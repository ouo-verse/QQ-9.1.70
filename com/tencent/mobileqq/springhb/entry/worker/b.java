package com.tencent.mobileqq.springhb.entry.worker;

import android.os.Build;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.config.SpringHbCommonConfProcessor;
import com.tencent.mobileqq.utils.m;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/worker/b;", "", "", "f", "", "needReport", "g", "Lcom/tencent/mobileqq/springhb/entry/worker/DemoteLevel;", "<set-?>", "b", "Lcom/tencent/mobileqq/springhb/entry/worker/DemoteLevel;", "c", "()Lcom/tencent/mobileqq/springhb/entry/worker/DemoteLevel;", "curDemoteLevel", "Z", "e", "()Z", "isDisableVideo", "d", "isDisableMiniBg", "disableCloseDesktop", "getDisableCheckHandler", "disableCheckHandler", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f289157a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static DemoteLevel curDemoteLevel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isDisableVideo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isDisableMiniBg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean disableCloseDesktop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean disableCheckHandler;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60663);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        b bVar = new b();
        f289157a = bVar;
        bVar.f();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.worker.a
            @Override // java.lang.Runnable
            public final void run() {
                b.b();
            }
        }, 16, null, false);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        f289157a.g(false);
    }

    private final void f() {
        DemoteLevel demoteLevel;
        int i3 = Build.VERSION.SDK_INT;
        long c16 = m.c();
        if (i3 > 25 && c16 > 4294967296L) {
            if (i3 > 28 && c16 > 6442450944L) {
                demoteLevel = DemoteLevel.LV1;
            } else {
                demoteLevel = DemoteLevel.LV2;
            }
        } else {
            demoteLevel = DemoteLevel.LV3;
        }
        curDemoteLevel = demoteLevel;
    }

    @NotNull
    public final DemoteLevel c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DemoteLevel) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        DemoteLevel demoteLevel = curDemoteLevel;
        if (demoteLevel != null) {
            return demoteLevel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("curDemoteLevel");
        return null;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return disableCloseDesktop;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return isDisableVideo;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(boolean needReport) {
        JSONObject jSONObject;
        String str;
        String str2;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        DemoteLevel demoteLevel;
        AppRuntime peekAppRuntime;
        ISpringHbReportApi iSpringHbReportApi;
        boolean contains$default;
        boolean contains$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, needReport);
            return;
        }
        long c16 = m.c();
        int i3 = Build.VERSION.SDK_INT;
        com.tencent.mobileqq.springhb.config.a d16 = SpringHbCommonConfProcessor.d();
        if (d16 != null) {
            jSONObject = d16.a("ResLoadStrategy");
        } else {
            jSONObject = null;
        }
        int i16 = 25;
        if (jSONObject != null) {
            i16 = jSONObject.optInt("ResLoadSdkLv3Version", 25);
        }
        int i17 = 28;
        if (jSONObject != null) {
            i17 = jSONObject.optInt("ResLoadSdkLv2Version", 28);
        }
        long j3 = 4294967296L;
        if (jSONObject != null) {
            j3 = jSONObject.optLong("ResLoadMemoryLv3", 4294967296L);
        }
        long j16 = 6442450944L;
        if (jSONObject != null) {
            j16 = jSONObject.optLong("ResLoadMemoryLv2", 6442450944L);
        }
        String str3 = "";
        if (jSONObject != null) {
            str = jSONObject.optString("ResLoadModelLv3", "");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (jSONObject != null) {
            str2 = jSONObject.optString("ResLoadModelLv2", "");
        } else {
            str2 = null;
        }
        if (str2 != null) {
            str3 = str2;
        }
        if (jSONObject != null) {
            z16 = jSONObject.optBoolean("IsDisableVideo", false);
        } else {
            z16 = false;
        }
        isDisableVideo = z16;
        if (jSONObject != null) {
            z17 = jSONObject.optBoolean("IsDisableMiniBg", false);
        } else {
            z17 = false;
        }
        isDisableMiniBg = z17;
        if (d16 != null) {
            z18 = d16.c("isCloseDesktop", false);
        } else {
            z18 = false;
        }
        disableCloseDesktop = z18;
        if (d16 != null) {
            z19 = d16.c("isCheckHandler", false);
        } else {
            z19 = false;
        }
        disableCheckHandler = z19;
        String model = DeviceInfoMonitor.getModel();
        if (i3 > i16 && c16 > j3) {
            Intrinsics.checkNotNullExpressionValue(model, "model");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) model, false, 2, (Object) null);
            if (!contains$default) {
                if (i3 > i17 && c16 > j16) {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) model, false, 2, (Object) null);
                    if (!contains$default2) {
                        demoteLevel = DemoteLevel.LV1;
                        curDemoteLevel = demoteLevel;
                        QLog.d("SpringDemoteWorker", 1, "totalMemory: " + c16 + ", sdk version: " + i3 + ", level: " + c() + "  model: " + model + " ");
                        if (needReport && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
                            iSpringHbReportApi.reportPerformance(i3, c16, model);
                            return;
                        }
                        return;
                    }
                }
                demoteLevel = DemoteLevel.LV2;
                curDemoteLevel = demoteLevel;
                QLog.d("SpringDemoteWorker", 1, "totalMemory: " + c16 + ", sdk version: " + i3 + ", level: " + c() + "  model: " + model + " ");
                if (needReport) {
                    return;
                } else {
                    return;
                }
            }
        }
        demoteLevel = DemoteLevel.LV3;
        curDemoteLevel = demoteLevel;
        QLog.d("SpringDemoteWorker", 1, "totalMemory: " + c16 + ", sdk version: " + i3 + ", level: " + c() + "  model: " + model + " ");
        if (needReport) {
        }
    }
}
