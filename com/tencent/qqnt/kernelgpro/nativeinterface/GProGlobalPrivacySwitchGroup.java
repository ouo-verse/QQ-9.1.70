package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGlobalPrivacySwitchGroup {
    public int addFriendSwitch;
    public int allSwitch;
    public int joinedGuildShowSwitch;
    public int publishedFeedShowSwitch;
    public int qqProfileShowSwitch;
    public int roomStateShowSwitch;

    public GProGlobalPrivacySwitchGroup() {
    }

    public int getAddFriendSwitch() {
        return this.addFriendSwitch;
    }

    public int getAllSwitch() {
        return this.allSwitch;
    }

    public int getJoinedGuildShowSwitch() {
        return this.joinedGuildShowSwitch;
    }

    public int getPublishedFeedShowSwitch() {
        return this.publishedFeedShowSwitch;
    }

    public int getQqProfileShowSwitch() {
        return this.qqProfileShowSwitch;
    }

    public int getRoomStateShowSwitch() {
        return this.roomStateShowSwitch;
    }

    public String toString() {
        return "GProGlobalPrivacySwitchGroup{addFriendSwitch=" + this.addFriendSwitch + ",allSwitch=" + this.allSwitch + ",qqProfileShowSwitch=" + this.qqProfileShowSwitch + ",roomStateShowSwitch=" + this.roomStateShowSwitch + ",joinedGuildShowSwitch=" + this.joinedGuildShowSwitch + ",publishedFeedShowSwitch=" + this.publishedFeedShowSwitch + ",}";
    }

    public GProGlobalPrivacySwitchGroup(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.addFriendSwitch = i3;
        this.allSwitch = i16;
        this.qqProfileShowSwitch = i17;
        this.roomStateShowSwitch = i18;
        this.joinedGuildShowSwitch = i19;
        this.publishedFeedShowSwitch = i26;
    }
}
