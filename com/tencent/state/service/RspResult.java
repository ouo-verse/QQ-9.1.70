package com.tencent.state.service;

import com.tencent.state.api.SquareErrorData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/service/RspResult;", "", "success", "", "data", "Lcom/tencent/state/api/SquareErrorData;", "(ZLcom/tencent/state/api/SquareErrorData;)V", "getData", "()Lcom/tencent/state/api/SquareErrorData;", "getSuccess", "()Z", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class RspResult {
    private final SquareErrorData data;
    private final boolean success;

    public RspResult(boolean z16, SquareErrorData squareErrorData) {
        this.success = z16;
        this.data = squareErrorData;
    }

    public final SquareErrorData getData() {
        return this.data;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public /* synthetic */ RspResult(boolean z16, SquareErrorData squareErrorData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? null : squareErrorData);
    }
}
