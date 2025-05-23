package com.tencent.filament.zplan.scene.cartoon;

import com.google.gson.Gson;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.animation.sequencer.NormalAnimation;
import com.tencent.filament.zplan.animation.sequencer.Track;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.util.d;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.common.utils.h;
import com.tencent.zplan.zplantracing.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.cartoon.CartoonScene$onLoad$1", f = "CartoonScene.kt", i = {0, 0, 0, 1, 1}, l = {98, 276}, m = "invokeSuspend", n = {"$this$launch", "gltfPath", "shaderPath", "bootResource", "avatar"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class CartoonScene$onLoad$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventData;
    final /* synthetic */ c $spanContext;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CartoonScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CartoonScene$onLoad$1(CartoonScene cartoonScene, String str, c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = cartoonScene;
        this.$eventData = str;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        CartoonScene$onLoad$1 cartoonScene$onLoad$1 = new CartoonScene$onLoad$1(this.this$0, this.$eventData, this.$spanContext, completion);
        cartoonScene$onLoad$1.L$0 = obj;
        return cartoonScene$onLoad$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CartoonScene$onLoad$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        String optString;
        String optString2;
        FilamentUrlTemplate filamentUrlTemplate;
        Object F;
        BootResourceModel g16;
        JSONObject jSONObject;
        List listOf;
        int collectionSizeOrDefault;
        Object awaitAll;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    JSONObject jSONObject2 = (JSONObject) this.L$1;
                    g16 = (BootResourceModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitAll = obj;
                    jSONObject = jSONObject2;
                    final BootResourceModel bootResourceModel = g16;
                    List list = (List) awaitAll;
                    final ZPlanAction zPlanAction = (ZPlanAction) list.get(0);
                    final ZPlanAction zPlanAction2 = (ZPlanAction) list.get(1);
                    final ZPlanAction zPlanAction3 = (ZPlanAction) list.get(2);
                    final JSONObject jSONObject3 = jSONObject;
                    this.this$0.k().d("boot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.cartoon.CartoonScene$onLoad$1.1
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
                            FilamentViewerV2305 viewer;
                            FilamentViewerV2305 viewer2;
                            FilamentViewerV2305 viewer3;
                            FilamentViewerV2305 viewer4;
                            FilamentViewerV2305 viewer5;
                            FilamentViewerV2305 viewer6;
                            Object firstOrNull;
                            Object firstOrNull2;
                            Object firstOrNull3;
                            Object firstOrNull4;
                            Object firstOrNull5;
                            Object firstOrNull6;
                            long j3;
                            List mutableListOf;
                            long j16;
                            LightsParams N;
                            CameraParams M;
                            viewer = CartoonScene$onLoad$1.this.this$0.getViewer();
                            if (viewer != null ? FilamentViewerV2.boot$default(viewer, bootResourceModel, "", false, false, false, FilamentFeatureUtil.f106409g.K(), false, 64, null) : false) {
                                viewer2 = CartoonScene$onLoad$1.this.this$0.getViewer();
                                if (viewer2 != null) {
                                    Gson gson = new Gson();
                                    M = CartoonScene$onLoad$1.this.this$0.M();
                                    String json = gson.toJson(M);
                                    Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(defaultCamera())");
                                    viewer2.setCamera(json);
                                }
                                viewer3 = CartoonScene$onLoad$1.this.this$0.getViewer();
                                if (viewer3 != null) {
                                    N = CartoonScene$onLoad$1.this.this$0.N();
                                    IndirectLight indirectLight = N.getIndirectLight();
                                    if (indirectLight != null) {
                                        String indirectLightPath = bootResourceModel.getIndirectLightPath();
                                        if (indirectLightPath == null) {
                                            indirectLightPath = "";
                                        }
                                        indirectLight.setPath(indirectLightPath);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    viewer3.setLights(N);
                                }
                                CartoonScene cartoonScene = CartoonScene$onLoad$1.this.this$0;
                                viewer4 = cartoonScene.getViewer();
                                cartoonScene.avatarRenderObjectId = viewer4 != null ? viewer4.createAvatarRenderObject(CartoonScene$onLoad$1.this.$spanContext) : 0L;
                                viewer5 = CartoonScene$onLoad$1.this.this$0.getViewer();
                                if (viewer5 != null) {
                                    CartoonScene$onLoad$1 cartoonScene$onLoad$1 = CartoonScene$onLoad$1.this;
                                    c cVar = cartoonScene$onLoad$1.$spanContext;
                                    j16 = cartoonScene$onLoad$1.this$0.avatarRenderObjectId;
                                    viewer5.updateRenderObjectAvatar(cVar, j16, jSONObject3);
                                }
                                viewer6 = CartoonScene$onLoad$1.this.this$0.getViewer();
                                if (viewer6 != null) {
                                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(viewer6.loadAnimation(zPlanAction.getFaceAnimationGltfPath(), null));
                                    if (((FilamentAnimation) firstOrNull) != null) {
                                        firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(viewer6.loadAnimation(zPlanAction.getBodyAnimationGltfPath(), null));
                                        FilamentAnimation filamentAnimation = (FilamentAnimation) firstOrNull2;
                                        if (filamentAnimation != null) {
                                            firstOrNull3 = ArraysKt___ArraysKt.firstOrNull(viewer6.loadAnimation(zPlanAction2.getFaceAnimationGltfPath(), null));
                                            if (((FilamentAnimation) firstOrNull3) != null) {
                                                firstOrNull4 = ArraysKt___ArraysKt.firstOrNull(viewer6.loadAnimation(zPlanAction2.getBodyAnimationGltfPath(), null));
                                                FilamentAnimation filamentAnimation2 = (FilamentAnimation) firstOrNull4;
                                                if (filamentAnimation2 != null) {
                                                    firstOrNull5 = ArraysKt___ArraysKt.firstOrNull(viewer6.loadAnimation(zPlanAction3.getFaceAnimationGltfPath(), null));
                                                    if (((FilamentAnimation) firstOrNull5) != null) {
                                                        firstOrNull6 = ArraysKt___ArraysKt.firstOrNull(viewer6.loadAnimation(zPlanAction3.getBodyAnimationGltfPath(), null));
                                                        FilamentAnimation filamentAnimation3 = (FilamentAnimation) firstOrNull6;
                                                        if (filamentAnimation3 != null) {
                                                            CartoonScene$onLoad$1 cartoonScene$onLoad$12 = CartoonScene$onLoad$1.this;
                                                            c cVar2 = cartoonScene$onLoad$12.$spanContext;
                                                            j3 = cartoonScene$onLoad$12.this$0.avatarRenderObjectId;
                                                            NormalAnimation.Companion companion = NormalAnimation.INSTANCE;
                                                            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(companion.a(filamentAnimation), companion.a(filamentAnimation2), companion.a(filamentAnimation3));
                                                            Track track = new Track(true, mutableListOf);
                                                            d.a(track);
                                                            Unit unit2 = Unit.INSTANCE;
                                                            viewer6.bindAnimationTrack(cVar2, j3, track);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            CartoonScene$onLoad$1.this.this$0.o(201024, "boot fail");
                            throw new IllegalArgumentException("boot fail");
                        }
                    });
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            optString2 = (String) this.L$2;
            optString = (String) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            F = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            JSONObject b16 = h.f385294a.b(this.$eventData);
            if (b16 != null) {
                optString = b16.optString("gltfPath");
                optString2 = b16.optString("shaderPath");
                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                c cVar = this.$spanContext;
                filamentUrlTemplate = this.this$0.urlTemplate;
                this.L$0 = coroutineScope;
                this.L$1 = optString;
                this.L$2 = optString2;
                this.label = 1;
                F = zPlanAvatarResourceHelper.F(cVar, filamentUrlTemplate, this);
                if (F == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new IllegalArgumentException("eventData parse fail");
            }
        }
        g16 = BootResourceModel.g((BootResourceModel) F, optString2, null, null, null, 14, null);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("avatarGltf", optString);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("slotGltfMap", jSONObject4);
        jSONObject = new JSONObject();
        jSONObject.put("dressUpInfo", jSONObject5);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("CMShow/Assets/Animation/Character/Player/Animation/AnimSequence/A_Female/StandingSideways/HeadAnimation/A_CH_F_Idle_Emote_Anim", "CMShow/Assets/Animation/Character/Player/Animation/AnimSequence/A_Female/StandingSideways/BodyAnimation/A_CH_F_Idle"), new Pair("CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/A_Female/zengliang/HeadAnimation/A_CH_F_Relax_1_Emote_Anim_1", "CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/A_Female/zengliang/BodyAnimation/A_CH_F_Relax_1"), new Pair("CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Female/HeadAnimation/A_CH_F_H_GorgeousClothes_01_Emote_Montage", "CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Female/BodyAnimation/A_CH_F_H_GorgeousClothes_01_Montage")});
        List list2 = listOf;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new CartoonScene$onLoad$1$invokeSuspend$$inlined$map$lambda$1((Pair) it.next(), null, this, coroutineScope), 3, null);
            arrayList.add(async$default);
        }
        this.L$0 = g16;
        this.L$1 = jSONObject;
        this.L$2 = null;
        this.label = 2;
        awaitAll = AwaitKt.awaitAll(arrayList, this);
        if (awaitAll == coroutine_suspended) {
            return coroutine_suspended;
        }
        final BootResourceModel bootResourceModel2 = g16;
        List list3 = (List) awaitAll;
        final ZPlanAction zPlanAction4 = (ZPlanAction) list3.get(0);
        final ZPlanAction zPlanAction22 = (ZPlanAction) list3.get(1);
        final ZPlanAction zPlanAction32 = (ZPlanAction) list3.get(2);
        final JSONObject jSONObject32 = jSONObject;
        this.this$0.k().d("boot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.cartoon.CartoonScene$onLoad$1.1
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
                FilamentViewerV2305 viewer;
                FilamentViewerV2305 viewer2;
                FilamentViewerV2305 viewer3;
                FilamentViewerV2305 viewer4;
                FilamentViewerV2305 viewer5;
                FilamentViewerV2305 viewer6;
                Object firstOrNull;
                Object firstOrNull2;
                Object firstOrNull3;
                Object firstOrNull4;
                Object firstOrNull5;
                Object firstOrNull6;
                long j3;
                List mutableListOf;
                long j16;
                LightsParams N;
                CameraParams M;
                viewer = CartoonScene$onLoad$1.this.this$0.getViewer();
                if (viewer != null ? FilamentViewerV2.boot$default(viewer, bootResourceModel2, "", false, false, false, FilamentFeatureUtil.f106409g.K(), false, 64, null) : false) {
                    viewer2 = CartoonScene$onLoad$1.this.this$0.getViewer();
                    if (viewer2 != null) {
                        Gson gson = new Gson();
                        M = CartoonScene$onLoad$1.this.this$0.M();
                        String json = gson.toJson(M);
                        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(defaultCamera())");
                        viewer2.setCamera(json);
                    }
                    viewer3 = CartoonScene$onLoad$1.this.this$0.getViewer();
                    if (viewer3 != null) {
                        N = CartoonScene$onLoad$1.this.this$0.N();
                        IndirectLight indirectLight = N.getIndirectLight();
                        if (indirectLight != null) {
                            String indirectLightPath = bootResourceModel2.getIndirectLightPath();
                            if (indirectLightPath == null) {
                                indirectLightPath = "";
                            }
                            indirectLight.setPath(indirectLightPath);
                        }
                        Unit unit = Unit.INSTANCE;
                        viewer3.setLights(N);
                    }
                    CartoonScene cartoonScene = CartoonScene$onLoad$1.this.this$0;
                    viewer4 = cartoonScene.getViewer();
                    cartoonScene.avatarRenderObjectId = viewer4 != null ? viewer4.createAvatarRenderObject(CartoonScene$onLoad$1.this.$spanContext) : 0L;
                    viewer5 = CartoonScene$onLoad$1.this.this$0.getViewer();
                    if (viewer5 != null) {
                        CartoonScene$onLoad$1 cartoonScene$onLoad$1 = CartoonScene$onLoad$1.this;
                        c cVar2 = cartoonScene$onLoad$1.$spanContext;
                        j16 = cartoonScene$onLoad$1.this$0.avatarRenderObjectId;
                        viewer5.updateRenderObjectAvatar(cVar2, j16, jSONObject32);
                    }
                    viewer6 = CartoonScene$onLoad$1.this.this$0.getViewer();
                    if (viewer6 != null) {
                        firstOrNull = ArraysKt___ArraysKt.firstOrNull(viewer6.loadAnimation(zPlanAction4.getFaceAnimationGltfPath(), null));
                        if (((FilamentAnimation) firstOrNull) != null) {
                            firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(viewer6.loadAnimation(zPlanAction4.getBodyAnimationGltfPath(), null));
                            FilamentAnimation filamentAnimation = (FilamentAnimation) firstOrNull2;
                            if (filamentAnimation != null) {
                                firstOrNull3 = ArraysKt___ArraysKt.firstOrNull(viewer6.loadAnimation(zPlanAction22.getFaceAnimationGltfPath(), null));
                                if (((FilamentAnimation) firstOrNull3) != null) {
                                    firstOrNull4 = ArraysKt___ArraysKt.firstOrNull(viewer6.loadAnimation(zPlanAction22.getBodyAnimationGltfPath(), null));
                                    FilamentAnimation filamentAnimation2 = (FilamentAnimation) firstOrNull4;
                                    if (filamentAnimation2 != null) {
                                        firstOrNull5 = ArraysKt___ArraysKt.firstOrNull(viewer6.loadAnimation(zPlanAction32.getFaceAnimationGltfPath(), null));
                                        if (((FilamentAnimation) firstOrNull5) != null) {
                                            firstOrNull6 = ArraysKt___ArraysKt.firstOrNull(viewer6.loadAnimation(zPlanAction32.getBodyAnimationGltfPath(), null));
                                            FilamentAnimation filamentAnimation3 = (FilamentAnimation) firstOrNull6;
                                            if (filamentAnimation3 != null) {
                                                CartoonScene$onLoad$1 cartoonScene$onLoad$12 = CartoonScene$onLoad$1.this;
                                                c cVar22 = cartoonScene$onLoad$12.$spanContext;
                                                j3 = cartoonScene$onLoad$12.this$0.avatarRenderObjectId;
                                                NormalAnimation.Companion companion = NormalAnimation.INSTANCE;
                                                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(companion.a(filamentAnimation), companion.a(filamentAnimation2), companion.a(filamentAnimation3));
                                                Track track = new Track(true, mutableListOf);
                                                d.a(track);
                                                Unit unit2 = Unit.INSTANCE;
                                                viewer6.bindAnimationTrack(cVar22, j3, track);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                CartoonScene$onLoad$1.this.this$0.o(201024, "boot fail");
                throw new IllegalArgumentException("boot fail");
            }
        });
        return Unit.INSTANCE;
    }
}
