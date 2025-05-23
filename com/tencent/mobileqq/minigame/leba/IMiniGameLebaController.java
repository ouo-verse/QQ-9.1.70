package com.tencent.mobileqq.minigame.leba;

import com.tencent.mobileqq.gamecenter.api.c;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameLebaController extends QRouteApi {
    public static final String MINI_GAME_NUM_RES_ID = "4048.0";
    public static final String MINI_GAME_RES_ID = "4048";

    String getLetsGoRedInfo();

    boolean hasRedInfo();

    void notifyLebaTabChange(boolean z16);

    void onItemClick();

    void onItemClickBefore(BusinessInfoCheckUpdate.AppInfo appInfo);

    void setGameViewContainer(c cVar);

    void showGridAnimation(boolean z16, BusinessInfoCheckUpdate.AppInfo appInfo);
}
