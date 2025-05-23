package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStRankingItem {
    public int grade;
    public int inTopicList;
    public int rankNo;
    public long score;
    public GProStUser user = new GProStUser();
    public GProStRelationInfo relation = new GProStRelationInfo();
    public byte[] busiData = new byte[0];

    public byte[] getBusiData() {
        return this.busiData;
    }

    public int getGrade() {
        return this.grade;
    }

    public int getInTopicList() {
        return this.inTopicList;
    }

    public int getRankNo() {
        return this.rankNo;
    }

    public GProStRelationInfo getRelation() {
        return this.relation;
    }

    public long getScore() {
        return this.score;
    }

    public GProStUser getUser() {
        return this.user;
    }

    public String toString() {
        return "GProStRankingItem{user=" + this.user + ",relation=" + this.relation + ",score=" + this.score + ",grade=" + this.grade + ",busiData=" + this.busiData + ",rankNo=" + this.rankNo + ",inTopicList=" + this.inTopicList + ",}";
    }
}
