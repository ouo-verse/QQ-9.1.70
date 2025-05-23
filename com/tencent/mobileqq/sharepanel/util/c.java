package com.tencent.mobileqq.sharepanel.util;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/util/c;", "", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "a", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f287601a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42872);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f287601a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Drawable a(@NotNull Context context) {
        Drawable mutate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        int dpToPx = ViewUtils.dpToPx(30.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_overlay_surface_bg));
        gradientDrawable.setSize(dpToPx, dpToPx);
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable});
        Drawable drawable = context.getDrawable(R.drawable.qui_close_btn_large);
        if (drawable != null) {
            if (drawable instanceof SkinnableBitmapDrawable) {
                mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
            } else {
                mutate = drawable.mutate();
            }
            if (mutate != null) {
                mutate.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(context, R.color.qui_common_overlay_surface_fg), PorterDuff.Mode.SRC_IN));
                layerDrawable.addLayer(mutate);
                layerDrawable.setLayerGravity(1, 17);
            }
        }
        return layerDrawable;
    }
}
