package com.tencent.sqshow.zootopia.avatar.filament;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.PortalBusiness", f = "PortalBusiness.kt", i = {0, 1}, l = {368, 369}, m = "onTerminate$suspendImpl", n = {"$this", "$this"}, s = {"L$0", "L$0"})
/* loaded from: classes34.dex */
public final class PortalBusiness$onTerminate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PortalBusiness this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalBusiness$onTerminate$1(PortalBusiness portalBusiness, Continuation<? super PortalBusiness$onTerminate$1> continuation) {
        super(continuation);
        this.this$0 = portalBusiness;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PortalBusiness.onTerminate$suspendImpl(this.this$0, (Continuation<? super Unit>) this);
    }
}
