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
import ys2.MemberSettingUIModel;
import zs2.b;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.membersetting.part.MemberSettingGroupManagePart$onMsgTipEntryClick$2$1", f = "MemberSettingGroupManagePart.kt", i = {}, l = {335}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class MemberSettingGroupManagePart$onMsgTipEntryClick$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $value;
    int label;
    final /* synthetic */ MemberSettingGroupManagePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberSettingGroupManagePart$onMsgTipEntryClick$2$1(MemberSettingGroupManagePart memberSettingGroupManagePart, int i3, Continuation<? super MemberSettingGroupManagePart$onMsgTipEntryClick$2$1> continuation) {
        super(2, continuation);
        this.this$0 = memberSettingGroupManagePart;
        this.$value = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberSettingGroupManagePart$onMsgTipEntryClick$2$1(this.this$0, this.$value, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MemberSettingUIModel memberSettingUIModel;
        MemberSettingUIModel memberSettingUIModel2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            memberSettingUIModel = this.this$0.uiModel;
            MemberSettingUIModel memberSettingUIModel3 = null;
            if (memberSettingUIModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel = null;
            }
            String troopUin = memberSettingUIModel.getTroopUin();
            if (troopUin == null) {
                troopUin = "";
            }
            memberSettingUIModel2 = this.this$0.uiModel;
            if (memberSettingUIModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel3 = memberSettingUIModel2;
            }
            String memberUin = memberSettingUIModel3.getMemberUin();
            String str = memberUin != null ? memberUin : "";
            zs2.c C9 = this.this$0.C9();
            b.UpdateMsgTip updateMsgTip = new b.UpdateMsgTip(Long.parseLong(troopUin), Long.parseLong(str), this.$value);
            this.label = 1;
            if (C9.sendUserIntent(updateMsgTip, this) == coroutine_suspended) {
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
        return ((MemberSettingGroupManagePart$onMsgTipEntryClick$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
