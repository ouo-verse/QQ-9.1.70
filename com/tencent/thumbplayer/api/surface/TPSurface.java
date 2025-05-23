package com.tencent.thumbplayer.api.surface;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* loaded from: classes26.dex */
public final class TPSurface extends Surface {
    private ITPSurfaceListener mPlayerSurfaceListener;

    public TPSurface(SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        this.mPlayerSurfaceListener = null;
    }

    @Override // android.view.Surface
    protected void finalize() throws Throwable {
        super.release();
        super.finalize();
    }

    public void setSurfaceListener(ITPSurfaceListener iTPSurfaceListener) {
        this.mPlayerSurfaceListener = iTPSurfaceListener;
    }
}
