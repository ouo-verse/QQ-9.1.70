package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.widget.OnSizeChangeListener;
import com.tencent.widget.ScrollView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BounceScrollView extends ScrollView {
    private static boolean P;
    private boolean C;
    private GestureDetector D;
    private af E;
    bf F;
    OnSizeChangeListener G;
    private int H;
    private int I;
    private Paint J;
    private float K;
    private boolean L;
    private int[] M;
    private float[] N;

    /* renamed from: d, reason: collision with root package name */
    protected d f315442d;

    /* renamed from: e, reason: collision with root package name */
    private int f315443e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f315444f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f315445h;

    /* renamed from: i, reason: collision with root package name */
    private int f315446i;

    /* renamed from: m, reason: collision with root package name */
    private int f315447m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (Math.abs(f17) >= Math.abs(f16)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
        void ae(float f16, float f17);

        void onScrollChanged(int i3, int i16, int i17, int i18);
    }

    @TargetApi(9)
    public BounceScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315443e = 0;
        this.f315444f = false;
        this.C = true;
        this.D = new GestureDetector(getContext(), new a(), new Handler(Looper.getMainLooper()));
        this.F = null;
        this.L = false;
        this.M = new int[]{-654311425, -654311425};
        this.N = new float[]{0.0f, 1.0f};
        setOverScrollMode(0);
        setFadingEdgeLength(0);
    }

    private void a() {
        if (this.L) {
            this.J.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.K, this.M, this.N, Shader.TileMode.CLAMP));
            this.H = getWidth();
            this.I = getHeight();
        }
    }

    public static void setEnableTalkBack(boolean z16) {
        P = z16;
    }

    @Override // com.tencent.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        bf bfVar;
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            d dVar = this.f315442d;
            if (dVar != null) {
                dVar.ae(motionEvent.getX(), motionEvent.getY());
            }
            bf bfVar2 = this.F;
            if (bfVar2 != null) {
                bfVar2.a(this, motionEvent.getX(), motionEvent.getY());
            }
        } else if (action == 3) {
            bf bfVar3 = this.F;
            if (bfVar3 != null) {
                bfVar3.a(this, motionEvent.getX(), motionEvent.getY());
            }
        } else if (action == 0 && (bfVar = this.F) != null) {
            bfVar.d(this, motionEvent.getX(), motionEvent.getY());
        }
        try {
            if (super.dispatchTouchEvent(motionEvent)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        if (!this.L) {
            return super.drawChild(canvas, view, j3);
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, view.getWidth(), view.getHeight(), null, 31);
        boolean drawChild = super.drawChild(canvas, view, j3);
        int save = canvas.save();
        canvas.drawRect(0.0f, (this.I + getScrollY()) - this.K, this.H, this.I + getScrollY(), this.J);
        canvas.restoreToCount(save);
        canvas.restoreToCount(saveLayer);
        return drawChild;
    }

    @Override // com.tencent.widget.ScrollView
    public void fling(int i3) {
        super.fling(i3);
        bf bfVar = this.F;
        if (bfVar != null) {
            bfVar.b(this, i3);
        }
    }

    @Override // com.tencent.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.C) {
            return false;
        }
        af afVar = this.E;
        if (afVar != null) {
            afVar.onInterceptTouchEvent(motionEvent);
        }
        try {
            if (this.f315444f) {
                super.onInterceptTouchEvent(motionEvent);
                return this.D.onTouchEvent(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17 = this.f315443e;
        if (i17 > 0) {
            i16 = View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ScrollView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        d dVar = this.f315442d;
        if (dVar != null) {
            dVar.onScrollChanged(i3, i16, i17, i18);
        }
        bf bfVar = this.F;
        if (bfVar != null) {
            bfVar.c(this, i3, i16, i17, i18);
        }
        if (this.L) {
            getChildAt(0).invalidate();
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ScrollView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        a();
        OnSizeChangeListener onSizeChangeListener = this.G;
        if (onSizeChangeListener != null) {
            onSizeChangeListener.onSizeChanged(i3, i16, i17, i18, false, 0);
        }
    }

    @Override // com.tencent.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View childAt;
        if (!this.C) {
            return false;
        }
        if ((motionEvent.getAction() & 255) == 2 && this.f315445h && this.f315446i < 0 && this.f315447m > 0 && (childAt = getChildAt(0)) != null) {
            int scrollY = getScrollY();
            if (scrollY < this.f315446i) {
                return true;
            }
            int measuredHeight = childAt.getMeasuredHeight();
            int height = getHeight();
            if (scrollY > 0 && height > 0 && measuredHeight > 0 && measuredHeight + this.f315447m <= scrollY + height) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.ScrollView, android.view.View
    public void scrollTo(int i3, int i16) {
        if (!this.C) {
            return;
        }
        super.scrollTo(i3, i16);
    }

    public void setMaxHeight(int i3) {
        this.f315443e = i3;
    }

    public void setNeedHorizontalGesture(boolean z16) {
        this.f315444f = z16;
    }

    public void setOnInterceptTouchEventListener(af afVar) {
        this.E = afVar;
    }

    public void setOnScrollChangedListener(d dVar) {
        this.f315442d = dVar;
    }

    public void setOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
        this.G = onSizeChangeListener;
    }

    public void setScrollListener(bf bfVar) {
        this.F = bfVar;
    }

    public BounceScrollView(Context context) {
        super(context);
        this.f315443e = 0;
        this.f315444f = false;
        this.C = true;
        this.D = new GestureDetector(getContext(), new a(), new Handler(Looper.getMainLooper()));
        this.F = null;
        this.L = false;
        this.M = new int[]{-654311425, -654311425};
        this.N = new float[]{0.0f, 1.0f};
    }

    public void setDrawFinishedListener(b bVar) {
    }

    public void setMotionEventInterceptor(c cVar) {
    }
}
