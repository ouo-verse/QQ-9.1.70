package com.tencent.filament.zplan.scene.couple;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.scene.couple.config.AvatarConfig;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$fetchSingleAnimResourceAsync$1", f = "CoupleAvatarScene.kt", i = {}, l = {648}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class CoupleAvatarScene$fetchSingleAnimResourceAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AvatarConfig>, Object> {
    final /* synthetic */ JSONObject $avatarCharacter;
    final /* synthetic */ int $singleAnimId;
    final /* synthetic */ c $spanContext;
    int label;
    final /* synthetic */ CoupleAvatarScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarScene$fetchSingleAnimResourceAsync$1(CoupleAvatarScene coupleAvatarScene, JSONObject jSONObject, int i3, c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarScene;
        this.$avatarCharacter = jSONObject;
        this.$singleAnimId = i3;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CoupleAvatarScene$fetchSingleAnimResourceAsync$1(this.this$0, this.$avatarCharacter, this.$singleAnimId, this.$spanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AvatarConfig> continuation) {
        return ((CoupleAvatarScene$fetchSingleAnimResourceAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        cl0.a aVar;
        String p16;
        cl0.a aVar2;
        String o16;
        cl0.a aVar3;
        String o17;
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
            String b16 = EnumUserGender.INSTANCE.b(this.$avatarCharacter.optInt("gender"));
            CoupleAvatarScene.Companion companion = CoupleAvatarScene.INSTANCE;
            aVar = this.this$0.coupleSceneUrlTemplate;
            p16 = companion.p(aVar, this.$singleAnimId, b16);
            aVar2 = this.this$0.coupleSceneUrlTemplate;
            o16 = companion.o(aVar2, this.$singleAnimId, b16, "head_anim");
            aVar3 = this.this$0.coupleSceneUrlTemplate;
            o17 = companion.o(aVar3, this.$singleAnimId, b16, "body_anim");
            CoupleAvatarScene coupleAvatarScene = this.this$0;
            c cVar = this.$spanContext;
            this.label = 1;
            obj = coupleAvatarScene.S0(cVar, p16, null, o16, o17, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
