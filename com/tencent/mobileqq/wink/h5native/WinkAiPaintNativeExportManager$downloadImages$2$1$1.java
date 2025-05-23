package com.tencent.mobileqq.wink.h5native;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager$downloadImages$2$1$1", f = "WinkAiPaintNativeExportManager.kt", i = {}, l = {PlayerResources.ViewId.LOADING}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkAiPaintNativeExportManager$downloadImages$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Image $image;
    final /* synthetic */ String $savePath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiPaintNativeExportManager$downloadImages$2$1$1(Image image, String str, Continuation<? super WinkAiPaintNativeExportManager$downloadImages$2$1$1> continuation) {
        super(2, continuation);
        this.$image = image;
        this.$savePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAiPaintNativeExportManager$downloadImages$2$1$1(this.$image, this.$savePath, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object N;
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
            WinkAiPaintNativeExportManager winkAiPaintNativeExportManager = WinkAiPaintNativeExportManager.f322863a;
            String content = this.$image.getContent();
            String str = this.$savePath;
            this.label = 1;
            N = winkAiPaintNativeExportManager.N(content, str, this);
            if (N == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAiPaintNativeExportManager$downloadImages$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
