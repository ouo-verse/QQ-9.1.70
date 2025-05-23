package com.tencent.mobileqq.vip;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.download.api.IDownloadAdapter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class f {
    static IPatchRedirector $redirector_;
    String wifiFlow;
    String xgFlow;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private void reportErrorToMM(g gVar) {
        if (QLog.isColorLevel()) {
            QLog.e("DownloadListener", 2, "-->report MM");
        }
        if (gVar.i() != 3) {
            if (QLog.isColorLevel()) {
                QLog.e("DownloadListener", 2, "-->report MM:command=" + gVar.f313011i + ",error code=" + gVar.f313006d + ",uin=" + gVar.Z.f313030b);
            }
            vipReportCgi(gVar);
        }
    }

    private void vipReportCgi(g gVar) {
        ((IDownloadAdapter) QRoute.api(IDownloadAdapter.class)).vipReportCgi(gVar);
    }

    public void onCancel(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) gVar);
        }
    }

    public void onDone(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) gVar);
            return;
        }
        gVar.I = System.currentTimeMillis();
        if (gVar.e((byte) 1)) {
            reportErrorToMM(gVar);
        }
    }

    public void onDoneFile(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) gVar);
        }
    }

    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d("DownloadListener", 2, "onNetMobile2None...");
        }
    }

    public void onNetWifi2Mobile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d("DownloadListener", 2, "onNetWifi2Mobile...");
        }
    }

    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d("DownloadListener", 2, "onNetWifi2None...");
        }
    }

    public void onPause(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) gVar);
        }
    }

    public void onProgress(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
        }
    }

    public boolean onStart(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar)).booleanValue();
        }
        gVar.H = System.currentTimeMillis();
        return true;
    }

    public void report(AppInterface appInterface, long j3) {
        String[] strArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, appInterface, Long.valueOf(j3));
            return;
        }
        if (this.wifiFlow != null && this.xgFlow != null && appInterface != null) {
            int systemNetwork = NetworkUtil.getSystemNetwork(appInterface.getApplication().getApplicationContext());
            if (systemNetwork > 0) {
                if (systemNetwork == 1) {
                    strArr = new String[]{this.wifiFlow, "param_WIFIFlow", "param_Flow"};
                } else {
                    strArr = new String[]{this.xgFlow, "param_XGFlow", "param_Flow"};
                }
            } else {
                strArr = null;
            }
            if (strArr != null && j3 > 0 && QLog.isColorLevel()) {
                QLog.d("com.tencent.mobileqq.vip.DownloadListener", 2, "report | tags=" + strArr + ",len=" + j3);
            }
        }
    }

    public f(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            this.wifiFlow = str;
            this.xgFlow = str2;
        }
    }
}
