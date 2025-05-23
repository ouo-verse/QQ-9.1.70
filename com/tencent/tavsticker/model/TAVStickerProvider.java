package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.core.ITAVStickerRenderer;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.ScreenUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.List;
import org.libpag.PAGImage;
import org.libpag.PAGImageLayer;
import org.libpag.PAGLayer;
import org.libpag.PAGMovie;
import org.libpag.PAGPlayer;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGSurface;
import org.libpag.PAGText;

/* loaded from: classes26.dex */
public class TAVStickerProvider implements ITAVStickerRenderer {
    private static final String TAG = "TAVStickerProvider";
    private TAVSticker sticker;
    private CGSize renderSize = CGSize.CGSizeZero;
    private boolean isHighQuality = true;
    private PAGPlayer pagPlayer = null;

    public TAVStickerProvider(TAVSticker tAVSticker) {
        this.sticker = null;
        if (tAVSticker != null) {
            this.sticker = tAVSticker;
            tAVSticker.registerRenderer(this);
            resetRenderConfigs();
            return;
        }
        throw new IllegalArgumentException("initWithSticker, parameter 'tavSticker' can not null");
    }

    private void resetRenderConfigs() {
        if (this.pagPlayer == null) {
            return;
        }
        if (!this.isHighQuality && TAVStickerUtil.isValidCGSize(this.renderSize)) {
            this.pagPlayer.setMaxFrameRate(24.0f);
            CGSize cGSize = this.renderSize;
            this.pagPlayer.setCacheScale(Math.max(cGSize.width / (ScreenUtil.getScreenWidth() * 1.0f), cGSize.height / (ScreenUtil.getScreenHeight() * 1.0f)));
            return;
        }
        this.pagPlayer.setCacheEnabled(true);
        this.pagPlayer.setMaxFrameRate(60.0f);
        this.pagPlayer.setCacheScale(1.0f);
    }

    private void updateTransform() {
        TAVSticker tAVSticker;
        if (TAVStickerUtil.isValidCGSize(this.renderSize) && this.pagPlayer != null && (tAVSticker = this.sticker) != null) {
            CGSize cGSize = this.renderSize;
            this.sticker.getPagFile().setMatrix(TAVStickerUtil.getMatrix(tAVSticker, (int) cGSize.width, (int) cGSize.height));
        }
    }

    public long getPagSourceDuration(String str, boolean z16) {
        TAVSticker tAVSticker = this.sticker;
        if (tAVSticker != null) {
            return tAVSticker.getPagSourceDuration(str, z16);
        }
        return 0L;
    }

    public TAVSticker getSticker() {
        return this.sticker;
    }

