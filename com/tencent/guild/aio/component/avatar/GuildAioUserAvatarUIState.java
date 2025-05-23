package com.tencent.guild.aio.component.avatar;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "JumpToSelfMsgState", "UpdateAvatarState", "Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState$JumpToSelfMsgState;", "Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState$UpdateAvatarState;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildAioUserAvatarUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState$JumpToSelfMsgState;", "Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState;", "", "d", "I", "b", "()I", "result", "", "e", "J", "a", "()J", "msgSeq", "<init>", "(IJ)V", "(J)V", "(I)V", "f", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class JumpToSelfMsgState extends GuildAioUserAvatarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int result;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long msgSeq;

        public JumpToSelfMsgState(int i3, long j3) {
            super(null);
            this.result = i3;
            this.msgSeq = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getMsgSeq() {
            return this.msgSeq;
        }

        /* renamed from: b, reason: from getter */
        public final int getResult() {
            return this.result;
        }

        public JumpToSelfMsgState(long j3) {
            this(0, j3);
        }

        public JumpToSelfMsgState(int i3) {
            this(i3, -1L);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState$UpdateAvatarState;", "Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "guildId", "<init>", "(Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UpdateAvatarState extends GuildAioUserAvatarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateAvatarState(@NotNull String guildId) {
            super(null);
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.guildId = guildId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }
    }

    public /* synthetic */ GuildAioUserAvatarUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GuildAioUserAvatarUIState() {
    }
}
