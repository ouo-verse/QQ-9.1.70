package com.tencent.aelight.camera.ae.flashshow.util;

/* compiled from: P */
/* loaded from: classes32.dex */
class SimpleGLThread$4 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Object f65102d;
    final /* synthetic */ t this$0;

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f65102d) {
            this.f65102d.notifyAll();
        }
    }
}
