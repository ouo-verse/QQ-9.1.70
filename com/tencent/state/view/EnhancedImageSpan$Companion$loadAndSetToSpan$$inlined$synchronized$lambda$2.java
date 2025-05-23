package com.tencent.state.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.utils.DiskCacheUtils;
import com.tencent.state.service.ImageService;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.view.EnhancedImageSpan;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000b\u00b8\u0006\u0000"}, d2 = {"com/tencent/state/view/EnhancedImageSpan$Companion$loadAndSetToSpan$1$1", "Lcom/nostra13/universalimageloader/core/listener/SimpleImageLoadingListener;", "onLoadingCancelled", "", "imageUri", "", "view", "Landroid/view/View;", "onLoadingComplete", "loadedImage", "Landroid/graphics/Bitmap;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class EnhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$2 extends SimpleImageLoadingListener {
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ int $endIdx;
    final /* synthetic */ int $imgH$inlined;
    final /* synthetic */ String $imgHolder$inlined;
    final /* synthetic */ String $imgUrl$inlined;
    final /* synthetic */ int $imgW$inlined;
    final /* synthetic */ int $marginLeft$inlined;
    final /* synthetic */ int $marginRight$inlined;
    final /* synthetic */ Function0 $onFinish$inlined;
    final /* synthetic */ SpannableStringBuilder $ssb$inlined;
    final /* synthetic */ int $startIdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$2(int i3, int i16, SpannableStringBuilder spannableStringBuilder, String str, int i17, int i18, String str2, Context context, int i19, int i26, Function0 function0) {
        this.$startIdx = i3;
        this.$endIdx = i16;
        this.$ssb$inlined = spannableStringBuilder;
        this.$imgHolder$inlined = str;
        this.$imgW$inlined = i17;
        this.$imgH$inlined = i18;
        this.$imgUrl$inlined = str2;
        this.$context$inlined = context;
        this.$marginLeft$inlined = i19;
        this.$marginRight$inlined = i26;
        this.$onFinish$inlined = function0;
    }

    @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
    public void onLoadingCancelled(final String imageUri, View view) {
        if (imageUri == null) {
            return;
        }
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.view.EnhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v4, types: [T, android.graphics.Bitmap] */
            /* JADX WARN: Type inference failed for: r1v9, types: [T, android.graphics.Bitmap] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MemoryCache memoryCache;
                ImageLoader imageLoader = ImageLoader.getInstance();
                Intrinsics.checkNotNullExpressionValue(imageLoader, "ImageLoader.getInstance()");
                if (imageLoader.isInited()) {
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ImageService.Companion companion = ImageService.INSTANCE;
                    ImageLoader loader = companion.getLoader();
                    T t16 = (loader == null || (memoryCache = loader.getMemoryCache()) == null) ? 0 : memoryCache.get(imageUri);
                    objectRef.element = t16;
                    if (t16 == 0) {
                        String str = imageUri;
                        ImageLoader loader2 = companion.getLoader();
                        File findInCache = DiskCacheUtils.findInCache(str, loader2 != null ? loader2.getDiskCache() : null);
                        if (findInCache != null) {
                            objectRef.element = BitmapFactory.decodeFile(findInCache.getAbsolutePath());
                        }
                    }
                    T t17 = objectRef.element;
                    if (((Bitmap) t17) == null) {
                        return;
                    }
                    EnhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$2 enhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$2 = EnhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$2.this;
                    objectRef.element = EnhancedImageSpanKt.imageScale((Bitmap) t17, enhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$2.$imgW$inlined, enhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$2.$imgH$inlined);
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.view.EnhancedImageSpan$Companion$loadAndSetToSpan$.inlined.synchronized.lambda.2.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            EnhancedImageSpan.Companion companion2 = EnhancedImageSpan.INSTANCE;
                            EnhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$2 enhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$22 = EnhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$2.this;
                            companion2.setImageSpan(enhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$22.$context$inlined, (Bitmap) objectRef.element, enhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$22.$marginLeft$inlined, enhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$22.$marginRight$inlined, enhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$22.$startIdx, enhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$22.$endIdx, enhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$22.$ssb$inlined);
                            EnhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$2.this.$onFinish$inlined.invoke();
                        }
                    });
                }
            }
        });
    }

    @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
        if (loadedImage == null) {
            return;
        }
        EnhancedImageSpan.INSTANCE.setImageSpan(this.$context$inlined, loadedImage, this.$marginLeft$inlined, this.$marginRight$inlined, this.$startIdx, this.$endIdx, this.$ssb$inlined);
        this.$onFinish$inlined.invoke();
    }
}
