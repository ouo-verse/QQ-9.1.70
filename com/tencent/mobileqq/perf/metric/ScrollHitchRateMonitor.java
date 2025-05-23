package com.tencent.mobileqq.perf.metric;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import com.tencent.mobileqq.perf.metric.config.ScrollHitchConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000e\u001a\u00020\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u0016\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/perf/metric/ScrollHitchRateMonitor;", "", "", "d", "", "g", "frameTimeNanos", "", "isScrolling", "c", "", "scene", h.F, "i", "f", "a", "J", "frameIndex", "b", "lastFrameTime", "scrollDuration", "hitchedDuration", "e", "frameIntervalNanos", "hitchThresholdNanos", "Ljava/lang/String;", "mLastScene", "Landroid/os/HandlerThread;", "Lkotlin/Lazy;", "getHandlerThread", "()Landroid/os/HandlerThread;", "handlerThread", "Landroid/os/Handler;", "()Landroid/os/Handler;", "handler", "<init>", "()V", "j", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ScrollHitchRateMonitor {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long frameIndex;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long lastFrameTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long scrollDuration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long hitchedDuration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long frameIntervalNanos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long hitchThresholdNanos;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mLastScene;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy handlerThread;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/perf/metric/ScrollHitchRateMonitor$a;", "", "", "MSG_DO_REPORT", "I", "MSG_RESET_SCROLL", "ONE_MILLI_SECOND_IN_NANOS", "", "PARAM_FRAME_INDEX", "Ljava/lang/String;", "PARAM_HITCH_DURATION", "PARAM_HITCH_RATE", "PARAM_SCENE", "PARAM_SCROLL_DURATION", "SCROLL_DETECT_THRESHOLD", "TAG", "", "TRACE_DEBUG", "Z", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.metric.ScrollHitchRateMonitor$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31457);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ScrollHitchRateMonitor() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLastScene = "";
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ScrollHitchRateMonitor$handlerThread$2.INSTANCE);
        this.handlerThread = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new ScrollHitchRateMonitor$handler$2(this));
        this.handler = lazy2;
        long d16 = d();
        this.frameIntervalNanos = d16;
        this.hitchThresholdNanos = (long) (d16 * ScrollHitchConfig.INSTANCE.a().b());
        QLog.d("ScrollHitchRate", 1, "frameIntervalNanos: " + this.frameIntervalNanos + ", hitchThresholdNanos:" + this.hitchThresholdNanos);
    }

    private final long d() {
        float f16;
        Display display;
        Object systemService = BaseApplication.context.getSystemService("display");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Display[] displays = ((DisplayManager) systemService).getDisplays();
        if (displays != null && (display = displays[0]) != null) {
            f16 = (int) display.getRefreshRate();
        } else {
            f16 = 60.0f;
        }
        QLog.d("ScrollHitchRate", 1, "refreshRate: " + f16);
        return 1.0E9f / f16;
    }

    private final Handler e() {
        return (Handler) this.handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.lastFrameTime = 0L;
        this.scrollDuration = 0L;
        this.hitchedDuration = 0L;
        this.frameIndex = 0L;
    }

    public final void c(long frameTimeNanos, boolean isScrolling) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(frameTimeNanos), Boolean.valueOf(isScrolling));
            return;
        }
        if (!isScrolling) {
            this.lastFrameTime = frameTimeNanos;
            return;
        }
        long j3 = this.lastFrameTime;
        if (j3 > 0) {
            long j16 = frameTimeNanos - j3;
            long j17 = 1000000;
            this.scrollDuration += j16 / j17;
            this.frameIndex++;
            if (j16 > this.hitchThresholdNanos) {
                this.hitchedDuration += (j16 - this.frameIntervalNanos) / j17;
            }
        }
        this.lastFrameTime = frameTimeNanos;
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            e().removeMessages(1);
            e().sendEmptyMessageDelayed(1, 100L);
        }
    }

    public final void h(@Nullable String scene) {
        String substringAfterLast$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) scene);
            return;
        }
        if (scene != null) {
            substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(scene, '.', (String) null, 2, (Object) null);
            if (!Intrinsics.areEqual(this.mLastScene, substringAfterLast$default)) {
                i(this.mLastScene);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ScrollHitchRate", 4, "startTracking by " + substringAfterLast$default + ", lastScene is " + this.mLastScene);
            }
            this.mLastScene = substringAfterLast$default;
            g();
        }
    }

    public final void i(@Nullable String scene) {
        String substringAfterLast$default;
        HashMap hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) scene);
            return;
        }
        if (scene != null) {
            substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(scene, '.', (String) null, 2, (Object) null);
            if (QLog.isColorLevel()) {
                QLog.d("ScrollHitchRate", 4, "stopTracking by " + substringAfterLast$default + ", totalInterval is " + this.scrollDuration);
            }
            if (this.scrollDuration > 0 && this.frameIndex >= ScrollHitchConfig.INSTANCE.a().c()) {
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("scrollDuration", String.valueOf(this.scrollDuration)), TuplesKt.to("hitchDuration", String.valueOf(this.hitchedDuration)), TuplesKt.to("scene", substringAfterLast$default), TuplesKt.to("frameIndex", String.valueOf(this.frameIndex)));
                e().sendMessage(Message.obtain(e(), 2, hashMapOf));
                g();
            }
        }
    }
}
