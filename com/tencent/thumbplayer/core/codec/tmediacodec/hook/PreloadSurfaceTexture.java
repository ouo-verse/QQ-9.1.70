package com.tencent.thumbplayer.core.codec.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import androidx.annotation.Nullable;

/* loaded from: classes26.dex */
public final class PreloadSurfaceTexture extends SurfaceTexture {

    @Nullable
    private ActionCallback mActionCallback;

    /* loaded from: classes26.dex */
    public interface ActionCallback {
        void onReleased();
    }

    public PreloadSurfaceTexture(int i3) {
        super(i3);
    }

    @Override // android.graphics.SurfaceTexture
    public void release() {
        super.release();
        ActionCallback actionCallback = this.mActionCallback;
        if (actionCallback != null) {
            actionCallback.onReleased();
        }
    }

    public final void setActionCallback(@Nullable ActionCallback actionCallback) {
        this.mActionCallback = actionCallback;
    }
}
