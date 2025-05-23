package com.tencent.mobileqq.vashealth.huaweistep;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.vashealth.huawei.HuaWeiStepAuthManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HuaweiStepManager extends BroadcastReceiver {
    private static HuaweiStepManager INSTANCE = null;
    private static final String TAG = "HuaweiStepManager";

    public HuaweiStepManager() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.huawei.step.broadcast_action");
        MobileQQ.sMobileQQ.registerReceiver(this, intentFilter);
    }

    public static HuaweiStepManager getInstance() {
        if (INSTANCE == null) {
            synchronized (HuaweiStepManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HuaweiStepManager();
                }
            }
        }
        return INSTANCE;
    }

    private void onReceiveStepAction(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("authResult", false);
        int intExtra = intent.getIntExtra("stepData", 0);
        QLog.d(TAG, 1, "onReceiveStepAction " + booleanExtra + " step " + intExtra);
        if (booleanExtra && intExtra > 0) {
            HuaweiStepHelper.saveStepData(intExtra);
        }
    }

    private void startQueryTodayStep(int i3, boolean z16) {
        QLog.e(TAG, 1, "startQueryTodayStep " + z16);
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            QLog.e(TAG, 1, "sTopActivity is null");
            HuaWeiStepAuthManager.h(MobileQQ.sMobileQQ).j(i3, z16);
        } else {
            HuaWeiStepAuthManager.h(qBaseActivity).j(i3, z16);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals("com.tencent.huawei.step.broadcast_action")) {
            onReceiveStepAction(intent);
        }
    }

    public int queryHuaWeiSdkTodaySteps(int i3, boolean z16) {
        QLog.d(TAG, 1, "queryHuaWeiSdkTodaySteps start originStep=" + i3);
        startQueryTodayStep(i3, z16);
        int cacheStep = HuaweiStepHelper.getCacheStep();
        if (i3 < cacheStep) {
            i3 = cacheStep;
        }
        QLog.d(TAG, 1, "queryHuaWeiSdkTodaySteps finish originStep=" + i3);
        return i3;
    }
}
