package com.tencent.filament.zplan.scene.couple;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.scene.couple.config.AvatarConfig;
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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$fetchCoupleAnimResourceAsync$1", f = "CoupleAvatarScene.kt", i = {1}, l = {663, 669}, m = "invokeSuspend", n = {"leftAvatarConfig"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class CoupleAvatarScene$fetchCoupleAnimResourceAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends AvatarConfig, ? extends AvatarConfig>>, Object> {
    final /* synthetic */ int $coupleAnimationId;
    final /* synthetic */ JSONObject $leftAvatarCharacter;
    final /* synthetic */ JSONObject $rightAvatarCharacter;
    final /* synthetic */ c $spanContext;
    Object L$0;
    int label;
    final /* synthetic */ CoupleAvatarScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarScene$fetchCoupleAnimResourceAsync$1(CoupleAvatarScene coupleAvatarScene, int i3, JSONObject jSONObject, c cVar, JSONObject jSONObject2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarScene;
        this.$coupleAnimationId = i3;
        this.$leftAvatarCharacter = jSONObject;
        this.$spanContext = cVar;
        this.$rightAvatarCharacter = jSONObject2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CoupleAvatarScene$fetchCoupleAnimResourceAsync$1(this.this$0, this.$coupleAnimationId, this.$leftAvatarCharacter, this.$spanContext, this.$rightAvatarCharacter, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends AvatarConfig, ? extends AvatarConfig>> continuation) {
        return ((CoupleAvatarScene$fetchCoupleAnimResourceAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        cl0.a aVar;
        String j3;
        cl0.a aVar2;
        String k3;
        cl0.a aVar3;
        String i3;
        cl0.a aVar4;
        String i16;
        cl0.a aVar5;
        String k16;
        cl0.a aVar6;
        String i17;
        cl0.a aVar7;
        String i18;
        AvatarConfig avatarConfig;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i19 = this.label;
        if (i19 != 0) {
            if (i19 != 1) {
                if (i19 == 2) {
                    avatarConfig = (AvatarConfig) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return new Pair(avatarConfig, (AvatarConfig) obj);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoupleAvatarScene.Companion companion = CoupleAvatarScene.INSTANCE;
            aVar = this.this$0.coupleSceneUrlTemplate;
            j3 = companion.j(aVar, this.$coupleAnimationId);
            String b16 = EnumUserGender.INSTANCE.b(this.$leftAvatarCharacter.optInt("gender"));
            aVar2 = this.this$0.coupleSceneUrlTemplate;
            k3 = companion.k(aVar2, this.$coupleAnimationId, "left", b16);
            aVar3 = this.this$0.coupleSceneUrlTemplate;
            i3 = companion.i(aVar3, this.$coupleAnimationId, "left", b16, "head_anim");
            aVar4 = this.this$0.coupleSceneUrlTemplate;
            i16 = companion.i(aVar4, this.$coupleAnimationId, "left", b16, "body_anim");
            CoupleAvatarScene coupleAvatarScene = this.this$0;
            c cVar = this.$spanContext;
            this.label = 1;
            obj = coupleAvatarScene.S0(cVar, j3, k3, i3, i16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        AvatarConfig avatarConfig2 = (AvatarConfig) obj;
        String b17 = EnumUserGender.INSTANCE.b(this.$rightAvatarCharacter.optInt("gender"));
        CoupleAvatarScene.Companion companion2 = CoupleAvatarScene.INSTANCE;
        aVar5 = this.this$0.coupleSceneUrlTemplate;
        k16 = companion2.k(aVar5, this.$coupleAnimationId, "right", b17);
        aVar6 = this.this$0.coupleSceneUrlTemplate;
        i17 = companion2.i(aVar6, this.$coupleAnimationId, "right", b17, "head_anim");
        aVar7 = this.this$0.coupleSceneUrlTemplate;
        i18 = companion2.i(aVar7, this.$coupleAnimationId, "right", b17, "body_anim");
        CoupleAvatarScene coupleAvatarScene2 = this.this$0;
        c cVar2 = this.$spanContext;
        this.L$0 = avatarConfig2;
        this.label = 2;
        Object S0 = coupleAvatarScene2.S0(cVar2, null, k16, i17, i18, this);
        if (S0 == coroutine_suspended) {
            return coroutine_suspended;
        }
        avatarConfig = avatarConfig2;
        obj = S0;
        return new Pair(avatarConfig, (AvatarConfig) obj);
    }
}
