package com.tencent.mobileqq.qrscan.earlydown;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qq.taf.jce.HexUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanIpcApi;
import com.tencent.mobileqq.qrscan.u;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.l;
import com.tencent.qqnt.http.api.m;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QBarSoDownloader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private b f276618a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f276619b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final QBarSoDownloader f276624a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27589);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f276624a = new QBarSoDownloader();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f276625a;

        /* renamed from: b, reason: collision with root package name */
        String f276626b;

        /* renamed from: c, reason: collision with root package name */
        String f276627c;

        /* renamed from: d, reason: collision with root package name */
        long f276628d;

        public b(String str, String str2, String str3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3, Long.valueOf(j3));
                return;
            }
            this.f276625a = str;
            this.f276626b = str2;
            this.f276627c = str3;
            this.f276628d = j3;
        }
    }

    QBarSoDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f276618a = null;
        this.f276619b = new AtomicBoolean(false);
        l();
    }

    private boolean e(String str, String str2) {
        String str3 = null;
        try {
            byte[] fileMd5 = MD5.getFileMd5(str);
            if (fileMd5 != null) {
                str3 = HexUtil.bytes2HexStr(fileMd5);
            }
        } catch (Throwable th5) {
            QLog.e("QBarSoDownloader", 1, "MD5.getFileMd5 exception ", th5);
            try {
                str3 = com.tencent.qqprotect.singleupdate.a.d(new File(str));
            } catch (Exception e16) {
                QLog.e("QBarSoDownloader", 1, "MD5FileUtil.getFileMD5String exception ", e16);
            }
        }
        if (str3 != null && str3.equalsIgnoreCase(str2)) {
            return true;
        }
        return false;
    }

    private String f() {
        File file = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/pddata/prd/qq.android.qbarnative.so");
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private String g() {
        File file = new File(f(), "download_" + System.currentTimeMillis() + "_" + new Random().nextInt(10));
        if (file.exists()) {
            file.delete();
        }
        return file.getAbsolutePath();
    }

    public static QBarSoDownloader h() {
        return a.f276624a;
    }

    private String i() {
        return new File(f(), "libQBarMod.so").getAbsolutePath();
    }

    private String j() {
        String i3 = i();
        if (!FileUtils.fileExists(i3)) {
            return null;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (new File(i3).length() != this.f276618a.f276628d) {
                QLog.e("QBarSoDownloader", 1, "libQBarMod.so length check failed");
                return null;
            }
        } else if (!e(i3, this.f276618a.f276627c)) {
            QLog.e("QBarSoDownloader", 1, "libQBarMod.so md5 check failed");
            return null;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(File file) {
        if (file != null && file.exists()) {
            if (!e(file.getAbsolutePath(), this.f276618a.f276626b)) {
                QLog.e("QBarSoDownloader", 1, "download file md5 error");
                m("zipMd5");
                return;
            }
            String i3 = i();
            if (j() != null) {
                QLog.i("QBarSoDownloader", 1, "so file is already exist, do not need uncompress");
                return;
            }
            try {
                FileUtils.deleteFile(i3);
                FileUtils.uncompressZip(file.getAbsolutePath(), f(), false);
                if (j() == null) {
                    QLog.e("QBarSoDownloader", 1, "download and uncompress success, but check so fail");
                    FileUtils.deleteFile(i3);
                    m("soMd5");
                    return;
                } else {
                    QLog.i("QBarSoDownloader", 1, "uncompress so file success");
                    try {
                        ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(BaseApplication.getContext(), i3);
                        return;
                    } catch (Throwable th5) {
                        QLog.e("QBarSoDownloader", 1, "registerSoFilePath error:", th5);
                        return;
                    }
                }
            } catch (IOException e16) {
                QLog.e("QBarSoDownloader", 1, "uncompress so fail ", e16);
                m("uncompress");
                return;
            }
        }
        QLog.e("QBarSoDownloader", 1, "download file is not exist");
        m("downloadFile");
    }

    private void l() {
        JSONException jSONException;
        String str;
        String str2;
        String str3;
        String str4;
        long j3;
        String str5;
        JSONObject jSONObject;
        String optString;
        String b16 = u.b();
        String str6 = null;
        if (!TextUtils.isEmpty(b16)) {
            try {
                jSONObject = new JSONObject(b16);
                optString = jSONObject.optString("downloadUrl");
                try {
                    str2 = jSONObject.optString("zipMd5");
                } catch (JSONException e16) {
                    jSONException = e16;
                    str = null;
                    str2 = null;
                }
            } catch (JSONException e17) {
                jSONException = e17;
                str = null;
                str2 = null;
            }
            try {
                str6 = jSONObject.optString("soMd5");
                j3 = jSONObject.optLong("soLength");
                str3 = str6;
                str4 = optString;
            } catch (JSONException e18) {
                jSONException = e18;
                str = str6;
                str6 = optString;
                QLog.e("QBarSoDownloader", 1, "parse download data error:", jSONException);
                str3 = str;
                str4 = str6;
                j3 = 0;
                str5 = str2;
                if (TextUtils.isEmpty(str4)) {
                }
                QLog.e("QBarSoDownloader", 1, "mQBarSoDownloadData is null");
            }
            str5 = str2;
        } else {
            str4 = null;
            str5 = null;
            str3 = null;
            j3 = 0;
        }
        if (TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str3) && j3 > 0) {
            this.f276618a = new b(str4, str5, str3, j3);
        } else {
            QLog.e("QBarSoDownloader", 1, "mQBarSoDownloadData is null");
        }
    }

    private void m(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        QQBeaconReport.report("", "scan_qbar_so_check_fail", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put(WadlProxyConsts.PARAM_DOWNLOAD_RESULT, str);
        QQBeaconReport.report("", "scan_qbar_so_download_result", hashMap);
    }

    @Nullable
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f276618a == null) {
            QLog.e("QBarSoDownloader", 1, "checkAndGetSoPath mQBarSoDownloadData is null");
            return null;
        }
        String j3 = j();
        if (j3 != null) {
            return j3;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qrscan.earlydown.QBarSoDownloader.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QBarSoDownloader.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (MobileQQ.sProcessId == 1) {
                    QBarSoDownloader.this.o();
                } else {
                    QIPCClientHelper.getInstance().callServer(IQRScanIpcApi.MODULUE_MAIN, "action_call_download_qbar_so", new Bundle());
                }
            }
        }, 16, null, false);
        return null;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f276618a == null) {
            QLog.e("QBarSoDownloader", 1, "startDownload mQBarSoDownloadData is null");
            return;
        }
        QLog.i("QBarSoDownloader", 1, "startDownload, isDownloading=" + this.f276619b.get());
        if (this.f276619b.getAndSet(true)) {
            return;
        }
        File file = new File(g());
        ((IHttpService) QRoute.api(IHttpService.class)).asyncExecute(new b.a("qbarlib", this.f276618a.f276625a, file).T(new l(file) { // from class: com.tencent.mobileqq.qrscan.earlydown.QBarSoDownloader.2
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ File f276620a;

            {
                this.f276620a = file;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QBarSoDownloader.this, (Object) file);
                }
            }

            @Override // com.tencent.qqnt.http.api.l
            public void onFailed(@NonNull com.tencent.qqnt.http.api.b bVar, @NonNull m mVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) bVar, (Object) mVar);
                    return;
                }
                QLog.i("QBarSoDownloader", 1, "onDownloadFailed " + mVar);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qrscan.earlydown.QBarSoDownloader.2.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (AnonymousClass2.this.f276620a.exists()) {
                            FileUtils.deleteFile(AnonymousClass2.this.f276620a);
                        }
                        QBarSoDownloader.this.f276619b.set(false);
                        QBarSoDownloader.this.n(false);
                    }
                }, 64, null, false);
            }

            @Override // com.tencent.qqnt.http.api.l
            public void onSuccess(@NonNull com.tencent.qqnt.http.api.b bVar, @NonNull m mVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar, (Object) mVar);
                    return;
                }
                QLog.i("QBarSoDownloader", 1, "onDownloadSuccess " + mVar);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qrscan.earlydown.QBarSoDownloader.2.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        QBarSoDownloader.this.k(anonymousClass2.f276620a);
                        if (AnonymousClass2.this.f276620a.exists()) {
                            FileUtils.deleteFile(AnonymousClass2.this.f276620a);
                        }
                        QBarSoDownloader.this.f276619b.set(false);
                        QBarSoDownloader.this.n(true);
                    }
                }, 64, null, false);
            }
        }).c());
    }
}
