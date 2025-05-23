package com.tencent.mobileqq.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.login.bn;
import com.tencent.mobileqq.login.bp;
import com.tencent.mobileqq.login.remind.h;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.QuestionnaireForLoginManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.bm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import tencent.im.login.GatewayVerify$ReqBody;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;

/* loaded from: classes15.dex */
public class PhoneQuickLoginMainline extends k<be> {
    static IPatchRedirector $redirector_ = null;
    public static final int LOGIN_ERROR_GET_PHONE_TOKEN = -2001;
    public static final int LOGIN_SUCCESS = 0;
    private static final String TAG = "LoginMainline_PhoneQuick";
    private AccountInfo mAccountInfo;
    private boolean mHasDevLockVerify;
    private boolean mHasShowMultiAccountDialog;
    private boolean mIsLoginByUinTokenNow;
    private WeakReference<Dialog> mMultiAccountDialogRef;
    private String mPhoneToken;

    /* loaded from: classes15.dex */
    public class a implements ne1.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        final /* synthetic */ AtomicBoolean f241804a;

        /* renamed from: b */
        final /* synthetic */ long f241805b;

        a(AtomicBoolean atomicBoolean, long j3) {
            this.f241804a = atomicBoolean;
            this.f241805b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PhoneQuickLoginMainline.this, atomicBoolean, Long.valueOf(j3));
            }
        }

        @Override // ne1.a
        public void a(@NonNull GetLocalPhone$OIDBGetPhoneRsp getLocalPhone$OIDBGetPhoneRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) getLocalPhone$OIDBGetPhoneRsp);
                return;
            }
            QLog.i(PhoneQuickLoginMainline.TAG, 1, "get phone token success waiting=" + this.f241804a.get());
            if (this.f241804a.getAndSet(false)) {
                PhoneQuickLoginMainline.this.reportEvent("0X800C30B", 0, String.valueOf(System.currentTimeMillis() - this.f241805b), "", "", "");
                PhoneQuickLoginMainline.this.mPhoneToken = getLocalPhone$OIDBGetPhoneRsp.msg_encrypt_phone_data.get().str_encypt_phone.get();
                PhoneQuickLoginMainline phoneQuickLoginMainline = PhoneQuickLoginMainline.this;
                phoneQuickLoginMainline.loginByPhoneToken(phoneQuickLoginMainline.mPhoneToken);
            }
        }

        @Override // ne1.a
        public void onFail(int i3, @Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            } else if (this.f241804a.getAndSet(false)) {
                PhoneQuickLoginMainline.this.reportEvent("0X800C30B", 1, String.valueOf(System.currentTimeMillis() - this.f241805b), String.valueOf(i3), "", "");
                com.tencent.mobileqq.util.aj.f306554f.h();
                PhoneQuickLoginMainline.this.onLoginFailed(-2001, BaseApplication.getContext().getString(R.string.f1376507f));
            }
        }
    }

    /* loaded from: classes15.dex */
    public class b extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneQuickLoginMainline.this);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void s(int i3, ErrMsg errMsg, WUserSigInfo wUserSigInfo) {
            List<AccountInfo> list;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, wUserSigInfo);
                return;
            }
            QLog.i(PhoneQuickLoginMainline.TAG, 1, "onLoginByGateway ret=" + i3);
            if (i3 != 0) {
                if (errMsg != null) {
                    str = errMsg.getMessage();
                } else {
                    str = "";
                }
                PhoneQuickLoginMainline.this.onLoginFailed(i3, str);
                return;
            }
            if (wUserSigInfo != null) {
                list = com.tencent.mobileqq.util.bk.c(wUserSigInfo, 4);
            } else {
                list = null;
            }
            if (list != null && !list.isEmpty()) {
                if (list.size() != 1) {
                    PhoneQuickLoginMainline.this.startMultiAccountLogin(list, wUserSigInfo);
                    return;
                }
                QLog.i(PhoneQuickLoginMainline.TAG, 1, "single account");
                PhoneQuickLoginMainline.this.reportEvent("0X800C4B5", 0, "1", "2", "", "");
                PhoneQuickLoginMainline.this.mAccountInfo = list.get(0);
                PhoneQuickLoginMainline.this.loginByUinToken();
                return;
            }
            QLog.i(PhoneQuickLoginMainline.TAG, 1, "no accounts bind");
            PhoneQuickLoginMainline.this.onLoginFailed(219, "\u624b\u673a\u53f7\u672a\u7ed1\u5b9aQQ");
        }
    }

    /* loaded from: classes15.dex */
    public class c implements bn.e {
        static IPatchRedirector $redirector_;

        /* loaded from: classes15.dex */
        class a implements h.b {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // com.tencent.mobileqq.login.remind.h.b
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    PhoneQuickLoginMainline.this.onLoginCancel();
                }
            }

            @Override // com.tencent.mobileqq.login.remind.h.b
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                } else {
                    PhoneQuickLoginMainline.this.onReLogin();
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

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneQuickLoginMainline.this);
            }
        }

        @Override // com.tencent.mobileqq.login.bn.e
        public void a(aj ajVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) ajVar);
            } else if (ajVar != null && !new com.tencent.mobileqq.login.remind.m().h(PhoneQuickLoginMainline.this.getActivity(), ajVar.f241869f, PhoneQuickLoginMainline.this.mAccountInfo.getMaskUin(), new a())) {
                PhoneQuickLoginMainline.this.onReLogin();
            }
        }

        @Override // com.tencent.mobileqq.login.bn.e
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                PhoneQuickLoginMainline.this.mIsLoginByUinTokenNow = false;
                if (PhoneQuickLoginMainline.this.isMultiAccountDialogShowing()) {
                    PhoneQuickLoginMainline.this.hideLoading(false);
                    return;
                } else {
                    PhoneQuickLoginMainline.this.onLoginCancel();
                    return;
                }
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // com.tencent.mobileqq.login.bn.e
        public void c(String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle);
                return;
            }
            QLog.i(PhoneQuickLoginMainline.TAG, 1, "loginByUinToken success");
            PhoneQuickLoginMainline.this.mIsLoginByUinTokenNow = false;
            PhoneQuickLoginMainline.this.onLoginSuccess(str, bundle);
        }

        @Override // com.tencent.mobileqq.login.bn.e
        public void d(aj ajVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                PhoneQuickLoginMainline.this.mIsLoginByUinTokenNow = false;
                if (PhoneQuickLoginMainline.this.isMultiAccountDialogShowing()) {
                    PhoneQuickLoginMainline.this.hideLoading(false);
                    ai.l(PhoneQuickLoginMainline.this.getActivity(), ((be) PhoneQuickLoginMainline.this.mLoginParams).f242201b, ajVar, true);
                    return;
                } else {
                    PhoneQuickLoginMainline.this.onLoginFailed(ajVar);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) ajVar);
        }
    }

    /* loaded from: classes15.dex */
    public class d implements bn.f {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneQuickLoginMainline.this);
            }
        }

        @Override // com.tencent.mobileqq.login.bn.f
        public void a() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QuestionnaireForLoginManager.g("new_device");
            PhoneQuickLoginMainline.this.mHasDevLockVerify = true;
            PhoneQuickLoginMainline phoneQuickLoginMainline = PhoneQuickLoginMainline.this;
            if (phoneQuickLoginMainline.mHasShowMultiAccountDialog) {
                str = "1";
            } else {
                str = "2";
            }
            phoneQuickLoginMainline.reportEvent("0X800C30C", 0, "", str, "", "");
        }

        @Override // com.tencent.mobileqq.login.bn.f
        public void b(int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                PhoneQuickLoginMainline.this.reportEvent("0X800C30F", i3, String.valueOf(j3), "", "", "");
            } else {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.login.bn.f
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                PhoneQuickLoginMainline.this.reportEvent("0X800C30E", 0, "", "", "", "");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.login.bn.f
        public void d(int i3, long j3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            PhoneQuickLoginMainline phoneQuickLoginMainline = PhoneQuickLoginMainline.this;
            String valueOf = String.valueOf(j3);
            if (PhoneQuickLoginMainline.this.mHasShowMultiAccountDialog) {
                str = "1";
            } else {
                str = "2";
            }
            phoneQuickLoginMainline.reportEvent("0X800C30D", i3, valueOf, str, "", "");
        }
    }

    public PhoneQuickLoginMainline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHasShowMultiAccountDialog = false;
        this.mHasDevLockVerify = false;
        this.mIsLoginByUinTokenNow = false;
    }

    public void dismissMultiAccountDialog() {
        Dialog dialog;
        WeakReference<Dialog> weakReference = this.mMultiAccountDialogRef;
        if (weakReference != null) {
            dialog = weakReference.get();
        } else {
            dialog = null;
        }
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Exception e16) {
                QLog.w(TAG, 1, "dismissMultiAccountDialog", e16);
            }
        }
        this.mMultiAccountDialogRef = null;
    }

    private String getSecureReportInfo() {
        if (this.mHasShowMultiAccountDialog) {
            if (this.mHasDevLockVerify) {
                return "4";
            }
            return "1";
        }
        if (this.mHasDevLockVerify) {
            return "2";
        }
        return "3";
    }

    public boolean isMultiAccountDialogShowing() {
        Dialog dialog;
        WeakReference<Dialog> weakReference = this.mMultiAccountDialogRef;
        if (weakReference != null) {
            dialog = weakReference.get();
        } else {
            dialog = null;
        }
        if (dialog != null && dialog.isShowing()) {
            return true;
        }
        return false;
    }

    public /* synthetic */ void lambda$showMultiAccountDialog$2(int i3, Object obj) {
        if (obj instanceof AccountInfo) {
            this.mAccountInfo = (AccountInfo) obj;
            QLog.i(TAG, 1, "select account " + this.mAccountInfo.getMaskUin());
            showLoading();
            reportEvent("0X800C4B5", 0, String.valueOf(i3), "1", "", "");
            loginByUinToken();
        }
    }

    public /* synthetic */ void lambda$showMultiAccountDialog$3(DialogInterface dialogInterface) {
        if (this.mIsLoggingIn.get()) {
            QLog.i(TAG, 1, "multi account dialog cancel");
            onLoginCancel();
        }
    }

    public /* synthetic */ void lambda$startMultiAccountLogin$1(List list, final WUserSigInfo wUserSigInfo) {
        final int i3;
        long j3;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        AccountInfo d16 = com.tencent.mobileqq.loginregister.z.d(list, "+86 " + ((be) this.mLoginParams).f241956f, ((be) this.mLoginParams).f241957g);
        if (d16 != null) {
            QLog.i(TAG, 1, "auto select reLogin uin " + StringUtil.getSimpleUinForPrint(((be) this.mLoginParams).f241957g));
            reportEvent("0X800C4B5", 0, String.valueOf(i3), "2", "", "");
            this.mAccountInfo = d16;
            loginByUinToken();
            return;
        }
        if (isLoginActivityInvalid()) {
            j3 = 1000;
        } else {
            j3 = 0;
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.az
            @Override // java.lang.Runnable
            public final void run() {
                PhoneQuickLoginMainline.this.lambda$startMultiAccountLogin$0(wUserSigInfo, i3);
            }
        }, j3);
    }

    public void loginByPhoneToken(String str) {
        QLog.i(TAG, 1, "start login by phone token");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "phoneToken=" + str);
        }
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        gatewayVerify$ReqBody.msg_req_self_phone.msg_req_phone_login.bytes_phone_token.set(ByteStringMicro.copyFromUtf8(str));
        gatewayVerify$ReqBody.msg_req_self_phone.msg_req_phone_login.bool_support_auxinfo_check.set(true);
        gatewayVerify$ReqBody.msg_req_self_phone.msg_req_phone_login.setHasFlag(true);
        gatewayVerify$ReqBody.msg_req_self_phone.setHasFlag(true);
        gatewayVerify$ReqBody.msg_req_self_phone.msg_req_phone_login.bool_support_unbind_phone.set(true);
        gatewayVerify$ReqBody.msg_req_cmd_23.bool_support_abolish_switch_of_phone_login.set(true);
        gatewayVerify$ReqBody.msg_req_cmd_23.setHasFlag(true);
        gatewayVerify$ReqBody.msg_req_common_info.bool_need_remind_in_cancel_status.set(false);
        gatewayVerify$ReqBody.msg_req_common_info.setHasFlag(true);
        gatewayVerify$ReqBody.setHasFlag(true);
        ((ILoginServletService) getAppRuntime().getRuntimeService(ILoginServletService.class, "all")).quickLoginByGateway(gatewayVerify$ReqBody.toByteArray(), ((be) this.mLoginParams).f242202c, new b());
    }

    public void loginByUinToken() {
        if (this.mAccountInfo == null) {
            return;
        }
        QLog.i(TAG, 1, "loginByUinToken uin=" + this.mAccountInfo.getMaskUin());
        new bn(new bp.a(4, ((be) this.mLoginParams).f242201b, this.mAccountInfo).d(((be) this.mLoginParams).f242202c).c(((be) this.mLoginParams).f242203d).e(((be) this.mLoginParams).f242204e).a(), new c(), new d()).i();
        this.mIsLoginByUinTokenNow = true;
    }

    public void onLoginFailed(int i3, String str) {
        onLoginFailed(new aj(i3, i3, str, null, null, null, null));
    }

    public void reportEvent(String str, int i3, String str2, String str3, String str4, String str5) {
        com.tencent.mobileqq.util.as.b("phone_quick_login_mainline", str, "", ((be) this.mLoginParams).f242201b, i3, false, str2, str3, str4, str5);
    }

    /* renamed from: showMultiAccountDialog */
    public void lambda$startMultiAccountLogin$0(WUserSigInfo wUserSigInfo, final int i3) {
        QLog.i(TAG, 1, "showMultiAccountDialog");
        QBaseActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            hideLoading(false);
            this.mHasShowMultiAccountDialog = true;
            reportEvent("0X800C4B4", 0, String.valueOf(i3), "", "", "");
            LoginReportConstants.f241792b = 2;
            LoginReportConstants.f241793c = String.valueOf(((be) this.mLoginParams).f242201b);
            com.tencent.mobileqq.widget.bm a16 = com.tencent.mobileqq.util.bk.a(activity, wUserSigInfo, 4, new bm.c() { // from class: com.tencent.mobileqq.login.bc
                @Override // com.tencent.mobileqq.widget.bm.c
                public final void a(Object obj) {
                    PhoneQuickLoginMainline.this.lambda$showMultiAccountDialog$2(i3, obj);
                }
            }, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.login.bd
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PhoneQuickLoginMainline.this.lambda$showMultiAccountDialog$3(dialogInterface);
                }
            });
            this.mMultiAccountDialogRef = new WeakReference<>(a16);
            if (a16 != null) {
                a16.show();
                return;
            }
            return;
        }
        QLog.w(TAG, 1, "activity is null or finishing, cancel show multi account dialog");
        onLoginCancel();
    }

    private void startGetPhoneToken() {
        QLog.i(TAG, 1, "startGetPhoneToken");
        long currentTimeMillis = System.currentTimeMillis();
        reportEvent("0X800C30A", 0, "", "", "", "");
        com.tencent.mobileqq.gateway.localphone.ecdh.g.m(3, 14, new a(new AtomicBoolean(true), currentTimeMillis), null);
    }

    public void startMultiAccountLogin(final List<AccountInfo> list, final WUserSigInfo wUserSigInfo) {
        QLog.i(TAG, 1, "start multi accounts login");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.bb
            @Override // java.lang.Runnable
            public final void run() {
                PhoneQuickLoginMainline.this.lambda$startMultiAccountLogin$1(list, wUserSigInfo);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onActivityDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onActivityDestroy();
        if (isMultiAccountDialogShowing() && !this.mIsLoginByUinTokenNow) {
            onLoginCancel();
        }
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
        reportEvent("0X800C310", 2, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getSecureReportInfo(), "");
        runOnUiThread(new ba(this));
        QuestionnaireForLoginManager.d(8);
        QuestionnaireForLoginManager.e();
        super.onLoginCancel();
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
        com.tencent.mobileqq.login.account.d.f241848a.b(str, "+86 " + ((be) this.mLoginParams).f241956f, 4);
        if (!TextUtils.isEmpty(str)) {
            MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + str, str);
        }
        reportEvent("0X800C310", 0, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getSecureReportInfo(), "");
        runOnUiThread(new ba(this));
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
            loginByUinToken();
        }
    }

    @Override // com.tencent.mobileqq.login.k
    protected void startLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "start quick login loginScene=" + ((be) this.mLoginParams).f242201b);
        QuestionnaireForLoginManager.i("gateway_login");
        QuestionnaireForLoginManager.h(8);
        this.mHasShowMultiAccountDialog = false;
        this.mHasDevLockVerify = false;
        this.mIsLoginByUinTokenNow = false;
        reportEvent("0X800C309", 0, "", "", "", "");
        startGetPhoneToken();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginFailed(aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) ajVar);
            return;
        }
        QLog.i(TAG, 1, "onLoginFailed ret=" + ajVar.f241864a + " errMsg=" + ajVar.f241866c);
        reportEvent("0X800C310", 1, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), String.valueOf(ajVar.f241864a), getSecureReportInfo(), "");
        runOnUiThread(new ba(this));
        QuestionnaireForLoginManager.d(8);
        QuestionnaireForLoginManager.e();
        super.onLoginFailed(ajVar);
    }
}
