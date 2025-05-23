package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends com.tencent.mobileqq.troop.api.config.b {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.b
    public void a(@NonNull AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface);
        } else {
            ((ITroopBatchAddFriendService) appInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.b
    public void b(@NonNull AppInterface appInterface, String str, HashMap<String, Integer> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, str, hashMap);
        } else {
            ((ITroopMemberExtDBApi) QRoute.api(ITroopMemberExtDBApi.class)).updateCommonFriendCount(str, hashMap, "TroopAddFriendProcessor");
        }
    }
}
