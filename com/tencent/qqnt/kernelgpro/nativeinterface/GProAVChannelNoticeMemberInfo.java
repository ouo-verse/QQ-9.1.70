package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAVChannelNoticeMemberInfo {
    public int atMemberType;
    public ArrayList<Long> atRoleIds = new ArrayList<>();

    public int getAtMemberType() {
        return this.atMemberType;
    }

    public ArrayList<Long> getAtRoleIds() {
        return this.atRoleIds;
    }

    public String toString() {
        return "GProAVChannelNoticeMemberInfo{atMemberType=" + this.atMemberType + ",atRoleIds=" + this.atRoleIds + ",}";
    }
}
