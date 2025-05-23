package com.tencent.mobileqq.kandian.biz.video.view;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

/* loaded from: classes33.dex */
public class ReadInJoyPullToZoomListView extends ReadInJoyBaseListView {

    /* renamed from: a0, reason: collision with root package name */
    private static boolean f239756a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    private static final Interpolator f239757b0 = new a();
    private View I;
    private boolean J;
    private FrameLayout K;
    private TextView L;
    private TextView M;
    float N;
    float P;
    float Q;
    float R;
    boolean S;
    private ScalingRunnalable T;
    private int U;
    private int V;
    protected int W;

    /* renamed from: com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyPullToZoomListView$2, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ReadInJoyPullToZoomListView this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.T.f(300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class ScalingRunnalable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f239758d;

        /* renamed from: e, reason: collision with root package name */
        boolean f239759e = true;

        /* renamed from: f, reason: collision with root package name */
        float f239760f;

        /* renamed from: h, reason: collision with root package name */
        long f239761h;

        ScalingRunnalable() {
        }

        public void f(long j3) {
            this.f239761h = AnimationUtils.currentAnimationTimeMillis();
            this.f239758d = j3;
            this.f239760f = ReadInJoyPullToZoomListView.this.K.getBottom() / ReadInJoyPullToZoomListView.this.U;
            this.f239759e = false;
            ReadInJoyPullToZoomListView.this.post(this);
            if (QLog.isColorLevel() && ReadInJoyPullToZoomListView.f239756a0) {
                QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# startAnimation(): duration =" + j3 + ", mScale=" + this.f239760f);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ReadInJoyPullToZoomListView.this.o0();
            if (this.f239759e || this.f239760f <= 1.0d) {
                return;
            }
            float currentAnimationTimeMillis = (((float) AnimationUtils.currentAnimationTimeMillis()) - ((float) this.f239761h)) / ((float) this.f239758d);
            float f16 = this.f239760f;
            float interpolation = f16 - ((f16 - 1.0f) * ReadInJoyPullToZoomListView.f239757b0.getInterpolation(currentAnimationTimeMillis));
            ViewGroup.LayoutParams layoutParams = ReadInJoyPullToZoomListView.this.K.getLayoutParams();
            if (interpolation > 1.0f) {
                layoutParams.height = ReadInJoyPullToZoomListView.this.U;
                layoutParams.height = (int) (ReadInJoyPullToZoomListView.this.U * interpolation);
                ReadInJoyPullToZoomListView.this.K.setLayoutParams(layoutParams);
                ReadInJoyPullToZoomListView.this.post(this);
                if (QLog.isColorLevel() && ReadInJoyPullToZoomListView.f239756a0) {
                    QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# runing...... f1 = " + currentAnimationTimeMillis + ", f2=" + interpolation);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel() && ReadInJoyPullToZoomListView.f239756a0) {
                QLog.w("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# run() end! f1 = " + currentAnimationTimeMillis + ", f2=" + interpolation);
            }
            this.f239759e = true;
        }

        public void e() {
            this.f239759e = true;
            if (QLog.isColorLevel() && ReadInJoyPullToZoomListView.f239756a0) {
                QLog.e("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# abortAnimation(): ");
            }
        }
    }

    /* loaded from: classes33.dex */
    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    }

    /* loaded from: classes33.dex */
    public interface b {
    }

    public ReadInJoyPullToZoomListView(Context context) {
        this(context, null);
    }

