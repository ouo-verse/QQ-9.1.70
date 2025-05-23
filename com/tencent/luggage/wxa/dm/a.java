package com.tencent.luggage.wxa.dm;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.dm.g f124327a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f124328b;

    /* renamed from: c, reason: collision with root package name */
    public String f124329c;

    /* renamed from: d, reason: collision with root package name */
    public int f124330d;

    /* renamed from: e, reason: collision with root package name */
    public int f124331e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f124332f;

    /* renamed from: g, reason: collision with root package name */
    public LinkedList f124333g;

    /* renamed from: h, reason: collision with root package name */
    public int f124334h;

    /* renamed from: i, reason: collision with root package name */
    public r f124335i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedList f124336j;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.dm.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6143a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f124337a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Animator f124338b;

        public C6143a(Runnable runnable, Animator animator) {
            this.f124337a = runnable;
            this.f124338b = animator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable = this.f124337a;
            if (runnable != null) {
                a.this.post(runnable);
            }
            this.f124338b.removeListener(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i3 = 0; i3 < a.this.f124332f.size(); i3++) {
                a aVar = a.this;
                aVar.a(aVar.f124328b.getChildAt(i3), (q) a.this.f124332f.get(i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends com.tencent.luggage.wxa.dm.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f124341a;

        public c(ImageView imageView) {
            this.f124341a = imageView;
        }

        @Override // com.tencent.luggage.wxa.dm.f
        public void a(Bitmap bitmap, com.tencent.luggage.wxa.dm.e eVar) {
            super.a(bitmap, eVar);
            a.this.a(bitmap, this.f124341a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends com.tencent.luggage.wxa.dm.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f124343a;

        public d(ImageView imageView) {
            this.f124343a = imageView;
        }

        @Override // com.tencent.luggage.wxa.dm.f
        public void a(Bitmap bitmap, com.tencent.luggage.wxa.dm.e eVar) {
            super.a(bitmap, eVar);
            a.this.a(bitmap, this.f124343a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f124345a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f124346b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageView f124347c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TextView f124348d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f124349e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ImageView f124350f;

        public e(boolean z16, TextView textView, ImageView imageView, TextView textView2, RelativeLayout relativeLayout, ImageView imageView2) {
            this.f124345a = z16;
            this.f124346b = textView;
            this.f124347c = imageView;
            this.f124348d = textView2;
            this.f124349e = relativeLayout;
            this.f124350f = imageView2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            int i3;
            Context context2;
            int i16;
            if (this.f124345a) {
                context = a.this.getContext();
                i3 = -12;
            } else {
                context = a.this.getContext();
                i3 = -8;
            }
            int b16 = a.b(context, i3);
            if (this.f124345a) {
                context2 = a.this.getContext();
                i16 = -1;
            } else {
                context2 = a.this.getContext();
                i16 = -3;
            }
            int b17 = a.b(context2, i16);
            int measuredWidth = (this.f124346b.getMeasuredWidth() - this.f124347c.getMeasuredWidth()) >> 1;
            if (measuredWidth > 0 && this.f124347c.getVisibility() != 8) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f124348d.getLayoutParams();
                int i17 = b16 - measuredWidth;
                if (layoutParams.leftMargin != i17) {
                    layoutParams.leftMargin = i17;
                    this.f124349e.updateViewLayout(this.f124348d, layoutParams);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f124350f.getLayoutParams();
                int i18 = b17 + measuredWidth;
                w.a("MicroMsg.AppBrandPageTabBar", "setItemView, marginRight: " + i18);
                if (layoutParams2.rightMargin != i18) {
                    layoutParams2.rightMargin = i18;
                    this.f124349e.updateViewLayout(this.f124350f, layoutParams2);
                    return;
                }
                return;
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f124348d.getLayoutParams();
            if (layoutParams3.leftMargin != b16) {
                layoutParams3.leftMargin = b16;
                this.f124349e.updateViewLayout(this.f124348d, layoutParams3);
            }
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f124350f.getLayoutParams();
            if (layoutParams4.rightMargin != b17) {
                layoutParams4.rightMargin = b17;
                this.f124349e.updateViewLayout(this.f124350f, layoutParams4);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f124352a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f124353b;

        public f(ImageView imageView, Bitmap bitmap) {
            this.f124352a = imageView;
            this.f124353b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f124352a.setImageBitmap(this.f124353b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f124355a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f124356b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f124357c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f124358d;

        public g(String str, String str2, String str3, String str4) {
            this.f124355a = str;
            this.f124356b = str2;
            this.f124357c = str3;
            this.f124358d = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(this.f124355a, this.f124356b);
            a.this.a(this.f124357c, this.f124358d);
            a.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h extends com.tencent.luggage.wxa.dm.d {
        public h() {
        }

        @Override // com.tencent.luggage.wxa.dm.d
        public void a(String str, com.tencent.luggage.wxa.dm.e eVar) {
            super.a(str, eVar);
            w.b("IconLoadErrorHandler ", "load icon fail: " + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i extends com.tencent.luggage.wxa.dm.d {
        public i() {
        }

        @Override // com.tencent.luggage.wxa.dm.d
        public void a(String str, com.tencent.luggage.wxa.dm.e eVar) {
            super.a(str, eVar);
            w.b("IconLoadErrorHandler ", "load icon fail: " + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f124362a;

        public j(q qVar) {
            this.f124362a = qVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke() {
            return Boolean.valueOf(this.f124362a.f124377e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(a.this.f124328b.indexOfChild(view));
            a.this.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f124365a;

        public l(boolean z16) {
            this.f124365a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f124365a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.setVisibility(8);
            if (a.this.getParent() instanceof p) {
                ((p) a.this.getParent()).b(a.this, true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f124368a;

        public n(boolean z16) {
            this.f124368a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(this.f124368a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObjectAnimator f124370a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.dm.a$o$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6144a implements Runnable {
            public RunnableC6144a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.getParent() instanceof p) {
                    ((p) a.this.getParent()).c(a.this, true);
                }
            }
        }

        public o(ObjectAnimator objectAnimator) {
            this.f124370a = objectAnimator;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.setVisibility(0);
            a.this.a(this.f124370a, new RunnableC6144a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface p extends ViewParent {
        void a(a aVar, boolean z16);

        void b(a aVar, boolean z16);

        void c(a aVar, boolean z16);

        void d(a aVar, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class q {

        /* renamed from: a, reason: collision with root package name */
        public String f124373a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.luggage.wxa.dm.e f124374b;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.luggage.wxa.dm.e f124375c;

        /* renamed from: d, reason: collision with root package name */
        public String f124376d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f124377e = false;

        /* renamed from: f, reason: collision with root package name */
        public boolean f124378f;

        /* renamed from: g, reason: collision with root package name */
        public String f124379g;

        /* renamed from: h, reason: collision with root package name */
        public int f124380h;

        /* renamed from: i, reason: collision with root package name */
        public int f124381i;

        public q() {
            a();
        }

        public void a() {
            this.f124378f = false;
            this.f124379g = "";
            this.f124380h = 0;
            this.f124381i = -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface r {
        void a(int i3, String str);
    }

    public a(Context context) {
        super(context);
        this.f124334h = 0;
        this.f124336j = new LinkedList();
        this.f124332f = new LinkedList();
        this.f124333g = new LinkedList();
        this.f124327a = new com.tencent.luggage.wxa.dm.g();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(context);
        this.f124328b = linearLayout;
        linearLayout.setOrientation(0);
        this.f124328b.setGravity(16);
        this.f124328b.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        addView(this.f124328b);
    }

    public String getPosition() {
        return this.f124329c;
    }

    public void setClickListener(@Nullable r rVar) {
        this.f124335i = rVar;
    }

    public void setPosition(String str) {
        this.f124329c = str;
    }

    public final void c() {
        a(new b());
    }

    public final void b(String str, String str2) {
        this.f124330d = com.tencent.luggage.wxa.tk.g.a(str, Color.parseColor("#E6000000"));
        this.f124331e = com.tencent.luggage.wxa.tk.g.a(str2, Color.parseColor("#07C160"));
    }

    public void a(String str, String str2, String str3, String str4) {
        a(new g(str, str2, str3, str4));
    }

    public void b(int i3, String str, com.tencent.luggage.wxa.dm.e eVar, com.tencent.luggage.wxa.dm.e eVar2) {
        a(i3, str, eVar, eVar2, true);
    }

    public final void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public void b(boolean z16) {
        if (!c0.b()) {
            c0.a(new n(z16));
            return;
        }
        if (getParent() instanceof p) {
            ((p) getParent()).d(this, z16);
        }
        if (!z16) {
            setVisibility(0);
            setTranslationY(0.0f);
            if (getParent() instanceof p) {
                ((p) getParent()).c(this, false);
                return;
            }
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = getHeight() * ("top".equals(this.f124329c) ? -1 : 1);
        fArr[1] = 0.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", fArr);
        ofFloat.setDuration(250L);
        post(new o(ofFloat));
    }

    public final void a(String str, String str2) {
        float b16 = b(getContext(), 1) / 2.0f;
        int i3 = b16 > 1.0f ? (int) b16 : 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(com.tencent.luggage.wxa.tk.g.a(str, -1));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(0);
        if ("white".equals(str2)) {
            gradientDrawable2.setStroke(i3, 872415231);
        } else {
            gradientDrawable2.setStroke(i3, 855638016);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2});
        if ("top".equals(this.f124329c)) {
            int i16 = -i3;
            layerDrawable.setLayerInset(1, i16, i16, i16, i16);
        } else {
            int i17 = -i3;
            layerDrawable.setLayerInset(1, i17, 0, i17, i17);
        }
        setBackground(layerDrawable);
    }

    public final void b() {
        r rVar = this.f124335i;
        if (rVar != null) {
            int i3 = this.f124334h;
            rVar.a(i3, ((q) this.f124332f.get(i3)).f124373a);
        }
    }

    public final q b(String str) {
        String b16 = com.tencent.luggage.wxa.h6.o.b(str);
        Iterator it = this.f124332f.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            if (com.tencent.luggage.wxa.h6.o.b(qVar.f124373a).equals(b16)) {
                return qVar;
            }
        }
        return null;
    }

    public static int b(Context context, int i3) {
        return Math.round(context.getResources().getDisplayMetrics().density * i3);
    }

    public void a(String str, String str2, String str3, String str4, com.tencent.luggage.wxa.dm.b bVar) {
        q qVar = new q();
        qVar.f124374b = new com.tencent.luggage.wxa.dm.c(str3, new h());
        qVar.f124375c = new com.tencent.luggage.wxa.dm.c(str4, new i());
        qVar.f124376d = str2;
        qVar.f124373a = str;
        this.f124333g.add(new Pair(qVar.f124374b, qVar.f124375c));
        if (qVar.f124376d == null && (qVar.f124374b.c() == null || qVar.f124375c.c() == null)) {
            w.b("MicroMsg.AppBrandPageTabBar", "illegal data");
            return;
        }
        com.tencent.luggage.wxa.dm.b bVar2 = bVar != null ? bVar : new com.tencent.luggage.wxa.dm.b(getContext());
        a(bVar2, qVar);
        com.tencent.luggage.wxa.jl.c.a(bVar2, null, null, false, null, null, null, new j(qVar), null, null, null, null, null);
        bVar2.setOnClickListener(new k());
        this.f124332f.add(qVar);
        this.f124328b.addView(bVar2);
    }

    public void a(int i3) {
        ((q) this.f124332f.get(this.f124334h)).f124377e = false;
        if (i3 > 0 && i3 < this.f124332f.size()) {
            this.f124334h = i3;
        } else {
            this.f124334h = 0;
        }
        ((q) this.f124332f.get(this.f124334h)).f124377e = true;
        c();
    }

    public void a(int i3, String str, com.tencent.luggage.wxa.dm.e eVar, com.tencent.luggage.wxa.dm.e eVar2) {
        a(i3, str, eVar, eVar2, false);
    }

    public final void a(int i3, String str, com.tencent.luggage.wxa.dm.e eVar, com.tencent.luggage.wxa.dm.e eVar2, boolean z16) {
        if (i3 >= this.f124332f.size()) {
            return;
        }
        q qVar = (q) this.f124332f.get(i3);
        if (str == null) {
            str = qVar.f124376d;
        }
        qVar.f124376d = str;
        if (eVar != null && (eVar.c() != null || z16)) {
            qVar.f124374b = eVar;
        }
        if (eVar2 != null && (eVar2.c() != null || z16)) {
            qVar.f124375c = eVar2;
        }
        c();
    }

    public void a(int i3, String str, String str2, String str3, String str4) {
        int a16 = com.tencent.luggage.wxa.tk.g.a(str3, 0);
        int a17 = com.tencent.luggage.wxa.tk.g.a(str4, -1);
        for (int i16 = 0; i16 < this.f124332f.size(); i16++) {
            if (i16 == i3) {
                ((q) this.f124332f.get(i16)).a();
                if ("redDot".equals(str)) {
                    ((q) this.f124332f.get(i16)).f124378f = true;
                } else if ("text".equals(str)) {
                    ((q) this.f124332f.get(i16)).f124379g = str2;
                    ((q) this.f124332f.get(i16)).f124380h = a16;
                    ((q) this.f124332f.get(i16)).f124381i = a17;
                } else if ("none".equals(str)) {
                    ((q) this.f124332f.get(i16)).f124378f = false;
                    ((q) this.f124332f.get(i16)).f124379g = "";
                }
            }
        }
        c();
    }

    public void a(boolean z16) {
        if (!c0.b()) {
            c0.a(new l(z16));
            return;
        }
        if (getParent() instanceof p) {
            ((p) getParent()).a(this, z16);
        }
        if (!z16) {
            setVisibility(8);
            if (getParent() instanceof p) {
                ((p) getParent()).b(this, false);
                return;
            }
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = 0.0f;
        fArr[1] = getHeight() * ("top".equals(this.f124329c) ? -1 : 1);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", fArr);
        ofFloat.setDuration(250L);
        a(ofFloat, new m());
    }

    public void a() {
        clearAnimation();
        Iterator it = this.f124336j.iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).cancel();
        }
        this.f124336j.clear();
    }

    public final void a(Animator animator, Runnable runnable) {
        a();
        this.f124336j.add(animator);
        animator.addListener(new C6143a(runnable, animator));
        animator.start();
    }

    public final void a(View view, q qVar) {
        int i3;
        int a16;
        int a17;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.sst);
        ImageView imageView = (ImageView) view.findViewById(R.id.ssu);
        TextView textView = (TextView) view.findViewById(R.id.sss);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.ssx);
        TextView textView2 = (TextView) view.findViewById(R.id.ssy);
        View findViewById = view.findViewById(R.id.ssw);
        boolean h16 = com.tencent.luggage.wxa.kn.a.h(getContext());
        w.a("MicroMsg.AppBrandPageTabBar", "setItemView, useLargerText: " + h16);
        if ("top".equals(this.f124329c)) {
            view.setLayoutParams(new LinearLayout.LayoutParams(0, (int) (b(getContext(), 40) * com.tencent.luggage.wxa.kn.a.d(getContext())), 1.0f));
            imageView.setVisibility(8);
            textView2.setTextSize(0, b(getContext(), 14) * com.tencent.luggage.wxa.kn.a.d(getContext()));
            if (qVar.f124377e) {
                findViewById.setBackgroundColor(this.f124331e);
                findViewById.setVisibility(0);
                i3 = 4;
            } else {
                i3 = 4;
                findViewById.setVisibility(4);
            }
        } else {
            if (qVar.f124374b.c() != null) {
                String str = qVar.f124376d;
                if (str != null && !str.equals("")) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, (int) (b(getContext(), 56) * com.tencent.luggage.wxa.kn.a.d(getContext())), 1.0f));
                    imageView.setVisibility(0);
                    if (h16) {
                        a17 = com.tencent.luggage.wxa.kn.a.a(getContext(), 34);
                    } else {
                        a17 = com.tencent.luggage.wxa.kn.a.a(getContext(), 28);
                    }
                    imageView.getLayoutParams().width = a17;
                    imageView.getLayoutParams().height = a17;
                    textView2.setVisibility(0);
                    textView2.setTextSize(0, b(getContext(), 12) * com.tencent.luggage.wxa.kn.a.d(getContext()));
                } else {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, (int) (b(getContext(), 48) * com.tencent.luggage.wxa.kn.a.d(getContext())), 1.0f));
                    imageView.setVisibility(0);
                    if (h16) {
                        a16 = com.tencent.luggage.wxa.kn.a.a(getContext(), 34);
                    } else {
                        a16 = com.tencent.luggage.wxa.kn.a.a(getContext(), 28);
                    }
                    imageView.getLayoutParams().width = a16;
                    imageView.getLayoutParams().height = a16;
                    textView2.setVisibility(8);
                }
            } else {
                String str2 = qVar.f124376d;
                if (str2 != null && !str2.equals("")) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, (int) (b(getContext(), 49) * com.tencent.luggage.wxa.kn.a.d(getContext())), 1.0f));
                    imageView.setVisibility(8);
                    textView2.setVisibility(0);
                    textView2.setTextSize(0, b(getContext(), 16) * com.tencent.luggage.wxa.kn.a.d(getContext()));
                }
            }
            i3 = 4;
            findViewById.setVisibility(4);
        }
        Drawable background = textView.getBackground();
        if (background != null) {
            background.setColorFilter(qVar.f124380h, PorterDuff.Mode.SRC_ATOP);
        }
        textView.setVisibility(qVar.f124379g.isEmpty() ? i3 : 0);
        textView.setText(qVar.f124379g);
        textView.setTextColor(qVar.f124381i);
        imageView2.setVisibility(qVar.f124378f ? 0 : i3);
        if (qVar.f124377e && qVar.f124375c.c() != null) {
            qVar.f124375c.a(new c(imageView));
            qVar.f124375c.e();
        } else {
            qVar.f124374b.a(new d(imageView));
            qVar.f124374b.e();
        }
        textView2.setText(qVar.f124376d);
        if (qVar.f124377e) {
            textView2.setTextColor(this.f124331e);
        } else {
            textView2.setTextColor(this.f124330d);
        }
        if ("top".equals(this.f124329c)) {
            return;
        }
        textView2.post(new e(h16, textView2, imageView, textView, relativeLayout, imageView2));
    }

    public final void a(Bitmap bitmap, ImageView imageView) {
        a(new f(imageView, bitmap));
    }

    public int a(String str) {
        return this.f124332f.indexOf(b(str));
    }
}
