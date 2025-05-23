package com.tencent.state.square;

import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.square.components.fragment.SquareMsgBoxComponent;
import com.tencent.state.square.message.box.IMsgBoxManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"getMsgBoxManager", "Lcom/tencent/state/square/message/box/IMsgBoxManager;", "Lcom/tencent/state/square/SquareFragment;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareFragmentKt {
    public static final IMsgBoxManager getMsgBoxManager(SquareFragment getMsgBoxManager) {
        Intrinsics.checkNotNullParameter(getMsgBoxManager, "$this$getMsgBoxManager");
        SquareMsgBoxComponent squareMsgBoxComponent = (SquareMsgBoxComponent) VasBaseLifecycleFragment.getComponent$default(getMsgBoxManager, SquareMsgBoxComponent.class, null, null, 6, null);
        if (squareMsgBoxComponent != null) {
            return squareMsgBoxComponent.getMsgBoxManager();
        }
        return null;
    }
}
