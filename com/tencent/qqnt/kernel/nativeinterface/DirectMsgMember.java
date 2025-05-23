package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DirectMsgMember {
    public String memberName;
    public int memberType;
    public int msgNotifyType;
    public String nickName;
    public long srcGuildId;
    public String srcGuildName;
    public long tinyId;

    public DirectMsgMember() {
        this.srcGuildName = "";
        this.nickName = "";
        this.memberName = "";
    }

    public String getMemberName() {
        return this.memberName;
    }

    public int getMemberType() {
        return this.memberType;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public String getNickName() {
        return this.nickName;
    }

    public long getSrcGuildId() {
        return this.srcGuildId;
    }

    public String getSrcGuildName() {
        return this.srcGuildName;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "DirectMsgMember{tinyId=" + this.tinyId + ",srcGuildId=" + this.srcGuildId + ",srcGuildName=" + this.srcGuildName + ",nickName=" + this.nickName + ",memberName=" + this.memberName + ",msgNotifyType=" + this.msgNotifyType + ",memberType=" + this.memberType + ",}";
    }

    public DirectMsgMember(long j3, long j16, String str, String str2, String str3, int i3, int i16) {
        this.tinyId = j3;
        this.srcGuildId = j16;
        this.srcGuildName = str;
        this.nickName = str2;
        this.memberName = str3;
        this.msgNotifyType = i3;
        this.memberType = i16;
    }
}
