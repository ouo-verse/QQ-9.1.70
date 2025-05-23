package com.tencent.mobileqq.nearbypro.repository.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.repository.service.BDHService", f = "BDHService.kt", i = {0, 0, 0, 1, 1, 2}, l = {129, 135, 140}, m = "sendPhoto", n = {"this", "filePath", "cumulateSha1", "this", "uploadRsp", "uploadRsp"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
/* loaded from: classes15.dex */
public final class BDHService$sendPhoto$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BDHService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDHService$sendPhoto$1(BDHService bDHService, Continuation<? super BDHService$sendPhoto$1> continuation) {
        super(continuation);
        this.this$0 = bDHService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(null, this);
    }
}
