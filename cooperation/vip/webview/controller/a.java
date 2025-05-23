package cooperation.vip.webview.controller;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* compiled from: P */
    /* renamed from: cooperation.vip.webview.controller.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static class C10130a {

        /* renamed from: a, reason: collision with root package name */
        public int f391412a;

        /* renamed from: b, reason: collision with root package name */
        public int f391413b;

        /* renamed from: c, reason: collision with root package name */
        public int f391414c;

        /* renamed from: d, reason: collision with root package name */
        public int f391415d;

        /* renamed from: e, reason: collision with root package name */
        public int f391416e;

        /* renamed from: f, reason: collision with root package name */
        public int f391417f;

        public C10130a(int i3, int i16, int i17, int i18, int i19, int i26) {
            this.f391417f = i3;
            this.f391416e = i16;
            this.f391413b = i17;
            this.f391412a = i18;
            this.f391414c = i19;
            this.f391415d = i26;
        }

        public int a() {
            return this.f391415d - this.f391412a;
        }

        public int b() {
            return this.f391417f;
        }

        public int c() {
            return this.f391416e;
        }

        public int d() {
            return this.f391414c - this.f391413b;
        }
    }

    public static void a(Activity activity, View view, C10130a c10130a, cooperation.vip.widget.a aVar) {
        if (activity == null || view == null || c10130a == null || aVar == null || aVar.isShowing()) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int b16 = iArr[0] + c10130a.b() + (c10130a.d() / 2);
        int c16 = iArr[1] + c10130a.c() + (c10130a.a() / 2);
        int screenHeight = ViewUtils.getScreenHeight();
        int h16 = aVar.h();
        int d16 = (screenHeight - c16) - (c10130a.d() / 4);
        int d17 = (c16 - (c10130a.d() / 4)) - aVar.k();
        if (d16 >= h16) {
            if (aVar.d(b16, c16 + (c10130a.d() / 4))) {
                aVar.t();
            }
        } else if (d17 >= h16 && aVar.d(b16, (c16 - h16) - (c10130a.d() / 4))) {
            aVar.u();
        }
    }
}
