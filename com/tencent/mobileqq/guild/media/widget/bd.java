package com.tencent.mobileqq.guild.media.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;

/* compiled from: P */
/* loaded from: classes14.dex */
public class bd extends Drawable {
    private LinearGradient A;
    private LinearGradient B;

    /* renamed from: a, reason: collision with root package name */
    private final int f229877a;

    /* renamed from: b, reason: collision with root package name */
    private final int f229878b;

    /* renamed from: d, reason: collision with root package name */
    private final Bitmap f229880d;

    /* renamed from: h, reason: collision with root package name */
    private Paint f229884h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f229885i;

    /* renamed from: l, reason: collision with root package name */
    private float f229888l;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f229889m;

    /* renamed from: n, reason: collision with root package name */
    private ValueAnimator f229890n;

    /* renamed from: o, reason: collision with root package name */
    private Bitmap f229891o;

    /* renamed from: p, reason: collision with root package name */
    private Canvas f229892p;

    /* renamed from: q, reason: collision with root package name */
    private Path f229893q;

    /* renamed from: r, reason: collision with root package name */
    private Path f229894r;

    /* renamed from: s, reason: collision with root package name */
    private Path f229895s;

    /* renamed from: t, reason: collision with root package name */
    private Path f229896t;

    /* renamed from: u, reason: collision with root package name */
    private float f229897u;

    /* renamed from: v, reason: collision with root package name */
    private float f229898v;

    /* renamed from: w, reason: collision with root package name */
    private float f229899w;

    /* renamed from: x, reason: collision with root package name */
    private float f229900x;

    /* renamed from: y, reason: collision with root package name */
    private float f229901y;

    /* renamed from: z, reason: collision with root package name */
    private LinearGradient f229902z;

    /* renamed from: c, reason: collision with root package name */
    private final Rect f229879c = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private final int[] f229881e = {-16733697, -16738561};

    /* renamed from: f, reason: collision with root package name */
    private final int[] f229882f = {-16738561, -16720129};

    /* renamed from: g, reason: collision with root package name */
    private final int[] f229883g = {1291902719, 1291884287};

    /* renamed from: j, reason: collision with root package name */
    private volatile int f229886j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f229887k = 0;
    private float C = -1.0f;

    public bd(Context context, int i3, int i16) {
        this.f229877a = i3;
        this.f229878b = i16;
        this.f229880d = c(context, R.drawable.guild_media_mic_on);
        this.f229885i = new RectF(0.0f, 0.0f, i3, i16);
        f();
    }

    private Bitmap c(Context context, int i3) {
        Drawable w3 = GuildUIUtils.w(context, i3, Integer.valueOf(R.color.qui_common_icon_white));
        if (w3 != null) {
            if (w3 instanceof BitmapDrawable) {
                return ((BitmapDrawable) w3).getBitmap();
            }
            Bitmap createBitmap = Bitmap.createBitmap(w3.getIntrinsicWidth(), w3.getIntrinsicHeight(), Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            w3.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            w3.draw(canvas);
            return createBitmap;
        }
        throw new IllegalArgumentException("[MicSpeakDrawable] [getBitmapFromDrawable] unsupported drawable type");
    }

    private float d() {
        return ((this.f229900x * this.f229886j) * 1.0f) / 100.0f;
    }

    private LinearGradient e(float f16, @NonNull @ColorInt int[] iArr) {
        float f17 = this.f229897u;
        float f18 = this.f229899w;
        return new LinearGradient((f18 / 2.0f) + f17, f16, f17 + (f18 / 2.0f), f16 + this.f229900x, iArr, (float[]) null, Shader.TileMode.CLAMP);
    }

    private void f() {
        this.f229891o = Bitmap.createBitmap(this.f229877a, this.f229878b, Bitmap.Config.ARGB_4444);
        this.f229892p = new Canvas(this.f229891o);
        Paint paint = new Paint(6);
        this.f229884h = paint;
        paint.setAntiAlias(true);
        this.f229894r = new Path();
        this.f229895s = new Path();
        this.f229896t = new Path();
        g();
    }

    private void g() {
        float f16 = this.f229877a / 56.0f;
        this.f229897u = 20.0f * f16;
        this.f229898v = 12.0f * f16;
        float f17 = 16.0f * f16;
        this.f229899w = f17;
        float f18 = f16 * 25.0f;
        this.f229900x = f18;
        float f19 = f17 / 2.0f;
        this.f229888l = f18 / 6.0f;
        Path path = new Path();
        this.f229893q = path;
        path.moveTo(this.f229897u + f19, this.f229898v + f19);
        Path path2 = this.f229893q;
        float f26 = this.f229897u;
        float f27 = this.f229898v;
        float f28 = 2.0f * f19;
        path2.addArc(f26, f27, f26 + this.f229899w, f27 + f28, -180.0f, 180.0f);
        Path path3 = this.f229893q;
        float f29 = this.f229897u;
        float f36 = this.f229898v;
        path3.addRect(f29, f36 + f19, f29 + this.f229899w, (f36 + this.f229900x) - f19, Path.Direction.CW);
        this.f229893q.moveTo(this.f229897u + f19, (this.f229898v + this.f229900x) - f19);
        Path path4 = this.f229893q;
        float f37 = this.f229897u;
        float f38 = this.f229898v;
        float f39 = this.f229900x;
        path4.addArc(f37, (f38 + f39) - f28, f37 + this.f229899w, f38 + f39, 0.0f, 180.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(ValueAnimator valueAnimator) {
        this.f229886j = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(ValueAnimator valueAnimator) {
        this.f229901y = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (this.f229886j >= 11) {
            invalidateSelf();
        }
    }

    private boolean j() {
        if (this.f229886j >= 10) {
            return true;
        }
        return false;
    }

    private void l() {
        if (this.f229890n == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.f229899w * 4.0f);
            this.f229890n = ofFloat;
            ofFloat.setDuration(8000L);
            this.f229890n.setRepeatMode(1);
            this.f229890n.setInterpolator(new LinearInterpolator());
            this.f229890n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.media.widget.bc
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    bd.this.i(valueAnimator);
                }
            });
        }
        if (!this.f229890n.isRunning()) {
            this.f229890n.start();
        }
    }

