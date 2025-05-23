package com.tencent.mobileqq.perf.startup;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@BX\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/perf/startup/a;", "", "", "b", "", "<set-?>", "Z", "a", "()Z", "getOpen$annotations", "()V", "open", "<init>", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f258031a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean open;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44191);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        a aVar = new a();
        f258031a = aVar;
        aVar.b();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final boolean a() {
        return open;
    }

    private final void b() {
        IFeatureRuntimeService iFeatureRuntimeService;
        if (MobileQQ.sProcessId == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
            } else {
                iFeatureRuntimeService = null;
            }
            boolean z16 = false;
            if (iFeatureRuntimeService != null && iFeatureRuntimeService.isFeatureSwitchEnable("dex2oatManualTrigger")) {
                z16 = true;
            }
            open = z16;
            QLog.i("ManualDex2oatFeatureSwitch", 1, "loadSwitch success. switch is " + open);
        }
    }
}
