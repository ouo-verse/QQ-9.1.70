package com.tencent.zplan.record.provider.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0086@"}, d2 = {"Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "param", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/zplan/record/model/a;", "continuation", "", "requestCloudCacheResource"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.provider.helper.SPQSCloudCacheHelper", f = "SPQSCloudCacheHelper.kt", i = {}, l = {51}, m = "requestCloudCacheResource", n = {}, s = {})
/* loaded from: classes27.dex */
public final class SPQSCloudCacheHelper$requestCloudCacheResource$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SPQSCloudCacheHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SPQSCloudCacheHelper$requestCloudCacheResource$1(SPQSCloudCacheHelper sPQSCloudCacheHelper, Continuation continuation) {
        super(continuation);
        this.this$0 = sPQSCloudCacheHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, this);
    }
}
