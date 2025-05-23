package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RoundedImageView extends ImageView {
    public static final Shader.TileMode L = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] M = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private Drawable C;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private ImageView.ScaleType I;
    private Shader.TileMode J;
    private Shader.TileMode K;

    /* renamed from: d, reason: collision with root package name */
    private final float[] f316200d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f316201e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f316202f;

    /* renamed from: h, reason: collision with root package name */
    private float f316203h;

    /* renamed from: i, reason: collision with root package name */
    private ColorFilter f316204i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f316205m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f316206a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f316206a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f316206a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f316206a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f316206a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f316206a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f316206a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f316206a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageView(Context context) {
        super(context);
        this.f316200d = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f316202f = ColorStateList.valueOf(-16777216);
        this.f316203h = 0.0f;
        this.f316204i = null;
        this.f316205m = false;
        this.D = false;
        this.E = false;
        this.F = false;
        Shader.TileMode tileMode = L;
        this.J = tileMode;
        this.K = tileMode;
    }

    private void a() {
        Drawable drawable = this.C;
        if (drawable != null && this.f316205m) {
            Drawable mutate = drawable.mutate();
            this.C = mutate;
            if (this.D) {
                mutate.setColorFilter(this.f316204i);
            }
        }
    }

    private static Shader.TileMode b(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return Shader.TileMode.MIRROR;
            }
            return Shader.TileMode.REPEAT;
        }
        return Shader.TileMode.CLAMP;
    }

    private Drawable c() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i3 = this.H;
        if (i3 != 0) {
            try {
                drawable = resources.getDrawable(i3);
            } catch (Exception e16) {
                QLog.w("RoundedImageView", 1, "Unable to find resource: " + this.H, e16);
                this.H = 0;
            }
        }
        return be.e(drawable);
    }

    private Drawable d() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i3 = this.G;
        if (i3 != 0) {
            try {
                drawable = resources.getDrawable(i3);
            } catch (Exception e16) {
                QLog.w("RoundedImageView", 1, "Unable to find resource: " + this.G, e16);
                this.G = 0;
            }
        }
        return be.e(drawable);
    }

    private void e(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof be) {
            be beVar = (be) drawable;
            beVar.l(scaleType).i(this.f316203h).h(this.f316202f).k(this.E).m(this.J).n(this.K);
            float[] fArr = this.f316200d;
            if (fArr != null) {
                beVar.j(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            a();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i3 = 0; i3 < numberOfLayers; i3++) {
                e(layerDrawable.getDrawable(i3), scaleType);
            }
        }
    }

    private void f(boolean z16) {
        if (this.F) {
            if (z16) {
                this.f316201e = be.e(this.f316201e);
            }
            e(this.f316201e, ImageView.ScaleType.FIT_XY);
        }
    }

    private void g() {
        e(this.C, this.I);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.I;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        ColorDrawable colorDrawable = new ColorDrawable(i3);
        this.f316201e = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f316201e = drawable;
        f(true);
        super.setBackgroundDrawable(this.f316201e);
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i3) {
        if (this.H != i3) {
            this.H = i3;
            Drawable c16 = c();
            this.f316201e = c16;
            setBackgroundDrawable(c16);
        }
    }

    public void setBorderColor(@ColorInt int i3) {
        setBorderColor(ColorStateList.valueOf(i3));
    }

    public void setBorderWidth(int i3) {
        setBorderWidth(getResources().getDimension(i3));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f316204i != colorFilter) {
            this.f316204i = colorFilter;
            this.D = true;
            this.f316205m = true;
            a();
            invalidate();
        }
    }

    public void setCornerRadius(float f16) {
        setCornerRadius(f16, f16, f16, f16);
    }

    public void setCornerRadiusDimen(int i3) {
        float dimension = getResources().getDimension(i3);
        setCornerRadius(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.G = 0;
        this.C = be.d(bitmap);
        g();
        super.setImageDrawable(this.C);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.G = 0;
        this.C = be.e(drawable);
        g();
        super.setImageDrawable(this.C);
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i3) {
        if (this.G != i3) {
            this.G = i3;
            this.C = d();
            g();
            super.setImageDrawable(this.C);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z16) {
        this.E = z16;
        g();
        f(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.I != scaleType) {
            this.I = scaleType;
            switch (a.f316206a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            g();
            f(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.J == tileMode) {
            return;
        }
        this.J = tileMode;
        g();
        f(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.K == tileMode) {
            return;
        }
        this.K = tileMode;
        g();
        f(false);
        invalidate();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.f316202f.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.f316202f = colorStateList;
        g();
        f(false);
        if (this.f316203h > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f16) {
        if (this.f316203h == f16) {
            return;
        }
        this.f316203h = f16;
        g();
        f(false);
        invalidate();
    }

    public void setCornerRadius(int i3, float f16) {
        float[] fArr = this.f316200d;
        if (fArr[i3] == f16) {
            return;
        }
        fArr[i3] = f16;
        g();
        f(false);
        invalidate();
    }

    public void setCornerRadiusDimen(int i3, int i16) {
        setCornerRadius(i3, getResources().getDimensionPixelSize(i16));
    }

    public void setCornerRadius(float f16, float f17, float f18, float f19) {
        float[] fArr = this.f316200d;
        if (fArr[0] == f16 && fArr[1] == f17 && fArr[2] == f19 && fArr[3] == f18) {
            return;
        }
        fArr[0] = f16;
        fArr[1] = f17;
        fArr[3] = f18;
        fArr[2] = f19;
        g();
        f(false);
        invalidate();
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.f316200d = fArr;
        this.f316202f = ColorStateList.valueOf(-16777216);
        this.f316203h = 0.0f;
        this.f316204i = null;
        this.f316205m = false;
        this.D = false;
        this.E = false;
        this.F = false;
        Shader.TileMode tileMode = L;
        this.J = tileMode;
        this.K = tileMode;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedImageView, i3, 0);
        int i16 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_android_scaleType, -1);
        if (i16 >= 0) {
            setScaleType(M[i16]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius, -1);
        fArr[0] = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_top_left, -1);
        fArr[1] = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_top_right, -1);
        fArr[2] = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_bottom_right, -1);
        fArr[3] = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_bottom_left, -1);
        int length = fArr.length;
        boolean z16 = false;
        for (int i17 = 0; i17 < length; i17++) {
            float[] fArr2 = this.f316200d;
            if (fArr2[i17] < 0.0f) {
                fArr2[i17] = 0.0f;
            } else {
                z16 = true;
            }
        }
        if (!z16) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length2 = this.f316200d.length;
            for (int i18 = 0; i18 < length2; i18++) {
                this.f316200d[i18] = dimensionPixelSize;
            }
        }
        float dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_border_width, -1);
        this.f316203h = dimensionPixelSize2;
        if (dimensionPixelSize2 < 0.0f) {
            this.f316203h = 0.0f;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.RoundedImageView_riv_border_color);
        this.f316202f = colorStateList;
        if (colorStateList == null) {
            this.f316202f = ColorStateList.valueOf(-16777216);
        }
        this.F = obtainStyledAttributes.getBoolean(R.styleable.RoundedImageView_riv_mutate_background, false);
        this.E = obtainStyledAttributes.getBoolean(R.styleable.RoundedImageView_riv_oval, false);
        int i19 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_riv_tile_mode, -2);
        if (i19 != -2) {
            setTileModeX(b(i19));
            setTileModeY(b(i19));
        }
        int i26 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_riv_tile_mode_x, -2);
        if (i26 != -2) {
            setTileModeX(b(i26));
        }
        int i27 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_riv_tile_mode_y, -2);
        if (i27 != -2) {
            setTileModeY(b(i27));
        }
        g();
        f(true);
        if (this.F) {
            super.setBackgroundDrawable(this.f316201e);
        }
        obtainStyledAttributes.recycle();
    }
}
