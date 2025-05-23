package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StatusBusinessInfo {
    public CustomStatus customStatus;
    public byte[] buf = new byte[0];
    public SynchVideoBizInfo videoBizInfo = new SynchVideoBizInfo();
    public VideoInfo videoInfo = new VideoInfo();

    public byte[] getBuf() {
        return this.buf;
    }

    public CustomStatus getCustomStatus() {
        return this.customStatus;
    }

    public SynchVideoBizInfo getVideoBizInfo() {
        return this.videoBizInfo;
    }

    public VideoInfo getVideoInfo() {
        return this.videoInfo;
    }
}
