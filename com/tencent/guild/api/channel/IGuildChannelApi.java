package com.tencent.guild.api.channel;

import android.widget.ImageView;
import com.tencent.aio.api.runtime.a;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\bH&J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\bH&J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH&J\b\u0010\u0019\u001a\u00020\u000fH&J\b\u0010\u001a\u001a\u00020\bH&J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH&J\u001b\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/api/channel/IGuildChannelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/widget/ImageView;", "view", "Lcom/tencent/aio/data/AIOContact;", "contact", "", "getChannelAvatar", "", "getChannelName", "", "getChannelNoticeFlag", "onChannelDetailClick", "getCurrentThemeId", "factoryName", "", "isInLiveChannel", "channelId", "guildId", "isSelfGuest", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "isVisibleForGuest", "isInteractiveForGuest", "isNeedRealNameForGuest", "isFaceAuthVerified", "getFaceAuthVerifyUrl", "isMutedForGuest", "channelReadOnly", "updateGuildInfo", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateChannelInfo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildChannelApi extends QRouteApi {
    boolean channelReadOnly(@NotNull String guildId, @NotNull String channelId);

    void getChannelAvatar(@NotNull ImageView view, @NotNull AIOContact contact);

    @NotNull
    String getChannelName(@NotNull AIOContact contact);

    int getChannelNoticeFlag(@NotNull AIOContact contact);

    @NotNull
    String getCurrentThemeId();

    @NotNull
    String getFaceAuthVerifyUrl();

    boolean isFaceAuthVerified();

    boolean isInLiveChannel(@NotNull String factoryName);

    boolean isInteractiveForGuest(@NotNull String channelId, @NotNull String guildId);

    boolean isMutedForGuest(@NotNull String guildId);

    boolean isNeedRealNameForGuest(@NotNull String channelId, @NotNull String guildId);

    boolean isSelfGuest(@NotNull a aioContext, @NotNull String guildId);

    boolean isSelfGuest(@NotNull String channelId, @NotNull String guildId);

    boolean isVisibleForGuest(@NotNull String channelId, @NotNull String guildId);

    void onChannelDetailClick();

    @Nullable
    Object updateChannelInfo(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Integer> continuation);

    @Nullable
    Object updateGuildInfo(@NotNull String str, @NotNull Continuation<? super Integer> continuation);
}
