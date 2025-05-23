package com.tencent.mobileqq.videocodec.mediacodec.recorder;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface c {
    void onEncodeError(int i3, Throwable th5);

    void onEncodeFinish(String str);

    void onEncodeFrame();

    void onEncodeStart();
}
