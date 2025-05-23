package com.tencent.guild.aio.msglist.reply;

import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/msglist/reply/GuildRefreshReplyNickEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "tinyId", "<init>", "(Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildRefreshReplyNickEvent implements MsgIntent {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tinyId;

    public GuildRefreshReplyNickEvent(@NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        this.tinyId = tinyId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }
}
