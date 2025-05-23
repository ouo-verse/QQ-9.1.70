package com.tencent.mobileqq.gamecenter.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameCenterArkMsgSenderApi extends QRouteApi {
    public static final int AIO_TYPE_C2C = 1;
    public static final int AIO_TYPE_GROUP = 2;

    void invokeFriendChooserThenSendArkMsg(String str, a aVar);

    void registerArkNotify();

    void sendArkMsg(String str, a aVar);

    void showRedPackFloatView(String str);

    void unRegisterArkNotify();
}
