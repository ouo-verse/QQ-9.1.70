package com.tencent.open.appstore.dl;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloadInfoReport {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, String> f340780a = new ConcurrentHashMap<>();

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && (str.endsWith("patch") || str.endsWith("zip") || str.endsWith("7z"))) {
            return true;
        }
        return false;
    }

    protected static String b(int i3) {
        if (i3 == 1) {
            return "0X800BECF";
        }
        if (i3 == 2) {
            return "0X800BED0";
        }
        return null;
    }

    public static boolean c(Context context) {
        String packageName;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            packageName = context.getApplicationContext().getPackageName();
            runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
        } catch (Throwable unused) {
        }
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && (str = runningAppProcessInfo.processName) != null) {
                if (!str.equals(packageName)) {
                    if (runningAppProcessInfo.processName.startsWith(packageName + ":")) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x0238, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(Context context, DownloadInfo downloadInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        if (downloadInfo != null && context != null) {
            ty3.a.f().addDownloadURL(downloadInfo.f341186f);
            if (a(downloadInfo.f341186f)) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("url", downloadInfo.f341186f);
            hashMap.put("NetworkType", NetworkUtil.getNetworkType(context) + "");
            if (!c(context)) {
                str = "0";
            } else {
                str = "1";
            }
            hashMap.put("isForeground", str);
            hashMap.put("reportVia", "3");
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            StringBuilder sb5 = new StringBuilder();
            try {
                if (f340780a.containsKey(downloadInfo.f341184e)) {
                    sb5.append(f340780a.remove(downloadInfo.f341184e));
                } else if (f340780a.containsKey(downloadInfo.f341186f)) {
                    sb5.append(f340780a.remove(downloadInfo.f341186f));
                }
            } catch (Throwable unused) {
            }
            for (int i3 = 1; i3 < stackTrace.length; i3++) {
                sb5.append(stackTrace[i3].toString());
            }
            if (sb5.length() < 950) {
                hashMap.put("Stack", sb5.toString());
            } else {
                hashMap.put("Stack", sb5.substring(0, 950));
                if (sb5.length() < 1901) {
                    hashMap.put("Stack1", sb5.substring(950));
                } else {
                    hashMap.put("Stack1", sb5.substring(950, 1900));
                }
            }
            hashMap.put(IUniformDownloadMgr.FILESIZE_FROM_DIALOG, downloadInfo.f341187f0 + "");
            String str5 = downloadInfo.f341189h;
            hashMap.put(IUniformDownloadMgr.FILENAME_FROM_DIALOG, str5);
            if (downloadInfo.X) {
                hashMap.put("isAPK", "1");
            } else {
                hashMap.put("isAPK", "0");
            }
            String str6 = downloadInfo.C;
            if (str6 == null) {
                str6 = "";
            }
            hashMap.put("ReferURL", str6);
            String str7 = downloadInfo.M;
            StringBuilder sb6 = new StringBuilder(downloadInfo.f341186f);
            sb6.append(";");
            sb6.append(hashMap.get("NetworkType"));
            sb6.append(";");
            sb6.append(str7);
            sb6.append(";");
            sb6.append(str5);
            sb6.append(";");
            sb6.append(hashMap.get(IUniformDownloadMgr.FILESIZE_FROM_DIALOG));
            sb6.append(";");
            sb6.append(hashMap.get("ReferURL"));
            if (TextUtils.isEmpty(str7)) {
                if (sb5.toString().contains("DownloadInterface")) {
                    str7 = "DownloadAPI";
                } else if (sb5.toString().contains("DownloadReceiver")) {
                    str7 = "DownloadManager";
                } else if (sb5.toString().contains("now.download.js.DownloadJSApi")) {
                    str7 = "biz_src_now";
                } else if (sb5.toString().contains("DownloadApi")) {
                    if (!str5.equals(QZoneHelper.PACKAGENAME_QQMUSIC)) {
                        if (!str5.equals("com.tencent.nijigen")) {
                            if (!str5.equals("com.tencent.mobileqq")) {
                                if (str5.equals("com.tencent.reading")) {
                                    str7 = "biz_src_jc_neirong";
                                } else if (str5.equals("com.tencent.news.lite")) {
                                    str7 = "biz_src_news";
                                }
                            }
                            str7 = "biz_src_yyb";
                        }
                        str7 = "biz_src_zz_bodong";
                    }
                    str7 = "biz_src_qqmusic";
                } else {
                    String str8 = downloadInfo.C;
                    if (str8 == null) {
                        str8 = "";
                    }
                    if (!TextUtils.isEmpty(str8)) {
                        if (!str8.equals("ANDROIDQQ.QQMUSIC.GENE")) {
                            if (!str8.equals("1")) {
                                if (!str8.equals("ANDROID.QQ.NEWYYBAPK") && !str8.startsWith("YYBH5.STORE.COMMONDETAIL.FEED.ADVERTISE") && !str8.equals("ANDROIDQQ.NEWYYB.XINJIFUWUHAO")) {
                                    if (str8.startsWith("ANDROIDQQ.FEED.ADVERTISE")) {
                                        str7 = AdDownloadConstants.DOWNLOAD_SOURCE_AD;
                                    }
                                }
                            }
                            str7 = "biz_src_zz_bodong";
                        }
                        str7 = "biz_src_qqmusic";
                    }
                }
            }
            if (TextUtils.isEmpty(str7)) {
                StatisticCollector.getInstance(context).collectPerformance(null, "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, hashMap, "");
                String str9 = hashMap.get("isForeground");
                String str10 = hashMap.get("isAPK");
                String sb7 = sb6.toString();
                StringBuilder sb8 = new StringBuilder();
                sb8.append(hashMap.get("Stack"));
                if (!hashMap.containsKey("Stack1")) {
                    str4 = "";
                } else {
                    str4 = hashMap.get("Stack1");
                }
                sb8.append(str4);
                ReportController.o(null, "dc00898", "", "", "0X800A003", "0X800A003", 1, 0, str9, str10, sb7, sb8.toString());
                str2 = "UniformDownloadEvent";
            } else {
                hashMap.put(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, str7);
                str2 = "UniformDownloadEvent";
                StatisticCollector.getInstance(context).collectPerformance(null, "UniformDownloadEvent", true, 0L, 0L, hashMap, "");
                String str11 = hashMap.get("isForeground");
                String str12 = hashMap.get("isAPK");
                String sb9 = sb6.toString();
                StringBuilder sb10 = new StringBuilder();
                sb10.append(hashMap.get("Stack"));
                if (!hashMap.containsKey("Stack1")) {
                    str3 = "";
                } else {
                    str3 = hashMap.get("Stack1");
                }
                sb10.append(str3);
                ReportController.o(null, "dc00898", "", "", "0X800A002", "0X800A002", 1, 0, str11, str12, sb9, sb10.toString());
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb11 = new StringBuilder();
                for (String str13 : hashMap.keySet()) {
                    sb11.append(str13);
                    sb11.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb11.append(hashMap.get(str13));
                    sb11.append("\n");
                }
                QLog.d(str2, 2, sb11.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UniformDownloadEvent", 2, "downloadInfo is null");
        }
    }

    public static void e(AppInterface appInterface, DownloadInfo downloadInfo) {
        d(appInterface.getApp(), downloadInfo);
    }

    public static void f(final int i3, @Nullable String str, final int i16, @Nullable final Object obj, final int i17) {
        try {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadInfoReport.2
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    try {
                        String b16 = DownloadInfoReport.b(i17);
                        if (TextUtils.isEmpty(b16)) {
                            f.e("UniformDownloadEvent", "reportDownloadInfoFromClicked action is empty");
                            return;
                        }
                        Object obj2 = obj;
                        if (obj2 instanceof DownloadInfo) {
                            String str3 = ((DownloadInfo) obj2).f341186f;
                            f.e("UniformDownloadEvent", "realURL : " + str3);
                            if (!TextUtils.isEmpty(str3)) {
                                int i18 = i3;
                                int i19 = i16;
                                if (TextUtils.isEmpty(((DownloadInfo) obj).f341189h)) {
                                    str2 = GlobalUtil.DEF_STRING;
                                } else {
                                    str2 = ((DownloadInfo) obj).f341189h;
                                }
                                ReportController.o(null, "dc00898", "", "", b16, b16, i18, i19, "1", "1", str3, str2);
                            }
                        }
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UniformDownloadEvent", 2, th5, " in reportSpecialCareAPKDownloadInfoFromClicked");
                        }
                    }
                }
            });
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("UniformDownloadEvent", 2, th5, " in reportSpecialCareAPKDownloadInfoFromClicked");
            }
        }
    }

    public static void g(final int i3, @Nullable final String str, final int i16, @Nullable final Object obj) {
        try {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadInfoReport.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    String str3;
                    String str4 = "1";
                    try {
                        int i17 = i3;
                        if (i17 != 1) {
                            if (i17 != 2) {
                                if (i17 != 11) {
                                    if (i17 != 12) {
                                        return;
                                    }
                                }
                            }
                            Object obj2 = obj;
                            if (obj2 instanceof DownloadInfo) {
                                String str5 = ((DownloadInfo) obj2).f341186f;
                                if (!TextUtils.isEmpty(str5)) {
                                    if (str5.contains("204002177")) {
                                        int i18 = i3;
                                        int i19 = i16;
                                        if (TextUtils.isEmpty(((DownloadInfo) obj).f341189h)) {
                                            str3 = GlobalUtil.DEF_STRING;
                                        } else {
                                            str3 = ((DownloadInfo) obj).f341189h;
                                        }
                                        ReportController.o(null, "dc00898", "", "", "0X800A80D", "0X800A80D", i18, i19, "1", "1", str5, str3);
                                    } else if (str5.contains("weseeugg.qq.com/download")) {
                                        int i26 = i3;
                                        int i27 = i16;
                                        if (TextUtils.isEmpty(((DownloadInfo) obj).f341189h)) {
                                            str2 = GlobalUtil.DEF_STRING;
                                        } else {
                                            str2 = ((DownloadInfo) obj).f341189h;
                                        }
                                        ReportController.o(null, "dc00898", "", "", "0X800A80D", "0X800A80D", i26, i27, "2", "1", str5, str2);
                                    }
                                    if (((DownloadInfo) obj).f341189h.equals("com.tencent.rijvideo")) {
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("datesource", "1");
                                        if (!DownloadInfoReport.c(BaseApplication.getContext())) {
                                            str4 = "0";
                                        }
                                        hashMap.put("isForeground", str4);
                                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "kd_click_ug_download_finish", true, 0L, 0L, hashMap, "", true);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            String str6 = str;
                            String str7 = "";
                            if (str6 != null && str6.contains("204002177")) {
                                Object obj3 = obj;
                                if (obj3 instanceof DownloadInfo) {
                                    str7 = ((DownloadInfo) obj3).f341189h;
                                }
                                ReportController.o(null, "dc00898", "", "", "0X800A80C", "0X800A80C", i3, i16, "1", "1", str, str7);
                                return;
                            }
                            String str8 = str;
                            if (str8 != null && str8.contains("weseeugg.qq.com/download")) {
                                Object obj4 = obj;
                                if (obj4 instanceof DownloadInfo) {
                                    str7 = ((DownloadInfo) obj4).f341189h;
                                }
                                ReportController.o(null, "dc00898", "", "", "0X800A80C", "0X800A80C", i3, i16, "2", "1", str, str7);
                            }
                        }
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UniformDownloadEvent", 2, th5, " in reportSpecialCareAPKDownloadInfo");
                        }
                    }
                }
            });
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("UniformDownloadEvent", 2, th5, " in reportSpecialCareAPKDownloadInfo");
            }
        }
    }
}
