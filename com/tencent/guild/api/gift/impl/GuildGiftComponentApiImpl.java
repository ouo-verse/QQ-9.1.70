package com.tencent.guild.api.gift.impl;

import android.content.Context;
import com.tencent.aio.data.msglist.a;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.gift.GiftResourceLoader;
import com.tencent.guild.api.gift.GuildGiftView;
import com.tencent.guild.api.gift.IGuildGiftComponentApi;
import com.tencent.guild.api.gift.c;
import com.tencent.guild.api.gift.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/api/gift/impl/GuildGiftComponentApiImpl;", "Lcom/tencent/guild/api/gift/IGuildGiftComponentApi;", "Landroid/content/Context;", "context", "Lcom/tencent/guild/api/gift/j;", "createGiftView", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "preLoadGiftRes", "preLoadPag", "", "isPause", "setPause", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "", "selfTinyId", "needAutoShowAnim", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildGiftComponentApiImpl implements IGuildGiftComponentApi {
    @Override // com.tencent.guild.api.gift.IGuildGiftComponentApi
    @NotNull
    public j createGiftView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new GuildGiftView(context);
    }

    @Override // com.tencent.guild.api.gift.IGuildGiftComponentApi
    public boolean needAutoShowAnim(@NotNull GuildMsgItem guildMsgItem, @NotNull String selfTinyId) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        return c.f112540a.d(guildMsgItem, selfTinyId);
    }

    @Override // com.tencent.guild.api.gift.IGuildGiftComponentApi
    public void preLoadGiftRes(@NotNull a msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        GiftResourceLoader.f112513a.d(msgItem, null);
    }

    @Override // com.tencent.guild.api.gift.IGuildGiftComponentApi
    public void preLoadPag() {
        GiftResourceLoader.f112513a.e();
    }

    @Override // com.tencent.guild.api.gift.IGuildGiftComponentApi
    public void setPause(boolean isPause) {
        GuildGiftView.INSTANCE.c(isPause);
    }
}
