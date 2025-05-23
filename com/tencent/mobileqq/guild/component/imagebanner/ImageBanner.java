package com.tencent.mobileqq.guild.component.imagebanner;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ImageBanner extends FrameLayout {
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private float H;
    private e I;
    private Runnable J;
    private LongClickTask K;
    private long L;
    private float M;
    private float N;
    private boolean P;
    private MotionEvent Q;
    private MotionEvent R;
    private MotionEvent S;
    private MotionEvent T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f215900a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f215901b0;

    /* renamed from: c0, reason: collision with root package name */
    private long f215902c0;

    /* renamed from: d, reason: collision with root package name */
    private ViewPager2 f215903d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f215904d0;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.guild.component.imagebanner.a f215905e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f215906e0;

    /* renamed from: f, reason: collision with root package name */
    private AutoSwitchTask f215907f;

    /* renamed from: f0, reason: collision with root package name */
    private int f215908f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f215909g0;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f215910h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f215911h0;

    /* renamed from: i, reason: collision with root package name */
    private volatile int f215912i;

    /* renamed from: i0, reason: collision with root package name */
    private final CopyOnWriteArrayList<ViewPager2.OnPageChangeCallback> f215913i0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f215914m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class AutoSwitchTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<ImageBanner> f215918d;

        AutoSwitchTask(ImageBanner imageBanner) {
            this.f215918d = new WeakReference<>(imageBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageBanner imageBanner = this.f215918d.get();
            if (imageBanner != null && imageBanner.S() != null) {
                int N = imageBanner.N();
                imageBanner.Y(N);
                int i3 = N + 1;
                if (imageBanner.c0()) {
                    i3 %= imageBanner.O();
                }
                imageBanner.m0(i3);
                imageBanner.postDelayed(imageBanner.f215907f, imageBanner.M() + imageBanner.Q());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class LongClickTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<ImageBanner> f215919d;

        LongClickTask(ImageBanner imageBanner) {
            this.f215919d = new WeakReference<>(imageBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageBanner imageBanner = this.f215919d.get();
            if (imageBanner != null) {
                imageBanner.K();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface e {
        void onItemLongClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface f {
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface g {
    }

    public ImageBanner(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.I != null && !this.P && e0(this.L, System.currentTimeMillis())) {
            this.I.onItemLongClick(this.f215912i);
        }
    }

    private ViewPager2.OnPageChangeCallback L() {
        return new ViewPager2.OnPageChangeCallback() { // from class: com.tencent.mobileqq.guild.component.imagebanner.ImageBanner.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i3) {
                Iterator it = ImageBanner.this.f215913i0.iterator();
                while (it.hasNext()) {
                    ((ViewPager2.OnPageChangeCallback) it.next()).onPageScrollStateChanged(i3);
                }
                if (i3 == 0 && ImageBanner.this.c0() && ImageBanner.this.f215903d != null) {
                    if (ImageBanner.this.f215903d.getCurrentItem() == ImageBanner.this.R() - 1) {
                        QLog.e("ImageBanner", 1, "[onPageScrollStateChanged] -> reset to starPos");
                        ImageBanner.this.f215903d.setCurrentItem(1, false);
                    } else if (ImageBanner.this.f215903d.getCurrentItem() == 0) {
                        QLog.e("ImageBanner", 1, "[onPageScrollStateChanged] -> reset to endPos");
                        ImageBanner.this.f215903d.setCurrentItem(ImageBanner.this.R() - 2, false);
                    }
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i3, float f16, int i16) {
                int P = ImageBanner.this.P(i3);
                Iterator it = ImageBanner.this.f215913i0.iterator();
                while (it.hasNext()) {
                    ((ViewPager2.OnPageChangeCallback) it.next()).onPageScrolled(P, f16, i16);
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i3) {
                boolean z16;
                if (ImageBanner.this.f215912i != -1 || !ImageBanner.this.c0() || ImageBanner.this.f215903d == null) {
                    int i16 = ImageBanner.this.f215912i;
                    ImageBanner imageBanner = ImageBanner.this;
                    imageBanner.f215912i = imageBanner.P(i3);
                    boolean z17 = true;
                    if (ImageBanner.this.f215912i == ImageBanner.this.O() - 1 && ImageBanner.this.O() > 1) {
                        ImageBanner.this.f215908f0++;
                    }
                    Iterator it = ImageBanner.this.f215913i0.iterator();
                    while (it.hasNext()) {
                        ((ViewPager2.OnPageChangeCallback) it.next()).onPageSelected(ImageBanner.this.f215912i);
                    }
                    if (ImageBanner.this.f215905e == null) {
                        return;
                    }
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = ImageBanner.this.f215905e.getRecyclerView().findViewHolderForAdapterPosition(i16);
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = ImageBanner.this.f215905e.getRecyclerView().findViewHolderForAdapterPosition(ImageBanner.this.f215912i);
                    if (findViewHolderForAdapterPosition != null) {
                        ImageBanner.this.f215905e.n0(findViewHolderForAdapterPosition, i16);
                    }
                    if (findViewHolderForAdapterPosition2 != null) {
                        ImageBanner.this.f215905e.m0(findViewHolderForAdapterPosition2, ImageBanner.this.f215912i);
                    }
                    if (ImageBanner.this.f215905e.l0()) {
                        ImageBanner imageBanner2 = ImageBanner.this;
                        if (i3 == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        imageBanner2.D = z16;
                        ImageBanner imageBanner3 = ImageBanner.this;
                        if (i3 != imageBanner3.f215905e.k0() - 1) {
                            z17 = false;
                        }
                        imageBanner3.E = z17;
                    }
                    if (ImageBanner.this.f215906e0 && ImageBanner.this.f215904d0) {
                        ImageBanner.this.n0();
                        ImageBanner.this.f215904d0 = false;
                        return;
                    }
                    return;
                }
                ImageBanner.this.f215903d.post(new Runnable() { // from class: com.tencent.mobileqq.guild.component.imagebanner.ImageBanner.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ImageBanner.this.f215912i == -1) {
                            ImageBanner.this.f215912i = 0;
                            ImageBanner imageBanner4 = ImageBanner.this;
                            imageBanner4.setCurrentItem(imageBanner4.f215912i, false);
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long M() {
        com.tencent.mobileqq.guild.component.imagebanner.a aVar = this.f215905e;
        if (aVar == null) {
            return 1000L;
        }
        return aVar.getAnimationTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int P(int i3) {
        com.tencent.mobileqq.guild.component.imagebanner.a aVar = this.f215905e;
        if (aVar == null) {
            return -1;
        }
        return aVar.getRealPosition(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Q() {
        com.tencent.mobileqq.guild.component.imagebanner.a aVar = this.f215905e;
        if (aVar == null) {
            return 2000L;
        }
        return aVar.getSwitchDurationTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R() {
        com.tencent.mobileqq.guild.component.imagebanner.a aVar = this.f215905e;
        if (aVar == null) {
            QLog.e("ImageBanner", 1, "[getTotalSize] -> mAdapter == null ");
            return 0;
        }
        return aVar.getItemCount();
    }

    private void T(MotionEvent motionEvent) {
        removeCallbacks(this.K);
    }

    private void U(MotionEvent motionEvent) {
        b0(motionEvent);
        a0(motionEvent);
    }

    private void V(MotionEvent motionEvent) {
        boolean z16;
        if (Math.sqrt(Math.pow(Math.abs(motionEvent.getX() - this.M), 2.0d) + Math.pow(Math.abs(motionEvent.getY() - this.N), 2.0d)) > 10.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.P = z16;
        if (z16) {
            removeCallbacks(this.K);
        }
    }

    private boolean W(final MotionEvent motionEvent) {
        removeCallbacks(this.K);
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.component.imagebanner.ImageBanner.3
            @Override // java.lang.Runnable
            public void run() {
                if (!ImageBanner.this.P) {
                    ImageBanner imageBanner = ImageBanner.this;
                    if (!imageBanner.e0(imageBanner.L, System.currentTimeMillis())) {
                        if (ImageBanner.this.U >= 2) {
                            ImageBanner.k(ImageBanner.this);
                        }
                        if (ImageBanner.this.U == 1) {
                            ImageBanner.j(ImageBanner.this);
                        }
                        ImageBanner.this.U = 0;
                        ImageBanner.this.Q = null;
                        ImageBanner.this.R = null;
                        ImageBanner.this.S = null;
                        ImageBanner.this.T = null;
                        ImageBanner.this.f215911h0 = false;
                    }
                }
            }
        };
        this.J = runnable;
        postDelayed(runnable, 300L);
        if (this.R == null) {
            this.R = MotionEvent.obtain(motionEvent);
        }
        MotionEvent motionEvent2 = this.T;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.T = obtain;
        if (f0(obtain, this.S)) {
            this.f215904d0 = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean X(MotionEvent motionEvent) {
        float x16 = motionEvent.getX() - this.H;
        if (this.f215914m) {
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
    public void Y(int i3) {
        int O = O();
        if (i3 == O - 1 && O > 1) {
            j0(2, false);
        }
    }

    private void Z(Context context) {
        this.f215907f = new AutoSwitchTask(this);
        this.K = new LongClickTask(this);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.V = scaledDoubleTapSlop;
        this.W = scaledDoubleTapSlop * scaledDoubleTapSlop;
        this.f215900a0 = viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.f215903d = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f215903d.registerOnPageChangeCallback(L());
        addView(this.f215903d);
    }

    private void a0(MotionEvent motionEvent) {
        if (this.f215903d == null) {
            return;
        }
        this.H = motionEvent.getX();
        this.F = this.f215903d.getLeft();
        this.G = this.f215903d.getRight();
    }

    private void b0(MotionEvent motionEvent) {
        this.L = System.currentTimeMillis();
        this.M = motionEvent.getX();
        this.N = motionEvent.getY();
        this.P = false;
        if (this.Q == null) {
            this.Q = MotionEvent.obtain(motionEvent);
            this.U = 1;
        }
        if (this.U >= 1 && d0(this.S, this.T, motionEvent)) {
            this.U++;
        }
        if (this.U == 1) {
            postDelayed(this.K, 500L);
        }
        MotionEvent motionEvent2 = this.S;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.S = MotionEvent.obtain(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c0() {
        com.tencent.mobileqq.guild.component.imagebanner.a aVar = this.f215905e;
        if (aVar != null && aVar.isCanLoop()) {
            return true;
        }
        return false;
    }

    private boolean d0(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (motionEvent == null || motionEvent2 == null || motionEvent3.getEventTime() - motionEvent2.getEventTime() > 300 || f0(motionEvent, motionEvent2)) {
            return false;
        }
        int x16 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y16 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        if ((x16 * x16) + (y16 * y16) >= this.W) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e0(long j3, long j16) {
        if (j16 - j3 >= 500) {
            return true;
        }
        return false;
    }

    private boolean f0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        int x16 = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
        int y16 = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
        if ((x16 * x16) + (y16 * y16) <= this.f215900a0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(AtomicInteger atomicInteger, ValueAnimator valueAnimator) {
        if (this.f215903d == null) {
            return;
        }
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            this.f215903d.fakeDragBy(-(intValue - atomicInteger.get()));
        } catch (Exception e16) {
            QLog.e("ImageBanner", 1, "fakeDragBy error:", e16);
        }
        atomicInteger.set(intValue);
    }

    private boolean h0(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        int abs = (int) ((x16 - this.H) / ((Math.abs(this.f215903d.getLeft()) / 100.0f) + 2.0f));
        int left = this.f215903d.getLeft() + abs;
        int right = abs + this.f215903d.getRight();
        QLog.d("ImageBanner", 1, "[onActionMove] -> left = " + left + " , right = " + right);
        if ((this.D && left > 0) || (this.E && left < 0)) {
            ViewPager2 viewPager2 = this.f215903d;
            viewPager2.layout(left, viewPager2.getTop(), right, this.f215903d.getBottom());
            this.H = x16;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    static /* bridge */ /* synthetic */ c j(ImageBanner imageBanner) {
        imageBanner.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ d k(ImageBanner imageBanner) {
        imageBanner.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ g l(ImageBanner imageBanner) {
        imageBanner.getClass();
        return null;
    }

    private void l0() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.f215903d.getLeft() - this.F, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.f215903d.startAnimation(translateAnimation);
        ViewPager2 viewPager2 = this.f215903d;
        viewPager2.layout(this.F, viewPager2.getTop(), this.G, this.f215903d.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(int i3) {
        int i16;
        if (this.f215912i == i3) {
            QLog.e("ImageBanner", 1, "[setCurrentItemWithAnimation] -> mCurrentPos == mCurrentPos ");
            return;
        }
        if (O() <= i3) {
            QLog.e("ImageBanner", 1, "[setCurrentItemWithAnimation] -> getDataSize()() <= pos , getDataSize()() == " + O() + " , pos == " + i3);
            return;
        }
        if (this.f215903d == null) {
            QLog.e("ImageBanner", 1, "[setCurrentItemWithAnimation] -> mViewPager2 == null ");
            return;
        }
        if (c0()) {
            if (this.f215912i == O() - 1 && i3 == 0) {
                i16 = R() - 1;
            } else {
                i16 = i3 + 1;
            }
        } else {
            i16 = i3;
        }
        if (c0() && this.f215903d.getCurrentItem() == this.f215905e.getItemCount() - 1) {
            if (this.f215903d.isFakeDragging()) {
                this.f215903d.endFakeDrag();
            }
            this.f215903d.setCurrentItem(1, false);
        }
        final AtomicInteger atomicInteger = new AtomicInteger();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.f215903d.getWidth() * (i16 - this.f215903d.getCurrentItem()));
        this.f215910h = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.component.imagebanner.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ImageBanner.this.g0(atomicInteger, valueAnimator);
            }
        });
        this.f215910h.addListener(new a(i3));
        this.f215910h.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f215910h.setDuration(M());
        this.f215910h.start();
    }

    private void o0() {
        removeCallbacks(this.f215907f);
        ValueAnimator valueAnimator = this.f215910h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f215909g0 = false;
    }

    public int N() {
        return this.f215912i;
    }

    public int O() {
        com.tencent.mobileqq.guild.component.imagebanner.a aVar = this.f215905e;
        if (aVar == null) {
            return 0;
        }
        return aVar.k0();
    }

    public ViewPager2 S() {
        return this.f215903d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f215914m) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 5) {
                            T(motionEvent);
                        } else {
                            this.f215911h0 = true;
                        }
                    } else {
                        V(motionEvent);
                    }
                } else {
                    return W(motionEvent);
                }
            } else {
                if (this.C) {
                    o0();
                    j0(3, false);
                }
                U(motionEvent);
                this.f215911h0 = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void i0(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f215913i0.add(onPageChangeCallback);
    }

    public void n0() {
        if (this.f215905e == null) {
            QLog.e("ImageBanner", 1, "[start] -> mAdapter == null ");
            return;
        }
        QLog.e("ImageBanner", 1, "[updatePicListPosition] start->  " + N());
        o0();
        postDelayed(this.f215907f, Q());
        this.f215909g0 = true;
        k0(N());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        QLog.d("ImageBanner", 4, "[onInterceptTouchEvent] -> MotionEvent = " + motionEvent.getAction());
        if (this.f215914m && motionEvent.getAction() == 2) {
            return X(motionEvent);
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
        QLog.d("ImageBanner", 4, "[onTouchEvent] -> MotionEvent = " + motionEvent.getAction());
        if (this.f215903d != null && this.f215914m && (this.D || this.E)) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    return h0(motionEvent);
                }
            }
            l0();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdapter(com.tencent.mobileqq.guild.component.imagebanner.a aVar) {
        ViewPager2 viewPager2 = this.f215903d;
        if (viewPager2 == null) {
            QLog.e("ImageBanner", 1, "[setAdapter] -> mViewPager2 == null ");
        } else {
            this.f215905e = aVar;
            viewPager2.setAdapter(aVar);
        }
    }

    public void setCurrentItem(int i3) {
        setCurrentItem(i3, true);
    }

    public void setEnableLoopAfterUserSlide(boolean z16) {
        this.f215906e0 = z16;
    }

    public void setEnableOperate(boolean z16) {
        this.f215903d.setUserInputEnabled(z16);
        this.f215914m = z16;
    }

    public void setOnItemLongClickListener(e eVar) {
        this.I = eVar;
    }

    public void setPageTransformer(ViewPager2.PageTransformer pageTransformer) {
        ViewPager2 viewPager2 = this.f215903d;
        if (viewPager2 == null) {
            return;
        }
        viewPager2.setPageTransformer(pageTransformer);
    }

    public void setStopBanner(boolean z16) {
        this.C = z16;
    }

    public void setVpPadding(int i3, int i16, int i17, int i18) {
        ViewPager2 viewPager2 = this.f215903d;
        if (viewPager2 == null) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) viewPager2.getChildAt(0);
        recyclerView.setPadding(i3, i16, i17, i18);
        recyclerView.setClipToPadding(false);
    }

    public ImageBanner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCurrentItem(int i3, boolean z16) {
        if (this.f215912i == i3) {
            return;
        }
        if (O() <= i3) {
            QLog.e("ImageBanner", 1, "[setCurrentItem] -> getDataSize()() <= pos , getDataSize()() == " + O() + " , pos == " + i3);
            return;
        }
        ViewPager2 viewPager2 = this.f215903d;
        if (viewPager2 == null) {
            QLog.e("ImageBanner", 1, "[setCurrentItem] -> mViewPager2 == null ");
            return;
        }
        if (viewPager2.isFakeDragging()) {
            this.f215903d.endFakeDrag();
        }
        if (z16) {
            m0(i3);
            return;
        }
        if (c0()) {
            i3 = (this.f215912i == O() - 1 && i3 == 0) ? R() - 1 : i3 + 1;
        }
        this.f215903d.setCurrentItem(i3, false);
    }

    public ImageBanner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f215912i = -1;
        this.f215914m = true;
        this.C = false;
        this.D = false;
        this.E = false;
        this.L = 0L;
        this.M = 0.0f;
        this.N = 0.0f;
        this.P = false;
        this.f215901b0 = 0L;
        this.f215902c0 = 0L;
        this.f215906e0 = false;
        this.f215913i0 = new CopyOnWriteArrayList<>();
        Z(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f215920d;

        a(int i3) {
            this.f215920d = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ImageBanner.this.f215903d.endFakeDrag();
            if (ImageBanner.this.f215912i == 0 && ImageBanner.this.O() > 1) {
                ImageBanner.this.k0(0);
            }
            ImageBanner.l(ImageBanner.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ImageBanner.this.f215903d.beginFakeDrag();
            ImageBanner.l(ImageBanner.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(int i3) {
    }

    public void setOnItemClickListener(c cVar) {
    }

    public void setOnItemDoubleClickListener(d dVar) {
    }

    public void setOnLoopStateListener(f fVar) {
    }

    public void setOnSwitchListener(g gVar) {
    }

    public void setStatusListener(b bVar) {
    }

    private void j0(int i3, boolean z16) {
    }
}
