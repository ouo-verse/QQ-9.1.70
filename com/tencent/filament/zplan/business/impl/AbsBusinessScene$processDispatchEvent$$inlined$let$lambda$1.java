package com.tencent.filament.zplan.business.impl;

import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.filament.zplanservice.download.ZPlanAvatarServiceException;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/filament/zplan/business/impl/AbsBusinessScene$processDispatchEvent$2$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.business.impl.AbsBusinessScene$processDispatchEvent$2$1", f = "AbsBusinessScene.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class AbsBusinessScene$processDispatchEvent$$inlined$let$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LightsParams $lightConfig$inlined;
    int label;
    final /* synthetic */ AbsBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBusinessScene$processDispatchEvent$$inlined$let$lambda$1(Continuation continuation, AbsBusinessScene absBusinessScene, LightsParams lightsParams) {
        super(2, continuation);
        this.this$0 = absBusinessScene;
        this.$lightConfig$inlined = lightsParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new AbsBusinessScene$processDispatchEvent$$inlined$let$lambda$1(completion, this.this$0, this.$lightConfig$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AbsBusinessScene$processDispatchEvent$$inlined$let$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IndirectLight indirectLight;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult = null;
        try {
        } catch (ZPlanAvatarServiceException e16) {
            FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchIndirectLight fail. " + e16);
        }
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ZPlanAvatarService service = this.this$0.getService();
            if (service != null) {
                this.label = 1;
                obj = service.C(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (zPlanAvatarInterfaceResult != null && (indirectLight = this.$lightConfig$inlined.getIndirectLight()) != null) {
                indirectLight.setPath(zPlanAvatarInterfaceResult.getResult());
            }
            this.this$0.doTask("setLightsAfterThemeChanged", new Function0<Unit>() { // from class: com.tencent.filament.zplan.business.impl.AbsBusinessScene$processDispatchEvent$$inlined$let$lambda$1.1
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
                    FilamentViewerV2 viewerV2 = AbsBusinessScene$processDispatchEvent$$inlined$let$lambda$1.this.this$0.getViewerV2();
                    if (viewerV2 != null) {
                        viewerV2.setLights(AbsBusinessScene$processDispatchEvent$$inlined$let$lambda$1.this.$lightConfig$inlined);
                    }
                }
            });
            return Unit.INSTANCE;
        }
        zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
        if (zPlanAvatarInterfaceResult != null) {
            indirectLight.setPath(zPlanAvatarInterfaceResult.getResult());
        }
        this.this$0.doTask("setLightsAfterThemeChanged", new Function0<Unit>() { // from class: com.tencent.filament.zplan.business.impl.AbsBusinessScene$processDispatchEvent$$inlined$let$lambda$1.1
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
                FilamentViewerV2 viewerV2 = AbsBusinessScene$processDispatchEvent$$inlined$let$lambda$1.this.this$0.getViewerV2();
                if (viewerV2 != null) {
                    viewerV2.setLights(AbsBusinessScene$processDispatchEvent$$inlined$let$lambda$1.this.$lightConfig$inlined);
                }
            }
        });
        return Unit.INSTANCE;
    }
}
