package com.tencent.tavcut.render.builder.light;

import ae4.MediaBuilderOutput;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.RenderScene;
import com.tencent.tavkit.composition.TAVComposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.MovieController;
import org.light.TimeLine;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/render/builder/light/b;", "Lae4/a;", "", "templatePath", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "", "isInit", "isUE4Template", "Lae4/c;", "a", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class b implements ae4.a {

    /* renamed from: a, reason: collision with root package name */
    public static final b f374379a = new b();

    b() {
    }

    @Override // ae4.a
    @Nullable
    public MediaBuilderOutput a(@NotNull String templatePath, @NotNull RenderModel renderModel, boolean isInit, boolean isUE4Template) {
        TimeLine[] timeLineArr;
        long j3;
        RenderModel copy;
        long j16;
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        ee4.b.a("LightMediaBuilder", "start buildComposition...");
        LightRenderChainManager lightRenderChainManager = new LightRenderChainManager();
        int o16 = lightRenderChainManager.o();
        if (o16 != 0) {
            ee4.b.b("LightMediaBuilder", "Auth Light-sdk failed, auth result is " + o16);
            return null;
        }
        if (isInit) {
            lightRenderChainManager.w(templatePath);
        } else {
            lightRenderChainManager.x(templatePath, renderModel);
        }
        lightRenderChainManager.F(renderModel.getCustomRenderConfig());
        lightRenderChainManager.v(templatePath, renderModel.getSeekTolerance(), isUE4Template);
        lightRenderChainManager.z(templatePath, renderModel, isUE4Template);
        lightRenderChainManager.y();
        lightRenderChainManager.D(a.a(renderModel.getClipsAssets()), renderModel.getPainting().pagPath, renderModel.getModifyClipsDuration());
        MovieController movieController = lightRenderChainManager.getMovieController();
        if (movieController == null || (timeLineArr = movieController.getTimeLines()) == null) {
            timeLineArr = new TimeLine[0];
        }
        LightRenderChainManager.u(lightRenderChainManager, timeLineArr, 0L, 2, null);
        if (lightRenderChainManager.getMovieController() == null) {
            ee4.b.b("LightMediaBuilder", "movieController is null.");
        }
        MovieController movieController2 = lightRenderChainManager.getMovieController();
        if (movieController2 != null) {
            j3 = movieController2.duration();
        } else {
            j3 = 0;
        }
        if (j3 == 0) {
            ee4.b.b("LightMediaBuilder", "get total duration failed. errorCode:-4");
        }
        if (renderModel.getMaxDuration() != -1) {
            j3 = Math.min(j3, renderModel.getMaxDuration());
        }
        long j17 = j3;
        ee4.b.a("LightMediaBuilder", timeLineArr + ", size:" + timeLineArr.length);
        copy = renderModel.copy((r32 & 1) != 0 ? renderModel.renderScene : null, (r32 & 2) != 0 ? renderModel.root : null, (r32 & 4) != 0 ? renderModel.inputSources : null, (r32 & 8) != 0 ? renderModel.painting : null, (r32 & 16) != 0 ? renderModel.clipsAssets : null, (r32 & 32) != 0 ? renderModel.modifyClipsDuration : false, (r32 & 64) != 0 ? renderModel.seekTolerance : 0, (r32 & 128) != 0 ? renderModel.properties : null, (r32 & 256) != 0 ? renderModel.audioAssets : null, (r32 & 512) != 0 ? renderModel.timeLines : a.b(timeLineArr), (r32 & 1024) != 0 ? renderModel.maxDuration : 0L, (r32 & 2048) != 0 ? renderModel.componentLevel : 0, (r32 & 4096) != 0 ? renderModel.voiceChangerConfig : null, (r32 & 8192) != 0 ? renderModel.customRenderConfig : null);
        RenderScene renderScene = renderModel.getRenderScene();
        RenderScene renderScene2 = RenderScene.PLAY;
        if (renderScene == renderScene2) {
            j16 = 216000000000L;
        } else {
            j16 = j17;
        }
        TAVComposition p16 = lightRenderChainManager.p(j16);
        if (renderModel.getRenderScene() == renderScene2 || renderModel.getRenderScene() == RenderScene.EXPORTER) {
            lightRenderChainManager.setVoiceChangerConfig(renderModel.getVoiceChangerConfig());
        }
        lightRenderChainManager.setRenderNodeDuration(j17);
        return new MediaBuilderOutput(lightRenderChainManager, copy, p16, j17);
    }
}
