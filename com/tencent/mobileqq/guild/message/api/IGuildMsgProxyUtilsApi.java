package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildMsgProxyUtilsApi extends QRouteApi {
    boolean compGuildMsgContent(AppRuntime appRuntime, MessageRecord messageRecord, MessageRecord messageRecord2, boolean z16, boolean z17);

    int[] getLocalOnlyMsgTypes();

    void pretreatmentAIOMsg(int i3, List<MessageRecord> list, AppRuntime appRuntime);

    void sortMsg(List<MessageRecord> list);

    List<MessageRecord> transToCompatMsgType(List<MsgRecord> list, String str, String str2);
}
