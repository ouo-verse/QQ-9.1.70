package com.tencent.sqshow.zootopia.friendsdressup;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentNativeAppHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import zb3.FriendsDressUpData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$loadFilament$1", f = "FriendsDressUpFragment.kt", i = {}, l = {PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT_CONTAINER}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class FriendsDressUpFragment$loadFilament$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FilamentNativeAppHelper $helper;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ FriendsDressUpFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsDressUpFragment$loadFilament$1(FilamentNativeAppHelper filamentNativeAppHelper, FriendsDressUpFragment friendsDressUpFragment, int i3, Continuation<? super FriendsDressUpFragment$loadFilament$1> continuation) {
        super(2, continuation);
        this.$helper = filamentNativeAppHelper;
        this.this$0 = friendsDressUpFragment;
        this.$position = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FriendsDressUpFragment$loadFilament$1(this.$helper, this.this$0, this.$position, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            FilamentNativeAppHelper filamentNativeAppHelper = this.$helper;
            x84.e eVar = this.this$0.avatarAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar = null;
            }
            FriendsDressUpData m06 = eVar.m0(this.$position + 1);
            String l3 = m06 != null ? Boxing.boxLong(m06.getUin()).toString() : null;
            x84.e eVar2 = this.this$0.avatarAdapter;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar2 = null;
            }
            FriendsDressUpData m07 = eVar2.m0(this.$position + 1);
            String headMontagePath = m07 != null ? m07.getHeadMontagePath() : null;
            x84.e eVar3 = this.this$0.avatarAdapter;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar3 = null;
            }
            FriendsDressUpData m08 = eVar3.m0(this.$position + 1);
            String bodyMontagePath = m08 != null ? m08.getBodyMontagePath() : null;
            this.label = 1;
            if (filamentNativeAppHelper.t(l3, headMontagePath, bodyMontagePath, this) == coroutine_suspended) {
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
        return ((FriendsDressUpFragment$loadFilament$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
