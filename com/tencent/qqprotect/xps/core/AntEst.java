package com.tencent.qqprotect.xps.core;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fe.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qsec.qsecurity.QSec;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.report.O3Report;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class AntEst {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final AntEst f363550a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19970);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f363550a = new AntEst();
            }
        }
    }

    AntEst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z16) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("QSec.Est", 2, "Start to query Est!");
            }
            String str = "est_time_qt_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            if (!z16) {
                long currentTimeMillis = System.currentTimeMillis() - from.decodeLong(str, 0L);
                if (currentTimeMillis < 86400000) {
                    g(86400000 - currentTimeMillis);
                    return;
                }
            }
            from.encodeLong(str, System.currentTimeMillis()).commitSync();
            String d16 = d();
            if (d16 != null && d16.length() > 0) {
                O3Report.j("est", d16, "1");
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static AntEst e() {
        return a.f363550a;
    }

    private void g(long j3) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqprotect.xps.core.AntEst.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AntEst.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    AntEst.this.c(false);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 192, null, true, j3);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            c(false);
        }
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String str = "";
        try {
            if (e.b().i()) {
                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                str = QSec.getInstance().getEstInfo(appInterface.getApplicationContext(), appInterface.getCurrentUin());
                if (QLog.isColorLevel()) {
                    QLog.d("QSec.Est", 2, "Est_data: " + str);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return str;
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            ThreadManagerV2.excute(new Runnable(i3) { // from class: com.tencent.qqprotect.xps.core.AntEst.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f363549d;

                {
                    this.f363549d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AntEst.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QSec.Est", 2, "Est_index: " + this.f363549d);
                    }
                    String d16 = AntEst.this.d();
                    if (!TextUtils.isEmpty(d16)) {
                        O3Report.j("est", d16, "1");
                    }
                }
            }, 192, null, true);
        }
    }
}
