package com.tencent.mobileqq.login.fragment;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.login.al;
import com.tencent.mobileqq.login.ay;
import com.tencent.mobileqq.login.bl;
import com.tencent.mobileqq.login.widget.LoginPageBottomMoreActionsView;
import com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.mobileqq.util.aj;
import com.tencent.mobileqq.util.at;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.slf4j.Marker;
import tencent.im.login.GetLocalPhone$MaskPhoneData;

/* loaded from: classes15.dex */
public class PhoneNumLoginFragment extends BaseLoginFragment implements View.OnClickListener, ConfigClearableEditText.e, ConfigClearableEditText.d {
    static IPatchRedirector $redirector_;
    private QBaseActivity K;
    private RelativeLayout L;
    private View M;
    private LinearLayout N;
    private RelativeLayout P;
    private ImageView Q;
    private TextView R;
    private ConfigClearableEditText S;
    private RelativeLayout T;
    private PastablePwdEditText U;
    private ImageView V;
    private ImageView W;
    private LinearLayout X;
    private QUICheckBox Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private QUIButton f242122a0;

    /* renamed from: b0, reason: collision with root package name */
    private LoginPageBottomMoreActionsView f242123b0;

    /* renamed from: c0, reason: collision with root package name */
    private InputMethodManager f242124c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f242125d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f242126e0;

    /* renamed from: f0, reason: collision with root package name */
    public BroadcastReceiver f242127f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f242128g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f242129h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f242130i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f242131j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f242132k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f242133l0;

    /* renamed from: m0, reason: collision with root package name */
    private ImageView f242134m0;

    /* renamed from: n0, reason: collision with root package name */
    private final TextWatcher f242135n0;

    /* renamed from: o0, reason: collision with root package name */
    private final TextWatcher f242136o0;

    /* renamed from: p0, reason: collision with root package name */
    private final View.OnFocusChangeListener f242137p0;

