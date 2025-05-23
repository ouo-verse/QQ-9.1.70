package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGuildEssenceSvrRsp implements Serializable {
    public int canModify;
    long serialVersionUID;
    public String tips;
    public GProUnifiedEssenceInfo unifiedEssenceInfo;
    public int visitorEdit;

    public GProGuildEssenceSvrRsp() {
        this.serialVersionUID = 1L;
        this.unifiedEssenceInfo = new GProUnifiedEssenceInfo();
        this.tips = "";
    }

    public int getCanModify() {
        return this.canModify;
    }

    public String getTips() {
        return this.tips;
    }

    public GProUnifiedEssenceInfo getUnifiedEssenceInfo() {
        return this.unifiedEssenceInfo;
    }

    public int getVisitorEdit() {
        return this.visitorEdit;
    }

    public String toString() {
        return "GProGuildEssenceSvrRsp{unifiedEssenceInfo=" + this.unifiedEssenceInfo + ",visitorEdit=" + this.visitorEdit + ",canModify=" + this.canModify + ",tips=" + this.tips + ",}";
    }

    public GProGuildEssenceSvrRsp(GProUnifiedEssenceInfo gProUnifiedEssenceInfo, int i3, int i16, String str) {
        this.serialVersionUID = 1L;
        new GProUnifiedEssenceInfo();
        this.unifiedEssenceInfo = gProUnifiedEssenceInfo;
        this.visitorEdit = i3;
        this.canModify = i16;
        this.tips = str;
    }
}
