package com.tencent.mobileqq.vashealth.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.vashealth.api.ISportDebug;
import com.tencent.mobileqq.vashealth.debug.CrossDayDebugFragment;
import com.tencent.mobileqq.vashealth.debug.HealthMainDebugFragment;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SportDebugImpl implements ISportDebug {
    @Override // com.tencent.mobileqq.vashealth.api.ISportDebug
    public void startCrossDayDebugFragment(Activity activity) {
        CrossDayDebugFragment.Lh(activity);
    }

    @Override // com.tencent.mobileqq.vashealth.api.ISportDebug
    public void startHealthMainDebugFragment(Activity activity) {
        HealthMainDebugFragment.Mh(activity);
    }
}
