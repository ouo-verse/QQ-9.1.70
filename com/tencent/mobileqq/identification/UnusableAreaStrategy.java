package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.identification.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes15.dex */
public class UnusableAreaStrategy implements k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f237909a;

    public UnusableAreaStrategy(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f237909a = str;
        }
    }

    @Override // com.tencent.mobileqq.identification.k
    public void a(k.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            ReportController.r(null, "dc00898", "", "", "0X800B0EA", "0X800B0EA", 0, 0, "", "", "", "");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.identification.UnusableAreaStrategy.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UnusableAreaStrategy.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(BaseApplication.context, UnusableAreaStrategy.this.f237909a, 0).show();
                    }
                }
            });
        }
    }
}
