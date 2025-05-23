package com.tencent.mobileqq.widget.cardlistview.animation;

import a53.a;
import a53.b;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.widget.cardlistview.QUICardListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUICardListAnimator {

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicBoolean f316817j = new AtomicBoolean(false);

    /* renamed from: k, reason: collision with root package name */
    private static int f316818k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static int f316819l = 0;

    /* renamed from: a, reason: collision with root package name */
    private final Context f316820a;

    /* renamed from: c, reason: collision with root package name */
    private View f316822c;

    /* renamed from: d, reason: collision with root package name */
    private List<f> f316823d;

    /* renamed from: e, reason: collision with root package name */
    private List<d53.b> f316824e;

    /* renamed from: f, reason: collision with root package name */
    private e f316825f;

    /* renamed from: b, reason: collision with root package name */
    private final List<View> f316821b = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private int f316826g = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f316827h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f316828i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends TranslateAnimation {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f316835d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(float f16, float f17, float f18, float f19, View view) {
            super(f16, f17, f18, f19);
            this.f316835d = view;
        }

        @Override // android.view.animation.TranslateAnimation, android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            super.applyTransformation(f16, transformation);
            QUICardListAnimator qUICardListAnimator = QUICardListAnimator.this;
            View view = this.f316835d;
            if (qUICardListAnimator.f316826g != 0) {
                f16 = 1.0f - f16;
            }
            qUICardListAnimator.r(view, f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerViewCompat f316839d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f316840e;

        d(RecyclerViewCompat recyclerViewCompat, int i3) {
            this.f316839d = recyclerViewCompat;
            this.f316840e = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0 && !QUICardListAnimator.this.f316828i) {
                QUICardListAnimator.this.f316828i = true;
                for (int i16 = 0; i16 < this.f316839d.getChildCount(); i16++) {
                    int[] iArr = new int[2];
                    this.f316839d.getChildAt(i16).getLocationInWindow(iArr);
                    if (Math.abs(((this.f316840e - r1.getMeasuredWidth()) / 2) - iArr[0]) < 20.0f) {
                        QUICardListAnimator.f316818k = iArr[0];
                        QUICardListAnimator.f316819l = iArr[1];
                        return;
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface e {
        void onFinish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private final Context f316842a;

        /* renamed from: b, reason: collision with root package name */
        public View f316843b;

        /* renamed from: c, reason: collision with root package name */
        public int f316844c;

        /* renamed from: d, reason: collision with root package name */
        public int f316845d;

        /* renamed from: e, reason: collision with root package name */
        public int f316846e;

        /* renamed from: f, reason: collision with root package name */
        public int f316847f;

        public f(Context context, View view, int i3, int i16, int i17, int i18) {
            this.f316842a = context;
            this.f316843b = view;
            this.f316844c = i3;
            this.f316845d = i3 - i16;
            this.f316846e = i17;
            this.f316847f = i18;
        }

        public boolean a() {
            Context context;
            if (this.f316843b == null || (context = this.f316842a) == null) {
                return true;
            }
            int i3 = context.getResources().getDisplayMetrics().widthPixels;
            int measuredWidth = this.f316843b.getMeasuredWidth();
            int i16 = this.f316846e;
            if (i16 <= i3 && i16 + measuredWidth >= 0) {
                return true;
            }
            return false;
        }
    }

    public QUICardListAnimator(Context context) {
        this.f316820a = context;
        f316817j.set(false);
    }

    private boolean l(int i3) {
        if (f316818k > 0 && f316819l > 0) {
            for (f fVar : this.f316823d) {
                final View view = this.f316821b.get(fVar.f316845d);
                Resources resources = view.getResources();
                final float dimensionPixelSize = f316818k + ((fVar.f316844c - i3) * (resources.getDimensionPixelSize(R.dimen.d_m) + resources.getDimensionPixelSize(R.dimen.f158713n2)));
                view.post(new Runnable() { // from class: com.tencent.mobileqq.widget.cardlistview.animation.QUICardListAnimator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QUICardListAnimator qUICardListAnimator = QUICardListAnimator.this;
                        View view2 = view;
                        qUICardListAnimator.t(view2, view2.getX(), dimensionPixelSize, view.getY(), QUICardListAnimator.f316819l);
                        if (QUICardListAnimator.this.f316822c != null) {
                            QUICardListAnimator.this.f316822c.setVisibility(4);
                        }
                    }
                });
            }
            return true;
        }
        return false;
    }

    private List<f> m(View view) {
        int i3;
        ArrayList arrayList = new ArrayList();
        ViewParent parent = view.getParent();
        while (true) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (!(viewGroup instanceof QUICardListView)) {
                if (viewGroup == null) {
                    return arrayList;
                }
                parent = viewGroup.getParent();
            } else {
                QUICardListView qUICardListView = (QUICardListView) viewGroup;
                int childCount = qUICardListView.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    View findViewById = qUICardListView.getChildAt(i16).findViewById(R.id.f65913_8);
                    if (findViewById != null) {
                        Object tag = findViewById.getTag();
                        if (tag instanceof a.b) {
                            a.b bVar = (a.b) tag;
                            int[] iArr = new int[2];
                            findViewById.getLocationInWindow(iArr);
                            if (bVar.f25545d == 0) {
                                i3 = iArr[0] + view.getResources().getDimensionPixelSize(R.dimen.d_j);
                            } else {
                                i3 = iArr[0];
                            }
                            int i17 = iArr[1];
                            Context context = this.f316820a;
                            int i18 = bVar.f25545d;
                            f fVar = new f(context, findViewById, i18, i18 - i16, i3, i17);
                            if (fVar.a()) {
                                arrayList.add(fVar);
                            }
                        }
                    }
                }
                return arrayList;
            }
        }
    }

    private void n(int i3) {
        int dimensionPixelSize;
        if (l(i3)) {
            return;
        }
        long M = ah.M();
        long L = ah.L();
        Resources resources = this.f316820a.getResources();
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.d_m) + resources.getDimensionPixelSize(R.dimen.f158713n2);
        if (this.f316827h) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.d_k);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.d_l);
        }
        float f16 = (((float) (M - dimensionPixelSize2)) / 2.0f) + 25.0f;
        final float statusBarHeight = (((float) (L - dimensionPixelSize)) + ImmersiveUtils.getStatusBarHeight(this.f316820a)) / 2.0f;
        Iterator<f> it = this.f316823d.iterator();
        while (it.hasNext()) {
            final View view = this.f316821b.get(it.next().f316845d);
            final float f17 = ((r3.f316844c - i3) * dimensionPixelSize2) + f16;
            view.post(new Runnable() { // from class: com.tencent.mobileqq.widget.cardlistview.animation.QUICardListAnimator.2
                @Override // java.lang.Runnable
                public void run() {
                    QUICardListAnimator qUICardListAnimator = QUICardListAnimator.this;
                    View view2 = view;
                    qUICardListAnimator.t(view2, view2.getX(), f17, view.getY(), statusBarHeight);
                    if (QUICardListAnimator.this.f316822c != null) {
                        QUICardListAnimator.this.f316822c.setVisibility(4);
                    }
                }
            });
        }
    }

    private float[] o(float f16, float f17, float f18, float f19) {
        float f26 = f17 - f16;
        float f27 = f19 - f18;
        float[] fArr = {0.0f, f26, 0.0f, f27};
        if (this.f316826g == 1) {
            fArr[0] = f26;
            fArr[1] = 0.0f;
            fArr[2] = f27;
            fArr[3] = 0.0f;
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.f316820a).getWindow().getDecorView().getRootView();
            Iterator<View> it = this.f316821b.iterator();
            while (it.hasNext()) {
                viewGroup.removeView(it.next());
            }
        } catch (Exception e16) {
            QLog.e("QUICardListAnimator", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(View view, float f16) {
        int dimensionPixelSize;
        Resources resources = this.f316820a.getResources();
        d53.a aVar = new d53.a();
        aVar.f393030a = f16;
        aVar.f393031b = resources.getDimensionPixelSize(R.dimen.d_q) + ((resources.getDimensionPixelSize(R.dimen.d_m) - r2) * f16);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.d_n);
        if (this.f316827h) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.d_k);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.d_l);
        }
        aVar.f393032c = dimensionPixelSize2 + ((dimensionPixelSize - dimensionPixelSize2) * f16);
        aVar.f393033d = resources.getDimensionPixelSize(R.dimen.d_h) + ((resources.getDimensionPixelSize(R.dimen.d_e) - r2) * f16);
        aVar.f393034e = resources.getDimensionPixelSize(R.dimen.d_i) + ((resources.getDimensionPixelSize(R.dimen.d_f) - r2) * f16);
        aVar.f393035f = resources.getDimensionPixelSize(R.dimen.d_g) + ((resources.getDimensionPixelSize(R.dimen.d_d) - r2) * f16);
        aVar.f393036g = resources.getDimensionPixelSize(R.dimen.d__);
        b.a aVar2 = new b.a(view, 1);
        d53.b bVar = (d53.b) view.getTag();
        bVar.f393040d = aVar;
        aVar2.b(bVar, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(View view, float f16, float f17, float f18, float f19) {
        float[] o16 = o(f16, f17, f18, f19);
        b bVar = new b(o16[0], o16[1], o16[2], o16[3], view);
        bVar.setDuration(350L);
        bVar.setFillAfter(true);
        bVar.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.setAnimationListener(new c(view));
        view.startAnimation(bVar);
    }

    public void p(RecyclerViewCompat recyclerViewCompat, int i3) {
        List<f> list;
        if (this.f316821b.size() > 0 && (list = this.f316823d) != null && list.size() > 0) {
            View view = null;
            for (f fVar : this.f316823d) {
                if (fVar.f316844c == i3) {
                    view = fVar.f316843b;
                }
            }
            if (view == null) {
                q();
                return;
            }
            this.f316822c = recyclerViewCompat;
            v(1);
            s(view, i3);
            return;
        }
        q();
    }

    public void s(View view, int i3) {
        float f16;
        AtomicBoolean atomicBoolean = f316817j;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        if (this.f316823d == null) {
            this.f316823d = m(view);
        }
        List<f> list = this.f316823d;
        if (list != null && list.size() > 0) {
            this.f316821b.clear();
            for (f fVar : this.f316823d) {
                d53.b a16 = this.f316824e.get(fVar.f316844c).a();
                View inflate = LayoutInflater.from(this.f316820a).inflate(R.layout.hfz, (ViewGroup) null);
                this.f316821b.add(inflate);
                inflate.setOnClickListener(new a());
                ((TextView) inflate.findViewById(R.id.f65933__)).setText(a16.f393038b);
                e53.b.a((ViewGroup) inflate.findViewById(R.id.f65923_9), a16.f393039c);
                a53.a.i((ImageView) inflate.findViewById(R.id.f65893_6), a16.f393037a, true);
                inflate.setTag(a16);
                ViewGroup viewGroup = (ViewGroup) ((Activity) this.f316820a).getWindow().getDecorView().getRootView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = fVar.f316846e;
                layoutParams.topMargin = fVar.f316847f;
                inflate.setVisibility(4);
                viewGroup.addView(inflate, layoutParams);
                if (this.f316826g == 0) {
                    f16 = 0.0f;
                } else {
                    f16 = 1.0f;
                }
                r(inflate, f16);
            }
            n(i3);
            return;
        }
        atomicBoolean.set(false);
    }

    public QUICardListAnimator u(e eVar) {
        this.f316825f = eVar;
        return this;
    }

    public QUICardListAnimator v(int i3) {
        this.f316826g = i3;
        return this;
    }

    public QUICardListAnimator w(List<d53.b> list) {
        this.f316824e = list;
        return this;
    }

    public QUICardListAnimator x(boolean z16) {
        this.f316827h = z16;
        return this;
    }

    public void y(RecyclerViewCompat recyclerViewCompat) {
        if (recyclerViewCompat == null) {
            return;
        }
        recyclerViewCompat.setOnScrollListener(new d(recyclerViewCompat, ViewUtils.getScreenWidth()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f316837d;

        c(View view) {
            this.f316837d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QUICardListAnimator.this.f316826g == 0) {
                QUICardListAnimator.this.r(this.f316837d, 1.0f);
                if (QUICardListAnimator.this.f316825f != null) {
                    QUICardListAnimator.this.f316825f.onFinish();
                }
            } else {
                QUICardListAnimator.this.r(this.f316837d, 0.0f);
            }
            QUICardListAnimator.this.q();
            QUICardListAnimator.f316817j.set(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f316837d.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
