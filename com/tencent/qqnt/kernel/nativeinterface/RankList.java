package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RankList {
    public RankType rankType = new RankType();
    public ArrayList<ClassRankList> classRankList = new ArrayList<>();

    public ArrayList<ClassRankList> getClassRankList() {
        return this.classRankList;
    }

    public RankType getRankType() {
        return this.rankType;
    }

    public String toString() {
        return "RankList{rankType=" + this.rankType + ",classRankList=" + this.classRankList + ",}";
    }
}
