package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

/* loaded from: classes23.dex */
public interface IUIProxy extends IMiniLifecycle {
    boolean doDispatchKeyEvent(KeyEvent keyEvent);

    void handleRestart();

    boolean isDestroyed();

    void notifyExit(boolean z16, boolean z17, boolean z18);

    void onActivityResult(Activity activity, int i3, int i16, Intent intent);

    boolean onBackPressed(Activity activity);

    void onConfigurationChanged(android.content.res.Configuration configuration);

    void onRefreshMiniBadge(Activity activity, Bundle bundle);

    void onRequestPermissionsResult(Activity activity, int i3, String[] strArr, int[] iArr);
}
