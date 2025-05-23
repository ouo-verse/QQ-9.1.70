package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum GmCgClientType {
    WEBRTC_SESSION_INVALID(0),
    WEBRTC_SESSION_TV_MINIPROGRAM(1),
    WEBRTC_SESSION_TV(2),
    WEBRTC_SESSION_ANDROID_APP(3),
    WEBRTC_SESSION_PCWEB(4),
    WEBRTC_SESSION_H5(5),
    WEBRTC_SESSION_QQ_MINIPROGRAM(6),
    WEBRTC_SESSION_WECHAT_MINIGAME(7);

    private final int mValue;

    GmCgClientType(int i3) {
        this.mValue = i3;
    }

    public int getValue() {
        return this.mValue;
    }
}
