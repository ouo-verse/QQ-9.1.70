package com.tencent.mobileqq.onlinestatus.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusLikeStatusApi;
import com.tencent.mobileqq.onlinestatus.networkhandler.OnlineStatusAggregationHandler;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusLikeStatusApiImpl implements IOnlineStatusLikeStatusApi {
    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusLikeStatusApi
    public void clearOnlineStatusCallback() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            return;
        }
        OnlineStatusAggregationHandler onlineStatusAggregationHandler = (OnlineStatusAggregationHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(OnlineStatusAggregationHandler.class.getName());
        onlineStatusAggregationHandler.N2(null);
        onlineStatusAggregationHandler.M2(null);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusLikeStatusApi
    public void getLikeStatusUserReq(AppInterface appInterface, ArrayList<String> arrayList, com.tencent.qqnt.aio.api.g gVar, int i3) {
        OnlineStatusAggregationHandler onlineStatusAggregationHandler = (OnlineStatusAggregationHandler) appInterface.getBusinessHandler(OnlineStatusAggregationHandler.class.getName());
        onlineStatusAggregationHandler.N2(gVar);
        onlineStatusAggregationHandler.D2(arrayList, i3);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusLikeStatusApi
    public String getOnlineStatusAggregationHandlerName() {
        return OnlineStatusAggregationHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusLikeStatusApi
    public void sendLikeStatusReq(AppInterface appInterface, String str, int i3, int i16, int i17, com.tencent.qqnt.aio.api.f fVar, byte[] bArr) {
        OnlineStatusAggregationHandler onlineStatusAggregationHandler = (OnlineStatusAggregationHandler) appInterface.getBusinessHandler(OnlineStatusAggregationHandler.class.getName());
        onlineStatusAggregationHandler.M2(fVar);
        onlineStatusAggregationHandler.K2(str, i3, i16, i17, bArr);
    }
}
