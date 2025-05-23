package com.tencent.mobileqq.guild.message.unread.api;

import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/api/IGuildTotalUnreadService;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "getGuildTabUnreadCount", "Lcom/tencent/mobileqq/guild/message/unread/api/g;", "getTotalCount", "Lcom/tencent/mobileqq/guild/message/unread/api/Source;", "source", "getUnreadCount", "Lcom/tencent/mobileqq/guild/message/unread/api/d;", "callback", "", "registerGuildTabUnreadCallback", "unRegisterGuildTabUnreadCallback", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface IGuildTotalUnreadService extends IRuntimeService {
    @NotNull
    UnreadInfo.a getGuildTabUnreadCount();

    @NotNull
    TotalUnreadCount getTotalCount();

    @NotNull
    UnreadInfo.a getUnreadCount(@NotNull Source source);

    void registerGuildTabUnreadCallback(@NotNull d callback);

    void unRegisterGuildTabUnreadCallback(@NotNull d callback);
}
