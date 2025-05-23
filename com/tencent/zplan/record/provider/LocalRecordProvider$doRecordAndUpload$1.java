package com.tencent.zplan.record.provider;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0082@"}, d2 = {"", "key", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "params", "Lcom/tencent/zplan/record/provider/helper/a;", "uploader", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "continuation", "", "doRecordAndUpload"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.provider.LocalRecordProvider", f = "LocalRecordProvider.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2}, l = {67, 91, 94}, m = "doRecordAndUpload", n = {"key", "params", "uploader", "beginAppearanceKey", "statistic", "timeStart", "key", "params", "statistic", "statistic"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$0"})
/* loaded from: classes27.dex */
public final class LocalRecordProvider$doRecordAndUpload$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalRecordProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalRecordProvider$doRecordAndUpload$1(LocalRecordProvider localRecordProvider, Continuation continuation) {
        super(continuation);
        this.this$0 = localRecordProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, null, this);
    }
}
