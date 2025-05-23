package com.tencent.mobileqq.wink.h5native;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager$preloadAiPaintRes$1", f = "WinkAiPaintNativeExportManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkAiPaintNativeExportManager$preloadAiPaintRes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkAiPaintNativeExportManager$preloadAiPaintRes$1(Continuation<? super WinkAiPaintNativeExportManager$preloadAiPaintRes$1> continuation) {
        super(2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AEResInfo aEResInfo, boolean z16, int i3) {
        w53.b.f("WinkAiPaintNativeExportManager", "preloadAiPaintRes loadLightAssets: " + z16);
        if (z16) {
            WinkExportUtils.R();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAiPaintNativeExportManager$preloadAiPaintRes$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady(new IAEMultiDownloadCallBack() { // from class: com.tencent.mobileqq.wink.h5native.b
                @Override // com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack
                public final void onAEMultiDownloadFinish(AEResInfo aEResInfo, boolean z16, int i3) {
                    WinkAiPaintNativeExportManager$preloadAiPaintRes$1.b(aEResInfo, z16, i3);
                }
            })) {
                WinkExportUtils.R();
                w53.b.f("WinkAiPaintNativeExportManager", "preloadAiPaintRes loadLightAssets: true");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAiPaintNativeExportManager$preloadAiPaintRes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
