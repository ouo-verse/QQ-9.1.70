package com.tencent.guild.aio.factory.business.holder.msglist;

import com.tencent.aio.base.mvi.part.MsgListUiState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "()V", "GuildInitFirstMsgSeq", "GuildInputBarHeightChangeDataState", "GuildMsgItemChangedState", "GuildMsgItemChangedStateWithPayload", "GuildMsgItemRemoveState", "GuildMsgListTopMarginChangeState", "GuildOnThemeChanged", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildInitFirstMsgSeq;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildInputBarHeightChangeDataState;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildMsgItemChangedState;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildMsgItemChangedStateWithPayload;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildMsgItemRemoveState;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildMsgListTopMarginChangeState;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildOnThemeChanged;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildMsgListViewState implements MsgListUiState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildInitFirstMsgSeq;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "seq", "<init>", "(J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildInitFirstMsgSeq extends GuildMsgListViewState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long seq;

        public GuildInitFirstMsgSeq(long j3) {
            super(null);
            this.seq = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getSeq() {
            return this.seq;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GuildInitFirstMsgSeq) && this.seq == ((GuildInitFirstMsgSeq) other).seq) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.seq);
        }

        @NotNull
        public String toString() {
            return "GuildInitFirstMsgSeq(seq=" + this.seq + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildInputBarHeightChangeDataState;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState;", "", "d", "I", "a", "()I", "height", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildInputBarHeightChangeDataState extends GuildMsgListViewState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int height;

        public GuildInputBarHeightChangeDataState(int i3) {
            super(null);
            this.height = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildMsgItemChangedState;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", com.tencent.luggage.wxa.c8.c.G, "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildMsgItemChangedState extends GuildMsgListViewState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pos;

        public GuildMsgItemChangedState(int i3) {
            super(null);
            this.pos = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getPos() {
            return this.pos;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GuildMsgItemChangedState) && this.pos == ((GuildMsgItemChangedState) other).pos) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.pos;
        }

        @NotNull
        public String toString() {
            return "GuildMsgItemChangedState(pos=" + this.pos + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildMsgItemChangedStateWithPayload;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", com.tencent.luggage.wxa.c8.c.G, "e", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "payloads", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildMsgItemChangedStateWithPayload extends GuildMsgListViewState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pos;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Object payloads;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Object getPayloads() {
            return this.payloads;
        }

        /* renamed from: b, reason: from getter */
        public final int getPos() {
            return this.pos;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildMsgItemChangedStateWithPayload)) {
                return false;
            }
            GuildMsgItemChangedStateWithPayload guildMsgItemChangedStateWithPayload = (GuildMsgItemChangedStateWithPayload) other;
            if (this.pos == guildMsgItemChangedStateWithPayload.pos && Intrinsics.areEqual(this.payloads, guildMsgItemChangedStateWithPayload.payloads)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.pos * 31) + this.payloads.hashCode();
        }

        @NotNull
        public String toString() {
            return "GuildMsgItemChangedStateWithPayload(pos=" + this.pos + ", payloads=" + this.payloads + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildMsgItemRemoveState;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", com.tencent.luggage.wxa.c8.c.G, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildMsgItemRemoveState extends GuildMsgListViewState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pos;

        /* renamed from: a, reason: from getter */
        public final int getPos() {
            return this.pos;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GuildMsgItemRemoveState) && this.pos == ((GuildMsgItemRemoveState) other).pos) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.pos;
        }

        @NotNull
        public String toString() {
            return "GuildMsgItemRemoveState(pos=" + this.pos + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildMsgListTopMarginChangeState;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState;", "", "d", "I", "a", "()I", "topMargin", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildMsgListTopMarginChangeState extends GuildMsgListViewState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int topMargin;

        public GuildMsgListTopMarginChangeState(int i3) {
            super(null);
            this.topMargin = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getTopMargin() {
            return this.topMargin;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState$GuildOnThemeChanged;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListViewState;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GuildOnThemeChanged extends GuildMsgListViewState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GuildOnThemeChanged f110457d = new GuildOnThemeChanged();

        GuildOnThemeChanged() {
            super(null);
        }
    }

    public /* synthetic */ GuildMsgListViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    GuildMsgListViewState() {
    }
}
