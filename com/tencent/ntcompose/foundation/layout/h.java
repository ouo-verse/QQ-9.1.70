package com.tencent.ntcompose.foundation.layout;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.core.ModifiersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "", NodeProps.MAX_WIDTH, "b", NodeProps.FLEX, "a", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h {
    public static final com.tencent.ntcompose.core.i a(com.tencent.ntcompose.core.i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, NodeProps.FLEX, Float.valueOf(f16), null, null, null, null, g.f339285a, 60, null);
    }

    public static final com.tencent.ntcompose.core.i b(com.tencent.ntcompose.core.i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, NodeProps.MAX_WIDTH, Float.valueOf(f16), null, null, null, null, g.f339285a, 60, null);
    }
}
