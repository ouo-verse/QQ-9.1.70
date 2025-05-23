package com.tencent.mobileqq.wink.magicstudio.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import java.io.File;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.view.ImageCreateImagePart$onSelectedPic$1", f = "ImageCreateImagePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class ImageCreateImagePart$onSelectedPic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ ImageCreateImagePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCreateImagePart$onSelectedPic$1(String str, ImageCreateImagePart imageCreateImagePart, Continuation<? super ImageCreateImagePart$onSelectedPic$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.this$0 = imageCreateImagePart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ImageCreateImagePart imageCreateImagePart, Bitmap bitmap, Bitmap bitmap2) {
        ImageView imageView;
        ImageView imageView2;
        imageView = imageCreateImagePart.imgbg;
        ImageView imageView3 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgbg");
            imageView = null;
        }
        imageView.setImageBitmap(bitmap);
        imageView2 = imageCreateImagePart.com.tencent.qqmini.miniapp.widget.InnerWebView.API_UPLOAD_IMAGE java.lang.String;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(InnerWebView.API_UPLOAD_IMAGE);
        } else {
            imageView3 = imageView2;
        }
        imageView3.setImageBitmap(bitmap2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImageCreateImagePart$onSelectedPic$1(this.$path, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        final Bitmap bitmap;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!new File(this.$path).exists()) {
                w53.b.a("ImageCreationFragment", "onSelectedPic: file not exists");
                return Unit.INSTANCE;
            }
            try {
                Bitmap e16 = com.tencent.mobileqq.wink.utils.f.e(this.$path, new BitmapFactory.Options());
                if (e16 != null) {
                    bitmap = e16.copy(Bitmap.Config.RGB_565, false);
                } else {
                    bitmap = null;
                }
                final Bitmap process = new StackBlurManager(e16).process(100);
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final ImageCreateImagePart imageCreateImagePart = this.this$0;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.view.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageCreateImagePart$onSelectedPic$1.b(ImageCreateImagePart.this, process, bitmap);
                    }
                });
            } catch (Exception e17) {
                w53.b.c("ImageCreationFragment", "create background drawable failed: " + e17.getMessage());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ImageCreateImagePart$onSelectedPic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
