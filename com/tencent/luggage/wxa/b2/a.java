package com.tencent.luggage.wxa.b2;

import android.app.Activity;
import android.view.Window;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.oj.c;
import com.tencent.luggage.wxa.ok.g;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final v f121823a;

    /* renamed from: b, reason: collision with root package name */
    public c.b f121824b = null;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C6027a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f121825a;

        static {
            int[] iArr = new int[c.b.values().length];
            f121825a = iArr;
            try {
                iArr[c.b.SHOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f121825a[c.b.HIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(v vVar) {
        this.f121823a = vVar;
    }

    @Override // com.tencent.luggage.wxa.oj.c
    public void a() {
        this.f121824b = c.b.HIDDEN;
        a(true);
    }

    @Override // com.tencent.luggage.wxa.oj.c
    public void b() {
        Window window;
        this.f121824b = c.b.SHOWN;
        a(false);
        if ((this.f121823a.getContext() instanceof Activity) && (window = ((Activity) this.f121823a.getContext()).getWindow()) != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    @Override // com.tencent.luggage.wxa.oj.c
    public void d() {
        c.b bVar;
        if (this.f121824b == null) {
            if (this.f121823a.getRuntime().E().a().f125642b) {
                bVar = c.b.SHOWN;
            } else {
                bVar = c.b.HIDDEN;
            }
            this.f121824b = bVar;
        }
        int i3 = C6027a.f121825a[this.f121824b.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            a();
            return;
        }
        b();
    }

    @Override // com.tencent.luggage.wxa.oj.c
    public c.b getCurrentState() {
        return this.f121824b;
    }

    public final void a(boolean z16) {
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(this.f121823a.getContext());
        if (a16 == null) {
            return;
        }
        Window window = a16.getWindow();
        if (z16) {
            g.a(window, true, true);
        } else {
            g.d(window, false);
        }
    }

    @Override // com.tencent.luggage.wxa.oj.c
    public void c() {
    }
}
