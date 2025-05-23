package com.tencent.mobileqq.troop.troopsquare.topic.share;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareActionHandler;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareActionHandler$withFetchedUrl$2", f = "TroopSquareTopicShareActionHandler.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopSquareTopicShareActionHandler$withFetchedUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function1<TroopSquareTopicShareActionHandler.c, Unit> $callback;
    final /* synthetic */ int $shareType;
    Object L$0;
    int label;
    final /* synthetic */ TroopSquareTopicShareActionHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSquareTopicShareActionHandler$withFetchedUrl$2(TroopSquareTopicShareActionHandler troopSquareTopicShareActionHandler, int i3, Function1<? super TroopSquareTopicShareActionHandler.c, Unit> function1, Continuation<? super TroopSquareTopicShareActionHandler$withFetchedUrl$2> continuation) {
        super(2, continuation);
        this.this$0 = troopSquareTopicShareActionHandler;
        this.$shareType = i3;
        this.$callback = function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopSquareTopicShareActionHandler, Integer.valueOf(i3), function1, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopSquareTopicShareActionHandler$withFetchedUrl$2(this.this$0, this.$shareType, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object o16;
        TroopSquareTopicShareActionHandler troopSquareTopicShareActionHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    troopSquareTopicShareActionHandler = (TroopSquareTopicShareActionHandler) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                TroopSquareTopicShareActionHandler troopSquareTopicShareActionHandler2 = this.this$0;
                int i16 = this.$shareType;
                this.L$0 = troopSquareTopicShareActionHandler2;
                this.label = 1;
                o16 = troopSquareTopicShareActionHandler2.o(i16, this);
                if (o16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                troopSquareTopicShareActionHandler = troopSquareTopicShareActionHandler2;
                obj = o16;
            }
            troopSquareTopicShareActionHandler.m((TroopSquareTopicShareActionHandler.b) obj, this.$callback);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopSquareTopicShareActionHandler$withFetchedUrl$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
