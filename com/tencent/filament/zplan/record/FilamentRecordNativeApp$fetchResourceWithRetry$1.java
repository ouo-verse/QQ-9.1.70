package com.tencent.filament.zplan.record;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006H\u0082@"}, d2 = {"T", "", "taskName", "", "maxRetries", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "continuation", "fetchResourceWithRetry"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.record.FilamentRecordNativeApp", f = "FilamentRecordNativeApp.kt", i = {0, 0, 0}, l = {754}, m = "fetchResourceWithRetry", n = {"taskName", "block", "tryCount"}, s = {"L$0", "L$1", "I$2"})
/* loaded from: classes6.dex */
public final class FilamentRecordNativeApp$fetchResourceWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilamentRecordNativeApp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentRecordNativeApp$fetchResourceWithRetry$1(FilamentRecordNativeApp filamentRecordNativeApp, Continuation continuation) {
        super(continuation);
        this.this$0 = filamentRecordNativeApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.F(null, 0, null, this);
    }
}
