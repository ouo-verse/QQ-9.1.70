package com.tencent.qcircle.weseevideo.composition;

import com.tencent.tav.coremedia.CGSize;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoRenderChainConfigure {
    private boolean imageMode;
    private boolean isOpenAspectFillEffect;
    private boolean isOpenBeautyEffect;
    private boolean isOpenFreeVideoEndEffect;
    private boolean isOpenLutEffect;
    private boolean isOpenMovieTemplateEffect;
    private boolean isOpenRedPacketStickerEffect;
    private boolean isOpenStickerEffect;
    private boolean isOpenSubtitleEffect;
    private boolean isOpenVideoBeginEffect;
    private boolean isOpenVideoEndEffect;
    private boolean isOpenVideoFenWeiEffect;
    private boolean isOpenVideoSpecialEffect;
    private boolean isOpenWXShareVideoEndEffect;
    private boolean isOpenWaterMarkEffect;
    public int mApplyType;
    private CGSize mRenderSize;
    private int mSceneType;
    private boolean modifyClip;
    private CGSize screenSize;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ApplyType {
        public static final int EXPORT_DEFAULT = 200;
        public static final int EXPORT_PUBLISH_TYPE = 202;
        public static final int EXPORT_WECHAT_30_TYPE = 201;
        public static final int PLAYING_DEFAULT = 100;
        public static final int PLAYING_PIC = 101;
        public static final int UNKNOWN_TYPE = -1;
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class SceneType {
        public static final int AUTO_TEMPLATE_SCENE = 2;
        public static final int CAMERA_SCENE = 5;
        public static final int DEFAULT_SCENE = 0;
        public static final int GAME_AUTO_TEMPLATE_SCENE = 3;
        public static final int LIGHT_TEMPLATE_SCENE = 4;
        public static final int TEMPLATE_SCENE = 1;
    }

    public VideoRenderChainConfigure() {
        this(true);
    }

    public int getApplyType() {
        return this.mApplyType;
    }

    public CGSize getRenderSize() {
        return this.mRenderSize;
    }

    public int getSceneType() {
        return this.mSceneType;
    }

    public CGSize getScreenSize() {
        return this.screenSize;
    }

    public boolean isImageMode() {
        return this.imageMode;
    }

    public boolean isModifyClip() {
        return this.modifyClip;
    }

    public boolean isOpenAspectFillEffect() {
        return this.isOpenAspectFillEffect;
    }

    public boolean isOpenBeautyEffect() {
        return this.isOpenBeautyEffect;
    }

    public boolean isOpenFreeVideoEndEffect() {
        return this.isOpenFreeVideoEndEffect;
    }

    public boolean isOpenLutEffect() {
        return this.isOpenLutEffect;
    }

    public boolean isOpenMovieTemplateEffect() {
        return this.isOpenMovieTemplateEffect;
    }

    public boolean isOpenRedPacketStickerEffect() {
        return this.isOpenRedPacketStickerEffect;
    }

    public boolean isOpenStickerEffect() {
        return this.isOpenStickerEffect;
    }

    public boolean isOpenSubtitleEffect() {
        return this.isOpenSubtitleEffect;
    }

    public boolean isOpenVideoBeginEffect() {
        return this.isOpenVideoBeginEffect;
    }

    public boolean isOpenVideoEndEffect() {
        return this.isOpenVideoEndEffect;
    }

    public boolean isOpenVideoFenWeiEffect() {
        return this.isOpenVideoFenWeiEffect;
    }

    public boolean isOpenVideoSpecialEffect() {
        return this.isOpenVideoSpecialEffect;
    }

    public boolean isOpenWXShareVideoEndEffect() {
        return this.isOpenWXShareVideoEndEffect;
    }

    public boolean isOpenWaterMarkEffect() {
        return this.isOpenWaterMarkEffect;
    }

    public void setApplyType(int i3) {
        this.mApplyType = i3;
    }

    public void setImageMode(boolean z16) {
        this.imageMode = z16;
    }

    public void setModifyClip(boolean z16) {
        this.modifyClip = z16;
    }

    public void setOpenAspectFillEffect(boolean z16) {
        this.isOpenAspectFillEffect = z16;
    }

    public void setOpenBeautyEffect(boolean z16) {
        this.isOpenBeautyEffect = z16;
    }

    public void setOpenFreeVideoEndEffect(boolean z16) {
        this.isOpenFreeVideoEndEffect = z16;
    }

    public void setOpenLutEffect(boolean z16) {
        this.isOpenLutEffect = z16;
    }

    public void setOpenMovieTemplateEffect(boolean z16) {
        this.isOpenMovieTemplateEffect = z16;
    }

    public void setOpenRedPacketStickerEffect(boolean z16) {
        this.isOpenRedPacketStickerEffect = z16;
    }

    public void setOpenStickerEffect(boolean z16) {
        this.isOpenStickerEffect = z16;
    }

    public void setOpenSubtitleEffect(boolean z16) {
        this.isOpenSubtitleEffect = z16;
    }

    public void setOpenVideoBeginEffect(boolean z16) {
        this.isOpenVideoBeginEffect = z16;
    }

    public void setOpenVideoEndEffect(boolean z16) {
        this.isOpenVideoEndEffect = z16;
    }

    public void setOpenVideoFenWeiEffect(boolean z16) {
        this.isOpenVideoFenWeiEffect = z16;
    }

    public void setOpenVideoSpecialEffect(boolean z16) {
        this.isOpenVideoSpecialEffect = z16;
    }

    public void setOpenWXShareVideoEndEffect(boolean z16) {
        this.isOpenWXShareVideoEndEffect = z16;
    }

    public void setOpenWaterMarkEffect(boolean z16) {
        this.isOpenWaterMarkEffect = z16;
    }

    public void setRenderSize(CGSize cGSize) {
        this.mRenderSize = cGSize;
    }

    public void setSceneType(int i3) {
        this.mSceneType = i3;
    }

    public void setScreenSize(CGSize cGSize) {
        this.screenSize = cGSize;
    }

    public VideoRenderChainConfigure(boolean z16) {
        this.mSceneType = 0;
        this.mApplyType = -1;
        this.isOpenAspectFillEffect = z16;
        this.isOpenBeautyEffect = z16;
        this.isOpenLutEffect = z16;
        this.isOpenVideoSpecialEffect = z16;
        this.isOpenVideoBeginEffect = z16;
        this.isOpenVideoFenWeiEffect = z16;
        this.isOpenVideoEndEffect = z16;
        this.isOpenStickerEffect = z16;
        this.isOpenSubtitleEffect = z16;
        this.isOpenFreeVideoEndEffect = z16;
        this.isOpenWaterMarkEffect = z16;
        this.isOpenWXShareVideoEndEffect = z16;
        this.isOpenRedPacketStickerEffect = z16;
        this.isOpenMovieTemplateEffect = z16;
    }
}
