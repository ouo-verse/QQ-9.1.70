package com.tencent.mobileqq.aio.input.at.business;

import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.tencent.mobileqq.aio.input.at.business.AIOAtSelectMemberUseCase$buildIndexAndSubmit$1", f = "AIOAtSelectMemberUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class AIOAtSelectMemberUseCase$buildIndexAndSubmit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ArrayList<Pair<String, Integer>> $alphabetIndex;
    final /* synthetic */ ArrayList<com.tencent.mobileqq.aio.input.at.common.list.data.b> $sortedItemList;
    int label;
    final /* synthetic */ AIOAtSelectMemberUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOAtSelectMemberUseCase$buildIndexAndSubmit$1(AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase, ArrayList<com.tencent.mobileqq.aio.input.at.common.list.data.b> arrayList, ArrayList<Pair<String, Integer>> arrayList2, Continuation<? super AIOAtSelectMemberUseCase$buildIndexAndSubmit$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOAtSelectMemberUseCase;
        this.$sortedItemList = arrayList;
        this.$alphabetIndex = arrayList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aIOAtSelectMemberUseCase, arrayList, arrayList2, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AIOAtSelectMemberUseCase$buildIndexAndSubmit$1(this.this$0, this.$sortedItemList, this.$alphabetIndex, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        com.tencent.mobileqq.aio.input.at.common.f Q;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                z16 = this.this$0.mReadyToShow;
                if (!z16) {
                    QLog.d("AIOAtUseCase", 1, "submitListAndShow not ready");
                    return Unit.INSTANCE;
                }
                this.this$0.mContext.e().h(new FullScreenMsgIntent.SetFullScreenMode(false));
                Q = this.this$0.Q();
                Q.b(this.$sortedItemList, this.$alphabetIndex);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOAtSelectMemberUseCase$buildIndexAndSubmit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
