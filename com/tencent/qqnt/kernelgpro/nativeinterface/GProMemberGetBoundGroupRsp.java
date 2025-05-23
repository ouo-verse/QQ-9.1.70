package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMemberGetBoundGroupRsp {
    public int bindingGroupLimit;
    public int bindingGroupSize;
    public long guildId;
    public int srcType;
    public ArrayList<GProBindingGroup> bindingGroupList = new ArrayList<>();
    public ArrayList<Long> allBindGroupCodeList = new ArrayList<>();

    public ArrayList<Long> getAllBindGroupCodeList() {
        return this.allBindGroupCodeList;
    }

    public int getBindingGroupLimit() {
        return this.bindingGroupLimit;
    }

    public ArrayList<GProBindingGroup> getBindingGroupList() {
        return this.bindingGroupList;
    }

    public int getBindingGroupSize() {
        return this.bindingGroupSize;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getSrcType() {
        return this.srcType;
    }

    public String toString() {
        return "GProMemberGetBoundGroupRsp{bindingGroupList=" + this.bindingGroupList + ",bindingGroupSize=" + this.bindingGroupSize + ",allBindGroupCodeList=" + this.allBindGroupCodeList + ",bindingGroupLimit=" + this.bindingGroupLimit + ",guildId=" + this.guildId + ",srcType=" + this.srcType + ",}";
    }
}
