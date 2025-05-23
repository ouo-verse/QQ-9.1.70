package com.tencent.qqlive.tvkplayer.api;

import android.graphics.SurfaceTexture;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSurfaceDestroyedInfo {

    @NonNull
    public View displayView;
    public long nativeObjectPtr;
    public long nativeWindowPtr;

    @NonNull
    public SurfaceTexture surfaceTexture;

    public TVKSurfaceDestroyedInfo(long j3, SurfaceTexture surfaceTexture, TextureView textureView) {
        this.nativeWindowPtr = j3;
        this.surfaceTexture = surfaceTexture;
        this.displayView = textureView;
    }

    public TVKSurfaceDestroyedInfo(long j3, SurfaceView surfaceView) {
        this.nativeObjectPtr = j3;
        this.displayView = surfaceView;
    }
}
