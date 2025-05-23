package com.tencent.aelight.camera.ae.download;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aelight.camera.ae.download.AENewResUtilKt$safeLoadSo$1", f = "AENewResUtil.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class AENewResUtilKt$safeLoadSo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filename;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AENewResUtilKt$safeLoadSo$1(String str, Continuation<? super AENewResUtilKt$safeLoadSo$1> continuation) {
        super(2, continuation);
        this.$filename = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AENewResUtilKt$safeLoadSo$1 aENewResUtilKt$safeLoadSo$1 = new AENewResUtilKt$safeLoadSo$1(this.$filename, continuation);
        aENewResUtilKt$safeLoadSo$1.L$0 = obj;
        return aENewResUtilKt$safeLoadSo$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ms.a.a("AEResUtil", "loadSo-start" + Thread.currentThread().getName());
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getDefault(), null, new AENewResUtilKt$safeLoadSo$1$deferred$1(this.$filename, null), 2, null);
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            ms.a.a("AEResUtil", "loadSo success " + Thread.currentThread().getName());
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AENewResUtilKt$safeLoadSo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
