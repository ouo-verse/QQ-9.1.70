package com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.ZPlanSharePreRecordUtil", f = "ZPlanSharePreRecordUtil.kt", i = {0, 0, 0, 0, 0}, l = {72}, m = "preRecordSharePics", n = {"this", "uin", "priority", "avatarCharacterInfo", "callback"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes34.dex */
public final class ZPlanSharePreRecordUtil$preRecordSharePics$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanSharePreRecordUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanSharePreRecordUtil$preRecordSharePics$1(ZPlanSharePreRecordUtil zPlanSharePreRecordUtil, Continuation<? super ZPlanSharePreRecordUtil$preRecordSharePics$1> continuation) {
        super(continuation);
        this.this$0 = zPlanSharePreRecordUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, null, null, this);
    }
}
