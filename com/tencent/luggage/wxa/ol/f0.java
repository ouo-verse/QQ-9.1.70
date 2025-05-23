package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.ol.t0;
import com.tencent.luggage.wxa.ol.x;
import com.tencent.luggage.wxa.ul.a;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f0 extends LinearLayout implements x.h, r0 {
    public static final int L = 2131363116;
    public static final i M = new n(null);
    public boolean C;
    public View D;
    public boolean E;
    public EditText F;
    public Context G;
    public final t0 H;
    public com.tencent.luggage.wxa.fi.a I;
    public boolean J;
    public boolean K;

    /* renamed from: a, reason: collision with root package name */
    public final List f136719a;

    /* renamed from: b, reason: collision with root package name */
    public int f136720b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f136721c;

    /* renamed from: d, reason: collision with root package name */
    public l f136722d;

    /* renamed from: e, reason: collision with root package name */
    public j f136723e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f136724f;

    /* renamed from: g, reason: collision with root package name */
    public m f136725g;

    /* renamed from: h, reason: collision with root package name */
    public int f136726h;

    /* renamed from: i, reason: collision with root package name */
    public final com.tencent.luggage.wxa.tn.b0 f136727i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.ul.a f136728j;

    /* renamed from: k, reason: collision with root package name */
    public View f136729k;

    /* renamed from: l, reason: collision with root package name */
    public View f136730l;

    /* renamed from: m, reason: collision with root package name */
    public ImageButton f136731m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f0.this.C && 1 == f0.this.f136726h) {
                f0.this.t();
            } else {
                f0.this.j();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f0.this.f136729k != null && ViewCompat.isAttachedToWindow(f0.this.f136729k)) {
                if (!f0.this.f136728j.c()) {
                    f0.this.i();
                } else {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
                    f0.this.post(this);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.ul.c {
        public c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends com.tencent.luggage.wxa.tn.b0 {
        public d(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.luggage.wxa.tn.b0
        public void d(Message message) {
            if (1 == message.what) {
                ((Runnable) message.obj).run();
            } else {
                super.d(message);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f0.this.f(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                f0.M.d(f0.this);
                view.setSelected(false);
            } else {
                f0.M.b(f0.this);
                view.setSelected(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f136738a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f136739b;

        public g(int i3, boolean z16) {
            this.f136738a = i3;
            this.f136739b = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3 = f0.this.f136726h;
            if (!f0.this.isShown()) {
                f0.this.f136726h = 2;
            } else {
                f0.this.f136726h = this.f136738a;
            }
            if (f0.this.f136725g != null && i3 != f0.this.f136726h && !this.f136739b) {
                f0.this.f136725g.a(f0.this.f136726h);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface h {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface i {
        void a(f0 f0Var);

        void a(f0 f0Var, int i3);

        void b(f0 f0Var);

        void c(f0 f0Var);

        void d(f0 f0Var);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface j {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface k {
        EditText a();

        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface l {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface m {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class o extends FrameLayout implements h {

        /* renamed from: a, reason: collision with root package name */
        public boolean f136741a;

        public o(Context context) {
            super(context);
            this.f136741a = false;
            LayoutInflater.from(context).inflate(R.layout.f167656dz3, this);
        }

        @Override // com.tencent.luggage.wxa.ol.f0.h
        public void a(boolean z16) {
            boolean z17;
            if (z16 != this.f136741a) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f136741a = z16;
            if (z17 && !isInLayout()) {
                requestLayout();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i3, int i16) {
            if (this.f136741a || !isShown()) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                i16 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                i3 = makeMeasureSpec;
            }
            super.onMeasure(i3, i16);
        }
    }

    public f0(Context context, com.tencent.luggage.wxa.fi.a aVar, boolean z16) {
        super(context);
        this.f136719a = new ArrayList();
        this.f136720b = 0;
        this.f136721c = new b();
        this.f136724f = false;
        this.f136726h = 2;
        this.f136727i = new d(Looper.getMainLooper());
        this.I = null;
        this.J = false;
        this.K = false;
        this.G = context;
        t0 a16 = t0.a.a(context);
        this.H = a16 == null ? new com.tencent.luggage.wxa.rl.a() : a16;
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandSoftKeyboardPanel", "mComponentView is assigned");
        this.I = aVar;
        e(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPanelHeightImpl(int i3) {
        if (this.f136728j.b(i3)) {
            this.f136721c.run();
        }
    }

    public EditText getAttachedEditText() {
        return this.F;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        View view;
        com.tencent.luggage.wxa.fi.a aVar;
        if (getVisibility() != 0 || ((view = this.f136730l) != null && (view.getVisibility() != 0 || (this.f136730l.getMeasuredWidth() == 0 && this.f136730l.getMeasuredHeight() == 0)))) {
            return 0;
        }
        if (this.J && (aVar = this.I) != null) {
            com.tencent.luggage.wxa.kj.c0 customViewContainer = aVar.getCustomViewContainer();
            if (customViewContainer == null || !(customViewContainer.c() instanceof ViewGroup) || ((ViewGroup) customViewContainer.c()).getChildCount() <= 0 || ((ViewGroup) customViewContainer.c()).getChildAt(0).getLayoutParams() == null) {
                return 0;
            }
            return Math.max(((ViewGroup) customViewContainer.c()).getChildAt(0).getLayoutParams().height, 0);
        }
        return com.tencent.luggage.wxa.kn.a.a(getContext(), 48);
    }

    public void j() {
        if (!isShown()) {
            return;
        }
        d(8);
        if (this.F != null && !this.H.a()) {
            try {
                a1.b(this).hideSoftInputFromWindow(getWindowToken(), 0);
            } catch (Exception unused) {
            }
        }
        k();
        m();
    }

    public final void k() {
        this.f136728j.onPause();
        M.c(this);
        ImageButton imageButton = this.f136731m;
        if (imageButton != null) {
            imageButton.setSelected(false);
        }
        c(0);
    }

    public final boolean l() {
        return this.C;
    }

    public void n() {
        setCanSmileyInput(this.C);
        setShowDoneButton(this.E);
        v();
    }

    public final boolean o() {
        return this.f136728j.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
    }

    public void onDestroy() {
        d(8);
        if (this.G != null) {
            EditText editText = this.F;
            if (editText != null) {
                this.H.hideVKB(editText);
            } else {
                this.H.d();
            }
        }
        this.f136728j.onDestroy();
        ImageButton imageButton = this.f136731m;
        if (imageButton != null) {
            imageButton.setOnClickListener(null);
        }
        this.f136722d = null;
        removeAllViews();
        this.G = null;
        this.f136719a.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
        w();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int measuredHeight = getMeasuredHeight();
        int i19 = this.f136720b;
        if (measuredHeight != i19) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandSoftKeyboardPanel", "update panel height from %d to %d", Integer.valueOf(i19), Integer.valueOf(measuredHeight));
            this.f136720b = measuredHeight;
            for (k kVar : this.f136719a) {
                if (kVar != null && kVar.a() == this.F) {
                    kVar.a(this.f136720b);
                }
            }
        }
        com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", Integer.valueOf(getMeasuredHeight()));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandSoftKeyboardPanel", "smileyPanelWrapper, onMeasure");
    }

    public final void p() {
        q();
        q b16 = q.b(this);
        if (b16 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandSoftKeyboardPanel", "registerSystemSoftKeyboardHeightListener get null rootLayout");
        } else {
            ((x) b16.getOnLayoutListener()).a((x.h) this);
        }
    }

    public void q() {
        a(this, this.I);
    }

    public void r() {
        M.b(this);
        this.f136731m.setSelected(true);
    }

    public void s() {
        if (this.F != null) {
            u();
        }
        n();
        if (!isShown()) {
            d(0);
        }
    }

    public void setCanSmileyInput(boolean z16) {
        boolean z17;
        boolean z18 = true;
        int i3 = 0;
        if (z16 && o()) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z19 = this.K;
        if (this.C == z17) {
            z18 = false;
        }
        this.K = z18 | z19;
        this.C = z17;
        x();
        ImageButton imageButton = this.f136731m;
        if (imageButton != null) {
            if (!this.C) {
                i3 = 8;
            }
            imageButton.setVisibility(i3);
        }
        v();
    }

    public void setComponentView(boolean z16) {
        if (this.J != z16) {
            this.J = z16;
            this.K = true;
        }
    }

    public void setOnDoneListener(j jVar) {
        this.f136723e = jVar;
    }

    public void setOnSmileyChosenListener(l lVar) {
        boolean z16;
        if (lVar != this.f136722d) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f136722d = lVar;
        if (z16) {
            this.f136728j.a(new c());
        }
    }

    public void setOnVisibilityChangedListener(m mVar) {
        this.f136725g = mVar;
    }

    public void setShowDoneButton(boolean z16) {
        int i3;
        x();
        this.E = z16;
        View view = this.D;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
        v();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (i3 == 8) {
            if (getVisibility() != i3) {
                f(false);
            }
            j();
        } else if (i3 == 0) {
            s();
        } else {
            d(i3);
        }
    }

    public final void t() {
        this.f136728j.onResume();
        M.a(this);
        ImageButton imageButton = this.f136731m;
        if (imageButton != null) {
            imageButton.setSelected(true);
        }
        c(1);
    }

    public final void u() {
        k();
        EditText editText = this.F;
        if (editText != null) {
            InputMethodManager b16 = a1.b(editText);
            if (!b16.showSoftInput(this.F, 1)) {
                b16.showSoftInput(this.F, 2);
                return;
            }
            return;
        }
        this.H.e();
    }

    public void v() {
        KeyEvent.Callback callback = this.f136730l;
        if (callback != null && (callback instanceof h)) {
            h hVar = (h) callback;
            boolean z16 = true;
            if (!((!this.C) & (!this.E)) && !com.tencent.luggage.wxa.ok.g.a(this)) {
                z16 = false;
            }
            hVar.a(z16);
        }
    }

    public final void w() {
        q b16 = q.b(this);
        if (b16 == null || b16.getOnLayoutListener() == null) {
            return;
        }
        ((x) b16.getOnLayoutListener()).a((x.h) null);
    }

    public void x() {
        View view;
        View view2 = this.f136730l;
        if (view2 == null) {
            return;
        }
        if (this.K) {
            b(view2);
            if (this.J) {
                this.f136730l = this.I;
            } else {
                this.f136730l = h();
            }
            b(this.f136730l);
            addView(this.f136730l, 0);
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is changed in updateToolbar() because of toolbarChanged");
            this.K = false;
        }
        if (this.J && (view = this.f136730l) != this.I) {
            b(view);
            com.tencent.luggage.wxa.fi.a aVar = this.I;
            this.f136730l = aVar;
            b(aVar);
            addView(this.f136730l, 0);
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is changed in updateToolbar() because toolbar != mComponentView");
        }
        if (this.J && this.f136730l.getParent() != this) {
            b(this.f136730l);
            addView(this.f136730l, 0);
        }
    }

    public final ImageButton c(View view) {
        ImageButton imageButton;
        if (view == null || (imageButton = (ImageButton) view.findViewById(R.id.f86464rq)) == null) {
            return null;
        }
        imageButton.setSelected(false);
        imageButton.setOnClickListener(new f());
        return imageButton;
    }

    public void d(int i3) {
        if (i3 == 0 && com.tencent.luggage.wxa.ok.g.a(this)) {
            i3 = 8;
        }
        if (getVisibility() == i3) {
            return;
        }
        super.setVisibility(i3);
        if (i3 == 0) {
            p();
        } else {
            w();
        }
    }

    @Override // com.tencent.luggage.wxa.ol.r0
    public boolean e() {
        return this.f136728j.e();
    }

    public int f() {
        return L;
    }

    public View h() {
        o oVar = new o(getContext());
        a(c(oVar));
        if (this.f136731m != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, com.tencent.luggage.wxa.tn.z.j().getDrawable(R.drawable.ouz));
            stateListDrawable.addState(new int[0], com.tencent.luggage.wxa.tn.z.j().getDrawable(R.drawable.ouy));
            this.f136731m.setImageDrawable(stateListDrawable);
        }
        View findViewById = oVar.findViewById(R.id.f86454rp);
        this.D = findViewById;
        findViewById.setOnClickListener(new e());
        return oVar;
    }

    public final void i() {
        com.tencent.luggage.wxa.tn.w.e("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] forceMeasurePanel enter");
        this.f136729k.requestLayout();
    }

    public static f0 a(View view) {
        return (f0) view.getRootView().findViewById(L);
    }

    public void b(k kVar) {
        this.f136719a.remove(kVar);
    }

    public final void e(boolean z16) {
        ViewGroup viewGroup;
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandSoftKeyboardPanel", "init");
        super.setId(f());
        setOrientation(1);
        if (this.J) {
            this.f136730l = this.I;
        } else {
            this.f136730l = h();
        }
        View view = this.f136730l;
        if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is already existed in a layout,the class of the parent is %s  the id is : %d", viewGroup.getClass().toString(), Integer.valueOf(viewGroup.getId()));
            viewGroup.removeView(this.f136730l);
        }
        addView(this.f136730l);
        this.K = false;
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(a.b.class));
        this.f136728j = null;
        this.f136728j = new a.C6806a(this.G);
        M.a(this, x.a(getContext()));
        View a16 = this.f136728j.a();
        this.f136729k = a16;
        a16.setVisibility(8);
        this.f136729k.setBackgroundColor(0);
        addView(this.f136729k);
        v();
    }

    public final void f(boolean z16) {
        j jVar;
        if (this.f136724f || (jVar = this.f136723e) == null) {
            return;
        }
        this.f136724f = true;
        jVar.a(z16);
        this.f136724f = false;
    }

    public void a(k kVar) {
        if (this.f136719a.contains(kVar)) {
            return;
        }
        this.f136719a.add(kVar);
    }

    public void b(View view) {
        ViewGroup viewGroup;
        if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public final void c(int i3) {
        this.f136727i.a(1, new g(i3, this.f136724f)).sendToTarget();
    }

    public static f0 a(View view, com.tencent.luggage.wxa.fi.a aVar) {
        return a(view, null, aVar);
    }

    public boolean b(EditText editText) {
        if (editText != this.F) {
            return false;
        }
        this.F = null;
        return true;
    }

    public static f0 a(View view, Context context, com.tencent.luggage.wxa.fi.a aVar) {
        q b16 = q.b(view);
        if (b16 == null) {
            return null;
        }
        q.c(view);
        f0 a16 = a(view);
        if (a16 == null) {
            Context h16 = com.tencent.luggage.wxa.po.b.h(view.getContext());
            if (h16 == null) {
                h16 = com.tencent.luggage.wxa.po.b.i(view.getContext());
            }
            if (h16 != null) {
                context = h16;
            }
            if (view instanceof f0) {
                a16 = (f0) view;
            } else {
                a16 = new f0(context, aVar, false);
            }
        }
        b16.a(a16);
        if (a16.I != aVar) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandSoftKeyboardPanel", "mComponentView != componentView so we set mComponentView = componentView;");
            a16.I = aVar;
        }
        return a16;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class n implements i {
        public n() {
        }

        public /* synthetic */ n(a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.ol.f0.i
        public void a(f0 f0Var) {
            if (com.tencent.luggage.wxa.ok.g.a(f0Var)) {
                f0Var.d(8);
                f0Var.u();
                return;
            }
            if (f0Var.isShown()) {
                f0Var.f136729k.setVisibility(0);
            }
            if (!f0Var.C) {
                f0Var.f136728j.c(true);
            } else {
                f0Var.f136728j.d();
            }
        }

        @Override // com.tencent.luggage.wxa.ol.f0.i
        public void b(f0 f0Var) {
            f0Var.H.d();
            f0Var.t();
            f0Var.a(x.a(f0Var.G));
        }

        @Override // com.tencent.luggage.wxa.ol.f0.i
        public void c(f0 f0Var) {
            if (f0Var.isShown()) {
                f0Var.f136729k.setVisibility(0);
            }
            f0Var.f136728j.c(!f0Var.C);
        }

        @Override // com.tencent.luggage.wxa.ol.f0.i
        public void d(f0 f0Var) {
            f0Var.H.e();
            f0Var.k();
        }

        @Override // com.tencent.luggage.wxa.ol.f0.i
        public void a(f0 f0Var, int i3) {
            if (!com.tencent.luggage.wxa.ok.g.a(f0Var)) {
                if (f0Var.f136729k == null || i3 <= 0) {
                    return;
                }
                f0Var.setPanelHeightImpl(i3);
                return;
            }
            f0Var.d(8);
        }
    }

    public void a(int i3) {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", Integer.valueOf(i3));
        M.a(this, i3);
    }

    public void a(boolean z16) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", Boolean.valueOf(z16));
        if (z16) {
            d(0);
            k();
        } else if (isShown()) {
            a aVar = new a();
            if (this.f136727i.a(1)) {
                this.f136727i.a((Runnable) aVar);
            } else {
                aVar.run();
            }
        }
    }

    public void m() {
    }

    public final void a(ImageButton imageButton) {
        this.f136731m = imageButton;
    }

    public void a(EditText editText) {
        this.F = editText;
    }

    @Override // android.view.View
    public void setId(int i3) {
    }
}
