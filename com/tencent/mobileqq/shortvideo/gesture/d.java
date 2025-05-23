package com.tencent.mobileqq.shortvideo.gesture;

import android.text.TextUtils;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    public static boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(downloadInfo.url_zip_gamemodel) || TextUtils.isEmpty(downloadInfo.MD5_zip_gamemodel) || TextUtils.isEmpty(downloadInfo.gamemodel_fullname)) {
            return false;
        }
        return true;
    }

    public static int b(DownloadInfo downloadInfo) {
        char c16;
        char c17;
        if (downloadInfo == null) {
            return 11;
        }
        if (TextUtils.isEmpty(downloadInfo.MD5_so)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QavGesture", 4, String.format("getEnableFlag, %s", downloadInfo));
            }
            return 11;
        }
        if (downloadInfo.enable) {
            if (h(downloadInfo) && g(downloadInfo)) {
                c16 = 1;
            } else {
                c16 = 11;
            }
        } else {
            c16 = 2;
        }
        if (downloadInfo.gameEnable) {
            if (h(downloadInfo) && f(downloadInfo)) {
                c17 = 1;
            } else {
                c17 = 11;
            }
        } else {
            c17 = 2;
        }
        if (c17 == 11 || c16 == 11) {
            return 11;
        }
        if (c17 != 2 || c16 != 2) {
            return 1;
        }
        return 2;
    }

    public static String c() {
        return e() + "gamemodel" + File.separator;
    }

    public static String d() {
        return e() + "model" + File.separator;
    }

    public static String e() {
        return AVSoUtils.y() + "so763" + File.separator;
    }

    public static boolean f(DownloadInfo downloadInfo) {
        String str = downloadInfo.MD5_zip_gamemodel;
        String str2 = c() + downloadInfo.gamemodel_fullname;
        String string = DownloadInfo.getSP().getString("gamemodel_zip_md5", null);
        if (!TextUtils.isEmpty(string) && string.equals(str)) {
            if (FileUtils.fileExists(str2)) {
                return true;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("QavGesture", 4, String.format("isGameModelReady, file no exist,  fileName[%s]", str2));
            }
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QavGesture", 4, String.format("isGameModelReady, sp_md5[%s], xmlMd5[%s]", string, str));
        }
        return false;
    }

    public static boolean g(DownloadInfo downloadInfo) {
        String str = downloadInfo.MD5_zip_model;
        String str2 = d() + downloadInfo.model_fullname;
        String string = DownloadInfo.getSP().getString("model_zip_md5", null);
        if (!TextUtils.isEmpty(string) && string.equals(str)) {
            if (FileUtils.fileExists(str2)) {
                return true;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("QavGesture", 4, String.format("isModelReady, file no exist,  fileName[%s]", str2));
            }
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QavGesture", 4, String.format("isModelReady, sp_md5[%s], xmlMd5[%s]", string, str));
        }
        return false;
    }

    public static boolean h(DownloadInfo downloadInfo) {
        String str = downloadInfo.MD5_zip_so;
        String str2 = e() + downloadInfo.so_fullname;
        String string = DownloadInfo.getSP().getString("so_zip_md5", null);
        if (!TextUtils.isEmpty(string) && string.equals(str)) {
            if (FileUtils.fileExists(str2)) {
                return true;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("QavGesture", 4, String.format("isSoReady, file no exist,  fileName[%s]", str2));
            }
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QavGesture", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", string, str));
        }
        return false;
    }
}
