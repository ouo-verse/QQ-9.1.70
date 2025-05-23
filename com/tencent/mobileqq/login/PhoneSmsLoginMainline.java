package com.tencent.mobileqq.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.login.bn;
import com.tencent.mobileqq.login.bp;
import com.tencent.mobileqq.login.remind.h;
import com.tencent.mobileqq.login.verify.PuzzleVerifyComponent;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.loginregister.sms.PhoneLoginSmsVerifyResult;
import com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.QuestionnaireForLoginManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.bm;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.slf4j.Marker;
import tencent.im.login.GatewayVerify$ReqBody;

/* loaded from: classes15.dex */
public class PhoneSmsLoginMainline extends k<bl> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LoginMainline_PhoneSms";
    private static final String WATERPROOF_URL = "https://ti.qq.com/safe/tools/captcha/sms-verify-login";
    private AccountInfo mAccountInfo;
    private boolean mHasDevLockVerify;
    private boolean mHasPuzzleVerify;
    private boolean mHasShowMultiAccountDialog;
    private boolean mIsLoginByUinTokenNow;
    private WeakReference<Dialog> mMultiAccountDialogRef;

    /* loaded from: classes15.dex */
    public class a implements PuzzleVerifyComponent.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        final /* synthetic */ long f241811a;

        a(long j3) {
            this.f241811a = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PhoneSmsLoginMainline.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i(PhoneSmsLoginMainline.TAG, 1, "puzzle verify cancel");
            PhoneSmsLoginMainline.this.reportEvent("0X800C302", 2, String.valueOf(System.currentTimeMillis() - this.f241811a), "", "");
            PhoneSmsLoginMainline.this.onLoginCancel();
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void b(boolean z16, String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, str3);
                return;
            }
            QLog.i(PhoneSmsLoginMainline.TAG, 1, "puzzle verify result result=" + z16);
            PhoneSmsLoginMainline.this.reportEvent("0X800C302", 0, String.valueOf(System.currentTimeMillis() - this.f241811a), "", "");
            PhoneSmsLoginMainline.this.requestSmsVerifyCode(str, str2, str3);
        }
    }

    /* loaded from: classes15.dex */
    public class b extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        /* renamed from: d */
        final /* synthetic */ long f241813d;

        b(long j3) {
            this.f241813d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PhoneSmsLoginMainline.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void g(long j3, long j16, String str, String str2, String str3, int i3, int i16, int i17, ErrMsg errMsg) {
            String str4;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i18 = 1;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), errMsg);
                return;
            }
            if (errMsg != null) {
                str4 = errMsg.getMessage();
            } else {
                str4 = str3;
            }
            QLog.i(PhoneSmsLoginMainline.TAG, 1, "onCheckSMSVerifyLoginAccount ret=" + i17 + " msg=" + str4);
            PhoneSmsLoginMainline phoneSmsLoginMainline = PhoneSmsLoginMainline.this;
            if (i17 == 0) {
                i18 = 0;
            }
            phoneSmsLoginMainline.reportEvent("0X800C303", i18, String.valueOf(System.currentTimeMillis() - this.f241813d), "", String.valueOf(i17));
            if (i17 == 0) {
                PhoneSmsLoginMainline.this.hideLoading(false);
                PhoneSmsLoginMainline.this.startSmsVerify();
            } else {
                aj ajVar = new aj();
                ajVar.f241864a = i17;
                ajVar.f241866c = str4;
                PhoneSmsLoginMainline.this.onLoginFailed(ajVar);
            }
        }
    }

    /* loaded from: classes15.dex */
    public class c implements SmsVerifyComponent.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        final /* synthetic */ long f241815a;

        c(long j3) {
            this.f241815a = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PhoneSmsLoginMainline.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent.f
        public void a(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                return;
            }
            QLog.i(PhoneSmsLoginMainline.TAG, 1, "SmsVerify cancel");
            PhoneSmsLoginMainline.this.reportEvent("0X800C305", 2, String.valueOf(System.currentTimeMillis() - this.f241815a), "", "");
            PhoneSmsLoginMainline.this.onLoginCancel();
        }

        @Override // com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent.f
        public void b(Bundle bundle) {
            String str;
            List<AccountInfo> list;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            PhoneLoginSmsVerifyResult phoneLoginSmsVerifyResult = (PhoneLoginSmsVerifyResult) bundle.getParcelable("key_verify_result");
            QLog.i(PhoneSmsLoginMainline.TAG, 1, "SmsVerify success");
            PhoneSmsLoginMainline phoneSmsLoginMainline = PhoneSmsLoginMainline.this;
            String valueOf = String.valueOf(System.currentTimeMillis() - this.f241815a);
            if (PhoneSmsLoginMainline.this.mHasPuzzleVerify) {
                str = "1";
            } else {
                str = "2";
            }
            phoneSmsLoginMainline.reportEvent("0X800C305", 0, valueOf, str, "");
            WUserSigInfo wUserSigInfo = phoneLoginSmsVerifyResult.f242902e;
            if (wUserSigInfo != null) {
                list = com.tencent.mobileqq.util.bk.c(wUserSigInfo, 5);
            } else {
                list = null;
            }
            if (list != null && !list.isEmpty()) {
                if (list.size() != 1) {
                    PhoneSmsLoginMainline.this.startMultiAccountLogin(list, phoneLoginSmsVerifyResult.f242902e);
                    return;
                }
                QLog.i(PhoneSmsLoginMainline.TAG, 1, "single account");
                PhoneSmsLoginMainline phoneSmsLoginMainline2 = PhoneSmsLoginMainline.this;
                if (phoneSmsLoginMainline2.mHasPuzzleVerify) {
                    str2 = "1";
                } else {
                    str2 = "2";
                }
                phoneSmsLoginMainline2.reportEvent("0X800C4B9", 0, "1", "2", str2);
                PhoneSmsLoginMainline.this.mAccountInfo = list.get(0);
                PhoneSmsLoginMainline.this.loginByUinToken();
                return;
            }
            QLog.i(PhoneSmsLoginMainline.TAG, 1, "no accounts bind");
            PhoneSmsLoginMainline.this.onLoginFailed(new aj(219, 219, "\u624b\u673a\u53f7\u672a\u7ed1\u5b9aQQ", null, null, null, null));
        }
    }

    /* loaded from: classes15.dex */
    public class d implements bn.e {
        static IPatchRedirector $redirector_;

        /* loaded from: classes15.dex */
        class a implements h.b {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }

            @Override // com.tencent.mobileqq.login.remind.h.b
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    PhoneSmsLoginMainline.this.onLoginCancel();
                }
            }

            @Override // com.tencent.mobileqq.login.remind.h.b
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                } else {
                    PhoneSmsLoginMainline.this.onReLogin();
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

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneSmsLoginMainline.this);
            }
        }

        @Override // com.tencent.mobileqq.login.bn.e
        public void a(aj ajVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) ajVar);
            } else if (ajVar != null && !new com.tencent.mobileqq.login.remind.m().h(PhoneSmsLoginMainline.this.getActivity(), ajVar.f241869f, PhoneSmsLoginMainline.this.mAccountInfo.getMaskUin(), new a())) {
                PhoneSmsLoginMainline.this.onReLogin();
            }
        }

        @Override // com.tencent.mobileqq.login.bn.e
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                PhoneSmsLoginMainline.this.mIsLoginByUinTokenNow = false;
                if (PhoneSmsLoginMainline.this.isMultiAccountDialogShowing()) {
                    PhoneSmsLoginMainline.this.hideLoading(false);
                    return;
                } else {
                    PhoneSmsLoginMainline.this.onLoginCancel();
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
            QLog.i(PhoneSmsLoginMainline.TAG, 1, "loginByUinToken success");
            PhoneSmsLoginMainline.this.mIsLoginByUinTokenNow = false;
            PhoneSmsLoginMainline.this.onLoginSuccess(str, bundle);
        }

        @Override // com.tencent.mobileqq.login.bn.e
        public void d(aj ajVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                PhoneSmsLoginMainline.this.mIsLoginByUinTokenNow = false;
                if (PhoneSmsLoginMainline.this.isMultiAccountDialogShowing()) {
                    PhoneSmsLoginMainline.this.hideLoading(false);
                    ai.n(PhoneSmsLoginMainline.this.getActivity(), ((bl) PhoneSmsLoginMainline.this.mLoginParams).f242201b, ajVar);
                    return;
                } else {
                    PhoneSmsLoginMainline.this.onLoginFailed(ajVar);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) ajVar);
        }
    }

    /* loaded from: classes15.dex */
    public class e implements bn.f {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneSmsLoginMainline.this);
            }
        }

        private String e() {
            if (PhoneSmsLoginMainline.this.mHasPuzzleVerify && PhoneSmsLoginMainline.this.mHasShowMultiAccountDialog) {
                return "1";
            }
            if (PhoneSmsLoginMainline.this.mHasPuzzleVerify) {
                return "2";
            }
            if (PhoneSmsLoginMainline.this.mHasShowMultiAccountDialog) {
                return "3";
            }
            return "4";
        }

        @Override // com.tencent.mobileqq.login.bn.f
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QuestionnaireForLoginManager.g("new_device");
            PhoneSmsLoginMainline.this.mHasDevLockVerify = true;
            PhoneSmsLoginMainline.this.reportEvent("0X800C378", 0, "", e(), "");
        }

        @Override // com.tencent.mobileqq.login.bn.f
        public void b(int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                PhoneSmsLoginMainline.this.reportEvent("0X800C307", i3, String.valueOf(j3), "", "");
            } else {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.login.bn.f
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                PhoneSmsLoginMainline.this.reportEvent("0X800C306", 0, "", "", "");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.login.bn.f
        public void d(int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                PhoneSmsLoginMainline.this.reportEvent("0X800C379", i3, String.valueOf(j3), e(), "");
            } else {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3));
            }
        }
    }

    public PhoneSmsLoginMainline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHasPuzzleVerify = false;
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
        if (this.mHasPuzzleVerify) {
            if (this.mHasShowMultiAccountDialog) {
                if (this.mHasDevLockVerify) {
                    return "1";
                }
                return "2";
            }
            if (this.mHasDevLockVerify) {
                return "3";
            }
            return "4";
        }
        if (this.mHasShowMultiAccountDialog) {
            if (this.mHasDevLockVerify) {
                return "5";
            }
            return "6";
        }
        if (this.mHasDevLockVerify) {
            return "7";
        }
        return "8";
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

    public /* synthetic */ void lambda$onLoginFailed$4(aj ajVar) {
        dismissMultiAccountDialog();
        ai.n(getActivity(), ((bl) this.mLoginParams).f242201b, ajVar);
    }

    public /* synthetic */ void lambda$showMultiAccountDialog$2(int i3, Object obj) {
        String str;
        if (obj instanceof AccountInfo) {
            this.mAccountInfo = (AccountInfo) obj;
            QLog.i(TAG, 1, "select account " + this.mAccountInfo.getMaskUin());
            String valueOf = String.valueOf(i3);
            if (this.mHasPuzzleVerify) {
                str = "1";
            } else {
                str = "2";
            }
            reportEvent("0X800C4B9", 0, valueOf, "1", str);
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
        long j3;
        String str;
        String str2 = Marker.ANY_NON_NULL_MARKER + ((bl) this.mLoginParams).f241977f + " " + ((bl) this.mLoginParams).f241978g;
        final int size = list.size();
        AccountInfo d16 = com.tencent.mobileqq.loginregister.z.d(list, str2, ((bl) this.mLoginParams).f241979h);
        if (d16 != null) {
            QLog.i(TAG, 1, "auto select reLogin uin " + StringUtil.getSimpleUinForPrint(((bl) this.mLoginParams).f241979h));
            String valueOf = String.valueOf(size);
            if (this.mHasPuzzleVerify) {
                str = "1";
            } else {
                str = "2";
            }
            reportEvent("0X800C4B9", 0, valueOf, "2", str);
            this.mAccountInfo = d16;
            loginByUinToken();
            return;
        }
        if (isLoginActivityInvalid()) {
            j3 = 1000;
        } else {
            j3 = 0;
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.bk
            @Override // java.lang.Runnable
            public final void run() {
                PhoneSmsLoginMainline.this.lambda$startMultiAccountLogin$0(wUserSigInfo, size);
            }
        }, j3);
    }

    public void loginByUinToken() {
        if (this.mAccountInfo == null) {
            return;
        }
        QLog.i(TAG, 1, "loginByUinToken uin=" + this.mAccountInfo.getMaskUin());
        showLoading();
        new bn(new bp.a(5, ((bl) this.mLoginParams).f242201b, this.mAccountInfo).g(((bl) this.mLoginParams).f241978g).b(((bl) this.mLoginParams).f241977f).d(((bl) this.mLoginParams).f242202c).c(((bl) this.mLoginParams).f242203d).f(((bl) this.mLoginParams).f241980i).e(((bl) this.mLoginParams).f242204e).a(), new d(), new e()).i();
        this.mIsLoginByUinTokenNow = true;
    }

    public void reportEvent(String str, int i3, String str2, String str3, String str4) {
        T t16 = this.mLoginParams;
        com.tencent.mobileqq.util.as.b("phone_sms_login_mainline", str, ((bl) t16).f241978g, ((bl) t16).f242201b, i3, false, str2, str3, str4, ((bl) t16).f241977f);
    }

    public void requestSmsVerifyCode(String str, String str2, String str3) {
        QLog.i(TAG, 1, "request sms verify code");
        long currentTimeMillis = System.currentTimeMillis();
        showLoading();
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        gatewayVerify$ReqBody.msg_req_bind_phone_login.msg_pic_verify_info.bytes_verify_sig.set(ByteStringMicro.copyFromUtf8(str));
        gatewayVerify$ReqBody.msg_req_bind_phone_login.msg_pic_verify_info.bytes_rand_key.set(ByteStringMicro.copyFromUtf8(str2));
        PBUInt64Field pBUInt64Field = gatewayVerify$ReqBody.msg_req_bind_phone_login.msg_pic_verify_info.uint64_appid;
        if (TextUtils.isEmpty(str3)) {
            str3 = "0";
        }
        pBUInt64Field.set(Long.parseLong(str3));
        gatewayVerify$ReqBody.msg_req_bind_phone_login.msg_pic_verify_info.setHasFlag(true);
        gatewayVerify$ReqBody.msg_req_bind_phone_login.setHasFlag(true);
        gatewayVerify$ReqBody.msg_req_cmd_17.str_mobile_phone.set(((bl) this.mLoginParams).f241978g);
        gatewayVerify$ReqBody.msg_req_cmd_17.uint32_country_code.set(Integer.parseInt(((bl) this.mLoginParams).f241977f));
        gatewayVerify$ReqBody.msg_req_cmd_17.bool_support_abolish_switch_of_phone_login.set(true);
        gatewayVerify$ReqBody.msg_req_cmd_17.setHasFlag(true);
        gatewayVerify$ReqBody.msg_req_common_info.bool_need_remind_in_cancel_status.set(false);
        gatewayVerify$ReqBody.msg_req_common_info.setHasFlag(true);
        gatewayVerify$ReqBody.setHasFlag(true);
        ILoginServletService iLoginServletService = (ILoginServletService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILoginServletService.class, "all");
        T t16 = this.mLoginParams;
        iLoginServletService.checkSMSVerifyLoginAccount(((bl) t16).f241978g, ((bl) t16).f241977f, AppSetting.f(), ((bl) this.mLoginParams).f242203d, gatewayVerify$ReqBody.toByteArray(), new b(currentTimeMillis));
    }

    /* renamed from: showMultiAccountDialog */
    public void lambda$startMultiAccountLogin$0(WUserSigInfo wUserSigInfo, final int i3) {
        String str;
        QLog.i(TAG, 1, "showMultiAccountDialog");
        QBaseActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            this.mHasShowMultiAccountDialog = true;
            String valueOf = String.valueOf(i3);
            if (this.mHasPuzzleVerify) {
                str = "1";
            } else {
                str = "2";
            }
            reportEvent("0X800C4B8", 0, valueOf, str, "");
            LoginReportConstants.f241792b = 1;
            LoginReportConstants.f241793c = String.valueOf(((bl) this.mLoginParams).f242201b);
            com.tencent.mobileqq.widget.bm a16 = com.tencent.mobileqq.util.bk.a(activity, wUserSigInfo, 5, new bm.c() { // from class: com.tencent.mobileqq.login.bi
                @Override // com.tencent.mobileqq.widget.bm.c
                public final void a(Object obj) {
                    PhoneSmsLoginMainline.this.lambda$showMultiAccountDialog$2(i3, obj);
                }
            }, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.login.bj
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PhoneSmsLoginMainline.this.lambda$showMultiAccountDialog$3(dialogInterface);
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

    public void startMultiAccountLogin(final List<AccountInfo> list, final WUserSigInfo wUserSigInfo) {
        QLog.i(TAG, 1, "start multi accounts login");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.bf
            @Override // java.lang.Runnable
            public final void run() {
                PhoneSmsLoginMainline.this.lambda$startMultiAccountLogin$1(list, wUserSigInfo);
            }
        }, 16, null, true);
    }

    private void startPuzzleVerify() {
        QLog.i(TAG, 1, "start puzzle verify");
        long currentTimeMillis = System.currentTimeMillis();
        reportEvent("0X800C301", 0, "", "", "");
        this.mHasPuzzleVerify = true;
        new PuzzleVerifyComponent().d(2, WATERPROOF_URL, new a(currentTimeMillis));
    }

    public void startSmsVerify() {
        QLog.i(TAG, 1, "startSmsVerify");
        long currentTimeMillis = System.currentTimeMillis();
        reportEvent("0X800C304", 0, "", "", "");
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.Key.PHONENUM, ((bl) this.mLoginParams).f241978g);
        bundle.putString("key", ((bl) this.mLoginParams).f241977f);
        bundle.putInt("phoneNumLoginEntrance", ((bl) this.mLoginParams).f242201b);
        bundle.putString("appid", ((bl) this.mLoginParams).f241980i);
        T t16 = this.mLoginParams;
        SmsVerifyComponent.e(2, ((bl) t16).f241978g, ((bl) t16).f241977f, bundle, new c(currentTimeMillis));
    }

    @Override // com.tencent.mobileqq.login.k
    protected String getReportUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return ((bl) this.mLoginParams).f241978g;
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
        reportEvent("0X800C308", 2, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getSecureReportInfo());
        runOnUiThread(new bg(this));
        QuestionnaireForLoginManager.d(8);
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
        QLog.i(TAG, 1, "onLoginFailed ret=" + ajVar.f241864a + " errMsg=" + ajVar.f241866c);
        reportEvent("0X800C308", 1, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), String.valueOf(ajVar.f241864a), getSecureReportInfo());
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.bh
            @Override // java.lang.Runnable
            public final void run() {
                PhoneSmsLoginMainline.this.lambda$onLoginFailed$4(ajVar);
            }
        });
        QuestionnaireForLoginManager.d(8);
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
        com.tencent.mobileqq.login.account.d.f241848a.b(str, Marker.ANY_NON_NULL_MARKER + ((bl) this.mLoginParams).f241977f + " " + ((bl) this.mLoginParams).f241978g, 5);
        if (!TextUtils.isEmpty(str)) {
            MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + str, str);
        }
        reportEvent("0X800C308", 0, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getSecureReportInfo());
        runOnUiThread(new bg(this));
        super.onLoginSuccess(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onReLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onReLogin();
            loginByUinToken();
        }
    }

    @Override // com.tencent.mobileqq.login.k
    protected void startLogin() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "start phone sms login loginScene=" + ((bl) this.mLoginParams).f242201b + ", countryCode=" + ((bl) this.mLoginParams).f241977f + ", phoneNum=" + ((bl) this.mLoginParams).f241978g);
        QuestionnaireForLoginManager.i("phone_num_verify_code_login");
        QuestionnaireForLoginManager.h(8);
        this.mHasPuzzleVerify = false;
        this.mHasShowMultiAccountDialog = false;
        this.mHasDevLockVerify = false;
        this.mIsLoginByUinTokenNow = false;
        T t16 = this.mLoginParams;
        boolean a16 = SmsVerifyComponent.a(2, ((bl) t16).f241977f, ((bl) t16).f241978g);
        if (a16) {
            str = "0";
        } else {
            str = "1";
        }
        reportEvent("0X800C300", 0, str, "", "");
        if (a16) {
            startSmsVerify();
        } else {
            startPuzzleVerify();
        }
    }
}