    public List<TAVStickerLayerItem> getUnderPointLayerItems(float f16, float f17) {
        TAVStickerImageItem tavStickerImageItem;
        if (this.pagPlayer == null || this.sticker == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        PAGLayer[] layersUnderPoint = this.pagPlayer.getLayersUnderPoint(f16, f17);
        if (layersUnderPoint == null) {
            return null;
        }
        for (PAGLayer pAGLayer : layersUnderPoint) {
            if (pAGLayer != null) {
                int editableIndex = pAGLayer.editableIndex();
                if (3 == pAGLayer.layerType()) {
                    TAVStickerTextItem tavStickerTextItem = this.sticker.getTavStickerTextItem(editableIndex);
                    if (tavStickerTextItem != null) {
                        arrayList.add(tavStickerTextItem);
                    }
                } else if (5 == pAGLayer.layerType() && (tavStickerImageItem = this.sticker.getTavStickerImageItem(editableIndex)) != null) {
                    arrayList.add(tavStickerImageItem);
                }
            }
        }
        return arrayList;
    }

    public long replacePagMovie(String str, String str2, CMTimeRange cMTimeRange, boolean z16) {
        PAGImageLayer pagImageLayerByName;
        TAVSticker tAVSticker = this.sticker;
        if (tAVSticker == null || (pagImageLayerByName = tAVSticker.getPagImageLayerByName(str, z16)) == null || !this.sticker.hasVideoTrack(pagImageLayerByName)) {
            return 0L;
        }
        replacePagMovie(pagImageLayerByName, str2, cMTimeRange);
        return pagImageLayerByName.duration();
    }

    public void replaceSourceImages(List<TAVSourceImage> list) {
        TAVSticker tAVSticker = this.sticker;
        if (tAVSticker != null && tAVSticker.getPagFile() != null && !CollectionUtil.isEmptyList(list)) {
            ArrayList arrayList = new ArrayList(list);
            int numImages = this.sticker.getPagFile().numImages();
            int size = arrayList.size();
            TLog.d(TAG, "replaceSourceImages ->  numImages : " + numImages + ", sourceImagesCount : " + size);
            for (int i3 = 0; i3 < size; i3++) {
                TAVSourceImage tAVSourceImage = (TAVSourceImage) arrayList.get(i3);
                if (tAVSourceImage != null) {
                    PAGImage pagImage = tAVSourceImage.getPagImage();
                    int index = tAVSourceImage.getIndex();
                    if (this.pagPlayer != null && index >= 0 && index < numImages) {
                        this.sticker.getPagFile().replaceImage(index, pagImage);
                    }
                }
            }
        }
    }

    public void setCacheEnabled(boolean z16) {
        PAGPlayer pAGPlayer = this.pagPlayer;
        if (pAGPlayer != null) {
            pAGPlayer.setCacheEnabled(z16);
        }
    }

    public void setHighQuality(boolean z16) {
        if (this.isHighQuality != z16) {
            resetRenderConfigs();
        }
        this.isHighQuality = z16;
    }

    @Override // com.tencent.tavsticker.core.ITAVStickerRenderer
    public void setImageData(int i3, PAGImage pAGImage) {
        TAVSticker tAVSticker = this.sticker;
        if (tAVSticker != null && tAVSticker.getPagFile() != null) {
            this.sticker.getPagFile().replaceImage(i3, pAGImage);
        }
    }

    @Override // com.tencent.tavsticker.core.ITAVStickerRenderer
    public void setLayerColor(String str, int i3) {
        PAGLayer[] layersByName;
        TAVSticker tAVSticker = this.sticker;
        if (tAVSticker == null || tAVSticker.getPagFile() == null || (layersByName = this.sticker.getPagFile().getLayersByName(str)) == null) {
            return;
        }
        for (PAGLayer pAGLayer : layersByName) {
            if (pAGLayer instanceof PAGSolidLayer) {
                ((PAGSolidLayer) pAGLayer).setSolidColor(i3);
            }
        }
    }

    public void setPagPlayer(PAGPlayer pAGPlayer) {
        TAVSticker tAVSticker = this.sticker;
        if (tAVSticker != null && tAVSticker.getPagFile() != null) {
            if (this.pagPlayer != pAGPlayer) {
                this.pagPlayer = pAGPlayer;
            }
            if (this.sticker.getPagFile().parent() == null) {
                this.pagPlayer.getComposition().addLayer(this.sticker.getPagFile());
            }
            this.sticker.getPagFile().setVisible(true);
        }
    }

    public void setPagSurface(PAGSurface pAGSurface) {
        PAGPlayer pAGPlayer = this.pagPlayer;
        if (pAGPlayer != null && pAGSurface != pAGPlayer.getSurface()) {
            this.pagPlayer.setSurface(pAGSurface);
        }
    }

    public void setRenderSize(CGSize cGSize) {
        if (TAVStickerUtil.isValidCGSize(cGSize) && !cGSize.equals(this.renderSize)) {
            this.renderSize = cGSize;
            resetRenderConfigs();
        }
    }

    @Override // com.tencent.tavsticker.core.ITAVStickerRenderer
    public void setTextData(int i3, PAGText pAGText) {
        TAVSticker tAVSticker = this.sticker;
        if (tAVSticker != null && tAVSticker.getPagFile() != null) {
            this.sticker.getPagFile().replaceText(i3, pAGText);
        }
    }

    public synchronized void updateRender(long j3) {
        if (this.pagPlayer != null && this.sticker != null) {
            updateTransform();
            this.pagPlayer.setProgress(this.sticker.computeProgress(j3));
            return;
        }
        TLog.e(TAG, "updateRender -> pagRenderer or sticker is null, return!");
    }

    private void replacePagMovie(PAGImageLayer pAGImageLayer, String str, CMTimeRange cMTimeRange) {
        if (pAGImageLayer == null || this.sticker == null || this.pagPlayer == null || cMTimeRange == null) {
            return;
        }
        replacePagMovie(str, cMTimeRange.getStartUs(), cMTimeRange.getDuration().getTimeUs(), pAGImageLayer.editableIndex());
    }

    private void replacePagMovie(String str, long j3, long j16, int i3) {
        this.sticker.getPagFile().replaceImage(i3, PAGMovie.FromVideoPath(str, j3, j16));
    }

    public void release() {
    }
}
