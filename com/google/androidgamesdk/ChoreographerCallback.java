package com.google.androidgamesdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Choreographer;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ChoreographerCallback implements Choreographer.FrameCallback {

    /* renamed from: d, reason: collision with root package name */
    private long f34661d;

    /* compiled from: P */
    /* renamed from: com.google.androidgamesdk.ChoreographerCallback$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ChoreographerCallback this$0;

        @Override // java.lang.Runnable
        public void run() {
            Choreographer.getInstance().postFrameCallback(this.this$0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class LooperThread extends BaseThread {
        public Handler C;
        final /* synthetic */ ChoreographerCallback this$0;

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.i("ChoreographerCallback", "Starting looper thread");
            Looper.prepare();
            this.C = new Handler();
            Looper.loop();
            Log.i("ChoreographerCallback", "Terminating looper thread");
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j3) {
        nOnChoreographer(this.f34661d, j3);
    }

    public native void nOnChoreographer(long j3, long j16);
}
