package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProCmd0x10b4RspExtendData implements Serializable {
    public int code;
    long serialVersionUID = 1;

    public GProCmd0x10b4RspExtendData() {
    }

    public int getCode() {
        return this.code;
    }

    public String toString() {
        return "GProCmd0x10b4RspExtendData{code=" + this.code + ",}";
    }

    public GProCmd0x10b4RspExtendData(int i3) {
        this.code = i3;
    }
}
