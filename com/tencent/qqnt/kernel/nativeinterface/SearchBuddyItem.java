package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchBuddyItem {
    public int chatType;
    public long uin;
    public String uid = "";
    public String qid = "";
    public ArrayList<SearchHitInfo> qidHits = new ArrayList<>();
    public ArrayList<SearchHitInfo> uinHits = new ArrayList<>();
    public String nickname = "";
    public ArrayList<SearchHitInfo> nicknameHits = new ArrayList<>();
    public String remark = "";
    public ArrayList<SearchHitInfo> remarkHits = new ArrayList<>();
    public String categoryName = "";

    public String getCategoryName() {
        return this.categoryName;
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getNickname() {
        return this.nickname;
    }

    public ArrayList<SearchHitInfo> getNicknameHits() {
        return this.nicknameHits;
    }

    public String getQid() {
        return this.qid;
    }

    public ArrayList<SearchHitInfo> getQidHits() {
        return this.qidHits;
    }

    public String getRemark() {
        return this.remark;
    }

    public ArrayList<SearchHitInfo> getRemarkHits() {
        return this.remarkHits;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public ArrayList<SearchHitInfo> getUinHits() {
        return this.uinHits;
    }

    public String toString() {
        return "SearchBuddyItem{chatType=" + this.chatType + ",uid=" + this.uid + ",qid=" + this.qid + ",qidHits=" + this.qidHits + ",uin=" + this.uin + ",uinHits=" + this.uinHits + ",nickname=" + this.nickname + ",nicknameHits=" + this.nicknameHits + ",remark=" + this.remark + ",remarkHits=" + this.remarkHits + ",categoryName=" + this.categoryName + ",}";
    }
}
