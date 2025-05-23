package com.tencent.mobileqq.guild.temp.api.impl;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.temp.api.impl.RandomLottieApiImpl$buildRandomLottieViewAndPlay$2", f = "RandomLottieApiImpl.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class RandomLottieApiImpl$buildRandomLottieViewAndPlay$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Contact $contact;
    final /* synthetic */ Ref.BooleanRef $isLastMsg;
    final /* synthetic */ long $msgSeq;
    Object L$0;
    int label;
    final /* synthetic */ RandomLottieApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RandomLottieApiImpl$buildRandomLottieViewAndPlay$2(Ref.BooleanRef booleanRef, RandomLottieApiImpl randomLottieApiImpl, Contact contact, long j3, Continuation<? super RandomLottieApiImpl$buildRandomLottieViewAndPlay$2> continuation) {
        super(2, continuation);
        this.$isLastMsg = booleanRef;
        this.this$0 = randomLottieApiImpl;
        this.$contact = contact;
        this.$msgSeq = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RandomLottieApiImpl$buildRandomLottieViewAndPlay$2(this.$isLastMsg, this.this$0, this.$contact, this.$msgSeq, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object checkIsLastMsg;
        Ref.BooleanRef booleanRef;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef2 = this.$isLastMsg;
            RandomLottieApiImpl randomLottieApiImpl = this.this$0;
            Contact contact = this.$contact;
            long j3 = this.$msgSeq;
            this.L$0 = booleanRef2;
            this.label = 1;
            checkIsLastMsg = randomLottieApiImpl.checkIsLastMsg(contact, j3, this);
            if (checkIsLastMsg == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
            obj = checkIsLastMsg;
        } else if (i3 == 1) {
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        booleanRef.element = ((Boolean) obj).booleanValue();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RandomLottieApiImpl$buildRandomLottieViewAndPlay$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
