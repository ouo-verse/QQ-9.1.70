package com.tencent.mobileqq.matchfriend.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMatchFriendRequest extends QRouteApi {
    void aioReport(AppInterface appInterface, long j3, int i3, int i16, long j16, String str);

    void batchGetUserGender(AppInterface appInterface, List<String> list);

    void executeLoginRequest(com.tencent.relation.common.servlet.c cVar);

    void getAioHint(AppInterface appInterface, long j3, String str);

    void getAioSign(AppInterface appInterface, long j3, String str);

    void getArkMiniProfileCardInfo(AppInterface appInterface, String str, String str2, int i3, boolean z16, String str3);

    void getCanAddFriend(AppInterface appInterface, String str);

    void getCanGreet(AppInterface appInterface, long j3, String str);

    void getIceBreakingTopic(AppInterface appInterface, long j3, String str);

    void getIsFriend(AppInterface appInterface, String str);

    void getIsFriend(AppInterface appInterface, String str, a aVar);

    void getMatchFriendEntrance(AppInterface appInterface);

    void getUserShield(AppInterface appInterface, long j3);

    void getVoiceLinkIceBreakTopic(AppInterface appInterface, long j3, long j16);

    void greetReport(AppInterface appInterface, long j3, String str);

    void onLebaResume(AppInterface appInterface);

    void reportJubao(AppInterface appInterface, long j3);

    void reportMatchFriendEntry(AppInterface appInterface);

    void sendInviteGrayTip(AppInterface appInterface, String str);

    void setFirstRelationOrigin(AppInterface appInterface, long j3, int i3, String str);

    void setUserShield(AppInterface appInterface, long j3, boolean z16);
}
