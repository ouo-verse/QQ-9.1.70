package com.tencent.qqmini.miniapp.widget;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.qqmini.miniapp.widget.camera.CameraCallBack;
import com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.CoverView;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CoverCameraView extends CoverView {
    private MiniAppCamera cameraView;

    public CoverCameraView(@NonNull IMiniAppContext iMiniAppContext) {
        super(iMiniAppContext.getAttachActivity());
    }

    public void closeCamera() {
        this.cameraView.closeCamera();
    }

    public void openCamera(String str) {
        this.cameraView.openCamera(str);
    }

    public void setCameraHeight(int i3) {
        MiniAppCamera.cameraHeight = i3;
    }

    public void setCameraId(int i3) {
        this.cameraView.setCameraId(i3);
    }

    public void setCameraSurfaceCallBack(CameraCallBack cameraCallBack) {
        this.cameraView.setCameraSurfaceCallBack(cameraCallBack);
    }

    public void setCameraWidth(int i3) {
        MiniAppCamera.cameraWidth = i3;
    }

    public void setFlashMode(String str) {
        this.cameraView.setFlashMode(str);
    }

    public void setMode(String str) {
        this.cameraView.setMode(str);
    }

    public void setWebviewId(int i3) {
        this.cameraView.setWebviewId(i3);
    }

    public void startRecord(RequestEvent requestEvent) {
        this.cameraView.startRecord(requestEvent);
    }

    public void stopRecord(RequestEvent requestEvent) {
        this.cameraView.stopRecord(requestEvent);
    }

    public void switchCamera(boolean z16, String str) {
        this.cameraView.switchCamera(z16, str);
    }

    public void takePhoto(RequestEvent requestEvent, String str) {
        this.cameraView.takePhoto(requestEvent, str);
    }

    public CoverCameraView(@NonNull IMiniAppContext iMiniAppContext, IJsService iJsService) {
        super(iMiniAppContext.getAttachActivity());
        this.cameraView = new MiniAppCamera(iMiniAppContext, iJsService);
        addView(this.cameraView, new FrameLayout.LayoutParams(-1, -1));
    }
}
