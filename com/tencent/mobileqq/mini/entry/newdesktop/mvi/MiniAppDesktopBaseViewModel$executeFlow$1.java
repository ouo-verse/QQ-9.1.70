package com.tencent.mobileqq.mini.entry.newdesktop.mvi;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\b\b\u0002\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u008a@"}, d2 = {"T", "Lcom/tencent/qqnt/base/mvi/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/base/mvi/b;", "I", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopBaseViewModel$executeFlow$1", f = "MiniAppDesktopBaseViewModel.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
final class MiniAppDesktopBaseViewModel$executeFlow$1<T> extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $action;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MiniAppDesktopBaseViewModel$executeFlow$1(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super MiniAppDesktopBaseViewModel$executeFlow$1> continuation) {
        super(2, continuation);
        this.$action = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MiniAppDesktopBaseViewModel$executeFlow$1 miniAppDesktopBaseViewModel$executeFlow$1 = new MiniAppDesktopBaseViewModel$executeFlow$1(this.$action, continuation);
        miniAppDesktopBaseViewModel$executeFlow$1.L$0 = obj;
        return miniAppDesktopBaseViewModel$executeFlow$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke2((MiniAppDesktopBaseViewModel$executeFlow$1<T>) obj, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            Function2<T, Continuation<? super Unit>, Object> function2 = this.$action;
            this.label = 1;
            if (function2.invoke(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(T t16, Continuation<? super Unit> continuation) {
        return ((MiniAppDesktopBaseViewModel$executeFlow$1) create(t16, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
