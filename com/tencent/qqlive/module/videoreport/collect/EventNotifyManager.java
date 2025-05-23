package com.tencent.qqlive.module.videoreport.collect;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class EventNotifyManager {
    private static final String TAG = "EventNotifyManager";
    private static final Set<Long> mTouchEventCache = new HashSet();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private Map<String, IEventNotifier> mNotifierMap = new HashMap();
    private ListenerMgr<IEventListener> mListenerMgr = new ListenerMgr<>();
    private Runnable mNotifyRunnable = new Runnable() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.1
        @Override // java.lang.Runnable
        public void run() {
            EventNotifyManager.this.notifyEvent();
        }
    };
    private final Object mImmediateNotifySetLock = new Object();
    private Set<String> mImmediateNotifySet = new HashSet();
    private Runnable mClearImmediateNotifierRunnable = new Runnable() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.2
        @Override // java.lang.Runnable
        public void run() {
            synchronized (EventNotifyManager.this.mImmediateNotifySetLock) {
                EventNotifyManager.this.mImmediateNotifySet.clear();
                EventNotifyManager.mTouchEventCache.clear();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements ListenerMgr.INotifyCallback<IEventListener> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f345230a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Dialog f345231b;

        a(Activity activity, Dialog dialog) {
            this.f345230a = activity;
            this.f345231b = dialog;
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNotify(IEventListener iEventListener) {
            iEventListener.onDialogHide(this.f345230a, this.f345231b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements ListenerMgr.INotifyCallback<IEventListener> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f345233a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f345234b;

        b(View view, View view2) {
            this.f345233a = view;
            this.f345234b = view2;
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNotify(IEventListener iEventListener) {
            iEventListener.onChildViewRemoved(this.f345233a, this.f345234b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements ListenerMgr.INotifyCallback<IEventListener> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f345236a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f345237b;

        c(View view, View view2) {
            this.f345236a = view;
            this.f345237b = view2;
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNotify(IEventListener iEventListener) {
            iEventListener.onChildViewAdded(this.f345236a, this.f345237b);
        }
    }

    private String getMapKey(Object obj, IEventNotifier iEventNotifier, String str) {
        String simpleName;
        int hashCode;
        if (iEventNotifier == null) {
            simpleName = "";
        } else {
            simpleName = iEventNotifier.getClass().getSimpleName();
        }
        StringBuilder sb5 = new StringBuilder();
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        sb5.append(hashCode);
        sb5.append("_");
        sb5.append(simpleName);
        sb5.append("_");
        sb5.append(str);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyEvent() {
        synchronized (this) {
            if (this.mNotifierMap.isEmpty()) {
                return;
            }
            HashMap hashMap = new HashMap(this.mNotifierMap);
            this.mNotifierMap.clear();
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                notifySingleEvent((IEventNotifier) it.next());
            }
            hashMap.clear();
        }
    }

    private void notifySingleEvent(final IEventNotifier iEventNotifier) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "notifyEvent, notifier = " + iEventNotifier.getClass().getSimpleName());
        }
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IEventListener>() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.3
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IEventListener iEventListener) {
                iEventNotifier.notifyEvent(iEventListener);
            }
        });
        ReusablePool.recycle(iEventNotifier);
    }

    private void notifyTouchEvent(final IEventNotifier iEventNotifier) {
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IEventListener>() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.4
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IEventListener iEventListener) {
                iEventNotifier.notifyEvent(iEventListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addEventNotifier(Object obj, IEventNotifier iEventNotifier) {
        String mapKey = getMapKey(obj, iEventNotifier, "");
        synchronized (this) {
            IEventNotifier iEventNotifier2 = this.mNotifierMap.get(mapKey);
            if (iEventNotifier2 != null) {
                ReusablePool.recycle(iEventNotifier2);
            }
            this.mNotifierMap.put(mapKey, iEventNotifier);
        }
        this.mMainHandler.removeCallbacks(this.mNotifyRunnable);
        this.mMainHandler.post(this.mNotifyRunnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addEventNotifierImmediately(Object obj, IEventNotifier iEventNotifier, String str) {
        String mapKey = getMapKey(obj, iEventNotifier, str);
        synchronized (this.mImmediateNotifySetLock) {
            if (this.mImmediateNotifySet.contains(mapKey)) {
                return;
            }
            this.mImmediateNotifySet.add(mapKey);
            notifySingleEvent(iEventNotifier);
            this.mMainHandler.removeCallbacks(this.mClearImmediateNotifierRunnable);
            this.mMainHandler.post(this.mClearImmediateNotifierRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTouchEventNotifierImmediately(long j3, Object obj, Window window, MotionEvent motionEvent, boolean z16, boolean z17) {
        synchronized (this.mImmediateNotifySetLock) {
            Set<Long> set = mTouchEventCache;
            if (set.contains(Long.valueOf(j3))) {
                return;
            }
            set.add(Long.valueOf(j3));
            PageManager.getInstance().markInteractive(obj, window, motionEvent, z16, z17);
            this.mMainHandler.removeCallbacks(this.mClearImmediateNotifierRunnable);
            this.mMainHandler.post(this.mClearImmediateNotifierRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityCreate(final Activity activity) {
        String str = "EventNotifyManager.onActivityCreate(" + activity.getClass().getSimpleName() + ")";
        SimpleTracer.begin(str);
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IEventListener>() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.5
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IEventListener iEventListener) {
                iEventListener.onActivityCreate(activity);
            }
        });
        SimpleTracer.end(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityDestroyed(final Activity activity) {
        String str = "EventNotifyManager.onActivityDestroyed(" + activity.getClass().getSimpleName() + ")";
        SimpleTracer.begin(str);
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IEventListener>() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.10
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IEventListener iEventListener) {
                iEventListener.onActivityDestroyed(activity);
            }
        });
        SimpleTracer.end(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityPaused(final Activity activity) {
        String str = "EventNotifyManager.onActivityPaused(" + activity.getClass().getSimpleName() + ")";
        SimpleTracer.begin(str);
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IEventListener>() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.8
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IEventListener iEventListener) {
                iEventListener.onActivityPause(activity);
            }
        });
        SimpleTracer.end(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityResumed(final Activity activity) {
        String str = "EventNotifyManager.onActivityResume(" + activity.getClass().getSimpleName() + ")";
        SimpleTracer.begin(str);
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IEventListener>() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.7
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IEventListener iEventListener) {
                iEventListener.onActivityResume(activity);
            }
        });
        SimpleTracer.end(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityStarted(final Activity activity) {
        String str = "EventNotifyManager.onActivityStarted(" + activity.getClass().getSimpleName() + ")";
        SimpleTracer.begin(str);
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IEventListener>() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.6
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IEventListener iEventListener) {
                iEventListener.onActivityStarted(activity);
            }
        });
        SimpleTracer.end(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityStopped(final Activity activity) {
        String str = "EventNotifyManager.onActivityStopped(" + activity.getClass().getSimpleName() + ")";
        SimpleTracer.begin(str);
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IEventListener>() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.9
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IEventListener iEventListener) {
                iEventListener.onActivityStopped(activity);
            }
        });
        SimpleTracer.end(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onChildViewAdded(View view, View view2) {
        this.mListenerMgr.startNotify(new c(view, view2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onChildViewRemoved(View view, View view2) {
        this.mListenerMgr.startNotify(new b(view, view2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDialogHide(Activity activity, Dialog dialog) {
        this.mListenerMgr.startNotify(new a(activity, dialog));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDialogShow(final Activity activity, final Dialog dialog) {
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IEventListener>() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.14
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IEventListener iEventListener) {
                iEventListener.onDialogShow(activity, dialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onFragmentDestroyView(final FragmentCompat fragmentCompat) {
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IEventListener>() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.13
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IEventListener iEventListener) {
                iEventListener.onFragmentDestroyView(fragmentCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onFragmentPaused(final FragmentCompat fragmentCompat) {
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IEventListener>() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.12
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IEventListener iEventListener) {
                iEventListener.onFragmentPause(fragmentCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onFragmentResumed(final FragmentCompat fragmentCompat) {
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IEventListener>() { // from class: com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.11
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IEventListener iEventListener) {
                iEventListener.onFragmentResume(fragmentCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerEventListener(IEventListener iEventListener) {
        this.mListenerMgr.register(iEventListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterEventListener(IEventListener iEventListener) {
        this.mListenerMgr.unregister(iEventListener);
    }
}
