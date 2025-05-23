package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.ol.a1;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e0 extends LinearLayout implements r0 {

    /* renamed from: h, reason: collision with root package name */
    public static final a f136703h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final int f136704i = R.id.sr6;

    /* renamed from: a, reason: collision with root package name */
    public final int f136705a;

    /* renamed from: b, reason: collision with root package name */
    public final String f136706b;

    /* renamed from: c, reason: collision with root package name */
    public View f136707c;

    /* renamed from: d, reason: collision with root package name */
    public final d0 f136708d;

    /* renamed from: e, reason: collision with root package name */
    public EditText f136709e;

    /* renamed from: f, reason: collision with root package name */
    public b f136710f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f136711g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e0 a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return (e0) view.getRootView().findViewById(e0.f136704i);
        }

        public final e0 a(View view, boolean z16, com.tencent.luggage.wxa.fi.a aVar) {
            Intrinsics.checkNotNullParameter(view, "view");
            e0 a16 = a(view);
            if (a16 != null) {
                a16.a(z16, aVar);
                return a16;
            }
            q b16 = q.b(view);
            if (b16 == null) {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.AppBrandSecureKeyboardPanel", "settleKeyboardPanel, rootFrameLayout is null");
                return null;
            }
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            e0 e0Var = new e0(context, z16, aVar);
            b16.a((View) e0Var, false);
            return e0Var;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(Context context, boolean z16, com.tencent.luggage.wxa.fi.a aVar) {
        super(context);
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(context, "context");
        int hashCode = hashCode();
        this.f136705a = hashCode;
        String str = "MicroMsg.AppBrand.AppBrandSecureKeyboardPanel#" + hashCode;
        this.f136706b = str;
        d0 d0Var = new d0(context);
        this.f136708d = d0Var;
        com.tencent.luggage.wxa.tn.w.a(str, "init");
        super.setId(f136704i);
        setOrientation(1);
        setBackgroundColor(-1);
        if (z16 && aVar != null) {
            ViewParent parent = aVar.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(aVar);
            }
            addView(aVar);
            this.f136707c = aVar;
        }
        addView(d0Var, new LinearLayout.LayoutParams(-1, -2));
    }

    public final void a(EditText editText) {
        com.tencent.luggage.wxa.tn.w.a(this.f136706b, "show");
        if (editText == null) {
            com.tencent.luggage.wxa.tn.w.d(this.f136706b, "show, inputWidget is null");
            return;
        }
        if (!Intrinsics.areEqual(editText, this.f136709e)) {
            j();
        }
        setInputWidget(editText);
        setVisibility(0);
    }

    @Override // com.tencent.luggage.wxa.ol.r0
    public boolean e() {
        boolean isLaidOut = ViewCompat.isLaidOut(this);
        com.tencent.luggage.wxa.tn.w.a(this.f136706b, "isRealHeightSettled, settled: " + isLaidOut);
        return isLaidOut;
    }

    public final void g() {
        com.tencent.luggage.wxa.tn.w.a(this.f136706b, "forceLightMode");
        this.f136708d.a();
    }

    @Nullable
    public final EditText getAttachedInputWidget() {
        com.tencent.luggage.wxa.tn.w.a(this.f136706b, "getAttachedInputWidget, inputWidget: " + this.f136709e);
        return this.f136709e;
    }

    public final void h() {
        com.tencent.luggage.wxa.tn.w.a(this.f136706b, "hide");
        setVisibility(8);
        j();
    }

    public final void i() {
        com.tencent.luggage.wxa.tn.w.a(this.f136706b, "performOnDone");
        if (this.f136711g) {
            com.tencent.luggage.wxa.tn.w.d(this.f136706b, "performOnDone, performingOnDone");
            return;
        }
        this.f136711g = true;
        b bVar = this.f136710f;
        if (bVar != null) {
            bVar.a();
        }
        this.f136711g = false;
    }

    public final void j() {
        com.tencent.luggage.wxa.tn.w.a(this.f136706b, "resetFocusStatus");
        EditText editText = this.f136709e;
        if (editText != null) {
            editText.clearFocus();
            this.f136709e = null;
            this.f136710f = null;
            this.f136711g = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.tencent.luggage.wxa.tn.w.a(this.f136706b, NodeProps.ON_DETACHED_FROM_WINDOW);
        super.onDetachedFromWindow();
        removeAllViews();
    }

    public final void setInputWidget(@Nullable EditText editText) {
        com.tencent.luggage.wxa.tn.w.a(this.f136706b, "setInputWidget, inputWidget: " + editText);
        this.f136709e = editText;
        this.f136708d.setInputEditText(editText);
        a1.a.b(editText);
        a1.a.a(editText);
        if (editText != null) {
            editText.requestFocus();
        }
    }

    public final void setOnDoneListener(@Nullable b bVar) {
        com.tencent.luggage.wxa.tn.w.a(this.f136706b, "setOnDoneListener, onDoneListener: " + bVar);
        this.f136710f = bVar;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        int visibility = getVisibility();
        com.tencent.luggage.wxa.tn.w.a(this.f136706b, "setVisibility, visibility: " + i3 + ", curVisibility: " + visibility);
        if (i3 == visibility && (visibility == 0 || 8 == visibility)) {
            com.tencent.luggage.wxa.tn.w.d(this.f136706b, "setVisibility, same visibility");
        } else if (i3 != 0) {
            super.setVisibility(8);
            i();
        } else {
            super.setVisibility(i3);
        }
    }

    @Override // android.view.View
    public String toString() {
        return "AppBrandSecureKeyboardPanel#" + this.f136705a;
    }

    public final void a(boolean z16, com.tencent.luggage.wxa.fi.a aVar) {
        if (z16) {
            View view = this.f136707c;
            if (view != null) {
                ViewParent parent = view.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            }
            if (aVar != null) {
                ViewParent parent2 = aVar.getParent();
                ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
                if (viewGroup2 != null) {
                    viewGroup2.removeView(aVar);
                }
                addView(aVar, 0);
            }
            this.f136707c = aVar;
            return;
        }
        View view2 = this.f136707c;
        if (view2 != null && Intrinsics.areEqual(this, view2.getParent())) {
            removeView(view2);
        }
        this.f136707c = null;
    }

    @Override // android.view.View
    public void setId(int i3) {
    }
}
