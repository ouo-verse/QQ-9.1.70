package com.tencent.thumbplayer.core.codec.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.NonNull;

/* loaded from: classes26.dex */
public final class PreloadSurface extends Surface {

    @NonNull
    private final SurfaceTexture mSurfaceTexture;

    public PreloadSurface(@NonNull SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    @NonNull
    public final SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }
}
