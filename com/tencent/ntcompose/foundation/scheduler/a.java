package com.tencent.ntcompose.foundation.scheduler;

import com.tencent.kuikly.core.pager.Pager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\",\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00018@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/pager/Pager;", "Lcom/tencent/ntcompose/foundation/scheduler/Choreographer;", "value", "a", "(Lcom/tencent/kuikly/core/pager/Pager;)Lcom/tencent/ntcompose/foundation/scheduler/Choreographer;", "b", "(Lcom/tencent/kuikly/core/pager/Pager;Lcom/tencent/ntcompose/foundation/scheduler/Choreographer;)V", "choreographer", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {
    public static final Choreographer a(Pager pager) {
        Intrinsics.checkNotNullParameter(pager, "<this>");
        Object obj = pager.getExtProps().get("choreographer");
        if (obj instanceof Choreographer) {
            return (Choreographer) obj;
        }
        return null;
    }

    public static final void b(Pager pager, Choreographer choreographer) {
        Intrinsics.checkNotNullParameter(pager, "<this>");
        if (choreographer == null) {
            pager.getExtProps().remove("choreographer");
        } else {
            pager.getExtProps().put("choreographer", choreographer);
            choreographer.g(pager);
        }
    }
}
