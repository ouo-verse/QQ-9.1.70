package com.tencent.mobileqq.ptt.temp.api;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPttTempApi extends QRouteApi {
    void doOnPttSrvAddressError(boolean z16, String str);

    Message getLastMessage(AppRuntime appRuntime, String str, int i3);

    MessageRecord getMsgItemByUniseq(AppRuntime appRuntime, String str, int i3, long j3);

    int getPttVipFlag(AppRuntime appRuntime, String str);

    boolean isHotChat(AppRuntime appRuntime, String str);

    void sendMessage(AppRuntime appRuntime, MessageRecord messageRecord, BaseMessageObserver baseMessageObserver);

    void setJsPttLocalPath(String str);

    void setJsPttServerId(String str);

    void updateMsgContentByUniseq(AppRuntime appRuntime, String str, int i3, long j3, byte[] bArr);
}
