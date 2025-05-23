package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProOperation {
    public String opData = "";
    public long opType;

    public String getOpData() {
        return this.opData;
    }

    public long getOpType() {
        return this.opType;
    }

    public String toString() {
        return "GProOperation{opType=" + this.opType + ",opData=" + this.opData + ",}";
    }
}
