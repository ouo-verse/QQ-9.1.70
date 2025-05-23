package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFriendsRsp;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProGetGuildFriendsRsp implements IGProGetGuildFriendsRsp {
    public final GProGetGuildFriendsRsp mInfo;

    public GGProGetGuildFriendsRsp(GProGetGuildFriendsRsp gProGetGuildFriendsRsp) {
        this.mInfo = gProGetGuildFriendsRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildFriendsRsp
    public ArrayList<Long> getUinList() {
        return this.mInfo.getUinList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildFriendsRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
