package com.tencent.filament.light.camera;

import com.tencent.filament.zplanservice.download.FetchBootResourcesOptions;
import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.light.camera.ZPlanFilamentRequestManager$fetchParticle$2$particleCachePathDeferred$1", f = "ZPlanFilamentRequestManager.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class ZPlanFilamentRequestManager$fetchParticle$2$particleCachePathDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAvatarInterfaceResult>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanFilamentRequestManager$fetchParticle$2$particleCachePathDeferred$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new ZPlanFilamentRequestManager$fetchParticle$2$particleCachePathDeferred$1(completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAvatarInterfaceResult> continuation) {
        return ((ZPlanFilamentRequestManager$fetchParticle$2$particleCachePathDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ZPlanAvatarService zPlanAvatarService;
        Object A;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                    A = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
                FetchBootResourcesOptions fetchBootResourcesOptions = new FetchBootResourcesOptions(false, false, filamentFeatureUtil.K(), filamentFeatureUtil.j(), filamentFeatureUtil.d(), true, false, false, 128, null);
                ZPlanFilamentRequestManager zPlanFilamentRequestManager = ZPlanFilamentRequestManager.INSTANCE;
                zPlanAvatarService = ZPlanFilamentRequestManager.avatarService;
                if (zPlanAvatarService == null) {
                    return null;
                }
                this.label = 1;
                A = zPlanAvatarService.A(fetchBootResourcesOptions, this);
                if (A == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return (ZPlanAvatarInterfaceResult) A;
        } catch (Exception unused) {
            return null;
        }
    }
}
