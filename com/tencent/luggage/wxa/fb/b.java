package com.tencent.luggage.wxa.fb;

import android.graphics.SurfaceTexture;
import com.tencent.luggage.wxa.tn.w;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends a {
    public b(int i3, int i16) {
        super(0, 0, 0, 0, i3, i16);
    }

    @Override // com.tencent.luggage.wxa.fb.a, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        try {
            com.tencent.luggage.wxa.ib.a.f129678a.a(true);
            SurfaceTexture j3 = j();
            if (j3 != null) {
                j3.updateTexImage();
            }
        } catch (Exception e16) {
            w.a("MicroMsg.Media.AbsSurfaceRenderer", e16, "updateTexImage error", new Object[0]);
        }
        if (d()) {
            d(false);
        } else {
            super.onDrawFrame(gl10);
        }
    }
}
