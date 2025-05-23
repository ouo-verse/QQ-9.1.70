package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetIdentityListRsp {
    public int unObtainedInteractionCnt;
    public GroupIdentityUserInfo userInfo = new GroupIdentityUserInfo();
    public GroupIdentityLevelInfo level = new GroupIdentityLevelInfo();
    public ArrayList<GroupIdentityTitleInfo> titles = new ArrayList<>();
    public ArrayList<GroupIdentityInteractionTag> interactionTags = new ArrayList<>();
    public GroupIdentityAppTag appTag = new GroupIdentityAppTag();
    public GroupIdentityVipTag vipTag = new GroupIdentityVipTag();

    public GroupIdentityAppTag getAppTag() {
        return this.appTag;
    }

    public ArrayList<GroupIdentityInteractionTag> getInteractionTags() {
        return this.interactionTags;
    }

    public GroupIdentityLevelInfo getLevel() {
        return this.level;
    }

    public ArrayList<GroupIdentityTitleInfo> getTitles() {
        return this.titles;
    }

    public int getUnObtainedInteractionCnt() {
        return this.unObtainedInteractionCnt;
    }

    public GroupIdentityUserInfo getUserInfo() {
        return this.userInfo;
    }

    public GroupIdentityVipTag getVipTag() {
        return this.vipTag;
    }

    public String toString() {
        return "GetIdentityListRsp{userInfo=" + this.userInfo + ",level=" + this.level + ",titles=" + this.titles + ",interactionTags=" + this.interactionTags + ",unObtainedInteractionCnt=" + this.unObtainedInteractionCnt + ",appTag=" + this.appTag + ",vipTag=" + this.vipTag + ",}";
    }
}
