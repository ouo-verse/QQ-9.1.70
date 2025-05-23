package com.tencent.guildmedia.aio.msglist.item.graytips;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/graytips/a;", "Lol3/b;", "<init>", "()V", "a", "b", "c", "Lcom/tencent/guildmedia/aio/msglist/item/graytips/a$a;", "Lcom/tencent/guildmedia/aio/msglist/item/graytips/a$b;", "Lcom/tencent/guildmedia/aio/msglist/item/graytips/a$c;", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class a implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/graytips/a$a;", "Lcom/tencent/guildmedia/aio/msglist/item/graytips/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "a", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guildmedia.aio.msglist.item.graytips.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1236a extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildMsgItem msgItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1236a(@NotNull GuildMsgItem msgItem) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            this.msgItem = msgItem;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildMsgItem getMsgItem() {
            return this.msgItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/graytips/a$b;", "Lcom/tencent/guildmedia/aio/msglist/item/graytips/a;", "", "d", "J", "a", "()J", "msgSeq", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long msgSeq;

        /* renamed from: a, reason: from getter */
        public final long getMsgSeq() {
            return this.msgSeq;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/graytips/a$c;", "Lcom/tencent/guildmedia/aio/msglist/item/graytips/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "a", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildMsgItem msgItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull GuildMsgItem msgItem) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            this.msgItem = msgItem;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildMsgItem getMsgItem() {
            return this.msgItem;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
