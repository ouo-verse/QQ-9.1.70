package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public class l {
    public static String a(String str) {
        return c() + File.separator + str;
    }

    public static String b(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a(str));
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append(str2);
        sb5.append(str4);
        sb5.append(str3);
        return sb5.toString();
    }

    public static String c() {
        if (BaseApplicationImpl.sApplication.getFilesDir() == null) {
            QLog.i("AREngine_ArNativeSoLoaderBase", 2, "getARNativeSoRootDir. ARNativeSoRootDir is null.");
            return "";
        }
        return BaseApplication.getContext().getFilesDir() + "/pddata/prd";
    }

    public static synchronized int d(String str, String str2, String str3, String str4) {
        int i3;
        synchronized (l.class) {
            String str5 = b(str, str2, str3) + File.separator + str4 + ".so";
            QLog.i("AREngine_ArNativeSoLoaderBase", 2, "loadArNativeSo. soFilename = " + str5);
            if (new File(str5).exists()) {
                try {
                    if (str5.endsWith("libARCloud.so") || str5.endsWith("libARCloud_64.so") || str5.endsWith("libARFeature.so")) {
                        SoLoadUtilNew.loadSoByName(BaseApplication.getContext(), "c++_shared");
                    }
                    System.load(str5);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("loadArNativeSo successfully. result = ");
                    i3 = 0;
                    sb5.append(0);
                    sb5.append(", soFilename = ");
                    sb5.append(str5);
                    QLog.i("AREngine_ArNativeSoLoaderBase", 2, sb5.toString());
                } catch (UnsatisfiedLinkError e16) {
                    QLog.e("AREngine_ArNativeSoLoaderBase", 2, "loadArNativeSo failed. result = -4, soFilename = " + str5 + ", errMsg = " + e16.getMessage() + ", StackTrace = " + e16.getStackTrace().toString());
                    i3 = -4;
                }
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("loadArNativeSo failed. result = ");
                i3 = -2;
                sb6.append(-2);
                sb6.append(", soFilename = ");
                sb6.append(str5);
                QLog.i("AREngine_ArNativeSoLoaderBase", 2, sb6.toString());
            }
        }
        return i3;
    }

    public static String e(String str, String str2, String str3) {
        String str4 = str + str2 + str3;
        String string = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString(str4, "");
        QLog.i("AREngine_ArNativeSoLoaderBase", 2, "readMd5. key = " + str4 + ", md5 = " + string);
        return string;
    }

    public static void f(String str, String str2, String str3, String str4) {
        String str5 = str + str2 + str3;
        SharedPreferences.Editor edit = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).edit();
        edit.putString(str5, str4);
        edit.commit();
        QLog.i("AREngine_ArNativeSoLoaderBase", 2, "saveMd5. key = " + str5 + ", md5 = " + str4);
    }
}
