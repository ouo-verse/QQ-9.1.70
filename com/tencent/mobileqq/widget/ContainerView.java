package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticon.api.IAniStickerUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.anisticker.view.AniStickerLottieView;
import com.tencent.qqnt.aio.anisticker.view.e;
import com.tencent.qqnt.textpreview.PreviewTextContainerView;
import com.tencent.widget.ScrollView;
import mqq.app.MobileQQ;

/* compiled from: P */
@SuppressLint({"NewApi", "ResourceAsColor", "Override"})
@TargetApi(11)
/* loaded from: classes20.dex */
public class ContainerView extends PreviewTextContainerView {

    /* renamed from: i0, reason: collision with root package name */
    private static final int f315568i0 = ViewUtils.dpToPx(5.0f);

    /* renamed from: j0, reason: collision with root package name */
    private static final int f315569j0 = ViewUtils.dpToPx(2.0f);

    /* renamed from: k0, reason: collision with root package name */
    private static final int f315570k0 = ViewUtils.dpToPx(28.0f);
    private int[] C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private int I;
    private Paint J;
    private Rect K;
    private int L;
    private boolean M;
    private int N;
    private int P;
    private int Q;
    private int R;
    private int S;
    public boolean T;
    protected boolean U;
    protected int V;
    protected String W;

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f315571a0;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f315572b0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f315573c0;

    /* renamed from: d0, reason: collision with root package name */
    protected volatile boolean f315574d0;

    /* renamed from: e, reason: collision with root package name */
    public int f315575e;

    /* renamed from: e0, reason: collision with root package name */
    protected AniStickerLottieView f315576e0;

    /* renamed from: f, reason: collision with root package name */
    private ScrollView f315577f;

    /* renamed from: f0, reason: collision with root package name */
    protected PopupWindow f315578f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f315579g0;

