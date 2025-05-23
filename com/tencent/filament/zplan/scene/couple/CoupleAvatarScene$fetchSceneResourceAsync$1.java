package com.tencent.filament.zplan.scene.couple;

import com.tencent.filament.zplan.scene.couple.config.AvatarConfig;
import com.tencent.filament.zplan.scene.couple.config.BpConfig;
import com.tencent.filament.zplan.scene.couple.config.SceneConfig;
import com.tencent.zplan.common.model.AppTheme;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/scene/couple/config/c;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$fetchSceneResourceAsync$1", f = "CoupleAvatarScene.kt", i = {0, 0, 1}, l = {633, 634, 635}, m = "invokeSuspend", n = {"leftAvatarConfigDeferred", "rightAvatarConfigDeferred", "rightAvatarConfigDeferred"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes6.dex */
public final class CoupleAvatarScene$fetchSceneResourceAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SceneConfig>, Object> {
    final /* synthetic */ JSONObject $leftAvatarCharacter;
    final /* synthetic */ JSONObject $rightAvatarCharacter;
    final /* synthetic */ int $sceneId;
    final /* synthetic */ c $spanContext;
    final /* synthetic */ AppTheme $theme;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CoupleAvatarScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarScene$fetchSceneResourceAsync$1(CoupleAvatarScene coupleAvatarScene, int i3, AppTheme appTheme, c cVar, JSONObject jSONObject, JSONObject jSONObject2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarScene;
        this.$sceneId = i3;
        this.$theme = appTheme;
        this.$spanContext = cVar;
        this.$leftAvatarCharacter = jSONObject;
        this.$rightAvatarCharacter = jSONObject2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        CoupleAvatarScene$fetchSceneResourceAsync$1 coupleAvatarScene$fetchSceneResourceAsync$1 = new CoupleAvatarScene$fetchSceneResourceAsync$1(this.this$0, this.$sceneId, this.$theme, this.$spanContext, this.$leftAvatarCharacter, this.$rightAvatarCharacter, completion);
        coupleAvatarScene$fetchSceneResourceAsync$1.L$0 = obj;
        return coupleAvatarScene$fetchSceneResourceAsync$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SceneConfig> continuation) {
        return ((CoupleAvatarScene$fetchSceneResourceAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        Deferred async$default3;
        int i3;
        Deferred deferred;
        Deferred deferred2;
        BpConfig bpConfig;
        Object await;
        int i16;
        AvatarConfig avatarConfig;
        BpConfig bpConfig2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 == 3) {
                        i16 = this.I$0;
                        avatarConfig = (AvatarConfig) this.L$1;
                        bpConfig2 = (BpConfig) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        return new SceneConfig(i16, bpConfig2, avatarConfig, (AvatarConfig) obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i3 = this.I$0;
                bpConfig = (BpConfig) this.L$1;
                deferred2 = (Deferred) this.L$0;
                ResultKt.throwOnFailure(obj);
                AvatarConfig avatarConfig2 = (AvatarConfig) obj;
                this.L$0 = bpConfig;
                this.L$1 = avatarConfig2;
                this.I$0 = i3;
                this.label = 3;
                await = deferred2.await(this);
                if (await != coroutine_suspended) {
                    return coroutine_suspended;
                }
                i16 = i3;
                avatarConfig = avatarConfig2;
                obj = await;
                bpConfig2 = bpConfig;
                return new SceneConfig(i16, bpConfig2, avatarConfig, (AvatarConfig) obj);
            }
            i3 = this.I$0;
            deferred2 = (Deferred) this.L$1;
            deferred = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new CoupleAvatarScene$fetchSceneResourceAsync$1$roomBpConfigDeferred$1(this, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new CoupleAvatarScene$fetchSceneResourceAsync$1$leftAvatarConfigDeferred$1(this, null), 3, null);
            async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new CoupleAvatarScene$fetchSceneResourceAsync$1$rightAvatarConfigDeferred$1(this, null), 3, null);
            i3 = this.$sceneId;
            this.L$0 = async$default2;
            this.L$1 = async$default3;
            this.I$0 = i3;
            this.label = 1;
            Object await2 = async$default.await(this);
            if (await2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            deferred = async$default2;
            deferred2 = async$default3;
            obj = await2;
        }
        BpConfig bpConfig3 = (BpConfig) obj;
        this.L$0 = deferred2;
        this.L$1 = bpConfig3;
        this.I$0 = i3;
        this.label = 2;
        Object await3 = deferred.await(this);
        if (await3 == coroutine_suspended) {
            return coroutine_suspended;
        }
        bpConfig = bpConfig3;
        obj = await3;
        AvatarConfig avatarConfig22 = (AvatarConfig) obj;
        this.L$0 = bpConfig;
        this.L$1 = avatarConfig22;
        this.I$0 = i3;
        this.label = 3;
        await = deferred2.await(this);
        if (await != coroutine_suspended) {
        }
    }
}
