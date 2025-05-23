package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.tencent.mm.plugin.appbrand.widget.input.KeyboardHeightProvider;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class x implements com.tencent.luggage.wxa.xl.a {

    /* renamed from: l, reason: collision with root package name */
    public static Integer f136945l;

    /* renamed from: c, reason: collision with root package name */
    public KeyboardHeightProvider f136948c;

    /* renamed from: h, reason: collision with root package name */
    public View f136953h;

    /* renamed from: i, reason: collision with root package name */
    public h f136954i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f136946a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f136947b = 1;

    /* renamed from: d, reason: collision with root package name */
    public int f136949d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f136950e = new int[2];

    /* renamed from: f, reason: collision with root package name */
    public final Rect f136951f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    public boolean f136952g = false;

    /* renamed from: j, reason: collision with root package name */
    public int f136955j = 0;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f136956k = new LinkedHashSet();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f136957a;

        public a(int i3) {
            this.f136957a = i3;
        }

        @Override // com.tencent.luggage.wxa.ol.x.g
        public void a(i iVar) {
            int height = iVar.getHeight();
            int i3 = this.f136957a;
            if (height != i3) {
                iVar.a(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f136959a;

        public b(boolean z16) {
            this.f136959a = z16;
        }

        @Override // com.tencent.luggage.wxa.ol.x.g
        public void a(i iVar) {
            iVar.a(this.f136959a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f136961a;

        public c(int i3) {
            this.f136961a = i3;
        }

        @Override // com.tencent.luggage.wxa.ol.x.g
        public void a(i iVar) {
            int height = iVar.getHeight();
            int i3 = this.f136961a;
            if (height != i3) {
                iVar.a(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements b1 {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.ol.b1
        public void a(int i3, boolean z16) {
            boolean z17;
            if (x.this.f136947b == 2) {
                x.this.d(i3);
                x xVar = x.this;
                if (i3 > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                xVar.b(z17);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f136964a;

        public e(int i3) {
            this.f136964a = i3;
        }

        @Override // com.tencent.luggage.wxa.ol.x.g
        public void a(i iVar) {
            int height = iVar.getHeight();
            int i3 = this.f136964a;
            if (height != i3) {
                iVar.a(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f136966a;

        public f(boolean z16) {
            this.f136966a = z16;
        }

        @Override // com.tencent.luggage.wxa.ol.x.g
        public void a(i iVar) {
            iVar.a(this.f136966a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface g {
        void a(i iVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface h extends i {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface i {
        void a(int i3);

        void a(boolean z16);

        int getHeight();
    }

    public final void b(int i3) {
        d(c() > i3);
    }

    public final int c() {
        int i3;
        if (d() == null) {
            return 0;
        }
        Rect rect = this.f136951f;
        a(rect);
        if (ViewCompat.isLaidOut(this.f136953h)) {
            i3 = this.f136953h.getMeasuredHeight();
        } else {
            i3 = a().getResources().getDisplayMetrics().heightPixels;
        }
        return i3 - rect.top;
    }

    public final View d() {
        View view = this.f136953h;
        if (view == null) {
            return null;
        }
        return view.getRootView();
    }

    public void e(int i3) {
        this.f136947b = i3;
        if (i3 != 1) {
            if (i3 == 2) {
                KeyboardHeightProvider keyboardHeightProvider = this.f136948c;
                if (keyboardHeightProvider == null) {
                    this.f136947b = 1;
                    return;
                } else {
                    keyboardHeightProvider.a();
                    this.f136948c.f();
                    return;
                }
            }
            return;
        }
        KeyboardHeightProvider keyboardHeightProvider2 = this.f136948c;
        if (keyboardHeightProvider2 != null) {
            keyboardHeightProvider2.b();
            this.f136948c.g();
        }
    }

    public void f(int i3) {
        boolean z16;
        if (i3 > 0 && this.f136955j != i3) {
            this.f136955j = i3;
            d(i3);
            a(new c(i3));
        }
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        d(z16);
    }

    @Override // com.tencent.luggage.wxa.xl.a
    public void onDestroy() {
        KeyboardHeightProvider keyboardHeightProvider = this.f136948c;
        if (keyboardHeightProvider != null) {
            keyboardHeightProvider.b();
            this.f136948c.g();
            this.f136948c.a((b1) null);
        }
        this.f136948c = null;
        this.f136956k.clear();
    }

    public final void d(boolean z16) {
        if ((this.f136952g == z16 || this.f136946a) ? false : true) {
            a(z16);
            a(new b(z16));
        }
        this.f136952g = z16;
    }

    public int b() {
        return this.f136947b;
    }

    public final void a(Rect rect) {
        View view = this.f136953h;
        if (view != null) {
            view.getWindowVisibleDisplayFrame(rect);
            this.f136953h.getLocationInWindow(this.f136950e);
            rect.top = this.f136950e[1];
        }
    }

    public final void b(boolean z16) {
        if (this.f136952g != z16) {
            a(z16);
            a(new f(z16));
        }
        this.f136952g = z16;
    }

    public final void d(int i3) {
        if (i3 <= 0) {
            return;
        }
        boolean a16 = a(a(), i3);
        a(new e(i3));
        h hVar = this.f136954i;
        if (hVar == null) {
            return;
        }
        if (a16 || hVar.getHeight() != i3) {
            this.f136954i.a(i3);
        }
    }

    public final Context a() {
        View view = this.f136953h;
        return view == null ? com.tencent.luggage.wxa.tn.z.c() : view.getContext();
    }

    public void b(i iVar) {
        if (iVar != null) {
            this.f136956k.remove(iVar);
        }
    }

    public final void c(int i3) {
        if (this.f136949d == 0) {
            this.f136949d = i3;
        }
        int c16 = c() - i3;
        if (c16 <= 0) {
            return;
        }
        boolean a16 = a(a(), c16);
        a(new a(c16));
        h hVar = this.f136954i;
        if (hVar == null) {
            return;
        }
        if (a16 || hVar.getHeight() != c16) {
            this.f136954i.a(c16);
        }
    }

    public final void a(int i3) {
        if (this.f136949d == 0) {
            this.f136949d = i3;
        }
        c(c() - i3);
    }

    public final void a(boolean z16) {
        h hVar = this.f136954i;
        if (hVar != null) {
            hVar.a(z16);
        }
    }

    public void a(h hVar) {
        this.f136954i = hVar;
    }

    @Override // com.tencent.luggage.wxa.xl.a
    public void a(View view, boolean z16, int i3, int i16, int i17, int i18) {
        this.f136953h = view;
        if (1 != this.f136947b) {
            return;
        }
        Rect rect = this.f136951f;
        a(rect);
        int height = rect.height();
        c(height);
        b(height);
        this.f136949d = height;
        this.f136953h = null;
    }

    public void c(boolean z16) {
        this.f136946a = z16;
    }

    @Override // com.tencent.luggage.wxa.xl.a
    public void a(View view, boolean z16, int i3) {
        this.f136953h = view;
        if (1 != this.f136947b) {
            return;
        }
        a(i3);
        d(z16);
        this.f136949d = i3;
        this.f136953h = null;
    }

    public void a(KeyboardHeightProvider keyboardHeightProvider) {
        this.f136948c = keyboardHeightProvider;
        keyboardHeightProvider.a(new d());
    }

    public static boolean a(Context context, int i3) {
        if (i3 <= 0) {
            return false;
        }
        if (f136945l == null) {
            f136945l = Integer.valueOf(com.tencent.luggage.wxa.tn.s.g(context));
        }
        if (f136945l.intValue() == i3) {
            return false;
        }
        f136945l = Integer.valueOf(i3);
        return true;
    }

    public static int a(Context context) {
        if (f136945l == null) {
            f136945l = Integer.valueOf(com.tencent.luggage.wxa.tn.s.g(context));
        }
        return f136945l.intValue();
    }

    public final void a(g gVar) {
        Iterator it = ((LinkedHashSet) this.f136956k.clone()).iterator();
        while (it.hasNext()) {
            gVar.a((i) it.next());
        }
    }

    public void a(i iVar) {
        if (iVar == null || this.f136956k.contains(iVar)) {
            return;
        }
        this.f136956k.add(iVar);
    }
}
