package com.tencent.mobileqq.emosm.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppService;

/* loaded from: classes6.dex */
public class WebIPCOperatorApiImpl implements IWebIPCOperatorApi {
    @Override // com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
    public void doBindService(Context context) {
        WebIPCOperator.h().g().doBindService(context, ((IEmosmService) QRoute.api(IEmosmService.class)).getMessengerServiceClass());
    }

    @Override // com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
    public void doUnbindService(Context context) {
        WebIPCOperator.h().g().doUnbindService(context);
    }

    @Override // com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
    public boolean isServiceClientBinded() {
        return WebIPCOperator.h().i();
    }

    @Override // com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
    public void onBindSuc() {
        WebIPCOperator.h().j();
    }

    @Override // com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
    public void onDisconnectWithService() {
        WebIPCOperator.h().k();
    }

    @Override // com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
    public void onPushMsgFromServer(Bundle bundle) {
        WebIPCOperator.h().l(bundle);
    }

    @Override // com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
    public void onRespFromClient(Bundle bundle) {
        WebIPCOperator.h().m(bundle);
    }

    @Override // com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
    public void registerObserver(t tVar) {
        WebIPCOperator.h().n(tVar);
    }

    @Override // com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
    public void sendServiceIpcReq(Bundle bundle) {
        WebIPCOperator.h().q(bundle);
    }

    @Override // com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
    public void sendServiceIpcReqWithoutTimeout(Bundle bundle) {
        WebIPCOperator.h().r(bundle);
    }

    @Override // com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
    public void unRegisterObserver(t tVar) {
        WebIPCOperator.h().t(tVar);
    }

    @Override // com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi
    public void doBindService(Context context, Class<? extends AppService> cls) {
        WebIPCOperator.h().g().doBindService(context, cls);
    }
}
