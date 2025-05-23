package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProTag implements Serializable {
    public byte[] icon;
    public byte[] name;
    long serialVersionUID;

    public GProTag() {
        this.serialVersionUID = 1L;
        this.name = new byte[0];
        this.icon = new byte[0];
    }

    public byte[] getIcon() {
        return this.icon;
    }

    public byte[] getName() {
        return this.name;
    }

    public void setIcon(byte[] bArr) {
        this.icon = bArr;
    }

    public void setName(byte[] bArr) {
        this.name = bArr;
    }

    public String toString() {
        return "GProTag{name=" + this.name + ",icon=" + this.icon + ",}";
    }

    public GProTag(byte[] bArr, byte[] bArr2) {
        this.serialVersionUID = 1L;
        this.name = bArr;
        this.icon = bArr2;
    }
}
