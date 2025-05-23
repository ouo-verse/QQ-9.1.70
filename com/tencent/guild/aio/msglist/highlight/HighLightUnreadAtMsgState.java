package com.tencent.guild.aio.msglist.highlight;

import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/highlight/HighLightUnreadAtMsgState;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "", "d", "J", "a", "()J", "newMsgSeq", "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "selfTid", "<init>", "(JLjava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class HighLightUnreadAtMsgState implements MsgListUiState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long newMsgSeq;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String selfTid;

    public HighLightUnreadAtMsgState(long j3, @NotNull String selfTid) {
        Intrinsics.checkNotNullParameter(selfTid, "selfTid");
        this.newMsgSeq = j3;
        this.selfTid = selfTid;
    }

    /* renamed from: a, reason: from getter */
    public final long getNewMsgSeq() {
        return this.newMsgSeq;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getSelfTid() {
        return this.selfTid;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
