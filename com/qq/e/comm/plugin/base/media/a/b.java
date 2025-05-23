package com.qq.e.comm.plugin.base.media.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private int f39173a;

    /* renamed from: b, reason: collision with root package name */
    private int f39174b;

    /* renamed from: c, reason: collision with root package name */
    private int f39175c;

    /* renamed from: d, reason: collision with root package name */
    private int f39176d;

    /* renamed from: e, reason: collision with root package name */
    private int f39177e;

    /* renamed from: f, reason: collision with root package name */
    private Movie f39178f;

    /* renamed from: g, reason: collision with root package name */
    private int f39179g;

    /* renamed from: h, reason: collision with root package name */
    private long f39180h;

    /* renamed from: i, reason: collision with root package name */
    private float f39181i;

    /* renamed from: j, reason: collision with root package name */
    private float f39182j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f39183k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f39184l;

    public b(Context context) {
        super(context);
        this.f39180h = -1L;
        this.f39181i = -1.0f;
        this.f39182j = 0.0f;
        this.f39183k = false;
        this.f39184l = true;
    }

    public void a(Movie movie) {
        if (movie == null) {
            GDTLogger.e("movie is null");
            return;
        }
        if (GDTADManager.getInstance().getSM().getInteger("git_hardware", 0) == 1) {
            setLayerType(1, null);
        }
        this.f39178f = movie;
        int duration = movie.duration();
        this.f39179g = duration;
        if (duration == 0) {
            this.f39179g = 2500;
            GDTLogger.e("gif duration = 0, reset to 2500");
        }
        this.f39174b = movie.width();
        this.f39173a = movie.height();
        invalidate();
    }

    public void b(boolean z16) {
        this.f39184l = z16;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            this.f39176d = getHeight();
            int width = getWidth();
            this.f39177e = width;
            if (width != 0 && this.f39174b != 0) {
                if (this.f39178f != null) {
                    super.setImageBitmap(null);
                    a(canvas);
                    super.onDraw(canvas);
                    return;
                }
                if (this.f39184l) {
                    int i3 = this.f39176d;
                    int i16 = this.f39177e;
                    double d16 = i3 / i16;
                    int i17 = this.f39173a;
                    int i18 = this.f39174b;
                    if (d16 < i17 / i18) {
                        this.f39175c = (i17 * i16) / i18;
                        getDrawable().setBounds(0, 0, this.f39177e, this.f39175c);
                    } else {
                        this.f39175c = (((i18 * i3) / i17) - i16) / 2;
                        Drawable drawable = getDrawable();
                        int i19 = this.f39175c;
                        drawable.setBounds(-i19, 0, this.f39177e + i19, this.f39176d);
                    }
                }
                super.onDraw(canvas);
                return;
            }
            super.onDraw(canvas);
        } catch (Exception e16) {
            GDTLogger.w("SplashImageView ondraw error:" + e16.getMessage());
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.f39173a = bitmap.getHeight();
            this.f39174b = bitmap.getWidth();
        } else {
            this.f39173a = 0;
            this.f39174b = 0;
        }
        super.setImageBitmap(bitmap);
    }

    private void a(Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f39180h < 0) {
            this.f39180h = currentTimeMillis;
        }
        this.f39178f.setTime(((int) (currentTimeMillis - this.f39180h)) % this.f39179g);
        if (this.f39181i < 0.0f) {
            double doubleValue = Double.valueOf(this.f39176d).doubleValue() / this.f39177e;
            double doubleValue2 = Double.valueOf(this.f39173a).doubleValue();
            int i3 = this.f39174b;
            if (doubleValue < doubleValue2 / i3) {
                this.f39181i = this.f39177e / i3;
            } else {
                float f16 = this.f39176d / this.f39173a;
                this.f39181i = f16;
                this.f39182j = (-(((i3 * f16) - this.f39177e) / 2.0f)) / f16;
            }
        }
        float f17 = this.f39181i;
        canvas.scale(f17, f17);
        this.f39178f.draw(canvas, this.f39182j, 0.0f);
        invalidate();
    }

    public boolean a() {
        return this.f39183k;
    }

    public void a(boolean z16) {
        this.f39183k = z16;
    }
}
