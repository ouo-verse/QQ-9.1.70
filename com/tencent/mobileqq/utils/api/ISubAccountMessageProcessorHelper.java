package com.tencent.mobileqq.utils.api;

import PushNotifyPack.RequestPushNotify;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface ISubAccountMessageProcessorHelper extends QRouteApi {
    String buildBaseMsg(AppInterface appInterface, MessageRecord messageRecord, String str);

    MessageRecord createMsgRecordByMsgType(int i3);

    boolean isMessageFuDai(MessageRecord messageRecord);

    boolean isMessagePubAccount(MessageRecord messageRecord);

    boolean isRedPacketMsg(MessageRecord messageRecord);

    void processSubAccountRevokeNotify(AppInterface appInterface, RequestPushNotify requestPushNotify);
}
