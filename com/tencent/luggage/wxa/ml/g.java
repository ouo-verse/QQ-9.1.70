package com.tencent.luggage.wxa.ml;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.collection.ArraySet;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends RelativeLayout implements r {
    public final Set C;
    public final Set D;
    public boolean E;
    public boolean F;
    public s G;
    public boolean H;

    /* renamed from: a, reason: collision with root package name */
    public int f134683a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ml.h f134684b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f134685c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f134686d;

    /* renamed from: e, reason: collision with root package name */
    public final b0 f134687e;

    /* renamed from: f, reason: collision with root package name */
    public final k f134688f;

    /* renamed from: g, reason: collision with root package name */
    public final LinkedList f134689g;

    /* renamed from: h, reason: collision with root package name */
    public final View.OnClickListener f134690h;

    /* renamed from: i, reason: collision with root package name */
    public final Runnable f134691i;

    /* renamed from: j, reason: collision with root package name */
    public m f134692j;

    /* renamed from: k, reason: collision with root package name */
    public m f134693k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f134694l;

    /* renamed from: m, reason: collision with root package name */
    public Set f134695m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar = g.this;
            if (view == gVar) {
                gVar.d();
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
            g.this.setBackgroundColor(0);
            g.this.removeAllViews();
            g.this.setVisibility(4);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f134698a;

        public c(m mVar) {
            this.f134698a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.a(this.f134698a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f134702a;

        public e(m mVar) {
            this.f134702a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.b(this.f134702a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f134704a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f134705b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ m f134707a;

            public a(m mVar) {
                this.f134707a = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                g.this.removeView(fVar.f134704a);
                g.this.E = true;
                Iterator it = g.this.C.iterator();
                while (it.hasNext()) {
                    ((o) it.next()).a(f.this.f134705b);
                }
                g.this.E = false;
                if (!g.this.D.isEmpty()) {
                    g.this.C.removeAll(g.this.D);
                    g.this.D.clear();
                }
                m mVar = this.f134707a;
                if (mVar != null) {
                    mVar.onShown();
                }
            }
        }

        public f(View view, m mVar) {
            this.f134704a = view;
            this.f134705b = mVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            w.d("MicroMsg.AppBrandDialogContainerLayout", "on dialogView exit animation end");
            m b16 = g.this.b();
            this.f134704a.setVisibility(8);
            g.this.f134689g.remove(this.f134705b);
            g.this.f134692j = null;
            g.this.post(new a(b16));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ml.g$g, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6483g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f134709a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f134710b;

        public RunnableC6483g(View view, int[] iArr) {
            this.f134709a = view;
            this.f134710b = iArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            View view = this.f134709a;
            int[] iArr = this.f134710b;
            int i3 = iArr[0] - 1;
            iArr[0] = i3;
            gVar.a(view, new int[]{i3});
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Function {
        public h() {
        }

        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void apply(m mVar) {
            if (mVar != null && mVar.getContentView() != null) {
                View contentView = mVar.getContentView();
                contentView.animate().cancel();
                contentView.clearAnimation();
                return null;
            }
            return null;
        }
    }

    public g(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() == 0) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i3) {
        if (this.f134686d) {
            View focusSearch = super.focusSearch(view, i3);
            if (!com.tencent.luggage.wxa.wl.b.a(this, focusSearch)) {
                return null;
            }
            return focusSearch;
        }
        return super.focusSearch(view, i3);
    }

    @Override // com.tencent.luggage.wxa.ml.r
    @Nullable
    public m getCurrentDialog() {
        return (m) this.f134689g.peekLast();
    }

    @NonNull
    public com.tencent.luggage.wxa.ml.h getShareContext() {
        return this.f134684b;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int rotation;
        super.onConfigurationChanged(configuration);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager != null && this.f134683a != (rotation = windowManager.getDefaultDisplay().getRotation())) {
            this.f134683a = rotation;
            Iterator it = this.f134689g.iterator();
            while (it.hasNext()) {
                ((m) it.next()).b(this.f134683a);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f134686d) {
            this.f134685c.clear();
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (this.f134686d) {
            View findFocus = view.getRootView().findFocus();
            if (!b(findFocus)) {
                this.f134685c.put(view, findFocus);
            }
            a(view, new int[]{10});
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (this.f134689g.isEmpty()) {
            if (this.f134686d) {
                c((View) this.f134685c.remove(view));
            }
            this.f134692j = null;
            this.f134693k = null;
            this.f134688f.a(0, this.f134691i);
            return;
        }
        m mVar = this.f134693k;
        if (mVar != null && mVar.getContentView() == view) {
            this.f134693k = null;
        }
        m mVar2 = this.f134692j;
        if (mVar2 != null && mVar2.getContentView() == view) {
            this.f134692j = null;
        }
    }

    public void setEnableKeyboardNav(boolean z16) {
        this.f134686d = z16;
    }

    public void setListener(@Nullable s sVar) {
        this.G = sVar;
    }

    public void setShouldBringSelfToFrontWhenDialogShown(boolean z16) {
        this.F = z16;
    }

    public g(Context context, com.tencent.luggage.wxa.ml.h hVar) {
        super(context);
        this.f134683a = 0;
        this.f134685c = new HashMap();
        this.f134687e = new b0(Looper.getMainLooper());
        this.f134688f = new k(this);
        this.f134689g = new LinkedList();
        a aVar = new a();
        this.f134690h = aVar;
        this.f134691i = new b();
        this.f134694l = false;
        this.f134695m = new ArraySet();
        this.C = new ArraySet();
        this.D = new ArraySet();
        this.E = false;
        this.F = true;
        this.G = null;
        this.H = false;
        setVisibility(4);
        setBackgroundColor(0);
        setOnClickListener(aVar);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager != null) {
            this.f134683a = windowManager.getDefaultDisplay().getRotation();
        }
        hVar = hVar == null ? new com.tencent.luggage.wxa.ml.h() : hVar;
        hVar.a(this);
        this.f134684b = hVar;
        setDescendantFocusability(262144);
    }

    @Override // com.tencent.luggage.wxa.ml.r
    public void b(m mVar) {
        if (mVar == null || mVar.getContentView() == null) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            this.f134687e.a((Runnable) new e(mVar));
            return;
        }
        if (mVar.getContentView().getParent() == this && this.f134692j != mVar) {
            this.f134692j = mVar;
            if (this.f134693k == mVar) {
                this.f134693k = null;
            }
            View contentView = mVar.getContentView();
            contentView.animate().cancel();
            contentView.clearAnimation();
            Animator a16 = a(contentView, mVar.getPosition());
            a16.addListener(new f(contentView, mVar));
            a16.start();
            if (this.f134689g.size() <= 1) {
                this.f134688f.a(0, this.f134691i);
            }
            if (!this.f134695m.isEmpty() && this.f134694l) {
                Iterator it = this.f134695m.iterator();
                while (it.hasNext()) {
                    ((p) it.next()).a(Boolean.FALSE);
                }
            }
            this.f134694l = false;
        }
    }

    public final void c(View view) {
        if (view == null || !view.requestFocus()) {
            w.b("MicroMsg.AppBrandDialogContainerLayout|WMPF.KeyBoardNav", "onViewRemoved: request previous view[%s] focus fail, fallback", view);
        }
    }

    public final void d() {
        m mVar = (m) this.f134689g.peekLast();
        if (mVar == null) {
            setVisibility(8);
        } else if (mVar.b()) {
            mVar.onCancel();
            b(mVar);
        }
    }

    public void e() {
        if (this.f134688f.b()) {
            this.f134688f.a();
        }
        if (!this.f134689g.isEmpty()) {
            h hVar = new h();
            while (!this.f134689g.isEmpty()) {
                hVar.apply((m) this.f134689g.pollFirst());
            }
        }
        this.f134692j = null;
        this.f134693k = null;
        this.E = false;
        this.C.clear();
        this.D.clear();
        removeAllViewsInLayout();
        this.f134687e.a((Object) null);
        this.f134691i.run();
    }

    public final void c() {
        boolean z16;
        if (this.H) {
            z16 = false;
        } else {
            this.H = true;
            z16 = true;
        }
        int size = this.f134689g.size();
        m mVar = size >= 1 ? (m) this.f134689g.get(size - 1) : null;
        m mVar2 = size >= 2 ? (m) this.f134689g.get(size - 2) : null;
        s sVar = this.G;
        if (sVar != null) {
            sVar.a(z16, mVar, mVar2);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.r
    public void a(m mVar) {
        RelativeLayout.LayoutParams layoutParams;
        Animation loadAnimation;
        if (mVar == null) {
            return;
        }
        w.d("MicroMsg.AppBrandDialogContainerLayout", "showDialog dialog[%s] tid[%d]", mVar.getClass().getName(), Long.valueOf(Thread.currentThread().getId()));
        if (Looper.getMainLooper() != Looper.myLooper()) {
            this.f134687e.a((Runnable) new c(mVar));
            return;
        }
        com.tencent.luggage.wxa.h6.h.a(getContext());
        if (this.f134688f.b()) {
            this.f134688f.a();
        }
        View contentView = mVar.getContentView();
        if (contentView == null) {
            w.h("MicroMsg.AppBrandDialogContainerLayout", "showDialog NULL dialogView from dialog[%s], stack=%s", mVar, Log.getStackTraceString(new Throwable()));
            return;
        }
        if (contentView.getParent() != this) {
            a(contentView);
            if (mVar.getPosition() == 2) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(14);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
            }
            addView(contentView, layoutParams);
            if (this.f134693k != mVar) {
                contentView.clearAnimation();
                if (mVar.getPosition() == 2) {
                    loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154652po);
                } else {
                    loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154489lz);
                }
                loadAnimation.setAnimationListener(new d(mVar));
                contentView.startAnimation(loadAnimation);
            }
            this.f134693k = mVar;
        }
        if (contentView.getVisibility() != 0) {
            contentView.setVisibility(0);
        }
        contentView.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(0L).scaleX(1.0f).scaleY(1.0f).start();
        contentView.setOnClickListener(this.f134690h);
        this.f134689g.add(mVar);
        mVar.a(this);
        setVisibility(0);
        if (this.F) {
            bringToFront();
        }
        this.f134688f.a(Color.argb(127, 0, 0, 0), (Runnable) null);
        if (!this.f134695m.isEmpty() && !this.f134694l) {
            Iterator it = this.f134695m.iterator();
            while (it.hasNext()) {
                ((p) it.next()).a(Boolean.TRUE);
            }
        }
        this.f134694l = true;
    }

    public final boolean b(View view) {
        return view != null && w0.a((Integer) view.getTag(-1434350070)) == 1;
    }

    @Override // com.tencent.luggage.wxa.ml.r
    public void b(p pVar) {
        this.f134695m.remove(pVar);
    }

    @Override // com.tencent.luggage.wxa.ml.r
    public void b(o oVar) {
        if (oVar == null) {
            return;
        }
        this.C.add(oVar);
    }

    public final m b() {
        int size = this.f134689g.size();
        boolean z16 = false;
        if (1 == size) {
            this.H = false;
            z16 = true;
        }
        m mVar = size >= 1 ? (m) this.f134689g.get(size - 1) : null;
        m mVar2 = size >= 2 ? (m) this.f134689g.get(size - 2) : null;
        s sVar = this.G;
        if (sVar != null) {
            sVar.b(z16, mVar, mVar2);
        }
        return mVar2;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f134700a;

        public d(m mVar) {
            this.f134700a = mVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            w.d("MicroMsg.AppBrandDialogContainerLayout", "on dialogView start animation end");
            g.this.c();
            this.f134700a.onShown();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public void setAppBrandDefaultFocus(n nVar) {
    }

    public final void a(View view, int[] iArr) {
        if (iArr[0] <= 0) {
            return;
        }
        if (view.isLaidOut() && view.requestFocus()) {
            w.d("MicroMsg.AppBrandDialogContainerLayout|WMPF.KeyBoardNav", "onViewAdded: request success, focusable[%b] remainTime[%d]  child[%s]", Boolean.valueOf(view.isFocusable()), Integer.valueOf(iArr[0]), view);
        } else {
            w.b("MicroMsg.AppBrandDialogContainerLayout|WMPF.KeyBoardNav", "onViewAdded: request fail, focusable[%b] remainTime[%d]  child[%s]", Boolean.valueOf(view.isFocusable()), Integer.valueOf(iArr[0]), view);
            view.postDelayed(new RunnableC6483g(view, iArr), 10L);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.r
    public void a(p pVar) {
        this.f134695m.add(pVar);
    }

    @Override // com.tencent.luggage.wxa.ml.r
    public void a(o oVar) {
        if (oVar == null) {
            return;
        }
        if (!this.E) {
            this.C.remove(oVar);
        } else {
            this.D.add(oVar);
        }
    }

    public final void a(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public boolean a() {
        m mVar = (m) this.f134689g.peekLast();
        if (mVar == null) {
            setVisibility(8);
            return false;
        }
        if (mVar.a() || !mVar.c()) {
            return true;
        }
        mVar.onCancel();
        b(mVar);
        return true;
    }

    public Animator a(Animator animator, Interpolator interpolator) {
        animator.setInterpolator(interpolator);
        return animator;
    }

    public Animator a(View view, int i3) {
        if (i3 == 2) {
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(a(ObjectAnimator.ofFloat(view, "translationY", 0.0f, view.getHeight()).setDuration(200L), accelerateInterpolator));
            return animatorSet;
        }
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(view.getContext(), R.anim.f154528mu);
        Interpolator loadInterpolator2 = AnimationUtils.loadInterpolator(view.getContext(), R.anim.f154527mt);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(a(ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.9f).setDuration(220L), loadInterpolator), a(ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.9f).setDuration(220L), loadInterpolator), a(ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(150L), loadInterpolator2));
        return animatorSet2;
    }
}
