package com.tencent.mobileqq.friend.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes12.dex */
public interface IFriendNameService extends IRuntimeService {
    String getBuddyName(String str, boolean z16);

    String getFriendAlias(String str);

    String getFriendName(String str);

    String getFriendName(String str, boolean z16);

    String getFriendNick(String str);

    String getFriendRemark(String str);

    String getPhoneContactName(String str);

    void saveFriendRemark(String str, String str2);
}
