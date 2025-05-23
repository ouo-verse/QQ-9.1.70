package com.tencent.mobileqq.qqlive.api.supervision;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.supervision.QueryBanedHistoryCallback;
import com.tencent.mobileqq.qqlive.callback.supervision.QueryIsBanedChatCallback;
import com.tencent.mobileqq.qqlive.callback.supervision.SetBanChatCallback;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveBanChat extends IQQLiveModule {
    void banChat(long j3, long j16, long j17, int i3, SetBanChatCallback setBanChatCallback);

    void cancelBanChat(long j3, long j16, long j17, SetBanChatCallback setBanChatCallback);

    List<AdminReason> getBanChatReasonList();

    void isBanedChat(long j3, long j16, long j17, QueryIsBanedChatCallback queryIsBanedChatCallback);

    void queryBanedHistory(long j3, long j16, int i3, int i16, QueryBanedHistoryCallback queryBanedHistoryCallback);
}
