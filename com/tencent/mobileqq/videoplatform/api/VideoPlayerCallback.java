package com.tencent.mobileqq.videoplatform.api;

import android.graphics.Bitmap;

/* loaded from: classes20.dex */
public interface VideoPlayerCallback {
    void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap);

    void onDownloadComplete(long j3);

    void onDownloadProgress(long j3, long j16);

    void onFirstFrameRendered(long j3);

    void onLoopBack(long j3, long j16);

    void onPlayError(long j3, int i3, int i16, int i17, String str);

    void onPlayProgress(long j3, long j16);

    void onStateChange(long j3, int i3);
}
