package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildListSortInfo;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProGuildListSortInfo implements IGProGuildListSortInfo {
    public final GProGuildListSortInfo mInfo;

    public GGProGuildListSortInfo(GProGuildListSortInfo gProGuildListSortInfo) {
        this.mInfo = gProGuildListSortInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo
    public ArrayList<Long> getSortList() {
        return this.mInfo.getSortList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo
    public ArrayList<Long> getTopList() {
        return this.mInfo.getTopList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
