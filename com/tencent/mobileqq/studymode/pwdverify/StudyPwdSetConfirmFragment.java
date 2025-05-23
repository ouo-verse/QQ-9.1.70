package com.tencent.mobileqq.studymode.pwdverify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.f;
import com.tencent.mobileqq.studymode.g;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.studymode.p;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes18.dex */
public class StudyPwdSetConfirmFragment extends StudyPwdBaseFragment implements l.a {
    static IPatchRedirector $redirector_;
    private Button V;
    private View W;
    private String X;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f291011a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f291012b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f291013c0;

    /* renamed from: d0, reason: collision with root package name */
    private FragmentActivity f291014d0;

    /* renamed from: e0, reason: collision with root package name */
    private l f291015e0;

    /* renamed from: f0, reason: collision with root package name */
    private QQAppInterface f291016f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f291017g0;

    /* renamed from: h0, reason: collision with root package name */
    private KidModeObserver f291018h0;

    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StudyPwdSetConfirmFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                StudyPwdSetConfirmFragment.this.di();
                ReportController.o(StudyPwdSetConfirmFragment.this.f291016f0, "dc00898", "", "", "0X800BD42", "0X800BD42", 0, 0, "", "", "", "");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes18.dex */
    class b extends KidModeObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StudyPwdSetConfirmFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void g(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle);
                return;
            }
            QBaseActivity qBaseActivity = StudyPwdSetConfirmFragment.this.getQBaseActivity();
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                QLog.i("KidModeObserver", 1, "onSendSmsTokenSuccess activity isSuccess=" + z16 + ",mIsSendPwdTokenRequest=" + StudyPwdSetConfirmFragment.this.f291017g0);
                StudyPwdSetConfirmFragment studyPwdSetConfirmFragment = StudyPwdSetConfirmFragment.this;
                if (!studyPwdSetConfirmFragment.f291017g0) {
                    return;
                }
                studyPwdSetConfirmFragment.f291017g0 = false;
                if (z16 && studyPwdSetConfirmFragment.Y != -1) {
                    StudyPwdSetConfirmFragment studyPwdSetConfirmFragment2 = StudyPwdSetConfirmFragment.this;
                    studyPwdSetConfirmFragment2.Th(studyPwdSetConfirmFragment2.f291012b0, StudyPwdSetConfirmFragment.this.Z);
                    if (p.f(StudyPwdSetConfirmFragment.this.f291012b0) && StudyPwdSetConfirmFragment.this.f291014d0 != null) {
                        Intent intent = StudyPwdSetConfirmFragment.this.f291014d0.getIntent();
                        intent.putExtra("msg", "StudyPwdSetConfirmFragment: verify password success");
                        intent.putExtra("extra_source", StudyPwdSetConfirmFragment.this.f291012b0);
                        qBaseActivity.setResult(-1, intent);
                        qBaseActivity.finish();
                        return;
                    }
                    if (StudyModeManager.z(StudyPwdSetConfirmFragment.this.Y, StudyPwdSetConfirmFragment.this.f291012b0)) {
                        StudyPwdSetConfirmFragment.this.fi(qBaseActivity);
                        return;
                    } else {
                        StudyPwdSetConfirmFragment.this.ei(qBaseActivity, false);
                        StudyPwdSetConfirmFragment.this.Oh();
                        return;
                    }
                }
                StudyPwdSetConfirmFragment.this.Ph(null);
                return;
            }
            QLog.i("StudyPwdSetConfirmFragment", 1, "onSendSmsTokenSuccess activity is finishing.");
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void i(KidModeObserver.SetNewPasswordResult setNewPasswordResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) setNewPasswordResult);
                return;
            }
            QBaseActivity qBaseActivity = StudyPwdSetConfirmFragment.this.getQBaseActivity();
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                if (setNewPasswordResult == null) {
                    QLog.i("StudyPwdSetConfirmFragment", 1, "onSetNewPassword result == null");
                    StudyPwdSetConfirmFragment.this.Ph(null);
                    return;
                }
                QLog.i("StudyPwdSetConfirmFragment", 1, "onSetNewPassword errCode=" + setNewPasswordResult.errCode + ",errMessage=" + setNewPasswordResult.errMessage + ",token=" + setNewPasswordResult.token);
                if (setNewPasswordResult.errCode != 0) {
                    StudyPwdSetConfirmFragment.this.Ph(null);
                    return;
                }
                StudyModeManager.M(2);
                if (TextUtils.isEmpty(setNewPasswordResult.token)) {
                    StudyPwdSetConfirmFragment.this.Ph(null);
                    return;
                }
                StudyPwdSetConfirmFragment studyPwdSetConfirmFragment = StudyPwdSetConfirmFragment.this;
                studyPwdSetConfirmFragment.f291017g0 = true;
                KidModeServlet.p((QQAppInterface) studyPwdSetConfirmFragment.getAppRuntime(), setNewPasswordResult.token.getBytes());
                return;
            }
            QLog.i("StudyPwdSetConfirmFragment", 1, "onSetNewPassword activity is finishing");
        }
    }

    public StudyPwdSetConfirmFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f291017g0 = false;
            this.f291018h0 = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di() {
        if (this.f291016f0 == null) {
            QLog.i("StudyPwdSetConfirmFragment", 1, "gotoSetPwd mApp == null");
            return;
        }
        String Gh = Gh();
        if (Gh.length() != 4 || !Gh.equals(this.X) || !ph()) {
            return;
        }
        String k3 = StudyModeManager.k();
        QLog.i("StudyPwdSetConfirmFragment", 1, "setNewPassword pwd=" + f.b(Gh) + ",salt=" + f.b(k3));
        KidModeServlet.x(this.f291016f0, Gh, k3);
        Qh();
    }

    private void gi() {
        FragmentActivity fragmentActivity = this.f291014d0;
        if (fragmentActivity != null) {
            fragmentActivity.setResult(0, fragmentActivity.getIntent());
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void Aa(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i("StudyPwdSetConfirmFragment", 1, "onModeChangeStart curType : " + i3 + ", oldType : " + i16);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            return;
        }
        QLog.i("StudyPwdSetConfirmFragment", 1, "onModeChangeStart activity == null || activity.isFinishing()");
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void C6(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), obj);
        }
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    protected View Dh(ViewGroup viewGroup) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewGroup);
        }
        if (this.W == null) {
            this.W = getLayoutInflater().inflate(R.layout.h5a, viewGroup, false);
        }
        if (this.V == null && (view = this.W) != null) {
            Button button = (Button) view.findViewById(R.id.ama);
            this.V = button;
            button.setOnClickListener(new a());
            this.V.setEnabled(false);
        }
        return this.W;
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    protected String Eh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return BaseApplication.getContext().getString(R.string.f2051454t);
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    protected String Fh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return BaseApplication.getContext().getString(R.string.f2051554u);
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    protected void Nh(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str);
            return;
        }
        if (this.V == null) {
            return;
        }
        if (str.length() == 4) {
            if (!str.equals(this.X)) {
                Bh(BaseApplication.getContext().getString(R.string.f2051754w));
                ReportController.o(this.f291016f0, "dc00898", "", "", "0X800BD44", "0X800BD44", 0, 0, "", "", "", "");
                return;
            } else {
                this.V.setEnabled(true);
                return;
            }
        }
        this.V.setEnabled(false);
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void W1(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i("StudyPwdSetConfirmFragment", 1, "onSelectModeRecover curType : " + i3 + ", oldType : " + i16);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            Oh();
            ei(qBaseActivity, false);
            if (p.g(this.f291012b0)) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.hhx, 0).show();
                return;
            }
            return;
        }
        QLog.i("StudyPwdSetConfirmFragment", 1, "onSelectModeRecover activity == null || activity.isFinishing()");
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void ed(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i("StudyPwdSetConfirmFragment", 1, "onModeSwitching curType : " + i3 + ", oldType : " + i16);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            notifyUser(R.string.f173119hi2, 0);
            Oh();
        } else {
            QLog.i("StudyPwdSetConfirmFragment", 1, "onSelectModeRecover activity == null || activity.isFinishing()");
        }
    }

    protected void ei(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, activity, Boolean.valueOf(z16));
            return;
        }
        Intent intent = activity.getIntent();
        intent.putExtra("key_is_jump_to_next", true);
        intent.putExtra("extra_mode_change_success", z16);
        activity.setResult(-1, intent);
        activity.finish();
    }

    protected void fi(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qBaseActivity);
            return;
        }
        l lVar = this.f291015e0;
        if (lVar == null) {
            QLog.i("StudyPwdSetConfirmFragment", 1, "setKidMode mModeSwitchManager == null)");
            Oh();
            return;
        }
        if (lVar.o()) {
            QLog.i("StudyPwdSetConfirmFragment", 1, "setKidMode isSwitching()");
            notifyUser(R.string.f173119hi2, 0);
            Oh();
            return;
        }
        if (g.a() == this.Z) {
            QLog.i("StudyPwdSetConfirmFragment", 1, "switchStudyMode already suc");
            Oh();
            ei(qBaseActivity, true);
            return;
        }
        l.b f16 = this.f291015e0.f(qBaseActivity, this.Z, SimpleUIUtil.getSimpleUIPref(), true);
        if (!f16.c() && f16.b() == f16.a()) {
            ei(qBaseActivity, true);
        }
        QLog.i("StudyPwdSetConfirmFragment", 1, "setKidMode isSwitching=" + f16.c() + ",targetMode=" + f16.b() + ",oldMode=" + f16.a());
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void j7(boolean z16, int i3, int i16, @NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        QLog.i("StudyPwdSetConfirmFragment", 1, "onModeChangeComplete isSuccess : " + z16 + ", curType : " + i3 + ", oldType : " + i16);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            Oh();
            ei(qBaseActivity, z16);
            if (p.g(this.f291012b0) && !TextUtils.isEmpty(str)) {
                BaseApplication context = BaseApplication.getContext();
                if (!z16) {
                    i17 = 1;
                }
                QQToast.makeText(context, i17, str, 0).show();
                return;
            }
            return;
        }
        QLog.i("StudyPwdSetConfirmFragment", 1, "onModeChangeComplete activity == null || activity.isFinishing()");
    }

    public void notifyUser(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            QQToast.makeText(BaseApplication.getContext(), i16, i3, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.f291014d0 = activity;
        if (activity != null) {
            Intent intent = activity.getIntent();
            this.X = intent.getStringExtra("key_previous_pwd");
            this.Y = intent.getIntExtra("ExtraTargetAction", -1);
            this.Z = intent.getIntExtra("extra_target_mode", -1);
            this.f291011a0 = intent.getIntExtra("extra_old_mode", -1);
            this.f291012b0 = intent.getIntExtra("extra_source", -1);
            this.f291013c0 = intent.getIntExtra("extra_source_for_report", -1);
            gi();
        }
        int i3 = this.f291013c0;
        if (i3 != -1) {
            Rh("0X800BD41", i3);
        } else {
            Sh("0X800BD41", this.Y);
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof QQAppInterface) {
            this.f291016f0 = (QQAppInterface) appRuntime;
        }
        QQAppInterface qQAppInterface = this.f291016f0;
        if (qQAppInterface != null) {
            l lVar = (l) qQAppInterface.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
            this.f291015e0 = lVar;
            lVar.d(this);
            this.f291016f0.registObserver(this.f291018h0);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onCreate mAction=");
        sb5.append(this.Y);
        sb5.append(",mApp=");
        if (this.f291016f0 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("StudyPwdSetConfirmFragment", 1, sb5.toString());
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        if (this.f291016f0 != null) {
            l lVar = this.f291015e0;
            if (lVar != null) {
                lVar.v(this);
            }
            this.f291016f0.unRegistObserver(this.f291018h0);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onDestroy mApp=");
        if (this.f291016f0 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("StudyPwdSetConfirmFragment", 1, sb5.toString());
    }

    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment
    protected void uh() {
        FragmentActivity fragmentActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f291012b0 == 6 && (fragmentActivity = this.f291014d0) != null) {
            Intent intent = fragmentActivity.getIntent();
            intent.putExtra("msg", "StudyPwdSetFragment: set password failed, reason: back button");
            this.f291014d0.setResult(0, intent);
            return;
        }
        super.uh();
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void wa(boolean z16, boolean z17, boolean z18, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3));
        }
    }
}
