package com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage;

import com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Custom;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage.StorageMiddleware", f = "StorageMiddleware.kt", i = {1, 1, 1, 1, 1, 1}, l = {51, 94}, m = "execute", n = {"this", "option", "isSuccess", "key", "isUpdateImmediately", "isStore"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "I$0"})
/* loaded from: classes33.dex */
public final class StorageMiddleware$execute$1 extends ContinuationImpl {
    public int I$0;
    public StorageMiddleware L$0;
    public Custom L$1;
    public Function1 L$2;
    public String L$3;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StorageMiddleware this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorageMiddleware$execute$1(StorageMiddleware storageMiddleware, Continuation<? super StorageMiddleware$execute$1> continuation) {
        super(continuation);
        this.this$0 = storageMiddleware;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, null, null, this);
    }
}
