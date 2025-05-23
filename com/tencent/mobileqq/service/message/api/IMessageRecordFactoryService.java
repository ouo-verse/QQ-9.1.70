package com.tencent.mobileqq.service.message.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IMessageRecordFactoryService extends QRouteApi {
    MessageRecord createMsgRecordByMsgType(int i3);
}
