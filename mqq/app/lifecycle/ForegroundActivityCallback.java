package mqq.app.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.QActivityLifecycleCallbacks;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ForegroundActivityCallback implements QActivityLifecycleCallbacks {
    public static final String TAG = "ForegroundActivityCallback";
    private final HashSet<ActivityRef> activityRefs = new HashSet<>();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class ActivityRef {
        private final WeakReference<Activity> activityRef;

        ActivityRef(Activity activity) {
            this.activityRef = new WeakReference<>(activity);
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof ActivityRef) || ((ActivityRef) obj).activityRef.get() != this.activityRef.get()) {
                return false;
            }
            return true;
        }

        public void finishActivity() {
            Activity activity = this.activityRef.get();
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }

        public boolean finishActivityIfAtTask(int i3) {
            Activity activity = this.activityRef.get();
            if (activity != null && activity.getTaskId() == i3) {
                activity.finish();
                return true;
            }
            return false;
        }

        public int hashCode() {
            Activity activity = this.activityRef.get();
            if (activity == null) {
                return 0;
            }
            return activity.hashCode();
        }

        public boolean isAvailable() {
            if (this.activityRef.get() != null) {
                return true;
            }
            return false;
        }
    }

    @MainThread
    public void finishAllActivity() {
        ArrayList arrayList = new ArrayList(this.activityRefs);
        this.activityRefs.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ActivityRef) it.next()).finishActivity();
        }
        QLog.e(TAG, 1, "finishAllActivity", new Throwable());
    }

    @MainThread
    public void finishAllActivityAtTask(int i3) {
        ArrayList arrayList = new ArrayList();
        Iterator<ActivityRef> it = this.activityRefs.iterator();
        while (it.hasNext()) {
            ActivityRef next = it.next();
            if (next.finishActivityIfAtTask(i3)) {
                arrayList.add(next);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            this.activityRefs.remove((ActivityRef) it5.next());
        }
    }

    public int getAvailableActCnt() {
        Iterator<ActivityRef> it = this.activityRefs.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().isAvailable()) {
                i3++;
            }
        }
        return i3;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        this.activityRefs.add(new ActivityRef(activity));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onActivityCreated: ", activity.toString(), ", after add set size: ", Integer.valueOf(this.activityRefs.size()));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        this.activityRefs.remove(new ActivityRef(activity));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onActivityDestroyed: ", activity.toString(), ", after remove set size: ", Integer.valueOf(this.activityRefs.size()));
        }
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessBackground() {
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessForeground() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }
}
