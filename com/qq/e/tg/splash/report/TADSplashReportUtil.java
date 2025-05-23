package com.qq.e.tg.splash.report;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.TangramReportUtil;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TADSplashReportUtil {

    /* renamed from: a, reason: collision with root package name */
    private static CopyOnWriteArrayList<ReportCache> f40848a = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class ReportCache {

        /* renamed from: a, reason: collision with root package name */
        int f40853a;

        /* renamed from: b, reason: collision with root package name */
        private int f40854b;

        /* renamed from: c, reason: collision with root package name */
        private Map f40855c;

        /* renamed from: d, reason: collision with root package name */
        private Map f40856d;

        public ReportCache(int i3, int i16, Map map, Map map2) {
            this.f40853a = i3;
            this.f40854b = i16;
            this.f40855c = map;
            this.f40856d = map2;
        }

        public void report() {
            if (GDTADManager.getInstance() == null) {
                GDTLogger.e("ReportCache SDK not init.");
            } else if (GDTADManager.getInstance().getAppStatus() == null) {
                GDTLogger.e("ReportCache SDK getAppStatus() == null");
            } else {
                TangramReportUtil.report(GDTADManager.getInstance().getAppContext(), GDTADManager.getInstance().getAppStatus().getAPPID(), this.f40853a, this.f40854b, this.f40855c, this.f40856d);
            }
        }
    }

    public static void report(final int i3, final int i16, final Map map, final Map map2) {
        GdtSDKThreadManager.getInstance().runOnThread(2, new Runnable() { // from class: com.qq.e.tg.splash.report.TADSplashReportUtil.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (!GDTADManager.getInstance().isInitialized()) {
                        GDTLogger.e("TADSplashReportUtil  SDK not init.");
                        TADSplashReportUtil.f40848a.add(new ReportCache(i3, i16, map, map2));
                        return;
                    }
                    if (GDTADManager.getInstance().getAppStatus() == null) {
                        GDTLogger.e("TADSplashReportUtil  SDK AppStatus not init.");
                        TADSplashReportUtil.f40848a.add(new ReportCache(i3, i16, map, map2));
                        return;
                    }
                    TangramReportUtil.report(GDTADManager.getInstance().getAppContext(), GDTADManager.getInstance().getAppStatus().getAPPID(), i3, i16, map, map2);
                    if (!TADSplashReportUtil.f40848a.isEmpty()) {
                        ArrayList<ReportCache> arrayList = new ArrayList(TADSplashReportUtil.f40848a);
                        for (ReportCache reportCache : arrayList) {
                            if (reportCache != null) {
                                GDTLogger.i("TADSplashReportUtil reportCache.report :" + reportCache.f40853a);
                                reportCache.report();
                            }
                        }
                        TADSplashReportUtil.f40848a.removeAll(arrayList);
                    }
                } catch (Throwable th5) {
                    GDTLogger.e("TADSplashReportUtil  report catch error:", th5);
                }
            }
        });
    }
}
