package com.tencent.mobileqq.ar;

import com.tencent.mm.vfs.VFSTrack;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ScanEntranceReport {

    /* renamed from: c, reason: collision with root package name */
    private static ScanEntranceReport f197614c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f197615a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f197616b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ScanEntranceReport$10, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass10 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f197621d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f197622e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f197623f;
        final /* synthetic */ ScanEntranceReport this$0;

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("device_name", this.f197621d);
            hashMap.put("memory_size", String.valueOf(this.f197622e));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_average_fps", true, this.f197623f, 0L, hashMap, "");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ScanEntranceReport$11, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass11 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f197624d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f197625e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f197626f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f197627h;
        final /* synthetic */ ScanEntranceReport this$0;

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("last_total_time", String.valueOf(this.f197624d));
            hashMap.put("upload_count", String.valueOf(this.f197625e));
            hashMap.put("session_ids", this.f197626f);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_first_ocr_tips", true, this.f197627h, 0L, hashMap, "");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ScanEntranceReport$12, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass12 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f197628d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f197629e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f197630f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f197631h;
        final /* synthetic */ ScanEntranceReport this$0;

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("last_total_time", String.valueOf(this.f197628d));
            hashMap.put("upload_count", String.valueOf(this.f197629e));
            hashMap.put("session_ids", this.f197630f);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_first_ar_recog", true, this.f197631h, 0L, hashMap, "");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ScanEntranceReport$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f197632d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f197633e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f197634f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f197635h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f197636i;
        final /* synthetic */ ScanEntranceReport this$0;

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("first_init", String.valueOf(this.f197632d));
            hashMap.put("init_delay", String.valueOf(this.f197633e));
            hashMap.put(VFSTrack.INIT_TIME, String.valueOf(this.f197634f));
            hashMap.put("download_resource", String.valueOf(this.f197635h));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_ar_init", true, this.f197636i, 0L, hashMap, "");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ScanEntranceReport$3, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f197637d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f197638e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f197639f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f197640h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f197641i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ long f197642m;
        final /* synthetic */ ScanEntranceReport this$0;

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("first_init", String.valueOf(this.f197637d));
            hashMap.put("bind_time", String.valueOf(this.f197638e));
            hashMap.put("got_config_time", String.valueOf(this.f197639f));
            hashMap.put("resource_check_time", String.valueOf(this.f197640h));
            hashMap.put("dependence_wait_time", String.valueOf(this.f197641i));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_ar_init_pre", true, this.f197642m, 0L, hashMap, "");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ScanEntranceReport$7, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass7 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f197653d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f197654e;
        final /* synthetic */ ScanEntranceReport this$0;

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("select_image_avg_time", String.valueOf(this.f197653d));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_ar_cloud_upload_count", true, this.f197654e, 0L, hashMap, "");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ScanEntranceReport$8, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass8 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f197655d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f197656e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f197657f;
        final /* synthetic */ ScanEntranceReport this$0;

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("upload_count", String.valueOf(this.f197655d));
            hashMap.put("zoom_count", String.valueOf(this.f197656e));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_qr_success", true, this.f197657f, 0L, hashMap, "");
        }
    }

    public static ScanEntranceReport c() {
        if (f197614c == null) {
            f197614c = new ScanEntranceReport();
        }
        return f197614c;
    }

    private boolean k(long j3) {
        if (j3 >= 0 && j3 <= 600000) {
            return true;
        }
        return false;
    }

    public void d(final boolean z16, long j3) {
        if (j3 <= 0) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis() - j3;
        if (!k(currentTimeMillis)) {
            return;
        }
        QLog.d("ScanEntranceReport", 2, String.format("reportARCloudFirstResult success=%s totalTime=%s", Boolean.valueOf(z16), Long.valueOf(currentTimeMillis)));
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ScanEntranceReport.5
            @Override // java.lang.Runnable
            public void run() {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_ar_cloud_first_result", z16, currentTimeMillis, 0L, new HashMap<>(), "");
            }
        }, 5, null, false);
    }

    public void e(long j3, final int i3) {
        if (j3 <= 0) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis() - j3;
        if (!k(currentTimeMillis)) {
            return;
        }
        QLog.d("ScanEntranceReport", 2, String.format("reportARCloudFirstSuccess totalTime=%s", Long.valueOf(currentTimeMillis)));
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ScanEntranceReport.6
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("neon_opened", String.valueOf(i3));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_ar_cloud_first_success", true, currentTimeMillis, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void f(long j3, long j16, long j17, final int i3) {
        final boolean z16;
        if (j3 > 0 && j16 > 0 && j17 > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f197615a && !this.f197616b) {
                z16 = false;
            } else {
                z16 = true;
            }
            final long j18 = j16 - j3;
            final long j19 = j17 - j16;
            final long j26 = currentTimeMillis - j17;
            final long j27 = j18 + j19 + j26;
            if (k(j18) && k(j19) && k(j26) && k(j27)) {
                QLog.d("ScanEntranceReport", 2, String.format("reportARCloudFirstUpload firstInit=%s startDelay=%s firstSelectTime=%s firstUploadDelay=%s totalTime=%s", Boolean.valueOf(z16), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27)));
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ScanEntranceReport.4
                    @Override // java.lang.Runnable
                    public void run() {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("first_init", String.valueOf(z16));
                        hashMap.put("start_delay", String.valueOf(j18));
                        hashMap.put("first_select_time", String.valueOf(j19));
                        hashMap.put("first_upload_delay", String.valueOf(j26));
                        hashMap.put("neon_opened", String.valueOf(i3));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_ar_cloud_first_upload", true, j27, 0L, hashMap, "");
                    }
                }, 5, null, false);
            }
        }
    }

    public void g(boolean z16, long j3, long j16, final String str) {
        boolean z17;
        if (j3 > 0 && j16 > 0) {
            final long j17 = j16 - j3;
            final long currentTimeMillis = System.currentTimeMillis() - j16;
            final long j18 = j17 + currentTimeMillis;
            if (k(j17) && k(currentTimeMillis) && k(j18)) {
                this.f197615a = z16;
                if (z16 && j17 > 500) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                this.f197616b = z17;
                QLog.d("ScanEntranceReport", 2, String.format("reportActivityLaunchTime procExist=%s procRestart=%s procLoadTimeCost=%s activityLaunchTimeCost=%s totalTimeCost=%s source=%s", Boolean.valueOf(z16), Boolean.valueOf(this.f197616b), Long.valueOf(j17), Long.valueOf(currentTimeMillis), Long.valueOf(j18), str));
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ScanEntranceReport.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("proc_exist", String.valueOf(ScanEntranceReport.this.f197615a));
                        hashMap.put("proc_restart", String.valueOf(ScanEntranceReport.this.f197616b));
                        hashMap.put("proc_load_time", String.valueOf(j17));
                        hashMap.put("activity_launch_time", String.valueOf(currentTimeMillis));
                        hashMap.put(PeakConstants.KEY_ENTRY_SOURCE, str);
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_activity_launch", true, j18, 0L, hashMap, "");
                    }
                }, 5, null, false);
            }
        }
    }

    public void h(boolean z16) {
        QLog.d("ScanEntranceReport", 2, String.format("reportQBarSoLoadFail systemLoadSuccess=%s", Boolean.valueOf(z16)));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_qbar_so_load_fail", z16, 0L, 0L, new HashMap<>(), "");
    }

    public void i() {
        QLog.d("ScanEntranceReport", 2, "reportZoomCamera");
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ScanEntranceReport.9
            @Override // java.lang.Runnable
            public void run() {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_zoom_camera", true, 0L, 0L, new HashMap<>(), "");
            }
        }, 5, null, false);
    }

    public void j() {
        this.f197615a = false;
        this.f197616b = false;
    }
}
