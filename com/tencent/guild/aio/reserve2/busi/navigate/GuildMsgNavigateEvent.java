package com.tencent.guild.aio.reserve2.busi.navigate;

import androidx.fragment.app.a;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "GuildNavigateToAIOBottomEvent", "GuildNavigateToMsgEvent", "NavigateCompleteEvent", "NotifyMsgFocusBottomEvent", "Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent$GuildNavigateToAIOBottomEvent;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent$GuildNavigateToMsgEvent;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent$NavigateCompleteEvent;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent$NotifyMsgFocusBottomEvent;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildMsgNavigateEvent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent$GuildNavigateToAIOBottomEvent;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "source", "<init>", "(Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildNavigateToAIOBottomEvent extends GuildMsgNavigateEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildNavigateToAIOBottomEvent(@NotNull String source) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GuildNavigateToAIOBottomEvent) && Intrinsics.areEqual(this.source, ((GuildNavigateToAIOBottomEvent) other).source)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.source.hashCode();
        }

        @NotNull
        public String toString() {
            return "GuildNavigateToAIOBottomEvent(source=" + this.source + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent$GuildNavigateToMsgEvent;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "source", "", "e", "J", "a", "()J", "msgSeq", "<init>", "(Ljava/lang/String;J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildNavigateToMsgEvent extends GuildMsgNavigateEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final long msgSeq;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildNavigateToMsgEvent(@NotNull String source, long j3) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.msgSeq = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getMsgSeq() {
            return this.msgSeq;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildNavigateToMsgEvent)) {
                return false;
            }
            GuildNavigateToMsgEvent guildNavigateToMsgEvent = (GuildNavigateToMsgEvent) other;
            if (Intrinsics.areEqual(this.source, guildNavigateToMsgEvent.source) && this.msgSeq == guildNavigateToMsgEvent.msgSeq) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.source.hashCode() * 31) + a.a(this.msgSeq);
        }

        @NotNull
        public String toString() {
            return "GuildNavigateToMsgEvent(source=" + this.source + ", msgSeq=" + this.msgSeq + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent$NavigateCompleteEvent;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class NavigateCompleteEvent extends GuildMsgNavigateEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final NavigateCompleteEvent f112240d = new NavigateCompleteEvent();

        NavigateCompleteEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent$NotifyMsgFocusBottomEvent;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/GuildMsgNavigateEvent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class NotifyMsgFocusBottomEvent extends GuildMsgNavigateEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final NotifyMsgFocusBottomEvent f112241d = new NotifyMsgFocusBottomEvent();

        NotifyMsgFocusBottomEvent() {
            super(null);
        }
    }

    public /* synthetic */ GuildMsgNavigateEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    GuildMsgNavigateEvent() {
    }
}
