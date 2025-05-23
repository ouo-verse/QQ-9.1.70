package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes26.dex */
public class SkinnableNinePatchDrawable extends Drawable {
    static IPatchRedirector $redirector_ = null;
    private static final boolean DEFAULT_DITHER = true;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private boolean mMutated;
    private NinePatch mNinePatch;
    private a mNinePatchState;
    private Rect mPadding;
    private int mTargetDensity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static final class a extends BaseConstantState {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        NinePatch f376036a;

        /* renamed from: b, reason: collision with root package name */
        Rect f376037b;

        /* renamed from: c, reason: collision with root package name */
        Rect f376038c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f376039d;

        /* renamed from: e, reason: collision with root package name */
        int f376040e;

        /* renamed from: f, reason: collision with root package name */
        int f376041f;

        /* renamed from: g, reason: collision with root package name */
        Bitmap f376042g;

        /* renamed from: h, reason: collision with root package name */
        Paint f376043h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(NinePatch ninePatch, Bitmap bitmap, Rect rect) {
            this(ninePatch, bitmap, rect, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, ninePatch, bitmap, rect);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.f376040e;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new SkinnableNinePatchDrawable(this, null) : (Drawable) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        a(NinePatch ninePatch, Bitmap bitmap, Rect rect, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, ninePatch, bitmap, rect, Boolean.valueOf(z16));
                return;
            }
            this.f376041f = 160;
            this.f376043h = new Paint();
            this.f376042g = bitmap;
            this.f376036a = ninePatch;
            this.f376037b = rect;
            this.f376039d = z16;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new SkinnableNinePatchDrawable(this, resources) : (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) resources);
        }
    }

    SkinnableNinePatchDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mTargetDensity = 160;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void computeBitmapSize() {
        updateImage();
        int[] iArr = this.mNinePatchState.mImageSizeWhenOOM;
        if (iArr != null) {
            this.mBitmapWidth = BaseConstantState.scaleFromDensity(iArr[0], iArr[2], this.mTargetDensity);
            this.mBitmapWidth = BaseConstantState.scaleFromDensity(iArr[1], iArr[2], this.mTargetDensity);
            this.mPadding.set(0, 0, 0, 0);
            return;
        }
        int density = this.mNinePatch.getDensity();
        int i3 = this.mTargetDensity;
        if (density == i3) {
            this.mBitmapWidth = this.mNinePatch.getWidth();
            this.mBitmapHeight = this.mNinePatch.getHeight();
            return;
        }
        this.mBitmapWidth = BaseConstantState.scaleFromDensity(this.mNinePatch.getWidth(), density, i3);
        this.mBitmapHeight = BaseConstantState.scaleFromDensity(this.mNinePatch.getHeight(), density, i3);
        Rect rect = this.mPadding;
        Rect rect2 = this.mNinePatchState.f376037b;
        if (rect == rect2) {
            rect = new Rect(rect2);
            this.mPadding = rect;
        }
        rect.left = BaseConstantState.scaleFromDensity(rect2.left, density, i3);
        rect.top = BaseConstantState.scaleFromDensity(rect2.top, density, i3);
        rect.right = BaseConstantState.scaleFromDensity(rect2.right, density, i3);
        rect.bottom = BaseConstantState.scaleFromDensity(rect2.bottom, density, i3);
    }

    private void setNinePatchState(a aVar, Resources resources) {
        int i3;
        this.mNinePatchState = aVar;
        this.mNinePatch = aVar.f376036a;
        this.mPadding = aVar.f376037b;
        if (resources != null) {
            i3 = resources.getDisplayMetrics().densityDpi;
        } else {
            i3 = aVar.f376041f;
        }
        this.mTargetDensity = i3;
        boolean z16 = aVar.f376039d;
        if (true != z16) {
            setDither(z16);
        }
        if (this.mNinePatch != null) {
            computeBitmapSize();
        }
    }

    private void updateImage() {
        NinePatch ninePatch = this.mNinePatch;
        a aVar = this.mNinePatchState;
        NinePatch ninePatch2 = aVar.f376036a;
        if (ninePatch != ninePatch2) {
            this.mNinePatch = ninePatch2;
            this.mPadding = aVar.f376037b;
            int[] iArr = aVar.mImageSizeWhenOOM;
            if (iArr != null) {
                this.mBitmapWidth = BaseConstantState.scaleFromDensity(iArr[0], iArr[2], this.mTargetDensity);
                this.mBitmapWidth = BaseConstantState.scaleFromDensity(iArr[1], iArr[2], this.mTargetDensity);
                this.mPadding.set(0, 0, 0, 0);
                return;
            }
            int density = ninePatch2.getDensity();
            int i3 = this.mTargetDensity;
            if (density == i3) {
                this.mBitmapWidth = this.mNinePatch.getWidth();
                this.mBitmapHeight = this.mNinePatch.getHeight();
                return;
            }
            this.mBitmapWidth = BaseConstantState.scaleFromDensity(this.mNinePatch.getWidth(), density, i3);
            this.mBitmapHeight = BaseConstantState.scaleFromDensity(this.mNinePatch.getHeight(), density, i3);
            Rect rect = this.mPadding;
            Rect rect2 = this.mNinePatchState.f376037b;
            if (rect == rect2) {
                rect = new Rect(rect2);
                this.mPadding = rect;
            }
            rect.left = BaseConstantState.scaleFromDensity(rect2.left, density, i3);
            rect.top = BaseConstantState.scaleFromDensity(rect2.top, density, i3);
            rect.right = BaseConstantState.scaleFromDensity(rect2.right, density, i3);
            rect.bottom = BaseConstantState.scaleFromDensity(rect2.bottom, density, i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        updateImage();
        if (this.mNinePatchState.mImageSizeWhenOOM != null) {
            return;
        }
        Rect bounds = getBounds();
        try {
            this.mNinePatch.draw(canvas, bounds, this.mNinePatchState.f376043h);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.mNinePatchState.hasProblem) {
            SkinEngine.getInstances();
            if (SkinEngine.mThemeService != null) {
                SkinEngine.getInstances();
                if (!SkinEngine.mThemeService.switchOn("vas_theme_engine_draw_9_patch_error", true)) {
                    return;
                }
            }
            canvas.drawRect(bounds, BaseConstantState.getErrorBoundPaint());
            canvas.drawLine(bounds.left, bounds.top, bounds.right, bounds.bottom, BaseConstantState.getErrorLinePaint());
            canvas.drawLine(bounds.right, bounds.top, bounds.left, bounds.bottom, BaseConstantState.getErrorLinePaint());
        }
    }

    public Bitmap getBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Bitmap) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.mNinePatchState.f376042g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return super.getChangingConfigurations() | this.mNinePatchState.f376040e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        this.mNinePatchState.f376040e = super.getChangingConfigurations();
        return this.mNinePatchState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        updateImage();
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        updateImage();
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        updateImage();
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        updateImage();
        return this.mBitmapWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getOldPadding(Rect rect) {
        Rect rect2 = this.mNinePatchState.f376038c;
        if (rect2 == null) {
            return false;
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        updateImage();
        NinePatch ninePatch = this.mNinePatch;
        if (ninePatch != null && !ninePatch.hasAlpha() && this.mNinePatchState.f376043h.getAlpha() >= 255) {
            return -1;
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) rect)).booleanValue();
        }
        updateImage();
        rect.set(this.mPadding);
        return true;
    }

    public Paint getPaint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Paint) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mNinePatchState.f376043h;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Region) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        updateImage();
        NinePatch ninePatch = this.mNinePatch;
        if (ninePatch == null) {
            return null;
        }
        return ninePatch.getTransparentRegion(getBounds());
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Drawable) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            getPaint().setAlpha(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) colorFilter);
        } else {
            getPaint().setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            getPaint().setDither(z16);
        }
    }

    public void setTargetDensity(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            setTargetDensity(canvas.getDensity());
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
        }
    }

    public void setTargetDensity(DisplayMetrics displayMetrics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) displayMetrics);
            return;
        }
        updateImage();
        this.mTargetDensity = displayMetrics.densityDpi;
        if (this.mNinePatch != null) {
            computeBitmapSize();
        }
    }

    @Deprecated
    public SkinnableNinePatchDrawable(Bitmap bitmap, byte[] bArr, Rect rect, String str) {
        this(new a(new NinePatch(bitmap, bArr, str), bitmap, rect), null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, bitmap, bArr, rect, str);
    }

    public SkinnableNinePatchDrawable(Resources resources, Bitmap bitmap, byte[] bArr, Rect rect, String str) {
        this(new a(new NinePatch(bitmap, bArr, str), bitmap, rect), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mNinePatchState.f376041f = this.mTargetDensity;
        } else {
            iPatchRedirector.redirect((short) 3, this, resources, bitmap, bArr, rect, str);
        }
    }

    SkinnableNinePatchDrawable(a aVar, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) aVar, (Object) resources);
        } else {
            this.mTargetDensity = 160;
            setNinePatchState(aVar, resources);
        }
    }

    public void setTargetDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        updateImage();
        if (i3 == 0) {
            i3 = 160;
        }
        this.mTargetDensity = i3;
        if (this.mNinePatch != null) {
            computeBitmapSize();
        }
    }
}
