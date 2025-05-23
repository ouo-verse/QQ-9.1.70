package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPItemCbData implements Serializable {
    public byte[] cbExtData;
    long serialVersionUID;
    public String statData;

    public GProMVPItemCbData() {
        this.serialVersionUID = 1L;
        this.statData = "";
        this.cbExtData = new byte[0];
    }

    public byte[] getCbExtData() {
        return this.cbExtData;
    }

    public String getStatData() {
        return this.statData;
    }

    public String toString() {
        return "GProMVPItemCbData{statData=" + this.statData + ",cbExtData=" + this.cbExtData + ",}";
    }

    public GProMVPItemCbData(String str, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.statData = str;
        this.cbExtData = bArr;
    }
}
