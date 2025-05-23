package com.tencent.guild.aio.title;

import com.tencent.guild.aio.title.IGuildAioTitleUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#R\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/guild/aio/title/GuildAioTitleCheckLoadDataUIState;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "d", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "getType", "()Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "setType", "(Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;)V", "type", "", "e", "Z", "getResult", "()Z", "setResult", "(Z)V", "result", "", "f", "I", "getChatType", "()I", "b", "(I)V", "chatType", "", h.F, "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", "channelId", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioTitleCheckLoadDataUIState implements IGuildAioTitleUIState {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int chatType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IGuildAioTitleUIState.TYPE type = IGuildAioTitleUIState.TYPE.LOAD_DATA;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean result = true;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String channelId = "";

    public final void a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    public final void b(int i3) {
        this.chatType = i3;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
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
