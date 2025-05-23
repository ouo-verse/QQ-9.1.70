package com.tencent.mobileqq.guild.live.danmu.item;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/live/danmu/item/d;", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "", "b", "", "a", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull GuildMsgItem msgItem) {
        super(msgItem);
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
    }

    @Override // com.tencent.mobileqq.guild.live.danmu.item.a
    @NotNull
    public String a() {
        return "";
    }

    @Override // com.tencent.mobileqq.guild.live.danmu.item.a
    public int b() {
        return 2;
    }
}
