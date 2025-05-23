package com.tencent.mobileqq.zplan.meme.prerecord.birthdaycare;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.meme.prerecord.birthdaycare.ZPlanBirthdayCareRecordHelper", f = "ZPlanBirthdayCareRecordHelper.kt", i = {}, l = {45}, m = "preRecordBirthdayCarePic", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanBirthdayCareRecordHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1(ZPlanBirthdayCareRecordHelper zPlanBirthdayCareRecordHelper, Continuation<? super ZPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1> continuation) {
        super(continuation);
        this.this$0 = zPlanBirthdayCareRecordHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
