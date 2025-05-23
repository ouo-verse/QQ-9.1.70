package com.tencent.qcircle.weseevideo.composition.builder;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.interfaces.ITAVCompositionBuilderInterface;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.qcircle.weseevideo.model.effect.MusicModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.utils.ModelAdaptUtils;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.utils.CompositionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MediaBuilder {
    public static final String TAG = "MediaBuilder";

    public static void build(@NonNull MediaModel mediaModel, VideoRenderChainManager.IStickerContextInterface iStickerContextInterface, @NonNull MediaBuilderListener mediaBuilderListener, @NonNull VideoRenderChainConfigure videoRenderChainConfigure) {
        TAVComposition buildComposition = buildComposition(videoRenderChainConfigure.getApplyType(), mediaModel, null);
        if (buildComposition == null) {
            Logger.e(TAG, "VideoRenderChainManager build fail for composition is null.");
            if (mediaBuilderListener != null) {
                mediaBuilderListener.buildCompleted(-101, null, null);
                return;
            }
            return;
        }
        if (videoRenderChainConfigure.getRenderSize() != null && videoRenderChainConfigure.getRenderSize().height > 0.0f && videoRenderChainConfigure.getRenderSize().width > 0.0f) {
            buildComposition.setRenderSize(videoRenderChainConfigure.getRenderSize());
        }
        mediaBuilderListener.buildCompleted(0, new VideoRenderChainManager(videoRenderChainConfigure.getApplyType(), buildComposition, mediaModel, iStickerContextInterface, null, videoRenderChainConfigure), null);
    }

    public static TAVComposition buildComposition(int i3, @NonNull MediaModel mediaModel, ITAVCompositionBuilderInterface iTAVCompositionBuilderInterface) {
        TAVResource transformToTAVResource;
        List<MediaClipModel> videos = mediaModel.getMediaResourceModel().getVideos();
        if (videos.size() == 0) {
            Logger.e(TAG, "this MediaResourceModel's videos is empty.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (iTAVCompositionBuilderInterface != null) {
            return iTAVCompositionBuilderInterface.buildComposition(videos);
        }
        for (MediaClipModel mediaClipModel : videos) {
            if (mediaClipModel != null && mediaClipModel.getResource() != null && (transformToTAVResource = ModelAdaptUtils.transformToTAVResource(mediaClipModel.getResource())) != null) {
                TAVClip tAVClip = new TAVClip(transformToTAVResource);
                if (mediaClipModel.getVideoConfigurationModel() != null) {
                    TAVVideoConfiguration convertToConfiguration = ModelAdaptUtils.transformToTAVVideoConfiguration(mediaClipModel.getVideoConfigurationModel()).convertToConfiguration();
                    convertToConfiguration.setPreferRotation(mediaClipModel.getVideoConfigurationModel().getRotate());
                    if (mediaClipModel.getResource().getType() == 1 && !convertToConfiguration.frameEnable()) {
                        convertToConfiguration.setFrame(TAVVideoConfiguration.FIX_RENDER_SIZE);
                    }
                    tAVClip.setVideoConfiguration(convertToConfiguration);
                }
                if (mediaClipModel.getAudioConfigurationModel() != null) {
                    tAVClip.setAudioConfiguration(ModelAdaptUtils.transformToTAVAudioConfiguration(mediaClipModel.getAudioConfigurationModel()).convertToConfiguration());
                }
                arrayList.add(tAVClip);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        TAVComposition tAVComposition = new TAVComposition();
        tAVComposition.addVideoChannel(arrayList);
        tAVComposition.addAudioChannel(arrayList);
        arrayList2.addAll(arrayList);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((TAVClip) it.next()).getAudioConfiguration().setVolume(getPlayVolume(mediaModel.getMediaEffectModel().getMusicModel()));
        }
        if (mediaModel.getMediaEffectModel().getMusicModel().getBgmVolume() >= 0.0f) {
            tAVComposition.setAudios(getAudioClips(tAVComposition, mediaModel));
        }
        return tAVComposition;
    }

    public static ArrayList<TAVClip> getAudioClips(@NonNull TAVComposition tAVComposition, @NonNull MediaModel mediaModel) {
        float f16;
        ArrayList<TAVClip> arrayList = new ArrayList<>();
        MusicModel musicModel = mediaModel.getMediaEffectModel().getMusicModel();
        if (musicModel == null) {
            musicModel = new MusicModel();
            mediaModel.getMediaEffectModel().setMusicModel(musicModel);
        }
        MusicMaterialMetaDataBean metaDataBean = musicModel.getMetaDataBean();
        if (metaDataBean != null && tAVComposition != null && !TextUtils.isEmpty(metaDataBean.path)) {
            float f17 = metaDataBean.startTime;
            float f18 = metaDataBean.mTotalTime * 1000;
            if (f18 > 0.0f) {
                f16 = f18 - f17;
            } else {
                f16 = metaDataBean.segDuration;
            }
            float timeUs = ((float) tAVComposition.getDuration().getTimeUs()) / 1000.0f;
            if (timeUs >= f16 && f16 > 0.0f) {
                TAVClip tAVClip = new TAVClip(new URLAsset(metaDataBean.path));
                CMTime cMTime = new CMTime(f16 / 1000.0f);
                int i3 = 0;
                while (timeUs > 0.0f) {
                    TAVClip m268clone = tAVClip.m268clone();
                    m268clone.getAudioConfiguration().setVolume(mediaModel.getMediaEffectModel().getMusicModel().getBgmVolume());
                    m268clone.getResource().setSourceTimeRange(new CMTimeRange(new CMTime(metaDataBean.startTime / 1000.0f), cMTime));
                    m268clone.setStartTime(cMTime.multi(i3));
                    arrayList.add(m268clone);
                    timeUs -= f16;
                    i3++;
                }
                CompositionUtils.reloadAudioStartTimeWithTransitionableAudio(arrayList);
            } else {
                CMTime duration = tAVComposition.getDuration();
                TAVClip tAVClip2 = new TAVClip(new URLAsset(metaDataBean.path));
                tAVClip2.getAudioConfiguration().setVolume(mediaModel.getMediaEffectModel().getMusicModel().getBgmVolume());
                tAVClip2.getResource().setSourceTimeRange(new CMTimeRange(new CMTime(metaDataBean.startTime / 1000.0f), duration));
                arrayList.add(tAVClip2);
            }
        }
        return arrayList;
    }

    private static float getPlayVolume(MusicModel musicModel) {
        if (musicModel == null) {
            return 0.0f;
        }
        if (musicModel.getMetaDataBean() == null && !musicModel.isManuallyChangedVolume()) {
            return 1.0f;
        }
        return musicModel.getVolume();
    }

    public static long multiClipsAdjustTimeRange(List<TAVClip> list, VideoResourceModel videoResourceModel, TAVClip tAVClip, float f16, long j3, long j16, long j17) {
        float f17;
        long j18;
        long j19 = j16 - j3;
        long j26 = 0;
        if (j19 < 0) {
            j19 = 0;
        }
        if (videoResourceModel.getScaleDuration() != 0) {
            f17 = (((float) videoResourceModel.getSelectTimeDuration()) * f16) / ((float) videoResourceModel.getScaleDuration());
        } else {
            f17 = f16;
        }
        if (videoResourceModel.getType() == 1) {
            long selectTimeDuration = ((float) (videoResourceModel.getSelectTimeDuration() * 1000)) / f17;
            long j27 = selectTimeDuration - j19;
            if (j27 > 0 && j3 < j17) {
                if (j3 + selectTimeDuration >= j17) {
                    j27 = (j17 - j3) - j19;
                }
                CMTime cMTime = new CMTime(j27, 1000000);
                tAVClip.getResource().setSourceTimeRange(new CMTimeRange(new CMTime((((float) ((videoResourceModel.getSourceTimeStart() + videoResourceModel.getSelectTimeStart()) * 1000)) + (((float) j19) * f17)) / 1000000.0f), cMTime.multi(f17)));
                tAVClip.getResource().setScaledDuration(cMTime);
                list.add(tAVClip);
            }
            j18 = j3 + selectTimeDuration;
            j26 = selectTimeDuration;
        } else if (videoResourceModel.getType() != 2 && videoResourceModel.getType() != 4) {
            j18 = j3;
        } else {
            long selectTimeDuration2 = ((float) (videoResourceModel.getSelectTimeDuration() * 1000)) / f17;
            long j28 = selectTimeDuration2 - j19;
            if (j28 > 0 && j3 < j17) {
                if (j3 + selectTimeDuration2 >= j17) {
                    j28 = (j17 - j3) - j19;
                }
                CMTime cMTime2 = new CMTime(j28, 1000000);
                tAVClip.setDuration(cMTime2.multi(f17));
                tAVClip.getResource().setScaledDuration(cMTime2);
                list.add(tAVClip);
            }
            j18 = j3 + selectTimeDuration2;
            j26 = selectTimeDuration2;
        }
        Logger.e(TAG, "multiClipsAdjustTimeRange: rangeStartUs-" + j16 + ", rangeEndUs-" + j17 + ", speed-" + f17 + ", itemScaleUs-" + j26);
        return j18;
    }
}
