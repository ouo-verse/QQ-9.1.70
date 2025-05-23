package com.tencent.hippykotlin.demo.pages.qq_intimate_space.msf;

import c45.e;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQNetworkEngine$Companion$sendOIDBRequest$1 extends Lambda implements Function1<OIDBResponse<e>, Unit> {
    public final /* synthetic */ Function1<OIDBResponse<e>, Unit> $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QQNetworkEngine$Companion$sendOIDBRequest$1(Function1<? super OIDBResponse<e>, Unit> function1) {
        super(1);
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(OIDBResponse<e> oIDBResponse) {
        this.$callback.invoke(oIDBResponse);
        return Unit.INSTANCE;
    }
}
