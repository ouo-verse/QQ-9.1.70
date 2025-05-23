package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildMemberCountInfo {
    public long adminCount;
    public String errMsg = "";
    public long guildId;
    public boolean isFromServer;
    public long maxCount;
    public long normalCount;
    public int result;
    public long robotCount;

    public long getAdminCount() {
        return this.adminCount;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getIsFromServer() {
        return this.isFromServer;
    }

    public long getMaxCount() {
        return this.maxCount;
    }

    public long getNormalCount() {
        return this.normalCount;
    }

    public int getResult() {
        return this.result;
    }

    public long getRobotCount() {
        return this.robotCount;
    }

    public String toString() {
        return "GProGuildMemberCountInfo{guildId=" + this.guildId + ",maxCount=" + this.maxCount + ",normalCount=" + this.normalCount + ",adminCount=" + this.adminCount + ",robotCount=" + this.robotCount + ",isFromServer=" + this.isFromServer + ",result=" + this.result + ",errMsg=" + this.errMsg + ",}";
    }
}
