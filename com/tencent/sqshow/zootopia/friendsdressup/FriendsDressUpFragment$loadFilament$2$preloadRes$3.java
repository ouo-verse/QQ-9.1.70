package com.tencent.sqshow.zootopia.friendsdressup;

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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$loadFilament$2$preloadRes$3", f = "FriendsDressUpFragment.kt", i = {}, l = {596, 601}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class FriendsDressUpFragment$loadFilament$2$preloadRes$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FilamentNativeAppHelper $helper;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ FriendsDressUpFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsDressUpFragment$loadFilament$2$preloadRes$3(FilamentNativeAppHelper filamentNativeAppHelper, FriendsDressUpFragment friendsDressUpFragment, int i3, Continuation<? super FriendsDressUpFragment$loadFilament$2$preloadRes$3> continuation) {
        super(2, continuation);
        this.$helper = filamentNativeAppHelper;
        this.this$0 = friendsDressUpFragment;
        this.$position = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FriendsDressUpFragment$loadFilament$2$preloadRes$3(this.$helper, this.this$0, this.$position, continuation);
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
            FriendsDressUpData m06 = eVar.m0(this.$position - 1);
            String l3 = m06 != null ? Boxing.boxLong(m06.getUin()).toString() : null;
            x84.e eVar2 = this.this$0.avatarAdapter;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar2 = null;
            }
            FriendsDressUpData m07 = eVar2.m0(this.$position - 1);
            String headMontagePath = m07 != null ? m07.getHeadMontagePath() : null;
            x84.e eVar3 = this.this$0.avatarAdapter;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar3 = null;
            }
            FriendsDressUpData m08 = eVar3.m0(this.$position - 1);
            String bodyMontagePath = m08 != null ? m08.getBodyMontagePath() : null;
            this.label = 1;
            if (filamentNativeAppHelper.t(l3, headMontagePath, bodyMontagePath, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        FilamentNativeAppHelper filamentNativeAppHelper2 = this.$helper;
        x84.e eVar4 = this.this$0.avatarAdapter;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            eVar4 = null;
        }
        FriendsDressUpData m09 = eVar4.m0(this.$position + 1);
        String l16 = m09 != null ? Boxing.boxLong(m09.getUin()).toString() : null;
        x84.e eVar5 = this.this$0.avatarAdapter;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            eVar5 = null;
        }
        FriendsDressUpData m010 = eVar5.m0(this.$position + 1);
        String headMontagePath2 = m010 != null ? m010.getHeadMontagePath() : null;
        x84.e eVar6 = this.this$0.avatarAdapter;
        if (eVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            eVar6 = null;
        }
        FriendsDressUpData m011 = eVar6.m0(this.$position + 1);
        String bodyMontagePath2 = m011 != null ? m011.getBodyMontagePath() : null;
        this.label = 2;
        if (filamentNativeAppHelper2.t(l16, headMontagePath2, bodyMontagePath2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FriendsDressUpFragment$loadFilament$2$preloadRes$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
