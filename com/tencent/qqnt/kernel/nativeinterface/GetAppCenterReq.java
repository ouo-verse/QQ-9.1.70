package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetAppCenterReq {
    public int from;
    public long groupId;
    public int groupType;
    public int miniappProtect;
    public int mode;
    public int needRobot;
    public int num;
    public int page;
    public int redpoint;
    public ClientInfo clientInfo = new ClientInfo();
    public String keyword = "";
    public String attachinfo = "";

    public String getAttachinfo() {
        return this.attachinfo;
    }

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public int getFrom() {
        return this.from;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public int getMiniappProtect() {
        return this.miniappProtect;
    }

    public int getMode() {
        return this.mode;
    }

    public int getNeedRobot() {
        return this.needRobot;
    }

    public int getNum() {
        return this.num;
    }

    public int getPage() {
        return this.page;
    }

    public int getRedpoint() {
        return this.redpoint;
    }

    public String toString() {
        return "GetAppCenterReq{clientInfo=" + this.clientInfo + ",groupId=" + this.groupId + ",groupType=" + this.groupType + ",mode=" + this.mode + ",keyword=" + this.keyword + ",page=" + this.page + ",num=" + this.num + ",attachinfo=" + this.attachinfo + ",miniappProtect=" + this.miniappProtect + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",redpoint=" + this.redpoint + ",needRobot=" + this.needRobot + ",}";
    }
}
