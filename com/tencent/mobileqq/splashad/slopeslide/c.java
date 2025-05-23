package com.tencent.mobileqq.splashad.slopeslide;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import com.tencent.gdtad.basics.adshake.animatorview.animator.Animator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.GroupAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.ProgressAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.RotationXAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.SequentialAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.BitmapLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.GroupLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.PathShapeLayer;
import com.tencent.gdtad.basics.adshake.util.ShakeUtils;
import com.tencent.gdtad.basics.adshake.util.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends GroupLayer {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private BitmapLayer f288915d;

    /* renamed from: e, reason: collision with root package name */
    private PathShapeLayer f288916e;

    /* renamed from: f, reason: collision with root package name */
    private Context f288917f;

    /* renamed from: h, reason: collision with root package name */
    private a f288918h;

    /* renamed from: i, reason: collision with root package name */
    private float f288919i;

    /* renamed from: m, reason: collision with root package name */
    private float f288920m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a extends GroupAnimator {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private C8604c f288921a;

        /* renamed from: b, reason: collision with root package name */
        private b f288922b;

        public a(AnimatorLayer animatorLayer, Animator... animatorArr) {
            super(animatorLayer, animatorArr);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayer, (Object) animatorArr);
            } else {
                a(animatorLayer);
            }
        }

        private void a(AnimatorLayer animatorLayer) {
            b bVar = new b(animatorLayer);
            this.f288922b = bVar;
            bVar.setRepeatCount(0);
            C8604c c8604c = new C8604c(animatorLayer);
            this.f288921a = c8604c;
            c8604c.setRepeatCount(0);
            addAnimators(this.f288922b, this.f288921a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
        
            if (r5 > 1.0f) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
                return;
            }
            float f17 = 0.0f;
            if (f16 >= 0.0f) {
                f17 = 1.0f;
            }
            f16 = f17;
            C8604c c8604c = this.f288921a;
            if (c8604c != null) {
                c8604c.a(f16);
            }
        }

        public void c(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
                return;
            }
            b bVar = this.f288922b;
            if (bVar != null) {
                bVar.a(f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b extends RotationXAnimator {
        static IPatchRedirector $redirector_;

        public b(AnimatorLayer animatorLayer) {
            super(animatorLayer);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayer);
            }
        }

        public void a(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
            } else {
                setRotationDegrees(f16, f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.splashad.slopeslide.c$c, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C8604c extends ProgressAnimator {
        static IPatchRedirector $redirector_;

        public C8604c(AnimatorLayer animatorLayer, float f16, float f17) {
            super(animatorLayer, f16, f17);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, animatorLayer, Float.valueOf(f16), Float.valueOf(f17));
        }

        public void a(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            } else {
                setFromProgress(f16);
                setToProgress(f16);
            }
        }

        @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.ProgressAnimator, com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
        protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, canvas, animatorLayer, Boolean.valueOf(z16));
            } else if (z16 && !shouldRepeat()) {
                animatorLayer.postProgress(getToProgress());
            } else {
                animatorLayer.postProgress(computeProgress());
            }
        }

        public C8604c(AnimatorLayer animatorLayer) {
            super(animatorLayer, 0.0f, 0.0f);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animatorLayer);
        }
    }

    public c(Context context) {
        super(new AnimatorLayer[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f288917f = context.getApplicationContext();
        int relativeSize = Utils.getRelativeSize(104);
        int relativeSize2 = Utils.getRelativeSize(152);
        this.f288919i = Utils.getRelativeSize(16);
        this.f288920m = Utils.getRelativeSize(14);
        setWidth(relativeSize);
        setHeight(relativeSize2);
        this.f288915d = b(context);
        PathShapeLayer c16 = c();
        this.f288916e = c16;
        addLayers(this.f288915d, c16);
        this.f288918h = new a(this, new Animator[0]);
        setAnimator(a());
    }

    private Animator a() {
        SequentialAnimator sequentialAnimator = new SequentialAnimator(this, d(), e(), f());
        sequentialAnimator.setRepeatCount(0);
        return sequentialAnimator;
    }

    private BitmapLayer b(Context context) {
        if (context == null) {
            return null;
        }
        int width = getWidth();
        int height = getHeight();
        BitmapLayer bitmapLayer = new BitmapLayer(ShakeUtils.createBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.o3c), width, height, true));
        bitmapLayer.setWidth(width);
        bitmapLayer.setHeight(height);
        bitmapLayer.setX(getX());
        bitmapLayer.setY(getY());
        return bitmapLayer;
    }

    private PathShapeLayer c() {
        d dVar = new d();
        dVar.setShader(g());
        int relativeSize = Utils.getRelativeSize(72);
        int relativeSize2 = Utils.getRelativeSize(120);
        float relativeSize3 = Utils.getRelativeSize(16);
        float relativeSize4 = Utils.getRelativeSize(14);
        dVar.setWidth(relativeSize);
        dVar.setHeight(relativeSize2);
        dVar.b(relativeSize3, relativeSize4);
        return dVar;
    }

    private Animator d() {
        RotationXAnimator rotationXAnimator = new RotationXAnimator(this);
        rotationXAnimator.setRotationDegrees(0.0f, 20.0f);
        GroupAnimator groupAnimator = new GroupAnimator(this, rotationXAnimator, new C8604c(this, 0.0f, 0.3f));
        groupAnimator.setDuration(720L);
        groupAnimator.setPathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        return groupAnimator;
    }

    private Animator e() {
        RotationXAnimator rotationXAnimator = new RotationXAnimator(this);
        rotationXAnimator.setRotationDegrees(20.0f, 0.0f);
        GroupAnimator groupAnimator = new GroupAnimator(this, rotationXAnimator, new C8604c(this, 0.3f, 0.0f));
        groupAnimator.setDuration(400L);
        groupAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        return groupAnimator;
    }

    private RotationXAnimator f() {
        RotationXAnimator rotationXAnimator = new RotationXAnimator(this);
        rotationXAnimator.setDuration(560L);
        rotationXAnimator.setRotationDegrees(0.0f, 0.0f);
        return rotationXAnimator;
    }

    private Shader g() {
        return new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), new int[]{1358954495, 1358954495}, (float[]) null, Shader.TileMode.MIRROR);
    }

    public void h(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            return;
        }
        super.postRotationX(f16, getCenterX(), getCenterY());
        a aVar = this.f288918h;
        if (aVar != null) {
            aVar.c(f16);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            setAnimator(this.f288918h);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.GroupLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            return;
        }
        a aVar = this.f288918h;
        if (aVar != null) {
            aVar.b(f16);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public AnimatorLayer setX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        }
        BitmapLayer bitmapLayer = this.f288915d;
        if (bitmapLayer != null) {
            bitmapLayer.setX(f16);
        }
        PathShapeLayer pathShapeLayer = this.f288916e;
        if (pathShapeLayer != null) {
            pathShapeLayer.setX(f16);
        }
        return super.setX(f16);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public AnimatorLayer setY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        }
        BitmapLayer bitmapLayer = this.f288915d;
        if (bitmapLayer != null) {
            bitmapLayer.setY(f16);
        }
        PathShapeLayer pathShapeLayer = this.f288916e;
        if (pathShapeLayer != null) {
            pathShapeLayer.setY(f16);
        }
        return super.setY(f16);
    }
}
