package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.sql.Timestamp;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AnalyticsSwitchHolder {
    public static final int ANALYTICS_DISABLED = 2;
    public static final int ANALYTICS_ENABLED = 1;

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f37657a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f37658b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static volatile Long f37659c = 0L;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f37660d = false;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f37661e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f37662a;

        a(Context context) {
            this.f37662a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnalyticsSwitchHolder.f(this.f37662a);
            HMSLog.i("AnalyticsSwitchHolder", "getStateForHmsAnalyticsProvider");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f37663a;

        b(Context context) {
            this.f37663a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("AnalyticsSwitchHolder", "enter setAnalyticsStateAndTimestamp");
            AnalyticsSwitchHolder.f(this.f37663a);
            HMSLog.i("AnalyticsSwitchHolder", "quit setAnalyticsStateAndTimestamp");
        }
    }

    private static boolean b(Context context) {
        Bundle bundle;
        if (context == null) {
            HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getBoolean("com.huawei.hms.client.bireport.setting");
                }
            } catch (AndroidException unused) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
            } catch (RuntimeException e16) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.", e16);
            }
        }
        HMSLog.i("AnalyticsSwitchHolder", "In getBiIsReportSetting, configuration not found for bi report setting.");
        return false;
    }

    private static void c(Context context) {
        f37659c = Long.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        new BaseThread(new a(context), "Thread-getStateForHmsAnalyticsProvider").start();
    }

    private static boolean d(Context context) {
        return LocaleManager.MOBILE_COUNTRY_CODE_CN_STR.equalsIgnoreCase(GrsApp.getInstance().getIssueCountryCode(context));
    }

    private static void e(Context context) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (timestamp.getTime() - f37659c.longValue() >= 86400000 && f37659c.longValue() > 0) {
            f37659c = Long.valueOf(timestamp.getTime());
            new BaseThread(new b(context), "Thread-refreshOobeAnalyticsState").start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context) {
        if (context == null) {
            HMSLog.e("AnalyticsSwitchHolder", "In setAnalyticsState\u3001, context is null.");
            return;
        }
        if (HiAnalyticsUtils.getInstance().getOobeAnalyticsState(context) == 1) {
            synchronized (f37658b) {
                f37657a = 1;
            }
            if (!HiAnalyticsUtils.getInstance().getInitFlag() && !f37660d) {
                HMSBIInitializer.getInstance(context).initHaSDK();
                f37660d = true;
                return;
            }
            return;
        }
        synchronized (f37658b) {
            f37657a = 2;
        }
        com.huawei.hms.stats.a.c().a();
    }

    public static int getAndRefreshAnalyticsState(Context context) {
        int i3;
        synchronized (f37658b) {
            isAnalyticsDisabled(context);
            i3 = f37657a;
        }
        return i3;
    }

    public static boolean getBiSetting(Context context) {
        Bundle bundle;
        if (context == null) {
            HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getBoolean("com.huawei.hms.client.bi.setting");
                }
            } catch (AndroidException unused) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.");
            } catch (RuntimeException e16) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.", e16);
            }
        }
        HMSLog.i("AnalyticsSwitchHolder", "In getBiSetting, configuration not found for bisetting.");
        return false;
    }

    public static boolean isAnalyticsDisabled(Context context) {
        synchronized (f37658b) {
            if (f37657a == 0) {
                if (context == null) {
                    return true;
                }
                if (b(context)) {
                    HMSLog.i("AnalyticsSwitchHolder", "Builder->biReportSetting :true");
                    f37657a = 1;
                } else if (getBiSetting(context)) {
                    HMSLog.i("AnalyticsSwitchHolder", "Builder->biSetting :true");
                    f37657a = 2;
                } else if (d(context)) {
                    f37657a = 1;
                } else {
                    HMSLog.i("AnalyticsSwitchHolder", "not ChinaROM");
                    f37657a = 3;
                    f37661e = true;
                    c(context);
                }
            } else if (f37661e) {
                e(context);
            }
            if (f37657a != 1) {
                return true;
            }
            return false;
        }
    }
}
