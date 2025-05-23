package com.tencent.guild.aio.msglist.holder.component.nick;

import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildReplyMsgNickState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "tinyId", "<init>", "(Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildReplyMsgNickState implements MviUIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String tinyId;

    public GuildReplyMsgNickState(@Nullable String str) {
        this.tinyId = str;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }
}
