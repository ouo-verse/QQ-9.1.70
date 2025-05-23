package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends Drawable implements Animatable {
    private Drawable C;
    private ValueAnimator S;
    private WeakReference<f> W;

    /* renamed from: d, reason: collision with root package name */
    private AnimationDrawable f68906d;

    /* renamed from: e, reason: collision with root package name */
    private AnimationDrawable f68907e;

    /* renamed from: f, reason: collision with root package name */
    private AnimationDrawable f68908f;

    /* renamed from: h, reason: collision with root package name */
    private int f68909h;

    /* renamed from: i, reason: collision with root package name */
    private String f68910i;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f68911m;
    private Paint D = new Paint();
    private float E = 68.0f;
    private float F = 68.0f;
    private float G = 30.0f;
    private float H = 70.0f;
    private float I = 60.0f;
    private float J = 50.0f;
    private float K = 35.0f;
    private float L = 5.0f;
    private RectF M = new RectF();
    private int N = 255;
    private float P = this.L;
    private boolean Q = false;
    private int R = 1;
    private Map<String, Drawable> T = new HashMap();
    private Map<String, Drawable> U = new HashMap();
    private List<Integer> V = new ArrayList();
    Property<d, Integer> X = new a(Integer.class, "bfIndex");
    Property<d, Integer> Y = new b(Integer.class, "textAlpha");
    Property<d, Float> Z = new c(Float.class, "textPos");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.d$d, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0620d implements ValueAnimator.AnimatorUpdateListener {
        C0620d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface f {
        void b(int i3);

        void d(int i3);

        void h(int i3);

        void i(int i3, int i16, int i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int A() {
        return this.f68909h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float C() {
        return this.P;
    }

    private AnimationDrawable E(Context context, int i3) {
        AnimationDrawable animationDrawable = (AnimationDrawable) context.getResources().getDrawable(i3);
        animationDrawable.setVisible(true, false);
        animationDrawable.setOneShot(true);
        return animationDrawable;
    }

    private void F() {
        this.V.add(1000);
        this.V.add(42);
        this.V.add(47);
        this.V.add(54);
        this.V.add(61);
        this.V.add(65);
        this.V.add(67);
        this.V.add(69);
        this.V.add(66);
        this.V.add(64);
        this.V.add(64);
        this.V.add(64);
        this.V.add(64);
        this.V.add(64);
    }

    private void I(float f16, float f17, float f18, float f19) {
        RectF rectF = this.M;
        float f26 = f19 / 2.0f;
        rectF.bottom = f17 + f26;
        rectF.top = f17 - f26;
        float f27 = f18 / 2.0f;
        rectF.right = f16 + f27;
        rectF.left = f16 - f27;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i3) {
        WeakReference<f> weakReference;
        f fVar;
        this.f68909h = i3;
        int i16 = this.R;
        if (i16 == 2) {
            if (i3 >= 0 && i3 < this.V.size()) {
                M(this.K + this.V.get(this.f68909h).intValue());
                O(this.E);
            }
            int i17 = this.f68909h;
            if (i17 == 1) {
                this.N = 51;
                return;
            } else if (i17 == 2) {
                this.N = 127;
                return;
            } else {
                this.N = 255;
                return;
            }
        }
        if (i16 != 4 || (weakReference = this.W) == null || this.f68906d == null || (fVar = weakReference.get()) == null) {
            return;
        }
        fVar.i(this.R, this.f68909h, this.f68906d.getNumberOfFrames());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i3) {
        this.N = i3;
    }

    private void M(float f16) {
        I(getBounds().width() - f16, this.M.centerY(), this.M.width(), this.M.height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(float f16) {
        this.P = f16;
    }

    private void O(float f16) {
        I(this.M.centerX(), this.M.centerY(), f16, f16);
    }

    private void P(int i3, int i16) {
        ValueAnimator valueAnimator = this.S;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.S.removeAllUpdateListeners();
            this.S = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MarkDrawable", 2, "startValueAnimator: state:" + this.R + " mIndex:" + this.f68909h + " mTextAlpha:" + this.N);
        }
        if (i3 == 2) {
            AnimationDrawable animationDrawable = this.f68908f;
            if (animationDrawable != null) {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofInt(this.X, this.f68909h, animationDrawable.getNumberOfFrames()));
                this.S = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(600L);
            }
        } else if (i3 == 4) {
            if (this.f68906d != null) {
                int q16 = q(this.f68909h);
                if (QLog.isColorLevel()) {
                    QLog.d("MarkDrawable", 2, "calcBackIndex return : " + q16);
                }
                ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofInt(this.X, q16, this.f68906d.getNumberOfFrames()));
                this.S = ofPropertyValuesHolder2;
                ofPropertyValuesHolder2.setDuration(400L);
            }
        } else if (i3 == 5) {
            ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofInt(this.Y, this.N, 255), PropertyValuesHolder.ofFloat(this.Z, this.P, 0.0f));
            this.S = ofPropertyValuesHolder3;
            ofPropertyValuesHolder3.setDuration(i16);
        } else if (i3 == 6) {
            ObjectAnimator ofPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofInt(this.Y, this.N, 0));
            this.S = ofPropertyValuesHolder4;
            ofPropertyValuesHolder4.setDuration(i16);
        }
        ValueAnimator valueAnimator2 = this.S;
        if (valueAnimator2 != null) {
            valueAnimator2.setRepeatMode(1);
            this.S.setRepeatCount(0);
            this.S.setStartDelay(0L);
            this.S.addUpdateListener(new C0620d());
            this.S.addListener(new e());
            this.S.start();
        }
    }

    private void Q(Context context) {
        this.E = PickerContainer.r(context, this.E);
        this.F = PickerContainer.r(context, this.F);
        this.G = PickerContainer.r(context, this.G);
        this.H = PickerContainer.r(context, this.H);
        this.I = PickerContainer.r(context, this.I);
        this.J = PickerContainer.r(context, this.J);
        this.K = PickerContainer.r(context, this.K);
        this.L = PickerContainer.r(context, this.L);
        List<Integer> list = this.V;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < this.V.size(); i3++) {
            this.V.set(i3, Integer.valueOf((int) PickerContainer.r(context, r1.get(i3).intValue())));
        }
    }

    private int q(int i3) {
        if (i3 > this.f68906d.getNumberOfFrames()) {
            return 0;
        }
        return this.f68906d.getNumberOfFrames() - i3;
    }

    private void t(Canvas canvas) {
        if (this.f68911m == null || this.R == 1) {
            return;
        }
        RectF rectF = this.M;
        this.f68911m.setBounds(new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        this.f68911m.setAlpha(this.N);
        this.f68911m.draw(canvas);
    }

    private void u(Canvas canvas) {
        AnimationDrawable animationDrawable;
        int i3 = this.R;
        if (i3 == 1) {
            return;
        }
        if (i3 == 2) {
            AnimationDrawable animationDrawable2 = this.f68908f;
            if (animationDrawable2 != null) {
                int numberOfFrames = animationDrawable2.getNumberOfFrames();
                if (this.f68909h >= numberOfFrames) {
                    this.f68909h = numberOfFrames - 1;
                }
                Drawable frame = this.f68908f.getFrame(this.f68909h);
                if (frame != null) {
                    frame.draw(canvas);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 3) {
            AnimationDrawable animationDrawable3 = this.f68908f;
            Drawable frame2 = animationDrawable3.getFrame(animationDrawable3.getNumberOfFrames() - 1);
            if (frame2 != null) {
                frame2.draw(canvas);
                return;
            }
            return;
        }
        if (i3 != 4 || (animationDrawable = this.f68906d) == null) {
            return;
        }
        int numberOfFrames2 = animationDrawable.getNumberOfFrames();
        if (this.f68909h >= numberOfFrames2) {
            this.f68909h = numberOfFrames2 - 1;
        }
        Drawable frame3 = this.f68906d.getFrame(this.f68909h);
        if (frame3 != null) {
            frame3.draw(canvas);
        }
        Drawable frame4 = this.f68907e.getFrame(this.f68909h);
        if (frame4 != null) {
            frame4.draw(canvas);
        }
    }

    private void v(Canvas canvas) {
        int i3;
        if (TextUtils.isEmpty(this.f68910i) || this.C == null || (i3 = this.R) == 2 || i3 == 4 || i3 == 3) {
            return;
        }
        Rect bounds = getBounds();
        int i16 = (int) ((bounds.right - this.H) - this.I);
        int centerY = (int) (bounds.centerY() - (this.J / 2.0f));
        Rect rect = new Rect(i16, centerY, (int) (i16 + this.I), (int) (centerY + this.J));
        if (this.R == 5) {
            rect.offset(0, (int) this.P);
        }
        this.C.setBounds(rect);
        this.C.setAlpha(this.N);
        this.C.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i3) {
        f fVar;
        WeakReference<f> weakReference = this.W;
        if (weakReference == null || (fVar = weakReference.get()) == null) {
            return;
        }
        fVar.h(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i3) {
        f fVar;
        WeakReference<f> weakReference = this.W;
        if (weakReference == null || (fVar = weakReference.get()) == null) {
            return;
        }
        fVar.d(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i3) {
        f fVar;
        WeakReference<f> weakReference = this.W;
        if (weakReference == null || (fVar = weakReference.get()) == null) {
            return;
        }
        fVar.b(i3);
    }

    public boolean D(Context context, int i3, int i16, int i17, f fVar) {
        F();
        Q(context);
        this.f68906d = E(context, i3);
        this.f68907e = E(context, i16);
        this.f68908f = E(context, i17);
        this.W = new WeakReference<>(fVar);
        G(context);
        this.D.setTextSize(this.G);
        this.D.setColor(16777215);
        this.D.setTextAlign(Paint.Align.LEFT);
        return true;
    }

    public void H(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MarkDrawable", 2, "setAnimState: old state:" + this.R + " new state:" + i3);
        }
        this.R = i3;
        if (i3 != 2) {
            return;
        }
        this.f68909h = 0;
        O(this.E);
    }

    public void K(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f68910i = "";
            this.f68911m = null;
        } else {
            this.f68910i = str;
            this.f68911m = this.T.get(str);
            this.C = this.U.get(str);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i3 = this.R;
        if (i3 == 0) {
            return;
        }
        if (i3 == 2 || i3 == 4 || i3 == 3) {
            u(canvas);
            if (this.R != 4) {
                t(canvas);
                return;
            }
            return;
        }
        if (i3 == 5 || i3 == 1 || i3 == 6) {
            v(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.Q;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (QLog.isColorLevel()) {
            QLog.d("MarkDrawable", 2, "onBoundsChange: mState:" + this.R + " bound:" + rect);
        }
        AnimationDrawable animationDrawable = this.f68908f;
        if (animationDrawable != null) {
            animationDrawable.setBounds(rect);
            for (int i3 = 0; i3 < this.f68908f.getNumberOfFrames(); i3++) {
                Drawable frame = this.f68908f.getFrame(i3);
                if (frame != null) {
                    frame.setBounds(rect);
                }
            }
        }
        AnimationDrawable animationDrawable2 = this.f68906d;
        if (animationDrawable2 != null) {
            animationDrawable2.setBounds(rect);
            for (int i16 = 0; i16 < this.f68906d.getNumberOfFrames(); i16++) {
                Drawable frame2 = this.f68906d.getFrame(i16);
                if (frame2 != null) {
                    frame2.setBounds(rect);
                }
            }
        }
        AnimationDrawable animationDrawable3 = this.f68907e;
        if (animationDrawable3 != null) {
            animationDrawable3.setBounds(rect);
            for (int i17 = 0; i17 < this.f68907e.getNumberOfFrames(); i17++) {
                Drawable frame3 = this.f68907e.getFrame(i17);
                if (frame3 != null) {
                    frame3.setBounds(rect);
                }
            }
        }
        I(rect.centerX(), rect.centerY(), this.E, this.F);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (QLog.isColorLevel()) {
            QLog.d("MarkDrawable", 2, "start:" + this.R + " isRunning:" + this.Q);
        }
        if (isRunning()) {
            stop();
        }
        this.Q = true;
        int i3 = this.R;
        if (i3 == 2 || i3 == 1) {
            this.R = 2;
            P(2, 600);
        } else if (i3 == 4 || i3 == 3) {
            this.R = 4;
            P(4, 400);
        } else if (i3 == 5 || i3 == 6) {
            P(i3, 200);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (QLog.isColorLevel()) {
            QLog.d("MarkDrawable", 2, "stop:" + this.R + " isRunning:" + this.Q);
        }
        if (this.Q) {
            this.Q = false;
            ValueAnimator valueAnimator = this.S;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.S.removeAllUpdateListeners();
                this.S = null;
            }
        }
    }

    public int z() {
        return this.R;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends Property<d, Integer> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(d dVar) {
            if (dVar != null) {
                return Integer.valueOf(dVar.A());
            }
            return 0;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Integer num) {
            if (dVar != null) {
                dVar.J(num.intValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends Property<d, Integer> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(d dVar) {
            if (dVar != null) {
                return Integer.valueOf(dVar.B());
            }
            return 255;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Integer num) {
            if (dVar != null) {
                dVar.L(num.intValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c extends Property<d, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            if (dVar != null) {
                return Float.valueOf(dVar.C());
            }
            return Float.valueOf(0.0f);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f16) {
            if (dVar != null) {
                dVar.N(f16.floatValue());
            }
        }
    }

    public void R() {
        this.f68906d = null;
        this.f68907e = null;
        this.f68908f = null;
        this.f68911m = null;
        this.C = null;
        this.Q = false;
        ValueAnimator valueAnimator = this.S;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.S.removeAllUpdateListeners();
            this.S = null;
        }
        this.T.clear();
        this.U.clear();
        this.V.clear();
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
    }

    private void G(Context context) {
        if (context == null) {
            return;
        }
        this.T.put("1/2", context.getResources().getDrawable(R.drawable.f161186d45));
        this.T.put("1/4", context.getResources().getDrawable(R.drawable.d46));
        this.T.put("1x", context.getResources().getDrawable(R.drawable.d47));
        this.T.put("2x", context.getResources().getDrawable(R.drawable.d48));
        this.T.put("4x", context.getResources().getDrawable(R.drawable.d49));
        Map<String, Drawable> map = this.T;
        String str = PickerContainer.N;
        map.put(str, context.getResources().getDrawable(R.drawable.d4v));
        this.U.put("1/2", context.getResources().getDrawable(R.drawable.d5b));
        this.U.put("1/4", context.getResources().getDrawable(R.drawable.d5c));
        this.U.put("1x", context.getResources().getDrawable(R.drawable.d5d));
        this.U.put("2x", context.getResources().getDrawable(R.drawable.d5e));
        this.U.put("4x", context.getResources().getDrawable(R.drawable.d5f));
        this.U.put(str, context.getResources().getDrawable(R.drawable.d5g));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e extends com.tencent.mobileqq.widget.f {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("MarkDrawable", 2, "onAnimationCancel: mState:" + d.this.R + " isrun:" + d.this.Q);
            }
            if (d.this.isRunning()) {
                d dVar = d.this;
                dVar.w(dVar.R);
                if (d.this.R != 2) {
                    if (d.this.R != 4) {
                        if (d.this.R == 5) {
                            d.this.H(1);
                        }
                    } else {
                        d.this.H(5);
                    }
                } else {
                    d.this.H(3);
                }
                d.this.Q = false;
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("MarkDrawable", 2, "onAnimationEnd: mState:" + d.this.R + " isrun:" + d.this.Q);
            }
            if (d.this.isRunning()) {
                d dVar = d.this;
                dVar.x(dVar.R);
                if (d.this.R != 2) {
                    if (d.this.R != 4) {
                        if (d.this.R != 5) {
                            if (d.this.R == 6) {
                                d.this.H(2);
                            }
                        } else {
                            d.this.H(1);
                            d.this.f68909h = 0;
                        }
                    } else {
                        d.this.H(0);
                    }
                } else {
                    d.this.H(3);
                }
                d.this.Q = false;
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("MarkDrawable", 2, "onAnimationStart: mState:" + d.this.R + " isrun:" + d.this.Q);
            }
            if (d.this.isRunning()) {
                d dVar = d.this;
                dVar.y(dVar.R);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
