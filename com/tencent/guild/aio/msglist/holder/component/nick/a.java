package com.tencent.guild.aio.msglist.holder.component.nick;

import com.tencent.guild.aio.util.h;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/a;", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "payloads", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.guild.aio.msglist.holder.component.nick.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1202a {
        @Nullable
        public static h.MemberRoleInfo a(@NotNull a aVar, @NotNull GuildMsgItem msgItem) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            return com.tencent.guild.aio.util.h.f112401a.d(msgItem);
        }

        public static int b(@NotNull a aVar, @NotNull GuildMsgItem msgItem) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            return com.tencent.guild.aio.util.h.j(com.tencent.guild.aio.util.h.f112401a, msgItem, 0L, 2, null);
        }

        public static void c(@NotNull a aVar, @NotNull GuildMsgItem msgItem, int i3) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        }
    }

    void a(@NotNull GuildMsgItem msgItem, @NotNull List<Object> payloads);
}
