package com.tencent.mobileqq.troop.membersetting.part;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zs2.b;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.membersetting.part.MemberSettingQuitOrDisbandPart$createNoBabyDelTroopMemberDialog$2$1", f = "MemberSettingQuitOrDisbandPart.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class MemberSettingQuitOrDisbandPart$createNoBabyDelTroopMemberDialog$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $normalMemberDel;
    int label;
    final /* synthetic */ MemberSettingQuitOrDisbandPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberSettingQuitOrDisbandPart$createNoBabyDelTroopMemberDialog$2$1(MemberSettingQuitOrDisbandPart memberSettingQuitOrDisbandPart, boolean z16, Continuation<? super MemberSettingQuitOrDisbandPart$createNoBabyDelTroopMemberDialog$2$1> continuation) {
        super(2, continuation);
        this.this$0 = memberSettingQuitOrDisbandPart;
        this.$normalMemberDel = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberSettingQuitOrDisbandPart$createNoBabyDelTroopMemberDialog$2$1(this.this$0, this.$normalMemberDel, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            zs2.c C9 = this.this$0.C9();
            b.DeleteTroopInfo deleteTroopInfo = new b.DeleteTroopInfo(this.this$0.getIsChecked(), this.$normalMemberDel);
            this.label = 1;
            if (C9.sendUserIntent(deleteTroopInfo, this) == coroutine_suspended) {
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
        return ((MemberSettingQuitOrDisbandPart$createNoBabyDelTroopMemberDialog$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
