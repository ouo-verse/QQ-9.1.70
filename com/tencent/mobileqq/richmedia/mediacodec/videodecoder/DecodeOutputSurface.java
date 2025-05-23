package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes18.dex */
public class DecodeOutputSurface {
    public Surface surface;
    public SurfaceTexture surfaceTexture;
    public int textureId;

    public DecodeOutputSurface(int i3, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.textureId = i3;
        SurfaceTexture surfaceTexture = new SurfaceTexture(i3);
        this.surfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
        this.surface = new Surface(this.surfaceTexture);
    }
}
