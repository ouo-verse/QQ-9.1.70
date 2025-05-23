package com.tencent.guild.aio.title;

import com.tencent.guild.aio.title.IGuildAioTitleUIState;
import com.tencent.mobileqq.guild.widget.GuildStateType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b#\u0010$R\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0003\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u0013\u0010\u001eR\"\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u000e\"\u0004\b\u000b\u0010\u0010\u00a8\u0006%"}, d2 = {"Lcom/tencent/guild/aio/title/GuildAioTitleGuildNameTextUIState;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "d", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "getType", "()Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "setType", "(Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;)V", "type", "", "e", "Z", "getResult", "()Z", "setResult", "(Z)V", "result", "", "f", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "name", "Lcom/tencent/mobileqq/guild/widget/GuildStateType;", h.F, "Lcom/tencent/mobileqq/guild/widget/GuildStateType;", "c", "()Lcom/tencent/mobileqq/guild/widget/GuildStateType;", "(Lcom/tencent/mobileqq/guild/widget/GuildStateType;)V", "stateType", "i", "b", "needHideGuest", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioTitleGuildNameTextUIState implements IGuildAioTitleUIState {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String name;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean needHideGuest;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IGuildAioTitleUIState.TYPE type = IGuildAioTitleUIState.TYPE.GUILDNAMETITLE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean result = true;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildStateType stateType = GuildStateType.NONE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/title/GuildAioTitleGuildNameTextUIState$a;", "", "", "name", "c", "Lcom/tencent/mobileqq/guild/widget/GuildStateType;", "stateType", "d", "", "needHideGuest", "b", "Lcom/tencent/guild/aio/title/GuildAioTitleGuildNameTextUIState;", "a", "Lcom/tencent/guild/aio/title/GuildAioTitleGuildNameTextUIState;", "state", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildAioTitleGuildNameTextUIState state = new GuildAioTitleGuildNameTextUIState();

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildAioTitleGuildNameTextUIState getState() {
            return this.state;
        }

        @NotNull
        public final a b(boolean needHideGuest) {
            this.state.e(needHideGuest);
            return this;
        }

        @NotNull
        public final a c(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.state.d(name);
            return this;
        }

        @NotNull
        public final a d(@NotNull GuildStateType stateType) {
            Intrinsics.checkNotNullParameter(stateType, "stateType");
            this.state.f(stateType);
            return this;
        }
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedHideGuest() {
        return this.needHideGuest;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GuildStateType getStateType() {
        return this.stateType;
    }

    public final void d(@Nullable String str) {
        this.name = str;
    }

    public final void e(boolean z16) {
        this.needHideGuest = z16;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    public final void f(@NotNull GuildStateType guildStateType) {
        Intrinsics.checkNotNullParameter(guildStateType, "<set-?>");
        this.stateType = guildStateType;
    }

    @Override // com.tencent.guild.aio.title.IGuildAioTitleUIState
    public boolean getResult() {
        return this.result;
    }

    @Override // com.tencent.guild.aio.title.IGuildAioTitleUIState
    @NotNull
    public IGuildAioTitleUIState.TYPE getType() {
        return this.type;
    }
}
