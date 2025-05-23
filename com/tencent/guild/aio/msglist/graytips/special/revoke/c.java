package com.tencent.guild.aio.msglist.graytips.special.revoke;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernelpublic.nativeinterface.RevokeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/revoke/c;", "Lol3/b;", "<init>", "()V", "a", "Lcom/tencent/guild/aio/msglist/graytips/special/revoke/c$a;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class c implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/revoke/c$a;", "Lcom/tencent/guild/aio/msglist/graytips/special/revoke/c;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "a", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "e", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "b", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "revokeElement", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends c {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildMsgItem guildMsgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RevokeElement revokeElement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull GuildMsgItem guildMsgItem, @NotNull RevokeElement revokeElement) {
            super(null);
            Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
            Intrinsics.checkNotNullParameter(revokeElement, "revokeElement");
            this.guildMsgItem = guildMsgItem;
            this.revokeElement = revokeElement;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildMsgItem getGuildMsgItem() {
            return this.guildMsgItem;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final RevokeElement getRevokeElement() {
            return this.revokeElement;
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    c() {
    }
}
