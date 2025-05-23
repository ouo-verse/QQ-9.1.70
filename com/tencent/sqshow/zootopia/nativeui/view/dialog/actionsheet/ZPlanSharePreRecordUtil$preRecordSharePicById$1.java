package com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.ZPlanSharePreRecordUtil", f = "ZPlanSharePreRecordUtil.kt", i = {0}, l = {57}, m = "preRecordSharePicById", n = {"callback"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class ZPlanSharePreRecordUtil$preRecordSharePicById$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanSharePreRecordUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanSharePreRecordUtil$preRecordSharePicById$1(ZPlanSharePreRecordUtil zPlanSharePreRecordUtil, Continuation<? super ZPlanSharePreRecordUtil$preRecordSharePicById$1> continuation) {
        super(continuation);
        this.this$0 = zPlanSharePreRecordUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object e16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        e16 = this.this$0.e(null, null, 0, 0, 0, null, null, this);
        return e16;
    }
}
