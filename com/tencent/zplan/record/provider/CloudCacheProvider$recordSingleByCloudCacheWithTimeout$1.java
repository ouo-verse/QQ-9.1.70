package com.tencent.zplan.record.provider;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@"}, d2 = {"Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "action", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "params", "", "timeout", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/zplan/record/model/a;", "continuation", "", "recordSingleByCloudCacheWithTimeout"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.provider.CloudCacheProvider", f = "CloudCacheProvider.kt", i = {0}, l = {86}, m = "recordSingleByCloudCacheWithTimeout", n = {"action"}, s = {"L$0"})
/* loaded from: classes27.dex */
public final class CloudCacheProvider$recordSingleByCloudCacheWithTimeout$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudCacheProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudCacheProvider$recordSingleByCloudCacheWithTimeout$1(CloudCacheProvider cloudCacheProvider, Continuation continuation) {
        super(continuation);
        this.this$0 = cloudCacheProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, null, 0L, this);
    }
}
