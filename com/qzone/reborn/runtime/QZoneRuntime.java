package com.qzone.reborn.runtime;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.common.account.c;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.misc.network.report.QzoneFeedProVisitorReportService;
import com.qzone.misc.network.report.QzoneFeedVisitorReportService;
import com.qzone.module.feedcomponent.ui.ViewLoader;
import com.qzone.publish.business.publishqueue.QZoneReportTaskQueue;
import com.qzone.reborn.albumx.qzone.local.QZoneForegroundForSubProcess;
import com.qzone.reborn.base.QZoneBaseActivity;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.event.QZoneFeedxRefreshEvent;
import com.qzone.reborn.feedx.viewmodel.e;
import com.qzone.reborn.util.k;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.cache.api.Business;
import com.tencent.cache.core.manager.api.ClearMode;
import com.tencent.component.media.image.ImageManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager;
import com.tencent.mobileqq.perf.memory.cache.AppStateMonitor;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.util.ProcessUtils;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mh.d;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.QActivityLifecycleCallbacks;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneRuntime implements QActivityLifecycleCallbacks {
    public static AtomicInteger C = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name */
    private boolean f59402d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f59403e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f59404f = false;

    /* renamed from: h, reason: collision with root package name */
    private String f59405h = "";

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f59406i = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private Runnable f59407m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static QZoneRuntime f59410a = new QZoneRuntime();
    }

    private void e() {
        if (this.f59407m != null) {
            RFWLog.d("QZoneRuntime", RFWLog.USR, "cancelClearFeedCache");
            RFWThreadManager.getInstance().remove(this.f59407m);
            this.f59407m = null;
        }
    }

    private void g() {
        if (this.f59407m == null) {
            this.f59407m = new Runnable() { // from class: com.qzone.reborn.runtime.a
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneRuntime.this.n();
                }
            };
        }
        int n3 = g.f53821a.l().n();
        RFWLog.d("QZoneRuntime", RFWLog.USR, "clearFeedCacheDelay: " + n3);
        RFWThreadManager.getInstance().execOnSubThread(this.f59407m, ((long) n3) * 1000);
    }

    private void i() {
        if (this.f59404f) {
            return;
        }
        this.f59404f = true;
        final String[] strArr = {"exp_qzone_feed_permission_entry", "exp_qzone_publishlink_shuoshuojumptopicker", "exp_qzone_publishlink_leadtoshare", "exp_qzone_share_sheet", "exp_album_reconstruction_9125_andr", "exp_eliminate_share_experiment_two", "exp_qzone_pluslongpress", "exp_qzone_new_frame"};
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.runtime.QZoneRuntime.2
            @Override // java.lang.Runnable
            public void run() {
                int i3 = 0;
                while (true) {
                    String[] strArr2 = strArr;
                    if (i3 >= strArr2.length) {
                        return;
                    }
                    String str = strArr2[i3];
                    if (!TextUtils.isEmpty(str)) {
                        com.qzone.reborn.a.f52169a.h(str);
                    }
                    i3++;
                }
            }
        });
    }

    public static QZoneRuntime j() {
        return b.f59410a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        RFWLog.d("QZoneRuntime", RFWLog.USR, "clearActiveFeedServiceMemoryCache when timeout");
        if (C.get() != 0 || m() || this.f59403e) {
            return;
        }
        RFWLog.d("QZoneRuntime", RFWLog.USR, "do clearActiveFeedServiceMemoryCache when timeout");
        f();
    }

    private void q() {
        g gVar = g.f53821a;
        if (gVar.k().k()) {
            RFWLog.d("QZoneRuntime", RFWLog.USR, "onLeaveQZoneEnv, releaseQzoneMemoryResource");
            ImageManager.getInstance().clear(false);
            ImageManager.getInstance().trimCacheToSize(0.0f);
            ViewLoader.getInstance().clear();
            ze.a.a().clearAll();
            d.d().f();
            mh.b.d().f();
            if (gVar.b().z()) {
                g();
            }
        }
    }

    public void f() {
        if (this.f59403e) {
            RFWLog.d("QZoneRuntime", RFWLog.USR, "in qzone tab, dont clear");
            return;
        }
        if (QZoneFeedService.X() > g.f53821a.b().y0()) {
            RFWLog.d("QZoneRuntime", RFWLog.USR, "do clearFeedCache, feedCount: " + QZoneFeedService.X());
            QZoneFeedService.N();
            if (k.f59549a.c()) {
                QZoneFeedxRefreshEvent qZoneFeedxRefreshEvent = new QZoneFeedxRefreshEvent();
                qZoneFeedxRefreshEvent.setContext(ProcessUtils.getTopActivity());
                qZoneFeedxRefreshEvent.setScrollToTop(true);
                SimpleEventBus.getInstance().dispatchEvent(qZoneFeedxRefreshEvent);
                return;
            }
            return;
        }
        RFWLog.d("QZoneRuntime", RFWLog.USR, "feed count not enough, dont clear");
    }

    public void h() {
        this.f59405h = "";
    }

    public String k() {
        return this.f59405h;
    }

    public void l() {
        if (this.f59406i.get()) {
            RFWLog.d("QZoneRuntime", RFWLog.USR, "init error, has inited");
            return;
        }
        RFWLog.d("QZoneRuntime", RFWLog.USR, "start init");
        g gVar = g.f53821a;
        if (gVar.k().j() && MobileQQ.PACKAGE_NAME.equals(BaseApplication.processName)) {
            Foreground.addActivityLifeCallback(this);
        }
        if (MobileQQ.PACKAGE_NAME.equals(BaseApplication.processName)) {
            QZoneForegroundForSubProcess.f52639a.o(MobileQQ.sMobileQQ);
        }
        com.tencent.mobileqq.perf.memory.cache.b.f257663a.c(new a());
        this.f59406i.compareAndSet(false, true);
        dh.a.f393805d.g();
        if (!gVar.c().j()) {
            ((IQQKuiklyService) QRoute.api(IQQKuiklyService.class)).startKMPCore();
        }
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            QLog.d("QZoneRuntime", 1, "init, main process, feedPro kmp");
            le.b.f414397d.i();
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            QzoneFakeFeedLogicManager qzoneFakeFeedLogicManager = QzoneFakeFeedLogicManager.INSTANCE;
            Objects.requireNonNull(qzoneFakeFeedLogicManager);
            rFWThreadManager.execOnFileThread(new c(qzoneFakeFeedLogicManager), 500L);
        }
    }

    public boolean m() {
        return this.f59402d;
    }

    public void o(boolean z16, boolean z17) {
        if (this.f59402d) {
            RFWLog.d("QZoneRuntime", RFWLog.USR, "onEnterQZoneEnv error, in qzone now, activityCount: " + C);
            return;
        }
        this.f59402d = true;
        if (!z16) {
            this.f59403e = z17;
        }
        RFWLog.d("QZoneRuntime", RFWLog.USR, "onEnterQZoneEnv, activityCount: " + C + ", mIsInQZoneTab: " + this.f59403e);
        QzoneOnlineTimeCollectRptService.getInstance().beginTrace(0);
        QZoneReportTaskQueue.h().p();
        if (!z16) {
            s();
            AppStateMonitor.f257658a.h(Business.QZone, true);
        }
        QZoneForegroundForSubProcess.f52639a.l(true);
        e();
        i();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if ((activity instanceof QZoneBaseActivity) || (activity instanceof BaseActivity)) {
            RFWLog.d("QZoneRuntime", RFWLog.USR, "onActivityCreated, activityName: " + activity);
            C.incrementAndGet();
            if (C.get() != 1 || this.f59403e) {
                return;
            }
            o(false, false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if ((activity instanceof QZoneBaseActivity) || (activity instanceof BaseActivity)) {
            RFWLog.d("QZoneRuntime", RFWLog.USR, "onActivityDestroyed, activityName: " + activity);
            C.decrementAndGet();
            if (C.get() != 0 || this.f59403e) {
                return;
            }
            p(false, false);
        }
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessBackground() {
        if (C.get() > 0) {
            p(true, false);
        }
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessForeground() {
        if (C.get() > 0) {
            o(true, false);
        }
    }

    public void p(boolean z16, boolean z17) {
        if (!this.f59402d) {
            RFWLog.d("QZoneRuntime", RFWLog.USR, "onLeaveQZoneEnv error, not in qzone now, activityCount: " + C);
            return;
        }
        this.f59402d = false;
        if (!z16) {
            this.f59403e = false;
        }
        RFWLog.d("QZoneRuntime", RFWLog.USR, "onLeaveQZoneEnv, activityCount: " + C + ", mIsInQZoneTab: " + this.f59403e);
        QzoneOnlineTimeCollectRptService.getInstance().closeTrace();
        QZoneReportTaskQueue.h().o();
        if (!z16) {
            h();
            AppStateMonitor.f257658a.h(Business.QZone, false);
        }
        QZoneForegroundForSubProcess.f52639a.l(false);
        if (C.get() == 0) {
            q();
        }
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            QzoneFeedProVisitorReportService.h().m();
        } else {
            QzoneFeedVisitorReportService.f().l();
        }
    }

    public void s() {
        this.f59405h = String.valueOf(System.currentTimeMillis());
        RFWLog.d("QZoneRuntime", RFWLog.USR, "updateQZoneSession: " + this.f59405h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(int i3) {
        return i3 > 15 && C.get() == 0 && g.f53821a.b().A() && !m() && !k.f59549a.c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements com.tencent.mobileqq.perf.memory.cache.a {
        a() {
        }

        @Override // com.tencent.mobileqq.perf.memory.cache.a
        public void onTrimMemory(int i3) {
            if (QZoneRuntime.this.r(i3)) {
                RFWLog.d("QZoneRuntime", RFWLog.USR, "clearActiveFeedServiceMemoryCache when trim memory, activityCount: " + QZoneRuntime.C.get() + ", inQzoneEnv: " + QZoneRuntime.this.m() + ", mIsInQzoneTab: " + QZoneRuntime.this.f59403e);
                QZoneRuntime.this.f();
                e.f55883a.a();
            }
        }

        @Override // com.tencent.mobileqq.perf.memory.cache.a
        public void onClear(ClearMode clearMode, float f16) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
