package com.tencent.mobileqq.loginregister.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.activity.DevLockQuickVerifyActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.RiskHintDlgFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.login.LogoutHelper;
import com.tencent.mobileqq.login.aa;
import com.tencent.mobileqq.login.al;
import com.tencent.mobileqq.login.api.IDirectLoginService;
import com.tencent.mobileqq.login.fragment.BaseLoginFragment;
import com.tencent.mobileqq.login.ntlogin.ag;
import com.tencent.mobileqq.login.relogin.dialog.AccountManagerComponent;
import com.tencent.mobileqq.login.restart.LoginProcessRestartMonitor;
import com.tencent.mobileqq.login.restart.ProcessPreloadHelper;
import com.tencent.mobileqq.login.restart.Scene;
import com.tencent.mobileqq.login.restart.Stage;
import com.tencent.mobileqq.login.verify.MaskUinPwdVerifyFragment;
import com.tencent.mobileqq.login.y;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.l;
import com.tencent.mobileqq.loginregister.w;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.register.n;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.mobileqq.util.QuestionnaireForLoginManager;
import com.tencent.mobileqq.util.bh;
import com.tencent.mobileqq.util.f;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LoginRegisterApiImpl implements ILoginRegisterApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LoginRegisterApiImpl";
    private final CopyOnWriteArrayList<l> mDevLockVerifyListenerList;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements y {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginRegisterApiImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.login.y
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.login.y
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
        }
    }

    public LoginRegisterApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mDevLockVerifyListenerList = new CopyOnWriteArrayList<>();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void accountLogin(QBaseActivity qBaseActivity, com.tencent.mobileqq.login.c cVar, aa aaVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, qBaseActivity, cVar, aaVar);
        } else {
            al.b(cVar.f242200a).login(qBaseActivity, cVar, new a(), aaVar);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void addDevLockVerifyListener(l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) lVar);
        } else if (lVar != null && !this.mDevLockVerifyListenerList.contains(lVar)) {
            this.mDevLockVerifyListenerList.add(lVar);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void changePWDByPhoneSmsLogin(QBaseActivity qBaseActivity, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, qBaseActivity, str, str2);
        } else {
            ag.f242225a.i(qBaseActivity, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void clearCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            com.tencent.mobileqq.register.util.c.f280585a.g(new ArrayList());
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void deleteAccount(QBaseActivity qBaseActivity, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, qBaseActivity, str, Boolean.valueOf(z16));
            return;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime().isLogin() && MobileQQ.sMobileQQ.peekAppRuntime().getAccount().equals(str)) {
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).logout(qBaseActivity, false);
        }
        new w().h(qBaseActivity, str, z16);
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void doRegister(QBaseActivity qBaseActivity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) qBaseActivity, i3);
        } else {
            n.f280469a.m(qBaseActivity, i3, null, true, false, true, false);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void finishAllLoginActivity(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
            return;
        }
        QLog.i(TAG, 1, "finishAllLoginActivity finishRoot: " + z16);
        com.tencent.mobileqq.login.fragment.l.f242160a.b(z16);
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public Class<?> getDevLockQuickVerifyCls() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return DevLockQuickVerifyActivity.class;
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public Class<? extends QPublicBaseFragment> getHintDlgFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return RiskHintDlgFragment.class;
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public List<com.tencent.mobileqq.login.account.a> getLoginAccountList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (List) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return com.tencent.mobileqq.login.account.d.f241848a.f();
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public Class<?> getLoginActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return LoginActivity.class;
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public QIPCModule getLoginIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return new com.tencent.mobileqq.login.ipc.d();
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public byte getLoginType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Byte) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).byteValue();
        }
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "getLoginType uin is empty");
            return (byte) 0;
        }
        String property = MobileQQ.sMobileQQ.getProperty("property_key_login_type_" + str);
        QLog.i(TAG, 1, "getLoginType uin=" + StringUtil.getSimpleUinForPrint(str) + " loginType=" + property);
        if (!TextUtils.isEmpty(property)) {
            try {
                return Byte.parseByte(property);
            } catch (NumberFormatException e16) {
                QLog.w(TAG, 1, "getLoginType", e16);
            }
        }
        return (byte) 0;
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public boolean isLoggingIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (al.b(1).isLoggingIn() || al.b(5).isLoggingIn() || al.b(4).isLoggingIn() || al.b(7).isLoggingIn() || al.b(6).isLoggingIn()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public boolean isUinValid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) str)).booleanValue();
        }
        return LoginUtil.p(str);
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void jumpToAccountLoginPage(Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) activity, (Object) intent);
            return;
        }
        if (activity == null) {
            return;
        }
        com.tencent.mobileqq.login.fragment.l lVar = com.tencent.mobileqq.login.fragment.l.f242160a;
        Activity j3 = lVar.j();
        BaseLoginFragment k3 = lVar.k();
        if (j3 != null && k3 != null) {
            Bundle bundle = new Bundle();
            if (intent != null && intent.getExtras() != null) {
                bundle.putAll(intent.getExtras());
            }
            k3.Hh(5, bundle, false);
            return;
        }
        Navigator createNavigator = QRoute.createNavigator(activity, RouterConstants.UI_ROUTER_LOGIN);
        createNavigator.withInt("loginFragmentType", 5);
        if (intent != null) {
            if (intent.getExtras() != null) {
                createNavigator.withAll(intent.getExtras());
            }
            createNavigator.withFlags(intent.getFlags());
        }
        createNavigator.requestWithReturn();
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void jumpToAccountVerifyPage(Activity activity, int i3) {
        AccountInfo accountInfo;
        String str;
        String str2;
        String stringExtra;
        HashMap<String, String> r16;
        String str3 = "";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity, i3);
            return;
        }
        if (activity == null) {
            QLog.e(TAG, 1, "jumpToAccountVerifyPage activity is null");
            return;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            QLog.e(TAG, 1, "jumpToAccountVerifyPage intent is null");
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("key_mask_user_info");
        if (serializableExtra instanceof AccountInfo) {
            accountInfo = (AccountInfo) serializableExtra;
        } else {
            accountInfo = null;
        }
        if (accountInfo == null) {
            QLog.e(TAG, 1, "jumpToAccountVerifyPage accountInfo is null");
            return;
        }
        try {
            stringExtra = intent.getStringExtra("url");
        } catch (Exception e16) {
            e = e16;
            str = "";
        }
        if (TextUtils.isEmpty(stringExtra) || (r16 = z.r(stringExtra)) == null) {
            str2 = "";
            QLog.i(TAG, 2, "jumpToAccountVerifyPage");
            int intExtra = intent.getIntExtra(TangramHippyConstants.LOGIN_TYPE, 5);
            Bundle bundle = new Bundle();
            bundle.putInt(TangramHippyConstants.LOGIN_TYPE, intExtra);
            bundle.putBoolean("isSubaccount", intent.getBooleanExtra("isSubaccount", false));
            bundle.putBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB, true);
            bundle.putString("verifySig", str3);
            bundle.putString("uinToken", str2);
            bundle.putString("appid", intent.getStringExtra("appid"));
            bundle.putString("from_where", intent.getStringExtra("from_where"));
            MaskUinPwdVerifyFragment.Th(activity, accountInfo, bundle, i3);
        }
        str = r16.get(PreloadTRTCPlayerParams.KEY_SIG);
        try {
            str2 = r16.get("uin-token");
        } catch (Exception e17) {
            e = e17;
            QLog.w(TAG, 1, "jumpToAccountVerifyPage parseUrl fail", e);
            str2 = "";
            str3 = str;
            QLog.i(TAG, 2, "jumpToAccountVerifyPage");
            int intExtra2 = intent.getIntExtra(TangramHippyConstants.LOGIN_TYPE, 5);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(TangramHippyConstants.LOGIN_TYPE, intExtra2);
            bundle2.putBoolean("isSubaccount", intent.getBooleanExtra("isSubaccount", false));
            bundle2.putBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB, true);
            bundle2.putString("verifySig", str3);
            bundle2.putString("uinToken", str2);
            bundle2.putString("appid", intent.getStringExtra("appid"));
            bundle2.putString("from_where", intent.getStringExtra("from_where"));
            MaskUinPwdVerifyFragment.Th(activity, accountInfo, bundle2, i3);
        }
        str3 = str;
        QLog.i(TAG, 2, "jumpToAccountVerifyPage");
        int intExtra22 = intent.getIntExtra(TangramHippyConstants.LOGIN_TYPE, 5);
        Bundle bundle22 = new Bundle();
        bundle22.putInt(TangramHippyConstants.LOGIN_TYPE, intExtra22);
        bundle22.putBoolean("isSubaccount", intent.getBooleanExtra("isSubaccount", false));
        bundle22.putBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB, true);
        bundle22.putString("verifySig", str3);
        bundle22.putString("uinToken", str2);
        bundle22.putString("appid", intent.getStringExtra("appid"));
        bundle22.putString("from_where", intent.getStringExtra("from_where"));
        MaskUinPwdVerifyFragment.Th(activity, accountInfo, bundle22, i3);
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void jumpToLoginForSplash(@NonNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) activity);
            return;
        }
        Activity topActivity = Foreground.getTopActivity();
        if ((topActivity instanceof LoginActivity) && ((LoginActivity) topActivity).isResume()) {
            QLog.i(TAG, 1, "jumpToLoginForSplash topActivity is LoginActivity and activity isOnResume");
            return;
        }
        QLog.d(TAG, 4, "jumpToLoginForSplash startLogin");
        QRoute.createNavigator(activity, RouterConstants.UI_ROUTER_LOGIN).requestWithReturn();
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void jumpToPhoneNumLoginPage(Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) activity, i3);
            return;
        }
        if (activity == null) {
            return;
        }
        com.tencent.mobileqq.login.fragment.l lVar = com.tencent.mobileqq.login.fragment.l.f242160a;
        Activity j3 = lVar.j();
        BaseLoginFragment k3 = lVar.k();
        if (j3 != null && k3 != null) {
            QLog.i(TAG, 1, "jumpToPhoneNumLoginPage hasLoginActivity");
            Bundle bundle = new Bundle();
            bundle.putString(AuthDevOpenUgActivity.KEY_PHONE_NUM, "");
            bundle.putBoolean("key_second_state", false);
            bundle.putInt("key_login_page_entrance", i3);
            k3.Hh(4, bundle, false);
            return;
        }
        QLog.i(TAG, 1, "jumpToPhoneNumLoginPage has not LoginActivity");
        QRoute.createNavigator(activity, RouterConstants.UI_ROUTER_LOGIN).withInt("loginFragmentType", 4).withInt("key_login_page_entrance", i3).withBoolean("IS_ADD_ACCOUNT", true).request();
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void logout(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, activity, Boolean.valueOf(z16));
        } else {
            LogoutHelper.c(activity, z16);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void notifyDevLockVerifyOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Iterator<l> it = this.mDevLockVerifyListenerList.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next != null) {
                next.a();
            }
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void onApplicationCreateEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            ProcessPreloadHelper.f242601a.c();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void onMainPageShowEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            LoginProcessRestartMonitor.f(Stage.COLD_START_END);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void onRegisterProxyEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (LoginProcessRestartMonitor.t()) {
            LoginProcessRestartMonitor.i(Scene.SWITCH_ACCOUNT);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void onRegisterProxyTaskEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            LoginProcessRestartMonitor.i(Scene.SWITCH_ACCOUNT);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void registerAccountListChangeObserver(com.tencent.mobileqq.loginregister.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) aVar);
        } else {
            com.tencent.mobileqq.login.account.d.f241848a.c(aVar);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void removeAccountListChangeObserver(com.tencent.mobileqq.loginregister.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) aVar);
        } else {
            com.tencent.mobileqq.login.account.d.f241848a.m(aVar);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void removeDevLockVerifyListener(l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) lVar);
        } else if (lVar != null) {
            this.mDevLockVerifyListenerList.remove(lVar);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void reportForQuestionnaire() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            QuestionnaireForLoginManager.b();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void setLoginType(String str, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Byte.valueOf(b16));
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            MobileQQ.sMobileQQ.setProperty("property_key_login_type_" + str, String.valueOf((int) b16));
        }
        QLog.i(TAG, 1, "setLoginType uin=" + StringUtil.getSimpleUinForPrint(str) + " loginType=" + ((int) b16));
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void setPhoneToMMKV(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            bh.n(str);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void showDeleteAccountDialog(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) activity);
        } else {
            new AccountManagerComponent().y(activity);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void switchAccount(String str, e72.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        if (!NetworkUtil.isNetSupport(context)) {
            QQToast.makeText(context, context.getString(R.string.b3j), 0).show();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "switchAccount toAccount=" + str);
        }
        if (TextUtils.equals(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), str)) {
            QLog.i(TAG, 1, "switchAccount same account");
            return;
        }
        context.sendBroadcast(new Intent("before_account_change"));
        ((IDirectLoginService) QRoute.api(IDirectLoginService.class)).switchAccount(str, aVar);
        setLoginType(str, (byte) 0);
        ((ISubAccountAssistantForward) QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), context);
        f.a();
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginRegisterApi
    public void updateLoginAccount(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) str2);
            return;
        }
        QLog.d(TAG, 2, "lastQid:" + str + ", newQid:" + str2);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!TextUtils.equals(str, str2)) {
            com.tencent.mobileqq.login.account.d.o(peekAppRuntime.getCurrentAccountUin(), str);
        }
    }
}
