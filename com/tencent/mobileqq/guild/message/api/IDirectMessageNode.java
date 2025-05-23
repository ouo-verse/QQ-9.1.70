package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u0007H&J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000b\u001a\u00020\u0007H&\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/message/api/IDirectMessageNode;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addObserver", "", "observer", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "findResourceGuildIdByGuildId", "", "guildId", "getChannelUnreadCnt", "", "curFriendUin", "getDisplayName", "getGuildPeerName", "node", "", "getMessageSourceGuildIdByGuildId", "getRemarkName", "getSrcGuildId", "getSrcGuildName", "getSrcTinyId", "isCurGuild", "", "isDirectMessageNodeNotNull", "isDisturb", "(Ljava/lang/String;)Ljava/lang/Boolean;", "removeObserver", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IDirectMessageNode extends QRouteApi {
    void addObserver(@NotNull GPServiceObserver observer);

    @Nullable
    String findResourceGuildIdByGuildId(@NotNull String guildId);

    int getChannelUnreadCnt(@NotNull String curFriendUin);

    @Nullable
    String getDisplayName(@NotNull String curFriendUin);

    @NotNull
    String getGuildPeerName(@NotNull Object node);

    @Nullable
    String getMessageSourceGuildIdByGuildId(@NotNull String guildId);

    @Nullable
    String getRemarkName(@NotNull String curFriendUin);

    @Nullable
    String getSrcGuildId(@NotNull String curFriendUin);

    @Nullable
    String getSrcGuildName(@NotNull String curFriendUin);

    @Nullable
    String getSrcTinyId(@NotNull String curFriendUin);

    boolean isCurGuild(@NotNull Object node, @NotNull String guildId);

    boolean isDirectMessageNodeNotNull(@NotNull String guildId);

    @Nullable
    Boolean isDisturb(@NotNull String curFriendUin);

    void removeObserver(@NotNull GPServiceObserver observer);
}
