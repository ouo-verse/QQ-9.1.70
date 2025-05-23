package com.tencent.mobileqq.guild.temp.api.impl;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.temp.api.impl.RandomLottieApiImpl$createRandomLottieAnimView$2", f = "RandomLottieApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class RandomLottieApiImpl$createRandomLottieAnimView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.ObjectRef<View> $rootLayout;
    int label;
    final /* synthetic */ RandomLottieApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RandomLottieApiImpl$createRandomLottieAnimView$2(Ref.ObjectRef<View> objectRef, RandomLottieApiImpl randomLottieApiImpl, Context context, Continuation<? super RandomLottieApiImpl$createRandomLottieAnimView$2> continuation) {
        super(2, continuation);
        this.$rootLayout = objectRef;
        this.this$0 = randomLottieApiImpl;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RandomLottieApiImpl$createRandomLottieAnimView$2(this.$rootLayout, this.this$0, this.$context, continuation);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, android.widget.FrameLayout] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$rootLayout.element = RandomLottieApiImpl.buildLottieView$default(this.this$0, this.$context, null, 2, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RandomLottieApiImpl$createRandomLottieAnimView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
