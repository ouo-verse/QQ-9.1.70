package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"isLock", "", "Lcom/tencent/state/square/data/StatusLockInfo;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOnlineStatusDataKt {
    public static final boolean isLock(StatusLockInfo isLock) {
        Intrinsics.checkNotNullParameter(isLock, "$this$isLock");
        return isLock.getLockStatus() == 1;
    }
}
