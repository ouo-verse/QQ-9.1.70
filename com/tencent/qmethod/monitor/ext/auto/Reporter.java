package com.tencent.qmethod.monitor.ext.auto;

import android.os.Handler;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.NetworkUtil;
import com.tencent.qmethod.monitor.base.util.d;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.monitor.AutoStartMonitor;
import java.security.InvalidParameterException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import nr3.UserMeta;
import or3.c;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\n\u001a\u00020\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0014\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0014\u0010\u000e\u001a\u00020\f*\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0015\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/auto/Reporter;", "", "Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$AutoStartBean;", "bean", "", "c", "", "k", "Lorg/json/JSONObject;", "info", "j", "i", "", "key", "g", h.F, "Lcom/tencent/qmethod/monitor/report/SampleHelper$SampleStatus;", "d", "e", "a", "Ljava/lang/Object;", "SAMPLE_LOCK", "Landroid/os/Handler;", "b", "Lkotlin/Lazy;", "f", "()Landroid/os/Handler;", "handler", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class Reporter {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy handler;

    /* renamed from: c, reason: collision with root package name */
    public static final Reporter f343614c = new Reporter();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Object SAMPLE_LOCK = new Object();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qmethod/monitor/ext/auto/Reporter$a", "Lor3/c$a;", "", "dbId", "", "onSuccess", "errorCode", "", "errorMsg", "a", "onCached", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class a implements c.a {
        a() {
        }

        @Override // or3.c.a
        public void a(int errorCode, @NotNull String errorMsg, int dbId) {
            Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
            o.a("AutoReporter", "errorCode:" + errorCode + ", errorMsg=" + errorMsg + ", dbId=" + dbId);
        }

        @Override // or3.c.a
        public void onCached() {
            o.a("AutoReporter", "dbId=onCached");
        }

        @Override // or3.c.a
        public void onSuccess(int dbId) {
            o.a("AutoReporter", "dbId=" + dbId);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Handler>() { // from class: com.tencent.qmethod.monitor.ext.auto.Reporter$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(ThreadManager.f343506c.b());
            }
        });
        handler = lazy;
    }

    Reporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c(AutoStartMonitor.AutoStartBean bean) {
        if (bean.getType() < 0) {
            if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                o.a("AutoReporter", "ignore activity start");
            }
            return false;
        }
        if (h()) {
            return false;
        }
        return true;
    }

    private final SampleHelper.SampleStatus d() {
        double d16;
        int i3;
        ConfigManager configManager = ConfigManager.f343549h;
        e eVar = configManager.p().g().get("func_auto_monitor");
        if (eVar != null) {
            d16 = eVar.getRate();
        } else {
            d16 = 0.0d;
        }
        double d17 = d16;
        e eVar2 = configManager.p().g().get("func_auto_monitor");
        if (eVar2 != null) {
            i3 = eVar2.getMaxReport();
        } else {
            i3 = 0;
        }
        synchronized (SAMPLE_LOCK) {
            d dVar = d.f343534a;
            if (dVar.b(2, "KEY_AUTO_REPORT", i3)) {
                return SampleHelper.SampleStatus.GLOBAL_LIMIT;
            }
            if (!SampleHelper.z(SampleHelper.f343779l, d17, 0, 0, 6, null)) {
                return SampleHelper.SampleStatus.GLOBAL_RATE;
            }
            dVar.d(2, "KEY_AUTO_REPORT");
            Unit unit = Unit.INSTANCE;
            return SampleHelper.SampleStatus.PASS;
        }
    }

    private final Handler f() {
        return (Handler) handler.getValue();
    }

    private final String g(@NotNull AutoStartMonitor.AutoStartBean autoStartBean, String str) {
        String obj;
        Object extraInfo = autoStartBean.getExtraInfo(str);
        if (extraInfo == null || (obj = extraInfo.toString()) == null) {
            return "";
        }
        return obj;
    }

    private final boolean h() {
        boolean z16;
        SampleHelper.SampleStatus d16 = d();
        if (SampleHelper.SampleStatus.PASS != d16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            o.a("AutoReporter", "ignore report, because of " + d16);
        }
        return z16;
    }

    private final JSONObject i(@NotNull JSONObject jSONObject, AutoStartMonitor.AutoStartBean autoStartBean) {
        jSONObject.put("type", autoStartBean.getType());
        jSONObject.put("componentInfo", autoStartBean.getComponentInfo());
        jSONObject.put("autoCallSelf", g(autoStartBean, AutoStartMonitor.AutoStartBean.KEY_AUTO_CALL_SELF));
        jSONObject.put("callingPid", g(autoStartBean, AutoStartMonitor.AutoStartBean.KEY_BINDER_PID));
        jSONObject.put("callingUid", g(autoStartBean, AutoStartMonitor.AutoStartBean.KEY_BINDER_UID));
        jSONObject.put(AutoStartMonitor.AutoStartBean.KEY_CALLEE_PID, g(autoStartBean, AutoStartMonitor.AutoStartBean.KEY_CALLEE_PID));
        jSONObject.put(AutoStartMonitor.AutoStartBean.KEY_CALLEE_UID, g(autoStartBean, AutoStartMonitor.AutoStartBean.KEY_CALLEE_UID));
        jSONObject.put("keyProviderURI", autoStartBean.getExtraInfo(AutoStartMonitor.AutoStartBean.KEY_PROVIDER_URI));
        jSONObject.put("keyAction", g(autoStartBean, AutoStartMonitor.AutoStartBean.KEY_ACTION));
        jSONObject.put("keyIntent", g(autoStartBean, AutoStartMonitor.AutoStartBean.KEY_INTENT));
        jSONObject.put("keyTrace", g(autoStartBean, AutoStartMonitor.AutoStartBean.KEY_TRACE));
        jSONObject.put("procName", com.tencent.qmethod.pandoraex.core.collector.utils.a.a());
        return jSONObject;
    }

    private final void j(@NotNull JSONObject jSONObject, AutoStartMonitor.AutoStartBean autoStartBean) {
        NetworkUtil networkUtil = NetworkUtil.f343513c;
        String jSONObject2 = i(new JSONObject(), autoStartBean).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "JSONObject().putAttribut\u2026rtParams(info).toString()");
        jSONObject.put(ReportDataBuilder.KEY_ATTRIBUTES, networkUtil.a(jSONObject2));
        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            o.a("AutoReporter", "report info: " + jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(AutoStartMonitor.AutoStartBean bean) {
        JSONObject e16 = pr3.b.f427061b.e("compliance", "self_launch", bean.getTimeStamp() / 1000);
        try {
            f343614c.j(e16, bean);
            or3.d.f423470e.a(new ReportData(e16, true), new a());
        } catch (InvalidParameterException e17) {
            o.d("AutoReporter", "report error:", e17);
        }
    }

    public final void e(@NotNull final AutoStartMonitor.AutoStartBean bean) {
        Intrinsics.checkParameterIsNotNull(bean, "bean");
        f().postDelayed(new Runnable() { // from class: com.tencent.qmethod.monitor.ext.auto.Reporter$doReport$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean c16;
                boolean isBlank;
                boolean isBlank2;
                if (!com.tencent.qmethod.monitor.a.f343451h.h()) {
                    return;
                }
                Reporter reporter = Reporter.f343614c;
                c16 = reporter.c(AutoStartMonitor.AutoStartBean.this);
                if (!c16) {
                    return;
                }
                UserMeta userMeta = nr3.a.f421180b;
                isBlank = StringsKt__StringsJVMKt.isBlank(userMeta.appId);
                if (!isBlank) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(userMeta.appKey);
                    if (!isBlank2) {
                        reporter.k(AutoStartMonitor.AutoStartBean.this);
                        return;
                    }
                }
                o.a("AutoReporter", "report to early");
            }
        }, 10000L);
    }
}
