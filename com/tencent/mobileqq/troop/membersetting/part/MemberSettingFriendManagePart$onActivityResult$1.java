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
@DebugMetadata(c = "com.tencent.mobileqq.troop.membersetting.part.MemberSettingFriendManagePart$onActivityResult$1", f = "MemberSettingFriendManagePart.kt", i = {}, l = {265}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class MemberSettingFriendManagePart$onActivityResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $groupId;
    final /* synthetic */ String $groupName;
    int label;
    final /* synthetic */ MemberSettingFriendManagePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberSettingFriendManagePart$onActivityResult$1(MemberSettingFriendManagePart memberSettingFriendManagePart, String str, int i3, Continuation<? super MemberSettingFriendManagePart$onActivityResult$1> continuation) {
        super(2, continuation);
        this.this$0 = memberSettingFriendManagePart;
        this.$groupName = str;
        this.$groupId = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberSettingFriendManagePart$onActivityResult$1(this.this$0, this.$groupName, this.$groupId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            zs2.c C9 = this.this$0.C9();
            b.UpdateGroup updateGroup = new b.UpdateGroup(this.$groupName, this.$groupId);
            this.label = 1;
            if (C9.sendUserIntent(updateGroup, this) == coroutine_suspended) {
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
        return ((MemberSettingFriendManagePart$onActivityResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
