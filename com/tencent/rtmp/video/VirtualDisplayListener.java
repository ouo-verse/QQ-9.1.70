package com.tencent.rtmp.video;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface VirtualDisplayListener {
    void onCaptureError();

    void onStartFinish(boolean z16, boolean z17);

    void onVirtualDisplayCreate(VirtualDisplayWrapper virtualDisplayWrapper);
}
