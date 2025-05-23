package com.tencent.state.publicchat.component;

import com.tencent.state.publicchat.data.MsgInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/publicchat/component/MsgsWithSequence;", "", "seq", "", "msgs", "", "Lcom/tencent/state/publicchat/data/MsgInfo;", "(ILjava/util/List;)V", "getMsgs", "()Ljava/util/List;", "getSeq", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MsgsWithSequence {
    private final List<MsgInfo> msgs;
    private final int seq;

    public MsgsWithSequence(int i3, List<MsgInfo> msgs) {
        Intrinsics.checkNotNullParameter(msgs, "msgs");
        this.seq = i3;
        this.msgs = msgs;
    }

    /* renamed from: component1, reason: from getter */
    public final int getSeq() {
        return this.seq;
    }

    public final List<MsgInfo> component2() {
        return this.msgs;
    }

    public final MsgsWithSequence copy(int seq, List<MsgInfo> msgs) {
        Intrinsics.checkNotNullParameter(msgs, "msgs");
        return new MsgsWithSequence(seq, msgs);
    }

    public final List<MsgInfo> getMsgs() {
        return this.msgs;
    }

    public final int getSeq() {
        return this.seq;
    }

    public int hashCode() {
        int i3 = this.seq * 31;
        List<MsgInfo> list = this.msgs;
        return i3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "MsgsWithSequence(seq=" + this.seq + ", msgs=" + this.msgs + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgsWithSequence)) {
            return false;
        }
        MsgsWithSequence msgsWithSequence = (MsgsWithSequence) other;
        return this.seq == msgsWithSequence.seq && Intrinsics.areEqual(this.msgs, msgsWithSequence.msgs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MsgsWithSequence copy$default(MsgsWithSequence msgsWithSequence, int i3, List list, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = msgsWithSequence.seq;
        }
        if ((i16 & 2) != 0) {
            list = msgsWithSequence.msgs;
        }
        return msgsWithSequence.copy(i3, list);
    }
}
