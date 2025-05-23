package com.tencent.ecommerce.biz.hr.module;

import android.app.Activity;
import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.hr.module.ECHRShare$shareViewImage$1", f = "ECHRShare.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECHRShare$shareViewImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Ref.ObjectRef $bitmap;
    final /* synthetic */ Function2 $callback;
    final /* synthetic */ Function1 $renderCallback;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECHRShare$shareViewImage$1(Activity activity, Ref.ObjectRef objectRef, Function1 function1, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$bitmap = objectRef;
        this.$renderCallback = function1;
        this.$callback = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECHRShare$shareViewImage$1(this.$activity, this.$bitmap, this.$renderCallback, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECHRShare$shareViewImage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECHRShare eCHRShare = ECHRShare.f102572h;
            Activity activity = this.$activity;
            Bitmap bitmap = (Bitmap) this.$bitmap.element;
            this.label = 1;
            obj = eCHRShare.m(activity, bitmap, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) obj;
        if (str.length() == 0) {
            ECHRShare.f102572h.g(-1, "can not save view image", this.$renderCallback);
            return Unit.INSTANCE;
        }
        this.$callback.invoke(str, (Bitmap) this.$bitmap.element);
        return Unit.INSTANCE;
    }
}
