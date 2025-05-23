package com.tencent.tavcut.core.render.builder.light;

import com.tencent.tavcut.core.render.builder.IMediaBuilder;
import com.tencent.tavcut.core.render.builder.MediaBuilderOutput;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.RenderScene;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavkit.composition.TAVComposition;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.MovieController;
import org.light.TimeLine;
import org.light.listener.OnClipAssetListener;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\\\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/LightMediaBuilder;", "Lcom/tencent/tavcut/core/render/builder/IMediaBuilder;", "()V", "COMPOSITION_DURATION_MAX", "", "TAG", "", "buildComposition", "Lcom/tencent/tavcut/core/render/builder/MediaBuilderOutput;", "templatePath", "renderModel", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "loadFromJson", "", "isUE4Template", "listener", "Lorg/light/listener/OnClipAssetListener;", "assetData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class LightMediaBuilder implements IMediaBuilder {
    private static final long COMPOSITION_DURATION_MAX = 216000000000L;
    public static final LightMediaBuilder INSTANCE = new LightMediaBuilder();
    private static final String TAG = "LightMediaBuilder";

    LightMediaBuilder() {
    }

    @Override // com.tencent.tavcut.core.render.builder.IMediaBuilder
    @Nullable
    public MediaBuilderOutput buildComposition(@NotNull String templatePath, @NotNull LAKRenderModel renderModel, boolean loadFromJson, boolean isUE4Template, @Nullable OnClipAssetListener listener, @Nullable HashMap<String, String> assetData) {
        boolean z16;
        TimeLine[] timeLineArr;
        long j3;
        long j16;
        LAKRenderModel copy;
        long j17;
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        TavLogger.d(TAG, "start buildComposition...");
        try {
            LightRenderChainManager lightRenderChainManager = new LightRenderChainManager();
            if (listener != null) {
                lightRenderChainManager.setClipAssetListener(listener);
            }
            int authLightSdk = lightRenderChainManager.authLightSdk();
            if (authLightSdk != 0) {
                TavLogger.e(TAG, "Auth Light-sdk failed, auth result is " + authLightSdk);
                return null;
            }
            lightRenderChainManager.initLightAsset(templatePath, renderModel, loadFromJson);
            lightRenderChainManager.setCustomRenderConfig(renderModel.getCustomRenderConfig());
            lightRenderChainManager.initEngine(renderModel, templatePath, renderModel.getSeekTolerance(), isUE4Template);
            if (assetData != null && !assetData.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                lightRenderChainManager.setAssetData(assetData);
            }
            String stickerValue = renderModel.getStickerValue();
            if (stickerValue != null) {
                lightRenderChainManager.setTextAsset(stickerValue);
            }
            lightRenderChainManager.initLightNode(templatePath, renderModel, isUE4Template);
            lightRenderChainManager.initLightAudioNode();
            lightRenderChainManager.setClipAssets(LightEntityTransHelper.transClipSourcesToClipAssets(renderModel.getClipsAssets()), renderModel.getPainting().getPagPath(), renderModel.getModifyClipsDuration());
            MovieController movieController = lightRenderChainManager.getMovieController();
            if (movieController == null || (timeLineArr = movieController.getTimeLines()) == null) {
                timeLineArr = new TimeLine[0];
            }
            LightRenderChainManager.initDuration$default(lightRenderChainManager, timeLineArr, 0L, 2, null);
            if (lightRenderChainManager.getMovieController() == null) {
                TavLogger.e(TAG, "movieController is null.");
            }
            MovieController movieController2 = lightRenderChainManager.getMovieController();
            if (movieController2 != null) {
                j3 = movieController2.duration();
            } else {
                j3 = 0;
            }
            if (j3 == 0) {
                TavLogger.e(TAG, "get total duration failed. errorCode:-4");
            }
            TavLogger.e(TAG, "get total movieController duration: " + j3);
            if (renderModel.getMaxDuration() != -1) {
                j16 = Math.min(j3, renderModel.getMaxDuration());
            } else {
                j16 = j3;
            }
            TavLogger.d(TAG, timeLineArr + ", size:" + timeLineArr.length);
            long j18 = j16;
            copy = renderModel.copy((r37 & 1) != 0 ? renderModel.renderScene : null, (r37 & 2) != 0 ? renderModel.root : null, (r37 & 4) != 0 ? renderModel.jsonData : null, (r37 & 8) != 0 ? renderModel.inputSources : null, (r37 & 16) != 0 ? renderModel.painting : null, (r37 & 32) != 0 ? renderModel.clipsAssets : null, (r37 & 64) != 0 ? renderModel.modifyClipsDuration : false, (r37 & 128) != 0 ? renderModel.seekTolerance : 0, (r37 & 256) != 0 ? renderModel.properties : null, (r37 & 512) != 0 ? renderModel.audioAssets : null, (r37 & 1024) != 0 ? renderModel.timeLines : LightEntityTransHelper.transLightTimeLineToTimeline(timeLineArr), (r37 & 2048) != 0 ? renderModel.maxDuration : 0L, (r37 & 4096) != 0 ? renderModel.componentLevel : 0, (r37 & 8192) != 0 ? renderModel.voiceChangerConfig : null, (r37 & 16384) != 0 ? renderModel.customRenderConfig : null, (r37 & 32768) != 0 ? renderModel.exportMode : false, (r37 & 65536) != 0 ? renderModel.stickerValue : null, (r37 & 131072) != 0 ? renderModel.watermarkConfig : null);
            RenderScene renderScene = renderModel.getRenderScene();
            RenderScene renderScene2 = RenderScene.PLAY;
            if (renderScene == renderScene2) {
                j17 = COMPOSITION_DURATION_MAX;
            } else {
                j17 = j18;
            }
            TAVComposition buildComposition = lightRenderChainManager.buildComposition(j17);
            if (renderModel.getRenderScene() == renderScene2 || renderModel.getRenderScene() == RenderScene.EXPORTER) {
                lightRenderChainManager.setVoiceChangerConfig(renderModel.getVoiceChangerConfig());
            }
            lightRenderChainManager.setRenderNodeDuration(j18);
            return new MediaBuilderOutput(lightRenderChainManager, copy, buildComposition, j18);
        } catch (Throwable th5) {
            TavLogger.e(TAG, "buildComposition error:" + th5.getMessage());
            return null;
        }
    }
}
