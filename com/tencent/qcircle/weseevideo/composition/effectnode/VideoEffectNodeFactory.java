package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.editor.sticker.constant.WsStickerConstant;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.qcircle.weseevideo.editor.utils.HandlerUtils;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.qcircle.weseevideo.model.effect.LutModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoBeginModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoEndModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoFenWeiModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoPagModel;
import com.tencent.qcircle.weseevideo.model.utils.ModelAdaptUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavmovie.filter.TAVBigStickerOverlayEffect;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoEffectNodeFactory {
    public static String TAG = "VideoEffectNodeFactory";

    @Nullable
    public static TAVAutomaticRenderContext addPagChainEffectNode(@NonNull VideoPagModel videoPagModel, TAVAutomaticRenderContext tAVAutomaticRenderContext) {
        TAVSticker tAVSticker;
        if (tAVAutomaticRenderContext == null) {
            tAVAutomaticRenderContext = new TAVAutomaticRenderContext();
        }
        if (VideoEffectType.TYPE_VIDEO_BEGIN.value == videoPagModel.getEffectType() && (videoPagModel instanceof VideoBeginModel)) {
            tAVSticker = ModelAdaptUtils.videoBeginModelToTAVSticker((VideoBeginModel) videoPagModel);
            TAVStickerExKt.setExtraStickerType(tAVSticker, WsStickerConstant.StickerType.STICKER_VIDEO_BEGIN);
        } else if (VideoEffectType.TYPE_VIDEO_END.value == videoPagModel.getEffectType() && (videoPagModel instanceof VideoEndModel)) {
            tAVSticker = ModelAdaptUtils.videoEndModelToTAVSticker((VideoEndModel) videoPagModel);
            TAVStickerExKt.setExtraStickerType(tAVSticker, WsStickerConstant.StickerType.STICKER_VIDEO_END);
        } else if (VideoEffectType.TYPE_FEN_WEI.value == videoPagModel.getEffectType() && (videoPagModel instanceof VideoFenWeiModel)) {
            tAVSticker = ModelAdaptUtils.videoFenWeiModelToTAVSticker((VideoFenWeiModel) videoPagModel);
            TAVStickerExKt.setExtraStickerType(tAVSticker, WsStickerConstant.StickerType.STICKER_FEN_WEI);
        } else {
            tAVSticker = null;
        }
        if (tAVSticker != null) {
            videoPagModel.setUniqueId(tAVSticker.getStickerId());
            tAVAutomaticRenderContext.loadSticker(tAVSticker, false);
        }
        return tAVAutomaticRenderContext;
    }

    @Nullable
    public static TAVStickerRenderContext addPagOverlayEffectNode(@NonNull VideoPagModel videoPagModel, CGSize cGSize, @NonNull TAVStickerRenderContext tAVStickerRenderContext, VideoRenderChainManager.IStickerContextInterface iStickerContextInterface) {
        TAVSticker tAVSticker;
        if (VideoEffectType.TYPE_SUBTITLE.value == videoPagModel.getEffectType() && (videoPagModel instanceof SubtitleModel)) {
            tAVSticker = ModelAdaptUtils.subtitleModelToTAVSticker((SubtitleModel) videoPagModel, cGSize);
            TAVStickerExKt.setExtraStickerType(tAVSticker, WsStickerConstant.StickerType.STICKER_LYRIC);
        } else {
            tAVSticker = null;
        }
        if (tAVSticker != null) {
            videoPagModel.setUniqueId(tAVSticker.getStickerId());
            loadSticker(tAVStickerRenderContext, tAVSticker);
        }
        return tAVStickerRenderContext;
    }

    @Nullable
    public static TAVStickerRenderContext addStickerEffectNode(@NonNull List<StickerModel> list, @NonNull CGSize cGSize, @NonNull TAVStickerRenderContext tAVStickerRenderContext, VideoRenderChainManager.IStickerContextInterface iStickerContextInterface) {
        for (StickerModel stickerModel : list) {
            if (stickerModel != null) {
                TAVSticker stickerModelToTAVSticker = ModelAdaptUtils.stickerModelToTAVSticker(stickerModel, cGSize);
                stickerModel.setUniqueId(stickerModelToTAVSticker.getStickerId());
                loadSticker(tAVStickerRenderContext, stickerModelToTAVSticker);
            }
        }
        return tAVStickerRenderContext;
    }

    @Nullable
    public static TAVAutomaticRenderContext addVideoSpecialEffectNode(@NonNull List<VideoEffectModel> list, @NonNull TAVAutomaticRenderContext tAVAutomaticRenderContext) {
        if (tAVAutomaticRenderContext == null) {
            tAVAutomaticRenderContext = new TAVAutomaticRenderContext();
        }
        for (VideoEffectModel videoEffectModel : list) {
            if (videoEffectModel != null) {
                TAVSticker videoEffectModelToTAVSticker = ModelAdaptUtils.videoEffectModelToTAVSticker(videoEffectModel);
                videoEffectModelToTAVSticker.setLayerIndex(-99);
                loadSticker(tAVAutomaticRenderContext, videoEffectModelToTAVSticker);
            }
        }
        return tAVAutomaticRenderContext;
    }

    @Nullable
    public static CropEffectNode createCropEffectNode(@NonNull CropModel cropModel) {
        CropEffectNode cropEffectNode = new CropEffectNode();
        cropEffectNode.setCropModel(cropModel);
        return cropEffectNode;
    }

    @Nullable
    public static WSLutEffectNode createLutEffectNode(@NonNull LutModel lutModel) {
        WSLutEffectNode wSLutEffectNode = new WSLutEffectNode();
        wSLutEffectNode.setLutMode(lutModel);
        return wSLutEffectNode;
    }

    @Nullable
    public static TAVVideoMixEffect createPagChainEffect(@NonNull TAVStickerRenderContext tAVStickerRenderContext) {
        if (tAVStickerRenderContext instanceof TAVAutomaticRenderContext) {
            TAVAutomaticRenderContext tAVAutomaticRenderContext = (TAVAutomaticRenderContext) tAVStickerRenderContext;
            tAVAutomaticRenderContext.readAllVideoTracks();
            return new WSPagChainStickerMergedEffectNode(tAVAutomaticRenderContext);
        }
        return new TAVBigStickerOverlayEffect(tAVStickerRenderContext);
    }

    public static WSOverlayStickerMergedEffectNode createPagOverlayEffect(@NonNull TAVStickerRenderContext tAVStickerRenderContext, VideoRenderChainManager.IStickerContextInterface iStickerContextInterface, boolean z16) {
        return new WSOverlayStickerMergedEffectNode(tAVStickerRenderContext, iStickerContextInterface, z16);
    }

    public static void loadSticker(@NonNull final TAVStickerRenderContext tAVStickerRenderContext, @NonNull final TAVSticker tAVSticker) {
        if (tAVStickerRenderContext instanceof TAVStickerContext) {
            HandlerUtils.getMainHandler().post(new Runnable() { // from class: com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectNodeFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    TAVStickerRenderContext.this.loadSticker(tAVSticker, false);
                }
            });
        } else {
            tAVStickerRenderContext.loadSticker(tAVSticker, false);
        }
    }
}
