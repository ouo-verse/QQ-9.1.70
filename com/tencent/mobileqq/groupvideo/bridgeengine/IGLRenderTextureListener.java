package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface IGLRenderTextureListener extends IBaseService {
    public static final int MSG_FLUSH = 1;
    public static final int MSG_INFO_CHANGE = 4;
    public static final int MSG_RENDER = 0;
    public static final int MSG_RESET = 2;
    public static final int MSG_SHOW = 3;

    void markForPerf(int i3);

    void nativeFrameDataUpdate();

    void onFaceFeatureUpdate(byte[] bArr);

    void onRenderFlush();

    void onRenderFrame();

    void onRenderInfoNotify(int i3, int i16, int i17, int i18);

    void onRenderReset();
}
