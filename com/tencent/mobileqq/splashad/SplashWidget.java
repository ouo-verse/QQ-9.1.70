package com.tencent.mobileqq.splashad;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bR\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/splashad/SplashWidget;", "Landroid/widget/FrameLayout;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "c", "e", "d", "Landroid/widget/ImageView;", "b", "a", "Landroid/graphics/drawable/Drawable;", "drawable", "", "useNewStyle", "setSplashDrawable", "setLogoDrawable", "Landroid/widget/ImageView;", "mSplashImage", "mLogoImage", "<init>", "(Landroid/app/Activity;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SplashWidget extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mSplashImage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mLogoImage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashWidget(@NotNull Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            c(activity);
        }
    }

    private final void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 26) {
            boolean enableNotch = LiuHaiUtils.enableNotch(activity);
            if (QLog.isColorLevel()) {
                QLog.d("SplashHelper", 2, "enableNotch=", Boolean.valueOf(enableNotch));
            }
        }
        setId(R.id.j0l);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (QQTheme.isNowThemeIsNight()) {
            setBackgroundColor(-16777216);
        } else {
            setBackgroundColor(-1);
        }
        ImageView imageView = new ImageView(activity);
        this.mSplashImage = imageView;
        imageView.setId(R.id.j0m);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        View view = this.mSplashImage;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSplashImage");
            view = null;
        }
        addView(view, layoutParams);
        ImageView imageView2 = new ImageView(activity);
        this.mLogoImage = imageView2;
        imageView2.setId(R.id.j0p);
        ImageView imageView3 = this.mLogoImage;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLogoImage");
            imageView3 = null;
        }
        imageView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageView imageView4 = this.mLogoImage;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLogoImage");
            imageView4 = null;
        }
        imageView4.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 80;
        View view3 = this.mLogoImage;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLogoImage");
        } else {
            view2 = view3;
        }
        addView(view2, layoutParams2);
        if (activity instanceof IphoneTitleBarActivity) {
            ((IphoneTitleBarActivity) activity).setContentViewNoTitle(this);
        } else {
            activity.setContentView(this);
        }
        if (ImmersiveUtils.isVivoAndLOLLIPOP() && com.tencent.mobileqq.theme.a.a()) {
            com.tencent.mobileqq.theme.a.b(activity.getWindow());
        }
    }

    private final void d() {
        try {
            ImageView imageView = this.mSplashImage;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSplashImage");
                imageView = null;
            }
            Drawable drawable = imageView.getDrawable();
            Intrinsics.checkNotNullExpressionValue(drawable, "mSplashImage.drawable");
            int i3 = getResources().getDisplayMetrics().widthPixels;
            com.tencent.mobileqq.splash.f fVar = com.tencent.mobileqq.splash.f.f288712a;
            int e16 = (int) (fVar.e() * i3);
            int intrinsicHeight = (drawable.getIntrinsicHeight() * e16) / drawable.getIntrinsicWidth();
            ImageView imageView3 = this.mSplashImage;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSplashImage");
            } else {
                imageView2 = imageView3;
            }
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.width = e16;
            marginLayoutParams.height = intrinsicHeight;
            int c16 = (int) (fVar.c() * intrinsicHeight);
            marginLayoutParams.bottomMargin = c16;
            QLog.d("SplashHelper", 1, "smW:" + e16 + ", smH:" + intrinsicHeight + ", bMargin:" + c16 + ", oriW:" + drawable.getIntrinsicWidth());
        } catch (Throwable th5) {
            QLog.e("SplashHelper", 1, "updateNewSplashLayout error!", th5);
        }
    }

    private final void e() {
        try {
            ImageView imageView = this.mSplashImage;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSplashImage");
                imageView = null;
            }
            Drawable drawable = imageView.getDrawable();
            Intrinsics.checkNotNullExpressionValue(drawable, "mSplashImage.drawable");
            if ((drawable instanceof BitmapDrawable) || (drawable instanceof SkinnableBitmapDrawable) || (drawable instanceof AnimationDrawable)) {
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
            QLog.e("SplashHelper", 1, "updateSplashViewLayout error!", th5);
        }
    }

    @NotNull
    public final ImageView a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ImageView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ImageView imageView = this.mLogoImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLogoImage");
            return null;
        }
        return imageView;
    }

    @NotNull
    public final ImageView b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ImageView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ImageView imageView = this.mSplashImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSplashImage");
            return null;
        }
        return imageView;
    }

    public final void setLogoDrawable(@NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
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
            int a16 = (int) (com.tencent.mobileqq.splash.f.f288712a.a() * i3);
            int intrinsicWidth = (int) (a16 / (drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()));
            QLog.d("SplashHelper", 1, "slW:" + a16 + ", slH:" + intrinsicWidth + ", oriW:" + drawable.getIntrinsicWidth());
            ImageView imageView3 = this.mLogoImage;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLogoImage");
                imageView3 = null;
            }
            ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.width = a16;
            marginLayoutParams.height = intrinsicWidth;
            int i16 = (i3 - a16) / 2;
            marginLayoutParams.leftMargin = i16;
            if (i16 > 0) {
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
            QLog.e("SplashHelper", 1, "splash_logo", th5);
        }
    }

    public final void setSplashDrawable(@NotNull Drawable drawable, boolean useNewStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, drawable, Boolean.valueOf(useNewStyle));
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        ImageView imageView = this.mSplashImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSplashImage");
            imageView = null;
        }
        imageView.setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            try {
                ((AnimationDrawable) drawable).setOneShot(false);
                ((AnimationDrawable) drawable).start();
            } catch (Throwable th5) {
                QLog.e("SplashHelper", 1, "", th5);
            }
        }
        if (useNewStyle) {
            d();
        } else {
            e();
        }
    }
}
