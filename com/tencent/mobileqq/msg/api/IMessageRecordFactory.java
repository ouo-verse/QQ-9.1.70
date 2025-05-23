package com.tencent.mobileqq.msg.api;

import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMessageRecordFactory extends QRouteApi {
    @Nullable
    MessageRecord createMessageForStructing(BaseQQAppInterface baseQQAppInterface, String str, int i3, String str2, String str3);

    MessageRecord createMsgRecordByMsgType(int i3);

    MessageRecord createMsgRecordFromDB(int i3, byte[] bArr, int i16, String str, int i17);

    MessageRecord createResendMsg(MessageRecord messageRecord);

    MessageRecord createSendMSg_BlessPTV(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3);

    MessageRecord createSendMSg_Pic(AppInterface appInterface, String str, String str2, int i3);

    MessageRecord createSendMSg_ShortVideo(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3);

    MessageRecord createSendMSg_VideoEmoticon(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3);

    void setSendingMsgRecordBaseInfo(AppRuntime appRuntime, MessageRecord messageRecord, String str, String str2, int i3);
}
