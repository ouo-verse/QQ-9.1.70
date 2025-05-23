package com.tencent.xweb;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;

/* loaded from: classes27.dex */
public interface ExtendPluginClient {
    void onPluginDestroy(String str, int i3);

    void onPluginManagerDestroy();

    void onPluginReady(String str, int i3, SurfaceTexture surfaceTexture);

    void onPluginReadyForGPUProcess(String str, int i3, Surface surface);

    void onPluginScreenshotTaken(String str, int i3, Bitmap bitmap);

    void onPluginSizeChanged(String str, int i3, int i16, int i17, SurfaceTexture surfaceTexture);

    void onPluginSizeChangedForGPUProcess(String str, int i3, int i16, int i17, Surface surface);

    void onPluginTouch(String str, int i3, MotionEvent motionEvent);
}
