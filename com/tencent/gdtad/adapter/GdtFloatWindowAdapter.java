package com.tencent.gdtad.adapter;

import android.app.Activity;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.views.floatwindow.AdFloatWindowAdapter;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtFloatWindowAdapter implements AdFloatWindowAdapter {
    @Override // com.tencent.ad.tangram.views.floatwindow.AdFloatWindowAdapter
    public void close(final WeakReference<Activity> weakReference) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.adapter.GdtFloatWindowAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                WeakReference weakReference2 = weakReference;
                if (weakReference2 != null) {
                    activity = (Activity) weakReference2.get();
                } else {
                    activity = null;
                }
                if (activity == null) {
                    GdtLog.e("GdtFloatWindowAdapter", "[close] error");
                    return;
                }
                try {
                    ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(activity);
                } catch (Throwable th5) {
                    GdtLog.e("GdtFloatWindowAdapter", "[close]", th5);
                }
            }
        }, 4);
    }
}
