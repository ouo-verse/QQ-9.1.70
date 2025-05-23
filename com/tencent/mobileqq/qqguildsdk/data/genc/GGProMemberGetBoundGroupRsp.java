package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProBindingGroup;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMemberGetBoundGroupRsp;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProMemberGetBoundGroupRsp implements IGProMemberGetBoundGroupRsp {
    public final GProMemberGetBoundGroupRsp mInfo;

    public GGProMemberGetBoundGroupRsp(GProMemberGetBoundGroupRsp gProMemberGetBoundGroupRsp) {
        this.mInfo = gProMemberGetBoundGroupRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberGetBoundGroupRsp
    public ArrayList<Long> getAllBindGroupCodeList() {
        return this.mInfo.getAllBindGroupCodeList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberGetBoundGroupRsp
    public int getBindingGroupLimit() {
        return this.mInfo.getBindingGroupLimit();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberGetBoundGroupRsp
    public ArrayList<IGProBindingGroup> getBindingGroupList() {
        ArrayList<GProBindingGroup> bindingGroupList = this.mInfo.getBindingGroupList();
        ArrayList<IGProBindingGroup> arrayList = new ArrayList<>();
        Iterator<GProBindingGroup> it = bindingGroupList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBindingGroup(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberGetBoundGroupRsp
    public int getBindingGroupSize() {
        return this.mInfo.getBindingGroupSize();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberGetBoundGroupRsp
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberGetBoundGroupRsp
    public int getSrcType() {
        return this.mInfo.getSrcType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberGetBoundGroupRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
