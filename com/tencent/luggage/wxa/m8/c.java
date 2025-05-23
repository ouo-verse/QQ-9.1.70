package com.tencent.luggage.wxa.m8;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface c {
    com.tencent.luggage.wxa.z7.b a();

    String a(String str, int i3, com.tencent.luggage.wxa.z7.c cVar);

    void a(com.tencent.luggage.wxa.k8.c cVar);

    void a(com.tencent.luggage.wxa.z7.b bVar);

    void a(String str, int i3);

    void onPluginDestroy(String str, int i3);

    void onPluginReady(String str, int i3, SurfaceTexture surfaceTexture);

    void onPluginReadyForGPUProcess(String str, int i3, Surface surface);

    void onPluginScreenshotTaken(String str, int i3, Bitmap bitmap);

    void onPluginTouch(String str, int i3, MotionEvent motionEvent);
}
