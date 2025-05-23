package com.tencent.autotemplate;

import android.opengl.EGLContext;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.tencent.autotemplate.filter.CopyFilter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavsticker.core.ITAVRenderContextDataSource;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerImageItem;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerProvider;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.libpag.PAGComposition;
import org.libpag.PAGPlayer;
import org.libpag.PAGSurface;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVAutomaticRenderContext extends TAVStickerRenderContext {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_EXTRA_STICKER_SPEED = "key_extra_sticker_speed";
    public static final String KEY_EXTRA_STICKER_TYPE = "key_extra_sticker_type";
    private static final int LAST_DROP_FRAME = 4;
    public static final String STICKER_VIDEO_TRANSITION = "sticker_video_transition";
    public static final int TRANSITION_LAYER_SUM = 2;
    private static final long US_UNIT = 1000000;
    public static final String VIDEO_TRACK = "videoTrack";
    private final String TAG;
    private List<TAVSourceImage> cacheImagesForRelease;
    private CopyFilter mCopyFilter;
    private TextureInfo mCopyTextureInfo;
    private ArrayList<TAVSticker> mEffectStickers;
    private ArrayList<TAVSticker> mTransitionStickers;
    private Map<String, List<TAVStickerImageItem>> mapVideoTrack;
    private long renderThreadId;

    public TAVAutomaticRenderContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "TAVAutomaticRenderConte@" + Integer.toHexString(hashCode());
        this.mTransitionStickers = new ArrayList<>();
        this.mEffectStickers = new ArrayList<>();
        this.mapVideoTrack = new ConcurrentHashMap();
        this.mCopyFilter = new CopyFilter();
        this.renderThreadId = -1L;
        this.cacheImagesForRelease = null;
    }

    private boolean checkVideoTrack(TAVStickerImageItem tAVStickerImageItem) {
        if (tAVStickerImageItem != null && tAVStickerImageItem.getLayerInfo() != null && tAVStickerImageItem.getLayerInfo().getUserDataList() != null) {
            List<TAVStickerLayerInfo.TAVStickerUserData> userDataList = tAVStickerImageItem.getLayerInfo().getUserDataList();
            if (!CollectionUtil.isEmptyList(userDataList)) {
                Iterator<TAVStickerLayerInfo.TAVStickerUserData> it = userDataList.iterator();
                while (it.hasNext()) {
                    TAVStickerLayerInfo.TAVStickerUserData next = it.next();
                    if (next != null) {
                        String data = next.getData();
                        if (TextUtils.isEmpty(data)) {
                            continue;
                        } else {
                            try {
                                if (1 != new JSONObject(data).optInt("videoTrack", 0)) {
                                    return false;
                                }
                                return true;
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private long getCurTimeUs(long j3) {
        long milli2Us = TimeUtil.milli2Us(j3);
        long duration = this.rootComposition.duration();
        float frameRate = this.rootComposition.frameRate();
        long j16 = ((((float) duration) * frameRate) / 1000000.0f) - ((((float) milli2Us) * frameRate) / 1000000.0f);
        if (j16 >= 0 && j16 <= 4) {
            return Math.abs(milli2Us - (milli2Us % 1000000));
        }
        return milli2Us;
    }

    private List<TAVStickerImageItem> getVideoTracks(TAVSticker tAVSticker) {
        if (tAVSticker != null) {
            ArrayList<TAVStickerImageItem> stickerImageItems = tAVSticker.getStickerImageItems();
            if (!CollectionUtil.isEmptyList(stickerImageItems)) {
                ArrayList arrayList = new ArrayList();
                for (TAVStickerImageItem tAVStickerImageItem : stickerImageItems) {
                    if (checkVideoTrack(tAVStickerImageItem)) {
                        arrayList.add(tAVStickerImageItem);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return null;
    }

    private void initPagPlayer() {
        if (this.pagPlayer == null) {
            PAGPlayer pAGPlayer = new PAGPlayer();
            this.pagPlayer = pAGPlayer;
            pAGPlayer.setSurface(this.pagSurface);
            PAGComposition pAGComposition = this.rootComposition;
            if (pAGComposition != null) {
                this.pagPlayer.setComposition(pAGComposition);
            }
            resetRenderConfigs();
        }
        if (this.rootComposition == null || r0.width() != this.renderSize.width || this.rootComposition.height() != this.renderSize.height) {
            createCompositionRenderTree();
            this.pagPlayer.setComposition(this.rootComposition);
        }
    }

    public static boolean isLayerFillAble(TAVStickerLayerInfo tAVStickerLayerInfo) {
        List<TAVStickerLayerInfo.TAVStickerUserData> userDataList;
        JSONObject jSONObject;
        if (tAVStickerLayerInfo == null || (userDataList = tAVStickerLayerInfo.getUserDataList()) == null || userDataList.isEmpty()) {
            return false;
        }
        for (TAVStickerLayerInfo.TAVStickerUserData tAVStickerUserData : userDataList) {
            if (tAVStickerUserData != null) {
                String data = tAVStickerUserData.getData();
                if (TextUtils.isEmpty(data)) {
                    continue;
                } else {
                    try {
                        jSONObject = new JSONObject(data);
                    } catch (JSONException e16) {
                        Logger.e("TAVAutomaticRenderContext", "isLayerFillAble JSONException " + e16.getMessage());
                        e16.printStackTrace();
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (jSONObject.optInt("videoTrack", 0) <= 0) {
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean updateIndexForImages(long j3, List<TAVSourceImage> list, TAVSticker tAVSticker) {
        int i3;
        boolean z16;
        if (!CollectionUtil.isEmptyList(list) && tAVSticker != null) {
            List<TAVStickerImageItem> list2 = this.mapVideoTrack.get(tAVSticker.getUniqueId());
            if (!CollectionUtil.isEmptyList(list2)) {
                i3 = list2.size();
            } else {
                i3 = 0;
            }
            int size = list.size();
            for (int i16 = 0; i16 < i3 && i16 < size; i16++) {
                TAVSourceImage tAVSourceImage = list.get(i16);
                if (tAVSourceImage != null && list2.get(i16) != null) {
                    tAVSourceImage.setIndex(list2.get(i16).getLayerIndex());
                }
            }
            ArrayList arrayList = new ArrayList();
            for (TAVStickerLayerInfo tAVStickerLayerInfo : tAVSticker.getStickerLayerInfos()) {
                if (isLayerFillAble(tAVStickerLayerInfo)) {
                    arrayList.add(tAVStickerLayerInfo);
                }
            }
            boolean equals = STICKER_VIDEO_TRANSITION.equals(tAVSticker.getExtraBundle().getString("key_extra_sticker_type"));
            if (CollectionUtil.isEmptyList(arrayList) && equals) {
                ArrayList<TAVStickerImageItem> stickerImageItems = tAVSticker.getStickerImageItems();
                if (stickerImageItems.size() != 2) {
                    return false;
                }
                for (int i17 = 0; i17 < stickerImageItems.size(); i17++) {
                    arrayList.add(stickerImageItems.get(i17).getLayerInfo());
                }
            }
            Collections.sort(arrayList, new Comparator<TAVStickerLayerInfo>() { // from class: com.tencent.autotemplate.TAVAutomaticRenderContext.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TAVAutomaticRenderContext.this);
                    }
                }

                @Override // java.util.Comparator
                public int compare(TAVStickerLayerInfo tAVStickerLayerInfo2, TAVStickerLayerInfo tAVStickerLayerInfo3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? tAVStickerLayerInfo2.getLayerIndex() - tAVStickerLayerInfo3.getLayerIndex() : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) tAVStickerLayerInfo2, (Object) tAVStickerLayerInfo3)).intValue();
                }
            });
            float f16 = tAVSticker.getExtraBundle().getFloat(KEY_EXTRA_STICKER_SPEED, 1.0f);
            if (equals && size == 1 && arrayList.size() == 2) {
                CMTime multi = new CMTime(j3, 1000).sub(tAVSticker.getTimeRange().getStart()).multi(f16);
                if (((TAVStickerLayerInfo) arrayList.get(0)).getTimeRange().getEnd().bigThan(((TAVStickerLayerInfo) arrayList.get(1)).getTimeRange().getStart()) && multi.bigThan(((TAVStickerLayerInfo) arrayList.get(1)).getTimeRange().getStart()) && ((TAVStickerLayerInfo) arrayList.get(0)).getTimeRange().getEnd().bigThan(multi)) {
                    return false;
                }
                if (multi.sub(((TAVStickerLayerInfo) arrayList.get(0)).getTimeRange().getEnd()).getTimeUs() >= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    list.get(0).setIndex(1);
                } else {
                    list.get(0).setIndex(0);
                }
                Log.i(this.TAG, "updateIndexForImages: presentationTimeMs = " + j3 + ", sticker start = " + (tAVSticker.getTimeRange().getStart().getTimeUs() / 1000) + ",isNextLayer = " + z16);
            }
        }
        return true;
    }

    public TextureInfo getCopyTextureInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TextureInfo) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        long nanoTime = System.nanoTime();
        if (this.mCopyTextureInfo == null) {
            this.mCopyTextureInfo = CIContext.newTextureInfo(this.stickerTexture.getTextureInfo().width, this.stickerTexture.getTextureInfo().height);
        }
        this.mCopyFilter.setRenderForScreen(false);
        this.mCopyFilter.setRendererWidth(this.stickerTexture.getTextureInfo().width);
        this.mCopyFilter.setRendererHeight(this.stickerTexture.getTextureInfo().height);
        this.mCopyFilter.setDesTextureInfo(this.mCopyTextureInfo);
        this.mCopyFilter.clearBufferBuffer(-16777216);
        this.mCopyFilter.applyFilter(this.stickerTexture.getTextureInfo());
        TLog.d(this.TAG, "getCopyTextureInfo const time : " + (System.nanoTime() - nanoTime) + " \u7eb3\u79d2");
        return this.mCopyTextureInfo;
    }

    public void readAllVideoTracks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        checkStickerList();
        this.mapVideoTrack.clear();
        for (TAVSticker tAVSticker : this.stickers) {
            if (tAVSticker != null) {
                List<TAVStickerImageItem> videoTracks = getVideoTracks(tAVSticker);
                if (!CollectionUtil.isEmptyList(videoTracks)) {
                    this.mapVideoTrack.put(tAVSticker.getUniqueId(), videoTracks);
                }
            }
        }
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    public synchronized void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        long j3 = this.renderThreadId;
        if (j3 != -1 && j3 != Thread.currentThread().getId()) {
            return;
        }
        super.release();
        TextureInfo textureInfo = this.mCopyTextureInfo;
        if (textureInfo != null) {
            textureInfo.release();
            this.mCopyTextureInfo = null;
        }
    }

    public CMSampleBuffer renderStickerChain(long j3, List<TAVSourceImage> list, EGLContext eGLContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CMSampleBuffer) iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), list, eGLContext);
        }
        if (!TAVStickerUtil.isValidCGSize(this.renderSize)) {
            TLog.e(this.TAG, "renderSticker -> mRenderSize is invalid!");
            return null;
        }
        createSurface();
        Surface surface = this.stickerSurface;
        if (surface == null) {
            TLog.e(this.TAG, "renderSticker -> mStickerSurface is null!");
            return null;
        }
        if (this.stickerTexture == null) {
            TLog.e(this.TAG, "renderSticker -> mStickerTexture is null!");
            return null;
        }
        return renderStickerChain(surface, j3, list, eGLContext);
    }

    public CMSampleBuffer renderStickerChainWithTexture(long j3, List<TAVSourceImage> list) {
        CMSampleBuffer cMSampleBuffer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CMSampleBuffer) iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), list);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.renderThreadId = Thread.currentThread().getId();
        this.presentationTimeMs = j3;
        if (!TAVStickerUtil.isValidCGSize(this.renderSize)) {
            TLog.e(this.TAG, "renderSticker -> mRenderSize is invalid!");
            return null;
        }
        checkStickerList();
        checkStickerProviderList();
        if (this.stickers.isEmpty()) {
            return null;
        }
        createTavStickerTexture();
        if (this.stickerTexture == null) {
            TLog.e(this.TAG, "renderSticker -> mStickerTexture is null!");
            return null;
        }
        checkStickerList();
        checkStickerProviderList();
        createPagSurface();
        if (this.pagSurface == null) {
            return null;
        }
        initPagPlayer();
        List<TAVSourceImage> list2 = this.cacheImagesForRelease;
        if (list2 != null) {
            releaseCacheImages(list2);
        }
        if (this.stickers.size() != this.providers.size()) {
            reloadAllProviders();
            sortedAllProviders();
        }
        if (!CollectionUtil.isEmptyList(list)) {
            this.cacheImagesForRelease = new ArrayList(list);
        } else {
            this.cacheImagesForRelease = new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        if (!CollectionUtil.isEmptyList(this.providers)) {
            boolean z16 = false;
            cMSampleBuffer = null;
            for (TAVStickerProvider tAVStickerProvider : this.providers) {
                if (tAVStickerProvider != null) {
                    TAVSticker sticker = tAVStickerProvider.getSticker();
                    if (shouldRenderSticker(sticker, j3)) {
                        boolean equals = STICKER_VIDEO_TRANSITION.equals(sticker.getExtraBundle().getString("key_extra_sticker_type"));
                        if (!z16 || !equals) {
                            if (equals) {
                                z16 = true;
                            }
                            if (cMSampleBuffer == null) {
                                cMSampleBuffer = new CMSampleBuffer(new CMTime(TAVStickerUtil.millisecond2Seconds(j3)), this.stickerTexture.getTextureInfo(), false);
                            }
                            if (updateIndexForImages(j3, arrayList, tAVStickerProvider.getSticker())) {
                                for (int i3 = 0; i3 < this.rootComposition.numLayers(); i3++) {
                                    this.rootComposition.getLayerAt(i3).setVisible(false);
                                }
                                tAVStickerProvider.setRenderSize(this.renderSize);
                                tAVStickerProvider.setPagPlayer(this.pagPlayer);
                                tAVStickerProvider.replaceSourceImages(arrayList);
                                this.rootComposition.setCurrentTime(getCurTimeUs(j3));
                                if (this.pagPlayer.flush()) {
                                    arrayList.clear();
                                    TAVSourceImage tAVSourceImage = new TAVSourceImage(getCopyTextureInfo(), true, 0);
                                    arrayList.add(tAVSourceImage);
                                    this.cacheImagesForRelease.add(tAVSourceImage);
                                }
                            }
                        }
                    }
                }
            }
            if (cMSampleBuffer != null) {
                cMSampleBuffer.setNewFrame(true);
            }
        } else {
            cMSampleBuffer = null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        Logger.e(this.TAG, "\u8d34\u7eb8\u6e32\u67d3\u8017\u65f6\uff1a" + (currentTimeMillis2 - currentTimeMillis), null);
        return cMSampleBuffer;
    }

    public void setEffectStickers(List<TAVSticker> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        checkStickerList();
        if (!CollectionUtil.isEmptyList(this.mEffectStickers)) {
            this.stickers.removeAll(this.mEffectStickers);
        }
        this.mEffectStickers.clear();
        if (list != null) {
            this.mEffectStickers.addAll(list);
        }
        if (!CollectionUtil.isEmptyList(this.mEffectStickers)) {
            this.stickers.addAll(this.stickers.size(), this.mEffectStickers);
        }
        reloadAllStickers();
        reloadAllProviders();
        sortedAllProviders();
    }

    public void setTransitionStickers(List<TAVSticker> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        checkStickerList();
        if (!CollectionUtil.isEmptyList(this.mTransitionStickers)) {
            this.stickers.removeAll(this.mTransitionStickers);
        }
        this.mTransitionStickers.clear();
        if (list != null) {
            this.mTransitionStickers.addAll(list);
        }
        if (!CollectionUtil.isEmptyList(this.mTransitionStickers)) {
            this.stickers.addAll(0, this.mTransitionStickers);
        }
        reloadAllStickers();
        reloadAllProviders();
        sortedAllProviders();
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    protected boolean shouldRenderSticker(TAVSticker tAVSticker, long j3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, tAVSticker, Long.valueOf(j3))).booleanValue();
        }
        if (tAVSticker == null) {
            return false;
        }
        ITAVRenderContextDataSource iTAVRenderContextDataSource = this.renderContextDataSource;
        if (iTAVRenderContextDataSource != null) {
            return iTAVRenderContextDataSource.shouldRenderSticker(tAVSticker, j3);
        }
        CMTimeRange timeRange = tAVSticker.getTimeRange();
        if (timeRange != null) {
            CMTime cMTime = new CMTime(j3, 1000);
            if ((!timeRange.getStart().smallThan(cMTime) && !timeRange.getStart().equalsTo(cMTime)) || (!timeRange.getEnd().bigThan(cMTime) && !timeRange.getEnd().equalsTo(cMTime))) {
                z16 = false;
                if (!z16 && TAVStickerMode.INACTIVE == tAVSticker.getMode()) {
                    return true;
                }
                return false;
            }
        }
        z16 = true;
        if (!z16) {
        }
        return false;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    @Deprecated
    public TAVAutomaticRenderContext copy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TAVAutomaticRenderContext) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        TAVAutomaticRenderContext tAVAutomaticRenderContext = new TAVAutomaticRenderContext();
        tAVAutomaticRenderContext.checkStickerList();
        List<TAVSticker> list = this.stickers;
        if (list != null) {
            tAVAutomaticRenderContext.stickers = list;
        }
        tAVAutomaticRenderContext.setRenderSize(this.renderSize);
        tAVAutomaticRenderContext.stickerLayerIndex = this.stickerLayerIndex;
        tAVAutomaticRenderContext.renderContextDataSource = this.renderContextDataSource;
        tAVAutomaticRenderContext.quality = this.quality;
        checkChildContexts();
        this.childContexts.add(tAVAutomaticRenderContext);
        return tAVAutomaticRenderContext;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    public TAVAutomaticRenderContext copyRenderContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TAVAutomaticRenderContext) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        TAVAutomaticRenderContext tAVAutomaticRenderContext = new TAVAutomaticRenderContext();
        tAVAutomaticRenderContext.checkStickerList();
        List<TAVSticker> list = this.stickers;
        if (list != null) {
            tAVAutomaticRenderContext.stickers = list;
        }
        tAVAutomaticRenderContext.setRenderSize(this.renderSize);
        tAVAutomaticRenderContext.stickerLayerIndex = this.stickerLayerIndex;
        tAVAutomaticRenderContext.renderContextDataSource = this.renderContextDataSource;
        tAVAutomaticRenderContext.quality = this.quality;
        checkChildContexts();
        this.childContexts.add(tAVAutomaticRenderContext);
        tAVAutomaticRenderContext.mapVideoTrack = this.mapVideoTrack;
        return tAVAutomaticRenderContext;
    }

    public CMSampleBuffer renderStickerChain(Surface surface, long j3, List<TAVSourceImage> list, EGLContext eGLContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CMSampleBuffer) iPatchRedirector.redirect((short) 6, this, surface, Long.valueOf(j3), list, eGLContext);
        }
        this.presentationTimeMs = j3;
        checkStickerList();
        checkStickerProviderList();
        if (this.pagSurface == null && surface != null) {
            if (eGLContext != null) {
                this.pagSurface = PAGSurface.FromSurface(surface, eGLContext);
            } else {
                this.pagSurface = PAGSurface.FromSurface(surface);
            }
        }
        CMSampleBuffer cMSampleBuffer = null;
        if (this.pagSurface == null) {
            return null;
        }
        initPagPlayer();
        List<TAVSourceImage> list2 = this.cacheImagesForRelease;
        if (list2 != null) {
            releaseCacheImages(list2);
        }
        if (this.stickers.size() != this.providers.size()) {
            reloadAllProviders();
            sortedAllProviders();
        }
        ArrayList arrayList = !CollectionUtil.isEmptyList(list) ? new ArrayList(list) : null;
        if (!CollectionUtil.isEmptyList(arrayList)) {
            this.cacheImagesForRelease = new ArrayList(arrayList);
        } else {
            this.cacheImagesForRelease = new ArrayList();
        }
        if (!CollectionUtil.isEmptyList(this.providers)) {
            for (TAVStickerProvider tAVStickerProvider : this.providers) {
                if (tAVStickerProvider != null && shouldRenderSticker(tAVStickerProvider.getSticker(), j3)) {
                    if (cMSampleBuffer == null) {
                        cMSampleBuffer = new CMSampleBuffer(new CMTime(TAVStickerUtil.millisecond2Seconds(j3)), this.stickerTexture.getTextureInfo(), false);
                    }
                    for (int i3 = 0; i3 < this.rootComposition.numLayers(); i3++) {
                        this.rootComposition.getLayerAt(i3).setVisible(false);
                    }
                    updateIndexForImages(j3, arrayList, tAVStickerProvider.getSticker());
                    tAVStickerProvider.setRenderSize(this.renderSize);
                    tAVStickerProvider.setPagPlayer(this.pagPlayer);
                    tAVStickerProvider.replaceSourceImages(arrayList);
                    this.rootComposition.setCurrentTime(1000 * j3);
                    boolean flush = this.pagPlayer.flush();
                    if (flush) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        } else {
                            arrayList.clear();
                        }
                        TAVSourceImage tAVSourceImage = new TAVSourceImage(this.stickerTexture.getTextureInfo(), 0);
                        arrayList.add(tAVSourceImage);
                        this.cacheImagesForRelease.add(tAVSourceImage);
                    }
                    cMSampleBuffer.setNewFrame(flush);
                }
            }
        }
        return cMSampleBuffer;
    }
}
