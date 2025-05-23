package com.tencent.tav.quick.export;

import com.tencent.tav.coremedia.CMSampleBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoFrame {
    private long mFence;
    private CMSampleBuffer mSampleBuffer;

    public VideoFrame(CMSampleBuffer cMSampleBuffer, long j3) {
        this.mSampleBuffer = cMSampleBuffer;
        this.mFence = j3;
    }

    public long getFence() {
        return this.mFence;
    }

    public CMSampleBuffer getSampleBuffer() {
        return this.mSampleBuffer;
    }
}
