package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStRichTextAtContent implements Serializable {
    public int type;
    long serialVersionUID = 1;
    public GProBaseFeedGuildInfo guildInfo = new GProBaseFeedGuildInfo();
    public GProRoleGroupInfo roleGroupId = new GProRoleGroupInfo();
    public GProStUser user = new GProStUser();

    public GProBaseFeedGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public GProRoleGroupInfo getRoleGroupId() {
        return this.roleGroupId;
    }

    public int getType() {
        return this.type;
    }

    public GProStUser getUser() {
        return this.user;
    }

    public String toString() {
        return "GProStRichTextAtContent{type=" + this.type + ",guildInfo=" + this.guildInfo + ",roleGroupId=" + this.roleGroupId + ",user=" + this.user + ",}";
    }
}
