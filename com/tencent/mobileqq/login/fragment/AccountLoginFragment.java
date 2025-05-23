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
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.login.al;
import com.tencent.mobileqq.login.ay;
import com.tencent.mobileqq.login.bl;
import com.tencent.mobileqq.login.c;
import com.tencent.mobileqq.login.relogin.dialog.AccountManagerComponent;
import com.tencent.mobileqq.login.widget.LoginPageBottomMoreActionsView;
import com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.mobileqq.util.aj;
import com.tencent.mobileqq.util.at;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.login.GatewayVerify$ReqBody;
import tencent.im.login.GetLocalPhone$MaskPhoneData;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AccountLoginFragment extends BaseLoginFragment implements View.OnClickListener, ConfigClearableEditText.e {
    static IPatchRedirector $redirector_;
    private QBaseActivity K;
    private RelativeLayout L;
    private View M;
    private AutoCompleteTextView N;
    private NewStyleDropdownView P;
    private ImageView Q;
    private PastablePwdEditText R;
    private ImageView S;
    private ImageView T;
    private LinearLayout U;
    private QUICheckBox V;
    private QUIButton W;
    private LoginPageBottomMoreActionsView X;
    private int Y;
    private InputMethodManager Z;

    /* renamed from: a0, reason: collision with root package name */
    private List<com.tencent.mobileqq.login.account.a> f242103a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f242104b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f242105c0;

    /* renamed from: d0, reason: collision with root package name */
    public BroadcastReceiver f242106d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f242107e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f242108f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f242109g0;

    /* renamed from: h0, reason: collision with root package name */
    private final View.OnClickListener f242110h0;

    /* renamed from: i0, reason: collision with root package name */
    private final TextWatcher f242111i0;

    /* renamed from: j0, reason: collision with root package name */
    private final TextWatcher f242112j0;

    /* renamed from: k0, reason: collision with root package name */
    private final View.OnFocusChangeListener f242113k0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountLoginFragment.this);
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
            QLog.d("AccountLoginFragment.TAG", 1, "AutoLoginReceiver onReceive, action=" + action + ", isResumed = " + AccountLoginFragment.this.isResumed());
            if ("com.tencent.mobileqq.InvitationWebViewPlugin.autoLogin".equals(action)) {
                if (intent.getIntExtra("loginFragmentType", 0) == 5 && !((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).isLoggingIn()) {
                    ((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).reportWebNotifyFinishVerify(MobileQQ.sMobileQQ.peekAppRuntime(), Integer.valueOf(AccountLoginFragment.this.uh()), AccountLoginFragment.this.ti());
                    AccountLoginFragment.this.f242105c0 = true;
                    return;
                }
                return;
            }
            if ("com.tencent.mobileqq.login.autoPhoneLogin".equals(action)) {
                if (AccountLoginFragment.this.isResumed() && AccountLoginFragment.this.Ci()) {
                    if (!AccountLoginFragment.this.Bi()) {
                        AccountLoginFragment.this.Ri();
                        return;
                    } else {
                        AccountLoginFragment.this.Hh(3, null, false);
                        return;
                    }
                }
                return;
            }
            if ("com.tencent.mobileqq.login.autoSmsLogin".equals(action) && AccountLoginFragment.this.isResumed() && AccountLoginFragment.this.Ci()) {
                AccountLoginFragment.this.Ri();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements ConfigClearableEditText.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountLoginFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void Af(boolean z16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ImageView imageView = AccountLoginFragment.this.T;
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
                AccountLoginFragment.this.T.setAlpha(0.5f);
            } else {
                AccountLoginFragment.this.T.setAlpha(1.0f);
            }
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void v2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                AccountLoginFragment.this.T.setAlpha(1.0f);
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
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements LoginPageBottomMoreActionsView.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountLoginFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.login.widget.LoginPageBottomMoreActionsView.a
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (AccountLoginFragment.this.V != null) {
                return AccountLoginFragment.this.V.isChecked();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.login.widget.LoginPageBottomMoreActionsView.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AccountLoginFragment.this.ri();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountLoginFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (AccountLoginFragment.this.Q != null && AccountLoginFragment.this.Q.isShown()) {
                    AccountLoginFragment.this.Q.setVisibility(8);
                }
                AccountLoginFragment.this.N.setText("");
                AccountLoginFragment.this.R.setText("");
                AccountLoginFragment.this.updateLoginBtnAndPasswordEditTextStatus();
                libsafeedit.clearPassBuffer();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e implements TextWatcher {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountLoginFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            QLog.d("AccountLoginFragment.TAG", 1, "afterTextChanged mUinEditText");
            AccountLoginFragment.this.updateLoginBtnAndPasswordEditTextStatus();
            AccountLoginFragment.this.Vi();
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
                return;
            }
            QLog.d("AccountLoginFragment.TAG", 1, "onTextChanged mUinEditText");
            String charSequence2 = charSequence.toString();
            if (AccountLoginFragment.this.Q != null && AccountLoginFragment.this.N != null) {
                if (charSequence2.length() > 0) {
                    AccountLoginFragment.this.Q.setVisibility(0);
                } else {
                    AccountLoginFragment.this.Q.setVisibility(8);
                }
            }
            AccountLoginFragment.this.Si(AccountLoginFragment.this.ui(charSequence2));
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class f implements TextWatcher {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountLoginFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            QLog.d("AccountLoginFragment.TAG", 2, "afterTextChanged mPasswordEditText");
            AccountLoginFragment.this.updateLoginBtnAndPasswordEditTextStatus();
            AccountLoginFragment.this.updatePasswordTextSize();
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
            } else {
                QLog.d("AccountLoginFragment.TAG", 2, "onTextChanged mPasswordEditText");
                AccountLoginFragment.this.updatePwdStates();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class g implements View.OnFocusChangeListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountLoginFragment.this);
            }
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
                return;
            }
            if (view == AccountLoginFragment.this.N) {
                QLog.d("AccountLoginFragment.TAG", 1, "mUinEditText onFocusChange hasFocus=" + z16);
                if (z16) {
                    AccountLoginFragment.this.N.setSelection(AccountLoginFragment.this.N.length());
                    if (AccountLoginFragment.this.N.isPopupShowing()) {
                        AccountLoginFragment.this.N.dismissDropDown();
                    }
                    if (AccountLoginFragment.this.Q != null && AccountLoginFragment.this.N.getText().length() > 0) {
                        AccountLoginFragment.this.Q.setVisibility(0);
                    }
                    AccountLoginFragment.this.N.setSelection(AccountLoginFragment.this.N.getText().length());
                    AccountLoginFragment.this.N.setHint("");
                    return;
                }
                if (AccountLoginFragment.this.Q != null && AccountLoginFragment.this.Q.isShown()) {
                    AccountLoginFragment.this.Q.setVisibility(8);
                }
                AccountLoginFragment.this.Ni();
                return;
            }
            if (view == AccountLoginFragment.this.R) {
                QLog.d("AccountLoginFragment.TAG", 1, "mPasswordEditText onFocusChange hasFocus=" + z16);
                AccountLoginFragment.this.updatePwdStates();
                if (!z16) {
                    AccountLoginFragment.this.showPasswordEditTextHint();
                    return;
                }
                AccountLoginFragment.this.R.setSelection(AccountLoginFragment.this.R.length());
                if (z.c() && AccountLoginFragment.this.Z.isActive(AccountLoginFragment.this.R)) {
                    AccountLoginFragment.this.Z.showSoftInput(AccountLoginFragment.this.R, 2);
                }
                AccountLoginFragment.this.R.setHint("");
            }
        }
    }

    public AccountLoginFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.Y = 1;
        this.f242104b0 = false;
        this.f242105c0 = false;
        this.f242110h0 = new d();
        this.f242111i0 = new e();
        this.f242112j0 = new f();
        this.f242113k0 = new g();
    }

    private boolean Ai(String str) {
        if (str != null && str.trim().length() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bi() {
        String str;
        String ti5 = ti();
        GetLocalPhone$MaskPhoneData mMaskPhoneData = aj.f306554f.getMMaskPhoneData();
        if (mMaskPhoneData != null) {
            str = mMaskPhoneData.str_mask_phone.get();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(ti5) && str != null) {
            return l.f242160a.n(ti5, str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ci() {
        String ti5 = ti();
        if (!TextUtils.isEmpty(ti5) && LoginUtil.f306390a.q("86", ti5)) {
            return true;
        }
        return false;
    }

    private boolean Di(String str, String str2) {
        if (Ai(str) && TextUtils.isEmpty(str2)) {
            Oi(HardCodeUtil.qqStr(R.string.f172152po));
            return true;
        }
        if (Ai(str)) {
            Oi(HardCodeUtil.qqStr(R.string.clh));
            return true;
        }
        if (str.startsWith("0")) {
            Oi(HardCodeUtil.qqStr(R.string.bzh));
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            Li(HardCodeUtil.qqStr(R.string.cqq));
            return true;
        }
        if (!yi()) {
            com.tencent.mobileqq.util.l.f(getContext(), this.U);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ei(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        z.t(getQBaseActivity(), ti());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ri();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Gi(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            QLog.d("AccountLoginFragment.TAG", 1, "mContentLayout.setOnTouch ACTION_DOWN");
            ri();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hi(String str) {
        QQToast.makeText(this.K, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ii() {
        this.P.f(false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ji(com.tencent.mobileqq.login.account.a aVar) {
        this.P.f(true, aVar.f());
    }

    private void Ki() {
        if (z.b(this.K)) {
            z.y(this.M);
        } else {
            z.A(this.M);
        }
    }

    private void Li(String str) {
        showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mi() {
        LoginUtil.t(this.V, "key_main_login_tips_shown");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ni() {
        int i3;
        int i16 = this.Y;
        if (i16 == 1) {
            i3 = R.string.f200414s2;
        } else if (i16 == 2) {
            i3 = R.string.f200404s1;
        } else {
            i3 = R.string.f199924qq;
        }
        this.N.setHint(i3);
    }

    private void Oi(String str) {
        showToast(str);
    }

    private void Pi() {
        boolean z16;
        GatewayVerify$ReqBody b16;
        com.tencent.mobileqq.login.c r16;
        QLog.d("AccountLoginFragment.TAG", 1, "startAccountLogin");
        String ti5 = ti();
        String inputPassword = getInputPassword();
        if (Di(ti5, inputPassword)) {
            return;
        }
        if (!Fh() && z.k(ti5)) {
            new AccountManagerComponent().y(this.K);
            QLog.d("AccountLoginFragment.TAG", 1, "startAccountLogin hasReachLoginAccountLimit");
            return;
        }
        if (this.K.getAppRuntime() == null) {
            QLog.e("AccountLoginFragment.TAG", 1, "startAccountLogin appRuntime is null");
            return;
        }
        ri();
        at.f306599a = true;
        Qi();
        byte[] byteSafeEditTextToMD5 = libsafeedit.byteSafeEditTextToMD5(Boolean.TRUE);
        if (LoginUtil.f306390a.q("86", ti5) && !MobileQQ.sMobileQQ.isLoginByNT()) {
            QLog.d("AccountLoginFragment.TAG", 1, "startAccountLogin login by phoneNum and pwd");
            al.b(7).login(this.K, new ay.a(ti5, "86", byteSafeEditTextToMD5, uh()).m(Gh()).l(Fh()).o(this.K.getIntent().getStringExtra("appid")).n(Eh()).k(), wh(), th(7));
            return;
        }
        QLog.d("AccountLoginFragment.TAG", 1, "startAccountLogin login by uin and pwd");
        if (Fh()) {
            Bundle bundle = new Bundle();
            bundle.putInt(AppConstants.Key.KEY_PUZZLE_VERIFY_CODE, 130);
            bundle.putByteArray(AppConstants.Key.KEY_CONNECT_DATA, com.tencent.open.agent.util.g.u(this.K.getIntent().getStringExtra("appid")));
            r16 = new c.a(3, uh(), ti5, inputPassword).D(64).x(bundle).B(byteSafeEditTextToMD5).r();
        } else if (Gh()) {
            r16 = new c.a(2, uh(), ti5, inputPassword).A(LoginUtil.b()).B(byteSafeEditTextToMD5).v(true).r();
        } else {
            if (this.f242107e0 && !TextUtils.isEmpty(ti5) && !TextUtils.isEmpty(this.f242109g0)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                b16 = LoginUtil.c(this.f242109g0);
            } else {
                b16 = LoginUtil.b();
            }
            r16 = new c.a(1, uh(), ti5, inputPassword).B(byteSafeEditTextToMD5).A(b16).u(z16).w(Eh()).s(this.f242109g0).r();
        }
        al.b(r16.f242200a).login(this.K, r16, wh(), th(r16.f242200a));
    }

    private void Qi() {
        QUIButton qUIButton = this.W;
        if (qUIButton != null && !qUIButton.m()) {
            this.W.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ri() {
        if (!Ci()) {
            QLog.w("AccountLoginFragment.TAG", 1, "input account is not phone num, can not sms login");
            return;
        }
        String ti5 = ti();
        QLog.i("AccountLoginFragment.TAG", 1, "startPhoneSmsLogin");
        al.b(5).login(this.K, new bl.a(uh()).b("86").f(ti5).d(this.K.getIntent().getStringExtra("appid")).c(Eh()).h(Gh()).e(Fh()).a(), wh(), th(5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Si(final com.tencent.mobileqq.login.account.a aVar) {
        if (zi()) {
            return;
        }
        if (aVar == null) {
            this.P.post(new Runnable() { // from class: com.tencent.mobileqq.login.fragment.c
                @Override // java.lang.Runnable
                public final void run() {
                    AccountLoginFragment.this.Ii();
                }
            });
        } else {
            this.P.post(new Runnable() { // from class: com.tencent.mobileqq.login.fragment.d
                @Override // java.lang.Runnable
                public final void run() {
                    AccountLoginFragment.this.Ji(aVar);
                }
            });
        }
    }

    private void Ti() {
        if (FontSettingManager.getFontLevel() >= 20.0f) {
            this.N.setPadding(ViewUtils.dpToPx(50.0f), 0, ViewUtils.dpToPx(40.0f), 0);
        }
    }

    private void Ui() {
        boolean z16;
        if (this.f242107e0 && !TextUtils.isEmpty(this.f242108f0)) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.N.setFocusable(z16);
        this.N.setFocusableInTouchMode(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vi() {
        if (this.N == null) {
            return;
        }
        if (TextUtils.isEmpty(ti())) {
            this.N.setTextSize(17.0f);
        } else {
            this.N.setTextSize(20.0f);
        }
    }

    private String getInputPassword() {
        PastablePwdEditText pastablePwdEditText = this.R;
        if (pastablePwdEditText != null) {
            return pastablePwdEditText.getText().toString();
        }
        return "";
    }

    private void initPasswordArea() {
        this.T.setOnClickListener(this);
        this.R.setCustomClearButtonCallback(new b());
        this.R.setHintTextColor(getResources().getColor(R.color.qui_common_text_tertiary));
        showPasswordEditTextHint();
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                View.class.getMethod("setImportantForAutofill", Integer.TYPE).invoke(this.R, 8);
            } catch (Exception e16) {
                QLog.w("AccountLoginFragment.TAG", 2, "disable auto fill error", e16);
            }
        }
        this.R.addTextChangedListener(this.f242112j0);
        this.R.setOnFocusChangeListener(this.f242113k0);
        this.R.setLongClickable(true);
        this.S.setOnClickListener(this);
        updatePwdStates();
        this.R.setTextClearedListener(this);
        this.P.f(false, null);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initViews(View view) {
        this.L = (RelativeLayout) view.findViewById(R.id.s89);
        this.M = view.findViewById(R.id.s88);
        NewStyleDropdownView newStyleDropdownView = (NewStyleDropdownView) view.findViewById(R.id.f113876rt);
        this.P = newStyleDropdownView;
        this.N = newStyleDropdownView.c();
        this.R = (PastablePwdEditText) view.findViewById(R.id.f226504a);
        this.T = (ImageView) view.findViewById(R.id.fis);
        this.S = (ImageView) view.findViewById(R.id.fiu);
        this.U = (LinearLayout) view.findViewById(R.id.yug);
        this.V = (QUICheckBox) view.findViewById(R.id.yue);
        this.W = (QUIButton) view.findViewById(R.id.f166147yu4);
        this.X = (LoginPageBottomMoreActionsView) view.findViewById(R.id.zea);
        this.Z = (InputMethodManager) this.K.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        xi();
        initPasswordArea();
        this.W.setContentDescription(getString(R.string.f211455kv));
        this.W.setOnClickListener(this);
        vi();
        this.M.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.login.fragment.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean Gi;
                Gi = AccountLoginFragment.this.Gi(view2, motionEvent);
                return Gi;
            }
        });
        wi();
        Ti();
        updateLoginBtnAndPasswordEditTextStatus();
        if (AppSetting.f99565y) {
            this.N.setAccessibilityTraversalBefore(R.id.f226504a);
            this.R.setAccessibilityTraversalBefore(R.id.yue);
            this.V.setAccessibilityTraversalBefore(R.id.yuh);
        }
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).loginTouchEvent(null, com.tencent.mobileqq.dt.api.c.I, this.N);
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).loginTouchEvent(null, com.tencent.mobileqq.dt.api.c.K, this.R);
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).loginTouchEvent(null, com.tencent.mobileqq.dt.api.c.M, this.V);
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).loginTouchEvent(null, com.tencent.mobileqq.dt.api.c.O, this.W);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri() {
        this.N.clearFocus();
        this.N.dismissDropDown();
        this.R.clearFocus();
        this.R.setClearButtonVisible(false);
        this.Q.setVisibility(8);
        this.Z.hideSoftInputFromWindow(this.K.getWindow().getDecorView().getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPasswordEditTextHint() {
        this.R.setContentDescription(this.K.getString(R.string.f211465kw));
        this.R.setHint(R.string.f211345kk);
    }

    private void showToast(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.fragment.h
            @Override // java.lang.Runnable
            public final void run() {
                AccountLoginFragment.this.Hi(str);
            }
        });
    }

    private void si() {
        if (this.f242105c0) {
            this.f242105c0 = false;
            Pi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ti() {
        AutoCompleteTextView autoCompleteTextView = this.N;
        if (autoCompleteTextView != null) {
            return autoCompleteTextView.getText().toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoginBtnAndPasswordEditTextStatus() {
        String ti5 = ti();
        String inputPassword = getInputPassword();
        if (!TextUtils.isEmpty(ti5) && !TextUtils.isEmpty(inputPassword)) {
            this.W.o();
        } else {
            this.W.setBackgroundDisabled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePasswordTextSize() {
        if (this.R == null) {
            return;
        }
        if (TextUtils.isEmpty(getInputPassword())) {
            this.R.setTextSize(17.0f);
        } else {
            this.R.setTextSize(20.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePwdStates() {
        if (this.R.isFocused()) {
            this.S.setVisibility(0);
        } else {
            this.S.setVisibility(8);
        }
        if (this.f242104b0) {
            this.R.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.S.setImageResource(R.drawable.qui_eye_on_secondary_01_selector);
            this.S.setContentDescription(HardCodeUtil.qqStr(R.string.f211245ka));
        } else {
            this.R.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.S.setImageResource(R.drawable.qui_eye_off_secondary_01_selector);
            this.S.setContentDescription(HardCodeUtil.qqStr(R.string.f211415kr));
        }
    }

    private void vi() {
        boolean z16;
        LoginPageBottomMoreActionsView.b bVar = new LoginPageBottomMoreActionsView.b();
        bVar.f242764d = new View.OnClickListener() { // from class: com.tencent.mobileqq.login.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountLoginFragment.this.Ei(view);
            }
        };
        bVar.f242766f = new c();
        Bundle bundle = new Bundle();
        bVar.f242767g = bundle;
        boolean z17 = false;
        if (this.f242107e0) {
            bundle.putBoolean("is_need_login_with_mask", false);
            bVar.f242767g.putString("uinMask", "");
            bVar.f242767g.putString("uinEncrpyt", "");
        }
        boolean booleanExtra = this.K.getIntent().getBooleanExtra("key_from_wx_login", false);
        bVar.f242767g.putBoolean("key_from_wx_login", booleanExtra);
        bVar.f242761a = booleanExtra;
        int i3 = this.Y;
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        bVar.f242762b = z16;
        if (i3 == 2) {
            z17 = true;
        }
        bVar.f242763c = z17;
        this.X.I(this, bVar);
    }

    private void wi() {
        if (uh() == 16) {
            this.V.setChecked(true);
            this.U.setVisibility(4);
            return;
        }
        this.V.setChecked(false);
        this.U.setVisibility(0);
        this.V.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountLoginFragment.this.Fi(view);
            }
        });
        PrivacyPolicyHelper.expandCheckBoxTouchDelegate(this.V);
        PrivacyPolicyHelper.initPrivacyPolicyTextView((TextView) this.L.findViewById(R.id.yuh), com.tencent.mobileqq.util.l.c(), com.tencent.mobileqq.util.l.b(this.V));
        this.U.post(new Runnable() { // from class: com.tencent.mobileqq.login.fragment.f
            @Override // java.lang.Runnable
            public final void run() {
                AccountLoginFragment.this.Mi();
            }
        });
    }

    private void xi() {
        this.N.setContentDescription(this.K.getString(R.string.f211425ks));
        this.N.setPadding(ViewUtils.dip2px(40.0f), 0, ViewUtils.dip2px(40.0f), 0);
        this.P.setHeadBorder(R.drawable.nou);
        this.N.setOnFocusChangeListener(this.f242113k0);
        this.N.setTextColor(ContextCompat.getColorStateList(this.K, R.color.qui_common_text_primary));
        this.N.setHintTextColor(ContextCompat.getColorStateList(this.K, R.color.qui_common_text_tertiary));
        this.N.addTextChangedListener(this.f242111i0);
        String stringExtra = this.K.getIntent().getStringExtra("uin");
        if (this.f242107e0 && !TextUtils.isEmpty(this.f242108f0)) {
            this.N.setText(this.f242108f0);
        } else if (LoginUtil.p(stringExtra) && !this.K.getIntent().getBooleanExtra("hide_uin", false) && this.Y != 2) {
            this.N.setText(stringExtra);
        }
        this.N.setRawInputType(2);
        if (TextUtils.isEmpty(this.N.getText().toString())) {
            this.N.setTextSize(17.0f);
        }
        Ni();
        Ui();
        this.P.d();
        ImageView b16 = this.P.b();
        this.Q = b16;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) b16.getLayoutParams();
        this.Q.setPadding(ViewUtils.dip2px(8.0f), ViewUtils.dip2px(10.0f), ViewUtils.dip2px(16.0f), ViewUtils.dip2px(10.0f));
        layoutParams.rightMargin = ViewUtils.dip2px(0.0f);
        layoutParams.width = ViewUtils.dip2px(40.0f);
        layoutParams.height = ViewUtils.dip2px(36.0f);
        this.Q.setImageResource(R.drawable.qui_close_secondary_01_selector);
        this.Q.setLayoutParams(layoutParams);
        this.Q.setOnClickListener(this.f242110h0);
        if (this.f242103a0 == null) {
            this.f242103a0 = new ArrayList();
        }
        this.f242103a0.clear();
        this.f242103a0.addAll(com.tencent.mobileqq.login.account.d.f241848a.f());
    }

    private boolean yi() {
        QUICheckBox qUICheckBox = this.V;
        if (qUICheckBox != null && !qUICheckBox.isChecked()) {
            return false;
        }
        return true;
    }

    private boolean zi() {
        QBaseActivity qBaseActivity = this.K;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.e
    public void E0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        libsafeedit.clearPassBuffer();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            peekAppRuntime.stopPCActivePolling("clearPassInput");
        }
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment
    public void Jh(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            super.Jh(i3);
        }
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment
    public void Kh(int i3, @NonNull com.tencent.mobileqq.login.aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) ajVar);
            return;
        }
        super.Kh(i3, ajVar);
        if (!zi() && i3 != 5) {
            this.K.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.fragment.a
                @Override // java.lang.Runnable
                public final void run() {
                    AccountLoginFragment.this.updateLoginBtnAndPasswordEditTextStatus();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment
    public void Lh(int i3, @NonNull String str, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), str, bundle);
        } else {
            super.Lh(i3, str, bundle);
            com.tencent.mobileqq.login.verify.i.e(BaseApplication.getContext(), MobileQQ.sMobileQQ.peekAppRuntime());
        }
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment
    public void Ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QUIButton qUIButton = this.W;
        if (qUIButton != null && qUIButton.m()) {
            this.W.s();
        }
    }

    protected void initData(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        if (intent == null) {
            QLog.e("AccountLoginFragment.TAG", 1, "initData, intent is null");
            return;
        }
        this.f242106d0 = new a();
        if (!zi()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mobileqq.InvitationWebViewPlugin.autoLogin");
                intentFilter.addAction("com.tencent.mobileqq.login.autoPhoneLogin");
                intentFilter.addAction("com.tencent.mobileqq.login.autoSmsLogin");
                this.K.registerReceiver(this.f242106d0, intentFilter);
            } catch (Exception e16) {
                QLog.e("AccountLoginFragment.TAG", 1, "register autoLoginReceiver error ", e16);
            }
        }
        this.Y = intent.getIntExtra("key_uin_input_hint_type", 1);
        boolean booleanExtra = intent.getBooleanExtra("is_need_login_with_mask", false);
        this.f242107e0 = booleanExtra;
        if (booleanExtra) {
            this.f242108f0 = intent.getStringExtra("uinMask");
            this.f242109g0 = intent.getStringExtra("uinEncrpyt");
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
            if (QLog.isColorLevel()) {
                QLog.d("AccountLoginFragment.TAG", 2, "onClick id=" + id5);
            }
            if (id5 == R.id.f166147yu4) {
                ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800C412", "0X800C412", uh(), 0, "", "1", com.tencent.mobileqq.statistics.o.c(), "");
                Pi();
            } else if (id5 == R.id.fiu) {
                this.f242104b0 = !this.f242104b0;
                updatePwdStates();
                PastablePwdEditText pastablePwdEditText = this.R;
                pastablePwdEditText.setSelection(pastablePwdEditText.length());
            } else if (id5 == R.id.fis) {
                this.R.h();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            Ki();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("AccountLoginFragment.TAG", 2, "onCreateView");
            }
            QLog.d("AccountLoginFragment.TAG", 1, "enableTalkBack=" + AppSetting.f99565y);
            inflate = layoutInflater.inflate(R.layout.fgd, viewGroup, false);
            QBaseActivity qBaseActivity = getQBaseActivity();
            this.K = qBaseActivity;
            initData(qBaseActivity.getIntent());
            initViews(inflate);
            Ki();
            ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800AA27", "0X800AA27", uh(), 0, "", "", com.tencent.mobileqq.statistics.o.c(), "");
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).loginReport(null, com.tencent.mobileqq.dt.api.c.G, "");
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).uiStartSensor(null, com.tencent.mobileqq.dt.api.c.F);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        BroadcastReceiver broadcastReceiver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroyView();
        QBaseActivity qBaseActivity = this.K;
        if (qBaseActivity != null && (broadcastReceiver = this.f242106d0) != null) {
            try {
                qBaseActivity.unregisterReceiver(broadcastReceiver);
            } catch (Exception e16) {
                QLog.e("AccountLoginFragment.TAG", 1, "unregisterAutoLoginReceiver error ", e16);
            }
            this.f242106d0 = null;
        }
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).loginReport(null, com.tencent.mobileqq.dt.api.c.H, ti());
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).uiEndSensor(null, com.tencent.mobileqq.dt.api.c.F);
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountLoginFragment.TAG", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        super.onPause();
        if (z.c()) {
            this.Z.hideSoftInputFromWindow(this.K.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountLoginFragment.TAG", 2, "onResume");
        }
        super.onResume();
        ri();
        si();
    }

    com.tencent.mobileqq.login.account.a ui(String str) {
        List<com.tencent.mobileqq.login.account.a> list;
        if (!TextUtils.isEmpty(str) && (list = this.f242103a0) != null) {
            for (com.tencent.mobileqq.login.account.a aVar : list) {
                if (TextUtils.equals(aVar.f(), str)) {
                    return aVar;
                }
            }
            return null;
        }
        return null;
    }
}
