package fe4;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavcut.core.render.rendernode.LightRenderNode;
import com.tencent.tavcut.session.f;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import fe4.a;
import fe4.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightEngine;
import org.light.LightSurface;
import org.light.MovieConfig;
import org.light.UEUtil;
import org.light.VideoOutput;
import org.light.listener.AIDLOnUE4EngineInitFInishListener;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0003B1\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010!\u0012\u0006\u0010(\u001a\u00020%\u0012\b\b\u0002\u0010*\u001a\u00020\u0012\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001cR\u0016\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u0014\u00a8\u0006-"}, d2 = {"Lfe4/c;", "Lfe4/a;", "Lfe4/a$b;", "a", "", "getReportKey", "", "duration", "", h.F, "Lcom/tencent/tavcut/session/b;", "callback", "f", "g", "Lfe4/c$a;", "c", "Lfe4/c$a;", "lightFilter", "", "d", "Z", "nodeSyncEnable", "", "e", "I", "nodeFrameRate", "J", "nodeDurationUs", "Lcom/tencent/tavcut/session/b;", "renderListener", "Lorg/light/LightEngine;", "Lorg/light/LightEngine;", "lightEngine", "Lorg/light/MovieConfig;", "i", "Lorg/light/MovieConfig;", "movieConfig", "Lcom/tencent/tavcut/session/f;", "j", "Lcom/tencent/tavcut/session/f;", "lightContextReadyCallback", "k", "isUE4Template", "<init>", "(Lorg/light/LightEngine;Lorg/light/MovieConfig;Lcom/tencent/tavcut/session/f;Z)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class c extends fe4.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private a lightFilter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean nodeSyncEnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int nodeFrameRate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long nodeDurationUs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.tencent.tavcut.session.b renderListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final LightEngine lightEngine;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MovieConfig movieConfig;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final f lightContextReadyCallback;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final boolean isUE4Template;

    public c(@Nullable LightEngine lightEngine, @Nullable MovieConfig movieConfig, @NotNull f lightContextReadyCallback, boolean z16) {
        Intrinsics.checkParameterIsNotNull(lightContextReadyCallback, "lightContextReadyCallback");
        this.lightEngine = lightEngine;
        this.movieConfig = movieConfig;
        this.lightContextReadyCallback = lightContextReadyCallback;
        this.isUE4Template = z16;
        this.nodeSyncEnable = true;
        this.nodeFrameRate = 30;
    }

    @Override // fe4.a
    @NotNull
    public a.b a() {
        a aVar;
        a aVar2 = new a(this.lightEngine, this.movieConfig, this.lightContextReadyCallback, this.isUE4Template);
        this.lightFilter = aVar2;
        aVar2.l(this.nodeSyncEnable);
        a aVar3 = this.lightFilter;
        if (aVar3 != null) {
            aVar3.i(this.nodeFrameRate);
        }
        a aVar4 = this.lightFilter;
        if (aVar4 != null) {
            aVar4.j(this.nodeDurationUs);
        }
        a aVar5 = this.lightFilter;
        if (aVar5 != null) {
            aVar5.k(null);
        }
        com.tencent.tavcut.session.b bVar = this.renderListener;
        if (bVar != null && (aVar = this.lightFilter) != null) {
            aVar.b(bVar);
        }
        a aVar6 = this.lightFilter;
        if (aVar6 == null) {
            Intrinsics.throwNpe();
        }
        return aVar6;
    }

    public final void f(@NotNull com.tencent.tavcut.session.b callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.renderListener = callback;
        a aVar = this.lightFilter;
        if (aVar != null) {
            aVar.b(callback);
        }
    }

    public final void g(@NotNull com.tencent.tavcut.session.b callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        a aVar = this.lightFilter;
        if (aVar != null) {
            aVar.g(callback);
        }
    }

    @Override // com.tencent.tavkit.report.IReportable
    @NotNull
    public String getReportKey() {
        return b();
    }

    public final void h(long duration) {
        this.nodeDurationUs = duration;
        a aVar = this.lightFilter;
        if (aVar != null) {
            aVar.j(duration);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 b2\u00020\u0001:\u0001\u0012B-\u0012\b\u0010O\u001a\u0004\u0018\u00010L\u0012\b\u0010S\u001a\u0004\u0018\u00010P\u0012\u0006\u0010W\u001a\u00020T\u0012\b\b\u0002\u0010Y\u001a\u00020\u000f\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010'R\"\u0010.\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00103\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0019\u001a\u0004\b0\u00101\"\u0004\b/\u00102R\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b4\u00108R\"\u0010=\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0019\u001a\u0004\b;\u00101\"\u0004\b<\u00102R\u0016\u0010>\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00105R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00130?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010@R\u0016\u0010C\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00105R\u0014\u0010E\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bD\u00105R\u0016\u0010G\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u00105R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u0004\u0018\u00010L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u0004\u0018\u00010P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010Y\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010)R$\u0010[\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b:\u0010_\u00a8\u0006c"}, d2 = {"Lfe4/c$a;", "Lfe4/a$b;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "beginTime", "endTime", h.F, "Lcom/tencent/tavkit/composition/video/RenderInfo;", "renderInfo", "e", "Lfe4/b;", "imageParams", "d", "c", "", "f", "isNeedApply", "a", "Lcom/tencent/tavcut/session/b;", "listener", "b", "g", "release", "", "I", "MAX_FRAME_COUNT", "FIRST_FRAME_COUNT", "SECOND_FRAME_COUNT", "Lorg/light/VideoOutput;", "Lorg/light/VideoOutput;", "videoOutput", "Lcom/tencent/tav/coremedia/TextureInfo;", "Lcom/tencent/tav/coremedia/TextureInfo;", "textureInfo", "Lorg/light/LightSurface;", "Lorg/light/LightSurface;", "lightSurface", "Lje4/b;", "Lje4/b;", "tracing", "Z", "getSyncEnable", "()Z", "l", "(Z)V", "syncEnable", "i", "getCurFrameRate", "()I", "(I)V", "curFrameRate", "j", "J", "getDurationUs", "()J", "(J)V", "durationUs", "k", "getFirstFrameCount", "setFirstFrameCount", "firstFrameCount", "predictedTime", "", "Ljava/util/List;", "renderCallbackList", DomainData.DOMAIN_NAME, "lastEndTime", "o", "leapTimeMs", "p", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "Ljava/util/concurrent/CountDownLatch;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/concurrent/CountDownLatch;", "countDownLatch", "Lorg/light/LightEngine;", "r", "Lorg/light/LightEngine;", "lightEngine", "Lorg/light/MovieConfig;", ReportConstant.COSTREPORT_PREFIX, "Lorg/light/MovieConfig;", "movieConfig", "Lcom/tencent/tavcut/session/f;", "t", "Lcom/tencent/tavcut/session/f;", "lightContextReadyCallback", "u", "isUE4Template", "Lcom/tencent/tavcut/session/c;", "renderTimeListener", "Lcom/tencent/tavcut/session/c;", "getRenderTimeListener", "()Lcom/tencent/tavcut/session/c;", "(Lcom/tencent/tavcut/session/c;)V", "<init>", "(Lorg/light/LightEngine;Lorg/light/MovieConfig;Lcom/tencent/tavcut/session/f;Z)V", "v", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class a implements a.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int MAX_FRAME_COUNT;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int FIRST_FRAME_COUNT;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int SECOND_FRAME_COUNT;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private VideoOutput videoOutput;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private TextureInfo textureInfo;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private LightSurface lightSurface;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final je4.b tracing;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean syncEnable;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int curFrameRate;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private long durationUs;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int firstFrameCount;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private long predictedTime;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private List<com.tencent.tavcut.session.b> renderCallbackList;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private long lastEndTime;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private final long leapTimeMs;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private long currentTime;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        private CountDownLatch countDownLatch;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        private final LightEngine lightEngine;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        private final MovieConfig movieConfig;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        private final f lightContextReadyCallback;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        private final boolean isUE4Template;

        public a(@Nullable LightEngine lightEngine, @Nullable MovieConfig movieConfig, @NotNull f lightContextReadyCallback, boolean z16) {
            Intrinsics.checkParameterIsNotNull(lightContextReadyCallback, "lightContextReadyCallback");
            this.lightEngine = lightEngine;
            this.movieConfig = movieConfig;
            this.lightContextReadyCallback = lightContextReadyCallback;
            this.isUE4Template = z16;
            this.MAX_FRAME_COUNT = 5;
            this.FIRST_FRAME_COUNT = 1;
            this.SECOND_FRAME_COUNT = 2;
            this.tracing = new je4.b("LightRenderFilter");
            this.syncEnable = true;
            this.curFrameRate = 30;
            this.predictedTime = -1L;
            this.renderCallbackList = new ArrayList();
            this.lastEndTime = -1L;
            this.leapTimeMs = 1000L;
            this.countDownLatch = new CountDownLatch(1);
        }

        private final void c(b imageParams, RenderInfo renderInfo) {
            if (this.videoOutput == null || f(renderInfo)) {
                e(renderInfo);
            }
            je4.b.d(this.tracing, null, 1, null);
            Intrinsics.checkExpressionValueIsNotNull(renderInfo.getTime(), "renderInfo.time");
            double d16 = ((r13.value * 1.0d) / r13.timeScale) * 1000000;
            ee4.b.a(LightRenderNode.LightFilter.TAG, "current render time: " + d16);
            long ceil = (long) Math.ceil(d16);
            if (this.predictedTime == -1) {
                ee4.b.a(LightRenderNode.LightFilter.TAG, "AsyncRenderMode applyAsync setSyncMode true step in ");
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
            ee4.b.a(LightRenderNode.LightFilter.TAG, "AsyncRenderMode applyAsync targetTime = " + ceil + " predictedTime = " + this.predictedTime + " nextTime = " + j3 + " oneFrameTimeInUs =" + floor);
            if (j3 > this.durationUs) {
                ee4.b.a(LightRenderNode.LightFilter.TAG, "current render isLastFrame NextTime: " + j3 + ", targetTime: " + ceil);
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
                ee4.b.a(LightRenderNode.LightFilter.TAG, "current render NextTime: " + j3);
                VideoOutput videoOutput3 = this.videoOutput;
                if (videoOutput3 != null) {
                    videoOutput3.readSample(j3);
                }
                this.currentTime = j3;
            }
            this.predictedTime = j3;
            this.tracing.a();
            imageParams.a().clear();
            List<b.a> a16 = imageParams.a();
            TextureInfo textureInfo = this.textureInfo;
            if (textureInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
            }
            a16.add(new b.a(new CIImage(textureInfo), null));
        }

        private final void d(b imageParams, RenderInfo renderInfo) {
            if (this.videoOutput == null || f(renderInfo)) {
                e(renderInfo);
            }
            je4.b.d(this.tracing, null, 1, null);
            Intrinsics.checkExpressionValueIsNotNull(renderInfo.getTime(), "renderInfo.time");
            double d16 = ((r8.value * 1.0d) / r8.timeScale) * 1000000;
            ee4.b.a(LightRenderNode.LightFilter.TAG, "current render time: " + d16);
            long ceil = (long) Math.ceil(d16);
            this.currentTime = ceil;
            if (this.durationUs < ceil) {
                ee4.b.a(LightRenderNode.LightFilter.TAG, "current frame timestamp is out of range:" + this.currentTime + ", read last frame: " + this.durationUs + ", ");
                this.currentTime = this.durationUs;
            }
            VideoOutput videoOutput = this.videoOutput;
            if (videoOutput != null) {
                videoOutput.readSample(this.currentTime);
            }
            this.tracing.a();
            imageParams.a().clear();
            List<b.a> a16 = imageParams.a();
            TextureInfo textureInfo = this.textureInfo;
            if (textureInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
            }
            a16.add(new b.a(new CIImage(textureInfo), null));
        }

        private final void e(final RenderInfo renderInfo) {
            VideoOutput videoOutput;
            ee4.b.a(LightRenderNode.LightFilter.TAG, "initReader.");
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
            if (this.isUE4Template && !UEUtil.checkUE4Ready()) {
                LightSurface lightSurface = this.lightSurface;
                if (lightSurface != null) {
                    lightSurface.makeRenderCurrent();
                    long renderCurrentGLContext = lightSurface.getRenderCurrentGLContext();
                    lightSurface.clearRenderCurrent();
                    UEUtil.initUE4(renderCurrentGLContext, od4.b.f422509e.o(), renderInfo.getRenderWidth(), renderInfo.getRenderHeight(), new AIDLOnUE4EngineInitFInishListener.Stub() { // from class: fe4.LightRenderNode$LightFilter$initReader$$inlined$let$lambda$1
                    });
                    this.countDownLatch.await(10L, TimeUnit.SECONDS);
                }
            } else if (this.isUE4Template) {
                this.lightContextReadyCallback.lightContextReady();
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
            zd4.c cVar = zd4.c.f452391c;
            MovieConfig movieConfig2 = this.movieConfig;
            if (movieConfig2 == null) {
                Intrinsics.throwNpe();
            }
            cVar.c(movieConfig2);
        }

        private final boolean f(RenderInfo renderInfo) {
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

        @Override // fe4.a.b
        public void a(@NotNull b imageParams, @NotNull RenderInfo renderInfo) {
            Intrinsics.checkParameterIsNotNull(imageParams, "imageParams");
            Intrinsics.checkParameterIsNotNull(renderInfo, "renderInfo");
            m();
            int i3 = this.firstFrameCount;
            if (i3 < this.MAX_FRAME_COUNT) {
                this.firstFrameCount = i3 + 1;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.firstFrameCount == this.SECOND_FRAME_COUNT) {
                ee4.b.a("FirstFrameCost", "playTime secondFrame begin , currentTimeMillis: " + currentTimeMillis);
            }
            ee4.b.a(LightRenderNode.LightFilter.TAG, "LightRenderNode apply begin timeInMs: " + currentTimeMillis + "(ms)");
            for (com.tencent.tavcut.session.b bVar : this.renderCallbackList) {
                CMTime time = renderInfo.getTime();
                Intrinsics.checkExpressionValueIsNotNull(time, "renderInfo.time");
                bVar.onBeforeRender(time.getTimeUs());
            }
            if (this.syncEnable) {
                d(imageParams, renderInfo);
            } else {
                c(imageParams, renderInfo);
            }
            for (com.tencent.tavcut.session.b bVar2 : this.renderCallbackList) {
                CMTime time2 = renderInfo.getTime();
                Intrinsics.checkExpressionValueIsNotNull(time2, "renderInfo.time");
                long timeUs = time2.getTimeUs();
                TextureInfo textureInfo = this.textureInfo;
                if (textureInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
                }
                bVar2.onRender(timeUs, textureInfo);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (this.firstFrameCount == this.FIRST_FRAME_COUNT) {
                ee4.b.a("FirstFrameCost", "playTime firstFrame finish , currentTimeMillis: " + currentTimeMillis2);
            }
            h(currentTimeMillis, currentTimeMillis2);
            ee4.b.a(LightRenderNode.LightFilter.TAG, "LightRenderNode apply end timeInMs: " + currentTimeMillis2 + "(ms), costTime: " + (currentTimeMillis2 - currentTimeMillis) + "(ms)");
        }

        public final void b(@NotNull com.tencent.tavcut.session.b listener) {
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            this.renderCallbackList.add(listener);
        }

        public final void g(@NotNull com.tencent.tavcut.session.b listener) {
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            if (this.renderCallbackList.contains(listener)) {
                this.renderCallbackList.remove(listener);
            }
        }

        public final void i(int i3) {
            this.curFrameRate = i3;
        }

        @Override // fe4.a.b
        public boolean isNeedApply(@Nullable RenderInfo renderInfo) {
            return true;
        }

        public final void j(long j3) {
            this.durationUs = j3;
        }

        public final void l(boolean z16) {
            this.syncEnable = z16;
        }

        @Override // fe4.a.b
        public void release() {
            je4.a.f409861a.a(this.tracing);
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

        private final void m() {
        }

        public final void k(@Nullable com.tencent.tavcut.session.c cVar) {
        }

        private final void h(long beginTime, long endTime) {
        }
    }
}
