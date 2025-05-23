package com.tencent.luggage.wxa.ol;

import android.app.Activity;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d, reason: collision with root package name */
    public static final a f136691d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final b f136692a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.jq.c f136693b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f136694c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        Activity a();

        void a(int i3);

        void a(boolean z16);

        int b();

        View getContentView();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f136695a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d1 f136696b;

        public c(int i3, d1 d1Var) {
            this.f136695a = i3;
            this.f136696b = d1Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i3 = this.f136695a;
            if (i3 > 0 && i3 != this.f136696b.a().b()) {
                this.f136696b.a().a(this.f136695a);
            }
            if (this.f136695a > 0 && !this.f136696b.f136694c) {
                this.f136696b.a().a(true);
                this.f136696b.f136694c = true;
            }
            this.f136696b.f136693b = null;
        }
    }

    public d1(b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f136692a = callback;
    }

    public final void b() {
        com.tencent.luggage.wxa.jq.c cVar = this.f136693b;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            if (!cVar.isCancelled()) {
                com.tencent.luggage.wxa.jq.c cVar2 = this.f136693b;
                Intrinsics.checkNotNull(cVar2);
                cVar2.cancel(false);
            }
        }
        this.f136693b = null;
        this.f136692a.a(false);
        this.f136694c = false;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int systemWindowInsetBottom;
        int i3;
        WindowInsets windowInsets;
        int c16;
        int i16;
        int coerceAtLeast;
        int ime;
        Insets insets;
        int i17;
        int navigationBars;
        Insets insets2;
        View contentView = this.f136692a.getContentView();
        if (contentView == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.OnEditableClientGlobalLayoutListener", "onGlobalLayout, content view is null");
            return;
        }
        Activity a16 = this.f136692a.a();
        if (a16 == null) {
            a16 = com.tencent.luggage.wxa.bo.a.a(contentView.getContext());
        }
        if (a16 != null) {
            windowInsets = com.tencent.luggage.wxa.lo.k.a(a16);
            Intrinsics.checkNotNull(windowInsets);
            i3 = windowInsets.getSystemWindowInsetBottom();
        } else {
            WindowInsets rootWindowInsets = contentView.getRootWindowInsets();
            if (rootWindowInsets == null) {
                Rect rect = new Rect();
                contentView.getWindowVisibleDisplayFrame(rect);
                systemWindowInsetBottom = rect.height();
            } else {
                systemWindowInsetBottom = rootWindowInsets.getSystemWindowInsetBottom();
            }
            i3 = systemWindowInsetBottom;
            windowInsets = rootWindowInsets;
        }
        int i18 = Build.VERSION.SDK_INT;
        if (i18 >= 30 && windowInsets != null) {
            navigationBars = WindowInsets.Type.navigationBars();
            insets2 = windowInsets.getInsets(navigationBars);
            c16 = insets2.bottom;
        } else {
            c16 = com.tencent.luggage.wxa.lo.q.c(a16);
        }
        if (i18 >= 30 && windowInsets != null) {
            ime = WindowInsets.Type.ime();
            insets = windowInsets.getInsets(ime);
            Intrinsics.checkNotNullExpressionValue(insets, "windowInsets.getInsets(WindowInsets.Type.ime())");
            i17 = insets.bottom;
            i16 = i17 - c16;
        } else {
            i16 = i3 - c16;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, i16);
        com.tencent.luggage.wxa.jq.c cVar = this.f136693b;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            if (!cVar.isCancelled()) {
                com.tencent.luggage.wxa.jq.c cVar2 = this.f136693b;
                Intrinsics.checkNotNull(cVar2);
                cVar2.cancel(false);
            }
        }
        c cVar3 = new c(coerceAtLeast, this);
        if (this.f136692a.b() == 0) {
            if (coerceAtLeast <= 0 && this.f136694c) {
                this.f136692a.a(false);
                this.f136694c = false;
            }
        } else if (coerceAtLeast > 0 && !this.f136694c) {
            this.f136692a.a(true);
            this.f136694c = true;
        } else if (coerceAtLeast <= 0 && this.f136694c) {
            this.f136692a.a(false);
            this.f136694c = false;
        }
        if (coerceAtLeast > 0) {
            this.f136693b = com.tencent.luggage.wxa.zp.h.f146825d.c(cVar3, 160L);
        }
    }

    public final b a() {
        return this.f136692a;
    }
}
