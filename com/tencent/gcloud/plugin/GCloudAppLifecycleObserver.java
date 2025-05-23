package com.tencent.gcloud.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class GCloudAppLifecycleObserver {
    static IPatchRedirector $redirector_;

    public GCloudAppLifecycleObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            com.gcore.gcloud.plugin.GCloudAppLifecycle.Instance.addGenericoObserver(this);
        }
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
