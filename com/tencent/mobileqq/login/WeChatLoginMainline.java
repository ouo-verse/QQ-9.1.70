package com.tencent.mobileqq.login;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.accountbinding.fragment.WechatLoginBindingFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.WeChatLoginMainline;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.remind.h;
import com.tencent.mobileqq.login.verify.DevLockVerifyComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.util.QuestionnaireForLoginManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import tencent.im.login.GatewayVerify$ReqBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class WeChatLoginMainline extends k<bw> {
    static IPatchRedirector $redirector_ = null;
    public static final int FAIL_WX_AUTH_ERROR = -5001;
    private static final String TAG = "LoginMainline_WeChat";
    private boolean mHasBindLoginTransit;
    private boolean mHasDevLockVerify;
    private boolean mIsWeChatAuthing;
    private String mProfileSig;
    private String mUin;
    private String mVerifySig;
    private final String mWxAppId;
    private String mWxCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends com.tencent.mobileqq.login.servlet.e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f241820d;

        a(long j3) {
            this.f241820d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WeChatLoginMainline.this, Long.valueOf(j3));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(WechatInfo wechatInfo) {
            WeChatLoginMainline.this.startBindLogin(wechatInfo);
        }

        @Override // com.tencent.mobileqq.login.servlet.e
        public void b(int i3, String str, int i16, int i17, final WechatInfo wechatInfo) {
            int i18;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), wechatInfo);
                return;
            }
            QLog.i(WeChatLoginMainline.TAG, 1, "onQueryWxBindState ret=" + i3 + " msg=" + str + " wxBindState=" + i16 + " qqBindState=" + i17);
            String valueOf = String.valueOf(System.currentTimeMillis() - this.f241820d);
            WeChatLoginMainline weChatLoginMainline = WeChatLoginMainline.this;
            if (i3 == 0) {
                i18 = 0;
            } else {
                i18 = 1;
            }
            weChatLoginMainline.reportEvent("0X800C39E", i18, valueOf, String.valueOf(i3), WeChatLoginMainline.this.getReportBindState(i16, i17), "");
            if (i3 == 0) {
                WeChatLoginMainline weChatLoginMainline2 = WeChatLoginMainline.this;
                if (wechatInfo != null) {
                    str2 = wechatInfo.a();
                } else {
                    str2 = "";
                }
                weChatLoginMainline2.mProfileSig = str2;
                if (i17 == 2) {
                    WeChatLoginMainline.this.requestWXLogin();
                    return;
                } else {
                    WeChatLoginMainline.this.hideLoading(false);
                    WeChatLoginMainline.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.bv
                        @Override // java.lang.Runnable
                        public final void run() {
                            WeChatLoginMainline.a.this.e(wechatInfo);
                        }
                    });
                    return;
                }
            }
            WeChatLoginMainline.this.onLoginFailed(new aj(i3, BaseApplication.getContext().getString(R.string.c68)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements com.tencent.mobileqq.accountbinding.fragment.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f241822a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f241823b;

        b(long j3, boolean z16) {
            this.f241822a = j3;
            this.f241823b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WeChatLoginMainline.this, Long.valueOf(j3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.accountbinding.fragment.f
        public void a(@NonNull String str) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QLog.i(WeChatLoginMainline.TAG, 1, "onBindLoginSuccess uin=" + StringUtil.getSimpleUinForPrint(str));
            WeChatLoginMainline.this.reportEvent("0X800C3A4", 0, String.valueOf(System.currentTimeMillis() - this.f241822a), "", "", "");
            WeChatLoginMainline weChatLoginMainline = WeChatLoginMainline.this;
            if (this.f241823b) {
                str2 = "1";
            } else {
                str2 = "2";
            }
            weChatLoginMainline.reportEvent("0X800C450", 0, "", str2, com.tencent.mobileqq.statistics.o.c(), "");
            WeChatLoginMainline.this.onLoginSuccess(str, new Bundle());
        }

        @Override // com.tencent.mobileqq.accountbinding.fragment.f
        public void b() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i(WeChatLoginMainline.TAG, 1, "onBindCancel");
            WeChatLoginMainline.this.reportEvent("0X800C3A4", 2, String.valueOf(System.currentTimeMillis() - this.f241822a), "", "", "");
            WeChatLoginMainline weChatLoginMainline = WeChatLoginMainline.this;
            if (this.f241823b) {
                str = "1";
            } else {
                str = "2";
            }
            weChatLoginMainline.reportEvent("0X800C450", 1, "", str, com.tencent.mobileqq.statistics.o.c(), "");
            WeChatLoginMainline.this.onLoginCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c extends com.tencent.mobileqq.login.servlet.e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f241825d;

        c(long j3) {
            this.f241825d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WeChatLoginMainline.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.login.servlet.e
        public void c(int i3, ErrMsg errMsg) {
            String str;
            int i16;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) errMsg);
                return;
            }
            if (errMsg != null) {
                str = errMsg.getMessage();
            } else {
                str = "";
            }
            String str3 = str;
            QLog.i(WeChatLoginMainline.TAG, 1, "onWxLogin ret=" + i3 + " msg=" + str3);
            WeChatLoginMainline weChatLoginMainline = WeChatLoginMainline.this;
            if (i3 == 0) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            weChatLoginMainline.reportEvent("0X800C39F", i16, String.valueOf(System.currentTimeMillis() - this.f241825d), String.valueOf(i3), "", "");
            if (i3 == 0) {
                WeChatLoginMainline.this.mVerifySig = null;
                WeChatLoginMainline.this.getStViaWxLogin(false);
                return;
            }
            if (errMsg != null && errMsg.getType() == 1) {
                str2 = errMsg.getOtherinfo();
            } else {
                str2 = null;
            }
            WeChatLoginMainline.this.onLoginFailed(new aj(i3, i3, str3, errMsg, str2, null, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d extends com.tencent.mobileqq.login.servlet.e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f241827d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f241828e;

        d(long j3, boolean z16) {
            this.f241827d = j3;
            this.f241828e = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WeChatLoginMainline.this, Long.valueOf(j3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.login.servlet.e
        public void a(int i3, String str, aj ajVar, DevlockInfo devlockInfo) {
            String str2;
            int i16;
            String str3;
            aj ajVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, ajVar, devlockInfo);
                return;
            }
            if (ajVar == null) {
                str2 = "";
            } else {
                str2 = ajVar.f241866c;
            }
            QLog.i(WeChatLoginMainline.TAG, 1, "onGetStViaWxLogin ret=" + i3 + " msg=" + str2 + " uin=" + StringUtil.getSimpleUinForPrint(str));
            WeChatLoginMainline weChatLoginMainline = WeChatLoginMainline.this;
            if (i3 == 0) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            String valueOf = String.valueOf(System.currentTimeMillis() - this.f241827d);
            String valueOf2 = String.valueOf(i3);
            if (this.f241828e) {
                str3 = "2";
            } else {
                str3 = "1";
            }
            weChatLoginMainline.reportEvent("0X800C3A0", i16, valueOf, valueOf2, str3, "");
            WeChatLoginMainline.this.mUin = str;
            if (i3 == 0) {
                WeChatLoginMainline.this.onLoginSuccess(str, new Bundle());
                return;
            }
            if (DevLockVerifyComponent.o(i3) && devlockInfo != null) {
                WeChatLoginMainline.this.startDevLockVerify(devlockInfo, i3, str);
                return;
            }
            if (i3 == 24) {
                WeChatLoginMainline.this.onShowRemindDialog(ajVar);
                return;
            }
            if (ajVar == null) {
                ajVar2 = new aj(i3, "");
            } else {
                ajVar2 = ajVar;
            }
            WeChatLoginMainline.this.onLoginFailed(ajVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements h.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeChatLoginMainline.this);
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                WeChatLoginMainline.this.onLoginCancel();
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                WeChatLoginMainline.this.onReLogin();
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void c(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class f implements DevLockVerifyComponent.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f241831a;

        f(long j3) {
            this.f241831a = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WeChatLoginMainline.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.login.verify.DevLockVerifyComponent.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i(WeChatLoginMainline.TAG, 1, "DevLockVerify onVerifyCancel");
            WeChatLoginMainline.this.reportEvent("0X800C3A2", 2, String.valueOf(System.currentTimeMillis() - this.f241831a), "", "", "");
            WeChatLoginMainline.this.onLoginCancel();
        }

        @Override // com.tencent.mobileqq.login.verify.DevLockVerifyComponent.c
        public void b(boolean z16, Bundle bundle) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            QLog.i(WeChatLoginMainline.TAG, 1, "DevLockVerify success isLogin = " + z16);
            WeChatLoginMainline.this.reportEvent("0X800C3A2", 0, String.valueOf(System.currentTimeMillis() - this.f241831a), "", "", "");
            if (z16) {
                WeChatLoginMainline.this.onLoginSuccess(bundle.getString("uin"), new Bundle());
                return;
            }
            if (bundle != null) {
                str = bundle.getString("devlock_verify_sig");
            } else {
                str = null;
            }
            WeChatLoginMainline.this.mVerifySig = str;
            WeChatLoginMainline.this.getStViaWxLogin(true);
        }
    }

    public WeChatLoginMainline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mWxAppId = com.tencent.mobileqq.wxapi.impl.a.a().b();
        this.mIsWeChatAuthing = false;
        this.mHasDevLockVerify = false;
        this.mHasBindLoginTransit = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String getReportAuxiliaryInfo() {
        boolean z16 = this.mHasDevLockVerify;
        int i3 = z16;
        if (this.mHasBindLoginTransit) {
            i3 = (z16 ? 1 : 0) | 2;
        }
        return String.valueOf(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getReportBindState(int i3, int i16) {
        int i17;
        if (i3 == 2) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        if (i16 == 2) {
            i17 |= 2;
        }
        return String.valueOf(i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStViaWxLogin(boolean z16) {
        QLog.i(TAG, 1, "getStViaWxLogin afterDevLockVerify=" + z16 + " verifySig=" + this.mVerifySig);
        com.tencent.mobileqq.login.servlet.f.c(this.mWxCode, this.mWxAppId, this.mProfileSig, this.mVerifySig, ((bw) this.mLoginParams).f242202c, this.mUin, new d(System.currentTimeMillis(), z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoginFailed$1(aj ajVar) {
        ai.p(getActivity(), ((bw) this.mLoginParams).f242201b, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGetWXAuthCode$0(long j3, int i3, String str, String str2) {
        QLog.d(TAG, 1, "onWXAuthResp, errorCode = " + i3);
        this.mIsWeChatAuthing = false;
        if (!isLoggingIn()) {
            QLog.i(TAG, 1, "onWXAuthResp, is not login");
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() - j3);
        if (i3 != -2) {
            if (i3 != 0) {
                QLog.d(TAG, 1, "onWXAuthResp, other");
                reportEvent("0X800C39D", 1, valueOf, String.valueOf(i3), "", "");
                onLoginFailed(new aj(-5001, BaseApplication.getContext().getString(R.string.f211495kz)));
            } else {
                QLog.d(TAG, 1, "onWXAuthSuccess, get wxCode: " + str2);
                reportEvent("0X800C39D", 0, valueOf, "", "", "");
                this.mWxCode = str2;
                queryBindState();
            }
        } else {
            reportEvent("0X800C39D", 2, valueOf, "", "", "");
            onLoginCancel();
        }
        ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).reportWXAuthResult(1, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShowRemindDialog(aj ajVar) {
        if (ajVar != null && !new com.tencent.mobileqq.login.remind.m().h(getActivity(), ajVar.f241869f, this.mUin, new e())) {
            onReLogin();
        }
    }

    private void queryBindState() {
        QLog.i(TAG, 1, "queryBindState");
        showLoading();
        com.tencent.mobileqq.login.servlet.f.d(this.mWxCode, this.mWxAppId, new a(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportEvent(String str, int i3, String str2, String str3, String str4, String str5) {
        com.tencent.mobileqq.util.as.b("wechat_login_mainline", str, "", ((bw) this.mLoginParams).f242201b, i3, false, str2, str3, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestWXLogin() {
        QLog.i(TAG, 1, "requestWXLogin");
        long currentTimeMillis = System.currentTimeMillis();
        this.mUin = null;
        com.tencent.mobileqq.login.servlet.f.e(this.mWxCode, this.mWxAppId, this.mProfileSig, new c(currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBindLogin(WechatInfo wechatInfo) {
        boolean z16 = true;
        QLog.i(TAG, 1, "startBindLogin");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "wechatInfo=" + wechatInfo);
        }
        QBaseActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            long currentTimeMillis = System.currentTimeMillis();
            reportEvent("0X800C3A3", 0, "", "", "", "");
            this.mHasBindLoginTransit = true;
            if (wechatInfo == null || TextUtils.isEmpty(wechatInfo.f())) {
                z16 = false;
            }
            WechatLoginBindingFragment.zh(activity, wechatInfo, new b(currentTimeMillis, z16));
            ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportWechatLoginBinding();
            return;
        }
        QLog.w(TAG, 1, "startBindLogin fail, activity is null or finishing");
        onLoginCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDevLockVerify(DevlockInfo devlockInfo, int i3, String str) {
        String str2;
        QLog.d(TAG, 1, "startDevLockVerify, uin = " + StringUtil.getSimpleUinForPrint(str));
        QuestionnaireForLoginManager.g("new_device");
        long currentTimeMillis = System.currentTimeMillis();
        reportEvent("0X800C3A1", 0, "", "", "", "");
        this.mHasDevLockVerify = true;
        T t16 = this.mLoginParams;
        if (((bw) t16).f242201b == 16 && ((bw) t16).f242204e) {
            str2 = com.tencent.mobileqq.accountbinding.d.f174609a.g();
        } else {
            str2 = null;
        }
        String str3 = str2;
        DevLockVerifyComponent devLockVerifyComponent = new DevLockVerifyComponent();
        Bundle bundle = new Bundle();
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        gatewayVerify$ReqBody.msg_req_common_info.bool_need_remind_in_cancel_status.set(com.tencent.mobileqq.login.remind.n.f242580a.c(str));
        gatewayVerify$ReqBody.msg_req_common_info.setHasFlag(true);
        bundle.putByteArray(AppConstants.Key.KEY_CONNECT_DATA, gatewayVerify$ReqBody.toByteArray());
        devLockVerifyComponent.A(6, devlockInfo, str, str3, i3, bundle, new f(currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGetWXAuthCode() {
        QLog.i(TAG, 1, "startGetWXAuthCode");
        final long currentTimeMillis = System.currentTimeMillis();
        this.mIsWeChatAuthing = true;
        com.tencent.mobileqq.wxapi.impl.a.a().g(new IWXAuthApi.a() { // from class: com.tencent.mobileqq.login.bt
            @Override // com.tencent.mobileqq.wxapi.IWXAuthApi.a
            public final void a(int i3, String str, String str2) {
                WeChatLoginMainline.this.lambda$startGetWXAuthCode$0(currentTimeMillis, i3, str, str2);
            }
        });
    }

    @Override // com.tencent.mobileqq.login.k
    public boolean canLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean canLogin = super.canLogin();
        if (!canLogin && this.mIsWeChatAuthing) {
            return true;
        }
        return canLogin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "onLoginCancel");
        reportEvent("0X800C3A5", 2, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getReportAuxiliaryInfo(), "");
        QuestionnaireForLoginManager.d(16);
        QuestionnaireForLoginManager.e();
        super.onLoginCancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginFailed(final aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) ajVar);
            return;
        }
        QLog.i(TAG, 1, "onLoginFailed ret=" + ajVar.f241864a + " msg=" + ajVar.f241866c);
        reportEvent("0X800C3A5", 1, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), String.valueOf(ajVar.f241864a), getReportAuxiliaryInfo(), "");
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.bu
            @Override // java.lang.Runnable
            public final void run() {
                WeChatLoginMainline.this.lambda$onLoginFailed$1(ajVar);
            }
        });
        QuestionnaireForLoginManager.d(16);
        QuestionnaireForLoginManager.e();
        super.onLoginFailed(ajVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginSuccess(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) bundle);
            return;
        }
        if (!checkBeforeLoginSuccess(str, bundle)) {
            return;
        }
        QLog.i(TAG, 1, "onLoginSuccess uin=" + StringUtil.getSimpleUinForPrint(str));
        com.tencent.mobileqq.login.account.d.f241848a.b(str, str, 6);
        if (!TextUtils.isEmpty(str)) {
            MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + str, str);
        }
        reportEvent("0X800C3A5", 0, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getReportAuxiliaryInfo(), "");
        super.onLoginSuccess(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onReLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onReLogin();
            getStViaWxLogin(!TextUtils.isEmpty(this.mVerifySig));
        }
    }

    @Override // com.tencent.mobileqq.login.k
    protected void startLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "start wx login");
        this.mHasDevLockVerify = false;
        this.mHasBindLoginTransit = false;
        reportEvent("0X800C39C", 0, "", "", "", "");
        QuestionnaireForLoginManager.i("wechat_login");
        QuestionnaireForLoginManager.h(16);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.bs
            @Override // java.lang.Runnable
            public final void run() {
                WeChatLoginMainline.this.startGetWXAuthCode();
            }
        }, 16, null, true);
    }
}
