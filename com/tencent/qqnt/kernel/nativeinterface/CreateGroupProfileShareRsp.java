package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class CreateGroupProfileShareRsp {
    public GroupProfileShareInfo info = new GroupProfileShareInfo();
    public String templateData = "";
    public String platData = "";
    public GroupProfileShareBusiErr err = new GroupProfileShareBusiErr();

    public GroupProfileShareBusiErr getErr() {
        return this.err;
    }

    public GroupProfileShareInfo getInfo() {
        return this.info;
    }

    public String getPlatData() {
        return this.platData;
    }

    public String getTemplateData() {
        return this.templateData;
    }

    public String toString() {
        return "CreateGroupProfileShareRsp{info=" + this.info + ",templateData=" + this.templateData + ",platData=" + this.platData + ",err=" + this.err + ",}";
    }
}
