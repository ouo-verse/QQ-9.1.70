package com.tencent.mobileqq.startup.task;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.guild.api.ILocalFocusService;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/startup/task/z;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Lmqq/app/AppRuntime;", "", "a", "Landroid/content/Context;", "context", TencentLocation.RUN_MODE, "<init>", "()V", "d", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class z extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/startup/task/z$a;", "", "", "KEY_BACKGROUND_LAUNCH_REQUEST_TIANSHU_SWITCH", "Ljava/lang/String;", "TAG", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.z$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33890);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public z() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(AppRuntime appRuntime) {
        boolean z16;
        AppRuntime peekAppRuntime;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("key_background_launch_request_tianshu_switch", true);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null && peekAppRuntime.isLogin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("GuardRegisterTask", 1, "run , switchByCfg = " + isSwitchOn + ", isLogin = " + z16);
        if (isSwitchOn && z16) {
            ((IRedTouchServer) appRuntime.getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tianshu_login_first_clear_push", true), false, 1);
        }
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        AppRuntime appRuntime;
        AppRuntime peekAppRuntime;
        AppRuntime peekAppRuntime2;
        ILocalFocusService iLocalFocusService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime2 = mobileQQ.peekAppRuntime()) != null) {
            if (!TextUtils.isEmpty(peekAppRuntime2.getAccount()) && (iLocalFocusService = (ILocalFocusService) peekAppRuntime2.getRuntimeService(ILocalFocusService.class, "")) != null) {
                iLocalFocusService.reportAfterQQLoginBg();
            }
            a(peekAppRuntime2);
        }
        ab.f289789a.a();
        d.d();
        MobileQQ mobileQQ2 = MobileQQ.sMobileQQ;
        String str = null;
        if (mobileQQ2 != null) {
            appRuntime = mobileQQ2.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        MobileQQ mobileQQ3 = MobileQQ.sMobileQQ;
        if (mobileQQ3 != null && (peekAppRuntime = mobileQQ3.peekAppRuntime()) != null) {
            str = peekAppRuntime.getAccount();
        }
        QLog.i("GuardRegisterTask", 1, "appRuntime:" + appRuntime + " account:" + str);
    }
}
