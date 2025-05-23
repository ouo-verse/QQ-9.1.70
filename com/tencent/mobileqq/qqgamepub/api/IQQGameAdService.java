package com.tencent.mobileqq.qqgamepub.api;

import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.data.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGameAdService extends QRouteApi {
    void doOnRunningForeground();

    void pullAd(int i3);

    void reportGdt(QQGameMsgInfo qQGameMsgInfo, int i3);

    void reportTianShu(a aVar);

    void updatePullAdInfo(boolean z16, long j3);
}
