package com.tencent.mobileqq.guild.profile.profilecard.joined.detail;

import com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedViewModel$fetchData$1", f = "GuildProfileJoinedViewModel.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildProfileJoinedViewModel$fetchData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuildProfileJoinedViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileJoinedViewModel$fetchData$1(GuildProfileJoinedViewModel guildProfileJoinedViewModel, Continuation<? super GuildProfileJoinedViewModel$fetchData$1> continuation) {
        super(2, continuation);
        this.this$0 = guildProfileJoinedViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildProfileJoinedViewModel$fetchData$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            Logger logger = Logger.f235387a;
            GuildProfileJoinedViewModel guildProfileJoinedViewModel = this.this$0;
            logger.d().d("Guild.profile.GuildProfileJoinedViewModel", 1, "fetchData: start data:" + guildProfileJoinedViewModel.getProfileData());
            GuildProfileJoinedViewModel guildProfileJoinedViewModel2 = this.this$0;
            this.label = 1;
            obj = guildProfileJoinedViewModel2.getProfileJoinedGuilds(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        GuildProfileJoinedViewModel.GetJoinedGuildRsp getJoinedGuildRsp = (GuildProfileJoinedViewModel.GetJoinedGuildRsp) obj;
        if (!getJoinedGuildRsp.getResult().c() && !getJoinedGuildRsp.getInfo().a().isEmpty()) {
            this.this$0.getDataList().setValue(getJoinedGuildRsp.getInfo());
            return Unit.INSTANCE;
        }
        this.this$0.getDataList().setValue(new GuildProfileJoinedViewModel.GuildJoinedCardInfo("", true, new ArrayList()));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildProfileJoinedViewModel$fetchData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
