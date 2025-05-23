package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMsgSummary implements Serializable {
    public long msgSeq;
    public long tinyId;
    long serialVersionUID = 1;
    public String avatar = "";
    public byte[] richText = new byte[0];

    public String getAvatar() {
        return this.avatar;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public byte[] getRichText() {
        return this.richText;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProMsgSummary{tinyId=" + this.tinyId + ",avatar=" + this.avatar + ",msgSeq=" + this.msgSeq + ",richText=" + this.richText + ",}";
    }
}
