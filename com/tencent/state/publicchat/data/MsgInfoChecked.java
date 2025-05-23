package com.tencent.state.publicchat.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/publicchat/data/MsgInfoChecked;", "", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "checked", "", "defaultChecked", "(Lcom/tencent/state/publicchat/data/MsgInfo;ZZ)V", "getChecked", "()Z", "setChecked", "(Z)V", "getDefaultChecked", "getMsg", "()Lcom/tencent/state/publicchat/data/MsgInfo;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MsgInfoChecked {
    private boolean checked;
    private final boolean defaultChecked;
    private final MsgInfo msg;

    public MsgInfoChecked(MsgInfo msg2, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.msg = msg2;
        this.checked = z16;
        this.defaultChecked = z17;
    }

    /* renamed from: component1, reason: from getter */
    public final MsgInfo getMsg() {
        return this.msg;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getDefaultChecked() {
        return this.defaultChecked;
    }

    public final MsgInfoChecked copy(MsgInfo msg2, boolean checked, boolean defaultChecked) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new MsgInfoChecked(msg2, checked, defaultChecked);
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final boolean getDefaultChecked() {
        return this.defaultChecked;
    }

    public final MsgInfo getMsg() {
        return this.msg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        MsgInfo msgInfo = this.msg;
        int hashCode = (msgInfo != null ? msgInfo.hashCode() : 0) * 31;
        boolean z16 = this.checked;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        boolean z17 = this.defaultChecked;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final void setChecked(boolean z16) {
        this.checked = z16;
    }

    public String toString() {
        return "MsgInfoChecked(msg=" + this.msg + ", checked=" + this.checked + ", defaultChecked=" + this.defaultChecked + ")";
    }

    public /* synthetic */ MsgInfoChecked(MsgInfo msgInfo, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(msgInfo, z16, (i3 & 4) != 0 ? false : z17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgInfoChecked)) {
            return false;
        }
        MsgInfoChecked msgInfoChecked = (MsgInfoChecked) other;
        return Intrinsics.areEqual(this.msg, msgInfoChecked.msg) && this.checked == msgInfoChecked.checked && this.defaultChecked == msgInfoChecked.defaultChecked;
    }

    public static /* synthetic */ MsgInfoChecked copy$default(MsgInfoChecked msgInfoChecked, MsgInfo msgInfo, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            msgInfo = msgInfoChecked.msg;
        }
        if ((i3 & 2) != 0) {
            z16 = msgInfoChecked.checked;
        }
        if ((i3 & 4) != 0) {
            z17 = msgInfoChecked.defaultChecked;
        }
        return msgInfoChecked.copy(msgInfo, z16, z17);
    }
}
