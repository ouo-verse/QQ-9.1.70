package com.tencent.qcircle.weseevideo.model.template.movie;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.MusicModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import com.tencent.qcircle.weseevideo.model.utils.FileUtils;
import com.tencent.qcircle.weseevideo.model.utils.Utils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavmovie.TAVMovie;
import com.tencent.tavmovie.base.TAVMovieAudioConfiguration;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieVideoConfiguration;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MovieTemplateMediaBuilder {
    public static final String TAG = "MovieTemplateMediaBuilder";

    public static void build(@NonNull MediaModel mediaModel, VideoRenderChainManager.IStickerContextInterface iStickerContextInterface, @NonNull MediaBuilderListener mediaBuilderListener, VideoRenderChainConfigure videoRenderChainConfigure) {
        MovieMediaTemplateModel movieMediaTemplateModel = mediaModel.getMediaTemplateModel().getMovieMediaTemplateModel();
        if (movieMediaTemplateModel.isEmpty()) {
            mediaBuilderListener.buildCompleted(-303, null, null);
            Logger.e(TAG, "MovieMediaTemplateModel is empty.");
        }
        String filePathBySuffix = FileUtils.getFilePathBySuffix(movieMediaTemplateModel.getFilePath(), ".pag");
        if (TextUtils.isEmpty(filePathBySuffix) || !FileUtils.exists(filePathBySuffix)) {
            mediaBuilderListener.buildCompleted(-300, null, null);
            Logger.e(TAG, "templatePAGPath is null or template file is not exist");
        }
        MovieTemplate movieTemplate = new MovieTemplate(filePathBySuffix, movieMediaTemplateModel.isAsset());
        TAVComposition buildCompositionAsync = buildCompositionAsync(mediaModel, movieTemplate);
        if (buildCompositionAsync == null) {
            mediaBuilderListener.buildCompleted(-301, null, null);
            return;
        }
        VideoRenderChainManager createVideoRenderChainManager = createVideoRenderChainManager(videoRenderChainConfigure.getApplyType(), buildCompositionAsync, mediaModel, iStickerContextInterface, videoRenderChainConfigure, movieTemplate);
        MediaBuilderOutput mediaBuilderOutput = new MediaBuilderOutput();
        mediaBuilderOutput.setMovieTemplate(movieTemplate);
        mediaBuilderListener.buildCompleted(0, createVideoRenderChainManager, mediaBuilderOutput);
    }

    private static TAVComposition buildCompositionAsync(@NonNull MediaModel mediaModel, @NonNull MovieTemplate movieTemplate) {
        List<TAVMovieClip> clipsFromSource;
        TAVClip convertToClip;
        if (CollectionUtil.isEmptyList(movieTemplate.getSegments())) {
            Logger.e(TAG, "MovieTemplate segments is empty.");
            return null;
        }
        if (mediaModel.getMediaTemplateModel().getMovieMediaTemplateModel().isContainSegments()) {
            clipsFromSource = getClipsFromDraft(mediaModel);
            movieTemplate.setFirstFill(false);
        } else {
            clipsFromSource = getClipsFromSource(mediaModel, movieTemplate);
            movieTemplate.setFirstFill(true);
        }
        if (CollectionUtil.isEmptyList(clipsFromSource)) {
            Logger.e(TAG, "MediaResourceModel build MovieClips is empty.");
            return null;
        }
        TAVMovie tAVMovie = new TAVMovie();
        tAVMovie.setClips(clipsFromSource);
        tAVMovie.setMovieTemplate(movieTemplate);
        tAVMovie.setRenderSize(movieTemplate.getRenderSize());
        TAVMovieClip generateBGMClip = generateBGMClip(mediaModel, movieTemplate);
        TAVComposition convertToComposition = tAVMovie.convertToComposition();
        if (generateBGMClip != null && (convertToClip = generateBGMClip.convertToClip()) != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(convertToClip);
            convertToComposition.setAudios(arrayList);
        }
        return convertToComposition;
    }

    private static VideoRenderChainManager createVideoRenderChainManager(int i3, @NonNull TAVComposition tAVComposition, @NonNull MediaModel mediaModel, VideoRenderChainManager.IStickerContextInterface iStickerContextInterface, VideoRenderChainConfigure videoRenderChainConfigure, final MovieTemplate movieTemplate) {
        return new VideoRenderChainManager(i3, tAVComposition, mediaModel, iStickerContextInterface, new VideoRenderChainManager.IEffectNodeInterface() { // from class: com.tencent.qcircle.weseevideo.model.template.movie.MovieTemplateMediaBuilder.1
            @Override // com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IEffectNodeInterface
            public void insertEffectNode(VideoRenderChainManager videoRenderChainManager, MediaEffectModel mediaEffectModel) {
                TAVMovieSticker templateSticker;
                MovieTemplate movieTemplate2 = MovieTemplate.this;
                if (movieTemplate2 != null && (templateSticker = movieTemplate2.getTemplateSticker()) != null && templateSticker.getSticker() != null) {
                    TAVSticker sticker = templateSticker.getSticker();
                    sticker.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, videoRenderChainManager.getComposition().getDuration()));
                    sticker.setLayerIndex(-98);
                    videoRenderChainManager.updateMovieTemplateEffect(sticker);
                }
            }
        }, videoRenderChainConfigure);
    }

    @Nullable
    private static TAVMovieClip generateBGMClip(@NonNull MediaModel mediaModel, @NonNull MovieTemplate movieTemplate) {
        movieTemplate.getBackgroundMusic();
        MusicModel musicModel = mediaModel.getMediaEffectModel().getMusicModel();
        MusicMaterialMetaDataBean metaDataBean = musicModel.getMetaDataBean();
        if (metaDataBean == null) {
            return null;
        }
        String str = metaDataBean.path;
        if (TextUtils.isEmpty(str) || !FileUtils.exists(str)) {
            return null;
        }
        TAVMovieClip tAVMovieClip = new TAVMovieClip();
        TAVMovieTrackResource tAVMovieTrackResource = new TAVMovieTrackResource(str);
        tAVMovieTrackResource.setType(TAVMovieResource.TAVResourceType.TAVResourceTypeAudio);
        CMTimeRange timeRange = tAVMovieTrackResource.getTimeRange();
        CMTime cMTime = new CMTime(metaDataBean.startTime / 1000.0f);
        CMTime sub = timeRange.getDuration().sub(cMTime);
        timeRange.setStart(cMTime);
        timeRange.setDuration(sub);
        tAVMovieTrackResource.setTimeRange(timeRange);
        tAVMovieClip.setResource(tAVMovieTrackResource);
        TAVMovieAudioConfiguration tAVMovieAudioConfiguration = new TAVMovieAudioConfiguration();
        tAVMovieAudioConfiguration.setVolume(musicModel.getBgmVolume());
        tAVMovieClip.setAudioConfiguration(tAVMovieAudioConfiguration);
        return tAVMovieClip;
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
        tAVMovieClip.getVideoConfiguration().setPreferRotation(videoResourceModel.getRotate());
        return tAVMovieClip;
    }

    private static List<TAVMovieClip> getClipsFromDraft(@NonNull MediaModel mediaModel) {
        TAVMovieClip generateMovieClip;
        ArrayList<MovieSegmentModel> movieSegmentModels = mediaModel.getMediaTemplateModel().getMovieMediaTemplateModel().getMovieSegmentModels();
        ArrayList<VideoResourceModel> arrayList = new ArrayList();
        Iterator<MovieSegmentModel> it = movieSegmentModels.iterator();
        while (it.hasNext()) {
            MovieSegmentModel next = it.next();
            if (next != null && !next.getVideoResourceModels().isEmpty()) {
                arrayList.addAll(next.getVideoResourceModels());
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

    private static List<TAVMovieClip> getClipsFromSource(@NonNull MediaModel mediaModel, @NonNull MovieTemplate movieTemplate) {
        List<MediaClipModel> afterAiProcessClips;
        AIAbilityModel aiAbilityModel = mediaModel.getMediaTemplateModel().getMovieMediaTemplateModel().getAiAbilityModel();
        MediaResourceModel mediaResourceModel = mediaModel.getMediaResourceModel();
        if (aiAbilityModel.getAiAbilityType() == AIAbilityModel.AIAbilityType.ORDINARY) {
            afterAiProcessClips = mediaResourceModel.getVideos();
        } else {
            afterAiProcessClips = aiAbilityModel.getAfterAiProcessClips();
        }
        if (CollectionUtil.isEmptyList(afterAiProcessClips)) {
            Logger.e(TAG, "MediaResourceModel videos is empty.");
            return null;
        }
        int size = movieTemplate.getSegments().size();
        ArrayList arrayList = new ArrayList();
        Iterator<MediaClipModel> it = afterAiProcessClips.iterator();
        int i3 = 0;
        boolean z16 = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MediaClipModel next = it.next();
            if (next != null) {
                TAVMovieClip tAVMovieClip = new TAVMovieClip();
                if (next.getResource().getType() == 1) {
                    TAVMovieTrackResource tAVMovieTrackResource = new TAVMovieTrackResource(next.getResource().getPath());
                    tAVMovieTrackResource.setType(TAVMovieResource.TAVResourceType.TAVResourceTypeVideo);
                    CMTimeRange cMTimeRange = new CMTimeRange(new CMTime(next.getResource().getSourceTimeStart(), 1000000), new CMTime(TimeUtil.milli2Us(next.getResource().getSourceTimeDuration()), 1000000));
                    CMTimeRange m260clone = cMTimeRange.m260clone();
                    m260clone.setStart(new CMTime(TimeUtil.milli2Us(next.getResource().getSourceTimeStart() + next.getResource().getSelectTimeStart()), 1000000));
                    m260clone.setDuration(new CMTime(TimeUtil.milli2Us(next.getResource().getSelectTimeDuration()), 1000000));
                    tAVMovieTrackResource.setTimeRange(m260clone);
                    tAVMovieTrackResource.setSourceTimeRange(cMTimeRange);
                    tAVMovieTrackResource.setDuration(tAVMovieTrackResource.getSourceTimeRange().getDuration());
                    tAVMovieClip.setResource(tAVMovieTrackResource);
                    z16 = false;
                } else if (next.getResource().getType() == 2) {
                    TAVMovieImageResource tAVMovieImageResource = new TAVMovieImageResource(next.getResource().getPath());
                    CMTime cMTime = new CMTime(600000000L, 60);
                    tAVMovieImageResource.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, cMTime));
                    tAVMovieImageResource.setSourceTimeRange(tAVMovieImageResource.getTimeRange());
                    tAVMovieImageResource.setDuration(cMTime);
                    tAVMovieImageResource.setType(TAVMovieResource.TAVResourceType.TAVResourceTypePhoto);
                    tAVMovieClip.setResource(tAVMovieImageResource);
                    i3++;
                    if (i3 > size && z16) {
                        Logger.d(TAG, "fillData: imageCount " + i3);
                        break;
                    }
                }
                TAVMovieVideoConfiguration tAVMovieVideoConfiguration = new TAVMovieVideoConfiguration();
                tAVMovieVideoConfiguration.setPreferRotation(next.getVideoConfigurationModel().getRotate());
                tAVMovieClip.setVideoConfiguration(tAVMovieVideoConfiguration);
                TAVMovieAudioConfiguration tAVMovieAudioConfiguration = new TAVMovieAudioConfiguration();
                tAVMovieAudioConfiguration.setVolume(Utils.getPlayVolume(mediaModel.getMediaEffectModel().getMusicModel()));
                tAVMovieClip.setAudioConfiguration(tAVMovieAudioConfiguration);
                arrayList.add(tAVMovieClip);
            }
        }
        return arrayList;
    }
}
