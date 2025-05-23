package com.tencent.tavmovie.sticker;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerImageItem;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMovieSticker {
    private PointF centerPosition;
    private String filePath;
    private List<TAVStickerImageItem> imageList;
    private float rotation;
    private float scale;
    private TAVSticker sticker;
    private TAVMovieStickerMode stickerMode;
    private TAVTemplateStickerType stickerType;
    private List<TAVMovieStickerTextItem> textList;
    private CMTimeRange timeRange;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum TAVMovieStickerMode {
        TAVMovieStickerModeOverlay,
        TAVMovieStickerModeFilter
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum TAVTemplateStickerType {
        TAVTemplateStickerTypeNormal,
        TAVTemplateStickerTypeWatermark
    }

    public TAVMovieSticker() {
    }

    public List<TAVStickerImageItem> getImageList() {
        return this.imageList;
    }

    public PointF getPosition() {
        return this.centerPosition;
    }

    public float getRotation() {
        return this.rotation;
    }

    public float getScale() {
        return this.scale;
    }

    public TAVSticker getSticker() {
        return this.sticker;
    }

    public List<TAVStickerLayerInfo> getStickerLayerInfos() {
        TAVSticker tAVSticker = this.sticker;
        if (tAVSticker != null) {
            return tAVSticker.getStickerLayerInfos();
        }
        return null;
    }

    public List<TAVStickerLayerInfo> getStickerLayerInfosFake() {
        TAVSticker tAVSticker = this.sticker;
        if (tAVSticker != null) {
            return tAVSticker.getStickerLayerInfosFake();
        }
        return null;
    }

    public TAVMovieStickerMode getStickerMode() {
        return this.stickerMode;
    }

    public TAVTemplateStickerType getStickerType() {
        return this.stickerType;
    }

    public List<TAVMovieStickerTextItem> getTextList() {
        return this.textList;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    public void setPosition(PointF pointF) {
        this.centerPosition = pointF;
        if (!pointF.equals(this.sticker.getCenterX(), this.sticker.getCenterY())) {
            this.sticker.setCenterX(this.centerPosition.x);
            this.sticker.setCenterY(this.centerPosition.y);
        }
    }

    public void setRotation(float f16) {
        this.rotation = f16;
        if (Math.abs(f16 - this.sticker.getRotate()) > 0.001f) {
            this.sticker.setRotate(this.rotation);
        }
    }

    public void setScale(float f16) {
        this.scale = f16;
        if (Math.abs(f16 - this.sticker.getScale()) > 0.001f) {
            this.sticker.setScale(this.scale);
        }
    }

    public void setStickerMode(TAVMovieStickerMode tAVMovieStickerMode) {
        this.stickerMode = tAVMovieStickerMode;
    }

    public void setStickerType(TAVTemplateStickerType tAVTemplateStickerType) {
        this.stickerType = tAVTemplateStickerType;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
        if (!cMTimeRange.equals(this.sticker.getTimeRange())) {
            this.sticker.setTimeRange(this.timeRange);
        }
    }

    public void updateImageData() {
        TAVSticker tAVSticker = this.sticker;
        if (tAVSticker != null) {
            tAVSticker.updateImageData();
        }
    }

    public void updateTextData() {
        TAVSticker tAVSticker = this.sticker;
        if (tAVSticker != null) {
            tAVSticker.updateTextData();
        }
    }

    public TAVMovieSticker(@NonNull String str) {
        this(str, false);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVMovieSticker m281clone() {
        TAVMovieSticker tAVMovieSticker = new TAVMovieSticker(this.filePath);
        tAVMovieSticker.setStickerType(this.stickerType);
        tAVMovieSticker.setPosition(this.centerPosition);
        tAVMovieSticker.setRotation(this.rotation);
        tAVMovieSticker.setScale(this.scale);
        tAVMovieSticker.setTimeRange(this.timeRange.m260clone());
        return null;
    }

    public TAVMovieSticker(@NonNull String str, boolean z16) {
        this.filePath = str;
        this.scale = 1.0f;
        this.rotation = 0.0f;
        this.centerPosition = new PointF(0.5f, 0.5f);
        try {
            if (z16) {
                this.sticker = new TAVSticker().setAssetFilePath(str).setScale(1.0f).setRotate(0.0f).setCenterX(0.5f).setCenterY(0.5f).init();
            } else {
                this.sticker = new TAVSticker().setFilePath(str).setScale(1.0f).setRotate(0.0f).setCenterX(0.5f).setCenterY(0.5f).init();
            }
            this.timeRange = this.sticker.getTimeRange();
            this.imageList = this.sticker.getStickerImageItems();
            ArrayList<TAVStickerTextItem> stickerTextItems = this.sticker.getStickerTextItems();
            if (stickerTextItems == null || stickerTextItems.size() <= 0) {
                return;
            }
            this.textList = new ArrayList();
            for (TAVStickerTextItem tAVStickerTextItem : stickerTextItems) {
                TAVMovieStickerTextItem tAVMovieStickerTextItem = new TAVMovieStickerTextItem();
                tAVMovieStickerTextItem.setTextItem(tAVStickerTextItem);
                tAVMovieStickerTextItem.setText(tAVStickerTextItem.getDefaultText());
                tAVMovieStickerTextItem.setTextColor(tAVStickerTextItem.getDefaultColor());
                this.textList.add(tAVMovieStickerTextItem);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
