package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum CodecMimeType {
    VP8("video/x-vnd.on2.vp8"),
    VP9("video/x-vnd.on2.vp9"),
    H264("video/avc"),
    H265("video/hevc");

    private final String mimeType;

    CodecMimeType(String str) {
        this.mimeType = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String mimeType() {
        return this.mimeType;
    }
}
