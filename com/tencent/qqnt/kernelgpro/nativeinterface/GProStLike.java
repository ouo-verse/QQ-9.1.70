package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStLike implements Serializable {
    public int count;
    public int hasLikedCount;
    public int ownerStatus;
    public int status;
    long serialVersionUID = 1;
    public String idd = "";
    public ArrayList<GProStUser> vecUserList = new ArrayList<>();
    public byte[] busiData = new byte[0];
    public GProStUser postUser = new GProStUser();
    public String jumpUrl = "";

    public byte[] getBusiData() {
        return this.busiData;
    }

    public int getCount() {
        return this.count;
    }

    public int getHasLikedCount() {
        return this.hasLikedCount;
    }

    public String getIdd() {
        return this.idd;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getOwnerStatus() {
        return this.ownerStatus;
    }

    public GProStUser getPostUser() {
        return this.postUser;
    }

    public int getStatus() {
        return this.status;
    }

    public ArrayList<GProStUser> getVecUserList() {
        return this.vecUserList;
    }

    public String toString() {
        return "GProStLike{idd=" + this.idd + ",count=" + this.count + ",status=" + this.status + ",vecUserList=" + this.vecUserList + ",busiData=" + this.busiData + ",postUser=" + this.postUser + ",hasLikedCount=" + this.hasLikedCount + ",ownerStatus=" + this.ownerStatus + ",jumpUrl=" + this.jumpUrl + ",}";
    }
}
