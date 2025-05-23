package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProMsgHighlight {
    public String keyWord = "";
    public long offset;

    public String getKeyWord() {
        return this.keyWord;
    }

    public long getOffset() {
        return this.offset;
    }

    public String toString() {
        return "GProMsgHighlight{offset=" + this.offset + ",keyWord=" + this.keyWord + ",}";
    }
}
