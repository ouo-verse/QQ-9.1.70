package com.tencent.mobileqq.perf.tool;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.strictmode.Violation;
import android.util.Log;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.perf.tool.StrictModeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.debug.report.PerfProblemBusinessHandler;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tencent.util.AppSetting;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import jy3.StrictModeProblem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/perf/tool/StrictModeUtil;", "", "", tl.h.F, "", "d", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "mainHandler", "Landroid/os/StrictMode$OnVmViolationListener;", "c", "Landroid/os/StrictMode$OnVmViolationListener;", "onVmViolationListener", "Landroid/os/StrictMode$VmPolicy;", "Landroid/os/StrictMode$VmPolicy;", "vmPolicy", "Landroid/os/StrictMode$OnThreadViolationListener;", "e", "Landroid/os/StrictMode$OnThreadViolationListener;", "onThreadViolationListener", "Landroid/os/StrictMode$ThreadPolicy;", "f", "Landroid/os/StrictMode$ThreadPolicy;", "threadPolicy", "<init>", "()V", "TimingCacheReporter", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class StrictModeUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final StrictModeUtil f258190a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler mainHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static StrictMode.OnVmViolationListener onVmViolationListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static StrictMode.VmPolicy vmPolicy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static StrictMode.OnThreadViolationListener onThreadViolationListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static StrictMode.ThreadPolicy threadPolicy;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\u001b\b\u00c2\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\r\u001a\u00020\u000bJ\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0004R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/perf/tool/StrictModeUtil$TimingCacheReporter;", "", "", PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME, "", "f", "Landroid/os/strictmode/Violation;", "v", "d", "Lcom/tencent/mobileqq/perf/tool/StrictModeUtil$TimingCacheReporter$a;", "cv", "", "g", "e", "isThreadViolation", tl.h.F, "", "b", "[Ljava/lang/String;", "filterDigests", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "violation2CountMap", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "com/tencent/mobileqq/perf/tool/StrictModeUtil$TimingCacheReporter$reportTask$1", "Lcom/tencent/mobileqq/perf/tool/StrictModeUtil$TimingCacheReporter$reportTask$1;", "reportTask", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class TimingCacheReporter {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final TimingCacheReporter f258196a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final String[] filterDigests;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final ConcurrentHashMap<String, a> violation2CountMap;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Handler handler;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final StrictModeUtil$TimingCacheReporter$reportTask$1 reportTask;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/perf/tool/StrictModeUtil$TimingCacheReporter$a;", "", "Landroid/os/strictmode/Violation;", "a", "Landroid/os/strictmode/Violation;", "b", "()Landroid/os/strictmode/Violation;", "v", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setCount", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "count", "", "c", "Z", "isThreadViolation", "()Z", "<init>", "(Landroid/os/strictmode/Violation;Ljava/util/concurrent/atomic/AtomicInteger;Z)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes16.dex */
        public static final class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Violation v;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private AtomicInteger count;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private final boolean isThreadViolation;

            public a(@NotNull Violation v3, @NotNull AtomicInteger count, boolean z16) {
                Intrinsics.checkNotNullParameter(v3, "v");
                Intrinsics.checkNotNullParameter(count, "count");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, v3, count, Boolean.valueOf(z16));
                    return;
                }
                this.v = v3;
                this.count = count;
                this.isThreadViolation = z16;
            }

            @NotNull
            public final AtomicInteger a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (AtomicInteger) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.count;
            }

            @NotNull
            public final Violation b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Violation) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.v;
            }
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.mobileqq.perf.tool.StrictModeUtil$TimingCacheReporter$reportTask$1] */
        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_WX_ROOM_ERR);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
                return;
            }
            f258196a = new TimingCacheReporter();
            filterDigests = new String[]{"libcore.io.ForwardingOs.access", "libcore.io.ForwardingOs.fstat", "libcore.io.ForwardingOs.chmod", "android.system.Os.statvfs", "java.io.File.mkdir", "java.io.File.exists", "java.io.File.isFile", "java.io.File.isDirectory", "libcore.io.ForwardingOs.open", "java.io.FileInputStream.<init>", "java.io.FileOutputStream.<init>", "android.app.SharedPreferencesImpl"};
            violation2CountMap = new ConcurrentHashMap<>();
            handler = new Handler(QQPerfHandlerThreadManager.INSTANCE.d().getLooper());
            reportTask = new Runnable() { // from class: com.tencent.mobileqq.perf.tool.StrictModeUtil$TimingCacheReporter$reportTask$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConcurrentHashMap concurrentHashMap;
                    Handler handler2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        concurrentHashMap = StrictModeUtil.TimingCacheReporter.violation2CountMap;
                        Iterator it = concurrentHashMap.entrySet().iterator();
                        while (it.hasNext()) {
                            StrictModeUtil.TimingCacheReporter.a aVar = (StrictModeUtil.TimingCacheReporter.a) ((Map.Entry) it.next()).getValue();
                            if (aVar.a().get() != 0) {
                                StrictModeUtil.TimingCacheReporter.f258196a.g(aVar);
                            }
                        }
                        handler2 = StrictModeUtil.TimingCacheReporter.handler;
                        handler2.postDelayed(this, 180000L);
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            };
        }

        TimingCacheReporter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:
        
            r0 = kotlin.collections.ArraysKt__ArraysKt.contentDeepToString(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
        
            r3 = kotlin.collections.ArraysKt__ArraysKt.contentDeepToString(r3);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final String d(Violation v3) {
            StackTraceElement[] stackTrace;
            String str;
            Throwable cause;
            String contentDeepToString;
            stackTrace = v3.getStackTrace();
            String str2 = "";
            if (stackTrace == null || str == null) {
                str = "";
            }
            cause = v3.getCause();
            if (cause != null && (r3 = cause.getStackTrace()) != null && contentDeepToString != null) {
                str2 = contentDeepToString;
            }
            String d16 = com.tencent.open.base.g.d(str + str2);
            Intrinsics.checkNotNullExpressionValue(d16, "toMD5(stackTrace + causeStackTrace)");
            return d16;
        }

        private final boolean f(String digest) {
            boolean startsWith$default;
            for (String str : filterDigests) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(digest, str, false, 2, null);
                if (startsWith$default) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        
            r1 = kotlin.collections.ArraysKt__ArraysKt.contentDeepToString(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x000d, code lost:
        
            r1 = kotlin.collections.ArraysKt__ArraysKt.contentDeepToString(r1);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void g(a cv5) {
            StackTraceElement[] stackTrace;
            String str;
            Throwable cause;
            String str2;
            String message;
            String str3;
            String contentDeepToString;
            String contentDeepToString2;
            Violation b16 = cv5.b();
            stackTrace = b16.getStackTrace();
            if (stackTrace == null || contentDeepToString2 == null) {
                str = "";
            } else {
                str = contentDeepToString2;
            }
            cause = b16.getCause();
            if (cause == null || (r1 = cause.getStackTrace()) == null || contentDeepToString == null) {
                str2 = "";
            } else {
                str2 = contentDeepToString;
            }
            message = b16.getMessage();
            if (message == null) {
                str3 = "";
            } else {
                str3 = message;
            }
            String type = b16.getClass().getSimpleName();
            int andSet = cv5.a().getAndSet(0);
            PerfProblemBusinessHandler.Companion companion = PerfProblemBusinessHandler.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            companion.c(new StrictModeProblem(type, str3, str, str2, andSet, null, null, 96, null));
        }

        public static /* synthetic */ void i(TimingCacheReporter timingCacheReporter, Violation violation, boolean z16, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            timingCacheReporter.h(violation, z16);
        }

        public final void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                handler.post(reportTask);
            }
        }

        public final void h(@NotNull Violation v3, boolean isThreadViolation) {
            StackTraceElement[] stackTrace;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, v3, Boolean.valueOf(isThreadViolation));
                return;
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            stackTrace = v3.getStackTrace();
            if (stackTrace.length < 2) {
                QLog.d("StrictModeUtil", 2, "v.stackTrace.size < 2, something wrong, don't report");
                return;
            }
            String stackTraceElement = stackTrace[2].toString();
            Intrinsics.checkNotNullExpressionValue(stackTraceElement, "stackTrace[2].toString()");
            if (f(stackTraceElement)) {
                QLog.d("StrictModeUtil", 4, "stop report " + stackTraceElement + ", it's filter digest");
                return;
            }
            String d16 = d(v3);
            ConcurrentHashMap<String, a> concurrentHashMap = violation2CountMap;
            a aVar = concurrentHashMap.get(d16);
            if (aVar != null) {
                if (aVar.a().incrementAndGet() > 100) {
                    g(aVar);
                    return;
                }
                return;
            }
            concurrentHashMap.put(d16, new a(v3, new AtomicInteger(1), isThreadViolation));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_WX_USER_ERR);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f258190a = new StrictModeUtil();
            mainHandler = new Handler(Looper.getMainLooper());
        }
    }

    StrictModeUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Violation it) {
        if (QLog.isDevelopLevel()) {
            QLog.i("StrictModeUtil", 1, "OnVmViolationListener");
        }
        TimingCacheReporter timingCacheReporter = TimingCacheReporter.f258196a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        TimingCacheReporter.i(timingCacheReporter, it, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Violation it) {
        QLog.i("StrictModeUtil", 1, "OnThreadViolationListener");
        TimingCacheReporter timingCacheReporter = TimingCacheReporter.f258196a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        timingCacheReporter.h(it, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        StrictMode.VmPolicy vmPolicy2 = vmPolicy;
        StrictMode.ThreadPolicy threadPolicy2 = null;
        if (vmPolicy2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vmPolicy");
            vmPolicy2 = null;
        }
        StrictMode.setVmPolicy(vmPolicy2);
        StrictMode.ThreadPolicy threadPolicy3 = threadPolicy;
        if (threadPolicy3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("threadPolicy");
        } else {
            threadPolicy2 = threadPolicy3;
        }
        StrictMode.setThreadPolicy(threadPolicy2);
        QLog.i("StrictModeUtil", 1, "finish set Vm&Thread policy");
    }

    public final void d() {
        StrictMode.VmPolicy.Builder penaltyListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (Build.VERSION.SDK_INT < 28) {
            if (QLog.isDevelopLevel()) {
                QLog.d("StrictModeUtil", 1, "version < Andorid 9\uff0cdon't start strict mode");
                return;
            }
            return;
        }
        if (AppSetting.isPublicVersion()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("StrictModeUtil", 1, "isPublicVersion\uff0cdon't start strict mode");
                return;
            }
            return;
        }
        if (!h()) {
            QLog.d("StrictModeUtil", 1, "not need auto start, start failed");
            return;
        }
        Log.i("StrictModeUtil", "startStrictMode success");
        onVmViolationListener = new StrictMode.OnVmViolationListener() { // from class: com.tencent.mobileqq.perf.tool.e
            @Override // android.os.StrictMode.OnVmViolationListener
            public final void onVmViolation(Violation violation) {
                StrictModeUtil.e(violation);
            }
        };
        StrictMode.VmPolicy.Builder detectFileUriExposure = new StrictMode.VmPolicy.Builder().detectLeakedClosableObjects().detectLeakedSqlLiteObjects().detectLeakedRegistrationObjects().detectFileUriExposure();
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        StrictMode.OnVmViolationListener onVmViolationListener2 = onVmViolationListener;
        StrictMode.OnThreadViolationListener onThreadViolationListener2 = null;
        if (onVmViolationListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onVmViolationListener");
            onVmViolationListener2 = null;
        }
        penaltyListener = detectFileUriExposure.penaltyListener(newSingleThreadExecutor, onVmViolationListener2);
        StrictMode.VmPolicy build = penaltyListener.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .d\u2026ner)\n            .build()");
        vmPolicy = build;
        onThreadViolationListener = new StrictMode.OnThreadViolationListener() { // from class: com.tencent.mobileqq.perf.tool.f
            @Override // android.os.StrictMode.OnThreadViolationListener
            public final void onThreadViolation(Violation violation) {
                StrictModeUtil.f(violation);
            }
        };
        StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder();
        ExecutorService newCachedThreadPool = ProxyExecutors.newCachedThreadPool();
        StrictMode.OnThreadViolationListener onThreadViolationListener3 = onThreadViolationListener;
        if (onThreadViolationListener3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onThreadViolationListener");
        } else {
            onThreadViolationListener2 = onThreadViolationListener3;
        }
        builder.penaltyListener(newCachedThreadPool, onThreadViolationListener2);
        builder.detectNetwork();
        builder.detectDiskWrites();
        builder.detectCustomSlowCalls();
        builder.detectResourceMismatches();
        StrictMode.ThreadPolicy build2 = builder.build();
        Intrinsics.checkNotNullExpressionValue(build2, "threadPolicyBuilder.build()");
        threadPolicy = build2;
        mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.perf.tool.g
            @Override // java.lang.Runnable
            public final void run() {
                StrictModeUtil.g();
            }
        });
        TimingCacheReporter.f258196a.e();
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeBool("strict_mode_auto_start", true);
    }
}
