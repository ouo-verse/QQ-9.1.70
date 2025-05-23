package com.tencent.mobileqq.structmsg.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IMsgStructing extends QRouteApi {
    void consumeStructMsgPicPre(MessageRecord messageRecord);

    MessageForPic getMessageForPic(MessageRecord messageRecord);

    boolean isMessageForStructing(MessageRecord messageRecord);

    void updateMsgAfterDownload(AppInterface appInterface, MessageRecord messageRecord, MessageForPic messageForPic);

    void updateMsgAfterUpload(AppInterface appInterface, MessageRecord messageRecord, String str, String str2, long j3, Long l3, String str3, int i3);

    void uploadPicConstructRichText(MessageRecord messageRecord, String str, String str2, long j3, Long l3, im_msg_body$RichText im_msg_body_richtext);
}
