package com.tencent.filament.zplan.render.impl;

import cl0.GpuOptimizeOptions;
import com.tencent.filament.zplan.business.api.IBusinessScene;
import com.tencent.filament.zplan.business.api.SceneType;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.util.log.FLog;
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
@DebugMetadata(c = "com.tencent.filament.zplan.render.impl.FilamentNativeApp$updateEngineLevelConfig$2", f = "FilamentNativeApp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FilamentNativeApp$updateEngineLevelConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FilamentNativeApp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentNativeApp$updateEngineLevelConfig$2(FilamentNativeApp filamentNativeApp, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filamentNativeApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentNativeApp$updateEngineLevelConfig$2(this.this$0, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentNativeApp$updateEngineLevelConfig$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i3;
        SceneType sceneType;
        int i16;
        final GpuOptimizeOptions y06;
        int i17;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            i3 = this.this$0.deviceLevel;
            if (i3 < 0) {
                return Unit.INSTANCE;
            }
            IBusinessScene scene = this.this$0.getScene();
            if (scene == null || (sceneType = scene.getSceneType()) == null) {
                sceneType = SceneType.NONE;
            }
            FilamentNativeApp filamentNativeApp = this.this$0;
            i16 = filamentNativeApp.deviceLevel;
            y06 = filamentNativeApp.y0(sceneType, i16);
            FLog fLog = FLog.INSTANCE;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("scene and level : sceneType is ");
            sb5.append(sceneType);
            sb5.append(" ,level is ");
            i17 = this.this$0.deviceLevel;
            sb5.append(i17);
            fLog.i("FilamentNativeApp", sb5.toString());
            FilamentNativeApp.H0(this.this$0, "setOptimizeOptions", false, new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$updateEngineLevelConfig$2.1
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
                    FilamentViewerV2 filamentViewerV2;
                    filamentViewerV2 = FilamentNativeApp$updateEngineLevelConfig$2.this.this$0.viewer;
                    if (filamentViewerV2 != null) {
                        filamentViewerV2.setOptimizeOptions(y06.getEnableShadow(), y06.getEnableFxaa(), y06.getEnableBloom(), y06.getRenderTargetScale());
                    }
                }
            }, 2, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
