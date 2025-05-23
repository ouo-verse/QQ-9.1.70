package com.tencent.filament.zplan.scene.couple;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.scene.couple.config.AvatarConfig;
import com.tencent.filament.zplan.scene.couple.config.BpConfig;
import com.tencent.filament.zplan.scene.couple.config.SceneConfig;
import com.tencent.filament.zplan.scene.couple.config.d;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.common.utils.h;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$playCoupleAnimation$1", f = "CoupleAvatarScene.kt", i = {0, 0, 0, 0}, l = {989}, m = "invokeSuspend", n = {"leftAvatar", "rightAvatar", "viewer", "coupleAnimationId"}, s = {"L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes6.dex */
public final class CoupleAvatarScene$playCoupleAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventData;
    final /* synthetic */ c $spanContext;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CoupleAvatarScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarScene$playCoupleAnimation$1(CoupleAvatarScene coupleAvatarScene, String str, c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarScene;
        this.$eventData = str;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CoupleAvatarScene$playCoupleAnimation$1(this.this$0, this.$eventData, this.$spanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoupleAvatarScene$playCoupleAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        xk0.a aVar;
        xk0.a aVar2;
        FilamentViewerV2305 viewer;
        Deferred Q0;
        final xk0.a aVar3;
        int i3;
        final FilamentViewerV2305 filamentViewerV2305;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                i3 = this.I$0;
                FilamentViewerV2305 filamentViewerV23052 = (FilamentViewerV2305) this.L$2;
                xk0.a aVar4 = (xk0.a) this.L$1;
                aVar = (xk0.a) this.L$0;
                ResultKt.throwOnFailure(obj);
                filamentViewerV2305 = filamentViewerV23052;
                aVar3 = aVar4;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FLog.INSTANCE.i("CoupleAvatarScene", "playCoupleAnimation, eventData:" + this.$eventData);
            aVar = this.this$0.leftAvatar;
            if (aVar != null) {
                aVar2 = this.this$0.rightAvatar;
                if (aVar2 != null) {
                    JSONObject b16 = h.f385294a.b(this.$eventData);
                    if (b16 != null) {
                        int optInt = b16.optInt("coupleAnimationId");
                        viewer = this.this$0.getViewer();
                        if (viewer != null) {
                            Q0 = this.this$0.Q0(this.$spanContext, optInt, aVar.getAvatarCharacter(), aVar2.getAvatarCharacter());
                            this.L$0 = aVar;
                            this.L$1 = aVar2;
                            this.L$2 = viewer;
                            this.I$0 = optInt;
                            this.label = 1;
                            Object await = Q0.await(this);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            aVar3 = aVar2;
                            i3 = optInt;
                            obj = await;
                            filamentViewerV2305 = viewer;
                        } else {
                            return Unit.INSTANCE;
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    return Unit.INSTANCE;
                }
            } else {
                return Unit.INSTANCE;
            }
        }
        final xk0.a aVar5 = aVar;
        Pair pair = (Pair) obj;
        final AvatarConfig avatarConfig = (AvatarConfig) pair.component1();
        final AvatarConfig avatarConfig2 = (AvatarConfig) pair.component2();
        this.this$0.k().d("playCoupleAnimation(" + i3 + ')', new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$playCoupleAnimation$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SceneConfig sceneConfig;
                d dVar;
                SceneConfig sceneConfig2;
                d dVar2;
                BpConfig room;
                BpConfig room2;
                avatarConfig.m(new double[]{0.0d, 0.0d, 0.0d});
                avatarConfig.k(true);
                EnumUserGender.Companion companion = EnumUserGender.INSTANCE;
                EnumUserGender a16 = companion.a(aVar5.getAvatarCharacter().optInt("gender"));
                sceneConfig = CoupleAvatarScene$playCoupleAnimation$1.this.this$0.sceneConfig;
                if (sceneConfig == null || (room2 = sceneConfig.getRoom()) == null || (dVar = room2.h(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT, a16)) == null) {
                    dVar = new d(new double[]{0.0d, 0.0d, 0.0d}, null, null, 6, null);
                }
                avatarConfig.n(dVar);
                aVar5.m(CoupleAvatarScene$playCoupleAnimation$1.this.$spanContext, filamentViewerV2305, avatarConfig, true);
                avatarConfig2.m(new double[]{0.0d, 0.0d, 0.0d});
                avatarConfig2.k(true);
                EnumUserGender a17 = companion.a(aVar5.getAvatarCharacter().optInt("gender"));
                sceneConfig2 = CoupleAvatarScene$playCoupleAnimation$1.this.this$0.sceneConfig;
                if (sceneConfig2 == null || (room = sceneConfig2.getRoom()) == null || (dVar2 = room.h(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT, a17)) == null) {
                    dVar2 = new d(new double[]{0.0d, 0.0d, 0.0d}, null, null, 6, null);
                }
                avatarConfig2.n(dVar2);
                aVar3.m(CoupleAvatarScene$playCoupleAnimation$1.this.$spanContext, filamentViewerV2305, avatarConfig2, true);
            }
        });
        return Unit.INSTANCE;
    }
}
