package com.tencent.qcircle.tavcut.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.TextureView;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.bean.ResInfoModel;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.cover.VideoImageExtractor;
import com.tencent.qcircle.tavcut.exporter.VideoExportConfig;
import com.tencent.qcircle.tavcut.exporter.VideoExporter;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.callback.FrameExtractCallback;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.util.VideoUtil;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderFactory;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.composition.effectnode.CropEffectNode;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.qcircle.weseevideo.editor.sticker.utils.StickerConverter;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qcircle.weseevideo.model.WSTemplateManager;
import com.tencent.qcircle.weseevideo.model.data.MusicData;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.qcircle.weseevideo.model.effect.MusicModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.light.LightMediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.utils.AudioUtils;
import com.tencent.qcircle.weseevideo.model.utils.MusicMaterialMataDataBeanUtils;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.light.AudioPlaceHolder;
import org.light.LightAsset;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TAVCutVideoSession extends TAVCutSession implements MoviePlayer.onVideoProgressListener {
    private TAVComposition coverTavComposition;
    private MediaBuilderOutput mediaBuilderOutput;
    protected TAVCutVideoView tavCutVideoView;
    private String videoPath;
    private List<MoviePlayer> players = new ArrayList();
    private boolean preIsPlaying = false;
    private long maxDuration = 60000;
    private VideoImageExtractor videoImageExtractor = null;

    private void addBaseMediaModel() {
        MediaModel mediaModel = new MediaModel();
        ArrayList arrayList = new ArrayList();
        MediaClipModel mediaClipModel = new MediaClipModel();
        VideoResourceModel videoResourceModel = new VideoResourceModel();
        videoResourceModel.setPath(this.videoPath);
        videoResourceModel.setType(1);
        long duration = DecoderUtils.getDuration(this.videoPath);
        videoResourceModel.setSourceTimeDurationUs(duration);
        videoResourceModel.setSelectTimeDurationUs(duration);
        SessionConfig sessionConfig = this.sessionConfig;
        if (sessionConfig != null && sessionConfig.getVideoInitCropConfig() != null) {
            CropConfig videoInitCropConfig = this.sessionConfig.getVideoInitCropConfig();
            CropModel cropModel = new CropModel();
            cropModel.setCropConfig(videoInitCropConfig);
            mediaModel.getMediaEffectModel().setCropModel(cropModel);
        }
        Size videoSize = VideoUtil.getVideoSize(this.videoPath);
        videoResourceModel.setWidth(videoSize.getWidth());
        videoResourceModel.setHeight(videoSize.getHeight());
        videoResourceModel.setRotate(0);
        mediaClipModel.setResource(videoResourceModel);
        VideoConfigurationModel videoConfigurationModel = new VideoConfigurationModel();
        videoConfigurationModel.setRotate(0);
        SessionConfig sessionConfig2 = this.sessionConfig;
        if (sessionConfig2 != null && sessionConfig2.getContentMode() != null) {
            videoConfigurationModel.setContentMode(this.sessionConfig.getContentMode().ordinal());
        }
        mediaClipModel.setVideoConfigurationModel(videoConfigurationModel);
        arrayList.add(mediaClipModel);
        MediaResourceModel mediaResourceModel = mediaModel.getMediaResourceModel();
        mediaResourceModel.setVideos(arrayList);
        mediaModel.setMediaResourceModel(mediaResourceModel);
        this.mediaModels.add(mediaModel);
    }

    private boolean correctMediaResourceIgnoreSpeedInner(long j3) {
        if (getMediaModel() == null || getMediaModel().getMediaResourceModel().getVideos().size() < 1) {
            return false;
        }
        List<MediaClipModel> videos = getMediaModel().getMediaResourceModel().getVideos();
        for (int i3 = 0; i3 < videos.size(); i3++) {
            MediaClipModel mediaClipModel = videos.get(i3);
            if (mediaClipModel != null) {
                mediaClipModel.getResource().setScaleDuration(mediaClipModel.getResource().getSelectTimeDuration());
            }
        }
        correctMediaResource(j3);
        return true;
    }

    private CropConfig findMultiCutCropByIndex(int i3) {
        MediaModel mediaModel = getMediaModel();
        if (mediaModel != null && i3 < mediaModel.getMediaResourceModel().getVideos().size()) {
            return mediaModel.getMediaResourceModel().getVideos().get(i3).getConfig();
        }
        return new CropConfig(0.0f, 0.0f, 1.0f, 1.0f);
    }

    private CGSize getCroppedMultiCutRenderSize(@NonNull List<MediaClipModel> list) {
        Size croppedSizeByIndex = getCroppedSizeByIndex(list, 0);
        Size multiMaxWidthHeight = getMultiMaxWidthHeight(list, croppedSizeByIndex.getWidth(), croppedSizeByIndex.getHeight());
        return constrainRenderSize(multiMaxWidthHeight.getWidth(), multiMaxWidthHeight.getHeight());
    }

    private Size getCroppedSizeByIndex(List<MediaClipModel> list, int i3) {
        if (list.size() <= i3) {
            return new Size(720, 1080);
        }
        CropConfig findMultiCutCropByIndex = findMultiCutCropByIndex(i3);
        int width = list.get(i3).getResource().getWidth();
        int height = list.get(i3).getResource().getHeight();
        if (findMultiCutCropByIndex == null) {
            return new Size(width, height);
        }
        return new Size(Math.round(width * findMultiCutCropByIndex.getWidth()), Math.round(height * findMultiCutCropByIndex.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CGSize getMultiCutRenderSize(VideoRenderChainManager videoRenderChainManager) {
        if (videoRenderChainManager != null && videoRenderChainManager.getMediaModel() != null && videoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().size() >= 1) {
            return getCroppedMultiCutRenderSize(videoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos());
        }
        return null;
    }

    private Size getMultiMaxWidthHeight(List<MediaClipModel> list, int i3, int i16) {
        if (list == null) {
            return new Size(i3, i16);
        }
        if (this.sessionConfig.getNoTempleSupportNineSize() && i3 / i16 > 0) {
            i16 = (i3 * 16) / 9;
        }
        int i17 = 0;
        for (int i18 = 0; i18 < list.size(); i18++) {
            Size croppedSizeByIndex = getCroppedSizeByIndex(list, i18);
            if (croppedSizeByIndex.getWidth() > i17) {
                i17 = croppedSizeByIndex.getWidth();
            }
            if (croppedSizeByIndex.getHeight() > i17) {
                i17 = croppedSizeByIndex.getHeight();
            }
        }
        if (i17 < i16 && i17 < i3) {
            return new Size(i3, i16);
        }
        if (i3 > i16) {
            return new Size(i17, Math.round(((i16 * 1.0f) / i3) * i17));
        }
        return new Size(Math.round(((i3 * 1.0f) / i16) * i17), i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoRenderChainManager getRenderChainManager() {
        SparseArray<VideoRenderChainManager> sparseArray = this.renderChainManagers;
        if (sparseArray != null && sparseArray.size() > 0) {
            return this.renderChainManagers.get(0);
        }
        return null;
    }

    private TAVComposition getTAVComposition() {
        SparseArray<TAVComposition> sparseArray = this.tavCompositions;
        if (sparseArray != null && sparseArray.size() > 0) {
            return this.tavCompositions.get(0);
        }
        return null;
    }

    private void mediaBuild(final StickerController stickerController, VideoRenderChainConfigure videoRenderChainConfigure, final boolean z16, final Runnable runnable) {
        MediaBuilderFactory.mediaBuilderSync(getMediaModel(), this.context, stickerController, videoRenderChainConfigure, new MediaBuilderListener() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.12
            @Override // com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener
            public void buildCompleted(int i3, VideoRenderChainManager videoRenderChainManager, MediaBuilderOutput mediaBuilderOutput) {
                VideoComposition.RenderLayoutMode renderLayoutMode;
                TAVCutVideoView tAVCutVideoView;
                if (videoRenderChainManager != null) {
                    TAVCutVideoSession.this.mediaBuilderOutput = mediaBuilderOutput;
                    CGSize renderSizeCompat = TAVCutVideoSession.this.setRenderSizeCompat(videoRenderChainManager, TAVCutVideoSession.this.getMultiCutRenderSize(videoRenderChainManager));
                    TAVCutVideoSession.this.updateMultiCutCropModel(videoRenderChainManager.getComposition());
                    TAVCutVideoSession.this.renderChainManagers.put(0, videoRenderChainManager);
                    TAVCutVideoSession.this.tavCompositions.put(0, videoRenderChainManager.getComposition());
                    TAVComposition composition = videoRenderChainManager.getComposition();
                    SessionConfig sessionConfig = TAVCutVideoSession.this.sessionConfig;
                    if (sessionConfig != null) {
                        renderLayoutMode = sessionConfig.getRenderLayoutMode();
                    } else {
                        renderLayoutMode = null;
                    }
                    composition.setRenderLayoutMode(renderLayoutMode);
                    if (TAVCutVideoSession.this.getPlayer() != null) {
                        TAVCutVideoSession.this.getPlayer().setPlayRange(new CMTimeRange(CMTime.CMTimeZero, videoRenderChainManager.getComposition().getDuration()));
                        TAVCutVideoSession.this.getPlayer().updateComposition(videoRenderChainManager.getComposition(), z16);
                    }
                    if (stickerController != null && (tAVCutVideoView = TAVCutVideoSession.this.tavCutVideoView) != null) {
                        tAVCutVideoView.adjustStickerContainer(new Size((int) renderSizeCompat.width, (int) renderSizeCompat.height));
                        stickerController.setStickerContainer(TAVCutVideoSession.this.tavCutVideoView.getStickerContainer());
                    }
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }
        }, getMediaModel().getMediaEffectModel().getMusicModel().isChangeMusicByUser());
    }

    private void refreshRenderTemplate() {
        initPlayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CGSize setRenderSizeCompat(VideoRenderChainManager videoRenderChainManager, CGSize cGSize) {
        if (ModelExtKt.isLightTemplate(getMediaModel())) {
            if (videoRenderChainManager.getLightTemplate() != null) {
                LightAsset lightAsset = videoRenderChainManager.getLightTemplate().getLightAsset();
                float max = Math.max(cGSize.width, cGSize.height);
                float width = lightAsset.width() / lightAsset.height();
                if (width > 1.0f) {
                    width = 1.0f / width;
                }
                cGSize = new CGSize(width * max, max);
            } else {
                float max2 = Math.max(cGSize.width, cGSize.height);
                cGSize = new CGSize((9.0f * max2) / 16.0f, max2);
            }
        }
        videoRenderChainManager.getComposition().setRenderSize(cGSize);
        return cGSize;
    }

    private void setVideoChangeConfigureRenderSize(VideoRenderChainConfigure videoRenderChainConfigure) {
        MediaModel mediaModel;
        List<MediaModel> list = this.mediaModels;
        if (list != null && list.size() > 0) {
            mediaModel = this.mediaModels.get(0);
        } else {
            mediaModel = null;
        }
        if (mediaModel == null) {
            return;
        }
        videoRenderChainConfigure.setRenderSize(getCroppedMultiCutRenderSize(mediaModel.getMediaResourceModel().getVideos()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMultiCutCropModel(TAVComposition tAVComposition) {
        List<? extends TAVTransitionableVideo> list;
        List<List<? extends TAVTransitionableVideo>> videoChannels = tAVComposition.getVideoChannels();
        if (CollectionUtil.isEmptyList(videoChannels) || (list = videoChannels.get(0)) == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            CropConfig findMultiCutCropByIndex = findMultiCutCropByIndex(i3);
            TAVClip tAVClip = (TAVClip) list.get(i3);
            List<TAVVideoEffect> effects = tAVClip.getVideoConfiguration().getEffects();
            if (findMultiCutCropByIndex != null) {
                CropEffectNode cropEffectNode = new CropEffectNode();
                CropModel cropModel = new CropModel();
                cropModel.setCropConfig(findMultiCutCropByIndex);
                cropEffectNode.setCropModel(cropModel);
                effects.add(0, cropEffectNode);
            }
            tAVClip.getVideoConfiguration().setEffects(effects);
        }
    }

    private void updatePlayer(MediaModel mediaModel, boolean z16) {
        updatePlayer(mediaModel, z16, false);
    }

    private void updateTemplateRenderChain(int i3, boolean z16, boolean z17, boolean z18) {
        updateTemplateRenderChain(i3, z16, z17, z18, null);
    }

    public void addPlayer(MoviePlayer moviePlayer) {
        this.players.add(moviePlayer);
    }

    public void addSticker(final StickerModel stickerModel) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.9
            @Override // java.lang.Runnable
            public void run() {
                TAVCutVideoSession tAVCutVideoSession = TAVCutVideoSession.this;
                tAVCutVideoSession.addSticker(tAVCutVideoSession.getStickerController(), stickerModel);
            }
        });
    }

    public void applyCurrentSticker() {
        applyCurrentSticker(getStickerController());
    }

    public void clearAEKitModel() {
        clearAEKitModel(getMediaModel(), getRenderChainManager());
        refresh();
    }

    public boolean correctMediaResource(long j3) {
        this.maxDuration = j3;
        if (getMediaModel() == null || getMediaModel().getMediaResourceModel().getVideos().size() < 1) {
            return false;
        }
        List<MediaClipModel> videos = getMediaModel().getMediaResourceModel().getVideos();
        int i3 = 0;
        long j16 = 0;
        while (true) {
            if (i3 < videos.size()) {
                MediaClipModel mediaClipModel = videos.get(i3);
                if (mediaClipModel != null) {
                    j16 += mediaClipModel.getResource().getScaleDuration();
                    if (500 + j16 >= j3) {
                        break;
                    }
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == -1) {
            return false;
        }
        VideoResourceModel resource = videos.get(i3).getResource();
        float f16 = 1.0f;
        if (resource.getSelectTimeDuration() != 0 && resource.getScaleDuration() != 0) {
            f16 = (((float) resource.getSelectTimeDuration()) * 1.0f) / ((float) resource.getScaleDuration());
        }
        long scaleDuration = resource.getScaleDuration() - (j16 - j3);
        videos.get(i3).getResource().setSelectTimeDurationUs(((float) scaleDuration) * f16 * 1000.0f);
        videos.get(i3).getResource().setScaleDuration(scaleDuration);
        for (int i16 = i3 + 1; i16 < videos.size(); i16++) {
            MediaClipModel mediaClipModel2 = videos.get(i16);
            if (mediaClipModel2 != null) {
                mediaClipModel2.getResource().setSelectTimeDurationUs(0L);
                mediaClipModel2.getResource().setScaleDuration(0L);
            }
        }
        return true;
    }

    public void deleteLyricSticker() {
        String str;
        Iterator<MediaModel> it = this.mediaModels.iterator();
        while (true) {
            if (it.hasNext()) {
                MediaModel next = it.next();
                if (next.getMediaEffectModel().getSubtitleModel() != null) {
                    str = next.getMediaEffectModel().getSubtitleModel().getUniqueId();
                    next.getMediaEffectModel().setSubtitleModel(null);
                    break;
                }
            } else {
                str = "";
                break;
            }
        }
        getStickerController().deleteLyricSticker();
        super.onDeleteButtonClick(str);
        refresh();
    }

    public CMTime getDuration() {
        if (getTAVComposition() != null) {
            return getTAVComposition().getDuration();
        }
        return CMTime.CMTimeZero;
    }

    @Nullable
    public void getEffectVideoFrame(long j3, final int i3, @NonNull final FrameExtractCallback frameExtractCallback) {
        final TAVSourceImageGenerator tAVSourceImageGenerator = new TAVSourceImageGenerator(new TAVCompositionBuilder(getTAVComposition()).buildSource(), getRenderChainManager().getComposition().getRenderSize());
        tAVSourceImageGenerator.getAssetImageGenerator().setForceUseFbo(true);
        tAVSourceImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
        tAVSourceImageGenerator.generateThumbnailAtTime(new CMTime(((float) j3) / 1000.0f), new AssetImageGenerator.ImageGeneratorListener() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.15
            @Override // com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener
            public void onCompletion(@NonNull CMTime cMTime, @Nullable Bitmap bitmap, @Nullable CMTime cMTime2, @NonNull AssetImageGenerator.AssetImageGeneratorResult assetImageGeneratorResult) {
                if (assetImageGeneratorResult == AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded) {
                    Bitmap scaleBitmap = BitmapUtil.scaleBitmap(bitmap, i3);
                    tAVSourceImageGenerator.getAssetImageGenerator().release();
                    frameExtractCallback.onFrameExtracted(scaleBitmap);
                } else if (assetImageGeneratorResult == AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorCancelled) {
                    frameExtractCallback.onExtractCanceled();
                } else {
                    frameExtractCallback.onExtractFailed();
                }
            }
        });
    }

    public Size getExportMaxMediaSize() {
        List<MediaClipModel> videos = getMediaModel().getMediaResourceModel().getVideos();
        Size croppedSizeByIndex = getCroppedSizeByIndex(videos, 0);
        return getMultiMaxWidthHeight(videos, croppedSizeByIndex.getWidth(), croppedSizeByIndex.getHeight());
    }

    public VideoExporter getExporter(final VideoExportConfig videoExportConfig) {
        final VideoExporter videoExporter = new VideoExporter();
        VideoRenderChainConfigure videoRenderChainConfigure = new VideoRenderChainConfigure(true);
        MediaModel mediaModel = getMediaModel();
        if (mediaModel != null) {
            MediaTemplateModel mediaTemplateModel = mediaModel.getMediaTemplateModel();
            if (!mediaTemplateModel.isLightTemplateEmpty()) {
                videoRenderChainConfigure.setSceneType(4);
                setVideoChangeConfigureRenderSize(videoRenderChainConfigure);
            } else if (!mediaTemplateModel.isAutoTemplateEmpty()) {
                videoRenderChainConfigure.setSceneType(2);
                setVideoChangeConfigureRenderSize(videoRenderChainConfigure);
            } else if (!mediaTemplateModel.isMovieTemplateEmpty()) {
                videoRenderChainConfigure.setSceneType(1);
            } else {
                videoRenderChainConfigure.setSceneType(0);
            }
        }
        MediaBuilderFactory.mediaBuilderSync(getMediaModel(), this.context, null, videoRenderChainConfigure, new MediaBuilderListener() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.13
            @Override // com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener
            public void buildCompleted(int i3, VideoRenderChainManager videoRenderChainManager, MediaBuilderOutput mediaBuilderOutput) {
                TAVCutVideoSession.this.mediaBuilderOutput = mediaBuilderOutput;
                if (ModelExtKt.isAutoTemplate(TAVCutVideoSession.this.getMediaModel()) || ModelExtKt.isLightTemplate(TAVCutVideoSession.this.getMediaModel())) {
                    TAVCutVideoSession.this.updateMultiCutCropModel(videoRenderChainManager.getComposition());
                    TAVCutVideoSession.this.setRenderSizeCompat(videoRenderChainManager, TAVCutVideoSession.this.getMultiCutRenderSize(videoRenderChainManager));
                }
                videoExporter.setTavComposition(videoRenderChainManager.getComposition());
                videoExporter.setVideoExportConfig(videoExportConfig);
            }
        }, getMediaModel().getMediaEffectModel().getMusicModel().isChangeMusicByUser());
        return videoExporter;
    }

    public MediaBuilderOutput getMediaBuilderOutput() {
        return this.mediaBuilderOutput;
    }

    public MediaModel getMediaModel() {
        List<MediaModel> list = this.mediaModels;
        if (list != null && !list.isEmpty()) {
            return this.mediaModels.get(0);
        }
        return null;
    }

    public List<Bitmap> getMultiVideoFrame(List<Long> list, int i3) {
        TAVSource tAVSourceForCover = getTAVSourceForCover();
        if (tAVSourceForCover != null && this.renderChainManagers.size() >= 1) {
            CGSize multiCutRenderSize = getMultiCutRenderSize(this.renderChainManagers.get(0));
            VideoImageExtractor videoImageExtractor = new VideoImageExtractor();
            this.videoImageExtractor = videoImageExtractor;
            videoImageExtractor.initCoverProvider(list, tAVSourceForCover, multiCutRenderSize, i3);
            return this.videoImageExtractor.extractImages();
        }
        Logger.i("Cover", "source = null");
        return new ArrayList();
    }

    protected MoviePlayer getPlayer() {
        List<MoviePlayer> list = this.players;
        if (list != null && !list.isEmpty()) {
            return this.players.get(0);
        }
        return null;
    }

    public CGSize getRenderSize() {
        return getRenderChainManager().getComposition().getRenderSize();
    }

    protected StickerController getStickerController() {
        SparseArray<StickerController> sparseArray = this.stickerControllers;
        if (sparseArray != null && sparseArray.size() > 0) {
            return this.stickerControllers.get(0);
        }
        return null;
    }

    public TAVSource getTAVSourceForCover() {
        TAVComposition tAVComposition = this.coverTavComposition;
        if (tAVComposition == null) {
            Logger.i("Cover", "composition null");
            return null;
        }
        return new TAVCompositionBuilder(tAVComposition).buildSource();
    }

    public TextureView getTexureView() {
        List<MoviePlayer> list = this.players;
        if (list != null && list.size() > 0) {
            return this.players.get(0).getTextureView();
        }
        return null;
    }

    public List<Bitmap> getVideoFrame(List<Long> list, int i3) {
        TAVSource tAVSourceForCover = getTAVSourceForCover();
        if (tAVSourceForCover == null) {
            Logger.i("Cover", "source = null");
            return new ArrayList();
        }
        Size videoSize = VideoUtil.getVideoSize(this.videoPath, true);
        CGSize cGSize = new CGSize(videoSize.getWidth(), videoSize.getHeight());
        VideoImageExtractor videoImageExtractor = new VideoImageExtractor();
        this.videoImageExtractor = videoImageExtractor;
        videoImageExtractor.initCoverProvider(list, tAVSourceForCover, cGSize, i3);
        return this.videoImageExtractor.extractImages();
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.Session
    public int init(Context context) {
        try {
            this.runAsync = false;
            super.init(context);
            initMediaModel();
            initRenderEnvironment();
            initPlayer();
            return 0;
        } catch (Exception e16) {
            Logger.e(e16);
            return -1;
        }
    }

    protected void initMediaModel() {
        if (this.mediaModels == null) {
            this.mediaModels = new ArrayList();
            addBaseMediaModel();
        }
        recordInitMediaModelsMD5();
    }

    public void initMultiCutSession(Context context, List<ResInfoModel> list) {
        try {
            this.runAsync = false;
            super.init(context);
            if (list == null) {
                return;
            }
            for (ResInfoModel resInfoModel : list) {
                if (resInfoModel != null) {
                    addBaseMediaModel(resInfoModel.getResPath(), resInfoModel.getType(), resInfoModel.getCropConfig());
                }
            }
            initRenderEnvironment();
            initPlayer();
        } catch (Exception e16) {
            Logger.e(e16);
        }
    }

    protected void initPlayer() {
        boolean z16;
        if (getPlayer() != null) {
            SessionConfig sessionConfig = this.sessionConfig;
            if (sessionConfig != null && !sessionConfig.isAutoPlayVideo()) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.preIsPlaying = z16;
            if (getTAVComposition() == null) {
                return;
            }
            CMTimeRange cMTimeRange = new CMTimeRange(CMTime.CMTimeZero, getTAVComposition().getDuration());
            getPlayer().updateComposition(getTAVComposition(), cMTimeRange.getStart(), this.preIsPlaying);
            getPlayer().setPlayRange(cMTimeRange);
        }
    }

    protected void initRenderEnvironment() {
        StickerController createStickerController = createStickerController();
        this.stickerControllers.put(0, createStickerController);
        VideoRenderChainConfigure videoRenderChainConfigure = new VideoRenderChainConfigure(true);
        videoRenderChainConfigure.setSceneType(0);
        MediaBuilderFactory.mediaBuilderSync(getMediaModel(), this.context, createStickerController, videoRenderChainConfigure, new MediaBuilderListener() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.1
            @Override // com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener
            public void buildCompleted(int i3, VideoRenderChainManager videoRenderChainManager, MediaBuilderOutput mediaBuilderOutput) {
                VideoComposition.RenderLayoutMode renderLayoutMode;
                TAVCutVideoSession.this.mediaBuilderOutput = mediaBuilderOutput;
                int width = videoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0).getResource().getWidth();
                int height = videoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0).getResource().getHeight();
                TAVCutVideoView tAVCutVideoView = TAVCutVideoSession.this.tavCutVideoView;
                if (tAVCutVideoView != null) {
                    tAVCutVideoView.adjustStickerContainer(new Size(width, height));
                }
                TAVCutVideoSession.this.setRenderSizeCompat(videoRenderChainManager, TAVCutVideoSession.this.constrainRenderSize(width, height));
                TAVCutVideoSession.this.renderChainManagers.put(0, videoRenderChainManager);
                TAVCutVideoSession.this.tavCompositions.put(0, videoRenderChainManager.getComposition());
                TAVComposition composition = videoRenderChainManager.getComposition();
                SessionConfig sessionConfig = TAVCutVideoSession.this.sessionConfig;
                if (sessionConfig != null) {
                    renderLayoutMode = sessionConfig.getRenderLayoutMode();
                } else {
                    renderLayoutMode = null;
                }
                composition.setRenderLayoutMode(renderLayoutMode);
            }
        });
        MediaBuilderFactory.mediaBuilderSync(getMediaModel(), this.context, createStickerController, videoRenderChainConfigure, new MediaBuilderListener() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.2
            @Override // com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener
            public void buildCompleted(int i3, VideoRenderChainManager videoRenderChainManager, MediaBuilderOutput mediaBuilderOutput) {
                TAVCutVideoSession.this.setRenderSizeCompat(videoRenderChainManager, TAVCutVideoSession.this.constrainRenderSize(videoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0).getResource().getWidth(), videoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0).getResource().getHeight()));
                TAVCutVideoSession.this.coverTavComposition = videoRenderChainManager.getComposition();
            }
        });
        if (this.tavCutVideoView != null) {
            if (getPlayer() != null) {
                getPlayer().bindView(this.tavCutVideoView);
            }
            if (getStickerController() != null) {
                getStickerController().setStickerContainer(this.tavCutVideoView.getStickerContainer());
            }
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback
    public void onDeleteButtonClick(String str) {
        super.onDeleteButtonClick(str);
        refresh();
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.Session
    public void onPause() {
        super.onPause();
        Iterator<MoviePlayer> it = this.players.iterator();
        while (it.hasNext()) {
            it.next().pause();
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.Session
    public void onResume() {
        super.onResume();
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.callback.StickerStateCallback
    public void onStatusChanged(boolean z16) {
        MoviePlayer player = getPlayer();
        if (player == null) {
            return;
        }
        if (z16) {
            if (player.isPlaying()) {
                this.preIsPlaying = true;
                player.pause();
                return;
            } else {
                this.preIsPlaying = false;
                player.refresh();
                return;
            }
        }
        if (this.preIsPlaying) {
            player.play();
        } else {
            player.refresh();
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.callback.StickerStateCallback
    public void onStickerActive() {
        refresh();
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.callback.StickerStateCallback
    public void onStickerResign(TAVSticker tAVSticker) {
        super.onStickerResign(tAVSticker);
        refresh();
    }

    protected void refresh() {
        if (getPlayer() != null && !getPlayer().isPlaying()) {
            getPlayer().refresh();
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.Session
    public void release() {
        DurationUtil.start("TAVCutVideoSession release");
        Iterator<MoviePlayer> it = this.players.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        VideoImageExtractor videoImageExtractor = this.videoImageExtractor;
        if (videoImageExtractor != null) {
            videoImageExtractor.release();
        }
        super.release();
        DurationUtil.end("TAVCutVideoSession release");
    }

    public void resetAEKitModel(final float f16, final String str, final float f17, final Map<String, String> map, final String str2) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.4
            @Override // java.lang.Runnable
            public void run() {
                TAVCutVideoSession tAVCutVideoSession = TAVCutVideoSession.this;
                tAVCutVideoSession.resetAEKitModel(tAVCutVideoSession.getMediaModel(), TAVCutVideoSession.this.getRenderChainManager(), f16, str, f17, map, str2);
                TAVCutVideoSession.this.refresh();
            }
        });
    }

    public void resetAEKitModelForAI(final String str, final float f16, final HashMap<String, String> hashMap, final int i3, final float f17) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.5
            @Override // java.lang.Runnable
            public void run() {
                TAVCutVideoSession tAVCutVideoSession = TAVCutVideoSession.this;
                tAVCutVideoSession.resetAEKitModelForAI(tAVCutVideoSession.getMediaModel(), TAVCutVideoSession.this.getRenderChainManager(), str, f16, hashMap, i3, f17, TAVCutVideoSession.this.getMediaModel().getMediaResourceModel().getVideos().get(0).getResource().getSelectTimeDuration());
                TAVCutVideoSession.this.refresh();
            }
        });
    }

    public void resetAEKitModelForMultiAI(final String str, final float f16, final HashMap<String, String> hashMap, final int i3, final float f17) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.6
            @Override // java.lang.Runnable
            public void run() {
                TAVCutVideoSession tAVCutVideoSession = TAVCutVideoSession.this;
                tAVCutVideoSession.resetAEKitModelForAI(tAVCutVideoSession.getMediaModel(), TAVCutVideoSession.this.getRenderChainManager(), str, f16, hashMap, i3, f17, TAVCutVideoSession.this.getDuration().getTimeUs() / 1000);
                TAVCutVideoSession.this.refresh();
            }
        });
    }

    public void restoreStickers(final List<StickerModel> list) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.10
            @Override // java.lang.Runnable
            public void run() {
                TAVCutVideoSession.this.getStickerController().restoreSticker(list);
                TAVCutVideoSession.this.getMediaModel().getMediaEffectModel().setStickerModelList(list);
            }
        });
    }

    public void restoreStickersWithLyric(final List<StickerModel> list) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.11
            @Override // java.lang.Runnable
            public void run() {
                StickerController stickerController;
                TAVCutVideoSession.this.getStickerController().restoreSticker(list);
                TAVCutVideoSession.this.getMediaModel().getMediaEffectModel().setStickerModelList(list);
                MediaModel mediaModel = TAVCutVideoSession.this.getMediaModel();
                if (mediaModel.getMediaEffectModel().getSubtitleModel() != null && TAVCutVideoSession.this.stickerControllers.size() > 0 && (stickerController = TAVCutVideoSession.this.stickerControllers.get(0)) != null) {
                    stickerController.addSticker(StickerConverter.subtitleModel2TavSticker(mediaModel.getMediaEffectModel().getSubtitleModel()));
                }
            }
        });
    }

    public boolean restoreTemplateMusic(float f16, float f17) {
        MediaBuilderOutput mediaBuilderOutput;
        AudioPlaceHolder[] audioPlaceHolders;
        if (ModelExtKt.isLightTemplate(getMediaModel()) && (mediaBuilderOutput = this.mediaBuilderOutput) != null && mediaBuilderOutput.getLightTemplate() != null && (audioPlaceHolders = this.mediaBuilderOutput.getLightTemplate().getMovieController().getAudioPlaceHolders()) != null && audioPlaceHolders.length != 0) {
            for (AudioPlaceHolder audioPlaceHolder : audioPlaceHolders) {
                if (!TextUtils.isEmpty(audioPlaceHolder.path)) {
                    MusicMaterialMetaDataBean musicMaterialMetaDataBean = new MusicMaterialMetaDataBean();
                    musicMaterialMetaDataBean.id = audioPlaceHolder.musicID;
                    musicMaterialMetaDataBean.path = audioPlaceHolder.path;
                    musicMaterialMetaDataBean.startTime = (int) TimeUtil.us2Milli(audioPlaceHolder.startOffset);
                    musicMaterialMetaDataBean.mTotalTimeMs = AudioUtils.getDuration(audioPlaceHolder.path);
                    MusicMaterialMataDataBeanUtils.setStartInTime(musicMaterialMetaDataBean, TimeUtil.us2Milli(audioPlaceHolder.fadeInDuration));
                    MusicMaterialMataDataBeanUtils.setEndOutTime(musicMaterialMetaDataBean, TimeUtil.us2Milli(audioPlaceHolder.fadeOutDuration));
                    getMediaModel().getMediaEffectModel().getMusicModel().setMetaDataBean(musicMaterialMetaDataBean);
                    getMediaModel().getMediaEffectModel().getMusicModel().setChangeMusicByUser(false);
                    getMediaModel().getMediaEffectModel().getMusicModel().setBgmVolume(audioPlaceHolder.volume);
                    if (musicMaterialMetaDataBean.mTotalTimeMs > 0 && getTAVComposition() != null) {
                        AudioUtils.updateCompositionAudiosBySymbol(getTAVComposition(), AudioUtils.getBGMAudioClips(TimeUtil.us2Milli(getTAVComposition().getDuration().getTimeUs()), musicMaterialMetaDataBean, musicMaterialMetaDataBean.volume), AudioUtils.AudioSymbol.BGM);
                        updatePlayer(getMediaModel(), true);
                        setMainVolume(f16);
                        setBgmVolume(f17);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public SubtitleModel saveLyricSticker() {
        return getStickerController().saveLyricSticker();
    }

    public void setBgmMusic(MusicData musicData, float f16, float f17, boolean z16) {
        if (musicData == null) {
            MusicModel musicModel = getMediaModel().getMediaEffectModel().getMusicModel();
            musicModel.setMetaDataBean(null);
            musicModel.setUserMetaDataBean(null);
            if (!ModelExtKt.isLightTemplate(getMediaModel())) {
                musicModel.setVolume(f16);
                musicModel.setBgmVolume(f17);
            }
            updatePlayer(getMediaModel(), z16);
            if (ModelExtKt.isLightTemplate(getMediaModel())) {
                setMainVolume(f16);
                setBgmVolume(f17);
                return;
            }
            return;
        }
        MusicMaterialMetaDataBean musicMaterialMetaDataBean = new MusicMaterialMetaDataBean();
        musicMaterialMetaDataBean.startTime = musicData.getStartTime();
        musicMaterialMetaDataBean.mTotalTimeMs = musicData.getTotalTime();
        musicMaterialMetaDataBean.mTotalTime = musicData.getTotalTime() / 1000;
        musicMaterialMetaDataBean.segDuration = musicData.getSegDuration();
        musicMaterialMetaDataBean.path = musicData.getPath();
        MusicModel musicModel2 = getMediaModel().getMediaEffectModel().getMusicModel();
        musicModel2.setUserMetaDataBean(musicMaterialMetaDataBean);
        musicModel2.setMetaDataBean(musicMaterialMetaDataBean);
        if (!ModelExtKt.isLightTemplate(getMediaModel())) {
            musicModel2.setVolume(f16);
            musicModel2.setBgmVolume(f17);
        }
        updatePlayer(getMediaModel(), z16, true);
        musicModel2.setChangeMusicByUser(true);
        if (ModelExtKt.isLightTemplate(getMediaModel())) {
            setMainVolume(f16);
            setBgmVolume(f17);
        }
    }

    public void setBgmRange(int i3, int i16) {
        MusicModel musicModel = getMediaModel().getMediaEffectModel().getMusicModel();
        musicModel.getUserMetaDataBean().startTime = i3;
        musicModel.getUserMetaDataBean().mTotalTime = i16;
        musicModel.getMetaDataBean().startTime = i3;
        musicModel.getMetaDataBean().mTotalTime = i16;
        updatePlayer(getMediaModel(), true);
    }

    public void setBgmVolume(float f16) {
        List<? extends TAVAudio> list;
        if (ModelExtKt.isLightTemplate(getMediaModel())) {
            if (getRenderChainManager() != null) {
                getRenderChainManager().updateBgmVolume(f16);
                return;
            }
            return;
        }
        getMediaModel().getMediaEffectModel().getMusicModel().setBgmVolume(f16);
        TAVComposition tAVComposition = getTAVComposition();
        if (tAVComposition != null) {
            list = tAVComposition.getAudios();
        } else {
            list = null;
        }
        if (!CollectionUtils.isEmpty(list)) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).getAudioConfiguration().setVolume(f16);
            }
        }
    }

    public void setClip(Long l3, Long l16) {
        setClip(l3, l16, false);
    }

    public void setEffectStrength(final float f16) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.7
            @Override // java.lang.Runnable
            public void run() {
                TAVCutVideoSession tAVCutVideoSession = TAVCutVideoSession.this;
                tAVCutVideoSession.setEffectStrength(tAVCutVideoSession.getMediaModel(), TAVCutVideoSession.this.getRenderChainManager(), f16);
                TAVCutVideoSession.this.refresh();
            }
        });
    }

    public void setLyricStartTime(int i3) {
        getStickerController().setLyricStartTime(i3);
    }

    public void setMainVolume(float f16) {
        List<? extends TAVTransitionableAudio> list;
        if (ModelExtKt.isLightTemplate(getMediaModel())) {
            if (getRenderChainManager() != null) {
                getRenderChainManager().updateVideoVolume(f16);
                return;
            }
            return;
        }
        getMediaModel().getMediaEffectModel().getMusicModel().setVolume(f16);
        TAVComposition tAVComposition = getTAVComposition();
        if (tAVComposition == null) {
            return;
        }
        List<List<? extends TAVTransitionableAudio>> audioChannels = tAVComposition.getAudioChannels();
        if (audioChannels.isEmpty() || audioChannels.get(0).isEmpty() || (list = audioChannels.get(0)) == null) {
            return;
        }
        for (TAVTransitionableAudio tAVTransitionableAudio : list) {
            if (tAVTransitionableAudio instanceof TAVClip) {
                tAVTransitionableAudio.getAudioConfiguration().setVolume(f16);
            }
        }
    }

    @Deprecated
    public void setMaterial(@Nullable final String str) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.8
            @Override // java.lang.Runnable
            public void run() {
                TAVCutVideoSession tAVCutVideoSession = TAVCutVideoSession.this;
                tAVCutVideoSession.setMaterial(tAVCutVideoSession.getMediaModel(), TAVCutVideoSession.this.getRenderChainManager(), str);
                TAVCutVideoSession.this.refresh();
            }
        });
    }

    public void setMediaModel(MediaModel mediaModel) {
        ArrayList arrayList = new ArrayList();
        this.mediaModels = arrayList;
        arrayList.add(mediaModel);
    }

    public void setRotate(int i3) {
        getMediaModel().getMediaResourceModel().getVideos().get(0).getVideoConfigurationModel().setRotate(i3);
        int i16 = (i3 % 4) * 90;
        if (getPlayer() != null) {
            getPlayer().rotate(i16, false);
        }
    }

    public void setSpeed(float f16, boolean z16) {
        if (f16 <= 0.0f) {
            return;
        }
        getMediaModel().getMediaResourceModel().getVideos().get(0).getResource().setScaleDuration(((float) r0.getResource().getSelectTimeDuration()) / f16);
        if (z16) {
            updatePlayer(getMediaModel(), true);
        }
    }

    public void setStickerTouchEnable(boolean z16) {
        if (getStickerController() != null) {
            getStickerController().setStickerTouchEnable(z16);
        }
    }

    public void setTAVCutVideoView(TAVCutVideoView tAVCutVideoView) {
        TAVCutVideoView tAVCutVideoView2 = this.tavCutVideoView;
        if (tAVCutVideoView2 != null) {
            tAVCutVideoView2.getStickerContainer().removeAllViews();
            this.tavCutVideoView.removeAllViews();
            tAVCutVideoView.adjustStickerContainer(new Size(getMediaModel().getMediaResourceModel().getVideos().get(0).getResource().getWidth(), getMediaModel().getMediaResourceModel().getVideos().get(0).getResource().getHeight()));
            getStickerController().setStickerContainer(tAVCutVideoView.getStickerContainer());
            getPlayer().release();
            getPlayer().bindView(tAVCutVideoView);
            initPlayer();
        }
        this.tavCutVideoView = tAVCutVideoView;
    }

    public void setTemplate(int i3, String str, boolean z16, String... strArr) {
        setTemplate(i3, str, z16, true, null, strArr);
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public void toggleAEKit(final boolean z16) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.3
            @Override // java.lang.Runnable
            public void run() {
                TAVCutVideoSession tAVCutVideoSession = TAVCutVideoSession.this;
                tAVCutVideoSession.toggleAEKit(tAVCutVideoSession.getMediaModel(), TAVCutVideoSession.this.getRenderChainManager(), z16);
                TAVCutVideoSession.this.refresh();
            }
        });
    }

    public void updateTemplateComposition(boolean z16) {
        if (ModelExtKt.isLightTemplate(getMediaModel())) {
            LightMediaTemplateModel lightMediaTemplateModel = getMediaModel().getMediaTemplateModel().getLightMediaTemplateModel();
            lightMediaTemplateModel.setClipPlaceHolders(null);
            lightMediaTemplateModel.setSegmentModels(new ArrayList());
            updateTemplateRenderChain(4, true, z16, false);
        } else {
            updateTemplateRenderChain(2, true, z16, false);
        }
        refreshRenderTemplate();
    }

    @Override // com.tencent.qcircle.tavcut.player.MoviePlayer.onVideoProgressListener
    public void updateVideoProgress(long j3) {
        getStickerController().setLyricProcess(j3);
    }

    private void updatePlayer(MediaModel mediaModel, final boolean z16, boolean z17) {
        if (getStickerController() != null) {
            getStickerController().destroy();
        }
        StickerController createStickerController = createStickerController();
        int i3 = 0;
        this.stickerControllers.put(0, createStickerController);
        VideoRenderChainConfigure videoRenderChainConfigure = new VideoRenderChainConfigure(true);
        if (ModelExtKt.isLightTemplate(mediaModel)) {
            i3 = 4;
        } else if (ModelExtKt.isAutoTemplate(mediaModel)) {
            i3 = 2;
        } else if (ModelExtKt.isMovieTemplate(mediaModel)) {
            i3 = 1;
        }
        videoRenderChainConfigure.setSceneType(i3);
        setVideoChangeConfigureRenderSize(videoRenderChainConfigure);
        MediaBuilderFactory.mediaBuilderSync(mediaModel, this.context, createStickerController, videoRenderChainConfigure, new MediaBuilderListener() { // from class: com.tencent.qcircle.tavcut.session.TAVCutVideoSession.14
            @Override // com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener
            public void buildCompleted(int i16, VideoRenderChainManager videoRenderChainManager, MediaBuilderOutput mediaBuilderOutput) {
                VideoComposition.RenderLayoutMode renderLayoutMode;
                TAVCutVideoSession.this.mediaBuilderOutput = mediaBuilderOutput;
                TAVCutVideoSession.this.setRenderSizeCompat(videoRenderChainManager, TAVCutVideoSession.this.getMultiCutRenderSize(videoRenderChainManager));
                TAVCutVideoSession.this.renderChainManagers.put(0, videoRenderChainManager);
                TAVCutVideoSession.this.tavCompositions.put(0, videoRenderChainManager.getComposition());
                TAVComposition composition = videoRenderChainManager.getComposition();
                SessionConfig sessionConfig = TAVCutVideoSession.this.sessionConfig;
                if (sessionConfig != null) {
                    renderLayoutMode = sessionConfig.getRenderLayoutMode();
                } else {
                    renderLayoutMode = null;
                }
                composition.setRenderLayoutMode(renderLayoutMode);
                TAVCutVideoSession.this.getPlayer().updateComposition(videoRenderChainManager.getComposition(), z16);
            }
        }, z17);
        TAVCutVideoView tAVCutVideoView = this.tavCutVideoView;
        if (tAVCutVideoView != null) {
            tAVCutVideoView.getStickerContainer().removeAllViews();
            getStickerController().setStickerContainer(this.tavCutVideoView.getStickerContainer());
        }
        createStickerController.restoreSticker(new ArrayList(mediaModel.getMediaEffectModel().getStickerModelList()));
        if (mediaModel.getMediaEffectModel().getSubtitleModel() != null) {
            createStickerController.addSticker(StickerConverter.subtitleModel2TavSticker(mediaModel.getMediaEffectModel().getSubtitleModel()));
        }
        getRenderChainManager().updateRenderChain(mediaModel.getMediaEffectModel());
    }

    private void updateTemplateRenderChain(int i3, boolean z16, boolean z17, boolean z18, Runnable runnable) {
        if (this.renderChainManagers.size() > 0) {
            this.renderChainManagers.get(0).release();
        }
        StickerController stickerController = getStickerController();
        if (stickerController != null && stickerController.getStickerContext() != null && stickerController.getStickerContext().getCurrentStickerEditView() != null) {
            Logger.d("sticker_size", "updateTemplateRenderChain: h=" + stickerController.getStickerContext().getCurrentStickerEditView().getMeasuredHeight());
            Logger.d("sticker_size", "updateTemplateRenderChain: w=" + stickerController.getStickerContext().getCurrentStickerEditView().getMeasuredWidth());
        }
        VideoRenderChainConfigure videoRenderChainConfigure = new VideoRenderChainConfigure(true);
        setVideoChangeConfigureRenderSize(videoRenderChainConfigure);
        if (!z16) {
            i3 = 0;
        }
        videoRenderChainConfigure.setSceneType(i3);
        videoRenderChainConfigure.setModifyClip(z18);
        mediaBuild(stickerController, videoRenderChainConfigure, z17, runnable);
    }

    public void resetAEKitModel(String str, float f16) {
        resetAEKitModel(getMediaModel(), getRenderChainManager(), str, f16);
        refresh();
    }

    public void setClip(Long l3, Long l16, boolean z16) {
        if (l3 != null && l16 != null) {
            MediaClipModel mediaClipModel = getMediaModel().getMediaResourceModel().getVideos().get(0);
            mediaClipModel.getResource().setSelectTimeStartUs(l3.longValue() * 1000);
            mediaClipModel.getResource().setSelectTimeDurationUs(l16.longValue() * 1000);
        } else {
            MediaClipModel mediaClipModel2 = getMediaModel().getMediaResourceModel().getVideos().get(0);
            long sourceTimeDuration = mediaClipModel2.getResource().getSourceTimeDuration();
            mediaClipModel2.getResource().setSelectTimeStartUs(0L);
            mediaClipModel2.getResource().setSelectTimeDurationUs(sourceTimeDuration * 1000);
        }
        if (z16) {
            updatePlayer(getMediaModel(), true);
        }
    }

    public void setTemplate(int i3, String str, boolean z16, boolean z17, String... strArr) {
        setTemplate(i3, str, z16, z17, null, strArr);
    }

    public void setTemplate(int i3, String str, boolean z16, boolean z17, Runnable runnable, String... strArr) {
        if (z17) {
            correctMediaResourceIgnoreSpeedInner(this.maxDuration);
        } else {
            correctMediaResource(this.maxDuration);
        }
        WSTemplateManager.updateTemplate(getMediaModel(), i3, str, z16, strArr);
        updateTemplateRenderChain(i3, !TextUtils.isEmpty(str), true, true, runnable);
        refreshRenderTemplate();
    }

    public void setSpeed(float f16) {
        setSpeed(f16, false);
    }

    public List<Bitmap> getVideoFrame(List<Long> list) {
        return getVideoFrame(list, -1);
    }

    public void addBaseMediaModel(String str, int i3, CropConfig cropConfig) {
        Size videoSize;
        List<MediaClipModel> arrayList;
        MediaModel mediaModel = new MediaModel();
        MediaClipModel mediaClipModel = new MediaClipModel();
        VideoResourceModel videoResourceModel = new VideoResourceModel();
        if (i3 == 2) {
            videoSize = BitmapUtil.getImageSize(str);
            videoResourceModel.setSelectTimeDurationUs(2000000L);
            videoResourceModel.setSourceTimeDurationUs(3000000L);
        } else {
            videoSize = VideoUtil.getVideoSize(str);
            long duration = DecoderUtils.getDuration(str);
            videoResourceModel.setSelectTimeDurationUs(duration);
            videoResourceModel.setSourceTimeDurationUs(duration);
        }
        videoResourceModel.setPath(str);
        videoResourceModel.setType(i3);
        videoResourceModel.setSelectTimeStartUs(0L);
        videoResourceModel.setScaleDuration(((float) videoResourceModel.getSelectTimeDuration()) / 1.0f);
        videoResourceModel.setWidth(videoSize.getWidth());
        videoResourceModel.setHeight(videoSize.getHeight());
        mediaClipModel.setResource(videoResourceModel);
        if (cropConfig == null) {
            cropConfig = new CropConfig(0.0f, 0.0f, 1.0f, 1.0f);
        }
        mediaClipModel.setConfig(cropConfig);
        List<MediaModel> list = this.mediaModels;
        if (list != null && list.size() > 0) {
            arrayList = this.mediaModels.get(0).getMediaResourceModel().getVideos();
        } else {
            arrayList = new ArrayList<>();
        }
        arrayList.add(mediaClipModel);
        MediaResourceModel mediaResourceModel = mediaModel.getMediaResourceModel();
        mediaResourceModel.setVideos(arrayList);
        mediaModel.setMediaResourceModel(mediaResourceModel);
        if (this.mediaModels == null) {
            this.mediaModels = new ArrayList();
        }
        this.mediaModels.add(mediaModel);
        recordInitMediaModelsMD5();
    }
}
