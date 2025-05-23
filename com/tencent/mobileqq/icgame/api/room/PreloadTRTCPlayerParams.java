package com.tencent.mobileqq.icgame.api.room;

/* loaded from: classes15.dex */
public class PreloadTRTCPlayerParams {
    public static final String KEY_ANCHOR_ID = "anchorid";
    public static final String KEY_FLV_URL = "flv_url";
    public static final String KEY_SIG = "sig";
    public static final String KEY_STREAM_ID = "streamid";
    public static final String KEY_STREAM_TYPE = "streamtype";
    public String trtcSig = "";
    public String streamId = "";
    public String anchorId = "";

    public void copyFrom(PreloadTRTCPlayerParams preloadTRTCPlayerParams) {
        if (preloadTRTCPlayerParams == null) {
            return;
        }
        this.trtcSig = preloadTRTCPlayerParams.trtcSig;
        this.streamId = preloadTRTCPlayerParams.streamId;
        this.anchorId = preloadTRTCPlayerParams.anchorId;
    }

    public String toString() {
        return "PreloadTRTCPlayerParams{+ trtcSig='" + this.trtcSig + "', + streamId='" + this.streamId + "', + anchorId='" + this.anchorId + "'}";
    }
}
