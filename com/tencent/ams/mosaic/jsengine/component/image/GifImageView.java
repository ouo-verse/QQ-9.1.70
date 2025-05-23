package com.tencent.ams.mosaic.jsengine.component.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class GifImageView extends ImageView {
    static IPatchRedirector $redirector_;
    private float C;
    private int D;
    private int E;
    private volatile boolean F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private int f71147d;

    /* renamed from: e, reason: collision with root package name */
    private Movie f71148e;

    /* renamed from: f, reason: collision with root package name */
    private long f71149f;

    /* renamed from: h, reason: collision with root package name */
    private int f71150h;

    /* renamed from: i, reason: collision with root package name */
    private float f71151i;

    /* renamed from: m, reason: collision with root package name */
    private float f71152m;

    public GifImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f71150h = 0;
        this.F = false;
        this.G = true;
    }

    private void a(Canvas canvas) {
        this.f71148e.setTime(this.f71150h);
        canvas.save();
        float f16 = this.C;
        canvas.scale(f16, f16);
        Movie movie = this.f71148e;
        float f17 = this.f71151i;
        float f18 = this.C;
        movie.draw(canvas, f17 / f18, this.f71152m / f18);
        canvas.restore();
    }

    @SuppressLint({"NewApi"})
    private void b() {
        if (this.G) {
            postInvalidateOnAnimation();
        }
    }

    private void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f71149f == 0) {
            this.f71149f = uptimeMillis;
        }
        int duration = this.f71148e.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.f71150h = (int) ((uptimeMillis - this.f71149f) % duration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
            return;
        }
        if (this.f71148e != null) {
            if (!this.F) {
                c();
                a(canvas);
                b();
                return;
            }
            a(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f71148e != null) {
            this.f71151i = (getWidth() - this.D) / 2.0f;
            this.f71152m = (getHeight() - this.E) / 2.0f;
            if (getVisibility() != 0) {
                z17 = false;
            }
            this.G = z17;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        float f16;
        float f17;
        int size;
        int size2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Movie movie = this.f71148e;
        if (movie != null) {
            int width = movie.width();
            int height = this.f71148e.height();
            if (View.MeasureSpec.getMode(i3) != 0 && width > (size2 = View.MeasureSpec.getSize(i3))) {
                f16 = width / size2;
            } else {
                f16 = 1.0f;
            }
            if (View.MeasureSpec.getMode(i16) != 0 && height > (size = View.MeasureSpec.getSize(i16))) {
                f17 = height / size;
            } else {
                f17 = 1.0f;
            }
            float max = 1.0f / Math.max(f16, f17);
            this.C = max;
            int i17 = (int) (width * max);
            this.D = i17;
            int i18 = (int) (height * max);
            this.E = i18;
            setMeasuredDimension(i17, i18);
            return;
        }
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        super.onScreenStateChanged(i3);
        if (this.f71148e != null) {
            boolean z16 = true;
            if (i3 != 1) {
                z16 = false;
            }
            this.G = z16;
            b();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, i3);
            return;
        }
        super.onVisibilityChanged(view, i3);
        if (this.f71148e != null) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.G = z16;
            b();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        super.onWindowVisibilityChanged(i3);
        if (this.f71148e != null) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.G = z16;
            b();
        }
    }

    public void setMovie(Movie movie) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) movie);
        } else {
            if (movie == null) {
                return;
            }
            this.f71148e = movie;
            requestLayout();
        }
    }

    public void setMovieFile(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) file);
        } else if (file != null && file.exists()) {
            setMovie(Movie.decodeFile(file.getAbsolutePath()));
        }
    }

    public void setMovieResource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f71147d = i3;
            setMovie(Movie.decodeStream(getResources().openRawResource(this.f71147d)));
        }
    }

    public void setMovieTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f71150h = i3;
            invalidate();
        }
    }

    public void setPaused(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        this.F = z16;
        if (!z16) {
            this.f71149f = SystemClock.uptimeMillis() - this.f71150h;
        }
        invalidate();
    }
}
