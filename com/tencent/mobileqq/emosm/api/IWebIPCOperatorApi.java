package com.tencent.mobileqq.emosm.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppService;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IWebIPCOperatorApi extends QRouteApi {
    void doBindService(Context context);

    void doBindService(Context context, Class<? extends AppService> cls);

    void doUnbindService(Context context);

    boolean isServiceClientBinded();

    void onBindSuc();

    void onDisconnectWithService();

    void onPushMsgFromServer(Bundle bundle);

    void onRespFromClient(Bundle bundle);

    void registerObserver(t tVar);

    void sendServiceIpcReq(Bundle bundle);

    void sendServiceIpcReqWithoutTimeout(Bundle bundle);

    void unRegisterObserver(t tVar);
}
