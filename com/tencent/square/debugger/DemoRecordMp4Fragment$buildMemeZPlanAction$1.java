package com.tencent.square.debugger;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0082@"}, d2 = {"", "useFilament", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "continuation", "", "buildMemeZPlanAction"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.square.debugger.DemoRecordMp4Fragment", f = "DemoRecordMp4Fragment.kt", i = {0, 0, 0, 0}, l = {546}, m = "buildMemeZPlanAction", n = {"this", "resource", "selectedUin2", "selectedUin1"}, s = {"L$0", "L$1", "L$2", "J$0"})
/* loaded from: classes34.dex */
public final class DemoRecordMp4Fragment$buildMemeZPlanAction$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DemoRecordMp4Fragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DemoRecordMp4Fragment$buildMemeZPlanAction$1(DemoRecordMp4Fragment demoRecordMp4Fragment, Continuation continuation) {
        super(continuation);
        this.this$0 = demoRecordMp4Fragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.Yh(false, this);
    }
}
