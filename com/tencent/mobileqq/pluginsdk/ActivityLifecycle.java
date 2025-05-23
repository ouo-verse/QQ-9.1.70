package com.tencent.mobileqq.pluginsdk;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ActivityLifecycle {
    static IPatchRedirector $redirector_;
    private static ReferenceQueue<ActivityLifecycleCallback> mCallbackReferenceQueue;
    private static ArrayList<WeakReference<ActivityLifecycleCallback>> mWeakCallbackArrayList;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface ActivityLifecycleCallback {
        void onNewIntent(Activity activity, Intent intent);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7399);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            mCallbackReferenceQueue = new ReferenceQueue<>();
            mWeakCallbackArrayList = new ArrayList<>();
        }
    }

    public ActivityLifecycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void onNewIntent(Activity activity, Intent intent) {
        if (DebugHelper.sDebug) {
            DebugHelper.log("ActivityLifecycle onNewIntent");
        }
        synchronized (mWeakCallbackArrayList) {
            try {
                Iterator<WeakReference<ActivityLifecycleCallback>> it = mWeakCallbackArrayList.iterator();
                while (it.hasNext()) {
                    ActivityLifecycleCallback activityLifecycleCallback = it.next().get();
                    if (activityLifecycleCallback != null) {
                        try {
                            activityLifecycleCallback.onNewIntent(activity, intent);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            } catch (ConcurrentModificationException e17) {
                e17.printStackTrace();
            }
        }
    }

    public static void onPause(Activity activity) {
        if (DebugHelper.sDebug) {
            DebugHelper.log("ActivityLifecycle onPause");
        }
        synchronized (mWeakCallbackArrayList) {
            try {
                Iterator<WeakReference<ActivityLifecycleCallback>> it = mWeakCallbackArrayList.iterator();
                while (it.hasNext()) {
                    ActivityLifecycleCallback activityLifecycleCallback = it.next().get();
                    if (activityLifecycleCallback != null) {
                        try {
                            activityLifecycleCallback.onPause(activity);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            } catch (ConcurrentModificationException e17) {
                e17.printStackTrace();
            }
        }
    }

    public static void onResume(Activity activity) {
        if (DebugHelper.sDebug) {
            DebugHelper.log("ActivityLifecycle onResume");
        }
        synchronized (mWeakCallbackArrayList) {
            try {
                Iterator<WeakReference<ActivityLifecycleCallback>> it = mWeakCallbackArrayList.iterator();
                while (it.hasNext()) {
                    ActivityLifecycleCallback activityLifecycleCallback = it.next().get();
                    if (activityLifecycleCallback != null) {
                        try {
                            activityLifecycleCallback.onResume(activity);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            } catch (ConcurrentModificationException e17) {
                e17.printStackTrace();
            }
        }
    }

    public static void registerNFCEventCallback(ActivityLifecycleCallback activityLifecycleCallback) {
        if (activityLifecycleCallback == null) {
            return;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("ActivityLifecycle registerNFCEventCallback;callback=" + activityLifecycleCallback.getClass().getName());
        }
        synchronized (mWeakCallbackArrayList) {
            while (true) {
                Reference<? extends ActivityLifecycleCallback> poll = mCallbackReferenceQueue.poll();
                if (poll != null) {
                    mWeakCallbackArrayList.remove(poll);
                } else {
                    try {
                        break;
                    } catch (ConcurrentModificationException unused) {
                    }
                }
            }
            Iterator<WeakReference<ActivityLifecycleCallback>> it = mWeakCallbackArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().get() == activityLifecycleCallback) {
                    return;
                }
            }
            mWeakCallbackArrayList.add(new WeakReference<>(activityLifecycleCallback, mCallbackReferenceQueue));
        }
    }

    public void unregister(ActivityLifecycleCallback activityLifecycleCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activityLifecycleCallback);
            return;
        }
        if (activityLifecycleCallback == null) {
            return;
        }
        synchronized (mWeakCallbackArrayList) {
            try {
                try {
                    Iterator<WeakReference<ActivityLifecycleCallback>> it = mWeakCallbackArrayList.iterator();
                    while (it.hasNext()) {
                        WeakReference<ActivityLifecycleCallback> next = it.next();
                        if (next.get() == activityLifecycleCallback) {
                            mWeakCallbackArrayList.remove(next);
                            return;
                        }
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            } catch (ConcurrentModificationException unused) {
            }
        }
    }
}
