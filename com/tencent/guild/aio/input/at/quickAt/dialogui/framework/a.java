package com.tencent.guild.aio.input.at.quickAt.dialogui.framework;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.tencent.guild.aio.input.at.quickAt.dialogui.framework.GuildDialogGestureLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import qo0.e;
import ro0.c;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a extends PopupWindow implements GuildDialogGestureLayout.c {
    protected View C;
    protected View D;
    protected LinearLayout E;
    protected GuildDialogGestureLayout F;
    protected int G;
    protected int H;
    protected boolean I;
    private final Rect J;

    /* renamed from: d, reason: collision with root package name */
    protected final Context f110977d;

    /* renamed from: e, reason: collision with root package name */
    protected final e f110978e;

    /* renamed from: f, reason: collision with root package name */
    protected final Map<Class<? extends oo0.a>, oo0.a> f110979f;

    /* renamed from: h, reason: collision with root package name */
    protected final c f110980h;

    /* renamed from: i, reason: collision with root package name */
    protected InterfaceC1190a f110981i;

    /* renamed from: m, reason: collision with root package name */
    protected ViewTreeObserver.OnGlobalLayoutListener f110982m;

    /* compiled from: P */
    /* renamed from: com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1190a {
        void H0(int i3);

        void b();

        void c();
    }

    public a(Context context, e eVar, Object[] objArr) {
        this(context, new GuildDialogGestureLayout(context), eVar, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        InterfaceC1190a interfaceC1190a = this.f110981i;
        if (interfaceC1190a != null) {
            interfaceC1190a.H0(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        n(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("GuildDialog", 4, "click on ScrollView");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        QLog.d("GuildDialog", 4, "onGlobalLayout");
        View view = this.C;
        if (view == null) {
            return;
        }
        Rect f16 = this.f110980h.f(view);
        if (!f16.equals(this.J)) {
            R(f16);
            QLog.d("GuildDialog", 4, "updatePanelLayout window height has change");
        }
    }

    private void P(e eVar) {
        Boolean bool;
        setFocusable(eVar.f429114d);
        setOutsideTouchable(false);
        setClippingEnabled(false);
        setInputMethodMode(eVar.f429115e);
        if (Build.VERSION.SDK_INT >= 29 && (bool = eVar.f429116f) != null) {
            setIsLaidOutInScreen(bool.booleanValue());
        }
    }

    private void s() {
        InterfaceC1190a interfaceC1190a = this.f110981i;
        if (interfaceC1190a != null) {
            interfaceC1190a.c();
        }
    }

    protected abstract oo0.a[] A(Context context);

    public boolean B() {
        if (super.isShowing() && this.H == 0) {
            return true;
        }
        return false;
    }

    public boolean C() {
        if (this.H == 2) {
            return true;
        }
        return false;
    }

    public void H() {
        View view;
        Iterator<oo0.a> it = this.f110979f.values().iterator();
        while (it.hasNext()) {
            it.next().i();
        }
        if (this.f110982m != null && (view = this.C) != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f110982m);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        View view;
        if (this.f110982m != null && (view = this.C) != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f110982m);
        }
        this.C = null;
        this.F.a();
    }

    protected void J() {
        o();
    }

    protected void K(int i3) {
        boolean z16;
        boolean z17 = false;
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.G == 1 && i3 == 2) {
            z17 = true;
        }
        u(z16);
        t(this.G, i3);
        v(z17);
        this.G = i3;
        this.F.setDisplayMode(i3);
        this.F.setTopPadding(x());
    }

    protected int L(Rect rect) {
        update(rect.left, rect.top, rect.width(), rect.height(), true);
        return this.f110980h.a(this.C);
    }

    public void M() {
        int b16;
        GuildDialogGestureLayout guildDialogGestureLayout = this.F;
        if (guildDialogGestureLayout != null && this.C != null) {
            if (getHeight() > 0) {
                b16 = getHeight();
            } else {
                b16 = this.f110980h.b(this.C);
            }
            guildDialogGestureLayout.scrollTo(0, -b16);
        }
    }

    public void N(float f16) {
        Drawable background = getBackground();
        int i3 = ((int) ((f16 * 255.0f) + 0.5f)) % 256;
        if (background instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) background;
            colorDrawable.setColor((i3 << 24) | ((colorDrawable.getColor() << 8) >>> 8));
            return;
        }
        setBackgroundDrawable(new ColorDrawable(Color.argb(i3, 0, 0, 0)));
    }

    public void O(InterfaceC1190a interfaceC1190a) {
        this.f110981i = interfaceC1190a;
    }

    public void Q(View view) {
        if (view != null && this.H == 0) {
            if (view.getWindowToken() == null) {
                QLog.e("GuildDialog", 1, "showOn anchor window token is null");
                return;
            }
            this.H = 1;
            this.C = view;
            view.getViewTreeObserver().addOnGlobalLayoutListener(w());
            M();
            s();
            Rect f16 = this.f110980h.f(this.C);
            showAtLocation(this.C, 0, f16.left, f16.top);
            R(f16);
            this.H = 0;
            q();
        }
    }

    public void R(Rect rect) {
        if (this.C == null) {
            return;
        }
        this.J.set(rect);
        this.f110980h.g(true);
        K(L(rect));
        this.f110980h.g(false);
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.GuildDialogGestureLayout.c
    public void b() {
        InterfaceC1190a interfaceC1190a = this.f110981i;
        if (interfaceC1190a != null) {
            interfaceC1190a.b();
        }
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.GuildDialogGestureLayout.c
    public void c(int i3) {
        n(true);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        n(this.f110978e.f429113c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(e eVar) {
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: qo0.a
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a.this.D();
            }
        });
        this.F.setScrollListener(this);
        setBackgroundDrawable(new ColorDrawable(Color.argb(this.f110978e.f429119i, 0, 0, 0)));
        P(eVar);
        this.F.setOnClickListener(new View.OnClickListener() { // from class: qo0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a.this.E(view);
            }
        });
        this.E.setOnClickListener(new View.OnClickListener() { // from class: qo0.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a.F(view);
            }
        });
    }

    protected void k(Context context, e eVar) {
        this.F = (GuildDialogGestureLayout) getContentView();
        LinearLayout linearLayout = new LinearLayout(context);
        this.E = linearLayout;
        linearLayout.setOrientation(1);
        this.E.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.F.addView(this.E);
        Iterator<oo0.a> it = this.f110979f.values().iterator();
        while (it.hasNext()) {
            this.E.addView(it.next().c());
        }
        View view = new View(context);
        this.D = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(getWidth(), x()));
        this.E.addView(this.D);
    }

    public <T extends oo0.a> T l(Class<T> cls) {
        return (T) this.f110979f.get(cls);
    }

    protected abstract c m(e eVar);

    public void n(boolean z16) {
        I();
        if (!z16) {
            if (isShowing() && !C()) {
                this.H = 2;
                o();
                this.H = 0;
                p();
                return;
            }
            r(1);
            return;
        }
        if (B() && !C()) {
            J();
        }
    }

    protected void o() {
        super.dismiss();
    }

    public void p() {
        Iterator<oo0.a> it = this.f110979f.values().iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    public void q() {
        for (oo0.a aVar : this.f110979f.values()) {
            if (aVar.c().getVisibility() == 0) {
                aVar.g();
            }
        }
    }

    public void r(int i3) {
        InterfaceC1190a interfaceC1190a = this.f110981i;
        if (interfaceC1190a != null) {
            interfaceC1190a.H0(i3);
        }
    }

    @Override // android.widget.PopupWindow
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }

    protected void t(int i3, int i16) {
        if (this.H == 1) {
            e eVar = this.f110978e;
            if (eVar.f429112b) {
                this.F.z(0, eVar.f429117g);
                return;
            }
        }
        this.F.scrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(boolean z16) {
        ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, this.E.getHeight());
        }
        layoutParams.height = this.f110980h.c(z16, this.f110979f.values());
        this.E.setLayoutParams(layoutParams);
        this.E.setTranslationY(this.f110980h.d(z16, y(z16), getHeight()));
    }

    protected void v(boolean z16) {
        if (z16 && !this.I) {
            this.I = true;
            ViewParent parent = this.F.getRootView().getParent();
            try {
                try {
                    Method declaredMethod = parent.getClass().getDeclaredMethod("doTraversal", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(parent, new Object[0]);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
                    QLog.e("GuildDialog", 1, "doTraversalManually | " + e16.getMessage());
                }
            } finally {
                this.I = false;
            }
        }
    }

    protected ViewTreeObserver.OnGlobalLayoutListener w() {
        if (this.f110982m == null) {
            this.f110982m = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: qo0.d
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a.this.G();
                }
            };
        }
        return this.f110982m;
    }

    protected abstract int x();

    public abstract int y(boolean z16);

    public void z() {
        k(this.f110977d, this.f110978e);
        i(this.f110978e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context context, GuildDialogGestureLayout guildDialogGestureLayout, e eVar, Object[] objArr) {
        super(guildDialogGestureLayout, -1, -1);
        this.f110979f = new LinkedHashMap();
        this.G = 0;
        this.H = 0;
        this.I = false;
        this.J = new Rect();
        this.f110977d = context;
        this.f110978e = eVar;
        j(objArr);
        this.f110980h = m(eVar);
        oo0.a[] A = A(context);
        for (int i3 = 0; i3 < A.length; i3++) {
            this.f110979f.put(A[i3].getClass(), A[i3]);
        }
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.GuildDialogGestureLayout.c
    public void d(boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(Object[] objArr) {
    }
}
