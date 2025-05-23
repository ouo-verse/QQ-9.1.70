package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.AnimatorListenerBase;

/* loaded from: classes.dex */
public class HippyOverPullHelper {
    public static final int OVER_PULL_DOWN_ING = 1;
    public static final int OVER_PULL_NONE = 0;
    public static final int OVER_PULL_NORMAL = 3;
    public static final int OVER_PULL_SETTLING = 4;
    public static final int OVER_PULL_UP_ING = 2;

    /* renamed from: a, reason: collision with root package name */
    private final RecyclerView.OnScrollListener f26487a;

    /* renamed from: c, reason: collision with root package name */
    private ValueAnimator f26489c;

    /* renamed from: e, reason: collision with root package name */
    private int f26491e;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerViewBase f26494h;

    /* renamed from: i, reason: collision with root package name */
    private int f26495i;
    protected float lastRawY = -1.0f;
    protected float downRawY = -1.0f;

    /* renamed from: b, reason: collision with root package name */
    private int f26488b = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f26490d = true;

    /* renamed from: f, reason: collision with root package name */
    private boolean f26492f = false;

    /* renamed from: g, reason: collision with root package name */
    private HippyOverPullListener f26493g = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class RollbackUpdateListener implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        int f26498a;

        /* renamed from: b, reason: collision with root package name */
        int f26499b;

        RollbackUpdateListener(int i3) {
            this.f26498a = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (HippyOverPullHelper.this.f26494h.isDataChangedWithoutNotify()) {
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int[] iArr = new int[2];
            int i3 = intValue - this.f26498a;
            HippyOverPullHelper.this.f26494h.scrollStep(0, i3, iArr);
            int i16 = iArr[1];
            this.f26499b += i16;
            int i17 = i16 - i3;
            if (i17 != 0) {
                HippyOverPullHelper.this.f26494h.offsetChildrenVertical(i17);
            }
            HippyOverPullHelper.this.a(4);
            this.f26498a = intValue;
        }
    }

