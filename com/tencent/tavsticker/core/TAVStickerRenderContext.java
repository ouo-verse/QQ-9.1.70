package com.tencent.tavsticker.core;

import android.graphics.PointF;
import android.opengl.EGLContext;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Surface;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.Logger;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerProvider;
import com.tencent.tavsticker.model.TAVStickerQuality;
import com.tencent.tavsticker.model.TAVStickerTexture;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.ScreenUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImageLayer;
import org.libpag.PAGLayer;
import org.libpag.PAGPlayer;
import org.libpag.PAGSurface;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerRenderContext {
    private static final String TAG = "TAVStickerRenderContext";
    protected PAGComposition baseComposition;
    protected List<TAVSourceImage> cacheImagesForRelease;
    protected List<TAVStickerRenderContext> childContexts;
    protected boolean isPagSurfaceFromTexture;
    protected PAGPlayer pagPlayer;
    protected volatile PAGSurface pagSurface;
    protected long presentationTimeMs;
    protected List<TAVStickerProvider> providers;
    protected TAVStickerQuality quality;
    protected long realDuration;
    protected ITAVRenderContextDataSource renderContextDataSource;
    protected CGSize renderSize;
    protected PAGComposition rootComposition;
    protected int stickerLayerIndex;
    protected Surface stickerSurface;
    protected TAVStickerTexture stickerTexture;
    protected List<TAVSticker> stickers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements Comparator<TAVSticker> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(TAVSticker tAVSticker, TAVSticker tAVSticker2) {
            if (tAVSticker != null && tAVSticker2 != null) {
                return tAVSticker.getLayerIndex() - tAVSticker2.getLayerIndex();
            }
            return 0;
        }
    }

    public TAVStickerRenderContext() {
        this.stickers = Collections.synchronizedList(new ArrayList());
        this.providers = Collections.synchronizedList(new ArrayList());
        this.stickerLayerIndex = 0;
        this.presentationTimeMs = 0L;
        this.renderContextDataSource = null;
        this.childContexts = new ArrayList();
        this.quality = TAVStickerQuality.TAVStickerQualityHigh;
        this.pagPlayer = null;
        this.rootComposition = null;
        this.baseComposition = null;
        this.pagSurface = null;
        this.stickerTexture = null;
        this.stickerSurface = null;
        this.renderSize = CGSize.CGSizeZero;
        this.cacheImagesForRelease = null;
        this.isPagSurfaceFromTexture = false;
    }

    private void rebindComposition() {
        PAGPlayer pAGPlayer;
        if (this.isPagSurfaceFromTexture && (pAGPlayer = this.pagPlayer) != null) {
            pAGPlayer.setComposition(this.rootComposition);
        }
    }

    private void releasePagSurface() {
        if (this.pagSurface != null) {
            this.pagSurface.freeCache();
            this.pagSurface.release();
            this.pagSurface = null;
        }
    }

    private void releaseStickerTexture() {
        TAVStickerTexture tAVStickerTexture = this.stickerTexture;
        if (tAVStickerTexture != null) {
            tAVStickerTexture.release();
            this.stickerTexture = null;
        }
    }

    private synchronized void replaceSourceImage(long j3, List<TAVSourceImage> list) {
        PAGLayer pAGLayer;
        if (list != null) {
            if (!list.isEmpty()) {
                PAGComposition pAGComposition = this.baseComposition;
                if (pAGComposition == null) {
                    return;
                }
                int numLayers = pAGComposition.numLayers();
                int i3 = 0;
                while (true) {
                    if (i3 < numLayers) {
                        pAGLayer = this.baseComposition.getLayerAt(i3);
                        if (pAGLayer != null && pAGLayer.startTime() <= j3 && j3 < pAGLayer.startTime() + pAGLayer.duration()) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        pAGLayer = null;
                        break;
                    }
                }
                if (pAGLayer == null) {
                    return;
                }
                if (pAGLayer instanceof PAGImageLayer) {
                    ((PAGImageLayer) pAGLayer).replaceImage(list.get(0).getPagImage());
                } else if (pAGLayer instanceof PAGFile) {
                    for (TAVSourceImage tAVSourceImage : list) {
                        if (tAVSourceImage != null) {
                            ((PAGFile) pAGLayer).replaceImage(tAVSourceImage.getIndex(), tAVSourceImage.getPagImage());
                        }
                    }
                }
            }
        }
    }

    private void resetComposition() {
        if (this.isPagSurfaceFromTexture && this.rootComposition != null) {
            this.rootComposition = null;
        }
    }

    private void resetOrUpdatePagSurface() {
        if (!this.isPagSurfaceFromTexture) {
            this.pagSurface.updateSize();
        } else {
            releasePagSurface();
            createPagSurface();
        }
        if (this.pagSurface != null) {
            TLog.d(TAG, "setRenderSize  renderSize = " + this.renderSize.toString() + "   pagSurface width = " + this.pagSurface.width() + "   pagSurface height = " + this.pagSurface.height());
        }
    }

    private void resetOrUpdateStickerTexture() {
        if (!this.isPagSurfaceFromTexture) {
            TAVStickerTexture tAVStickerTexture = this.stickerTexture;
            CGSize cGSize = this.renderSize;
            tAVStickerTexture.updateStickerTextureSize((int) cGSize.width, (int) cGSize.height);
        } else {
            releaseStickerTexture();
            createTavStickerTexture();
        }
    }

    private void updateAllLayers() {
        for (TAVSticker tAVSticker : getStickers()) {
            if (tAVSticker != null) {
                tAVSticker.getPagFile().setVisible(shouldRenderSticker(tAVSticker, this.presentationTimeMs));
                tAVSticker.computeProgress(this.presentationTimeMs);
                CGSize cGSize = this.renderSize;
                tAVSticker.getPagFile().setMatrix(TAVStickerUtil.getMatrix(tAVSticker, (int) cGSize.width, (int) cGSize.height));
            }
        }
    }

    private void updateCompositionDuration() {
        long j3 = 0;
        for (TAVSticker tAVSticker : this.stickers) {
            if (tAVSticker.getTimeRange() != null) {
                j3 = Math.max(j3, tAVSticker.getTimeRange().getEndUs());
            } else {
                j3 = Math.max(j3, tAVSticker.getPagFile().duration());
            }
        }
        this.realDuration = j3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkChildContexts() {
        if (this.childContexts == null) {
            this.childContexts = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkStickerList() {
        if (this.stickers == null) {
            this.stickers = Collections.synchronizedList(new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkStickerProviderList() {
        if (this.providers == null) {
            this.providers = Collections.synchronizedList(new ArrayList());
        }
    }

    public boolean containSticker(TAVSticker tAVSticker) {
        if (tAVSticker == null) {
            return false;
        }
        checkStickerList();
        return this.stickers.contains(tAVSticker);
    }

    @Deprecated
    public TAVStickerRenderContext copy() {
        TAVStickerRenderContext tAVStickerRenderContext = new TAVStickerRenderContext();
        tAVStickerRenderContext.checkStickerList();
        List<TAVSticker> list = this.stickers;
        if (list != null) {
            tAVStickerRenderContext.stickers = list;
        }
        tAVStickerRenderContext.setRenderSize(this.renderSize);
        tAVStickerRenderContext.stickerLayerIndex = this.stickerLayerIndex;
        tAVStickerRenderContext.renderContextDataSource = this.renderContextDataSource;
        tAVStickerRenderContext.quality = this.quality;
        checkChildContexts();
        this.childContexts.add(tAVStickerRenderContext);
        return tAVStickerRenderContext;
    }

    public TAVStickerRenderContext copyRenderContext() {
        TAVStickerRenderContext tAVStickerRenderContext = new TAVStickerRenderContext(this.renderSize, this.realDuration);
        tAVStickerRenderContext.checkStickerList();
        List<TAVSticker> list = this.stickers;
        if (list != null) {
            tAVStickerRenderContext.stickers = list;
        }
        tAVStickerRenderContext.stickerLayerIndex = this.stickerLayerIndex;
        tAVStickerRenderContext.renderContextDataSource = this.renderContextDataSource;
        tAVStickerRenderContext.quality = this.quality;
        checkChildContexts();
        this.childContexts.add(tAVStickerRenderContext);
        return tAVStickerRenderContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void createCompositionRenderTree() {
        updateCompositionDuration();
        CGSize cGSize = this.renderSize;
        this.baseComposition = PAGComposition.Make((int) cGSize.width, (int) cGSize.height);
        CGSize cGSize2 = this.renderSize;
        PAGImageLayer Make = PAGImageLayer.Make((int) cGSize2.width, (int) cGSize2.height, this.realDuration);
        if (Make == null) {
            return;
        }
        Make.setStartTime(0L);
        this.baseComposition.addLayer(Make);
        CGSize cGSize3 = this.renderSize;
        this.rootComposition = PAGComposition.Make((int) cGSize3.width, (int) cGSize3.height);
        updateCompositionRenderTree();
    }

    protected synchronized void createOrUpdateRenderTree() {
        if (this.rootComposition == null) {
            createCompositionRenderTree();
        } else {
            updateCompositionRenderTree();
        }
    }

    protected boolean createPagPlayer() {
        createTavStickerTexture();
        if (this.stickerTexture == null) {
            TLog.e(TAG, "renderSticker -> mStickerTexture is null!");
            return false;
        }
        createPagSurface();
        if (this.pagSurface == null) {
            return false;
        }
        if (this.pagPlayer == null) {
            PAGPlayer pAGPlayer = new PAGPlayer();
            this.pagPlayer = pAGPlayer;
            pAGPlayer.setSurface(this.pagSurface);
            this.pagPlayer.setComposition(this.rootComposition);
            if (TAVStickerUtil.isValidCGSize(this.renderSize)) {
                resetRenderConfigs();
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createPagSurface() {
        if (this.pagSurface == null) {
            this.isPagSurfaceFromTexture = true;
            this.pagSurface = PAGSurface.FromTexture(this.stickerTexture.getTextureInfo().textureID, this.stickerTexture.getTextureInfo().width, this.stickerTexture.getTextureInfo().height, true);
            PAGPlayer pAGPlayer = this.pagPlayer;
            if (pAGPlayer != null) {
                pAGPlayer.setSurface(this.pagSurface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void createSurface() {
        Surface surface;
        if (TAVStickerUtil.isValidCGSize(this.renderSize) && ((surface = this.stickerSurface) == null || !surface.isValid())) {
            TAVStickerTexture tAVStickerTexture = this.stickerTexture;
            if (tAVStickerTexture != null) {
                tAVStickerTexture.release();
            }
            CGSize cGSize = this.renderSize;
            this.stickerTexture = new TAVStickerTexture((int) cGSize.width, (int) cGSize.height);
            Surface surface2 = this.stickerSurface;
            if (surface2 != null) {
                surface2.release();
            }
            this.stickerSurface = new Surface(this.stickerTexture.surfaceTexture());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createTavStickerTexture() {
        if (this.stickerTexture == null && TAVStickerUtil.isValidCGSize(this.renderSize)) {
            CGSize cGSize = this.renderSize;
            this.stickerTexture = new TAVStickerTexture((int) cGSize.width, (int) cGSize.height, GLSLRender.GL_TEXTURE_2D, 0);
        }
    }

    public int getStickerCount() {
        checkStickerList();
        return this.stickers.size();
    }

    public TAVStickerTexture getStickerTexture() {
        return this.stickerTexture;
    }

    public List<TAVSticker> getStickers() {
        checkStickerList();
        return this.stickers;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TAVSticker getTouchedSticker(float f16, float f17) {
        checkStickerList();
        for (int size = this.stickers.size() - 1; size >= 0; size--) {
            TAVSticker tAVSticker = this.stickers.get(size);
            if (tAVSticker != null && TAVStickerUtil.isPresentationTimeInStickerTimeRange(this.presentationTimeMs, tAVSticker) && tAVSticker.isEditable() && isTouchOnTavSticker(tAVSticker, f16, f17)) {
                return tAVSticker;
            }
        }
        return null;
    }

    public void getUnderPointLayerItems(float f16, float f17, ITAVTouchStickerLayerListener iTAVTouchStickerLayerListener) {
        if (iTAVTouchStickerLayerListener == null) {
            return;
        }
        TAVSticker touchedSticker = getTouchedSticker(f16, f17);
        if (touchedSticker != null) {
            checkStickerProviderList();
            for (TAVStickerProvider tAVStickerProvider : this.providers) {
                if (tAVStickerProvider != null && touchedSticker == tAVStickerProvider.getSticker()) {
                    iTAVTouchStickerLayerListener.onTouchSticker(touchedSticker, tAVStickerProvider.getUnderPointLayerItems(f16, f17));
                    return;
                }
            }
        }
        iTAVTouchStickerLayerListener.onTouchSticker(touchedSticker, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isTouchOnTavSticker(TAVSticker tAVSticker, float f16, float f17) {
        if (tAVSticker == null) {
            TLog.e(TAG, "isTouchOnTavSticker -> parameter tavSticker is null!");
            return false;
        }
        if (!TAVStickerUtil.isValidCGSize(this.renderSize)) {
            TLog.e(TAG, "isTouchOnTavSticker -> renderSize invalid!");
            return false;
        }
        CGSize cGSize = this.renderSize;
        PointF[] computeRectanglePoints = TAVStickerUtil.computeRectanglePoints(TAVStickerUtil.getMatrix(tAVSticker, (int) cGSize.width, (int) cGSize.height), tAVSticker.getWidth(), tAVSticker.getHeight());
        String str = TAG;
        TLog.d(str, "isTouchOnTavSticker -> x : " + f16 + ", y : " + f17);
        if (TAVStickerUtil.inQuadrangle(computeRectanglePoints[0], computeRectanglePoints[1], computeRectanglePoints[2], computeRectanglePoints[3], new PointF(f16, f17))) {
            TLog.d(str, "isTouchOnTavSticker -> \u70b9\u4e2d\u4e86\u8d34\u7eb8, " + tAVSticker.getFilePath());
            return true;
        }
        TLog.d(str, "isTouchOnTavSticker -> \u6ca1\u6709\u70b9\u4e2d\u8d34\u7eb8, " + tAVSticker.getFilePath());
        return false;
    }

    public void loadSticker(TAVSticker tAVSticker, boolean z16) {
        checkStickerList();
        if (tAVSticker != null && !containSticker(tAVSticker)) {
            tAVSticker.setMode(TAVStickerMode.INACTIVE);
            if (-1 == tAVSticker.getLayerIndex()) {
                int i3 = this.stickerLayerIndex;
                this.stickerLayerIndex = i3 + 1;
                tAVSticker.setLayerIndex(i3);
            }
            this.stickers.add(tAVSticker);
            sortedAllStickers();
            reloadAllProviders();
            sortedAllProviders();
            syncAllChildContext();
        }
        createOrUpdateRenderTree();
    }

    public synchronized void release() {
        try {
            for (TAVStickerProvider tAVStickerProvider : this.providers) {
                if (tAVStickerProvider != null) {
                    tAVStickerProvider.release();
                }
            }
            this.providers.clear();
            this.stickerLayerIndex = 0;
            this.renderContextDataSource = null;
            releasePagSurface();
            releaseStickerTexture();
            Surface surface = this.stickerSurface;
            if (surface != null) {
                surface.release();
                this.stickerSurface = null;
            }
            PAGPlayer pAGPlayer = this.pagPlayer;
            if (pAGPlayer != null) {
                pAGPlayer.release();
            }
            PAGComposition pAGComposition = this.rootComposition;
            if (pAGComposition != null) {
                pAGComposition.removeAllLayers();
            }
            TLog.e(TAG, "release: " + Thread.currentThread().getName() + ProvinceSelectorView.NAME_NO_SELECT_PROFILE + Log.getStackTraceString(new RuntimeException()));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseCacheImages(@NonNull List<TAVSourceImage> list) {
        for (TAVSourceImage tAVSourceImage : list) {
            if (tAVSourceImage != null && tAVSourceImage.getPagImage() != null) {
                tAVSourceImage.getPagImage().release();
            }
        }
        list.clear();
    }

    public void reloadAllProviders() {
        boolean z16;
        TAVSticker sticker;
        checkStickerProviderList();
        ArrayList arrayList = new ArrayList(this.providers);
        ArrayList arrayList2 = new ArrayList(this.stickers);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TAVStickerProvider tAVStickerProvider = (TAVStickerProvider) it.next();
            if (tAVStickerProvider != null && (sticker = tAVStickerProvider.getSticker()) != null) {
                if (!this.stickers.contains(tAVStickerProvider.getSticker())) {
                    this.providers.remove(tAVStickerProvider);
                } else {
                    tAVStickerProvider.setRenderSize(this.renderSize);
                    arrayList2.remove(sticker);
                }
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            TAVSticker tAVSticker = (TAVSticker) it5.next();
            if (tAVSticker != null) {
                TAVStickerProvider tAVStickerProvider2 = new TAVStickerProvider(tAVSticker);
                if (TAVStickerQuality.TAVStickerQualityHigh == this.quality) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                tAVStickerProvider2.setHighQuality(z16);
                tAVStickerProvider2.setRenderSize(this.renderSize);
                this.providers.add(tAVStickerProvider2);
            }
        }
    }

    public void reloadAllStickers() {
        checkStickerList();
        for (TAVSticker tAVSticker : this.stickers) {
            if (tAVSticker != null) {
                tAVSticker.updateImageData();
                tAVSticker.updateTextData();
                tAVSticker.setMode(TAVStickerMode.INACTIVE);
            }
        }
        createOrUpdateRenderTree();
    }

    public void reloadStickers(List<TAVSticker> list) {
        checkStickerList();
        if (!CollectionUtil.isEmptyList(list)) {
            removeAllStickers();
            this.stickers.addAll(list);
            reloadAllStickers();
            reloadAllProviders();
            sortedAllProviders();
            createOrUpdateRenderTree();
        }
    }

    public void removeAllStickers() {
        checkStickerList();
        this.stickers.clear();
        syncAllChildContext();
        createOrUpdateRenderTree();
    }

    public boolean removeSticker(TAVSticker tAVSticker) {
        checkStickerList();
        boolean remove = this.stickers.remove(tAVSticker);
        syncAllChildContext();
        createOrUpdateRenderTree();
        return remove;
    }

    public CMSampleBuffer renderSticker(long j3, List<TAVSourceImage> list) {
        return renderSticker(j3, list, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetRenderConfigs() {
        if (this.pagPlayer == null) {
            return;
        }
        if (this.quality != TAVStickerQuality.TAVStickerQualityHigh && TAVStickerUtil.isValidCGSize(this.renderSize)) {
            this.pagPlayer.setMaxFrameRate(24.0f);
            CGSize cGSize = this.renderSize;
            this.pagPlayer.setCacheScale(Math.max(cGSize.width / (ScreenUtil.getScreenWidth() * 1.0f), cGSize.height / (ScreenUtil.getScreenHeight() * 1.0f)));
            return;
        }
        this.pagPlayer.setCacheEnabled(true);
        this.pagPlayer.setMaxFrameRate(60.0f);
        this.pagPlayer.setCacheScale(1.0f);
    }

    public void setCacheEnabled(boolean z16) {
        List<TAVStickerProvider> list = this.providers;
        if (list != null) {
            for (TAVStickerProvider tAVStickerProvider : list) {
                if (tAVStickerProvider != null) {
                    tAVStickerProvider.setCacheEnabled(z16);
                }
            }
        }
    }

    public void setRealDuration(long j3) {
        this.realDuration = j3;
    }

    public void setRenderSize(CGSize cGSize) {
        if (TAVStickerUtil.isValidCGSize(cGSize) && !cGSize.equals(this.renderSize)) {
            TLog.d(TAG, "setRenderSize -> render size changed, oldRenderSize : " + this.renderSize + ", newRenderSize : " + cGSize);
            this.renderSize = cGSize;
            if (this.stickerTexture != null) {
                resetOrUpdateStickerTexture();
            }
            if (this.pagSurface != null) {
                resetOrUpdatePagSurface();
            }
            resetRenderConfigs();
            resetComposition();
            createOrUpdateRenderTree();
            rebindComposition();
        }
    }

    public void setStickerRenderQuality(TAVStickerQuality tAVStickerQuality) {
        if (tAVStickerQuality != null) {
            this.quality = tAVStickerQuality;
        }
    }

    public void setTavRenderContextDataSource(ITAVRenderContextDataSource iTAVRenderContextDataSource) {
        this.renderContextDataSource = iTAVRenderContextDataSource;
    }

    protected boolean shouldRenderSticker(TAVSticker tAVSticker, long j3) {
        boolean containsTime;
        if (tAVSticker == null) {
            return false;
        }
        ITAVRenderContextDataSource iTAVRenderContextDataSource = this.renderContextDataSource;
        if (iTAVRenderContextDataSource != null) {
            return iTAVRenderContextDataSource.shouldRenderSticker(tAVSticker, j3);
        }
        CMTimeRange timeRange = tAVSticker.getTimeRange();
        if (timeRange == null) {
            containsTime = true;
        } else {
            containsTime = timeRange.containsTime(new CMTime(j3, 1000));
        }
        if (!containsTime || TAVStickerMode.INACTIVE != tAVSticker.getMode()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sortedAllProviders() {
        checkStickerProviderList();
        Collections.sort(this.providers, new Comparator<TAVStickerProvider>() { // from class: com.tencent.tavsticker.core.TAVStickerRenderContext.1
            @Override // java.util.Comparator
            public int compare(TAVStickerProvider tAVStickerProvider, TAVStickerProvider tAVStickerProvider2) {
                if (tAVStickerProvider == null || tAVStickerProvider.getSticker() == null || tAVStickerProvider2 == null || tAVStickerProvider2.getSticker() == null) {
                    return 0;
                }
                return tAVStickerProvider.getSticker().getLayerIndex() - tAVStickerProvider2.getSticker().getLayerIndex();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sortedAllStickers() {
        checkStickerList();
        Collections.sort(this.stickers, new Comparator<TAVSticker>() { // from class: com.tencent.tavsticker.core.TAVStickerRenderContext.2
            @Override // java.util.Comparator
            public int compare(TAVSticker tAVSticker, TAVSticker tAVSticker2) {
                if (tAVSticker == null || tAVSticker2 == null) {
                    return 0;
                }
                return tAVSticker.getLayerIndex() - tAVSticker2.getLayerIndex();
            }
        });
    }

    protected void sortedStickersByLayerIndex(List<TAVSticker> list) {
        Collections.sort(list, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void syncAllChildContext() {
        checkChildContexts();
        for (TAVStickerRenderContext tAVStickerRenderContext : this.childContexts) {
            if (tAVStickerRenderContext != null) {
                tAVStickerRenderContext.checkStickerList();
                tAVStickerRenderContext.checkStickerProviderList();
                tAVStickerRenderContext.providers.clear();
                List<TAVSticker> list = this.stickers;
                if (list != null) {
                    tAVStickerRenderContext.stickers = list;
                }
                tAVStickerRenderContext.setRenderSize(this.renderSize);
                tAVStickerRenderContext.setRealDuration(this.realDuration);
                tAVStickerRenderContext.stickerLayerIndex = this.stickerLayerIndex;
                tAVStickerRenderContext.renderContextDataSource = this.renderContextDataSource;
                tAVStickerRenderContext.quality = this.quality;
            }
        }
    }

    protected synchronized void updateCompositionRenderTree() {
        this.rootComposition.removeAllLayers();
        this.rootComposition.addLayer(this.baseComposition);
        sortedStickersByLayerIndex(this.stickers);
        if (!this.stickers.isEmpty()) {
            for (TAVSticker tAVSticker : this.stickers) {
                if (tAVSticker != null && tAVSticker.getPagFile() != null) {
                    tAVSticker.updateTextData();
                    tAVSticker.updateImageData();
                    tAVSticker.updateLayerColor();
                    tAVSticker.updateTransform(this.renderSize);
                    this.rootComposition.addLayer(tAVSticker.getPagFile());
                }
            }
        }
    }

    public CMSampleBuffer renderSticker(long j3, List<TAVSourceImage> list, EGLContext eGLContext) {
        long currentTimeMillis = System.currentTimeMillis();
        this.presentationTimeMs = j3;
        checkStickerList();
        checkStickerProviderList();
        if (this.stickers.isEmpty()) {
            return null;
        }
        if (this.rootComposition == null) {
            createCompositionRenderTree();
        }
        if (!createPagPlayer()) {
            return null;
        }
        List<TAVSourceImage> list2 = this.cacheImagesForRelease;
        if (list2 != null) {
            releaseCacheImages(list2);
        }
        updateAllLayers();
        long j16 = 1000 * j3;
        replaceSourceImage(j16, list);
        this.rootComposition.setCurrentTime(j16);
        boolean flush = this.pagPlayer.flush();
        if (!CollectionUtil.isEmptyList(list)) {
            this.cacheImagesForRelease = new ArrayList(list);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        Logger.e(TAG, "\u8d34\u7eb8\u6e32\u67d3\u8017\u65f6\uff1a" + (currentTimeMillis2 - currentTimeMillis), null);
        return new CMSampleBuffer(new CMTime(TAVStickerUtil.millisecond2Seconds(j3)), this.stickerTexture.getTextureInfo(), flush);
    }

    public void loadSticker(TAVSticker tAVSticker) {
        loadSticker(tAVSticker, false);
    }

    public TAVStickerRenderContext(@NonNull CGSize cGSize, @NonNull long j3) {
        this.stickers = Collections.synchronizedList(new ArrayList());
        this.providers = Collections.synchronizedList(new ArrayList());
        this.stickerLayerIndex = 0;
        this.presentationTimeMs = 0L;
        this.renderContextDataSource = null;
        this.childContexts = new ArrayList();
        this.quality = TAVStickerQuality.TAVStickerQualityHigh;
        this.pagPlayer = null;
        this.rootComposition = null;
        this.baseComposition = null;
        this.pagSurface = null;
        this.stickerTexture = null;
        this.stickerSurface = null;
        CGSize cGSize2 = CGSize.CGSizeZero;
        this.cacheImagesForRelease = null;
        this.isPagSurfaceFromTexture = false;
        this.renderSize = cGSize;
        this.realDuration = j3;
    }
}
