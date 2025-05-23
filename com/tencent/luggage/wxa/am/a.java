package com.tencent.luggage.wxa.am;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.l0;
import com.tencent.luggage.wxa.xd.m;
import com.tencent.mobileqq.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.commons.lang.ArrayUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final v f121556a;

    /* renamed from: b, reason: collision with root package name */
    public b f121557b;

    /* renamed from: c, reason: collision with root package name */
    public final b0 f121558c = new b0(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    public int f121559d;

    /* renamed from: e, reason: collision with root package name */
    public View f121560e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends FrameLayout {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f121562a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f121563b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f121564c;

        public b(Context context) {
            super(context);
            this.f121562a = new Rect();
            this.f121563b = new int[2];
            this.f121564c = false;
            setWillNotDraw(true);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup
        public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) super.generateLayoutParams(layoutParams);
            if (-1 == layoutParams2.gravity) {
                layoutParams2.gravity = 17;
            }
            return layoutParams2;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.f121564c = false;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.f121564c = true;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
            super.onLayout(z16, i3, i16, i17, i18);
            if (!ViewCompat.isAttachedToWindow(this)) {
                return;
            }
            getWindowVisibleDisplayFrame(this.f121562a);
            getLocationInWindow(this.f121563b);
            if (w.d() <= 1) {
                w.a("MicroMsg.PagePromptViewContainerLayout[keyboard]", "onLayout, WindowVisibleDisplayFrame=%s, location=%s", this.f121562a, ArrayUtils.toString(this.f121563b));
            }
            for (int i19 = 0; i19 < getChildCount(); i19++) {
                View childAt = getChildAt(i19);
                int top = ((this.f121563b[1] + childAt.getTop()) + childAt.getHeight()) - this.f121562a.bottom;
                if (top > 0) {
                    int max = Math.max(0, childAt.getTop() - top);
                    childAt.layout(childAt.getLeft(), max, childAt.getRight(), childAt.getHeight() + max);
                }
            }
        }

        @Override // android.view.ViewGroup
        public void onViewAdded(View view) {
            super.onViewAdded(view);
            bringToFront();
            bringChildToFront(view);
        }

        @Override // android.view.ViewGroup
        public void onViewRemoved(View view) {
            super.onViewRemoved(view);
            if (getChildCount() == 0) {
                setVisibility(8);
                if (getParent() instanceof ViewGroup) {
                    ((ViewGroup) getParent()).removeView(this);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements m {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedList f121565a = new LinkedList();

        public boolean a() {
            boolean z16 = false;
            while (!this.f121565a.isEmpty()) {
                z16 |= ((v) this.f121565a.poll()).u0().d();
            }
            return z16;
        }

        public static c a(g gVar, boolean z16) {
            c cVar = (c) gVar.c(c.class);
            if (cVar != null || !z16) {
                return cVar;
            }
            c cVar2 = new c();
            gVar.a((m) cVar2);
            return cVar2;
        }
    }

    public a(v vVar) {
        this.f121556a = vVar;
    }

    public final b b() {
        b bVar = this.f121557b;
        if (bVar != null && !bVar.f121564c) {
            return this.f121557b;
        }
        this.f121557b = null;
        ViewGroup f16 = this.f121556a.getCustomViewContainer().f();
        if (f16 == null) {
            return null;
        }
        for (int i3 = 0; i3 < f16.getChildCount(); i3++) {
            View childAt = f16.getChildAt(i3);
            if (childAt instanceof b) {
                return (b) childAt;
            }
        }
        return null;
    }

    public View c() {
        return this.f121560e;
    }

    public boolean d() {
        return a(false);
    }

    public final b e() {
        ViewGroup e16 = this.f121556a.getCustomViewContainer().e();
        b b16 = b();
        if (b16 == null) {
            b16 = new b(com.tencent.luggage.wxa.ye.c.a(this.f121556a.getContext()));
            b16.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC6021a());
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
            marginLayoutParams.topMargin = this.f121559d;
            e16.addView(b16, marginLayoutParams);
        }
        b16.bringToFront();
        this.f121557b = b16;
        return b16;
    }

    public final void f() {
        this.f121560e = null;
    }

    public final void g() {
        com.tencent.luggage.wxa.kl.b W = this.f121556a.W();
        if (W == null) {
            return;
        }
        a(W.getTop() + W.getMeasuredHeight());
    }

    public static boolean a(g gVar) {
        if (gVar == null) {
            return false;
        }
        a();
        c cVar = (c) gVar.c(c.class);
        if (cVar != null) {
            return cVar.a();
        }
        return false;
    }

    public void a(int i3) {
        this.f121559d = i3;
        b b16 = b();
        if (b16 == null || !(b16.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) b16.getLayoutParams();
        if (i3 != marginLayoutParams.topMargin) {
            marginLayoutParams.topMargin = i3;
            b16.requestLayout();
        }
    }

    public void a(View view, long j3) {
        if (!this.f121556a.isRunning() || this.f121556a.getRuntime() == null) {
            return;
        }
        this.f121560e = view;
        a();
        b e16 = e();
        g();
        view.setTag(R.id.ssz, Boolean.TRUE);
        e16.addView(view);
        if (j3 < 0) {
            j3 = 0;
        }
        this.f121558c.a(new d(view), j3);
        c a16 = c.a(this.f121556a.getRuntime(), true);
        Objects.requireNonNull(a16);
        a16.f121565a.add(this.f121556a);
    }

    public boolean a(boolean z16) {
        boolean z17;
        c a16;
        c a17;
        if (!this.f121556a.isRunning()) {
            if (z16 && this.f121556a.getRuntime() != null && (a17 = c.a(this.f121556a.getRuntime(), false)) != null) {
                a17.f121565a.remove(this.f121556a);
            }
            if (z16) {
                this.f121558c.a((Object) null);
            }
            f();
            return false;
        }
        a();
        b bVar = this.f121557b;
        if (bVar == null || !ViewCompat.isAttachedToWindow(bVar)) {
            z17 = false;
        } else {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < bVar.getChildCount(); i3++) {
                View childAt = bVar.getChildAt(i3);
                if (childAt != null && Objects.equals(childAt.getTag(R.id.ssz), Boolean.TRUE)) {
                    linkedList.add(childAt);
                }
            }
            z17 = !linkedList.isEmpty();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                View view = (View) it.next();
                view.setVisibility(8);
                bVar.removeView(view);
            }
        }
        if (z16 && this.f121556a.getRuntime() != null && (a16 = c.a(this.f121556a.getRuntime(), false)) != null) {
            a16.f121565a.remove(this.f121556a);
        }
        if (z16) {
            this.f121558c.a((Object) null);
        }
        f();
        return z17;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.am.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnAttachStateChangeListenerC6021a implements View.OnAttachStateChangeListener {
        public ViewOnAttachStateChangeListenerC6021a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (view == a.this.f121557b) {
                a.this.f121557b = null;
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public View f121566a;

        public d(View view) {
            this.f121566a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f121566a;
            if (view == null) {
                return;
            }
            try {
                view.setVisibility(8);
                if (this.f121566a.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f121566a.getParent()).removeView(this.f121566a);
                }
            } finally {
                this.f121566a = null;
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static void a() {
        if (!l0.a()) {
            throw new RuntimeException("Should be called on main-thread");
        }
    }
}
