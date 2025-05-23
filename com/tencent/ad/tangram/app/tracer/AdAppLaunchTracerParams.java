package com.tencent.ad.tangram.app.tracer;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class AdAppLaunchTracerParams {
    public int requestCode = Integer.MIN_VALUE;
    public long timeoutMillis = 6000;
    public WeakReference<Activity> weakActivity;
    public CopyOnWriteArrayList<WeakReference<IAdAppLaunchTracerListener>> weakListeners;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValid() {
        WeakReference<Activity> weakReference = this.weakActivity;
        if (weakReference != null && weakReference.get() != null && this.requestCode != Integer.MIN_VALUE && this.timeoutMillis >= 0) {
            return true;
        }
        return false;
    }
}
