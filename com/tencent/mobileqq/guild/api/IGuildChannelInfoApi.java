package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J=\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00030\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildChannelInfoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "fetchChannelInfoAnyway", "", "guildId", "", "channelId", "block", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "Lkotlin/ParameterName;", "name", "info", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildChannelInfoApi extends QRouteApi {
    void fetchChannelInfoAnyway(@NotNull String guildId, @NotNull String channelId, @NotNull Function1<? super IGProChannelInfo, Unit> block);
}
