package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.ReportManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import pw2.n;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public enum ReportManager {
    INSTANCE;

    public static final int MAX_FAILED_COUNT = 5;
    private static final String PARAM_RT = "&rt=";
    private static final int RECOVERY_INTERVAL = 120;
    public static final int REPORT_TYPE_CLICK = 1;
    public static final int REPORT_TYPE_COMMON_DP3 = 7;
    public static final int REPORT_TYPE_DEFAULT = 0;
    public static final int REPORT_TYPE_EFFECTIVE = 3;
    public static final int REPORT_TYPE_EMPTY = 4;
    public static final int REPORT_TYPE_EXPOSURE = 2;
    public static final int REPORT_TYPE_FLOAT_FORM = 13;
    public static final int REPORT_TYPE_PLAY = 8;
    public static final int REPORT_TYPE_PLAY_STAGE = 14;
    public static final int REPORT_TYPE_PRE_AD_FUNNEL = 6;
    public static final int REPORT_TYPE_SKIP_VIDEO_EXPOSURE = 9;
    public static final int REPORT_TYPE_SPLASH_DP3 = 5;
    public static final int REPORT_TYPE_THIRD_PARTY_API = 11;
    public static final int REPORT_TYPE_THIRD_PARTY_SDK = 12;
    public static final int REPORT_TYPE_WISDOM = 10;
    private static final String TAG = "ReportManager";
    private static ScheduledExecutorService sRecoveryThreadPool;
    private static final ow2.d STORAGE = ow2.b.a("QAD_CORE_REPORT_EVENT_SP");
    private static final ArrayList<String> mReportingEvents = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.ReportManager$1, reason: invalid class name */
    /* loaded from: classes19.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f304030d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f304031e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f304032f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Map f304033h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ g f304034i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f304035m;

        AnonymousClass1(f fVar, String str, String str2, Map map, g gVar, int i3) {
            this.f304030d = fVar;
            this.f304031e = str;
            this.f304032f = str2;
            this.f304033h = map;
            this.f304034i = gVar;
            this.f304035m = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(g gVar, int i3, int i16, String str) {
            if (gVar != null) {
                if (i16 != 0) {
                    str = null;
                }
                gVar.a(i3, str, i16);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            n.e(ReportManager.TAG, "doPost, real report event=" + this.f304030d);
            String str = this.f304031e;
            String str2 = this.f304032f;
            Map map = this.f304033h;
            final g gVar = this.f304034i;
            final int i3 = this.f304035m;
            pw2.i.q(str, str2, map, new iw2.a() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.i
                @Override // iw2.a
                public final void a(int i16, String str3) {
                    ReportManager.AnonymousClass1.b(g.this, i3, i16, str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.ReportManager$2, reason: invalid class name */
    /* loaded from: classes19.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f304036d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f304037e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f304038f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ g f304039h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f304040i;

        AnonymousClass2(f fVar, String str, Map map, g gVar, int i3) {
            this.f304036d = fVar;
            this.f304037e = str;
            this.f304038f = map;
            this.f304039h = gVar;
            this.f304040i = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(g gVar, int i3, int i16, String str) {
            if (gVar != null) {
                if (i16 != 0) {
                    str = null;
                }
                gVar.a(i3, str, i16);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            n.e(ReportManager.TAG, "doGet, real report event=" + this.f304036d);
            String str = this.f304037e;
            Map map = this.f304038f;
            final g gVar = this.f304039h;
            final int i3 = this.f304040i;
            pw2.i.p(str, map, new iw2.a() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.j
                @Override // iw2.a
                public final void a(int i16, String str2) {
                    ReportManager.AnonymousClass2.b(g.this, i3, i16, str2);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private class RecoveryWorker implements Runnable {
        RecoveryWorker() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ReportManager.this.doEventReportFromStorage();
        }

        /* synthetic */ RecoveryWorker(ReportManager reportManager, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private boolean alreadyReporting(String str) {
        ArrayList<String> arrayList = mReportingEvents;
        if (arrayList.contains(str)) {
            return true;
        }
        arrayList.add(str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void doEventReportFromStorage() {
        n.e(TAG, "doEventReportFromStorage, start");
        if (!pw2.a.a()) {
            n.e(TAG, "doEventReportFromStorage, no network");
            return;
        }
        n.e(TAG, "doEventReportFromStorage, getAllKeys start");
        String[] allKeys = STORAGE.getAllKeys();
        n.e(TAG, "doEventReportFromStorage, getAllKeys finish, allKeys:" + Arrays.toString(allKeys));
        if (y.j(allKeys)) {
            n.e(TAG, "doEventReportFromStorage, nothing to report.");
            shutdown();
            return;
        }
        for (final String str : allKeys) {
            if (!TextUtils.isEmpty(str)) {
                f fVar = (f) STORAGE.a(str, f.class);
                if (fVar == null) {
                    n.e(TAG, "event == null, key:" + str);
                    removeEventFromStorage(str);
                } else if (alreadyReporting(str)) {
                    n.e(TAG, "already reporting key:" + str);
                } else {
                    n.e(TAG, "doEventReportFromStorage, reportInternal key:" + str);
                    reportInternal(fVar, true, new g() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.h
                        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g
                        public final void a(int i3, String str2, int i16) {
                            ReportManager.lambda$doEventReportFromStorage$0(str, i3, str2, i16);
                        }
                    }, getReporterRequestType(fVar.e()));
                }
            }
        }
    }

    private void doGet(f fVar, boolean z16, g gVar, int i3) {
        if (fVar != null && !TextUtils.isEmpty(fVar.f())) {
            String f16 = fVar.f();
            if (fVar.j() && z16 && fVar.c() > 0) {
                f16 = f16 + PARAM_RT + fVar.c();
            }
            Map<String, String> d16 = fVar.d();
            n.e(TAG, "doGet, report event=" + fVar);
            QAdThreadManager.INSTANCE.execIo(new AnonymousClass2(fVar, f16, d16, gVar, i3));
        }
    }

    private void doPost(f fVar, boolean z16, g gVar, int i3) {
        if (fVar != null && !TextUtils.isEmpty(fVar.f())) {
            String f16 = fVar.f();
            String b16 = fVar.b();
            Map<String, String> d16 = fVar.d();
            n.e(TAG, "doPost, report event=" + fVar);
            QAdThreadManager.INSTANCE.execIo(new AnonymousClass1(fVar, f16, b16, d16, gVar, i3));
        }
    }

    private synchronized ScheduledExecutorService getRecoveryThreadPool() {
        ScheduledExecutorService scheduledExecutorService = sRecoveryThreadPool;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || sRecoveryThreadPool.isTerminated()) {
            sRecoveryThreadPool = ProxyExecutors.newScheduledThreadPool(1, new pw2.h("QAdCoreReporterThreadPool"));
        }
        return sRecoveryThreadPool;
    }

    public static int getReporterRequestType(int i3) {
        if (i3 != 11) {
            if (i3 != 12) {
                return 0;
            }
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doEventReportFromStorage$0(String str, int i3, String str2, int i16) {
        mReportingEvents.remove(str);
    }

    private synchronized void reportInternal(f fVar, boolean z16, g gVar, int i3) {
        if (fVar != null) {
            if (!TextUtils.isEmpty(fVar.f())) {
                if (!pw2.a.a()) {
                    n.e(TAG, "reportInternal, no network.");
                    if (z16) {
                        fVar.i();
                        n.e(TAG, "reportInternal, no network, need retry. report event=" + fVar);
                        addEventToStorage(fVar);
                    }
                    return;
                }
                n.e(TAG, "reportInternal, real report event=" + fVar);
                int g16 = fVar.g();
                if (g16 == 1) {
                    doGet(fVar, z16, gVar, i3);
                } else if (g16 == 2) {
                    doPost(fVar, z16, gVar, i3);
                }
                return;
            }
        }
        n.e(TAG, "reportInternal, report event or report url is null.");
    }

    private void shutdown() {
        ScheduledExecutorService scheduledExecutorService = sRecoveryThreadPool;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            sRecoveryThreadPool.shutdown();
        }
    }

    public synchronized void addEventToStorage(f fVar) {
        n.e(TAG, "addEventToStorage, event:" + fVar);
        if (fVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(fVar.h()) && !TextUtils.isEmpty(fVar.f())) {
            STORAGE.putValue(fVar.h(), fVar);
        }
    }

    public void recoverReport() {
        try {
            getRecoveryThreadPool().scheduleAtFixedRate(new RecoveryWorker(this, null), 1L, 120L, TimeUnit.SECONDS);
        } catch (Throwable th5) {
            n.b(TAG, "schedule error." + th5.getLocalizedMessage());
        }
    }

    public synchronized void removeEventFromStorage(f fVar) {
        n.e(TAG, "removeEventFromStorage, event:" + fVar);
        if (fVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(fVar.h())) {
            STORAGE.remove(fVar.h());
        }
    }

    public void report(d dVar, boolean z16, int i3, g gVar) {
        if (dVar != null) {
            reportInternal(f.a(dVar, i3), z16, gVar, getReporterRequestType(i3));
        }
    }

    public void reportWithSign(d dVar, boolean z16, int i3, g gVar) {
        if (dVar == null) {
            return;
        }
        reportInternal(f.a(dVar, i3), z16, gVar, getReporterRequestType(i3));
    }

    private synchronized void removeEventFromStorage(String str) {
        STORAGE.remove(str);
    }
}
