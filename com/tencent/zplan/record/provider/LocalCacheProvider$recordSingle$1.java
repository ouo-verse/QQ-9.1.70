package com.tencent.zplan.record.provider;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0096@"}, d2 = {"", "key", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "params", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "continuation", "", "recordSingle"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.provider.LocalCacheProvider", f = "LocalCacheProvider.kt", i = {0, 0, 0}, l = {35, 43}, m = "recordSingle", n = {"this", "key", "params"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes27.dex */
public final class LocalCacheProvider$recordSingle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalCacheProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalCacheProvider$recordSingle$1(LocalCacheProvider localCacheProvider, Continuation continuation) {
        super(continuation);
        this.this$0 = localCacheProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
