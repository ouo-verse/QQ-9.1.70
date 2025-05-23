package com.tencent.mobileqq.profile.view.helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HeartRiseLayerDrawable extends LayerDrawable {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    static class a extends BitmapDrawable {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        private static int f260535h;

        /* renamed from: i, reason: collision with root package name */
        private static int f260536i;

        /* renamed from: a, reason: collision with root package name */
        private float f260537a;

        /* renamed from: b, reason: collision with root package name */
        private int f260538b;

        /* renamed from: c, reason: collision with root package name */
        private float f260539c;

        /* renamed from: d, reason: collision with root package name */
        private int f260540d;

        /* renamed from: e, reason: collision with root package name */
        private int f260541e;

        /* renamed from: f, reason: collision with root package name */
        private long f260542f;

        /* renamed from: g, reason: collision with root package name */
        private AccelerateInterpolator f260543g;

        public a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) resources, (Object) bitmap);
                return;
            }
            this.f260539c = 0.5f;
            this.f260540d = 50;
            this.f260541e = 0;
            this.f260542f = 0L;
            this.f260543g = new AccelerateInterpolator(1.5f);
        }

        public static a[] a(int i3, Resources resources, Bitmap bitmap) {
            if (bitmap != null && resources != null) {
                a[] aVarArr = new a[i3];
                f260536i = bitmap.getWidth() / 2;
                f260535h = bitmap.getHeight() / 2;
                for (int i16 = 0; i16 < i3; i16++) {
                    aVarArr[i16] = new a(resources, bitmap);
                }
                return aVarArr;
            }
            return null;
        }

        public void b(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3));
                return;
            }
            this.f260537a = (float) j3;
            this.f260538b = i3;
            this.f260541e = 1;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            float f16;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
                return;
            }
            int i16 = this.f260541e;
            boolean z16 = false;
            if (i16 != 1) {
                if (i16 == 2) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f260542f)) / this.f260537a;
                    if (uptimeMillis > 1.0f) {
                        this.f260541e = 3;
                    } else {
                        canvas.save();
                        float interpolation = this.f260543g.getInterpolation(uptimeMillis);
                        if (interpolation > 0.5f) {
                            f16 = -interpolation;
                            i3 = this.f260540d;
                        } else {
                            f16 = -(1.0f - interpolation);
                            i3 = this.f260540d;
                        }
                        float f17 = f16 * i3;
                        int i17 = this.f260538b;
                        canvas.translate(f17, i17 - (interpolation * i17));
                        float f18 = this.f260539c;
                        canvas.scale(uptimeMillis * f18, f18 * uptimeMillis, f260536i, f260535h);
                        setAlpha((int) (255.0f - (uptimeMillis * 255.0f)));
                        super.draw(canvas);
                        canvas.restore();
                    }
                }
                z16 = true;
            } else {
                this.f260542f = SystemClock.uptimeMillis();
                this.f260541e = 2;
            }
            if (!z16) {
                invalidateSelf();
            }
        }
    }

    public HeartRiseLayerDrawable(int i3, Resources resources) {
        super(a.a(i3, resources, a(resources)));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) resources);
        }
    }

    public static Bitmap a(Resources resources) {
        Paint paint = new Paint();
        paint.setColor(resources.getColor(R.color.a5o));
        Bitmap createBitmap = Bitmap.createBitmap(126, 126, Bitmap.Config.ARGB_4444);
        createBitmap.setDensity(resources.getDisplayMetrics().densityDpi);
        Canvas canvas = new Canvas(createBitmap);
        canvas.rotate(45.0f);
        canvas.translate(0.0f, -88.0f);
        float f16 = 56;
        float f17 = 126;
        canvas.drawRect(f16, f16, f17, f17, paint);
        float f18 = 91;
        float f19 = 35;
        canvas.drawCircle(f16, f18, f19, paint);
        canvas.drawCircle(f18, f16, f19, paint);
        return createBitmap;
    }

    public void b(Handler handler, int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, handler, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        for (int i18 = 0; i18 < getNumberOfLayers(); i18++) {
            Runnable runnable = new Runnable(i18, i3, i16) { // from class: com.tencent.mobileqq.profile.view.helper.HeartRiseLayerDrawable.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f260532d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f260533e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f260534f;

                {
                    this.f260532d = i18;
                    this.f260533e = i3;
                    this.f260534f = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, HeartRiseLayerDrawable.this, Integer.valueOf(i18), Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((a) HeartRiseLayerDrawable.this.getDrawable(this.f260532d)).b(this.f260533e, this.f260534f);
                    }
                }
            };
            if (i18 % 2 == 0) {
                i17 = i18 * 200;
            } else {
                i17 = i18 * 130;
            }
            handler.postDelayed(runnable, i17);
        }
    }
}
