package com.tencent.qmethod.monitor.ext.traffic;

import android.util.Log;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qmethod.pandoraex.core.ext.netcap.k;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.s;
import com.tencent.qmethod.pandoraex.core.x;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b=\u0010>J\u0006\u0010\u0003\u001a\u00020\u0002J\\\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0014R\"\u0010\u001e\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010$\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\"\u0010'\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0019\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\"\u0010*\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\"\u0010.\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\"\u00101\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR*\u00105\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00148\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR\u0016\u00106\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0019R\"\u0010<\u001a\u0002078\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b/\u00108\u001a\u0004\b+\u00109\"\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/traffic/a;", "Lcom/tencent/qmethod/pandoraex/core/ext/netcap/k$a;", "", "l", "", "requestSource", "url", "", "", "headerMap", "", "requestBody", "", "requestTime", "monitorMethod", "contentType", "contentLength", "c", "host", "", "", "b", "a", "d", "e", "Z", "getEnableHttpAsIssue", "()Z", "setEnableHttpAsIssue", "(Z)V", "enableHttpAsIssue", "getEnableSensitiveFieldAsIssue", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "enableSensitiveFieldAsIssue", tl.h.F, "setEnableKeyCheck", "enableKeyCheck", "g", "setEnableDataMask", "enableDataMask", "i", "setEnableLog", "enableLog", "f", "getEnableReportStack", "setEnableReportStack", "enableReportStack", "j", "setOnlyPrintIssue", "onlyPrintIssue", "value", "k", "setStrictMode", "strictMode", "hadInit", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setCounterSensitiveFieldCheck$qmethod_privacy_monitor_tencentBuglyRelease", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "counterSensitiveFieldCheck", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a implements k.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean enableSensitiveFieldAsIssue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean enableKeyCheck;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean enableLog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean strictMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean hadInit;

    /* renamed from: k, reason: collision with root package name */
    public static final a f343721k = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean enableHttpAsIssue = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean enableDataMask = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean enableReportStack = true;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean onlyPrintIssue = true;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicInteger counterSensitiveFieldCheck = new AtomicInteger(0);

    a() {
    }

    @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.k.a
    public boolean a() {
        if (hadInit && (NetworkCaptureSample.f343708b.b() || NetworkHttpPlainSample.f343710b.c())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.k.a
    public boolean b(@NotNull String host, int monitorMethod) {
        boolean contains$default;
        Intrinsics.checkParameterIsNotNull(host, "host");
        if (enableLog) {
            o.a("NetworkCapture", "sampleReqCapture " + host + " method " + monitorMethod);
        }
        if (!hadInit) {
            return false;
        }
        NetworkHttpPlainSample networkHttpPlainSample = NetworkHttpPlainSample.f343710b;
        if (!networkHttpPlainSample.c() && !NetworkCaptureSample.f343708b.b()) {
            return false;
        }
        if (networkHttpPlainSample.d() && NetworkCaptureSample.f343708b.c()) {
            return false;
        }
        if (monitorMethod != 4) {
            e.a().add(host);
        }
        if (!networkHttpPlainSample.a() && !NetworkCaptureSample.f343708b.a()) {
            return false;
        }
        if (monitorMethod != 5 && monitorMethod != 6) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) host, (CharSequence) "compliance", false, 2, (Object) null);
            if (contains$default) {
                return false;
            }
            if (monitorMethod != 4) {
                e.a().add(host);
                return true;
            }
            if (e.a().contains(host)) {
                if (enableLog) {
                    o.a("NetworkCapture", "hostRecordByJava stop check");
                }
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.qmethod.pandoraex.core.ext.netcap.k.a
    public void c(@NotNull String requestSource, @NotNull String url, @NotNull Map<String, ? extends List<String>> headerMap, @Nullable byte[] requestBody, long requestTime, @NotNull String monitorMethod, @NotNull String contentType, long contentLength) {
        boolean z16;
        boolean z17;
        boolean contains$default;
        Intrinsics.checkParameterIsNotNull(requestSource, "requestSource");
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headerMap, "headerMap");
        Intrinsics.checkParameterIsNotNull(monitorMethod, "monitorMethod");
        Intrinsics.checkParameterIsNotNull(contentType, "contentType");
        try {
            if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "https://compliance.tdos", false, 2, (Object) null);
                if (contains$default) {
                    return;
                }
            }
            String str = "";
            if (enableReportStack && NetworkHttpPlainSample.f343710b.b()) {
                str = Log.getStackTraceString(new Throwable());
                Intrinsics.checkExpressionValueIsNotNull(str, "Log.getStackTraceString(Throwable())");
            }
            String str2 = str;
            if (!s.b()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!x.w()) {
                z17 = true;
            } else {
                z17 = false;
            }
            NetworkCaptureCheckHttpTask networkCaptureCheckHttpTask = new NetworkCaptureCheckHttpTask(url, requestBody, requestSource, requestTime, z16, z17, monitorMethod, str2, headerMap, contentType, contentLength);
            counterSensitiveFieldCheck.incrementAndGet();
            f.f343729e.c().post(networkCaptureCheckHttpTask);
        } catch (Throwable th5) {
            o.d("NetworkCapture", "onGetHttpRequest", th5);
        }
    }

    public final boolean d() {
        if (enableHttpAsIssue && NetworkHttpPlainSample.f343710b.c()) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (enableSensitiveFieldAsIssue && NetworkCaptureSample.f343708b.b()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final AtomicInteger f() {
        return counterSensitiveFieldCheck;
    }

    public final boolean g() {
        return enableDataMask;
    }

    public final boolean h() {
        return enableKeyCheck;
    }

    public final boolean i() {
        return enableLog;
    }

    public final boolean j() {
        return onlyPrintIssue;
    }

    public final boolean k() {
        return strictMode;
    }

    public final void l() {
        if (!hadInit) {
            com.tencent.qmethod.monitor.base.util.h hVar = com.tencent.qmethod.monitor.base.util.h.f343541c;
            hVar.e("NetworkCapture_INIT");
            k.l(this);
            hVar.b("NetworkCapture_INIT");
            if (enableLog) {
                o.a("NetworkCapture", "init s " + NetworkCaptureSample.f343708b.b() + " e " + NetworkHttpPlainSample.f343710b.c());
            }
            hadInit = true;
        }
    }

    public final void m(boolean z16) {
        enableSensitiveFieldAsIssue = z16;
    }
}
