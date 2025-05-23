package com.tencent.gdtad.basics.twist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.RingShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.flip.FlipView;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.gdtad.basics.adshake.RotationSensor;
import com.tencent.gdtad.basics.twist.a;
import com.tencent.gdtad.basics.twist.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TwistView extends FrameLayout implements b.a {

    /* renamed from: j0, reason: collision with root package name */
    private static final int f109112j0 = Color.parseColor("#00000000");

    /* renamed from: k0, reason: collision with root package name */
    private static final int f109113k0 = Color.parseColor("#7F000000");

    /* renamed from: l0, reason: collision with root package name */
    protected static final int f109114l0 = Color.parseColor("#CCFFFFFF");

    /* renamed from: m0, reason: collision with root package name */
    private static final int f109115m0 = Color.parseColor("#7F191919");
    private boolean C;
    private volatile boolean D;
    private volatile boolean E;
    private b F;
    private int G;
    private int H;
    private String I;
    private String J;
    private boolean K;
    private RingShapeLayer L;
    private ProgressAnimator M;
    private List<PathShapeLayer> N;
    private RotationAnimator P;
    private AnimatorLayer Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;
    private float W;

    /* renamed from: a0, reason: collision with root package name */
    private float f109116a0;

    /* renamed from: b0, reason: collision with root package name */
    private float f109117b0;

    /* renamed from: c0, reason: collision with root package name */
    private float f109118c0;

    /* renamed from: d, reason: collision with root package name */
    private final AnimatorView f109119d;

    /* renamed from: d0, reason: collision with root package name */
    private float f109120d0;

    /* renamed from: e, reason: collision with root package name */
    private final RotationSensor f109121e;

    /* renamed from: e0, reason: collision with root package name */
    private float f109122e0;

    /* renamed from: f, reason: collision with root package name */
    private int f109123f;

    /* renamed from: f0, reason: collision with root package name */
    private float f109124f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f109125g0;

    /* renamed from: h, reason: collision with root package name */
    private float f109126h;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.gdtad.basics.twist.b f109127h0;

    /* renamed from: i, reason: collision with root package name */
    private float f109128i;

    /* renamed from: i0, reason: collision with root package name */
    private TextLayer f109129i0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f109130m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements Animator.AnimatorProgressListener {
        a() {
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorProgressListener
        public void onAnimationProgressUpdate(float f16) {
            float f17;
            if (TwistView.this.f109123f == 2) {
                f17 = 45.0f;
            } else {
                f17 = 150.0f;
            }
            TwistView twistView = TwistView.this;
            twistView.p(Math.abs(twistView.Q.getRotationDegrees()) / f17);
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorProgressListener
        public int updateInterval() {
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface b {
        void onBackInteractProgress(float f16, int i3);

        void onInteractProgress(float f16, int i3);

        void onInteractResult(boolean z16);

        void onInteractStart();
    }

    public TwistView(@NonNull Context context) {
        super(context);
        this.f109123f = 0;
        this.f109126h = 90.0f;
        this.f109128i = 0.0f;
        this.G = 0;
        this.H = 48;
        this.K = true;
        AnimatorView animatorView = new AnimatorView(context);
        this.f109119d = animatorView;
        addView(animatorView);
        RotationSensor rotationSensor = new RotationSensor(getContext());
        this.f109121e = rotationSensor;
        com.tencent.gdtad.basics.twist.b bVar = new com.tencent.gdtad.basics.twist.b(this);
        this.f109127h0 = bVar;
        rotationSensor.setOnRotationChangeListener(bVar);
    }

    private void d() {
        this.R = Utils.dp2px(14.0f);
        this.S = Utils.dp2px(18.0f);
        float height = ((getHeight() - Utils.dp2px(this.G)) - Utils.dp2px(this.H)) - Utils.getTextPaintBaselineToBottom(this.R);
        this.T = height;
        this.U = ((height - Utils.getTextPaintHeight(this.R)) - Utils.dp2px(4.0f)) - Utils.getTextPaintBaselineToBottom(this.S);
        this.V = Utils.dp2px(70.0f);
        this.W = Utils.dp2px(70.0f);
        this.f109116a0 = (getWidth() - this.V) / 2.0f;
        this.f109117b0 = ((this.U - Utils.getTextPaintHeight(this.S)) - Utils.dp2px(10.0f)) - this.W;
        this.f109118c0 = getWidth() / 2.0f;
        this.f109120d0 = ((getHeight() - Utils.dp2px(110.0f)) - Utils.dp2px(this.G)) - Utils.dp2px(this.H);
        this.f109122e0 = Utils.dp2px(49.0f);
        this.f109124f0 = Utils.dp2px(8.0f);
        this.f109125g0 = Utils.dp2px(16.0f) * 1.414f;
    }

    private PathShapeLayer e() {
        int dp2px = (int) (Utils.dp2px(192.0f) + Utils.dp2px(this.H));
        int[] iArr = {f109112j0, f109113k0};
        int width = getWidth();
        int height = getHeight() - ((int) Utils.dp2px(this.G));
        float f16 = height - dp2px;
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

    private AnimatorLayer f() {
        float cos;
        float sin;
        if (this.f109123f == 2) {
            cos = this.f109118c0;
            sin = this.f109120d0 - this.f109122e0;
        } else {
            float radians = (float) Math.toRadians(-45.0d);
            if (this.f109123f == 0) {
                radians = (float) Math.toRadians(-135.0d);
            }
            double d16 = radians;
            cos = (float) (this.f109118c0 + (this.f109122e0 * Math.cos(d16)));
            sin = (float) (this.f109120d0 + (this.f109122e0 * Math.sin(d16)));
        }
        RingShapeLayer strokeCap = new RingShapeLayer(cos, sin, this.f109124f0 / 2.0f, -1, 1.0f).setStrokeCap(Paint.Cap.BUTT);
        strokeCap.setStartAngle(0.0f);
        strokeCap.setSweepAngle(360.0f);
        strokeCap.setUseCenter(true);
        strokeCap.setStyle(Paint.Style.FILL);
        strokeCap.postProgress(100.0f);
        strokeCap.setAnimator(new KeepAnimator(strokeCap));
        return strokeCap;
    }

    private AnimatorLayer g() {
        AnimatorLayer c16 = com.tencent.gdtad.basics.twist.a.c(getContext(), new a.C1160a(this.f109116a0, this.f109117b0, this.V, this.W));
        this.Q = c16;
        if (c16 != null) {
            c16.setAnimator(com.tencent.gdtad.basics.twist.a.b(c16, this.f109123f, new a()));
        }
        this.P = null;
        return this.Q;
    }

    private AnimatorLayer h() {
        RingShapeLayer strokeCap = new RingShapeLayer(this.f109118c0, this.f109120d0, this.f109122e0, -1, this.f109124f0).setStrokeCap(Paint.Cap.BUTT);
        strokeCap.postAlpha(153);
        strokeCap.setStartAngle(-45.0f);
        strokeCap.setSweepAngle(-90.0f);
        strokeCap.postProgress(100.0f);
        strokeCap.setAnimator(new KeepAnimator(strokeCap));
        return strokeCap;
    }

    private AnimatorLayer i() {
        float f16;
        int i3 = this.f109123f;
        float f17 = 90.0f;
        if (i3 == 0) {
            f16 = -135.0f;
        } else if (i3 == 2) {
            f16 = -90.0f;
        } else {
            f16 = -45.0f;
            f17 = -90.0f;
        }
        RingShapeLayer strokeCap = new RingShapeLayer(this.f109118c0, this.f109120d0, this.f109122e0, -1, this.f109124f0).setStrokeCap(Paint.Cap.ROUND);
        this.L = strokeCap;
        strokeCap.setStartAngle(f16);
        this.L.setSweepAngle(f17);
        ProgressAnimator progressAnimator = new ProgressAnimator(this.L, 0.0f, 0.0f);
        this.M = progressAnimator;
        this.L.setAnimator(progressAnimator);
        return this.L;
    }

    private TextLayer j() {
        return k(this.J, f109114l0, this.R, this.T, false);
    }

    private TextLayer k(String str, int i3, float f16, float f17, boolean z16) {
        Logger.i("TwistView", "createTextLayer, text:" + str + ", y:" + f17);
        TextLayer textLayer = new TextLayer(str, i3, f16);
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setX(((float) getWidth()) / 2.0f);
        textLayer.setY(f17);
        textLayer.setTextBold(z16);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private TextLayer l() {
        return k(this.I, -1, this.S, this.U, true);
    }

    private PathShapeLayer m(int i3) {
        Path path = new Path();
        float radians = (float) Math.toRadians(-135.0d);
        if (i3 == 0) {
            radians = (float) Math.toRadians(-45.0d);
        }
        double d16 = radians;
        float cos = (float) (this.f109118c0 + ((this.f109122e0 - (this.f109125g0 / 2.0f)) * Math.cos(d16)));
        float sin = (float) (this.f109120d0 + ((this.f109122e0 - (this.f109125g0 / 2.0f)) * Math.sin(d16)));
        float cos2 = (float) (this.f109118c0 + ((this.f109122e0 + (this.f109125g0 / 2.0f)) * Math.cos(d16)));
        float sin2 = (float) (this.f109120d0 + ((this.f109122e0 + (this.f109125g0 / 2.0f)) * Math.sin(d16)));
        path.moveTo(cos, sin);
        path.lineTo(cos2, sin2);
        path.lineTo(cos2, sin);
        path.close();
        PathShapeLayer pathShapeLayer = new PathShapeLayer(path, null, Paint.Style.FILL);
        pathShapeLayer.setColor(-1);
        pathShapeLayer.postAlpha(153);
        pathShapeLayer.setPathEffect(new CornerPathEffect(Utils.dp2px(2.0f)));
        pathShapeLayer.setAnimator(new KeepAnimator(pathShapeLayer));
        return pathShapeLayer;
    }

    private void n() {
        this.F.onInteractResult(true);
        this.f109121e.stop();
        this.f109130m = true;
    }

    private void o(float f16, float f17) {
        AnimatorLayer animatorLayer = this.Q;
        if (animatorLayer == null) {
            return;
        }
        if (f17 > 0.0f) {
            f16 = -f16;
        }
        float f18 = f16 * 45.0f;
        RotationAnimator rotationAnimator = this.P;
        if (rotationAnimator == null) {
            Animator animator = animatorLayer.getAnimator();
            if (animator != null) {
                animator.cancelAnimation();
            }
            float rotationDegrees = this.Q.getRotationDegrees();
            RotationAnimator rotationAnimator2 = new RotationAnimator(this.Q);
            rotationAnimator2.setRepeatCount(1);
            rotationAnimator2.setDuration(60L);
            rotationAnimator2.setRotationDegrees(rotationDegrees, f18);
            this.Q.setAnimator(rotationAnimator2);
            this.P = rotationAnimator2;
            return;
        }
        rotationAnimator.setDuration(0L);
        rotationAnimator.setRotationDegrees(f18, f18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(float f16) {
        RingShapeLayer ringShapeLayer;
        ProgressAnimator progressAnimator = this.M;
        if (progressAnimator != null) {
            progressAnimator.setFromProgress(f16);
            this.M.setToProgress(f16);
        }
        if (this.f109123f == 2 && (ringShapeLayer = this.L) != null) {
            ringShapeLayer.setStartAngle((-90.0f) - (f16 * 45.0f));
        }
    }

    private void q(float f16, int i3) {
        List<PathShapeLayer> list;
        float f17 = i3 / 100.0f;
        if (f17 < 0.0f) {
            f17 = 0.0f;
        } else if (f17 > 1.0f) {
            f17 = 1.0f;
        }
        p(f17);
        o(f17, f16);
        if (f17 == 1.0f && (list = this.N) != null) {
            Iterator<PathShapeLayer> it = list.iterator();
            while (it.hasNext()) {
                it.next().postAlpha(255);
            }
        }
    }

    @Override // com.tencent.gdtad.basics.twist.b.a
    public void onBackInteractProgress(float f16, int i3) {
        q(f16, i3);
        TextLayer textLayer = this.f109129i0;
        if (textLayer != null) {
            textLayer.setText(FlipView.DEFAULT_REVERSE_TITLE_TEXT);
        }
        b bVar = this.F;
        if (bVar != null) {
            bVar.onBackInteractProgress(f16, i3);
        }
    }

    @Override // com.tencent.gdtad.basics.twist.b.a
    public void onInteractProgress(float f16, int i3) {
        q(f16, i3);
        b bVar = this.F;
        if (bVar != null) {
            bVar.onInteractProgress(f16, i3);
        }
    }

    @Override // com.tencent.gdtad.basics.twist.b.a
    public void onInteractStart() {
        b bVar = this.F;
        if (bVar != null) {
            bVar.onInteractStart();
        }
    }

    @Override // com.tencent.gdtad.basics.twist.b.a
    public void onInteractSuccess() {
        n();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.C && !this.f109130m) {
            Logger.i("TwistView", "onSizeChanged() start() mHasPause: " + this.E);
            if (this.E) {
                return;
            }
            r();
        }
    }

    public void r() {
        Logger.i("TwistView", "start()");
        this.C = true;
        if (getWidth() > 0 && getHeight() > 0) {
            d();
            ArrayList arrayList = new ArrayList();
            if (this.K) {
                arrayList.add(e());
            }
            arrayList.add(j());
            TextLayer l3 = l();
            this.f109129i0 = l3;
            arrayList.add(l3);
            arrayList.add(g());
            arrayList.add(h());
            arrayList.add(f());
            ArrayList arrayList2 = new ArrayList();
            this.N = arrayList2;
            int i3 = this.f109123f;
            if (i3 == 2) {
                arrayList2.add(m(0));
                this.N.add(m(1));
            } else {
                arrayList2.add(m(i3));
            }
            arrayList.addAll(this.N);
            arrayList.add(i());
            GroupLayer groupLayer = new GroupLayer((AnimatorLayer[]) arrayList.toArray(new AnimatorLayer[0]));
            this.f109119d.clearLayers();
            this.f109119d.addLayer(groupLayer);
            this.f109119d.startAnimation();
            this.f109121e.start();
            this.D = true;
            this.E = false;
            Logger.i("TwistView", "start() ...");
            return;
        }
        Logger.i("TwistView", "start() widthHeight=0, return");
    }

    public void s() {
        Logger.i("TwistView", "stop()");
        this.f109119d.stopAnimation();
        this.f109121e.stop();
    }

    public void setBottomPaddingDp(int i3) {
        if (i3 >= 0) {
            this.G = i3;
        }
    }

    public void setDirection(int i3) {
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            Logger.w("TwistView", "invalid direction: " + i3);
            return;
        }
        this.f109123f = i3;
        com.tencent.gdtad.basics.twist.b bVar = this.f109127h0;
        if (bVar != null) {
            bVar.f(i3);
        }
    }

    public void setEnableShowBgShadow(boolean z16) {
        this.K = z16;
    }

    public void setReverseAngle(float f16) {
        if (f16 <= 0.0f) {
            Logger.i("TwistView", "invalid reverseAngle");
            return;
        }
        this.f109128i = f16;
        com.tencent.gdtad.basics.twist.b bVar = this.f109127h0;
        if (bVar != null) {
            bVar.g(f16);
        }
    }

    public void setSubTitle(String str) {
        this.J = str;
    }

    public void setTargetAngle(float f16) {
        if (f16 <= 0.0f) {
            Logger.i("TwistView", "invalid targetAngle");
            return;
        }
        this.f109126h = f16;
        com.tencent.gdtad.basics.twist.b bVar = this.f109127h0;
        if (bVar != null) {
            bVar.h(f16);
        }
    }

    public void setTextBottomMarginDp(int i3) {
        if (i3 >= 0) {
            this.H = i3;
        }
    }

    public void setTitle(String str) {
        this.I = str;
    }

    public void setTwistInteractListener(b bVar) {
        this.F = bVar;
    }

    public void setViewsShowOnTop(AnimatorView.ViewShowOnTop[] viewShowOnTopArr) {
        this.f109119d.setViewsShowOnTop(viewShowOnTopArr);
    }
}
