package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class LocalAVRecordElement {
    public String avAbstract;
    public Integer extraType;
    public boolean hasRead;
    public long sendTime;
    public int sendType;
    public String senderUid;
    public long senderUin;
    public String text;
    public long time;
    public int type;

    public LocalAVRecordElement() {
        this.senderUid = "";
        this.text = "";
        this.avAbstract = "";
    }

    public String getAvAbstract() {
        return this.avAbstract;
    }

    public Integer getExtraType() {
        return this.extraType;
    }

    public boolean getHasRead() {
        return this.hasRead;
    }

    public long getSendTime() {
        return this.sendTime;
    }

    public int getSendType() {
        return this.sendType;
    }

    public String getSenderUid() {
        return this.senderUid;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    public String getText() {
        return this.text;
    }

    public long getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "LocalAVRecordElement{type=" + this.type + ",time=" + this.time + ",senderUid=" + this.senderUid + ",sendType=" + this.sendType + ",text=" + this.text + ",avAbstract=" + this.avAbstract + ",hasRead=" + this.hasRead + ",sendTime=" + this.sendTime + ",extraType=" + this.extraType + ",senderUin=" + this.senderUin + ",}";
    }

    public LocalAVRecordElement(int i3, long j3, String str, int i16, String str2, String str3, boolean z16, long j16, Integer num) {
        this.type = i3;
        this.time = j3;
        this.senderUid = str;
        this.sendType = i16;
        this.text = str2;
        this.avAbstract = str3;
        this.hasRead = z16;
        this.sendTime = j16;
        this.extraType = num;
    }
}
