package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Keep;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class CircleProgressDrawable extends Drawable {

    /* renamed from: j, reason: collision with root package name */
    public static final RectF f152330j = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);

    /* renamed from: k, reason: collision with root package name */
    public static final RectF f152331k = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);

    /* renamed from: a, reason: collision with root package name */
    public Paint f152332a;

    /* renamed from: c, reason: collision with root package name */
    public int f152334c;

    /* renamed from: h, reason: collision with root package name */
    public RingPathTransform f152339h;

    /* renamed from: i, reason: collision with root package name */
    public RingRotation f152340i;

    /* renamed from: d, reason: collision with root package name */
    public int f152335d = 4;

    /* renamed from: e, reason: collision with root package name */
    public int f152336e = -16777216;

    /* renamed from: f, reason: collision with root package name */
    public boolean f152337f = false;

    /* renamed from: g, reason: collision with root package name */
    public int f152338g = 0;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f152333b = new ArrayList();

    /* loaded from: classes9.dex */
    public static class RingPathTransform {

        /* renamed from: a, reason: collision with root package name */
        public float f152341a;

        /* renamed from: b, reason: collision with root package name */
        public float f152342b;

        /* renamed from: c, reason: collision with root package name */
        public float f152343c;

        public RingPathTransform() {
            this.f152341a = 0.0f;
            this.f152342b = 0.0f;
            this.f152343c = 0.0f;
        }

        @Keep
        public void setTrimPathEnd(float f16) {
            this.f152342b = f16;
        }

        @Keep
        public void setTrimPathOffset(float f16) {
            this.f152343c = f16;
        }

        @Keep
        public void setTrimPathStart(float f16) {
            this.f152341a = f16;
        }
    }

    /* loaded from: classes9.dex */
    public static class RingRotation {

        /* renamed from: a, reason: collision with root package name */
        public float f152344a;

        public RingRotation() {
        }

        @Keep
        public void setRotation(float f16) {
            this.f152344a = f16;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final Interpolator f152345a = new LinearInterpolator();
    }

    /* loaded from: classes9.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final Path f152346a;

        /* renamed from: b, reason: collision with root package name */
        public static final Interpolator f152347b;

        static {
            Path path = new Path();
            f152346a = path;
            path.cubicTo(0.2f, 0.0f, 0.1f, 1.0f, 0.5f, 1.0f);
            path.lineTo(1.0f, 1.0f);
            f152347b = PathInterpolatorCompat.create(path);
        }
    }

    /* loaded from: classes9.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static final Path f152348a;

        /* renamed from: b, reason: collision with root package name */
        public static final Interpolator f152349b;

        static {
            Path path = new Path();
            f152348a = path;
            path.lineTo(0.5f, 0.0f);
            path.cubicTo(0.7f, 0.0f, 0.6f, 1.0f, 1.0f, 1.0f);
            f152349b = PathInterpolatorCompat.create(path);
        }
    }

    public CircleProgressDrawable(Context context) {
        this.f152339h = new RingPathTransform();
        this.f152340i = new RingRotation();
        this.f152334c = Math.round(context.getResources().getDisplayMetrics().density * 48.0f);
    }

    public void a(int i3) {
        this.f152336e = i3;
        invalidateSelf();
    }

    public final boolean b() {
        Iterator it = this.f152333b.iterator();
        while (it.hasNext()) {
            if (((Animator) it.next()).isStarted()) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        Paint paint = new Paint();
        this.f152332a = paint;
        paint.setAntiAlias(true);
        this.f152332a.setStyle(Paint.Style.STROKE);
        this.f152332a.setStrokeWidth(this.f152335d);
        this.f152332a.setStrokeCap(Paint.Cap.SQUARE);
        this.f152332a.setStrokeJoin(Paint.Join.MITER);
    }

    public void d() {
        stop();
        this.f152333b.clear();
        this.f152333b.add(a(this.f152339h));
        this.f152333b.add(a(this.f152340i));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() != 0 && bounds.height() != 0) {
            if (this.f152332a == null) {
                c();
            }
            int save = canvas.save();
            canvas.translate(bounds.left, bounds.top);
            a(canvas, bounds.width(), bounds.height(), this.f152332a);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void start() {
        if (b()) {
            return;
        }
        Iterator it = this.f152333b.iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).start();
        }
        invalidateSelf();
    }

    public void stop() {
        Iterator it = this.f152333b.iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).end();
        }
    }

    public final int a() {
        return this.f152334c;
    }

    public final void b(Canvas canvas, Paint paint) {
        int save = canvas.save();
        paint.setColor(this.f152338g);
        canvas.drawArc(f152331k, 0.0f, 360.0f, false, paint);
        canvas.restoreToCount(save);
    }

    public final void a(Canvas canvas, int i3, int i16, Paint paint) {
        RectF rectF = f152330j;
        canvas.scale(i3 / rectF.width(), i16 / rectF.height());
        canvas.translate(rectF.width() / 2.0f, rectF.height() / 2.0f);
        if (this.f152337f) {
            b(canvas, paint);
        }
        a(canvas, paint);
    }

    public final void a(Canvas canvas, Paint paint) {
        int save = canvas.save();
        paint.setColor(this.f152336e);
        canvas.rotate(this.f152340i.f152344a);
        RingPathTransform ringPathTransform = this.f152339h;
        float f16 = ringPathTransform.f152343c;
        canvas.drawArc(f152331k, ((f16 + r3) * 360.0f) - 90.0f, (ringPathTransform.f152342b - ringPathTransform.f152341a) * 360.0f, false, paint);
        canvas.restoreToCount(save);
    }

    public static Animator a(RingPathTransform ringPathTransform) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ringPathTransform, "trimPathStart", 0.0f, 0.75f);
        ofFloat.setDuration(1333L);
        ofFloat.setInterpolator(d.f152349b);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(ringPathTransform, "trimPathEnd", 0.0f, 0.75f);
        ofFloat2.setDuration(1333L);
        ofFloat2.setInterpolator(c.f152347b);
        ofFloat2.setRepeatCount(-1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(ringPathTransform, "trimPathOffset", 0.0f, 0.25f);
        ofFloat3.setDuration(1333L);
        ofFloat3.setInterpolator(b.f152345a);
        ofFloat3.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public static Animator a(RingRotation ringRotation) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ringRotation, BasicAnimation.KeyPath.ROTATION, 0.0f, 720.0f);
        ofFloat.setDuration(6665L);
        ofFloat.setInterpolator(b.f152345a);
        ofFloat.setRepeatCount(-1);
        return ofFloat;
    }
}
