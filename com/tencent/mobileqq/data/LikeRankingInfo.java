package com.tencent.mobileqq.data;

/* compiled from: P */
/* loaded from: classes10.dex */
public class LikeRankingInfo {
    public int likeCountOfToday;
    public int rankingNum;
    public int totalLikeCount;
    public long uin;

    public String toString() {
        return "uin:" + this.uin + ",todayVoteCount:" + this.likeCountOfToday + ",rank:" + this.rankingNum + ",total:" + this.totalLikeCount;
    }
}
