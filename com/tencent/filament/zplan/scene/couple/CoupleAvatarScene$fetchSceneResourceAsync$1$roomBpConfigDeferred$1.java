package com.tencent.filament.zplan.scene.couple;

import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.scene.couple.config.BpConfig;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplan/scene/couple/config/BpConfig;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$fetchSceneResourceAsync$1$roomBpConfigDeferred$1", f = "CoupleAvatarScene.kt", i = {}, l = {612}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class CoupleAvatarScene$fetchSceneResourceAsync$1$roomBpConfigDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BpConfig>, Object> {
    int label;
    final /* synthetic */ CoupleAvatarScene$fetchSceneResourceAsync$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarScene$fetchSceneResourceAsync$1$roomBpConfigDeferred$1(CoupleAvatarScene$fetchSceneResourceAsync$1 coupleAvatarScene$fetchSceneResourceAsync$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarScene$fetchSceneResourceAsync$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CoupleAvatarScene$fetchSceneResourceAsync$1$roomBpConfigDeferred$1(this.this$0, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BpConfig> continuation) {
        return ((CoupleAvatarScene$fetchSceneResourceAsync$1$roomBpConfigDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        cl0.a aVar;
        String n3;
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
            CoupleAvatarScene.Companion companion = CoupleAvatarScene.INSTANCE;
            aVar = this.this$0.this$0.coupleSceneUrlTemplate;
            CoupleAvatarScene$fetchSceneResourceAsync$1 coupleAvatarScene$fetchSceneResourceAsync$1 = this.this$0;
            n3 = companion.n(aVar, coupleAvatarScene$fetchSceneResourceAsync$1.$sceneId, coupleAvatarScene$fetchSceneResourceAsync$1.$theme);
            CoupleAvatarScene$fetchSceneResourceAsync$1 coupleAvatarScene$fetchSceneResourceAsync$12 = this.this$0;
            CoupleAvatarScene coupleAvatarScene = coupleAvatarScene$fetchSceneResourceAsync$12.this$0;
            c cVar = coupleAvatarScene$fetchSceneResourceAsync$12.$spanContext;
            this.label = 1;
            obj = coupleAvatarScene.U0(cVar, n3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
