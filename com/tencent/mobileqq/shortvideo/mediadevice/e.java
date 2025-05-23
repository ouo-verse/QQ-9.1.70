package com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.TextureView;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes18.dex */
public class e extends PreviewContext implements TextureView.SurfaceTextureListener, CameraProxy.e {
    public e(CameraProxy cameraProxy, int i3, int i16) {
        super(cameraProxy, i3, i16);
    }

    @Override // com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.e
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        getPreviewFrame(bArr, camera2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        this.mCamera.i();
        this.mCamera.h(0, i3, i16);
        this.mCamera.m(surfaceTexture, null, this, true);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        CameraProxy cameraProxy = this.mCamera;
        if (cameraProxy != null) {
            cameraProxy.n();
            this.mCamera.l(true);
            if (this.mActivtiyDestory) {
                this.mCamera = null;
            }
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
    }
}
