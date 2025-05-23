package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStUserGroupInfo {
    public String idd = "";
    public String name = "";
    public ArrayList<GProStUser> userListList = new ArrayList<>();

    public String getIdd() {
        return this.idd;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<GProStUser> getUserListList() {
        return this.userListList;
    }

    public String toString() {
        return "GProStUserGroupInfo{idd=" + this.idd + ",name=" + this.name + ",userListList=" + this.userListList + ",}";
    }
}
