package com.tencent.aelight.camera.ae.flashshow.util;

import android.opengl.EGLContext;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;
import com.tencent.ttpic.openapi.config.MediaConfig;

/* compiled from: P */
/* loaded from: classes32.dex */
class SimpleGLThread$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ EGLContext f65100d;
    final /* synthetic */ t this$0;

    @Override // java.lang.Runnable
    public void run() {
        t.d(null, new EglCore(this.f65100d, 0));
        t.e(null, new OffscreenSurface(t.a(null), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT));
        t.c(null).makeCurrent();
    }
}
