package com.tencent.mobileqq.relationx.onewayfriend;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(AppInterface appInterface, int i3, String str) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (i3 == 0 && !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "OneWayFriendHelper")) {
            return true;
        }
        return false;
    }
}
