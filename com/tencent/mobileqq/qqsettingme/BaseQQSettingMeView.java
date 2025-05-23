package com.tencent.mobileqq.qqsettingme;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.part.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.w;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class BaseQQSettingMeView extends a {
    static IPatchRedirector $redirector_;
    protected b D;
    protected final QQSettingMeViewModel E;
    protected w F;

    public BaseQQSettingMeView(@NonNull QBaseActivity qBaseActivity, @NonNull ViewGroup viewGroup) {
        super(qBaseActivity, viewGroup);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) viewGroup);
            return;
        }
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) h.b(this.f274438f, QQSettingMeViewModel.f312690m0).get(QQSettingMeViewModel.class);
        this.E = qQSettingMeViewModel;
        QLog.i("BaseQQSettingMeView", 2, "BaseQQSettingMeView: owner: " + this.f274438f + ", viewModel: " + qQSettingMeViewModel);
        w wVar = new w();
        this.F = wVar;
        wVar.onStart();
        b bVar = new b(viewGroup, qBaseActivity, this.F);
        this.D = bVar;
        bVar.b(V());
    }

    public static boolean W() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("SETTING_ME_UPDATE_NAVIGATION_BAR", true);
    }

    public static boolean X() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("SETTING_ME_USE_NEW_IMMERSIVE", true);
    }

    @Nullable
    public abstract List<com.tencent.mobileqq.part.a> V();

    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BaseQQSettingMeView", 2, "-->onDestroy!");
        }
        this.F.onDestroy();
        this.D.d();
        this.E.onDestroy();
        a.C.clear();
    }

    public void Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f274437e = true;
        this.E.Z1();
        this.D.f();
    }

    public void a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f274437e = false;
        this.D.g();
        this.E.a2();
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void b(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime);
            return;
        }
        super.b(appRuntime);
        if (QLog.isColorLevel()) {
            QLog.i("BaseQQSettingMeView", 2, "-->fillData, isInit:" + this.f274436d);
        }
        this.E.M1(appRuntime);
        this.D.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            QLog.i("BaseQQSettingMeView", 1, "preload");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d0() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        if (QQTheme.isNowThemeIsNight()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("zplan_page_model", str);
        QQSettingMeViewModel qQSettingMeViewModel = this.E;
        if (qQSettingMeViewModel != null) {
            str2 = qQSettingMeViewModel.P1();
        } else {
            str2 = "";
        }
        if (str2 != null) {
            hashMap.put("drawer_cover", str2);
        }
        VideoReport.setPageParams(this.f274439h, new PageParams(hashMap));
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public QQSettingMeViewModel k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QQSettingMeViewModel) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.E;
    }

    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BaseQQSettingMeView", 2, "-->onPostThemeChanged");
        }
        this.D.h();
        this.f274439h.post(new Runnable() { // from class: com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseQQSettingMeView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    BaseQQSettingMeView.this.E.b2();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.p();
        if (QLog.isColorLevel()) {
            QLog.i("BaseQQSettingMeView", 2, "-->onPause!");
        }
        this.D.j();
        this.E.onPause();
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.q();
        if (QLog.isColorLevel()) {
            QLog.i("BaseQQSettingMeView", 2, "-->onResume!");
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.r();
            this.D.i();
        }
    }
}
