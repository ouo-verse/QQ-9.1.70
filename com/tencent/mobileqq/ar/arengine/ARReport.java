package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARReport {

    /* renamed from: a, reason: collision with root package name */
    private static ARReport f197922a;

    /* renamed from: b, reason: collision with root package name */
    private static final FileFilter f197923b = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.arengine.ARReport$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f197924d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f197925e;
        final /* synthetic */ ARReport this$0;

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> hashMap = new HashMap<>();
            if (this.this$0.t(this.f197924d)) {
                hashMap.put("total_render_all_time", String.valueOf(this.f197924d));
            }
            if (this.this$0.t(this.f197925e)) {
                hashMap.put("total_render_success_time", String.valueOf(this.f197925e));
            }
            hashMap.put("buildmodel", DeviceInfoMonitor.getModel());
            hashMap.put("cpuNumber", String.valueOf(ARReport.d()));
            hashMap.put("totalram", ARReport.e(BaseApplication.getContext()));
            hashMap.put("cpuname", this.this$0.b());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidactARTotal", true, this.f197924d, 0L, hashMap, "");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.arengine.ARReport$15, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass15 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f197935d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f197936e;
        final /* synthetic */ ARReport this$0;

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ar_model", DeviceInfoMonitor.getModel());
            hashMap.put("result", this.f197935d + "");
            hashMap.put("alltime", String.valueOf(this.f197936e));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AREngine_openCamera", true, 0L, 0L, hashMap, "", true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i3 = 3; i3 < name.length(); i3++) {
                if (name.charAt(i3) < '0' || name.charAt(i3) > '9') {
                    return false;
                }
            }
            return true;
        }
    }

    public static ARReport c() {
        if (f197922a == null) {
            f197922a = new ARReport();
        }
        return f197922a;
    }

    public static int d() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(f197923b).length;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    public static String e(Context context) {
        return "2";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(long j3) {
        if (j3 >= 0 && j3 <= 600000) {
            return true;
        }
        return false;
    }

    public String b() {
        return "un";
    }

    public void f(final long j3, final boolean z16) {
        QLog.d("AREngine_ARReport", 2, String.format("report  ARCloudControlSo mTotal:  %s result:  %s", Long.valueOf(j3), Boolean.valueOf(z16)));
        if (!t(j3)) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.8
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("alltime", String.valueOf(j3));
                if (z16) {
                    hashMap.put("result", "0");
                } else {
                    hashMap.put("result", "1");
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARCloudControlSo", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void g(final long j3, final boolean z16) {
        QLog.d("AREngine_ARReport", 2, String.format("report  ARCloudControlinit mTotal:  %s result:  %s", Long.valueOf(j3), Boolean.valueOf(z16)));
        if (!t(j3)) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.9
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("alltime", String.valueOf(j3));
                if (z16) {
                    hashMap.put("result", "0");
                } else {
                    hashMap.put("result", "1");
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARCloudControlinit", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void h(final long j3, final int i3) {
        QLog.d("AREngine_ARReport", 2, String.format("report   AREngineinitAR mTotal:  %s  result:  %s", Long.valueOf(j3), Integer.valueOf(i3)));
        if (!t(j3)) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.16
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("alltime", String.valueOf(j3));
                hashMap.put("result", i3 + "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AREngineinitAR", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void i(final long j3, final boolean z16) {
        QLog.d("AREngine_ARReport", 2, String.format("report  ARLocalControlint mTotal:  %s result:  %s", Long.valueOf(j3), Boolean.valueOf(z16)));
        if (!t(j3)) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.7
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("alltime", String.valueOf(j3));
                if (z16) {
                    hashMap.put("result", "0");
                } else {
                    hashMap.put("result", "1");
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARLocalControlInt", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void j(final long j3, final boolean z16) {
        QLog.d("AREngine_ARReport", 2, String.format("report   ARLocalFaceRecogInit mTotal:  %s result:  %s", Long.valueOf(j3), Boolean.valueOf(z16)));
        if (!t(j3)) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.13
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("alltime", String.valueOf(j3));
                if (z16) {
                    hashMap.put("result", "0");
                } else {
                    hashMap.put("result", "1");
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARLocalFaceRecogInit", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void k(final long j3, final boolean z16) {
        QLog.d("AREngine_ARReport", 2, String.format("report   ARLocalMarkerRecoglSo mTotal:  %s result:  %s", Long.valueOf(j3), Boolean.valueOf(z16)));
        if (!t(j3)) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.11
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("alltime", String.valueOf(j3));
                if (z16) {
                    hashMap.put("result", "0");
                } else {
                    hashMap.put("result", "1");
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARLocalMarkerRecoglSo", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void l(final long j3, final boolean z16) {
        QLog.d("AREngine_ARReport", 2, String.format("report   ARLocalMarkerRecoglinit mTotal:  %s result:   %s", Long.valueOf(j3), Boolean.valueOf(z16)));
        if (!t(j3)) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.10
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("alltime", String.valueOf(j3));
                if (z16) {
                    hashMap.put("result", "0");
                } else {
                    hashMap.put("result", "1");
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARLocalMarkerRecoglinit", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void m(final long j3) {
        QLog.d("AREngine_ARReport", 2, String.format("report  ARMarkerResourceManagerint mTotal:  %s ", Long.valueOf(j3)));
        if (!t(j3)) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.6
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("alltime", String.valueOf(j3));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARMarkerResourceManagerInt", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void n(final long j3, final boolean z16) {
        QLog.d("AREngine_ARReport", 2, String.format("report   ARNativeBridgeSo mTotal:  %s result:  %s", Long.valueOf(j3), Boolean.valueOf(z16)));
        if (!t(j3)) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.12
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("alltime", String.valueOf(j3));
                if (z16) {
                    hashMap.put("result", "0");
                } else {
                    hashMap.put("result", "1");
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARNativeBridgeSo", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void o(final String str, final long j3, final long j16, final int i3, final long j17, final long j18, final int i16, final long j19, final int i17, final long j26, final long j27, final int i18) {
        QLog.d("AREngine_ARReport", 2, String.format("report  CloudDownload   mImageId=:  %s mFeatureSize=:  %s mFeatureTime=:  %s mFeatureCode=:  %s  mModedSize=:  %s  mModelTime=:  %s mModelCode=:  %s mUnzipeTime=:  %s mType=:  %s totalTime=:  %s  mNetSize=:  %s mResult=:  %s", str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Long.valueOf(j17), Long.valueOf(j18), Integer.valueOf(i16), Long.valueOf(j19), Integer.valueOf(i17), Long.valueOf(j26), Long.valueOf(j27), Integer.valueOf(i18)));
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.2
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                String str2 = str;
                if (str2 != null) {
                    hashMap.put("cloud_download_imgId", String.valueOf(str2));
                }
                long j28 = j3;
                if (j28 > 0) {
                    hashMap.put("cloud_download_feature_size", String.valueOf(j28));
                }
                if (ARReport.this.t(j16)) {
                    hashMap.put("cloud_download_feature_time", String.valueOf(j16));
                }
                int i19 = i3;
                if (i19 > -1) {
                    hashMap.put("cloud_download_feature_code", String.valueOf(i19));
                }
                long j29 = j17;
                if (j29 > 0) {
                    hashMap.put("cloud_download_model_size", String.valueOf(j29));
                }
                if (ARReport.this.t(j18)) {
                    hashMap.put("cloud_download_model_time", String.valueOf(j18));
                }
                int i26 = i16;
                if (i26 > -1) {
                    hashMap.put("cloud_download_model_code", String.valueOf(i26));
                }
                long j36 = j19;
                if (j36 > 0) {
                    hashMap.put("cloud_download_unzip_time", String.valueOf(j36));
                }
                int i27 = i17;
                if (i27 > -1) {
                    hashMap.put("cloud_download_type", String.valueOf(i27));
                }
                hashMap.put("cloud_download_net_type", String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext())));
                if (ARReport.this.t(j26)) {
                    hashMap.put("cloud_download_all_time", String.valueOf(j26));
                }
                long j37 = j27;
                if (j37 > 0) {
                    hashMap.put("cloud_download_net_size", String.valueOf(j37));
                }
                int i28 = i18;
                if (i28 > -1) {
                    hashMap.put("cloud_download_all_result", String.valueOf(i28));
                }
                hashMap.put("cloud_download_type", "0");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidactARCloudDownLoad", true, 0L, 0L, hashMap, "", true);
            }
        }, 5, null, false);
    }

    public void p(final long j3, final long j16, final long j17, final long j18, final long j19, final String str) {
        QLog.d("AREngine_ARReport", 2, String.format("report Local mDataReportLoadedFeatureTimeLen=:  %s  mDataReportLoadedFeatureCnt=:  %s mDataReportFirstRecogSuccessTimeLen=:  %s  mDataReportFirstRecogSuccessFrameCnt=:  %s  mDataReportRecogQuality=:  %s mDataReportFirstRecogSuccessFeatureId=:  %s  ", Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), str));
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.4
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                if (ARReport.this.t(j3)) {
                    hashMap.put("local_load_feature_time", String.valueOf(j3));
                }
                long j26 = j16;
                if (j26 > 0) {
                    hashMap.put("local_load_feature_count", String.valueOf(j26));
                }
                if (ARReport.this.t(j17)) {
                    hashMap.put("local_recognize_time", String.valueOf(j17));
                }
                long j27 = j18;
                if (j27 > 0) {
                    hashMap.put("local_recognize_times", String.valueOf(j27));
                }
                long j28 = j19;
                if (j28 > 0) {
                    hashMap.put("local_recognize_quality", String.valueOf(j28));
                }
                if (!str.equals("")) {
                    hashMap.put("local_recognize_featureid", str);
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidactARLocal", true, 0L, 0L, hashMap, "", true);
            }
        }, 5, null, false);
    }

    public void q(final long j3) {
        QLog.d("AREngine_ARReport", 2, String.format("report   SensorTrackManagerInit mTotal:  %s ", Long.valueOf(j3)));
        if (!t(j3)) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.14
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("alltime", String.valueOf(j3));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "SensorTrackManagerInit", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void r(final long j3) {
        QLog.d("AREngine_ARReport", 2, String.format("report  WebView mTotal:  %s ", Long.valueOf(j3)));
        if (!t(j3)) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.5
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_LOADING_TIME, String.valueOf(j3));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidactARWebView", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void s(final long j3, final long j16, final long j17, final int i3, final String str, final int i16, final long j18, final long j19, final long j26, final int i17) {
        QLog.d("AREngine_ARReport", 2, String.format("report  selectImg   mSelectTime=:  %s  mUploadTime=:  %s mImgSize=:  %s  mUploadTimes=:  %s  mImageId=:  %s mCloudTime=:  %s mCloudAllSize=:  %s mCloudAllTime=:  %s mtotaltime=:  %s  mResult=:  %s ", Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), str, Integer.valueOf(i16), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Integer.valueOf(i17)));
        if (i3 < 1) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARReport.3
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                if (ARReport.this.t(j3)) {
                    hashMap.put("cloud_choose_time", String.valueOf(j3));
                }
                if (ARReport.this.t(j16)) {
                    hashMap.put("cloud_upload_time", String.valueOf(j16));
                }
                if (ARReport.this.t(j17)) {
                    hashMap.put("cloud_upload_size", String.valueOf(j17));
                }
                if (ARReport.this.t(i3)) {
                    hashMap.put("cloud_upload_times", String.valueOf(i3));
                }
                String str2 = str;
                if (str2 != null) {
                    hashMap.put("cloud_upload_imgid", str2);
                }
                if (ARReport.this.t(i16)) {
                    hashMap.put("cloud_recognize_time", String.valueOf(i16));
                }
                if (ARReport.this.t(j18)) {
                    hashMap.put("cloud_all_size", String.valueOf(j18));
                }
                if (ARReport.this.t(j19)) {
                    hashMap.put("cloud_time", String.valueOf(j19));
                }
                hashMap.put("cloud_net_type", String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext())));
                if (ARReport.this.t(j26)) {
                    hashMap.put("cloud_all_time", String.valueOf(j26));
                }
                hashMap.put("cloud_all_result", String.valueOf(i17));
                hashMap.put("cloud_type", "0");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidactARCloud", true, 0L, 0L, hashMap, "", true);
            }
        }, 5, null, false);
    }
}
