package com.tencent.ark;

import android.util.Log;
import android.view.Choreographer;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkVsync {
    protected static final String TAG = "ArkApp.ArkVsync";
    protected ArrayList<CallbackItem> mCallbackArrays;
    protected ArrayList<CallbackItem> mCallbacks = new ArrayList<>();
    protected ArkVsyncImpl mImpl = new SystemVsync();
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    private static final ArkVsync gInstance = new ArkVsync();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ArkFrameCallback {
        void doFrame();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ArkVsyncImpl {
        void start(ArkVsync arkVsync);

        void stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class CallbackItem {
        WeakReference<ArkFrameCallback> callbackRef;
        boolean isCallbacking = false;
        String queueKey;

        CallbackItem(String str, ArkFrameCallback arkFrameCallback) {
            this.queueKey = str;
            this.callbackRef = new WeakReference<>(arkFrameCallback);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static final class SystemVsync implements ArkVsyncImpl, Choreographer.FrameCallback {
        Choreographer mChoreographer;
        ArkVsync mVsync;

        SystemVsync() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            ArkVsync arkVsync = this.mVsync;
            if (arkVsync != null && this.mChoreographer != null) {
                arkVsync.frameCallback();
                this.mChoreographer.postFrameCallback(this);
            }
        }

        @Override // com.tencent.ark.ArkVsync.ArkVsyncImpl
        public void start(ArkVsync arkVsync) {
            if (this.mVsync != null) {
                Log.d(ArkVsync.TAG, String.format("mVsync != null", new Object[0]));
            } else {
                this.mVsync = arkVsync;
                ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.ArkVsync.SystemVsync.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SystemVsync systemVsync = SystemVsync.this;
                            if (systemVsync.mChoreographer == null) {
                                systemVsync.mChoreographer = Choreographer.getInstance();
                            }
                            SystemVsync systemVsync2 = SystemVsync.this;
                            systemVsync2.mChoreographer.postFrameCallback(systemVsync2);
                        } catch (Exception e16) {
                            Logger.logE(ArkVsync.TAG, e16.toString());
                        }
                    }
                });
            }
        }

        @Override // com.tencent.ark.ArkVsync.ArkVsyncImpl
        public void stop() {
            ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.ArkVsync.SystemVsync.2
                @Override // java.lang.Runnable
                public void run() {
                    SystemVsync systemVsync = SystemVsync.this;
                    Choreographer choreographer = systemVsync.mChoreographer;
                    if (choreographer != null) {
                        choreographer.removeFrameCallback(systemVsync);
                        SystemVsync systemVsync2 = SystemVsync.this;
                        systemVsync2.mChoreographer = null;
                        systemVsync2.mVsync = null;
                    }
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static final class TimerVsync implements ArkVsyncImpl, Runnable {
        volatile boolean mCallbacking;
        Timer mTimer;
        ArkVsync mVsync;

        TimerVsync() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArkVsync arkVsync = this.mVsync;
            if (arkVsync != null) {
                arkVsync.frameCallback();
            }
        }

        @Override // com.tencent.ark.ArkVsync.ArkVsyncImpl
        public void start(ArkVsync arkVsync) {
            if (this.mVsync != null) {
                return;
            }
            BaseTimer baseTimer = new BaseTimer();
            this.mTimer = baseTimer;
            this.mVsync = arkVsync;
            baseTimer.scheduleAtFixedRate(new TimerTask() { // from class: com.tencent.ark.ArkVsync.TimerVsync.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (TimerVsync.this.mCallbacking) {
                        return;
                    }
                    TimerVsync.this.mCallbacking = true;
                    TimerVsync.this.run();
                    TimerVsync.this.mCallbacking = false;
                }
            }, 0L, 16L);
        }

        @Override // com.tencent.ark.ArkVsync.ArkVsyncImpl
        public void stop() {
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer.purge();
                this.mTimer = null;
            }
            this.mVsync = null;
        }
    }

    ArkVsync() {
    }

    public static ArkVsync getInstance() {
        return gInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFrameCallback(String str, ArkFrameCallback arkFrameCallback) {
        if (arkFrameCallback != null && ArkStateCenter.getInstance().isForeground()) {
            synchronized (this.mCallbacks) {
                Iterator<CallbackItem> it = this.mCallbacks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CallbackItem next = it.next();
                    WeakReference<ArkFrameCallback> weakReference = next.callbackRef;
                    if (weakReference != null && weakReference.get() == arkFrameCallback) {
                        next.callbackRef = null;
                        this.mCallbacks.remove(next);
                        break;
                    }
                }
                this.mCallbacks.add(new CallbackItem(str, arkFrameCallback));
                ArrayList<CallbackItem> arrayList = this.mCallbackArrays;
                if (arrayList != null) {
                    arrayList.clear();
                    this.mCallbackArrays = null;
                }
                if (this.mCallbacks.size() == 1 && this.mImpl != null) {
                    ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.ArkVsync.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Logger.logD(ArkVsync.TAG, "addFrameCallback, start vsync");
                            ArkVsync.this.mImpl.start(this);
                        }
                    });
                }
            }
            return;
        }
        Logger.logE(TAG, "add frame callback fail. callback:" + arkFrameCallback + ",isForeground:" + ArkStateCenter.getInstance().isForeground());
    }

    void frameCallback() {
        synchronized (this.mCallbacks) {
            if (this.mCallbacks.size() <= 0) {
                return;
            }
            if (this.mCallbackArrays == null) {
                this.mCallbackArrays = new ArrayList<>(this.mCallbacks);
            }
            Iterator<CallbackItem> it = this.mCallbackArrays.iterator();
            while (it.hasNext()) {
                final CallbackItem next = it.next();
                if (!next.isCallbacking) {
                    next.isCallbacking = true;
                    ArkDispatchQueue.asyncRun(next.queueKey, new Runnable() { // from class: com.tencent.ark.ArkVsync.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ArkFrameCallback arkFrameCallback;
                            try {
                                WeakReference<ArkFrameCallback> weakReference = next.callbackRef;
                                if (weakReference != null) {
                                    arkFrameCallback = weakReference.get();
                                } else {
                                    arkFrameCallback = null;
                                }
                                if (arkFrameCallback != null) {
                                    arkFrameCallback.doFrame();
                                }
                            } catch (NullPointerException e16) {
                                Logger.logE(ArkVsync.TAG, "[NullPointerException] frameCallback doFrame " + e16);
                            }
                            next.isCallbacking = false;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeFrameCallback(ArkFrameCallback arkFrameCallback) {
        if (arkFrameCallback == null) {
            return;
        }
        synchronized (this.mCallbacks) {
            Iterator<CallbackItem> it = this.mCallbacks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CallbackItem next = it.next();
                WeakReference<ArkFrameCallback> weakReference = next.callbackRef;
                if (weakReference != null && weakReference.get() == arkFrameCallback) {
                    next.callbackRef = null;
                    this.mCallbacks.remove(next);
                    break;
                }
            }
            ArrayList<CallbackItem> arrayList = this.mCallbackArrays;
            if (arrayList != null) {
                arrayList.clear();
                this.mCallbackArrays = null;
            }
            if (this.mCallbacks.size() == 0 && this.mImpl != null) {
                ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.ArkVsync.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ArkVsync.this.mImpl.stop();
                    }
                });
            }
        }
    }
}
