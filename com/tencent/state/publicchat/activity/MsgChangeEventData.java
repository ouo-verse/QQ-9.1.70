package com.tencent.state.publicchat.activity;

import com.tencent.state.publicchat.data.MsgInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\tH\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/publicchat/activity/MsgChangeEventData;", "", "index", "", "count", "msgs", "", "Lcom/tencent/state/publicchat/data/MsgInfo;", "isAdd", "", "isDel", "(IILjava/util/List;ZZ)V", "getCount", "()I", "getIndex", "()Z", "getMsgs", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MsgChangeEventData {
    private final int count;
    private final int index;
    private final boolean isAdd;
    private final boolean isDel;
    private final List<MsgInfo> msgs;

    public MsgChangeEventData(int i3, int i16, List<MsgInfo> msgs, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(msgs, "msgs");
        this.index = i3;
        this.count = i16;
        this.msgs = msgs;
        this.isAdd = z16;
        this.isDel = z17;
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final List<MsgInfo> component3() {
        return this.msgs;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsAdd() {
        return this.isAdd;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsDel() {
        return this.isDel;
    }

    public final MsgChangeEventData copy(int index, int count, List<MsgInfo> msgs, boolean isAdd, boolean isDel) {
        Intrinsics.checkNotNullParameter(msgs, "msgs");
        return new MsgChangeEventData(index, count, msgs, isAdd, isDel);
    }

    public final int getCount() {
        return this.count;
    }

    public final int getIndex() {
        return this.index;
    }

    public final List<MsgInfo> getMsgs() {
        return this.msgs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((this.index * 31) + this.count) * 31;
        List<MsgInfo> list = this.msgs;
        int hashCode = (i3 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z16 = this.isAdd;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.isDel;
        return i17 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final boolean isAdd() {
        return this.isAdd;
    }

    public final boolean isDel() {
        return this.isDel;
    }

    public String toString() {
        return "index=" + this.index + "; count=" + this.count + "; isAdd=" + this.isAdd + "; isDel=" + this.isDel + "; msgsSize=" + this.msgs.size();
    }

    public /* synthetic */ MsgChangeEventData(int i3, int i16, List list, boolean z16, boolean z17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, list, (i17 & 8) != 0 ? false : z16, (i17 & 16) != 0 ? false : z17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgChangeEventData)) {
            return false;
        }
        MsgChangeEventData msgChangeEventData = (MsgChangeEventData) other;
        return this.index == msgChangeEventData.index && this.count == msgChangeEventData.count && Intrinsics.areEqual(this.msgs, msgChangeEventData.msgs) && this.isAdd == msgChangeEventData.isAdd && this.isDel == msgChangeEventData.isDel;
    }

    public static /* synthetic */ MsgChangeEventData copy$default(MsgChangeEventData msgChangeEventData, int i3, int i16, List list, boolean z16, boolean z17, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = msgChangeEventData.index;
        }
        if ((i17 & 2) != 0) {
            i16 = msgChangeEventData.count;
        }
        int i18 = i16;
        if ((i17 & 4) != 0) {
            list = msgChangeEventData.msgs;
        }
        List list2 = list;
        if ((i17 & 8) != 0) {
            z16 = msgChangeEventData.isAdd;
        }
        boolean z18 = z16;
        if ((i17 & 16) != 0) {
            z17 = msgChangeEventData.isDel;
        }
        return msgChangeEventData.copy(i3, i18, list2, z18, z17);
    }
}
