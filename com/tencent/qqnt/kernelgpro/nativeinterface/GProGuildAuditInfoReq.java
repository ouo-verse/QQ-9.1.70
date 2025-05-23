package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildAuditInfoReq {
    public ArrayList<GProGuildAuditBaseItem> auditList = new ArrayList<>();
    public int auditReqType;
    public long guildId;
    public int ignoreGeneralizationWords;

    public ArrayList<GProGuildAuditBaseItem> getAuditList() {
        return this.auditList;
    }

    public int getAuditReqType() {
        return this.auditReqType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getIgnoreGeneralizationWords() {
        return this.ignoreGeneralizationWords;
    }

    public String toString() {
        return "GProGuildAuditInfoReq{guildId=" + this.guildId + ",auditReqType=" + this.auditReqType + ",auditList=" + this.auditList + ",ignoreGeneralizationWords=" + this.ignoreGeneralizationWords + ",}";
    }
}
