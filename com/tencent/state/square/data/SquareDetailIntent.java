package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/data/SquareDetailIntent;", "", "targetMotionId", "", "(Ljava/lang/Integer;)V", "getTargetMotionId", "()Ljava/lang/Integer;", "setTargetMotionId", "Ljava/lang/Integer;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareDetailIntent {
    private Integer targetMotionId;

    public SquareDetailIntent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Integer getTargetMotionId() {
        return this.targetMotionId;
    }

    public final void setTargetMotionId(Integer num) {
        this.targetMotionId = num;
    }

    public SquareDetailIntent(Integer num) {
        this.targetMotionId = num;
    }

    public /* synthetic */ SquareDetailIntent(Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num);
    }
}
