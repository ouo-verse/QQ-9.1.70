package com.tencent.av.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.avcore.camera.AVCameraMgr;
import com.tencent.avcore.camera.observe.CameraObserver;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVCameraManagerImpl implements ICameraManagerApi {
    private static final String TAG = "AVCameraManagerImpl";
    private volatile AVCameraMgr mAVCamera;

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void addObserver(Observer observer) {
        if (this.mAVCamera == null) {
            com.tencent.xaction.log.b.a(TAG, 1, "addObserver null camera");
        } else {
            this.mAVCamera.n((CameraObserver) observer);
        }
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public boolean closeCamera(long j3, boolean z16) {
        this.mAVCamera.M(z16);
        return false;
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void deleteObserver(Observer observer) {
        this.mAVCamera.H((CameraObserver) observer);
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public int getCameraNum() {
        return this.mAVCamera.y().f77431d;
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public Camera.Parameters getCameraParams() {
        return this.mAVCamera.x();
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public SurfaceTexture getSurfaceTextureForRender() {
        if (this.mAVCamera == null) {
            return null;
        }
        return this.mAVCamera.z();
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public boolean isCameraOpened(long j3) {
        return this.mAVCamera.y().f77429b;
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public boolean isCameraOpening(long j3) {
        return this.mAVCamera.y().f77430c;
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public boolean isFrontCamera() {
        return this.mAVCamera.y().f77428a;
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void openCamera(long j3) {
        if (!isCameraOpening(j3) && !isCameraOpened(j3)) {
            this.mAVCamera.J(com.tencent.avcore.camera.b.f77378u, com.tencent.avcore.camera.b.f77379v, com.tencent.avcore.camera.b.f77383z);
            return;
        }
        com.tencent.xaction.log.b.a(TAG, 1, "openCamera FAILED for camera is opening or opened.");
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void reopenCamera(String str, long j3, int i3, int i16) {
        this.mAVCamera.o(i3, i16, -1);
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void reopenCamera2(long j3, int i3, int i16) {
        this.mAVCamera.o(i3, i16, -1);
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void resetCamera() {
        this.mAVCamera.t();
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void rotateCamera() {
        this.mAVCamera.rotateCamera();
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void saveCameraAngle() {
        this.mAVCamera.saveCameraAngle();
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void setCameraListener(com.tencent.avcore.camera.callback.b bVar) {
        this.mAVCamera.I(bVar);
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void setCameraSensorMode(boolean z16) {
        this.mAVCamera.v(z16);
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void setCameraWithNewFps(long j3, int i3) {
        if (this.mAVCamera != null) {
            this.mAVCamera.o(com.tencent.avcore.camera.b.f77378u, com.tencent.avcore.camera.b.f77379v, i3);
        }
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void setRotation(int i3) {
        this.mAVCamera.setRotation(i3);
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void setSupportLandscape(boolean z16) {
        this.mAVCamera.u(z16);
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void setUp(Context context) {
        this.mAVCamera = (AVCameraMgr) com.tencent.avcore.camera.a.a(context, new ou.a());
        this.mAVCamera.D(1);
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    public void switchCamera(long j3) {
        this.mAVCamera.P();
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi, com.tencent.avcore.camera.callback.c
    @Deprecated
    public void onPreviewData(com.tencent.avcore.camera.data.c cVar) {
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    @Deprecated
    public void openCamera2(long j3) {
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    @Deprecated
    public void switchCamera2(long j3) {
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    @Deprecated
    public void closeCamera2(long j3, boolean z16) {
    }

    @Override // com.tencent.av.camera.api.ICameraManagerApi
    @Deprecated
    public void setCameraPara2(long j3, int i3) {
    }
}
