package com.tencent.gamematrix.gmcg.webrtc;

import com.qzone.publish.business.model.UploadVideoObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum VideoCodecType {
    UNKNOWN("unknown"),
    VP8("vp8"),
    VP9("vp9"),
    H264("h264"),
    H265(UploadVideoObject.VODEO_FORMAT_H265);

    private final String mimeType;

    VideoCodecType(String str) {
        this.mimeType = str;
    }

    public String mimeType() {
        return this.mimeType;
    }
}
