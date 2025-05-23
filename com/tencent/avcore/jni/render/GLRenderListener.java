package com.tencent.avcore.jni.render;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface GLRenderListener {
    void onFaceFeatureUpdate(byte[] bArr);

    void onRenderFlush();

    void onRenderFrame();

    void onRenderInfoNotify(int i3, int i16, int i17, int i18);

    void onRenderReset();
}
