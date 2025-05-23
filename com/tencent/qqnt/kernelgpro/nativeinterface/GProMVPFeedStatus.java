package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProMVPFeedStatus {
    public boolean isDeleted;
    public boolean isInReview;
    public boolean isSecBeat;
    public boolean isVedioTranscoding;

    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    public boolean getIsInReview() {
        return this.isInReview;
    }

    public boolean getIsSecBeat() {
        return this.isSecBeat;
    }

    public boolean getIsVedioTranscoding() {
        return this.isVedioTranscoding;
    }

    public String toString() {
        return "GProMVPFeedStatus{isSecBeat=" + this.isSecBeat + ",isDeleted=" + this.isDeleted + ",isVedioTranscoding=" + this.isVedioTranscoding + ",isInReview=" + this.isInReview + ",}";
    }
}