    public HippyOverPullHelper(RecyclerViewBase recyclerViewBase) {
        this.f26491e = -1;
        this.f26494h = recyclerViewBase;
        this.f26491e = recyclerViewBase.getOverScrollMode();
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.HippyOverPullHelper.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
                if (HippyOverPullHelper.this.f26495i != i3 && i3 == 0) {
                    HippyOverPullHelper.this.a();
                }
                HippyOverPullHelper.this.f26495i = i3;
            }
        };
        this.f26487a = onScrollListener;
        recyclerViewBase.addOnScrollListener(onScrollListener);
    }

    private int d() {
        return ViewConfiguration.get(this.f26494h.getContext()).getScaledTouchSlop();
    }

    private void e() {
        int i3 = this.f26491e;
        if (i3 != -1) {
            this.f26494h.setOverScrollMode(i3);
        }
    }

    private int f() {
        int i3 = this.f26488b;
        if (i3 == 1) {
            return getOverPullDownOffset();
        }
        if (i3 == 2) {
            return getOverPullUpOffset();
        }
        return 0;
    }

    private void g() {
        ValueAnimator valueAnimator = this.f26489c;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f26489c.removeAllUpdateListeners();
            this.f26489c.end();
            this.f26489c = null;
        }
        this.f26492f = false;
    }

    private void h() {
        e();
        this.lastRawY = -1.0f;
        this.downRawY = -1.0f;
        a(0);
    }

    boolean c() {
        return this.f26494h.canScrollVertically(1);
    }

    public void destroy() {
        this.f26494h.removeOnScrollListener(this.f26487a);
    }

    public int getOverPullDownOffset() {
        if (this.f26488b == 1) {
            return this.f26494h.computeVerticalScrollOffset();
        }
        return 0;
    }

    public int getOverPullState() {
        return this.f26488b;
    }

    public int getOverPullUpOffset() {
        int computeVerticalScrollOffset = this.f26494h.computeVerticalScrollOffset();
        int height = (this.f26494h.getHeight() + computeVerticalScrollOffset) - this.f26494h.computeVerticalScrollRange();
        if (height > 0 && computeVerticalScrollOffset > 0) {
            return Math.min(height, computeVerticalScrollOffset);
        }
        return 0;
    }

    public void handleEventUp(MotionEvent motionEvent) {
        if (e(motionEvent)) {
            e();
            if (this.f26494h.getScrollState() != 2) {
                a();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f26492f || d(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setOverPullListener(HippyOverPullListener hippyOverPullListener) {
        this.f26493g = hippyOverPullListener;
    }

    private boolean c(MotionEvent motionEvent) {
        return this.lastRawY > 0.0f && Math.abs(motionEvent.getRawY() - this.downRawY) > ((float) d());
    }

    private boolean d(MotionEvent motionEvent) {
        if (!this.f26490d) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.lastRawY = motionEvent.getRawY();
            this.downRawY = motionEvent.getRawY();
        } else if (action != 2) {
            h();
        } else {
            boolean f16 = f(motionEvent);
            boolean g16 = g(motionEvent);
            if (f16 || g16) {
                this.f26494h.setOverScrollMode(2);
                this.f26494h.invalidateGlows();
                if (f16) {
                    a(1);
                } else {
                    a(2);
                }
                this.f26494h.offsetChildrenVertical(((int) (motionEvent.getRawY() - this.lastRawY)) / 2);
                HippyOverPullListener hippyOverPullListener = this.f26493g;
                if (hippyOverPullListener != null) {
                    int i3 = this.f26488b;
                    hippyOverPullListener.onOverPullStateChanged(i3, i3, f());
                }
            } else {
                a(3);
            }
            this.lastRawY = motionEvent.getRawY();
        }
        int i16 = this.f26488b;
        return i16 == 1 || i16 == 2;
    }

    private boolean e(MotionEvent motionEvent) {
        return motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
    }

    private boolean f(MotionEvent motionEvent) {
        if (Math.abs(this.f26494h.computeVerticalScrollOffset()) + Math.abs((int) (motionEvent.getRawY() - this.lastRawY)) + 1 < this.f26494h.getHeight()) {
            return c(motionEvent) && a(motionEvent) && !b();
        }
        return false;
    }

    private boolean g(MotionEvent motionEvent) {
        if (((this.f26494h.computeVerticalScrollOffset() + this.f26494h.getHeight()) - this.f26494h.computeVerticalScrollRange()) + Math.abs((int) (motionEvent.getRawY() - this.lastRawY)) + 1 < this.f26494h.getHeight()) {
            return c(motionEvent) && b(motionEvent) && !c();
        }
        return false;
    }

    boolean b() {
        return this.f26494h.canScrollVertically(-1);
    }

    void a() {
        int computeVerticalScrollOffset = this.f26494h.computeVerticalScrollOffset();
        if (computeVerticalScrollOffset >= 0 && (computeVerticalScrollOffset = getOverPullUpOffset()) == 0) {
            return;
        }
        a(computeVerticalScrollOffset, 0);
    }

    boolean b(MotionEvent motionEvent) {
        return motionEvent.getRawY() - this.lastRawY <= 0.0f;
    }

    void a(int i3) {
        HippyOverPullListener hippyOverPullListener = this.f26493g;
        if (hippyOverPullListener != null) {
            hippyOverPullListener.onOverPullStateChanged(this.f26488b, i3, f());
        }
        this.f26488b = i3;
    }

    private void a(int i3, int i16) {
        g();
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, i16);
        this.f26489c = ofInt;
        ofInt.setInterpolator(new DecelerateInterpolator());
        this.f26489c.addUpdateListener(new RollbackUpdateListener(i3));
        this.f26489c.addListener(new AnimatorListenerBase() { // from class: androidx.recyclerview.widget.HippyOverPullHelper.2
            @Override // com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.AnimatorListenerBase, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                HippyOverPullHelper.this.a(0);
                HippyOverPullHelper.this.f26492f = false;
            }
        });
        this.f26492f = true;
        this.f26489c.setDuration(150L).start();
    }

    boolean a(MotionEvent motionEvent) {
        return motionEvent.getRawY() - this.lastRawY > 0.0f;
    }
}
