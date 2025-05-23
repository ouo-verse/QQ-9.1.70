package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.guild.data.GuildFeedJumpData;
import com.tencent.mobileqq.guild.data.GuildJumpBaseData;
import com.tencent.mobileqq.guild.data.GuildJumpData;
import com.tencent.mobileqq.guild.data.GuildLiveJumpData;
import com.tencent.mobileqq.guild.data.GuildScheduleJumpData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildMiniProgramApi extends QRouteApi {
    int getJoinedGuildCount();

    void joinGuild(GuildJumpBaseData guildJumpBaseData, Runnable runnable);

    void jumpToFeed(GuildFeedJumpData guildFeedJumpData);

    void jumpToGuild(GuildJumpBaseData guildJumpBaseData, String str);

    void jumpToGuild(GuildJumpData guildJumpData);

    void jumpToLiveRoom(GuildLiveJumpData guildLiveJumpData);

    void jumpToSchedule(GuildScheduleJumpData guildScheduleJumpData);

    void jumpToWebBrowser(String str);
}
