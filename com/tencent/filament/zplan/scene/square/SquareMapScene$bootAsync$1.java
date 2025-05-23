package com.tencent.filament.zplan.scene.square;

import com.google.gson.Gson;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.square.SquareMapScene$bootAsync$1", f = "SquareMapScene.kt", i = {0, 0, 1, 1, 1}, l = {320, 324}, m = "invokeSuspend", n = {"bootSpan", "bootStartTs", "bootSpan", "bootResource", "bootStartTs"}, s = {"L$0", "J$0", "L$0", "L$1", "J$0"})
/* loaded from: classes6.dex */
public final class SquareMapScene$bootAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Size $mapSize;
    final /* synthetic */ com.tencent.zplan.zplantracing.c $spanContext;
    final /* synthetic */ Size $viewportSize;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SquareMapScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareMapScene$bootAsync$1(SquareMapScene squareMapScene, Size size, Size size2, com.tencent.zplan.zplantracing.c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = squareMapScene;
        this.$mapSize = size;
        this.$viewportSize = size2;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new SquareMapScene$bootAsync$1(this.this$0, this.$mapSize, this.$viewportSize, this.$spanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SquareMapScene$bootAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ea  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AtomicBoolean atomicBoolean;
        SquareMapViewport squareMapViewport;
        FilamentUrlTemplate filamentUrlTemplate;
        long j3;
        com.tencent.zplan.zplantracing.b bVar;
        final BootResourceModel bootResourceModel;
        final com.tencent.zplan.zplantracing.b bVar2;
        final long j16;
        final n nVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    long j17 = this.J$0;
                    BootResourceModel bootResourceModel2 = (BootResourceModel) this.L$1;
                    com.tencent.zplan.zplantracing.b bVar3 = (com.tencent.zplan.zplantracing.b) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    j16 = j17;
                    bootResourceModel = bootResourceModel2;
                    bVar2 = bVar3;
                    nVar = this.this$0.squareMapSceneHelper;
                    if (nVar == null) {
                        this.this$0.k().d("boot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapScene$bootAsync$1.1
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
                                boolean z16;
                                AtomicBoolean atomicBoolean2;
                                FilamentViewerV2305 viewer2;
                                String str;
                                viewer = SquareMapScene$bootAsync$1.this.this$0.getViewer();
                                if (viewer != null) {
                                    BootResourceModel bootResourceModel3 = bootResourceModel;
                                    FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
                                    z16 = viewer.boot(bootResourceModel3, "", false, false, false, filamentFeatureUtil.K(), filamentFeatureUtil.j());
                                } else {
                                    z16 = false;
                                }
                                if (!z16) {
                                    com.tencent.zplan.zplantracing.b bVar4 = bVar2;
                                    if (bVar4 != null) {
                                        bVar4.a("boot fail");
                                    }
                                    SquareMapScene$bootAsync$1.this.this$0.o(201024, "boot fail");
                                    return;
                                }
                                com.tencent.zplan.zplantracing.b bVar5 = bVar2;
                                if (bVar5 != null) {
                                    bVar5.b();
                                }
                                atomicBoolean2 = SquareMapScene$bootAsync$1.this.this$0.booted;
                                atomicBoolean2.set(true);
                                SquareMapScene$bootAsync$1.this.this$0.statistics.setBootTimeCost(System.currentTimeMillis() - j16);
                                viewer2 = SquareMapScene$bootAsync$1.this.this$0.getViewer();
                                if (viewer2 != null) {
                                    String json = new Gson().toJson(nVar.e());
                                    Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(camera)");
                                    viewer2.setCamera(json);
                                    LightsParams f16 = nVar.f();
                                    b.b(f16, SquareMapScene$bootAsync$1.this.this$0.j());
                                    IndirectLight indirectLight = f16.getIndirectLight();
                                    if (indirectLight != null) {
                                        str = SquareMapScene$bootAsync$1.this.this$0.indirectLightPath;
                                        indirectLight.setPath(str);
                                    }
                                    viewer2.setLights(f16);
                                }
                            }
                        });
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = this.J$0;
            bVar = (com.tencent.zplan.zplantracing.b) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            atomicBoolean = this.this$0.booted;
            if (atomicBoolean.get()) {
                return Unit.INSTANCE;
            }
            FLog.INSTANCE.d("SquareMapScene", "bootAsync: start mapSize=" + this.$mapSize + ", viewportSize=" + this.$viewportSize);
            SquareMapScene squareMapScene = this.this$0;
            Size size = this.$mapSize;
            Size size2 = this.$viewportSize;
            squareMapViewport = this.this$0.viewport;
            squareMapScene.squareMapSceneHelper = new n(size, size2, squareMapViewport);
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("boot", this.$spanContext);
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            com.tencent.zplan.zplantracing.c cVar = this.$spanContext;
            filamentUrlTemplate = this.this$0.urlTemplate;
            this.L$0 = startSpan;
            this.J$0 = currentTimeMillis;
            this.label = 1;
            Object F = zPlanAvatarResourceHelper.F(cVar, filamentUrlTemplate, this);
            if (F == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = currentTimeMillis;
            bVar = startSpan;
            obj = F;
        }
        BootResourceModel bootResourceModel3 = (BootResourceModel) obj;
        this.this$0.statistics.setBootDownloadedFromNet(bootResourceModel3.getDownloadFromNet());
        SquareMapScene squareMapScene2 = this.this$0;
        String indirectLightPath = bootResourceModel3.getIndirectLightPath();
        if (indirectLightPath == null) {
            indirectLightPath = "";
        }
        squareMapScene2.indirectLightPath = indirectLightPath;
        SquareMapResourceHelper squareMapResourceHelper = SquareMapResourceHelper.f106088j;
        com.tencent.zplan.zplantracing.c cVar2 = this.$spanContext;
        String shaderDir = bootResourceModel3.getShaderDir();
        this.L$0 = bVar;
        this.L$1 = bootResourceModel3;
        this.J$0 = j3;
        this.label = 2;
        if (squareMapResourceHelper.f(cVar2, shaderDir, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        bootResourceModel = bootResourceModel3;
        bVar2 = bVar;
        j16 = j3;
        nVar = this.this$0.squareMapSceneHelper;
        if (nVar == null) {
        }
    }
}
