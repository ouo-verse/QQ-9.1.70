package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends PreviewContext implements CameraProxy.e, SurfaceHolder.Callback {
    public d(CameraProxy cameraProxy, int i3, int i16) {
        super(cameraProxy, i3, i16);
    }

    @Override // com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.e
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        getPreviewFrame(bArr, camera2);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        this.mCamera.h(i3, i16, i17);
        this.mCamera.m(null, surfaceHolder, this, true);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mCamera.i();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        CameraProxy cameraProxy = this.mCamera;
        if (cameraProxy != null) {
            cameraProxy.n();
            this.mCamera.l(true);
            if (this.mActivtiyDestory) {
                this.mCamera = null;
            }
        }
    }
}
