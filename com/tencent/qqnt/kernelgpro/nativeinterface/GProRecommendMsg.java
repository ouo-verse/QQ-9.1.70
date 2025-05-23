package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendMsg implements Serializable {
    public String avatar;
    public long msgSeq;
    public String nickName;
    public byte[] richText;
    long serialVersionUID;
    public long tinyid;

    public GProRecommendMsg() {
        this.serialVersionUID = 1L;
        this.nickName = "";
        this.avatar = "";
        this.richText = new byte[0];
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String getNickName() {
        return this.nickName;
    }

    public byte[] getRichText() {
        return this.richText;
    }

    public long getTinyid() {
        return this.tinyid;
    }

    public String toString() {
        return "GProRecommendMsg{tinyid=" + this.tinyid + ",nickName=" + this.nickName + ",avatar=" + this.avatar + ",msgSeq=" + this.msgSeq + ",richText=" + this.richText + ",}";
    }

    public GProRecommendMsg(long j3, String str, String str2, long j16, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.tinyid = j3;
        this.nickName = str;
        this.avatar = str2;
        this.msgSeq = j16;
        this.richText = bArr;
    }
}
