package com.tencent.biz.qqcircle.immersive.views.banner;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSImageBanner extends FrameLayout implements QFSViewPager.b {
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private float H;
    private d I;
    private c J;
    private e K;
    private f L;
    private b M;
    private h N;
    private g P;
    private Runnable Q;
    private LongClickTask R;
    private long S;
    private float T;
    private float U;
    private boolean V;
    private MotionEvent W;

    /* renamed from: a0, reason: collision with root package name */
    private MotionEvent f90525a0;

    /* renamed from: b0, reason: collision with root package name */
    private MotionEvent f90526b0;

    /* renamed from: c0, reason: collision with root package name */
    private MotionEvent f90527c0;

    /* renamed from: d, reason: collision with root package name */
    private ViewPager2 f90528d;

    /* renamed from: d0, reason: collision with root package name */
    private int f90529d0;

    /* renamed from: e, reason: collision with root package name */
    private k f90530e;

    /* renamed from: e0, reason: collision with root package name */
    private int f90531e0;

    /* renamed from: f, reason: collision with root package name */
    private AutoSwitchTask f90532f;

    /* renamed from: f0, reason: collision with root package name */
    private int f90533f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f90534g0;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f90535h;

    /* renamed from: h0, reason: collision with root package name */
    private long f90536h0;

    /* renamed from: i, reason: collision with root package name */
    private volatile int f90537i;

    /* renamed from: i0, reason: collision with root package name */
    private long f90538i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f90539j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f90540k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f90541l0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f90542m;

    /* renamed from: m0, reason: collision with root package name */
    private int f90543m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f90544n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f90545o0;

    /* renamed from: p0, reason: collision with root package name */
    private float f90546p0;

    /* renamed from: q0, reason: collision with root package name */
    private final CopyOnWriteArrayList<ViewPager2.OnPageChangeCallback> f90547q0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class AutoSwitchTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QFSImageBanner> f90551d;

        AutoSwitchTask(QFSImageBanner qFSImageBanner) {
            this.f90551d = new WeakReference<>(qFSImageBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSImageBanner qFSImageBanner = this.f90551d.get();
            if (qFSImageBanner != null && qFSImageBanner.X() != null) {
                int S = qFSImageBanner.S();
                qFSImageBanner.d0(S);
                int i3 = S + 1;
                if (qFSImageBanner.h0()) {
                    i3 %= qFSImageBanner.T();
                }
                qFSImageBanner.u0(i3);
                qFSImageBanner.postDelayed(qFSImageBanner.f90532f, qFSImageBanner.R() + qFSImageBanner.V());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class LongClickTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QFSImageBanner> f90552d;

        LongClickTask(QFSImageBanner qFSImageBanner) {
            this.f90552d = new WeakReference<>(qFSImageBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSImageBanner qFSImageBanner = this.f90552d.get();
            if (qFSImageBanner != null) {
                qFSImageBanner.P();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, int i3, int i16, int i17, boolean z16);

        void b(View view, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        void onItemClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface d {
        void a(float f16, float f17);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface e {
        void onItemLongClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface g {
        void a(float f16);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface h {
        void a(int i3);

        void b(int i3);

        void c();
    }

    public QFSImageBanner(@NonNull Context context) {
        this(context, null);
    }

    private void A0() {
        removeCallbacks(this.f90532f);
        ValueAnimator valueAnimator = this.f90535h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f90544n0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (this.K != null && !this.V && j0(this.S, System.currentTimeMillis())) {
            this.K.onItemLongClick(this.f90537i);
        }
    }

    private ViewPager2.OnPageChangeCallback Q() {
        return new ViewPager2.OnPageChangeCallback() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i3) {
                Iterator it = QFSImageBanner.this.f90547q0.iterator();
                while (it.hasNext()) {
                    ((ViewPager2.OnPageChangeCallback) it.next()).onPageScrollStateChanged(i3);
                }
                if (i3 != 0) {
                    return;
                }
                VideoReport.traverseExposure();
                if (QFSImageBanner.this.h0() && QFSImageBanner.this.f90528d != null) {
                    if (QFSImageBanner.this.f90528d.getCurrentItem() == QFSImageBanner.this.W() - 1) {
                        QLog.e("QFSImageBanner", 1, "[onPageScrollStateChanged] -> reset to starPos");
                        QFSImageBanner.this.f90528d.setCurrentItem(1, false);
                    } else if (QFSImageBanner.this.f90528d.getCurrentItem() == 0) {
                        QLog.e("QFSImageBanner", 1, "[onPageScrollStateChanged] -> reset to endPos");
                        QFSImageBanner.this.f90528d.setCurrentItem(QFSImageBanner.this.W() - 2, false);
                    }
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i3, float f16, int i16) {
                int U = QFSImageBanner.this.U(i3);
                Iterator it = QFSImageBanner.this.f90547q0.iterator();
                while (it.hasNext()) {
                    ((ViewPager2.OnPageChangeCallback) it.next()).onPageScrolled(U, f16, i16);
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i3) {
                boolean z16;
                if (QFSImageBanner.this.f90537i != -1 || !QFSImageBanner.this.h0() || QFSImageBanner.this.f90528d == null) {
                    int i16 = QFSImageBanner.this.f90537i;
                    QFSImageBanner qFSImageBanner = QFSImageBanner.this;
                    qFSImageBanner.f90537i = qFSImageBanner.U(i3);
                    boolean z17 = true;
                    if (QFSImageBanner.this.f90537i == QFSImageBanner.this.T() - 1 && QFSImageBanner.this.T() > 1) {
                        QFSImageBanner.this.f90541l0++;
                    }
                    Iterator it = QFSImageBanner.this.f90547q0.iterator();
                    while (it.hasNext()) {
                        ((ViewPager2.OnPageChangeCallback) it.next()).onPageSelected(QFSImageBanner.this.f90537i);
                    }
                    if (QFSImageBanner.this.f90530e == null) {
                        return;
                    }
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = QFSImageBanner.this.f90530e.getRecyclerView().findViewHolderForAdapterPosition(i16);
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = QFSImageBanner.this.f90530e.getRecyclerView().findViewHolderForAdapterPosition(QFSImageBanner.this.f90537i);
                    if (findViewHolderForAdapterPosition != null) {
                        QFSImageBanner.this.f90530e.p0(findViewHolderForAdapterPosition, i16);
                    }
                    if (findViewHolderForAdapterPosition2 != null) {
                        QFSImageBanner.this.f90530e.o0(findViewHolderForAdapterPosition2, QFSImageBanner.this.f90537i);
                    }
                    if (QFSImageBanner.this.f90530e.m0()) {
                        QFSImageBanner qFSImageBanner2 = QFSImageBanner.this;
                        if (i3 == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        qFSImageBanner2.D = z16;
                        QFSImageBanner qFSImageBanner3 = QFSImageBanner.this;
                        if (i3 != qFSImageBanner3.f90530e.k0() - 1) {
                            z17 = false;
                        }
                        qFSImageBanner3.E = z17;
                    }
                    if (QFSImageBanner.this.f90540k0 && QFSImageBanner.this.f90539j0) {
                        QFSImageBanner.this.v0();
                        QFSImageBanner.this.f90539j0 = false;
                        return;
                    }
                    return;
                }
                QFSImageBanner.this.f90528d.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QFSImageBanner.this.f90537i == -1) {
                            QFSImageBanner.this.f90537i = 0;
                            QFSImageBanner qFSImageBanner4 = QFSImageBanner.this;
                            qFSImageBanner4.setCurrentItem(qFSImageBanner4.f90537i, false);
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long R() {
        long j3;
        k kVar = this.f90530e;
        if (kVar != null) {
            j3 = kVar.getAnimationTime();
        } else {
            j3 = 1000;
        }
        if (this.f90546p0 > 0.0f) {
            return ((float) j3) / r2;
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int U(int i3) {
        k kVar = this.f90530e;
        if (kVar == null) {
            return -1;
        }
        return kVar.getRealPosition(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long V() {
        long j3;
        k kVar = this.f90530e;
        if (kVar != null) {
            j3 = kVar.getSwitchDurationTime();
        } else {
            j3 = 2000;
        }
        if (this.f90546p0 > 0.0f) {
            return ((float) j3) / r2;
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int W() {
        k kVar = this.f90530e;
        if (kVar == null) {
            QLog.e("QFSImageBanner", 1, "[getTotalSize] -> mAdapter == null ");
            return 0;
        }
        return kVar.getItemCount();
    }

    private void Y(MotionEvent motionEvent) {
        removeCallbacks(this.R);
    }

    private void Z(MotionEvent motionEvent) {
        g0(motionEvent);
        f0(motionEvent);
    }

    private void a0(MotionEvent motionEvent) {
        boolean z16;
        if (Math.sqrt(Math.pow(Math.abs(motionEvent.getX() - this.T), 2.0d) + Math.pow(Math.abs(motionEvent.getY() - this.U), 2.0d)) > 10.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.V = z16;
        if (z16) {
            removeCallbacks(this.R);
        }
    }

    private boolean b0(final MotionEvent motionEvent) {
        removeCallbacks(this.R);
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.3
            @Override // java.lang.Runnable
            public void run() {
                if (!QFSImageBanner.this.V) {
                    QFSImageBanner qFSImageBanner = QFSImageBanner.this;
                    if (!qFSImageBanner.j0(qFSImageBanner.S, System.currentTimeMillis())) {
                        if (QFSImageBanner.this.f90529d0 >= 2 && QFSImageBanner.this.I != null) {
                            if (!QFSImageBanner.this.m0()) {
                                return;
                            }
                            QFSImageBanner.this.f90536h0 = System.currentTimeMillis();
                            QFSImageBanner.this.I.a(motionEvent.getX(), motionEvent.getY());
                        } else if (QFSImageBanner.this.f90529d0 == 1 && QFSImageBanner.this.J != null && !QFSImageBanner.this.f90545o0) {
                            if (!QFSImageBanner.this.n0()) {
                                return;
                            }
                            QFSImageBanner.this.f90538i0 = System.currentTimeMillis();
                            QFSImageBanner.this.J.onItemClick(QFSImageBanner.this.f90537i);
                        }
                        QFSImageBanner.this.f90529d0 = 0;
                        QFSImageBanner.this.W = null;
                        QFSImageBanner.this.f90525a0 = null;
                        QFSImageBanner.this.f90526b0 = null;
                        QFSImageBanner.this.f90527c0 = null;
                        QFSImageBanner.this.f90545o0 = false;
                    }
                }
            }
        };
        this.Q = runnable;
        postDelayed(runnable, 300L);
        if (this.f90525a0 == null) {
            this.f90525a0 = MotionEvent.obtain(motionEvent);
        }
        MotionEvent motionEvent2 = this.f90527c0;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.f90527c0 = obtain;
        if (k0(obtain, this.f90526b0)) {
            h hVar = this.N;
            if (hVar != null) {
                hVar.c();
            }
            this.f90539j0 = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean c0(MotionEvent motionEvent) {
        float x16 = motionEvent.getX() - this.H;
        if (this.f90542m) {
            if (!this.D || x16 <= 0.0f) {
                if (this.E && x16 < 0.0f) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i3) {
        int T = T();
        if (i3 != T - 1) {
            return;
        }
        f fVar = this.L;
        if (fVar != null) {
            fVar.a();
        }
        if (T > 1) {
            r0(2, false);
        }
    }

    private void e0(Context context) {
        this.f90532f = new AutoSwitchTask(this);
        this.R = new LongClickTask(this);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.f90531e0 = scaledDoubleTapSlop;
        this.f90533f0 = scaledDoubleTapSlop * scaledDoubleTapSlop;
        this.f90534g0 = viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.f90528d = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f90528d.registerOnPageChangeCallback(Q());
        addView(this.f90528d);
    }

    private void f0(MotionEvent motionEvent) {
        if (this.f90528d == null) {
            return;
        }
        this.H = motionEvent.getX();
        this.F = this.f90528d.getLeft();
        this.G = this.f90528d.getRight();
    }

    private void g0(MotionEvent motionEvent) {
        this.S = System.currentTimeMillis();
        this.T = motionEvent.getX();
        this.U = motionEvent.getY();
        this.V = false;
        if (this.W == null) {
            this.W = MotionEvent.obtain(motionEvent);
            this.f90529d0 = 1;
        }
        if (this.f90529d0 >= 1 && i0(this.f90526b0, this.f90527c0, motionEvent)) {
            this.f90529d0++;
        }
        if (this.f90529d0 == 1) {
            postDelayed(this.R, 500L);
        }
        MotionEvent motionEvent2 = this.f90526b0;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.f90526b0 = MotionEvent.obtain(motionEvent);
    }

    private boolean i0(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (motionEvent == null || motionEvent2 == null || motionEvent3.getEventTime() - motionEvent2.getEventTime() > 300 || k0(motionEvent, motionEvent2)) {
            return false;
        }
        int x16 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y16 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        if ((x16 * x16) + (y16 * y16) >= this.f90533f0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j0(long j3, long j16) {
        if (j16 - j3 >= 500) {
            return true;
        }
        return false;
    }

    private boolean k0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        int x16 = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
        int y16 = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
        if ((x16 * x16) + (y16 * y16) <= this.f90534g0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m0() {
        if (System.currentTimeMillis() - this.f90538i0 >= 560) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n0() {
        if (System.currentTimeMillis() - this.f90536h0 >= 500) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(AtomicInteger atomicInteger, ValueAnimator valueAnimator) {
        if (this.f90528d == null) {
            return;
        }
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            this.f90528d.fakeDragBy(-(intValue - atomicInteger.get()));
        } catch (Exception e16) {
            QLog.e("QFSImageBanner", 1, "fakeDragBy error:", e16);
        }
        atomicInteger.set(intValue);
    }

    private boolean p0(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        int abs = (int) ((x16 - this.H) / ((Math.abs(this.f90528d.getLeft()) / 100.0f) + 2.0f));
        int left = this.f90528d.getLeft() + abs;
        int right = abs + this.f90528d.getRight();
        QLog.d("QFSImageBanner", 1, "[onActionMove] -> left = " + left + " , right = " + right);
        if ((this.D && left > 0) || (this.E && left < 0)) {
            ViewPager2 viewPager2 = this.f90528d;
            viewPager2.layout(left, viewPager2.getTop(), right, this.f90528d.getBottom());
            this.H = x16;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void r0(int i3, boolean z16) {
        b bVar = this.M;
        if (bVar == null) {
            return;
        }
        bVar.a(this, S(), i3, this.f90541l0, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(int i3) {
        b bVar = this.M;
        if (bVar == null) {
            return;
        }
        this.f90543m0 = i3;
        bVar.b(this, i3, this.f90541l0);
    }

    private void t0() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.f90528d.getLeft() - this.F, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.f90528d.startAnimation(translateAnimation);
        ViewPager2 viewPager2 = this.f90528d;
        viewPager2.layout(this.F, viewPager2.getTop(), this.G, this.f90528d.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i3) {
        int i16;
        if (this.f90537i == i3) {
            QLog.e("QFSImageBanner", 1, "[setCurrentItemWithAnimation] -> mCurrentPos == mCurrentPos ");
            return;
        }
        if (T() <= i3) {
            QLog.e("QFSImageBanner", 1, "[setCurrentItemWithAnimation] -> getDataSize()() <= pos , getDataSize()() == " + T() + " , pos == " + i3);
            return;
        }
        if (this.f90528d == null) {
            QLog.e("QFSImageBanner", 1, "[setCurrentItemWithAnimation] -> mViewPager2 == null ");
            return;
        }
        if (h0()) {
            if (this.f90537i == T() - 1 && i3 == 0) {
                i16 = W() - 1;
            } else {
                i16 = i3 + 1;
            }
        } else {
            i16 = i3;
        }
        if (h0() && this.f90528d.getCurrentItem() == this.f90530e.getItemCount() - 1) {
            if (this.f90528d.isFakeDragging()) {
                this.f90528d.endFakeDrag();
            }
            this.f90528d.setCurrentItem(1, false);
        }
        final AtomicInteger atomicInteger = new AtomicInteger();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.f90528d.getWidth() * (i16 - this.f90528d.getCurrentItem()));
        this.f90535h = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSImageBanner.this.o0(atomicInteger, valueAnimator);
            }
        });
        this.f90535h.addListener(new a(i3));
        this.f90535h.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f90535h.setDuration(R());
        this.f90535h.start();
    }

    public int S() {
        return this.f90537i;
    }

    public int T() {
        k kVar = this.f90530e;
        if (kVar == null) {
            return 0;
        }
        return kVar.k0();
    }

    public ViewPager2 X() {
        return this.f90528d;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSViewPager.b
    public boolean a(boolean z16, int i3, int i16, int i17) {
        return !this.f90542m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f90546p0 != 1.0f) {
            return true;
        }
        if (this.f90542m) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 5) {
                            Y(motionEvent);
                        } else {
                            this.f90545o0 = true;
                        }
                    } else {
                        a0(motionEvent);
                    }
                } else {
                    return b0(motionEvent);
                }
            } else {
                if (this.C) {
                    A0();
                    r0(3, false);
                }
                Z(motionEvent);
                this.f90545o0 = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean h0() {
        k kVar = this.f90530e;
        if (kVar != null && kVar.isCanLoop()) {
            return true;
        }
        return false;
    }

    public boolean l0() {
        return this.f90544n0;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        QLog.d("QFSImageBanner", 4, "[onInterceptTouchEvent] -> MotionEvent = " + motionEvent.getAction());
        if (this.f90542m && motionEvent.getAction() == 2) {
            return c0(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        QLog.d("QFSImageBanner", 4, "[onTouchEvent] -> MotionEvent = " + motionEvent.getAction());
        if (this.f90528d != null && this.f90542m && (this.D || this.E)) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    return p0(motionEvent);
                }
            }
            t0();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void q0(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f90547q0.add(onPageChangeCallback);
    }

    public void setAdapter(k kVar) {
        ViewPager2 viewPager2 = this.f90528d;
        if (viewPager2 == null) {
            QLog.e("QFSImageBanner", 1, "[setAdapter] -> mViewPager2 == null ");
        } else {
            this.f90530e = kVar;
            viewPager2.setAdapter(kVar);
        }
    }

    public void setCurrentItem(int i3) {
        setCurrentItem(i3, true);
    }

    public void setCurrentItemWhenModeChange(int i3) {
        if (T() <= i3) {
            QLog.e("QFSImageBanner", 1, "[setCurrentItemWhenModeChange] -> getDataSize()() <= pos , getDataSize()() == " + T() + " , pos == " + i3);
            return;
        }
        ViewPager2 viewPager2 = this.f90528d;
        if (viewPager2 == null) {
            QLog.e("QFSImageBanner", 1, "[setCurrentItemWhenModeChange] -> mViewPager2 == null ");
            return;
        }
        if (viewPager2.isFakeDragging()) {
            this.f90528d.endFakeDrag();
        }
        if (h0()) {
            i3++;
        }
        this.f90528d.setCurrentItem(i3, false);
    }

    public void setEnableLoopAfterUserSlide(boolean z16) {
        this.f90540k0 = z16;
    }

    public void setEnableOperate(boolean z16) {
        this.f90528d.setUserInputEnabled(z16);
        this.f90542m = z16;
    }

    public void setOnItemClickListener(c cVar) {
        this.J = cVar;
    }

    public void setOnItemDoubleClickListener(d dVar) {
        this.I = dVar;
    }

    public void setOnItemLongClickListener(e eVar) {
        this.K = eVar;
    }

    public void setOnLoopStateListener(f fVar) {
        this.L = fVar;
    }

    public void setOnPlayRateListener(g gVar) {
        this.P = gVar;
    }

    public void setOnSwitchListener(h hVar) {
        this.N = hVar;
    }

    public void setPageTransformer(ViewPager2.PageTransformer pageTransformer) {
        ViewPager2 viewPager2 = this.f90528d;
        if (viewPager2 == null) {
            return;
        }
        viewPager2.setPageTransformer(pageTransformer);
    }

    public void setPlayRate(float f16) {
        this.f90546p0 = f16;
        g gVar = this.P;
        if (gVar != null) {
            gVar.a(f16);
        }
    }

    public void setStatusListener(b bVar) {
        this.M = bVar;
    }

    public void setStopBanner(boolean z16) {
        this.C = z16;
    }

    public void setVpPadding(int i3, int i16, int i17, int i18) {
        ViewPager2 viewPager2 = this.f90528d;
        if (viewPager2 == null) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) viewPager2.getChildAt(0);
        recyclerView.setPadding(i3, i16, i17, i18);
        recyclerView.setClipToPadding(false);
    }

    public void v0() {
        if (this.f90530e == null) {
            QLog.e("QFSImageBanner", 1, "[start] -> mAdapter == null ");
            return;
        }
        QLog.e("QFSImageBanner", 1, "[updatePicListPosition] start->  " + S());
        A0();
        postDelayed(this.f90532f, V());
        this.f90544n0 = true;
        s0(S());
    }

    public void w0(int i3) {
        setCurrentItem(i3, false);
        s0(i3);
    }

    public void x0(int i3) {
        ViewPager2 viewPager2;
        if (this.f90530e != null && (viewPager2 = this.f90528d) != null) {
            if (viewPager2.isFakeDragging()) {
                this.f90528d.endFakeDrag();
            }
            this.f90537i = i3;
            this.f90528d.setCurrentItem(i3, false);
            removeCallbacks(this.f90532f);
            postDelayed(this.f90532f, V());
            this.f90544n0 = true;
            s0(S());
            return;
        }
        QLog.e("QFSImageBanner", 1, "[start] -> mAdapter == null ");
    }

    public void y0() {
        z0(false);
    }

    public void z0(boolean z16) {
        A0();
        r0(2, z16);
        if (z16) {
            this.f90541l0 = 0;
            this.f90543m0 = 0;
            this.f90537i = -1;
            this.f90528d.setCurrentItem(0, false);
        }
    }

    public QFSImageBanner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCurrentItem(int i3, boolean z16) {
        if (this.f90537i == i3) {
            return;
        }
        if (T() <= i3) {
            QLog.e("QFSImageBanner", 1, "[setCurrentItem] -> getDataSize()() <= pos , getDataSize()() == " + T() + " , pos == " + i3);
            return;
        }
        ViewPager2 viewPager2 = this.f90528d;
        if (viewPager2 == null) {
            QLog.e("QFSImageBanner", 1, "[setCurrentItem] -> mViewPager2 == null ");
            return;
        }
        if (viewPager2.isFakeDragging()) {
            this.f90528d.endFakeDrag();
        }
        if (z16) {
            u0(i3);
            return;
        }
        this.f90537i = i3;
        if (h0()) {
            i3 = (this.f90537i == T() - 1 && i3 == 0) ? W() - 1 : i3 + 1;
        }
        this.f90528d.setCurrentItem(i3, false);
    }

    public QFSImageBanner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f90537i = -1;
        this.f90542m = true;
        this.C = false;
        this.D = false;
        this.E = false;
        this.S = 0L;
        this.T = 0.0f;
        this.U = 0.0f;
        this.V = false;
        this.f90536h0 = 0L;
        this.f90538i0 = 0L;
        this.f90540k0 = false;
        this.f90546p0 = 1.0f;
        this.f90547q0 = new CopyOnWriteArrayList<>();
        e0(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f90553d;

        a(int i3) {
            this.f90553d = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSImageBanner.this.f90528d.endFakeDrag();
            if (QFSImageBanner.this.f90537i == 0 && QFSImageBanner.this.T() > 1) {
                QFSImageBanner.this.s0(0);
            }
            if (QFSImageBanner.this.N != null) {
                QFSImageBanner.this.N.b(this.f90553d);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSImageBanner.this.f90528d.beginFakeDrag();
            if (QFSImageBanner.this.N != null) {
                QFSImageBanner.this.N.a(this.f90553d);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
