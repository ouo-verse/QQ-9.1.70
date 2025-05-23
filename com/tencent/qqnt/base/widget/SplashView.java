package com.tencent.qqnt.base.widget;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/base/widget/SplashView;", "Landroid/widget/FrameLayout;", "", "a", "Landroid/graphics/drawable/Drawable;", "drawable", "setSplashDrawable", "setLogoDrawable", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mSplashImage", "e", "mLogoImage", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class SplashView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mSplashImage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mLogoImage;

    private final void a() {
        try {
            ImageView imageView = this.mSplashImage;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSplashImage");
                imageView = null;
            }
            Drawable drawable = imageView.getDrawable();
            Intrinsics.checkNotNullExpressionValue(drawable, "mSplashImage.drawable");
            if ((drawable instanceof BitmapDrawable) || (drawable instanceof AnimationDrawable)) {
                int i3 = getResources().getDisplayMetrics().widthPixels;
                int i16 = getResources().getDisplayMetrics().heightPixels;
                int intrinsicHeight = (drawable.getIntrinsicHeight() * i3) / drawable.getIntrinsicWidth();
                ImageView imageView3 = this.mSplashImage;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSplashImage");
                    imageView3 = null;
                }
                ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
                Intrinsics.checkNotNullExpressionValue(layoutParams, "mSplashImage.getLayoutParams()");
                layoutParams.width = i3;
                layoutParams.height = intrinsicHeight;
                ImageView imageView4 = this.mSplashImage;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSplashImage");
                    imageView4 = null;
                }
                imageView4.setLayoutParams(layoutParams);
                if (intrinsicHeight <= i16) {
                    ImageView imageView5 = this.mSplashImage;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSplashImage");
                    } else {
                        imageView2 = imageView5;
                    }
                    imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    return;
                }
                if (intrinsicHeight > i16) {
                    ImageView imageView6 = this.mSplashImage;
                    if (imageView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSplashImage");
                    } else {
                        imageView2 = imageView6;
                    }
                    imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public final void setLogoDrawable(@NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        ImageView imageView = null;
        try {
            ImageView imageView2 = this.mLogoImage;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLogoImage");
                imageView2 = null;
            }
            imageView2.setImageDrawable(drawable);
            int i3 = getResources().getDisplayMetrics().widthPixels;
            float intrinsicWidth = drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
            int i16 = (int) (i3 * 0.33333334f);
            float f16 = i16;
            int i17 = (int) (f16 / intrinsicWidth);
            ImageView imageView3 = this.mLogoImage;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLogoImage");
                imageView3 = null;
            }
            ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.width = i16;
            marginLayoutParams.height = i17;
            int i18 = (i3 - i16) / 2;
            marginLayoutParams.leftMargin = i18;
            marginLayoutParams.bottomMargin = (int) (((f16 * 2.0f) * 28) / 256);
            if (i18 > 0) {
                ImageView imageView4 = this.mLogoImage;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLogoImage");
                    imageView4 = null;
                }
                imageView4.setLayoutParams(marginLayoutParams);
                ImageView imageView5 = this.mLogoImage;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLogoImage");
                    imageView5 = null;
                }
                imageView5.setVisibility(0);
                return;
            }
            ImageView imageView6 = this.mLogoImage;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLogoImage");
                imageView6 = null;
            }
            imageView6.setVisibility(8);
        } catch (Throwable th5) {
            ImageView imageView7 = this.mLogoImage;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLogoImage");
            } else {
                imageView = imageView7;
            }
            imageView.setVisibility(8);
            QLog.e("SetSplash", 1, "splash_logo", th5);
        }
    }

    public final void setSplashDrawable(@NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        ImageView imageView = this.mSplashImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSplashImage");
            imageView = null;
        }
        imageView.setImageDrawable(drawable);
        a();
    }
}
