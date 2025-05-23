package com.tencent.mobileqq.service.message.api;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IMessageHandlerService extends QRouteApi {
    void getRoamMsgInOneDay(AppRuntime appRuntime, String str, long j3, short s16, Bundle bundle, long j16);

    void handleGetBlackList(AppInterface appInterface, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj);
}
