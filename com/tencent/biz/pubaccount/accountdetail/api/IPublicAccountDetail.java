package com.tencent.biz.pubaccount.accountdetail.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountDetail extends QRouteApi {
    void clone(IPublicAccountDetail iPublicAccountDetail);

    byte[] getAccountData();

    int getAccountFlag();

    long getAccountFlag2();

    long getCertifiedGrade();

    String getDisplayNumber();

    Entity getEntity();

    int getFollowType();

    long getId();

    String getName();

    int getReportAccountType(AppInterface appInterface, String str);

    int getShowFlag();

    int getShowMsgFlag();

    String getSummary();

    String getUid();

    String getUin();

    IPublicAccountDetail init(mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse);

    boolean isAgreeSyncLbs();

    boolean isRecvMsg();

    boolean isRecvPush();

    boolean isShowFollowButton();

    boolean isSyncLbs();

    boolean isSyncLbsSelected();

    void setFollowType(int i3);
}
