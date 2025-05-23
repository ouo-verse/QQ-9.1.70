package com.tencent.guildlive.aio.msglist.holder.component;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/component/c;", "Lol3/b;", "", "d", "J", "a", "()J", "b", "(J)V", "firstMsgSeq", "<init>", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c implements ol3.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long firstMsgSeq;

    public c(long j3) {
        this.firstMsgSeq = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getFirstMsgSeq() {
        return this.firstMsgSeq;
    }

    public final void b(long j3) {
        this.firstMsgSeq = j3;
    }
}
