package com.tencent.qcircle.weseevideo.model.template.auto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.autotemplate.TAVAutomaticTemplateParse;
import com.tencent.autotemplate.TAVRhythmAutomaticTemplate;
import com.tencent.autotemplate.TAVRhythmMovieSegment;
import com.tencent.autotemplate.model.TAVEffectParameter;
import com.tencent.autotemplate.model.TAVLUTAutomaticEffect;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qcircle.tavcut.constants.Constants;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilder;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.composition.interfaces.ITAVCompositionBuilderInterface;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.qcircle.weseevideo.model.effect.BeautyModel;
import com.tencent.qcircle.weseevideo.model.effect.LutModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.MusicModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieSegmentModel;
import com.tencent.qcircle.weseevideo.model.utils.FileUtils;
import com.tencent.qcircle.weseevideo.model.utils.ModelAdaptUtils;
import com.tencent.qcircle.weseevideo.model.utils.Utils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavmovie.TAVMovie;
import com.tencent.tavmovie.base.TAVMovieAudioConfiguration;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.libpag.PAGLayer;
import org.libpag.PAGRenderer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AutoTemplateMediaBuilder {
    public static final String TAG = "AutoTemplateMediaBuilder";

    @Nullable
    public static void build(@NonNull final MediaModel mediaModel, Context context, VideoRenderChainManager.IStickerContextInterface iStickerContextInterface, @NonNull VideoRenderChainConfigure videoRenderChainConfigure, @NonNull MediaBuilderListener mediaBuilderListener) {
        if (videoRenderChainConfigure.getRenderSize() == null) {
            videoRenderChainConfigure.setRenderSize(new CGSize(720.0f, 1280.0f));
        }
        final TAVAutomaticTemplate buildAutomaticTemplate = buildAutomaticTemplate(context, mediaModel, videoRenderChainConfigure.getRenderSize());
        if (buildAutomaticTemplate == null) {
            Logger.e(TAG, "build automaticTemplate failed.");
            if (mediaBuilderListener != null) {
                mediaBuilderListener.buildCompleted(-200, null, null);
                return;
            }
            return;
        }
        TAVComposition buildComposition = buildComposition(videoRenderChainConfigure.getApplyType(), mediaModel, buildAutomaticTemplate, null);
        if (buildComposition == null) {
            Logger.e(TAG, "build composition failed.");
            if (mediaBuilderListener != null) {
                mediaBuilderListener.buildCompleted(-201, null, null);
                return;
            }
            return;
        }
        final AutomaticMediaTemplateModel automaticMediaTemplateModel = mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
        final boolean isSwitchToTemplateByUser = automaticMediaTemplateModel.isSwitchToTemplateByUser();
        VideoRenderChainManager videoRenderChainManager = new VideoRenderChainManager(videoRenderChainConfigure.getApplyType(), buildComposition, mediaModel, iStickerContextInterface, new VideoRenderChainManager.IEffectNodeInterface() { // from class: com.tencent.qcircle.weseevideo.model.template.auto.AutoTemplateMediaBuilder.1
            @Override // com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IEffectNodeInterface
            public void insertEffectNode(VideoRenderChainManager videoRenderChainManager2, MediaEffectModel mediaEffectModel) {
                ArrayList arrayList = new ArrayList();
                List<TAVSticker> transitionStickers = TAVAutomaticTemplate.this.getTransitionStickers();
                if (!CollectionUtil.isEmptyList(transitionStickers)) {
                    for (TAVSticker tAVSticker : transitionStickers) {
                        if (tAVSticker != null) {
                            tAVSticker.setLayerIndex(-100);
                        }
                    }
                    arrayList.addAll(transitionStickers);
                }
                List<TAVSticker> filterStickers = TAVAutomaticTemplate.this.getFilterStickers();
                if (!CollectionUtil.isEmptyList(filterStickers)) {
                    if ("1".equals(mediaEffectModel.getParam(Constants.FRAME_PARAMS_KEY_IS_ON)) && automaticMediaTemplateModel.getAEFrameModel() != null) {
                        int pagFillMode = automaticMediaTemplateModel.getAEFrameModel().getPagFillMode();
                        for (TAVSticker tAVSticker2 : filterStickers) {
                            if (pagFillMode == 1) {
                                tAVSticker2.setScaleMode(1);
                            } else {
                                tAVSticker2.setScaleMode(0);
                                TAVAutomaticTemplate.this.setRenderSize(AutoTemplateMediaBuilder.getTAVStickerFrameRenderSize(tAVSticker2));
                            }
                        }
                    }
                    arrayList.addAll(filterStickers);
                }
                if (!CollectionUtil.isEmptyList(arrayList)) {
                    TAVStickerRenderContext pagChainRenderContext = videoRenderChainManager2.getPagChainRenderContext();
                    arrayList.addAll(pagChainRenderContext.getStickers());
                    if (pagChainRenderContext instanceof TAVAutomaticRenderContext) {
                        ((TAVAutomaticRenderContext) pagChainRenderContext).setEffectStickers(arrayList);
                    }
                }
                List<TAVSticker> overlayStickers = TAVAutomaticTemplate.this.getOverlayStickers();
                if (!CollectionUtil.isEmptyList(overlayStickers)) {
                    TAVStickerRenderContext stickerRenderContext = videoRenderChainManager2.getStickerRenderContext();
                    overlayStickers.addAll(stickerRenderContext.getStickers());
                    stickerRenderContext.reloadStickers(overlayStickers);
                }
                AutoTemplateMediaBuilder.updateLutModel(mediaEffectModel, TAVAutomaticTemplate.this, isSwitchToTemplateByUser, videoRenderChainManager2.getComposition().getDuration());
                mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().setSwitchToTemplateByUser(false);
            }
        }, videoRenderChainConfigure);
        if (mediaBuilderListener != null) {
            MediaBuilderOutput mediaBuilderOutput = new MediaBuilderOutput();
            mediaBuilderOutput.setAutomaticTemplate(buildAutomaticTemplate);
            mediaBuilderListener.buildCompleted(0, videoRenderChainManager, mediaBuilderOutput);
        }
    }

    private static TAVAutomaticTemplate buildAutomaticTemplate(Context context, MediaModel mediaModel, CGSize cGSize) {
        TAVAutomaticTemplate tAVAutomaticTemplate;
        if (mediaModel == null) {
            return null;
        }
        AutomaticMediaTemplateModel automaticMediaTemplateModel = mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
        if (!TextUtils.isEmpty(automaticMediaTemplateModel.getTemplateDir())) {
            tAVAutomaticTemplate = TAVAutomaticTemplateParse.parseAutomaticTemplate(context, automaticMediaTemplateModel.getTemplateDir(), automaticMediaTemplateModel.getTemplateFileName());
        } else {
            tAVAutomaticTemplate = null;
        }
        if (tAVAutomaticTemplate != null) {
            tAVAutomaticTemplate.setImagePagAssetDir(automaticMediaTemplateModel.getImagePagAssetDir());
            ModelExtKt.selectNearRatioPagFile(tAVAutomaticTemplate, automaticMediaTemplateModel, mediaModel);
            AEFrameModel aEFrameModel = automaticMediaTemplateModel.getAEFrameModel();
            if (aEFrameModel != null && aEFrameModel.getPagItems().size() > 0) {
                String pagName = aEFrameModel.getPagItems().get(0).getPagName();
                if (!aEFrameModel.getSelectedPAGName().isEmpty()) {
                    pagName = aEFrameModel.getSelectedPAGName();
                }
                if (PagViewMonitor.Load(automaticMediaTemplateModel.getTemplateDir() + "/" + pagName) != null && !automaticMediaTemplateModel.getTemplateDir().equals(TAVCut.getPlaceHolderTemplatePath()) && !automaticMediaTemplateModel.getAEFrameModel().getIsEmptyFrame()) {
                    float width = r2.width() / r2.height();
                    float f16 = cGSize.width;
                    float f17 = cGSize.height;
                    if (width > f16 / f17) {
                        cGSize.height = f16 / width;
                    } else {
                        cGSize.width = f17 * width;
                    }
                }
            }
            tAVAutomaticTemplate.setRenderSize(cGSize);
            MusicModel musicModel = mediaModel.getMediaEffectModel().getMusicModel();
            tAVAutomaticTemplate.setBgmVolume(musicModel.getBgmVolume());
            tAVAutomaticTemplate.setVolume(Utils.getPlayVolume(musicModel));
            MusicMaterialMetaDataBean metaDataBean = musicModel.getMetaDataBean();
            if (metaDataBean != null && FileUtils.exists(metaDataBean.path)) {
                String path = Utils.getPath(metaDataBean);
                boolean exists = FileUtils.exists(path);
                Logger.i(TAG, "build template, isRhythmMusic: " + metaDataBean.isStuckPoint + ", isRhythmFileExist: " + exists + ", muiscId: " + metaDataBean.id);
                if ((tAVAutomaticTemplate instanceof TAVRhythmAutomaticTemplate) && metaDataBean.isStuckPoint && exists) {
                    TAVRhythmAutomaticTemplate tAVRhythmAutomaticTemplate = (TAVRhythmAutomaticTemplate) tAVAutomaticTemplate;
                    tAVRhythmAutomaticTemplate.parseMusicRhythm(null, path, musicModel.getMetaDataBean().path, musicModel.getMetaDataBean().startTime, mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getRhythmSecondEffectIndices(), automaticMediaTemplateModel.getRandomIndex());
                    tAVRhythmAutomaticTemplate.setTransitionEffects(mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getTransitionEffects());
                } else {
                    tAVAutomaticTemplate.configMusic(null, musicModel.getMetaDataBean().path, musicModel.getMetaDataBean().startTime);
                }
            }
        }
        return tAVAutomaticTemplate;
    }

    private static TAVComposition buildComposition(int i3, @NonNull MediaModel mediaModel, @NonNull TAVAutomaticTemplate tAVAutomaticTemplate, ITAVCompositionBuilderInterface iTAVCompositionBuilderInterface) {
        if (mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().isContainSegments()) {
            return buildCompositionFromSegment(i3, mediaModel, tAVAutomaticTemplate, iTAVCompositionBuilderInterface);
        }
        return buildCompositionFromResource(i3, mediaModel, tAVAutomaticTemplate, iTAVCompositionBuilderInterface);
    }

    private static TAVComposition buildCompositionFromResource(int i3, @NonNull MediaModel mediaModel, @NonNull TAVAutomaticTemplate tAVAutomaticTemplate, ITAVCompositionBuilderInterface iTAVCompositionBuilderInterface) {
        TAVMovieResource tAVMovieTrackResource;
        if (mediaModel.getMediaResourceModel() == null) {
            Logger.e(TAG, "this MediaResourceModel is empty.");
            return null;
        }
        List<MediaClipModel> videos = mediaModel.getMediaResourceModel().getVideos();
        if (videos != null && videos.size() != 0) {
            if (iTAVCompositionBuilderInterface != null) {
                return iTAVCompositionBuilderInterface.buildComposition(videos);
            }
            boolean isRhythmTemplate = tAVAutomaticTemplate.isRhythmTemplate();
            ArrayList arrayList = new ArrayList();
            for (MediaClipModel mediaClipModel : videos) {
                if (mediaClipModel.getResource().getSelectTimeDuration() != 0 && mediaClipModel.getResource() != null) {
                    if (mediaClipModel.getResource().getType() != 1 && mediaClipModel.getResource().getType() != 3) {
                        if (mediaClipModel.getResource().getType() != 2 && mediaClipModel.getResource().getType() != 4) {
                            tAVMovieTrackResource = null;
                        } else {
                            tAVMovieTrackResource = new TAVMovieImageResource(mediaClipModel.getResource().getPath());
                            tAVMovieTrackResource.setTimeRange(new CMTimeRange(new CMTime(((float) (mediaClipModel.getResource().getSourceTimeStart() + mediaClipModel.getResource().getSelectTimeStart())) / 1000.0f), new CMTime(((float) mediaClipModel.getResource().getSelectTimeDuration()) / 1000.0f)));
                            tAVMovieTrackResource.setSourceTimeRange(tAVMovieTrackResource.getTimeRange());
                            tAVMovieTrackResource.setDuration(tAVMovieTrackResource.getTimeRange().getDuration());
                            tAVMovieTrackResource.setType(TAVMovieResource.TAVResourceType.TAVResourceTypePhoto);
                            if (!isRhythmTemplate) {
                                TAVMovieTimeEffect tAVMovieTimeEffect = new TAVMovieTimeEffect();
                                tAVMovieTimeEffect.setTimeRange(tAVMovieTrackResource.getTimeRange());
                                tAVMovieTimeEffect.setSpeed((((float) mediaClipModel.getResource().getSelectTimeDuration()) * 1.0f) / ((float) mediaClipModel.getResource().getScaleDuration()));
                                tAVMovieTrackResource.setTimeEffect(tAVMovieTimeEffect);
                            }
                        }
                    } else {
                        tAVMovieTrackResource = new TAVMovieTrackResource(mediaClipModel.getResource().getPath());
                        tAVMovieTrackResource.setTimeRange(new CMTimeRange(new CMTime(((float) (mediaClipModel.getResource().getSourceTimeStart() + mediaClipModel.getResource().getSelectTimeStart())) / 1000.0f), new CMTime(((float) mediaClipModel.getResource().getSelectTimeDuration()) / 1000.0f)));
                        tAVMovieTrackResource.setSourceTimeRange(tAVMovieTrackResource.getTimeRange());
                        tAVMovieTrackResource.setDuration(tAVMovieTrackResource.getTimeRange().getDuration());
                        if (mediaClipModel.getResource().getType() == 1) {
                            tAVMovieTrackResource.setType(TAVMovieResource.TAVResourceType.TAVResourceTypeVideo);
                        } else if (mediaClipModel.getResource().getType() == 3) {
                            tAVMovieTrackResource.setType(TAVMovieResource.TAVResourceType.TAVResourceTypeAudio);
                        }
                        if (!isRhythmTemplate) {
                            TAVMovieTimeEffect tAVMovieTimeEffect2 = new TAVMovieTimeEffect();
                            tAVMovieTimeEffect2.setTimeRange(tAVMovieTrackResource.getTimeRange());
                            tAVMovieTimeEffect2.setSpeed((((float) mediaClipModel.getResource().getSelectTimeDuration()) * 1.0f) / ((float) mediaClipModel.getResource().getScaleDuration()));
                            tAVMovieTrackResource.setTimeEffect(tAVMovieTimeEffect2);
                        }
                    }
                    if (tAVMovieTrackResource != null) {
                        TAVMovieClip tAVMovieClip = new TAVMovieClip();
                        tAVMovieClip.setResource(tAVMovieTrackResource);
                        if (mediaClipModel.getVideoConfigurationModel() != null) {
                            tAVMovieClip.setVideoConfiguration(ModelAdaptUtils.transformToTAVVideoConfiguration(mediaClipModel.getVideoConfigurationModel()));
                        }
                        if (mediaClipModel.getAudioConfigurationModel() != null) {
                            tAVMovieClip.setAudioConfiguration(ModelAdaptUtils.transformToTAVAudioConfiguration(mediaClipModel.getAudioConfigurationModel()));
                        }
                        arrayList.add(tAVMovieClip);
                    }
                }
            }
            if (arrayList.size() == 0) {
                Logger.e(TAG, "this TAVMovieClip list is empty.");
                return null;
            }
            TAVMovie tAVMovie = new TAVMovie();
            tAVMovie.setClips(arrayList);
            TAVComposition buildBaseComposition = tAVAutomaticTemplate.buildBaseComposition(tAVMovie);
            if (tAVAutomaticTemplate.getMusicResource() != null) {
                if (buildBaseComposition.getAudioChannels() != null && buildBaseComposition.getAudioChannels().get(0).size() > 0) {
                    for (TAVTransitionableAudio tAVTransitionableAudio : buildBaseComposition.getAudioChannels().get(0)) {
                        if (tAVTransitionableAudio instanceof TAVClip) {
                            tAVTransitionableAudio.getAudioConfiguration().setVolume(Utils.getPlayVolume(mediaModel.getMediaEffectModel().getMusicModel()));
                        }
                    }
                }
                if (mediaModel.getMediaEffectModel().getMusicModel().getBgmVolume() >= 0.0f) {
                    buildBaseComposition.setAudios(MediaBuilder.getAudioClips(buildBaseComposition, mediaModel));
                }
            }
            return buildBaseComposition;
        }
        Logger.e(TAG, "this MediaResourceModel's videos is empty.");
        return null;
    }

    private static TAVComposition buildCompositionFromSegment(int i3, @NonNull MediaModel mediaModel, @NonNull TAVAutomaticTemplate tAVAutomaticTemplate, ITAVCompositionBuilderInterface iTAVCompositionBuilderInterface) {
        if (mediaModel.getMediaResourceModel() == null) {
            Logger.e(TAG, "this MediaResourceModel is empty.");
            return null;
        }
        List<MediaClipModel> videos = mediaModel.getMediaResourceModel().getVideos();
        if (videos != null && videos.size() != 0) {
            if (iTAVCompositionBuilderInterface == null) {
                return null;
            }
            return iTAVCompositionBuilderInterface.buildComposition(videos);
        }
        Logger.e(TAG, "this MediaResourceModel's videos is empty.");
        return null;
    }

    private static List<TAVMovieClip> buildMovieClipsFromSegmentModel(@NonNull MediaModel mediaModel) {
        TAVMovieClip generateMovieClip;
        List<MovieSegmentModel> rhythmSegmentModels = mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getRhythmSegmentModels();
        ArrayList<VideoResourceModel> arrayList = new ArrayList();
        for (MovieSegmentModel movieSegmentModel : rhythmSegmentModels) {
            if (movieSegmentModel != null && !movieSegmentModel.getVideoResourceModels().isEmpty()) {
                arrayList.addAll(movieSegmentModel.getVideoResourceModels());
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (VideoResourceModel videoResourceModel : arrayList) {
            if (videoResourceModel != null && (generateMovieClip = generateMovieClip(videoResourceModel)) != null) {
                TAVMovieAudioConfiguration tAVMovieAudioConfiguration = new TAVMovieAudioConfiguration();
                tAVMovieAudioConfiguration.setVolume(Utils.getPlayVolume(mediaModel.getMediaEffectModel().getMusicModel()));
                generateMovieClip.setAudioConfiguration(tAVMovieAudioConfiguration);
                arrayList2.add(generateMovieClip);
            }
        }
        return arrayList2;
    }

    private static List<TAVRhythmMovieSegment> buildRhythmSegmentFromSegmentModel(@NonNull MediaModel mediaModel) {
        List<MovieSegmentModel> rhythmSegmentModels = mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getRhythmSegmentModels();
        ArrayList arrayList = new ArrayList();
        for (MovieSegmentModel movieSegmentModel : rhythmSegmentModels) {
            TAVRhythmMovieSegment tAVRhythmMovieSegment = new TAVRhythmMovieSegment();
            tAVRhythmMovieSegment.setTimeRange(movieSegmentModel.getTimeRange());
            arrayList.add(tAVRhythmMovieSegment);
        }
        return arrayList;
    }

    private static TAVMovieClip generateMovieClip(@NonNull VideoResourceModel videoResourceModel) {
        TAVMovieResource tAVMovieResource;
        int type = videoResourceModel.getType();
        if (type == 1) {
            tAVMovieResource = new TAVMovieTrackResource(videoResourceModel.getPath());
            tAVMovieResource.setType(TAVMovieResource.TAVResourceType.TAVResourceTypeVideo);
        } else if (type == 2) {
            tAVMovieResource = new TAVMovieImageResource(videoResourceModel.getPath());
            tAVMovieResource.setType(TAVMovieResource.TAVResourceType.TAVResourceTypePhoto);
        } else {
            tAVMovieResource = null;
        }
        if (tAVMovieResource == null) {
            return null;
        }
        TAVMovieClip tAVMovieClip = new TAVMovieClip();
        tAVMovieResource.setTimeRange(new CMTimeRange(new CMTime(videoResourceModel.getSourceTimeStartUs() + videoResourceModel.getSelectTimeStartUs(), 1000000), new CMTime(videoResourceModel.getSelectTimeDurationUs(), 1000000)));
        tAVMovieResource.setSourceTimeRange(new CMTimeRange(new CMTime(videoResourceModel.getSourceTimeStartUs(), 1000000), new CMTime(videoResourceModel.getSourceTimeDurationUs(), 1000000)));
        tAVMovieResource.setDuration(tAVMovieResource.getSourceTimeRange().getDuration());
        tAVMovieClip.setResource(tAVMovieResource);
        return tAVMovieClip;
    }

    private static List<TAVMovieTimeEffect> getSpeedTimeEffect(float f16, CMTimeRange cMTimeRange) {
        ArrayList arrayList = new ArrayList();
        TAVMovieTimeEffect tAVMovieTimeEffect = new TAVMovieTimeEffect();
        tAVMovieTimeEffect.setSourceTimeRange(cMTimeRange);
        tAVMovieTimeEffect.setTimeRange(cMTimeRange);
        tAVMovieTimeEffect.setLoop(1);
        tAVMovieTimeEffect.setSpeed(f16);
        arrayList.add(tAVMovieTimeEffect);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CGSize getTAVStickerFrameRenderSize(TAVSticker tAVSticker) {
        PAGLayer pAGLayer;
        PAGRenderer pAGRenderer = new PAGRenderer();
        pAGRenderer.setFile(tAVSticker.getPagFile());
        PAGLayer[] layersByName = pAGRenderer.getRootComposition().getLayersByName("mid_photo");
        if (layersByName != null && layersByName.length > 0) {
            pAGLayer = layersByName[0];
        } else {
            pAGLayer = null;
        }
        if (pAGLayer == null) {
            pAGLayer = pAGRenderer.getRootComposition().getLayerAt(0);
        }
        if (pAGLayer == null) {
            return null;
        }
        return new CGSize(pAGLayer.getBounds().width(), pAGLayer.getBounds().height());
    }

    public static long multiClipsAdjustTimeRange(List<TAVMovieClip> list, VideoResourceModel videoResourceModel, TAVMovieClip tAVMovieClip, float f16, long j3, long j16, long j17) {
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
                tAVMovieClip.getResource().setTimeRange(new CMTimeRange(new CMTime((((float) ((videoResourceModel.getSourceTimeStart() + videoResourceModel.getSelectTimeStart()) * 1000)) + (((float) j19) * f17)) / 1000000.0f), new CMTime(j27, 1000000).multi(f17)));
                list.add(tAVMovieClip);
            }
            j18 = j3 + selectTimeDuration;
            j26 = selectTimeDuration;
        } else if (videoResourceModel.getType() == 2) {
            long selectTimeDuration2 = ((float) (videoResourceModel.getSelectTimeDuration() * 1000)) / f17;
            long j28 = selectTimeDuration2 - j19;
            if (j28 > 0 && j3 < j17) {
                if (j3 + selectTimeDuration2 >= j17) {
                    j28 = (j17 - j3) - j19;
                }
                tAVMovieClip.getResource().setTimeRange(new CMTimeRange(CMTime.CMTimeZero, new CMTime(j28, 1000000).multi(f17)));
                list.add(tAVMovieClip);
            }
            j18 = j3 + selectTimeDuration2;
            j26 = selectTimeDuration2;
        } else {
            j18 = j3;
        }
        Logger.e(TAG, "multiClipsAdjustTimeRange: rangeStartUs-" + j16 + ", rangeEndUs-" + j17 + ", speed-" + f17 + ", itemScaleUs-" + j26);
        return j18;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateLutModel(@NonNull MediaEffectModel mediaEffectModel, @NonNull TAVAutomaticTemplate tAVAutomaticTemplate, boolean z16, CMTime cMTime) {
        BeautyModel beautyModel;
        TAVEffectParameter tAVEffectParameter;
        LutModel lutModel = mediaEffectModel.getLutModel();
        TAVLUTAutomaticEffect lutEffect = tAVAutomaticTemplate.getLutEffect();
        String str = null;
        if (lutEffect != null) {
            if (!TextUtils.isEmpty(lutEffect.fileDir) && (tAVEffectParameter = lutEffect.parameter) != null && !TextUtils.isEmpty(tAVEffectParameter.filePath)) {
                str = lutEffect.fileDir + File.separator + lutEffect.parameter.filePath;
            }
            if (!TextUtils.isEmpty(str)) {
                CMTimeRange lutTimeRange = lutEffect.getLutTimeRange((float) (cMTime.getTimeUs() / 1000));
                if (lutModel == null) {
                    lutModel = new LutModel();
                    mediaEffectModel.setLutModel(lutModel);
                }
                lutModel.setLutBitmap(str);
                lutModel.setLutStartTime(lutTimeRange.getStartUs() / 1000);
                lutModel.setLutDuration(lutTimeRange.getDurationUs() / 1000);
                if (z16 && (beautyModel = mediaEffectModel.getBeautyModel()) != null) {
                    beautyModel.clearFilter();
                    return;
                }
                return;
            }
            return;
        }
        mediaEffectModel.setLutModel(null);
    }
}
