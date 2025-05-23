package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.content.Intent;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdActivityHandler {
    private static final String TAG = "AdActivityHandler";

    public static void onActivityResult(WeakReference<Activity> weakReference, int i3, int i16, Intent intent) {
        Activity activity;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        AdLog.i(TAG, "[onActivityResult] activity:" + activity + " requestCode:" + i3 + " resultCode:" + i16 + " data:" + intent);
        AdAppDeeplinkLaunchTracer.getInstance().onActivityResult(weakReference, i3, i16, intent);
    }

    public static void onTopResumedActivityChanged(WeakReference<Activity> weakReference, boolean z16) {
        Activity activity;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        AdLog.i(TAG, "[onTopResumedActivityChanged] activity:" + activity + " onTop:" + z16);
        AdAppDeeplinkLaunchTracer.getInstance().onTopResumedActivityChanged(weakReference, z16);
    }
}
