package com.tencent.liteav.base.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class i implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private static final p<Boolean> f119018a = new p<>(j.a());

    /* renamed from: b, reason: collision with root package name */
    private volatile WeakReference<Activity> f119019b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Boolean f119020c;

    /* renamed from: d, reason: collision with root package name */
    private volatile a f119021d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<Integer> f119022e;

    /* renamed from: f, reason: collision with root package name */
    private final Set<Integer> f119023f;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final i f119024a = new i(0);
    }

    /* synthetic */ i(byte b16) {
        this();
    }

    public static void a(boolean z16) {
        f119018a.a(Boolean.valueOf(z16));
    }

    public final synchronized boolean b() {
        if (this.f119020c == null) {
            this.f119020c = f119018a.a();
        }
        return this.f119020c.booleanValue();
    }

    public final Activity c() {
        WeakReference<Activity> weakReference = this.f119019b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityDestroyed(Activity activity) {
        Log.i("ProcessLifecycleOwner", "onActivityDestroyed, activity=".concat(String.valueOf(activity)), new Object[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityPaused(Activity activity) {
        this.f119023f.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityResumed(Activity activity) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityStarted(Activity activity) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityStopped(Activity activity) {
        int hashCode = activity.hashCode();
        boolean z16 = true;
        if (this.f119022e.contains(Integer.valueOf(hashCode))) {
            this.f119022e.remove(Integer.valueOf(hashCode));
            if (this.f119022e.size() != 0) {
                z16 = false;
            }
            b(z16);
        } else if (this.f119022e.size() == 0) {
            if (this.f119023f.contains(Integer.valueOf(hashCode))) {
                b(true);
            }
        } else {
            b(false);
        }
        this.f119023f.remove(Integer.valueOf(hashCode));
    }

    i() {
        this.f119019b = null;
        this.f119020c = null;
        this.f119022e = new HashSet();
        this.f119023f = new HashSet();
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            Log.e("ProcessLifecycleOwner", "ProcessStateOwner init failed. Context is null", new Object[0]);
        } else {
            ((Application) applicationContext.getApplicationContext()).registerActivityLifecycleCallbacks(this);
        }
    }

    public static i a() {
        return b.f119024a;
    }

    public final synchronized void a(Activity activity) {
        if (activity == null) {
            return;
        }
        if (c() != null) {
            Log.i("ProcessLifecycleOwner", "activity is exists, don't need activity from user", new Object[0]);
            return;
        }
        this.f119019b = new WeakReference<>(activity);
        Log.i("ProcessLifecycleOwner", "update activity to " + activity + " from user", new Object[0]);
    }

    private synchronized void b(boolean z16) {
        if (this.f119020c == null || this.f119020c.booleanValue() != z16) {
            this.f119020c = Boolean.valueOf(z16);
            f119018a.a(Boolean.valueOf(z16));
            if (this.f119021d != null) {
                this.f119021d.a(this.f119020c.booleanValue());
            }
        }
    }

    private void b(Activity activity) {
        this.f119022e.add(Integer.valueOf(activity.hashCode()));
        this.f119019b = new WeakReference<>(activity);
        b(false);
        Log.i("ProcessLifecycleOwner", "update activity to ".concat(String.valueOf(activity)), new Object[0]);
    }

    public final synchronized void a(a aVar) {
        this.f119021d = aVar;
    }

    private static boolean a(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager == null) {
                Log.e("ProcessLifecycleOwner", "activityManager is null.", new Object[0]);
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
            if (runningAppProcesses == null) {
                Log.e("ProcessLifecycleOwner", "processInfoList is null.", new Object[0]);
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && context.getPackageName().equals(runningAppProcessInfo.processName)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e16) {
            Log.e("ProcessLifecycleOwner", "Get App background state failed. ".concat(String.valueOf(e16)), new Object[0]);
            return false;
        }
    }
}
