package com.tencent.midas.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class APPluginChecker {
    private static final String TAG = "APPluginChecker";

    private static boolean isAllPluginValid(File file) {
        if (file == null) {
            APLog.e(TAG, "Cannot check all plugin valid, pluginPath is null!");
            return false;
        }
        APLog.d(TAG, "Check all plugin valid, parameter ok!");
        try {
            File file2 = new File(file.getCanonicalPath() + File.separator + APPluginConfig.SIGN_FILE_NAME);
            if (!file2.exists()) {
                APLog.e(TAG, "Check all plugin valid, sign file is not found");
                return false;
            }
            APLog.d(TAG, "Check all plugin valid, sign file exist!");
            HashMap hashMap = new HashMap();
            APPluginUtils.readSingInfo(hashMap, file2);
            int i3 = 0;
            for (File file3 : file.listFiles()) {
                String name = file3.getName();
                APLog.d(TAG, "Check all plugin valid, current check file = " + name);
                if (!name.startsWith("MidasSign") && name.startsWith("Midas")) {
                    String str = (String) hashMap.get(name.split("\\_")[0]);
                    if (!TextUtils.isEmpty(str)) {
                        if (!APPluginUtils.checkFileMD5(file3.getCanonicalPath(), str)) {
                            APLog.d(TAG, "Check all plugin valid, current check file = " + name + ", MD5 not OK");
                            file3.delete();
                        } else {
                            i3++;
                            APLog.d(TAG, "Check all plugin valid, current check file = " + name + ", MD5 OK");
                        }
                    }
                }
                APLog.d(TAG, "Check all plugin valid, ignore = " + name);
            }
            if (i3 == hashMap.size() && i3 >= 2) {
                APLog.d(TAG, "Check all plugin valid, all valid file num = " + i3 + ", sign file size = " + hashMap.size() + ", check success!");
                return true;
            }
            APLog.e(TAG, "Check all plugin valid, all valid file num = " + i3 + ", but sign file size = " + hashMap.size() + ", check fail!");
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean isPluginExists(Context context) {
        if (!new File(APPluginConfig.getPluginPath(context) + File.separator + APPluginConfig.SIGN_FILE_NAME).exists()) {
            return false;
        }
        return true;
    }

    public static boolean isPluginValid(Context context) {
        APLog.d(TAG, "Calling into isPluginValid " + Thread.currentThread().getStackTrace()[3].toString());
        return isAllPluginValid(APPluginConfig.getPluginPath(context));
    }

    public static boolean isPluginValid(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            APLog.e(TAG, "Cannot check plugin valid, pluginPath is null!");
            return false;
        }
        APLog.d(TAG, "Check plugin valid, parameter ok!");
        try {
            if (!APPluginUtils.checkFileMD5(str, str2)) {
                return false;
            }
            File file = new File(new File(str.substring(0, str.lastIndexOf("/"))).getCanonicalPath() + File.separator + APPluginConfig.SIGN_FILE_NAME);
            if (!file.exists()) {
                APLog.e(TAG, "Check plugin valid, sign file is not found");
                return false;
            }
            APLog.d(TAG, "Check plugin valid, sign file exist!");
            HashMap hashMap = new HashMap();
            APPluginUtils.readSingInfo(hashMap, file);
            String name = new File(str).getName();
            APLog.d(TAG, "Check plugin valid, current check file = " + name);
            if (str2.equals((String) hashMap.get(name.split("\\_")[0]))) {
                APLog.d(TAG, "Check plugin valid, current check file = " + name + ", MD5 OK");
                return true;
            }
            APLog.d(TAG, "Check plugin valid, current check file = " + name + ", MD5 not OK");
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
