package cooperation.qzone;

import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import com.tencent.rfix.loader.utils.RFixConstants;
import common.config.service.QzoneConfig;
import common.config.service.b;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import cooperation.qzone.networkedmodule.QzoneModuleRecord;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class UploadSoDownloader {
    private static final String KEY_UPLOAD_DOWNLOAD_SUCCESS = "upload_so_download_success";
    private static final String KEY_UPLOAD_VER = "upload_so_ver";
    private static int MAX_DOWNLOADER_RETRY_COUNT = 5;
    private static final String PRE_UPLOAD_DOWNLOAD = "qzone_upload_so";
    private static final String TAG = "[upload2]UploadEnv";
    private static File mUploadSoDir = BaseApplication.getContext().getDir("qzoneupload", 0);
    private static volatile boolean useDownloadedSo = false;
    private static boolean isSoDownloading = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        com.tencent.qphone.base.util.QLog.d(cooperation.qzone.UploadSoDownloader.TAG, 1, "so not exists " + r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkSoMd5(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str + File.separator + "md5.json");
        if (!file.exists()) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONObject(FileUtils.readFileContent(file)).getJSONArray("so_lib");
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
                String b16 = g.b(file2);
                QLog.d(TAG, 1, "src md5 : ", b16, " dst md5 : ", string2, " file size :", Long.valueOf(file2.length()), " file : ", string);
                if (!b16.equals(string2)) {
                    break;
                }
                if (i3 == jSONArray.length() - 1) {
                    z16 = true;
                }
                i3++;
            }
            return z16;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "checkSoMd5 error : " + e16.getMessage());
            return false;
        }
    }

    private void delLastVersionRetryCnt(String str) {
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(PRE_UPLOAD_DOWNLOAD, 0);
        String str2 = "";
        if (sharedPreferences != null) {
            str2 = sharedPreferences.getString(KEY_UPLOAD_VER, "");
        }
        QLog.d(TAG, 1, "last ver " + str2 + " curUrl:" + str);
        if (!TextUtils.isEmpty(str2) && !str2.equals(str) && sharedPreferences != null) {
            sharedPreferences.edit().remove(str2);
            sharedPreferences.edit().remove(KEY_UPLOAD_VER);
        }
    }

    private int getRetryCnt() {
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(PRE_UPLOAD_DOWNLOAD, 0);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(KEY_UPLOAD_VER, "");
            int i3 = sharedPreferences.getInt(string, 0);
            QLog.d(TAG, 1, "getRetryCnt ver " + string + " cnt:" + i3);
            return i3;
        }
        QLog.d(TAG, 1, "getRetryCnt 0");
        return 0;
    }

    private boolean getSoDownloadState() {
        boolean z16 = false;
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(PRE_UPLOAD_DOWNLOAD, 0);
        if (sharedPreferences != null) {
            z16 = sharedPreferences.getBoolean(KEY_UPLOAD_DOWNLOAD_SUCCESS, false);
        }
        QLog.d(TAG, 1, "getSoDownloadState " + z16);
        return z16;
    }

    public static boolean isRunningInQzoneProcess() {
        try {
            String qQProcessName = MobileQQ.sMobileQQ.getQQProcessName();
            if (qQProcessName == null) {
                return false;
            }
            if (!qQProcessName.endsWith(":qzone")) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private void recordRetryCnt(String str) {
        QLog.d(TAG, 1, "recordRetryCnt " + str);
        delLastVersionRetryCnt(str);
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(PRE_UPLOAD_DOWNLOAD, 0);
        if (sharedPreferences != null) {
            if (TextUtils.isEmpty(sharedPreferences.getString(KEY_UPLOAD_VER, ""))) {
                sharedPreferences.edit().putString(KEY_UPLOAD_VER, str).commit();
            }
            sharedPreferences.edit().putInt(str, sharedPreferences.getInt(str, 0) + 1).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSoDownloadState(boolean z16) {
        QLog.d(TAG, 1, "saveSoDownloadState " + z16);
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(PRE_UPLOAD_DOWNLOAD, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(KEY_UPLOAD_DOWNLOAD_SUCCESS, z16).commit();
        }
    }

    public synchronized void downloadUploadSo() {
        if (!isRunningInQzoneProcess()) {
            useDownloadedSo = false;
            QLog.d(TAG, 1, "not in qzone process do not download");
            return;
        }
        boolean checkIfNeedUpdate = ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).checkIfNeedUpdate(QzoneModuleConst.QZONE_MODULE_UPLOAD_SO);
        boolean soDownloadState = getSoDownloadState();
        QLog.d(TAG, 1, "downloadUploadSo needUpdate:" + checkIfNeedUpdate + " saveState:" + soDownloadState + " isSoDownloading:" + isSoDownloading + " process:" + Process.myPid());
        if (!checkIfNeedUpdate && soDownloadState) {
            QLog.d(TAG, 1, "start check so md5");
            useDownloadedSo = false;
            ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.UploadSoDownloader.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean checkSoMd5 = UploadSoDownloader.this.checkSoMd5(UploadSoDownloader.mUploadSoDir.getAbsolutePath());
                    QLog.d(UploadSoDownloader.TAG, 1, "check so md5 result: " + checkSoMd5);
                    if (checkSoMd5) {
                        boolean unused = UploadSoDownloader.useDownloadedSo = true;
                        return;
                    }
                    try {
                        if (UploadSoDownloader.mUploadSoDir.exists()) {
                            UploadSoDownloader.mUploadSoDir.delete();
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    UploadSoDownloader.this.saveSoDownloadState(false);
                    boolean unused2 = UploadSoDownloader.useDownloadedSo = false;
                }
            }, 5, null, true);
            return;
        }
        if (isSoDownloading) {
            return;
        }
        QLog.d(TAG, 1, "upload so need update");
        isSoDownloading = true;
        useDownloadedSo = false;
        saveSoDownloadState(false);
        QzoneModuleRecord moduleRecord = ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).getModuleRecord(QzoneModuleConst.QZONE_MODULE_UPLOAD_SO);
        String moduleFilePath = ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(QzoneModuleConst.QZONE_MODULE_UPLOAD_SO);
        if (moduleRecord == null) {
            isSoDownloading = false;
            useDownloadedSo = false;
            return;
        }
        int retryCnt = getRetryCnt();
        int i3 = MAX_DOWNLOADER_RETRY_COUNT;
        if (retryCnt > i3 / 2 && retryCnt < i3) {
            try {
                new File(moduleFilePath).delete();
            } catch (Exception unused) {
            }
        }
        if (retryCnt > MAX_DOWNLOADER_RETRY_COUNT) {
            QLog.d(TAG, 1, "upload so has retry:" + getRetryCnt());
            isSoDownloading = false;
            return;
        }
        recordRetryCnt(moduleRecord.mNewVersion.mUrl);
        ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).downloadModule(QzoneModuleConst.QZONE_MODULE_UPLOAD_SO, new ModuleDownloadListener() { // from class: cooperation.qzone.UploadSoDownloader.2
            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadCanceled(String str) {
                boolean unused2 = UploadSoDownloader.isSoDownloading = false;
            }

            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadFailed(String str) {
                boolean unused2 = UploadSoDownloader.isSoDownloading = false;
            }

            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadSucceed(String str) {
                if (str.equals(QzoneModuleConst.QZONE_MODULE_UPLOAD_SO)) {
                    boolean unused2 = UploadSoDownloader.isSoDownloading = false;
                    String absolutePath = UploadSoDownloader.mUploadSoDir.getAbsolutePath();
                    QLog.d(UploadSoDownloader.TAG, 1, "upload so download success : " + absolutePath);
                    String moduleFilePath2 = ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(str);
                    File file = new File(absolutePath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (!cooperation.qzone.util.FileUtils.unzip(new File(moduleFilePath2), file)) {
                        QLog.d(UploadSoDownloader.TAG, 1, "upload so unzip fail");
                        boolean unused3 = UploadSoDownloader.isSoDownloading = false;
                        return;
                    }
                    if (UploadSoDownloader.this.checkSoMd5(absolutePath)) {
                        QLog.d(UploadSoDownloader.TAG, 1, "upload so save success");
                        UploadSoDownloader.this.saveSoDownloadState(true);
                        boolean unused4 = UploadSoDownloader.useDownloadedSo = true;
                    } else {
                        try {
                            file.delete();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        UploadSoDownloader.this.saveSoDownloadState(false);
                    }
                    boolean unused5 = UploadSoDownloader.isSoDownloading = false;
                }
            }

            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadProgress(String str, float f16) {
            }
        });
    }

    public synchronized boolean loadLibrary(String str) {
        int b16 = b.e().b(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_ENABLE_DOWNLOAD_SO, 0);
        QLog.d(TAG, 1, "upload so enableLoadSo " + b16 + " useDownloadedSo " + useDownloadedSo);
        if (b16 != 1) {
            useDownloadedSo = false;
        }
        boolean soDownloadState = getSoDownloadState();
        QLog.d(TAG, 1, "upload so getSoDownloadState " + soDownloadState);
        if (!soDownloadState) {
            useDownloadedSo = false;
        }
        if (useDownloadedSo) {
            File file = new File(mUploadSoDir.getAbsolutePath() + File.separator + RFixConstants.SO_PATH + str + ".so");
            try {
                if (file.exists()) {
                    try {
                        System.load(file.getAbsolutePath());
                        QLog.d(TAG, 1, "upload so load downloaded so " + str);
                        return true;
                    } catch (Throwable th5) {
                        QLog.d(TAG, 1, "load downloaded so fail:" + th5.getMessage());
                        useDownloadedSo = false;
                        saveSoDownloadState(false);
                        mUploadSoDir.delete();
                    }
                } else {
                    useDownloadedSo = false;
                    QLog.d(TAG, 1, "downloaded upload so not exists:" + str);
                    saveSoDownloadState(false);
                    mUploadSoDir.delete();
                }
            } catch (Exception unused) {
            }
        }
        return useDownloadedSo;
    }
}
