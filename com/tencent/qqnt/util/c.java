package com.tencent.qqnt.util;

import android.R;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/util/c;", "", "", "gradientColors", "", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "", "cornerRadii", "Landroid/graphics/drawable/Drawable;", "a", "normalColor", "pressColor", "Landroid/graphics/drawable/StateListDrawable;", "b", "<init>", "()V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f362979a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38803);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f362979a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Drawable a(@NotNull int[] gradientColors, int defaultColor, @NotNull float[] cornerRadii) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, this, gradientColors, Integer.valueOf(defaultColor), cornerRadii);
        }
        Intrinsics.checkNotNullParameter(gradientColors, "gradientColors");
        Intrinsics.checkNotNullParameter(cornerRadii, "cornerRadii");
        return new com.tencent.qqnt.widget.a(cornerRadii, gradientColors, defaultColor);
    }

    @NotNull
    public final StateListDrawable b(int normalColor, int pressColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (StateListDrawable) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(normalColor), Integer.valueOf(pressColor));
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(pressColor));
        stateListDrawable.addState(new int[]{R.attr.state_selected}, new ColorDrawable(pressColor));
        stateListDrawable.addState(new int[0], new ColorDrawable(normalColor));
        return stateListDrawable;
    }
}
