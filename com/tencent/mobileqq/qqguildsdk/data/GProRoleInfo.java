package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRole;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes17.dex */
public class GProRoleInfo implements ej, Serializable {
    private final GProRole role;

    public GProRoleInfo(GProRole gProRole) {
        this.role = gProRole;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ej
    public boolean getIsBind() {
        return this.role.getIsBind();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ej
    public String getRoleDescribe() {
        return this.role.getRoleDescribe();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ej
    public String getRoleId() {
        return this.role.getRoleId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ej
    public String getRoleName() {
        return this.role.getRoleName();
    }

    @NotNull
    public String toString() {
        return "GProRoleInfo{RoleId : " + getRoleId() + ", RoleName : " + getRoleName() + ", RoleDescribe : " + getRoleDescribe() + ", IsBind : " + getIsBind() + "}";
    }
}
