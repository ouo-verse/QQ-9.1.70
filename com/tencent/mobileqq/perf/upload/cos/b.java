package com.tencent.mobileqq.perf.upload.cos;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\f\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/perf/upload/cos/b;", "", "", "c", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setSid", "(Ljava/lang/String;)V", "sid", "setSkey", "skey", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f258278a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String sid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String skey;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        b bVar = new b();
        f258278a = bVar;
        sid = "";
        skey = "";
        bVar.c();
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c() {
        IFeatureRuntimeService iFeatureRuntimeService;
        if (MobileQQ.sProcessId == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Map<String, String> map = null;
            if (peekAppRuntime != null) {
                iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
            } else {
                iFeatureRuntimeService = null;
            }
            if (iFeatureRuntimeService != null) {
                map = iFeatureRuntimeService.isEnabledWithDataSet("perf_cos_upload_key", "");
            }
            if (map != null && !map.isEmpty()) {
                String valueOf = String.valueOf(map.get("sid"));
                sid = valueOf;
                if (Intrinsics.areEqual(valueOf, "null")) {
                    QLog.i("PerfCosFeatureSwitch", 1, "sid load failed");
                }
                String valueOf2 = String.valueOf(map.get("skey"));
                skey = valueOf2;
                if (Intrinsics.areEqual(valueOf2, "null")) {
                    QLog.i("PerfCosFeatureSwitch", 1, "skey load failed");
                }
            }
        }
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return sid;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return skey;
    }
}
