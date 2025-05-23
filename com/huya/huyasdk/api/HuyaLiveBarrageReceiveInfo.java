package com.huya.huyasdk.api;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuyaLiveBarrageReceiveInfo {
    public String content;
    public String fromAppName;
    public long presenterId;
    public String senderNick;
    public long senderUid;

    public HuyaLiveBarrageReceiveInfo(long j3, long j16, String str, String str2, String str3) {
        this.presenterId = j3;
        this.senderUid = j16;
        this.senderNick = str;
        this.content = str2;
        this.fromAppName = str3;
    }

    public String toString() {
        return "HuyaLiveBarrageReceiveInfo{presenterId=" + this.presenterId + ", senderUid=" + this.senderUid + ", senderNick='" + this.senderNick + "', content='" + this.content + "', fromAppName='" + this.fromAppName + "'}";
    }
}
