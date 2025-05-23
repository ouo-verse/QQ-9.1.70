package com.tencent.mobileqq.newfriend.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes15.dex */
public interface INewFriendVerificationService extends IRuntimeService {
    void clearRedPointAtNewFriendBanner();

    void getAddFriendBlockedList(String str);

    void getAddFriendBlockedRedPoint(String str);

    int getEntranceType();

    boolean isShowRedPoint();

    boolean isShowRedPointAtNewFriendBanner();

    void leaveNewFriend();

    void reportAddFriendBlocked(String str, int i3, int i16, int i17, String str2);
}
