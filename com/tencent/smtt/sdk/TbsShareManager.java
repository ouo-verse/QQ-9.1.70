package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TbsShareManager {

    /* renamed from: a, reason: collision with root package name */
    private static Context f369175a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f369176b = false;
    public static boolean mHasQueried = false;

    @Deprecated
    public static int findCoreForThirdPartyApp(Context context) {
        return -1;
    }

    @Deprecated
    public static File getBackupCoreFile(Context context, String str) {
        return null;
    }

    @Deprecated
    public static int getBackupCoreVersion(Context context, String str) {
        return 0;
    }

    @Deprecated
    public static File getBackupDecoupleCoreFile(Context context, String str) {
        return null;
    }

    @Deprecated
    public static int getBackupDecoupleCoreVersion(Context context, String str) {
        return 0;
    }

    @Deprecated
    public static boolean getCoreDisabled() {
        return false;
    }

    @Deprecated
    public static String[] getCoreProviderAppList() {
        return new String[0];
    }

    @Deprecated
    public static int getCoreShareDecoupleCoreVersion(Context context, String str) {
        return 0;
    }

    @Deprecated
    public static String getHostCorePathAppDefined() {
        return "";
    }

    public static Context getPackageContext(Context context, String str, boolean z16) {
        if (context != null && context.getPackageName().equals(str)) {
            return context;
        }
        if (context == null) {
            TbsLog.e("TbsShareManager", "getPackageContext appContext is null!!");
        }
        return null;
    }

    @Deprecated
    public static File getSDCoreFile(Context context, String str, int i3) {
        return null;
    }

    @Deprecated
    public static int getSharedTbsCoreVersion(Context context, String str) {
        return 0;
    }

    @Deprecated
    public static File getStableCoreFile(Context context, String str) {
        return null;
    }

    @Deprecated
    public static int getStableCoreVersion(Context context, String str) {
        return 0;
    }

    @Deprecated
    public static int getTbsStableCoreVersion(Context context, int i3) {
        return 0;
    }

    public static boolean isThirdPartyApp(Context context) {
        Context context2;
        try {
            context2 = f369175a;
        } catch (Throwable th5) {
            TbsLog.i(th5);
        }
        if (context2 != null && context2.equals(context.getApplicationContext())) {
            return f369176b;
        }
        Context applicationContext = context.getApplicationContext();
        f369175a = applicationContext;
        String packageName = applicationContext.getPackageName();
        String[] strArr = {TbsConfig.APP_DEMO, "com.tencent.mm", "com.tencent.mobileqq", "com.qzone", "com.tencent.qqlite"};
        for (int i3 = 0; i3 < 5; i3++) {
            if (packageName.equals(strArr[i3])) {
                f369176b = false;
                return false;
            }
        }
        f369176b = true;
        return true;
    }

    @Deprecated
    public static void setHostCorePathAppDefined(String str) {
    }
}
