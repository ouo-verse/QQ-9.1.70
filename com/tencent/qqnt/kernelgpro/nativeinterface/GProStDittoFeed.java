package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStDittoFeed {
    public byte[] dittoData = new byte[0];
    public byte[] dittoDataNew = new byte[0];
    public int dittoId;
    public int dittoPatternId;

    public byte[] getDittoData() {
        return this.dittoData;
    }

    public byte[] getDittoDataNew() {
        return this.dittoDataNew;
    }

    public int getDittoId() {
        return this.dittoId;
    }

    public int getDittoPatternId() {
        return this.dittoPatternId;
    }

    public String toString() {
        return "GProStDittoFeed{dittoId=" + this.dittoId + ",dittoPatternId=" + this.dittoPatternId + ",dittoData=" + this.dittoData + ",dittoDataNew=" + this.dittoDataNew + ",}";
    }
}
