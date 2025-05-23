package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$GetUserRoleGroupReq;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RoleGroupInfoRequest extends ProtoBufRequest {
    private INTERFACE$GetUserRoleGroupReq mReq;

    public RoleGroupInfoRequest(String str) {
        INTERFACE$GetUserRoleGroupReq iNTERFACE$GetUserRoleGroupReq = new INTERFACE$GetUserRoleGroupReq();
        this.mReq = iNTERFACE$GetUserRoleGroupReq;
        iNTERFACE$GetUserRoleGroupReq.guild_openid.set(str);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.mReq.toByteArray();
    }
}
