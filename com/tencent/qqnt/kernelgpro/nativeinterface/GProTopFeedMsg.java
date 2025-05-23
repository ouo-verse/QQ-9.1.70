package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProTopFeedMsg {
    public long createTime;
    public int labelColor;
    public int labelId;
    public boolean needNotify;
    public long operatorTinyid;
    public String feedId = "";
    public String labelText = "";
    public String summaryText = "";
    public ArrayList<Long> roleIds = new ArrayList<>();

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getLabelColor() {
        return this.labelColor;
    }

    public int getLabelId() {
        return this.labelId;
    }

    public String getLabelText() {
        return this.labelText;
    }

    public boolean getNeedNotify() {
        return this.needNotify;
    }

    public long getOperatorTinyid() {
        return this.operatorTinyid;
    }

    public ArrayList<Long> getRoleIds() {
        return this.roleIds;
    }

    public String getSummaryText() {
        return this.summaryText;
    }

    public String toString() {
        return "GProTopFeedMsg{feedId=" + this.feedId + ",labelId=" + this.labelId + ",labelText=" + this.labelText + ",labelColor=" + this.labelColor + ",summaryText=" + this.summaryText + ",needNotify=" + this.needNotify + ",createTime=" + this.createTime + ",operatorTinyid=" + this.operatorTinyid + ",roleIds=" + this.roleIds + ",}";
    }
}
