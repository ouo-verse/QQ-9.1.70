package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStFollowRecomInfo {
    public String followText = "";
    public ArrayList<GProStFollowUser> followUsers = new ArrayList<>();
    public String commFriendText = "";
    public String commGroupText = "";

    public String getCommFriendText() {
        return this.commFriendText;
    }

    public String getCommGroupText() {
        return this.commGroupText;
    }

    public String getFollowText() {
        return this.followText;
    }

    public ArrayList<GProStFollowUser> getFollowUsers() {
        return this.followUsers;
    }

    public String toString() {
        return "GProStFollowRecomInfo{followText=" + this.followText + ",followUsers=" + this.followUsers + ",commFriendText=" + this.commFriendText + ",commGroupText=" + this.commGroupText + ",}";
    }
}
