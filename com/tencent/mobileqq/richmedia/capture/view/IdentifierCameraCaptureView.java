package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.hardware.Camera;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes18.dex */
public class IdentifierCameraCaptureView extends CameraCaptureView {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
    }

    public IdentifierCameraCaptureView(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        super.onDrawFrame(gl10);
    }

    @Override // com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView, com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.e
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        super.onPreviewFrame(bArr, camera2);
    }

    public IdentifierCameraCaptureView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setPreviewCallback(a aVar) {
    }
}
