package com.tencent.mobileqq.ark.util;

import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String appResPath = ArkEnvironmentManager.getInstance().getAppResPath(str);
            String format = String.format("share_%d_%02d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf((int) (Math.random() * 10.0d)));
            String str3 = appResPath + "/" + format;
            String str4 = "res:" + format;
            if (FileUtils.copyFile(str2, str3)) {
                return str4;
            }
            return "";
        }
        if (QLog.isColorLevel()) {
            QLog.e("ArkApp.AppDataUtil", 2, "AAShare.CopyFileToCache appName is null or local path is null");
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        if (!TextUtils.isEmpty(str) && bArr != null) {
            String appResPath = ArkEnvironmentManager.getInstance().getAppResPath(str);
            boolean z16 = false;
            String format = String.format("share_%d_%02d", Long.valueOf(System.currentTimeMillis()), Double.valueOf(Math.random() * 10.0d));
            String str2 = appResPath + "/" + format;
            String str3 = "res:" + format;
            try {
            } catch (IOException e16) {
                QLog.e("ArkApp.AppDataUtil", 1, "CopyFileToCache.e.", e16);
            }
            try {
                try {
                    File file = new File(str2);
                    if (file.exists()) {
                        file.delete();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr, 0, bArr.length);
                        fileOutputStream2.flush();
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e17) {
                            QLog.e("ArkApp.AppDataUtil", 1, "CopyFileToCache.e.", e17);
                        }
                        z16 = true;
                    } catch (IOException e18) {
                        fileOutputStream = fileOutputStream2;
                        e = e18;
                        QLog.e("ArkApp.AppDataUtil", 1, "CopyFileToCache.e.", e);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (z16) {
                        }
                    } catch (OutOfMemoryError e19) {
                        fileOutputStream = fileOutputStream2;
                        e = e19;
                        QLog.e("ArkApp.AppDataUtil", 1, "CopyFileToCache.oom.", e);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (z16) {
                        }
                    } catch (Throwable th5) {
                        fileOutputStream = fileOutputStream2;
                        th = th5;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e26) {
                                QLog.e("ArkApp.AppDataUtil", 1, "CopyFileToCache.e.", e26);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e27) {
                    e = e27;
                } catch (OutOfMemoryError e28) {
                    e = e28;
                }
                if (z16) {
                    return str3;
                }
                return "";
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("ArkApp.AppDataUtil", 2, "AAShare.CopyFileToCache appName is null or data is null");
            }
            return null;
        }
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (str2.startsWith("cache:")) {
            return ArkEnvironmentManager.getInstance().getCacheDirectory() + File.separator + str2.substring(6);
        }
        if (str2.startsWith("res:")) {
            return ArkEnvironmentManager.getInstance().getAppResPath(str) + File.separator + str2.substring(4);
        }
        QLog.w("ArkApp.AppDataUtil", 1, "convertArkPathToSysPath, unknown path: " + str2);
        return "";
    }

    public static String d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        return ArkEnvironmentManager.getInstance().getAppResPath(str) + "/" + str2.replace("res:", "");
    }
}
