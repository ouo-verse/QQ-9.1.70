package com.tencent.qqperf.monitor.crash;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QQCrashControlManager {

    /* renamed from: f, reason: collision with root package name */
    private static QQCrashControlManager f363133f;

    /* renamed from: g, reason: collision with root package name */
    static SimpleDateFormat f363134g = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");

    /* renamed from: a, reason: collision with root package name */
    boolean f363135a = false;

    /* renamed from: b, reason: collision with root package name */
    boolean f363136b = true;

    /* renamed from: c, reason: collision with root package name */
    int f363137c = 1;

    /* renamed from: d, reason: collision with root package name */
    int f363138d = 86400;

    /* renamed from: e, reason: collision with root package name */
    int f363139e = 5;

    /* compiled from: P */
    /* renamed from: com.tencent.qqperf.monitor.crash.QQCrashControlManager$2, reason: invalid class name */
    /* loaded from: classes25.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SharedPreferences f363141d;

        @Override // java.lang.Runnable
        public void run() {
            QLog.e("QQCrashControlManager", 1, "restart for background and crash many times, kill self !!!!");
            this.f363141d.edit().putBoolean("allowAutoRestart", true);
            this.f363141d.edit().putInt("crashcount", 0);
            this.f363141d.edit().commit();
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "suicideCount", true, System.currentTimeMillis(), 0L, null, null);
            QLog.flushLog();
            System.exit(0);
        }
    }

    QQCrashControlManager() {
    }

    public static QQCrashControlManager b() {
        if (f363133f == null) {
            synchronized (QQCrashReportManager.class) {
                if (f363133f == null) {
                    f363133f = new QQCrashControlManager();
                }
            }
        }
        return f363133f;
    }

    private boolean d() {
        boolean z16;
        if (Build.VERSION.SDK_INT == 27) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && DeviceInfoMonitor.getModel().contains("OPPO R11")) {
            return true;
        }
        return false;
    }

    public void a(final String str) {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.qqperf.monitor.crash.QQCrashControlManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences a16 = e.a(MobileQQ.sMobileQQ, "crashcontrol", 0);
                    if (a16 != null) {
                        if (a16.getBoolean("shouldStopMsf", false)) {
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "actKillMsf", true, 0L, 0L, null, "");
                            a16.edit().putBoolean("shouldStopMsf", false).commit();
                        }
                        int i3 = a16.getInt("countTryKillMsf", 0);
                        if (i3 > 0) {
                            for (int i16 = 0; i16 < i3; i16++) {
                                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "countTryKillMsf", true, 0L, 0L, null, "");
                            }
                            a16.edit().putInt("countTryKillMsf", 0).commit();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.crash_control.name(), null);
        if (!TextUtils.isEmpty(featureValueWithoutAccountManager)) {
            try {
                JSONObject jSONObject = new JSONObject(featureValueWithoutAccountManager);
                this.f363136b = jSONObject.getBoolean("control_switch");
                this.f363137c = jSONObject.getInt("control_level");
                this.f363138d = jSONObject.getInt("control_window");
                this.f363139e = jSONObject.getInt("control_freq");
            } catch (Throwable unused) {
                e();
                QLog.d("QQCrashControlManager", 1, "initCrashControl parse json throws an exception, so reset.");
            }
        }
        QQCrashReportManager.a();
        StringBuilder sb5 = QQCrashReportManager.f363169m;
        sb5.append("initCrashControl");
        sb5.append(",controlJson=");
        sb5.append(featureValueWithoutAccountManager);
        sb5.append(",switch=");
        sb5.append(this.f363136b);
        sb5.append(",level=");
        sb5.append(this.f363137c);
        sb5.append(",window=");
        sb5.append(this.f363138d);
        sb5.append(",Freq=");
        sb5.append(this.f363139e);
        QQCrashReportManager.a();
        QQCrashReportManager.f363169m.append("\n");
    }

    public void e() {
        this.f363136b = true;
        this.f363137c = 1;
        this.f363138d = 86400;
        this.f363139e = 5;
    }

    public boolean f() {
        return this.f363135a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        long j3;
        int i3;
        if (!this.f363136b) {
            QLog.d("QQCrashControlManager", 1, "updateLocalCrashData crash control is off..");
            return;
        }
        String str = MobileQQ.sMobileQQ.startComponentInfo;
        if (this.f363137c == 2 && (TextUtils.isEmpty(str) || !str.contains("QQBroadcastReceiver"))) {
            QLog.d("QQCrashControlManager", 1, "updateLocalCrashData controllevel is 2 but not QQBroadcastReceiver start QQ.");
            return;
        }
        SharedPreferences a16 = e.a(MobileQQ.sMobileQQ, "crashcontrol", 0);
        if (a16 != null) {
            long j16 = a16.getLong(AEEditorConstants.VIDEO_CLIP_START_TIME, 0L);
            int i16 = a16.getInt("crashcount", 0);
            int i17 = a16.getInt("natmem_crashcount", 0);
            long currentTimeMillis = System.currentTimeMillis();
            QQCrashReportManager.a();
            StringBuilder sb5 = QQCrashReportManager.f363169m;
            sb5.append("updateLocalCrashData startTime=");
            sb5.append(f363134g.format(new Date(j16)));
            sb5.append(",currenttime=");
            sb5.append(f363134g.format(new Date(currentTimeMillis)));
            sb5.append(",crashCount=");
            sb5.append(i16);
            sb5.append(",mCurUin=");
            sb5.append(QQCrashReportManager.f363157a);
            sb5.append("\n");
            if (j16 > 0 && currentTimeMillis > j16 && i16 >= 0 && currentTimeMillis - j16 <= this.f363138d * 1000) {
                int i18 = i16 + 1;
                String str2 = QQCrashReportManager.f363166j;
                if (str2 != null && str2.contains("natmem")) {
                    i17++;
                }
                i3 = i18;
                j3 = j16;
            } else {
                String str3 = QQCrashReportManager.f363166j;
                if (str3 != null && str3.contains("natmem")) {
                    j3 = currentTimeMillis;
                    i17 = 1;
                } else {
                    j3 = currentTimeMillis;
                }
                i3 = 1;
            }
            if (i3 > this.f363139e) {
                this.f363135a = true;
                if (d()) {
                    a16.edit().putBoolean("crashFrequentLast", true).commit();
                }
            }
            QQCrashReportManager.a();
            StringBuilder sb6 = QQCrashReportManager.f363169m;
            sb6.append("updateLocalCrashData shouldStopMsf=");
            sb6.append(this.f363135a);
            sb6.append("\n");
            a16.edit().putLong(AEEditorConstants.VIDEO_CLIP_START_TIME, j3).putInt("crashcount", i3).putInt("natmem_crashcount", i17).putBoolean("shouldStopMsf", this.f363135a).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str) {
        boolean z16;
        int i3;
        long j3;
        if (!this.f363136b) {
            QLog.d("QQCrashControlManager", 1, "updatePreloadCrashData crash control is off..");
            return;
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("CrashControl_" + str, 4);
        if (sharedPreferences != null) {
            long j16 = sharedPreferences.getLong(AEEditorConstants.VIDEO_CLIP_START_TIME, 0L);
            int i16 = sharedPreferences.getInt("crashcount", 0);
            boolean z17 = sharedPreferences.getBoolean("allowpreload", true);
            long currentTimeMillis = System.currentTimeMillis();
            QQCrashReportManager.a();
            StringBuilder sb5 = QQCrashReportManager.f363169m;
            sb5.append("updatePreloadCrashData process=");
            sb5.append(str);
            sb5.append(",startTime=");
            sb5.append(f363134g.format(new Date(j16)));
            sb5.append(",currenttime=");
            sb5.append(f363134g.format(new Date(currentTimeMillis)));
            sb5.append(",crashCount=");
            sb5.append(i16);
            sb5.append(",allowPreload=");
            sb5.append(z17);
            sb5.append(",mCurUin=");
            sb5.append(QQCrashReportManager.f363157a);
            sb5.append("\n");
            if (j16 > 0 && currentTimeMillis > j16 && i16 >= 0 && currentTimeMillis - j16 <= this.f363138d * 1000) {
                z16 = true;
                i3 = i16 + 1;
                j3 = j16;
            } else {
                z16 = true;
                i3 = 1;
                j3 = currentTimeMillis;
            }
            if (i3 > this.f363139e) {
                z16 = false;
            }
            QQCrashReportManager.a();
            StringBuilder sb6 = QQCrashReportManager.f363169m;
            sb6.append("updatePreloadCrashData update allowPreload=");
            sb6.append(z16);
            sb6.append("\n");
            sharedPreferences.edit().putLong(AEEditorConstants.VIDEO_CLIP_START_TIME, j3).putInt("crashcount", i3).putBoolean("allowpreload", z16).putInt("controlwindow", this.f363138d).commit();
        }
    }
}
