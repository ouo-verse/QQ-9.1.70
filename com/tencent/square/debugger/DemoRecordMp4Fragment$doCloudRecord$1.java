package com.tencent.square.debugger;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0082@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "doCloudRecord"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.square.debugger.DemoRecordMp4Fragment", f = "DemoRecordMp4Fragment.kt", i = {0}, l = {597}, m = "doCloudRecord", n = {"this"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class DemoRecordMp4Fragment$doCloudRecord$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DemoRecordMp4Fragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DemoRecordMp4Fragment$doCloudRecord$1(DemoRecordMp4Fragment demoRecordMp4Fragment, Continuation continuation) {
        super(continuation);
        this.this$0 = demoRecordMp4Fragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.bi(this);
    }
}
