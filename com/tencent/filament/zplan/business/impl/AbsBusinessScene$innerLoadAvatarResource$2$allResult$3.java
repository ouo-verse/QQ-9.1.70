package com.tencent.filament.zplan.business.impl;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.AvatarCheckResult;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.zplan.zplantracing.b;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u0005H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/filament/zplan/avatar/AvatarCheckResult;", "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.business.impl.AbsBusinessScene$innerLoadAvatarResource$2$allResult$3", f = "AbsBusinessScene.kt", i = {}, l = {TVKQQLiveAssetPlayerMsg.PLAYER_INFO_PROXY_AUTHENTICATION_FAILED}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class AbsBusinessScene$innerLoadAvatarResource$2$allResult$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends AvatarCheckResult, ? extends ZPlanAction[]>>, Object> {
    final /* synthetic */ b $fetchAllResourceSpan;
    final /* synthetic */ EnumUserGender $gender;
    int label;
    final /* synthetic */ AbsBusinessScene$innerLoadAvatarResource$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBusinessScene$innerLoadAvatarResource$2$allResult$3(AbsBusinessScene$innerLoadAvatarResource$2 absBusinessScene$innerLoadAvatarResource$2, b bVar, EnumUserGender enumUserGender, Continuation continuation) {
        super(2, continuation);
        this.this$0 = absBusinessScene$innerLoadAvatarResource$2;
        this.$fetchAllResourceSpan = bVar;
        this.$gender = enumUserGender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new AbsBusinessScene$innerLoadAvatarResource$2$allResult$3(this.this$0, this.$fetchAllResourceSpan, this.$gender, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends AvatarCheckResult, ? extends ZPlanAction[]>> continuation) {
        return ((AbsBusinessScene$innerLoadAvatarResource$2$allResult$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        c cVar;
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
            AbsBusinessScene absBusinessScene = this.this$0.this$0;
            b bVar = this.$fetchAllResourceSpan;
            if (bVar != null) {
                cVar = bVar.c();
            } else {
                cVar = null;
            }
            EnumUserGender enumUserGender = this.$gender;
            this.label = 1;
            obj = absBusinessScene.fetchAction(cVar, enumUserGender, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
