package com.tencent.mobileqq.guild.summary.api;

import com.tencent.mobileqq.guild.summary.GuildSummaryData;
import com.tencent.mobileqq.guild.summary.d;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0010\u001a\u00020\u000bH&J(\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0011j\b\u0012\u0004\u0012\u00020\u0002`\u0012H&J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/summary/api/IGuildSummaryApi;", "Lmqq/app/api/IRuntimeService;", "", "guildId", "channelId", "", "isDirect", "Lcom/tencent/mobileqq/guild/summary/a;", "getSummary", "Lcom/tencent/mobileqq/guild/summary/d;", "callback", "", "registerSummaryUpdateCallback", "unregisterSummaryUpdateCallback", "getGuestSummary", "batchFetchSummary", "clearGuestSummary", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "channelIds", "refreshGuestGuildSummary", "registerGuestSummaryUpdateCallback", "unregisterGuestSummaryUpdateCallback", "removeSummary", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface IGuildSummaryApi extends IRuntimeService {
    void batchFetchSummary(@NotNull String guildId);

    void clearGuestSummary();

    @NotNull
    GuildSummaryData getGuestSummary(@NotNull String guildId, @NotNull String channelId);

    @NotNull
    GuildSummaryData getSummary(@NotNull String guildId, @NotNull String channelId, boolean isDirect);

    void refreshGuestGuildSummary(@NotNull String guildId, @NotNull ArrayList<String> channelIds);

    void registerGuestSummaryUpdateCallback(@NotNull d callback);

    void registerSummaryUpdateCallback(@NotNull d callback);

    void removeSummary(@NotNull String guildId, @NotNull String channelId);

    void unregisterGuestSummaryUpdateCallback(@NotNull d callback);

    void unregisterSummaryUpdateCallback(@NotNull d callback);
}
