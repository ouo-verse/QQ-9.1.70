package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCreateShareRsp {
    public GProShareInfo info = new GProShareInfo();
    public String templateData = "";
    public String platData = "";
    public GProBusiErr err = new GProBusiErr();

    public GProBusiErr getErr() {
        return this.err;
    }

    public GProShareInfo getInfo() {
        return this.info;
    }

    public String getPlatData() {
        return this.platData;
    }

    public String getTemplateData() {
        return this.templateData;
    }

    public String toString() {
        return "GProCreateShareRsp{info=" + this.info + ",templateData=" + this.templateData + ",platData=" + this.platData + ",err=" + this.err + ",}";
    }
}
