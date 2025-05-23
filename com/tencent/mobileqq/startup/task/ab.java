package com.tencent.mobileqq.startup.task;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.ISportManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/startup/task/ab;", "", "", "a", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ab {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ab f289789a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35068);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f289789a = new ab();
        }
    }

    ab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && MobileQQ.sMobileQQ.peekAppRuntime().isLogin()) {
            if (!((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isSupportStepCounter(appRuntime.getApplicationContext())) {
                QLog.i("HealthStepTask", 1, "step counter unsupported model.");
                return;
            }
            IRuntimeService runtimeService = appRuntime.getRuntimeService(ISportManager.class, ProcessConstant.MULTI);
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026a, ProcessConstant.MULTI)");
            ISportManager iSportManager = (ISportManager) runtimeService;
            if (((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isNeedReport(appRuntime.getAccount())) {
                iSportManager.refreshCurrentStep("login");
            }
            iSportManager.doOnLogin();
        }
    }
}
