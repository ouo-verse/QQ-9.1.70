package com.tencent.qqnt.chathistory.ui.file.c2c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes23.dex */
final class StickyHeaderPositioner {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final RecyclerView f353523a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f353524b;

    /* renamed from: c, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f353525c;

    /* renamed from: d, reason: collision with root package name */
    private View f353526d;

    /* renamed from: e, reason: collision with root package name */
    private int f353527e;

    /* renamed from: f, reason: collision with root package name */
    private List<Integer> f353528f;

    /* renamed from: g, reason: collision with root package name */
    private int f353529g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f353530h;

    /* renamed from: i, reason: collision with root package name */
    private float f353531i;

    /* renamed from: j, reason: collision with root package name */
    private int f353532j;

    /* renamed from: k, reason: collision with root package name */
    private RecyclerView.ViewHolder f353533k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private n f353534l;

    /* renamed from: m, reason: collision with root package name */
    private int f353535m;

    /* loaded from: classes23.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StickyHeaderPositioner.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int visibility = StickyHeaderPositioner.this.f353523a.getVisibility();
            if (StickyHeaderPositioner.this.f353526d != null) {
                StickyHeaderPositioner.this.f353526d.setVisibility(visibility);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f353538d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f353539e;

        b(View view) {
            this.f353539e = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StickyHeaderPositioner.this, (Object) view);
            } else {
                this.f353538d = StickyHeaderPositioner.this.r();
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f353539e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (StickyHeaderPositioner.this.f353526d != null) {
                int r16 = StickyHeaderPositioner.this.r();
                if (StickyHeaderPositioner.this.x() && (i3 = this.f353538d) != r16) {
                    StickyHeaderPositioner.this.P(i3 - r16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f353541d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map f353542e;

        c(View view, Map map) {
            this.f353541d = view;
            this.f353542e = map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, StickyHeaderPositioner.this, view, map);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f353541d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (StickyHeaderPositioner.this.f353526d == null) {
                return;
            }
            StickyHeaderPositioner.this.v().requestLayout();
            StickyHeaderPositioner.this.n(this.f353542e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StickyHeaderPositioner(RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView);
            return;
        }
        this.f353525c = new a();
        this.f353527e = -1;
        this.f353531i = -1.0f;
        this.f353532j = -1;
        this.f353535m = View.generateViewId();
        this.f353523a = recyclerView;
        this.f353524b = D();
        A();
    }

    private void A() {
        View findViewById = v().findViewById(this.f353535m);
        if (findViewById != null) {
            v().removeView(findViewById);
        }
        this.f353526d = null;
    }

    private float B(View view) {
        if (M(view)) {
            if (this.f353529g == 1) {
                float f16 = -(this.f353526d.getHeight() - view.getY());
                this.f353526d.setTranslationY(f16);
                return f16;
            }
            float f17 = -(this.f353526d.getWidth() - view.getX());
            this.f353526d.setTranslationX(f17);
            return f17;
        }
        return -1.0f;
    }

    private float C(Context context, int i3) {
        return i3 * context.getResources().getDisplayMetrics().density;
    }

    private boolean D() {
        if (this.f353523a.getPaddingLeft() <= 0 && this.f353523a.getPaddingRight() <= 0 && this.f353523a.getPaddingTop() <= 0) {
            return false;
        }
        return true;
    }

    private void F() {
        if (this.f353529g == 1) {
            this.f353526d.setTranslationY(0.0f);
        } else {
            this.f353526d.setTranslationX(0.0f);
        }
    }

    private void G(Context context) {
        int i3 = this.f353532j;
        if (i3 != -1 && this.f353531i == -1.0f) {
            this.f353531i = C(context, i3);
        }
    }

    private void H() {
        v().post(new Runnable(this.f353527e) { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.StickyHeaderPositioner.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f353536d;

            {
                this.f353536d = r5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) StickyHeaderPositioner.this, r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (StickyHeaderPositioner.this.f353530h) {
                    StickyHeaderPositioner.this.s(this.f353536d);
                }
            }
        });
    }

    private void L() {
        if (this.f353526d.getTag() != null) {
            this.f353526d.setTag(null);
            this.f353526d.animate().z(0.0f);
        }
    }

    private boolean M(View view) {
        if (this.f353529g == 1) {
            if (view.getY() >= this.f353526d.getHeight()) {
                return false;
            }
            return true;
        }
        if (view.getX() >= this.f353526d.getWidth()) {
            return false;
        }
        return true;
    }

    private void O(View view) {
        z((ViewGroup.MarginLayoutParams) view.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i3) {
        View view = this.f353526d;
        if (view == null) {
            return;
        }
        if (this.f353529g == 1) {
            view.setTranslationY(view.getTranslationY() + i3);
        } else {
            view.setTranslationX(view.getTranslationX() + i3);
        }
    }

    private void Q(Map<Integer, View> map) {
        View view = this.f353526d;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new c(view, map));
    }

    private void k(int i3) {
        n nVar = this.f353534l;
        if (nVar != null) {
            nVar.a(this.f353526d, i3);
        }
    }

    private void l(int i3) {
        n nVar = this.f353534l;
        if (nVar != null) {
            nVar.b(this.f353526d, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        View view;
        if (this.f353531i != -1.0f && (view = this.f353526d) != null) {
            if ((this.f353529g == 1 && view.getTranslationY() == 0.0f) || (this.f353529g == 0 && this.f353526d.getTranslationX() == 0.0f)) {
                t();
            } else {
                L();
            }
        }
    }

    private void o() {
        View view = this.f353526d;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new b(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int r() {
        View view = this.f353526d;
        if (view == null) {
            return 0;
        }
        if (this.f353529g == 1) {
            return view.getHeight();
        }
        return view.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i3) {
        if (this.f353526d != null) {
            v().removeView(this.f353526d);
            l(i3);
            q();
            this.f353526d = null;
            this.f353533k = null;
        }
    }

    private void t() {
        if (this.f353526d.getTag() != null) {
            return;
        }
        this.f353526d.setTag(Boolean.TRUE);
        this.f353526d.animate().z(this.f353531i);
    }

    private int u(int i3, @Nullable View view) {
        int indexOf;
        if (y(view) && (indexOf = this.f353528f.indexOf(Integer.valueOf(i3))) > 0) {
            return this.f353528f.get(indexOf - 1).intValue();
        }
        int i16 = -1;
        for (Integer num : this.f353528f) {
            if (num.intValue() > i3) {
                break;
            }
            i16 = num.intValue();
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup v() {
        return (ViewGroup) this.f353523a.getParent();
    }

    private boolean w(View view) {
        if (view == null) {
            return false;
        }
        if (this.f353529g == 1) {
            if (view.getY() <= 0.0f) {
                return false;
            }
        } else if (view.getX() <= 0.0f) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        View view = this.f353526d;
        if (view == null) {
            return false;
        }
        if (this.f353529g == 1) {
            if (view.getTranslationY() >= 0.0f) {
                return false;
            }
            return true;
        }
        if (view.getTranslationX() >= 0.0f) {
            return false;
        }
        return true;
    }

    private boolean y(View view) {
        if (view == null) {
            return false;
        }
        if (this.f353529g == 1) {
            if (view.getY() <= 0.0f) {
                return false;
            }
        } else if (view.getX() <= 0.0f) {
            return false;
        }
        return true;
    }

    private void z(ViewGroup.MarginLayoutParams marginLayoutParams) {
        int i3;
        int paddingTop;
        int i16;
        if (this.f353529g == 1) {
            i3 = this.f353523a.getPaddingLeft();
        } else {
            i3 = 0;
        }
        if (this.f353529g == 1) {
            paddingTop = 0;
        } else {
            paddingTop = this.f353523a.getPaddingTop();
        }
        if (this.f353529g == 1) {
            i16 = this.f353523a.getPaddingRight();
        } else {
            i16 = 0;
        }
        marginLayoutParams.setMargins(i3, paddingTop, i16, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int i3) {
        this.f353529g = i3;
        this.f353527e = -1;
        this.f353530h = true;
        H();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i3) {
        if (i3 != -1) {
            this.f353532j = i3;
        } else {
            this.f353531i = -1.0f;
            this.f353532j = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(List<Integer> list) {
        this.f353528f = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(@Nullable n nVar) {
        this.f353534l = nVar;
        View view = this.f353526d;
        if (view != null && nVar != null) {
            nVar.a(view, this.f353527e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(int i3, Map<Integer, View> map, p pVar, boolean z16) {
        int u16;
        if (z16) {
            u16 = -1;
        } else {
            u16 = u(i3, map.get(Integer.valueOf(i3)));
        }
        View view = map.get(Integer.valueOf(u16));
        if (u16 != this.f353527e) {
            if (u16 != -1 && (!this.f353524b || !w(view))) {
                this.f353527e = u16;
                j(pVar.a(u16), u16);
            } else {
                this.f353530h = true;
                H();
                this.f353527e = -1;
            }
        } else if (this.f353524b && w(view)) {
            s(this.f353527e);
            this.f353527e = -1;
        }
        n(map);
        this.f353523a.post(new Runnable() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.StickyHeaderPositioner.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) StickyHeaderPositioner.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    StickyHeaderPositioner.this.m();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @VisibleForTesting
    void j(RecyclerView.ViewHolder viewHolder, int i3) {
        if (this.f353533k == viewHolder) {
            l(this.f353527e);
            this.f353523a.getAdapter().onBindViewHolder(this.f353533k, i3);
            this.f353533k.itemView.requestLayout();
            o();
            k(i3);
            this.f353530h = false;
            return;
        }
        s(this.f353527e);
        this.f353533k = viewHolder;
        this.f353523a.getAdapter().onBindViewHolder(this.f353533k, i3);
        this.f353526d = this.f353533k.itemView;
        k(i3);
        G(this.f353526d.getContext());
        this.f353526d.setVisibility(4);
        this.f353526d.setId(this.f353535m);
        this.f353523a.getViewTreeObserver().addOnGlobalLayoutListener(this.f353525c);
        v().addView(this.f353526d);
        if (this.f353524b) {
            O(this.f353526d);
        }
        this.f353530h = false;
    }

    void n(Map<Integer, View> map) {
        boolean z16;
        View view = this.f353526d;
        if (view == null) {
            return;
        }
        if (view.getHeight() == 0) {
            this.f353526d.setVisibility(0);
            Q(map);
            return;
        }
        Iterator<Map.Entry<Integer, View>> it = map.entrySet().iterator();
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, View> next = it.next();
            if (next.getKey().intValue() > this.f353527e) {
                if (B(next.getValue()) != -1.0f) {
                    z16 = false;
                }
            }
        }
        if (z16) {
            F();
        }
        this.f353526d.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        s(this.f353527e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f353523a.getViewTreeObserver().removeOnGlobalLayoutListener(this.f353525c);
    }
}
