package com.tencent.ntcompose.core;

import androidx.compose.runtime.BroadcastFrameClock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\"\u0018\u0010\u0006\u001a\u00020\u0003*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/pager/b;", "", "a", "Landroidx/compose/runtime/BroadcastFrameClock;", "b", "(Lcom/tencent/kuikly/core/pager/b;)Landroidx/compose/runtime/BroadcastFrameClock;", "composeFrameClock", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {
    public static final void a(com.tencent.kuikly.core.pager.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        b(bVar).sendFrame(0L);
    }

    public static final BroadcastFrameClock b(com.tencent.kuikly.core.pager.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Object obj = bVar.getDynamicExtProps().get("COMPOSE_FRAME_CLOCK");
        if (obj == null) {
            obj = new BroadcastFrameClock(null, 1, 0 == true ? 1 : 0);
            bVar.getDynamicExtProps().put("COMPOSE_FRAME_CLOCK", obj);
        }
        return (BroadcastFrameClock) obj;
    }
}
