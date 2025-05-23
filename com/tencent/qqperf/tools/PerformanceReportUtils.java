package com.tencent.qqperf.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.m;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.suspendthread.SuspendThreadManager;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* loaded from: classes25.dex */
public class PerformanceReportUtils {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f363381a = false;

    /* renamed from: b, reason: collision with root package name */
    public static int f363382b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static long f363383c = 14400000;

    /* renamed from: d, reason: collision with root package name */
    private static String f363384d = "actUISwitchC2C";

    /* renamed from: e, reason: collision with root package name */
    private static String f363385e = "actUISwitchGroup";

    /* renamed from: f, reason: collision with root package name */
    private static String f363386f = "actUISwitchDiscuss";

    /* renamed from: g, reason: collision with root package name */
    private static String f363387g = "actUISwitchQzone";

    /* renamed from: h, reason: collision with root package name */
    private static String f363388h = "actUISwitchUserAlbum";

    /* renamed from: i, reason: collision with root package name */
    private static String f363389i = "actUISwitchQunAlbum";

    /* renamed from: j, reason: collision with root package name */
    private static String f363390j = "actUISwitchUserHome";

    /* renamed from: k, reason: collision with root package name */
    private static String f363391k = "actUISwitchPushBannerMyfeed";

    /* renamed from: l, reason: collision with root package name */
    private static String f363392l = "actUISwitchNotificationMyfeed";

    /* renamed from: m, reason: collision with root package name */
    private static String f363393m = "actUISwitchMyfeed";

    /* renamed from: n, reason: collision with root package name */
    private static String f363394n = "actUISwitchAioPreload";

    /* renamed from: o, reason: collision with root package name */
    private static String f363395o = "actUISwitchAioGuild";

    /* renamed from: p, reason: collision with root package name */
    private static String f363396p = "";

    /* renamed from: q, reason: collision with root package name */
    static String[] f363397q = {"actUISwitchC2C", "actUISwitchGroup", "actUISwitchDiscuss", "actUISwitchQzone", "actUISwitchUserAlbum", "actUISwitchQunAlbum", "actUISwitchUserHome"};

    /* renamed from: r, reason: collision with root package name */
    private static long f363398r;

    /* renamed from: s, reason: collision with root package name */
    private static long f363399s;

    /* renamed from: t, reason: collision with root package name */
    private static long f363400t;

    /* renamed from: u, reason: collision with root package name */
    private static long f363401u;

    /* renamed from: v, reason: collision with root package name */
    private static long f363402v;

    /* renamed from: w, reason: collision with root package name */
    private static long f363403w;

    /* renamed from: x, reason: collision with root package name */
    private static long f363404x;

    /* loaded from: classes25.dex */
    class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f363408a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f363409b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f363410c;

