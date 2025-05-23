package com.tencent.mobileqq.perf.block;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.open.base.g;
import com.tencent.qqperf.debug.report.PerfProblemBusinessHandler;
import com.tencent.util.AppSetting;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import jy3.MainBlockMethodProblem;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/perf/block/MainBlockMethodMonitor;", "", "()V", "TAG", "", "entryTime", "", "isMainThread", "", "isPublicVersion", "onMethodEnd", "", "suffix", "onMethodStart", "TimingCacheReporter", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class MainBlockMethodMonitor {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final MainBlockMethodMonitor INSTANCE;

    @NotNull
    private static final String TAG = "MainBlockMethodMonitor";
    private static long entryTime;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c2\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0002J(\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/perf/block/MainBlockMethodMonitor$TimingCacheReporter;", "", "()V", "REPORT_MIN_INTERVAL_MS", "", "stack2ProblemMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/perf/block/MainBlockMethodMonitor$TimingCacheReporter$Problem;", "Lkotlin/collections/HashMap;", "reportProblem", "", "p", "reportViolationForMR", "type", "stackTrace", QCircleWeakNetReporter.KEY_COST, "", "count", "tryReport", "Problem", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class TimingCacheReporter {
        static IPatchRedirector $redirector_ = null;

        @NotNull
        public static final TimingCacheReporter INSTANCE;
        private static final int REPORT_MIN_INTERVAL_MS = 30000;

        @NotNull
        private static final HashMap<String, Problem> stack2ProblemMap;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/perf/block/MainBlockMethodMonitor$TimingCacheReporter$Problem;", "", QCircleWeakNetReporter.KEY_COST, "", "stackTrace", "", "methodName", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "lastReportTime", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicInteger;J)V", "getCost", "()J", "getCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setCount", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "getLastReportTime", "setLastReportTime", "(J)V", "getMethodName", "()Ljava/lang/String;", "getStackTrace", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public static final class Problem {
            static IPatchRedirector $redirector_;
            private final long cost;

            @NotNull
            private AtomicInteger count;
            private long lastReportTime;

            @NotNull
            private final String methodName;

            @NotNull
            private final String stackTrace;

            public Problem(long j3, @NotNull String stackTrace, @NotNull String methodName, @NotNull AtomicInteger count, long j16) {
                Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
                Intrinsics.checkNotNullParameter(methodName, "methodName");
                Intrinsics.checkNotNullParameter(count, "count");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), stackTrace, methodName, count, Long.valueOf(j16));
                    return;
                }
                this.cost = j3;
                this.stackTrace = stackTrace;
                this.methodName = methodName;
                this.count = count;
                this.lastReportTime = j16;
            }

            public final long getCost() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
                }
                return this.cost;
            }

            @NotNull
            public final AtomicInteger getCount() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (AtomicInteger) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return this.count;
            }

            public final long getLastReportTime() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
                }
                return this.lastReportTime;
            }

            @NotNull
            public final String getMethodName() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return this.methodName;
            }

            @NotNull
            public final String getStackTrace() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.stackTrace;
            }

            public final void setCount(@NotNull AtomicInteger atomicInteger) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this, (Object) atomicInteger);
                } else {
                    Intrinsics.checkNotNullParameter(atomicInteger, "<set-?>");
                    this.count = atomicInteger;
                }
            }

            public final void setLastReportTime(long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    iPatchRedirector.redirect((short) 8, (Object) this, j3);
                } else {
                    this.lastReportTime = j3;
                }
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28779);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                INSTANCE = new TimingCacheReporter();
                stack2ProblemMap = new HashMap<>();
            }
        }

        TimingCacheReporter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final void reportProblem(Problem p16) {
            reportViolationForMR(p16.getMethodName(), p16.getStackTrace(), p16.getCost(), p16.getCount().get());
        }

        private final void reportViolationForMR(String type, String stackTrace, long cost, int count) {
            PerfProblemBusinessHandler.INSTANCE.c(new MainBlockMethodProblem(type, stackTrace, cost, count, null, null, 48, null));
        }

        public final void tryReport(@NotNull Problem p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) p16);
                return;
            }
            Intrinsics.checkNotNullParameter(p16, "p");
            String key = g.d(p16.getStackTrace());
            HashMap<String, Problem> hashMap = stack2ProblemMap;
            Problem problem = hashMap.get(key);
            if (problem != null) {
                problem.getCount().incrementAndGet();
                if (p16.getLastReportTime() - problem.getLastReportTime() > 30000) {
                    reportProblem(p16);
                    p16.getCount().set(0);
                    problem.setLastReportTime(p16.getLastReportTime());
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullExpressionValue(key, "key");
            hashMap.put(key, p16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28782);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new MainBlockMethodMonitor();
        }
    }

    MainBlockMethodMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void onMethodEnd() {
        onMethodEnd("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMethodEnd$lambda$0(long j3, StackTraceElement[] stackTraceElementArr, String methodName, String suffix) {
        Intrinsics.checkNotNullParameter(methodName, "$methodName");
        Intrinsics.checkNotNullParameter(suffix, "$suffix");
        TimingCacheReporter.INSTANCE.tryReport(new TimingCacheReporter.Problem(j3, ArraysKt.contentDeepToString(stackTraceElementArr), methodName + suffix, new AtomicInteger(1), System.currentTimeMillis()));
    }

    @JvmStatic
    public static final void onMethodStart() {
        MainBlockMethodMonitor mainBlockMethodMonitor = INSTANCE;
        if (!mainBlockMethodMonitor.isPublicVersion() && mainBlockMethodMonitor.isMainThread()) {
            entryTime = System.currentTimeMillis();
        }
    }

    public final boolean isMainThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread());
    }

    public final boolean isPublicVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return AppSetting.isPublicVersion();
    }

    @JvmStatic
    public static final void onMethodEnd(@NotNull final String suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MainBlockMethodMonitor mainBlockMethodMonitor = INSTANCE;
        if (mainBlockMethodMonitor.isPublicVersion() || !mainBlockMethodMonitor.isMainThread()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis() - entryTime;
        if (currentTimeMillis < 2) {
            return;
        }
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i3 = Intrinsics.areEqual(suffix, "") ? 4 : 3;
        if (stackTrace.length < i3) {
            return;
        }
        String stackTraceElement = stackTrace[i3].toString();
        Intrinsics.checkNotNullExpressionValue(stackTraceElement, "stackTrace[methodIndex].toString()");
        final String substringBefore = StringsKt.substringBefore(StringsKt.substringAfter(stackTraceElement, "com.tencent.mobileqq.perf.block.", ""), "(", "");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.block.a
            @Override // java.lang.Runnable
            public final void run() {
                MainBlockMethodMonitor.onMethodEnd$lambda$0(currentTimeMillis, stackTrace, substringBefore, suffix);
            }
        }, 128, null, true);
    }
}
