package com.tencent.mobileqq.matchfriend.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.matchfriend.request.MatchFriendRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendRequestImpl implements IMatchFriendRequest {
    private static final String TAG = "MatchFriendRequestImpl";
    private static int appSeq;

    private void getMayKnowRecommendRemote(AppInterface appInterface) {
        QLog.i(TAG, 1, "getMayKnowRecommendRemote after conversation list loaded!");
        ((MayknowRecommendManager) appInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).g(1);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void aioReport(AppInterface appInterface, long j3, int i3, int i16, long j16, String str) {
        MatchFriendRequest.j(appInterface, j3, i3, i16, j16, str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void batchGetUserGender(AppInterface appInterface, List<String> list) {
        MatchFriendRequest.k(appInterface, list);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void executeLoginRequest(com.tencent.relation.common.servlet.c cVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        MatchFriendRequest.L(peekAppRuntime, cVar);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void getAioHint(AppInterface appInterface, long j3, String str) {
        MatchFriendRequest.n(appInterface, j3, str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void getAioSign(AppInterface appInterface, long j3, String str) {
        MatchFriendRequest.o(appInterface, j3, str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void getArkMiniProfileCardInfo(AppInterface appInterface, String str, String str2, int i3, boolean z16, String str3) {
        MatchFriendRequest.p(appInterface, str, str2, i3, z16, str3);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void getCanAddFriend(AppInterface appInterface, String str) {
        MatchFriendRequest.r(appInterface, str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void getCanGreet(AppInterface appInterface, long j3, String str) {
        MatchFriendRequest.t(appInterface, j3, str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void getIceBreakingTopic(AppInterface appInterface, long j3, String str) {
        MatchFriendRequest.v(appInterface, j3, str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void getIsFriend(AppInterface appInterface, String str) {
        MatchFriendRequest.x(appInterface, str, null);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void getMatchFriendEntrance(AppInterface appInterface) {
        getMayKnowRecommendRemote(appInterface);
        if (appSeq != appInterface.hashCode()) {
            appSeq = appInterface.hashCode();
            QLog.i(TAG, 1, "[early_task]getMatchFriendEntrance invoke");
            MatchFriendRequest.A(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void getUserShield(AppInterface appInterface, long j3) {
        MatchFriendRequest.B(appInterface, j3);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void getVoiceLinkIceBreakTopic(AppInterface appInterface, long j3, long j16) {
        MatchFriendRequest.C(appInterface, j3, j16);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void greetReport(AppInterface appInterface, long j3, String str) {
        MatchFriendRequest.D(appInterface, j3, str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void onLebaResume(final AppInterface appInterface) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.api.impl.MatchFriendRequestImpl.1
            @Override // java.lang.Runnable
            public void run() {
                MatchFriendRequest.O(appInterface);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void reportJubao(AppInterface appInterface, long j3) {
        MatchFriendRequest.P(appInterface, j3);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void reportMatchFriendEntry(AppInterface appInterface) {
        if (appSeq != appInterface.hashCode()) {
            appSeq = appInterface.hashCode();
            QLog.i(TAG, 1, "[early_task]reportMatchFriendEntry invoke");
            MatchFriendRequest.A(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void sendInviteGrayTip(AppInterface appInterface, String str) {
        MatchFriendRequest.R(appInterface, str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void setFirstRelationOrigin(AppInterface appInterface, long j3, int i3, String str) {
        MatchFriendRequest.S(appInterface, j3, i3, str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void setUserShield(AppInterface appInterface, long j3, boolean z16) {
        MatchFriendRequest.U(appInterface, j3, z16);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest
    public void getIsFriend(AppInterface appInterface, String str, com.tencent.mobileqq.matchfriend.api.a aVar) {
        MatchFriendRequest.x(appInterface, str, aVar);
    }
}
