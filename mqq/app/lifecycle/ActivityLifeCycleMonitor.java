package mqq.app.lifecycle;

import android.app.Activity;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ActivityLifeCycleMonitor {
    private static IActivityLifeCycleMonitorHandle sActivityLifeCycleMonitorHandle;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface IActivityLifeCycleMonitorHandle {
        void doOnActivityPostResumeEnd(Activity activity);

        void doOnActiviyConfigurationChanged(Activity activity);
    }

    public static void doOnActivityPostResumeEnd(Activity activity) {
        IActivityLifeCycleMonitorHandle iActivityLifeCycleMonitorHandle = sActivityLifeCycleMonitorHandle;
        if (iActivityLifeCycleMonitorHandle != null) {
            iActivityLifeCycleMonitorHandle.doOnActivityPostResumeEnd(activity);
        }
    }

    public static void doOnActiviyConfigurationChanged(Activity activity) {
        IActivityLifeCycleMonitorHandle iActivityLifeCycleMonitorHandle = sActivityLifeCycleMonitorHandle;
        if (iActivityLifeCycleMonitorHandle != null) {
            iActivityLifeCycleMonitorHandle.doOnActiviyConfigurationChanged(activity);
        }
    }

    public static void setActivityLifeCycleMonitorHandle(IActivityLifeCycleMonitorHandle iActivityLifeCycleMonitorHandle) {
        sActivityLifeCycleMonitorHandle = iActivityLifeCycleMonitorHandle;
    }
}
