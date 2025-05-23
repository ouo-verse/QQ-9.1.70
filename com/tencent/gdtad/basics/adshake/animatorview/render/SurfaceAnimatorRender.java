package com.tencent.gdtad.basics.adshake.animatorview.render;

import android.graphics.Canvas;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* compiled from: P */
/* loaded from: classes6.dex */
public class SurfaceAnimatorRender extends BaseAnimatorRender<SurfaceView> {
    private static final String TAG = "SurfaceAnimatorRender";
    private final SurfaceHolder mHolder;

    public SurfaceAnimatorRender(SurfaceView surfaceView) {
        super(surfaceView);
        this.mHolder = surfaceView.getHolder();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.render.BaseAnimatorRender
    protected Canvas lockCanvas() {
        SurfaceHolder surfaceHolder = this.mHolder;
        Canvas canvas = null;
        if (surfaceHolder == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            canvas = surfaceHolder.lockHardwareCanvas();
        }
        if (canvas == null) {
            return this.mHolder.lockCanvas();
        }
        return canvas;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.render.BaseAnimatorRender
    protected void unlockCanvasAndPost(Canvas canvas) {
        SurfaceHolder surfaceHolder = this.mHolder;
        if (surfaceHolder == null) {
            return;
        }
        surfaceHolder.unlockCanvasAndPost(canvas);
    }
}
