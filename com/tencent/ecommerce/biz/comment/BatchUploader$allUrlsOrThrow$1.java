package com.tencent.ecommerce.biz.comment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u0087@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "", "continuation", "", "allUrlsOrThrow"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.comment.BatchUploader", f = "BatchUploader.kt", i = {0, 1}, l = {202, 203}, m = "allUrlsOrThrow", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: classes31.dex */
public final class BatchUploader$allUrlsOrThrow$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BatchUploader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchUploader$allUrlsOrThrow$1(BatchUploader batchUploader, Continuation continuation) {
        super(continuation);
        this.this$0 = batchUploader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(this);
    }
}
