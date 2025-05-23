package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "Lri1/a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildBaseBindPermissionMemberStrategy$searchUserData$1$result$1", f = "GuildBaseBindPermissionMemberStrategy.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class GuildBaseBindPermissionMemberStrategy$searchUserData$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends ri1.a, ? extends List<? extends IGProUserInfo>>>, Object> {
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ GuildBaseBindPermissionMemberStrategy this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBaseBindPermissionMemberStrategy$searchUserData$1$result$1(GuildBaseBindPermissionMemberStrategy guildBaseBindPermissionMemberStrategy, String str, Continuation<? super GuildBaseBindPermissionMemberStrategy$searchUserData$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = guildBaseBindPermissionMemberStrategy;
        this.$text = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildBaseBindPermissionMemberStrategy$searchUserData$1$result$1(this.this$0, this.$text, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        GuildRoleMemberParamData guildRoleMemberParamData;
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
            GuildBaseBindPermissionMemberStrategy guildBaseBindPermissionMemberStrategy = this.this$0;
            guildRoleMemberParamData = guildBaseBindPermissionMemberStrategy.param;
            String str = this.$text;
            int r16 = this.this$0.r();
            this.label = 1;
            obj = guildBaseBindPermissionMemberStrategy.s(guildRoleMemberParamData, str, r16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<? extends ri1.a, ? extends List<? extends IGProUserInfo>>> continuation) {
        return ((GuildBaseBindPermissionMemberStrategy$searchUserData$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
