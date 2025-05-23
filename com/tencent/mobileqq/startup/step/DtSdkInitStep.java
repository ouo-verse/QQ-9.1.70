package com.tencent.mobileqq.startup.step;

import android.app.Activity;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.dt.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.IBizDataProcessor;
import com.tencent.qqlive.module.videoreport.ILogger;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.DTReportComponent;
import com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity;
import com.tencent.qqlive.module.videoreport.lazy.LazyInitObserver;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;
import com.tencent.thumbplayer.api.dtreport.IDtReport;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DtSdkInitStep extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;
    private static int C;
    private static long D;
    public static final /* synthetic */ int E = 0;

    /* renamed from: d, reason: collision with root package name */
    private static volatile AtomicBoolean f289728d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile AtomicBoolean f289729e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile AtomicBoolean f289730f;

    /* renamed from: h, reason: collision with root package name */
    private static volatile AtomicBoolean f289731h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile AtomicBoolean f289732i;

    /* renamed from: m, reason: collision with root package name */
    private static AtomicBoolean f289733m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements ILogger {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.ILogger
        public void d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.d(str, 2, str2);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.ILogger
        public void e(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            } else {
                QLog.e(str, 1, str2);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.ILogger
        public void i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            } else {
                QLog.i(str, 1, str2);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.ILogger
        public void v(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.d(str, 2, str2);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.ILogger
        public void w(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            } else {
                QLog.w(str, 1, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements IBizDataProcessor {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.IBizDataProcessor
        public Map<String, Object> process(String str, Map<String, Object> map, Map<String, Object> map2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Map) iPatchRedirector.redirect((short) 2, this, str, map, map2);
            }
            HashMap hashMap = new HashMap(map);
            if (map.containsKey("qq_pgid")) {
                hashMap.put("dt_pgid", map.get("qq_pgid"));
            }
            if (map.containsKey("qq_eid")) {
                hashMap.put("dt_eid", map.get("qq_eid"));
            }
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements com.tencent.qqlive.module.videoreport.dtreport.video.logic.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.logic.a
        public void a(Object obj, VideoBaseEntity videoBaseEntity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, obj, (Object) videoBaseEntity);
            } else if (obj instanceof IDtReport) {
                ((IDtReport) obj).bindVideoPlayerInfo(videoBaseEntity);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.logic.a
        public void b(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.logic.a
        public void c(Object obj, VideoBaseEntity videoBaseEntity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj, (Object) videoBaseEntity);
            } else if (obj instanceof IDtReport) {
                ((IDtReport) obj).bindVideoPlayerInfo(videoBaseEntity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements IDetectionInterceptor {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor
        public boolean ignoreAppEvent(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity)).booleanValue();
            }
            QLog.d("DtSdkInitStep", 1, "848QQDT [ignoreAppEvent] activity: " + activity.toString());
            return activity instanceof QQLSActivity;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75371);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f289728d = null;
        f289729e = null;
        f289730f = new AtomicBoolean(false);
        f289731h = new AtomicBoolean(false);
        f289732i = new AtomicBoolean(false);
        f289733m = new AtomicBoolean(false);
        C = 0;
        D = 0L;
    }

    public DtSdkInitStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean g() {
        return f289731h.get();
    }

    private static boolean h(int i3) {
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    public static boolean i() {
        if (f289728d != null) {
            return f289728d.get();
        }
        f289728d = new AtomicBoolean(BaseApplication.getContext().getSharedPreferences("dt_sdk_start", 4).getBoolean("is_init_dt_sdk_at_start_b", true));
        return f289728d.get();
    }

    public static void initDTSDK(int i3) {
        if (h(i3)) {
            if (i()) {
                k(i3);
                return;
            }
            return;
        }
        k(i3);
    }

    private static boolean j() {
        if (f289729e != null) {
            return f289729e.get();
        }
        f289729e = new AtomicBoolean(BaseApplication.getContext().getSharedPreferences("dt_sdk_start", 4).getBoolean("key_need_turn_on_dt_video", false));
        return f289729e.get();
    }

    private static void k(int i3) {
        if (MobileQQ.sProcessId == 1) {
            com.tencent.mobileqq.dt.b.j(1);
        }
        C = i3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            VideoReport.startWithComponent(application, DTReportComponent.builder(com.tencent.mobileqq.data.dt.a.e()).addReporter(com.tencent.mobileqq.dt.c.d()).enableRemoteConfig(true).enableRemoteSample(true, "10004").elementFormatMode(1).lazyInitType(0).setVideoPageSwitch(3).independentPageOut(true).bizDataProcessor(new b()).setLogger(new a()).build());
            VideoReport.setOnDTPlayInfoChangeListener(new c());
            VideoReport.setDetectionMode(2);
            VideoReport.setDetectionInterceptor(new d());
            if (!PrivacyPolicyHelper.isUserAllow()) {
                VideoReport.setCollectProcessName(false);
            }
            m(j());
            if (!i() || MobileQQ.sProcessId != 1) {
                LazyInitObserver.getInstance().markToProceed();
                QLog.d("DtSdkInitStep", 1, "markToProceed");
            }
            VideoReport.supportPlayerReport(true);
            VideoReport.enableSampleTest(false);
            g.c().h();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.startup.step.DtSdkInitStep.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        VideoReport.bindRemoteConfig(new com.tencent.mobileqq.dt.a());
                    }
                }
            }, 16, null, true);
            D = SystemClock.elapsedRealtime() - elapsedRealtime;
            f289731h.set(true);
            QLog.d("DtSdkInitStep", 1, "848QQDT initDTCost : " + D + " ms\uff0c from = " + i3 + ", currentProcess: " + MobileQQ.processName);
            return;
        }
        QLog.i("DtSdkInitStep", 1, "848QQDT application is null, init DT sdk fail !");
    }

    public static void l() {
        String str;
        if (com.tencent.mobileqq.startup.a.f289665f > 0 && f289733m.compareAndSet(false, true) && MobileQQ.sProcessId == 1) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("initDTFrom", String.valueOf(C));
            hashMap.put("initDTCostTime", String.valueOf(D));
            hashMap.put("showCostTime", String.valueOf(com.tencent.mobileqq.startup.a.f289665f));
            if (C == 1) {
                str = "evt_init_dt_at_boot_b";
            } else {
                str = "evt_init_dt_at_boot_a";
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", str, true, 0L, 0L, hashMap, "", true);
        }
    }

    public static void m(boolean z16) {
        VideoReport.setVideoReportConfig(new DTConfig.Builder().supportVideoReport(z16).build());
        QLog.d("DtSdkInitStep", 1, "[setDtVideoSwitch] switch: ", Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        initDTSDK(0);
        return super.doStep();
    }
}
