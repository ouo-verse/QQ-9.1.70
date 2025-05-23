package com.tencent.state.square;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"SquareHelper", "Lcom/tencent/state/square/SquareCallback;", "getSquareHelper", "()Lcom/tencent/state/square/SquareCallback;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareKt {
    private static final SquareCallback SquareHelper = Square.INSTANCE.getCallback();

    public static final SquareCallback getSquareHelper() {
        return SquareHelper;
    }
}
