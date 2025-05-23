package com.tencent.mobileqq.nearbypro.repository.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.repository.service.BDHService", f = "BDHService.kt", i = {}, l = {117}, m = "reqDownPhoto", n = {}, s = {})
/* loaded from: classes15.dex */
public final class BDHService$reqDownPhoto$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BDHService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDHService$reqDownPhoto$1(BDHService bDHService, Continuation<? super BDHService$reqDownPhoto$1> continuation) {
        super(continuation);
        this.this$0 = bDHService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, this);
    }
}
