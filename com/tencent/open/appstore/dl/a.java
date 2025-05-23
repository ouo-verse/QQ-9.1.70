package com.tencent.open.appstore.dl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.notify.DownloadGlobalListener;
import com.tencent.tmdownloader.notify.DownloadTaskInfo;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements DownloadGlobalListener {

    /* renamed from: a, reason: collision with root package name */
    private static a f340868a;

    a() {
        if (QLog.isColorLevel()) {
            QLog.d("TMADownloadMonitor", 2, "TMADownloadMonitor Init");
        }
    }

    private static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && (str.endsWith("patch") || str.endsWith("zip") || str.endsWith("7z"))) {
            return true;
        }
        return false;
    }

    public static a b() {
        a aVar;
        a aVar2 = f340868a;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (a.class) {
            aVar = new a();
            f340868a = aVar;
        }
        return aVar;
    }

    public static void c(Context context, DownloadTaskInfo downloadTaskInfo) {
        if (downloadTaskInfo != null && context != null) {
            ty3.a.f().addDownloadURL(downloadTaskInfo.url);
            if (a(downloadTaskInfo.url)) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("url", downloadTaskInfo.url);
            hashMap.put("NetworkType", NetworkUtil.getNetworkType(context) + "");
            hashMap.put("reportVia", "5");
            if (downloadTaskInfo.stackInfo.length() < 950) {
                hashMap.put("Stack", downloadTaskInfo.stackInfo);
            } else {
                hashMap.put("Stack", downloadTaskInfo.stackInfo.substring(0, 950));
                if (downloadTaskInfo.stackInfo.length() < 1901) {
                    hashMap.put("Stack1", downloadTaskInfo.stackInfo.substring(950));
                } else {
                    hashMap.put("Stack1", downloadTaskInfo.stackInfo.substring(950, 1900));
                }
            }
            hashMap.put(IUniformDownloadMgr.FILESIZE_FROM_DIALOG, "0");
            hashMap.put(IUniformDownloadMgr.FILENAME_FROM_DIALOG, downloadTaskInfo.pkgName);
            if (downloadTaskInfo.versionCode > 0) {
                hashMap.put("isAPK", "1");
            } else {
                hashMap.put("isAPK", "0");
            }
            hashMap.put("VersionCode", downloadTaskInfo.versionCode + "");
            String str = downloadTaskInfo.source;
            if (TextUtils.isEmpty(str)) {
                StatisticCollector.getInstance(context).collectPerformance(null, "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, hashMap, "");
            } else {
                hashMap.put(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, str);
                StatisticCollector.getInstance(context).collectPerformance(null, "UniformDownloadEvent", true, 0L, 0L, hashMap, "");
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                for (String str2 : hashMap.keySet()) {
                    sb5.append(str2);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(hashMap.get(str2));
                    sb5.append("\n");
                }
                QLog.d("UniformDownloadEvent", 2, sb5.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UniformDownloadEvent", 2, "downloadTaskInfo is null or context==null");
        }
    }

    @Override // com.tencent.tmdownloader.notify.DownloadGlobalListener
    public void onTaskCompleted(DownloadTaskInfo downloadTaskInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("TMADownloadMonitor", 2, "onTaskCompleted,", downloadTaskInfo);
        }
    }

    @Override // com.tencent.tmdownloader.notify.DownloadGlobalListener
    public void onTaskFailed(DownloadTaskInfo downloadTaskInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("TMADownloadMonitor", 2, "onTaskFailed,", downloadTaskInfo);
        }
    }

    @Override // com.tencent.tmdownloader.notify.DownloadGlobalListener
    public void onTaskPaused(DownloadTaskInfo downloadTaskInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("TMADownloadMonitor", 2, "onTaskPaused,", downloadTaskInfo);
        }
    }

    @Override // com.tencent.tmdownloader.notify.DownloadGlobalListener
    public void onTaskStarted(DownloadTaskInfo downloadTaskInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("TMADownloadMonitor", 2, "onTaskStarted,", downloadTaskInfo);
        }
        c(BaseApplication.getContext(), downloadTaskInfo);
    }
}
