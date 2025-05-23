package com.tencent.mobileqq.ar.model;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import com.tencent.mobileqq.ar.ARRecord.g;
import com.tencent.mobileqq.ar.ARRenderModel.e;
import com.tencent.mobileqq.ar.ARRenderModel.f;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface d extends GLSurfaceView.Renderer {
    boolean A(GLSurfaceView gLSurfaceView, Context context);

    void B(long j3);

    boolean C();

    void D(com.tencent.mobileqq.ar.ARRenderModel.b bVar);

    void E(g gVar);

    void q();

    void r(int i3, Object obj);

    void requestRender();

    void s(int i3, SurfaceTexture surfaceTexture, int i16, int i17, int i18, int i19);

    boolean start();

    void stop();

    long t();

    boolean u(e eVar);

    void uninit();

    void v(com.tencent.mobileqq.ar.view.c cVar);

    boolean w(boolean z16, float f16, float f17);

    void x(long j3);

    void y(int i3, float[] fArr);

    void z(f fVar);
}
