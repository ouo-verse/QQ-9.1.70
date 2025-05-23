package com.tencent.zplan.record;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0086@"}, d2 = {"Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "params", "", "Lcom/tencent/zplan/record/model/Source;", "sources", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "continuation", "", "requestSingleResourceImmediate"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.ZPlanRecordResourceCenter", f = "ZPlanRecordResourceCenter.kt", i = {}, l = {44}, m = "requestSingleResourceImmediate", n = {}, s = {})
/* loaded from: classes27.dex */
public final class ZPlanRecordResourceCenter$requestSingleResourceImmediate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanRecordResourceCenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanRecordResourceCenter$requestSingleResourceImmediate$1(ZPlanRecordResourceCenter zPlanRecordResourceCenter, Continuation continuation) {
        super(continuation);
        this.this$0 = zPlanRecordResourceCenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, null, this);
    }
}
