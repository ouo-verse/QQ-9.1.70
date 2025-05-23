package com.tencent.mobileqq.guild.util;

import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Choreographer;
import android.view.View;
import androidx.core.view.OneShotPreDrawListener;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r*\u0001(\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001;B\t\b\u0002\u00a2\u0006\u0004\b:\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0004J$\u0010\u0018\u001a\u00020\u0004*\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016R!\u0010 \u001a\u00020\u00198FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010#\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00100R\u0016\u00103\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00102R$\u00104\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/util/TraceUtils;", "", "", "event", "", tl.h.F, "k", "", "g", "cookie", "j", "filename", "", "durationInMs", "o", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/util/TraceUtils$a;", "i", "intervalUs", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Landroid/view/View;", "Lkotlin/Function0;", "block", "e", "", "b", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "getTraceEnable$annotations", "()V", "traceEnable", "c", "Z", "traceEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "running", "com/tencent/mobileqq/guild/util/TraceUtils$b", "Lcom/tencent/mobileqq/guild/util/TraceUtils$b;", "invalidationLoop", "Ljava/util/concurrent/atomic/AtomicInteger;", "f", "Ljava/util/concurrent/atomic/AtomicInteger;", "generator", "Ljava/io/File;", "Ljava/io/File;", "methodTraceFile", "J", "methodTraceStartTime", "traceCallback", "Lcom/tencent/mobileqq/guild/util/TraceUtils$a;", "l", "()Lcom/tencent/mobileqq/guild/util/TraceUtils$a;", "setTraceCallback", "(Lcom/tencent/mobileqq/guild/util/TraceUtils$a;)V", "<init>", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class TraceUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TraceUtils f235403a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy traceEnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean traceEnabled;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicBoolean running;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b invalidationLoop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicInteger generator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static File methodTraceFile;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long methodTraceStartTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/util/TraceUtils$a;", "", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface a {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/util/TraceUtils$b", "Landroid/view/Choreographer$FrameCallback;", "", "frameTimeNanos", "", "doFrame", "", "d", "I", AIInput.KEY_FRAME, "e", "J", "time", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements Choreographer.FrameCallback {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int frame;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long time;

        b() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            if (SystemClock.uptimeMillis() - this.time > 2000) {
                this.time = SystemClock.uptimeMillis();
                this.frame = 0;
            } else {
                this.frame++;
            }
            if (TraceUtils.running.get()) {
                Choreographer.getInstance().postFrameCallback(this);
            } else {
                Choreographer.getInstance().removeFrameCallback(this);
            }
        }
    }

    static {
        Lazy lazy;
        TraceUtils traceUtils = new TraceUtils();
        f235403a = traceUtils;
        traceUtils.i();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.util.TraceUtils$traceEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).getTraceEnable());
            }
        });
        traceEnable = lazy;
        running = new AtomicBoolean(false);
        invalidationLoop = new b();
        if (m() && Build.VERSION.SDK_INT < 31) {
            try {
                if (!traceEnabled) {
                    traceEnabled = true;
                    Trace.class.getMethod("setAppTracingAllowed", Boolean.TYPE).invoke(null, Boolean.TRUE);
                    Looper.class.getMethod("setTraceTag", Long.TYPE).invoke(Looper.getMainLooper(), 4096L);
                }
            } catch (Exception e16) {
                if (e16 instanceof InvocationTargetException) {
                    Throwable cause = e16.getCause();
                    if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    }
                    throw new RuntimeException(cause);
                }
                QLog.e("TraceUtils", 1, "Unable to enable trace via reflection", e16);
            }
        }
        generator = new AtomicInteger(0);
    }

    TraceUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String event, Function0 function0) {
        Intrinsics.checkNotNullParameter(event, "$event");
        n(event);
        if (function0 != null) {
            function0.invoke();
        }
    }

    @JvmStatic
    public static final int g(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int incrementAndGet = generator.incrementAndGet();
        if (!m()) {
            return incrementAndGet;
        }
        cy.a(4096L, event, incrementAndGet);
        return incrementAndGet;
    }

    @JvmStatic
    public static final void h(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!m()) {
            return;
        }
        cy.c(event);
    }

    private final a i() {
        return null;
    }

    @JvmStatic
    public static final void j(@NotNull String event, int cookie) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!m()) {
            return;
        }
        cy.b(4096L, event, cookie);
    }

    @JvmStatic
    public static final void k() {
        if (!m()) {
            return;
        }
        cy.d();
    }

    public static final boolean m() {
        return ((Boolean) traceEnable.getValue()).booleanValue();
    }

    @JvmStatic
    public static final void n(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        cy.c(event);
        cy.d();
    }

    @JvmStatic
    public static final void o(@NotNull String filename, long durationInMs) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        if (!m()) {
            return;
        }
        final File file = new File(MobileQQ.sMobileQQ.getExternalFilesDir("android"), "guild-" + filename + ".trace");
        Logger.f235387a.d().i("TraceUtils", 1, "startMethodTrace: " + file.getAbsolutePath() + ", duration = " + durationInMs + " ms...");
        Debug.startMethodTracing(file.getAbsolutePath(), 1073741824);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.guild.util.cu
            @Override // java.lang.Runnable
            public final void run() {
                TraceUtils.p(file);
            }
        }, 16, null, false, durationInMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(File file) {
        Intrinsics.checkNotNullParameter(file, "$file");
        Logger.f235387a.d().i("TraceUtils", 1, "stopMethodTrace: " + file.getAbsolutePath() + MiniBoxNoticeInfo.APPNAME_SUFFIX);
        Debug.stopMethodTracing();
    }

    public final void e(@NotNull View view, @NotNull final String event, @Nullable final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        OneShotPreDrawListener.add(view, new Runnable() { // from class: com.tencent.mobileqq.guild.util.ct
            @Override // java.lang.Runnable
            public final void run() {
                TraceUtils.f(event, function0);
            }
        });
    }

    @Nullable
    public final a l() {
        return null;
    }

    public final void q(@NotNull String filename, int intervalUs) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        if (!m()) {
            return;
        }
        methodTraceStartTime = System.nanoTime() / 1000;
        File file = new File(MobileQQ.sMobileQQ.getExternalFilesDir("android"), "guild-" + filename + '-' + methodTraceStartTime + ".trace");
        methodTraceFile = file;
        Intrinsics.checkNotNull(file);
        Debug.startMethodTracingSampling(file.getAbsolutePath(), 268435456, intervalUs);
        Logger.a d16 = Logger.f235387a.d();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startMethodTraceSampling: ");
        File file2 = methodTraceFile;
        Intrinsics.checkNotNull(file2);
        sb5.append(file2.getAbsolutePath());
        sb5.append(", intervalUs = ");
        sb5.append(intervalUs);
        d16.i("TraceUtils", 1, sb5.toString());
    }

    public final void r() {
        if (methodTraceFile != null) {
            long nanoTime = (System.nanoTime() / 1000) - methodTraceStartTime;
            Logger.a d16 = Logger.f235387a.d();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("stopMethodTraceSampling: ");
            File file = methodTraceFile;
            Intrinsics.checkNotNull(file);
            sb5.append(file.getAbsolutePath());
            sb5.append(", cost: ");
            sb5.append(nanoTime);
            sb5.append(" us...");
            d16.i("TraceUtils", 1, sb5.toString());
            Debug.stopMethodTracing();
            methodTraceFile = null;
        }
    }
}