    private void l0() {
        FrameLayout frameLayout = this.K;
        if (frameLayout == null || this.I == null || frameLayout.getBottom() <= 0 || this.I.getBottom() <= 0) {
            return;
        }
        int bottom = this.K.getBottom();
        int bottom2 = this.I.getBottom();
        boolean z16 = bottom <= bottom2;
        if (z16 != this.J) {
            this.J = z16;
        }
        if (QLog.isColorLevel() && f239756a0) {
            QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "checkIsTopFixed(): titleBarBottom=" + bottom2 + "\uff0c headerBottom=" + bottom + "\uff0c fixed = " + z16 + ", mTopFixed=" + this.J);
        }
    }

    private void m0() {
        if (this.S) {
            n0(false);
        } else {
            this.T.f(300L);
        }
    }

    private void n0(boolean z16) {
        t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        TextView textView = this.M;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void p0() {
        TextView textView = this.L;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void q0(View view) {
        if (this.K == null) {
            this.K = new FrameLayout(getContext());
            this.K.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
        s0();
        r0();
        view.setLayerType(0, null);
    }

    private void r0() {
        if (this.M == null) {
            TextView textView = new TextView(getContext());
            textView.setTextColor(1728053247);
            textView.setTextSize(1, 12.0f);
            textView.setGravity(17);
            textView.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = x.c(getContext(), 58.0f);
            this.K.addView(textView, layoutParams);
            this.M = textView;
        }
    }

    private void s0() {
        if (this.L == null) {
            TextView textView = new TextView(getContext());
            textView.setTextColor(-1);
            textView.setText(HardCodeUtil.qqStr(R.string.ssu));
            textView.setGravity(17);
            textView.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = x.c(getContext(), 52.0f);
            this.K.addView(textView, layoutParams);
            this.L = textView;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t0() {
        TextView textView = this.L;
        if (textView == null || textView.getVisibility() != 8) {
            return;
        }
        this.L.setVisibility(0);
        Drawable drawable = getResources().getDrawable(R.drawable.common_loading5);
        this.L.setCompoundDrawablePadding(10);
        this.L.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        ((Animatable) drawable).start();
    }

    @Override // com.tencent.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z16) {
        q0(view);
        super.addHeaderView(this.K, obj, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView
    public void d0(Context context, AttributeSet attributeSet) {
        super.d0(context, attributeSet);
        setOverScrollMode(2);
        this.T = new ScalingRunnalable();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView, com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        super.onScroll(absListView, i3, i16, i17);
        l0();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        super.onScrollStateChanged(absListView, i3);
        l0();
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.W = (int) motionEvent.getRawY();
            ScalingRunnalable scalingRunnalable = this.T;
            if (!scalingRunnalable.f239759e) {
                scalingRunnalable.e();
            }
            this.N = motionEvent.getY();
            this.P = this.K.getBottom() / this.U;
            if (QLog.isColorLevel() && f239756a0) {
                QLog.i("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_DOWN ==>  mLastScale = " + this.P + "\uff0c mHeaderMaxHeight = " + this.V);
            }
        } else if (action == 1) {
            if (QLog.isColorLevel() && f239756a0) {
                QLog.i("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_UP <=====  mEnterRefreshDefer=" + this.S);
            }
            m0();
            reset();
        } else if (action == 2) {
            this.f239314i = ((int) motionEvent.getRawY()) - this.W;
            if (this.N == -1.0f) {
                this.N = motionEvent.getY();
            }
            if (this.K.getBottom() >= this.U) {
                ViewGroup.LayoutParams layoutParams = this.K.getLayoutParams();
                float y16 = (motionEvent.getY() - this.N) + this.K.getBottom();
                int i3 = this.U;
                float f16 = this.P;
                float f17 = (((y16 / i3) - f16) / 2.0f) + f16;
                if (f16 <= 1.0d && f17 < f16) {
                    layoutParams.height = i3;
                    this.K.setLayoutParams(layoutParams);
                    return super.onTouchEvent(motionEvent);
                }
                float min = Math.min(Math.max(f17, 1.0f), this.Q);
                this.P = min;
                int i16 = (int) (this.U * min);
                layoutParams.height = i16;
                if (i16 <= this.V) {
                    this.K.setLayoutParams(layoutParams);
                }
                if (this.P >= this.R) {
                    t0();
                    this.S = true;
                } else {
                    p0();
                    this.S = false;
                }
                if (QLog.isColorLevel() && f239756a0) {
                    QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_MOVE, f = " + f17 + ", mLastScale=" + this.P + ", mEnterRefreshDefer=" + this.S);
                }
                this.N = motionEvent.getY();
                return true;
            }
            this.N = motionEvent.getY();
        } else if (action == 3) {
            this.N = motionEvent.getY();
            if (QLog.isColorLevel() && f239756a0) {
                QLog.w("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_CANCEL xxxx");
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setHeaderViewSize(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams = this.K.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(i3, i16);
        }
        layoutParams.width = i3;
        layoutParams.height = i16;
        this.K.setLayoutParams(layoutParams);
        this.U = i16;
        this.V = (int) (i16 * this.Q);
    }

    public ReadInJoyPullToZoomListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.N = -1.0f;
        this.P = -1.0f;
        this.Q = 1.401f;
        this.R = 1.235f;
        this.W = 0;
    }

    private void reset() {
        this.N = -1.0f;
        this.P = -1.0f;
        this.S = false;
    }

    @Override // com.tencent.widget.ListView
    public void addHeaderView(View view) {
        q0(view);
        super.addHeaderView(this.K);
    }

    public ReadInJoyPullToZoomListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.N = -1.0f;
        this.P = -1.0f;
        this.Q = 1.401f;
        this.R = 1.235f;
        this.W = 0;
    }

    public void setOnTopCallback(b bVar) {
    }
}
