package com.tencent.android.androidbypass.enhance.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.drawable.RoundedDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final RectF f72105a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f72106b;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f72107c;

    /* renamed from: d, reason: collision with root package name */
    private final Bitmap f72108d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f72109e;

    /* renamed from: f, reason: collision with root package name */
    private final int f72110f;

    /* renamed from: g, reason: collision with root package name */
    private final int f72111g;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f72112h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f72113i;

    /* renamed from: j, reason: collision with root package name */
    private final Matrix f72114j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f72115k;

    /* renamed from: l, reason: collision with root package name */
    private Shader.TileMode f72116l;

    /* renamed from: m, reason: collision with root package name */
    private Shader.TileMode f72117m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f72118n;

    /* renamed from: o, reason: collision with root package name */
    private float f72119o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean[] f72120p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f72121q;

    /* renamed from: r, reason: collision with root package name */
    private float f72122r;

    /* renamed from: s, reason: collision with root package name */
    private ColorStateList f72123s;

    /* renamed from: t, reason: collision with root package name */
    private ImageView.ScaleType f72124t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.android.androidbypass.enhance.drawable.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0716a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f72125a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10513);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f72125a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f72125a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f72125a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f72125a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f72125a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f72125a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f72125a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap);
            return;
        }
        this.f72105a = new RectF();
        this.f72106b = new RectF();
        RectF rectF = new RectF();
        this.f72107c = rectF;
        this.f72112h = new RectF();
        this.f72114j = new Matrix();
        this.f72115k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f72116l = tileMode;
        this.f72117m = tileMode;
        this.f72118n = true;
        this.f72119o = 0.0f;
        this.f72120p = new boolean[]{true, true, true, true};
        this.f72121q = false;
        this.f72122r = 0.0f;
        this.f72123s = ColorStateList.valueOf(-16777216);
        this.f72124t = ImageView.ScaleType.FIT_CENTER;
        this.f72108d = bitmap;
        int width = bitmap.getWidth();
        this.f72110f = width;
        int height = bitmap.getHeight();
        this.f72111g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f72109e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f72113i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f72123s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.f72122r);
    }

    private static boolean a(boolean[] zArr) {
        for (boolean z16 : zArr) {
            if (z16) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(boolean[] zArr) {
        for (boolean z16 : zArr) {
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap c(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable unused) {
            com.tencent.android.androidbypass.config.a.f72049a.e(RoundedDrawable.TAG, "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static a d(Bitmap bitmap) {
        if (bitmap != null) {
            return new a(bitmap);
        }
        return null;
    }

    private void e(Canvas canvas) {
        if (a(this.f72120p) || this.f72119o == 0.0f) {
            return;
        }
        RectF rectF = this.f72106b;
        float f16 = rectF.left;
        float f17 = rectF.top;
        float width = rectF.width() + f16;
        float height = this.f72106b.height() + f17;
        float f18 = this.f72119o;
        if (!this.f72120p[0]) {
            this.f72115k.set(f16, f17, f16 + f18, f17 + f18);
            canvas.drawRect(this.f72115k, this.f72109e);
        }
        if (!this.f72120p[1]) {
            this.f72115k.set(width - f18, f17, width, f18);
            canvas.drawRect(this.f72115k, this.f72109e);
        }
        if (!this.f72120p[2]) {
            this.f72115k.set(width - f18, height - f18, width, height);
            canvas.drawRect(this.f72115k, this.f72109e);
        }
        if (!this.f72120p[3]) {
            this.f72115k.set(f16, height - f18, f18 + f16, height);
            canvas.drawRect(this.f72115k, this.f72109e);
        }
    }

    private void f(Canvas canvas) {
        float f16;
        if (a(this.f72120p) || this.f72119o == 0.0f) {
            return;
        }
        RectF rectF = this.f72106b;
        float f17 = rectF.left;
        float f18 = rectF.top;
        float width = rectF.width() + f17;
        float height = f18 + this.f72106b.height();
        float f19 = this.f72119o;
        float f26 = this.f72122r / 2.0f;
        if (!this.f72120p[0]) {
            canvas.drawLine(f17 - f26, f18, f17 + f19, f18, this.f72113i);
            canvas.drawLine(f17, f18 - f26, f17, f18 + f19, this.f72113i);
        }
        if (!this.f72120p[1]) {
            canvas.drawLine((width - f19) - f26, f18, width, f18, this.f72113i);
            canvas.drawLine(width, f18 - f26, width, f18 + f19, this.f72113i);
        }
        if (!this.f72120p[2]) {
            f16 = f19;
            canvas.drawLine((width - f19) - f26, height, width + f26, height, this.f72113i);
            canvas.drawLine(width, height - f16, width, height, this.f72113i);
        } else {
            f16 = f19;
        }
        if (!this.f72120p[3]) {
            canvas.drawLine(f17 - f26, height, f17 + f16, height, this.f72113i);
            canvas.drawLine(f17, height - f16, f17, height, this.f72113i);
        }
    }

    private void l() {
        float width;
        float height;
        float min;
        int i3 = C0716a.f72125a[this.f72124t.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                                this.f72112h.set(this.f72107c);
                                this.f72114j.setRectToRect(this.f72107c, this.f72105a, Matrix.ScaleToFit.CENTER);
                                this.f72114j.mapRect(this.f72112h);
                                RectF rectF = this.f72112h;
                                float f16 = this.f72122r;
                                rectF.inset(f16 / 2.0f, f16 / 2.0f);
                                this.f72114j.setRectToRect(this.f72107c, this.f72112h, Matrix.ScaleToFit.FILL);
                            } else {
                                this.f72112h.set(this.f72105a);
                                RectF rectF2 = this.f72112h;
                                float f17 = this.f72122r;
                                rectF2.inset(f17 / 2.0f, f17 / 2.0f);
                                this.f72114j.reset();
                                this.f72114j.setRectToRect(this.f72107c, this.f72112h, Matrix.ScaleToFit.FILL);
                            }
                        } else {
                            this.f72112h.set(this.f72107c);
                            this.f72114j.setRectToRect(this.f72107c, this.f72105a, Matrix.ScaleToFit.START);
                            this.f72114j.mapRect(this.f72112h);
                            RectF rectF3 = this.f72112h;
                            float f18 = this.f72122r;
                            rectF3.inset(f18 / 2.0f, f18 / 2.0f);
                            this.f72114j.setRectToRect(this.f72107c, this.f72112h, Matrix.ScaleToFit.FILL);
                        }
                    } else {
                        this.f72112h.set(this.f72107c);
                        this.f72114j.setRectToRect(this.f72107c, this.f72105a, Matrix.ScaleToFit.END);
                        this.f72114j.mapRect(this.f72112h);
                        RectF rectF4 = this.f72112h;
                        float f19 = this.f72122r;
                        rectF4.inset(f19 / 2.0f, f19 / 2.0f);
                        this.f72114j.setRectToRect(this.f72107c, this.f72112h, Matrix.ScaleToFit.FILL);
                    }
                } else {
                    this.f72114j.reset();
                    if (this.f72110f <= this.f72105a.width() && this.f72111g <= this.f72105a.height()) {
                        min = 1.0f;
                    } else {
                        min = Math.min(this.f72105a.width() / this.f72110f, this.f72105a.height() / this.f72111g);
                    }
                    float width2 = (int) (((this.f72105a.width() - (this.f72110f * min)) * 0.5f) + 0.5f);
                    float height2 = (int) (((this.f72105a.height() - (this.f72111g * min)) * 0.5f) + 0.5f);
                    this.f72114j.setScale(min, min);
                    this.f72114j.postTranslate(width2, height2);
                    this.f72112h.set(this.f72107c);
                    this.f72114j.mapRect(this.f72112h);
                    RectF rectF5 = this.f72112h;
                    float f26 = this.f72122r;
                    rectF5.inset(f26 / 2.0f, f26 / 2.0f);
                    this.f72114j.setRectToRect(this.f72107c, this.f72112h, Matrix.ScaleToFit.FILL);
                }
            } else {
                this.f72112h.set(this.f72105a);
                RectF rectF6 = this.f72112h;
                float f27 = this.f72122r;
                rectF6.inset(f27 / 2.0f, f27 / 2.0f);
                this.f72114j.reset();
                float f28 = 0.0f;
                if (this.f72110f * this.f72112h.height() > this.f72112h.width() * this.f72111g) {
                    width = this.f72112h.height() / this.f72111g;
                    height = 0.0f;
                    f28 = (this.f72112h.width() - (this.f72110f * width)) * 0.5f;
                } else {
                    width = this.f72112h.width() / this.f72110f;
                    height = (this.f72112h.height() - (this.f72111g * width)) * 0.5f;
                }
                this.f72114j.setScale(width, width);
                Matrix matrix = this.f72114j;
                float f29 = this.f72122r;
                matrix.postTranslate(((int) (f28 + 0.5f)) + (f29 / 2.0f), ((int) (height + 0.5f)) + (f29 / 2.0f));
            }
        } else {
            this.f72112h.set(this.f72105a);
            RectF rectF7 = this.f72112h;
            float f36 = this.f72122r;
            rectF7.inset(f36 / 2.0f, f36 / 2.0f);
            this.f72114j.reset();
            this.f72114j.setTranslate((int) (((this.f72112h.width() - this.f72110f) * 0.5f) + 0.5f), (int) (((this.f72112h.height() - this.f72111g) * 0.5f) + 0.5f));
        }
        this.f72106b.set(this.f72112h);
        this.f72118n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        if (this.f72118n) {
            BitmapShader bitmapShader = new BitmapShader(this.f72108d, this.f72116l, this.f72117m);
            Shader.TileMode tileMode = this.f72116l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.f72117m == tileMode2) {
                bitmapShader.setLocalMatrix(this.f72114j);
            }
            this.f72109e.setShader(bitmapShader);
            this.f72118n = false;
        }
        if (this.f72121q) {
            if (this.f72122r > 0.0f) {
                canvas.drawOval(this.f72106b, this.f72109e);
                canvas.drawOval(this.f72112h, this.f72113i);
                return;
            } else {
                canvas.drawOval(this.f72106b, this.f72109e);
                return;
            }
        }
        if (b(this.f72120p)) {
            float f16 = this.f72119o;
            if (this.f72122r > 0.0f) {
                canvas.drawRoundRect(this.f72106b, f16, f16, this.f72109e);
                canvas.drawRoundRect(this.f72112h, f16, f16, this.f72113i);
                e(canvas);
                f(canvas);
                return;
            }
            canvas.drawRoundRect(this.f72106b, f16, f16, this.f72109e);
            e(canvas);
            return;
        }
        canvas.drawRect(this.f72106b, this.f72109e);
        if (this.f72122r > 0.0f) {
            canvas.drawRect(this.f72112h, this.f72113i);
        }
    }

    public a g(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (a) iPatchRedirector.redirect((short) 22, this, Float.valueOf(f16));
        }
        this.f72122r = f16;
        this.f72113i.setStrokeWidth(f16);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f72109e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ColorFilter) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f72109e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.f72111g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.f72110f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return -3;
    }

    public a h(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (a) iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
        }
        i(f16, f16, f16, f16);
        return this;
    }

    public a i(float f16, float f17, float f18, float f19) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (a) iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        }
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f16));
        hashSet.add(Float.valueOf(f17));
        hashSet.add(Float.valueOf(f18));
        hashSet.add(Float.valueOf(f19));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(floatValue) && !Float.isNaN(floatValue) && floatValue >= 0.0f) {
                    this.f72119o = floatValue;
                } else {
                    throw new IllegalArgumentException("Invalid radius value: " + floatValue);
                }
            } else {
                this.f72119o = 0.0f;
            }
            boolean[] zArr = this.f72120p;
            if (f16 > 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            zArr[0] = z16;
            if (f17 > 0.0f) {
                z17 = true;
            } else {
                z17 = false;
            }
            zArr[1] = z17;
            if (f18 > 0.0f) {
                z18 = true;
            } else {
                z18 = false;
            }
            zArr[2] = z18;
            if (f19 > 0.0f) {
                z19 = true;
            }
            zArr[3] = z19;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f72123s.isStateful();
    }

    public a j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (a) iPatchRedirector.redirect((short) 28, (Object) this, z16);
        }
        this.f72121q = z16;
        return this;
    }

    public a k(ImageView.ScaleType scaleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (a) iPatchRedirector.redirect((short) 30, (Object) this, (Object) scaleType);
        }
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.f72124t != scaleType) {
            this.f72124t = scaleType;
            l();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rect);
            return;
        }
        super.onBoundsChange(rect);
        this.f72105a.set(rect);
        l();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) iArr)).booleanValue();
        }
        int colorForState = this.f72123s.getColorForState(iArr, 0);
        if (this.f72113i.getColor() != colorForState) {
            this.f72113i.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f72109e.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) colorFilter);
        } else {
            this.f72109e.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.f72109e.setDither(z16);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.f72109e.setFilterBitmap(z16);
            invalidateSelf();
        }
    }
}
