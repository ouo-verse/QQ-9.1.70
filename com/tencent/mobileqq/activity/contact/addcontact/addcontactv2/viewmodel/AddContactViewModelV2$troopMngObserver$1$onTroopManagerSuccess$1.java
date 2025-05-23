package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel;

import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report.JoinStatus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactViewModelV2$troopMngObserver$1$onTroopManagerSuccess$1", f = "AddContactViewModelV2.kt", i = {}, l = {54, 58, 62}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
final class AddContactViewModelV2$troopMngObserver$1$onTroopManagerSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $result;
    final /* synthetic */ String $troopUin;
    int label;
    final /* synthetic */ AddContactViewModelV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddContactViewModelV2$troopMngObserver$1$onTroopManagerSuccess$1(int i3, AddContactViewModelV2 addContactViewModelV2, String str, Continuation<? super AddContactViewModelV2$troopMngObserver$1$onTroopManagerSuccess$1> continuation) {
        super(2, continuation);
        this.$result = i3;
        this.this$0 = addContactViewModelV2;
        this.$troopUin = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), addContactViewModelV2, str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AddContactViewModelV2$troopMngObserver$1$onTroopManagerSuccess$1(this.$result, this.this$0, this.$troopUin, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        MutableSharedFlow mutableSharedFlow3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1 || i3 == 2 || i3 == 3) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                int i16 = this.$result;
                if (i16 == -2) {
                    mutableSharedFlow = this.this$0._groupJoinedEvent;
                    c cVar = new c(this.$troopUin, JoinStatus.JOINING);
                    this.label = 1;
                    if (mutableSharedFlow.emit(cVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i16 == 0 || i16 == 1) {
                    mutableSharedFlow2 = this.this$0._groupJoinedEvent;
                    c cVar2 = new c(this.$troopUin, JoinStatus.JOINED);
                    this.label = 2;
                    if (mutableSharedFlow2.emit(cVar2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    mutableSharedFlow3 = this.this$0._groupJoinedEvent;
                    c cVar3 = new c(this.$troopUin, JoinStatus.NOT_JOIN);
                    this.label = 3;
                    if (mutableSharedFlow3.emit(cVar3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AddContactViewModelV2$troopMngObserver$1$onTroopManagerSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
