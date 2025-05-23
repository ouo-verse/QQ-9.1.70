package com.tencent.mobileqq.guild.summary.api;

import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.a;
import com.tencent.mobileqq.guild.message.unread.api.d;
import com.tencent.mobileqq.guild.message.unread.api.e;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/summary/api/IGuildSummaryUnreadLimitService;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/mobileqq/guild/summary/d;", "callback", "", "registerSummaryUpdateCallback", "unregisterSummaryUpdateCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/a;", "registerCategoryUnreadCallback", "unRegisterCategoryUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/e;", "registerGuildUnreadCallback", "unRegisterGuildUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/d;", "registerGuildTabUnreadCallback", "unRegisterGuildTabUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "getGuildTabUnreadCount", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface IGuildSummaryUnreadLimitService extends IRuntimeService {
    @NotNull
    UnreadInfo.a getGuildTabUnreadCount();

    void registerCategoryUnreadCallback(@NotNull a callback);

    void registerGuildTabUnreadCallback(@NotNull d callback);

    void registerGuildUnreadCallback(@NotNull e callback);

    void registerSummaryUpdateCallback(@NotNull com.tencent.mobileqq.guild.summary.d callback);

    void unRegisterCategoryUnreadCallback(@NotNull a callback);

    void unRegisterGuildTabUnreadCallback(@NotNull d callback);

    void unRegisterGuildUnreadCallback(@NotNull e callback);

    void unregisterSummaryUpdateCallback(@NotNull com.tencent.mobileqq.guild.summary.d callback);
}
