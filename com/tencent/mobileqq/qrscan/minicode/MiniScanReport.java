package com.tencent.mobileqq.qrscan.minicode;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MiniScanReport {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static a f276709a;

    /* renamed from: b, reason: collision with root package name */
    private static long f276710b;

    /* renamed from: c, reason: collision with root package name */
    private static int f276711c;

    /* renamed from: d, reason: collision with root package name */
    private static int f276712d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f276735a;

        /* renamed from: b, reason: collision with root package name */
        int f276736b;

        /* renamed from: c, reason: collision with root package name */
        int f276737c;

        /* renamed from: d, reason: collision with root package name */
        int f276738d;

        /* renamed from: e, reason: collision with root package name */
        int f276739e;

        /* renamed from: f, reason: collision with root package name */
        int f276740f;

        /* renamed from: g, reason: collision with root package name */
        int f276741g;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29138);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f276710b = 0L;
        f276711c = 0;
        f276712d = -1;
    }

    public static void b() {
        if (f276710b == 0) {
            f276710b = SystemClock.uptimeMillis();
        }
        f276711c++;
    }

    public static int c() {
        String[] split = MobileQQ.processName.split(":");
        if (split.length <= 1) {
            return 0;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.equalsIgnoreCase("peak")) {
            return 1;
        }
        if (str.equalsIgnoreCase("tool")) {
            return 2;
        }
        if (str.equalsIgnoreCase("web")) {
            return 3;
        }
        if (str.equalsIgnoreCase("qzone")) {
            return 4;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(HashMap<String, String> hashMap) {
        String model = DeviceInfoMonitor.getModel();
        int i3 = Build.VERSION.SDK_INT;
        if (model == null) {
            model = "";
        }
        hashMap.put("report_key_device_model", model);
        hashMap.put("report_key_device_sdk", String.valueOf(i3));
    }

    public static boolean e() {
        if (f276712d == -1) {
            f276712d = BaseApplication.getContext().getSharedPreferences(MiniConst.EnvSwitchActivityConst.KEY_ENV_SWITCH, 4).getBoolean("key_base_test_scan_on", false) ? 1 : 0;
        }
        if (f276712d != 1) {
            return false;
        }
        return true;
    }

    public static void f(int i3, int i16) {
        a aVar = f276709a;
        if (aVar != null && i3 > 1 && i3 <= 15000) {
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 == 2) {
                        aVar.f276738d++;
                        aVar.f276741g += i3;
                        return;
                    }
                    return;
                }
                aVar.f276737c++;
                aVar.f276740f += i3;
                return;
            }
            aVar.f276736b++;
            aVar.f276739e += i3;
        }
    }

    public static void g(int i3) {
        int i16;
        int i17;
        int i18;
        a aVar = f276709a;
        if (aVar == null) {
            return;
        }
        f276709a = null;
        long currentTimeMillis = System.currentTimeMillis() - aVar.f276735a;
        if (currentTimeMillis <= 600000 && (i16 = aVar.f276736b) > 0) {
            int i19 = aVar.f276737c;
            int i26 = aVar.f276738d;
            int i27 = aVar.f276739e / i16;
            if (i19 <= 0) {
                i17 = 0;
            } else {
                i17 = aVar.f276740f / i19;
            }
            if (i26 <= 0) {
                i18 = 0;
            } else {
                i18 = aVar.f276741g / i26;
            }
            ThreadManagerV2.post(new Runnable(i27, currentTimeMillis, i16, i3, i19, i17, i26, i18) { // from class: com.tencent.mobileqq.qrscan.minicode.MiniScanReport.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int C;
                final /* synthetic */ int D;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f276713d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f276714e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f276715f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f276716h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ int f276717i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ int f276718m;

                {
                    this.f276713d = i27;
                    this.f276714e = currentTimeMillis;
                    this.f276715f = i16;
                    this.f276716h = i3;
                    this.f276717i = i19;
                    this.f276718m = i17;
                    this.C = i26;
                    this.D = i18;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i27), Long.valueOf(currentTimeMillis), Integer.valueOf(i16), Integer.valueOf(i3), Integer.valueOf(i19), Integer.valueOf(i17), Integer.valueOf(i26), Integer.valueOf(i18));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i28;
                    String str;
                    String str2;
                    int i29;
                    int i36;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                    int i37 = this.f276713d;
                    if (i37 > 0 && i37 < 180000) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("report_key_scan_total", String.valueOf(this.f276714e));
                        hashMap.put("report_key_scan_cnt", String.valueOf(this.f276715f));
                        hashMap.put("report_key_scan_avg", String.valueOf(this.f276713d));
                        hashMap.put("report_key_scan_suc", String.valueOf(this.f276716h));
                        MiniScanReport.d(hashMap);
                        i28 = 180000;
                        str = "report_key_scan_total";
                        statisticCollector.collectPerformance("", "report_tag_scan_avg_qr", true, 0L, 0L, hashMap, "");
                    } else {
                        i28 = 180000;
                        str = "report_key_scan_total";
                    }
                    if (this.f276717i > 0 && (i36 = this.f276718m) > 0 && i36 < i28) {
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        String str3 = str;
                        hashMap2.put(str3, String.valueOf(this.f276714e));
                        hashMap2.put("report_key_scan_cnt", String.valueOf(this.f276717i));
                        hashMap2.put("report_key_scan_avg", String.valueOf(this.f276718m));
                        hashMap2.put("report_key_scan_suc", String.valueOf(this.f276716h));
                        MiniScanReport.d(hashMap2);
                        str2 = str3;
                        statisticCollector.collectPerformance("", "report_tag_scan_avg_minidecode", true, 0L, 0L, hashMap2, "");
                    } else {
                        str2 = str;
                    }
                    if (this.C > 0 && (i29 = this.D) > 0 && i29 < i28) {
                        HashMap<String, String> hashMap3 = new HashMap<>();
                        hashMap3.put(str2, String.valueOf(this.f276714e));
                        hashMap3.put("report_key_scan_cnt", String.valueOf(this.C));
                        hashMap3.put("report_key_scan_avg", String.valueOf(this.D));
                        hashMap3.put("report_key_scan_suc", String.valueOf(this.f276716h));
                        MiniScanReport.d(hashMap3);
                        statisticCollector.collectPerformance("", "report_tag_scan_avg_minidetect", true, 0L, 0L, hashMap3, "");
                    }
                    if (QLog.isColorLevel() || MiniScanReport.e()) {
                        QLog.i("MiniRecog.MiniScanReport", 1, String.format("base_test_scan markScanEnd [sucType,totalConsume,qrAvg,decodeAvg,detectAvg]=[%d,%d,%d,%d,%d]", Integer.valueOf(this.f276716h), Long.valueOf(this.f276714e), Integer.valueOf(this.f276713d), Integer.valueOf(this.f276718m), Integer.valueOf(this.D)));
                    }
                }
            }, 5, null, false);
        }
    }

    public static void h() {
        a aVar = new a();
        f276709a = aVar;
        aVar.f276735a = System.currentTimeMillis();
    }

    public static void i(boolean z16, boolean z17) {
        ThreadManagerV2.post(new Runnable(z16, z17) { // from class: com.tencent.mobileqq.qrscan.minicode.MiniScanReport.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f276726d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f276727e;

            {
                this.f276726d = z16;
                this.f276727e = z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                long q16 = MiniScanReport.q("report_tag_aio_minicode_result", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - q16 > 10800000) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    String str2 = "1";
                    if (this.f276726d) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    hashMap.put("report_key_aio_decode_suc", str);
                    if (!this.f276727e) {
                        str2 = "0";
                    }
                    hashMap.put("report_key_aio_detect_suc", str2);
                    hashMap.put("report_key_qq_version", "0");
                    hashMap.put("report_key_qq_subversion", AppSetting.f99542b);
                    MiniScanReport.d(hashMap);
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "report_tag_aio_minicode_result", true, 0L, 0L, hashMap, "");
                    if (QLog.isColorLevel()) {
                        QLog.i("MiniRecog.MiniScanReport", 2, String.format("onAIOMiniCodeResultReport [decodeSuc,detectSuc]=[%b,%b]", Boolean.valueOf(this.f276726d), Boolean.valueOf(this.f276727e)));
                    }
                    MiniScanReport.r("report_tag_aio_minicode_result", currentTimeMillis);
                }
            }
        }, 5, null, false);
    }

    public static void j(int i3) {
        ThreadManagerV2.post(new Runnable(i3) { // from class: com.tencent.mobileqq.qrscan.minicode.MiniScanReport.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f276728d;

            {
                this.f276728d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("report_key_aio_scan_recog_type", String.valueOf(this.f276728d));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "report_tag_aio_scan_recog_type", true, 0L, 0L, hashMap, "");
                if (QLog.isColorLevel()) {
                    QLog.i("MiniRecog.MiniScanReport", 2, String.format("onAIOScanRecogTypeReport %d", Integer.valueOf(this.f276728d)));
                }
            }
        }, 5, null, false);
    }

    public static void k(int i3, int i16) {
        if (i16 > 0 && i16 <= 180000) {
            ThreadManagerV2.post(new Runnable(i3, i16) { // from class: com.tencent.mobileqq.qrscan.minicode.MiniScanReport.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f276733d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f276734e;

                {
                    this.f276733d = i3;
                    this.f276734e = i16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("report_key_detect_support_type", String.valueOf(this.f276733d));
                    hashMap.put("report_key_detect_first_cost", String.valueOf(this.f276734e));
                    hashMap.put("report_key_qq_version", "0");
                    hashMap.put("report_key_qq_subversion", AppSetting.f99542b);
                    hashMap.put("report_key_detect_init_process", String.valueOf(MiniScanReport.c()));
                    MiniScanReport.d(hashMap);
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "report_tag_detect_first_cost", true, 0L, 0L, hashMap, "");
                    if (QLog.isColorLevel()) {
                        QLog.i("MiniRecog.MiniScanReport", 2, String.format("onDetectFirstCost [supportType,timeCost]=[%d,%d]", Integer.valueOf(this.f276733d), Integer.valueOf(this.f276734e)));
                    }
                }
            }, 5, null, false);
        }
    }

    public static void l(int i3, int i16) {
        if (i16 > 0 && i16 <= 180000) {
            ThreadManagerV2.post(new Runnable(i3, i16) { // from class: com.tencent.mobileqq.qrscan.minicode.MiniScanReport.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f276729d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f276730e;

                {
                    this.f276729d = i3;
                    this.f276730e = i16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("report_key_detect_support_type", String.valueOf(this.f276729d));
                    hashMap.put("report_key_detect_init_cost", String.valueOf(this.f276730e));
                    hashMap.put("report_key_qq_version", "0");
                    hashMap.put("report_key_qq_subversion", AppSetting.f99542b);
                    MiniScanReport.d(hashMap);
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "report_tag_detect_init_cost", true, 0L, 0L, hashMap, "");
                    if (QLog.isColorLevel() || MiniScanReport.e()) {
                        QLog.i("MiniRecog.MiniScanReport", 2, String.format("base_test_scan onDetectInitCost [supportType,timeCost]=[%d,%d]", Integer.valueOf(this.f276729d), Integer.valueOf(this.f276730e)));
                    }
                }
            }, 5, null, false);
        }
    }

    public static void m(int i3, int i16) {
        ThreadManagerV2.post(new Runnable(i3, i16) { // from class: com.tencent.mobileqq.qrscan.minicode.MiniScanReport.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f276731d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f276732e;

            {
                this.f276731d = i3;
                this.f276732e = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("report_key_detect_support_type", String.valueOf(this.f276731d));
                hashMap.put("report_key_detect_init_cost", String.valueOf(this.f276732e));
                hashMap.put("report_key_qq_version", AppSetting.f99551k + AppSetting.f99542b);
                MiniScanReport.d(hashMap);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "report_tag_detect_init_internal_cost", true, 0L, 0L, hashMap, "");
                if (QLog.isColorLevel() || MiniScanReport.e()) {
                    QLog.i("MiniRecog.MiniScanReport", 2, String.format("base_test_scan onDetectInitInternalCost [supportType,timeCost]=[%d,%d]", Integer.valueOf(this.f276731d), Integer.valueOf(this.f276732e)));
                }
            }
        }, 5, null, false);
    }

    public static void n(int i3, int i16) {
        ThreadManagerV2.post(new Runnable(i16, i3) { // from class: com.tencent.mobileqq.qrscan.minicode.MiniScanReport.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f276724d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f276725e;

            {
                this.f276724d = i16;
                this.f276725e = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i16), Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                long q16 = MiniScanReport.q("report_tag_detect_support_easy", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - q16 > 86400000) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("report_key_detect_support_type", String.valueOf(this.f276724d));
                    hashMap.put("report_key_detect_support_type_strict", String.valueOf(this.f276725e));
                    MiniScanReport.d(hashMap);
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "report_tag_detect_support_easy", true, 0L, 0L, hashMap, "");
                    if (QLog.isColorLevel()) {
                        QLog.i("MiniRecog.MiniScanReport", 2, String.format("onDetectSupportEasyReport [model,sdkver]=[%s,%d]", DeviceInfoMonitor.getModel(), Integer.valueOf(Build.VERSION.SDK_INT)));
                    }
                    MiniScanReport.r("report_tag_detect_support_easy", currentTimeMillis);
                }
            }
        }, 5, null, false);
    }

    public static void o(int i3, int i16) {
        ThreadManagerV2.post(new Runnable(i3, i16) { // from class: com.tencent.mobileqq.qrscan.minicode.MiniScanReport.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f276722d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f276723e;

            {
                this.f276722d = i3;
                this.f276723e = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("report_key_detect_support_type", String.valueOf(this.f276722d));
                hashMap.put("report_key_detect_init_stauts", String.valueOf(this.f276723e));
                hashMap.put("report_key_qq_version", "0");
                hashMap.put("report_key_qq_subversion", AppSetting.f99542b);
                int c16 = MiniScanReport.c();
                hashMap.put("report_key_detect_init_process", String.valueOf(c16));
                MiniScanReport.d(hashMap);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "report_tag_detect_supporttype", true, 0L, 0L, hashMap, "");
                if (QLog.isColorLevel()) {
                    QLog.i("MiniRecog.MiniScanReport", 2, String.format("onDetectSupportReport [supportType,initStatus]=[%d,%d] pid=%d", Integer.valueOf(this.f276722d), Integer.valueOf(this.f276723e), Integer.valueOf(c16)));
                }
            }
        }, 5, null, false);
    }

    public static void p(boolean z16, int i3, String str) {
        ThreadManagerV2.post(new Runnable(z16, i3, str) { // from class: com.tencent.mobileqq.qrscan.minicode.MiniScanReport.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f276719d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f276720e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f276721f;

            {
                this.f276719d = z16;
                this.f276720e = i3;
                this.f276721f = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                if (!this.f276719d) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                hashMap.put("report_key_so_suc", str2);
                hashMap.put("report_key_so_version", String.valueOf(this.f276720e));
                String str3 = this.f276721f;
                String str4 = "";
                if (str3 == null) {
                    str3 = "";
                }
                hashMap.put("report_key_so_md5", str3);
                hashMap.put("report_key_qq_version", "0");
                hashMap.put("report_key_qq_subversion", AppSetting.f99542b);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "report_tag_so_cover", true, 0L, 0L, hashMap, "");
                if (QLog.isColorLevel()) {
                    Object[] objArr = new Object[3];
                    objArr[0] = Boolean.valueOf(this.f276719d);
                    objArr[1] = Integer.valueOf(this.f276720e);
                    String str5 = this.f276721f;
                    if (str5 != null) {
                        str4 = str5;
                    }
                    objArr[2] = str4;
                    QLog.i("MiniRecog.MiniScanReport", 2, String.format("onSoCoverReport [suc,ver,md5]=[%b,%d,%s]", objArr));
                }
            }
        }, 5, null, false);
    }

    public static long q(String str, long j3) {
        return QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ, "sp_mini_scan_report", 4).getLong(str, j3);
    }

    public static void r(String str, long j3) {
        QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ, "sp_mini_scan_report", 4).edit().putLong(str, j3).apply();
    }
}
