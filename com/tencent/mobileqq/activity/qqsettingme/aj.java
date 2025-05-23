package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import tencent.im.oidb.redInfo$RedInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class aj extends com.tencent.mobileqq.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.j> f184811h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f184812i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f184813j;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.j> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184814d;

        a(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184814d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aj.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.activity.qqsettingme.bean.j jVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jVar);
                return;
            }
            this.f184814d.M(jVar);
            QQSettingMeViewModel k3 = this.f184814d.k();
            if (k3 != null) {
                k3.Q.postValue(jVar);
            }
        }
    }

    public aj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184811h = new MutableLiveData<>(new com.tencent.mobileqq.activity.qqsettingme.bean.j());
        }
    }

    @NonNull
    private com.tencent.mobileqq.activity.qqsettingme.bean.j m() {
        if (this.f184811h.getValue() == null) {
            return new com.tencent.mobileqq.activity.qqsettingme.bean.j();
        }
        return this.f184811h.getValue();
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
            return;
        }
        this.f259740a = new WeakReference<>(appRuntime);
        if (this.f184812i) {
            e();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f184812i = false;
            this.f184811h.observe(this.f259743d, new a(aVar));
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void e() {
        boolean z16;
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.qqsettingme.bean.j jVar = new com.tencent.mobileqq.activity.qqsettingme.bean.j();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) peekAppRuntime.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        RedTouchItem j3 = localRedTouchManager.j(-4);
        if (localRedTouchManager.d(j3, true) && j3.count > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        jVar.f184915a = z16;
        if (z16) {
            jVar.f184916b = j3.count;
            jVar.f184918d = localRedTouchManager.j(10028);
            ProfileCardUtil.f((QQAppInterface) peekAppRuntime);
            redInfo$RedInfo redinfo_redinfo = new redInfo$RedInfo();
            if (localRedTouchManager.d(j3, true) && j3.count > 0) {
                try {
                    Object readObject = FileUtils.readObject(com.tencent.mobileqq.nearby.redtouch.a.c(-4));
                    if (readObject instanceof RedTouchItemExtMsg) {
                        redinfo_redinfo.mergeFrom(((RedTouchItemExtMsg) readObject).bytesData);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("QQSettingMe", 2, e16.getMessage(), e16);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQSettingMe", 2, "updateProfileBubbleMsgInfo red point: " + j3.redtouchType);
                }
            } else {
                redinfo_redinfo = null;
            }
            jVar.f184917c = redinfo_redinfo;
            jVar.f184919e = BaseImageUtil.getDefaultFaceDrawable(true);
        }
        if (jVar.f184915a && jVar.f184917c != null && !this.f184813j) {
            RedTouchItem redTouchItem = jVar.f184918d;
            if (redTouchItem != null && redTouchItem.count > 0 && redTouchItem.unReadFlag) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQSettingMeBaseProcessor", 2, "checkAndReportAnonymousAnswerMsgExpose");
                }
                appRuntime = peekAppRuntime;
                ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800B47F", "0X800B47F", 0, 0, "", "", "", "");
            } else {
                appRuntime = peekAppRuntime;
            }
            ReportController.o(appRuntime, "dc00898", "", "", "0X800A97E", "0X800A97E", 0, 0, "0", "0", "", "");
            this.f184813j = true;
        }
        this.f184811h.setValue(jVar);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        RedTouchItem redTouchItem = m().f184918d;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (redTouchItem != null && redTouchItem.count > 0 && redTouchItem.unReadFlag) {
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeBaseProcessor", 2, "checkAndReportAnonymousAnswerMsgClick");
            }
            ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800B480", "0X800B480", 0, 0, "", "", "", "");
        }
        ProfileCardUtil.U(qBaseActivity);
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A97F", "0X800A97F", 0, 0, "0", "0", "", "");
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onPause();
            this.f184813j = false;
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            e();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        e();
        this.f184812i = true;
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_profile_bubble";
    }
}
