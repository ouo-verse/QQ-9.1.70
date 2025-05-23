package com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter;

import com.tencent.qqnt.kernel.nativeinterface.AIOBindGuildInfo;
import ht2.b;
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
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.TroopBindGuildSettingListAdapter$manageBtnClickListener$1$1$dialog$1$1", f = "TroopBindGuildSettingListAdapter.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
final class TroopBindGuildSettingListAdapter$manageBtnClickListener$1$1$dialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIOBindGuildInfo $guildInfo;
    int label;
    final /* synthetic */ TroopBindGuildSettingListAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopBindGuildSettingListAdapter$manageBtnClickListener$1$1$dialog$1$1(TroopBindGuildSettingListAdapter troopBindGuildSettingListAdapter, AIOBindGuildInfo aIOBindGuildInfo, Continuation<? super TroopBindGuildSettingListAdapter$manageBtnClickListener$1$1$dialog$1$1> continuation) {
        super(2, continuation);
        this.this$0 = troopBindGuildSettingListAdapter;
        this.$guildInfo = aIOBindGuildInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TroopBindGuildSettingListAdapter$manageBtnClickListener$1$1$dialog$1$1(this.this$0, this.$guildInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ht2.g gVar;
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
            gVar = this.this$0.vm;
            b.UnBindGuild unBindGuild = new b.UnBindGuild(this.$guildInfo.guildId);
            this.label = 1;
            if (gVar.sendUserIntent(unBindGuild, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TroopBindGuildSettingListAdapter$manageBtnClickListener$1$1$dialog$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
