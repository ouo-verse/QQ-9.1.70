package com.tencent.guild.aio.msglist.holder.component.nick;

import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildMsgNickState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "", "d", "I", "b", "()I", "updateType", "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "tinyId", "<init>", "(ILjava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMsgNickState implements MviUIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int updateType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String tinyId;

    public GuildMsgNickState(int i3, @Nullable String str) {
        this.updateType = i3;
        this.tinyId = str;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    /* renamed from: b, reason: from getter */
    public final int getUpdateType() {
        return this.updateType;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }
}
