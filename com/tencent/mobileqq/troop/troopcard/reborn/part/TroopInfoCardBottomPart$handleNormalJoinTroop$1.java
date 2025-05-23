package com.tencent.mobileqq.troop.troopcard.reborn.part;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBottomPart$handleNormalJoinTroop$1", f = "TroopInfoCardBottomPart.kt", i = {}, l = {com.tencent.luggage.wxa.ig.w.CTRL_INDEX, 504, 506}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopInfoCardBottomPart$handleNormalJoinTroop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ a.AbstractC8794a.b $normalJoinBtnUIModel;
    final /* synthetic */ com.tencent.mobileqq.troop.data.v $troopInfoWrapper;
    int label;
    final /* synthetic */ TroopInfoCardBottomPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopInfoCardBottomPart$handleNormalJoinTroop$1(TroopInfoCardBottomPart troopInfoCardBottomPart, a.AbstractC8794a.b bVar, com.tencent.mobileqq.troop.data.v vVar, Continuation<? super TroopInfoCardBottomPart$handleNormalJoinTroop$1> continuation) {
        super(2, continuation);
        this.this$0 = troopInfoCardBottomPart;
        this.$normalJoinBtnUIModel = bVar;
        this.$troopInfoWrapper = vVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopInfoCardBottomPart, bVar, vVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopInfoCardBottomPart$handleNormalJoinTroop$1(this.this$0, this.$normalJoinBtnUIModel, this.$troopInfoWrapper, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        String str2;
        Object Ba;
        Object Ca;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2 && i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                TroopInfoCardBottomPart troopInfoCardBottomPart = this.this$0;
                a.AbstractC8794a.b bVar = this.$normalJoinBtnUIModel;
                com.tencent.mobileqq.troop.data.v vVar = this.$troopInfoWrapper;
                str = troopInfoCardBottomPart.authKey;
                str2 = this.this$0.authSig;
                int g16 = this.$troopInfoWrapper.g();
                this.label = 1;
                obj = troopInfoCardBottomPart.aa(bVar, vVar, str, str2, g16, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (((Boolean) obj).booleanValue()) {
                TroopInfoCardBottomPart troopInfoCardBottomPart2 = this.this$0;
                com.tencent.mobileqq.troop.data.v vVar2 = this.$troopInfoWrapper;
                this.label = 2;
                Ca = troopInfoCardBottomPart2.Ca(vVar2, this);
                if (Ca == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                TroopInfoCardBottomPart troopInfoCardBottomPart3 = this.this$0;
                com.tencent.mobileqq.troop.data.v vVar3 = this.$troopInfoWrapper;
                this.label = 3;
                Ba = troopInfoCardBottomPart3.Ba(vVar3, this);
                if (Ba == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopInfoCardBottomPart$handleNormalJoinTroop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
