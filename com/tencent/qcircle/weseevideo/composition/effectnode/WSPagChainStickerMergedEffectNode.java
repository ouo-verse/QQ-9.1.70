package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.qcircle.weseevideo.editor.sticker.constant.WsStickerConstant;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.qcircle.weseevideo.model.effect.VideoBeginModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoEndModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoFenWeiModel;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes22.dex */
public class WSPagChainStickerMergedEffectNode extends TAVOneClickFilmStickerEffect {
    private VideoBeginModel mVideoBeginModel;
    private List<VideoEffectModel> mVideoEffectModels;
    private VideoEndModel mVideoEndModel;
    private VideoFenWeiModel mVideoFenWeiModel;
    private final String sEffectId;

    public WSPagChainStickerMergedEffectNode(TAVAutomaticRenderContext tAVAutomaticRenderContext) {
        super(tAVAutomaticRenderContext);
        this.sEffectId = "WSPagChainStickerMergedEffectNode" + Integer.toHexString(hashCode());
        this.reportKey = "WSPagChainStickerMergedEffectNode";
    }

    private List<TAVSticker> findStickerByType(int i3) {
        ArrayList arrayList = new ArrayList();
        if (isAvailable()) {
            synchronized (getStickerContext().getStickers()) {
                for (TAVSticker tAVSticker : getStickerContext().getStickers()) {
                    if (tAVSticker != null) {
                        if (i3 == VideoEffectType.TYPE_STICKER.value && "blur".equals(TAVStickerExKt.getExtraStickerType(tAVSticker))) {
                            arrayList.add(tAVSticker);
                        } else if (i3 == VideoEffectType.TYPE_VIDEO_END.value && WsStickerConstant.StickerType.STICKER_VIDEO_END.equals(TAVStickerExKt.getExtraStickerType(tAVSticker))) {
                            arrayList.add(tAVSticker);
                        } else if (i3 == VideoEffectType.TYPE_FEN_WEI.value && WsStickerConstant.StickerType.STICKER_FEN_WEI.equals(TAVStickerExKt.getExtraStickerType(tAVSticker))) {
                            arrayList.add(tAVSticker);
                        } else if (i3 == VideoEffectType.TYPE_VIDEO_BEGIN.value && WsStickerConstant.StickerType.STICKER_VIDEO_BEGIN.equals(TAVStickerExKt.getExtraStickerType(tAVSticker))) {
                            arrayList.add(tAVSticker);
                        } else if (i3 == VideoEffectType.TYPE_SPECIAL_EFFECT.value && WsStickerConstant.StickerType.STICKER_VIDEO_SPECIAL.equals(TAVStickerExKt.getExtraStickerType(tAVSticker))) {
                            arrayList.add(tAVSticker);
                        } else if (i3 == VideoEffectType.TYPE_SUBTITLE.value && WsStickerConstant.StickerType.STICKER_LYRIC.equals(TAVStickerExKt.getExtraStickerType(tAVSticker))) {
                            arrayList.add(tAVSticker);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean isAvailable() {
        if (getStickerContext() != null) {
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        if (CollectionUtil.isEmptyList(this.mVideoEffectModels) && this.mVideoBeginModel == null && this.mVideoEndModel == null && this.mVideoFenWeiModel == null) {
            if (getStickerContext() == null || getStickerContext().getStickerCount() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void removeStickers(List<TAVSticker> list) {
        if (isAvailable() && !CollectionUtil.isEmptyList(list)) {
            Iterator<TAVSticker> it = list.iterator();
            while (it.hasNext()) {
                getStickerContext().removeSticker(it.next());
            }
        }
    }

    private void updateVideoBeginSticker() {
        if (isAvailable()) {
            removeStickers(findStickerByType(VideoEffectType.TYPE_VIDEO_BEGIN.value));
            VideoBeginModel videoBeginModel = this.mVideoBeginModel;
            if (videoBeginModel != null && !TextUtils.isEmpty(videoBeginModel.getFilePath())) {
                VideoEffectNodeFactory.addPagChainEffectNode(this.mVideoBeginModel, getStickerContext());
            }
        }
    }

    private void updateVideoEffectSticker() {
        if (isAvailable()) {
            removeStickers(findStickerByType(VideoEffectType.TYPE_SPECIAL_EFFECT.value));
            if (!CollectionUtil.isEmptyList(this.mVideoEffectModels)) {
                VideoEffectNodeFactory.addVideoSpecialEffectNode(this.mVideoEffectModels, getStickerContext());
            }
        }
    }

    private void updateVideoEndSticker() {
        if (isAvailable()) {
            removeStickers(findStickerByType(VideoEffectType.TYPE_VIDEO_END.value));
            VideoEndModel videoEndModel = this.mVideoEndModel;
            if (videoEndModel != null && !TextUtils.isEmpty(videoEndModel.getFilePath())) {
                VideoEffectNodeFactory.addPagChainEffectNode(this.mVideoEndModel, getStickerContext());
            }
        }
    }

    private void updateVideoFenWeiSticker() {
        if (isAvailable()) {
            removeStickers(findStickerByType(VideoEffectType.TYPE_FEN_WEI.value));
            VideoFenWeiModel videoFenWeiModel = this.mVideoFenWeiModel;
            if (videoFenWeiModel != null && !TextUtils.isEmpty(videoFenWeiModel.getFilePath())) {
                VideoEffectNodeFactory.addPagChainEffectNode(this.mVideoFenWeiModel, getStickerContext());
            }
        }
    }

    @Override // com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect, com.tencent.tavkit.composition.video.TAVVideoMixEffect
    @NonNull
    public String effectId() {
        if (isEmpty()) {
            return "";
        }
        return this.sEffectId;
    }

    public VideoBeginModel getVideoBeginModel() {
        return this.mVideoBeginModel;
    }

    public List<VideoEffectModel> getVideoEffectModels() {
        return this.mVideoEffectModels;
    }

    public VideoEndModel getVideoEndModel() {
        return this.mVideoEndModel;
    }

    public VideoFenWeiModel getVideoFenWeiModel() {
        return this.mVideoFenWeiModel;
    }

    public void setVideoBeginModel(VideoBeginModel videoBeginModel) {
        this.mVideoBeginModel = videoBeginModel;
        updateVideoBeginSticker();
    }

    public void setVideoEffectModels(List<VideoEffectModel> list) {
        this.mVideoEffectModels = list;
        updateVideoEffectSticker();
    }

    public void setVideoEndModel(VideoEndModel videoEndModel) {
        this.mVideoEndModel = videoEndModel;
        updateVideoEndSticker();
    }

    public void setVideoFenWeiModel(VideoFenWeiModel videoFenWeiModel) {
        this.mVideoFenWeiModel = videoFenWeiModel;
        updateVideoFenWeiSticker();
    }
}
