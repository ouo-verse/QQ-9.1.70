package com.tencent.mobileqq.qrscan.earlydown;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class h extends com.tencent.mobileqq.earlydownload.handler.b {
    static IPatchRedirector $redirector_;
    private int E;
    private boolean F;

    public h(AppRuntime appRuntime) {
        super("qq.android.qbarnative.model_v8.6.0", appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.F = false;
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void E(XmlData xmlData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) xmlData);
            return;
        }
        super.E(xmlData);
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.QBarModelDownloadHandler", 2, "download begin");
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void G(XmlData xmlData, boolean z16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, xmlData, Boolean.valueOf(z16), Integer.valueOf(i3), str);
            return;
        }
        if (!z16) {
            M();
            QRScanResDownloadManager.g(3, false);
        }
        super.G(xmlData, z16, i3, str);
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.QBarModelDownloadHandler", 2, "download finish: " + z16);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void H(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        super.H(j3, j16);
        this.E = (int) ((j3 * 100) / j16);
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.QBarModelDownloadHandler", 2, "download progress: " + this.E);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        if (!this.F) {
            this.F = z16;
        }
        super.I(z16);
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.QBarModelDownloadHandler", 2, "restartDownload userClick=" + z16);
        }
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.QBarModelDownloadHandler", 2, "restoreState");
        }
        o().loadState = 0;
        o().Version = 0;
        com.tencent.mobileqq.earlydownload.a.f(o(), new String[0]);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        boolean c16 = q.c(new File(i.o()));
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.QBarModelDownloadHandler", 2, "deleteUnZipFile ret: " + c16);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        byte n3 = i.n(str);
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.QBarModelDownloadHandler", 2, "doOnDownloadSuccess ret=" + ((int) n3) + ", filePath=" + str);
        }
        if (n3 != 0) {
            M();
            QRScanResDownloadManager.g(3, false);
        } else {
            QRScanResDownloadManager.g(3, true);
        }
        super.i(str);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (!this.F) {
            boolean z16 = !QBaseActivity.mAppForground;
            if (QLog.isColorLevel()) {
                QLog.d("MiniRecog.QBarModelDownloadHandler", 2, "downloadResource later " + z16);
            }
            if (z16) {
                return false;
            }
        }
        return super.k();
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).getEarlyDownBusId(4);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public Class<? extends XmlData> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return QBarModelData.class;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return PreDownloadConstants.DEPARTMENT_PRD;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "QBarModelData";
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.F) {
            if (QLog.isColorLevel()) {
                QLog.d("MiniRecog.QBarModelDownloadHandler", 2, "isNetValid2Download by user ");
                return true;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.QBarModelDownloadHandler", 2, "isNetValid2Download by startup ");
        }
        return super.z();
    }
}
