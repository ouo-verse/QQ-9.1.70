package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import friendlist.FriendInfo;
import java.util.List;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class RelationFriendNTProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public RelationFriendNTProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private void a(Friends friends, FriendInfo friendInfo) {
        ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(String.valueOf(friendInfo.friendUin), friendInfo.uid);
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> list, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        for (Pair<Friends, FriendInfo> pair : list) {
            a((Friends) pair.first, (FriendInfo) pair.second);
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateFriendInfo(Friends friends, FriendInfo friendInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) friends, (Object) friendInfo);
        } else {
            a(friends, friendInfo);
        }
    }
}
