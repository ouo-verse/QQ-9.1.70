package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProApplicationChannelInfo implements Serializable {
    public int appChannelJumpType;
    public int appQyyFlag;
    public long applicationId;
    public int externalUrlRequestStatus;
    long serialVersionUID = 1;
    public String strAppChannelId = "";
    public String strJumpSecret = "";
    public String appChannelIcon = "";
    public String appChannelJumpUrl = "";

    public String getAppChannelIcon() {
        return this.appChannelIcon;
    }

    public int getAppChannelJumpType() {
        return this.appChannelJumpType;
    }

    public String getAppChannelJumpUrl() {
        return this.appChannelJumpUrl;
    }

    public int getAppQyyFlag() {
        return this.appQyyFlag;
    }

    public long getApplicationId() {
        return this.applicationId;
    }

    public int getExternalUrlRequestStatus() {
        return this.externalUrlRequestStatus;
    }

    public String getStrAppChannelId() {
        return this.strAppChannelId;
    }

    public String getStrJumpSecret() {
        return this.strJumpSecret;
    }

    public String toString() {
        return "GProApplicationChannelInfo{applicationId=" + this.applicationId + ",strAppChannelId=" + this.strAppChannelId + ",strJumpSecret=" + this.strJumpSecret + ",appChannelIcon=" + this.appChannelIcon + ",appChannelJumpType=" + this.appChannelJumpType + ",appChannelJumpUrl=" + this.appChannelJumpUrl + ",appQyyFlag=" + this.appQyyFlag + ",externalUrlRequestStatus=" + this.externalUrlRequestStatus + ",}";
    }
}
