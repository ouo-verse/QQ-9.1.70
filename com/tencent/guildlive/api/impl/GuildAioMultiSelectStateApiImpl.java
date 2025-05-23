package com.tencent.guildlive.api.impl;

import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guildlive.api.IGuildAioMultiSelectStateApi;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/guildlive/api/impl/GuildAioMultiSelectStateApiImpl;", "Lcom/tencent/guildlive/api/IGuildAioMultiSelectStateApi;", "()V", "isMultiSelect", "", "channelId", "", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildAioMultiSelectStateApiImpl implements IGuildAioMultiSelectStateApi {
    @Override // com.tencent.guildlive.api.IGuildAioMultiSelectStateApi
    public boolean isMultiSelect(@Nullable String channelId) {
        boolean z16;
        if (channelId != null && channelId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(channelId, FromScene.DEFAULT.ordinal()));
    }
}
