package com.tencent.aelight.camera.ae.flashshow.util;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes32.dex */
class MediaCodecGLFrameFetcher$3 implements Runnable {
    final /* synthetic */ n this$0;

    @Override // java.lang.Runnable
    public void run() {
        if (n.f(null) == null) {
            return;
        }
        n.f(null).updateTexImage();
        GLES20.glViewport(0, 0, n.e(null), n.d(null));
        n.c(null).a(n.f(null), n.b(null));
        if (n.a(null) != null && !n.a(null).isRecycled()) {
            n.a(null).recycle();
        }
        n.g(null, j.a(n.b(null), n.e(null), n.d(null)));
    }
}
