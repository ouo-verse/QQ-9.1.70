package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProItemCbData implements Serializable {
    public byte[] cbExtData;
    long serialVersionUID;
    public String statData;

    public GProItemCbData() {
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

    public void setCbExtData(byte[] bArr) {
        this.cbExtData = bArr;
    }

    public void setStatData(String str) {
        this.statData = str;
    }

    public String toString() {
        return "GProItemCbData{statData=" + this.statData + ",cbExtData=" + this.cbExtData + ",}";
    }

    public GProItemCbData(String str, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.statData = str;
        this.cbExtData = bArr;
    }
}
