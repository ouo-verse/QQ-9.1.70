package com.tencent.oskplayer.proxy;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface VideoCancelListener {
    void onVideoCancelProceed(VideoRequest videoRequest, int i3);

    void onVideoCancelStart(VideoRequest videoRequest);

    void onVideoCancelSuccess(VideoRequest videoRequest);
}
