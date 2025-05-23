package com.tencent.mobileqq.vashealth.step;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.api.ISportManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bR\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vashealth/step/k;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, "", "j", "i", "", "g", "time", "", "r", "Landroid/content/Context;", "f", DomainData.DOMAIN_NAME, "k", "b", "J", "lastReportTime", "c", "Z", "needRefresh", "d", "I", "refreshTime", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f312340a = new k();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long lastReportTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean needRefresh;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int refreshTime;

    k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = waitAppRuntime.getRuntimeService(ISportManager.class, ProcessConstant.MULTI);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IS\u2026stant.MULTI\n            )");
        ((ISportManager) runtimeService).refreshCurrentStep(com.tencent.mobileqq.msf.core.net.r.a.f248963o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            com.tencent.kuikly.core.render.android.expand.module.l.e(qBaseActivity, "QQSPORT_HOME_PAGE_REFRESH_PAGE_DATA", new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = waitAppRuntime.getRuntimeService(ISportManager.class, ProcessConstant.MULTI);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IS\u2026stant.MULTI\n            )");
        ((ISportManager) runtimeService).refreshCurrentStep(com.tencent.mobileqq.msf.core.net.r.a.f248963o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            com.tencent.kuikly.core.render.android.expand.module.l.e(qBaseActivity, "QQSPORT_HOME_PAGE_REFRESH_PAGE_DATA", new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(long j3) {
        MMKVOptionEntity from = QMMKV.from(f312340a.f(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeLong(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_key_step_last_report_time_ms", j3);
    }

    @Nullable
    public final Context f() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    public final long g() {
        MMKVOptionEntity from = QMMKV.from(f(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeLong(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_key_step_last_report_time_ms", 0L);
    }

    public final int h() {
        int b16 = e.f312337a.b(String.valueOf(l.f312344a.a(0)));
        int[] e16 = SSOHttpUtils.e();
        int i3 = e16[1];
        if (i3 > 0) {
            QLog.e("SportReportHelper", 1, "use device step:" + i3 + " instead of:" + b16);
            return e16[1];
        }
        return b16;
    }

    public final boolean i() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100951", false);
    }

    public final boolean j() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100799", false);
    }

    public final void k() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vashealth.step.g
            @Override // java.lang.Runnable
            public final void run() {
                k.l();
            }
        }, 16, null, false, 1000L);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vashealth.step.h
            @Override // java.lang.Runnable
            public final void run() {
                k.m();
            }
        }, 16, null, false, 1500L);
    }

    public final void n() {
        needRefresh = true;
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vashealth.step.i
            @Override // java.lang.Runnable
            public final void run() {
                k.o();
            }
        }, 16, null, false, 2600L);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vashealth.step.j
            @Override // java.lang.Runnable
            public final void run() {
                k.p();
            }
        }, 16, null, false, 3200L);
    }

    public final int q() {
        lastReportTime = g();
        if (System.currentTimeMillis() - lastReportTime < 10000 && !needRefresh) {
            QLog.e("SportReportHelper", 1, "time over, cancel report");
            return 102;
        }
        if (refreshTime > 1) {
            needRefresh = false;
            refreshTime = 0;
        }
        if (needRefresh) {
            refreshTime++;
        }
        lastReportTime = System.currentTimeMillis();
        e eVar = e.f312337a;
        l lVar = l.f312344a;
        QLog.e("SportReportHelper", 1, "step is " + eVar.b(String.valueOf(lVar.a(0))));
        Bundle bundle = new Bundle();
        HashMap<Long, Integer> c16 = d.f312333a.c();
        c16.put(Long.valueOf(lVar.a(0)), Integer.valueOf(h()));
        bundle.putSerializable(StepCounterConstants.ATTR_STEP_COUNT_HISTORY, c16);
        SSOHttpUtils.u(MobileQQ.sMobileQQ.peekAppRuntime(), bundle);
        return 0;
    }

    public final void r(final long time) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.step.f
            @Override // java.lang.Runnable
            public final void run() {
                k.s(time);
            }
        }, 16, null, false);
    }
}
