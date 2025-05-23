package com.tencent.qqnt.aio;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/AIODrawableUtils;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/content/Context;", "context", "", "startPercentage", "endPercentage", "c", "", "b", "Lkotlin/Lazy;", "a", "()Z", "mNavigationBarImmersiveSwitch", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIODrawableUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIODrawableUtils f348410a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mNavigationBarImmersiveSwitch;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22210);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f348410a = new AIODrawableUtils();
        lazy = LazyKt__LazyJVMKt.lazy(AIODrawableUtils$mNavigationBarImmersiveSwitch$2.INSTANCE);
        mNavigationBarImmersiveSwitch = lazy;
    }

    AIODrawableUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a() {
        return ((Boolean) mNavigationBarImmersiveSwitch.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean b() {
        return f348410a.a();
    }

    @JvmStatic
    @NotNull
    public static final Drawable c(@NotNull Drawable drawable, @NotNull Context context, float startPercentage, float endPercentage) {
        BitmapDrawable bitmapDrawable;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(context, "context");
        if (startPercentage >= endPercentage) {
            return drawable;
        }
        try {
            if (drawable instanceof BitmapDrawable) {
                bitmapDrawable = (BitmapDrawable) drawable;
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                bitmapDrawable = new BitmapDrawable(context.getResources(), createBitmap);
            }
            Bitmap bitmap = bitmapDrawable.getBitmap();
            int width = bitmap.getWidth();
            float height = bitmap.getHeight();
            return new BitmapDrawable(context.getResources(), Bitmap.createBitmap(bitmap, 0, (int) (startPercentage * height), width, (int) ((endPercentage - startPercentage) * height)));
        } catch (Exception e16) {
            QLog.e("AIODrawableUtils", 1, "getPartOfImage " + e16);
            return drawable;
        }
    }
}
