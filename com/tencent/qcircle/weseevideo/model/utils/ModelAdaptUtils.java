package com.tencent.qcircle.weseevideo.model.utils;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qcircle.tavcut.util.StickerUtil;
import com.tencent.qcircle.weseevideo.common.utils.CollectionExtKt;
import com.tencent.qcircle.weseevideo.editor.sticker.utils.StickerConverterKt;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoBeginModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoEndModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoFenWeiModel;
import com.tencent.qcircle.weseevideo.model.resource.AudioConfigurationModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavmovie.base.TAVMovieAudioConfiguration;
import com.tencent.tavmovie.base.TAVMovieVideoConfiguration;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavsticker.exception.StickerInitializationException;
import com.tencent.tavsticker.model.TAVSticker;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ModelAdaptUtils {
    public static final String TAG = "ModelAdaptUtils";

    private static TAVVideoConfiguration.TAVVideoConfigurationContentMode getContentMode(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit;
            }
            return TAVVideoConfiguration.TAVVideoConfigurationContentMode.scaleToFit;
        }
        return TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill;
    }

    public static TAVSticker stickerModelToTAVSticker(@NonNull StickerModel stickerModel, @NonNull CGSize cGSize) {
        return StickerUtil.stickerModel2TavSticker(stickerModel);
    }

    public static TAVSticker subtitleModelToTAVSticker(@NonNull SubtitleModel subtitleModel, @NonNull CGSize cGSize) {
        return StickerConverterKt.convert2TavSticker(subtitleModel);
    }

    public static TAVMovieAudioConfiguration transformToTAVAudioConfiguration(@NonNull AudioConfigurationModel audioConfigurationModel) {
        return new TAVMovieAudioConfiguration();
    }

    public static TAVResource transformToTAVResource(@NonNull VideoResourceModel videoResourceModel) {
        TAVResource tAVAssetTrackResource;
        if (videoResourceModel.getType() != 1 && videoResourceModel.getType() != 3) {
            if (videoResourceModel.getType() == 2) {
                tAVAssetTrackResource = new TAVImageTrackResource(videoResourceModel.getPath(), new CMTime(((float) videoResourceModel.getSourceTimeDuration()) / 1000.0f));
            } else if (videoResourceModel.getType() == 4) {
                tAVAssetTrackResource = new TAVImageResource(new CIImage(videoResourceModel.getPath(), new CGSize(videoResourceModel.getWidth(), videoResourceModel.getHeight())), new CMTime(((float) videoResourceModel.getSourceTimeDuration()) / 1000.0f));
            } else {
                tAVAssetTrackResource = null;
            }
        } else {
            tAVAssetTrackResource = new TAVAssetTrackResource(new URLAsset(videoResourceModel.getPath()));
        }
        if (tAVAssetTrackResource != null) {
            tAVAssetTrackResource.setSourceTimeRange(new CMTimeRange(new CMTime(videoResourceModel.getSourceTimeStart() + videoResourceModel.getSelectTimeStart(), 1000), new CMTime(videoResourceModel.getSelectTimeDuration(), 1000)));
            Log.d("lingeng_time", "transformToTAVResource:  \nvideoResourceModel.getSourceTimeStart()" + videoResourceModel.getSourceTimeStart() + "\nvideoResourceModel.getSelectTimeStart()" + videoResourceModel.getSelectTimeStart() + "\nvideoResourceModel.getSelectTimeDuration()" + videoResourceModel.getSelectTimeDuration() + "\nvideoResourceModel.getScaleDuration()" + videoResourceModel.getScaleDuration());
            tAVAssetTrackResource.setScaledDuration(new CMTime(videoResourceModel.getScaleDuration(), 1000));
        }
        return tAVAssetTrackResource;
    }

    public static TAVMovieVideoConfiguration transformToTAVVideoConfiguration(@NonNull VideoConfigurationModel videoConfigurationModel) {
        TAVMovieVideoConfiguration tAVMovieVideoConfiguration = new TAVMovieVideoConfiguration();
        tAVMovieVideoConfiguration.setContentMode(getContentMode(videoConfigurationModel.getContentMode()));
        CGRect createFrameRect = videoConfigurationModel.createFrameRect();
        if (createFrameRect != null) {
            tAVMovieVideoConfiguration.setFrame(createFrameRect);
        }
        Matrix matrix = new Matrix();
        matrix.setValues(CollectionExtKt.toArray(videoConfigurationModel.getMatrix()));
        tAVMovieVideoConfiguration.setTransform(matrix);
        tAVMovieVideoConfiguration.setPreferRotation(videoConfigurationModel.getRotate());
        return tAVMovieVideoConfiguration;
    }

    public static TAVSticker videoBeginModelToTAVSticker(@NonNull VideoBeginModel videoBeginModel) {
        TAVSticker tAVSticker = new TAVSticker();
        tAVSticker.setFilePath(videoBeginModel.getFilePath());
        try {
            return tAVSticker.init();
        } catch (StickerInitializationException e16) {
            e16.printStackTrace();
            return tAVSticker;
        }
    }

    public static TAVSticker videoEffectModelToTAVSticker(@NonNull VideoEffectModel videoEffectModel) {
        TAVMovieSticker tAVMovieSticker = new TAVMovieSticker(videoEffectModel.getFilePath());
        tAVMovieSticker.setTimeRange(new CMTimeRange(new CMTime(videoEffectModel.getStartTime() / 1000.0f), new CMTime(videoEffectModel.getDuration() / 1000.0f)));
        tAVMovieSticker.getSticker().setStickerId(videoEffectModel.getEffectId());
        return tAVMovieSticker.getSticker();
    }

    public static TAVSticker videoEndModelToTAVSticker(@NonNull VideoEndModel videoEndModel) {
        String pag = videoEndModel.getPag();
        if (!TextUtils.isEmpty(pag) && FileUtils.exists(pag)) {
            TAVMovieSticker tAVMovieSticker = new TAVMovieSticker(pag);
            CMTime cMTime = new CMTime(((float) tAVMovieSticker.getSticker().durationTime()) / 1000000.0f);
            tAVMovieSticker.setTimeRange(new CMTimeRange(new CMTime(videoEndModel.getCompositionDuration() / 1000.0f).sub(cMTime), cMTime));
            return tAVMovieSticker.getSticker();
        }
        return null;
    }

    public static TAVSticker videoFenWeiModelToTAVSticker(@NonNull VideoFenWeiModel videoFenWeiModel) {
        TAVSticker tAVSticker = new TAVSticker();
        tAVSticker.setFilePath(videoFenWeiModel.getFilePath());
        try {
            tAVSticker.init();
        } catch (StickerInitializationException e16) {
            e16.printStackTrace();
        }
        return tAVSticker;
    }
}
