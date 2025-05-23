package com.tencent.mobileqq.apollo.view.opengl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface k {
    void onDrawFrame(GL10 gl10);

    void onSurfaceChanged(GL10 gl10, int i3, int i16);

    void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
}
