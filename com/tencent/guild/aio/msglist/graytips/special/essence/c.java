package com.tencent.guild.aio.msglist.graytips.special.essence;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernelpublic.nativeinterface.EssenceElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/essence/c;", "Lol3/b;", "<init>", "()V", "a", "b", "Lcom/tencent/guild/aio/msglist/graytips/special/essence/c$a;", "Lcom/tencent/guild/aio/msglist/graytips/special/essence/c$b;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class c implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/essence/c$a;", "Lcom/tencent/guild/aio/msglist/graytips/special/essence/c;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;", "d", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;", "a", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;", "essenceElement", "<init>", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends c {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final EssenceElement essenceElement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull EssenceElement essenceElement) {
            super(null);
            Intrinsics.checkNotNullParameter(essenceElement, "essenceElement");
            this.essenceElement = essenceElement;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final EssenceElement getEssenceElement() {
            return this.essenceElement;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/essence/c$b;", "Lcom/tencent/guild/aio/msglist/graytips/special/essence/c;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "b", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;", "e", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;", "a", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;", "essenceElement", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends c {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildMsgItem guildMsgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final EssenceElement essenceElement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull GuildMsgItem guildMsgItem, @NotNull EssenceElement essenceElement) {
            super(null);
            Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
            Intrinsics.checkNotNullParameter(essenceElement, "essenceElement");
            this.guildMsgItem = guildMsgItem;
            this.essenceElement = essenceElement;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final EssenceElement getEssenceElement() {
            return this.essenceElement;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final GuildMsgItem getGuildMsgItem() {
            return this.guildMsgItem;
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    c() {
    }
}
