package com.tencent.mobileqq.qrscan.earlydown;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager;
import com.tencent.mobileqq.qrscan.minicode.MiniScanReport;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b extends com.tencent.mobileqq.earlydownload.handler.b {
    static IPatchRedirector $redirector_;
    private int E;
    private boolean F;

    public b(AppRuntime appRuntime) {
        super("qq.android.minidecode.so_v8.8.5", appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.F = false;
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void D(boolean z16) {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        long q16 = MiniScanReport.q("report_tag_so_cover", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - q16 > 86400000) {
            XmlData o16 = o();
            boolean z17 = false;
            if (o16 != null && (o16 instanceof MiniScanDecodeSoData)) {
                i3 = ((MiniScanDecodeSoData) o16).Version;
                str = c.s("minicode");
                if (o16.loadState == 1 && i3 > 0 && !TextUtils.isEmpty(str)) {
                    z17 = true;
                }
            } else {
                str = "";
                i3 = 0;
            }
            MiniScanReport.p(z17, i3, str);
            MiniScanReport.r("report_tag_so_cover", currentTimeMillis);
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
            QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download begin");
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
            N();
            QRScanResDownloadManager.g(0, false);
        }
        super.G(xmlData, z16, i3, str);
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download finish: " + z16);
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
            QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download progress: " + this.E);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        XmlData o16 = o();
        if (z16 && (o16 instanceof MiniScanDecodeSoData)) {
            MiniScanDecodeSoData miniScanDecodeSoData = (MiniScanDecodeSoData) o16;
            if (QLog.isColorLevel()) {
                QLog.i("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, String.format("restartDownload block_user_download=%b", Boolean.valueOf(miniScanDecodeSoData.block_user_download)));
            }
            if (miniScanDecodeSoData.block_user_download) {
                return;
            }
        }
        if (!this.F) {
            this.F = z16;
        }
        super.I(z16);
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "restartDownload userClick=" + z16);
        }
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "restoreState");
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
            QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ, "mini_scan_sp", 4).edit().putInt("minidecode_so_version", v()).apply();
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
        boolean c16 = q.c(new File(c.o()));
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "deleteUnZipFile ret: " + c16);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        byte n3 = c.n(str);
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "doOnDownloadSuccess ret=" + ((int) n3) + ", filePath=" + str);
        }
        if (n3 != 0) {
            M();
            N();
            QRScanResDownloadManager.g(0, false);
        } else {
            QRScanResDownloadManager.g(0, true);
        }
        super.i(str);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (!this.F) {
            boolean z16 = !QBaseActivity.mAppForground;
            if (QLog.isColorLevel()) {
                QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "downloadResource later " + z16);
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
        return ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).getEarlyDownBusId(1);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public Class<? extends XmlData> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return MiniScanDecodeSoData.class;
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
        return "MiniScanDecodeSoData";
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.F) {
            if (QLog.isColorLevel()) {
                QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "isNetValid2Download by user ");
                return true;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "isNetValid2Download by startup ");
        }
        return super.z();
    }
}
