package com.tencent.paysdk.util;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static DisplayMetrics f342086a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8134);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342086a = null;
        }
    }

    public static float a(float f16) {
        return TypedValue.applyDimension(1, f16, b());
    }

    private static DisplayMetrics b() {
        if (f342086a == null) {
            f342086a = com.tencent.paysdk.a.l().getContext().getResources().getDisplayMetrics();
        }
        return f342086a;
    }

    public static void c(View view, int i3, int i16) {
        if (view == null) {
            return;
        }
        int a16 = (int) a(i3);
        int a17 = (int) a(i16);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = a16;
        layoutParams.height = a17;
        view.setLayoutParams(layoutParams);
    }
}
