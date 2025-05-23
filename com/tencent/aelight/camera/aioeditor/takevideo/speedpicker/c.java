package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends Drawable implements Animatable {
    private String C;
    private Drawable D;
    private float E;
    private float F;
    private float G;
    private Context I;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f68900i;

    /* renamed from: m, reason: collision with root package name */
    private float f68901m;

    /* renamed from: d, reason: collision with root package name */
    private Rect f68896d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private int f68897e = 255;

    /* renamed from: f, reason: collision with root package name */
    private boolean f68898f = false;

    /* renamed from: h, reason: collision with root package name */
    private int f68899h = 0;
    private boolean H = false;
    Property<c, Float> J = new a(Float.class, "backScale");
    Property<c, Integer> K = new b(Integer.class, "backAlpha");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.c$c, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0619c implements ValueAnimator.AnimatorUpdateListener {
        C0619c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i3, int i16) {
        ValueAnimator valueAnimator = this.f68900i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f68900i.removeAllUpdateListeners();
            this.f68900i = null;
        }
        if (i3 == 1) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat(this.J, this.G, 1.0f), PropertyValuesHolder.ofInt(this.K, 0, 255));
            this.f68900i = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(i16);
        } else if (i3 == 2) {
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofInt(this.K, 255, 0));
            this.f68900i = ofPropertyValuesHolder2;
            ofPropertyValuesHolder2.setDuration(i16);
        }
        ValueAnimator valueAnimator2 = this.f68900i;
        if (valueAnimator2 != null) {
            valueAnimator2.setRepeatMode(1);
            this.f68900i.setRepeatCount(0);
            this.f68900i.setStartDelay(0L);
            this.f68900i.addUpdateListener(new C0619c());
            this.f68900i.addListener(new d());
            this.f68900i.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p() {
        return this.f68897e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float q() {
        return this.f68901m;
    }

    private Drawable t(String str) {
        if (!TextUtils.isEmpty(str) && this.I != null) {
            try {
                if ("1/4".equals(str)) {
                    return this.I.getResources().getDrawable(R.drawable.f161181d40);
                }
                if ("1/2".equals(str)) {
                    return this.I.getResources().getDrawable(R.drawable.d3z);
                }
                if ("1x".equals(str)) {
                    return this.I.getResources().getDrawable(R.drawable.f161182d41);
                }
                if ("2x".equals(str)) {
                    return this.I.getResources().getDrawable(R.drawable.f161183d42);
                }
                if ("4x".equals(str)) {
                    return this.I.getResources().getDrawable(R.drawable.f161184d43);
                }
                if (PickerContainer.N.equals(str)) {
                    return this.I.getResources().getDrawable(R.drawable.f161185d44);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("HintDrawable", 2, "getDrawableByText exception:" + e16.toString());
            } catch (OutOfMemoryError unused) {
                QLog.e("HintDrawable", 2, "getDrawableByText OOM!!");
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i3) {
        this.f68897e = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(float f16) {
        this.f68901m = f16;
        int centerX = this.f68896d.centerX();
        int centerY = this.f68896d.centerY();
        float f17 = this.E;
        float f18 = f16 - 1.0f;
        int i3 = ((int) (f17 * f18)) / 2;
        float f19 = this.F;
        int i16 = ((int) (f18 * f19)) / 2;
        this.f68896d.set((int) ((centerX - i3) - (f17 / 2.0f)), (int) ((centerY - i16) - (f19 / 2.0f)), (int) (centerX + i3 + (f17 / 2.0f)), (int) (centerY + i16 + (f19 / 2.0f)));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        if (this.f68899h == 0 || (drawable = this.D) == null) {
            return;
        }
        drawable.setAlpha(this.f68897e);
        this.D.setBounds(this.f68896d);
        this.D.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f68898f;
    }

    public int o() {
        return this.f68899h;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f68896d.set(rect);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            stop();
        }
        this.f68898f = true;
        if (QLog.isColorLevel()) {
            QLog.d("HintDrawable", 2, "start :" + this.f68899h);
        }
        A(this.f68899h, 150);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f68898f) {
            this.f68898f = false;
            ValueAnimator valueAnimator = this.f68900i;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f68900i.removeAllUpdateListeners();
                this.f68900i = null;
            }
        }
    }

    public void v(int i3) {
        this.f68899h = i3;
    }

    public void w(boolean z16) {
        this.H = z16;
    }

    public boolean z(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.C)) {
            return false;
        }
        this.C = str;
        this.D = t(str);
        invalidateSelf();
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends Property<c, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(c cVar) {
            if (cVar != null) {
                return Float.valueOf(cVar.q());
            }
            return Float.valueOf(0.0f);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Float f16) {
            if (cVar != null) {
                cVar.y(f16.floatValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends Property<c, Integer> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(c cVar) {
            if (cVar != null) {
                return Integer.valueOf(cVar.p());
            }
            return 0;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Integer num) {
            if (cVar != null) {
                cVar.x(num.intValue());
            }
        }
    }

    public void B() {
        this.f68898f = false;
        this.I = null;
        this.D = null;
        ValueAnimator valueAnimator = this.f68900i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f68900i.removeAllUpdateListeners();
            this.f68900i = null;
        }
        this.J = null;
        this.K = null;
    }

    public boolean u(Context context, float f16, float f17, float f18) {
        if (context == null) {
            return false;
        }
        this.E = f16;
        this.F = f17;
        this.G = f18;
        this.I = context;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d extends com.tencent.mobileqq.widget.f {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (c.this.f68898f) {
                if (!c.this.H) {
                    c.this.f68898f = false;
                    if (c.this.f68899h == 1) {
                        c.this.f68899h = 3;
                        return;
                    } else {
                        c.this.f68899h = 0;
                        c.this.C = "";
                        return;
                    }
                }
                if (c.this.f68899h == 1) {
                    c.this.f68899h = 2;
                    c cVar = c.this;
                    cVar.A(cVar.f68899h, 1000);
                } else {
                    c.this.C = "";
                    c.this.f68899h = 0;
                    c.this.f68898f = false;
                }
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (c.this.f68898f) {
                if (!c.this.H) {
                    c.this.f68898f = false;
                    if (c.this.f68899h == 1) {
                        c.this.f68899h = 3;
                        return;
                    } else {
                        c.this.f68899h = 0;
                        c.this.C = "";
                        return;
                    }
                }
                if (c.this.f68899h == 1) {
                    c.this.f68899h = 2;
                    c cVar = c.this;
                    cVar.A(cVar.f68899h, 1000);
                } else {
                    c.this.C = "";
                    c.this.f68899h = 0;
                    c.this.f68898f = false;
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
