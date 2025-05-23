package com.qq.e.comm.plugin.k;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.download.data.MediaCustomDownloaderCallBackInfo;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    public static boolean a(Context context, String str) {
        if (!StringUtil.isEmpty(str) && context != null) {
            if (Build.VERSION.SDK_INT >= 30 && !a(context)) {
                return b(context, str);
            }
            try {
                GDTLogger.d("isAPKInstalled start pkgName =" + str);
                return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 256) != null;
            } catch (Throwable th5) {
                GDTLogger.d("isAPKInstalled exception =" + th5.getMessage());
                th5.printStackTrace();
            }
        }
        return false;
    }

    public static boolean b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            GDTLogger.i(String.format("launch %s", str));
            Intent c16 = c(context, str);
            if (c16 == null) {
                GDTLogger.e("launch error\uff0c intent is null");
                return false;
            }
            if (a(context, c16) != null) {
                return true;
            }
            GDTLogger.e("launch error\uff0c resolveInfo is null");
            return false;
        }
        GDTLogger.e("launch error");
        return false;
    }

    public static Intent c(Context context, String str) {
        if (context != null && context.getPackageManager() != null && !TextUtils.isEmpty(str)) {
            try {
                return InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), str);
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
        return null;
    }

    public static ResolveInfo a(Context context, Intent intent) {
        PackageManager packageManager;
        if (context == null || intent == null || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        return packageManager.resolveActivity(intent, 65536);
    }

    private static boolean a(Context context) {
        try {
            return context.checkCallingOrSelfPermission("android.permission.QUERY_ALL_PACKAGES") == 0;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public static MediaCustomDownloaderCallBackInfo a(com.qq.e.comm.plugin.base.ad.model.d dVar) {
        MediaCustomDownloaderCallBackInfo mediaCustomDownloaderCallBackInfo = null;
        try {
            if (dVar == null) {
                GDTLogger.e("[getDownloadInfoByPackageName] no such task");
                return null;
            }
            MediaCustomDownloaderCallBackInfo mediaCustomDownloaderCallBackInfo2 = new MediaCustomDownloaderCallBackInfo();
            try {
                mediaCustomDownloaderCallBackInfo2.progress = ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getProgress(dVar.e());
                mediaCustomDownloaderCallBackInfo2.status = dVar.m();
                mediaCustomDownloaderCallBackInfo2.pkgName = dVar.e();
                mediaCustomDownloaderCallBackInfo2.totalSize = ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getAPKTotalSize(dVar.e());
                mediaCustomDownloaderCallBackInfo2.iconUrl = dVar.g();
                mediaCustomDownloaderCallBackInfo2.appName = dVar.c();
                mediaCustomDownloaderCallBackInfo2.taskId = String.valueOf(dVar.k());
                return mediaCustomDownloaderCallBackInfo2;
            } catch (Throwable th5) {
                th = th5;
                mediaCustomDownloaderCallBackInfo = mediaCustomDownloaderCallBackInfo2;
                GDTLogger.e("[getApkInfoList]", th);
                return mediaCustomDownloaderCallBackInfo;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
