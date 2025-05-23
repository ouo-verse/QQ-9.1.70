package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.login.api.INTLoginApi;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/startup/task/cn;", "Lcom/tencent/qqnt/startup/task/NtTask;", "", "scene", "", "a", "b", "Landroid/content/Context;", "context", TencentLocation.RUN_MODE, "<init>", "()V", "d", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class cn extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/startup/task/cn$a;", "", "", "EVENT_KEY_SCENE", "Ljava/lang/String;", "EVENT_NT_SIG_FAIL_REFRESH", "EVENT_SCENE_COUNT_CHANGE", "EVENT_SCENE_START", "TAG", "UNITED_CONFIG_WT_REFRESH_NT_SIGN", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.cn$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44625);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public cn() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(String scene) {
        long j3;
        if (!MobileQQ.sMobileQQ.isLoginByNT()) {
            QLog.d("WTRefreshNTSignTask", 2, "check NT-WT refresh nt login switch is close!");
            return;
        }
        QLog.d("WTRefreshNTSignTask", 2, "check NT-WT refresh start");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        try {
            String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
            j3 = Long.parseLong(currentAccountUin);
        } catch (Exception e16) {
            QLog.e("WTRefreshNTSignTask", 1, "check NT-WT uin exception:", e16);
            j3 = 0;
        }
        if (j3 == 0) {
            QLog.d("WTRefreshNTSignTask", 2, "check NT-WT refresh return uin not ready");
            return;
        }
        TicketManager ticketManager = (TicketManager) peekAppRuntime.getManager(2);
        if (ticketManager == null) {
            return;
        }
        boolean isQQNTSignToWTRefreshSuccess = ticketManager.isQQNTSignToWTRefreshSuccess(j3);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("refresh_nt_sign_on_start", false);
        QLog.i("WTRefreshNTSignTask", 1, "check NT-WT uin:" + MsfSdkUtils.getShortUin(peekAppRuntime.getCurrentAccountUin()) + ",result:" + isQQNTSignToWTRefreshSuccess + ",isRefreshOn:" + isSwitchOn);
        if (!isQQNTSignToWTRefreshSuccess && isSwitchOn) {
            ((INTLoginApi) QRoute.api(INTLoginApi.class)).refreshCurrentAccountTicket(true);
            b(scene);
        }
    }

    private final void b(String scene) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("key_scene", scene);
        com.tencent.mobileqq.inject.v.c(peekAppRuntime.getCurrentAccountUin(), "event_nt_sig_fail_refresh", hashMap);
        QLog.e("WTRefreshNTSignTask", 1, "check NT-WT reportNTSignWTRefreshFail scene:" + scene);
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            a("start");
        }
    }
}
