package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f186003a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f186004b;

    /* renamed from: c, reason: collision with root package name */
    private final Bitmap f186005c;

    /* renamed from: d, reason: collision with root package name */
    private final float f186006d;

    /* renamed from: e, reason: collision with root package name */
    private final float f186007e;

    /* renamed from: f, reason: collision with root package name */
    private final float f186008f;

    /* renamed from: g, reason: collision with root package name */
    private final float f186009g;

    /* renamed from: h, reason: collision with root package name */
    private float f186010h;

    /* renamed from: i, reason: collision with root package name */
    private float f186011i;

    /* renamed from: j, reason: collision with root package name */
    private int f186012j;

    /* renamed from: k, reason: collision with root package name */
    private a f186013k;

    /* renamed from: l, reason: collision with root package name */
    private float f186014l;

    /* renamed from: m, reason: collision with root package name */
    private float f186015m;

    /* renamed from: n, reason: collision with root package name */
    private int f186016n;

    /* renamed from: o, reason: collision with root package name */
    private b f186017o;

    /* renamed from: p, reason: collision with root package name */
    private float f186018p;

    /* renamed from: q, reason: collision with root package name */
    private float f186019q;

    /* renamed from: r, reason: collision with root package name */
    private float f186020r;

    /* renamed from: s, reason: collision with root package name */
    private int f186021s;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void a(float f16, float f17);
    }

    public e(b bVar, float f16, float f17, int i3, int i16, int i17, int i18) {
        Paint paint = new Paint(1);
        this.f186003a = paint;
        this.f186012j = -1;
        this.f186016n = 4;
        this.f186021s = Color.parseColor("#298be7");
        this.f186017o = bVar;
        Context context = bVar.getContext();
        float screenWidth = ViewUtils.getScreenWidth() * 0.0375f;
        this.f186006d = screenWidth;
        this.f186007e = f17;
        this.f186008f = 0.5f * screenWidth;
        float f18 = i17;
        this.f186009g = f18;
        Bitmap g16 = g(context.getResources(), R.drawable.f162361gh4, (int) screenWidth, (int) f17);
        Bitmap g17 = g(context.getResources(), R.drawable.gh6, (int) screenWidth, (int) f17);
        ColorDrawable colorDrawable = new ColorDrawable(this.f186021s);
        colorDrawable.setBounds(0, 0, (int) screenWidth, (int) f17);
        Bitmap createBitmap = Bitmap.createBitmap((int) screenWidth, (int) f17, Bitmap.Config.RGB_565);
        this.f186004b = createBitmap;
        Canvas canvas = new Canvas(createBitmap);
        colorDrawable.draw(canvas);
        if (g16 != null) {
            canvas.drawBitmap(g16, (screenWidth - g16.getWidth()) / 2.0f, (f17 - g16.getHeight()) / 2.0f, paint);
        }
        Bitmap createBitmap2 = Bitmap.createBitmap((int) screenWidth, (int) f17, Bitmap.Config.RGB_565);
        this.f186005c = createBitmap2;
        canvas.setBitmap(createBitmap2);
        colorDrawable.draw(canvas);
        if (g17 != null) {
            canvas.drawBitmap(g17, (screenWidth - g17.getWidth()) / 2.0f, (f17 - g17.getHeight()) / 2.0f, paint);
        }
        float f19 = i16;
        float f26 = (((i18 * 1.0f) / f19) * f16) + screenWidth;
        this.f186015m = f26;
        this.f186014l = (2000.0f / f19) * f16;
        this.f186019q = f18 - screenWidth;
        this.f186020r = screenWidth;
        this.f186010h = screenWidth;
        this.f186011i = f26;
    }

    private void d(float f16, Canvas canvas) {
        canvas.drawBitmap(this.f186005c, f16, 0.0f, this.f186003a);
    }

    private void e(float f16, Canvas canvas) {
        canvas.drawBitmap(this.f186004b, f16 - this.f186006d, 0.0f, this.f186003a);
    }

    private boolean f(float f16, float f17) {
        if (Math.abs(f16 - f17) == 0.0f) {
            return true;
        }
        return false;
    }

    private boolean l(float f16, float f17, float f18) {
        if (Math.abs(f16 - f18) <= this.f186006d * 2.0f && f17 > 0.0f && f17 < this.f186007e) {
            return true;
        }
        return false;
    }

    public int a(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        int i19 = 1;
        if (i17 > i16 || i18 > i3) {
            int i26 = i17 / 2;
            int i27 = i18 / 2;
            while (i26 / i19 > i16 && i27 / i19 > i3) {
                i19 *= 2;
            }
        }
        return i19;
    }

    public void b() {
        this.f186013k = null;
        this.f186004b.recycle();
        this.f186005c.recycle();
    }

    public void c(Canvas canvas) {
        canvas.save();
        int color = this.f186003a.getColor();
        this.f186003a.setColor(this.f186021s);
        canvas.drawRect(this.f186010h, 0.0f, this.f186011i, this.f186016n, this.f186003a);
        float f16 = this.f186010h;
        float f17 = this.f186007e;
        canvas.drawRect(f16, f17 - this.f186016n, this.f186011i, f17, this.f186003a);
        this.f186003a.setColor(color);
        e(this.f186010h, canvas);
        d(this.f186011i, canvas);
        canvas.restore();
    }

    public Bitmap g(Resources resources, int i3, int i16, int i17) {
        if (resources == null || i3 <= 0) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i18 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(resources, i3, options);
            if (i16 > 0 || i17 > 0) {
                i18 = a(options, i16, i17);
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = i18;
            return BitmapFactory.decodeResource(resources, i3, options);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public float h() {
        return this.f186007e;
    }

    public float i() {
        return this.f186011i - this.f186010h;
    }

    public float j() {
        return this.f186006d;
    }

    public boolean k() {
        if (f(this.f186010h, this.f186006d) && f(this.f186011i, this.f186015m)) {
            return false;
        }
        return true;
    }

    public boolean m(float f16, float f17) {
        boolean l3 = l(f16, f17, this.f186010h - this.f186008f);
        boolean l16 = l(f16, f17, this.f186011i + this.f186008f);
        if (l3) {
            this.f186012j = 0;
            return true;
        }
        if (!l16) {
            return false;
        }
        this.f186012j = 1;
        return true;
    }

    public void n(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        if (motionEvent.getAction() == 1) {
            this.f186012j = -1;
        }
        if (motionEvent.getAction() == 0) {
            this.f186018p = motionEvent.getX();
            return;
        }
        if (motionEvent.getAction() == 2) {
            float f16 = x16 - this.f186018p;
            int i3 = this.f186012j;
            if (i3 == 0) {
                float max = Math.max(this.f186011i - this.f186015m, this.f186020r);
                if (x16 < max) {
                    this.f186010h = max;
                    return;
                }
                if (f16 < 0.0f && this.f186010h + f16 <= this.f186006d) {
                    this.f186010h = max;
                } else {
                    float f17 = this.f186011i;
                    float f18 = f17 - x16;
                    float f19 = this.f186014l;
                    if (f18 < f19) {
                        this.f186010h = f17 - f19;
                    } else {
                        this.f186010h = x16;
                    }
                }
            } else if (i3 == 1) {
                float min = Math.min(this.f186010h + this.f186015m, this.f186019q);
                if (x16 > min) {
                    this.f186011i = min;
                    return;
                }
                if (f16 > 0.0f && this.f186011i + f16 >= this.f186015m) {
                    this.f186011i = min;
                } else {
                    float f26 = this.f186010h;
                    float f27 = x16 - f26;
                    float f28 = this.f186014l;
                    if (f27 < f28) {
                        this.f186011i = f26 + f28;
                    } else {
                        this.f186011i = x16;
                    }
                }
            }
        }
        this.f186017o.invalidate();
        a aVar = this.f186013k;
        if (aVar != null) {
            aVar.a(this.f186010h, this.f186011i);
        }
    }

    public void o() {
        this.f186013k = null;
        this.f186010h = 0.0f;
        this.f186011i = 0.0f;
    }

    public void p(float f16, float f17) {
        if (f16 >= 0.0f) {
            this.f186020r = f16 + this.f186006d;
        } else {
            this.f186020r = this.f186006d;
        }
        if (f17 >= 0.0f) {
            float f18 = this.f186006d;
            this.f186019q = Math.min(f17 + f18, this.f186009g - f18);
        }
    }

    public void q(a aVar) {
        this.f186013k = aVar;
    }
}
