package com.tencent.mobileqq.vashealth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.ISportManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes20.dex */
public class StepAlarmReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    AppRuntime f312198a;

    public StepAlarmReceiver(AppRuntime appRuntime) {
        this.f312198a = appRuntime;
    }

    public void a() {
        this.f312198a = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        final AppRuntime appRuntime = this.f312198a;
        if (appRuntime == null) {
            QLog.e("StepAlarmReceiver", 1, "onReceive:mApp is null");
            return;
        }
        if (!((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isSupportStepCounter(appRuntime.getApplicationContext())) {
            QLog.e("StepAlarmReceiver", 1, "onReceive:step counter not support");
            return;
        }
        String action = intent.getAction();
        if ("action_sport_timer1".equals(action) && SSOHttpUtils.p(2, appRuntime.getAccount())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.StepAlarmReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    AppRuntime appRuntime2 = appRuntime;
                    if (appRuntime2 == null) {
                        return;
                    }
                    ((ISportManager) appRuntime2.getRuntimeService(ISportManager.class, ProcessConstant.MULTI)).doOnTimer1();
                }
            }, 16, null, false);
            return;
        }
        if ("action_sport_timer2".equals(action)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.StepAlarmReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    AppRuntime appRuntime2 = StepAlarmReceiver.this.f312198a;
                    if (appRuntime2 == null) {
                        return;
                    }
                    ((ISportManager) appRuntime2.getRuntimeService(ISportManager.class, ProcessConstant.MULTI)).doOnTimer2();
                }
            }, 16, null, false);
            return;
        }
        if (StepCounterConstants.ACTION_SSO_STEP_REPORT.equals(action)) {
            QLog.i("StepAlarmReceiver", 1, "StepAlarmReceiver_long_time_report!");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.StepAlarmReceiver.3
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.vashealth.step.k kVar = com.tencent.mobileqq.vashealth.step.k.f312340a;
                    if (kVar.j()) {
                        kVar.q();
                    } else {
                        SSOHttpUtils.u(StepAlarmReceiver.this.f312198a, intent.getExtras());
                    }
                }
            }, 16, null, false);
        } else if (IECScreenReceiver.ACTION_QQ_FOREGROUND.equals(action)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.StepAlarmReceiver.4
                @Override // java.lang.Runnable
                public void run() {
                    AppRuntime appRuntime2 = StepAlarmReceiver.this.f312198a;
                    if (appRuntime2 == null) {
                        return;
                    }
                    ((ISportManager) appRuntime2.getRuntimeService(ISportManager.class, ProcessConstant.MULTI)).refreshCurrentStep(com.tencent.mobileqq.msf.core.net.r.a.f248963o);
                }
            }, 16, null, false);
        } else if ("action_sport_timer_morning".equals(action)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.StepAlarmReceiver.5
                @Override // java.lang.Runnable
                public void run() {
                    AppRuntime appRuntime2 = StepAlarmReceiver.this.f312198a;
                    if (appRuntime2 == null) {
                        return;
                    }
                    ((ISportManager) appRuntime2.getRuntimeService(ISportManager.class, ProcessConstant.MULTI)).refreshCurrentStep("morning_report");
                }
            }, 16, null, false);
        }
    }
}
