package com.tencent.state.square.like;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/like/LikeResult;", "", "errorCode", "", "isGotFlower", "", "(IZ)V", "getErrorCode", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class LikeResult {
    private final int errorCode;
    private final boolean isGotFlower;

    public LikeResult(int i3, boolean z16) {
        this.errorCode = i3;
        this.isGotFlower = z16;
    }

    /* renamed from: component1, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsGotFlower() {
        return this.isGotFlower;
    }

    public final LikeResult copy(int errorCode, boolean isGotFlower) {
        return new LikeResult(errorCode, isGotFlower);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.errorCode * 31;
        boolean z16 = this.isGotFlower;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    public final boolean isGotFlower() {
        return this.isGotFlower;
    }

    public String toString() {
        return "LikeResult(errorCode=" + this.errorCode + ", isGotFlower=" + this.isGotFlower + ")";
    }

    public /* synthetic */ LikeResult(int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? false : z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LikeResult)) {
            return false;
        }
        LikeResult likeResult = (LikeResult) other;
        return this.errorCode == likeResult.errorCode && this.isGotFlower == likeResult.isGotFlower;
    }

    public static /* synthetic */ LikeResult copy$default(LikeResult likeResult, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = likeResult.errorCode;
        }
        if ((i16 & 2) != 0) {
            z16 = likeResult.isGotFlower;
        }
        return likeResult.copy(i3, z16);
    }
}
