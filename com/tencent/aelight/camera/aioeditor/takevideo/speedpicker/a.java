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
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends Drawable implements Animatable {

    /* renamed from: f, reason: collision with root package name */
    private Paint f68869f;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f68872m;

    /* renamed from: d, reason: collision with root package name */
    private int f68867d = 127;

    /* renamed from: e, reason: collision with root package name */
    private boolean f68868e = false;

    /* renamed from: h, reason: collision with root package name */
    private RectF f68870h = new RectF();

    /* renamed from: i, reason: collision with root package name */
    private int f68871i = 0;
    private boolean C = false;
    Property<a, Integer> D = new C0617a(Integer.class, "backAlpha");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k() {
        return this.f68867d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3) {
        this.f68867d = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i3, int i16) {
        ValueAnimator valueAnimator = this.f68872m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f68872m.removeAllUpdateListeners();
            this.f68872m = null;
        }
        if (i3 == 1) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofInt(this.D, 0, 127));
            this.f68872m = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(i16);
        } else if (i3 == 2) {
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofInt(this.D, 127, 0));
            this.f68872m = ofPropertyValuesHolder2;
            ofPropertyValuesHolder2.setDuration(i16);
        }
        ValueAnimator valueAnimator2 = this.f68872m;
        if (valueAnimator2 != null) {
            valueAnimator2.setRepeatMode(1);
            this.f68872m.setRepeatCount(0);
            this.f68872m.setStartDelay(0L);
            this.f68872m.addUpdateListener(new b());
            this.f68872m.addListener(new c());
            this.f68872m.start();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f68871i == 0) {
            return;
        }
        this.f68869f.setAlpha(this.f68867d);
        canvas.drawRect(this.f68870h, this.f68869f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f68868e;
    }

    public void n(int i3) {
        this.f68871i = i3;
    }

    public void o(boolean z16) {
        this.C = z16;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f68870h.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.f68869f;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            stop();
        }
        this.f68868e = true;
        if (QLog.isColorLevel()) {
            QLog.d("HintDrawable", 2, "start :" + this.f68871i);
        }
        int i3 = this.f68871i;
        if (i3 == 1) {
            q(i3, this.C ? 150 : 300);
        } else if (i3 == 2) {
            q(i3, 200);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f68868e) {
            this.f68868e = false;
            ValueAnimator valueAnimator = this.f68872m;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f68872m.removeAllUpdateListeners();
                this.f68872m = null;
            }
            this.f68871i = 0;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C0617a extends Property<a, Integer> {
        C0617a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(a aVar) {
            if (aVar != null) {
                return Integer.valueOf(aVar.k());
            }
            return 0;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(a aVar, Integer num) {
            if (aVar != null) {
                aVar.p(num.intValue());
            }
        }
    }

    public void t() {
        this.f68868e = false;
        this.f68869f = null;
        ValueAnimator valueAnimator = this.f68872m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f68872m.removeAllUpdateListeners();
            this.f68872m = null;
        }
        this.D = null;
    }

    public boolean m(Context context) {
        if (context == null) {
            return false;
        }
        if (this.f68869f == null) {
            Paint paint = new Paint();
            this.f68869f = paint;
            paint.setAntiAlias(true);
        }
        this.f68869f.setColor(0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends com.tencent.mobileqq.widget.f {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (a.this.f68868e) {
                if (!a.this.C) {
                    a.this.f68868e = false;
                    if (a.this.f68871i == 2) {
                        a.this.f68871i = 0;
                        return;
                    }
                    return;
                }
                a.this.f68868e = false;
                a.this.f68871i = 0;
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (a.this.f68868e) {
                if (!a.this.C) {
                    a.this.f68868e = false;
                    if (a.this.f68871i == 1) {
                        a.this.f68871i = 3;
                        return;
                    } else {
                        a.this.f68871i = 0;
                        return;
                    }
                }
                if (a.this.f68871i == 1) {
                    a.this.f68871i = 2;
                    a aVar = a.this;
                    aVar.q(aVar.f68871i, 1000);
                } else {
                    a.this.f68868e = false;
                    a.this.f68871i = 0;
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
}
