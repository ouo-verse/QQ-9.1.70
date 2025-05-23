package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProBusinessData implements Serializable {
    public int businessType;
    long serialVersionUID = 1;
    public byte[] businessParam = new byte[0];

    public byte[] getBusinessParam() {
        return this.businessParam;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public String toString() {
        return "GProBusinessData{businessType=" + this.businessType + ",businessParam=" + this.businessParam + ",}";
    }
}
