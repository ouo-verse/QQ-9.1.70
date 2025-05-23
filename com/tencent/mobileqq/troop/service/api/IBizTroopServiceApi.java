package com.tencent.mobileqq.troop.service.api;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IBizTroopServiceApi extends QRouteApi {
    Object handleDecode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    boolean handleRequest(ToServiceMsg toServiceMsg, UniPacket uniPacket);
}
