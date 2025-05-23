package com.tencent.filament.zplan.record;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@"}, d2 = {"Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "", "configJsonPath", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "fetchSplitShaderWithConfigJson"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.record.FilamentRecordHelper", f = "FilamentRecordHelper.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {81, 93}, m = "fetchSplitShaderWithConfigJson", n = {"zplanSpanContext", "configJsonPath", "urlTemplate", "zplanSpanContext", "configJsonPath", "urlTemplate", "meshes"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes6.dex */
public final class FilamentRecordHelper$fetchSplitShaderWithConfigJson$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilamentRecordHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentRecordHelper$fetchSplitShaderWithConfigJson$1(FilamentRecordHelper filamentRecordHelper, Continuation continuation) {
        super(continuation);
        this.this$0 = filamentRecordHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}
