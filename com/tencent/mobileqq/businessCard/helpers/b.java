package com.tencent.mobileqq.businessCard.helpers;

import android.annotation.TargetApi;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @TargetApi(11)
    /* loaded from: classes11.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        static void a(View view, float f16) {
            view.setAlpha(f16);
        }

        static void b(View view, float f16) {
            view.setPivotX(f16);
        }

        static void c(View view, float f16) {
            view.setPivotY(f16);
        }

        static void d(View view, float f16) {
            view.setScaleX(f16);
        }

        static void e(View view, float f16) {
            view.setScaleY(f16);
        }

        static void f(View view, float f16) {
            view.setTranslationY(f16);
        }

        static void g(View view, float f16) {
            view.setX(f16);
        }
    }

    public static void a(View view, float f16) {
        if (com.tencent.mobileqq.businessCard.helpers.a.M) {
            com.tencent.mobileqq.businessCard.helpers.a.n(view).d(f16);
        } else {
            a.a(view, f16);
        }
    }

    public static void b(View view, float f16) {
        if (com.tencent.mobileqq.businessCard.helpers.a.M) {
            com.tencent.mobileqq.businessCard.helpers.a.n(view).e(f16);
        } else {
            a.b(view, f16);
        }
    }

    public static void c(View view, float f16) {
        if (com.tencent.mobileqq.businessCard.helpers.a.M) {
            com.tencent.mobileqq.businessCard.helpers.a.n(view).f(f16);
        } else {
            a.c(view, f16);
        }
    }

    public static void d(View view, float f16) {
        if (com.tencent.mobileqq.businessCard.helpers.a.M) {
            com.tencent.mobileqq.businessCard.helpers.a.n(view).h(f16);
        } else {
            a.d(view, f16);
        }
    }

    public static void e(View view, float f16) {
        if (com.tencent.mobileqq.businessCard.helpers.a.M) {
            com.tencent.mobileqq.businessCard.helpers.a.n(view).i(f16);
        } else {
            a.e(view, f16);
        }
    }

    public static void f(View view, float f16) {
        if (com.tencent.mobileqq.businessCard.helpers.a.M) {
            com.tencent.mobileqq.businessCard.helpers.a.n(view).k(f16);
        } else {
            a.f(view, f16);
        }
    }

    public static void g(View view, float f16) {
        if (com.tencent.mobileqq.businessCard.helpers.a.M) {
            com.tencent.mobileqq.businessCard.helpers.a.n(view).l(f16);
        } else {
            a.g(view, f16);
        }
    }
}
