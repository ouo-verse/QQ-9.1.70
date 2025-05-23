package com.tencent.mobileqq.minorsmode.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.studymode.p;
import com.tencent.mobileqq.studymode.pwdverify.PwdVerifySuccess;
import com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment;
import com.tencent.mobileqq.studymode.pwdverify.StudyPwdSetFragment;
import com.tencent.mobileqq.studymode.t;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes33.dex */
public class StudyPwdVerifyFragment extends StudyPwdBaseFragment implements l.a {
    private View W;
    private QQAppInterface X;
    private FragmentActivity Y;

    /* renamed from: d0, reason: collision with root package name */
    private int f247154d0;

    /* renamed from: e0, reason: collision with root package name */
    private l f247155e0;
    private c V = null;
    private int Z = -1;

    /* renamed from: a0, reason: collision with root package name */
    private int f247151a0 = -1;

    /* renamed from: b0, reason: collision with root package name */
    private int f247152b0 = -1;

    /* renamed from: c0, reason: collision with root package name */
    private int f247153c0 = -1;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f247156f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private KidModeObserver f247157g0 = new b();

    /* loaded from: classes33.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StudyPwdVerifyFragment.this.Ih();
            StudyPwdVerifyFragment.this.hi();
            ReportController.o(StudyPwdVerifyFragment.this.X, "dc00898", "", "", "0X800BD46", "0X800BD46", 0, 0, "", "", "", "");
        }
    }

    /* loaded from: classes33.dex */
    class b extends KidModeObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void g(boolean z16, Bundle bundle) {
            QBaseActivity qBaseActivity = StudyPwdVerifyFragment.this.getQBaseActivity();
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                QLog.i("StudyPwdVerifyFragment", 1, "onSendSmsTokenSuccess activity isSuccess=" + z16 + ",mIsSendPwdTokenRequest=" + StudyPwdVerifyFragment.this.f247156f0);
                StudyPwdVerifyFragment studyPwdVerifyFragment = StudyPwdVerifyFragment.this;
                if (studyPwdVerifyFragment.f247156f0) {
                    studyPwdVerifyFragment.f247156f0 = false;
                    if (!z16) {
                        studyPwdVerifyFragment.Ph(null);
                        return;
                    }
                    studyPwdVerifyFragment.Th(studyPwdVerifyFragment.f247153c0, StudyPwdVerifyFragment.this.f247151a0);
                    StudyPwdVerifyFragment.this.ii();
                    StudyPwdVerifyFragment.this.Oh();
                    return;
                }
                return;
            }
            QLog.i("StudyPwdVerifyFragment", 1, "onSendSmsTokenSuccess activity is finishing.");
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void j(KidModeObserver.VerifyPasswordResult verifyPasswordResult) {
            String str;
            QBaseActivity qBaseActivity = StudyPwdVerifyFragment.this.getQBaseActivity();
            if (qBaseActivity == null || qBaseActivity.isFinishing()) {
                QLog.i("StudyPwdVerifyFragment", 1, "onVerifyPassword activity is finishing");
                return;
            }
            if (verifyPasswordResult == null) {
                StudyPwdVerifyFragment.this.Ph(null);
                QLog.i("StudyPwdVerifyFragment", 1, "onVerifyPassword result == null");
                return;
            }
            QLog.i("StudyPwdVerifyFragment", 1, "onVerifyPassword errCode=" + verifyPasswordResult.errCode + ",errMessage=" + verifyPasswordResult.errMessage + ",token=" + com.tencent.mobileqq.studymode.f.b(verifyPasswordResult.token));
            int i3 = verifyPasswordResult.errCode;
            if (i3 != 0) {
                if (i3 == 20003) {
                    StudyPwdVerifyFragment.this.Bh(null);
                    str = StudyPwdVerifyFragment.this.getString(R.string.f20522551);
                    ReportController.o(StudyPwdVerifyFragment.this.X, "dc00898", "", "", "0X800BD49", "0X800BD49", 0, 0, "", "", "", "");
                } else if (i3 == 30001) {
                    StudyPwdVerifyFragment.this.Bh(null);
                    str = StudyPwdVerifyFragment.this.getString(R.string.f20523552);
                    ReportController.o(StudyPwdVerifyFragment.this.X, "dc00898", "", "", "0X800BD48", "0X800BD48", 0, 0, "", "", "", "");
                } else {
                    str = "";
                }
                StudyPwdVerifyFragment.this.Ph(str);
                return;
            }
            if (TextUtils.isEmpty(verifyPasswordResult.token)) {
                StudyPwdVerifyFragment.this.Ph(null);
                return;
            }
            StudyPwdVerifyFragment studyPwdVerifyFragment = StudyPwdVerifyFragment.this;
            studyPwdVerifyFragment.f247156f0 = true;
            KidModeServlet.p((QQAppInterface) studyPwdVerifyFragment.getAppRuntime(), verifyPasswordResult.token.getBytes());
        }
    }

    private void ki() {
        if (this.V == null) {
            this.V = new c();
            getActivity().registerReceiver(this.V, new IntentFilter("com.tencent.mobileqq.studymode.pwdverify.studyidentify"));
        }
    }

    private void li() {
        if (this.V != null) {
            getActivity().unregisterReceiver(this.V);
            this.V = null;
        }
    }

    private void mi() {
        FragmentActivity fragmentActivity = this.Y;
        if (fragmentActivity != null) {
            Intent intent = fragmentActivity.getIntent();
            if (p.f(this.f247153c0)) {
                intent.putExtra("msg", "StudyPwdVerifyFragment: verify password failed, reason: back");
            }
            this.Y.setResult(0, intent);
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void Aa(int i3, int i16) {
        QLog.d("StudyPwdVerifyFragment", 1, "ModeChangeStart, oldType: " + i16 + " --> targetType: " + i3);
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void C6(boolean z16, Object obj) {
        QLog.d("StudyPwdVerifyFragment", 1, "IReqGetSimpleUISwitch, isSuc: " + z16 + ", param:  " + obj);
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    protected View Dh(ViewGroup viewGroup) {
        View findViewById;
        if (this.W == null) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.h5b, viewGroup, false);
            this.W = inflate;
            if (inflate != null && (findViewById = inflate.findViewById(R.id.f112896p6)) != null) {
                findViewById.setOnClickListener(new a());
            }
        }
        if (com.tencent.common.config.pad.f.o()) {
            this.W.setVisibility(8);
        }
        return this.W;
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    protected String Eh() {
        return BaseApplication.getContext().getString(R.string.f20521550);
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    protected String Fh() {
        return BaseApplication.getContext().getString(R.string.f20524553);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    public void Oh() {
        if (StudyModeManager.z(this.Z, this.f247153c0)) {
            return;
        }
        super.Oh();
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void W1(int i3, int i16) {
        QLog.d("StudyPwdVerifyFragment", 1, "SelectModeRecover, targetType: " + i3 + " --> oldType: " + i16);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            if (p.g(this.f247153c0)) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.hhx, 0).show();
            }
            Intent intent = this.Y.getIntent();
            intent.putExtra("extra_mode_change_success", false);
            qBaseActivity.setResult(-1, intent);
            qBaseActivity.finish();
            return;
        }
        QLog.i("StudyPwdVerifyFragment", 1, "SelectModeRecover activity == null || activity.isFinishing()");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        if (p.f(this.f247153c0)) {
            Mh();
        }
        super.beforeFinish();
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void ed(int i3, int i16) {
        QLog.d("StudyPwdVerifyFragment", 1, "ModeSwitching, oldType: " + i16 + " --> targetType: " + i3);
    }

    protected void ii() {
        Intent intent;
        Intent intent2;
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            if (p.f(this.f247153c0)) {
                Intent intent3 = qBaseActivity.getIntent();
                intent3.putExtra("msg", "verify password success");
                qBaseActivity.setResult(-1, intent3);
                this.S = 2;
                qBaseActivity.finish();
                return;
            }
            QLog.i("StudyPwdVerifyFragment", 1, "jumpToNextActivity mAction=" + this.Z + ", mSrc: " + this.f247153c0);
            int i3 = this.Z;
            if (i3 == -1) {
                vh(null);
                return;
            }
            if (StudyModeManager.z(i3, this.f247153c0)) {
                if (p.g(this.f247153c0)) {
                    t.d(this.f247151a0, this.X, this.Y, null);
                    return;
                } else {
                    SimpleEventBus.getInstance().dispatchEvent(new PwdVerifySuccess());
                    return;
                }
            }
            if (this.Z == 1 && !com.tencent.common.config.pad.f.o()) {
                KidModeAdvanceSettingFragment.Vh(qBaseActivity, false);
                qBaseActivity.finish();
                return;
            }
            if (this.Z == 6) {
                if (getActivity() == null) {
                    intent2 = new Intent();
                } else {
                    intent2 = getActivity().getIntent();
                }
                intent2.putExtra("extra_mode_pass_word_check_sucess", true);
                qBaseActivity.setResult(-1, intent2);
                qBaseActivity.finish();
                return;
            }
            if (getActivity() == null) {
                intent = new Intent();
            } else {
                intent = getActivity().getIntent();
            }
            qBaseActivity.setResult(-1, intent);
            qBaseActivity.finish();
            return;
        }
        QLog.i("StudyPwdVerifyFragment", 1, "jumpToNextActivity activity == null || activity.isFinishing()");
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void j7(boolean z16, int i3, int i16, String str) {
        QLog.d("StudyPwdVerifyFragment", 1, "ModeChangeComplete, oldType: " + i16 + " --> targetType: " + i3);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            if (p.g(this.f247153c0) && !TextUtils.isEmpty(str)) {
                QQToast.makeText(BaseApplication.getContext(), z16 ? 2 : 1, str, 0).show();
            }
            Intent intent = this.Y.getIntent();
            intent.putExtra("extra_mode_change_success", z16);
            qBaseActivity.setResult(-1, intent);
            qBaseActivity.finish();
            return;
        }
        QLog.d("StudyPwdVerifyFragment", 1, "onModeChangeComplete activity == null || activity.isFinishing()");
    }

    protected void ji(boolean z16) {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            QLog.i("StudyPwdVerifyFragment", 1, "onAppealSuccess isJumpPwdSet=" + z16 + ",action" + this.Z);
            if (this.Z == -1) {
                return;
            }
            if (z16) {
                Intent intent = qBaseActivity.getIntent();
                if (this.Z == 1) {
                    QPublicFragmentActivity.start(qBaseActivity, intent, StudyPwdSetFragment.class);
                    qBaseActivity.finish();
                    return;
                } else {
                    this.S = 1;
                    QPublicFragmentActivity.startForResult(qBaseActivity, intent, (Class<? extends QPublicBaseFragment>) StudyPwdSetFragment.class, 2);
                    return;
                }
            }
            qBaseActivity.finish();
            return;
        }
        QLog.i("StudyPwdVerifyFragment", 1, "onAppealSuccess activity == null || activity.isFinishing()");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        QLog.i("StudyPwdVerifyFragment", 1, "doOnActivityResult requestCode=" + i3 + ",resultCode=" + i16);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null || qBaseActivity.isFinishing()) {
            QLog.i("StudyPwdVerifyFragment", 1, "onActivityResult activity == null || activity.isFinishing()");
            return;
        }
        if (i3 == 2) {
            if (intent != null && p.f(intent.getIntExtra("extra_source", -1))) {
                qBaseActivity.setResult(i16, intent);
            } else {
                qBaseActivity.setResult(i16, new Intent());
            }
            qBaseActivity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ki();
        FragmentActivity activity = getActivity();
        this.Y = activity;
        if (activity != null) {
            Intent intent = activity.getIntent();
            this.Z = intent.getIntExtra("ExtraTargetAction", -1);
            this.f247151a0 = intent.getIntExtra("extra_target_mode", -1);
            this.f247152b0 = intent.getIntExtra("extra_old_mode", -1);
            this.f247153c0 = intent.getIntExtra("extra_source", -1);
            this.f247154d0 = intent.getIntExtra("extra_source_for_report", -1);
            mi();
        }
        int i3 = this.f247154d0;
        if (i3 != -1) {
            Rh("0X800BD45", i3);
        } else {
            Sh("0X800BD45", this.Z);
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof QQAppInterface) {
            this.X = (QQAppInterface) appRuntime;
        }
        QQAppInterface qQAppInterface = this.X;
        if (qQAppInterface != null) {
            qQAppInterface.registObserver(this.f247157g0);
            if (StudyModeManager.z(this.Z, this.f247153c0)) {
                l lVar = (l) this.X.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
                this.f247155e0 = lVar;
                lVar.d(this);
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onCreate mAction=");
        sb5.append(this.Z);
        sb5.append(",mApp=");
        sb5.append(this.X == null);
        QLog.i("StudyPwdVerifyFragment", 1, sb5.toString());
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QQAppInterface qQAppInterface = this.X;
        if (qQAppInterface != null) {
            qQAppInterface.unRegistObserver(this.f247157g0);
        }
        l lVar = this.f247155e0;
        if (lVar != null) {
            lVar.v(this);
        }
        li();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onDestroy mApp=");
        sb5.append(this.X == null);
        QLog.i("StudyPwdVerifyFragment", 1, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment
    public void uh() {
        if (this.Y != null) {
            if (p.f(this.f247153c0)) {
                Intent intent = this.Y.getIntent();
                intent.putExtra("msg", "StudyPwdSetFragment: set password failed, reason: back button");
                this.Y.setResult(0, intent);
                return;
            }
            super.uh();
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void wa(boolean z16, boolean z17, boolean z18, int i3) {
        QLog.d("StudyPwdVerifyFragment", 1, "ISwitchSimpleUICallback, isSuc: " + z16 + ", bChangeTheme:  " + z17 + ", bSwitchElsePref: " + z18 + ", statusCode: " + i3);
    }

    protected void hi() {
        QLog.i("StudyPwdVerifyFragment", 1, "getToAppeal");
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getActivity(), RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putString("url", "https://accounts.qq.com/teenager/psw/reset");
        QRoute.startUri(activityURIRequest, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra("jumpType", 0);
            if (intExtra == 1) {
                StudyPwdVerifyFragment.this.ji(false);
            } else if (intExtra == 2) {
                StudyPwdVerifyFragment.this.ji(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    protected void Nh(boolean z16, String str) {
        if (z16) {
            if (this.X == null) {
                QLog.i("StudyPwdSetFragment", 1, "onVerifyCodeComplete mApp == null");
                return;
            }
            if (ph()) {
                String k3 = StudyModeManager.k();
                QLog.i("StudyPwdSetFragment", 1, "verifyPassword pwd=" + com.tencent.mobileqq.studymode.f.b(str) + ",salt=" + com.tencent.mobileqq.studymode.f.b(k3));
                KidModeServlet.y(this.X, str, k3);
                Qh();
            }
        }
    }
}
