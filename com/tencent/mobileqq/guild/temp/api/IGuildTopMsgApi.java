package com.tencent.mobileqq.guild.temp.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes14.dex */
public interface IGuildTopMsgApi extends QRouteApi {
    void notifyRefreshTopChatPie(String str, String str2);

    MessageRecord queryTopMsgItemByShmsgseq(String str, String str2, long j3);

    void updateTopMessage(String str, String str2, MessageRecord messageRecord, boolean z16);
}
