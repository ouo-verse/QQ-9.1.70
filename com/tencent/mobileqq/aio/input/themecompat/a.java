package com.tencent.mobileqq.aio.input.themecompat;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/input/themecompat/a;", "", "Landroid/content/Context;", "context", "", "isImmersive", "Landroid/content/res/ColorStateList;", "d", "", "c", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f189924a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57063);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f189924a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ int b(a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return aVar.a(z16);
    }

    public static /* synthetic */ ColorStateList e(a aVar, Context context, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return aVar.d(context, z16);
    }

    public final int a(boolean isImmersive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, isImmersive)).intValue();
        }
        if (isImmersive) {
            return R.drawable.qui_aio_input_immersive_bg;
        }
        if (QQTheme.isVasTheme()) {
            return R.drawable.skin_aio_input_bg;
        }
        return R.drawable.qui_aio_input_bg;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (QQTheme.isVasTheme()) {
            return R.drawable.skin_aio_input_bar_bg_theme_version2;
        }
        return R.drawable.qui_common_bg_nav_bottom_aio_bg;
    }

    @NotNull
    public final ColorStateList d(@NotNull Context context, boolean isImmersive) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(isImmersive));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (QQTheme.isVasTheme() && !isImmersive) {
            i3 = R.color.skin_input_theme_version2;
        } else {
            i3 = R.color.qui_common_text_primary;
        }
        ColorStateList colorStateList = context.getColorStateList(i3);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.getColorStateLis\u2026n_text_primary\n        })");
        return colorStateList;
    }
}
