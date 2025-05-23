package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class EssenceElement implements Serializable {
    public int isSetEssence;
    public long msgSeq;
    long serialVersionUID = 1;
    public long tinyId;

    public EssenceElement() {
    }

    public int getIsSetEssence() {
        return this.isSetEssence;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "EssenceElement{tinyId=" + this.tinyId + ",msgSeq=" + this.msgSeq + ",isSetEssence=" + this.isSetEssence + ",}";
    }

    public EssenceElement(long j3, long j16, int i3) {
        this.tinyId = j3;
        this.msgSeq = j16;
        this.isSetEssence = i3;
    }
}
