package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMVPUser implements Serializable {
    public String avatar;
    public String nick;
    public ArrayList<GProMVPRoleGroup> roleGroups;
    long serialVersionUID;
    public long tinyid;
    public long uin;

    public GProMVPUser() {
        this.serialVersionUID = 1L;
        this.nick = "";
        this.avatar = "";
        this.roleGroups = new ArrayList<>();
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNick() {
        return this.nick;
    }

    public ArrayList<GProMVPRoleGroup> getRoleGroups() {
        return this.roleGroups;
    }

    public long getTinyid() {
        return this.tinyid;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProMVPUser{tinyid=" + this.tinyid + ",nick=" + this.nick + ",avatar=" + this.avatar + ",roleGroups=" + this.roleGroups + ",uin=" + this.uin + ",}";
    }

    public GProMVPUser(long j3, String str, String str2, ArrayList<GProMVPRoleGroup> arrayList) {
        this.serialVersionUID = 1L;
        this.nick = "";
        this.avatar = "";
        new ArrayList();
        this.tinyid = j3;
        this.nick = str;
        this.avatar = str2;
        this.roleGroups = arrayList;
    }
}
