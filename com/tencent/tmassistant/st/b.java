package com.tencent.tmassistant.st;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tmassistant.common.jce.BoutiqueGameConfig;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f380401a;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b();
        }
    }

    b() {
        e.a().postDelayed(new a(), 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ArrayList<String> arrayList;
        BoutiqueGameConfig boutiqueGameConfig = (BoutiqueGameConfig) com.tencent.tmdownloader.f.b.b.a().a("key_recommend_games_config", BoutiqueGameConfig.class);
        if (boutiqueGameConfig != null && (arrayList = boutiqueGameConfig.pkgList) != null && arrayList.size() != 0) {
            Iterator<String> it = boutiqueGameConfig.pkgList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                com.tencent.tmdownloader.internal.downloadservice.c queryDownloadInfoByPkgName = ApkDownloadManager.getInstance().queryDownloadInfoByPkgName(next);
                if (queryDownloadInfoByPkgName != null && queryDownloadInfoByPkgName.f380686g == 4 && (TextUtils.isEmpty(queryDownloadInfoByPkgName.A) || !queryDownloadInfoByPkgName.A.endsWith("SENDED"))) {
                    if (com.tencent.tmdownloader.internal.downloadservice.a.a(next, 0)) {
                        try {
                            long j3 = InstalledAppListMonitor.getPackageInfo(GlobalUtil.getInstance().getContext().getPackageManager(), next, 0).lastUpdateTime;
                            long j16 = j3 - queryDownloadInfoByPkgName.f380700u;
                            if (j16 > 0 && j16 < 86400000) {
                                a(next, queryDownloadInfoByPkgName, j3);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    public static b a() {
        if (f380401a == null) {
            synchronized (b.class) {
                if (f380401a == null) {
                    f380401a = new b();
                }
            }
        }
        return f380401a;
    }

    public void a(com.tencent.tmdownloader.internal.downloadservice.c cVar, DownloaderTask downloaderTask) {
        String str;
        cVar.f380700u = System.currentTimeMillis();
        if (!TextUtils.isEmpty(cVar.f380697r) && GlobalUtil.isRecommendGame(cVar.f380697r)) {
            long j3 = 0;
            try {
                com.tencent.tmdownloader.f.b.a.a().a(cVar);
                String savePath = downloaderTask.getSavePath();
                j3 = new File(savePath).length();
                System.currentTimeMillis();
                str = com.tencent.dlsdk.yybutil.apkchannel.a.a(savePath);
            } catch (Throwable th5) {
                r.a("BoutiqueGameRT", "[doDownloadSuccReport] read dowloaded fileSize error:" + th5.getMessage());
                str = "";
            }
            SDKReportManager2.getInstance().postReport(2004, cVar.f380700u + "|" + Build.BRAND + "|" + DeviceInfoMonitor.getModel() + "|" + GlobalUtil.getInstance().getImei() + "|" + cVar.f380697r + "|" + cVar.f380698s + "|" + str + "|" + cVar.f380681b + "|" + j3 + "|" + cVar.f380703x + "|" + GlobalUtil.getInstance().getAppVersionCode());
            return;
        }
        r.a("BoutiqueGameRT", "download complete, mTaskPackageName is empty! || not bgg");
    }

    public void a(String str) {
        com.tencent.tmdownloader.internal.downloadservice.c queryDownloadInfoByPkgName = ApkDownloadManager.getInstance().queryDownloadInfoByPkgName(str);
        if (queryDownloadInfoByPkgName != null && queryDownloadInfoByPkgName.f380686g == 4 && (TextUtils.isEmpty(queryDownloadInfoByPkgName.A) || !queryDownloadInfoByPkgName.A.endsWith("SENDED"))) {
            if (!TextUtils.isEmpty(str) && GlobalUtil.isRecommendGame(str)) {
                Context context = GlobalUtil.getInstance().getContext();
                long j3 = 0;
                String str2 = "";
                if (context != null) {
                    try {
                        String str3 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).applicationInfo.sourceDir;
                        j3 = new File(str3).length();
                        System.currentTimeMillis();
                        str2 = com.tencent.dlsdk.yybutil.apkchannel.a.a(str3);
                    } catch (Throwable th5) {
                        r.a("BoutiqueGameRT", "[doInstallSuccReport] read installed fileSize error:" + th5.getMessage());
                    }
                }
                SDKReportManager2.getInstance().postReport(2005, System.currentTimeMillis() + "|" + Build.BRAND + "|" + DeviceInfoMonitor.getModel() + "|" + GlobalUtil.getInstance().getImei() + "|" + str + "|" + queryDownloadInfoByPkgName.f380698s + "|" + str2 + "|" + queryDownloadInfoByPkgName.f380681b + "|" + j3 + "|" + queryDownloadInfoByPkgName.f380703x + "|" + GlobalUtil.getInstance().getAppVersionCode() + "|" + queryDownloadInfoByPkgName.f380700u);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(queryDownloadInfoByPkgName.A);
                sb5.append("SENDED");
                queryDownloadInfoByPkgName.A = sb5.toString();
                com.tencent.tmdownloader.f.b.a.a().a(queryDownloadInfoByPkgName);
                return;
            }
            r.a("BoutiqueGameRT", "install complete, pkgName is empty!");
            return;
        }
        r.a("BoutiqueGameRT", "[doInstallSuccReport] di is NULL OR di.mStatus != DOWNLOAD_STATUS_SUCCEED OR SENDED!");
    }

    private void a(String str, com.tencent.tmdownloader.internal.downloadservice.c cVar, long j3) {
        Context context = GlobalUtil.getInstance().getContext();
        long j16 = 0;
        String str2 = "";
        if (context != null) {
            try {
                String str3 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).applicationInfo.sourceDir;
                j16 = new File(str3).length();
                System.currentTimeMillis();
                str2 = com.tencent.dlsdk.yybutil.apkchannel.a.a(str3);
            } catch (Throwable th5) {
                r.a("BoutiqueGameRT", "[doInstallReportDir] read installed fileSize error:" + th5.getMessage());
            }
        }
        SDKReportManager2.getInstance().postReport(2005, j3 + "|" + Build.BRAND + "|" + DeviceInfoMonitor.getModel() + "|" + GlobalUtil.getInstance().getImei() + "|" + str + "|" + str2 + "|" + cVar.f380681b + "|" + j16 + "|" + cVar.f380703x + "|" + GlobalUtil.getInstance().getAppVersionCode() + "|" + cVar.f380700u);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(cVar.A);
        sb5.append("SENDED");
        cVar.A = sb5.toString();
        com.tencent.tmdownloader.f.b.a.a().a(cVar);
    }
}
