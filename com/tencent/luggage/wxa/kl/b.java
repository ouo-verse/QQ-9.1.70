package com.tencent.luggage.wxa.kl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import c31.j;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.luggage.wxa.so.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.o0;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.ui.SimplifiedLoadingProgressBar;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mobileqq.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends FrameLayout implements i, i.a, g.d, g.b {
    public int C;
    public double D;
    public boolean E;
    public boolean F;
    public final com.tencent.luggage.wxa.kl.c G;
    public e H;
    public AppBrandCapsuleBarPlaceHolderView I;
    public c J;
    public g K;
    public View.OnLongClickListener L;
    public boolean M;
    public final Set N;
    public final View.OnClickListener O;
    public AppBrandActionBarCustomImageView P;
    public final Runnable Q;

    /* renamed from: a, reason: collision with root package name */
    public final String f132610a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.vo.c f132611b;

    /* renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f132612c;

    /* renamed from: d, reason: collision with root package name */
    public int f132613d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.so.c f132614e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.so.c f132615f;

    /* renamed from: g, reason: collision with root package name */
    public View f132616g;

    /* renamed from: h, reason: collision with root package name */
    public View f132617h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f132618i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f132619j;

    /* renamed from: k, reason: collision with root package name */
    public View f132620k;

    /* renamed from: l, reason: collision with root package name */
    public CircleProgressDrawable f132621l;

    /* renamed from: m, reason: collision with root package name */
    public int f132622m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public long f132623a = 0;

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - this.f132623a < 250) {
                Iterator it = b.this.N.iterator();
                while (it.hasNext()) {
                    ((com.tencent.luggage.wxa.kl.a) it.next()).a(b.this);
                }
                this.f132623a = 0L;
            }
            this.f132623a = System.currentTimeMillis();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kl.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6398b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f132625a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f132626b;

        public RunnableC6398b(Bitmap bitmap, View.OnClickListener onClickListener) {
            this.f132625a = bitmap;
            this.f132626b = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.getParent() == null) {
                return;
            }
            if (b.this.P == null) {
                ViewStub viewStub = (ViewStub) b.this.findViewById(R.id.uct);
                if (viewStub == null) {
                    return;
                }
                b.this.P = (AppBrandActionBarCustomImageView) viewStub.inflate();
            }
            b.this.P.setVisibility(0);
            b.this.P.setImageBitmap(this.f132625a);
            b.this.P.setClickable(true);
            b.this.P.setOnClickListener(this.f132626b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final int f132628a = 2131166300;

        int a();

        void a(b bVar, com.tencent.luggage.wxa.so.c cVar, com.tencent.luggage.wxa.so.c cVar2, View view);

        boolean a(View view);

        boolean b(View view);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d implements com.tencent.luggage.wxa.sn.a {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f132629a;

        public d(b bVar) {
            this.f132629a = new WeakReference(bVar);
        }

        @Override // com.tencent.luggage.wxa.sn.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            b bVar = (b) this.f132629a.get();
            if (bVar != null) {
                bVar.a(bool.booleanValue(), bVar.getMainTitle());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e extends i.a {
        void a(int i3);

        void a(View.OnClickListener onClickListener);

        void b(View.OnClickListener onClickListener);

        void c(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements c {
        public f() {
        }

        @Override // com.tencent.luggage.wxa.kl.b.c
        public /* synthetic */ int a() {
            return j.a(this);
        }

        @Override // com.tencent.luggage.wxa.kl.b.c
        public /* synthetic */ boolean b(View view) {
            return j.c(this, view);
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.kl.b.c
        public /* synthetic */ boolean a(View view) {
            return j.b(this, view);
        }

        @Override // com.tencent.luggage.wxa.kl.b.c
        public void a(b bVar, com.tencent.luggage.wxa.so.c cVar, com.tencent.luggage.wxa.so.c cVar2, View view) {
            ImageView imageView;
            if (b.this.k() || b.this.m() || (imageView = (ImageView) cVar.b()) == null) {
                return;
            }
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.m8c);
            imageView.setColorFilter(b.this.f132622m, PorterDuff.Mode.SRC_ATOP);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            marginLayoutParams.width = b.this.getContext().getResources().getDimensionPixelSize(R.dimen.c1d);
            marginLayoutParams.height = b.this.getContext().getResources().getDimensionPixelSize(R.dimen.c1c);
            marginLayoutParams.leftMargin = b.this.getContext().getResources().getDimensionPixelSize(a());
            marginLayoutParams.rightMargin = b.this.getContext().getResources().getDimensionPixelSize(R.dimen.c1p);
            imageView.setLayoutParams(marginLayoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface g {
        void a(boolean z16);
    }

    public b(Context context) {
        super(context);
        String str = "MicroMsg.AppBrandActionBar#" + hashCode();
        this.f132610a = str;
        com.tencent.luggage.wxa.vo.c cVar = new com.tencent.luggage.wxa.vo.c();
        this.f132611b = cVar;
        this.f132612c = new o0(hashCode(), cVar);
        this.f132614e = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: c31.e
            @Override // com.tencent.luggage.wxa.so.c.a
            public final Object a() {
                return com.tencent.luggage.wxa.kl.b.this.g();
            }
        });
        this.f132615f = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: c31.f
            @Override // com.tencent.luggage.wxa.so.c.a
            public final Object a() {
                return com.tencent.luggage.wxa.kl.b.this.f();
            }
        });
        this.G = new com.tencent.luggage.wxa.kl.c();
        this.J = new f(this, null);
        this.M = false;
        this.N = new LinkedHashSet();
        this.O = new a();
        this.Q = new Runnable() { // from class: c31.g
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.kl.b.this.n();
            }
        };
        w.d(str, "<init>, context: " + context);
        this.E = true;
        this.F = false;
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        super.requestLayout();
    }

    private void setBackgroundColorInternal(int i3) {
        if (!this.F) {
            super.setBackgroundColor(i3);
        } else {
            super.setBackgroundColor(0);
        }
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void destroy() {
        w.d(this.f132610a, "destroy");
        CircleProgressDrawable circleProgressDrawable = this.f132621l;
        if (circleProgressDrawable != null) {
            circleProgressDrawable.stop();
        }
        removeAllViews();
        this.J = null;
        this.f132611b.g();
    }

    public final double getBackgroundAlpha() {
        return this.D;
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public final int getBackgroundColor() {
        if (this.F) {
            return 0;
        }
        return this.C;
    }

    public int getForegroundColor() {
        return this.f132622m;
    }

    public CharSequence getMainTitle() {
        return this.f132618i.getText();
    }

    public c getNavResetStyleListener() {
        return this.J;
    }

    public final boolean i() {
        return com.tencent.luggage.wxa.uk.b.f142651b.isEnable();
    }

    public boolean j() {
        if (this.I.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean k() {
        return this.F;
    }

    public boolean l() {
        View view = this.f132620k;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean m() {
        return this.E;
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i3, int i16, int i17, int i18) {
        int i19 = 0;
        if (R.id.s_x == view.getId()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            View view2 = this.f132616g;
            if (view2 != null && view2.getVisibility() == 0) {
                i19 = Math.max(0, this.f132616g.getMeasuredWidth());
            }
            View view3 = this.f132617h;
            if (view3 != null && view3.getVisibility() == 0) {
                i19 = Math.max(i19, this.f132617h.getMeasuredWidth());
            }
            marginLayoutParams.rightMargin = i19;
            marginLayoutParams.leftMargin = i19;
        } else if (R.id.s_o == view.getId()) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int paddingStart = view.getPaddingStart() + 0;
            View view4 = this.f132616g;
            if (view4 != null && view4.getVisibility() == 0) {
                paddingStart += this.f132616g.getMeasuredWidth();
            }
            marginLayoutParams2.leftMargin = paddingStart;
            marginLayoutParams2.setMarginStart(paddingStart);
            int paddingEnd = view.getPaddingEnd() + 0;
            if (this.f132618i != null && View.MeasureSpec.getMode(i3) != 0) {
                paddingEnd = paddingEnd + (View.MeasureSpec.getSize(i3) / 2) + (this.f132618i.getMeasuredWidth() / 2);
            }
            marginLayoutParams2.rightMargin = paddingEnd;
            marginLayoutParams2.setMarginEnd(paddingEnd);
        }
        super.measureChildWithMargins(view, i3, i16, i17, i18);
    }

    public final void o() {
        com.tencent.luggage.wxa.uk.b.f142651b.S().a(this.f132612c, new d(this));
    }

    @Override // com.tencent.luggage.wxa.xd.g.b
    public void onBackground() {
        CircleProgressDrawable circleProgressDrawable = this.f132621l;
        if (circleProgressDrawable != null) {
            circleProgressDrawable.stop();
        }
    }

    @Override // android.view.View
    public void onCancelPendingInputEvents() {
        super.onCancelPendingInputEvents();
        this.f132616g.cancelPendingInputEvents();
        ImageView[] imageViewArr = {(ImageView) this.f132614e.d(), (ImageView) this.f132615f.d()};
        for (int i3 = 0; i3 < 2; i3++) {
            ImageView imageView = imageViewArr[i3];
            if (imageView != null) {
                imageView.cancelPendingInputEvents();
                imageView.setPressed(false);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.g.d
    public void onForeground() {
        CircleProgressDrawable circleProgressDrawable;
        if (l() && (circleProgressDrawable = this.f132621l) != null) {
            circleProgressDrawable.start();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(Math.max(0, this.f132613d), 1073741824));
    }

    public final void p() {
        if (this.M) {
            w.d(this.f132610a, "resetDoubleClickEmitter");
            this.f132618i.setOnClickListener(null);
            this.f132618i.setClickable(false);
            this.M = false;
        }
    }

    public void q() {
        if (this.J != null) {
            r();
            this.J.a(this, this.f132614e, this.f132615f, this.f132616g);
        }
        this.f132618i.setTextColor(this.f132622m);
        if (this.f132620k != null && this.f132621l != null) {
            d();
        }
        b(this.f132622m);
    }

    public final void r() {
        int i3;
        if (!this.F && !this.E) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        this.f132616g.setVisibility(i3);
    }

    public final void s() {
        int i3;
        TextView textView = this.f132618i;
        if (this.F) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
        if (this.F) {
            View view = this.f132620k;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            setLoadingIconVisibility(this.f132619j);
        }
        requestLayout();
    }

    public void setActionBarHeight(int i3) {
        if (this.f132613d != i3) {
            this.f132613d = i3;
            invalidate();
        }
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void setBackButtonClickListener(View.OnClickListener onClickListener) {
        this.G.a(onClickListener);
    }

    public final void setBackgroundAlpha(double d16) {
        this.D = d16;
        if (!this.F) {
            Drawable background = super.getBackground();
            if (background == null) {
                setBackgroundColorInternal(this.C);
                background = super.getBackground();
            }
            background.setAlpha((int) (d16 * 255.0d));
        }
    }

    @Override // android.view.View, com.tencent.luggage.wxa.kl.i
    public final void setBackgroundColor(int i3) {
        this.C = i3;
        setBackgroundColorInternal(i3);
        setBackgroundAlpha(this.D);
    }

    public final void setCapsuleBarInteractionDelegate(e eVar) {
        this.H = eVar;
        if (eVar != null) {
            final com.tencent.luggage.wxa.kl.c cVar = this.G;
            Objects.requireNonNull(cVar);
            eVar.b(new View.OnClickListener() { // from class: c31.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.tencent.luggage.wxa.kl.c.this.c(view);
                }
            });
            e eVar2 = this.H;
            final com.tencent.luggage.wxa.kl.c cVar2 = this.G;
            Objects.requireNonNull(cVar2);
            eVar2.a(new View.OnClickListener() { // from class: c31.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.tencent.luggage.wxa.kl.c.this.b(view);
                }
            });
        }
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void setCloseButtonClickListener(View.OnClickListener onClickListener) {
        this.G.b(onClickListener);
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void setForegroundColor(int i3) {
        this.f132622m = i3;
        q();
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void setForegroundStyle(String str) {
        this.f132622m = i.b.a(str).f132666a;
        q();
    }

    public void setFullscreenMode(boolean z16) {
        boolean z17;
        c cVar;
        if (this.F != z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.F = z16;
        r();
        if (z17 && (cVar = this.J) != null) {
            cVar.a(this, this.f132614e, this.f132615f, this.f132616g);
        }
        s();
        setBackgroundColor(this.C);
        setLoadingIconVisibility(this.f132619j);
    }

    @Override // com.tencent.luggage.wxa.kl.i
    @SuppressLint({"NewApi"})
    public void setLoadingIconVisibility(boolean z16) {
        CircleProgressDrawable circleProgressDrawable;
        ViewStub viewStub;
        this.f132619j = z16;
        g gVar = this.K;
        if (gVar != null) {
            gVar.a(z16);
            return;
        }
        int i3 = 8;
        if (this.F) {
            View view = this.f132620k;
            if (view != null) {
                view.setVisibility(8);
            }
            CircleProgressDrawable circleProgressDrawable2 = this.f132621l;
            if (circleProgressDrawable2 != null) {
                circleProgressDrawable2.stop();
                return;
            }
            return;
        }
        if (this.f132620k == null) {
            if (!z16 || (viewStub = (ViewStub) findViewById(R.id.s_p)) == null) {
                return;
            }
            viewStub.setLayoutResource(R.layout.dxg);
            this.f132620k = viewStub.inflate();
        }
        View view2 = this.f132620k;
        if (z16) {
            i3 = 0;
        }
        view2.setVisibility(i3);
        if (z16) {
            if (this.f132621l == null) {
                if (this.f132620k instanceof SimplifiedLoadingProgressBar) {
                    circleProgressDrawable = new com.tencent.luggage.wxa.il.i(getContext());
                } else {
                    circleProgressDrawable = new CircleProgressDrawable(getContext());
                }
                this.f132621l = circleProgressDrawable;
            }
            d();
            this.f132621l.d();
            this.f132621l.start();
            return;
        }
        this.f132621l.stop();
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void setMainTitle(CharSequence charSequence) {
        boolean isLayoutRequested = isLayoutRequested();
        this.f132618i.setText(charSequence);
        float c16 = com.tencent.luggage.wxa.kn.a.c(this.f132618i.getContext(), R.dimen.bck);
        TextView textView = this.f132618i;
        textView.setTextSize(0, c16 * com.tencent.luggage.wxa.kl.c.a(textView.getContext()));
        a(i(), charSequence);
        if (isLayoutRequested) {
            requestLayout();
        }
    }

    public void setNavButtonLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.L = onLongClickListener;
    }

    public void setNavContainerMinimumWidth(int i3) {
        View view = this.f132616g;
        if (view != null) {
            view.setMinimumWidth(i3);
        }
    }

    public void setNavHidden(boolean z16) {
        this.E = z16;
        r();
        q();
    }

    public void setNavLoadingIconVisibilityResetListener(g gVar) {
        this.K = gVar;
    }

    public void setNavResetStyleListener(c cVar) {
        this.J = cVar;
    }

    public void setOptionButtonClickListener(View.OnClickListener onClickListener) {
        this.G.c(onClickListener);
    }

    public final void t() {
        if (!this.M) {
            w.d(this.f132610a, "setupDoubleClickEmitter");
            this.f132618i.setOnClickListener(this.O);
            this.M = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b(View view) {
        View.OnLongClickListener onLongClickListener = this.L;
        if (onLongClickListener != null) {
            return onLongClickListener.onLongClick(view);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c(View view) {
        View.OnLongClickListener onLongClickListener = this.L;
        if (onLongClickListener != null) {
            return onLongClickListener.onLongClick(view);
        }
        return false;
    }

    public final void d() {
        Objects.requireNonNull(this.f132620k);
        Objects.requireNonNull(this.f132621l);
        this.f132621l.a(this.f132622m);
        View view = this.f132620k;
        if (view instanceof ProgressBar) {
            ((ProgressBar) view).setIndeterminateDrawable(this.f132621l);
            ((ProgressBar) this.f132620k).setIndeterminate(true);
        } else if (view instanceof SimplifiedLoadingProgressBar) {
            com.tencent.luggage.wxa.er.a.b(this.f132621l instanceof Animatable2);
            this.f132620k.setForeground(this.f132621l);
        } else {
            view.setBackground(this.f132621l);
        }
    }

    public final ImageView f() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.s_n);
        if (viewStub == null) {
            return null;
        }
        ImageView imageView = (ImageView) viewStub.inflate();
        imageView.setId(R.id.s_m);
        com.tencent.luggage.wxa.jl.c.a(imageView, Button.class, Integer.valueOf(R.string.yjp), false, null, null, null, null, null, null, null, null, null);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: c31.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.tencent.luggage.wxa.kl.b.this.a(view);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: c31.d
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean b16;
                b16 = com.tencent.luggage.wxa.kl.b.this.b(view);
                return b16;
            }
        });
        return imageView;
    }

    public final ImageView g() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.s_t);
        if (viewStub == null) {
            return null;
        }
        final ImageView imageView = (ImageView) viewStub.inflate();
        imageView.setId(R.id.s_s);
        com.tencent.luggage.wxa.jl.c.a(imageView, Button.class, Integer.valueOf(R.string.yjp), false, null, null, null, null, null, null, null, null, null);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: c31.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.tencent.luggage.wxa.kl.b.this.a(imageView, view);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: c31.i
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean c16;
                c16 = com.tencent.luggage.wxa.kl.b.this.c(view);
                return c16;
            }
        });
        return imageView;
    }

    @NonNull
    public AppBrandCapsuleBarPlaceHolderView getCapsuleView() {
        return this.I;
    }

    public final void h() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.dxd, (ViewGroup) this, true);
        this.f132613d = getContext().getResources().getDimensionPixelSize(R.dimen.c1h);
        this.f132622m = -1;
        this.C = ContextCompat.getColor(getContext(), R.color.b3f);
        this.D = 1.0d;
        this.f132616g = findViewById(R.id.s_r);
        TextView textView = (TextView) findViewById(R.id.s_x);
        this.f132618i = textView;
        textView.setClickable(false);
        this.I = (AppBrandCapsuleBarPlaceHolderView) findViewById(R.id.s__);
        this.f132617h = findViewById(R.id.s_v);
        o();
    }

    public void setForegroundStyle(boolean z16) {
        this.f132622m = z16 ? -16777216 : -1;
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ImageView imageView, View view) {
        c cVar = this.J;
        if (cVar == null || cVar.a(view)) {
            return;
        }
        this.G.a(imageView);
    }

    @Override // com.tencent.luggage.wxa.kl.i.a
    public boolean b(boolean z16, i.a.EnumC6399a enumC6399a) {
        e eVar = this.H;
        return eVar != null ? eVar.b(z16, enumC6399a) : z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        c cVar = this.J;
        if (cVar != null) {
            cVar.b(view);
        }
    }

    public final void b(int i3) {
        if (i.b.a(i3) == i.b.WHITE) {
            e eVar = this.H;
            if (eVar != null) {
                eVar.a(-1);
                return;
            }
            return;
        }
        e eVar2 = this.H;
        if (eVar2 != null) {
            eVar2.a(-16777216);
        }
    }

    public void a(com.tencent.luggage.wxa.kl.a aVar) {
        if (aVar != null) {
            this.N.add(aVar);
        }
        a(i(), getMainTitle());
    }

    public final void a(boolean z16, CharSequence charSequence) {
        w.d(this.f132610a, "operateDoubleClickEmitter, isAccessibilityEnable: %b, title: %s", Boolean.valueOf(z16), charSequence);
        if (!z16) {
            if (this.N.isEmpty()) {
                return;
            }
            t();
        } else {
            if (!TextUtils.isEmpty(charSequence)) {
                if (this.N.isEmpty()) {
                    return;
                }
                t();
                return;
            }
            p();
        }
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void a(boolean z16, i.a.EnumC6399a enumC6399a) {
        boolean b16 = b(z16, enumC6399a);
        int i3 = b16 ? 0 : 4;
        this.I.setVisibility(i3);
        if (this.I.getLayoutParams() != null) {
            this.I.getLayoutParams().width = b16 ? -2 : 0;
            this.I.requestLayout();
        }
        e eVar = this.H;
        if (eVar != null) {
            eVar.c(this.I.getVisibility());
        }
        AppBrandActionBarCustomImageView appBrandActionBarCustomImageView = this.P;
        if (appBrandActionBarCustomImageView != null) {
            appBrandActionBarCustomImageView.setVisibility(i3);
        }
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public View getActionView() {
        return this;
    }

    public void a(Bitmap bitmap, View.OnClickListener onClickListener) {
        post(new RunnableC6398b(bitmap, onClickListener));
    }
}
