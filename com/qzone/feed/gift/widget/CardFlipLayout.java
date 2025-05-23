package com.qzone.feed.gift.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.feed.gift.util.FeedGiftUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.widget.AsyncImageView;
import java.io.File;
import v6.a;
import v6.c;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CardFlipLayout extends FrameLayout implements c.b {
    private float C;
    private float D;
    private Context E;
    private a F;
    private View.OnClickListener G;
    private c.b H;
    private int I;
    private int J;
    private float K;
    private Matrix L;
    private Camera M;
    private boolean N;
    private float P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private BusinessFeedData T;
    private CellDecorateInfo.CellGiftData U;
    private g V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private long f47234a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f47235b0;

    /* renamed from: c0, reason: collision with root package name */
    boolean f47236c0;

    /* renamed from: d, reason: collision with root package name */
    private AsyncImageView f47237d;

    /* renamed from: e, reason: collision with root package name */
    private GiftAnimationLayout f47238e;

    /* renamed from: f, reason: collision with root package name */
    private AsyncImageView f47239f;

    /* renamed from: h, reason: collision with root package name */
    private String f47240h;

    /* renamed from: i, reason: collision with root package name */
    private String f47241i;

    /* renamed from: m, reason: collision with root package name */
    private float f47242m;

    public CardFlipLayout(Context context) {
        super(context);
        this.N = false;
        this.Q = false;
        this.R = true;
        this.S = false;
        this.f47236c0 = false;
        j(context);
    }

    private void f() {
        if (this.F == null) {
            i();
        }
    }

    private void g() {
        if (this.N) {
            this.P += 180.0f;
            this.F.r();
        }
        this.f47238e.o();
    }

    private void i() {
        if (this.F == null) {
            a aVar = new a(this, this.f47237d, this.f47238e);
            this.F = aVar;
            aVar.g(this);
        }
    }

    private void j(Context context) {
        this.E = context;
        this.K = context.getResources().getDisplayMetrics().density;
        this.L = new Matrix();
        this.M = new Camera();
        setClipChildren(false);
        setClipToPadding(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        GiftAnimationLayout giftAnimationLayout = new GiftAnimationLayout(this.E);
        this.f47238e = giftAnimationLayout;
        giftAnimationLayout.setVisibility(8);
        addView(this.f47238e, layoutParams);
        AsyncImageView asyncImageView = new AsyncImageView(this.E);
        this.f47237d = asyncImageView;
        asyncImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f47237d, layoutParams);
        AsyncImageView asyncImageView2 = new AsyncImageView(this.E);
        this.f47239f = asyncImageView2;
        asyncImageView2.setVisibility(8);
    }

    private void n() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    @Override // v6.c.b
    public void a(float f16) {
        c.b bVar = this.H;
        if (bVar != null) {
            bVar.a(f16);
        }
        if (f16 <= 0.5f || this.f47236c0) {
            return;
        }
        this.f47237d.setAsyncImage(this.f47241i);
        this.f47236c0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.concat(this.L);
        super.dispatchDraw(canvas);
    }

    public void h(String str) {
        this.f47240h = str;
        GiftAnimationLayout giftAnimationLayout = this.f47238e;
        if (giftAnimationLayout == null) {
            return;
        }
        giftAnimationLayout.h(str);
        if (!TextUtils.isEmpty(str)) {
            this.f47238e.n(str + File.separator + "reverse.png");
        }
        if (this.U.currentIndex == 2) {
            g();
        }
    }

    public boolean k() {
        if (this.f47237d.getVisibility() != 8 && this.f47238e.getVisibility() != 0) {
            return false;
        }
        this.U.currentIndex = 2;
        return true;
    }

    public void l() {
        GiftAnimationLayout giftAnimationLayout = this.f47238e;
        if (giftAnimationLayout != null) {
            giftAnimationLayout.k();
        }
    }

    public void m() {
        GiftAnimationLayout giftAnimationLayout = this.f47238e;
        if (giftAnimationLayout != null) {
            giftAnimationLayout.l();
        }
        removeAllViews();
    }

    public boolean o(boolean z16, final int i3) {
        this.S = z16;
        this.f47234a0 = System.currentTimeMillis();
        this.Q = false;
        j.e("CardFlipLayout", 4, " tempStartTime = " + this.f47234a0 + " lastTempStartTime = " + this.f47235b0 + " offest = " + (this.f47234a0 - this.f47235b0));
        long j3 = this.f47235b0;
        if (j3 == 0) {
            this.f47235b0 = this.f47234a0;
        } else {
            if (this.f47234a0 - j3 <= 2900) {
                j.e("CardFlipLayout", 4, "startAnimation repeat offest time = " + (this.f47234a0 - this.f47235b0));
                return false;
            }
            this.f47235b0 = 0L;
        }
        c.b bVar = this.H;
        if (bVar != null) {
            bVar.b();
        }
        f();
        if (!z16) {
            this.N = false;
            this.F.q();
        }
        this.R = false;
        this.F.s(i3);
        if (z16) {
            this.F.p(i3);
            this.Q = true;
            return true;
        }
        this.F.h();
        postDelayed(new Runnable() { // from class: com.qzone.feed.gift.widget.CardFlipLayout.1
            @Override // java.lang.Runnable
            public void run() {
                if (CardFlipLayout.this.F != null) {
                    CardFlipLayout.this.F.p(-i3);
                }
                CardFlipLayout.this.Q = true;
            }
        }, this.U.iType != 2 ? 2000L : 3400L);
        return true;
    }

    @Override // v6.c.b
    public void onAnimationFinish() {
        if (this.Q) {
            this.f47235b0 = 0L;
            this.R = true;
            c.b bVar = this.H;
            if (bVar != null) {
                bVar.onAnimationFinish();
            }
        }
        if (this.N) {
            this.P += 180.0f;
            this.F.r();
        }
        if (this.N && this.f47238e.getVisibility() == 8) {
            q();
        }
        if (this.S) {
            if (this.f47237d.getVisibility() == 8) {
                this.U.currentIndex = 2;
            } else if (this.f47238e.getVisibility() == 8) {
                this.U.currentIndex = 1;
            }
            FeedGiftUtil.f(this.T);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean o16;
        getParent().requestDisallowInterceptTouchEvent(true);
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (!this.R) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f47242m = x16;
            this.C = y16;
        } else if (action == 1) {
            float scaledTouchSlop = ViewConfiguration.get(this.E).getScaledTouchSlop();
            if (Math.abs(x16 - this.f47242m) <= scaledTouchSlop && Math.abs(y16 - this.C) <= scaledTouchSlop) {
                View.OnClickListener onClickListener = this.G;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
                j.e("CardFlipLayout", 4, "onTouchEvent: onClick");
                return true;
            }
            f();
            float f16 = x16 - this.f47242m;
            float scaledTouchSlop2 = ViewConfiguration.get(this.E).getScaledTouchSlop() * 3;
            if (f16 > 0.0f && f16 > scaledTouchSlop2) {
                o16 = o(true, 1);
            } else {
                o16 = (f16 >= 0.0f || Math.abs(f16) <= scaledTouchSlop2) ? false : o(true, -1);
            }
            g gVar = this.V;
            if (gVar != null) {
                gVar.onClick(this, FeedElement.FEED_GIFT, this.W, Boolean.FALSE);
            }
            if (this.H != null && o16 && this.f47237d.getVisibility() == 0) {
                this.H.c(0);
            }
        } else if (action == 2) {
            float f17 = this.f47242m;
            float f18 = y16 - this.C;
            float f19 = x16 - f17;
            int scaledTouchSlop3 = ViewConfiguration.get(this.E).getScaledTouchSlop() * 2;
            if (scaledTouchSlop3 < 40) {
                scaledTouchSlop3 = 40;
            }
            float f26 = f18 / f19;
            if (f26 >= 1.0f || f26 <= -1.0f) {
                float f27 = scaledTouchSlop3;
                if (Math.abs(f18) <= f27 && Math.abs(f19) <= f27) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return true;
                }
            }
        }
        return true;
    }

    public void p() {
        GiftAnimationLayout giftAnimationLayout = this.f47238e;
        if (giftAnimationLayout == null || giftAnimationLayout.getVisibility() != 0) {
            return;
        }
        this.f47238e.o();
    }

    public void q() {
        GiftAnimationLayout giftAnimationLayout = this.f47238e;
        if (giftAnimationLayout != null) {
            giftAnimationLayout.p();
        }
    }

    public void setCardLength(int i3, int i16, int i17) {
        this.I = i3;
        this.J = i16;
        this.f47238e.setType(i17);
        this.f47238e.setCardLength(i3, i16);
        this.f47238e.setMatrix(180.0f);
    }

    public void setFeedPosition(int i3) {
        this.W = i3;
    }

    public void setMatrix(float f16) {
        this.D = f16;
        j.e("CardFlipLayout", 4, "setMatrix: mCurrentMoveX= " + this.D + " degree = " + f16 + " isReversal = " + this.N);
        f();
        float f17 = this.D;
        if (f17 <= 90.0f && f17 >= -90.0f) {
            if (this.N) {
                this.F.o(false);
                this.N = false;
            }
        } else if (!this.N) {
            this.F.o(true);
            this.N = true;
        }
        this.M.save();
        this.M.rotateY(this.P + this.D);
        this.M.getMatrix(this.L);
        this.M.restore();
        float[] fArr = new float[9];
        this.L.getValues(fArr);
        float f18 = fArr[6];
        float f19 = this.K;
        fArr[6] = f18 / f19;
        fArr[7] = fArr[7] / f19;
        this.L.setValues(fArr);
        this.L.preTranslate((-this.I) / 2, (-this.J) / 2);
        this.L.postTranslate(this.I / 2, this.J / 2);
        n();
    }

    public void setOnAnimationListener(c.b bVar) {
        this.H = bVar;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.G = onClickListener;
    }

    public void setOnFeedElementClickListener(g gVar) {
        this.V = gVar;
    }

    public void setCardData(BusinessFeedData businessFeedData) {
        CellDecorateInfo cellDecorateInfo;
        String str;
        if (businessFeedData == null || (cellDecorateInfo = businessFeedData.cellDecorateInfo) == null) {
            return;
        }
        this.T = businessFeedData;
        CellDecorateInfo.CellGiftData cellGiftData = cellDecorateInfo.cellGiftData;
        this.U = cellGiftData;
        this.f47238e.setType(cellGiftData.iType);
        CellDecorateInfo.CellGiftData cellGiftData2 = this.U;
        if (cellGiftData2.isFirst) {
            str = cellGiftData2.positiveUrl;
        } else {
            str = cellGiftData2.strReverseUrl;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f47237d.setAsyncImage(str);
        }
        String str2 = this.U.strReverseUrl;
        this.f47241i = str2;
        if (!TextUtils.isEmpty(str2)) {
            this.f47239f.setAsyncImage(this.f47241i);
        }
        if (this.U.currentIndex == 2) {
            this.f47237d.setVisibility(8);
            setMatrix(180.0f);
        }
    }

    public CardFlipLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.N = false;
        this.Q = false;
        this.R = true;
        this.S = false;
        this.f47236c0 = false;
        j(context);
    }

    public CardFlipLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.N = false;
        this.Q = false;
        this.R = true;
        this.S = false;
        this.f47236c0 = false;
        j(context);
    }

    @Override // v6.c.b
    public void b() {
    }

    @Override // v6.c.b
    public void c(int i3) {
    }
}
