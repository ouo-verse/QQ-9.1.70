package com.tencent.qcircle.shadow.core.runtime;

import android.app.Activity;
import android.app.Instrumentation;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ShadowInstrumentation extends Instrumentation {
    public void callActivityOnDestroy(ShadowActivity shadowActivity) {
        super.callActivityOnDestroy((Activity) shadowActivity.mHostActivityDelegator.getHostActivity());
    }
}
