package com.tencent.mobileqq.gamecenter.qa.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import sd1.a;
import sd1.b;
import sd1.c;
import sd1.d;
import vd1.MetaDreamUnreadMsgInfo;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes12.dex */
public interface IMetaDreamService extends IRuntimeService {
    void addMetaDreamGameFriend(String str, String str2, b bVar);

    void getIsMetaDreamFriendFromServer(String str, d dVar);

    void getMetaDreamGameTeamingLink(String str, String str2, String str3, c cVar);

    MetaDreamUnreadMsgInfo getMetaDreamUnreadMsgInfo();

    Bundle getMetaDreamUnreadMsgInfoBundle();

    void getOAIDFromServer(String str, a aVar);

    String getSavedOAID();

    void removeGetOAIDCallback();

    void removeMetaDreamAddFriendCallback();

    void removeMetaDreamGetGameTeamingLinkCallback();

    void removeMetaDreamIsGameFriendCallback();
}
