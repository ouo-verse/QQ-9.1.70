package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class YoloGameUserInfo {
    public String bizId;
    public int rank;
    public int result;
    public String uid;

    public YoloGameUserInfo() {
        this.uid = "";
        this.bizId = "";
    }

    public String getBizId() {
        return this.bizId;
    }

    public int getRank() {
        return this.rank;
    }

    public int getResult() {
        return this.result;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "YoloGameUserInfo{uid=" + this.uid + ",result=" + this.result + ",rank=" + this.rank + ",bizId=" + this.bizId + ",}";
    }

    public YoloGameUserInfo(String str, int i3, int i16, String str2) {
        this.uid = str;
        this.result = i3;
        this.rank = i16;
        this.bizId = str2;
    }
}
