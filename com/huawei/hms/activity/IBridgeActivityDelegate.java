package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IBridgeActivityDelegate {
    int getRequestCode();

    void onBridgeActivityCreate(Activity activity);

    void onBridgeActivityDestroy();

    boolean onBridgeActivityResult(int i3, int i16, Intent intent);

    void onBridgeConfigurationChanged();

    void onKeyUp(int i3, KeyEvent keyEvent);
}
