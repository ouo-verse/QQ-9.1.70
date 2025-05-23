package com.tencent.guild.aio.msglist.holder.component;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleAvatarLongClickEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "a", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final /* data */ class GuildBubbleAvatarLongClickEvent implements MsgIntent {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GuildMsgItem msgItem;

    public GuildBubbleAvatarLongClickEvent(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        this.msgItem = msgItem;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GuildMsgItem getMsgItem() {
        return this.msgItem;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof GuildBubbleAvatarLongClickEvent) && Intrinsics.areEqual(this.msgItem, ((GuildBubbleAvatarLongClickEvent) other).msgItem)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    public int hashCode() {
        return this.msgItem.hashCode();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    @NotNull
    public String toString() {
        return "GuildBubbleAvatarLongClickEvent(msgItem=" + this.msgItem + ")";
    }
}
