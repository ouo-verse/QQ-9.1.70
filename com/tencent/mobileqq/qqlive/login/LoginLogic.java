package com.tencent.mobileqq.qqlive.login;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.utils.ThreadCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LoginLogic implements IQQLiveModuleLogin {
    static IPatchRedirector $redirector_;
    private volatile int C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private volatile LoginRequest f271382d;

    /* renamed from: e, reason: collision with root package name */
    private volatile LoginInfo f271383e;

    /* renamed from: f, reason: collision with root package name */
    private final List<IQQLiveLoginCallback> f271384f;

    /* renamed from: h, reason: collision with root package name */
    private IQQLiveSDK f271385h;

    /* renamed from: i, reason: collision with root package name */
    private final AuthRunnable f271386i;

    /* renamed from: m, reason: collision with root package name */
    private final List<IQQLiveLoginCallback> f271387m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class AuthRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        AuthRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginLogic.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (LoginLogic.this.f271385h != null && LoginLogic.this.isLogined() && LoginLogic.this.f271383e != null && !LoginLogic.this.f271383e.isValid()) {
                if (NetworkUtil.isNetworkAvailable()) {
                    LoginLogic loginLogic = LoginLogic.this;
                    loginLogic.reLogin(loginLogic.f271382d, null);
                    ThreadCenter.a(LoginLogic.this.f271386i, 6000000);
                    return;
                }
                ThreadCenter.a(LoginLogic.this.f271386i, 300000);
            }
        }
    }

    public LoginLogic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f271384f = new CopyOnWriteArrayList();
        this.f271386i = new AuthRunnable();
        this.f271387m = new CopyOnWriteArrayList();
        this.C = 0;
    }

    private void o(int i3, int i16) {
        int i17 = this.C;
        if (QLog.isColorLevel()) {
            AegisLogger.i("Login|LoginLogic", "changeState", "hash:" + this.D + ", old:" + i17 + ", new:" + i3 + ", check:" + i16);
        }
        if (i17 == i3) {
            return;
        }
        if (i16 > -1 && i17 != i16) {
            return;
        }
        this.C = i3;
    }

    private boolean p(String str, LoginRequest loginRequest, LoginInfo loginInfo, String str2) {
        if (loginRequest == null) {
            AegisLogger.e("Login|LoginLogic", "checkLoginInfo", "hash:" + this.D + ", " + str2 + ", requestInfo is null");
            return false;
        }
        if (loginInfo == null) {
            AegisLogger.e("Login|LoginLogic", "checkLoginInfo", "hash:" + this.D + ", " + str2 + ", loginInfo is null");
            return false;
        }
        if (!TextUtils.equals(loginInfo.originUin, loginRequest.uin)) {
            AegisLogger.e("Login|LoginLogic", "checkLoginInfo", "hash:" + this.D + ", " + str2 + ", uin not equal");
            return false;
        }
        if (!str.equals(loginInfo.appId)) {
            AegisLogger.e("Login|LoginLogic", "checkLoginInfo", "hash:" + this.D + ", " + str2 + ", clientType not equal");
            return false;
        }
        if (!loginInfo.isValid()) {
            AegisLogger.e("Login|LoginLogic", "checkLoginInfo", "hash:" + this.D + ", " + str2 + ", loginInfo not valid");
            return false;
        }
        return true;
    }

    private LoginInfo q(String str, LoginRequest loginRequest) {
        LoginInfo loginInfo = this.f271383e;
        if (isLogined() && p(str, loginRequest, loginInfo, "memCache")) {
            return loginInfo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit r(QQLiveResponse qQLiveResponse) {
        if (!qQLiveResponse.isFailed() && qQLiveResponse.getRsp() != null) {
            IQQLiveSDK iQQLiveSDK = this.f271385h;
            if (iQQLiveSDK == null) {
                t(5105, "invalid live sdk");
                return Unit.INSTANCE;
            }
            u(iQQLiveSDK.getAppId(), (LiveLoginInfo) qQLiveResponse.getRsp());
            return Unit.INSTANCE;
        }
        t(5105, "retCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        return Unit.INSTANCE;
    }

    private synchronized void s() {
        AegisLogger.i("Login|LoginLogic", "logOut", "hash:" + this.D + ", state:" + this.C);
        this.f271382d = null;
        this.f271383e = null;
        o(0, -1);
    }

    private void setLoginInfo(LoginInfo loginInfo) {
        this.f271383e = loginInfo;
    }

    private void t(int i3, String str) {
        AegisLogger.i("Login|LoginLogic", "onLoginCallFail", "hash:" + this.D + ", code:" + i3 + ", msg:" + str);
        o(3, 2);
        try {
            Iterator<IQQLiveLoginCallback> it = this.f271384f.iterator();
            while (it.hasNext()) {
                it.next().onFailed(i3, str);
            }
        } catch (Throwable th5) {
            AegisLogger.e("Login|LoginLogic", "onLoginCallFail", th5.getMessage());
        }
        try {
            if (this.f271387m.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f271387m);
            this.f271387m.clear();
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                ((IQQLiveLoginCallback) it5.next()).onFailed(i3, str);
            }
        } catch (Throwable th6) {
            AegisLogger.e("Login|LoginLogic", "onLoginCallFail", th6.getMessage());
        }
    }

    private void u(String str, LiveLoginInfo liveLoginInfo) {
        AegisLogger.i("Login|LoginLogic", "onLoginCallback", "hash:" + this.D);
        LoginInfo loginInfo = new LoginInfo(liveLoginInfo);
        if (!p(str, this.f271382d, loginInfo, "net")) {
            t(9999, "hash:" + this.D + "checkLoginInfo invalid");
            return;
        }
        if (this.C != 2) {
            AegisLogger.e("Login|LoginLogic", "onLoginCallback", "hash:" + this.D + ", state=" + this.C + ", ignore");
            return;
        }
        setLoginInfo(loginInfo);
        v(loginInfo, "net");
        w();
    }

    private void v(LoginInfo loginInfo, String str) {
        if (loginInfo.userInfo == null) {
            AegisLogger.e("Login|LoginLogic", "onSuccessCallback", "liveUserInfo is null from:" + str);
        }
        AegisLogger.i("Login|LoginLogic", "onSuccessCallback", "hash:" + this.D + ", from:" + str);
        o(1, 2);
        Iterator<IQQLiveLoginCallback> it = this.f271384f.iterator();
        while (it.hasNext()) {
            try {
                it.next().onSuccess(loginInfo);
            } catch (Throwable th5) {
                AegisLogger.e("Login|LoginLogic", "onSuccessCallback", "", th5);
            }
        }
        if (this.f271387m.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f271387m);
        this.f271387m.clear();
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            try {
                ((IQQLiveLoginCallback) it5.next()).onSuccess(loginInfo);
            } catch (Throwable th6) {
                AegisLogger.e("Login|LoginLogic", "onSuccessCallback", "", th6);
            }
        }
    }

    private void w() {
        ThreadCenter.b(this.f271386i);
        ThreadCenter.a(this.f271386i, 6000000);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        AegisLogger.i("Login|LoginLogic", "destroy", "hash:" + this.D);
        o(0, -1);
        this.f271384f.clear();
        this.f271387m.clear();
        AegisLogger.d("Login|LoginLogic", "destroy", "clear all login callback size: " + this.f271384f.size());
        ThreadCenter.b(this.f271386i);
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public LoginInfo getLoginInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LoginInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f271383e;
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public LoginRequest getLoginRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LoginRequest) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f271382d;
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public int getLoginStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.C;
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public LiveUserInfo getUserInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LiveUserInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.f271383e == null) {
            return null;
        }
        return this.f271383e.userInfo;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        this.f271385h = iQQLiveSDK;
        iQQLiveSDK.getAppRuntime();
        this.D = hashCode();
        AegisLogger.i("Login|LoginLogic", "init", "hash:" + this.D + ", appId:" + iQQLiveSDK.getAppId());
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public boolean isLogined() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.C == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public synchronized void login(LoginRequest loginRequest, IQQLiveLoginCallback iQQLiveLoginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) loginRequest, (Object) iQQLiveLoginCallback);
            return;
        }
        AegisLogger.i("Login|LoginLogic", "login", "hash:" + this.D + ", state:" + this.C);
        if (this.f271385h == null) {
            AegisLogger.i("Login|LoginLogic", "login", "hash:" + this.D + "not inited, return");
            return;
        }
        if (iQQLiveLoginCallback != null && !this.f271387m.contains(iQQLiveLoginCallback)) {
            this.f271387m.add(iQQLiveLoginCallback);
        }
        if (this.C == 2) {
            return;
        }
        if (this.f271382d == null) {
            this.f271382d = loginRequest;
        }
        if (this.f271382d == null) {
            t(10000, this.D + ", login, requestInfo is null");
            return;
        }
        LoginInfo q16 = q(this.f271385h.getAppId(), this.f271382d);
        if (q16 != null) {
            AegisLogger.i("Login|LoginLogic", "login", "hash:" + this.D + ", hit mem cache");
            v(q16, "memCache");
            return;
        }
        o(2, -1);
        ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).login(this.f271385h.getAppId(), this.f271382d.uin, this.f271382d.qqA2, new Function1() { // from class: com.tencent.mobileqq.qqlive.login.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r16;
                r16 = LoginLogic.this.r((QQLiveResponse) obj);
                return r16;
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public synchronized void reLogin(LoginRequest loginRequest, IQQLiveLoginCallback iQQLiveLoginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) loginRequest, (Object) iQQLiveLoginCallback);
            return;
        }
        AegisLogger.i("Login|LoginLogic", "reLogin", "hash:" + this.D + ", state:" + this.C);
        s();
        login(loginRequest, iQQLiveLoginCallback);
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public void registerLoginStateCallback(IQQLiveLoginCallback iQQLiveLoginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iQQLiveLoginCallback);
        } else if (!this.f271384f.contains(iQQLiveLoginCallback)) {
            this.f271384f.add(iQQLiveLoginCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        AegisLogger.i("Login|LoginLogic", "reset", "hash:" + this.D);
        o(0, -1);
        this.f271384f.clear();
        ThreadCenter.b(this.f271386i);
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
    public void unregisterLoginStateCallback(IQQLiveLoginCallback iQQLiveLoginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iQQLiveLoginCallback);
        } else {
            this.f271384f.remove(iQQLiveLoginCallback);
        }
    }
}
