package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupHonor {
    public ArrayList<Integer> honorIds;
    public Integer level;
    public Integer oldLevel;
    public Long rankSeq;
    public Integer richFlag;
    public Integer titleId;
    public String uniqueTitle;

    public GroupHonor() {
    }

    public ArrayList<Integer> getHonorIds() {
        return this.honorIds;
    }

    public Integer getLevel() {
        return this.level;
    }

    public Integer getOldLevel() {
        return this.oldLevel;
    }

    public Long getRankSeq() {
        return this.rankSeq;
    }

    public Integer getRichFlag() {
        return this.richFlag;
    }

    public Integer getTitleId() {
        return this.titleId;
    }

    public String getUniqueTitle() {
        return this.uniqueTitle;
    }

    public String toString() {
        return "GroupHonor{richFlag=" + this.richFlag + ",honorIds=" + this.honorIds + ",level=" + this.level + ",oldLevel=" + this.oldLevel + ",rankSeq=" + this.rankSeq + ",titleId=" + this.titleId + ",uniqueTitle=" + this.uniqueTitle + ",}";
    }

    public GroupHonor(Integer num, ArrayList<Integer> arrayList, Integer num2, Integer num3, Long l3, Integer num4, String str) {
        this.richFlag = num;
        this.honorIds = arrayList;
        this.level = num2;
        this.oldLevel = num3;
        this.rankSeq = l3;
        this.titleId = num4;
        this.uniqueTitle = str;
    }
}
