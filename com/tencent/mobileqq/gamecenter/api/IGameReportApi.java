package com.tencent.mobileqq.gamecenter.api;

import com.tencent.mobileqq.gamecenter.data.GameReportExtraData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGameReportApi extends QRouteApi {
    public static final String HONOR_RANK_ARK_APP_NAME = "com.tencent.gamecenter.wangzherank";
    public static final String HONOR_RANK_ARK_APP_NAME2 = "com.tencent.gamecenter.wangzheopenpk";

    void clearLastReportApplyPartnerBoxData();

    void clearLastReportApplyPartnerData();

    void clearLastReportGamePartnerData();

    void reportApplyPartnerBoxExpo(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar);

    void reportApplyPartnerMsgExpo(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar);

    void reportGameAchievement(String str, String str2, int i3);

    void reportGamePartnerMsgExpo(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar);

    void reportRobot(String str, String str2, GameReportExtraData gameReportExtraData);

    void reportSendHonorRankArkMsg(String str);
}
