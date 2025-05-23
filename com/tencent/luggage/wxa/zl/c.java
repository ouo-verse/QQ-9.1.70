package com.tencent.luggage.wxa.zl;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.g0;
import com.tencent.luggage.wxa.uk.t;
import com.tencent.mobileqq.R;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class c extends FrameLayout {
    public Runnable C;
    public final CopyOnWriteArrayList D;
    public j E;
    public t F;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.zf.c f146733a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f146734b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f146735c;

    /* renamed from: d, reason: collision with root package name */
    public View f146736d;

    /* renamed from: e, reason: collision with root package name */
    public View f146737e;

    /* renamed from: f, reason: collision with root package name */
    public View f146738f;

    /* renamed from: g, reason: collision with root package name */
    public i f146739g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f146740h;

    /* renamed from: i, reason: collision with root package name */
    public View f146741i;

    /* renamed from: j, reason: collision with root package name */
    public View f146742j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f146743k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f146744l;

    /* renamed from: m, reason: collision with root package name */
    public int f146745m;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.zl.c$c, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class ViewOnLayoutChangeListenerC6991c implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC6991c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            c.this.b();
            c.this.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object currentValue;
            c cVar = c.this;
            if (cVar.f146733a == null) {
                currentValue = null;
            } else {
                currentValue = c.this.f146733a.currentValue();
            }
            cVar.a(true, currentValue);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a(false, (Object) null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f146741i.setBackground(ContextCompat.getDrawable(c.this.getContext(), R.drawable.j_q));
            c cVar = c.this;
            cVar.f146735c.setTextColor(ContextCompat.getColor(cVar.getContext(), R.color.f156614aj0));
            c cVar2 = c.this;
            cVar2.f146737e.setBackgroundColor(ContextCompat.getColor(cVar2.getContext(), R.color.ah_));
            ((Button) c.this.f146737e.findViewById(R.id.tbv)).setTextColor(ContextCompat.getColor(c.this.getContext(), R.color.bdm));
            ((Button) c.this.f146737e.findViewById(R.id.tbv)).setBackground(ContextCompat.getDrawable(c.this.getContext(), R.drawable.jeg));
            ((Button) c.this.f146737e.findViewById(R.id.tbu)).setTextColor(ContextCompat.getColor(c.this.getContext(), R.color.cyu));
            ((Button) c.this.f146737e.findViewById(R.id.tbu)).setBackground(ContextCompat.getDrawable(c.this.getContext(), R.drawable.jeo));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface i {
        void onResult(boolean z16, Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface j {
        void a(Object obj);
    }

    public c(Context context) {
        super(context);
        this.D = new CopyOnWriteArrayList();
        this.F = null;
        f();
    }

    public final void f() {
        this.f146745m = getResources().getConfiguration().uiMode;
        setClickable(true);
        setLongClickable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dy8, (ViewGroup) this, false);
        this.f146741i = inflate;
        this.f146734b = (FrameLayout) inflate.findViewById(R.id.sru);
        this.f146742j = this.f146741i.findViewById(R.id.srs);
        b(this.f146741i);
        a(this.f146741i);
        addView(this.f146741i, layoutParams);
        TextView textView = (TextView) findViewById(R.id.srr);
        this.f146735c = textView;
        textView.setClickable(true);
        this.f146736d = findViewById(R.id.srq);
        addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC6991c());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i3) {
        View focusSearch = super.focusSearch(view, i3);
        if (com.tencent.luggage.wxa.wl.b.a(this, focusSearch)) {
            return focusSearch;
        }
        return null;
    }

    public final boolean g() {
        if (g0.LANDSCAPE == i().a()) {
            return true;
        }
        return false;
    }

    public com.tencent.luggage.wxa.zf.c getPicker() {
        return this.f146733a;
    }

    public final void h() {
        setBackgroundResource(R.color.ajr);
        clearAnimation();
        a(8);
        requestLayout();
        this.f146744l = false;
    }

    public final t i() {
        if (this.F == null) {
            w.f("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "requireOrientationGetter, orientationGetter is null, use AndroidOrientationGetter as fallback");
            this.F = com.tencent.luggage.wxa.uk.e.f142670b.a(null);
        }
        return this.F;
    }

    public void j() {
        if (this.f146744l) {
            clearAnimation();
            this.f146744l = false;
        }
        if (this.f146743k) {
            return;
        }
        if (this.f146733a == null) {
            setVisibility(8);
            return;
        }
        Runnable runnable = this.C;
        if (runnable != null) {
            runnable.run();
            this.C = null;
        }
        Iterator it = this.D.iterator();
        while (it.hasNext()) {
            ((com.tencent.luggage.wxa.zl.d) it.next()).a(true, this.f146733a.getView());
        }
        this.f146733a.onShow(this);
        clearAnimation();
        setVisibility(0);
        this.f146743k = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154487lx);
        this.f146741i.startAnimation(loadAnimation);
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154485lv));
        loadAnimation.setAnimationListener(new a());
    }

    public final void k() {
        a();
        this.f146742j.setVisibility(0);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.uiMode != this.f146745m && this.C == null) {
            this.C = new h();
        }
        this.f146745m = configuration.uiMode;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
        removeAllViews();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        if (!isShown()) {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
        }
    }

    @CallSuper
    public void setHeader(String str) {
        if (w0.c(str)) {
            e();
        } else {
            b(a(str));
        }
    }

    public void setOnResultListener(i iVar) {
        this.f146739g = iVar;
    }

    public void setOnValueUpdateListener(j jVar) {
        this.E = jVar;
    }

    public void setOrientationGetter(@NonNull t tVar) {
        w.a("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "setOrientationGetter, orientationGetter is " + tVar.getName());
        this.F = tVar;
    }

    public void setPickerImpl(com.tencent.luggage.wxa.zf.c cVar) {
        com.tencent.luggage.wxa.zf.c cVar2;
        com.tencent.luggage.wxa.zf.c cVar3 = this.f146733a;
        if (cVar3 != null) {
            cVar3.onDetach(this);
        }
        this.f146733a = cVar;
        if (cVar != null) {
            cVar.onAttach(this);
        }
        if (this.f146734b != null && (cVar2 = this.f146733a) != null && cVar2.getView() != null) {
            this.f146734b.removeAllViews();
            c();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f146734b.addView(this.f146733a.getView(), layoutParams);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (i3 != 0) {
            a(false);
        } else {
            super.setVisibility(i3);
        }
    }

    public final void b(View view) {
        View findViewById = view.findViewById(R.id.f25250ab);
        this.f146737e = findViewById;
        this.f146738f = findViewById.findViewById(R.id.f11838740);
        b();
        this.f146737e.findViewById(R.id.tbv).setOnClickListener(new d());
        this.f146737e.findViewById(R.id.tbu).setOnClickListener(new e());
        this.f146737e.setOnClickListener(new f());
    }

    public final void c() {
        this.f146739g = null;
        this.E = null;
    }

    public void d() {
        a(true);
    }

    public final void e() {
        k();
        this.f146735c.setText("");
        this.f146736d.setVisibility(8);
        this.f146735c.setVisibility(8);
    }

    public final void a(boolean z16, Object obj) {
        i iVar;
        if (this.f146740h || (iVar = this.f146739g) == null) {
            return;
        }
        this.f146740h = true;
        iVar.onResult(z16, obj);
        this.f146740h = false;
    }

    public final void a(int i3) {
        super.setVisibility(i3);
    }

    public void a(boolean z16) {
        if (this.f146743k) {
            clearAnimation();
            this.f146743k = false;
        }
        if (this.f146744l || getVisibility() != 0) {
            return;
        }
        a(false, (Object) null);
        if (this.f146733a != null) {
            Iterator it = this.D.iterator();
            while (it.hasNext()) {
                ((com.tencent.luggage.wxa.zl.d) it.next()).a(false, this.f146733a.getView());
            }
            this.f146733a.onHide(this);
            if (!z16) {
                h();
                return;
            }
            this.f146744l = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154751r8);
            this.f146741i.startAnimation(loadAnimation);
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154486lw));
            loadAnimation.setAnimationListener(new b());
        }
    }

    public final void b(String str) {
        this.f146742j.setVisibility(8);
        this.f146736d.setVisibility(0);
        this.f146735c.setVisibility(0);
        this.f146735c.setText(str);
    }

    public final void b() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int dimensionPixelSize3;
        if (g()) {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.bht);
            dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.bht);
            dimensionPixelSize3 = getContext().getResources().getDimensionPixelSize(R.dimen.f159278cy1);
        } else {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.bil);
            dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.bif);
            dimensionPixelSize3 = getContext().getResources().getDimensionPixelSize(R.dimen.f159279cy2);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f146738f.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelSize;
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = dimensionPixelSize2;
        this.f146738f.setLayoutParams(layoutParams);
        this.f146737e.setLayoutParams(new LinearLayout.LayoutParams(-1, dimensionPixelSize3));
    }

    public final void a(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.setBackgroundResource(R.color.c8k);
            c.this.f146743k = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public final void a(View view) {
        View findViewById = view.findViewById(R.id.sru);
        findViewById.setOnClickListener(new g());
        findViewById.setBackgroundColor(ContextCompat.getColor(findViewById.getContext(), R.color.ah_));
    }

    public final String a(String str) {
        if ("\u8bbe\u7f6e\u65f6\u95f4".equals(str)) {
            return getContext().getString(R.string.z0u);
        }
        if ("\u8bbe\u7f6e\u5730\u533a".equals(str)) {
            return getContext().getString(R.string.z0t);
        }
        if ("\u8bbe\u7f6e\u65e5\u671f".equals(str)) {
            return getContext().getString(R.string.z0s);
        }
        return str == null ? "" : str;
    }

    public final void a(Object obj) {
        j jVar = this.E;
        if (jVar != null) {
            jVar.a(obj);
        }
    }

    public final void a() {
        int dimensionPixelSize = g() ? 0 : getContext().getResources().getDimensionPixelSize(R.dimen.bi8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f146742j.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        this.f146742j.setLayoutParams(layoutParams);
    }

    public void a(com.tencent.luggage.wxa.zl.d dVar) {
        this.D.add(dVar);
    }
}
