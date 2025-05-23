package com.tencent.zplan.record.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006H\u0086@"}, d2 = {"Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "resource", "", "uuid", "Lcom/tencent/zplan/common/model/UploadConfig$UploadTarget;", "uploadTarget", "Lkotlin/coroutines/Continuation;", "continuation", "", "uploadWithRetry"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.manager.ZPlanResourceUploader", f = "ZPlanResourceUploader.kt", i = {0, 0, 0, 0, 0}, l = {33}, m = "uploadWithRetry", n = {"this", "resource", "uuid", "uploadTarget", "tryCount"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
/* loaded from: classes27.dex */
public final class ZPlanResourceUploader$uploadWithRetry$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanResourceUploader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanResourceUploader$uploadWithRetry$1(ZPlanResourceUploader zPlanResourceUploader, Continuation continuation) {
        super(continuation);
        this.this$0 = zPlanResourceUploader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, null, this);
    }
}