    private void m(float f16, Path path, float f17) {
        path.reset();
        if (!j()) {
            return;
        }
        float f18 = this.f229899w;
        float f19 = (this.f229898v + this.f229900x) - f16;
        float f26 = this.f229897u - (((f17 % f18) * 4.0f) / 3.0f);
        path.moveTo(f26, f19);
        float f27 = ((f18 / 2.0f) * 2.0f) / 3.0f;
        float f28 = 0.0f;
        while (true) {
            int i3 = this.f229877a;
            if (f28 <= i3) {
                float f29 = f27 * 2.0f;
                path.rQuadTo(f27, -this.f229888l, f29, 0.0f);
                path.rQuadTo(f27, this.f229888l, f29, 0.0f);
                f28 += f29;
            } else {
                path.lineTo(i3, this.f229900x + f19);
                path.lineTo(f26, f19 + this.f229900x);
                path.close();
                return;
            }
        }
    }

    private void n() {
        boolean z16;
        this.f229891o.eraseColor(0);
        float d16 = d();
        float f16 = (this.f229898v + this.f229900x) - d16;
        if (this.C == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.C = f16;
        m(d16, this.f229894r, this.f229901y);
        if (z16 || this.f229902z == null) {
            this.f229902z = e(f16, this.f229881e);
        }
        this.f229884h.setShader(this.f229902z);
        this.f229892p.drawPath(this.f229894r, this.f229884h);
        m(d16, this.f229895s, this.f229901y * 2.0f);
        this.f229884h.setColor(Color.argb(255, 0, 0, 255));
        if (z16 || this.A == null) {
            this.A = e(f16, this.f229882f);
        }
        this.f229884h.setShader(this.A);
        this.f229892p.drawPath(this.f229895s, this.f229884h);
        m(d16, this.f229896t, this.f229901y * 3.0f);
        this.f229884h.setColor(Color.argb(255, 0, 255, 0));
        if (z16 || this.B == null) {
            this.B = e(f16, this.f229883g);
        }
        this.f229884h.setShader(this.B);
        this.f229892p.drawPath(this.f229896t, this.f229884h);
        this.f229884h.setShader(null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f229879c.set(0, 0, this.f229880d.getWidth(), this.f229880d.getHeight());
        canvas.drawBitmap(this.f229880d, this.f229879c, this.f229885i, this.f229884h);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, this.f229877a, this.f229878b, this.f229884h);
        this.f229884h.setColor(-16777216);
        this.f229884h.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.f229893q, this.f229884h);
        n();
        this.f229884h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(this.f229891o, 0.0f, 0.0f, this.f229884h);
        this.f229884h.setXfermode(null);
        canvas.restoreToCount(saveLayer);
        l();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f229878b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f229877a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public void k(int i3) {
        int i16;
        boolean z16;
        long j3;
        int i17 = this.f229887k;
        this.f229887k = i3;
        if (i3 < 11 && i17 < 11) {
            return;
        }
        if (i3 != i17) {
            ValueAnimator valueAnimator = this.f229889m;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                i17 = ((Integer) this.f229889m.getAnimatedValue()).intValue();
                this.f229889m.cancel();
                i16 = i17;
            } else {
                i16 = -1;
            }
            if (this.f229889m == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.f229889m = valueAnimator2;
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.media.widget.bb
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        bd.this.h(valueAnimator3);
                    }
                });
            }
            if (this.f229887k > i17) {
                z16 = true;
            } else {
                z16 = false;
            }
            ValueAnimator valueAnimator3 = this.f229889m;
            if (z16) {
                j3 = 100;
            } else {
                j3 = 200;
            }
            valueAnimator3.setDuration(j3);
            ValueAnimator valueAnimator4 = this.f229889m;
            int[] iArr = new int[2];
            if (i16 != -1) {
                i17 = i16;
            }
            iArr[0] = i17;
            iArr[1] = this.f229887k;
            valueAnimator4.setIntValues(iArr);
            this.f229889m.start();
            return;
        }
        this.f229886j = i3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f229885i = new RectF(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.f229884h.getAlpha() == i3) {
            return;
        }
        this.f229884h.setAlpha(i3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f229884h.setColorFilter(colorFilter);
    }
}
