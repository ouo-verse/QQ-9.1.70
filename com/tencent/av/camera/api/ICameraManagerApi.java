package com.tencent.av.camera.api;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.avcore.camera.callback.b;
import com.tencent.avcore.camera.callback.c;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.Observer;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ICameraManagerApi extends QRouteApi, c {
    void addObserver(Observer observer);

    boolean closeCamera(long j3, boolean z16);

    void closeCamera2(long j3, boolean z16);

    void deleteObserver(Observer observer);

    int getCameraNum();

    Camera.Parameters getCameraParams();

    SurfaceTexture getSurfaceTextureForRender();

    boolean isCameraOpened(long j3);

    boolean isCameraOpening(long j3);

    boolean isFrontCamera();

    /* synthetic */ void onPreviewData(com.tencent.avcore.camera.data.c cVar);

    void openCamera(long j3);

    void openCamera2(long j3);

    void reopenCamera(String str, long j3, int i3, int i16);

    void reopenCamera2(long j3, int i3, int i16);

    void resetCamera();

    void rotateCamera();

    void saveCameraAngle();

    void setCameraListener(b bVar);

    void setCameraPara2(long j3, int i3);

    void setCameraSensorMode(boolean z16);

    void setCameraWithNewFps(long j3, int i3);

    void setRotation(int i3);

    void setSupportLandscape(boolean z16);

    void setUp(Context context);

    void switchCamera(long j3);

    void switchCamera2(long j3);
}
