package com.tencent.mobileqq.splashad.slopeslide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.gdtad.basics.adshake.RotationSensor;
import com.tencent.gdtad.basics.adshake.animatorview.AnimatorView;
import com.tencent.gdtad.basics.adshake.animatorview.animator.AlphaAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.Animator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.GroupAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.KeepAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.ScaleAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.SequentialAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.TranslateAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.BitmapLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.GroupLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.PathShapeLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.TextLayer;
import com.tencent.gdtad.basics.adshake.util.ShakeUtils;
import com.tencent.gdtad.basics.adshake.util.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.splashad.slopeslide.b;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SlopeSlideView extends AnimatorView implements RotationSensor.OnRotationChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: j0, reason: collision with root package name */
    private static final int f288887j0;

    /* renamed from: k0, reason: collision with root package name */
    private static final int f288888k0;

    /* renamed from: l0, reason: collision with root package name */
    private static final int f288889l0;
    private BitmapLayer C;
    private BitmapLayer D;
    private com.tencent.mobileqq.splashad.slopeslide.b E;
    private com.tencent.mobileqq.splashad.slopeslide.a F;
    private Animator G;
    private Animator H;
    private boolean I;
    private volatile boolean J;
    private boolean K;
    private boolean L;
    private float M;

    @Reason
    private int N;
    private c P;
    private boolean Q;
    private boolean R;
    private String S;
    private String T;
    private Bitmap U;
    private float V;
    private Rect W;

    /* renamed from: a0, reason: collision with root package name */
    private float f288890a0;

    /* renamed from: b0, reason: collision with root package name */
    private float f288891b0;

    /* renamed from: c0, reason: collision with root package name */
    private float f288892c0;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.splashad.slopeslide.c f288893d;

    /* renamed from: d0, reason: collision with root package name */
    private float f288894d0;

    /* renamed from: e, reason: collision with root package name */
    private TextLayer f288895e;

    /* renamed from: e0, reason: collision with root package name */
    private int f288896e0;

    /* renamed from: f, reason: collision with root package name */
    private TextLayer f288897f;

    /* renamed from: f0, reason: collision with root package name */
    private float f288898f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f288899g0;

    /* renamed from: h, reason: collision with root package name */
    private BitmapLayer f288900h;

    /* renamed from: h0, reason: collision with root package name */
    private float f288901h0;

    /* renamed from: i, reason: collision with root package name */
    private PathShapeLayer f288902i;

    /* renamed from: i0, reason: collision with root package name */
    private final ViewConfiguration f288903i0;

    /* renamed from: m, reason: collision with root package name */
    private final RotationSensor f288904m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public @interface InteractType {
        public static final int CLICK = 3;
        public static final int ROTATION = 1;
        public static final int SLIDE = 2;
        public static final int UNKNOWN = 0;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public @interface Reason {
        public static final int NONE = 0;
        public static final int NOT_INTERACTIVE = 1;
        public static final int SLIDE_DO_NOT_IN_HOTAREA = 3;
        public static final int SLIDE_DO_NOT_REACH_THRESHOLD = 2;
        public static final int SLOPE_DO_NOT_REACH_THRESHOLD = 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements b.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SlopeSlideView.this);
            }
        }

        @Override // com.tencent.mobileqq.splashad.slopeslide.b.a
        public void a(boolean z16, int i3, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17));
                return;
            }
            QLog.d("SlopeSlideView", 1, "onGestureMatchFinish:" + z16);
            SlopeSlideView.this.N = i3;
            SlopeSlideView.this.P.onInteractFinish(2, z16, new Point((int) f16, (int) f17));
        }

        @Override // com.tencent.mobileqq.splashad.slopeslide.b.a
        public void b(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17));
                return;
            }
            if (SlopeSlideView.this.f288904m != null) {
                SlopeSlideView.this.f288904m.stop();
            }
            if (SlopeSlideView.this.f288893d != null) {
                SlopeSlideView.this.f288893d.setAnimator(new KeepAnimator(SlopeSlideView.this.f288893d));
            }
            SlopeSlideView.this.y(2, new Point((int) f16, (int) f17));
        }

        @Override // com.tencent.mobileqq.splashad.slopeslide.b.a
        public void onGestureMatchStart(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17));
            } else if (SlopeSlideView.this.P != null) {
                SlopeSlideView.this.P.onInteractStart(2, new Point((int) f16, (int) f17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SlopeSlideView.this);
            }
        }

        @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator.AnimatorListener
        public void onAnimationFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SlopeSlideView.this.L = true;
                if (SlopeSlideView.this.P != null) {
                    SlopeSlideView.this.P.onAnimatorFinish();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        void onAnimatorFinish();

        void onAnimatorStart();

        void onInteractFinish(@InteractType int i3, boolean z16, Point point);

        void onInteractResult(@InteractType int i3, boolean z16, @Reason int i16, Point point, float f16);

        void onInteractStart(@InteractType int i3, Point point);

        void onSensorError();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75242);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
            return;
        }
        f288887j0 = Color.parseColor("#CCFFFFFF");
        f288888k0 = Color.parseColor("#00000000");
        f288889l0 = Color.parseColor("#7F000000");
    }

    public SlopeSlideView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.I = false;
        this.M = 0.0f;
        this.N = 0;
        this.R = true;
        this.V = 40.0f;
        this.f288896e0 = -1;
        RotationSensor rotationSensor = new RotationSensor(getContext());
        this.f288904m = rotationSensor;
        rotationSensor.setOnRotationChangeListener(this);
        this.f288903i0 = ViewConfiguration.get(context);
    }

    private void g() {
        float width = (getWidth() - Utils.getRelativeSize(78)) / 2.0f;
        if (this.C == null) {
            BitmapLayer o16 = o(width, Utils.getRelativeSize(98));
            this.C = o16;
            AlphaAnimator alphaAnimator = new AlphaAnimator(o16, 0.2f, 1.0f);
            alphaAnimator.setDuration(720L);
            alphaAnimator.setPathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
            AlphaAnimator alphaAnimator2 = new AlphaAnimator(this.C, 1.0f, 0.2f);
            alphaAnimator2.setDuration(400L);
            alphaAnimator2.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
            AlphaAnimator alphaAnimator3 = new AlphaAnimator(this.C, 0.2f, 0.2f);
            alphaAnimator3.setDuration(560L);
            SequentialAnimator sequentialAnimator = new SequentialAnimator(this.C, alphaAnimator, alphaAnimator2, alphaAnimator3);
            sequentialAnimator.setRepeatMode(1);
            sequentialAnimator.setRepeatCount(0);
            this.C.setAnimator(sequentialAnimator);
        }
        if (this.D == null) {
            BitmapLayer o17 = o(width, Utils.getRelativeSize(66));
            this.D = o17;
            AlphaAnimator alphaAnimator4 = new AlphaAnimator(o17, 0.2f, 0.2f);
            alphaAnimator4.setDuration(360L);
            AlphaAnimator alphaAnimator5 = new AlphaAnimator(this.D, 0.2f, 1.0f);
            alphaAnimator5.setDuration(360L);
            alphaAnimator5.setPathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
            AlphaAnimator alphaAnimator6 = new AlphaAnimator(this.D, 1.0f, 0.2f);
            alphaAnimator6.setDuration(400L);
            alphaAnimator6.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
            AlphaAnimator alphaAnimator7 = new AlphaAnimator(this.D, 0.2f, 0.2f);
            alphaAnimator7.setDuration(560L);
            SequentialAnimator sequentialAnimator2 = new SequentialAnimator(this.D, alphaAnimator4, alphaAnimator5, alphaAnimator6, alphaAnimator7);
            sequentialAnimator2.setRepeatMode(1);
            sequentialAnimator2.setRepeatCount(0);
            this.D.setAnimator(sequentialAnimator2);
        }
    }

    private void h() {
        com.tencent.mobileqq.splashad.slopeslide.a aVar = new com.tencent.mobileqq.splashad.slopeslide.a(getWidth() / 2.0f, r(), s());
        aVar.setShader(new LinearGradient(aVar.getX(), aVar.getY(), aVar.getX(), getHeight(), new int[]{1291845632, 0}, (float[]) null, Shader.TileMode.MIRROR));
        aVar.setAnimator(new KeepAnimator(aVar));
        this.F = aVar;
    }

    private void i() {
        if (this.f288902i == null) {
            int relativeSize = Utils.getRelativeSize(480);
            int[] iArr = {f288888k0, f288889l0};
            int width = getWidth();
            int height = getHeight();
            float f16 = height - relativeSize;
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
            this.f288902i = pathShapeLayer;
            this.f288902i.setAnimator(new KeepAnimator(pathShapeLayer));
        }
    }

    private void init() {
        GroupLayer groupLayer;
        if (getWidth() > 0 && getHeight() > 0) {
            if (this.f288897f == null) {
                this.f288897f = p(this.T, f288887j0, ViewUtils.dpToPx(14.0f), u());
            }
            if (this.f288895e == null) {
                this.f288895e = p(this.S, -1, ViewUtils.dpToPx(18.0f), v());
            }
            l();
            n();
            g();
            m();
            if (this.I) {
                h();
            } else {
                j();
                i();
            }
            if (this.H == null) {
                this.H = new KeepAnimator(this.f288900h);
            }
            if (this.I) {
                groupLayer = new GroupLayer(this.f288902i, this.f288893d, this.f288897f, this.f288895e, this.f288900h, this.C, this.D, this.F);
            } else {
                groupLayer = new GroupLayer(this.f288902i, this.f288893d, this.f288897f, this.f288895e, this.f288900h, this.C, this.D, this.E);
            }
            addLayer(groupLayer);
        }
    }

    private void j() {
        this.W = q();
        com.tencent.mobileqq.splashad.slopeslide.b bVar = new com.tencent.mobileqq.splashad.slopeslide.b(getContext(), this.W, this.f288898f0);
        this.E = bVar;
        bVar.h(this.f288896e0);
        this.E.d(this.R);
        this.E.e(new a());
    }

    private void k() {
        float y16 = this.f288900h.getY() + (this.f288900h.getHeight() * 1.3f);
        float relativeSize = Utils.getRelativeSize(246);
        QLog.i("SlopeSlideView", 1, "createIconFlyAnimator, offset: " + y16);
        float f16 = -relativeSize;
        GroupAnimator groupAnimator = new GroupAnimator(this.f288900h, new TranslateAnimator(this.f288900h, 0.0f, 0.0f, 0.0f, f16), new ScaleAnimator((AnimatorLayer) this.f288900h, 1.0f, 1.3f, 1.0f, 1.3f));
        groupAnimator.setDuration(120L);
        groupAnimator.setPathInterpolator(0.37f, 0.0f, 0.63f, 1.0f);
        GroupAnimator groupAnimator2 = new GroupAnimator(this.f288900h, new TranslateAnimator(this.f288900h, 0.0f, 0.0f, f16, -y16), new ScaleAnimator((AnimatorLayer) this.f288900h, 1.3f, 1.3f, 1.3f, 1.3f));
        groupAnimator2.setDuration(300L);
        groupAnimator2.setPathInterpolator(0.33f, 1.0f, 0.68f, 1.0f);
        SequentialAnimator sequentialAnimator = new SequentialAnimator(this.f288900h, groupAnimator, groupAnimator2);
        sequentialAnimator.setAnimatorListener(new b());
        this.f288900h.setAnimator(sequentialAnimator);
    }

    private void l() {
        if (this.f288900h == null) {
            int relativeSize = Utils.getRelativeSize(260);
            float height = getHeight() - Utils.getRelativeSize(124);
            BitmapLayer bitmapLayer = new BitmapLayer(this.U);
            this.f288900h = bitmapLayer;
            bitmapLayer.setWidth(relativeSize);
            this.f288900h.setHeight(relativeSize);
            this.f288900h.setX((getWidth() - relativeSize) / 2.0f);
            this.f288900h.setY(height);
        }
    }

    private void m() {
        if (this.G == null) {
            float f16 = -Utils.getRelativeSize(20);
            TranslateAnimator translateAnimator = new TranslateAnimator(this.f288900h, 0.0f, 0.0f, 0.0f, f16);
            translateAnimator.setDuration(720L);
            translateAnimator.setPathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
            TranslateAnimator translateAnimator2 = new TranslateAnimator(this.f288900h, 0.0f, 0.0f, f16, 0.0f);
            translateAnimator2.setDuration(400L);
            translateAnimator2.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
            KeepAnimator keepAnimator = new KeepAnimator(this.f288900h);
            keepAnimator.setDuration(560L);
            SequentialAnimator sequentialAnimator = new SequentialAnimator(this.f288900h, translateAnimator, translateAnimator2, keepAnimator);
            this.G = sequentialAnimator;
            sequentialAnimator.setRepeatCount(0);
        }
    }

    private void n() {
        Context context = getContext();
        if (this.f288893d == null) {
            com.tencent.mobileqq.splashad.slopeslide.c cVar = new com.tencent.mobileqq.splashad.slopeslide.c(context);
            this.f288893d = cVar;
            cVar.setX((getWidth() - this.f288893d.getWidth()) / 2.0f);
            com.tencent.mobileqq.splashad.slopeslide.c cVar2 = this.f288893d;
            cVar2.setY(t(cVar2));
        }
    }

    private BitmapLayer o(float f16, int i3) {
        int relativeSize = Utils.getRelativeSize(78);
        int relativeSize2 = Utils.getRelativeSize(54);
        BitmapLayer bitmapLayer = new BitmapLayer(ShakeUtils.createBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.o3b), relativeSize, relativeSize2, true));
        bitmapLayer.setWidth(relativeSize);
        bitmapLayer.setHeight(relativeSize2);
        bitmapLayer.setX(f16);
        com.tencent.mobileqq.splashad.slopeslide.c cVar = this.f288893d;
        if (cVar != null) {
            bitmapLayer.setY(cVar.getY() - i3);
        }
        return bitmapLayer;
    }

    private TextLayer p(String str, int i3, float f16, float f17) {
        TextLayer textLayer = new TextLayer(str, i3, f16);
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setX(getWidth() / 2.0f);
        textLayer.setY(f17);
        textLayer.setTextBold(true);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private float r() {
        return u() + ViewUtils.dpToPx(32.0f);
    }

    private float s() {
        return ViewUtils.dpToPx(230.0f);
    }

    private float u() {
        return (getHeight() - Utils.getRelativeSize(167)) - Utils.getTextPaintBaselineToBottom(ViewUtils.dpToPx(14.0f));
    }

    private float v() {
        return ((u() - Utils.getTextPaintHeight(ViewUtils.dpToPx(14.0f))) - Utils.getRelativeSize(8)) - Utils.getTextPaintBaselineToBottom(ViewUtils.dpToPx(18.0f));
    }

    private boolean w(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                return super.onTouchEvent(motionEvent);
            }
            if (x(this.f288901h0, this.f288899g0) && com.tencent.mobileqq.vassplash.common.c.n(this.f288903i0, this.f288901h0, this.f288899g0, motionEvent.getX(), motionEvent.getY())) {
                RotationSensor rotationSensor = this.f288904m;
                if (rotationSensor != null) {
                    rotationSensor.stop();
                }
                com.tencent.mobileqq.splashad.slopeslide.c cVar = this.f288893d;
                if (cVar != null) {
                    cVar.setAnimator(new KeepAnimator(cVar));
                }
                y(3, new Point((int) this.f288901h0, (int) this.f288899g0));
            }
            return true;
        }
        this.f288901h0 = motionEvent.getX();
        this.f288899g0 = motionEvent.getY();
        return true;
    }

    private boolean x(float f16, float f17) {
        if (((float) Math.sqrt(Math.pow(Math.abs((getWidth() / 2.0f) - f16), 2.0d) + Math.pow(Math.abs(r() - f17), 2.0d))) <= s()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void y(@InteractType int i3, Point point) {
        if (!this.Q) {
            this.Q = true;
            c cVar = this.P;
            if (cVar != null) {
                cVar.onInteractResult(i3, true, 0, point, this.M);
            }
            k();
            c cVar2 = this.P;
            if (cVar2 != null) {
                cVar2.onAnimatorStart();
            }
        }
    }

    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.K = true;
        if (getWidth() > 0 && getHeight() > 0) {
            z();
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.RotationSensor.OnRotationChangeListener
    public void onChanged(float f16, float f17, float f18) {
        RotationSensor rotationSensor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        float f19 = -f16;
        if (f19 < 0.0f && (rotationSensor = this.f288904m) != null) {
            rotationSensor.resetRotation();
        }
        if (f19 > this.M) {
            this.M = f19;
        }
        c cVar = this.P;
        if (f19 > 5.0f || this.J) {
            if (!this.J) {
                com.tencent.mobileqq.splashad.slopeslide.c cVar2 = this.f288893d;
                if (cVar2 != null) {
                    cVar2.i();
                }
                if (cVar != null) {
                    cVar.onInteractStart(1, null);
                }
                this.J = true;
            }
            com.tencent.mobileqq.splashad.slopeslide.c cVar3 = this.f288893d;
            if (cVar3 != null) {
                cVar3.h(f19);
                this.f288893d.postProgress(f19 / this.V);
            }
        }
        if (f19 > this.V) {
            RotationSensor rotationSensor2 = this.f288904m;
            if (rotationSensor2 != null) {
                rotationSensor2.stop();
            }
            if (cVar != null) {
                cVar.onInteractFinish(1, true, null);
            }
            y(1, null);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.RotationSensor.OnRotationChangeListener
    public void onError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        c cVar = this.P;
        if (cVar != null) {
            cVar.onSensorError();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.K && !this.Q) {
            A();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.Q) {
            return super.onTouchEvent(motionEvent);
        }
        QLog.e("SlopeSlideView", 1, "slode slide touch " + motionEvent);
        if (this.E != null) {
            if (this.W == null) {
                Rect q16 = q();
                this.W = q16;
                if (q16 != null) {
                    this.E.f(q16);
                }
            }
            return this.E.c(motionEvent);
        }
        if (this.I) {
            return w(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.AnimatorView, com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void pauseAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.pauseAnimation();
        if (!this.Q) {
            this.f288904m.pause();
        }
    }

    public Rect q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Rect) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        Rect rect = this.W;
        if (rect != null) {
            return rect;
        }
        Rect rect2 = new Rect();
        getLocalVisibleRect(rect2);
        if (rect2.width() != 0 && rect2.height() != 0) {
            rect2.left = (int) this.f288890a0;
            rect2.right = (int) (rect2.right - this.f288891b0);
            int i3 = (int) (rect2.bottom - this.f288892c0);
            rect2.bottom = i3;
            rect2.top = (int) (i3 - this.f288894d0);
            this.W = rect2;
            return rect2;
        }
        return null;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.AnimatorView, com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void resumeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.resumeAnimation();
        if (!this.Q) {
            this.f288904m.resume();
        }
    }

    public void setEnableShowStroke(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
            return;
        }
        this.R = z16;
        com.tencent.mobileqq.splashad.slopeslide.b bVar = this.E;
        if (bVar != null) {
            bVar.d(z16);
        }
    }

    public void setHotArea(int i3, float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        if (getContext() != null && getContext().getResources() != null) {
            Resources resources = getContext().getResources();
            this.f288890a0 = TypedValue.applyDimension(i3, f16, resources.getDisplayMetrics());
            this.f288891b0 = TypedValue.applyDimension(i3, f17, resources.getDisplayMetrics());
            this.f288892c0 = TypedValue.applyDimension(i3, f18, resources.getDisplayMetrics());
            this.f288894d0 = TypedValue.applyDimension(i3, f19, resources.getDisplayMetrics());
        }
    }

    public void setIconBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bitmap);
            return;
        }
        int relativeSize = Utils.getRelativeSize(260);
        Bitmap createBitmap = ShakeUtils.createBitmap(bitmap, relativeSize, relativeSize, true);
        this.U = createBitmap;
        BitmapLayer bitmapLayer = this.f288900h;
        if (bitmapLayer != null) {
            bitmapLayer.setBitmap(createBitmap);
        }
    }

    public void setIsOnlyEnableClick(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.I = z16;
        }
    }

    public void setOnSlopeSlideInteractListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) cVar);
        } else {
            this.P = cVar;
        }
    }

    public void setRotationThreshold(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
        } else if (f16 > 0.0f) {
            this.V = f16;
        }
    }

    public void setSlideThreshold(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        if (getContext() != null && getContext().getResources() != null) {
            float applyDimension = TypedValue.applyDimension(i3, f16, getContext().getResources().getDisplayMetrics());
            this.f288898f0 = applyDimension;
            com.tencent.mobileqq.splashad.slopeslide.b bVar = this.E;
            if (bVar != null) {
                bVar.g(applyDimension);
            }
        }
    }

    public void setSlideThresholdWithDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else {
            setSlideThreshold(1, f16);
        }
    }

    public void setStrokeColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
            return;
        }
        this.f288896e0 = i3;
        com.tencent.mobileqq.splashad.slopeslide.b bVar = this.E;
        if (bVar != null) {
            bVar.h(i3);
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        this.T = str;
        TextLayer textLayer = this.f288897f;
        if (textLayer != null) {
            textLayer.setText(str);
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        this.S = str;
        TextLayer textLayer = this.f288895e;
        if (textLayer != null) {
            textLayer.setText(str);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.AnimatorView, com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void startAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.startAnimation();
            this.f288904m.start();
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.AnimatorView, com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void stopAnimation() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.stopAnimation();
        this.f288904m.stop();
        synchronized (this) {
            c cVar = this.P;
            if (cVar != null) {
                if (!this.Q) {
                    if (this.M >= 5.0f) {
                        cVar.onInteractFinish(1, false, null);
                        i16 = 4;
                        i3 = 1;
                    } else {
                        int i17 = this.N;
                        if (i17 != 0) {
                            i16 = i17;
                            i3 = 2;
                        } else {
                            i3 = 0;
                            i16 = 0;
                        }
                    }
                    this.P.onInteractResult(i3, false, i16, null, this.M);
                } else if (!this.L) {
                    cVar.onAnimatorFinish();
                }
            }
        }
    }

    public float t(AnimatorLayer animatorLayer) {
        int height;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Float) iPatchRedirector.redirect((short) 18, (Object) this, (Object) animatorLayer)).floatValue();
        }
        float v3 = v();
        if (animatorLayer == null) {
            height = 0;
        } else {
            height = animatorLayer.getHeight();
        }
        return ((v3 - Utils.getTextPaintHeight(ViewUtils.dpToPx(18.0f))) - Utils.getRelativeSize(8)) - height;
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            clearLayers();
            init();
            BitmapLayer bitmapLayer = this.f288900h;
            if (bitmapLayer != null) {
                bitmapLayer.setAnimator(this.G);
            }
            startAnimation();
        } catch (Throwable th5) {
            QLog.e("SlopeSlideView", 1, "reset error.", th5);
        }
    }
}
