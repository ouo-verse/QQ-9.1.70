package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import u35.b;

/* loaded from: classes31.dex */
public final class QQStrangerSsoService$sendProxyRequest$1 extends Lambda implements Function1<PbResponse<b>, Unit> {
    public final /* synthetic */ Function1<PbResponse<b>, Unit> $proxyCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QQStrangerSsoService$sendProxyRequest$1(Function1<? super PbResponse<b>, Unit> function1) {
        super(1);
        this.$proxyCallback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PbResponse<b> pbResponse) {
        this.$proxyCallback.invoke(pbResponse);
        return Unit.INSTANCE;
    }
}
