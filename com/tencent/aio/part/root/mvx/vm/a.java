package com.tencent.aio.part.root.mvx.vm;

import com.tencent.aio.data.AIOParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/api/runtime/a;", "", "d", "c", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(com.tencent.aio.api.runtime.a aVar) {
        if (aVar == null) {
            return false;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "this.aioParam");
        return ft.a.f(g16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(com.tencent.aio.api.runtime.a aVar) {
        return false;
    }
}
