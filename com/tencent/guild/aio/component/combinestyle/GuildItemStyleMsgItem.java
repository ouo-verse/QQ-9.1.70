package com.tencent.guild.aio.component.combinestyle;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/GuildItemStyleMsgItem;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "", "getViewType", "Lcom/tencent/guild/aio/component/combinestyle/i;", "guildMediaAioCombineStyleChain", "Lcom/tencent/guild/aio/component/combinestyle/i;", "getGuildMediaAioCombineStyleChain", "()Lcom/tencent/guild/aio/component/combinestyle/i;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/guild/aio/component/combinestyle/i;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildItemStyleMsgItem extends GuildMsgItem {

    @NotNull
    private final GuildMediaAioCombineStyleChain guildMediaAioCombineStyleChain;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildItemStyleMsgItem(@NotNull GuildMediaAioCombineStyleChain guildMediaAioCombineStyleChain, @NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(guildMediaAioCombineStyleChain, "guildMediaAioCombineStyleChain");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        this.guildMediaAioCombineStyleChain = guildMediaAioCombineStyleChain;
    }

    @NotNull
    public final GuildMediaAioCombineStyleChain getGuildMediaAioCombineStyleChain() {
        return this.guildMediaAioCombineStyleChain;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        return com.tencent.mobileqq.guild.message.a.f230108a.c();
    }
}
