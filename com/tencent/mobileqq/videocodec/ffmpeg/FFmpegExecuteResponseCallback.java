package com.tencent.mobileqq.videocodec.ffmpeg;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface FFmpegExecuteResponseCallback {
    void onFailure(String str);

    void onFinish(boolean z16);

    void onProgress(String str);

    void onStart();

    void onSuccess(String str);
}
