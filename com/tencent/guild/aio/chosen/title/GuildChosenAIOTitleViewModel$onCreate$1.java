package com.tencent.guild.aio.chosen.title;

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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.chosen.title.GuildChosenAIOTitleViewModel$onCreate$1", f = "GuildChosenAIOTitleViewModel.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildChosenAIOTitleViewModel$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ GuildChosenAIOTitleViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChosenAIOTitleViewModel$onCreate$1(GuildChosenAIOTitleViewModel guildChosenAIOTitleViewModel, Continuation<? super GuildChosenAIOTitleViewModel$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = guildChosenAIOTitleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildChosenAIOTitleViewModel$onCreate$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object t16;
        GuildChosenAIOTitleViewModel guildChosenAIOTitleViewModel;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                guildChosenAIOTitleViewModel = (GuildChosenAIOTitleViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            GuildChosenAIOTitleViewModel guildChosenAIOTitleViewModel2 = this.this$0;
            this.L$0 = guildChosenAIOTitleViewModel2;
            this.label = 1;
            t16 = guildChosenAIOTitleViewModel2.t(this);
            if (t16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            guildChosenAIOTitleViewModel = guildChosenAIOTitleViewModel2;
            obj = t16;
        }
        guildChosenAIOTitleViewModel.isHideBtnClickable = !((Boolean) obj).booleanValue();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildChosenAIOTitleViewModel$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
