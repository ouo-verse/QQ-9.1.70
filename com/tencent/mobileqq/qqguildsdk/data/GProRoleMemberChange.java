package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoleMemberChangeInfo;
import java.util.List;

/* loaded from: classes17.dex */
public class GProRoleMemberChange implements IGProRoleMemberChange {
    private final GProRoleMemberChangeInfo mChangeInfo;

    public GProRoleMemberChange(GProRoleMemberChangeInfo gProRoleMemberChangeInfo) {
        this.mChangeInfo = gProRoleMemberChangeInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberChange
    public List<String> getAddMembers() {
        return com.tencent.mobileqq.qqguildsdk.util.g.Y0(this.mChangeInfo.getAddMembers());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberChange
    public List<String> getRemoveMembers() {
        return com.tencent.mobileqq.qqguildsdk.util.g.Y0(this.mChangeInfo.getRemoveMembers());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberChange
    public String getRoleId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.mChangeInfo.getRoleId());
    }
}
