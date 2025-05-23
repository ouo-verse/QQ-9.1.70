package com.tencent.kuikly.core.pager;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/kuikly/core/pager/Pager;", "a", "", "b", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class h {
    public static final Pager a() {
        b g16 = com.tencent.kuikly.core.manager.c.f117352a.g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.kuikly.core.pager.Pager");
        return (Pager) g16;
    }

    public static final boolean b() {
        b h16 = com.tencent.kuikly.core.manager.c.f117352a.h();
        Pager pager = h16 instanceof Pager ? (Pager) h16 : null;
        return pager != null && pager.isV2();
    }
}
