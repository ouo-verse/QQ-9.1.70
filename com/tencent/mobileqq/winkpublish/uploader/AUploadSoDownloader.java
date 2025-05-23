package com.tencent.mobileqq.winkpublish.uploader;

import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.mobileqq.winkpublish.util.WinkHostFileUtils;
import com.tencent.mobileqq.winkpublish.util.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class AUploadSoDownloader {

    /* renamed from: a, reason: collision with root package name */
    private static int f327398a = 5;

    /* renamed from: b, reason: collision with root package name */
    private static File f327399b = RFWApplication.getApplication().getDir("qzoneupload", 0);

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f327400c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f327401d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements ModuleDownloadListener {
        a() {
        }

        @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
        public void onDownloadSucceed(String str) {
            if (str.equals(WinkHostConstants.QzoneModuleConst.qzoneModuleUploadSo())) {
                AUploadSoDownloader.f327401d = false;
                String absolutePath = AUploadSoDownloader.f327399b.getAbsolutePath();
                QLog.d("[upload2]AUploadSoDownloader", 1, "upload so download success : " + absolutePath);
                String b16 = h.b(str);
                File file = new File(absolutePath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (WinkHostFileUtils.unzip(new File(b16), file)) {
                    if (AUploadSoDownloader.this.f(absolutePath)) {
                        QLog.d("[upload2]AUploadSoDownloader", 1, "upload so save success");
                        AUploadSoDownloader.this.m(true);
                        AUploadSoDownloader.f327400c = true;
                    } else {
                        try {
                            file.delete();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        AUploadSoDownloader.this.m(false);
                    }
                    AUploadSoDownloader.f327401d = false;
                    return;
                }
                QLog.d("[upload2]AUploadSoDownloader", 1, "upload so unzip fail");
                AUploadSoDownloader.f327401d = false;
            }
        }

        @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
        public void onDownloadCanceled(String str) {
            AUploadSoDownloader.f327401d = false;
        }

        @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
        public void onDownloadFailed(String str) {
            AUploadSoDownloader.f327401d = false;
        }

        @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
        public void onDownloadProgress(String str, float f16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        com.tencent.qphone.base.util.QLog.d("[upload2]AUploadSoDownloader", 1, "so not exists " + r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str + File.separator + "md5.json");
        if (!file.exists()) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONObject(WinkHostFileUtils.readFileContent(file)).getJSONArray("so_lib");
            int i3 = 0;
            boolean z16 = false;
            while (true) {
                if (i3 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                String string = jSONObject.getString("name");
                String string2 = jSONObject.getString("md5");
                File file2 = new File(str + File.separator + string);
                if (!file2.exists()) {
                    break;
                }
                String a16 = com.tencent.mobileqq.winkpublish.util.c.a(file2);
                QLog.d("[upload2]AUploadSoDownloader", 1, "src md5 : ", a16, " dst md5 : ", string2, " file size :", Long.valueOf(file2.length()), " file : ", string);
                if (!a16.equals(string2)) {
                    break;
                }
                if (i3 == jSONArray.length() - 1) {
                    z16 = true;
                }
                i3++;
            }
            return z16;
        } catch (Exception e16) {
            QLog.d("[upload2]AUploadSoDownloader", 1, "checkSoMd5 error : " + e16.getMessage());
            return false;
        }
    }

    private void g(String str) {
        SharedPreferences sharedPreferences = RFWApplication.getApplication().getSharedPreferences("qzone_upload_so", 0);
        String str2 = "";
        if (sharedPreferences != null) {
            str2 = sharedPreferences.getString("upload_so_ver", "");
        }
        QLog.d("[upload2]AUploadSoDownloader", 1, "last ver " + str2 + " curUrl:" + str);
        if (TextUtils.isEmpty(str2) || str2.equals(str) || sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str2);
        sharedPreferences.edit().remove("upload_so_ver");
    }

    private int i() {
        SharedPreferences sharedPreferences = RFWApplication.getApplication().getSharedPreferences("qzone_upload_so", 0);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("upload_so_ver", "");
            int i3 = sharedPreferences.getInt(string, 0);
            QLog.d("[upload2]AUploadSoDownloader", 1, "getRetryCnt ver " + string + " cnt:" + i3);
            return i3;
        }
        QLog.d("[upload2]AUploadSoDownloader", 1, "getRetryCnt 0");
        return 0;
    }

    private boolean j() {
        SharedPreferences sharedPreferences = RFWApplication.getApplication().getSharedPreferences("qzone_upload_so", 0);
        boolean z16 = sharedPreferences != null ? sharedPreferences.getBoolean("upload_so_download_success", false) : false;
        QLog.d("[upload2]AUploadSoDownloader", 1, "getSoDownloadState " + z16);
        return z16;
    }

    private void l(String str) {
        QLog.d("[upload2]AUploadSoDownloader", 1, "recordRetryCnt " + str);
        g(str);
        SharedPreferences sharedPreferences = RFWApplication.getApplication().getSharedPreferences("qzone_upload_so", 0);
        if (sharedPreferences != null) {
            if (TextUtils.isEmpty(sharedPreferences.getString("upload_so_ver", ""))) {
                sharedPreferences.edit().putString("upload_so_ver", str).commit();
            }
            sharedPreferences.edit().putInt(str, sharedPreferences.getInt(str, 0) + 1).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z16) {
        QLog.d("[upload2]AUploadSoDownloader", 1, "saveSoDownloadState " + z16);
        SharedPreferences sharedPreferences = RFWApplication.getApplication().getSharedPreferences("qzone_upload_so", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("upload_so_download_success", z16).commit();
        }
    }

    public synchronized void h() {
        boolean a16 = h.a(WinkHostConstants.QzoneModuleConst.qzoneModuleUploadSo());
        boolean j3 = j();
        QLog.d("[upload2]AUploadSoDownloader", 1, "downloadUploadSo needUpdate:" + a16 + " saveState:" + j3 + " isSoDownloading:" + f327401d + " process:" + Process.myPid());
        if (!a16 && j3) {
            QLog.d("[upload2]AUploadSoDownloader", 1, "start check so md5");
            f327400c = false;
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.winkpublish.uploader.AUploadSoDownloader.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean f16 = AUploadSoDownloader.this.f(AUploadSoDownloader.f327399b.getAbsolutePath());
                    QLog.d("[upload2]AUploadSoDownloader", 1, "check so md5 result: " + f16);
                    if (f16) {
                        AUploadSoDownloader.f327400c = true;
                        return;
                    }
                    try {
                        if (AUploadSoDownloader.f327399b.exists()) {
                            AUploadSoDownloader.f327399b.delete();
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    AUploadSoDownloader.this.m(false);
                    AUploadSoDownloader.f327400c = false;
                }
            });
            return;
        }
        if (f327401d) {
            return;
        }
        QLog.d("[upload2]AUploadSoDownloader", 1, "upload so need update");
        f327401d = true;
        f327400c = false;
        m(false);
        String c16 = h.c(WinkHostConstants.QzoneModuleConst.qzoneModuleUploadSo());
        String b16 = h.b(WinkHostConstants.QzoneModuleConst.qzoneModuleUploadSo());
        if (c16 == null) {
            f327401d = false;
            f327400c = false;
            return;
        }
        int i3 = i();
        int i16 = f327398a;
        if (i3 > i16 / 2 && i3 < i16) {
            try {
                new File(b16).delete();
            } catch (Exception unused) {
            }
        }
        if (i3 > f327398a) {
            QLog.d("[upload2]AUploadSoDownloader", 1, "upload so has retry:" + i());
            f327401d = false;
            return;
        }
        l(c16);
        ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).downloadModule(WinkHostConstants.QzoneModuleConst.qzoneModuleUploadSo(), new a());
    }

    public synchronized boolean k(String str) {
        int b16 = ya3.a.d().b(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_ENABLE_DOWNLOAD_SO, WinkHostConstants.AppSetting.isDebugVersion() ? 1 : 0);
        QLog.d("[upload2]AUploadSoDownloader", 1, "upload so enableLoadSo " + b16 + " useDownloadedSo " + f327400c);
        if (b16 != 1) {
            f327400c = false;
        }
        boolean j3 = j();
        QLog.d("[upload2]AUploadSoDownloader", 1, "upload so getSoDownloadState " + j3);
        if (!j3) {
            f327400c = false;
        }
        if (f327400c) {
            File file = new File(f327399b.getAbsolutePath() + File.separator + RFixConstants.SO_PATH + str + ".so");
            try {
                if (file.exists()) {
                    try {
                        System.load(file.getAbsolutePath());
                        QLog.d("[upload2]AUploadSoDownloader", 1, "upload so load downloaded so " + str);
                        return true;
                    } catch (Throwable th5) {
                        QLog.d("[upload2]AUploadSoDownloader", 1, "load downloaded so fail:" + th5.getMessage());
                        f327400c = false;
                        m(false);
                        f327399b.delete();
                    }
                } else {
                    f327400c = false;
                    QLog.d("[upload2]AUploadSoDownloader", 1, "downloaded upload so not exists:" + str);
                    m(false);
                    f327399b.delete();
                }
            } catch (Exception unused) {
            }
        }
        return f327400c;
    }
}
