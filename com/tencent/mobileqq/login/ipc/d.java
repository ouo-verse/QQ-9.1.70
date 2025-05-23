package com.tencent.mobileqq.login.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.identity.IAccountApi;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.login.ntlogin.ag;
import com.tencent.mobileqq.login.ntlogin.y;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J&\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/login/ipc/d;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "params", "", "i", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "maskUin", "uin", "", h.F, "Lcom/tencent/mobileqq/login/account/a;", "account", "g", "", "callbackId", "e", "action", "Leipc/EIPCResult;", "onCall", "<init>", "()V", "d", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/login/ipc/d$a;", "", "", "SP_JWT_TIME_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.ipc.d$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21120);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        super("LoginIPCModule");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e(Bundle params, final int callbackId) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ipc.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f(d.this, callbackId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(d this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MobileQQ.sMobileQQ.closeAllActivities();
        QLog.i("LoginIPCModule", 1, "finish all activity");
        this$0.callbackResult(i3, new EIPCResult());
    }

    private final boolean g(com.tencent.mobileqq.login.account.a account) {
        if (account.b() != 4 && account.b() != 5 && account.b() != 7) {
            return false;
        }
        return true;
    }

    private final boolean h(String maskUin, String uin) {
        if (TextUtils.isEmpty(maskUin) || TextUtils.isEmpty(uin) || maskUin.length() != uin.length() || maskUin.length() < 4 || maskUin.charAt(0) != uin.charAt(0) || maskUin.charAt(1) != uin.charAt(1) || maskUin.charAt(maskUin.length() - 1) != uin.charAt(uin.length() - 1) || maskUin.charAt(maskUin.length() - 2) != uin.charAt(uin.length() - 2)) {
            return false;
        }
        return true;
    }

    private final void i(Bundle params) {
        QLog.i("LoginIPCModule", 1, "jumpPhoneSmsLoginPage");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            int i3 = 0;
            if (params != null) {
                i3 = params.getInt("key_login_page_entrance", 0);
            }
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).jumpToPhoneNumLoginPage(qBaseActivity, i3);
            return;
        }
        QLog.e("LoginIPCModule", 1, "activity is invalid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(d this$0, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(d this$0, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l(bundle);
    }

    private final void l(Bundle params) {
        String str;
        QLog.i("LoginIPCModule", 1, "phoneSmsLogin");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            String str2 = null;
            if (params != null) {
                str = params.getString(AuthDevOpenUgActivity.KEY_PHONE_NUM);
            } else {
                str = null;
            }
            if (params != null) {
                str2 = params.getString("country_code");
            }
            ag.f242225a.i(qBaseActivity, str, str2);
            return;
        }
        QLog.e("LoginIPCModule", 1, "activity is invalid");
    }

    private final void m(Bundle params) {
        String str;
        boolean z16;
        QLog.d("LoginIPCModule", 1, "refreshNTLoginTicket ");
        if (params != null) {
            str = params.getString("user_uin");
        } else {
            str = null;
        }
        if (params != null) {
            z16 = params.getBoolean("is_host_uin", true);
        } else {
            z16 = true;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("LoginIPCModule", 1, "refreshNTLoginTicket uin is null");
            return;
        }
        try {
            y yVar = y.f242393a;
            Intrinsics.checkNotNull(str);
            y.j(yVar, Long.parseLong(str), z16, false, null, 8, null);
        } catch (Exception e16) {
            QLog.e("LoginIPCModule", 1, "refreshNTLoginTicket error: " + e16);
        }
    }

    private final void n(Bundle params) {
        String str;
        QLog.i("LoginIPCModule", 1, "unbindPhoneFinish");
        if (params != null) {
            str = params.getString("key_login_unbind_phone_account_data");
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginIPCModule", 2, "UnbindAccountCallBack accountDataStr : " + str);
        }
        List<AccountInfo> k3 = LoginUtil.f306390a.k(str);
        if (k3.isEmpty()) {
            QLog.d("LoginIPCModule", 1, "UnbindAccountCallBack accountInfo is empty");
            return;
        }
        List<com.tencent.mobileqq.login.account.a> f16 = com.tencent.mobileqq.login.account.d.f241848a.f();
        for (AccountInfo accountInfo : k3) {
            for (com.tencent.mobileqq.login.account.a aVar : f16) {
                String maskUin = accountInfo.getMaskUin();
                Intrinsics.checkNotNullExpressionValue(maskUin, "unbindAccount.maskUin");
                if (h(maskUin, aVar.f()) && g(aVar)) {
                    QLog.d("LoginIPCModule", 1, "unbindPhoneFinish update account: " + aVar.f());
                    com.tencent.mobileqq.login.account.d.f241848a.p(aVar.f());
                }
                String maskUin2 = accountInfo.getMaskUin();
                Intrinsics.checkNotNullExpressionValue(maskUin2, "unbindAccount.maskUin");
                if (h(maskUin2, aVar.f())) {
                    QLog.d("LoginIPCModule", 1, "unbindPhoneFinish and clear SP account: " + aVar.f());
                    ((IAccountApi) QRoute.api(IAccountApi.class)).clearAccountIdentityStatus(aVar.f());
                }
            }
        }
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable final Bundle params, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, params, Integer.valueOf(callbackId));
        }
        if (action != null) {
            switch (action.hashCode()) {
                case -1466780627:
                    if (action.equals("RefreshNTTicket")) {
                        m(params);
                        return null;
                    }
                    return null;
                case -1417792258:
                    if (action.equals("PhoneSmsLogin")) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ipc.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                d.k(d.this, params);
                            }
                        });
                        return null;
                    }
                    return null;
                case -1175332321:
                    if (action.equals("JumpPhoneSmsLoginPage")) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ipc.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                d.j(d.this, params);
                            }
                        });
                        return null;
                    }
                    return null;
                case -869293886:
                    if (action.equals("finishActivity")) {
                        e(params, callbackId);
                        return null;
                    }
                    return null;
                case 1253761867:
                    if (action.equals("UnbindPhoneFinish")) {
                        n(params);
                        return null;
                    }
                    return null;
                default:
                    return null;
            }
        }
        return null;
    }
}
