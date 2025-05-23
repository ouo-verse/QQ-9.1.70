package com.tencent.mobileqq.util;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SSODebugUtil {
    public static final String KEY_ROUTING_ID = "key_routing_id";
    public static final String KEY_TEST_ENV = "key_test_env";
    public static String SSO_CONF_DIR = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";
    public static String SSO_CONF_FILENAME = "testserver";

    public static Intent getSSOEnvIntent() {
        String[] loadTestEnvironment = loadTestEnvironment();
        String str = loadTestEnvironment[0];
        String str2 = loadTestEnvironment[1];
        Intent intent = new Intent();
        intent.putExtra("key_test_env", str);
        intent.putExtra(KEY_ROUTING_ID, str2);
        return intent;
    }

    public static boolean isTestEnv() {
        return new File(SSO_CONF_DIR, SSO_CONF_FILENAME).exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0056 A[Catch: IOException -> 0x003e, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x003e, blocks: (B:17:0x003a, B:36:0x0056), top: B:7:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] loadTestEnvironment() {
        FileInputStream fileInputStream;
        String str;
        String str2;
        File file = new File(SSO_CONF_DIR, SSO_CONF_FILENAME);
        String str3 = "";
        if (!file.exists()) {
            return new String[]{"", "", ""};
        }
        String str4 = null;
        str4 = null;
        str4 = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
                str = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        try {
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream);
                str = properties.getProperty("server");
                try {
                    str2 = properties.getProperty("id");
                    try {
                        str4 = properties.getProperty("configId");
                        fileInputStream.close();
                    } catch (Exception e18) {
                        e = e18;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        if (TextUtils.isEmpty(str2)) {
                        }
                        if (!TextUtils.isEmpty(str4)) {
                        }
                        return new String[]{str, str2, str3};
                    }
                } catch (Exception e19) {
                    e = e19;
                    str2 = null;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e27) {
            e = e27;
            str = null;
            str2 = str;
            e.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (TextUtils.isEmpty(str)) {
            }
            if (TextUtils.isEmpty(str2)) {
            }
            if (!TextUtils.isEmpty(str4)) {
            }
            return new String[]{str, str2, str3};
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str4)) {
            str3 = str4;
        }
        return new String[]{str, str2, str3};
    }
}
