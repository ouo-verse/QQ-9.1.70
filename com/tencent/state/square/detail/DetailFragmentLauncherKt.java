package com.tencent.state.square.detail;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"covertToSource", "", "Lcom/tencent/state/square/detail/MainScene;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailFragmentLauncherKt {
    public static final int covertToSource(MainScene covertToSource) {
        Intrinsics.checkNotNullParameter(covertToSource, "$this$covertToSource");
        int ordinal = covertToSource.ordinal();
        if (ordinal == MainScene.SQUARE.ordinal()) {
            return 0;
        }
        if (ordinal == MainScene.LIBRARY.ordinal()) {
            return 1;
        }
        if (ordinal == MainScene.H5.ordinal()) {
            return 2;
        }
        if (ordinal == MainScene.COLLECT_CARD.ordinal()) {
            return 4;
        }
        if (ordinal == MainScene.SQUARE_CHAT_BLOCK.ordinal()) {
            return 1001;
        }
        if (ordinal == MainScene.SQUARE_CHAT_BLOCK_FIXED.ordinal()) {
            return 1002;
        }
        if (ordinal == MainScene.SQUARE_RELAX_BLOCK_FIXED.ordinal()) {
            return 1003;
        }
        if (ordinal == MainScene.SQUARE_CHAT_WUJI_BLOCK_1.ordinal()) {
            return 1004;
        }
        return ordinal == MainScene.SQUARE_CHAT_WUJI_BLOCK_2.ordinal() ? 1005 : 999;
    }
}
