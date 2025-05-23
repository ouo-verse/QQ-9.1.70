package com.tencent.filament.zplan.scene.couple;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.scene.couple.config.AvatarConfig;
import com.tencent.filament.zplan.scene.couple.config.BpConfig;
import com.tencent.filament.zplan.scene.couple.config.ItemConfig;
import com.tencent.filament.zplan.scene.couple.config.SceneConfig;
import com.tencent.filament.zplan.scene.couple.config.d;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.common.utils.h;
import com.tencent.zplan.zplantracing.c;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
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
@DebugMetadata(c = "com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$playSingleAnimation$1", f = "CoupleAvatarScene.kt", i = {0, 0, 0, 0, 0, 0}, l = {963}, m = "invokeSuspend", n = {"avatar", "otherAvatar", "location", "avatarTransform", "viewer", "singleAnimationId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
/* loaded from: classes6.dex */
public final class CoupleAvatarScene$playSingleAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventData;
    final /* synthetic */ c $spanContext;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ CoupleAvatarScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarScene$playSingleAnimation$1(CoupleAvatarScene coupleAvatarScene, String str, c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarScene;
        this.$eventData = str;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CoupleAvatarScene$playSingleAnimation$1(this.this$0, this.$eventData, this.$spanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoupleAvatarScene$playSingleAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Pair pair;
        xk0.a aVar;
        xk0.a aVar2;
        SceneConfig sceneConfig;
        double[] dArr;
        BpConfig room;
        SceneConfig sceneConfig2;
        d dVar;
        List asList;
        FilamentViewerV2305 viewer;
        Deferred V0;
        int i3;
        final xk0.a aVar3;
        final FilamentViewerV2305 filamentViewerV2305;
        final double[] dArr2;
        final xk0.a aVar4;
        final d dVar2;
        BpConfig room2;
        SceneConfig sceneConfig3;
        BpConfig room3;
        xk0.a aVar5;
        xk0.a aVar6;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                i3 = this.I$0;
                FilamentViewerV2305 filamentViewerV23052 = (FilamentViewerV2305) this.L$4;
                d dVar3 = (d) this.L$3;
                double[] dArr3 = (double[]) this.L$2;
                xk0.a aVar7 = (xk0.a) this.L$1;
                xk0.a aVar8 = (xk0.a) this.L$0;
                ResultKt.throwOnFailure(obj);
                filamentViewerV2305 = filamentViewerV23052;
                aVar3 = aVar7;
                aVar4 = aVar8;
                dVar2 = dVar3;
                dArr2 = dArr3;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            JSONObject b16 = h.f385294a.b(this.$eventData);
            if (b16 != null) {
                int optInt = b16.optInt("singleAnimationId");
                CoupleAvatarScene.AvatarTarget q16 = CoupleAvatarScene.INSTANCE.q(b16.optString("avatarTarget"));
                CoupleAvatarScene.AvatarTarget avatarTarget = CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT;
                if (q16 == avatarTarget) {
                    aVar5 = this.this$0.leftAvatar;
                    aVar6 = this.this$0.rightAvatar;
                    pair = new Pair(aVar5, aVar6);
                } else {
                    aVar = this.this$0.rightAvatar;
                    aVar2 = this.this$0.leftAvatar;
                    pair = new Pair(aVar, aVar2);
                }
                xk0.a aVar9 = (xk0.a) pair.component1();
                xk0.a aVar10 = (xk0.a) pair.component2();
                if (aVar9 != null && aVar10 != null) {
                    if (q16 == avatarTarget) {
                        sceneConfig3 = this.this$0.sceneConfig;
                        if (sceneConfig3 == null || (room3 = sceneConfig3.getRoom()) == null || (dArr = room3.getLeftSingleAnimPosition()) == null) {
                            dArr = new double[]{-0.25d, 0.0d, 0.6d};
                        }
                    } else {
                        sceneConfig = this.this$0.sceneConfig;
                        if (sceneConfig == null || (room = sceneConfig.getRoom()) == null || (dArr = room.getRightSingleAnimPosition()) == null) {
                            dArr = new double[]{0.25d, 0.0d, 0.6d};
                        }
                    }
                    EnumUserGender a16 = EnumUserGender.INSTANCE.a(aVar9.getAvatarCharacter().optInt("gender"));
                    sceneConfig2 = this.this$0.sceneConfig;
                    if (sceneConfig2 == null || (room2 = sceneConfig2.getRoom()) == null || (dVar = room2.h(q16, a16)) == null) {
                        dVar = new d(new double[]{0.0d, 0.0d, 0.0d}, null, null, 6, null);
                    }
                    FLog fLog = FLog.INSTANCE;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("playSingleAnimation, eventData:");
                    sb5.append(this.$eventData);
                    sb5.append(", location:");
                    asList = ArraysKt___ArraysJvmKt.asList(dArr);
                    sb5.append(asList);
                    fLog.i("CoupleAvatarScene", sb5.toString());
                    viewer = this.this$0.getViewer();
                    if (viewer != null) {
                        V0 = this.this$0.V0(this.$spanContext, optInt, aVar9.getAvatarCharacter());
                        this.L$0 = aVar9;
                        this.L$1 = aVar10;
                        this.L$2 = dArr;
                        this.L$3 = dVar;
                        this.L$4 = viewer;
                        this.I$0 = optInt;
                        this.label = 1;
                        Object await = V0.await(this);
                        if (await == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i3 = optInt;
                        aVar3 = aVar10;
                        filamentViewerV2305 = viewer;
                        dArr2 = dArr;
                        aVar4 = aVar9;
                        dVar2 = dVar;
                        obj = await;
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
        final AvatarConfig avatarConfig = (AvatarConfig) obj;
        this.this$0.k().d("playSingleAnimation(" + i3 + ')', new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$playSingleAnimation$1.1
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
                List<ItemConfig> c16;
                avatarConfig.m(dArr2);
                avatarConfig.n(dVar2);
                BpConfig bpConfig = avatarConfig.getBpConfig();
                if (bpConfig != null && (c16 = bpConfig.c()) != null) {
                    Iterator<T> it = c16.iterator();
                    while (it.hasNext()) {
                        ((ItemConfig) it.next()).d(new d(dArr2, null, null, 6, null));
                    }
                }
                avatarConfig.k(true);
                aVar4.m(CoupleAvatarScene$playSingleAnimation$1.this.$spanContext, filamentViewerV2305, avatarConfig, false);
                aVar3.b(filamentViewerV2305, 0.0d, true);
            }
        });
        return Unit.INSTANCE;
    }
}
