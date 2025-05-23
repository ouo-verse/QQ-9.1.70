package com.tencent.tav.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes26.dex */
public class PlayerLayer {
    private boolean needReleaseSurface;

    @Nullable
    private Player player;

    @NonNull
    Surface surface;
    int surfaceHeight;
    int surfaceWidth;

    public PlayerLayer(@NonNull Surface surface, int i3, int i16) {
        this.needReleaseSurface = false;
        this.surface = surface;
        this.surfaceWidth = i3;
        this.surfaceHeight = i16;
    }

    @Nullable
    public Player getPlayer() {
        return this.player;
    }

    @NonNull
    public Surface getSurface() {
        return this.surface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (this.needReleaseSurface) {
            this.surface.release();
        }
    }

    public void setPlayer(@Nullable Player player) {
        this.player = player;
        if (player != null) {
            player.bindLayer(this);
        }
    }

    public PlayerLayer(@NonNull SurfaceTexture surfaceTexture, int i3, int i16) {
        this.needReleaseSurface = false;
        this.surface = new Surface(surfaceTexture);
        this.needReleaseSurface = true;
        this.surfaceWidth = i3;
        this.surfaceHeight = i16;
    }
}
