package com.tencent.luggage.wxa.oj;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.oj.c;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends b {

    /* renamed from: c, reason: collision with root package name */
    public int f136546c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.oj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C6552a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f136547a;

        static {
            int[] iArr = new int[c.b.values().length];
            f136547a = iArr;
            try {
                iArr[c.b.SHOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f136547a[c.b.HIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(v vVar) {
        super(vVar);
        this.f136546c = 0;
    }

    public final void a(boolean z16) {
        Window window;
        this.f136549b.set(c.b.SHOWN);
        if (!(this.f136548a.getContext() instanceof Activity) || (window = ((Activity) this.f136548a.getContext()).getWindow()) == null) {
            return;
        }
        View decorView = window.getDecorView();
        window.clearFlags(1024);
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-5));
    }

    @Override // com.tencent.luggage.wxa.oj.b, com.tencent.luggage.wxa.oj.c
    public void b() {
        a(false);
    }

    @Override // com.tencent.luggage.wxa.oj.b, com.tencent.luggage.wxa.oj.c
    public void d() {
        super.d();
        int i3 = C6552a.f136547a[((c.b) this.f136549b.get()).ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            a();
            return;
        }
        a(true);
    }

    @Override // com.tencent.luggage.wxa.oj.b, com.tencent.luggage.wxa.oj.c
    public void a() {
        Window window;
        this.f136549b.set(c.b.HIDDEN);
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(this.f136548a.getContext());
        if (a16 == null || a16.isFinishing() || a16.isDestroyed() || (window = a16.getWindow()) == null) {
            return;
        }
        window.addFlags(1024);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4 | 256);
    }

    public void a(boolean z16, int i3) {
        boolean isInMultiWindowMode;
        boolean z17 = i3 != this.f136546c;
        this.f136546c = i3;
        if (2 == i3) {
            Activity a06 = this.f136548a.a0();
            if (a06 != null && Build.VERSION.SDK_INT >= 24) {
                isInMultiWindowMode = a06.isInMultiWindowMode();
                if (isInMultiWindowMode && a06.getRequestedOrientation() == 1) {
                    return;
                }
            }
            if (z16) {
                return;
            }
            a();
            return;
        }
        if ((z17 || this.f136549b.get() == c.b.SHOWN) && !z16) {
            b();
        }
    }

    @Override // com.tencent.luggage.wxa.oj.b, com.tencent.luggage.wxa.oj.c
    public void c() {
    }
}
