package com.tencent.robot.discoveryv2.common.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "", "a", "b", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    public static final boolean a(@NotNull LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "<this>");
        if (loadState == LoadState.LOAD_SUCCESS) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "<this>");
        if (loadState == LoadState.LOADING) {
            return true;
        }
        return false;
    }
}
