package com.tencent.util;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/util/TokenUIUtils;", "", "()V", "replaceIconWithBg", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "btn", "Landroid/widget/TextView;", "drawable", "Landroid/graphics/drawable/Drawable;", "qqui_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class TokenUIUtils {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final TokenUIUtils INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44332);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new TokenUIUtils();
        }
    }

    TokenUIUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void replaceIconWithBg(boolean r56, @NotNull TextView btn, @NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(r56), btn, drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(btn, "btn");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (r56) {
            btn.setBackground(null);
            btn.setPadding(0, 0, 0, 0);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            btn.setCompoundDrawables(drawable, null, null, null);
        }
    }
}
