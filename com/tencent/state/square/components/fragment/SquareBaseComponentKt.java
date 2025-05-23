package com.tencent.state.square.components.fragment;

import com.tencent.state.VasBaseGroupFragment;
import com.tencent.state.square.SquareGroupFragment;
import com.tencent.state.square.SquareGroupFragmentConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"getSquareGroupConfig", "Lcom/tencent/state/square/SquareGroupFragmentConfig;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareBaseComponentKt {
    public static final SquareGroupFragmentConfig getSquareGroupConfig(SquareBaseComponent getSquareGroupConfig) {
        SquareGroupFragmentConfig squareGroupConfig;
        Intrinsics.checkNotNullParameter(getSquareGroupConfig, "$this$getSquareGroupConfig");
        VasBaseGroupFragment parentGroupFragment = getSquareGroupConfig.getParentGroupFragment();
        if (!(parentGroupFragment instanceof SquareGroupFragment)) {
            parentGroupFragment = null;
        }
        SquareGroupFragment squareGroupFragment = (SquareGroupFragment) parentGroupFragment;
        return (squareGroupFragment == null || (squareGroupConfig = squareGroupFragment.getSquareGroupConfig()) == null) ? new SquareGroupFragmentConfig(null, 0, false, null, 15, null) : squareGroupConfig;
    }
}
