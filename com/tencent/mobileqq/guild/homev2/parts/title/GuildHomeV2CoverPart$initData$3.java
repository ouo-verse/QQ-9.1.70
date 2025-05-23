package com.tencent.mobileqq.guild.homev2.parts.title;

import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2CoverPart$initData$3", f = "GuildHomeV2CoverPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildHomeV2CoverPart$initData$3 extends SuspendLambda implements Function2<GuildHomeViewModel.GuildHomeUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildHomeV2CoverPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeV2CoverPart$initData$3(GuildHomeV2CoverPart guildHomeV2CoverPart, Continuation<? super GuildHomeV2CoverPart$initData$3> continuation) {
        super(2, continuation);
        this.this$0 = guildHomeV2CoverPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildHomeV2CoverPart$initData$3 guildHomeV2CoverPart$initData$3 = new GuildHomeV2CoverPart$initData$3(this.this$0, continuation);
        guildHomeV2CoverPart$initData$3.L$0 = obj;
        return guildHomeV2CoverPart$initData$3;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull GuildHomeViewModel.GuildHomeUiState guildHomeUiState, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildHomeV2CoverPart$initData$3) create(guildHomeUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.R9((GuildHomeViewModel.GuildHomeUiState) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
