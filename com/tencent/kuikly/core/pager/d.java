package com.tencent.kuikly.core.pager;

import com.tencent.kuikly.core.module.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/pager/b;", "", "pagerEvent", "", "eventData", "", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d {
    public static final void a(b bVar, String pagerEvent, Object eventData) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        if (eventData instanceof String) {
            bVar.onReceivePagerEvent(pagerEvent, new com.tencent.kuikly.core.nvi.serialization.json.e((String) eventData));
        }
        bVar.onReceivePagerEventV2(pagerEvent, n.a(eventData));
    }
}
