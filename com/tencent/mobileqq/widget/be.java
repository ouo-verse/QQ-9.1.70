package com.tencent.mobileqq.widget;

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
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.drawable.RoundedDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes20.dex */
public class be extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final RectF f316714a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    private final RectF f316715b = new RectF();

    /* renamed from: c, reason: collision with root package name */
    private final RectF f316716c;

    /* renamed from: d, reason: collision with root package name */
    private final Bitmap f316717d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f316718e;

    /* renamed from: f, reason: collision with root package name */
    private final int f316719f;

    /* renamed from: g, reason: collision with root package name */
    private final int f316720g;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f316721h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f316722i;

    /* renamed from: j, reason: collision with root package name */
    private final Matrix f316723j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f316724k;

    /* renamed from: l, reason: collision with root package name */
    private Shader.TileMode f316725l;

    /* renamed from: m, reason: collision with root package name */
    private Shader.TileMode f316726m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f316727n;

    /* renamed from: o, reason: collision with root package name */
    private float f316728o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean[] f316729p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f316730q;

    /* renamed from: r, reason: collision with root package name */
    private float f316731r;

    /* renamed from: s, reason: collision with root package name */
    private ColorStateList f316732s;

    /* renamed from: t, reason: collision with root package name */
    private ImageView.ScaleType f316733t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f316734a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f316734a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f316734a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f316734a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f316734a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f316734a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f316734a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f316734a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public be(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f316716c = rectF;
        this.f316721h = new RectF();
        this.f316723j = new Matrix();
        this.f316724k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f316725l = tileMode;
        this.f316726m = tileMode;
        this.f316727n = true;
        this.f316728o = 0.0f;
        this.f316729p = new boolean[]{true, true, true, true};
        this.f316730q = false;
        this.f316731r = 0.0f;
        this.f316732s = ColorStateList.valueOf(-16777216);
        this.f316733t = ImageView.ScaleType.FIT_CENTER;
        this.f316717d = bitmap;
        int width = bitmap.getWidth();
        this.f316719f = width;
        int height = bitmap.getHeight();
        this.f316720g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f316718e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f316722i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f316732s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.f316731r);
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
            QLog.e(RoundedDrawable.TAG, 1, "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static be d(Bitmap bitmap) {
        if (bitmap != null) {
            return new be(bitmap);
        }
        return null;
    }

    public static Drawable e(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof be) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i3 = 0; i3 < numberOfLayers; i3++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i3), e(layerDrawable.getDrawable(i3)));
                }
                return layerDrawable;
            }
            Bitmap c16 = c(drawable);
            if (c16 != null) {
                return new be(c16);
            }
            return drawable;
        }
        return drawable;
    }

    private void f(Canvas canvas) {
        if (a(this.f316729p) || this.f316728o == 0.0f) {
            return;
        }
        RectF rectF = this.f316715b;
        float f16 = rectF.left;
        float f17 = rectF.top;
        float width = rectF.width() + f16;
        float height = this.f316715b.height() + f17;
        float f18 = this.f316728o;
        if (!this.f316729p[0]) {
            this.f316724k.set(f16, f17, f16 + f18, f17 + f18);
            canvas.drawRect(this.f316724k, this.f316718e);
        }
        if (!this.f316729p[1]) {
            this.f316724k.set(width - f18, f17, width, f18);
            canvas.drawRect(this.f316724k, this.f316718e);
        }
        if (!this.f316729p[2]) {
            this.f316724k.set(width - f18, height - f18, width, height);
            canvas.drawRect(this.f316724k, this.f316718e);
        }
        if (!this.f316729p[3]) {
            this.f316724k.set(f16, height - f18, f18 + f16, height);
            canvas.drawRect(this.f316724k, this.f316718e);
        }
    }

    private void g(Canvas canvas) {
        float f16;
        if (a(this.f316729p) || this.f316728o == 0.0f) {
            return;
        }
        RectF rectF = this.f316715b;
        float f17 = rectF.left;
        float f18 = rectF.top;
        float width = rectF.width() + f17;
        float height = f18 + this.f316715b.height();
        float f19 = this.f316728o;
        float f26 = this.f316731r / 2.0f;
        if (!this.f316729p[0]) {
            canvas.drawLine(f17 - f26, f18, f17 + f19, f18, this.f316722i);
            canvas.drawLine(f17, f18 - f26, f17, f18 + f19, this.f316722i);
        }
        if (!this.f316729p[1]) {
            canvas.drawLine((width - f19) - f26, f18, width, f18, this.f316722i);
            canvas.drawLine(width, f18 - f26, width, f18 + f19, this.f316722i);
        }
        if (!this.f316729p[2]) {
            f16 = f19;
            canvas.drawLine((width - f19) - f26, height, width + f26, height, this.f316722i);
            canvas.drawLine(width, height - f16, width, height, this.f316722i);
        } else {
            f16 = f19;
        }
        if (!this.f316729p[3]) {
            canvas.drawLine(f17 - f26, height, f17 + f16, height, this.f316722i);
            canvas.drawLine(f17, height - f16, f17, height, this.f316722i);
        }
    }

    private void o() {
        float width;
        float height;
        float min;
        int i3 = a.f316734a[this.f316733t.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                                this.f316721h.set(this.f316716c);
                                this.f316723j.setRectToRect(this.f316716c, this.f316714a, Matrix.ScaleToFit.CENTER);
                                this.f316723j.mapRect(this.f316721h);
                                RectF rectF = this.f316721h;
                                float f16 = this.f316731r;
                                rectF.inset(f16 / 2.0f, f16 / 2.0f);
                                this.f316723j.setRectToRect(this.f316716c, this.f316721h, Matrix.ScaleToFit.FILL);
                            } else {
                                this.f316721h.set(this.f316714a);
                                RectF rectF2 = this.f316721h;
                                float f17 = this.f316731r;
                                rectF2.inset(f17 / 2.0f, f17 / 2.0f);
                                this.f316723j.reset();
                                this.f316723j.setRectToRect(this.f316716c, this.f316721h, Matrix.ScaleToFit.FILL);
                            }
                        } else {
                            this.f316721h.set(this.f316716c);
                            this.f316723j.setRectToRect(this.f316716c, this.f316714a, Matrix.ScaleToFit.START);
                            this.f316723j.mapRect(this.f316721h);
                            RectF rectF3 = this.f316721h;
                            float f18 = this.f316731r;
                            rectF3.inset(f18 / 2.0f, f18 / 2.0f);
                            this.f316723j.setRectToRect(this.f316716c, this.f316721h, Matrix.ScaleToFit.FILL);
                        }
                    } else {
                        this.f316721h.set(this.f316716c);
                        this.f316723j.setRectToRect(this.f316716c, this.f316714a, Matrix.ScaleToFit.END);
                        this.f316723j.mapRect(this.f316721h);
                        RectF rectF4 = this.f316721h;
                        float f19 = this.f316731r;
                        rectF4.inset(f19 / 2.0f, f19 / 2.0f);
                        this.f316723j.setRectToRect(this.f316716c, this.f316721h, Matrix.ScaleToFit.FILL);
                    }
                } else {
                    this.f316723j.reset();
                    if (this.f316719f <= this.f316714a.width() && this.f316720g <= this.f316714a.height()) {
                        min = 1.0f;
                    } else {
                        min = Math.min(this.f316714a.width() / this.f316719f, this.f316714a.height() / this.f316720g);
                    }
                    float width2 = (int) (((this.f316714a.width() - (this.f316719f * min)) * 0.5f) + 0.5f);
                    float height2 = (int) (((this.f316714a.height() - (this.f316720g * min)) * 0.5f) + 0.5f);
                    this.f316723j.setScale(min, min);
                    this.f316723j.postTranslate(width2, height2);
                    this.f316721h.set(this.f316716c);
                    this.f316723j.mapRect(this.f316721h);
                    RectF rectF5 = this.f316721h;
                    float f26 = this.f316731r;
                    rectF5.inset(f26 / 2.0f, f26 / 2.0f);
                    this.f316723j.setRectToRect(this.f316716c, this.f316721h, Matrix.ScaleToFit.FILL);
                }
            } else {
                this.f316721h.set(this.f316714a);
                RectF rectF6 = this.f316721h;
                float f27 = this.f316731r;
                rectF6.inset(f27 / 2.0f, f27 / 2.0f);
                this.f316723j.reset();
                float f28 = 0.0f;
                if (this.f316719f * this.f316721h.height() > this.f316721h.width() * this.f316720g) {
                    width = this.f316721h.height() / this.f316720g;
                    height = 0.0f;
                    f28 = (this.f316721h.width() - (this.f316719f * width)) * 0.5f;
                } else {
                    width = this.f316721h.width() / this.f316719f;
                    height = (this.f316721h.height() - (this.f316720g * width)) * 0.5f;
                }
                this.f316723j.setScale(width, width);
                Matrix matrix = this.f316723j;
                float f29 = this.f316731r;
                matrix.postTranslate(((int) (f28 + 0.5f)) + (f29 / 2.0f), ((int) (height + 0.5f)) + (f29 / 2.0f));
            }
        } else {
            this.f316721h.set(this.f316714a);
            RectF rectF7 = this.f316721h;
            float f36 = this.f316731r;
            rectF7.inset(f36 / 2.0f, f36 / 2.0f);
            this.f316723j.reset();
            this.f316723j.setTranslate((int) (((this.f316721h.width() - this.f316719f) * 0.5f) + 0.5f), (int) (((this.f316721h.height() - this.f316720g) * 0.5f) + 0.5f));
        }
        this.f316715b.set(this.f316721h);
        this.f316727n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f316727n) {
            BitmapShader bitmapShader = new BitmapShader(this.f316717d, this.f316725l, this.f316726m);
            Shader.TileMode tileMode = this.f316725l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.f316726m == tileMode2) {
                bitmapShader.setLocalMatrix(this.f316723j);
            }
            this.f316718e.setShader(bitmapShader);
            this.f316727n = false;
        }
        if (this.f316730q) {
            if (this.f316731r > 0.0f) {
                canvas.drawOval(this.f316715b, this.f316718e);
                canvas.drawOval(this.f316721h, this.f316722i);
                return;
            } else {
                canvas.drawOval(this.f316715b, this.f316718e);
                return;
            }
        }
        if (b(this.f316729p)) {
            float f16 = this.f316728o;
            if (this.f316731r > 0.0f) {
                canvas.drawRoundRect(this.f316715b, f16, f16, this.f316718e);
                canvas.drawRoundRect(this.f316721h, f16, f16, this.f316722i);
                f(canvas);
                g(canvas);
                return;
            }
            canvas.drawRoundRect(this.f316715b, f16, f16, this.f316718e);
            f(canvas);
            return;
        }
        canvas.drawRect(this.f316715b, this.f316718e);
        if (this.f316731r > 0.0f) {
            canvas.drawRect(this.f316721h, this.f316722i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f316718e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f316718e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f316720g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f316719f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public be h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f316732s = colorStateList;
        this.f316722i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public be i(float f16) {
        this.f316731r = f16;
        this.f316722i.setStrokeWidth(f16);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f316732s.isStateful();
    }

    public be j(float f16, float f17, float f18, float f19) {
        boolean z16;
        boolean z17;
        boolean z18;
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f16));
        hashSet.add(Float.valueOf(f17));
        hashSet.add(Float.valueOf(f18));
        hashSet.add(Float.valueOf(f19));
        hashSet.remove(Float.valueOf(0.0f));
        boolean z19 = true;
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(floatValue) && !Float.isNaN(floatValue) && floatValue >= 0.0f) {
                    this.f316728o = floatValue;
                } else {
                    throw new IllegalArgumentException("Invalid radius value: " + floatValue);
                }
            } else {
                this.f316728o = 0.0f;
            }
            boolean[] zArr = this.f316729p;
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
            if (f19 <= 0.0f) {
                z19 = false;
            }
            zArr[3] = z19;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public be k(boolean z16) {
        this.f316730q = z16;
        return this;
    }

    public be l(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.f316733t != scaleType) {
            this.f316733t = scaleType;
            o();
        }
        return this;
    }

    public be m(Shader.TileMode tileMode) {
        if (this.f316725l != tileMode) {
            this.f316725l = tileMode;
            this.f316727n = true;
            invalidateSelf();
        }
        return this;
    }

    public be n(Shader.TileMode tileMode) {
        if (this.f316726m != tileMode) {
            this.f316726m = tileMode;
            this.f316727n = true;
            invalidateSelf();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f316714a.set(rect);
        o();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f316732s.getColorForState(iArr, 0);
        if (this.f316722i.getColor() != colorForState) {
            this.f316722i.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f316718e.setAlpha(i3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f316718e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        this.f316718e.setDither(z16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        this.f316718e.setFilterBitmap(z16);
        invalidateSelf();
    }
}
