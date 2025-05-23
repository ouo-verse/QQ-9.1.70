package com.tencent.aelight.camera.ae.flashshow.util;

/* compiled from: P */
/* loaded from: classes32.dex */
class SimpleGLThread$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Object f65101d;
    final /* synthetic */ t this$0;

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f65101d) {
            this.f65101d.notifyAll();
        }
    }
}
