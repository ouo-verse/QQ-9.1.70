package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.minorsmode.api.IMinorsModeApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.ModeChoiceViewContainer;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.studymode.pwdverify.PwdVerifySuccess;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class s implements l.a, SimpleEventReceiver {
    static IPatchRedirector $redirector_;
    private KidModeObserver C;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f291022d;

    /* renamed from: e, reason: collision with root package name */
    protected QBaseActivity f291023e;

    /* renamed from: f, reason: collision with root package name */
    protected View f291024f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f291025h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f291026i;

    /* renamed from: m, reason: collision with root package name */
    private ModeChoiceViewContainer.k f291027m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends KidModeObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void c(KidModeObserver.QueryPasswordStateResult queryPasswordStateResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) queryPasswordStateResult);
                return;
            }
            if (queryPasswordStateResult == null) {
                QLog.i("KidModeObserver", 1, "onQueryPasswordState result == null");
                return;
            }
            QLog.i("KidModeObserver", 1, "onQueryPasswordState errCode=" + queryPasswordStateResult.errCode + ",State=" + queryPasswordStateResult.passwordState + ",salt=" + f.b(queryPasswordStateResult.salt));
            if (queryPasswordStateResult.errCode == 0) {
                StudyModeManager.N(queryPasswordStateResult.passwordState, queryPasswordStateResult.salt);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void d(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle);
                return;
            }
            if (!s.this.f291023e.isResume()) {
                if (QLog.isColorLevel()) {
                    QLog.d("KidModeObserver", 2, "onSendGetKidModeStatusSuccess but setting Activity is not resume");
                }
            } else if (z16) {
                StudyModeManager.L(bundle.getInt("KID_MODE_NEED_VERIFY"));
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void f(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            QLog.i("KidModeObserver", 1, "onSendSmsCodeSuccess isSuccess" + z16);
        }
    }

    public s(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) qBaseActivity);
            return;
        }
        this.f291025h = false;
        this.f291026i = false;
        this.C = new a();
        this.f291022d = qQAppInterface;
        this.f291023e = qBaseActivity;
        h();
    }

    private void l(int i3, Intent intent) {
        if (intent == null) {
            QLog.i("StudyModeBaseUI", 1, "doOnActivityResult REQ_ENTER_STUDY_MODEL_FRONT_PAGE params exception, data is null");
            return;
        }
        int intExtra = intent.getIntExtra("extra_target_mode", -1);
        int intExtra2 = intent.getIntExtra("extra_old_mode", -1);
        int intExtra3 = intent.getIntExtra("extra_source", -1);
        boolean booleanExtra = intent.getBooleanExtra("key_is_jump_to_next", false);
        boolean booleanExtra2 = intent.getBooleanExtra("extra_mode_change_success", false);
        QLog.i("StudyModeBaseUI", 1, "doOnActivityResult REQ_ENTER_STUDY_MODEL_FRONT_PAGE resultCode=" + i3 + ", targetMode: " + intExtra + ", oldMode: " + intExtra2 + ", src: " + intExtra3 + ", jumpToNext: " + booleanExtra + ", modeChangeSuc:" + booleanExtra2);
        if (intExtra != -1 && intExtra2 != -1 && intExtra3 != -1) {
            if (intExtra3 == 5 && i3 == -1 && !booleanExtra2) {
                ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startKidModeAdvanceSettingFragment(this.f291023e, false, null);
                return;
            }
            if (intExtra == 2 && i3 == -1 && booleanExtra2) {
                if (booleanExtra) {
                    ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startKidModeAdvanceSettingFragmentForResult(this.f291023e, true, 5);
                    return;
                } else {
                    JumpKidModeMgr.b().i(intExtra2, intExtra, this.f291023e, intExtra3, 1, false);
                    return;
                }
            }
            if (i3 != -1 && intExtra3 == 2) {
                f(R.string.hhx, 1);
            }
        }
    }

    private void m(int i3, Intent intent) {
        int i16;
        int i17;
        boolean h16 = JumpKidModeMgr.b().h();
        int d16 = JumpKidModeMgr.b().d();
        int c16 = JumpKidModeMgr.b().c();
        if (intent != null) {
            i17 = intent.getIntExtra("ExtraTargetAction", -1);
            i16 = intent.getIntExtra("extra_source", -1);
        } else {
            i16 = -1;
            i17 = -1;
        }
        boolean z16 = true;
        QLog.i("StudyModeBaseUI", 1, "doOnActivityResult REQ_CHANGE_STUDY_MODEL_SWITCH resultCode=" + i3 + ",lastTargetMode=" + d16 + ",lastOldMode=" + c16 + ",isJumpToStudyPwdVerify=" + h16 + ", action=" + i17 + ", src=" + i16);
        if (d16 != -1 && c16 != -1) {
            if (i3 != -1 || !StudyModeManager.z(i17, i16)) {
                if (i3 != -1) {
                    z16 = false;
                }
                k(z16, d16, c16, h16);
            }
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void Aa(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void C6(boolean z16, @NonNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(z16), obj);
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void W1(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public synchronized void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!this.f291026i) {
            this.f291026i = true;
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    public synchronized void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!this.f291025h) {
            this.f291025h = true;
            ((l) this.f291022d.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).d(this);
        }
    }

    public void c(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (intent != null && p.f(intent.getIntExtra("extra_source", -1))) {
            QLog.d("StudyModeBaseUI", 1, "doOnActivityResult is from isOuterBizToCheckPwd, return directly");
            return;
        }
        if (i3 == 2) {
            m(i16, intent);
            return;
        }
        if (i3 == 4) {
            l(i16, intent);
            return;
        }
        if (i3 == 5) {
            if (intent == null) {
                QLog.i("StudyModeBaseUI", 1, "doOnActivityResult REQ_ENTER_ADVANCED_SETTINGS_PAGE params exception, data is null");
                return;
            }
            int intExtra = intent.getIntExtra("extra_target_mode", -1);
            int intExtra2 = intent.getIntExtra("extra_old_mode", -1);
            int intExtra3 = intent.getIntExtra("extra_source", -1);
            QLog.i("StudyModeBaseUI", 1, "doOnActivityResult REQ_ENTER_ADVANCED_SETTINGS_PAGE resultCode=" + i16 + ", data: " + intent + ", targetMode: " + intExtra + ", oldMode: " + intExtra2 + ", src: " + intExtra3);
            if (intExtra != -1 && intExtra2 != -1 && intExtra3 != -1 && i16 == -1 && intExtra3 == 5) {
                JumpKidModeMgr.b().i(intExtra, intExtra2, this.f291023e, intExtra3, 1, false);
            }
        }
    }

    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f291024f;
    }

    protected abstract View e();

    @Override // com.tencent.mobileqq.studymode.l.a
    public void ed(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            QQToast.makeText(BaseApplication.getContext(), i16, i3, 0).show(this.f291023e.getTitleBarHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, i3);
        } else {
            QQToast.makeText(BaseApplication.getContext(), i3, str, 0).show(this.f291023e.getTitleBarHeight());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ArrayList) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(PwdVerifySuccess.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f291024f = e();
        this.f291022d.registObserver(this.C);
        b();
        a();
        KidModeServlet.m(this.f291022d);
    }

    public synchronized void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.f291026i = false;
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    public synchronized void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            ((l) this.f291022d.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).v(this);
            this.f291025h = false;
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void j7(boolean z16, int i3, int i16, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str);
        }
    }

    protected void k(boolean z16, int i3, int i16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17));
            return;
        }
        if (z16) {
            if (i3 == 2 && !z17) {
                ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startKidModeAdvanceSettingFragmentForResult(this.f291023e, true, 5);
                return;
            } else {
                t.d(i3, this.f291022d, this.f291023e, this.f291027m);
                return;
            }
        }
        f(R.string.hhx, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f291022d.unRegistObserver(this.C);
        j();
        i();
        if (JumpKidModeMgr.b().r()) {
            KidModeServlet.p(this.f291022d, null);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof PwdVerifySuccess) {
            boolean h16 = JumpKidModeMgr.b().h();
            int d16 = JumpKidModeMgr.b().d();
            int c16 = JumpKidModeMgr.b().c();
            QLog.i("StudyModeBaseUI", 1, "onReceiveEvent, password verify suc, targetMode=" + d16 + ",oldMode=" + c16 + ",isJumpToStudyPwdVerify=" + h16);
            if (d16 != -1 && c16 != -1) {
                k(true, d16, c16, h16);
            }
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void wa(boolean z16, boolean z17, boolean z18, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3));
        }
    }
}
