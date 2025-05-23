package com.tencent.map.lib;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface JNIInterfaceCallback {
    Object callback(int i3, int i16, String str, byte[] bArr, Object obj);

    int callbackGetGLContext();

    boolean onJniCallbackRenderMapFrame(int i3);

    void onMapCameraChangeStopped();

    void onMapCameraChanged();

    void onMapLoaded();

    void onMarkerCollisionCallback(int[] iArr, int[] iArr2);

    void onVisualLayerClickResult(float f16, float f17, long j3, String str, String str2);
}
