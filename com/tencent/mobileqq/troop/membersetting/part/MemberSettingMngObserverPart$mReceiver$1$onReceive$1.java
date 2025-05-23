package com.tencent.mobileqq.troop.membersetting.part;

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
import zs2.b;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.membersetting.part.MemberSettingMngObserverPart$mReceiver$1$onReceive$1", f = "MemberSettingMngObserverPart.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class MemberSettingMngObserverPart$mReceiver$1$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $nickName;
    int label;
    final /* synthetic */ MemberSettingMngObserverPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberSettingMngObserverPart$mReceiver$1$onReceive$1(MemberSettingMngObserverPart memberSettingMngObserverPart, String str, Continuation<? super MemberSettingMngObserverPart$mReceiver$1$onReceive$1> continuation) {
        super(2, continuation);
        this.this$0 = memberSettingMngObserverPart;
        this.$nickName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberSettingMngObserverPart$mReceiver$1$onReceive$1(this.this$0, this.$nickName, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            zs2.c C9 = this.this$0.C9();
            String nickName = this.$nickName;
            Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
            b.UpdateMemberCard updateMemberCard = new b.UpdateMemberCard(nickName);
            this.label = 1;
            if (C9.sendUserIntent(updateMemberCard, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MemberSettingMngObserverPart$mReceiver$1$onReceive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
