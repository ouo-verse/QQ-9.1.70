package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo;
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
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.uimodel.TroopInfoCardGameViewModel$requestTroopGameInfo$1", f = "TroopInfoCardGameViewModel.kt", i = {}, l = {31, 32}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopInfoCardGameViewModel$requestTroopGameInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    Object L$0;
    int label;
    final /* synthetic */ TroopInfoCardGameViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopInfoCardGameViewModel$requestTroopGameInfo$1(TroopInfoCardGameViewModel troopInfoCardGameViewModel, Continuation<? super TroopInfoCardGameViewModel$requestTroopGameInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = troopInfoCardGameViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopInfoCardGameViewModel, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopInfoCardGameViewModel$requestTroopGameInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        TroopCardRepo troopCardRepo;
        MutableLiveData mutableLiveData2;
        TroopCardRepo troopCardRepo2;
        MutableLiveData mutableLiveData3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        mutableLiveData3 = (MutableLiveData) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutableLiveData3.setValue(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                mutableLiveData = this.this$0._troopGameInfo;
                troopCardRepo = this.this$0.repo;
                String Q1 = this.this$0.Q1();
                this.L$0 = mutableLiveData;
                this.label = 1;
                obj = troopCardRepo.y(Q1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            mutableLiveData.setValue(obj);
            mutableLiveData2 = this.this$0._troopMetaDreamGameInfo;
            troopCardRepo2 = this.this$0.repo;
            String Q12 = this.this$0.Q1();
            this.L$0 = mutableLiveData2;
            this.label = 2;
            Object z16 = troopCardRepo2.z(Q12, this);
            if (z16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData3 = mutableLiveData2;
            obj = z16;
            mutableLiveData3.setValue(obj);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopInfoCardGameViewModel$requestTroopGameInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
