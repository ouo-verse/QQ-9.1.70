package com.tencent.state.square.interaction;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pt4.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0010\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0005\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionResult;", "", "", "component1", "component2", "isCritical", "isGotFlower", "copy", "", "toString", "", "hashCode", "other", "equals", "Z", "()Z", "<init>", "(ZZ)V", "Lpt4/n;", "pb", "(Lpt4/n;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionResult {
    private final boolean isCritical;
    private final boolean isGotFlower;

    public InteractionResult(boolean z16, boolean z17) {
        this.isCritical = z16;
        this.isGotFlower = z17;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsCritical() {
        return this.isCritical;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsGotFlower() {
        return this.isGotFlower;
    }

    public final InteractionResult copy(boolean isCritical, boolean isGotFlower) {
        return new InteractionResult(isCritical, isGotFlower);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isCritical;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        boolean z17 = this.isGotFlower;
        return i3 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final boolean isCritical() {
        return this.isCritical;
    }

    public final boolean isGotFlower() {
        return this.isGotFlower;
    }

    public String toString() {
        return "InteractionResult(isCritical=" + this.isCritical + ", isGotFlower=" + this.isGotFlower + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InteractionResult(n pb5) {
        this(pb5.f427190a, pb5.f427191b);
        Intrinsics.checkNotNullParameter(pb5, "pb");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionResult)) {
            return false;
        }
        InteractionResult interactionResult = (InteractionResult) other;
        return this.isCritical == interactionResult.isCritical && this.isGotFlower == interactionResult.isGotFlower;
    }

    public static /* synthetic */ InteractionResult copy$default(InteractionResult interactionResult, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = interactionResult.isCritical;
        }
        if ((i3 & 2) != 0) {
            z17 = interactionResult.isGotFlower;
        }
        return interactionResult.copy(z16, z17);
    }
}
