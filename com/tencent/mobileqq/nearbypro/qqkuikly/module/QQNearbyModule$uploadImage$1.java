package com.tencent.mobileqq.nearbypro.qqkuikly.module;

import com.tencent.mobileqq.nearbypro.repository.service.BDHService;
import fu4.w;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule$uploadImage$1", f = "QQNearbyModule.kt", i = {}, l = {1339}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
final class QQNearbyModule$uploadImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Object, Unit> $callback;
    final /* synthetic */ String $path;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQNearbyModule$uploadImage$1(String str, Function1<Object, Unit> function1, Continuation<? super QQNearbyModule$uploadImage$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QQNearbyModule$uploadImage$1(this.$path, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            BDHService bDHService = new BDHService();
            String str = this.$path;
            this.label = 1;
            obj = bDHService.o(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        w wVar = (w) obj;
        if (wVar != null) {
            Function1<Object, Unit> function1 = this.$callback;
            if (function1 != null) {
                function1.invoke(com.tencent.mobileqq.nearbypro.request.c.c(wVar));
            }
        } else {
            com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "uploadImage failed, msgInfo is null");
            Function1<Object, Unit> function12 = this.$callback;
            if (function12 != null) {
                function12.invoke(null);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QQNearbyModule$uploadImage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
