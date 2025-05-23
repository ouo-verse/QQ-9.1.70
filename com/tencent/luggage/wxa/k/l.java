package com.tencent.luggage.wxa.k;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import com.tencent.mm.plugin.mmsight.model.MMSightCameraFrameDataCallback;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l extends o {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(SurfaceTexture surfaceTexture);
    }

    public abstract void a(a aVar);

    public abstract void a(com.tencent.luggage.wxa.kb.a aVar);

    public abstract EGLContext j();

    public abstract MMSightCameraFrameDataCallback k();

    public abstract void l();

    public abstract void m();
}
