package com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting;

import ht2.b;
import ht2.g;
import kotlin.Metadata;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.TroopBindGuildSettingFragment$onLoadMoreStart$1", f = "TroopBindGuildSettingFragment.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
final class TroopBindGuildSettingFragment$onLoadMoreStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TroopBindGuildSettingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopBindGuildSettingFragment$onLoadMoreStart$1(TroopBindGuildSettingFragment troopBindGuildSettingFragment, Continuation<? super TroopBindGuildSettingFragment$onLoadMoreStart$1> continuation) {
        super(2, continuation);
        this.this$0 = troopBindGuildSettingFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TroopBindGuildSettingFragment$onLoadMoreStart$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        g Ah;
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
            Ah = this.this$0.Ah();
            b.C10474b c10474b = b.C10474b.f406238a;
            this.label = 1;
            if (Ah.sendUserIntent(c10474b, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TroopBindGuildSettingFragment$onLoadMoreStart$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
