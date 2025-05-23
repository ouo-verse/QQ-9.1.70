package com.tencent.mobileqq.activity.qqsettingme;

import android.net.Uri;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.util.db;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class q extends com.tencent.mobileqq.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public final MutableLiveData<BusinessInfoCheckUpdate.AppInfo> f185016h;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f185017a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68996);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[QQSettingMeBizBean.ActionType.values().length];
            f185017a = iArr;
            try {
                iArr[QQSettingMeBizBean.ActionType.MINIAPP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f185017a[QQSettingMeBizBean.ActionType.SCHEMA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f185017a[QQSettingMeBizBean.ActionType.WEB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f185017a[QQSettingMeBizBean.ActionType.DEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185016h = new MutableLiveData<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(BusinessInfoCheckUpdate.AppInfo appInfo) {
        com.tencent.mobileqq.qqsettingme.a aVar = this.f259742c.get();
        if (aVar != null) {
            aVar.y(w(), appInfo);
            aVar.k().P.setValue(new com.tencent.mobileqq.activity.qqsettingme.bean.k(w(), appInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(BusinessInfoCheckUpdate.AppInfo appInfo) {
        this.f185016h.setValue(appInfo);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            super.d(aVar);
            this.f185016h.observe(this.f259743d, new Observer() { // from class: com.tencent.mobileqq.activity.qqsettingme.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    q.this.o((BusinessInfoCheckUpdate.AppInfo) obj);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void j(final BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInfo, Boolean.valueOf(z16));
            return;
        }
        if (appInfo == null || appInfo.iNewFlag.get() == 0) {
            z17 = false;
        }
        am.b(appInfo);
        if (!this.f259745f) {
            return;
        }
        if (z16) {
            r(appInfo, z17);
        }
        am.a(MobileQQ.sMobileQQ.peekAppRuntime(), appInfo, this.f259744e);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.o
            @Override // java.lang.Runnable
            public final void run() {
                q.this.p(appInfo);
            }
        });
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c(w());
        if (c16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeBaseProcessor", 2, "onClick(), bizId = ", w(), ", bizBean == null");
                return;
            }
            return;
        }
        QQSettingMeBizBean.a h16 = c16.h();
        if (Uri.parse(h16.f184990b) == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeBaseProcessor", 2, "QQSettingMeBaseMenuProcessor#onClick, ", h16.f184990b, ", uri==null");
            }
            h16.f184989a = QQSettingMeBizBean.ActionType.DEFAULT;
        }
        int i3 = a.f185017a[h16.f184989a.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        q(view);
                        return;
                    }
                    return;
                }
                db.a(qBaseActivity, h16.f184990b, false, false);
                return;
            }
            db.b(qBaseActivity, h16.f184990b);
            return;
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(qBaseActivity, h16.f184990b, 2066, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        }
    }

    protected void r(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appInfo, Boolean.valueOf(z16));
        }
    }
}
