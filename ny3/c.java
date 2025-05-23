package ny3;

import android.app.Activity;
import mqq.app.lifecycle.ActivityLifeCycleMonitor;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c implements ActivityLifeCycleMonitor.IActivityLifeCycleMonitorHandle {
    @Override // mqq.app.lifecycle.ActivityLifeCycleMonitor.IActivityLifeCycleMonitorHandle
    public void doOnActivityPostResumeEnd(Activity activity) {
        b.e().c(activity);
    }

    @Override // mqq.app.lifecycle.ActivityLifeCycleMonitor.IActivityLifeCycleMonitorHandle
    public void doOnActiviyConfigurationChanged(Activity activity) {
    }
}