        a(String str, int i3, String str2) {
            this.f363408a = str;
            this.f363409b = i3;
            this.f363410c = str2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00cb A[Catch: Exception -> 0x016a, TryCatch #0 {Exception -> 0x016a, blocks: (B:3:0x0005, B:5:0x000d, B:9:0x0019, B:11:0x001f, B:12:0x0036, B:14:0x0048, B:17:0x0077, B:19:0x007f, B:23:0x008c, B:26:0x009a, B:28:0x00cb, B:29:0x00e2, B:31:0x00eb, B:33:0x0115, B:35:0x012e, B:37:0x0157, B:39:0x015d, B:41:0x0119), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00eb A[Catch: Exception -> 0x016a, TryCatch #0 {Exception -> 0x016a, blocks: (B:3:0x0005, B:5:0x000d, B:9:0x0019, B:11:0x001f, B:12:0x0036, B:14:0x0048, B:17:0x0077, B:19:0x007f, B:23:0x008c, B:26:0x009a, B:28:0x00cb, B:29:0x00e2, B:31:0x00eb, B:33:0x0115, B:35:0x012e, B:37:0x0157, B:39:0x015d, B:41:0x0119), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0115 A[Catch: Exception -> 0x016a, TryCatch #0 {Exception -> 0x016a, blocks: (B:3:0x0005, B:5:0x000d, B:9:0x0019, B:11:0x001f, B:12:0x0036, B:14:0x0048, B:17:0x0077, B:19:0x007f, B:23:0x008c, B:26:0x009a, B:28:0x00cb, B:29:0x00e2, B:31:0x00eb, B:33:0x0115, B:35:0x012e, B:37:0x0157, B:39:0x015d, B:41:0x0119), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0119 A[Catch: Exception -> 0x016a, TryCatch #0 {Exception -> 0x016a, blocks: (B:3:0x0005, B:5:0x000d, B:9:0x0019, B:11:0x001f, B:12:0x0036, B:14:0x0048, B:17:0x0077, B:19:0x007f, B:23:0x008c, B:26:0x009a, B:28:0x00cb, B:29:0x00e2, B:31:0x00eb, B:33:0x0115, B:35:0x012e, B:37:0x0157, B:39:0x015d, B:41:0x0119), top: B:2:0x0005 }] */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            int i3;
            boolean z16;
            String str;
            SharedPreferences.Editor edit;
            try {
                SharedPreferences d16 = PerformanceReportUtils.d();
                if (this.f363408a != null && (i3 = this.f363409b) > 0) {
                    if (i3 >= 60 && QLog.isDevelopLevel()) {
                        QLog.e("PerformanceReportUtils", 4, "reportFPS  fps error fpsvalue :" + this.f363409b);
                    }
                    long j3 = d16.getLong(this.f363408a, 0L);
                    long j16 = PerformanceReportUtils.f363383c;
                    if (QLog.isDevelopLevel()) {
                        QLog.d("PerformanceReportUtils", 4, "reportFPS report_time \uff1a" + j16 + ",lastRp" + j3 + ",reportFPS fpsvalue\uff1a" + this.f363409b);
                    }
                    if (j3 != 0 && SystemClock.uptimeMillis() >= j3 && SystemClock.uptimeMillis() - j3 < j16) {
                        z16 = false;
                        boolean whetherReportThisTime = ey3.a.f().whetherReportThisTime(12, false);
                        if (!z16 || whetherReportThisTime) {
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("param_FPS", String.valueOf(this.f363409b));
                            hashMap.put("aioBusiness", this.f363410c);
                            hashMap.put("param_threadOpId", String.valueOf(com.tencent.qqperf.opt.threadpriority.a.c().b()));
                            if (QLog.isDevelopLevel()) {
                                QLog.d("PerformanceReportUtils", 4, "reportFPS real report  fpsvalue\uff1a" + this.f363409b);
                            }
                            MobileQQ.sMobileQQ.waitAppRuntime(null);
                            if (MobileQQ.sProcessId == 1) {
                                hashMap.put("param_is_logining", String.valueOf(((IAutomatorApi) QRoute.api(IAutomatorApi.class)).isLogining()));
                                hashMap.put("param_syncing_msg", String.valueOf(((IAutomatorApi) QRoute.api(IAutomatorApi.class)).isSyncingMsg()));
                            }
                            if (!z16) {
                                str = this.f363408a;
                            } else {
                                str = this.f363408a + "_new";
                            }
                            String str2 = str;
                            com.tencent.mobileqq.perf.report.a.a(hashMap);
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.getLastLoginUin(), str2, PerformanceReportUtils.h(this.f363408a), this.f363409b, 0L, hashMap, PerformanceReportUtils.f363396p);
                            if (z16 && (edit = d16.edit()) != null) {
                                edit.putLong(this.f363408a, SystemClock.uptimeMillis()).commit();
                            }
                        }
                    }
                    z16 = true;
                    boolean whetherReportThisTime2 = ey3.a.f().whetherReportThisTime(12, false);
                    if (!z16) {
                    }
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    hashMap2.put("param_FPS", String.valueOf(this.f363409b));
                    hashMap2.put("aioBusiness", this.f363410c);
                    hashMap2.put("param_threadOpId", String.valueOf(com.tencent.qqperf.opt.threadpriority.a.c().b()));
                    if (QLog.isDevelopLevel()) {
                    }
                    MobileQQ.sMobileQQ.waitAppRuntime(null);
                    if (MobileQQ.sProcessId == 1) {
                    }
                    if (!z16) {
                    }
                    String str22 = str;
                    com.tencent.mobileqq.perf.report.a.a(hashMap2);
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.getLastLoginUin(), str22, PerformanceReportUtils.h(this.f363408a), this.f363409b, 0L, hashMap2, PerformanceReportUtils.f363396p);
                    if (z16) {
                        edit.putLong(this.f363408a, SystemClock.uptimeMillis()).commit();
                    }
                }
            } catch (Exception unused) {
            }
            return null;
        }
    }

    static /* bridge */ /* synthetic */ SharedPreferences d() {
        return g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3000) {
                    if (i3 != 10014) {
                        switch (i3) {
                            case 3:
                                return f363387g;
                            case 4:
                                return f363388h;
                            case 5:
                                return f363389i;
                            case 6:
                                return f363390j;
                            case 7:
                                return f363391k;
                            case 8:
                                return f363392l;
                            case 9:
                                return f363393m;
                            case 10:
                                return f363394n;
                            default:
                                return null;
                        }
                    }
                    return f363395o;
                }
                return f363386f;
            }
            return f363385e;
        }
        return f363384d;
    }

    private static SharedPreferences g() {
        return BaseApplication.getContext().getSharedPreferences("PerformanceReportUtils", 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(String str) {
        long j3;
        if ("actFPSAIO".equals(str)) {
            j3 = f363398r;
        } else if ("actFPSRecent".equals(str)) {
            j3 = f363399s;
        } else if ("actFPSFriend".equals(str)) {
            j3 = f363400t;
        } else {
            j3 = 0;
        }
        if (j3 == 0 || ((float) (SystemClock.uptimeMillis() - j3)) / 1000.0f >= 10.0f) {
            return false;
        }
        return true;
    }

    public static void i(String str, int i3, String str2) {
        new a(str, i3, str2).execute(new Void[0]);
    }

    public static void j(Context context, final String str, final int i3, final long j3) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.qqperf.tools.PerformanceReportUtils.1
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                String valueOf;
                String str2;
                String str3;
                String str4;
                try {
                    HashMap<String, String> hashMap = new HashMap<>();
                    int i17 = i3;
                    if (i17 == 0 || i17 == 1 || i17 == 3000 || i17 == 10) {
                        if (PerformanceReportUtils.f363381a) {
                            i16 = 0;
                        } else {
                            i16 = 1;
                        }
                        hashMap.put("actloginTypt", String.valueOf(i16));
                        hashMap.put("param_threadOpId", String.valueOf(com.tencent.qqperf.opt.threadpriority.a.c().b()));
                        if (!PerformanceReportUtils.f363381a && i3 != 10) {
                            hashMap.put("aio_preloaded", String.valueOf(PerformanceReportUtils.f363382b));
                        }
                        if (MobileQQ.sMobileQQ.waitAppRuntime(null) != null && MobileQQ.sProcessId == 1) {
                            hashMap.put("param_is_logining", String.valueOf(((IAutomatorApi) QRoute.api(IAutomatorApi.class)).isLogining()));
                            hashMap.put("param_syncing_msg", String.valueOf(((IAutomatorApi) QRoute.api(IAutomatorApi.class)).isSyncingMsg()));
                        }
                        hashMap.put("param_cpu_core_num", String.valueOf(f.f()));
                        hashMap.put("param_ram", String.valueOf(m.c()));
                        hashMap.put("suspend_thread_switch", String.valueOf(SuspendThreadManager.f363305u));
                        if (vy3.a.f443747p) {
                            long currentTimeMillis = System.currentTimeMillis();
                            long j16 = vy3.a.f443748q;
                            String str5 = "-1";
                            if (j16 == -1) {
                                valueOf = "-1";
                            } else {
                                valueOf = String.valueOf(currentTimeMillis - j16);
                            }
                            long j17 = vy3.a.f443744m;
                            if (j17 == 0) {
                                str2 = "-1";
                            } else {
                                str2 = String.valueOf(currentTimeMillis - j17);
                            }
                            long j18 = vy3.a.f443743l;
                            if (j18 == 0) {
                                str3 = "-1";
                            } else {
                                str3 = String.valueOf(currentTimeMillis - j18);
                            }
                            long j19 = vy3.a.f443746o;
                            if (j19 == 0) {
                                str4 = "-1";
                            } else {
                                str4 = String.valueOf(currentTimeMillis - j19);
                            }
                            long j26 = vy3.a.f443745n;
                            if (j26 != 0) {
                                str5 = String.valueOf(currentTimeMillis - j26);
                            }
                            hashMap.put("perfConfigReportValue", String.valueOf(vy3.a.f443742k));
                            hashMap.put("automatorFinishtime", valueOf);
                            hashMap.put("qZoneInterval", str2);
                            hashMap.put("miniInterval", str3);
                            hashMap.put("troopListInterval", str4);
                            hashMap.put("preDownloadInterval", str5);
                        }
                    }
                    int i18 = i3;
                    if (i18 != 10) {
                        PerformanceReportUtils.f363381a = true;
                    }
                    String f16 = PerformanceReportUtils.f(i18);
                    SharedPreferences d16 = PerformanceReportUtils.d();
                    if (f16 != null && j3 > 0) {
                        long j27 = d16.getLong(f16, 0L);
                        long j28 = PerformanceReportUtils.f363383c;
                        if (QLog.isDevelopLevel()) {
                            QLog.d("PerformanceReportUtils", 4, "reportUISwitch report_time \uff1a" + j28 + ",lastRp" + j27 + ",aioBusiness=" + String.valueOf(b.a()));
                        }
                        if (j27 == 0 || SystemClock.uptimeMillis() < j27 || SystemClock.uptimeMillis() - j27 >= j28) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("PerformanceReportUtils", 4, "reportUISwitch timeConsumed \uff1a" + j3 + ",aioBusiness=" + String.valueOf(b.a()));
                            }
                            hashMap.put("aioBusiness", String.valueOf(b.a()));
                            com.tencent.mobileqq.perf.report.a.a(hashMap);
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, f16, true, j3, 0L, hashMap, PerformanceReportUtils.f363396p);
                            SharedPreferences.Editor edit = d16.edit();
                            if (edit != null) {
                                edit.putLong(f16, SystemClock.uptimeMillis()).commit();
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }, 8, null, false);
    }

    public static void k(String str, long j3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("PerformanceReportUtils", 4, "reportFPS saveCompleteTime \uff1atag:" + str + ",time:" + j3);
        }
        if ("actFPSAIO".equals(str)) {
            f363398r = j3;
            return;
        }
        if ("actFPSRecent".equals(str)) {
            f363399s = j3;
            return;
        }
        if ("actFPSFriend".equals(str)) {
            f363400t = j3;
            return;
        }
        if ("actFPSQZoneFriendFeed".equals(str)) {
            f363401u = j3;
            return;
        }
        if ("actFPSQZoneMyFeed".equals(str)) {
            f363402v = j3;
        } else if ("actFPSQZoneUserHome".equals(str)) {
            f363403w = j3;
        } else if ("actFPSQZoneMoodList".equals(str)) {
            f363404x = j3;
        }
    }
}
