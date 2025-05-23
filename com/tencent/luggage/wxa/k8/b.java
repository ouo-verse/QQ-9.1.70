package com.tencent.luggage.wxa.k8;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface b {
    String handleJsApi(com.tencent.luggage.wxa.z7.c cVar);

    void handlePluginDestroy();

    void handlePluginReady(SurfaceTexture surfaceTexture);

    void handlePluginReadyForGPUProcess(Surface surface);

    void handlePluginScreenshotTaken(Bitmap bitmap);

    void handlePluginTouch(MotionEvent motionEvent);

    boolean isPluginReady(com.tencent.luggage.wxa.z7.c cVar);

    void setId(int i3);

    void setPluginClientProxy(com.tencent.luggage.wxa.m8.c cVar);

    void setType(String str);
}
