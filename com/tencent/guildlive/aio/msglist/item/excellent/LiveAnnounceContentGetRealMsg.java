package com.tencent.guildlive.aio.msglist.item.excellent;

import kotlin.Metadata;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/item/excellent/a;", "Lol3/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "seq", "<init>", "(J)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guildlive.aio.msglist.item.excellent.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class LiveAnnounceContentGetRealMsg implements b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long seq;

    public LiveAnnounceContentGetRealMsg(long j3) {
        this.seq = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getSeq() {
        return this.seq;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof LiveAnnounceContentGetRealMsg) && this.seq == ((LiveAnnounceContentGetRealMsg) other).seq) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return androidx.fragment.app.a.a(this.seq);
    }

    @NotNull
    public String toString() {
        return "LiveAnnounceContentGetRealMsg(seq=" + this.seq + ")";
    }
}
