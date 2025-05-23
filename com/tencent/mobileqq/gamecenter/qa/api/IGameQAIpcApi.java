package com.tencent.mobileqq.gamecenter.qa.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameQAIpcApi extends QRouteApi {
    void callbackStrategyAnswer(int i3, int i16, long j3, long j16);

    void callbackStrategyQuestion(int i3, int i16, long j3);
}
