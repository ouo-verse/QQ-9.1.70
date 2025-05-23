package com.tencent.qcircle.weseevideo.model.template.light;

import android.graphics.RectF;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qcircle.weishi.module.publisher.interfaces.XffectsDownloadListener;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieSegmentModel;
import com.tencent.qcircle.weseevideo.model.utils.AudioUtils;
import com.tencent.qcircle.weseevideo.model.utils.MusicMaterialMataDataBeanUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioOutputConfig;
import org.light.AudioPlaceHolder;
import org.light.ClipAsset;
import org.light.ClipInfo;
import org.light.ClipPlaceHolder;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.TextAsset;
import org.light.TimeRange;
import org.light.VideoOutputConfig;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J2\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0002J4\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007J4\u0010\u001f\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007J<\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010%\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0007J\u0010\u0010(\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010)\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J=\u0010*\u001a\u00020\u00162\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0,2\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0007\u00a2\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J&\u00105\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\nJ\u0018\u0010:\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010;\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010<\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010=\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J/\u0010>\u001a\u00020\f2\u0012\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0,2\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0007\u00a2\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/template/light/LightTemplateMediaBuilder;", "", "()V", "DEFAULT_FRAME_RATE", "", "DEFAULT_SEEK_TOLERANCE", "", "PLAYING_SEEK_TOLERANCE", "SECONDS_US", "TAG", "", "bindAudioPlaceHolder", "", "editorModel", "Lcom/tencent/qcircle/weseevideo/model/MediaModel;", "lightTemplate", "Lcom/tencent/qcircle/weseevideo/model/template/light/LightTemplate;", "lightTemplateModel", "Lcom/tencent/qcircle/weseevideo/model/template/light/LightMediaTemplateModel;", "composition", "Lcom/tencent/tavkit/composition/TAVComposition;", "changeMusicByUser", "", "build", "model", "renderContextCreator", "Lcom/tencent/qcircle/weseevideo/composition/VideoRenderChainManager$IStickerContextInterface;", "listener", "Lcom/tencent/qcircle/weseevideo/composition/builder/MediaBuilderListener;", "configure", "Lcom/tencent/qcircle/weseevideo/composition/VideoRenderChainConfigure;", "buildComposition", "renderSize", "Lcom/tencent/tav/coremedia/CGSize;", "createVideoRenderChainManager", "Lcom/tencent/qcircle/weseevideo/composition/VideoRenderChainManager;", "applyType", "generateTAVComposition", "durationUs", "", "initBoundsRect", "initLightEngine", "isFullFilled", "cilpInfos", "", "Lorg/light/ClipInfo;", "clipPlaceHolders", "Lorg/light/ClipPlaceHolder;", "lightSegments", "", "Lcom/tencent/qcircle/weseevideo/model/template/movie/MovieSegmentModel;", "([[Lorg/light/ClipInfo;[Lorg/light/ClipPlaceHolder;Ljava/util/List;)Z", "parseSegmentInfo", "replaceLightPresetData", "Ljava/util/HashMap;", "movieController", "Lorg/light/MovieController;", "filePath", "replaceLightTextData", "updateClipPlaceHolderInfo", "updateSegmentCount", "updateSegmentMinDuration", "updateSegmentTimeRange", "clipInfos", "([[Lorg/light/ClipInfo;Ljava/util/List;)V", "updateTemplateDuration", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class LightTemplateMediaBuilder {
    private static final float DEFAULT_FRAME_RATE = 30.0f;
    private static final int DEFAULT_SEEK_TOLERANCE = 0;
    public static final LightTemplateMediaBuilder INSTANCE = new LightTemplateMediaBuilder();
    private static final int PLAYING_SEEK_TOLERANCE = 120000;
    public static final int SECONDS_US = 1000000;

    @NotNull
    public static final String TAG = "LightTemplateMediaBuilder";

    LightTemplateMediaBuilder() {
    }

    private final void bindAudioPlaceHolder(MediaModel editorModel, LightTemplate lightTemplate, LightMediaTemplateModel lightTemplateModel, TAVComposition composition, boolean changeMusicByUser) {
        boolean z16;
        String str;
        if (editorModel.getMediaEffectModel().getMusicModel().getMetaDataBean() != null && changeMusicByUser) {
            return;
        }
        MovieController movieController = lightTemplate.getMovieController();
        Intrinsics.checkExpressionValueIsNotNull(movieController, "lightTemplate.movieController");
        AudioPlaceHolder[] audioPlaceHolder = movieController.getAudioPlaceHolders();
        Intrinsics.checkExpressionValueIsNotNull(audioPlaceHolder, "audioPlaceHolder");
        if (audioPlaceHolder.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        for (AudioPlaceHolder audioPlaceHolder2 : audioPlaceHolder) {
            if (!TextUtils.isEmpty(audioPlaceHolder2.path)) {
                MusicMaterialMetaDataBean musicMaterialMetaDataBean = new MusicMaterialMetaDataBean(null, 0L, null, null, null, null, 0, 0, null, null, null, null, null, 0, null, 0, null, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0L, 0, 0, (byte) 0, 0, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, null, false, 0, 0, null, null, false, null, false, 0L, 0L, 0L, 0L, false, 0L, 0.0f, 0L, null, -1, Integer.MAX_VALUE, null);
                String str2 = audioPlaceHolder2.musicID;
                Intrinsics.checkExpressionValueIsNotNull(str2, "audio.musicID");
                musicMaterialMetaDataBean.id = str2;
                musicMaterialMetaDataBean.path = audioPlaceHolder2.path;
                TemplateBean templateBean = lightTemplateModel.getTemplateBean();
                if (templateBean != null) {
                    str = templateBean.templateName;
                } else {
                    str = null;
                }
                musicMaterialMetaDataBean.name = str;
                musicMaterialMetaDataBean.startTime = (int) TimeUtil.us2Milli(audioPlaceHolder2.startOffset);
                musicMaterialMetaDataBean.mTotalTimeMs = AudioUtils.getDuration(audioPlaceHolder2.path);
                MusicMaterialMataDataBeanUtils.setStartInTime(musicMaterialMetaDataBean, TimeUtil.us2Milli(audioPlaceHolder2.fadeInDuration));
                MusicMaterialMataDataBeanUtils.setEndOutTime(musicMaterialMetaDataBean, TimeUtil.us2Milli(audioPlaceHolder2.fadeOutDuration));
                editorModel.getMediaEffectModel().getMusicModel().setMetaDataBean(musicMaterialMetaDataBean);
                editorModel.getMediaEffectModel().getMusicModel().setBgmVolume(audioPlaceHolder2.volume);
                return;
            }
        }
    }

    static /* synthetic */ void bindAudioPlaceHolder$default(LightTemplateMediaBuilder lightTemplateMediaBuilder, MediaModel mediaModel, LightTemplate lightTemplate, LightMediaTemplateModel lightMediaTemplateModel, TAVComposition tAVComposition, boolean z16, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z16 = false;
        }
        lightTemplateMediaBuilder.bindAudioPlaceHolder(mediaModel, lightTemplate, lightMediaTemplateModel, tAVComposition, z16);
    }

    @JvmStatic
    public static final void build(@NotNull MediaModel model, @Nullable VideoRenderChainManager.IStickerContextInterface renderContextCreator, @NotNull MediaBuilderListener listener, @NotNull VideoRenderChainConfigure configure, boolean changeMusicByUser) {
        CGSize renderSize;
        Intrinsics.checkParameterIsNotNull(model, "model");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        Intrinsics.checkParameterIsNotNull(configure, "configure");
        MediaTemplateModel mediaTemplateModel = model.getMediaTemplateModel();
        LightMediaTemplateModel lightMediaTemplateModel = mediaTemplateModel.getLightMediaTemplateModel();
        if (lightMediaTemplateModel.isEmpty()) {
            listener.buildCompleted(-304, null, null);
            Logger.e(TAG, "LightMediaTemplateModel is empty. template path is null or template file is not exist");
            return;
        }
        if (mediaTemplateModel.getOriginMediaResourceModel() == null) {
            mediaTemplateModel.setOriginMediaResourceModel(model.getMediaResourceModel().deepCopy());
        }
        String filePath = lightMediaTemplateModel.getFilePath();
        if (filePath == null) {
            filePath = "";
        }
        LightTemplate lightTemplate = new LightTemplate(filePath);
        if (configure.getRenderSize() != null) {
            renderSize = configure.getRenderSize();
        } else {
            renderSize = lightTemplate.getRenderSize();
        }
        CGSize renderSize2 = renderSize;
        LightTemplateMediaBuilder lightTemplateMediaBuilder = INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(renderSize2, "renderSize");
        TAVComposition buildComposition = lightTemplateMediaBuilder.buildComposition(model, lightTemplate, renderSize2, configure, changeMusicByUser);
        if (buildComposition == null) {
            listener.buildCompleted(-306, null, null);
            return;
        }
        VideoRenderChainManager createVideoRenderChainManager = lightTemplateMediaBuilder.createVideoRenderChainManager(configure.getApplyType(), buildComposition, model, renderContextCreator, configure, lightTemplate);
        MediaBuilderOutput mediaBuilderOutput = new MediaBuilderOutput();
        mediaBuilderOutput.setLightTemplate(lightTemplate);
        listener.buildCompleted(0, createVideoRenderChainManager, mediaBuilderOutput);
    }

    public static /* synthetic */ void build$default(MediaModel mediaModel, VideoRenderChainManager.IStickerContextInterface iStickerContextInterface, MediaBuilderListener mediaBuilderListener, VideoRenderChainConfigure videoRenderChainConfigure, boolean z16, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z16 = false;
        }
        build(mediaModel, iStickerContextInterface, mediaBuilderListener, videoRenderChainConfigure, z16);
    }

    public static /* synthetic */ TAVComposition buildComposition$default(LightTemplateMediaBuilder lightTemplateMediaBuilder, MediaModel mediaModel, LightTemplate lightTemplate, CGSize cGSize, VideoRenderChainConfigure videoRenderChainConfigure, boolean z16, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z16 = false;
        }
        return lightTemplateMediaBuilder.buildComposition(mediaModel, lightTemplate, cGSize, videoRenderChainConfigure, z16);
    }

    private final VideoRenderChainManager createVideoRenderChainManager(int applyType, final TAVComposition composition, final MediaModel model, VideoRenderChainManager.IStickerContextInterface renderContextCreator, VideoRenderChainConfigure configure, final LightTemplate lightTemplate) {
        return new VideoRenderChainManager(applyType, composition, model, renderContextCreator, new VideoRenderChainManager.IEffectNodeInterface() { // from class: com.tencent.qcircle.weseevideo.model.template.light.LightTemplateMediaBuilder$createVideoRenderChainManager$1
            @Override // com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IEffectNodeInterface
            public final void insertEffectNode(@NotNull VideoRenderChainManager videoRenderChainManager, @Nullable MediaEffectModel mediaEffectModel) {
                Intrinsics.checkParameterIsNotNull(videoRenderChainManager, "videoRenderChainManager");
                videoRenderChainManager.updateLightVideoRender(LightTemplate.this, model);
                videoRenderChainManager.updateLightAudioRender(LightTemplate.this, composition, model);
            }
        }, configure);
    }

    private final void initBoundsRect(LightTemplate lightTemplate) {
        lightTemplate.getBoundsRect().clear();
        LightAsset lightAsset = lightTemplate.getLightAsset();
        Intrinsics.checkExpressionValueIsNotNull(lightAsset, "lightTemplate.lightAsset");
        for (String str : lightAsset.getBoundsTrackerPlaceHolders()) {
            HashMap<String, RectF> boundsRect = lightTemplate.getBoundsRect();
            Intrinsics.checkExpressionValueIsNotNull(boundsRect, "lightTemplate.boundsRect");
            boundsRect.put(str, lightTemplate.getMovieController().getBoundsByKey(str));
        }
    }

    private final boolean initLightEngine(VideoRenderChainConfigure configure, LightTemplate lightTemplate) {
        int i3;
        if (configure.getApplyType() == 100) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u5f00\u542fLightSDK\u9884\u89e3\u7801\uff0cseekTolerance\uff1a");
            i3 = 120000;
            sb5.append(120000);
            Logger.i(TAG, sb5.toString());
        } else {
            i3 = 0;
        }
        VideoOutputConfig videoOutputConfig = new VideoOutputConfig(30.0f, i3);
        AudioOutputConfig audioOutputConfig = new AudioOutputConfig();
        audioOutputConfig.sampleRate = 44100;
        audioOutputConfig.sampleCount = 2048;
        audioOutputConfig.channels = 1;
        RendererConfig rendererConfig = new RendererConfig(TAVCut.getLightBundleResPath());
        rendererConfig.initMode = 1;
        LightEngine make = LightEngine.make(videoOutputConfig, audioOutputConfig, rendererConfig);
        if (make == null) {
            return false;
        }
        lightTemplate.setLightEngine(make);
        lightTemplate.setMovieController(make.setAssetForMovie(lightTemplate.getLightAsset()));
        return true;
    }

    @VisibleForTesting
    private final boolean parseSegmentInfo(LightMediaTemplateModel lightTemplateModel, LightTemplate lightTemplate) {
        boolean z16;
        ClipPlaceHolder[] clipPlaceHolderArr;
        List<MovieSegmentModel> segmentModels = lightTemplateModel.getSegmentModels();
        if (segmentModels != null && !segmentModels.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            lightTemplate.setSegments(lightTemplateModel.getSegmentModels());
            return true;
        }
        if (lightTemplateModel.getClipPlaceHolders() != null && lightTemplate.isNoDurationLimitTemplate()) {
            LightSegmentHelper lightSegmentHelper = LightSegmentHelper.INSTANCE;
            List<ClipPlaceHolder> clipPlaceHolders = lightTemplateModel.getClipPlaceHolders();
            if (clipPlaceHolders != null) {
                Object[] array = clipPlaceHolders.toArray(new ClipPlaceHolder[0]);
                if (array != null) {
                    clipPlaceHolderArr = (ClipPlaceHolder[]) array;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                clipPlaceHolderArr = null;
            }
            lightTemplate.setSegments(lightSegmentHelper.parseLightSegmentInfo(clipPlaceHolderArr));
        } else {
            LightSegmentHelper lightSegmentHelper2 = LightSegmentHelper.INSTANCE;
            MovieController movieController = lightTemplate.getMovieController();
            Intrinsics.checkExpressionValueIsNotNull(movieController, "lightTemplate.movieController");
            lightTemplate.setSegments(lightSegmentHelper2.parseLightSegmentInfo(movieController.getClipPlaceHolders()));
        }
        return false;
    }

    private final void replaceLightTextData(LightMediaTemplateModel lightTemplateModel, LightTemplate lightTemplate) {
        if (!lightTemplateModel.getLightStickerTextModels().isEmpty()) {
            for (Map.Entry<String, LightStickerTextModel> entry : lightTemplateModel.getLightStickerTextModels().entrySet()) {
                lightTemplate.getMovieController().setTextAsset(entry.getKey(), new TextAsset(entry.getValue().getStickerTextContent(), entry.getValue().getStickerTextColor()));
            }
        }
    }

    private final void updateClipPlaceHolderInfo(LightTemplate lightTemplate, LightMediaTemplateModel lightTemplateModel) {
        int collectionSizeOrDefault;
        if (lightTemplate.isNoDurationLimitTemplate() && lightTemplateModel.getClipPlaceHolders() == null) {
            ArrayList<MovieSegmentModel> lightSegments = lightTemplate.getLightSegments();
            Intrinsics.checkExpressionValueIsNotNull(lightSegments, "lightTemplate.lightSegments");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(lightSegments, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            int i3 = 0;
            for (Object obj : lightSegments) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                MovieSegmentModel it = (MovieSegmentModel) obj;
                MovieController movieController = lightTemplate.getMovieController();
                Intrinsics.checkExpressionValueIsNotNull(movieController, "lightTemplate.movieController");
                int i17 = movieController.getClipPlaceHolders()[i3].fillMode;
                MovieController movieController2 = lightTemplate.getMovieController();
                Intrinsics.checkExpressionValueIsNotNull(movieController2, "lightTemplate.movieController");
                int i18 = movieController2.getClipPlaceHolders()[i3].width;
                MovieController movieController3 = lightTemplate.getMovieController();
                Intrinsics.checkExpressionValueIsNotNull(movieController3, "lightTemplate.movieController");
                int i19 = movieController3.getClipPlaceHolders()[i3].height;
                MovieController movieController4 = lightTemplate.getMovieController();
                Intrinsics.checkExpressionValueIsNotNull(movieController4, "lightTemplate.movieController");
                float f16 = movieController4.getClipPlaceHolders()[i3].volume;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                arrayList.add(new ClipPlaceHolder(it.getVideoResourceModels().get(0).getSelectTimeDurationUs(), i17, i18, i19, f16));
                i3 = i16;
            }
            lightTemplateModel.setClipPlaceHolders(arrayList);
        }
    }

    private final void updateSegmentCount(LightTemplate lightTemplate) {
        List dropLast;
        MovieController movieController = lightTemplate.getMovieController();
        Intrinsics.checkExpressionValueIsNotNull(movieController, "lightTemplate.movieController");
        if (movieController.getClipInfos().length < lightTemplate.getLightSegments().size()) {
            ArrayList<MovieSegmentModel> lightSegments = lightTemplate.getLightSegments();
            Intrinsics.checkExpressionValueIsNotNull(lightSegments, "lightTemplate.lightSegments");
            int size = lightTemplate.getLightSegments().size();
            MovieController movieController2 = lightTemplate.getMovieController();
            Intrinsics.checkExpressionValueIsNotNull(movieController2, "lightTemplate.movieController");
            dropLast = CollectionsKt___CollectionsKt.dropLast(lightSegments, size - movieController2.getClipInfos().length);
            lightTemplate.setLightSegments(new ArrayList<>(dropLast));
        }
    }

    private final void updateSegmentMinDuration(LightTemplate lightTemplate) {
        if (lightTemplate.isNoDurationLimitTemplate()) {
            MovieController movieController = lightTemplate.getMovieController();
            Intrinsics.checkExpressionValueIsNotNull(movieController, "lightTemplate.movieController");
            int length = movieController.getClipInfos().length;
            Iterator<MovieSegmentModel> it = lightTemplate.getLightSegments().iterator();
            Intrinsics.checkExpressionValueIsNotNull(it, "lightTemplate.lightSegments.iterator()");
            for (int i3 = 0; it.hasNext() && i3 < length; i3++) {
                MovieSegmentModel currentSegment = it.next();
                Intrinsics.checkExpressionValueIsNotNull(currentSegment, "currentSegment");
                CMTimeRange timeRange = currentSegment.getTimeRange();
                Intrinsics.checkExpressionValueIsNotNull(timeRange, "currentSegment.timeRange");
                CMTime duration = timeRange.getDuration();
                Intrinsics.checkExpressionValueIsNotNull(duration, "currentSegment.timeRange.duration");
                long j3 = 0;
                if (duration.getTimeUs() != 0) {
                    MovieController movieController2 = lightTemplate.getMovieController();
                    Intrinsics.checkExpressionValueIsNotNull(movieController2, "lightTemplate.movieController");
                    ClipInfo[] clipInfoArr = movieController2.getClipInfos()[i3];
                    Intrinsics.checkExpressionValueIsNotNull(clipInfoArr, "lightTemplate.movieController.clipInfos[i]");
                    for (ClipInfo clipInfo : clipInfoArr) {
                        j3 += clipInfo.sourceTimeRange.duration;
                    }
                    currentSegment.setMinDuration(CMTime.fromUs(j3));
                } else {
                    it.remove();
                }
            }
        }
    }

    private final void updateTemplateDuration(LightTemplate lightTemplate) {
        MovieController movieController = lightTemplate.getMovieController();
        Intrinsics.checkExpressionValueIsNotNull(movieController, "lightTemplate.movieController");
        ClipInfo[][] clipInfos = movieController.getClipInfos();
        Intrinsics.checkExpressionValueIsNotNull(clipInfos, "lightTemplate.movieController.clipInfos");
        MovieController movieController2 = lightTemplate.getMovieController();
        Intrinsics.checkExpressionValueIsNotNull(movieController2, "lightTemplate.movieController");
        ClipPlaceHolder[] clipPlaceHolders = movieController2.getClipPlaceHolders();
        Intrinsics.checkExpressionValueIsNotNull(clipPlaceHolders, "lightTemplate.movieController.clipPlaceHolders");
        ArrayList<MovieSegmentModel> lightSegments = lightTemplate.getLightSegments();
        Intrinsics.checkExpressionValueIsNotNull(lightSegments, "lightTemplate.lightSegments");
        if (!isFullFilled(clipInfos, clipPlaceHolders, lightSegments) || lightTemplate.isNoDurationLimitTemplate()) {
            MovieSegmentModel movieSegmentModel = lightTemplate.getLightSegments().get(lightTemplate.getLightSegments().size() - 1);
            Intrinsics.checkExpressionValueIsNotNull(movieSegmentModel, "lightTemplate.lightSegme\u2026e.lightSegments.size - 1]");
            CMTimeRange timeRange = movieSegmentModel.getTimeRange();
            Intrinsics.checkExpressionValueIsNotNull(timeRange, "lightTemplate.lightSegme\u2026ments.size - 1].timeRange");
            lightTemplate.setDuration(timeRange.getEndUs());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0183  */
    @VisibleForTesting
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TAVComposition buildComposition(@NotNull MediaModel editorModel, @NotNull LightTemplate lightTemplate, @NotNull CGSize renderSize, @NotNull VideoRenderChainConfigure configure, boolean changeMusicByUser) {
        String str;
        ArrayList<ClipAsset> fillOriginResToClipAsset;
        ArrayList<ClipAsset> fillOriginClipsToEmptySegmentTemplate;
        Object[] array;
        Intrinsics.checkParameterIsNotNull(editorModel, "editorModel");
        Intrinsics.checkParameterIsNotNull(lightTemplate, "lightTemplate");
        Intrinsics.checkParameterIsNotNull(renderSize, "renderSize");
        Intrinsics.checkParameterIsNotNull(configure, "configure");
        if (CollectionUtil.isEmptyList(editorModel.getMediaResourceModel().getVideos())) {
            Logger.e(TAG, "LightTemplate segments is empty.");
            return null;
        }
        LightMediaTemplateModel lightTemplateModel = editorModel.getMediaTemplateModel().getLightMediaTemplateModel();
        if (!initLightEngine(configure, lightTemplate)) {
            return null;
        }
        LightSegmentHelper lightSegmentHelper = LightSegmentHelper.INSTANCE;
        MovieController movieController = lightTemplate.getMovieController();
        Intrinsics.checkExpressionValueIsNotNull(movieController, "lightTemplate.movieController");
        lightTemplate.setNoDurationLimitTemplate(lightSegmentHelper.isNoDurationLimitTemplate(movieController.getClipPlaceHolders()));
        Intrinsics.checkExpressionValueIsNotNull(lightTemplateModel, "lightTemplateModel");
        boolean parseSegmentInfo = parseSegmentInfo(lightTemplateModel, lightTemplate);
        if (CollectionUtil.isEmptyList(lightTemplate.getSegments())) {
            Logger.e(TAG, "LightTemplate segments is empty.");
            return null;
        }
        lightTemplate.setDuration(lightTemplate.getMovieController().duration());
        if (parseSegmentInfo) {
            ArrayList<MovieSegmentModel> lightSegments = lightTemplate.getLightSegments();
            Intrinsics.checkExpressionValueIsNotNull(lightSegments, "lightTemplate.lightSegments");
            fillOriginClipsToEmptySegmentTemplate = lightSegmentHelper.fillSegmentToClipAsset(lightSegments, editorModel.getMediaEffectModel().getMusicModel().getVolume());
        } else if (lightTemplate.isNoDurationLimitTemplate() && lightTemplateModel.getClipPlaceHolders() == null) {
            List<MediaClipModel> videos = editorModel.getMediaResourceModel().getVideos();
            List<MovieSegmentModel> segments = lightTemplate.getSegments();
            Intrinsics.checkExpressionValueIsNotNull(segments, "lightTemplate.segments");
            fillOriginClipsToEmptySegmentTemplate = lightSegmentHelper.fillOriginClipsToEmptySegmentTemplate(videos, segments, editorModel.getMediaEffectModel().getMusicModel().getVolume());
        } else {
            float volume = editorModel.getMediaEffectModel().getMusicModel().getVolume();
            List<MediaClipModel> videos2 = editorModel.getMediaResourceModel().getVideos();
            List<MovieSegmentModel> segments2 = lightTemplate.getSegments();
            Intrinsics.checkExpressionValueIsNotNull(segments2, "lightTemplate.segments");
            str = "lightTemplate.movieController";
            fillOriginResToClipAsset = lightSegmentHelper.fillOriginResToClipAsset(videos2, segments2, volume, lightTemplate.getDuration());
            MovieController movieController2 = lightTemplate.getMovieController();
            boolean z16 = false;
            array = fillOriginResToClipAsset.toArray(new ClipAsset[0]);
            if (array == null) {
                movieController2.setClipAssets((ClipAsset[]) array, lightTemplateModel.getBackgroundEffectPath(), configure.isModifyClip());
                MovieController movieController3 = lightTemplate.getMovieController();
                Intrinsics.checkExpressionValueIsNotNull(movieController3, str);
                ClipInfo[][] clipInfos = movieController3.getClipInfos();
                Intrinsics.checkExpressionValueIsNotNull(clipInfos, "lightTemplate.movieController.clipInfos");
                if (clipInfos.length == 0) {
                    z16 = true;
                }
                if (z16) {
                    Logger.e(TAG, "setClipAssets called but clipInfo is empty. Build failed!!");
                    return null;
                }
                MovieController movieController4 = lightTemplate.getMovieController();
                Intrinsics.checkExpressionValueIsNotNull(movieController4, str);
                ClipInfo[][] clipInfos2 = movieController4.getClipInfos();
                Intrinsics.checkExpressionValueIsNotNull(clipInfos2, "lightTemplate.movieController.clipInfos");
                ArrayList<MovieSegmentModel> lightSegments2 = lightTemplate.getLightSegments();
                Intrinsics.checkExpressionValueIsNotNull(lightSegments2, "lightTemplate.lightSegments");
                updateSegmentTimeRange(clipInfos2, lightSegments2);
                updateSegmentCount(lightTemplate);
                if (lightTemplateModel.getClipPlaceHolders() == null) {
                    updateSegmentMinDuration(lightTemplate);
                }
                updateTemplateDuration(lightTemplate);
                updateClipPlaceHolderInfo(lightTemplate, lightTemplateModel);
                MovieController movieController5 = lightTemplate.getMovieController();
                Intrinsics.checkExpressionValueIsNotNull(movieController5, str);
                replaceLightPresetData(movieController5, lightTemplate.getFilePath());
                replaceLightTextData(lightTemplateModel, lightTemplate);
                initBoundsRect(lightTemplate);
                TAVComposition generateTAVComposition = generateTAVComposition(renderSize, lightTemplate.getDuration());
                bindAudioPlaceHolder(editorModel, lightTemplate, lightTemplateModel, generateTAVComposition, changeMusicByUser);
                return generateTAVComposition;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        fillOriginResToClipAsset = fillOriginClipsToEmptySegmentTemplate;
        str = "lightTemplate.movieController";
        MovieController movieController22 = lightTemplate.getMovieController();
        boolean z162 = false;
        array = fillOriginResToClipAsset.toArray(new ClipAsset[0]);
        if (array == null) {
        }
    }

    @VisibleForTesting
    @NotNull
    public final TAVComposition generateTAVComposition(@NotNull CGSize renderSize, long durationUs) {
        Intrinsics.checkParameterIsNotNull(renderSize, "renderSize");
        TAVComposition tAVComposition = new TAVComposition();
        tAVComposition.setRenderSize(renderSize);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new TAVClip(new TAVEmptyResource(CMTime.fromUs(durationUs), true, true)));
        arrayList.add(arrayList2);
        tAVComposition.setVideoChannels(arrayList);
        return tAVComposition;
    }

    @VisibleForTesting
    public final boolean isFullFilled(@NotNull ClipInfo[][] cilpInfos, @NotNull ClipPlaceHolder[] clipPlaceHolders, @NotNull List<? extends MovieSegmentModel> lightSegments) {
        Intrinsics.checkParameterIsNotNull(cilpInfos, "cilpInfos");
        Intrinsics.checkParameterIsNotNull(clipPlaceHolders, "clipPlaceHolders");
        Intrinsics.checkParameterIsNotNull(lightSegments, "lightSegments");
        if (lightSegments.size() < clipPlaceHolders.length) {
            return false;
        }
        int length = cilpInfos.length - 1;
        ArrayList<VideoResourceModel> videoResourceModels = lightSegments.get(length).getVideoResourceModels();
        Intrinsics.checkExpressionValueIsNotNull(videoResourceModels, "lightSegments[lastIndex].videoResourceModels");
        Iterator<T> it = videoResourceModels.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += ((VideoResourceModel) it.next()).getSelectTimeDurationUs();
        }
        if (j3 < clipPlaceHolders[length].contentDuration) {
            return false;
        }
        return true;
    }

    @Nullable
    public final HashMap<String, String> replaceLightPresetData(@NotNull final MovieController movieController, @Nullable String filePath) {
        Intrinsics.checkParameterIsNotNull(movieController, "movieController");
        HashMap<String, String> assetData = movieController.getAssetData();
        if (assetData != null && assetData.size() != 0) {
            final HashMap<String, String> hashMap = new HashMap<>();
            LightPatterHelper.fillNickName(assetData, hashMap);
            LightPatterHelper.fillDate(assetData, hashMap);
            LightPatterHelper.fillLocation(assetData, hashMap);
            LightPatterHelper.fillWeather(assetData, hashMap);
            LightPatterHelper.fillWatermark(assetData, hashMap);
            LightPatterHelper.fillAvatar(assetData, hashMap, filePath, new XffectsDownloadListener() { // from class: com.tencent.qcircle.weseevideo.model.template.light.LightTemplateMediaBuilder$replaceLightPresetData$1
                @Override // com.tencent.qcircle.weishi.module.publisher.interfaces.XffectsDownloadListener
                public void onDownloadFailed(@NotNull String url) {
                    Intrinsics.checkParameterIsNotNull(url, "url");
                }

                @Override // com.tencent.qcircle.weishi.module.publisher.interfaces.XffectsDownloadListener
                public void onDownloadSucceed(@NotNull String url, @NotNull String path) {
                    Intrinsics.checkParameterIsNotNull(url, "url");
                    Intrinsics.checkParameterIsNotNull(path, "path");
                    hashMap.put(LightPatterHelper.KEY_AVATAR, path);
                    movieController.setAssetData(hashMap);
                }
            });
            movieController.setAssetData(hashMap);
            return hashMap;
        }
        return null;
    }

    @VisibleForTesting
    public final void updateSegmentTimeRange(@NotNull ClipInfo[][] clipInfos, @NotNull List<? extends MovieSegmentModel> lightSegments) {
        Object orNull;
        Long l3;
        Long l16;
        Long l17;
        Long l18;
        int i3;
        long coerceAtMost;
        long coerceAtLeast;
        Intrinsics.checkParameterIsNotNull(clipInfos, "clipInfos");
        Intrinsics.checkParameterIsNotNull(lightSegments, "lightSegments");
        int length = clipInfos.length;
        int i16 = 0;
        int i17 = 0;
        while (i16 < length) {
            ClipInfo[] clipInfoArr = clipInfos[i16];
            int length2 = clipInfoArr.length;
            long j3 = Long.MAX_VALUE;
            long j16 = Long.MIN_VALUE;
            int i18 = 0;
            while (i18 < length2) {
                ClipInfo clipInfo = clipInfoArr[i18];
                StringBuilder sb5 = new StringBuilder();
                sb5.append("clipInfo: sourceTimeRange:[");
                TimeRange timeRange = clipInfo.sourceTimeRange;
                VideoResourceModel videoResourceModel = null;
                int i19 = i16;
                if (timeRange != null) {
                    l3 = Long.valueOf(timeRange.startTime);
                } else {
                    l3 = null;
                }
                sb5.append(l3);
                sb5.append(", ");
                TimeRange timeRange2 = clipInfo.sourceTimeRange;
                ClipInfo[] clipInfoArr2 = clipInfoArr;
                int i26 = length2;
                if (timeRange2 != null) {
                    l16 = Long.valueOf(timeRange2.duration);
                } else {
                    l16 = null;
                }
                sb5.append(l16);
                sb5.append("], targetTimeRange:[");
                TimeRange timeRange3 = clipInfo.targetTimeRange;
                if (timeRange3 != null) {
                    l17 = Long.valueOf(timeRange3.startTime);
                } else {
                    l17 = null;
                }
                sb5.append(l17);
                sb5.append(", ");
                TimeRange timeRange4 = clipInfo.targetTimeRange;
                if (timeRange4 != null) {
                    l18 = Long.valueOf(timeRange4.duration);
                } else {
                    l18 = null;
                }
                sb5.append(l18);
                sb5.append("], path:");
                sb5.append(clipInfo.path);
                Logger.i("miles", sb5.toString());
                ArrayList<VideoResourceModel> videoResourceModels = lightSegments.get(i17).getVideoResourceModels();
                Intrinsics.checkExpressionValueIsNotNull(videoResourceModels, "lightSegments[index].videoResourceModels");
                Iterator<VideoResourceModel> it = videoResourceModels.iterator();
                int i27 = 0;
                while (true) {
                    if (it.hasNext()) {
                        if (Intrinsics.areEqual(it.next().getPath(), clipInfo.path)) {
                            break;
                        } else {
                            i27++;
                        }
                    } else {
                        i27 = -1;
                        break;
                    }
                }
                if (i27 != -1) {
                    VideoResourceModel videoResourceModel2 = lightSegments.get(i17).getVideoResourceModels().get(i27);
                    if (videoResourceModel2 != null) {
                        TimeRange timeRange5 = clipInfo.sourceTimeRange;
                        long j17 = timeRange5.startTime;
                        long j18 = timeRange5.duration;
                        i3 = length;
                        videoResourceModel = VideoResourceModel.copy$default(videoResourceModel2, null, j18 / 1000, 0, 0L, 0L, j17, j18, 0L, 0L, 0, 0, 0, null, 8093, null);
                    } else {
                        i3 = length;
                    }
                    lightSegments.get(i17).getVideoResourceModels().set(i27, videoResourceModel);
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(j3, clipInfo.targetTimeRange.startTime);
                    TimeRange timeRange6 = clipInfo.targetTimeRange;
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j16, timeRange6.startTime + timeRange6.duration);
                    j3 = coerceAtMost;
                    j16 = coerceAtLeast;
                } else {
                    i3 = length;
                }
                i18++;
                length = i3;
                clipInfoArr = clipInfoArr2;
                i16 = i19;
                length2 = i26;
            }
            int i28 = length;
            int i29 = i16;
            CMTime cMTime = new CMTime(j3, 1000000);
            CMTime cMTime2 = new CMTime(j16 - j3, 1000000);
            orNull = CollectionsKt___CollectionsKt.getOrNull(lightSegments, i17);
            MovieSegmentModel movieSegmentModel = (MovieSegmentModel) orNull;
            if (movieSegmentModel != null) {
                movieSegmentModel.setTimeRange(new CMTimeRange(cMTime, cMTime2));
            }
            i17++;
            i16 = i29 + 1;
            length = i28;
        }
    }
}
