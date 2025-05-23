package com.tencent.mobileqq.gamecenter.api;

import com.tencent.mobileqq.gamecenter.data.q;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$BattlepassWidget;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$NewWidget;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameCenterWidgetMgrApi extends QRouteApi {
    boolean addWidgetV2();

    void clearImgCache();

    void clearWidgetConfigCacheV2();

    void downloadAndUpdateUi(String str);

    void fetchEncryptedUinFromSvrV2();

    void fetchWidgetConfigFromSvrV2();

    void fetchWidgetConfigFromSvrV2(int i3);

    String getFileDownloadPath(String str);

    q getWidgetCacheData(boolean z16);

    boolean hasWidgetV2();

    boolean isPullConfigTimeUpV2();

    void onWidgetPushMsgReceived(String str);

    void reportIfNeed(String str);

    void startTimer();

    void updateWidgetConfigV3(int i3, QQWidgetSvr$BattlepassWidget qQWidgetSvr$BattlepassWidget, QQWidgetSvr$NewWidget qQWidgetSvr$NewWidget, long j3);
}
