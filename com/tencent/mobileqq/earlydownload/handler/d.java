package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.av.so.ResInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.earlydownload.xmldata.FaceScanNativeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends b {
    static IPatchRedirector $redirector_;
    private int E;
    private boolean F;

    public d(QQAppInterface qQAppInterface) {
        super("qq.android.ar.face.so_v8.5.2_64", qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.F = false;
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoDownloadHandler", 2, "FaceScanNativeSoDownloadHandler construct,STR_RES_NAME = qq.android.ar.face.so_v8.5.2_64,AppSetting.IS_CPU_64_BIT = true");
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void E(XmlData xmlData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) xmlData);
            return;
        }
        super.E(xmlData);
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoDownloadHandler", 2, "download begin");
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
            FaceScanDownloadManager.k(1, false);
        }
        super.G(xmlData, z16, i3, str);
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoDownloadHandler", 2, "download finish: " + z16);
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
        int i3 = (int) ((j3 * 100) / j16);
        this.E = i3;
        FaceScanDownloadManager.j(1, i3);
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoDownloadHandler", 2, "download progress: " + this.E);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        if (!this.F) {
            this.F = z16;
        }
        super.I(z16);
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoDownloadHandler", 2, "download restart userClick" + z16);
        }
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoDownloadHandler", 2, "restoreState");
        }
        o().loadState = 0;
        o().Version = 0;
        com.tencent.mobileqq.earlydownload.a.f(o(), new String[0]);
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            BaseApplicationImpl.sApplication.getSharedPreferences("face_scan_sp", 4).edit().putInt("face_scan_native_so_version", v()).apply();
        }
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
        boolean c16 = com.tencent.mobileqq.filemanager.util.q.c(new File(com.tencent.mobileqq.ar.p.c()));
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoDownloadHandler", 2, "deleteUnZipFile ret: " + c16);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoDownloadHandler", 2, "download success: " + str);
        }
        byte a16 = com.tencent.mobileqq.ar.p.a(str);
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoDownloadHandler", 2, "download success: " + str + ",ret = " + ((int) a16));
        }
        if (a16 != 0) {
            M();
            N();
            FaceScanDownloadManager.k(1, false);
        } else {
            FaceScanDownloadManager.k(1, true);
            ReportController.o(this.f203921f, "dc00898", "", "", "0X8008358", "0X8008358", 0, 0, "", "", ResInfo.RES_TYPE_SO, "");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("res_type", ResInfo.RES_TYPE_SO);
            StatisticCollector.getInstance(this.f203921f.getApp()).collectPerformance(this.f203921f.getCurrentAccountUin(), "FaceResDownloadSuccess", true, 0L, 0L, hashMap, "", true);
        }
        super.i(str);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean k() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoDownloadHandler", 2, "downloadResource,isDownloadReqedByUser = " + this.F);
        }
        if (!this.F) {
            if (!FaceScanDownloadManager.e((QQAppInterface) this.f203921f)) {
                if (QLog.isColorLevel()) {
                    QLog.d("FaceScanNativeSoDownloadHandler", 2, "pre download config disable ");
                }
                return false;
            }
            if (BaseActivity.sTopActivity != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanNativeSoDownloadHandler", 2, "downloadResource later " + z16);
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
        return 10061;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public Class<? extends XmlData> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return FaceScanNativeSoData.class;
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
        return null;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.F) {
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanNativeSoDownloadHandler", 2, "isNetValid2Download by user ");
                return true;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoDownloadHandler", 2, "isNetValid2Download by startup ");
        }
        return super.z();
    }
}
