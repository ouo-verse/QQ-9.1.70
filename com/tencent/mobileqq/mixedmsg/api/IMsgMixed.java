package com.tencent.mobileqq.mixedmsg.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMsgMixed extends QRouteApi {
    void copyBaseInfoFromMixedToPic(MessageForPic messageForPic, MessageRecord messageRecord);

    List<MessageRecord> getElementList(MessageRecord messageRecord);

    MessageRecord getMessageForPic(MessageRecord messageRecord, long j3);

    boolean isMessageForMixedMsg(MessageRecord messageRecord);

    MessageRecord updateMixmsgBySVMsg(MessageRecord messageRecord, MessageRecord messageRecord2, int i3);

    void updateMsgAfterDownload(AppInterface appInterface, MessageRecord messageRecord, MessageForPic messageForPic);
}
