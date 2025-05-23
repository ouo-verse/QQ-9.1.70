package com.tencent.mobileqq.shortvideo.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.portal.o;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f288250b = false;

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f288249a = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f288251c = new AtomicBoolean(false);

    public static String b() {
        File filesDir = BaseApplicationImpl.sApplication.getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("TK_Config_NativeSoLoader", 2, "getFilesDir is null");
                return "";
            }
            return "";
        }
        return filesDir.getParent() + "/tk";
    }

    public static boolean c(String str) {
        String str2 = b() + "/lib" + str + ".so";
        File file = new File(str2);
        if (QLog.isColorLevel()) {
            QLog.d("TK_Config_NativeSoLoader", 2, "isSoFileExist: exist= " + file.exists() + " isUncompressZip=" + f288250b);
        }
        boolean z16 = false;
        if (!f288250b && file.exists()) {
            synchronized (f288249a) {
                String string = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("tk_native_" + str, null);
                if (string != null && !string.equalsIgnoreCase(o.e(str2))) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TK_Config_NativeSoLoader", 2, "isSoFileExist: soName= " + str + " check md5 false!");
                    }
                }
                z16 = true;
            }
        }
        return z16;
    }

    public static byte d(String str) {
        if (str == null) {
            return (byte) -1;
        }
        String str2 = b() + "/lib" + str + ".so";
        if (QLog.isColorLevel()) {
            QLog.i("TK_Config_NativeSoLoader", 2, "start TKNativeSo: " + str2);
        }
        File file = new File(str2);
        if (!f288250b && file.exists()) {
            try {
                System.load(str2);
                if (QLog.isColorLevel()) {
                    QLog.i("TK_Config_NativeSoLoader", 2, "load " + str2 + " success!");
                }
                return (byte) 0;
            } catch (UnsatisfiedLinkError e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("TK_Config_NativeSoLoader", 2, "load from tk dir failed: " + e16.getMessage());
                }
                return (byte) -3;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("TK_Config_NativeSoLoader", 2, "no tk so in ar dir");
        }
        return (byte) -2;
    }
}
