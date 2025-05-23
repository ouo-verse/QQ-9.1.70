package com.tencent.richframework.gallery.part;

import android.view.View;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.delegate.inner.IGalleryPageProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 1})
/* loaded from: classes25.dex */
final class ScaleAndAlphaTransformerPart$onInitView$1 implements Runnable {
    final /* synthetic */ View $rootView;

    @Override // java.lang.Runnable
    public final void run() {
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() { // from class: com.tencent.richframework.gallery.part.ScaleAndAlphaTransformerPart$onInitView$1.1
            @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
            public final void transformPage(@NotNull View page, float f16) {
                Intrinsics.checkNotNullParameter(page, "page");
                if (f16 < 0.0f) {
                    page.setTranslationX(0.0f);
                    page.setTranslationZ(0.0f);
                } else {
                    float f17 = -f16;
                    page.setTranslationX(page.getWidth() * f17);
                    page.setTranslationZ(f17);
                }
            }
        });
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() { // from class: com.tencent.richframework.gallery.part.ScaleAndAlphaTransformerPart$ScaleAndAlphaTransformer
            @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
            public void transformPage(@NotNull View page, float position) {
                float f16;
                Intrinsics.checkNotNullParameter(page, "page");
                if (position < -1) {
                    position = -1.0f;
                }
                float f17 = 1;
                if (position > f17) {
                    position = 1.0f;
                }
                if (position < 0.0f) {
                    page.setScaleX(1.0f);
                    page.setScaleY(1.0f);
                    page.setAlpha(1.0f);
                    return;
                }
                float f18 = 0;
                if (position < f18) {
                    f16 = position + f17;
                } else {
                    f16 = f17 - position;
                }
                float f19 = ((f17 - 0.618f) * f16) + 0.618f;
                page.setScaleX(f19);
                page.setScaleY(f19);
                page.setAlpha(f18 + (f16 * 1));
            }
        });
        IGalleryPageProvider galleryPageProvider = RFWLayerIOCUtil.getGalleryPageProvider(this.$rootView);
        if (galleryPageProvider != null) {
            galleryPageProvider.getGalleryViewPager().getViewPager2().setPageTransformer(compositePageTransformer);
        }
    }
}
