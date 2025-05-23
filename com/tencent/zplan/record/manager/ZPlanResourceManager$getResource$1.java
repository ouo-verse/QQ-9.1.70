package com.tencent.zplan.record.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0086@"}, d2 = {"", "key", "Lcom/tencent/zplan/record/model/ExpireConfig;", "expire", "Lyx4/c$e;", "forceDeleteConfig", "", "downloadFromNetIfLocalAbsent", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "continuation", "", "getResource"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.manager.ZPlanResourceManager", f = "ZPlanResourceManager.kt", i = {0, 0, 0, 0, 0}, l = {71}, m = "getResource", n = {"this", "key", "cachedResource", "resultResource", "downloadFromNetIfLocalAbsent"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"})
/* loaded from: classes27.dex */
public final class ZPlanResourceManager$getResource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanResourceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanResourceManager$getResource$1(ZPlanResourceManager zPlanResourceManager, Continuation continuation) {
        super(continuation);
        this.this$0 = zPlanResourceManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, null, null, false, this);
    }
}
