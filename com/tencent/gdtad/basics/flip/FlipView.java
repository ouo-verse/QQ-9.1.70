package com.tencent.gdtad.basics.flip;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.gdtad.basics.adshake.RotationSensor;
import com.tencent.gdtad.basics.adshake.animatorview.AnimatorView;
import com.tencent.gdtad.basics.adshake.animatorview.animator.AlphaAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.Animator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.KeepAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.SequentialAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.GroupLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.PathShapeLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.TextLayer;
import com.tencent.gdtad.basics.flip.b;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FlipView extends FrameLayout {

    /* renamed from: o0, reason: collision with root package name */
    private static final int f108744o0 = Color.parseColor("#00000000");

    /* renamed from: p0, reason: collision with root package name */
    private static final int f108745p0 = Color.parseColor("#80000000");
    private final int C;
    private final int D;
    private final int E;
    private final int F;
    private final float G;
    private final float H;
    private final int I;
    private final AnimatorView J;
    private boolean K;
    private TextLayer L;
    private TextLayer M;
    private ArrowShapeLayer N;
    private ArrowShapeLayer P;
    private ArrowShapeLayer Q;
    private ArrowShapeLayer R;
    private com.tencent.gdtad.basics.flip.a S;
    private PathShapeLayer T;
    private final RotationSensor U;
    private final com.tencent.gdtad.basics.flip.b V;

    @Nullable
    private c W;

    /* renamed from: a0, reason: collision with root package name */
    private String f108746a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f108747b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f108748c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f108749d;

    /* renamed from: d0, reason: collision with root package name */
    private float f108750d0;

    /* renamed from: e, reason: collision with root package name */
    private final int f108751e;

    /* renamed from: e0, reason: collision with root package name */
    private float f108752e0;

    /* renamed from: f, reason: collision with root package name */
    private final int f108753f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f108754f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f108755g0;

    /* renamed from: h, reason: collision with root package name */
    private final int f108756h;

    /* renamed from: h0, reason: collision with root package name */
    private final View f108757h0;

    /* renamed from: i, reason: collision with root package name */
    private final int f108758i;

    /* renamed from: i0, reason: collision with root package name */
    private int f108759i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f108760j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f108761k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f108762l0;

    /* renamed from: m, reason: collision with root package name */
    private final int f108763m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f108764m0;

    /* renamed from: n0, reason: collision with root package name */
    private final b.a f108765n0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FlipView.this.z();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FlipView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(final float f16, final float f17) {
        this.J.postOnAnimation(new Runnable() { // from class: com.tencent.gdtad.basics.flip.FlipView.2
            @Override // java.lang.Runnable
            public void run() {
                if (f17 >= 0.0f) {
                    FlipView.this.R.postProgress(f17);
                    FlipView.this.Q.postProgress(0.0f);
                } else {
                    FlipView.this.R.postProgress(0.0f);
                    FlipView.this.Q.postProgress(-f17);
                }
                FlipView.this.S.postRotationY(f16);
            }
        });
    }

    private void D() {
        this.f108764m0 = true;
        SequentialAnimator sequentialAnimator = new SequentialAnimator(this.N);
        sequentialAnimator.addAnimator(p(this.N, 0.4f, 0.8f, 542L));
        sequentialAnimator.addAnimator(p(this.N, 0.8f, 0.3f, 583L));
        sequentialAnimator.addAnimator(p(this.N, 0.3f, 0.4f, 500L));
        sequentialAnimator.setRepeatCount(0);
        sequentialAnimator.setRepeatMode(1);
        this.N.setAnimator(sequentialAnimator);
        SequentialAnimator sequentialAnimator2 = new SequentialAnimator(this.P);
        sequentialAnimator2.addAnimator(p(this.P, 0.4f, 0.3f, 542L));
        sequentialAnimator2.addAnimator(p(this.P, 0.3f, 0.8f, 583L));
        sequentialAnimator2.addAnimator(p(this.P, 0.8f, 0.4f, 500L));
        sequentialAnimator2.setRepeatCount(0);
        sequentialAnimator2.setRepeatMode(1);
        this.P.setAnimator(sequentialAnimator2);
        SequentialAnimator sequentialAnimator3 = new SequentialAnimator(this.S);
        sequentialAnimator3.addAnimator(q(this.S, 0.0f, -25.0f, 542L));
        sequentialAnimator3.addAnimator(q(this.S, -25.0f, 25.0f, 583L));
        sequentialAnimator3.addAnimator(q(this.S, 25.0f, 0.0f, 500L));
        sequentialAnimator3.setRepeatCount(0);
        sequentialAnimator3.setRepeatMode(1);
        this.S.setAnimator(sequentialAnimator3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        this.S.d();
    }

    private void F(AnimatorLayer animatorLayer) {
        if (animatorLayer == null) {
            return;
        }
        Animator animator = animatorLayer.getAnimator();
        if (animator != null) {
            animator.cancelAnimation();
        }
        animatorLayer.setAnimator(new KeepAnimator(animatorLayer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        QLog.i("FlipView", 1, "tryStopEntranceAnimation, " + this.f108764m0);
        if (!this.f108764m0) {
            return;
        }
        this.f108764m0 = false;
        F(this.N);
        F(this.P);
        F(this.S);
        this.N.postAlpha(102);
        this.P.postAlpha(102);
    }

    private AlphaAnimator m(AnimatorLayer animatorLayer, float f16, float f17, long j3, float f18, float f19, float f26, float f27) {
        AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, f16, f17);
        alphaAnimator.setDuration(j3);
        alphaAnimator.setPathInterpolator(f18, f19, f26, f27);
        return alphaAnimator;
    }

    private ArrowShapeLayer n(int i3, int i16, int i17, int i18) {
        ArrowShapeLayer arrowShapeLayer = new ArrowShapeLayer();
        arrowShapeLayer.b(i3, i16, this.f108763m, this.C, i18, i17, 0.33333334f, 0.75f, this.G, this.H);
        arrowShapeLayer.setAnimator(new KeepAnimator(arrowShapeLayer));
        return arrowShapeLayer;
    }

    private AlphaAnimator p(AnimatorLayer animatorLayer, float f16, float f17, long j3) {
        return m(animatorLayer, f16, f17, j3, 0.33f, 0.0f, 0.67f, 1.0f);
    }

    private com.tencent.gdtad.basics.adshake.animatorview.animator.a q(AnimatorLayer animatorLayer, float f16, float f17, long j3) {
        com.tencent.gdtad.basics.adshake.animatorview.animator.a aVar = new com.tencent.gdtad.basics.adshake.animatorview.animator.a(animatorLayer);
        aVar.setRotationDegrees(f16, f17);
        aVar.setDuration(j3);
        aVar.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        aVar.a(0.0f, 0.0f, -10.0f);
        return aVar;
    }

    private ArrowShapeLayer r() {
        return n((int) ((getWidth() / 2.0f) - this.f108758i), (getHeight() - this.f108753f) - (this.f108756h / 2), -1, 2);
    }

    private com.tencent.gdtad.basics.flip.a s() {
        com.tencent.gdtad.basics.flip.a aVar = new com.tencent.gdtad.basics.flip.a();
        int height = (getHeight() - this.f108753f) - (this.f108756h / 2);
        Context context = getContext();
        int i3 = this.f108756h;
        aVar.c(context, (int) (getWidth() / 2.0f), height, i3, i3, -10);
        aVar.setAnimator(new KeepAnimator(aVar));
        return aVar;
    }

    private ArrowShapeLayer t() {
        return n((int) ((getWidth() / 2.0f) + this.f108758i), (getHeight() - this.f108753f) - (this.f108756h / 2), -1, 1);
    }

    private TextLayer u() {
        return v(this.f108747b0, this.F, this.E, getWidth() / 2.0f, getHeight() - this.f108749d, false);
    }

    private TextLayer v(String str, int i3, float f16, float f17, float f18, boolean z16) {
        QLog.i("FlipView", 1, "createTextLayer, x" + f17 + ", y:" + f18 + "text " + str);
        TextLayer textLayer = new TextLayer(str, i3, f16);
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setX(f17);
        textLayer.setY(f18);
        textLayer.setTextBold(z16);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private TextLayer w() {
        return v(this.f108746a0, -1, this.D, getWidth() / 2.0f, getHeight() - this.f108751e, true);
    }

    private void y() {
        int i3 = this.f108762l0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i3);
        layoutParams.gravity = 80;
        layoutParams.leftMargin = this.f108759i0;
        layoutParams.rightMargin = this.f108760j0;
        layoutParams.bottomMargin = this.f108761k0;
        this.f108757h0.setLayoutParams(layoutParams);
        if (i3 <= 0) {
            this.f108757h0.setOnClickListener(null);
        } else {
            this.f108757h0.setOnClickListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.f108755g0) {
            return;
        }
        this.f108755g0 = true;
        G();
        RotationSensor rotationSensor = this.U;
        if (rotationSensor != null) {
            rotationSensor.stop();
        }
        c cVar = this.W;
        if (cVar != null) {
            cVar.onInteractStart(1);
            cVar.onInteractResult(1, true);
        }
    }

    public void B() {
        this.J.clearLayers();
        this.J.stopAnimation();
    }

    public void C() {
        this.K = true;
        B();
        this.L = w();
        this.M = u();
        this.N = r();
        this.P = t();
        this.Q = r();
        this.R = t();
        this.N.postProgress(1.0f);
        this.P.postProgress(1.0f);
        this.Q.postProgress(0.0f);
        this.R.postProgress(0.0f);
        this.S = s();
        PathShapeLayer o16 = o();
        this.T = o16;
        this.J.addLayer(new GroupLayer(o16, this.L, this.M, this.N, this.P, this.Q, this.R, this.S));
        this.J.startAnimation();
        this.V.d(this.f108750d0);
        this.V.b(this.f108752e0);
        y();
        D();
        this.U.start();
    }

    protected PathShapeLayer o() {
        int[] iArr = {f108744o0, f108745p0};
        int width = getWidth();
        int height = getHeight();
        float f16 = height - this.I;
        float f17 = height;
        LinearGradient linearGradient = new LinearGradient(0.0f, f16, 0.0f, f17, iArr, (float[]) null, Shader.TileMode.MIRROR);
        Path path = new Path();
        path.moveTo(0.0f, f16);
        path.lineTo(0.0f, f17);
        float f18 = width;
        path.lineTo(f18, f17);
        path.lineTo(f18, f16);
        path.lineTo(0.0f, f16);
        PathShapeLayer pathShapeLayer = new PathShapeLayer(path, linearGradient, Paint.Style.FILL);
        pathShapeLayer.setAnimator(new KeepAnimator(pathShapeLayer));
        return pathShapeLayer;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.U.setOnRotationChangeListener(this.V);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.U.setOnRotationChangeListener(null);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.K && !this.f108755g0) {
            C();
        }
    }

    public void setClickHotArea(int i3, float f16, float f17, float f18, float f19) {
        if (getContext() != null && getContext().getResources() != null) {
            Resources resources = getContext().getResources();
            this.f108759i0 = (int) TypedValue.applyDimension(i3, f16, resources.getDisplayMetrics());
            this.f108760j0 = (int) TypedValue.applyDimension(i3, f17, resources.getDisplayMetrics());
            this.f108761k0 = (int) TypedValue.applyDimension(i3, f18, resources.getDisplayMetrics());
            this.f108762l0 = (int) TypedValue.applyDimension(i3, f19, resources.getDisplayMetrics());
        }
    }

    public void setInteractiveListener(@Nullable c cVar) {
        this.W = cVar;
    }

    public void setReverseRotationThreshold(float f16) {
        if (f16 <= 0.0f) {
            f16 = 0.0f;
        }
        this.f108752e0 = f16;
    }

    public void setReverseTitleText(String str) {
        this.f108748c0 = str;
    }

    public void setSubTitleText(String str) {
        this.f108747b0 = str;
    }

    public void setTargetRotationThreshold(float f16) {
        if (f16 <= 0.0f) {
            f16 = 45.0f;
        }
        this.f108750d0 = f16;
    }

    public void setTitleText(String str) {
        this.f108746a0 = str;
    }

    public String x() {
        if (TextUtils.isEmpty(this.f108748c0)) {
            return com.tencent.ams.fusion.widget.flip.FlipView.DEFAULT_REVERSE_TITLE_TEXT;
        }
        return this.f108748c0;
    }

    public FlipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f108749d = ViewUtils.dip2px(82.0f);
        this.f108751e = ViewUtils.dip2px(106.0f);
        this.f108753f = ViewUtils.dip2px(143.0f);
        this.f108756h = ViewUtils.dip2px(70.0f);
        this.f108758i = ViewUtils.dip2px(55.0f);
        this.f108763m = ViewUtils.dip2px(32.0f);
        this.C = ViewUtils.dip2px(14.0f);
        this.D = ViewUtils.dip2px(18.0f);
        this.E = ViewUtils.dip2px(14.0f);
        this.F = Color.parseColor("#CCFFFFFF");
        this.G = ViewUtils.dip2px(1.0f);
        this.H = ViewUtils.dip2px(3.0f);
        this.I = ViewUtils.dip2px(277.0f);
        this.f108750d0 = 45.0f;
        this.f108752e0 = 0.0f;
        this.f108754f0 = false;
        this.f108755g0 = false;
        this.f108764m0 = false;
        b bVar = new b();
        this.f108765n0 = bVar;
        AnimatorView animatorView = new AnimatorView(context);
        this.J = animatorView;
        addView(animatorView);
        this.U = new RotationSensor(context);
        com.tencent.gdtad.basics.flip.b bVar2 = new com.tencent.gdtad.basics.flip.b();
        this.V = bVar2;
        bVar2.c(bVar);
        View view = new View(getContext());
        this.f108757h0 = view;
        addView(view);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements b.a {
        b() {
        }

        @Override // com.tencent.gdtad.basics.flip.b.a
        public void onFlipBackInteractProgress(float f16, float f17) {
            FlipView.this.A(f16, f17);
            c cVar = FlipView.this.W;
            if (cVar != null) {
                cVar.onBackInteractProgress(f16);
            }
        }

        @Override // com.tencent.gdtad.basics.flip.b.a
        public void onFlipBackInteractStart() {
            TextLayer textLayer = FlipView.this.L;
            if (textLayer != null) {
                textLayer.setText(FlipView.this.x());
            }
        }

        @Override // com.tencent.gdtad.basics.flip.b.a
        public void onFlipInteractFinish(boolean z16, boolean z17) {
            FlipView.this.f108755g0 = true;
            if (FlipView.this.U != null) {
                FlipView.this.U.stop();
            }
            c cVar = FlipView.this.W;
            if (cVar != null) {
                cVar.onInteractResult(3, z16);
            }
        }

        @Override // com.tencent.gdtad.basics.flip.b.a
        public void onFlipInteractProgress(float f16, float f17) {
            FlipView.this.A(f16, f17);
            c cVar = FlipView.this.W;
            if (cVar != null) {
                cVar.onInteractProgress(f16);
            }
        }

        @Override // com.tencent.gdtad.basics.flip.b.a
        public void onFlipInteractStart() {
            FlipView.this.f108754f0 = true;
            FlipView.this.G();
            FlipView.this.E();
            c cVar = FlipView.this.W;
            if (cVar != null) {
                cVar.onInteractStart(3);
            }
        }

        @Override // com.tencent.gdtad.basics.flip.b.a
        public void onError() {
        }

        @Override // com.tencent.gdtad.basics.flip.b.a
        public void onRotationChanged(float f16, boolean z16) {
        }
    }
}
