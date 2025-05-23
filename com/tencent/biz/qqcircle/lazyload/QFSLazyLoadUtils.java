package com.tencent.biz.qqcircle.lazyload;

import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.faultreport.FaultTracker;
import com.tencent.mobileqq.qcircle.api.impl.QCircleInit571ABTestApiImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.wink.api.IQQWinkABTestReportAPI;
import com.tencent.mobileqq.wink.api.IQQWinkEditorDraftCleanAPI;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import uq3.c;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLazyLoadUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final long f91417a = c.b3();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c() {
        String loginAccountUin = ABTestController.getInstance().getLoginAccountUin();
        ABTestController.getInstance().doInit571(loginAccountUin, true);
        QCircleInit571ABTestApiImpl.tab571ReportWhenEnterQCircle(loginAccountUin);
        ((IQQWinkABTestReportAPI) QRoute.api(IQQWinkABTestReportAPI.class)).reportEnterQCircleExperiment();
    }

    public static void d(Context context) {
        if (!o.W1()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.lazyload.a
                @Override // java.lang.Runnable
                public final void run() {
                    QFSLazyLoadUtils.c();
                }
            });
        }
        g();
        e(context);
    }

    private static void e(final Context context) {
        long j3;
        long j16;
        if (h20.c.a()) {
            j3 = f91417a;
            j16 = 4;
        } else {
            j3 = f91417a;
            j16 = 2;
        }
        long j17 = j3 * j16;
        QLog.d("QFSLazyLoadUtils", 1, "[notifyLazyInit] delayTime:" + j17);
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.lazyload.QFSLazyLoadUtils.3
            @Override // java.lang.Runnable
            public void run() {
                SimpleEventBus.getInstance().dispatchEvent(new QFSNotifyLazyLoadEvent(2));
                SimpleEventBus.getInstance().dispatchEvent(new QFSLazyExecuteEvent(2, QFSLazyLoadUtils.f91417a, false));
                SimpleEventBus.getInstance().dispatchEvent(new QFSLazyExecuteEvent(3, QFSLazyLoadUtils.f91417a, true));
                wa0.c.f().b();
                Context context2 = context;
                if (context2 != null) {
                    QCirclePluginInitHelper.PreloadWink(context2);
                }
                QCircleApplication.makeSureApplicationLazyLoad();
                ((IQQWinkEditorDraftCleanAPI) QRoute.api(IQQWinkEditorDraftCleanAPI.class)).tryBatchDeleteQCircleDraft();
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_open_fault_tracker", false)) {
                    FaultTracker.n().u(new com.tencent.mobileqq.faultreport.TrackerFilter.c());
                }
            }
        }, j17, true);
    }

    public static void f() {
        int c36;
        if (h20.c.a()) {
            c36 = c.c3() * 3;
        } else {
            c36 = c.c3();
        }
        QLog.d("QFSLazyLoadUtils", 1, "notifyLazyLoadLayerRightProfile, delay time:" + c36);
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.lazyload.QFSLazyLoadUtils.2
            @Override // java.lang.Runnable
            public void run() {
                SimpleEventBus.getInstance().dispatchEvent(new QFSLazyExecuteEvent(4, 0L, true));
                QCircleApplication.makeSureApplicationLazyLoad();
            }
        }, (long) c36, true);
    }

    private static void g() {
        long j3;
        if (h20.c.a()) {
            j3 = f91417a * 3;
        } else {
            j3 = f91417a;
        }
        QLog.d("QFSLazyLoadUtils", 1, "[notifyLazyLoadTab] delayTime:" + j3);
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.lazyload.QFSLazyLoadUtils.1
            @Override // java.lang.Runnable
            public void run() {
                if (!i30.a.b().a()) {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSNotifyLazyLoadEvent(1));
                    SimpleEventBus.getInstance().dispatchEvent(new QFSNotifyLazyLoadEvent(3));
                }
                SimpleEventBus.getInstance().dispatchEvent(new QFSLazyExecuteEvent(1, 0L, true));
                SimpleEventBus.getInstance().dispatchEvent(new QFSNotifyLazyLoadEvent(7));
                SimpleEventBus.getInstance().dispatchEvent(new QFSNotifyLazyLoadEvent(8));
                SimpleEventBus.getInstance().dispatchEvent(new QFSLazyExecuteEvent(6, 10000L, true));
            }
        }, j3, true);
    }
}
