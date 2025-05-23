package com.tencent.state.service;

import com.tencent.state.api.SquareErrorData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/service/SetStatusResult;", "", "isSetStatusSuccess", "", "setCustomTextErrorData", "Lcom/tencent/state/api/SquareErrorData;", "(ZLcom/tencent/state/api/SquareErrorData;)V", "()Z", "getSetCustomTextErrorData", "()Lcom/tencent/state/api/SquareErrorData;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SetStatusResult {
    private final boolean isSetStatusSuccess;
    private final SquareErrorData setCustomTextErrorData;

    public SetStatusResult(boolean z16, SquareErrorData squareErrorData) {
        this.isSetStatusSuccess = z16;
        this.setCustomTextErrorData = squareErrorData;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsSetStatusSuccess() {
        return this.isSetStatusSuccess;
    }

    /* renamed from: component2, reason: from getter */
    public final SquareErrorData getSetCustomTextErrorData() {
        return this.setCustomTextErrorData;
    }

    public final SetStatusResult copy(boolean isSetStatusSuccess, SquareErrorData setCustomTextErrorData) {
        return new SetStatusResult(isSetStatusSuccess, setCustomTextErrorData);
    }

    public final SquareErrorData getSetCustomTextErrorData() {
        return this.setCustomTextErrorData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isSetStatusSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        SquareErrorData squareErrorData = this.setCustomTextErrorData;
        return i3 + (squareErrorData != null ? squareErrorData.hashCode() : 0);
    }

    public final boolean isSetStatusSuccess() {
        return this.isSetStatusSuccess;
    }

    public String toString() {
        return "SetStatusResult(isSetStatusSuccess=" + this.isSetStatusSuccess + ", setCustomTextErrorData=" + this.setCustomTextErrorData + ")";
    }

    public /* synthetic */ SetStatusResult(boolean z16, SquareErrorData squareErrorData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? null : squareErrorData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetStatusResult)) {
            return false;
        }
        SetStatusResult setStatusResult = (SetStatusResult) other;
        return this.isSetStatusSuccess == setStatusResult.isSetStatusSuccess && Intrinsics.areEqual(this.setCustomTextErrorData, setStatusResult.setCustomTextErrorData);
    }

    public static /* synthetic */ SetStatusResult copy$default(SetStatusResult setStatusResult, boolean z16, SquareErrorData squareErrorData, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = setStatusResult.isSetStatusSuccess;
        }
        if ((i3 & 2) != 0) {
            squareErrorData = setStatusResult.setCustomTextErrorData;
        }
        return setStatusResult.copy(z16, squareErrorData);
    }
}
