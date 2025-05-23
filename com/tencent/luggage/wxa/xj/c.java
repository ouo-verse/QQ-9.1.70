package com.tencent.luggage.wxa.xj;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.wj.d;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c extends com.tencent.luggage.wxa.wj.a {

    /* renamed from: l, reason: collision with root package name */
    public final d.b f145061l;

    /* renamed from: m, reason: collision with root package name */
    public int f145062m;

    /* renamed from: n, reason: collision with root package name */
    public int f145063n;

    /* renamed from: o, reason: collision with root package name */
    public WindowManager.LayoutParams f145064o;

    /* renamed from: p, reason: collision with root package name */
    public e.b f145065p;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements d.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindowAndroidActivityImpl f145066a;

        public a(WindowAndroidActivityImpl windowAndroidActivityImpl) {
            this.f145066a = windowAndroidActivityImpl;
        }

        @Override // com.tencent.luggage.wxa.wj.d.b
        public void a(e.b bVar) {
            this.f145066a.getOrientationHandler().a(bVar, null);
        }
    }

    public c(WindowAndroidActivityImpl windowAndroidActivityImpl, d.a aVar) {
        super(windowAndroidActivityImpl, aVar);
        this.f145063n = -1;
        this.f145061l = new a(windowAndroidActivityImpl);
    }

    @Override // com.tencent.luggage.wxa.wj.d
    public void a(int i3) {
        this.f144260k = true;
        if (i3 == -90) {
            this.f145065p = e.b.a(8);
        } else if (i3 == 0) {
            this.f145065p = e.b.a(1);
        } else if (i3 != 90) {
            this.f145065p = e.b.a(9);
        } else {
            this.f145065p = e.b.a(0);
        }
        this.f145061l.a(this.f145065p);
    }

    @Override // com.tencent.luggage.wxa.wj.a, com.tencent.luggage.wxa.wj.d
    public boolean c() {
        boolean z16 = this.f144260k;
        try {
            if (super.c()) {
                Activity f16 = f();
                if (f16 != null && !f16.isFinishing() && !f16.isDestroyed()) {
                    ((ViewGroup) f16.getWindow().getDecorView()).setSystemUiVisibility(this.f145062m);
                    f16.getWindow().clearFlags(1024);
                    if (this.f145064o != null) {
                        f16.getWindow().setAttributes(this.f145064o);
                    }
                    this.f145061l.a(e.b.a(this.f145063n));
                    this.f145063n = -1;
                    e();
                    return true;
                }
                w.b("Luggage.ActivityWindowFullscreenImpl", "exitFullscreen activity(%s) destroyed", f16);
                e();
                return true;
            }
            if (!z16) {
                return false;
            }
            this.f144260k = false;
            e();
            return true;
        } finally {
            this.f145065p = null;
        }
    }

    public final Activity f() {
        return ((WindowAndroidActivityImpl) this.f144251b).j();
    }

    @Override // com.tencent.luggage.wxa.wj.d
    public e.b a() {
        return this.f145065p;
    }

    @Override // com.tencent.luggage.wxa.wj.a, com.tencent.luggage.wxa.wj.d
    public final void a(View view, int i3) {
        super.a(view, i3);
        Activity f16 = f();
        if (f16 != null) {
            ViewGroup viewGroup = (ViewGroup) f16.getWindow().getDecorView();
            if (this.f144259j == null) {
                this.f145062m = viewGroup.getSystemUiVisibility();
            }
            if (com.tencent.luggage.wxa.aa.a.a(19)) {
                viewGroup.setSystemUiVisibility(2);
            } else {
                viewGroup.setSystemUiVisibility(4102);
            }
            if (this.f144259j == null) {
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                this.f145064o = layoutParams;
                layoutParams.copyFrom(f16.getWindow().getAttributes());
            }
            f16.getWindow().addFlags(1024);
            if (Build.VERSION.SDK_INT >= 28) {
                f16.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
            }
            if (this.f144259j == null) {
                this.f145063n = f16.getRequestedOrientation();
            }
            a(i3);
        } else {
            w.b("Luggage.ActivityWindowFullscreenImpl", "enterFullscreen, get NULL activity");
            if (this.f144259j == null) {
                this.f145063n = -1;
                this.f145064o = null;
                this.f145062m = 0;
            }
        }
        d();
        this.f144259j = null;
    }
}
