package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
public class IceCandidate {
    public final String sdp;
    public final int sdpMLineIndex;
    public final String sdpMid;
    public final String serverUrl;

    public IceCandidate(String str, int i3, String str2) {
        this.sdpMid = str;
        this.sdpMLineIndex = i3;
        this.sdp = str2;
        this.serverUrl = "";
    }

    @CalledByNative
    String getSdp() {
        return this.sdp;
    }

    @CalledByNative
    String getSdpMid() {
        return this.sdpMid;
    }

    public String toString() {
        return this.sdpMid + ":" + this.sdpMLineIndex + ":" + this.sdp + ":" + this.serverUrl;
    }

    @CalledByNative
    IceCandidate(String str, int i3, String str2, String str3) {
        this.sdpMid = str;
        this.sdpMLineIndex = i3;
        this.sdp = str2;
        this.serverUrl = str3;
    }
}
