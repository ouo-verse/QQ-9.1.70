package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* loaded from: classes10.dex */
public class QQSettingMeNicknameProcessor extends com.tencent.mobileqq.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private String f184710h;

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<String> f184711i;

    /* renamed from: j, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.h> f184712j;

    /* loaded from: classes10.dex */
    class a implements Observer<String> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184714d;

        a(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184714d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeNicknameProcessor.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            this.f184714d.H(str);
            QQSettingMeViewModel k3 = this.f184714d.k();
            if (k3 != null) {
                k3.L.postValue(str);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.h> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184716d;

        b(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184716d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeNicknameProcessor.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.activity.qqsettingme.bean.h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar);
                return;
            }
            this.f184716d.I(hVar);
            QQSettingMeViewModel k3 = this.f184716d.k();
            if (k3 != null) {
                k3.M.postValue(hVar);
            }
        }
    }

    public QQSettingMeNicknameProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184711i = new MutableLiveData<>();
            this.f184712j = new MutableLiveData<>();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
        } else {
            this.f259740a = new WeakReference<>(appRuntime);
            e();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f184711i.observe(this.f259743d, new a(aVar));
            this.f184712j.observe(this.f259743d, new b(aVar));
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeNicknameProcessor.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeNicknameProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    String currentUin = peekAppRuntime.getCurrentUin();
                    String G = com.tencent.mobileqq.utils.ac.G((QQAppInterface) peekAppRuntime, currentUin);
                    if (G != null && !"".equals(G.trim())) {
                        currentUin = G;
                    }
                    com.tencent.mobileqq.activity.qqsettingme.bean.h hVar = new com.tencent.mobileqq.activity.qqsettingme.bean.h();
                    hVar.f184909a = currentUin;
                    QQSettingMeNicknameProcessor.this.f184712j.postValue(hVar);
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeBaseProcessor", 2, "jumpToProfile");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AllInOne allInOne = new AllInOne(peekAppRuntime.getCurrentAccountUin(), 0);
        allInOne.lastActivity = 1;
        allInOne.profileEntryType = 8;
        ProfileUtils.openProfileCardForResult(qBaseActivity, allInOne, 1009);
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).checkToCleanSettingMeRedPointGuide((QQAppInterface) peekAppRuntime);
        ReportController.o(peekAppRuntime, "CliOper", "", "", "0X80072D6", "0X80072D6", 0, 0, "", "", "", "");
        VideoReport.reportEvent("clck", view, null);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        if (currentAccountUin != null && currentAccountUin.equals(this.f184710h)) {
            ThreadManagerV2.excute(new Runnable(peekAppRuntime) { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeNicknameProcessor.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AppRuntime f184713d;

                {
                    this.f184713d = peekAppRuntime;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeNicknameProcessor.this, (Object) peekAppRuntime);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (this.f184713d != null) {
                        ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).checkAndGetSelfNickName(this.f184713d);
                    }
                }
            }, 16, null, true);
        }
        e();
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void preload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        String property = peekAppRuntime.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + currentAccountUin);
        this.f184710h = property;
        if (property == null || "".equals(property.trim())) {
            this.f184710h = currentAccountUin;
        }
        this.f184711i.setValue(this.f184710h);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_nickname";
    }
}
