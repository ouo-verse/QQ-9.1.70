package com.tencent.ams.fusion.widget.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OnActivityLifecycleChanged implements Application.ActivityLifecycleCallbacks {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "OnActivityLifecycleChanged";
    private static final Map<OnActivityLifecycleChangedListener, OnActivityLifecycleChanged> sCache;
    private Application mApplication;
    private WeakReference<Activity> mCurrentActivityRef;
    private WeakReference<OnActivityLifecycleChangedListener> mOnActivityLifecycleChangedListenerRef;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface ActivityLifecycle {
        public static final int CREATED = 1;
        public static final int DESTROYED = 6;
        public static final int PAUSED = 3;
        public static final int RESUMED = 4;
        public static final int STARTED = 2;
        public static final int STOPPED = 5;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnActivityLifecycleChangedListener {
        void onChanged(@ActivityLifecycle int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39130);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            sCache = new WeakHashMap();
        }
    }

    OnActivityLifecycleChanged(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            init(context);
        }
    }

    public static synchronized void addListener(Context context, OnActivityLifecycleChangedListener onActivityLifecycleChangedListener) {
        synchronized (OnActivityLifecycleChanged.class) {
            Logger.i(TAG, "addListener, context: " + context + ", listener: " + onActivityLifecycleChangedListener);
            if (onActivityLifecycleChangedListener != null) {
                Map<OnActivityLifecycleChangedListener, OnActivityLifecycleChanged> map = sCache;
                if (map.get(onActivityLifecycleChangedListener) == null) {
                    OnActivityLifecycleChanged onActivityLifecycleChanged = new OnActivityLifecycleChanged(context);
                    onActivityLifecycleChanged.setOnActivityLifecycleChangedListener(onActivityLifecycleChangedListener);
                    map.put(onActivityLifecycleChangedListener, onActivityLifecycleChanged);
                }
            }
        }
    }

    private void init(Context context) {
        Activity currentActivity;
        if (context != null && (currentActivity = Utils.getCurrentActivity(context)) != null) {
            this.mCurrentActivityRef = new WeakReference<>(currentActivity);
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                Application application = (Application) applicationContext;
                this.mApplication = application;
                application.registerActivityLifecycleCallbacks(this);
            }
        }
    }

    private void onDestroyed() {
        OnActivityLifecycleChangedListener onActivityLifecycleChangedListener;
        WeakReference<OnActivityLifecycleChangedListener> weakReference = this.mOnActivityLifecycleChangedListenerRef;
        if (weakReference == null) {
            onActivityLifecycleChangedListener = null;
        } else {
            onActivityLifecycleChangedListener = weakReference.get();
        }
        if (onActivityLifecycleChangedListener != null) {
            synchronized (OnActivityLifecycleChangedListener.class) {
                sCache.remove(onActivityLifecycleChangedListener);
            }
        }
        Application application = this.mApplication;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this);
        }
        this.mCurrentActivityRef = null;
        this.mOnActivityLifecycleChangedListenerRef = null;
    }

    private void onLifecycleChanged(Activity activity, @ActivityLifecycle int i3) {
        Activity activity2;
        OnActivityLifecycleChangedListener onActivityLifecycleChangedListener;
        WeakReference<Activity> weakReference = this.mCurrentActivityRef;
        if (weakReference == null) {
            activity2 = null;
        } else {
            activity2 = weakReference.get();
        }
        if (activity == activity2) {
            WeakReference<OnActivityLifecycleChangedListener> weakReference2 = this.mOnActivityLifecycleChangedListenerRef;
            if (weakReference2 != null && (onActivityLifecycleChangedListener = weakReference2.get()) != null) {
                onActivityLifecycleChangedListener.onChanged(i3);
            }
            if (i3 == 6) {
                onDestroyed();
            }
        }
    }

    public static synchronized void removeListener(OnActivityLifecycleChangedListener onActivityLifecycleChangedListener) {
        synchronized (OnActivityLifecycleChanged.class) {
            Logger.i(TAG, "removeListener");
            if (onActivityLifecycleChangedListener == null) {
                Logger.w(TAG, "listener is null.");
                return;
            }
            OnActivityLifecycleChanged remove = sCache.remove(onActivityLifecycleChangedListener);
            if (remove != null) {
                Logger.i(TAG, "destroy " + remove);
                remove.onDestroyed();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) bundle);
        } else {
            onLifecycleChanged(activity, 1);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        } else {
            onLifecycleChanged(activity, 6);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            onLifecycleChanged(activity, 3);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            onLifecycleChanged(activity, 4);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity, (Object) bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            onLifecycleChanged(activity, 2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            onLifecycleChanged(activity, 5);
        }
    }

    public void setOnActivityLifecycleChangedListener(OnActivityLifecycleChangedListener onActivityLifecycleChangedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onActivityLifecycleChangedListener);
        } else {
            this.mOnActivityLifecycleChangedListenerRef = new WeakReference<>(onActivityLifecycleChangedListener);
        }
    }
}
