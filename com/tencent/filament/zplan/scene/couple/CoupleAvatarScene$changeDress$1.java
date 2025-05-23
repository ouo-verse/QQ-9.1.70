package com.tencent.filament.zplan.scene.couple;

import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.scene.couple.config.d;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.zplan.common.utils.h;
import com.tencent.zplan.zplantracing.c;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$changeDress$1", f = "CoupleAvatarScene.kt", i = {0, 0, 0, 1, 1, 1}, l = {312, 313}, m = "invokeSuspend", n = {"leftAvatarCharacter", "rightAvatarCharacter", "rightResourceModelDeferred", "leftAvatarCharacter", "rightAvatarCharacter", "leftResourceModel"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
public final class CoupleAvatarScene$changeDress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventData;
    final /* synthetic */ c $spanContext;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CoupleAvatarScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarScene$changeDress$1(CoupleAvatarScene coupleAvatarScene, String str, c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarScene;
        this.$eventData = str;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CoupleAvatarScene$changeDress$1(this.this$0, this.$eventData, this.$spanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoupleAvatarScene$changeDress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00b5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        JSONObject optJSONObject;
        Deferred deferred;
        Deferred deferred2;
        JSONObject jSONObject;
        ReloadAvatarResourceModel reloadAvatarResourceModel;
        JSONObject jSONObject2;
        Deferred deferred3;
        final ReloadAvatarResourceModel reloadAvatarResourceModel2;
        final JSONObject jSONObject3;
        final ReloadAvatarResourceModel reloadAvatarResourceModel3;
        final JSONObject jSONObject4;
        ReloadAvatarResourceModel reloadAvatarResourceModel4;
        JSONObject jSONObject5;
        final FilamentViewerV2305 viewer;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    reloadAvatarResourceModel4 = (ReloadAvatarResourceModel) this.L$2;
                    jSONObject = (JSONObject) this.L$1;
                    jSONObject5 = (JSONObject) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    reloadAvatarResourceModel2 = reloadAvatarResourceModel4;
                    jSONObject3 = jSONObject;
                    jSONObject4 = jSONObject5;
                    reloadAvatarResourceModel3 = (ReloadAvatarResourceModel) obj;
                    if (FilamentFeatureUtil.f106409g.m()) {
                        viewer = this.this$0.getViewer();
                        if (viewer != null) {
                            this.this$0.g1("createOrReuseLeftAvatar", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$changeDress$1.1
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
                                    xk0.a aVar;
                                    xk0.a aVar2;
                                    d dVar;
                                    if (reloadAvatarResourceModel2 != null) {
                                        aVar = CoupleAvatarScene$changeDress$1.this.this$0.leftAvatar;
                                        if (aVar != null) {
                                            CoupleAvatarScene$changeDress$1 coupleAvatarScene$changeDress$1 = CoupleAvatarScene$changeDress$1.this;
                                            CoupleAvatarScene coupleAvatarScene = coupleAvatarScene$changeDress$1.this$0;
                                            c cVar = coupleAvatarScene$changeDress$1.$spanContext;
                                            FilamentViewerV2305 filamentViewerV2305 = viewer;
                                            JSONObject leftAvatarCharacter = jSONObject4;
                                            Intrinsics.checkNotNullExpressionValue(leftAvatarCharacter, "leftAvatarCharacter");
                                            ReloadAvatarResourceModel reloadAvatarResourceModel5 = reloadAvatarResourceModel2;
                                            aVar2 = CoupleAvatarScene$changeDress$1.this.this$0.leftAvatar;
                                            dVar = CoupleAvatarScene$changeDress$1.this.this$0.leftTransform;
                                            CoupleAvatarScene.K0(coupleAvatarScene, cVar, filamentViewerV2305, leftAvatarCharacter, reloadAvatarResourceModel5, aVar2, false, dVar, 32, null);
                                        }
                                    }
                                }
                            });
                            this.this$0.g1("createOrReuseRightAvatar", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$changeDress$1.2
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
                                    AtomicBoolean atomicBoolean;
                                    xk0.a aVar;
                                    xk0.a aVar2;
                                    d dVar;
                                    if (reloadAvatarResourceModel3 != null) {
                                        aVar = CoupleAvatarScene$changeDress$1.this.this$0.rightAvatar;
                                        if (aVar != null) {
                                            CoupleAvatarScene$changeDress$1 coupleAvatarScene$changeDress$1 = CoupleAvatarScene$changeDress$1.this;
                                            CoupleAvatarScene coupleAvatarScene = coupleAvatarScene$changeDress$1.this$0;
                                            c cVar = coupleAvatarScene$changeDress$1.$spanContext;
                                            FilamentViewerV2305 filamentViewerV2305 = viewer;
                                            JSONObject rightAvatarCharacter = jSONObject3;
                                            Intrinsics.checkNotNullExpressionValue(rightAvatarCharacter, "rightAvatarCharacter");
                                            ReloadAvatarResourceModel reloadAvatarResourceModel5 = reloadAvatarResourceModel3;
                                            aVar2 = CoupleAvatarScene$changeDress$1.this.this$0.rightAvatar;
                                            dVar = CoupleAvatarScene$changeDress$1.this.this$0.rightTransform;
                                            CoupleAvatarScene.K0(coupleAvatarScene, cVar, filamentViewerV2305, rightAvatarCharacter, reloadAvatarResourceModel5, aVar2, false, dVar, 32, null);
                                        }
                                    }
                                    atomicBoolean = CoupleAvatarScene$changeDress$1.this.this$0.hasRecordFrame;
                                    atomicBoolean.set(false);
                                }
                            });
                        } else {
                            return Unit.INSTANCE;
                        }
                    } else {
                        this.this$0.k().d("changeDress", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$changeDress$1.3
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
                                FilamentViewerV2305 viewer2;
                                AtomicBoolean atomicBoolean;
                                xk0.a aVar;
                                xk0.a aVar2;
                                d dVar;
                                xk0.a aVar3;
                                xk0.a aVar4;
                                d dVar2;
                                viewer2 = CoupleAvatarScene$changeDress$1.this.this$0.getViewer();
                                if (viewer2 != null) {
                                    if (reloadAvatarResourceModel2 != null) {
                                        aVar3 = CoupleAvatarScene$changeDress$1.this.this$0.leftAvatar;
                                        if (aVar3 != null) {
                                            CoupleAvatarScene$changeDress$1 coupleAvatarScene$changeDress$1 = CoupleAvatarScene$changeDress$1.this;
                                            CoupleAvatarScene coupleAvatarScene = coupleAvatarScene$changeDress$1.this$0;
                                            c cVar = coupleAvatarScene$changeDress$1.$spanContext;
                                            JSONObject leftAvatarCharacter = jSONObject4;
                                            Intrinsics.checkNotNullExpressionValue(leftAvatarCharacter, "leftAvatarCharacter");
                                            ReloadAvatarResourceModel reloadAvatarResourceModel5 = reloadAvatarResourceModel2;
                                            aVar4 = CoupleAvatarScene$changeDress$1.this.this$0.leftAvatar;
                                            dVar2 = CoupleAvatarScene$changeDress$1.this.this$0.leftTransform;
                                            CoupleAvatarScene.K0(coupleAvatarScene, cVar, viewer2, leftAvatarCharacter, reloadAvatarResourceModel5, aVar4, false, dVar2, 32, null);
                                        }
                                    }
                                    if (reloadAvatarResourceModel3 != null) {
                                        aVar = CoupleAvatarScene$changeDress$1.this.this$0.rightAvatar;
                                        if (aVar != null) {
                                            CoupleAvatarScene$changeDress$1 coupleAvatarScene$changeDress$12 = CoupleAvatarScene$changeDress$1.this;
                                            CoupleAvatarScene coupleAvatarScene2 = coupleAvatarScene$changeDress$12.this$0;
                                            c cVar2 = coupleAvatarScene$changeDress$12.$spanContext;
                                            JSONObject rightAvatarCharacter = jSONObject3;
                                            Intrinsics.checkNotNullExpressionValue(rightAvatarCharacter, "rightAvatarCharacter");
                                            ReloadAvatarResourceModel reloadAvatarResourceModel6 = reloadAvatarResourceModel3;
                                            aVar2 = CoupleAvatarScene$changeDress$1.this.this$0.rightAvatar;
                                            dVar = CoupleAvatarScene$changeDress$1.this.this$0.rightTransform;
                                            CoupleAvatarScene.K0(coupleAvatarScene2, cVar2, viewer2, rightAvatarCharacter, reloadAvatarResourceModel6, aVar2, false, dVar, 32, null);
                                        }
                                    }
                                    atomicBoolean = CoupleAvatarScene$changeDress$1.this.this$0.hasRecordFrame;
                                    atomicBoolean.set(false);
                                }
                            }
                        });
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            deferred3 = (Deferred) this.L$2;
            jSONObject2 = (JSONObject) this.L$1;
            optJSONObject = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            JSONObject b16 = h.f385294a.b(this.$eventData);
            if (b16 != null) {
                optJSONObject = b16.optJSONObject(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT.toString());
                if (optJSONObject != null) {
                    deferred = this.this$0.R0(this.$spanContext, optJSONObject);
                } else {
                    deferred = null;
                }
                JSONObject optJSONObject2 = b16.optJSONObject(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT.toString());
                if (optJSONObject2 != null) {
                    deferred2 = this.this$0.R0(this.$spanContext, optJSONObject2);
                } else {
                    deferred2 = null;
                }
                if (deferred != null) {
                    this.L$0 = optJSONObject;
                    this.L$1 = optJSONObject2;
                    this.L$2 = deferred2;
                    this.label = 1;
                    Object await = deferred.await(this);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jSONObject2 = optJSONObject2;
                    obj = await;
                    deferred3 = deferred2;
                } else {
                    jSONObject = optJSONObject2;
                    reloadAvatarResourceModel = null;
                    if (deferred2 == null) {
                        this.L$0 = optJSONObject;
                        this.L$1 = jSONObject;
                        this.L$2 = reloadAvatarResourceModel;
                        this.label = 2;
                        Object await2 = deferred2.await(this);
                        if (await2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        reloadAvatarResourceModel4 = reloadAvatarResourceModel;
                        obj = await2;
                        jSONObject5 = optJSONObject;
                        reloadAvatarResourceModel2 = reloadAvatarResourceModel4;
                        jSONObject3 = jSONObject;
                        jSONObject4 = jSONObject5;
                        reloadAvatarResourceModel3 = (ReloadAvatarResourceModel) obj;
                        if (FilamentFeatureUtil.f106409g.m()) {
                        }
                        return Unit.INSTANCE;
                    }
                    reloadAvatarResourceModel2 = reloadAvatarResourceModel;
                    jSONObject3 = jSONObject;
                    reloadAvatarResourceModel3 = null;
                    jSONObject4 = optJSONObject;
                    if (FilamentFeatureUtil.f106409g.m()) {
                    }
                    return Unit.INSTANCE;
                }
            } else {
                return Unit.INSTANCE;
            }
        }
        reloadAvatarResourceModel = (ReloadAvatarResourceModel) obj;
        deferred2 = deferred3;
        jSONObject = jSONObject2;
        if (deferred2 == null) {
        }
    }
}
