package com.tencent.avcore.jni.render;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IGLRenderTexture extends GLRenderListener {
    public static final int MSG_FLUSH = 1;
    public static final int MSG_INFO_CHANGE = 4;
    public static final int MSG_RENDER = 0;
    public static final int MSG_RESET = 2;
    public static final int MSG_SHOW = 3;

    void markForPerf(int i3);

    void nativeFrameDataUpdate();
}
