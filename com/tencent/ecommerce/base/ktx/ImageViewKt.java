package com.tencent.ecommerce.base.ktx;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LocaleManager;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a0\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u00a8\u0006\t"}, d2 = {"Landroid/widget/ImageView;", "", "url", "", "width", "height", "fallbackDrawableResId", "", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ImageViewKt {
    public static final void a(final ImageView imageView, final String str, int i3, int i16, int i17) {
        final Drawable drawable = AppCompatResources.getDrawable(imageView.getContext(), i17);
        if (i3 > 0 && i16 > 0) {
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(imageView.getContext(), str, imageView, new IECImageLoader.ImageLoaderOption(i3, i16, 0, null, drawable, drawable, false, false, null, LocaleManager.MOBILE_COUNTRY_CODE_CN_INT, null));
        } else {
            imageView.post(new Runnable() { // from class: com.tencent.ecommerce.base.ktx.ImageViewKt$loadImage$1
                @Override // java.lang.Runnable
                public final void run() {
                    int measuredWidth = imageView.getMeasuredWidth();
                    int measuredHeight = imageView.getMeasuredHeight();
                    Drawable drawable2 = drawable;
                    QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(imageView.getContext(), str, imageView, new IECImageLoader.ImageLoaderOption(measuredWidth, measuredHeight, 0, null, drawable2, drawable2, false, false, null, LocaleManager.MOBILE_COUNTRY_CODE_CN_INT, null));
                }
            });
        }
    }

    public static /* synthetic */ void b(ImageView imageView, String str, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 2) != 0) {
            i3 = 0;
        }
        if ((i18 & 4) != 0) {
            i16 = 0;
        }
        if ((i18 & 8) != 0) {
            i17 = R.drawable.evj;
        }
        a(imageView, str, i3, i16, i17);
    }
}
