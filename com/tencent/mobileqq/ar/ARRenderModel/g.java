package com.tencent.mobileqq.ar.ARRenderModel;

import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class g {
    public static a a(c cVar, e eVar, GLSurfaceView gLSurfaceView) {
        if (eVar == null) {
            return null;
        }
        int i3 = eVar.f197226b;
        if (i3 != 0) {
            if (i3 != 8) {
                if (i3 != 100) {
                    if (i3 != 2 && i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return null;
                            }
                            MultiFragmentAnimRenderable multiFragmentAnimRenderable = new MultiFragmentAnimRenderable(cVar, (o) eVar);
                            QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_MULTI_ANIM here" + eVar.toString());
                            return multiFragmentAnimRenderable;
                        }
                        OnlineVideoARRenderable onlineVideoARRenderable = new OnlineVideoARRenderable(cVar, (q) eVar);
                        QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_ONLINE_VIDEO here" + eVar.toString());
                        return onlineVideoARRenderable;
                    }
                    NormalVideoARRenderable normalVideoARRenderable = new NormalVideoARRenderable(cVar, (p) eVar);
                    QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + eVar.toString());
                    return normalVideoARRenderable;
                }
                Interactive3DRenderable interactive3DRenderable = new Interactive3DRenderable(cVar, (n) eVar, gLSurfaceView);
                QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_BINHAI_3D here" + eVar.toString());
                return interactive3DRenderable;
            }
            return new ARTransferPromotionRenderable(cVar, (i) eVar);
        }
        GeneralAR3DRenderable generalAR3DRenderable = new GeneralAR3DRenderable(cVar, (k) eVar);
        QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + eVar.toString());
        return generalAR3DRenderable;
    }
}
