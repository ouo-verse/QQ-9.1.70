package com.tencent.mobileqq.guild.media.core.logic;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper$exitTRTCRoom$1", f = "MediaEnterExitRequestHelper.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MediaEnterExitRequestHelper$exitTRTCRoom$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.guild.media.core.c $callback;
    Object L$0;
    int label;
    final /* synthetic */ MediaEnterExitRequestHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEnterExitRequestHelper$exitTRTCRoom$1(MediaEnterExitRequestHelper mediaEnterExitRequestHelper, com.tencent.mobileqq.guild.media.core.c cVar, Continuation<? super MediaEnterExitRequestHelper$exitTRTCRoom$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaEnterExitRequestHelper;
        this.$callback = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaEnterExitRequestHelper$exitTRTCRoom$1(this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.guild.media.core.c cVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                cVar = (com.tencent.mobileqq.guild.media.core.c) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MediaEnterExitRequestHelper mediaEnterExitRequestHelper = this.this$0;
            com.tencent.mobileqq.guild.media.core.c cVar2 = this.$callback;
            this.L$0 = cVar2;
            this.label = 1;
            obj = mediaEnterExitRequestHelper.f1(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            cVar = cVar2;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (cVar != null) {
            cVar.a(booleanValue);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaEnterExitRequestHelper$exitTRTCRoom$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
