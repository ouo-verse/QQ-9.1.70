package com.tencent.shadow.core.runtime;

import android.app.Activity;
import android.app.Instrumentation;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ShadowInstrumentation extends Instrumentation {
    public void callActivityOnDestroy(ShadowActivity shadowActivity) {
        super.callActivityOnDestroy((Activity) shadowActivity.mHostActivityDelegator.getHostActivity());
    }
}
