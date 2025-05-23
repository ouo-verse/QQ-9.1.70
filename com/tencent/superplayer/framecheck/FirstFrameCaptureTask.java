package com.tencent.superplayer.framecheck;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FirstFrameCaptureTask extends VideoFrameCaptureTask {
    public FirstFrameCaptureTask(IFrameCaptureTaskRunner iFrameCaptureTaskRunner) {
        super(iFrameCaptureTaskRunner);
    }

    @Override // com.tencent.superplayer.framecheck.VideoFrameCaptureTask
    public int getTaskDelay() {
        return 0;
    }
}
