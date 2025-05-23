package com.tencent.guild.aio.title;

import com.tencent.guild.aio.title.IGuildAioTitleUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/aio/title/GuildAioTitleTextUIState;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "d", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "getType", "()Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "setType", "(Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;)V", "type", "", "e", "Z", "getResult", "()Z", "c", "(Z)V", "result", "", "f", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "name", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioTitleTextUIState implements IGuildAioTitleUIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IGuildAioTitleUIState.TYPE type = IGuildAioTitleUIState.TYPE.TITLE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean result = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String name;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/aio/title/GuildAioTitleTextUIState$a;", "", "", "result", "c", "", "name", "b", "Lcom/tencent/guild/aio/title/GuildAioTitleTextUIState;", "a", "Lcom/tencent/guild/aio/title/GuildAioTitleTextUIState;", "state", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildAioTitleTextUIState state = new GuildAioTitleTextUIState();

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildAioTitleTextUIState getState() {
            return this.state;
        }

        @NotNull
        public final a b(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.state.b(name);
            return this;
        }

        @NotNull
        public final a c(boolean result) {
            this.state.c(result);
            return this;
        }
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final void b(@Nullable String str) {
        this.name = str;
    }

    public void c(boolean z16) {
        this.result = z16;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
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
