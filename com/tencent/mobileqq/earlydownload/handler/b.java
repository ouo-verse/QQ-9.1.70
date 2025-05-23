package com.tencent.mobileqq.earlydownload.handler;

import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.relation.api.IConfigHandlerTempService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.util.QQFaceFileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceReqInfoV2;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class b {
    static IPatchRedirector $redirector_;
    static final String D;
    protected boolean C;

    /* renamed from: d, reason: collision with root package name */
    protected String f203919d;

    /* renamed from: e, reason: collision with root package name */
    private XmlData f203920e;

    /* renamed from: f, reason: collision with root package name */
    protected AppRuntime f203921f;

    /* renamed from: h, reason: collision with root package name */
    protected ArrayList<com.tencent.mobileqq.earlydownload.b> f203922h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f203923i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f203924m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24849);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
            return;
        }
        D = AppConstants.SDCARD_PATH + "pddata/prd/early";
    }

    public b(String str, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) appRuntime);
        } else {
            this.f203919d = str;
            this.f203921f = appRuntime;
        }
    }

    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        XmlData o16 = o();
        if (o16 == null || o16.loadState != 1) {
            return false;
        }
        return true;
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        XmlData o16 = o();
        boolean z16 = false;
        if (o16 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = o16.tLoadFail;
            if (j3 == 0 || (j3 > 0 && j3 + 43200000 < currentTimeMillis)) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "isTimeValid() " + z16 + " res=" + o16.strResName + " tLoadFail=" + o16.tLoadFail);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 4, "isTimeValid() = false,  data = null");
        }
        return z16;
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        return true;
    }

    public void D(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, z16);
        }
    }

    public void E(XmlData xmlData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) xmlData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 4, "onDownloadBegin()");
        }
        ArrayList<com.tencent.mobileqq.earlydownload.b> arrayList = this.f203922h;
        if (arrayList != null) {
            Iterator<com.tencent.mobileqq.earlydownload.b> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b(xmlData);
            }
        }
    }

    public void F(XmlData xmlData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) xmlData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("EarlyDown", 2, "onDownloadCancel");
        }
        ArrayList<com.tencent.mobileqq.earlydownload.b> arrayList = this.f203922h;
        if (arrayList != null) {
            Iterator<com.tencent.mobileqq.earlydownload.b> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().d(xmlData);
            }
        }
    }

    public void G(XmlData xmlData, boolean z16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, xmlData, Boolean.valueOf(z16), Integer.valueOf(i3), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "onDownloadFinish() result=" + z16 + " filePath=" + str);
        }
        if (z16) {
            xmlData.hasResDownloaded = true;
            com.tencent.mobileqq.earlydownload.a.f(xmlData, "hasResDownloaded");
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "EarlyHandler, onDownloadFinish,download Successful, hasResDownloaded=true, resName=" + this.f203919d + "this=" + this);
            }
            i(str);
            ((IPreDownloadController) this.f203921f.getRuntimeService(IPreDownloadController.class, "")).preDownloadSuccess(xmlData.strResURL_big, xmlData.downSize);
        } else {
            xmlData.hasResDownloaded = false;
            com.tencent.mobileqq.earlydownload.a.f(xmlData, "hasResDownloaded");
            QLog.d("EarlyDown", 1, "EarlyHandler, onDownloadFinish,download failed, hasResDownloaded=false, resName=" + this.f203919d);
            ArrayList<com.tencent.mobileqq.earlydownload.b> arrayList = this.f203922h;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<com.tencent.mobileqq.earlydownload.b> it = this.f203922h.iterator();
                while (it.hasNext()) {
                    it.next().c(xmlData, z16, i3, e(), str);
                }
            }
        }
        if (this.C) {
            Intent intent = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
            if (i3 == 9037) {
                intent.setAction("resp.com.tencent.mobileqq.EARLY_CANCEL");
            } else {
                intent.setAction("resp.com.tencent.mobileqq.EARLY_QUERY");
            }
            intent.putExtra("strResName", this.f203919d);
            intent.putExtra("strPkgName", o().strPkgName);
            intent.putExtra("loadState", o().loadState);
            intent.putExtra("totalSize", xmlData.totalSize);
            intent.putExtra("downSize", xmlData.downSize);
            intent.putExtra("errCode", i3);
            intent.putExtra("resPath", str);
            MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(intent, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
            this.C = false;
        }
    }

    public void H(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(j3), Long.valueOf(j16));
        } else if (this.f203922h != null) {
            XmlData o16 = o();
            Iterator<com.tencent.mobileqq.earlydownload.b> it = this.f203922h.iterator();
            while (it.hasNext()) {
                it.next().a(o16, j3, j16);
            }
        }
    }

    public void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        new File(u()).delete();
        XmlData o16 = o();
        o16.Version = 0;
        o16.tLoadFail = 0L;
        o16.loadState = 0;
        o16.hasResDownloaded = false;
        com.tencent.mobileqq.earlydownload.a.f(o16, "Version", "loadState", "tLoadFail", "hasResDownloaded");
        o16.isUserClick = z16;
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "restartDownload(), this.strResName=" + this.f203919d + ", resName=" + o16.strResName + ", user=" + z16);
        }
        Intent intent = new Intent();
        GetResourceReqInfo r16 = r();
        if (r16 != null) {
            IEarlyDownloadService iEarlyDownloadService = (IEarlyDownloadService) this.f203921f.getRuntimeService(IEarlyDownloadService.class, "");
            if (iEarlyDownloadService != null && !iEarlyDownloadService.isRequesting(o16.getStrResName())) {
                intent.putExtra("reqResult", true);
                iEarlyDownloadService.addRequesting(o16.getStrResName());
                ((IConfigHandlerTempService) this.f203921f.getRuntimeService(IConfigHandlerTempService.class, "")).doConfigHandlerUpdateConfigs(this.f203921f, null, r16);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 2, String.format("restartDownload() res[%s] is downloading", o16.getStrResName()));
                }
                intent.putExtra("reqResult", false);
                intent.putExtra("resultReason", "strPkgName=" + o16.strPkgName);
            }
        } else {
            intent.putExtra("reqResult", false);
            intent.putExtra("resultReason", "strPkgName=" + o16.strPkgName);
        }
        if (this.C) {
            intent.setAction("resp.com.tencent.mobileqq.EARLY_DOWNLOAD");
            intent.putExtra("strResName", this.f203919d);
            intent.putExtra("strPkgName", o16.strPkgName);
            MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(intent, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
        }
    }

    public void J(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "setFail() resName:" + this.f203919d);
        }
        XmlData o16 = o();
        if (o16 != null) {
            int i3 = o16.loadState;
            if (i3 == 1) {
                o16.loadState = 0;
                o16.Version = 0;
            } else if (i3 == 2 && z16) {
                o16.loadState = 0;
            }
            o16.hasResDownloaded = false;
            com.tencent.mobileqq.earlydownload.a.f(o16, "loadState", "Version", "hasResDownloaded");
        }
    }

    public void K(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (this.C != z16) {
            this.C = z16;
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "setIsBroadcast() " + z16);
            }
        }
    }

    public synchronized void L(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
            return;
        }
        if (z16) {
            if (!this.f203923i) {
                this.f203923i = true;
                z17 = true;
            }
            z17 = false;
        } else {
            if (!this.f203924m) {
                this.f203924m = true;
                z17 = true;
            }
            z17 = false;
        }
        if (z17) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_strResName", this.f203919d);
            StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(this.f203921f.getCurrentAccountUin(), "actEarlyDownUse", z16, 0L, 0L, hashMap, "");
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "statisticUsage() strResName=" + this.f203919d + " inUse=" + z16);
            }
        }
    }

    public void c(com.tencent.mobileqq.earlydownload.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bVar);
            return;
        }
        if (bVar != null) {
            if (this.f203922h == null) {
                this.f203922h = new ArrayList<>();
            }
            if (!this.f203922h.contains(bVar)) {
                this.f203922h.add(bVar);
            }
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else if (!e()) {
            new File(u()).delete();
        }
    }

    public abstract boolean e();

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ArrayList<com.tencent.mobileqq.earlydownload.b> arrayList = this.f203922h;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        if (e()) {
            File file = new File(u());
            if (file.exists()) {
                boolean delete = file.delete();
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 2, "doAfterFinish() deleteResouceAfterDownload==true, delete storage:" + file.getAbsolutePath() + " bool=" + delete);
                }
            }
        }
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        ArrayList<com.tencent.mobileqq.earlydownload.b> arrayList = this.f203922h;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<com.tencent.mobileqq.earlydownload.b> it = this.f203922h.iterator();
            while (it.hasNext()) {
                it.next().c(o(), true, 0, e(), str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0384  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(XmlData xmlData) {
        String str;
        File file;
        boolean k3;
        String str2;
        String d16;
        String d17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) xmlData);
            return;
        }
        if (xmlData == null) {
            QLog.e("EarlyDown", 1, "doOnServerResp() return respData == null.");
            return;
        }
        XmlData o16 = o();
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 4, "doOnServerResp() called," + xmlData.strResName + ", pkg=" + xmlData.strPkgName + ", serverVer=" + xmlData.Version + " localVer=" + o16.Version + " localState=" + o16.loadState + ",strResURL_big = " + xmlData.strResURL_big + ",handler = " + this);
        }
        if (!TextUtils.equals(xmlData.strPkgName, o16.strPkgName)) {
            QLog.w("EarlyHandler", 1, "doOnServerResp() pkgName mismatch! resp:" + xmlData.strPkgName + " vs local:" + o16.strPkgName + ", will abandon download this time!");
            return;
        }
        File file2 = new File(u());
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "fStorage=" + file2.getAbsolutePath() + ", exist=" + file2.exists());
        }
        File file3 = null;
        if (file2.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "fStorage.length=" + file2.length());
            }
            try {
                d17 = HexUtil.bytes2HexStr(MD5.getFileMd5(file2.getAbsolutePath()));
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 2, "doOnServerResp, fStorage, OutOfMemoryError, oom.message=", e16.getMessage());
                    e16.printStackTrace();
                }
                try {
                    d17 = com.tencent.qqprotect.singleupdate.a.d(file2);
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.e("EarlyDown", 2, "verifyResource() get file md5 failed:" + file2.getAbsolutePath());
                    }
                    d17 = null;
                    if (d17 == null) {
                    }
                    file2.delete();
                    f();
                    str = d17;
                    File file4 = new File(m());
                    if (QLog.isColorLevel()) {
                    }
                    if (file3 == null) {
                    }
                    if (file3 == null) {
                    }
                }
            } catch (UnsatisfiedLinkError e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 2, "doOnServerResp, fStorage, UnsatisfiedLinkError, e.message=", e17.getMessage());
                    e17.printStackTrace();
                }
                try {
                    d17 = com.tencent.qqprotect.singleupdate.a.d(file2);
                } catch (Exception unused2) {
                    if (QLog.isColorLevel()) {
                        QLog.e("EarlyDown", 2, "verifyResource() get file md5 failed:" + file2.getAbsolutePath());
                    }
                    d17 = null;
                    if (d17 == null) {
                    }
                    file2.delete();
                    f();
                    str = d17;
                    File file42 = new File(m());
                    if (QLog.isColorLevel()) {
                    }
                    if (file3 == null) {
                    }
                    if (file3 == null) {
                    }
                }
            }
            if (d17 == null && xmlData.MD5 != null && d17.toLowerCase().equals(xmlData.MD5.toLowerCase())) {
                str = d17;
                file3 = file2;
            } else {
                file2.delete();
                f();
                str = d17;
            }
        } else {
            str = null;
        }
        File file422 = new File(m());
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "fBackup=" + file422.getAbsolutePath() + ", exist=" + file422.exists());
        }
        if (file3 == null) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fBackup.length=");
                str2 = str;
                sb5.append(file422.length());
                QLog.d("EarlyDown", 4, sb5.toString());
            } else {
                str2 = str;
            }
            try {
                File file5 = new File(AppConstants.SDCARD_PATH + "early/" + this.f203919d);
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 2, "copy oldBackupFile=" + file5.getAbsolutePath() + ", exist=" + file5.exists());
                }
                if (!file422.exists() && file5.exists()) {
                    boolean copyFile = FileUtils.copyFile(file5, file422);
                    if (QLog.isColorLevel()) {
                        QLog.d("EarlyDown", 2, "copy oldBackupFile:" + copyFile);
                    }
                }
                if (file5.exists()) {
                    boolean delete = file5.delete();
                    if (QLog.isColorLevel()) {
                        QLog.d("EarlyDown", 2, "delete oldBackupFile:" + delete);
                    }
                }
            } catch (Throwable th5) {
                QLog.d("EarlyDown", 1, "dealing old backup file, exception:" + th5.getMessage());
            }
            if (file422.exists()) {
                try {
                    d16 = HexUtil.bytes2HexStr(MD5.getFileMd5(file422.getAbsolutePath()));
                } catch (OutOfMemoryError e18) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EarlyDown", 2, "doOnServerResp, fBackup, OutOfMemoryError, oom.message=", e18.getMessage());
                        e18.printStackTrace();
                    }
                    try {
                        d16 = com.tencent.qqprotect.singleupdate.a.d(file422);
                    } catch (Exception unused3) {
                        if (QLog.isColorLevel()) {
                            QLog.e("EarlyDown", 2, "verifyResource() get file md5 failed:" + file422.getAbsolutePath());
                        }
                        d16 = str2;
                        if (d16 == null) {
                        }
                        file422.delete();
                        f();
                        if (file3 == null) {
                        }
                    }
                } catch (UnsatisfiedLinkError e19) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EarlyDown", 2, "doOnServerResp, fBackup, UnsatisfiedLinkError, e.message=", e19.getMessage());
                        e19.printStackTrace();
                    }
                    try {
                        d16 = com.tencent.qqprotect.singleupdate.a.d(file422);
                    } catch (Exception unused4) {
                        if (QLog.isColorLevel()) {
                            QLog.e("EarlyDown", 2, "verifyResource() get file md5 failed:" + file422.getAbsolutePath());
                        }
                        d16 = str2;
                        if (d16 == null) {
                        }
                        file422.delete();
                        f();
                        if (file3 == null) {
                        }
                    }
                }
                if (d16 == null && xmlData.MD5 != null && d16.toLowerCase().equals(xmlData.MD5.toLowerCase())) {
                    file3 = file422;
                } else {
                    file422.delete();
                    f();
                }
            }
        }
        if (file3 == null) {
            o16.hasResDownloaded = false;
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "EarlyHandler, doOnServerResp, fValidRes NotExist, hasResDownloaded=false, resName=" + this.f203919d);
            }
            com.tencent.mobileqq.earlydownload.a.f(o16, "hasResDownloaded");
            if (!C()) {
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 2, "user not need download.just save data and do nothing. resName=" + this.f203919d);
                }
                o16.updateServerInfo(xmlData);
                o16.loadState = 1;
                com.tencent.mobileqq.earlydownload.a.f(o16, new String[0]);
            } else {
                int i3 = xmlData.Version;
                int i16 = o16.Version;
                if (i3 >= i16) {
                    if (i3 == i16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("EarlyDown", 2, "same version, loadState=" + o16.loadState + ". resName=" + this.f203919d);
                        }
                        if (o16.loadState != 1) {
                            o16.updateServerInfo(xmlData);
                            com.tencent.mobileqq.earlydownload.a.f(o16, new String[0]);
                            IEarlyDownloadService iEarlyDownloadService = (IEarlyDownloadService) this.f203921f.getRuntimeService(IEarlyDownloadService.class, "");
                            if (QLog.isColorLevel()) {
                                QLog.d("EarlyDown", 4, "same version, state not suc. isUserClick=" + o16.isUserClick + ". notPreDownInLowEndPhone=" + o16.notPreDownloadInLowEndPhone + ". isLowEndPhone=" + iEarlyDownloadService.isLowEndPhone());
                            }
                            if (o16.isUserClick || !o16.notPreDownloadInLowEndPhone || !iEarlyDownloadService.isLowEndPhone()) {
                                k3 = k();
                                if (!k3) {
                                    ((IEarlyDownloadService) this.f203921f.getRuntimeService(IEarlyDownloadService.class, "")).removeRequesting(o16.getStrResName());
                                    w(o16);
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (i3 > i16) {
                        o16.updateServerInfo(xmlData);
                        com.tencent.mobileqq.earlydownload.a.f(o16, new String[0]);
                        IEarlyDownloadService iEarlyDownloadService2 = (IEarlyDownloadService) this.f203921f.getRuntimeService(IEarlyDownloadService.class, "");
                        if (QLog.isColorLevel()) {
                            QLog.d("EarlyDown", 2, "resp new version.  isUserClick=" + o16.isUserClick + ". notPreDownInLowEndPhone=" + o16.notPreDownloadInLowEndPhone + ". isLowEndPhone=" + iEarlyDownloadService2.isLowEndPhone());
                        }
                        if (o16.isUserClick || !o16.notPreDownloadInLowEndPhone || !iEarlyDownloadService2.isLowEndPhone()) {
                            k3 = k();
                            if (!k3) {
                            }
                        }
                    }
                }
            }
            k3 = false;
            if (!k3) {
            }
        } else {
            o16.updateServerInfo(xmlData);
            o16.Version = xmlData.Version;
            o16.loadState = 1;
            o16.hasResDownloaded = true;
            com.tencent.mobileqq.earlydownload.a.f(o16, "hasResDownloaded");
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "EarlyHandler, doOnServerResp, fValidRes exist, hasResDownloaded=true, resName=" + this.f203919d);
            }
            if (!file2.exists() && !e()) {
                try {
                    FileUtils.copyFile(file3, file2);
                    if (QLog.isColorLevel()) {
                        QLog.d("EarlyDown", 2, "doOnServerResp() copy[" + file3.getAbsolutePath() + "] to [" + file2.getAbsolutePath() + "]");
                    }
                } catch (Exception unused5) {
                }
            }
            com.tencent.mobileqq.earlydownload.a.f(o16, new String[0]);
            i(file3.getAbsolutePath());
            ((IEarlyDownloadService) this.f203921f.getRuntimeService(IEarlyDownloadService.class, "")).removeRequesting(o16.getStrResName());
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "doOnServerResp() " + o16.strResName + " doBackup by[" + file3.getAbsolutePath() + "]");
            }
            if (this.C) {
                Intent intent = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
                intent.putExtra("strResName", this.f203919d);
                intent.putExtra("strPkgName", o16.strPkgName);
                intent.putExtra("loadState", 1);
                file = file3;
                intent.putExtra("totalSize", o16.totalSize);
                intent.putExtra("downSize", o16.downSize);
                intent.putExtra("resPath", file.getAbsolutePath());
                MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(intent, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
                this.C = false;
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 2, "set isBroadcast false. send Broadcast: resName" + this.f203919d);
                }
            } else {
                file = file3;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_strPkgName", o16.strPkgName);
            hashMap.put("param_byBackup", Boolean.TRUE.toString());
            String t16 = t();
            if (t16 != null && t16.length() > 0) {
                StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(this.f203921f.getCurrentAccountUin(), t16, true, 2000L, file2.length(), hashMap, "");
            }
            if (!file422.exists() && xmlData.StoreBackup) {
                try {
                    FileUtils.copyFile(file, file422);
                    if (QLog.isColorLevel()) {
                        QLog.d("EarlyDown", 2, "doOnServerResp() copy[" + file.getAbsolutePath() + "] to [" + file422.getAbsolutePath() + "]");
                    }
                } catch (Exception unused6) {
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean k() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        XmlData o16 = o();
        boolean z17 = z();
        if (!B()) {
            if (NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ.getApplicationContext())) {
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 2, "wifi connected,reset timeValid=true");
                }
            } else {
                z16 = false;
                if (!z17 && z16) {
                    ((IEarlyDownloadService) this.f203921f.getRuntimeService(IEarlyDownloadService.class, "")).downloadResource(o16, u());
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 2, "downloadResource() return false, netValid=" + z17 + " timeValid=" + z16 + " strResName=" + this.f203919d);
                }
                return false;
            }
        }
        z16 = true;
        if (!z17) {
        }
        if (QLog.isColorLevel()) {
        }
        return false;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            try {
                new File(u()).delete();
            } catch (Exception unused) {
            }
            com.tencent.mobileqq.earlydownload.a.b(o());
        }
    }

    public String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        String str = D;
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str);
        File file = new File(sDKPrivatePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = file.getAbsolutePath() + File.separator + this.f203919d;
        if (QLog.isColorLevel()) {
            QLog.d("EarlyHandler", 2, "getBackupPath ,SDCARD_DIR = " + str + ",vfsDir = " + sDKPrivatePath + ",filepath = " + str2);
        }
        return str2;
    }

    public abstract int n();

    public final XmlData o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (XmlData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f203920e == null) {
            this.f203920e = com.tencent.mobileqq.earlydownload.a.e(p());
        }
        return this.f203920e;
    }

    public abstract Class<? extends XmlData> p();

    public abstract String q();

    public GetResourceReqInfo r() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (GetResourceReqInfo) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        XmlData o16 = o();
        if (o16 != null && (str = o16.strPkgName) != null && str.length() > 0) {
            GetResourceReqInfo getResourceReqInfo = new GetResourceReqInfo();
            getResourceReqInfo.uiResID = 0L;
            getResourceReqInfo.strPkgName = o16.strPkgName;
            getResourceReqInfo.uiCurVer = v();
            getResourceReqInfo.sResType = (short) 512;
            getResourceReqInfo.sLanType = (short) 1;
            getResourceReqInfo.sReqType = (short) 1;
            return getResourceReqInfo;
        }
        if (QLog.isColorLevel()) {
            StringBuffer stringBuffer = new StringBuffer("getResourceReqInfo() return null.");
            if (o16 == null) {
                stringBuffer.append("data==null");
            } else {
                stringBuffer.append("resName=" + o16.strResName);
                stringBuffer.append(".pkgName=" + o16.strPkgName);
            }
            QLog.d("EarlyDown", 2, stringBuffer.toString());
        }
        return null;
    }

    public GetResourceReqInfoV2 s(String str) {
        GetResourceReqInfoV2 getResourceReqInfoV2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (GetResourceReqInfoV2) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        }
        XmlData o16 = o();
        long j3 = 0;
        if (o16 == null) {
            getResourceReqInfoV2 = new GetResourceReqInfoV2();
            getResourceReqInfoV2.cState = (byte) 0;
            getResourceReqInfoV2.sLanType = (short) 1;
            getResourceReqInfoV2.sResSubType = (short) 1;
            getResourceReqInfoV2.strPkgName = str;
            getResourceReqInfoV2.uiCurVer = 0L;
        } else {
            getResourceReqInfoV2 = new GetResourceReqInfoV2();
            getResourceReqInfoV2.cState = (byte) 0;
            getResourceReqInfoV2.sLanType = (short) 1;
            getResourceReqInfoV2.sResSubType = (short) 1;
            getResourceReqInfoV2.strPkgName = str;
            if (!y()) {
                j3 = v();
            }
            getResourceReqInfoV2.uiCurVer = j3;
        }
        if (QLog.isColorLevel()) {
            StringBuffer stringBuffer = new StringBuffer("getResourceReqInfoV2(), strPkgName=" + str);
            if (o16 == null) {
                stringBuffer.append(",data==null");
            } else {
                stringBuffer.append(",this.strResName=[" + this.f203919d);
                stringBuffer.append("], resName=[" + o16.strResName);
                stringBuffer.append("], pkgName=[" + o16.strPkgName);
                stringBuffer.append("], version=[" + o16.Version);
            }
            QLog.d("EarlyDown", 2, stringBuffer.toString());
        }
        return getResourceReqInfoV2;
    }

    public abstract String t();

    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        File file = new File(MobileQQ.sMobileQQ.getApplicationContext().getFilesDir() + "/pddata/prd/early");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator + this.f203919d;
    }

    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        XmlData o16 = o();
        if (o16 != null) {
            return o16.Version;
        }
        return 0;
    }

    public void w(XmlData xmlData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) xmlData);
        }
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.C;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean y() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        XmlData o16 = o();
        boolean z16 = true;
        if (o16 == null) {
            i3 = 1;
        } else {
            System.currentTimeMillis();
            int i16 = o16.loadState;
            boolean z17 = false;
            int i17 = -1;
            if (i16 == 1) {
                if (!e() && !new File(u()).exists()) {
                    J(false);
                    d();
                    i17 = 2;
                }
                if (o16.hasResDownloaded) {
                    i3 = 4;
                } else {
                    z16 = z17;
                    i3 = i17;
                }
            } else if (o16.Version != 0 && i16 != 2) {
                o16.Version = 0;
                com.tencent.mobileqq.earlydownload.a.f(o16, "Version");
                i17 = 3;
            }
            z17 = true;
            if (o16.hasResDownloaded) {
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "isNeedServerInfo(), " + o().strResName + ", need=" + z16 + ", needTrueReasonCode =" + i3);
        }
        return z16;
    }

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        XmlData o16 = o();
        if (o16 != null) {
            if (NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ.getApplicationContext())) {
                boolean z16 = o16.loadWifi;
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 4, "isNetValid2Down() return:" + z16 + " isWifiConn=true, " + o16.strResName + ":loadWifi=" + o16.loadWifi);
                    return z16;
                }
                return z16;
            }
            if (NetworkUtil.isMobileNetWork(MobileQQ.sMobileQQ.getApplicationContext())) {
                if (NetworkUtil.is3Gor4G(MobileQQ.sMobileQQ.getApplicationContext())) {
                    boolean z17 = o16.load3G;
                    if (QLog.isColorLevel()) {
                        QLog.d("EarlyDown", 4, "isNetValid2Down() return:" + z17 + " is3Gor4G=true, " + o16.strResName + ":load3G=" + o16.load3G);
                        return z17;
                    }
                    return z17;
                }
                boolean z18 = o16.load2G;
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 4, "isNetValid2Down() return:" + z18 + " is2G=true, " + o16.strResName + ":load2G=" + o16.load2G);
                    return z18;
                }
                return z18;
            }
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 4, "isNetValid2Down() return:false, no wifi and no MobileNet.");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 4, "isNetValid2Download() return false, data == null");
        }
        return false;
    }
}
