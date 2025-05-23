package com.tencent.mobileqq.login;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.login.AccountLoginMainline;
import com.tencent.mobileqq.login.remind.h;
import com.tencent.mobileqq.login.verify.DevLockVerifyComponent;
import com.tencent.mobileqq.login.verify.PuzzleVerifyComponent;
import com.tencent.mobileqq.login.verify.PuzzleVerifyInfo;
import com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.QuestionnaireForLoginManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import tencent.im.login.GatewayVerify$ReqBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AccountLoginMainline extends k<com.tencent.mobileqq.login.c> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LoginMainline_Account";
    private boolean mHasDevLockVerify;
    private boolean mHasPuzzleVerify;
    private boolean mIsReLogin;
    private String mVerifySig;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements h.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountLoginMainline.this);
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                AccountLoginMainline.this.onLoginCancel();
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                AccountLoginMainline.this.onReLogin();
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
    public class b implements PuzzleVerifyComponent.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f241778a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f241779b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f241780c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PuzzleVerifyInfo f241781d;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a extends com.tencent.mobileqq.login.servlet.d {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // com.tencent.mobileqq.login.servlet.d
            public void e(int i3, boolean z16, Bundle bundle) {
                int i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                    return;
                }
                QLog.i(AccountLoginMainline.TAG, 1, "onSubmitPuzzleTicket ret=" + i3 + " isSuccess=" + z16);
                boolean z17 = bundle.getBoolean("needDevLockVerify", false);
                if (i3 != 0 && !z17) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                AccountLoginMainline.this.reportEvent("0X800C4A0", i16, "", "", String.valueOf(i3));
                b bVar = b.this;
                AccountLoginMainline.this.notifyObserver(bVar.f241780c, z16, bundle);
            }
        }

        b(long j3, Bundle bundle, int i3, PuzzleVerifyInfo puzzleVerifyInfo) {
            this.f241778a = j3;
            this.f241779b = bundle;
            this.f241780c = i3;
            this.f241781d = puzzleVerifyInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AccountLoginMainline.this, Long.valueOf(j3), bundle, Integer.valueOf(i3), puzzleVerifyInfo);
            }
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i(AccountLoginMainline.TAG, 1, "PuzzleVerify cancel");
            AccountLoginMainline.this.reportEvent("0X800C27A", 2, String.valueOf(System.currentTimeMillis() - this.f241778a), "", "");
            AccountLoginMainline.this.onLoginCancel();
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void b(boolean z16, String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, str3);
                return;
            }
            QLog.i(AccountLoginMainline.TAG, 1, "PuzzleVerify result=" + z16);
            AccountLoginMainline.this.reportEvent("0X800C27A", 0, String.valueOf(System.currentTimeMillis() - this.f241778a), "", "");
            Bundle bundle = this.f241779b;
            T t16 = AccountLoginMainline.this.mLoginParams;
            if (((com.tencent.mobileqq.login.c) t16).f242047k && ((com.tencent.mobileqq.login.c) t16).f242049m != null && bundle != null) {
                bundle.putInt("businessType", ((com.tencent.mobileqq.login.c) t16).f242049m.intValue());
            }
            com.tencent.mobileqq.login.servlet.b.h(this.f241780c, str, this.f241781d, AccountLoginMainline.this.getNewPassThroughParams(bundle, true), new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements DevLockVerifyComponent.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f241784a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f241785b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f241786c;

        c(long j3, String str, int i3) {
            this.f241784a = j3;
            this.f241785b = str;
            this.f241786c = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AccountLoginMainline.this, Long.valueOf(j3), str, Integer.valueOf(i3));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(byte[] bArr) {
            AccountLoginMainline.this.showRemindDialog(bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            AccountLoginMainline accountLoginMainline = AccountLoginMainline.this;
            accountLoginMainline.requestLogin((com.tencent.mobileqq.login.c) accountLoginMainline.mLoginParams, true);
        }

        @Override // com.tencent.mobileqq.login.verify.DevLockVerifyComponent.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i(AccountLoginMainline.TAG, 1, "DevLockVerify cancel");
            AccountLoginMainline.this.reportEvent("0X800C27B", 2, String.valueOf(System.currentTimeMillis() - this.f241784a), this.f241785b, "");
            AccountLoginMainline.this.onLoginCancel();
        }

        @Override // com.tencent.mobileqq.login.verify.DevLockVerifyComponent.c
        public void b(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            QLog.i(AccountLoginMainline.TAG, 1, "DevLockVerify success isLogin = " + z16);
            AccountLoginMainline.this.reportEvent("0X800C27B", 0, String.valueOf(System.currentTimeMillis() - this.f241784a), this.f241785b, "");
            String str = null;
            FromServiceMsg fromServiceMsg = null;
            if (z16) {
                if (bundle != null) {
                    fromServiceMsg = (FromServiceMsg) bundle.getParcelable("fromServiceMsg");
                }
                if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
                    z17 = true;
                }
                AccountLoginMainline.this.notifyObserver(this.f241786c, z17, bundle);
                return;
            }
            if (bundle != null && bundle.getInt("ret") == 24) {
                final byte[] byteArray = bundle.getByteArray("errorTlv");
                AccountLoginMainline.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AccountLoginMainline.c.this.e(byteArray);
                    }
                });
                return;
            }
            AccountLoginMainline accountLoginMainline = AccountLoginMainline.this;
            if (bundle != null) {
                str = bundle.getString("devlock_verify_sig");
            }
            accountLoginMainline.mVerifySig = str;
            AccountLoginMainline.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.b
                @Override // java.lang.Runnable
                public final void run() {
                    AccountLoginMainline.c.this.f();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d extends com.tencent.mobileqq.login.servlet.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f241788d;

        d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AccountLoginMainline.this, Boolean.valueOf(z16));
            } else {
                this.f241788d = z16;
            }
        }

        private void f(boolean z16, int i3) {
            String str;
            String str2;
            if (!this.f241788d) {
                return;
            }
            AccountLoginMainline accountLoginMainline = AccountLoginMainline.this;
            int i16 = !z16 ? 1 : 0;
            String valueOf = String.valueOf(i3);
            if (AccountLoginMainline.this.mIsReLogin) {
                str = "1";
            } else {
                str = "0";
            }
            if (AccountLoginMainline.this.mHasPuzzleVerify) {
                str2 = "1";
            } else {
                str2 = "2";
            }
            accountLoginMainline.reportEvent("0X800C49F", i16, valueOf, str, str2);
        }

        @Override // com.tencent.mobileqq.login.servlet.a
        public void a(DevlockInfo devlockInfo, String str, int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, devlockInfo, str, Integer.valueOf(i3), bundle);
                return;
            }
            QLog.i(AccountLoginMainline.TAG, 1, "onLoginDevLockVerify ret=" + i3);
            f(true, i3);
            AccountLoginMainline accountLoginMainline = AccountLoginMainline.this;
            accountLoginMainline.startDevLockVerify(((com.tencent.mobileqq.login.c) accountLoginMainline.mLoginParams).f242200a, devlockInfo, str, i3, bundle);
        }

        @Override // com.tencent.mobileqq.login.servlet.a
        public void b(aj ajVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) ajVar);
            } else {
                f(false, ajVar.f241864a);
                AccountLoginMainline.this.onLoginFailed(ajVar);
            }
        }

        @Override // com.tencent.mobileqq.login.servlet.a
        public void c(PuzzleVerifyInfo puzzleVerifyInfo, int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, puzzleVerifyInfo, Integer.valueOf(i3), bundle);
                return;
            }
            QLog.i(AccountLoginMainline.TAG, 1, "onLoginPuzzleVerify");
            f(true, i3);
            AccountLoginMainline accountLoginMainline = AccountLoginMainline.this;
            accountLoginMainline.startPuzzleVerify(((com.tencent.mobileqq.login.c) accountLoginMainline.mLoginParams).f242200a, puzzleVerifyInfo, bundle);
        }

        @Override // com.tencent.mobileqq.login.servlet.a
        public void d(String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle);
            } else {
                f(true, 0);
                AccountLoginMainline.this.onLoginSuccess(str, bundle);
            }
        }

        @Override // com.tencent.mobileqq.login.servlet.a
        public void e(aj ajVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                AccountLoginMainline.this.showRemindDialog(ajVar.f241869f);
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) ajVar);
            }
        }
    }

    public AccountLoginMainline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHasPuzzleVerify = false;
        this.mHasDevLockVerify = false;
        this.mIsReLogin = false;
        this.mVerifySig = null;
    }

    private String getLoginDuration() {
        return String.valueOf(System.currentTimeMillis() - this.mLoginStartTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Bundle getNewPassThroughParams(Bundle bundle, boolean z16) {
        String str;
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (z16) {
            str = AppConstants.Key.KEY_CONNECT_DATA;
        } else {
            str = "smsExtraData";
        }
        if (!bundle.containsKey(str)) {
            GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
            gatewayVerify$ReqBody.msg_req_common_info.bool_need_remind_in_cancel_status.set(com.tencent.mobileqq.login.remind.n.f242580a.c(((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f));
            gatewayVerify$ReqBody.msg_req_common_info.setHasFlag(true);
            bundle.putByteArray(str, gatewayVerify$ReqBody.toByteArray());
        } else if (!((com.tencent.mobileqq.login.c) this.mLoginParams).f242203d) {
            try {
                byte[] byteArray = bundle.getByteArray(str);
                GatewayVerify$ReqBody gatewayVerify$ReqBody2 = new GatewayVerify$ReqBody();
                gatewayVerify$ReqBody2.mergeFrom(byteArray);
                gatewayVerify$ReqBody2.msg_req_common_info.bool_need_remind_in_cancel_status.set(com.tencent.mobileqq.login.remind.n.f242580a.c(((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f));
                gatewayVerify$ReqBody2.msg_req_common_info.setHasFlag(true);
                bundle.putByteArray(str, gatewayVerify$ReqBody2.toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 1, "getNewPassThroughParams error" + e16);
            }
        }
        return bundle;
    }

    private int getNotifyType(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return 0;
                }
                return 1100;
            }
            return 1035;
        }
        return 1001;
    }

    private String getVerifyReportInfo() {
        boolean z16 = this.mHasPuzzleVerify;
        if (z16 && this.mHasDevLockVerify) {
            return "1";
        }
        if (z16) {
            return "2";
        }
        if (this.mHasDevLockVerify) {
            return "3";
        }
        return "4";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyObserver(int i3, boolean z16, Bundle bundle) {
        AppRuntime appRuntime = getAppRuntime();
        int notifyType = getNotifyType(i3);
        appRuntime.notifyObserver(new d(false), notifyType, z16, bundle);
        appRuntime.notifyObservers(com.tencent.mobileqq.login.servlet.a.class, notifyType, z16, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportEvent(String str, int i3, String str2, String str3, String str4) {
        T t16 = this.mLoginParams;
        com.tencent.mobileqq.util.as.b("account_login_mainline", str, "", ((com.tencent.mobileqq.login.c) t16).f242201b, i3, false, str2, str3, str4, ((com.tencent.mobileqq.login.c) t16).f242042f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestLogin(com.tencent.mobileqq.login.c cVar, boolean z16) {
        byte[] bArr;
        Bundle bundle;
        GatewayVerify$ReqBody gatewayVerify$ReqBody;
        QLog.i(TAG, 1, "request login loginType=" + cVar.f242200a + " reLogin=" + z16 + " verifySig=" + this.mVerifySig);
        this.mIsReLogin = z16;
        Bundle bundle2 = new Bundle();
        if (cVar.f242046j) {
            bundle2.putBoolean("loginByMask", true);
        }
        byte[] bArr2 = cVar.f242048l;
        if (bArr2 != null) {
            bundle2.putByteArray(BaseConstants.ATTR_KET_SIF_SESSION, bArr2);
        }
        Integer num = cVar.f242049m;
        if (num != null) {
            bundle2.putInt("businessType", num.intValue());
        }
        GatewayVerify$ReqBody gatewayVerify$ReqBody2 = cVar.f242045i;
        if (gatewayVerify$ReqBody2 != null) {
            gatewayVerify$ReqBody2.msg_req_common_info.setHasFlag(true);
            cVar.f242045i.msg_req_common_info.bool_need_remind_in_cancel_status.set(com.tencent.mobileqq.login.remind.n.f242580a.c(((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f));
        }
        if (!TextUtils.isEmpty(this.mVerifySig) && (gatewayVerify$ReqBody = cVar.f242045i) != null) {
            gatewayVerify$ReqBody.msg_req_common_info.str_verify_sig.set(this.mVerifySig);
        }
        d dVar = new d(true);
        GatewayVerify$ReqBody gatewayVerify$ReqBody3 = cVar.f242045i;
        if (gatewayVerify$ReqBody3 != null) {
            bArr = gatewayVerify$ReqBody3.toByteArray();
        } else {
            bArr = null;
        }
        byte[] bArr3 = bArr;
        int i3 = cVar.f242200a;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (!TextUtils.isEmpty(this.mVerifySig) && (bundle = cVar.f242053q) != null && bundle.containsKey(AppConstants.Key.KEY_CONNECT_DATA)) {
                        try {
                            byte[] byteArray = cVar.f242053q.getByteArray(AppConstants.Key.KEY_CONNECT_DATA);
                            GatewayVerify$ReqBody gatewayVerify$ReqBody4 = new GatewayVerify$ReqBody();
                            gatewayVerify$ReqBody4.mergeFrom(byteArray);
                            gatewayVerify$ReqBody4.msg_req_common_info.str_verify_sig.set(this.mVerifySig);
                            cVar.f242053q.putByteArray(AppConstants.Key.KEY_CONNECT_DATA, gatewayVerify$ReqBody4.toByteArray());
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, "set str_verify_sig to connect_data error:", e16);
                        }
                    }
                    com.tencent.mobileqq.login.servlet.b.f(cVar.f242042f, cVar.f242043g, bArr3, cVar.f242052p, bundle2, cVar.f242053q, dVar);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.login.servlet.b.g(getAppRuntime().getCurrentAccountUin(), cVar.f242042f, cVar.f242043g, bArr3, bundle2, dVar);
            return;
        }
        byte[] bArr4 = cVar.f242051o;
        if (bArr4 != null) {
            bundle2.putByteArray(MsfConstants.ATTRIBUTE_RESP_REGISTER_SUPER_SIG, bArr4);
        }
        if (cVar.f242054r) {
            bundle2.putBoolean("forbiddenCreateRuntime", true);
        }
        com.tencent.mobileqq.login.servlet.b.e(cVar.f242042f, cVar.f242044h, bArr3, bundle2, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRemindDialog(byte[] bArr) {
        if (!new com.tencent.mobileqq.login.remind.m().h(getActivity(), bArr, ((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f, new a())) {
            onReLogin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDevLockVerify(int i3, DevlockInfo devlockInfo, String str, int i16, Bundle bundle) {
        String str2;
        String str3;
        QuestionnaireForLoginManager.g("new_device");
        this.mHasDevLockVerify = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mHasPuzzleVerify) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        String str4 = str2;
        reportEvent("0X800C4AE", 0, "", str4, "");
        T t16 = this.mLoginParams;
        if (((com.tencent.mobileqq.login.c) t16).f242201b == 16 && ((com.tencent.mobileqq.login.c) t16).f242204e) {
            str3 = com.tencent.mobileqq.accountbinding.d.f174609a.g();
        } else {
            str3 = null;
        }
        c cVar = new c(currentTimeMillis, str4, i3);
        new DevLockVerifyComponent().A(i3, devlockInfo, str, str3, i16, getNewPassThroughParams(bundle, false), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPuzzleVerify(int i3, PuzzleVerifyInfo puzzleVerifyInfo, Bundle bundle) {
        this.mHasPuzzleVerify = true;
        long currentTimeMillis = System.currentTimeMillis();
        reportEvent("0X800C4AD", 0, "", "", "");
        new PuzzleVerifyComponent().d(1, puzzleVerifyInfo.D, new b(currentTimeMillis, bundle, i3, puzzleVerifyInfo));
    }

    @Override // com.tencent.mobileqq.login.k
    protected String getReportUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return ((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "onLoginCancel");
        reportEvent("0X800C27C", 2, getLoginDuration(), getVerifyReportInfo(), "");
        QuestionnaireForLoginManager.e();
        super.onLoginCancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginFailed(aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) ajVar);
            return;
        }
        QLog.i(TAG, 1, "onLoginFailed ret=" + ajVar.f241864a + " msg=" + ajVar.f241866c);
        ai.j(getActivity(), (com.tencent.mobileqq.login.c) this.mLoginParams, ajVar);
        reportEvent("0X800C27C", 1, getLoginDuration(), getVerifyReportInfo(), String.valueOf(ajVar.f241864a));
        QuestionnaireForLoginManager.e();
        super.onLoginFailed(ajVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginSuccess(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) bundle);
            return;
        }
        if (!checkBeforeLoginSuccess(str, bundle)) {
            return;
        }
        QLog.i(TAG, 1, "onLoginSuccess uin=" + StringUtil.getSimpleUinForPrint(str));
        T t16 = this.mLoginParams;
        if (((com.tencent.mobileqq.login.c) t16).f242046j) {
            com.tencent.mobileqq.login.account.d.f241848a.b(str, str, ((com.tencent.mobileqq.login.c) t16).f242200a);
            if (!TextUtils.isEmpty(str)) {
                MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + str, str);
            }
        } else {
            com.tencent.mobileqq.login.account.d.f241848a.b(str, ((com.tencent.mobileqq.login.c) t16).f242042f, ((com.tencent.mobileqq.login.c) t16).f242200a);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f)) {
                MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + str, ((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f);
            }
        }
        ((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).reportLoginSuccess(getAppRuntime(), Integer.valueOf(((com.tencent.mobileqq.login.c) this.mLoginParams).f242201b), str);
        reportEvent("0X800C27C", 0, getLoginDuration(), getVerifyReportInfo(), "");
        super.onLoginSuccess(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onReLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onReLogin();
            requestLogin((com.tencent.mobileqq.login.c) this.mLoginParams, true);
        }
    }

    @Override // com.tencent.mobileqq.login.k
    protected void startLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "start account login loginType=" + ((com.tencent.mobileqq.login.c) this.mLoginParams).f242200a + " account=" + ((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f);
        this.mHasPuzzleVerify = false;
        this.mHasDevLockVerify = false;
        reportEvent("0X800C279", 0, "", "", "");
        QuestionnaireForLoginManager.i("account_pwd_login");
        this.mVerifySig = null;
        requestLogin((com.tencent.mobileqq.login.c) this.mLoginParams, false);
    }
}
