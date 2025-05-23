package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService;
import com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerifyCodeView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SmsVerifyComponentFragment extends RegisterNewBaseFragment implements View.OnClickListener, VerifyCodeView.a, com.tencent.mobileqq.loginregister.sms.c {
    static IPatchRedirector $redirector_;
    private int J;
    private com.tencent.mobileqq.activity.verifysms.a K;
    private TextView L;
    private QQProgressDialog M;
    private com.tencent.mobileqq.loginregister.sms.e N;
    private int P;
    private String Q;
    private int R;
    private boolean S;
    private long T;
    protected Handler U;
    private Runnable V;

    public SmsVerifyComponentFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.J = 1;
        this.S = false;
        this.T = 0L;
        this.U = new Handler();
        this.V = new Runnable() { // from class: com.tencent.mobileqq.fragment.SmsVerifyComponentFragment.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SmsVerifyComponentFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (SmsVerifyComponentFragment.this.J <= 1) {
                    SmsVerifyComponentFragment.this.Nh(true);
                    return;
                }
                SmsVerifyComponentFragment.this.J--;
                SmsVerifyComponentFragment.this.Nh(false);
                SmsVerifyComponentFragment.this.U.postDelayed(this, 1000L);
            }
        };
    }

    private boolean Ih() {
        if (!NetworkUtil.isNetSupport(this.C)) {
            showToast(getString(R.string.b3j));
            return false;
        }
        return true;
    }

    private void Kh() {
        this.U.post(new Runnable() { // from class: com.tencent.mobileqq.fragment.SmsVerifyComponentFragment.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SmsVerifyComponentFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (SmsVerifyComponentFragment.this.M != null && SmsVerifyComponentFragment.this.M.isShowing()) {
                        SmsVerifyComponentFragment.this.M.dismiss();
                        SmsVerifyComponentFragment.this.M.cancel();
                    }
                } catch (Throwable th5) {
                    QLog.e("Q.devlock..SmsVerifyComponentFragment", 1, "hideProgressDialog exception", th5);
                }
                SmsVerifyComponentFragment.this.M = null;
            }
        });
    }

    private void Lh() {
        ISmsVerifyCodeService iSmsVerifyCodeService = (ISmsVerifyCodeService) this.D.getRuntimeService(ISmsVerifyCodeService.class, "all");
        if (iSmsVerifyCodeService != null) {
            iSmsVerifyCodeService.handleSmsVerifyCodeCancel(this.C, new Bundle());
        }
    }

    private void Mh() {
        if (com.tencent.mobileqq.loginregister.z.b(getContext())) {
            com.tencent.mobileqq.loginregister.z.w(this.E.findViewById(R.id.f116546z1));
        } else {
            com.tencent.mobileqq.loginregister.z.A(this.E.findViewById(R.id.f116546z1));
        }
        com.tencent.mobileqq.activity.verifysms.a aVar = this.K;
        if (aVar != null) {
            aVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh(boolean z16) {
        QLog.i("Q.devlock..SmsVerifyComponentFragment", 2, "refreshSendCodeBtn: " + this.J);
        this.K.c(z16, this.S, this.J);
    }

    private void initViews() {
        int b16 = this.K.b();
        if (b16 != 0) {
            Ch(b16);
        }
        Bh();
        Ah(false);
        long b17 = SmsVerifyComponent.b(this.P, this.G, this.F, 0L);
        long currentTimeMillis = System.currentTimeMillis() - b17;
        if (b17 > 0 && currentTimeMillis < 60000) {
            int i3 = (int) ((60000 - currentTimeMillis) / 1000);
            this.J = i3;
            this.J = Math.max(i3, 1);
        }
        QLog.i("Q.devlock..SmsVerifyComponentFragment", 2, "initViews: second= " + this.J);
        if (this.J > 1) {
            Nh(false);
            this.U.postDelayed(this.V, 1000L);
            if (this.J == 60) {
                SmsVerifyComponent.c(this.P, this.G, this.F, System.currentTimeMillis());
            }
        } else {
            Nh(true);
        }
        TextView textView = (TextView) this.E.findViewById(R.id.an9);
        this.L = textView;
        textView.setOnClickListener(this);
        Mh();
    }

    private void restartTimer(int i3) {
        QLog.i("Q.devlock..SmsVerifyComponentFragment", 1, "restartTimer: " + i3);
        this.J = i3;
        if (this.K != null) {
            Nh(false);
        }
        SmsVerifyComponent.c(this.P, this.G, this.F, System.currentTimeMillis());
        this.U.postDelayed(this.V, 1000L);
    }

    private void showProgressDialog(@StringRes int i3) {
        this.U.post(new Runnable(i3) { // from class: com.tencent.mobileqq.fragment.SmsVerifyComponentFragment.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f211231d;

            {
                this.f211231d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SmsVerifyComponentFragment.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (SmsVerifyComponentFragment.this.M == null && !SmsVerifyComponentFragment.this.C.isFinishing()) {
                        SmsVerifyComponentFragment smsVerifyComponentFragment = SmsVerifyComponentFragment.this;
                        QBaseActivity qBaseActivity = SmsVerifyComponentFragment.this.C;
                        smsVerifyComponentFragment.M = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
                        SmsVerifyComponentFragment.this.M.setMessage(SmsVerifyComponentFragment.this.getString(this.f211231d));
                    }
                    if (SmsVerifyComponentFragment.this.M != null && !SmsVerifyComponentFragment.this.M.isShowing()) {
                        SmsVerifyComponentFragment.this.M.show();
                    }
                } catch (Throwable th5) {
                    QLog.e("Q.devlock..SmsVerifyComponentFragment", 1, "showProgressDialog exception", th5);
                }
            }
        });
    }

    private void showToast(String str) {
        QQToast.makeText(this.C, str, 0).show(this.C.getTitleBarHeight());
        as.g(this.D, "0X800C19B", "", 0, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.RegisterNewBaseFragment
    public void Bh() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            if (this.K == null || (str = this.F) == null || str.length() < 3 || this.K.d(this.G, uh())) {
                return;
            }
            super.Bh();
        }
    }

    protected void Jh() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (!NetworkUtil.isNetSupport(this.C)) {
            showToast(getString(R.string.b3j));
            return;
        }
        com.tencent.mobileqq.activity.verifysms.a aVar = this.K;
        if (aVar != null) {
            str = aVar.a();
        } else {
            str = null;
        }
        if (str != null) {
            str = str.trim();
        }
        this.N.c(this.C, this, str);
        com.tencent.mobileqq.loginregister.sms.f.f(this.F, this.R);
    }

    @Override // com.tencent.mobileqq.loginregister.sms.c
    public void Xc(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            showProgressDialog(i3);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.c
    public void clearWrongCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.verifysms.a aVar = this.K;
        if (aVar != null) {
            aVar.clearWrongCode();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.c
    public void dismissDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            Kh();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
            this.N.a(this.C, i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.N.f(this.C, this.S, this.T)) {
            return true;
        }
        Lh();
        this.C.finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.aji) {
                if (this.J <= 1 && Ih()) {
                    this.N.g(this.C, this);
                    this.S = true;
                }
            } else if (view.getId() == R.id.an9) {
                onBackEvent();
            } else if (id5 == R.id.tfu) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.T >= 500) {
                    this.T = currentTimeMillis;
                    this.N.e(this.C);
                }
            } else if (id5 == R.id.b7p) {
                Jh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            Mh();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
        } else {
            this.E = layoutInflater.inflate(R.layout.dzd, viewGroup, false);
            if (!wh()) {
                view = this.E;
            } else {
                this.N = new com.tencent.mobileqq.loginregister.sms.e();
                Intent intent = this.C.getIntent();
                this.F = intent.getExtras().getString(AppConstants.Key.PHONENUM);
                this.Q = intent.getStringExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
                this.P = intent.getIntExtra("key_sms_verify_function_code", 0);
                String string = intent.getExtras().getString("key");
                if (!TextUtils.isEmpty(string)) {
                    QLog.e("Q.devlock..SmsVerifyComponentFragment", 1, "onCreateView countryCode is empty, use default");
                    this.G = string;
                }
                RelativeLayout relativeLayout = (RelativeLayout) this.E.findViewById(R.id.root_layout);
                if (this.P == 3) {
                    this.K = new com.tencent.mobileqq.activity.verifysms.d(getLayoutInflater(), relativeLayout, this);
                    this.C.getWindow().setSoftInputMode(16);
                } else {
                    this.C.getWindow().setSoftInputMode(5);
                    this.K = new com.tencent.mobileqq.activity.verifysms.b(getLayoutInflater(), relativeLayout, this, this);
                }
                if (ImmersiveUtils.isSupporImmersive() == 1) {
                    ImmersiveUtils.setFitsSystemWindows(this.E, true);
                    if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
                        ImmersiveUtils.setStatusTextColor(true, this.C.getWindow());
                    }
                }
                initViews();
                this.N.h(this.C, this);
                if (this.K.f() && this.J <= 1 && Ih()) {
                    this.S = this.N.b(this.C, this);
                }
                com.tencent.mobileqq.loginregister.sms.f.g(this.F, this.R);
                view = this.E;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        this.H.removeCallbacksAndMessages(null);
        this.U.removeCallbacksAndMessages(null);
        Kh();
        com.tencent.mobileqq.loginregister.sms.e eVar = this.N;
        if (eVar != null) {
            eVar.onActivityDestroy();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        com.tencent.mobileqq.loginregister.sms.e eVar = this.N;
        if (eVar != null) {
            eVar.onActivityResume();
        }
    }

    @Override // com.tencent.mobileqq.widget.VerifyCodeView.a
    public void onVerifyCodeChanged(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str);
        } else if (z16) {
            Jh();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.c
    public void showLoadingDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            showProgressDialog(R.string.f211275kd);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.c
    public void startTimer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            restartTimer(i3);
        }
    }
}
