package com.tencent.qqnt.kernelgpro.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetLabelGuildsReq {
    public String code;
    public String labelName;

    public GetLabelGuildsReq() {
        this.code = "";
        this.labelName = "";
    }

    public String getCode() {
        return this.code;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String toString() {
        return "GetLabelGuildsReq{code=" + this.code + ",labelName=" + this.labelName + ",}";
    }

    public GetLabelGuildsReq(String str, String str2) {
        this.code = str;
        this.labelName = str2;
    }
}
