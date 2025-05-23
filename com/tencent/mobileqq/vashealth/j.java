package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.ISportManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vashealth/j;", "", "", "f", "c", "e", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f312314a = new j();

    j() {
    }

    private final void c() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vashealth.h
            @Override // java.lang.Runnable
            public final void run() {
                j.d();
            }
        }, 16, null, false, 30000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).checkScheduleDownloadTask(1);
    }

    private final void f() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vashealth.i
            @Override // java.lang.Runnable
            public final void run() {
                j.g();
            }
        }, 16, null, false, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).restartDownloadAfterLogin();
    }

    public final void e() {
        Context applicationContext = BaseApplicationImpl.getApplication().getApplicationContext();
        if (!((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isSupportStepCounter(applicationContext)) {
            QLog.i("HealthStepReporter", 1, "step counter unsupported model.");
            return;
        }
        String banInfo = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.health_ban.name(), "");
        QLog.i("HealthStepReporter", 1, "ban_info:" + banInfo);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!TextUtils.isEmpty(banInfo)) {
            Intrinsics.checkNotNullExpressionValue(banInfo, "banInfo");
            if (Integer.parseInt(banInfo) == 0) {
                NewIntent stepCounterServletIntent = ((IQQHealthApi) QRoute.api(IQQHealthApi.class)).getStepCounterServletIntent(applicationContext);
                stepCounterServletIntent.putExtra(com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, false);
                if (peekAppRuntime != null) {
                    peekAppRuntime.startServlet(stepCounterServletIntent);
                }
                QLog.e("HealthStepReporter", 1, "step counter found current model banned!");
            }
        }
        if (peekAppRuntime != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ISportManager.class, ProcessConstant.MULTI);
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IS\u2026a, ProcessConstant.MULTI)");
            ISportManager iSportManager = (ISportManager) runtimeService;
            if (((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isNeedReport(peekAppRuntime.getAccount())) {
                iSportManager.refreshCurrentStep("login");
                iSportManager.refreshStepConfig();
            }
            iSportManager.doOnLogin();
        }
        f();
        c();
    }
}
