package com.tencent.mobileqq.app.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface BaseActivityLifecycleCallbacks {
    void doOnActivityCreate(Activity activity, Bundle bundle);

    void doOnActivityDestroyed(Activity activity);

    void doOnActivityOnStart(Activity activity);

    void doOnActivityPause(Activity activity);

    void doOnActivityPostCreated(Activity activity, Bundle bundle);

    void doOnActivityPostPaused(Activity activity);

    void doOnActivityPostResumed(Activity activity);

    void doOnActivityPreCreated(Activity activity, Bundle bundle);

    void doOnActivityPrePaused(Activity activity);

    void doOnActivityPreResumed(Activity activity);

    void doOnActivityResume(Activity activity);

    void doOnActivityStopped(Activity activity);

    void doOnConfigurationChanged(Activity activity, Configuration configuration);

    boolean doOnDispatchKeyEvent(KeyEvent keyEvent);

    void doOnNewIntent(Activity activity, Intent intent);

    void doOnWindowFocusChanged(Activity activity, boolean z16);

    void onAccountChanged(Activity activity);

    void onMultiWindowModeChanged(Activity activity, boolean z16);

    void onPostThemeChanged(Activity activity);

    void onPreHandleStartActivityForResult(Activity activity, Intent intent, int i3);

    void onPreSetContentView(int i3);

    void onPreSetContentView(View view);

    void onRestoreInstanceState(Activity activity, Bundle bundle);

    void onSaveInstanceState(Activity activity, Bundle bundle);
}
