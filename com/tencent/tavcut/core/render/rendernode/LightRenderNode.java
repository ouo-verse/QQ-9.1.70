package com.tencent.tavcut.core.render.rendernode;

import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavcut.core.render.LightAiManager;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.render.rendernode.ImageParams;
import com.tencent.tavcut.core.session.IRenderCallback;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import com.tencent.tavcut.core.session.LightContextReadyCallback;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightEngine;
import org.light.LightSurface;
import org.light.MovieConfig;
import org.light.VideoOutput;
import vd4.a;
import vd4.b;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0001%B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013J\u0016\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0015J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/tavcut/core/render/rendernode/LightRenderNode;", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "lightEngine", "Lorg/light/LightEngine;", "movieConfig", "Lorg/light/MovieConfig;", "lightContextReadyCallback", "Lcom/tencent/tavcut/core/session/LightContextReadyCallback;", "isUE4Template", "", "(Lorg/light/LightEngine;Lorg/light/MovieConfig;Lcom/tencent/tavcut/core/session/LightContextReadyCallback;Z)V", "lightFilter", "Lcom/tencent/tavcut/core/render/rendernode/LightRenderNode$LightFilter;", "nodeDurationUs", "", "nodeFrameRate", "", "nodeSyncEnable", "renderListener", "Lcom/tencent/tavcut/core/session/IRenderCallback;", "renderTimeListener", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "addRenderCallback", "", "callback", "createFilter", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode$Filter;", "getReportKey", "", "removeRenderCallback", "setRenderSyncMode", "enable", "frameRate", "setRenderTimeListener", "listener", "setTotalDuration", "duration", LightFilter.TAG, "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class LightRenderNode extends BaseEffectNode {
    private final boolean isUE4Template;
    private final LightContextReadyCallback lightContextReadyCallback;
    private final LightEngine lightEngine;
    private LightFilter lightFilter;
    private final MovieConfig movieConfig;
    private long nodeDurationUs;
    private int nodeFrameRate;
    private boolean nodeSyncEnable;
    private IRenderCallback renderListener;
    private IRenderTimeListener renderTimeListener;

    public /* synthetic */ LightRenderNode(LightEngine lightEngine, MovieConfig movieConfig, LightContextReadyCallback lightContextReadyCallback, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : lightEngine, (i3 & 2) != 0 ? null : movieConfig, lightContextReadyCallback, (i3 & 8) != 0 ? false : z16);
    }

    public final void addRenderCallback(@NotNull IRenderCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.renderListener = callback;
        LightFilter lightFilter = this.lightFilter;
        if (lightFilter != null) {
            lightFilter.addRenderCallback(callback);
        }
    }

    @Override // com.tencent.tavcut.core.render.rendernode.BaseEffectNode
    @NotNull
    public BaseEffectNode.Filter createFilter() {
        LightFilter lightFilter;
        LightFilter lightFilter2 = new LightFilter(this.lightEngine, this.movieConfig, this.lightContextReadyCallback, this.isUE4Template);
        this.lightFilter = lightFilter2;
        lightFilter2.setSyncEnable(this.nodeSyncEnable);
        LightFilter lightFilter3 = this.lightFilter;
        if (lightFilter3 != null) {
            lightFilter3.setCurFrameRate(this.nodeFrameRate);
        }
        LightFilter lightFilter4 = this.lightFilter;
        if (lightFilter4 != null) {
            lightFilter4.setDurationUs(this.nodeDurationUs);
        }
        LightFilter lightFilter5 = this.lightFilter;
        if (lightFilter5 != null) {
            lightFilter5.setRenderTimeListener(this.renderTimeListener);
        }
        IRenderCallback iRenderCallback = this.renderListener;
        if (iRenderCallback != null && (lightFilter = this.lightFilter) != null) {
            lightFilter.addRenderCallback(iRenderCallback);
        }
        LightFilter lightFilter6 = this.lightFilter;
        if (lightFilter6 == null) {
            Intrinsics.throwNpe();
        }
        return lightFilter6;
    }

    @Override // com.tencent.tavkit.report.IReportable
    @NotNull
    public String getReportKey() {
        return getEffectId();
    }

    public final void removeRenderCallback(@NotNull IRenderCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        LightFilter lightFilter = this.lightFilter;
        if (lightFilter != null) {
            lightFilter.removeRenderCallback(callback);
        }
    }

    public final void setRenderSyncMode(boolean enable, int frameRate) {
        this.nodeSyncEnable = enable;
        this.nodeFrameRate = frameRate;
    }

    public final void setRenderTimeListener(@NotNull IRenderTimeListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.renderTimeListener = listener;
        LightFilter lightFilter = this.lightFilter;
        if (lightFilter != null) {
            lightFilter.setListener(listener);
        }
    }

    public final void setTotalDuration(long duration) {
        this.nodeDurationUs = duration;
        LightFilter lightFilter = this.lightFilter;
        if (lightFilter != null) {
            lightFilter.setDurationUs(duration);
        }
    }

    public LightRenderNode(@Nullable LightEngine lightEngine, @Nullable MovieConfig movieConfig, @NotNull LightContextReadyCallback lightContextReadyCallback, boolean z16) {
        Intrinsics.checkParameterIsNotNull(lightContextReadyCallback, "lightContextReadyCallback");
        this.lightEngine = lightEngine;
        this.movieConfig = movieConfig;
        this.lightContextReadyCallback = lightContextReadyCallback;
        this.isUE4Template = z16;
        this.nodeSyncEnable = true;
        this.nodeFrameRate = 30;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 `2\u00020\u0001:\u0001`B-\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\b\u0010X\u001a\u0004\u0018\u00010W\u0012\u0006\u0010[\u001a\u00020Z\u0012\b\b\u0002\u0010]\u001a\u00020\u0010\u00a2\u0006\u0004\b^\u0010_J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0017J\b\u0010\u001a\u001a\u00020\u0002H\u0016R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u001d\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u001d\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u0016\u0010@\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00108R$\u0010A\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00170G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u00108R\u0016\u0010K\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u00108R\u0014\u0010L\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bL\u00108R\u0016\u0010M\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u00108R\u0016\u0010N\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u00108R\u0016\u0010O\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u00108R\u0016\u0010P\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u00108R\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u0004\u0018\u00010T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u0004\u0018\u00010W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010-\u00a8\u0006a"}, d2 = {"Lcom/tencent/tavcut/core/render/rendernode/LightRenderNode$LightFilter;", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode$Filter;", "", "updateTrackSticker", "resetReportData", "", "beginTime", "endTime", "reportTimeData", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "renderInfo", "initReader", "Lcom/tencent/tavcut/core/render/rendernode/ImageParams;", "imageParams", "applySync", "applyAsync", "", "isTextureChanged", "isNeedApply", "apply", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "listener", "setListener", "Lcom/tencent/tavcut/core/session/IRenderCallback;", "addRenderCallback", "removeRenderCallback", "release", "", "MAX_FRAME_COUNT", "I", "FIRST_FRAME_COUNT", "SECOND_FRAME_COUNT", "Lorg/light/VideoOutput;", "videoOutput", "Lorg/light/VideoOutput;", "Lcom/tencent/tav/coremedia/TextureInfo;", "textureInfo", "Lcom/tencent/tav/coremedia/TextureInfo;", "Lorg/light/LightSurface;", "lightSurface", "Lorg/light/LightSurface;", "Lvd4/b;", "tracing", "Lvd4/b;", "syncEnable", "Z", "getSyncEnable", "()Z", "setSyncEnable", "(Z)V", "curFrameRate", "getCurFrameRate", "()I", "setCurFrameRate", "(I)V", "durationUs", "J", "getDurationUs", "()J", "setDurationUs", "(J)V", "firstFrameCount", "getFirstFrameCount", "setFirstFrameCount", "predictedTime", "renderTimeListener", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "getRenderTimeListener", "()Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "setRenderTimeListener", "(Lcom/tencent/tavcut/core/session/IRenderTimeListener;)V", "", "renderCallbackList", "Ljava/util/List;", "lastResetTimeMs", "lastEndTime", "leapTimeMs", "frameCostSum", "frameCount", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "renderNodeCostSum", "Ljava/util/concurrent/CountDownLatch;", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "Lorg/light/LightEngine;", "lightEngine", "Lorg/light/LightEngine;", "Lorg/light/MovieConfig;", "movieConfig", "Lorg/light/MovieConfig;", "Lcom/tencent/tavcut/core/session/LightContextReadyCallback;", "lightContextReadyCallback", "Lcom/tencent/tavcut/core/session/LightContextReadyCallback;", "isUE4Template", "<init>", "(Lorg/light/LightEngine;Lorg/light/MovieConfig;Lcom/tencent/tavcut/core/session/LightContextReadyCallback;Z)V", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class LightFilter implements BaseEffectNode.Filter {

        @NotNull
        public static final String TAG = "LightFilter";
        private final int FIRST_FRAME_COUNT;
        private final int MAX_FRAME_COUNT;
        private final int SECOND_FRAME_COUNT;
        private CountDownLatch countDownLatch;
        private int curFrameRate;
        private long currentTime;
        private long durationUs;
        private int firstFrameCount;
        private long frameCostSum;
        private long frameCount;
        private final boolean isUE4Template;
        private long lastEndTime;
        private long lastResetTimeMs;
        private final long leapTimeMs;
        private final LightContextReadyCallback lightContextReadyCallback;
        private final LightEngine lightEngine;
        private LightSurface lightSurface;
        private final MovieConfig movieConfig;
        private long predictedTime;
        private List<IRenderCallback> renderCallbackList;
        private long renderNodeCostSum;

        @Nullable
        private IRenderTimeListener renderTimeListener;
        private boolean syncEnable;
        private TextureInfo textureInfo;
        private final b tracing;
        private VideoOutput videoOutput;

        public LightFilter(@Nullable LightEngine lightEngine, @Nullable MovieConfig movieConfig, @NotNull LightContextReadyCallback lightContextReadyCallback, boolean z16) {
            Intrinsics.checkParameterIsNotNull(lightContextReadyCallback, "lightContextReadyCallback");
            this.lightEngine = lightEngine;
            this.movieConfig = movieConfig;
            this.lightContextReadyCallback = lightContextReadyCallback;
            this.isUE4Template = z16;
            this.MAX_FRAME_COUNT = 5;
            this.FIRST_FRAME_COUNT = 1;
            this.SECOND_FRAME_COUNT = 2;
            this.tracing = new b("LightRenderFilter");
            this.syncEnable = true;
            this.curFrameRate = 30;
            this.predictedTime = -1L;
            this.renderCallbackList = new ArrayList();
            this.lastEndTime = -1L;
            this.leapTimeMs = 1000L;
            this.countDownLatch = new CountDownLatch(1);
        }

        private final void applyAsync(ImageParams imageParams, RenderInfo renderInfo) {
            if (this.videoOutput == null || isTextureChanged(renderInfo)) {
                initReader(renderInfo);
            }
            b.d(this.tracing, null, 1, null);
            Intrinsics.checkExpressionValueIsNotNull(renderInfo.getTime(), "renderInfo.time");
            double d16 = ((r13.value * 1.0d) / r13.timeScale) * 1000000;
            TavLogger.d(TAG, "current render time: " + d16);
            long ceil = (long) Math.ceil(d16);
            if (this.predictedTime == -1) {
                TavLogger.d(TAG, "AsyncRenderMode applyAsync setSyncMode true step in ");
                MovieConfig movieConfig = this.movieConfig;
                if (movieConfig != null) {
                    movieConfig.setSyncMode(true);
                }
                VideoOutput videoOutput = this.videoOutput;
                if (videoOutput != null) {
                    videoOutput.readSample(ceil);
                }
            }
            long floor = (float) Math.floor(1000000.0f / this.curFrameRate);
            long j3 = ceil + floor;
            TavLogger.d(TAG, "AsyncRenderMode applyAsync targetTime = " + ceil + " predictedTime = " + this.predictedTime + " nextTime = " + j3 + " oneFrameTimeInUs =" + floor);
            if (j3 > this.durationUs) {
                TavLogger.d(TAG, "current render isLastFrame NextTime: " + j3 + ", targetTime: " + ceil);
                VideoOutput videoOutput2 = this.videoOutput;
                if (videoOutput2 != null) {
                    videoOutput2.readSample(this.durationUs);
                }
                this.currentTime = this.durationUs;
            } else {
                MovieConfig movieConfig2 = this.movieConfig;
                if (movieConfig2 != null) {
                    movieConfig2.setSyncMode(false);
                }
                TavLogger.d(TAG, "current render NextTime: " + j3);
                VideoOutput videoOutput3 = this.videoOutput;
                if (videoOutput3 != null) {
                    videoOutput3.readSample(j3);
                }
                this.currentTime = j3;
            }
            this.predictedTime = j3;
            this.tracing.a();
            imageParams.getVideoChannelImages().clear();
            List<ImageParams.ImageTrackPair> videoChannelImages = imageParams.getVideoChannelImages();
            TextureInfo textureInfo = this.textureInfo;
            if (textureInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
            }
            videoChannelImages.add(new ImageParams.ImageTrackPair(new CIImage(textureInfo), null));
        }

        private final void applySync(ImageParams imageParams, RenderInfo renderInfo) {
            if (this.videoOutput == null || isTextureChanged(renderInfo)) {
                initReader(renderInfo);
            }
            b.d(this.tracing, null, 1, null);
            Intrinsics.checkExpressionValueIsNotNull(renderInfo.getTime(), "renderInfo.time");
            long ceil = (long) Math.ceil(((r7.value * 1.0d) / r7.timeScale) * 1000000);
            this.currentTime = ceil;
            if (this.durationUs < ceil) {
                TavLogger.d(TAG, "current frame timestamp is out of range:" + this.currentTime + ", read last frame: " + this.durationUs + ", ");
                this.currentTime = this.durationUs;
            }
            VideoOutput videoOutput = this.videoOutput;
            if (videoOutput != null) {
                videoOutput.readSample(this.currentTime);
            }
            this.tracing.a();
            imageParams.getVideoChannelImages().clear();
            List<ImageParams.ImageTrackPair> videoChannelImages = imageParams.getVideoChannelImages();
            TextureInfo textureInfo = this.textureInfo;
            if (textureInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
            }
            videoChannelImages.add(new ImageParams.ImageTrackPair(new CIImage(textureInfo), null));
        }

        private final void initReader(RenderInfo renderInfo) {
            VideoOutput videoOutput;
            TavLogger.d(TAG, "initReader.");
            TextureInfo newTextureInfo = CIContext.newTextureInfo(renderInfo.getRenderSize());
            Intrinsics.checkExpressionValueIsNotNull(newTextureInfo, "CIContext.newTextureInfo(renderInfo.renderSize)");
            this.textureInfo = newTextureInfo;
            if (newTextureInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
            }
            int i3 = newTextureInfo.textureID;
            TextureInfo textureInfo = this.textureInfo;
            if (textureInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
            }
            int i16 = textureInfo.width;
            TextureInfo textureInfo2 = this.textureInfo;
            if (textureInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
            }
            LightSurface makeFromTexture = LightSurface.makeFromTexture(i3, i16, textureInfo2.height, true);
            this.lightSurface = makeFromTexture;
            LightEngine lightEngine = this.lightEngine;
            if (lightEngine != null) {
                lightEngine.setSurface(makeFromTexture);
            }
            MovieConfig movieConfig = this.movieConfig;
            if (movieConfig != null) {
                TextureInfo textureInfo3 = this.textureInfo;
                if (textureInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
                }
                int i17 = textureInfo3.width;
                TextureInfo textureInfo4 = this.textureInfo;
                if (textureInfo4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
                }
                movieConfig.setRenderSize(i17, textureInfo4.height);
            }
            LightEngine lightEngine2 = this.lightEngine;
            if (lightEngine2 != null) {
                videoOutput = lightEngine2.videoOutput();
            } else {
                videoOutput = null;
            }
            this.videoOutput = videoOutput;
            LightAiManager lightAiManager = LightAiManager.INSTANCE;
            MovieConfig movieConfig2 = this.movieConfig;
            if (movieConfig2 == null) {
                Intrinsics.throwNpe();
            }
            lightAiManager.setupAgentPath(movieConfig2);
        }

        private final boolean isTextureChanged(RenderInfo renderInfo) {
            TextureInfo textureInfo = this.textureInfo;
            if (textureInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
            }
            if (textureInfo.width == renderInfo.getRenderWidth()) {
                TextureInfo textureInfo2 = this.textureInfo;
                if (textureInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
                }
                if (textureInfo2.height == renderInfo.getRenderHeight()) {
                    return false;
                }
            }
            return true;
        }

        private final void reportTimeData(long beginTime, long endTime) {
            IRenderTimeListener iRenderTimeListener = this.renderTimeListener;
            if (iRenderTimeListener != null) {
                long j3 = this.lastEndTime;
                if (j3 > 0) {
                    long j16 = endTime - j3;
                    long j17 = endTime - beginTime;
                    long j18 = this.frameCount + 1;
                    this.frameCount = j18;
                    long j19 = this.frameCostSum + j16;
                    this.frameCostSum = j19;
                    long j26 = this.renderNodeCostSum + j17;
                    this.renderNodeCostSum = j26;
                    if (endTime - this.lastResetTimeMs > this.leapTimeMs && j18 != 0) {
                        iRenderTimeListener.onRenderTimeCost(j19 / j18, j26 / j18, this.currentTime);
                        resetReportData();
                        this.lastResetTimeMs = endTime;
                    }
                    iRenderTimeListener.onSingleFrameTimeCost(j16, j17, this.currentTime);
                } else {
                    this.lastResetTimeMs = endTime;
                }
                this.lastEndTime = endTime;
            }
        }

        private final void resetReportData() {
            this.lastResetTimeMs = 0L;
            this.lastEndTime = -1L;
            this.frameCostSum = 0L;
            this.frameCount = 0L;
            this.renderNodeCostSum = 0L;
        }

        public final void addRenderCallback(@NotNull IRenderCallback listener) {
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            this.renderCallbackList.add(listener);
        }

        @Override // com.tencent.tavcut.core.render.rendernode.BaseEffectNode.Filter
        public void apply(@NotNull ImageParams imageParams, @NotNull RenderInfo renderInfo) {
            Intrinsics.checkParameterIsNotNull(imageParams, "imageParams");
            Intrinsics.checkParameterIsNotNull(renderInfo, "renderInfo");
            updateTrackSticker();
            int i3 = this.firstFrameCount;
            if (i3 < this.MAX_FRAME_COUNT) {
                this.firstFrameCount = i3 + 1;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.firstFrameCount == this.SECOND_FRAME_COUNT) {
                TavLogger.d("FirstFrameCost", "playTime secondFrame begin , currentTimeMillis: " + currentTimeMillis);
                IRenderTimeListener iRenderTimeListener = this.renderTimeListener;
                if (iRenderTimeListener != null) {
                    iRenderTimeListener.onFirstFrameTimeFinish(currentTimeMillis);
                }
            }
            for (IRenderCallback iRenderCallback : this.renderCallbackList) {
                CMTime time = renderInfo.getTime();
                Intrinsics.checkExpressionValueIsNotNull(time, "renderInfo.time");
                iRenderCallback.onBeforeRender(time.getTimeUs());
            }
            if (this.syncEnable) {
                applySync(imageParams, renderInfo);
            } else {
                applyAsync(imageParams, renderInfo);
            }
            for (IRenderCallback iRenderCallback2 : this.renderCallbackList) {
                CMTime time2 = renderInfo.getTime();
                Intrinsics.checkExpressionValueIsNotNull(time2, "renderInfo.time");
                long timeUs = time2.getTimeUs();
                TextureInfo textureInfo = this.textureInfo;
                if (textureInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
                }
                iRenderCallback2.onRender(timeUs, textureInfo);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (this.firstFrameCount == this.FIRST_FRAME_COUNT) {
                TavLogger.d("FirstFrameCost", "playTime firstFrame finish , currentTimeMillis: " + currentTimeMillis2);
                IRenderTimeListener iRenderTimeListener2 = this.renderTimeListener;
                if (iRenderTimeListener2 != null) {
                    iRenderTimeListener2.onFirstFrameTimeFinish(currentTimeMillis2);
                }
            }
            reportTimeData(currentTimeMillis, currentTimeMillis2);
        }

        public final int getCurFrameRate() {
            return this.curFrameRate;
        }

        public final long getDurationUs() {
            return this.durationUs;
        }

        public final int getFirstFrameCount() {
            return this.firstFrameCount;
        }

        @Nullable
        public final IRenderTimeListener getRenderTimeListener() {
            return this.renderTimeListener;
        }

        public final boolean getSyncEnable() {
            return this.syncEnable;
        }

        @Override // com.tencent.tavcut.core.render.rendernode.BaseEffectNode.Filter
        public boolean isNeedApply(@Nullable RenderInfo renderInfo) {
            return true;
        }

        @Override // com.tencent.tavcut.core.render.rendernode.BaseEffectNode.Filter
        public void release() {
            a.f441477a.a(this.tracing);
            VideoOutput videoOutput = this.videoOutput;
            if (videoOutput != null) {
                videoOutput.release();
            }
            TextureInfo textureInfo = this.textureInfo;
            if (textureInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
            }
            if (textureInfo != null) {
                textureInfo.release();
            }
            this.renderCallbackList.clear();
            if (this.isUE4Template) {
                this.countDownLatch.countDown();
            }
        }

        public final void removeRenderCallback(@NotNull IRenderCallback listener) {
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            if (this.renderCallbackList.contains(listener)) {
                this.renderCallbackList.remove(listener);
            }
        }

        public final void setCurFrameRate(int i3) {
            this.curFrameRate = i3;
        }

        public final void setDurationUs(long j3) {
            this.durationUs = j3;
        }

        public final void setFirstFrameCount(int i3) {
            this.firstFrameCount = i3;
        }

        public final void setListener(@NotNull IRenderTimeListener listener) {
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            this.renderTimeListener = listener;
        }

        public final void setRenderTimeListener(@Nullable IRenderTimeListener iRenderTimeListener) {
            this.renderTimeListener = iRenderTimeListener;
        }

        public final void setSyncEnable(boolean z16) {
            this.syncEnable = z16;
        }

        public /* synthetic */ LightFilter(LightEngine lightEngine, MovieConfig movieConfig, LightContextReadyCallback lightContextReadyCallback, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(lightEngine, movieConfig, lightContextReadyCallback, (i3 & 8) != 0 ? false : z16);
        }

        private final void updateTrackSticker() {
        }
    }
}
