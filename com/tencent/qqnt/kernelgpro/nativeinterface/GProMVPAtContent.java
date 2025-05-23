package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPAtContent implements Serializable {
    public String atAllText;
    public GProMVPRoleGroup roleGroup;
    long serialVersionUID;
    public String text;
    public int type;
    public GProMVPUser user;

    public GProMVPAtContent() {
        this.serialVersionUID = 1L;
        this.user = new GProMVPUser();
        this.atAllText = "";
        this.roleGroup = new GProMVPRoleGroup();
        this.text = "";
    }

    public String getAtAllText() {
        return this.atAllText;
    }

    public GProMVPRoleGroup getRoleGroup() {
        return this.roleGroup;
    }

    public String getText() {
        return this.text;
    }

    public int getType() {
        return this.type;
    }

    public GProMVPUser getUser() {
        return this.user;
    }

    public String toString() {
        return "GProMVPAtContent{type=" + this.type + ",user=" + this.user + ",atAllText=" + this.atAllText + ",roleGroup=" + this.roleGroup + ",text=" + this.text + ",}";
    }

    public GProMVPAtContent(int i3, GProMVPUser gProMVPUser, String str, GProMVPRoleGroup gProMVPRoleGroup, String str2) {
        this.serialVersionUID = 1L;
        this.user = new GProMVPUser();
        this.atAllText = "";
        new GProMVPRoleGroup();
        this.type = i3;
        this.user = gProMVPUser;
        this.atAllText = str;
        this.roleGroup = gProMVPRoleGroup;
        this.text = str2;
    }
}
