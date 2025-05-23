package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProSortAndWriteBindGroupsRsp;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProSortAndWriteBindGroupsRsp implements IGProSortAndWriteBindGroupsRsp {
    public final GProSortAndWriteBindGroupsRsp mInfo;

    public GGProSortAndWriteBindGroupsRsp(GProSortAndWriteBindGroupsRsp gProSortAndWriteBindGroupsRsp) {
        this.mInfo = gProSortAndWriteBindGroupsRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSortAndWriteBindGroupsRsp
    public ArrayList<Long> getGroupCodeList() {
        return this.mInfo.getGroupCodeList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSortAndWriteBindGroupsRsp
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSortAndWriteBindGroupsRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
