package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import android.view.View;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class o implements g.b, g.c {

    /* renamed from: a, reason: collision with root package name */
    public MMBottomSheet f132269a;

    /* renamed from: b, reason: collision with root package name */
    public String f132270b;

    /* renamed from: c, reason: collision with root package name */
    public v f132271c;

    /* renamed from: e, reason: collision with root package name */
    public List f132273e;

    /* renamed from: d, reason: collision with root package name */
    public View f132272d = null;

    /* renamed from: f, reason: collision with root package name */
    public final Set f132274f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    public final Set f132275g = new HashSet();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Iterator it = o.this.f132274f.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Iterator it = o.this.f132275g.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.mo.p {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.mo.p
        public void a(com.tencent.luggage.wxa.mo.h hVar) {
            o.this.a(hVar, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.mo.u {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.mo.u
        public void a(MenuItem menuItem, int i3) {
            o.this.a(menuItem);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.mo.p {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.mo.p
        public void a(com.tencent.luggage.wxa.mo.h hVar) {
            o.this.a(hVar, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements com.tencent.luggage.wxa.mo.u {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.mo.u
        public void a(MenuItem menuItem, int i3) {
            o.this.a(menuItem);
        }
    }

    public o(v vVar, List list, boolean z16) {
        this.f132270b = vVar.getAppId();
        this.f132271c = vVar;
        this.f132273e = list;
        this.f132269a = new MMBottomSheet(vVar.getContext(), false, !z16 ? 1 : 0);
        com.tencent.luggage.wxa.wj.c n06 = vVar.getRuntime().n0();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageActionSheet", "AppBrandPageActionSheet: width [%d]", Integer.valueOf(n06.getVDisplayMetrics().widthPixels));
        if (n06.shouldInLargeScreenCompatMode()) {
            this.f132269a.setNewLandscapeMaxWidth((int) (n06.getVDisplayMetrics().widthPixels * n06.getScale()));
        }
        a(this.f132269a);
    }

    public void b(MMBottomSheet mMBottomSheet) {
    }

    public void c(Runnable runnable) {
        a(runnable);
    }

    public void d(Runnable runnable) {
        b(runnable);
    }

    public final boolean f() {
        boolean z16;
        boolean z17;
        try {
            MMBottomSheet mMBottomSheet = this.f132269a;
            if (!this.f132271c.d() && !this.f132271c.L0()) {
                z16 = false;
                mMBottomSheet.hideStatusBar(z16);
                MMBottomSheet mMBottomSheet2 = this.f132269a;
                if (!this.f132271c.d() && !this.f132271c.L0()) {
                    z17 = false;
                    mMBottomSheet2.hideNavigationFullScreen(z17);
                    b(this.f132269a);
                    this.f132269a.tryShow();
                    this.f132271c.a((g.b) this);
                    this.f132271c.a((g.c) this);
                    this.f132269a.getWindow().getDecorView().addOnAttachStateChangeListener(new a());
                    this.f132269a.getWindow().setFlags(131072, 131072);
                    this.f132269a.getWindow().setSoftInputMode(48);
                    return true;
                }
                z17 = true;
                mMBottomSheet2.hideNavigationFullScreen(z17);
                b(this.f132269a);
                this.f132269a.tryShow();
                this.f132271c.a((g.b) this);
                this.f132271c.a((g.c) this);
                this.f132269a.getWindow().getDecorView().addOnAttachStateChangeListener(new a());
                this.f132269a.getWindow().setFlags(131072, 131072);
                this.f132269a.getWindow().setSoftInputMode(48);
                return true;
            }
            z16 = true;
            mMBottomSheet.hideStatusBar(z16);
            MMBottomSheet mMBottomSheet22 = this.f132269a;
            if (!this.f132271c.d()) {
                z17 = false;
                mMBottomSheet22.hideNavigationFullScreen(z17);
                b(this.f132269a);
                this.f132269a.tryShow();
                this.f132271c.a((g.b) this);
                this.f132271c.a((g.c) this);
                this.f132269a.getWindow().getDecorView().addOnAttachStateChangeListener(new a());
                this.f132269a.getWindow().setFlags(131072, 131072);
                this.f132269a.getWindow().setSoftInputMode(48);
                return true;
            }
            z17 = true;
            mMBottomSheet22.hideNavigationFullScreen(z17);
            b(this.f132269a);
            this.f132269a.tryShow();
            this.f132271c.a((g.b) this);
            this.f132271c.a((g.c) this);
            this.f132269a.getWindow().getDecorView().addOnAttachStateChangeListener(new a());
            this.f132269a.getWindow().setFlags(131072, 131072);
            this.f132269a.getWindow().setSoftInputMode(48);
            return true;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandPageActionSheet", e16, "showActionSheet", new Object[0]);
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.g.b
    public void onBackground() {
        d();
    }

    @Override // com.tencent.luggage.wxa.xd.g.c
    public void onDestroy() {
        d();
    }

    public final boolean d() {
        try {
            this.f132269a.tryHide();
            this.f132271c.b((g.b) this);
            this.f132271c.b((g.c) this);
            return true;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPageActionSheet", "hide exception = %s", e16);
            return false;
        }
    }

    public void b(Runnable runnable) {
        if (runnable != null) {
            this.f132274f.add(runnable);
        }
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            this.f132275g.add(runnable);
        }
    }

    public void a(MMBottomSheet mMBottomSheet) {
        View W0 = this.f132271c.W0();
        if (W0 != null) {
            this.f132269a.setTitleView(W0, true);
            this.f132272d = W0;
        }
        View Z = this.f132271c.Z();
        if (Z != null) {
            this.f132269a.setFooterView(Z);
        }
        this.f132269a.setOnCreateMenuListener(new b());
        this.f132269a.setOnMenuSelectedListener(new c());
        this.f132269a.setOnCreateSecondMenuListener(new d());
        this.f132269a.setOnSecondMenuSelectedListener(new e());
        if (i.b.BLACK == this.f132271c.Y()) {
            this.f132269a.setBackgroundColor(Color.parseColor("#000000"));
        }
    }

    public final void a(com.tencent.luggage.wxa.mo.h hVar, boolean z16) {
        for (com.tencent.luggage.wxa.ui.a aVar : this.f132273e) {
            if (aVar != null && aVar.e() == z16) {
                a(this.f132271c.getContext(), this.f132271c, hVar, this.f132270b, aVar);
            }
        }
    }

    public final void a(MenuItem menuItem) {
        if (a(this.f132271c.getContext(), this.f132271c, this.f132270b, a(this.f132273e, menuItem.getItemId()))) {
            this.f132269a.tryHide();
        }
    }

    public static boolean a(Context context, v vVar, com.tencent.luggage.wxa.mo.h hVar, String str, com.tencent.luggage.wxa.ui.a aVar) {
        if (aVar == null) {
            return false;
        }
        aVar.a().b(context, vVar, hVar, str, aVar);
        return true;
    }

    public static boolean a(Context context, v vVar, String str, com.tencent.luggage.wxa.ui.a aVar) {
        if (aVar == null) {
            return false;
        }
        aVar.a().a(context, vVar, str, aVar);
        return true;
    }

    public static com.tencent.luggage.wxa.ui.a a(List list, int i3) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.ui.a aVar = (com.tencent.luggage.wxa.ui.a) it.next();
            if (aVar.b() == i3) {
                return aVar;
            }
        }
        return null;
    }
}
