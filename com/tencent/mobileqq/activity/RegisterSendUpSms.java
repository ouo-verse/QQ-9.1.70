package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.loginregister.servlet.IRegisterServletService;
import com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService;
import com.tencent.mobileqq.loginregister.sms.RegisterVerifyResult;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.CheckLimitHandleResultReq;
import com.tencent.qqnt.kernel.nativeinterface.IRegisterIdentityCallback;
import com.tencent.qqnt.kernel.nativeinterface.RegisterIdentityLimit;
import com.tencent.qqnt.kernel.nativeinterface.RegisterIdentityRsp;
import java.util.Locale;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RegisterSendUpSms extends RegisterNewBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private String f176950a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f176951b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f176952c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f176953d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f176954e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f176955f0;

    /* renamed from: g0, reason: collision with root package name */
    private byte[] f176956g0;

    /* renamed from: h0, reason: collision with root package name */
    private Button f176957h0;

    /* renamed from: i0, reason: collision with root package name */
    private Button f176958i0;

    /* renamed from: j0, reason: collision with root package name */
    private Dialog f176959j0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f176960k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f176961l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f176962m0;

    /* renamed from: n0, reason: collision with root package name */
    private MqqHandler f176963n0;

    /* renamed from: o0, reason: collision with root package name */
    private com.tencent.mobileqq.loginregister.servlet.d f176964o0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends MqqHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RegisterSendUpSms.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 107) {
                RegisterSendUpSms.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends com.tencent.mobileqq.loginregister.servlet.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RegisterSendUpSms.this);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.d
        public void g(boolean z16, int i3, byte[] bArr, int i16, int i17, String str, String str2, String str3, String str4, String str5) {
            String str6 = str4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), bArr, Integer.valueOf(i16), Integer.valueOf(i17), str, str2, str3, str6, str5);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("RegisterSendUpSms", 2, "onRegisterQuerySmsStatResp isSuccess=" + z16 + ", code=" + i3 + ", uin=" + str + ", nick=" + str2 + ", faceUrl=" + str3 + ", errmsg=" + str6);
            }
            RegisterSendUpSms.this.S2();
            if (i3 == 4) {
                QLog.d("RegisterSendUpSms", 1, "not receive sms");
                RegisterSendUpSms.this.f176961l0 = 4;
                if (!TextUtils.isEmpty(str4)) {
                    RegisterSendUpSms.this.f176960k0.setText(str6);
                    RegisterSendUpSms.this.f176960k0.setTextColor(ResourcesCompat.getColor(RegisterSendUpSms.this.getResources(), R.color.qui_common_feedback_error, null));
                }
                RegisterSendUpSms registerSendUpSms = RegisterSendUpSms.this;
                registerSendUpSms.e3(i3, registerSendUpSms.getString(R.string.g0s), 1);
                return;
            }
            if (i3 == 0) {
                RegisterSendUpSms.this.f176954e0 = str5;
                RegisterSendUpSms.this.f176961l0 = 3;
                RegisterSendUpSms registerSendUpSms2 = RegisterSendUpSms.this;
                registerSendUpSms2.e3(i3, registerSendUpSms2.getString(R.string.szk), 2);
                if (!RegisterSendUpSms.this.Q2()) {
                    QLog.e("RegisterSendUpSms", 2, "onRegisterQuerySmsStatResp handleCallback: false");
                }
                com.tencent.mobileqq.util.cb.d("0X800B4BB");
                RegisterSendUpSms registerSendUpSms3 = RegisterSendUpSms.this;
                com.tencent.mobileqq.loginregister.sms.f.e(registerSendUpSms3.phoneNum, registerSendUpSms3.f176962m0);
                ReportController.r(null, "dc00898", "", "", "0X800B8DC", "0X800B8DC", 0, 0, "", "", com.tencent.mobileqq.loginregister.ao.INSTANCE.b(), "");
                return;
            }
            RegisterSendUpSms.this.f176961l0 = 4;
            if (i3 == -1 && bArr != null) {
                try {
                    str6 = new String(bArr, "utf-8");
                } catch (Throwable th5) {
                    QLog.e("RegisterSendUpSms", 1, "strPromptInfo to string error : ", th5.getMessage());
                }
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = RegisterSendUpSms.this.getString(R.string.g0s);
            }
            RegisterSendUpSms.this.e3(i3, str6.trim(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c implements e {
        static IPatchRedirector $redirector_;

        protected c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.RegisterSendUpSms.e
        public boolean a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
            }
            if (i3 % 4 == 3) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d implements e {
        static IPatchRedirector $redirector_;

        protected d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.RegisterSendUpSms.e
        public boolean a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
            }
            if (i3 % 4 == 2) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
        boolean a(int i3);
    }

    public RegisterSendUpSms() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176954e0 = null;
        this.f176955f0 = 0;
        this.f176956g0 = null;
        this.f176961l0 = 0;
        this.f176962m0 = 1;
        this.f176963n0 = new a();
        this.f176964o0 = new b();
    }

    private CharSequence P2(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("RegisterSendUpSms", 1, "src is empty");
            return null;
        }
        if (str2 == null) {
            QLog.d("RegisterSendUpSms", 1, "value is null");
            return str;
        }
        int indexOf = str.indexOf("%s");
        if (indexOf == -1) {
            QLog.d("RegisterSendUpSms", 1, "getColorSpan, no %s tag");
            return str;
        }
        SpannableString spannableString = new SpannableString(String.format(str, str2));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.qui_common_text_primary)), indexOf, str2.length() + indexOf, 17);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q2() {
        ISmsVerifyCodeService iSmsVerifyCodeService = (ISmsVerifyCodeService) getAppRuntime().getRuntimeService(ISmsVerifyCodeService.class, "all");
        RegisterVerifyResult registerVerifyResult = new RegisterVerifyResult(true);
        registerVerifyResult.f242905h = true;
        registerVerifyResult.f242903e = this.f176950a0;
        registerVerifyResult.f242904f = this.f176954e0;
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            registerVerifyResult.f242907m = this.f176956g0;
            registerVerifyResult.f242906i = this.f176955f0;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_verify_result", registerVerifyResult);
        boolean handleRegisterSendUpSmsSuccess = iSmsVerifyCodeService.handleRegisterSendUpSmsSuccess(this, bundle);
        if (handleRegisterSendUpSmsSuccess) {
            finish();
        }
        return handleRegisterSendUpSmsSuccess;
    }

    private void R2() {
        ((ISmsVerifyCodeService) getAppRuntime().getRuntimeService(ISmsVerifyCodeService.class, "all")).handleSmsVerifyCodeCancel(this, new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2() {
        Dialog dialog = this.f176959j0;
        if (dialog == null) {
            QLog.d("RegisterSendUpSms", 1, "hide loading dialog, but dialog is null");
        } else {
            dialog.dismiss();
        }
    }

    private void T2() {
        this.f176956g0 = getIntent().getByteArrayExtra(AppConstants.Key.KEY_NT_REGISTER_CONTEXT);
        this.f176950a0 = getIntent().getStringExtra(AppConstants.Key.KEY_REGISTER_PROMPT_UPMSG);
        this.phoneNum = getIntent().getStringExtra(AppConstants.Key.KEY_REGISTER_PROMPT_PHONE);
        this.f176951b0 = getIntent().getStringExtra(AppConstants.Key.KEY_REGISTER_PROMPT_UPSMS_PORT);
        this.f176952c0 = getIntent().getStringExtra(AppConstants.Key.KEY_REGISTER_TIPS);
        this.f176953d0 = getIntent().getStringExtra(AppConstants.Key.KEY_REGISTER_PROMPT_TEXT);
        QLog.d("RegisterSendUpSms", 2, "doOnCreate nt data mUpMsg: " + this.f176950a0 + " phoneNum: " + this.phoneNum);
    }

    private void U2() {
        if (!TextUtils.isEmpty(this.f176950a0) && !TextUtils.isEmpty(this.f176951b0)) {
            TextView textView = (TextView) findViewById(R.id.f113286q8);
            TextView textView2 = (TextView) findViewById(R.id.f111416l6);
            TextView textView3 = (TextView) findViewById(R.id.f110476im);
            String W2 = W2(this.f176951b0, new c());
            textView.setText(this.f176952c0);
            textView2.setText(this.f176950a0);
            textView3.setText(W2);
            this.f176960k0.setText(this.f176953d0);
            Z2();
            return;
        }
        QLog.e("RegisterSendUpSms", 1, "initView, data is unexpected, phoneNum : ", this.phoneNum, " upMsg : ", this.f176950a0, " upNum : ", this.f176951b0);
    }

    private void V2(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f176950a0 = jSONObject.getString("upmsg");
            this.f176951b0 = jSONObject.getString("upnum");
            if (TextUtils.isEmpty(this.phoneNum)) {
                String string = jSONObject.getString("phone");
                this.phoneNum = string.substring(string.indexOf(45) + 1);
            }
        } catch (JSONException e16) {
            QLog.e("RegisterSendUpSms", 1, "initView error : ", e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y2(int i3, String str, RegisterIdentityRsp registerIdentityRsp) {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("queryUpSms result: ");
        sb5.append(i3);
        sb5.append("business code: ");
        if (registerIdentityRsp != null) {
            obj = Integer.valueOf(registerIdentityRsp.retCode);
        } else {
            obj = "";
        }
        sb5.append(obj);
        QLog.d("RegisterSendUpSms", 1, sb5.toString());
        if (registerIdentityRsp != null) {
            this.f176956g0 = registerIdentityRsp.context;
        }
        ThreadManager.getUIHandler().post(new Runnable(i3, registerIdentityRsp) { // from class: com.tencent.mobileqq.activity.RegisterSendUpSms.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f176965d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RegisterIdentityRsp f176966e;

            {
                this.f176965d = i3;
                this.f176966e = registerIdentityRsp;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, RegisterSendUpSms.this, Integer.valueOf(i3), registerIdentityRsp);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                RegisterIdentityLimit registerIdentityLimit;
                RegisterIdentityRsp registerIdentityRsp2;
                int i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    RegisterSendUpSms.this.S2();
                    if (this.f176965d == 0 && (registerIdentityRsp2 = this.f176966e) != null && ((i16 = registerIdentityRsp2.retCode) == 10000 || i16 == 10001)) {
                        if (i16 == 10001) {
                            RegisterSendUpSms.this.f176954e0 = registerIdentityRsp2.limit.handleUrl;
                            RegisterSendUpSms.this.f176955f0 = this.f176966e.limit.type;
                        }
                        RegisterSendUpSms.this.f176961l0 = 3;
                        RegisterSendUpSms registerSendUpSms = RegisterSendUpSms.this;
                        registerSendUpSms.e3(0, registerSendUpSms.getString(R.string.szk), 2);
                        if (!RegisterSendUpSms.this.Q2()) {
                            QLog.e("RegisterSendUpSms", 2, "onRegisterQuerySmsStatResp handleCallback: false");
                            return;
                        }
                        return;
                    }
                    QLog.d("RegisterSendUpSms", 1, "not receive sms");
                    RegisterSendUpSms.this.f176961l0 = 4;
                    RegisterIdentityRsp registerIdentityRsp3 = this.f176966e;
                    if (registerIdentityRsp3 != null && (registerIdentityLimit = registerIdentityRsp3.limit) != null && !TextUtils.isEmpty(registerIdentityLimit.prompt)) {
                        RegisterSendUpSms.this.f176960k0.setText(this.f176966e.limit.prompt);
                        RegisterSendUpSms.this.f176960k0.setTextColor(ResourcesCompat.getColor(RegisterSendUpSms.this.getResources(), R.color.qui_common_feedback_error, null));
                    }
                    RegisterSendUpSms registerSendUpSms2 = RegisterSendUpSms.this;
                    registerSendUpSms2.e3(-1, registerSendUpSms2.getString(R.string.g0s), 1);
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    private void Z2() {
        com.tencent.mobileqq.loginregister.z.q(findViewById(R.id.iif), this);
    }

    private void b3() {
        int i3;
        showLoadingDialog();
        this.f176961l0 = 2;
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            CheckLimitHandleResultReq checkLimitHandleResultReq = new CheckLimitHandleResultReq();
            checkLimitHandleResultReq.context = getIntent().getByteArrayExtra(AppConstants.Key.KEY_NT_REGISTER_CONTEXT);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("queryUpSms cookie length: ");
            byte[] bArr = checkLimitHandleResultReq.context;
            if (bArr != null) {
                i3 = bArr.length;
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            QLog.d("RegisterSendUpSms", 1, sb5.toString());
            ((ILoginService) QRoute.api(ILoginService.class)).checkLimitHandleResult(checkLimitHandleResultReq, new IRegisterIdentityCallback() { // from class: com.tencent.mobileqq.activity.ev
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRegisterIdentityCallback
                public final void onResult(int i16, String str, RegisterIdentityRsp registerIdentityRsp) {
                    RegisterSendUpSms.this.Y2(i16, str, registerIdentityRsp);
                }
            });
        }
        ((IRegisterServletService) this.mRuntime.getRuntimeService(IRegisterServletService.class, "all")).queryUpSmsStat(this.f176964o0);
    }

    private void d3(String str, String str2) {
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(SmsPlugin.KEY_SYSTEM_SMS_URI));
            intent.setType(SmsPlugin.KEY_SYSTEM_SMS_TYPE);
            intent.putExtra("address", str);
            intent.putExtra(SmsPlugin.KEY_SYSTEM_SMS_CONTENT, str2);
            startActivity(intent);
        } catch (Exception e16) {
            e16.printStackTrace();
            Intent intent2 = new Intent("android.intent.action.SENDTO");
            intent2.setData(Uri.parse(SmsPlugin.KEY_SYSTEM_SMS_URI + str));
            intent2.putExtra(SmsPlugin.KEY_SYSTEM_SMS_CONTENT, str2);
            startActivity(intent2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("RegisterSendUpSms", 2, String.format("sendSMS phoneNum:%s, msgBody:%s", str, str2));
        }
        ReportController.t(this.mRuntime, "new_reg_805", "send_msg", "send_clk", "", 1, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3(int i3, String str, int i16) {
        QQToast.makeText(this, i16, str, 0).show(getTitleBarHeight());
        com.tencent.mobileqq.util.as.g(this.mRuntime, "0X800C1C5", "", com.tencent.mobileqq.loginregister.ao.INSTANCE.c(), str);
        if (i3 != 0) {
            com.tencent.mobileqq.loginregister.sms.f.d(this.phoneNum, this.f176962m0, str);
        }
    }

    private void initView() {
        if (!TextUtils.isEmpty(this.phoneNum) && !TextUtils.isEmpty(this.f176950a0) && !TextUtils.isEmpty(this.f176951b0)) {
            TextView textView = (TextView) findViewById(R.id.f113286q8);
            TextView textView2 = (TextView) findViewById(R.id.f111416l6);
            TextView textView3 = (TextView) findViewById(R.id.f110476im);
            String W2 = W2(this.phoneNum, new d());
            String W22 = W2(this.f176951b0, new c());
            textView.setText(P2(getString(R.string.f216615ys), W2));
            textView2.setText(this.f176950a0);
            textView3.setText(W22);
            Z2();
            return;
        }
        QLog.e("RegisterSendUpSms", 1, "initView, data is unexpected, phoneNum : ", this.phoneNum, " upMsg : ", this.f176950a0, " upNum : ", this.f176951b0);
    }

    private void showLoadingDialog() {
        if (this.f176959j0 == null) {
            this.f176959j0 = com.tencent.mobileqq.loginregister.z.a(this, R.string.k2e);
        }
        this.f176959j0.show();
    }

    protected String W2(String str, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) eVar);
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("RegisterSendUpSms", 1, "insertSpace charSequence is null");
            return null;
        }
        int length = str.length();
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < length; i3++) {
            sb5.append(str.charAt(i3));
            if (eVar.a(i3)) {
                sb5.append(" ");
            }
        }
        return sb5.toString().trim();
    }

    protected void c3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.util.cb.d("0X8007364");
        ReportController.r(null, "dc00898", "", "", "0X800B8DB", "0X800B8DB", 0, 0, "", "", com.tencent.mobileqq.loginregister.ao.INSTANCE.b(), "");
        com.tencent.mobileqq.loginregister.sms.f.c(this.phoneNum, this.f176962m0);
    }

    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(@NonNull Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) configuration);
        } else {
            super.doOnConfigurationChanged(configuration);
            Z2();
        }
    }

    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        RFWImmersiveUtils.setTransparentStatusBar(getWindow());
        RFWImmersiveUtils.setImmersiveLayout(getWindow(), true);
        Intent intent = getIntent();
        setContentView(R.layout.hmy);
        String str = "";
        setTitleText("");
        com.tencent.mobileqq.util.w.a(this, findViewById(R.id.root_layout));
        setProgressBarVisible(false);
        setBackListener();
        initData(intent);
        this.f176950a0 = super.getString(R.string.g0w);
        this.f176951b0 = super.getString(R.string.g0x);
        this.f176957h0 = (Button) findViewById(R.id.aje);
        this.f176958i0 = (Button) findViewById(R.id.td8);
        this.f176960k0 = (TextView) findViewById(R.id.f107886bm);
        this.f176957h0.setOnClickListener(this);
        this.f176958i0.setOnClickListener(this);
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            T2();
            U2();
            return true;
        }
        if (intent != null) {
            str = intent.getStringExtra(AppConstants.Key.KEY_REGISTER_PROMPT_INFO);
        }
        if (!TextUtils.isEmpty(str)) {
            V2(str);
            initView();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnResume();
        com.tencent.mobileqq.register.q.c().l(2);
        if (QLog.isColorLevel()) {
            QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "doOnResume mState: %s", Integer.valueOf(this.f176961l0)));
        }
        if (this.f176961l0 == 1) {
            b3();
        }
    }

    protected void initData(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        if (intent != null) {
            this.phoneNum = intent.getStringExtra(AppConstants.Key.PHONENUM);
            this.countryCode = intent.getStringExtra("key");
        }
        setBarProgress(50);
        com.tencent.mobileqq.loginregister.z.v(this.mRuntime, getClass(), this.f176963n0);
        c3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity, com.tencent.mobileqq.app.QBaseActivity
    protected boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        R2();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.td8) {
                com.tencent.mobileqq.util.cb.d("0X800B4BA");
                com.tencent.mobileqq.loginregister.sms.f.a(this.phoneNum, this.f176962m0);
                if (this.f176961l0 == 2) {
                    QLog.d("RegisterSendUpSms", 1, "check sms, but is querying");
                } else {
                    b3();
                }
            } else if (id5 == R.id.aje) {
                if (QLog.isColorLevel()) {
                    QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "onClick mState: %s", Integer.valueOf(this.f176961l0)));
                }
                com.tencent.mobileqq.util.cb.d("0X800B4B9");
                com.tencent.mobileqq.loginregister.sms.f.b(this.phoneNum, this.f176962m0);
                d3(this.f176951b0, this.f176950a0);
                this.f176961l0 = 1;
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.mobileqq.loginregister.z.s(this.mRuntime, getClass());
        S2();
    }
}
