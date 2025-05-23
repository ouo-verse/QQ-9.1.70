package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TbsExtensionFunctionManager {
    public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
    public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
    public static final String DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME = "disable_get_apk_version_switch.txt";
    public static final String DISABLE_UNPREINIT = "disable_unpreinit.txt";
    public static final String DISABLE_USE_HOST_BACKUP_CORE = "disable_use_host_backup_core.txt";
    public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
    public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
    public static final int SWITCH_BYTE_COOKIE = 1;
    public static final int SWITCH_BYTE_DISABLE_GET_APK_VERSION = 2;
    public static final int SWITCH_BYTE_DISABLE_UNPREINIT = 4;
    public static final int SWITCH_BYTE_DISABLE_USE_HOST_BACKUPCORE = 8;
    public static final String USEX5_FILE_NAME = "usex5.txt";

    /* renamed from: b, reason: collision with root package name */
    private static TbsExtensionFunctionManager f369118b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f369119a;

    TbsExtensionFunctionManager() {
    }

    public static TbsExtensionFunctionManager getInstance() {
        if (f369118b == null) {
            synchronized (TbsExtensionFunctionManager.class) {
                if (f369118b == null) {
                    f369118b = new TbsExtensionFunctionManager();
                }
            }
        }
        return f369118b;
    }

    public synchronized boolean canUseFunction(Context context, String str) {
        File file = new File(context.getFilesDir(), str);
        if (file.exists()) {
            if (file.isFile()) {
                return true;
            }
        }
        return false;
    }

    public synchronized int getRomCookieDBVersion(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME_FOR_COOKIE, 4);
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(SP_KEY_COOKIE_DB_VERSION, -1);
    }

    public synchronized void initTbsBuglyIfNeed(Context context) {
        if (this.f369119a) {
            return;
        }
        if (!canUseFunction(context, BUGLY_SWITCH_FILE_NAME)) {
            TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
            return;
        }
        File n3 = n.a().n(context);
        if (n3 == null) {
            TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
            return;
        }
        if (n3.listFiles() != null && n3.listFiles().length > 0) {
            String absolutePath = n3.getAbsolutePath();
            if (TextUtils.isEmpty(absolutePath)) {
                TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
                return;
            }
            File n16 = n.a().n(context);
            if (n16 == null) {
                TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
                return;
            }
            File file = new File(absolutePath, "tbs_bugly_dex.jar");
            try {
                com.tencent.smtt.utils.k.a(new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, n16.getAbsolutePath(), QbSdk.getSettings()).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", (Class<?>[]) new Class[]{Context.class, String.class, String.class, String.class}, context, absolutePath, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context)));
                this.f369119a = true;
                TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
                return;
            } catch (Throwable th5) {
                TbsLog.i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(th5));
                return;
            }
        }
        TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
    }

    public synchronized boolean setFunctionEnable(Context context, String str, boolean z16) {
        if (context == null) {
            return false;
        }
        File file = new File(context.getFilesDir(), str);
        if (z16) {
            if (!file.exists()) {
                try {
                    if (file.createNewFile()) {
                        return true;
                    }
                } catch (IOException e16) {
                    TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + str);
                    e16.printStackTrace();
                    return false;
                }
            }
        } else if (file.exists()) {
            if (file.delete()) {
                return true;
            }
            TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + str);
            return false;
        }
        return true;
    }
}
