package com.tencent.mobileqq.guild.temp.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes14.dex */
public interface IGuildArticleMsgApi extends QRouteApi {
    boolean judgeActivityIsArticleMsgDetailFragment(Object obj);

    boolean judgeFragmentIsArticleMsgDetailFragment(Object obj);

    void notifyArticleMessageListUpdate(String str, String str2, List<MessageRecord> list, boolean z16);

    void notifyArticleMessageRevoke(String str, String str2, long j3);

    void notifyRefreshArticleChatPie(String str, String str2);

    MessageRecord queryArticleMsgItemByShmsgseq(String str, String str2, long j3);

    void updateArticleMessage(String str, String str2, MessageRecord messageRecord, boolean z16);
}
