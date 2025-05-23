package com.tencent.mobileqq.troop.troopcard.reborn.vm;

import com.tencent.mobileqq.data.troop.TroopInfo;
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
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$updateTroopName$1", f = "TroopBasicInfoViewModel.kt", i = {}, l = {458}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopBasicInfoViewModel$updateTroopName$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $newTroopName;
    final /* synthetic */ TroopInfo $troopInfo;
    Object L$0;
    int label;
    final /* synthetic */ TroopBasicInfoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopBasicInfoViewModel$updateTroopName$1(TroopBasicInfoViewModel troopBasicInfoViewModel, TroopInfo troopInfo, String str, Continuation<? super TroopBasicInfoViewModel$updateTroopName$1> continuation) {
        super(2, continuation);
        this.this$0 = troopBasicInfoViewModel;
        this.$troopInfo = troopInfo;
        this.$newTroopName = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopBasicInfoViewModel, troopInfo, str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopBasicInfoViewModel$updateTroopName$1(this.this$0, this.$troopInfo, this.$newTroopName, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        TroopCardRepo troopCardRepo;
        TroopBasicInfoViewModel troopBasicInfoViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    troopBasicInfoViewModel = (TroopBasicInfoViewModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.this$0;
                troopCardRepo = troopBasicInfoViewModel2.repo;
                TroopInfo troopInfo = this.$troopInfo;
                String str = this.$newTroopName;
                this.L$0 = troopBasicInfoViewModel2;
                this.label = 1;
                Object C = troopCardRepo.C(troopInfo, str, this);
                if (C == coroutine_suspended) {
                    return coroutine_suspended;
                }
                troopBasicInfoViewModel = troopBasicInfoViewModel2;
                obj = C;
            }
            troopBasicInfoViewModel.m3((TroopInfo) obj);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopBasicInfoViewModel$updateTroopName$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
