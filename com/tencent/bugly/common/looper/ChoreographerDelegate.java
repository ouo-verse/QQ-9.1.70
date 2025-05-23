package com.tencent.bugly.common.looper;

import android.annotation.TargetApi;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.ref.WeakReference;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes5.dex */
public class ChoreographerDelegate {
    private static final int INIT_LIMIT = 10;
    private static final String TAG = "RMonitor_looper";
    private int failInitCount = 0;
    private WeakReference<Choreographer> mChoreographerRef = null;

    public ChoreographerDelegate() {
        initChoreographer();
    }

    private Choreographer initChoreographer() {
        Choreographer choreographer = null;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return null;
        }
        try {
            choreographer = Choreographer.getInstance();
            this.mChoreographerRef = new WeakReference<>(choreographer);
            return choreographer;
        } catch (Throwable th5) {
            this.failInitCount++;
            Logger.f365497g.b(TAG, "init choreographer error (fail count: " + this.failInitCount + ")", th5);
            return choreographer;
        }
    }

    public Choreographer getChoreographer() {
        Choreographer choreographer;
        WeakReference<Choreographer> weakReference = this.mChoreographerRef;
        if (weakReference == null) {
            choreographer = null;
        } else {
            choreographer = weakReference.get();
        }
        if (choreographer == null && this.failInitCount < 10) {
            return initChoreographer();
        }
        return choreographer;
    }

    public void postFrameCallback(Choreographer.FrameCallback frameCallback) {
        Choreographer choreographer = getChoreographer();
        if (choreographer == null) {
            return;
        }
        try {
            choreographer.postFrameCallback(frameCallback);
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
        }
    }

    public void removeFrameCallback(Choreographer.FrameCallback frameCallback) {
        Choreographer choreographer = getChoreographer();
        if (choreographer == null) {
            return;
        }
        try {
            choreographer.removeFrameCallback(frameCallback);
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
        }
    }
}
