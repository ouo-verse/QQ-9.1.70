package com.tencent.gamematrix.gmcg.base.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.base.helper.CGBaseHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGAppUtil {
    private static final String TAG = "AppUtil";

    public static boolean checkAPKInstalled(String str) {
        return checkAPKInstalled(str, null);
    }

    @Deprecated
    public static boolean checkAPKInstalledByFilePath(String str) {
        if (str == null) {
            return false;
        }
        try {
            InstalledAppListMonitor.getPackageInfo(CGBaseHelper.getAppContext().getPackageManager(), getPackageName(str), 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkActivityNullOrFinished(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return true;
        }
        return false;
    }

    public static int checkApkInstallOrUpdate(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (CGStringUtil.versionCompare(InstalledAppListMonitor.getPackageInfo(CGBaseHelper.getAppContext().getPackageManager(), str, 128).versionName, str2) < 0) {
                return -1;
            }
            return 1;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public static String getAppImgSaveDir() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(CGBaseHelper.getAppContext().getExternalFilesDir(null));
        String str = File.separator;
        sb5.append(str);
        sb5.append("gmcg");
        sb5.append(str);
        sb5.append("images");
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getAppVideoSaveDir() {
        File file = new File(CGBaseHelper.getAppContext().getExternalFilesDir(null) + File.separator + "gmcg");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static Application getApplicationByReflection() {
        try {
            CGLog.w("getApplicationByReflection");
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String getCurrentVersion(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return "0";
        }
    }

    public static Drawable getIconFromApk(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            return applicationInfo.loadIcon(packageManager);
        }
        return null;
    }

    public static String getNameFromApk(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        CharSequence applicationLabel = packageManager.getApplicationLabel(applicationInfo);
        if (applicationLabel == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    public static String getPackageName(String str) {
        if (str == null) {
            return null;
        }
        return CGBaseHelper.getAppContext().getPackageManager().getPackageArchiveInfo(str, 0).packageName;
    }

    public static String getPubAppImgSavePath() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
        String str = File.separator;
        sb5.append(str);
        sb5.append("gmcg");
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + str + "gmcgSaved" + System.currentTimeMillis() + ".jpg";
    }

    public static String getSelfPackageName() {
        return CGBaseHelper.getAppContext().getPackageName();
    }

    public static String getTempAppImageSaveDir() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(CGBaseHelper.getAppContext().getExternalCacheDir());
        String str = File.separator;
        sb5.append(str);
        sb5.append("gmcg");
        sb5.append(str);
        sb5.append("images");
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getVersionFromApk(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.versionName;
        }
        return "";
    }

    public static String getVersionName(String str) {
        if (str == null) {
            return null;
        }
        return CGBaseHelper.getAppContext().getPackageManager().getPackageArchiveInfo(str, 0).versionName;
    }

    public static String getVersionNameFromDir(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length > 0) {
                return getVersionName(listFiles[0].getAbsolutePath());
            }
            return null;
        }
        return null;
    }

    public static boolean isOnBackgroundThread() {
        return !isOnMainThread();
    }

    public static boolean isOnMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    public static boolean launchApp(Context context, String str) {
        Intent launchIntentForPackage;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, str)) == null) {
            return false;
        }
        launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        context.startActivity(launchIntentForPackage);
        return true;
    }

    public static void launchAppByPackageName(Context context, String str) {
        if (str == null) {
            return;
        }
        launchApp(context, str);
    }

    public static void launchAppFromFilePath(Context context, String str) {
        Intent launchIntentForPackage;
        String packageName = getPackageName(str);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null && (launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, packageName)) != null) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            context.startActivity(launchIntentForPackage);
        }
    }

    public static boolean checkAPKInstalled(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(CGBaseHelper.getAppContext().getPackageManager(), str, 128);
            if (str2 != null) {
                if (CGStringUtil.versionCompare(packageInfo.versionName, str2) < 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