    /* renamed from: h, reason: collision with root package name */
    public AnimationTextView f315580h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f315581h0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f315582i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.qqnt.selectable.i f315583m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!ContainerView.this.f315582i) {
                ContainerView.this.x(PreviewTextContainerView.f362309d);
                ContainerView.this.f315582i = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements ScrollView.OnScrollStateChangedListener {
        b() {
        }

        @Override // com.tencent.widget.ScrollView.OnScrollStateChangedListener
        public void onScrollStateChanged(ScrollView scrollView, int i3, boolean z16) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ContainerView.this.f315581h0 = true;
                    } else {
                        return;
                    }
                }
                com.tencent.qqnt.selectable.a C = com.tencent.qqnt.selectable.a.C();
                if (C.isSelected() && C.o()) {
                    C.k();
                    return;
                }
                return;
            }
            if (!z16 || ContainerView.this.f315581h0) {
                com.tencent.qqnt.selectable.a C2 = com.tencent.qqnt.selectable.a.C();
                if (C2.isSelected() && !C2.o()) {
                    C2.h();
                }
                ContainerView.this.f315581h0 = false;
            }
        }
    }

    @TargetApi(11)
    public ContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315575e = 0;
        this.f315582i = false;
        this.C = new int[2];
        this.D = false;
        this.E = false;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.M = false;
        this.N = -1;
        this.P = -1;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.T = true;
        this.U = true;
        this.V = -1;
        this.W = null;
        this.f315571a0 = false;
        this.f315572b0 = false;
        this.f315573c0 = false;
        this.f315574d0 = false;
        this.f315579g0 = true;
        this.f315581h0 = false;
        t(context);
    }

    private void r() {
        if (this.f315583m != null) {
        } else {
            throw new IllegalStateException("Has no bound delegate!");
        }
    }

    private com.tencent.mobileqq.activity.richmedia.i s() {
        return ((IAniStickerUtils) QRoute.api(IAniStickerUtils.class)).getAniStickerPreGuideViewSize();
    }

    private void t(Context context) {
        AnimationTextView animationTextView = new AnimationTextView(context);
        this.f315580h = animationTextView;
        animationTextView.setBackgroundColor(17170445);
        this.f315580h.setGravity(1);
        this.f315580h.setScroller(null);
        this.f315580h.setHighlightColor(1722605812);
        this.f315580h.setTextSize(1, 32.0f);
        this.f315580h.setTextColor(-16777216);
        int f16 = BaseAIOUtils.f(10.0f, getResources());
        this.f315580h.setPadding(f16, f16, f16, f16);
        addView(this.f315580h, new LinearLayout.LayoutParams(-2, -2));
        AniStickerLottieView aniStickerLottieView = new AniStickerLottieView(context);
        this.f315576e0 = aniStickerLottieView;
        aniStickerLottieView.setId(R.id.spv);
        this.f315576e0.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        addView(this.f315576e0, layoutParams);
        setOrientation(1);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private PopupWindow u() {
        return ((IAniStickerUtils) QRoute.api(IAniStickerUtils.class)).createAniStickerPreGuideView(getContext());
    }

    private int v(float f16, float f17) {
        int i3 = this.F;
        int i16 = f315568i0;
        int i17 = i3 - (i16 * 3);
        int i18 = i3 + (i16 * 3);
        int i19 = this.G;
        int i26 = f315570k0;
        int i27 = (i19 - i26) - (i16 * 2);
        if (f16 >= i17 && f16 <= i18 && f17 >= i27 && f17 <= i19 && this.D) {
            return 1;
        }
        int i28 = this.H;
        int i29 = i28 - (i16 * 3);
        int i36 = i28 + (i16 * 3);
        int i37 = this.I;
        int i38 = i37 - i26;
        int i39 = i37 + (i16 * 2);
        if (f16 >= i29 && f16 <= i36 && f17 >= i38 && f17 <= i39 && this.E) {
            return 2;
        }
        return -1;
    }

    private float w() {
        int scrollY = this.f315577f.getScrollY();
        Layout layout = this.f315580h.getLayout();
        if (layout != null) {
            if (scrollY <= (-layout.getTopPadding())) {
                return (r2 - scrollY) / this.f315580h.getLineHeight();
            }
            int lineForVertical = layout.getLineForVertical(scrollY - 1) + 1;
            return layout.getLineStart(lineForVertical) + ((layout.getLineTop(lineForVertical) - scrollY) / this.f315580h.getLineHeight());
        }
        return scrollY / this.f315580h.getLineHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(float f16) {
        int lineTop;
        if (f16 != 0.0f && f16 != this.f315577f.getScrollY()) {
            int i3 = (int) f16;
            int lineHeight = (int) ((f16 - i3) * this.f315580h.getLineHeight());
            Layout layout = this.f315580h.getLayout();
            if (layout != null) {
                int lineForOffset = layout.getLineForOffset(i3);
                if (lineForOffset == 0) {
                    lineTop = -layout.getTopPadding();
                } else {
                    lineTop = layout.getLineTop(lineForOffset);
                }
                final int i16 = lineTop - lineHeight;
                new Handler().post(new Runnable() { // from class: com.tencent.mobileqq.widget.ContainerView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ContainerView.this.f315577f.smoothScrollTo(0, i16);
                    }
                });
                return;
            }
            final int lineHeight2 = i3 * this.f315580h.getLineHeight();
            new Handler().post(new Runnable() { // from class: com.tencent.mobileqq.widget.ContainerView.5
                @Override // java.lang.Runnable
                public void run() {
                    ContainerView.this.f315577f.smoothScrollTo(0, lineHeight2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        String str;
        if (this.f315578f0 == null) {
            this.f315578f0 = u();
        }
        Rect rect = new Rect();
        this.f315576e0.getGlobalVisibleRect(rect);
        com.tencent.mobileqq.activity.richmedia.i s16 = s();
        this.f315578f0.showAsDropDown(this.f315576e0, (rect.width() - s16.b()) / 2, -(s16.a() + rect.height()), 3);
        ((IAniStickerUtils) QRoute.api(IAniStickerUtils.class)).notifyAniStickerPreGuideShow();
        if (this.f315571a0) {
            str = "0X800BCCF";
        } else {
            str = "0X800BBD8";
        }
        String str2 = str;
        ReportController.o(MobileQQ.sMobileQQ.waitAppRuntime(null), "dc00898", "", "", str2, str2, QQSysFaceUtil.convertToServer(this.V), 0, "", "", "", "");
    }

    private void z(int i3, int i16, int i17) {
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        if (this.N == 1) {
            i18 = this.P;
        } else {
            i18 = this.Q;
        }
        int b16 = this.f315583m.b(i3, i16);
        if (QLog.isColorLevel()) {
            QLog.d("BaseChatItemLayout", 2, "updateCursorLocation, touchIndex=" + b16 + ", type=" + this.N);
        }
        if (i17 == -1) {
            this.f315583m.d(this.N, false);
        }
        if (b16 == -1) {
            return;
        }
        if (b16 != i18) {
            if (this.N == 1) {
                i26 = this.P;
                if (b16 < i26) {
                    i26 = this.Q;
                    this.P = b16;
                } else if (b16 > i26 && b16 < (i29 = this.Q)) {
                    this.P = b16;
                    i26 = i29;
                } else {
                    if (b16 == i26) {
                        b16 = this.Q;
                    } else {
                        i26 = this.Q;
                        if (b16 == i26) {
                            b16 = i26 - 1;
                        } else {
                            this.P = i26;
                            this.Q = b16;
                            this.N = 2;
                            this.f315583m.l(2);
                        }
                    }
                    int i36 = b16;
                    b16 = i26;
                    i26 = i36;
                }
            } else {
                i26 = this.Q;
                if (b16 > i26) {
                    i26 = this.P;
                    this.Q = b16;
                } else if (b16 < i26 && b16 > (i27 = this.P)) {
                    this.Q = b16;
                    i26 = b16;
                    b16 = i27;
                } else if (b16 == i26) {
                    b16 = this.P;
                } else {
                    i26 = this.P;
                    if (b16 == i26) {
                        b16 = i26 + 1;
                    } else {
                        this.Q = i26;
                        this.P = b16;
                        this.N = 1;
                        this.f315583m.l(1);
                    }
                }
                int i362 = b16;
                b16 = i26;
                i26 = i362;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BaseChatItemLayout", 2, "update selection, s=" + b16 + ", e=" + i26);
            }
            this.f315583m.j(b16, i26);
            this.f315583m.p(i3, i16);
            int i37 = this.N;
            if (i37 == 1) {
                int i38 = this.R;
                if (i38 != -1) {
                    this.f315583m.m(i3, i38, true);
                    return;
                }
                return;
            }
            if (i37 == 2 && (i28 = this.S) != -1) {
                this.f315583m.m(i3, i28, true);
                return;
            }
            return;
        }
        int i39 = this.N;
        if (i39 == 1) {
            int i46 = this.R;
            if (i46 != -1) {
                this.f315583m.m(i3, i46, false);
                return;
            }
            return;
        }
        if (i39 == 2 && (i19 = this.S) != -1) {
            this.f315583m.m(i3, i19, false);
        }
    }

    @Override // com.tencent.qqnt.selectable.h
    public void a(int i3) {
        this.L = i3;
    }

    @Override // com.tencent.qqnt.selectable.h
    public void b(int i3) {
        if (i3 == 1) {
            this.D = false;
        } else {
            this.E = false;
        }
        invalidate();
    }

    @Override // com.tencent.qqnt.selectable.h
    public boolean d(int i3) {
        if (i3 == 1) {
            return this.D;
        }
        return this.E;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.D) {
            Rect rect = this.K;
            int i3 = this.F;
            int i16 = i3 - f315569j0;
            int i17 = this.G;
            rect.set(i16, i17 - f315570k0, i3, i17);
            this.J.setColor(this.L);
            canvas.drawRect(this.K, this.J);
            float centerX = this.K.centerX();
            int i18 = this.K.top;
            canvas.drawCircle(centerX, i18 - r2, f315568i0, this.J);
        }
        if (this.E) {
            Rect rect2 = this.K;
            int i19 = this.H;
            int i26 = this.I;
            rect2.set(i19, i26 - f315570k0, f315569j0 + i19, i26);
            this.J.setColor(this.L);
            canvas.drawRect(this.K, this.J);
            float centerX2 = this.K.centerX();
            int i27 = this.K.bottom;
            canvas.drawCircle(centerX2, i27 + r2, f315568i0, this.J);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!super.dispatchTouchEvent(motionEvent) && this.f315579g0 && this.f315580h.getVisibility() == 0) {
            return this.f315580h.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.tencent.qqnt.selectable.h
    public void e(int i3, int i16, int i17) {
        boolean z16;
        r();
        getLocationInWindow(this.C);
        if (i3 != -1 && i16 != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i17 == 1) {
            int[] iArr = this.C;
            this.F = i3 - iArr[0];
            this.G = i16 - iArr[1];
            this.D = z16;
        } else {
            int[] iArr2 = this.C;
            this.H = i3 - iArr2[0];
            this.I = i16 - iArr2[1];
            this.E = z16;
        }
        if (this.J == null) {
            this.J = new Paint(1);
        }
        if (this.K == null) {
            this.K = new Rect();
        }
        if (i17 == 1) {
            this.R = i16;
        } else if (i17 == 2) {
            this.S = i16;
        } else {
            this.R = -1;
            this.S = -1;
        }
        invalidate();
    }

    @Override // com.tencent.qqnt.selectable.h
    public void g(com.tencent.qqnt.selectable.i iVar) {
        this.f315583m = iVar;
    }

    @Override // com.tencent.qqnt.textpreview.PreviewTextContainerView
    public TextView h() {
        return this.f315580h;
    }

    @Override // com.tencent.qqnt.textpreview.PreviewTextContainerView
    public boolean i() {
        if (this.f315580h.getSelectionEnd() - this.f315580h.getSelectionStart() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.textpreview.PreviewTextContainerView
    public boolean j() {
        return this.f315577f.isScrollFinished();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        PreviewTextContainerView.f362309d = w();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f315575e == 0) {
            super.onDraw(canvas);
            return;
        }
        canvas.save();
        canvas.translate(0.0f, this.f315575e);
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((this.D || this.E) && v(motionEvent.getX(), motionEvent.getY()) != -1) {
            r();
            this.f315583m.r();
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.U && this.V >= 0) {
            int f16 = BaseAIOUtils.f(180.0f, getResources());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f315576e0.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(f16, f16);
            } else {
                layoutParams.width = f16;
                layoutParams.height = f16;
            }
            setGravity(17);
            this.f315576e0.setLayoutParams(layoutParams);
            if (!this.f315571a0 && !this.f315572b0) {
                com.tencent.qqnt.aio.anisticker.view.e.f348849a.r(new e.a(this.f315576e0).B(f16).p(f16).r(this.V).s(R.drawable.c0i).a());
            } else {
                e.a s16 = new e.a(this.f315576e0).B(f16).p(f16).r(this.V).s(R.drawable.c0i);
                if (this.f315572b0) {
                    s16.y(TextUtils.isEmpty(this.W));
                }
                e.a a16 = s16.a();
                com.tencent.qqnt.aio.anisticker.view.e eVar = com.tencent.qqnt.aio.anisticker.view.e.f348849a;
                eVar.n(a16);
                eVar.p(new e.a(this.f315576e0).w(this.W).v(-1).a());
            }
            this.f315576e0.setVisibility(0);
            this.f315580h.setVisibility(8);
        } else {
            this.f315576e0.setVisibility(8);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f315580h.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, 0);
            this.f315580h.setLayoutParams(layoutParams2);
            ScrollView scrollView = this.f315577f;
            if (scrollView != null && scrollView.getHeight() > getHeight()) {
                return;
            }
            int height = getHeight();
            int width = getWidth();
            int height2 = this.f315580h.getHeight();
            int width2 = this.f315580h.getWidth();
            if (height2 == 0 || width2 == 0) {
                this.f315580h.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
                height2 = this.f315580h.getMeasuredHeight();
                width2 = this.f315580h.getMeasuredWidth();
            }
            if (height2 < height * 0.8f) {
                if (this.T) {
                    if (width2 < width) {
                        setGravity(17);
                    } else {
                        setGravity(19);
                    }
                }
                this.f315575e = -this.f315580h.getLineHeight();
            } else if (this.T) {
                setGravity(51);
            }
            this.f315580h.setVisibility(0);
        }
        boolean checkIsNeedShowAniStickerPreGuide = ((IAniStickerUtils) QRoute.api(IAniStickerUtils.class)).checkIsNeedShowAniStickerPreGuide();
        if (this.V >= 0 && this.f315571a0 && checkIsNeedShowAniStickerPreGuide && !this.f315574d0 && !this.f315573c0) {
            this.f315574d0 = true;
            this.f315580h.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.ContainerView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ContainerView.this.isAttachedToWindow()) {
                        ContainerView.this.y();
                    }
                }
            }, 500L);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        if (this.D || this.E) {
            int action = motionEvent.getAction();
            if (!this.M) {
                int v3 = v(motionEvent.getX(), motionEvent.getY());
                if (v3 != -1 && action == 0) {
                    r();
                    this.M = true;
                    this.N = v3;
                    this.P = this.f315583m.q();
                    this.Q = this.f315583m.f();
                    if (motionEvent.getSource() != -1) {
                        this.f315583m.d(this.N, false);
                    }
                    if (this.f315583m.o()) {
                        this.f315583m.k();
                    }
                    return true;
                }
            } else {
                r();
                if (action != 1 && action != 3) {
                    if (action == 2) {
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        int i16 = this.N;
                        if (i16 == 1) {
                            int i17 = this.F;
                            int i18 = f315568i0;
                            int i19 = i17 - (i18 * 3);
                            int i26 = i17 + (i18 * 3);
                            int i27 = this.G;
                            int i28 = f315570k0;
                            int i29 = (i27 - i28) - (i18 * 2);
                            int i36 = i27 - i28;
                            if (rawX >= i19 && rawX <= i26 && rawY >= i29 && rawY <= i36 && this.D) {
                                rawY += i18 * 2;
                            }
                        } else if (i16 == 2) {
                            int i37 = this.H;
                            int i38 = f315568i0;
                            int i39 = i37 - (i38 * 3);
                            int i46 = i37 + (i38 * 3);
                            int i47 = this.I;
                            int i48 = (i38 * 2) + i47;
                            if (rawX >= i39 && rawX <= i46 && rawY >= i47 && rawY <= i48 && this.E) {
                                rawY -= i38 * 2;
                            }
                        }
                        z(rawX, rawY, motionEvent.getSource());
                    }
                } else {
                    this.M = false;
                    this.R = -1;
                    this.S = -1;
                    this.f315583m.d(-1, true);
                    this.f315583m.h();
                    if (action == 1) {
                        if (motionEvent.getSource() == -1) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                        ReportController.o(null, "dc00898", "", "", "0X800AE7B", "0X800AE7B", i3, 0, "", "", "", "");
                    }
                }
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.qqnt.textpreview.PreviewTextContainerView
    public void setAniStickerLocID(int i3) {
        this.V = i3;
        this.f315571a0 = QQSysFaceUtil.isRandomAniSticker(i3);
        this.f315572b0 = QQSysFaceUtil.isRandomChainSticker(i3);
        this.f315574d0 = false;
    }

    @Override // com.tencent.qqnt.textpreview.PreviewTextContainerView
    public void setAniStickerResult(String str) {
        this.W = str;
    }

    @Override // com.tencent.qqnt.textpreview.PreviewTextContainerView
    public void setAniStickerShowBig(boolean z16) {
        this.U = z16;
    }

    @Override // com.tencent.qqnt.textpreview.PreviewTextContainerView
    public void setAutoAdjustGravity(boolean z16) {
        this.T = z16;
    }

    @Override // com.tencent.qqnt.textpreview.PreviewTextContainerView
    public void setDispatchTouchToTv(boolean z16) {
        this.f315579g0 = z16;
    }

    @Override // com.tencent.qqnt.textpreview.PreviewTextContainerView
    public void setIsSendMsg(boolean z16) {
        this.f315573c0 = z16;
    }

    public void setLinkTextColor(int i3) {
        this.f315580h.setLinkTextColor(i3);
    }

    @Override // com.tencent.qqnt.textpreview.PreviewTextContainerView
    @SuppressLint({"ClickableViewAccessibility"})
    public void setOutScrollView(ScrollView scrollView) {
        this.f315577f = scrollView;
        scrollView.setOnScrollStateChangedListener(new b());
    }

    public void setText(CharSequence charSequence) {
        this.f315580h.setText(charSequence);
    }

    public void setTextColor(int i3) {
        this.f315580h.setTextColor(i3);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f315580h.setTextColor(colorStateList);
    }

    @Override // com.tencent.qqnt.selectable.h
    @NonNull
    public View f() {
        return this;
    }

    public ContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315575e = 0;
        this.f315582i = false;
        this.C = new int[2];
        this.D = false;
        this.E = false;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.M = false;
        this.N = -1;
        this.P = -1;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.T = true;
        this.U = true;
        this.V = -1;
        this.W = null;
        this.f315571a0 = false;
        this.f315572b0 = false;
        this.f315573c0 = false;
        this.f315574d0 = false;
        this.f315579g0 = true;
        this.f315581h0 = false;
        t(context);
    }

    public ContainerView(Context context) {
        super(context);
        this.f315575e = 0;
        this.f315582i = false;
        this.C = new int[2];
        this.D = false;
        this.E = false;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.M = false;
        this.N = -1;
        this.P = -1;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.T = true;
        this.U = true;
        this.V = -1;
        this.W = null;
        this.f315571a0 = false;
        this.f315572b0 = false;
        this.f315573c0 = false;
        this.f315574d0 = false;
        this.f315579g0 = true;
        this.f315581h0 = false;
        t(context);
    }
}
