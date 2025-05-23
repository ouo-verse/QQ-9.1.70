package com.tencent.ecommerce.richtext.ui.view.lottie;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import nk0.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VLottieView extends View {

    /* renamed from: d, reason: collision with root package name */
    nk0.a f105482d;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static b f105483a;

        public static nk0.a a(Context context) {
            b bVar = f105483a;
            if (bVar != null) {
                return bVar.a(context);
            }
            return null;
        }

        public static void b(b bVar) {
            f105483a = bVar;
        }
    }

    public VLottieView(Context context) {
        super(context);
        this.f105482d = a.a(context);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        nk0.a aVar = this.f105482d;
        if (aVar != null) {
            aVar.j(animatorListener);
        }
    }

    public View b() {
        Object obj = this.f105482d;
        if (obj != null && (obj instanceof View)) {
            return (View) obj;
        }
        return new View(getContext());
    }

    public void c(boolean z16) {
        nk0.a aVar = this.f105482d;
        if (aVar != null) {
            aVar.c(z16);
        }
    }
}
