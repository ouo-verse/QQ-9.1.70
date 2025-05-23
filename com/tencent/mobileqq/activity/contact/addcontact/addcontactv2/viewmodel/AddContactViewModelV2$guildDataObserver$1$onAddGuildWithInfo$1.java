package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel;

import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report.JoinStatus;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactViewModelV2$guildDataObserver$1$onAddGuildWithInfo$1", f = "AddContactViewModelV2.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
final class AddContactViewModelV2$guildDataObserver$1$onAddGuildWithInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGProGuildInfo $info;
    int label;
    final /* synthetic */ AddContactViewModelV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddContactViewModelV2$guildDataObserver$1$onAddGuildWithInfo$1(AddContactViewModelV2 addContactViewModelV2, IGProGuildInfo iGProGuildInfo, Continuation<? super AddContactViewModelV2$guildDataObserver$1$onAddGuildWithInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = addContactViewModelV2;
        this.$info = iGProGuildInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AddContactViewModelV2$guildDataObserver$1$onAddGuildWithInfo$1(this.this$0, this.$info, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            mutableSharedFlow = this.this$0._guildJoinedEvent;
            String guildID = this.$info.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID, "info.guildID");
            c cVar = new c(guildID, JoinStatus.JOINED);
            this.label = 1;
            if (mutableSharedFlow.emit(cVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AddContactViewModelV2$guildDataObserver$1$onAddGuildWithInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
