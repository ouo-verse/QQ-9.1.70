package com.gcore.gcloud.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class GCloudAppLifecycleObserver {
    public GCloudAppLifecycleObserver() {
        GCloudAppLifecycle.Instance.addObserver(this);
    }

    public abstract void onActivityResult(int i3, int i16, Intent intent);

    public abstract void onCreate(Activity activity, Bundle bundle);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onNewIntent(Intent intent);

    public abstract void onPause();

    public abstract void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr);

    public abstract void onRestart();

    public abstract void onResume();

    public abstract void onStart();

    public abstract void onStop();
}
