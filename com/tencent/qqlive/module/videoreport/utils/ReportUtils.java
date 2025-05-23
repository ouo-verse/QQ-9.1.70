package com.tencent.qqlive.module.videoreport.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.module.videoreport.BuildConfig;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportUtils {
    private static final String BUGLY_APP_ID = "c7924ada07";
    private static final String BUGLY_SDK_SP = "BuglySdkInfos";
    private static final String TAG = "ReportUtils";
    private static volatile boolean sBuglyInited = false;
    private static volatile Context sContext;
    private static volatile Application sCurrentApplication;
    private static volatile boolean sGetCurrentApplicationChecked;
    private static PackageInfo sPackageInfo;

    public static long calcElementUniqueId(View view) {
        String str;
        if (view == null) {
            return 0L;
        }
        String elementId = DataRWProxy.getElementId(view);
        if (TextUtils.isEmpty(elementId)) {
            return 0L;
        }
        Object innerParam = DataRWProxy.getInnerParam(view, InnerKey.ELEMENT_IDENTIFIER);
        if (innerParam instanceof String) {
            str = (String) innerParam;
        } else {
            str = null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(elementId);
        sb5.append("_");
        if (TextUtils.isEmpty(str)) {
            innerParam = Integer.valueOf(view.hashCode());
        }
        sb5.append(innerParam.toString());
        return sb5.toString().hashCode();
    }

    public static String generateSessionId() {
        return System.currentTimeMillis() + "" + (new Random().nextInt(900) + 100);
    }

    @Nullable
    public static Context getContext() {
        if (sContext == null) {
            sContext = getCurrentApplication();
        }
        return sContext;
    }

    private static Application getCurrentApplication() {
        if (!sGetCurrentApplicationChecked) {
            synchronized (ReportUtils.class) {
                if (!sGetCurrentApplicationChecked) {
                    try {
                        sCurrentApplication = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                        if (sCurrentApplication != null) {
                            sGetCurrentApplicationChecked = true;
                        }
                    } catch (Throwable th5) {
                        sGetCurrentApplicationChecked = true;
                        Log.e(TAG, "getCurrentApplication error " + th5);
                    }
                }
            }
        }
        return sCurrentApplication;
    }

    private static PackageInfo getPackageInfo() {
        try {
            if (sPackageInfo == null) {
                sPackageInfo = InstalledAppListMonitor.getPackageInfo(sContext.getPackageManager(), sContext.getPackageName(), 0);
            }
        } catch (Exception e16) {
            Log.e(TAG, "getPackageInfo exception " + e16);
        }
        return sPackageInfo;
    }

    public static String getPackageName() {
        PackageInfo packageInfo = getPackageInfo();
        if (packageInfo != null) {
            return packageInfo.packageName;
        }
        return "";
    }

    public static int getPackageVersionCode() {
        PackageInfo packageInfo = getPackageInfo();
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    public static String getPackageVersionName() {
        PackageInfo packageInfo = getPackageInfo();
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return "";
    }

    public static void initCrashReport(Context context) {
        if (!sBuglyInited) {
            synchronized (ReportUtils.class) {
                if (!sBuglyInited) {
                    writeBuglySpInfo(context);
                    sBuglyInited = true;
                }
            }
        }
    }

    public static void printStack(String str) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                Log.d(str, stackTraceElement.toString());
            }
        }
    }

    public static void setContext(Context context) {
        sContext = context.getApplicationContext();
    }

    private static void writeBuglySpInfo(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("BuglySdkInfos", 0);
        String string = sharedPreferences.getString(BUGLY_APP_ID, "");
        String valueOf = String.valueOf(BuildConfig.VERSION_CODE);
        if (TextUtils.equals(string, valueOf)) {
            return;
        }
        sharedPreferences.edit().putString(BUGLY_APP_ID, valueOf).apply();
    }
}
