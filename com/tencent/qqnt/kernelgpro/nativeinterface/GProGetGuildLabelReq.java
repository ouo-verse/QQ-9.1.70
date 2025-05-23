package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetGuildLabelReq {
    public String code;

    public GProGetGuildLabelReq() {
        this.code = "";
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String toString() {
        return "GProGetGuildLabelReq{code=" + this.code + ",}";
    }

    public GProGetGuildLabelReq(String str) {
        this.code = str;
    }
}
