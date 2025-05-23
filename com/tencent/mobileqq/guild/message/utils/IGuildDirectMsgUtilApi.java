package com.tencent.mobileqq.guild.message.utils;

import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/message/utils/IGuildDirectMsgUtilApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "", "isDirectMsg", "", "channelId", "hasDirectMsgFlag", "", "getGuildId", "getSourceGuildId", "guildId", "isGuest", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildDirectMsgUtilApi extends QRouteApi {
    long getGuildId(@NotNull String channelId);

    long getSourceGuildId(@NotNull String channelId);

    boolean hasDirectMsgFlag(@NotNull String channelId);

    boolean isDirectMsg(@NotNull p sessionInfo);

    boolean isGuest(@NotNull String guildId);
}
