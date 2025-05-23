package com.tencent.mobileqq.wink.h5native;

import java.util.List;
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

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadImagesJob$1", f = "WinkAiPaintNativeExportManager.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadImagesJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ String $cacheDir;
    final /* synthetic */ RenderReq $renderReq;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadImagesJob$1(RenderReq renderReq, String str, Continuation<? super WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadImagesJob$1> continuation) {
        super(2, continuation);
        this.$renderReq = renderReq;
        this.$cacheDir = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadImagesJob$1(this.$renderReq, this.$cacheDir, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<String>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List<Image> list;
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
            PlaceHolder placeHolders = this.$renderReq.getPlaceHolders();
            if (placeHolders != null) {
                list = placeHolders.getImages();
            } else {
                list = null;
            }
            String str = this.$cacheDir;
            this.label = 1;
            obj = winkAiPaintNativeExportManager.O(list, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<String>> continuation) {
        return ((WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadImagesJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
