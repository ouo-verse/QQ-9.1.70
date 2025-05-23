package com.tencent.mobileqq.onlinestatus.tempapi.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.onlinestatus.tempapi.IOnlineStatusAIOTempApi;
import com.tencent.mobileqq.paiyipai.PaiYiPaiHandler;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusAIOTempApiImpl implements IOnlineStatusAIOTempApi {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends com.tencent.mobileqq.paiyipai.a {
        a(IOnlineStatusAIOTempApi.a aVar) {
        }

        @Override // com.tencent.mobileqq.paiyipai.a, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            throw null;
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.tempapi.IOnlineStatusAIOTempApi
    public BusinessObserver getPaiYiPaiObserver(AppInterface appInterface, IOnlineStatusAIOTempApi.a aVar) {
        return new a(aVar);
    }

    @Override // com.tencent.mobileqq.onlinestatus.tempapi.IOnlineStatusAIOTempApi
    public Manager helpGetFriendsManager(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return null;
        }
        return appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
    }

    @Override // com.tencent.mobileqq.onlinestatus.tempapi.IOnlineStatusAIOTempApi
    public void sendPaiYiPaiReq(AppInterface appInterface, String str, String str2) {
        ((PaiYiPaiHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.PAI_YI_PAI_HANDLER)).L2(str, str2, 0, 1);
    }
}
