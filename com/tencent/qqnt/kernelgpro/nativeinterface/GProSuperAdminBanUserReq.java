package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSuperAdminBanUserReq {
    public int sourceId;
    public ArrayList<Long> tinyIds = new ArrayList<>();
    public String reason = "";
    public String source = "";

    public String getReason() {
        return this.reason;
    }

    public String getSource() {
        return this.source;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public ArrayList<Long> getTinyIds() {
        return this.tinyIds;
    }

    public String toString() {
        return "GProSuperAdminBanUserReq{tinyIds=" + this.tinyIds + ",reason=" + this.reason + ",source=" + this.source + ",sourceId=" + this.sourceId + ",}";
    }
}
