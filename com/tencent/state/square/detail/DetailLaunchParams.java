package com.tencent.state.square.detail;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ<\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/detail/DetailLaunchParams;", "", "autoEnterEditState", "", "curStatusId", "", "curRichStatusId", "curActionId", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAutoEnterEditState", "()Z", "setAutoEnterEditState", "(Z)V", "getCurActionId", "()Ljava/lang/Integer;", "setCurActionId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCurRichStatusId", "setCurRichStatusId", "getCurStatusId", "setCurStatusId", "component1", "component2", "component3", "component4", "copy", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/state/square/detail/DetailLaunchParams;", "equals", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class DetailLaunchParams {
    private boolean autoEnterEditState;
    private Integer curActionId;
    private Integer curRichStatusId;
    private Integer curStatusId;

    public DetailLaunchParams() {
        this(false, null, null, null, 15, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getAutoEnterEditState() {
        return this.autoEnterEditState;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getCurStatusId() {
        return this.curStatusId;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getCurRichStatusId() {
        return this.curRichStatusId;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getCurActionId() {
        return this.curActionId;
    }

    public final DetailLaunchParams copy(boolean autoEnterEditState, Integer curStatusId, Integer curRichStatusId, Integer curActionId) {
        return new DetailLaunchParams(autoEnterEditState, curStatusId, curRichStatusId, curActionId);
    }

    public final boolean getAutoEnterEditState() {
        return this.autoEnterEditState;
    }

    public final Integer getCurActionId() {
        return this.curActionId;
    }

    public final Integer getCurRichStatusId() {
        return this.curRichStatusId;
    }

    public final Integer getCurStatusId() {
        return this.curStatusId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.autoEnterEditState;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        Integer num = this.curStatusId;
        int hashCode = (i3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.curRichStatusId;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.curActionId;
        return hashCode2 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setAutoEnterEditState(boolean z16) {
        this.autoEnterEditState = z16;
    }

    public final void setCurActionId(Integer num) {
        this.curActionId = num;
    }

    public final void setCurRichStatusId(Integer num) {
        this.curRichStatusId = num;
    }

    public final void setCurStatusId(Integer num) {
        this.curStatusId = num;
    }

    public String toString() {
        return "DetailLaunchParams(autoEnterEditState=" + this.autoEnterEditState + ", curStatusId=" + this.curStatusId + ", curRichStatusId=" + this.curRichStatusId + ", curActionId=" + this.curActionId + ")";
    }

    public DetailLaunchParams(boolean z16, Integer num, Integer num2, Integer num3) {
        this.autoEnterEditState = z16;
        this.curStatusId = num;
        this.curRichStatusId = num2;
        this.curActionId = num3;
    }

    public /* synthetic */ DetailLaunchParams(boolean z16, Integer num, Integer num2, Integer num3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : num3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DetailLaunchParams)) {
            return false;
        }
        DetailLaunchParams detailLaunchParams = (DetailLaunchParams) other;
        return this.autoEnterEditState == detailLaunchParams.autoEnterEditState && Intrinsics.areEqual(this.curStatusId, detailLaunchParams.curStatusId) && Intrinsics.areEqual(this.curRichStatusId, detailLaunchParams.curRichStatusId) && Intrinsics.areEqual(this.curActionId, detailLaunchParams.curActionId);
    }

    public static /* synthetic */ DetailLaunchParams copy$default(DetailLaunchParams detailLaunchParams, boolean z16, Integer num, Integer num2, Integer num3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = detailLaunchParams.autoEnterEditState;
        }
        if ((i3 & 2) != 0) {
            num = detailLaunchParams.curStatusId;
        }
        if ((i3 & 4) != 0) {
            num2 = detailLaunchParams.curRichStatusId;
        }
        if ((i3 & 8) != 0) {
            num3 = detailLaunchParams.curActionId;
        }
        return detailLaunchParams.copy(z16, num, num2, num3);
    }
}
