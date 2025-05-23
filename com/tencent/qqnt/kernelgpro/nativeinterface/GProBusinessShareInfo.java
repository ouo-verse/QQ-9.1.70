package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProBusinessShareInfo {
    public byte[] businessTransData = new byte[0];
    public int businessType;

    public byte[] getBusinessTransData() {
        return this.businessTransData;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public String toString() {
        return "GProBusinessShareInfo{businessType=" + this.businessType + ",businessTransData=" + this.businessTransData + ",}";
    }
}
