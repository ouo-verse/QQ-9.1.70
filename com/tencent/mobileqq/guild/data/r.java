package com.tencent.mobileqq.guild.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u00020\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/data/r;", "Lcom/tencent/mobileqq/guild/data/s;", "", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "getChannelId", "setChannelId", "channelId", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface r extends s {
    @NotNull
    String getChannelId();

    @NotNull
    String getGuildId();

    void setChannelId(@NotNull String str);

    void setGuildId(@NotNull String str);
}
