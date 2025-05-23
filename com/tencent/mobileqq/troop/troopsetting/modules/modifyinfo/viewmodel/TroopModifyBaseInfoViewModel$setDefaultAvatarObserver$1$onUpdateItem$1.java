package com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.viewmodel;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.TroopOperationRepo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.viewmodel.TroopModifyBaseInfoViewModel$setDefaultAvatarObserver$1$onUpdateItem$1", f = "TroopModifyBaseInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
final class TroopModifyBaseInfoViewModel$setDefaultAvatarObserver$1$onUpdateItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopUploadingThread.b $state;
    int label;
    final /* synthetic */ TroopModifyBaseInfoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopModifyBaseInfoViewModel$setDefaultAvatarObserver$1$onUpdateItem$1(TroopUploadingThread.b bVar, TroopModifyBaseInfoViewModel troopModifyBaseInfoViewModel, Continuation<? super TroopModifyBaseInfoViewModel$setDefaultAvatarObserver$1$onUpdateItem$1> continuation) {
        super(2, continuation);
        this.$state = bVar;
        this.this$0 = troopModifyBaseInfoViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, troopModifyBaseInfoViewModel, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopModifyBaseInfoViewModel$setDefaultAvatarObserver$1$onUpdateItem$1(this.$state, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                int i3 = this.$state.f294520a;
                if (i3 == 2) {
                    QLog.d("TroopModifyBaseInfoViewModel", 1, "set default avatar failed.");
                    this.this$0.b2();
                } else if (i3 == 1) {
                    QLog.d("TroopModifyBaseInfoViewModel", 1, "set default avatar succeed.");
                    TroopOperationRepo troopOperationRepo = TroopOperationRepo.INSTANCE;
                    TroopInfo W1 = this.this$0.W1();
                    if (W1 != null) {
                        str = W1.troopuin;
                    } else {
                        str = null;
                    }
                    troopOperationRepo.updateNewTroopState(str);
                    Function0<Unit> R1 = this.this$0.R1();
                    if (R1 != null) {
                        R1.invoke();
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopModifyBaseInfoViewModel$setDefaultAvatarObserver$1$onUpdateItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
