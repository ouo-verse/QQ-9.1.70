package com.tencent.mobileqq.activity.troop.config;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;

/* compiled from: P */
/* loaded from: classes10.dex */
public class u extends com.tencent.mobileqq.troop.api.config.t {
    static IPatchRedirector $redirector_;

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.t
    public void a(@NonNull AppInterface appInterface, @NonNull String str, @NonNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, str, obj);
            return;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "TroopTokenHandlerProcessor")) {
            String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(uidFromUin, "TroopTokenHandlerProcessor");
            String remarkWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getRemarkWithUid(uidFromUin, "TroopTokenHandlerProcessor");
            AllInOne allInOne = new AllInOne(str, 1);
            allInOne.nickname = nickWithUid;
            allInOne.remark = remarkWithUid;
            return;
        }
        new AllInOne(str, 105);
    }
}
