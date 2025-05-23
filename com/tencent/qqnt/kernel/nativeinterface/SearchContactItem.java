package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchContactItem {
    public SearchBuddyItem buddyItem;
    public SearchGroupMemberItem groupMemberItem;
    public String rankInfo = "";
    public String recallReason = "";
    public int type;

    public SearchBuddyItem getBuddyItem() {
        return this.buddyItem;
    }

    public SearchGroupMemberItem getGroupMemberItem() {
        return this.groupMemberItem;
    }

    public String getRankInfo() {
        return this.rankInfo;
    }

    public String getRecallReason() {
        return this.recallReason;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "SearchContactItem{type=" + this.type + ",buddyItem=" + this.buddyItem + ",groupMemberItem=" + this.groupMemberItem + ",rankInfo=" + this.rankInfo + ",recallReason=" + this.recallReason + ",}";
    }
}
