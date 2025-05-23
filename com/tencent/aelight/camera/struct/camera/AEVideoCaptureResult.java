package com.tencent.aelight.camera.struct.camera;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEVideoCaptureResult extends BaseVideoCaptureResult {
    public int arkCoverStartFrame = 0;
    public long finishTimeMs;
    public long startTimeMs;

    public long getVideoCaptureLength() {
        return this.finishTimeMs - this.startTimeMs;
    }
}
