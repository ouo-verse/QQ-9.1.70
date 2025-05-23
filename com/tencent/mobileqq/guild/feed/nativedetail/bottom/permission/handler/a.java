package com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import wk1.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "getGuildId", "()Ljava/lang/String;", "guildId", "getChannelId", "channelId", "getTroopUin", "troopUin", "Lwk1/i;", "getDelegate", "()Lwk1/i;", "delegate", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a {
    @NotNull
    String getChannelId();

    @NotNull
    Context getContext();

    @NotNull
    i getDelegate();

    @NotNull
    String getGuildId();

    @NotNull
    String getTroopUin();
}
