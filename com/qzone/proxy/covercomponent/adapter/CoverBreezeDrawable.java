package com.qzone.proxy.covercomponent.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.qzone.util.ar;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.zipanimate.IZipDrawableLoader;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.zipanimate.ZipDrawableLoaderInterface;
import cooperation.qzone.zipanimate.ZipLoadedListener;
import java.lang.ref.SoftReference;
import sy3.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverBreezeDrawable extends Drawable implements Runnable, Animatable {
    private int C;
    private ColorFilter D;
    private ZipDrawableLoaderInterface H;

    /* renamed from: e, reason: collision with root package name */
    private SoftReference<Context> f50103e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f50104f;

    /* renamed from: i, reason: collision with root package name */
    private boolean f50106i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f50107m;

    /* renamed from: d, reason: collision with root package name */
    private int f50102d = 80;

    /* renamed from: h, reason: collision with root package name */
    private long f50105h = -1;
    private int E = 640;
    private int F = 1080;
    private int G = 20;

    public CoverBreezeDrawable(Context context) {
        this.f50103e = new SoftReference<>(context);
        int l3 = ar.l();
        ar.k();
        int i3 = this.E;
        l3 = l3 > i3 ? i3 : l3;
        QZLog.i("animationDrawable", " availclassSize : " + b.a());
        ZipDrawableLoaderInterface zipDrawableLoader = ((IZipDrawableLoader) QRoute.api(IZipDrawableLoader.class)).getZipDrawableLoader(context);
        this.H = zipDrawableLoader;
        zipDrawableLoader.setSize(l3, -1);
        this.H.setPreloadNum(1);
    }

    private void e() {
        long j3;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j16 = this.f50105h;
        long j17 = uptimeMillis - j16;
        int i3 = this.f50102d;
        if (j17 < i3) {
            j3 = i3 - (uptimeMillis - j16);
        } else {
            this.H.nextFrame();
            invalidateSelf();
            j3 = this.f50102d;
        }
        this.f50107m = true;
        this.f50106i = true;
        scheduleSelf(this, SystemClock.uptimeMillis() + j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable currentDrawable = this.H.getCurrentDrawable();
        if (currentDrawable != null) {
            currentDrawable.setBounds(0, 0, canvas.getWidth(), (currentDrawable.getIntrinsicHeight() * canvas.getWidth()) / currentDrawable.getIntrinsicWidth());
            currentDrawable.draw(canvas);
            this.f50105h = SystemClock.uptimeMillis();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f50106i;
    }

    @Override // java.lang.Runnable
    public void run() {
        e();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.C != i3) {
            this.C = i3;
            if (this.H.getCurrentDrawable() != null) {
                this.H.getCurrentDrawable().mutate().setAlpha(i3);
            }
        }
    }

    public void setAnimationListener(ZipLoadedListener zipLoadedListener) {
        this.H.setZipLoadedListener(zipLoadedListener);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.D != colorFilter) {
            this.D = colorFilter;
            if (this.H.getCurrentDrawable() != null) {
                this.H.getCurrentDrawable().mutate().setColorFilter(colorFilter);
            }
        }
    }

    @Deprecated
    public void setDisAppearAfterShow(boolean z16) {
        this.f50104f = z16;
    }

    public void setDrawableData(String str, String str2, int i3) {
        if (i3 > this.G) {
            this.H.release();
        } else {
            this.H.setDrawableData(str, "weidong", str2, i3, true);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        if (!z16) {
            unscheduleSelf(this);
        } else if (z17 || visible) {
            this.H.setFrame(0);
            unscheduleSelf(this);
            if (this.f50107m) {
                this.f50106i = true;
                scheduleSelf(this, SystemClock.uptimeMillis() + this.f50102d);
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f50107m = true;
        if (isRunning()) {
            return;
        }
        run();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f50107m = false;
        if (isRunning()) {
            unscheduleSelf(this);
        }
        this.H.release();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        this.f50106i = false;
        super.unscheduleSelf(runnable);
    }
}
