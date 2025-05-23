package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildAuditInfo implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<GProGuildAuditBaseItem> auditContentList = new ArrayList<>();

    public ArrayList<GProGuildAuditBaseItem> getAuditContentList() {
        return this.auditContentList;
    }

    public String toString() {
        return "GProGuildAuditInfo{auditContentList=" + this.auditContentList + ",}";
    }
}
