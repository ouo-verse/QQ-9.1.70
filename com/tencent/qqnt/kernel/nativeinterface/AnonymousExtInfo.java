package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AnonymousExtInfo {
    public int anonymousFlag;
    public byte[] anonymousId;
    public String anonymousNick;
    public long bubbleId;
    public long expireTime;
    public long headPicIndex;
    public String rankColor;

    public AnonymousExtInfo() {
        this.anonymousId = new byte[0];
        this.anonymousNick = "";
        this.rankColor = "";
    }

    public int getAnonymousFlag() {
        return this.anonymousFlag;
    }

    public byte[] getAnonymousId() {
        return this.anonymousId;
    }

    public String getAnonymousNick() {
        return this.anonymousNick;
    }

    public long getBubbleId() {
        return this.bubbleId;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public long getHeadPicIndex() {
        return this.headPicIndex;
    }

    public String getRankColor() {
        return this.rankColor;
    }

    public String toString() {
        return "AnonymousExtInfo{anonymousFlag=" + this.anonymousFlag + ",anonymousId=" + this.anonymousId + ",anonymousNick=" + this.anonymousNick + ",headPicIndex=" + this.headPicIndex + ",expireTime=" + this.expireTime + ",bubbleId=" + this.bubbleId + ",rankColor=" + this.rankColor + ",}";
    }

    public AnonymousExtInfo(int i3, byte[] bArr, String str, long j3, long j16, long j17, String str2) {
        this.anonymousFlag = i3;
        this.anonymousId = bArr;
        this.anonymousNick = str;
        this.headPicIndex = j3;
        this.expireTime = j16;
        this.bubbleId = j17;
        this.rankColor = str2;
    }
}
