package com.tencent.mobileqq.studymode.pwdverify;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeBaseFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerifyCodeView;
import com.tencent.mobileqq.widget.container.AdaptiveKeyboardLayout;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneTeenOnlineTimeHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes18.dex */
public abstract class StudyPwdBaseFragment extends StudyModeBaseFragment {
    static IPatchRedirector $redirector_;
    private ViewGroup E;
    private TextView F;
    private TextView G;
    private VerifyCodeView H;
    private AdaptiveKeyboardLayout I;
    private View J;
    private InputMethodManager K;
    private Runnable L;
    protected Dialog M;
    private boolean N;
    private boolean P;
    private SharedPreferences Q;
    private int R;
    protected int S;
    private boolean T;
    private Runnable U;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a implements VerifyCodeView.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StudyPwdBaseFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.VerifyCodeView.a
        public void onVerifyCodeChanged(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else {
                StudyPwdBaseFragment.this.Nh(z16, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class b implements AdaptiveKeyboardLayout.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StudyPwdBaseFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.container.AdaptiveKeyboardLayout.a
        public void a(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            } else if (z16) {
                StudyPwdBaseFragment.this.Vh(i3);
            }
        }
    }

    public StudyPwdBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.S = 0;
        this.T = true;
        this.U = new Runnable() { // from class: com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StudyPwdBaseFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    StudyPwdBaseFragment.this.M.show();
                }
            }
        };
    }

    private void Ch() {
        this.H.removeCallbacks(this.L);
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) StudyPwdBaseFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (StudyPwdBaseFragment.this.isResumed()) {
                    StudyPwdBaseFragment.this.I.setKeyboardLayoutEnable(true);
                    StudyPwdBaseFragment.this.H.k(StudyPwdBaseFragment.this.K);
                }
            }
        };
        this.L = runnable;
        this.H.postDelayed(runnable, 300L);
    }

    private int Hh() {
        int i3 = this.Q.getInt("study_pwd_keyboard_height", 0);
        this.R = i3;
        return i3;
    }

    private void Kh() {
        Ch();
    }

    private void Lh(@NonNull View view) {
        int i3;
        this.H = (VerifyCodeView) view.findViewById(R.id.f1195977_);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            this.T = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("study_pwd_frag_forbid_to_fit_theme");
        }
        if (this.T) {
            VerifyCodeView verifyCodeView = this.H;
            if (rh()) {
                i3 = -1;
            } else {
                i3 = -16777216;
            }
            verifyCodeView.setDigitTextColorNormal(i3);
        }
        this.H.e(new a());
        this.H.setContextMenuEnable(false);
        this.H.setTheme(rh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh(int i3) {
        if (i3 != this.R) {
            this.Q.edit().putInt("study_pwd_keyboard_height", i3).apply();
            this.R = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.H.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bh(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        this.H.g();
        if (!TextUtils.isEmpty(str)) {
            QQToast.makeText(getContext(), 1, str, 0).show();
        }
    }

    @Nullable
    protected abstract View Dh(ViewGroup viewGroup);

    protected abstract String Eh();

    protected abstract String Fh();

    /* JADX INFO: Access modifiers changed from: protected */
    public String Gh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.H.i();
    }

    public void Ih() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (this.K != null && getActivity() != null) {
            this.K.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
        }
        this.I.n();
    }

    protected void Jh(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        this.J = Dh(this.I);
        this.I.setKeyboardLayoutEnable(false);
        this.I.m(this.E, true);
        this.I.setKeyboardListener(new b());
        View view2 = this.J;
        if (view2 == null) {
            return;
        }
        this.I.addView(view2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent(QZoneTeenOnlineTimeHelper.TEEN_PSW_VERIFY_RESULT_ACTION);
            int i3 = this.S;
            if (i3 == 2) {
                intent.putExtra("result", "success");
                intent.putExtra("msg", "StudyPwdSetFragment: password success");
                activity.sendBroadcast(intent);
            } else if (i3 == 0) {
                intent.putExtra("result", "fail");
                intent.putExtra("msg", "StudyPwdSetFragment: set password failed, reason: back");
                activity.sendBroadcast(intent);
            }
        }
    }

    protected abstract void Nh(boolean z16, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void Oh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            hideLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ph(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            vh(str);
            hideLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            showLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Rh(String str, int i3) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str, i3);
            return;
        }
        if (i3 != -1) {
            if (i3 != 3) {
                if (i3 != 4) {
                    i17 = -1;
                    if (i17 != -1) {
                        QLog.d("StudyPwdBaseFragment", 1, "reportData exp!!! srcForReport:" + i3);
                        return;
                    }
                    ReportController.o(getAppRuntime(), "dc00898", "", "", str, str, i17, 0, "", "", "", "");
                    return;
                }
                i16 = 7;
            } else {
                i16 = 6;
            }
            i17 = i16;
            if (i17 != -1) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Sh(String str, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, i3);
            return;
        }
        int i17 = 3;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    i17 = 4;
                } else {
                    i16 = 2;
                }
            } else {
                i16 = 1;
            }
            ReportController.o(getAppRuntime(), "dc00898", "", "", str, str, i16, 0, "", "", "", "");
        }
        i16 = i17;
        ReportController.o(getAppRuntime(), "dc00898", "", "", str, str, i16, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Th(int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i16 != 2) {
            return;
        }
        if (i3 != 1 && i3 != 2) {
            if (i3 != 8) {
                i17 = 3;
            } else {
                i17 = 2;
            }
        } else {
            i17 = 1;
        }
        ReportController.o(getAppRuntime(), "dc00898", "", "", "0X800C3C5", "0X800C3C5", i17, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Uh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            Ch();
        }
    }

    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment, com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
            return;
        }
        this.K = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.Q = PreferenceManager.getDefaultSharedPreferences(getContext());
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
    }

    protected void hideLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        ThreadManager.getUIHandler().removeCallbacks(this.U);
        this.N = false;
        Dialog dialog = this.M;
        if (dialog != null && dialog.isShowing()) {
            this.M.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        this.H.removeCallbacks(this.L);
        hideLoading();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onFinish();
            Ih();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        sh();
        this.H.setTheme(rh());
        if (this.T) {
            VerifyCodeView verifyCodeView = this.H;
            if (rh()) {
                i3 = -1;
            } else {
                i3 = -16777216;
            }
            verifyCodeView.setDigitTextColorNormal(i3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        if (this.P && (view = this.J) != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.bottomMargin += Hh();
            this.J.setLayoutParams(layoutParams);
        } else {
            this.I.n();
        }
        this.P = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        this.P = true;
        this.F = (TextView) view.findViewById(R.id.kbs);
        this.G = (TextView) view.findViewById(R.id.f167042k73);
        this.F.setText(Fh());
        this.G.setText(Eh());
        this.I = (AdaptiveKeyboardLayout) view.findViewById(R.id.u6a);
        this.E = (ViewGroup) view.findViewById(R.id.root_layout);
        sh();
        Lh(view);
        Jh(view);
        Kh();
    }

    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment
    protected void qh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) layoutInflater, (Object) viewGroup);
        } else {
            layoutInflater.inflate(R.layout.h5_, viewGroup, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment
    public void sh() {
        int color;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        super.sh();
        TextView textView = this.F;
        if (rh()) {
            color = -1;
        } else {
            color = getResources().getColor(R.color.f156919f8);
        }
        textView.setTextColor(color);
    }

    protected void showLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (getActivity() == null || getActivity().isFinishing() || this.N) {
            return;
        }
        if (this.M == null) {
            this.M = DialogUtil.createWaitingDialog(getActivity(), R.string.f1628621k);
        }
        if (!this.M.isShowing()) {
            this.N = true;
            ThreadManager.getUIHandler().postDelayed(this.U, 400L);
        }
    }
}