    /* loaded from: classes15.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneNumLoginFragment.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            QLog.d("PhoneNumLoginFragment.TAG", 1, "AutoLoginReceiver onReceive, action=" + action + ", mIsFirstState=" + PhoneNumLoginFragment.this.f242126e0 + ", isResumed = " + PhoneNumLoginFragment.this.isResumed());
            if ("com.tencent.mobileqq.InvitationWebViewPlugin.autoLogin".equals(action)) {
                if (intent.getIntExtra("loginFragmentType", 0) == 4 && !((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).isLoggingIn()) {
                    ((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).reportWebNotifyFinishVerify(MobileQQ.sMobileQQ.peekAppRuntime(), Integer.valueOf(PhoneNumLoginFragment.this.uh()), PhoneNumLoginFragment.this.ri());
                    PhoneNumLoginFragment.this.f242128g0 = true;
                    return;
                }
                return;
            }
            if ("com.tencent.mobileqq.login.autoPhoneLogin".equals(action)) {
                if (!PhoneNumLoginFragment.this.f242126e0 && PhoneNumLoginFragment.this.isResumed()) {
                    if (!PhoneNumLoginFragment.this.yi()) {
                        PhoneNumLoginFragment.this.Mi();
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString(AuthDevOpenUgActivity.KEY_PHONE_NUM, "");
                    bundle.putBoolean("key_second_state", false);
                    PhoneNumLoginFragment.this.Hh(3, bundle, false);
                    return;
                }
                return;
            }
            if ("com.tencent.mobileqq.login.autoSmsLogin".equals(action) && !PhoneNumLoginFragment.this.f242126e0 && PhoneNumLoginFragment.this.isResumed()) {
                PhoneNumLoginFragment.this.Mi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class b implements ConfigClearableEditText.d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f242139d;

        b(int i3) {
            this.f242139d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneNumLoginFragment.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void Af(boolean z16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ImageView imageView = PhoneNumLoginFragment.this.W;
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
            } else if (z16) {
                PhoneNumLoginFragment.this.W.setAlpha(0.5f);
            } else {
                PhoneNumLoginFragment.this.W.setAlpha(1.0f);
            }
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void v2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                PhoneNumLoginFragment.this.W.setAlpha(1.0f);
            }
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public int w9() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f242139d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class c implements LoginPageBottomMoreActionsView.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneNumLoginFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.login.widget.LoginPageBottomMoreActionsView.a
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (PhoneNumLoginFragment.this.Y != null) {
                return PhoneNumLoginFragment.this.Y.isChecked();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.login.widget.LoginPageBottomMoreActionsView.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                PhoneNumLoginFragment.this.pi();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* loaded from: classes15.dex */
    class d implements TextWatcher {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneNumLoginFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            QLog.d("PhoneNumLoginFragment.TAG", 2, "afterTextChanged mPhoneNumEditText");
            PhoneNumLoginFragment.this.updateLoginBtnAndPasswordEditTextStatus();
            PhoneNumLoginFragment.this.Ti();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* loaded from: classes15.dex */
    class e implements TextWatcher {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneNumLoginFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            QLog.d("PhoneNumLoginFragment.TAG", 2, "afterTextChanged mPasswordEditText");
            PhoneNumLoginFragment.this.updateLoginBtnAndPasswordEditTextStatus();
            PhoneNumLoginFragment.this.updatePasswordTextSize();
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* loaded from: classes15.dex */
    class f implements View.OnFocusChangeListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneNumLoginFragment.this);
            }
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
                return;
            }
            if (view == PhoneNumLoginFragment.this.S) {
                PhoneNumLoginFragment.this.Si(z16);
            } else if (view == PhoneNumLoginFragment.this.U) {
                PhoneNumLoginFragment.this.Ri();
                PhoneNumLoginFragment.this.Qi(z16);
            }
        }
    }

    public PhoneNumLoginFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f242125d0 = false;
        this.f242126e0 = true;
        this.f242128g0 = false;
        this.f242129h0 = "";
        this.f242130i0 = "";
        this.f242131j0 = "86";
        this.f242132k0 = HardCodeUtil.qqStr(R.string.fyo);
        this.f242133l0 = null;
        this.f242135n0 = new d();
        this.f242136o0 = new e();
        this.f242137p0 = new f();
    }

    private void Ai() {
        Bundle bundle = new Bundle();
        bundle.putString("country_code", this.f242131j0);
        bundle.putString(AuthDevOpenUgActivity.KEY_PHONE_NUM, this.f242130i0);
        bundle.putString("uin", this.f242129h0);
        bundle.putBoolean("key_second_state", true);
        bundle.putBoolean("key_from_wx_login", this.K.getIntent().getBooleanExtra("key_from_wx_login", false));
        Hh(4, bundle, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        z.t(getQBaseActivity(), ri());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ci(String str, String str2) {
        if (!TextUtils.isEmpty(this.f242131j0) && !TextUtils.isEmpty(str) && !str.equals(this.f242131j0)) {
            this.f242131j0 = str;
            Oi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Di(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        pi();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ei() {
        LoginUtil.t(this.Y, "key_phone_num_login_tips_shown");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Fi(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            pi();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gi() {
        if (this.P.getWidth() <= ViewUtils.dpToPx(320.0f)) {
            this.S.setPadding(Math.max(this.N.getWidth(), this.S.getPaddingLeft()), 0, this.S.getPaddingRight(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hi(String str) {
        QQToast.makeText(this.K, str, 0).show();
    }

    private void Ii() {
        if (z.b(this.K)) {
            z.y(this.M);
        } else {
            z.A(this.M);
        }
    }

    private void Ji(boolean z16) {
        if (z16) {
            this.f242122a0.o();
        } else {
            this.f242122a0.setBackgroundDisabled();
        }
    }

    private void Ki() {
        String ri5 = ri();
        if (TextUtils.isEmpty(getInputPassword())) {
            showToast(HardCodeUtil.qqStr(R.string.cqq));
            return;
        }
        QLog.d("PhoneNumLoginFragment.TAG", 1, "startAccountLogin login by pwd");
        pi();
        at.f306599a = true;
        byte[] byteSafeEditTextToMD5 = libsafeedit.byteSafeEditTextToMD5(Boolean.TRUE);
        if (this.K.getAppRuntime() == null) {
            QLog.e("PhoneNumLoginFragment.TAG", 1, "login() appRuntime is null");
            return;
        }
        Li();
        ay k3 = new ay.a(ri5, this.f242131j0, byteSafeEditTextToMD5, uh()).p(this.f242129h0).m(Gh()).l(Fh()).o(this.K.getIntent().getStringExtra("appid")).n(Eh()).k();
        k3.f242200a = 7;
        al.b(7).login(getQBaseActivity(), k3, wh(), th(7));
    }

    private void Li() {
        QUIButton qUIButton = this.f242122a0;
        if (qUIButton != null && !qUIButton.m()) {
            this.f242122a0.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mi() {
        String ri5 = ri();
        if (!TextUtils.isEmpty(this.f242131j0) && !TextUtils.isEmpty(ri5)) {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                showToast(HardCodeUtil.qqStr(R.string.b3j));
                return;
            }
            bl a16 = new bl.a(uh()).b(this.f242131j0).f(ri5).g(this.f242133l0).d(this.K.getIntent().getStringExtra("appid")).c(Eh()).h(Gh()).e(Fh()).a();
            QLog.i("PhoneNumLoginFragment.TAG", 1, "startPhoneSmsLogin");
            al.b(5).login(this.K, a16, wh(), th(5));
            return;
        }
        QLog.e("PhoneNumLoginFragment.TAG", 1, "mCountryCode=" + this.f242131j0 + " phoneNum=" + ri5);
        showToast(HardCodeUtil.qqStr(R.string.c68));
    }

    private void Ni() {
        if (ViewUtils.getScreenWidthByContext(BaseApplication.getContext()) >= ViewUtils.dip2px(340.0f)) {
            this.R.setPadding(ViewUtils.dpToPx(16.0f), 0, 0, 0);
        } else {
            this.R.setPadding(ViewUtils.dpToPx(6.0f), 0, 0, 0);
        }
    }

    private void Oi() {
        this.R.setText(Marker.ANY_NON_NULL_MARKER + this.f242131j0);
        Ni();
        this.R.setContentDescription(Marker.ANY_NON_NULL_MARKER + this.f242131j0 + this.f242132k0);
        updateLoginBtnAndPasswordEditTextStatus();
        AccessibilityUtil.c(this.N, Marker.ANY_NON_NULL_MARKER + this.f242131j0, Button.class.getName());
    }

    private void Pi() {
        if (FontSettingManager.getFontLevel() >= 17.0f) {
            if (FontSettingManager.getFontLevel() >= 20.0f) {
                this.S.setPadding(ViewUtils.dpToPx(68.0f), 0, ViewUtils.dpToPx(16.0f), 0);
            } else {
                this.S.setPadding(ViewUtils.dpToPx(48.0f), 0, ViewUtils.dpToPx(16.0f), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qi(boolean z16) {
        if (z16) {
            PastablePwdEditText pastablePwdEditText = this.U;
            pastablePwdEditText.setSelection(pastablePwdEditText.length());
            if (z.c() && this.f242124c0.isActive(this.U)) {
                this.f242124c0.showSoftInput(this.U, 2);
            }
        }
        this.U.setHint(R.string.f211345kk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ri() {
        if (this.U.isFocused()) {
            this.V.setVisibility(0);
        } else {
            this.V.setVisibility(8);
        }
        if (this.f242125d0) {
            this.U.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.V.setImageResource(R.drawable.qui_eye_on_secondary_01_selector);
            this.V.setContentDescription(HardCodeUtil.qqStr(R.string.f211245ka));
        } else {
            this.U.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.V.setImageResource(R.drawable.qui_eye_off_secondary_01_selector);
            this.V.setContentDescription(HardCodeUtil.qqStr(R.string.f211415kr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Si(boolean z16) {
        if (z16) {
            ConfigClearableEditText configClearableEditText = this.S;
            configClearableEditText.setSelection(configClearableEditText.length());
            if (z.c() && this.f242124c0.isActive(this.S)) {
                this.f242124c0.showSoftInput(this.S, 2);
            }
            this.S.setHint("");
            return;
        }
        this.S.setHint(R.string.f211285ke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ti() {
        if (this.S == null) {
            return;
        }
        if (TextUtils.isEmpty(ri())) {
            this.S.setTextSize(17.0f);
        } else {
            this.S.setTextSize(20.0f);
        }
    }

    private String getInputPassword() {
        PastablePwdEditText pastablePwdEditText = this.U;
        if (pastablePwdEditText != null) {
            return pastablePwdEditText.getText().toString();
        }
        return "";
    }

    private void initPasswordArea() {
        this.f242125d0 = false;
        this.W.setOnClickListener(this);
        this.U.setCustomClearButtonCallback(new b(ViewUtils.dpToPx(43.0f)));
        this.U.setContentDescription(this.K.getString(R.string.f211465kw));
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                View.class.getMethod("setImportantForAutofill", Integer.TYPE).invoke(this.U, 8);
            } catch (Exception e16) {
                QLog.w("PhoneNumLoginFragment.TAG", 2, "disable auto fill error", e16);
            }
        }
        this.U.addTextChangedListener(this.f242136o0);
        this.U.setOnFocusChangeListener(this.f242137p0);
        this.U.setLongClickable(true);
        this.V.setOnClickListener(this);
        this.V.setVisibility(8);
        this.U.setTextClearedListener(this);
        Ri();
        Qi(false);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initViews(View view) {
        this.L = (RelativeLayout) view.findViewById(R.id.f2441092);
        this.M = view.findViewById(R.id.f2440091);
        this.N = (LinearLayout) view.findViewById(R.id.tra);
        this.P = (RelativeLayout) view.findViewById(R.id.f2439090);
        this.S = (ConfigClearableEditText) view.findViewById(R.id.f243808z);
        this.Q = (ImageView) view.findViewById(R.id.u_7);
        this.R = (TextView) view.findViewById(R.id.u_8);
        this.f242134m0 = (ImageView) view.findViewById(R.id.f243708y);
        this.T = (RelativeLayout) view.findViewById(R.id.f226604b);
        this.U = (PastablePwdEditText) view.findViewById(R.id.f226504a);
        this.V = (ImageView) view.findViewById(R.id.fiu);
        this.W = (ImageView) view.findViewById(R.id.fis);
        this.X = (LinearLayout) view.findViewById(R.id.yug);
        this.Y = (QUICheckBox) view.findViewById(R.id.yue);
        this.f242122a0 = (QUIButton) view.findViewById(R.id.f166147yu4);
        this.Z = (TextView) view.findViewById(R.id.f86604s4);
        this.f242123b0 = (LoginPageBottomMoreActionsView) view.findViewById(R.id.zea);
        this.f242124c0 = (InputMethodManager) this.K.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.M.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.login.fragment.p
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean Fi;
                Fi = PhoneNumLoginFragment.this.Fi(view2, motionEvent);
                return Fi;
            }
        });
        ti();
        initPasswordArea();
        this.f242122a0.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        si();
        if (this.K.getIntent().getBooleanExtra("key_second_state", false)) {
            oi();
        } else {
            ni();
        }
        Pi();
        updateLoginBtnAndPasswordEditTextStatus();
        this.P.post(new Runnable() { // from class: com.tencent.mobileqq.login.fragment.q
            @Override // java.lang.Runnable
            public final void run() {
                PhoneNumLoginFragment.this.Gi();
            }
        });
        if (AppSetting.f99565y) {
            this.S.setAccessibilityTraversalBefore(R.id.yue);
            this.Y.setAccessibilityTraversalBefore(R.id.yuh);
        }
    }

    private void ni() {
        ui();
        this.f242126e0 = true;
        this.T.setVisibility(4);
        this.Z.setVisibility(4);
        this.S.setEnabled(true);
        this.S.setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary));
        this.S.setAlpha(1.0f);
        this.R.setEnabled(true);
        this.R.setAlpha(1.0f);
        this.R.setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary));
        this.Q.setEnabled(true);
        this.Q.setAlpha(1.0f);
        this.Q.setImageResource(R.drawable.qui_chevron_down);
        this.N.setEnabled(true);
        this.f242122a0.setText(HardCodeUtil.qqStr(R.string.f200044r2));
    }

    private void oi() {
        this.f242126e0 = false;
        this.X.setVisibility(8);
        this.T.setVisibility(0);
        this.Z.setVisibility(0);
        this.S.setEnabled(false);
        this.S.setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary));
        this.S.setAlpha(0.7f);
        this.R.setEnabled(false);
        this.R.setAlpha(0.5f);
        this.Q.setEnabled(false);
        this.Q.setAlpha(0.5f);
        this.N.setEnabled(false);
        this.f242122a0.setText(HardCodeUtil.qqStr(R.string.f199904qo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi() {
        this.S.clearFocus();
        this.U.clearFocus();
        this.U.setClearButtonVisible(false);
        this.f242124c0.hideSoftInputFromWindow(this.K.getWindow().getDecorView().getWindowToken(), 0);
    }

    private void qi() {
        if (this.f242128g0) {
            this.f242128g0 = false;
            Ki();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ri() {
        ConfigClearableEditText configClearableEditText = this.S;
        if (configClearableEditText != null) {
            return configClearableEditText.getText().toString();
        }
        return "";
    }

    private void showToast(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.fragment.o
            @Override // java.lang.Runnable
            public final void run() {
                PhoneNumLoginFragment.this.Hi(str);
            }
        });
    }

    private void si() {
        LoginPageBottomMoreActionsView.b bVar = new LoginPageBottomMoreActionsView.b();
        bVar.f242764d = new View.OnClickListener() { // from class: com.tencent.mobileqq.login.fragment.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneNumLoginFragment.this.Bi(view);
            }
        };
        bVar.f242766f = new c();
        Bundle bundle = new Bundle();
        bVar.f242767g = bundle;
        bundle.putString(AuthDevOpenUgActivity.KEY_PHONE_NUM, "");
        bVar.f242767g.putBoolean("key_second_state", false);
        boolean booleanExtra = this.K.getIntent().getBooleanExtra("key_from_wx_login", false);
        bVar.f242767g.putBoolean("key_from_wx_login", booleanExtra);
        bVar.f242761a = booleanExtra;
        this.f242123b0.I(this, bVar);
    }

    private void ti() {
        this.f242131j0 = this.K.getIntent().getStringExtra("country_code");
        QLog.d("PhoneNumLoginFragment.TAG", 1, "context countryCode:" + this.f242131j0);
        if (TextUtils.isEmpty(this.f242131j0)) {
            this.f242131j0 = PhoneCodeUtils.b(this.K);
            com.tencent.mobileqq.util.s.f306795a.c(1, new com.tencent.mobileqq.util.q() { // from class: com.tencent.mobileqq.login.fragment.r
                @Override // com.tencent.mobileqq.util.q
                public final void onResult(String str, String str2) {
                    PhoneNumLoginFragment.this.Ci(str, str2);
                }
            });
        } else {
            Oi();
        }
        this.N.setOnClickListener(this);
        this.f242134m0.setOnClickListener(this);
        AccessibilityUtil.c(this.f242134m0, this.K.getString(R.string.f200144rb), Button.class.getName());
        String stringExtra = this.K.getIntent().getStringExtra(AuthDevOpenUgActivity.KEY_PHONE_NUM);
        this.S.setText(stringExtra);
        if (TextUtils.isEmpty(stringExtra)) {
            this.S.setTextSize(17.0f);
        }
        this.S.addTextChangedListener(this.f242135n0);
        this.S.setOnFocusChangeListener(this.f242137p0);
        this.S.setContentDescription(this.K.getString(R.string.f211285ke));
        this.S.setFocusable(true);
        this.S.setFocusableInTouchMode(true);
        this.S.setCustomClearButtonCallback(this);
        this.S.setNeedContextMenu(true);
        Si(false);
        this.f242129h0 = this.K.getIntent().getStringExtra("uin");
    }

    private void ui() {
        if (uh() == 16) {
            this.Y.setChecked(true);
            this.X.setVisibility(8);
            return;
        }
        this.Y.setChecked(false);
        this.X.setVisibility(0);
        this.Y.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.fragment.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneNumLoginFragment.this.Di(view);
            }
        });
        PrivacyPolicyHelper.expandCheckBoxTouchDelegate(this.Y);
        PrivacyPolicyHelper.initPrivacyPolicyTextView((TextView) this.L.findViewById(R.id.yuh), com.tencent.mobileqq.util.l.c(), com.tencent.mobileqq.util.l.b(this.Y));
        this.X.post(new Runnable() { // from class: com.tencent.mobileqq.login.fragment.u
            @Override // java.lang.Runnable
            public final void run() {
                PhoneNumLoginFragment.this.Ei();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoginBtnAndPasswordEditTextStatus() {
        boolean z16;
        this.f242130i0 = this.S.getText().toString();
        if (xi()) {
            if (zi(this.f242131j0)) {
                this.f242122a0.setText(this.K.getString(R.string.f200044r2));
            } else {
                this.f242122a0.setText(this.K.getString(R.string.f200694st));
            }
            Ji(LoginUtil.f306390a.q(this.f242131j0, this.f242130i0));
            return;
        }
        if (LoginUtil.f306390a.q(this.f242131j0, this.f242130i0) && this.U.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Ji(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePasswordTextSize() {
        if (this.U == null) {
            return;
        }
        if (TextUtils.isEmpty(getInputPassword())) {
            this.U.setTextSize(17.0f);
        } else {
            this.U.setTextSize(20.0f);
        }
    }

    private boolean vi() {
        QUICheckBox qUICheckBox = this.Y;
        if (qUICheckBox != null && !qUICheckBox.isChecked()) {
            return false;
        }
        return true;
    }

    private boolean wi() {
        QBaseActivity qBaseActivity = this.K;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yi() {
        String str;
        String ri5 = ri();
        GetLocalPhone$MaskPhoneData mMaskPhoneData = aj.f306554f.getMMaskPhoneData();
        if (mMaskPhoneData != null) {
            str = mMaskPhoneData.str_mask_phone.get();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(ri5) && str != null) {
            return l.f242160a.n(ri5, str);
        }
        return false;
    }

    private boolean zi(String str) {
        return TextUtils.equals(str, "86");
    }

    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
    public void Af(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        ImageView imageView = this.f242134m0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.e
    public void E0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        libsafeedit.clearPassBuffer();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            peekAppRuntime.stopPCActivePolling("clearPassInput");
        }
    }

    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
    public void Mg(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment
    public void Ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QUIButton qUIButton = this.f242122a0;
        if (qUIButton != null && qUIButton.m()) {
            this.f242122a0.s();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 100 && i16 == -1 && intent != null) {
            this.f242131j0 = intent.getStringExtra("k_code");
            this.f242132k0 = intent.getStringExtra("k_name");
            if (TextUtils.isEmpty(this.f242131j0)) {
                this.f242131j0 = "86";
                this.f242132k0 = HardCodeUtil.qqStr(R.string.fyo);
            }
            Oi();
            com.tencent.mobileqq.util.s.f306795a.b();
            QLog.d("PhoneNumLoginFragment.TAG", 4, "mCountryCode=" + this.f242131j0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (QLog.isDevelopLevel()) {
                QLog.d("PhoneNumLoginFragment.TAG", 4, "onClick id=" + id5);
            }
            if (id5 == R.id.tra) {
                Intent intent = new Intent(this.K, (Class<?>) NewStyleCountryActivity.class);
                intent.putExtra("k_code", this.f242131j0);
                intent.putExtra("k_name", this.f242132k0);
                startActivityForResult(intent, 100);
                if (getActivity() != null) {
                    getActivity().overridePendingTransition(R.anim.f154454a3, R.anim.f154550b4);
                }
            } else if (id5 == R.id.f166147yu4) {
                if (xi()) {
                    ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800C40F", "0X800C40F", uh(), 0, "", "", com.tencent.mobileqq.statistics.o.c(), "");
                    if (!LoginUtil.f306390a.q(this.f242131j0, ri())) {
                        showToast(HardCodeUtil.qqStr(R.string.f174022uq));
                    } else if (!vi()) {
                        com.tencent.mobileqq.util.l.f(getContext(), this.X);
                    } else {
                        pi();
                        if (zi(this.f242131j0)) {
                            Ai();
                        } else {
                            Mi();
                        }
                    }
                } else {
                    ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800C410", "0X800C410", uh(), 0, "", "", com.tencent.mobileqq.statistics.o.c(), "");
                    Ki();
                }
            } else if (id5 == R.id.fiu) {
                this.f242125d0 = !this.f242125d0;
                Ri();
                PastablePwdEditText pastablePwdEditText = this.U;
                pastablePwdEditText.setSelection(pastablePwdEditText.length());
            } else if (id5 == R.id.fis) {
                this.U.h();
            } else if (id5 == R.id.f86604s4) {
                ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800C411", "0X800C411", uh(), 0, "", "", com.tencent.mobileqq.statistics.o.c(), "");
                pi();
                Mi();
            } else if (id5 == R.id.f243708y) {
                this.S.h();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        Ii();
        Ni();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("PhoneNumLoginFragment.TAG", 2, "onCreateView");
            }
            inflate = layoutInflater.inflate(R.layout.fgg, viewGroup, false);
            this.K = getQBaseActivity();
            initViews(inflate);
            this.f242127f0 = new a();
            if (!wi()) {
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("com.tencent.mobileqq.InvitationWebViewPlugin.autoLogin");
                    intentFilter.addAction("com.tencent.mobileqq.login.autoPhoneLogin");
                    intentFilter.addAction("com.tencent.mobileqq.login.autoSmsLogin");
                    this.K.registerReceiver(this.f242127f0, intentFilter);
                } catch (Exception e16) {
                    QLog.e("PhoneNumLoginFragment.TAG", 1, "registerAutoLoginReceiver error ", e16);
                }
            }
            this.f242133l0 = this.K.getIntent().getStringExtra("uin");
            int uh5 = uh();
            if (xi()) {
                str = "0X800B104";
            } else {
                str = "0X800C2D7";
            }
            String str2 = str;
            Ii();
            ReportController.r(getAppRuntime(), "dc00898", "", "", str2, str2, uh5, 0, "", "", com.tencent.mobileqq.statistics.o.c(), "");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        BroadcastReceiver broadcastReceiver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroyView();
        QBaseActivity qBaseActivity = this.K;
        if (qBaseActivity != null && (broadcastReceiver = this.f242127f0) != null) {
            try {
                qBaseActivity.unregisterReceiver(broadcastReceiver);
            } catch (Exception e16) {
                QLog.e("PhoneNumLoginFragment.TAG", 1, "unregisterAutoLoginReceiver error ", e16);
            }
        }
        this.f242127f0 = null;
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhoneNumLoginFragment.TAG", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        super.onPause();
        if (z.c()) {
            this.f242124c0.hideSoftInputFromWindow(this.K.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhoneNumLoginFragment.TAG", 2, "onResume");
        }
        super.onResume();
        pi();
        qi();
    }

    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
    public void v2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
    public int w9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean xi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f242126e0;
    }
}
