package com.qzone.util;

import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aq {
    public static boolean a(long j3) {
        return j3 == LoginData.getInstance().getUin();
    }

    public static boolean b(long j3) {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3)), "UserUtil");
    }
}
