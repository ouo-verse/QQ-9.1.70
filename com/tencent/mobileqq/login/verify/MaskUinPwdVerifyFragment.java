package com.tencent.mobileqq.login.verify;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LoginPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.login.aa;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.login.al;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.c;
import com.tencent.mobileqq.loginregister.ai;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.bk;
import com.tencent.mobileqq.util.bw;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.IVerifyNewDeviceCallback;
import com.tencent.qqnt.kernel.nativeinterface.LoginRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.NewDeviceVerifyReq;
import com.tencent.qqnt.kernel.nativeinterface.NewDeviceVerifyRsp;
import com.tencent.qqnt.kernel.nativeinterface.UserInfo;
import cooperation.qzone.QZoneShareManager;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import tencent.im.login.GatewayVerify$ReqBody;

/* loaded from: classes15.dex */
public class MaskUinPwdVerifyFragment extends QPublicBaseFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private ai C;
    private AccountInfo D;
    private String E;
    private String F;
    private int G;
    private PastablePwdEditText H;
    private ImageView I;
    private ImageView J;
    private boolean K;
    private InputMethodManager L;
    private QUIButton M;
    protected final aa N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a implements ConfigClearableEditText.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MaskUinPwdVerifyFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void Af(boolean z16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ImageView imageView = MaskUinPwdVerifyFragment.this.J;
                if (z16) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void Mg(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void v2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public int w9() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return ViewUtils.dpToPx(16.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class b implements TextWatcher {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MaskUinPwdVerifyFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                MaskUinPwdVerifyFragment.this.updateLoginBtnAndPasswordEditTextStatus();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                MaskUinPwdVerifyFragment.this.updatePwdStates();
            } else {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* loaded from: classes15.dex */
    class c implements aa {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MaskUinPwdVerifyFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                QLog.d("MaskUinPwdVerifyFragment", 1, "onLoginCancel");
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void b(aj ajVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) ajVar);
                return;
            }
            int i3 = ajVar.f241864a;
            String str = ajVar.f241866c;
            QLog.d("MaskUinPwdVerifyFragment", 1, "onLoginFailed ret=", Integer.valueOf(i3), " errorMsg", str);
            if (MaskUinPwdVerifyFragment.this.G == 4) {
                bw.a(i3, str);
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void c(String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle);
                return;
            }
            QLog.d("MaskUinPwdVerifyFragment", 1, "onLoginSuccess. loginType= " + MaskUinPwdVerifyFragment.this.G);
            if (MaskUinPwdVerifyFragment.this.Ih()) {
                return;
            }
            if (MaskUinPwdVerifyFragment.this.G == 4) {
                bw.a(0, "SUCCESS");
                i.e(BaseApplication.getContext(), MobileQQ.sMobileQQ.peekAppRuntime());
            }
            MaskUinPwdVerifyFragment.this.Rh(str);
            FragmentActivity activity = MaskUinPwdVerifyFragment.this.getActivity();
            if (activity != null) {
                Intent intent = new Intent();
                intent.putExtra("last_account", str);
                activity.setResult(-1, intent);
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class d implements aa {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MaskUinPwdVerifyFragment.this);
            }
        }

        private void d(String str, byte[] bArr, Bundle bundle) {
            FragmentActivity activity = MaskUinPwdVerifyFragment.this.getActivity();
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                Intent intent = new Intent();
                if (bArr != null) {
                    intent.putExtra("wtTicket", new String(bArr));
                }
                intent.putExtra("ssobundle", bundle);
                intent.putExtra("last_account", str);
                activity.setResult(-1, intent);
                activity.finish();
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void b(aj ajVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) ajVar);
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void c(String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle);
            } else {
                d(str, bundle.getByteArray("wtTicket"), bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class e implements aa {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MaskUinPwdVerifyFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void b(aj ajVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) ajVar);
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void c(String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle);
                return;
            }
            QLog.d("MaskUinPwdVerifyFragment", 2, "subaccount onLoginSuccess: start");
            FragmentActivity activity = MaskUinPwdVerifyFragment.this.getActivity();
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                Intent intent = new Intent();
                intent.putExtra("last_account", str);
                activity.setResult(-1, intent);
                activity.finish();
            }
        }
    }

    public MaskUinPwdVerifyFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.K = false;
            this.N = new c();
        }
    }

    private aa Bh() {
        return new d();
    }

    private aa Ch() {
        return new e();
    }

    public static byte[] Dh(String str) {
        try {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            if (length != 0 && length % 2 == 0) {
                byte[] bArr = new byte[length / 2];
                char[] cArr = new char[2];
                for (int i3 = 0; i3 < length; i3 += 2) {
                    cArr[0] = charArray[i3];
                    cArr[1] = charArray[i3 + 1];
                    bArr[i3 / 2] = (byte) Integer.parseInt(new String(cArr), 16);
                }
                return bArr;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("MaskUinPwdVerifyFragment", 1, "hexDecode error: " + e16);
            return null;
        }
    }

    private void Eh() {
        if (this.L != null && getActivity() != null) {
            this.L.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    private void Fh(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.f113896rv);
        AccountInfo accountInfo = this.D;
        if (accountInfo != null) {
            str = accountInfo.getMaskUin();
        } else {
            str = "";
        }
        textView.setText(str);
        textView.setContentDescription(getString(R.string.account) + str);
        textView.setAlpha(0.5f);
    }

    private void Gh(View view) {
        this.H = (PastablePwdEditText) view.findViewById(R.id.f226504a);
        this.J = (ImageView) view.findViewById(R.id.fis);
        this.I = (ImageView) view.findViewById(R.id.fiu);
        this.J.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.H.setCustomClearButtonCallback(new a());
        showPasswordEditTextHint();
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                View.class.getMethod("setImportantForAutofill", Integer.TYPE).invoke(this.H, 8);
            } catch (Exception e16) {
                QLog.w("MaskUinPwdVerifyFragment", 2, "disable auto fill error", e16);
            }
        }
        this.H.addTextChangedListener(new b());
        this.H.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.login.verify.m
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z16) {
                MaskUinPwdVerifyFragment.this.Jh(view2, z16);
            }
        });
        this.H.setLongClickable(true);
        this.H.setTextClearedListener(new ConfigClearableEditText.e() { // from class: com.tencent.mobileqq.login.verify.n
            @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.e
            public final void E0() {
                libsafeedit.clearPassBuffer();
            }
        });
        this.H.setTextSize(20.0f);
        updatePwdStates();
        updateLoginBtnAndPasswordEditTextStatus();
    }

    private void Hh(View view) {
        view.findViewById(R.id.f61782z2).setVisibility(8);
        TextView textView = (TextView) view.findViewById(R.id.yud);
        TextView textView2 = (TextView) view.findViewById(R.id.yun);
        textView.setVisibility(0);
        textView2.setVisibility(0);
        textView.setText(R.string.f200544se);
        textView2.setText(R.string.f200534sd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ih() {
        boolean z16;
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.d("MaskUinPwdVerifyFragment", 1, "activity invalid");
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(View view, boolean z16) {
        updatePwdStates();
        if (z16) {
            PastablePwdEditText pastablePwdEditText = this.H;
            pastablePwdEditText.setSelection(pastablePwdEditText.length());
            if (z.c() && this.L.isActive(this.H)) {
                this.L.showSoftInput(this.H, 2);
            }
            this.H.setHint("");
            return;
        }
        showPasswordEditTextHint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(int i3, String str, NewDeviceVerifyRsp newDeviceVerifyRsp) {
        FragmentActivity activity;
        QLog.d("MaskUinPwdVerifyFragment", 1, "loginFromNTByToken result: " + i3 + " busCode: " + newDeviceVerifyRsp.loginRspInfo.errCode + " errMsg: " + str);
        if (i3 == 0 && newDeviceVerifyRsp.loginRspInfo.errCode == 0) {
            if (!Ih() && (activity = getActivity()) != null) {
                Intent intent = new Intent();
                intent.putExtra("devlock_verify_sig", newDeviceVerifyRsp.deviceCheckSucceedSig);
                activity.setResult(-1, intent);
                activity.finish();
                return;
            }
            return;
        }
        FragmentActivity activity2 = getActivity();
        LoginRspInfo loginRspInfo = newDeviceVerifyRsp.loginRspInfo;
        Sh(activity2, loginRspInfo.tipsTitle, loginRspInfo.errMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Mh(Activity activity, String str, String str2) {
        DialogUtil.createCustomDialog(activity, 230, str, str2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.verify.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }, null).show();
    }

    private void Oh(byte[] bArr) {
        QLog.d("MaskUinPwdVerifyFragment", 1, "loginFromNTByToken");
        NewDeviceVerifyReq newDeviceVerifyReq = new NewDeviceVerifyReq();
        newDeviceVerifyReq.passwordMd5 = util.buf_to_string(bArr);
        newDeviceVerifyReq.verifyNewDeviceSig = this.E.getBytes();
        UserInfo userInfo = new UserInfo();
        userInfo.account = this.D.getMaskUin();
        userInfo.encryptUin = Dh(this.F);
        newDeviceVerifyReq.userInfo = userInfo;
        ((ILoginService) QRoute.api(ILoginService.class)).verifyNewDeviceWithPwd(newDeviceVerifyReq, new IVerifyNewDeviceCallback() { // from class: com.tencent.mobileqq.login.verify.o
            @Override // com.tencent.qqnt.kernel.nativeinterface.IVerifyNewDeviceCallback
            public final void onResult(int i3, String str, NewDeviceVerifyRsp newDeviceVerifyRsp) {
                MaskUinPwdVerifyFragment.this.Kh(i3, str, newDeviceVerifyRsp);
            }
        });
    }

    private void Ph() {
        int i3 = this.G;
        if (i3 == 4) {
            bk.k("0X800B8D4");
        } else if (i3 == 5) {
            bk.k("0X800B93A");
        }
        ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800AA27", "0X800AA27", 6, 0, "", "", com.tencent.mobileqq.statistics.o.c(), "");
    }

    private void Qh() {
        int i3 = this.G;
        if (i3 == 4) {
            bk.k("0X800B8D5");
        } else if (i3 == 5) {
            bk.k("0X800B93B");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh(String str) {
        int loginEntranceForReport = ((ILoginReporter) QRoute.api(ILoginReporter.class)).getLoginEntranceForReport();
        int i3 = this.G;
        if (i3 == 4) {
            bk.h("0X800B8D9", loginEntranceForReport, "");
        } else if (i3 == 5) {
            ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800B93D", "0X800B93D", loginEntranceForReport, 0, "", "", str, "");
        }
    }

    private static void Sh(final Activity activity, final String str, final String str2) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (TextUtils.isEmpty(str)) {
                str = HardCodeUtil.qqStr(R.string.f172151nv4);
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.verify.p
                @Override // java.lang.Runnable
                public final void run() {
                    MaskUinPwdVerifyFragment.Mh(activity, str, str2);
                }
            });
        }
    }

    public static void Th(Activity activity, AccountInfo accountInfo, Bundle bundle, int i3) {
        QLog.d("MaskUinPwdVerifyFragment", 1, "-->startFragmentForResult curActivity=", activity);
        if (activity == null) {
            return;
        }
        Intent intent = activity.getIntent();
        Intent intent2 = new Intent();
        intent2.putExtra("account_info", accountInfo);
        intent2.putExtra(QZoneShareManager.QZONE_SHARE_FROM_WEB, bundle.getBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB, false));
        intent2.putExtra(TangramHippyConstants.LOGIN_TYPE, bundle.getInt(TangramHippyConstants.LOGIN_TYPE, 0));
        intent2.putExtra("isSubaccount", bundle.getBoolean("isSubaccount", false));
        intent2.putExtra("from_where", bundle.getString("from_where"));
        intent2.putExtra("verifySig", bundle.getString("verifySig"));
        intent2.putExtra("uinToken", bundle.getString("uinToken"));
        intent2.putExtra("appid", intent.getStringExtra("appid"));
        LoginPublicFragmentActivity.F2(activity, intent2, MaskUinPwdVerifyFragment.class, i3);
    }

    private String getInputPassword() {
        PastablePwdEditText pastablePwdEditText = this.H;
        if (pastablePwdEditText != null) {
            return pastablePwdEditText.getText().toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreateView$0(View view, MotionEvent motionEvent) {
        this.H.clearFocus();
        Eh();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showKeyboard() {
        PastablePwdEditText pastablePwdEditText;
        if (this.L != null && (pastablePwdEditText = this.H) != null) {
            pastablePwdEditText.requestFocus();
            this.L.showSoftInput(this.H, 2);
        }
    }

    private void showPasswordEditTextHint() {
        this.H.setContentDescription(BaseApplication.getContext().getString(R.string.f211465kw));
        this.H.setHint(R.string.f211345kk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoginBtnAndPasswordEditTextStatus() {
        if (!TextUtils.isEmpty(getInputPassword())) {
            this.M.o();
        } else {
            this.M.setBackgroundDisabled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePwdStates() {
        if (this.H.isFocused()) {
            this.I.setVisibility(0);
        } else {
            this.I.setVisibility(8);
        }
        if (this.K) {
            this.H.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.I.setImageResource(R.drawable.qui_eye_on_secondary_01_selector);
            this.I.setContentDescription(HardCodeUtil.qqStr(R.string.f211245ka));
        } else {
            this.H.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.I.setImageResource(R.drawable.qui_eye_off_secondary_01_selector);
            this.I.setContentDescription(HardCodeUtil.qqStr(R.string.f211415kr));
        }
    }

    protected void Nh() {
        int i3;
        c.a B;
        aa aaVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            String inputPassword = getInputPassword();
            if (TextUtils.isEmpty(inputPassword)) {
                QQToast.makeText(getQBaseActivity(), R.string.cqq, 0).show();
                return;
            }
            libsafeedit.getLoginLegal(inputPassword);
            byte[] byteSafeEditTextToMD5 = libsafeedit.byteSafeEditTextToMD5(Boolean.TRUE);
            if (MobileQQ.sMobileQQ.isLoginByNT()) {
                Oh(byteSafeEditTextToMD5);
                return;
            }
            GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
            String str = this.E;
            if (str != null) {
                gatewayVerify$ReqBody.msg_req_cmd_4.str_new_device_check_sig.set(str);
            }
            String str2 = this.F;
            if (str2 != null) {
                gatewayVerify$ReqBody.msg_req_cmd_4.str_new_device_check_uin_token.set(str2);
            }
            gatewayVerify$ReqBody.msg_req_cmd_4.setHasFlag(true);
            gatewayVerify$ReqBody.setHasFlag(true);
            int i16 = this.G;
            if (i16 == 4) {
                i3 = 2;
            } else if (i16 == 5) {
                i3 = 3;
            } else {
                i3 = 0;
            }
            boolean equals = BaseConstants.SSO_ACCOUNT_ACTION.equals(qBaseActivity.getIntent().getStringExtra("from_where"));
            if (equals) {
                this.C.a(gatewayVerify$ReqBody, qBaseActivity.getIntent().getStringExtra("appid"));
            }
            boolean booleanExtra = qBaseActivity.getIntent().getBooleanExtra("isSubaccount", false);
            if (equals) {
                Bundle bundle = new Bundle();
                bundle.putInt(AppConstants.Key.KEY_PUZZLE_VERIFY_CODE, 130);
                B = new c.a(3, 6, this.D.getMaskUin(), inputPassword).x(bundle);
                aaVar = Bh();
            } else if (booleanExtra) {
                c.a aVar = new c.a(2, 6, this.D.getMaskUin(), inputPassword);
                aaVar = Ch();
                B = aVar;
            } else {
                B = new c.a(1, 6, this.D.getMaskUin(), inputPassword).B(byteSafeEditTextToMD5);
                if (qBaseActivity.getIntent().getBooleanExtra(QZoneShareManager.QZONE_SHARE_FROM_WEB, false)) {
                    B.t(true);
                }
                aaVar = this.N;
            }
            com.tencent.mobileqq.login.c r16 = B.u(true).A(gatewayVerify$ReqBody).z(true).w(true).y(i3).r();
            al.b(r16.f242200a).login(qBaseActivity, r16, null, aaVar);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentActivity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else if (view.getId() == R.id.f166147yu4) {
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(BaseApplication.getContext(), R.string.f171137ci2, 0).show();
            } else {
                Eh();
                Qh();
                Nh();
            }
        } else if (view.getId() == R.id.fiu) {
            this.K = !this.K;
            updatePwdStates();
            PastablePwdEditText pastablePwdEditText = this.H;
            pastablePwdEditText.setSelection(pastablePwdEditText.length());
        } else if (view.getId() == R.id.fis) {
            this.H.h();
        } else if (view.getId() == R.id.a47) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && !activity2.isFinishing()) {
                activity2.onBackPressed();
            }
        } else if (view.getId() == R.id.tei && (activity = getActivity()) != null && !activity.isFinishing()) {
            z.t(activity, "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            inflate = layoutInflater.inflate(R.layout.gyd, viewGroup, false);
            this.C = new ai();
            FragmentActivity requireActivity = requireActivity();
            Intent intent = requireActivity.getIntent();
            this.G = intent.getIntExtra(TangramHippyConstants.LOGIN_TYPE, 0);
            this.D = (AccountInfo) intent.getSerializableExtra("account_info");
            this.E = intent.getStringExtra("verifySig");
            this.F = intent.getStringExtra("uinToken");
            if (this.D == null) {
                QLog.e("MaskUinPwdVerifyFragment", 1, "onCreateView, info is null");
                QQToast.makeText(BaseApplication.getContext(), R.string.f200994tm, 0).show();
                requireActivity().finish();
            } else {
                if (TextUtils.isEmpty(this.E)) {
                    QLog.w("MaskUinPwdVerifyFragment", 1, "onCreateView verifySig is null");
                }
                View findViewById = inflate.findViewById(R.id.a47);
                View findViewById2 = inflate.findViewById(R.id.tei);
                this.M = (QUIButton) inflate.findViewById(R.id.f166147yu4);
                if (AppSetting.f99565y) {
                    AccessibilityUtil.p(findViewById, BaseApplication.getContext().getString(R.string.f211435kt));
                    AccessibilityUtil.p(findViewById2, BaseApplication.getContext().getString(R.string.ipk));
                }
                findViewById.setOnClickListener(this);
                findViewById2.setOnClickListener(this);
                this.M.setOnClickListener(this);
                Hh(inflate);
                Fh(inflate);
                Gh(inflate);
                this.L = (InputMethodManager) requireActivity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                inflate.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.login.verify.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        MaskUinPwdVerifyFragment.this.showKeyboard();
                    }
                }, 100L);
                inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.login.verify.l
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean lambda$onCreateView$0;
                        lambda$onCreateView$0 = MaskUinPwdVerifyFragment.this.lambda$onCreateView$0(view, motionEvent);
                        return lambda$onCreateView$0;
                    }
                });
                Ph();
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }
}
