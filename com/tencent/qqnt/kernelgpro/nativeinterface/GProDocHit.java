package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDocHit {
    public GProRelation relation = GProRelation.values()[0];
    public long value;

    public GProRelation getRelation() {
        return this.relation;
    }

    public long getValue() {
        return this.value;
    }

    public String toString() {
        return "GProDocHit{value=" + this.value + ",relation=" + this.relation + ",}";
    }
}
