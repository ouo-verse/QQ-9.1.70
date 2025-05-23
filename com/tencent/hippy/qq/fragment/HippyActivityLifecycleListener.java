package com.tencent.hippy.qq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface HippyActivityLifecycleListener {
    void onActivityCreated(Activity activity, Bundle bundle);

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResult(Activity activity, int i3, int i16, Intent intent);

    void onActivityResumed(Activity activity);

    void onActivitySaveInstanceState(Activity activity, Bundle bundle);

    void onActivityStarted(Activity activity);

    void onActivityStopped(Activity activity);

    void onNewIntent(Activity activity, Intent intent);
}
