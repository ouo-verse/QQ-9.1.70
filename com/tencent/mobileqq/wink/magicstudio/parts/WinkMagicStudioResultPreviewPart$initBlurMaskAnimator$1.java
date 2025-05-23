package com.tencent.mobileqq.wink.magicstudio.parts;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.eh;
import com.tencent.widget.immersive.ImmersiveUtils;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultPreviewPart$initBlurMaskAnimator$1", f = "WinkMagicStudioResultPreviewPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkMagicStudioResultPreviewPart$initBlurMaskAnimator$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WinkMagicStudioResultPreviewPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMagicStudioResultPreviewPart$initBlurMaskAnimator$1(WinkMagicStudioResultPreviewPart winkMagicStudioResultPreviewPart, Continuation<? super WinkMagicStudioResultPreviewPart$initBlurMaskAnimator$1> continuation) {
        super(2, continuation);
        this.this$0 = winkMagicStudioResultPreviewPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkMagicStudioResultPreviewPart winkMagicStudioResultPreviewPart, Bitmap bitmap) {
        ImageView imageView;
        winkMagicStudioResultPreviewPart.isBlurImageGenerated = true;
        imageView = winkMagicStudioResultPreviewPart.loadingBlurView;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        winkMagicStudioResultPreviewPart.ha();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkMagicStudioResultPreviewPart$initBlurMaskAnimator$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        LocalMediaInfo localMediaInfo;
        String str;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                localMediaInfo = this.this$0.originImage;
                final Bitmap bitmap = null;
                if (localMediaInfo != null) {
                    str = localMediaInfo.path;
                } else {
                    str = null;
                }
                Bitmap j3 = com.tencent.mobileqq.wink.utils.f.j(str, 720, 720, false);
                if (j3 != null) {
                    bitmap = j3.copy(Bitmap.Config.ARGB_8888, true);
                }
                eh.a(bitmap, ImmersiveUtils.dpToPx(80.0f));
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final WinkMagicStudioResultPreviewPart winkMagicStudioResultPreviewPart = this.this$0;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkMagicStudioResultPreviewPart$initBlurMaskAnimator$1.b(WinkMagicStudioResultPreviewPart.this, bitmap);
                    }
                });
            } catch (Throwable th5) {
                w53.b.c("WinkMagicStudioResultButtonPart", "initBlurMaskAnimator failed " + th5);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkMagicStudioResultPreviewPart$initBlurMaskAnimator$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
