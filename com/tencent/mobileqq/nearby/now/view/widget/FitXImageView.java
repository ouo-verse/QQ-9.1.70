package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes15.dex */
public class FitXImageView extends View {
    private static final Matrix.ScaleToFit[] T = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private int C;
    private int D;
    private boolean E;
    private Drawable F;
    private int[] G;
    private boolean H;
    private int I;
    private int J;
    private int K;
    private Matrix L;
    private final RectF M;
    private final RectF N;
    private boolean P;
    private Context Q;
    private Matrix R;
    private boolean S;

    /* renamed from: d, reason: collision with root package name */
    private Uri f252959d;

    /* renamed from: e, reason: collision with root package name */
    private int f252960e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f252961f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f252962h;

    /* renamed from: i, reason: collision with root package name */
    private int f252963i;

    /* renamed from: m, reason: collision with root package name */
    private int f252964m;

    public FitXImageView(Context context) {
        super(context);
        this.f252960e = 0;
        this.f252961f = false;
        this.f252962h = false;
        this.f252963i = Integer.MAX_VALUE;
        this.f252964m = Integer.MAX_VALUE;
        this.C = 255;
        this.D = 256;
        this.E = false;
        this.F = null;
        this.G = null;
        this.H = false;
        this.I = 0;
        this.L = null;
        this.M = new RectF();
        this.N = new RectF();
        this.S = false;
        this.Q = context;
        d();
    }

    private void a() {
        Drawable drawable = this.F;
        if (drawable != null && this.E) {
            Drawable mutate = drawable.mutate();
            this.F = mutate;
            mutate.setAlpha((this.C * this.D) >> 8);
        }
    }

    private void b() {
        boolean z16;
        float f16;
        float f17;
        if (this.F != null && this.f252961f) {
            int i3 = this.J;
            int i16 = this.K;
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            if ((i3 >= 0 && width != i3) || (i16 >= 0 && height != i16)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (i3 > 0 && i16 > 0) {
                this.F.setBounds(0, 0, i3, i16);
                if (z16) {
                    this.L = null;
                    return;
                }
                Matrix matrix = this.R;
                this.L = matrix;
                int i17 = width * i16;
                float f18 = 0.0f;
                if (i17 / i3 < height) {
                    this.M.set(0.0f, 0.0f, i3, i16);
                    this.N.set(0.0f, 0.0f, width, height);
                    Matrix matrix2 = this.R;
                    this.L = matrix2;
                    matrix2.setRectToRect(this.M, this.N, Matrix.ScaleToFit.CENTER);
                    return;
                }
                this.L = matrix;
                if (i3 * height > i17) {
                    f17 = height / i16;
                    float f19 = (width - (i3 * f17)) * 0.5f;
                    f16 = 0.0f;
                    f18 = f19;
                } else {
                    float f26 = width / i3;
                    f16 = (height - (i16 * f26)) * 0.5f;
                    f17 = f26;
                }
                matrix.setScale(f17, f17);
                if (!this.S) {
                    this.L.postTranslate((int) (f18 + 0.5f), (int) (f16 + 0.5f));
                    return;
                }
                return;
            }
            this.F.setBounds(0, 0, width, height);
            this.L = null;
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ((IResourceUtil) QRoute.api(IResourceUtil.class)).getCustomFitMode());
        this.S = obtainStyledAttributes.getBoolean(((IResourceUtil) QRoute.api(IResourceUtil.class)).getCustomFitModeUseFitXFromStart(), false);
        obtainStyledAttributes.recycle();
    }

    private void d() {
        this.R = new Matrix();
    }

    private void e() {
        Drawable drawable = this.F;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth < 0) {
                intrinsicWidth = this.J;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight < 0) {
                intrinsicHeight = this.K;
            }
            if (intrinsicWidth != this.J || intrinsicHeight != this.K) {
                this.J = intrinsicWidth;
                this.K = intrinsicHeight;
                requestLayout();
            }
        }
    }

    private int f(int i3, int i16, int i17) {
        int mode = View.MeasureSpec.getMode(i17);
        int size = View.MeasureSpec.getSize(i17);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return size;
                }
                return i3;
            }
            return Math.min(i3, i16);
        }
        return Math.min(Math.min(i3, size), i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v21, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g() {
        Resources resources;
        ?? r06;
        if (this.F != null || (resources = getResources()) == null) {
            return;
        }
        int i3 = this.f252960e;
        InputStream inputStream = null;
        Drawable drawable = null;
        if (i3 != 0) {
            try {
                drawable = resources.getDrawable(i3);
            } catch (Exception e16) {
                Log.w("ImageView", "Unable to find resource: " + this.f252960e, e16);
                this.f252959d = null;
            }
        } else {
            Uri uri = this.f252959d;
            if (uri != null) {
                String scheme = uri.getScheme();
                if (!"content".equals(scheme) && !"file".equals(scheme)) {
                    r06 = Drawable.createFromPath(this.f252959d.toString());
                } else {
                    try {
                        r06 = this.Q.getContentResolver().openInputStream(this.f252959d);
                    } catch (Exception e17) {
                        e = e17;
                        r06 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                    try {
                        try {
                            Drawable createFromStream = Drawable.createFromStream(r06, null);
                            if (r06 != 0) {
                                try {
                                    r06.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                            r06 = createFromStream;
                        } catch (Exception e19) {
                            e = e19;
                            Log.w("ImageView", "Unable to open content: " + this.f252959d, e);
                            if (r06 != 0) {
                                try {
                                    r06.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                }
                            }
                            r06 = 0;
                            if (r06 == 0) {
                            }
                            drawable = r06;
                            h(drawable);
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = r06;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e27) {
                                e27.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (r06 == 0) {
                    System.out.println("resolveUri failed on bad bitmap uri: " + this.f252959d);
                    this.f252959d = null;
                }
                drawable = r06;
            } else {
                return;
            }
        }
        h(drawable);
    }

    private void h(Drawable drawable) {
        Drawable drawable2 = this.F;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.F);
        }
        this.F = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            drawable.setLevel(this.I);
            this.J = drawable.getIntrinsicWidth();
            this.K = drawable.getIntrinsicHeight();
            a();
            b();
            return;
        }
        this.K = -1;
        this.J = -1;
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.F;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.F) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.F;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void layout(int i3, int i16, int i17, int i18) {
        super.layout(i3, i16, i17, i18);
        this.f252961f = true;
        b();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        boolean z16;
        super.onAttachedToWindow();
        Drawable drawable = this.F;
        if (drawable != null) {
            if (getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            drawable.setVisible(z16, false);
        }
    }

    @Override // android.view.View
    public int[] onCreateDrawableState(int i3) {
        int[] iArr = this.G;
        if (iArr == null) {
            return super.onCreateDrawableState(i3);
        }
        if (!this.H) {
            return iArr;
        }
        return View.mergeDrawableStates(super.onCreateDrawableState(i3 + iArr.length), this.G);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.F;
        if (drawable != null) {
            drawable.setVisible(false, false);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.F != null && this.J != 0 && this.K != 0) {
            try {
                if (this.L == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
                    this.F.draw(canvas);
                    return;
                }
                int saveCount = canvas.getSaveCount();
                canvas.save();
                if (this.P) {
                    int scrollX = getScrollX();
                    int scrollY = getScrollY();
                    canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
                }
                canvas.translate(getPaddingLeft(), getPaddingTop());
                Matrix matrix = this.L;
                if (matrix != null) {
                    canvas.concat(matrix);
                }
                this.F.draw(canvas);
                canvas.restoreToCount(saveCount);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        float f16;
        boolean z16;
        boolean z17;
        int f17;
        int f18;
        int i19;
        int i26;
        g();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        boolean z18 = true;
        if (this.F == null) {
            this.J = -1;
            this.K = -1;
            f16 = 0.0f;
            z16 = false;
            z17 = false;
            i17 = 0;
            i18 = 0;
        } else {
            i17 = this.J;
            i18 = this.K;
            if (i17 <= 0) {
                i17 = 1;
            }
            if (i18 <= 0) {
                i18 = 1;
            }
            if (this.f252962h) {
                if (mode != 1073741824) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (mode2 != 1073741824) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                f16 = i17 / i18;
            } else {
                f16 = 0.0f;
                z16 = false;
                z17 = false;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (!z16 && !z17) {
            int max = Math.max(i17 + paddingLeft + paddingRight, getSuggestedMinimumWidth());
            int max2 = Math.max(i18 + paddingTop + paddingBottom, getSuggestedMinimumHeight());
            f17 = View.resolveSizeAndState(max, i3, 0);
            f18 = View.resolveSizeAndState(max2, i16, 0);
        } else {
            f17 = f(i17 + paddingLeft + paddingRight, this.f252963i, i3);
            f18 = f(i18 + paddingTop + paddingBottom, this.f252964m, i16);
            if (f16 != 0.0f) {
                float f19 = (f18 - paddingTop) - paddingBottom;
                if (Math.abs((((f17 - paddingLeft) - paddingRight) / f19) - f16) > 1.0E-7d) {
                    if (z16 && (i26 = ((int) (f19 * f16)) + paddingLeft + paddingRight) <= f17) {
                        f17 = i26;
                    } else {
                        z18 = false;
                    }
                    if (!z18 && z17 && (i19 = ((int) (((f17 - paddingLeft) - paddingRight) / f16)) + paddingTop + paddingBottom) <= f18) {
                        f18 = i19;
                    }
                }
            }
        }
        setMeasuredDimension(f17, f18);
    }

    public void setAlpha(int i3) {
        int i16 = i3 & 255;
        if (this.C != i16) {
            this.C = i16;
            this.E = true;
            a();
            invalidate();
        }
    }

    public void setCropToPadding(boolean z16) {
        if (this.P != z16) {
            this.P = z16;
            requestLayout();
            invalidate();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new BitmapDrawable(this.Q.getResources(), bitmap));
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.F != drawable || this.J != drawable.getIntrinsicWidth() || this.K != drawable.getIntrinsicHeight()) {
            this.f252960e = 0;
            this.f252959d = null;
            int i3 = this.J;
            int i16 = this.K;
            h(drawable);
            if (i3 != this.J || i16 != this.K) {
                requestLayout();
            }
            invalidate();
        }
    }

    public void setImageLevel(int i3) {
        this.I = i3;
        Drawable drawable = this.F;
        if (drawable != null) {
            drawable.setLevel(i3);
            e();
        }
    }

    public void setImageResource(int i3) {
        if (this.f252959d != null || this.f252960e != i3) {
            h(null);
            this.f252960e = i3;
            this.f252959d = null;
            g();
            requestLayout();
            invalidate();
        }
    }

    public void setImageState(int[] iArr, boolean z16) {
        this.G = iArr;
        this.H = z16;
        if (this.F != null) {
            refreshDrawableState();
            e();
        }
    }

    public void setImageURI(Uri uri) {
        if (this.f252960e == 0) {
            Uri uri2 = this.f252959d;
            if (uri2 != uri) {
                if (uri != null && uri2 != null && uri.equals(uri2)) {
                    return;
                }
            } else {
                return;
            }
        }
        h(null);
        this.f252960e = 0;
        this.f252959d = uri;
        g();
        requestLayout();
        invalidate();
    }

    public void setMaxHeight(int i3) {
        this.f252964m = i3;
    }

    public void setMaxWidth(int i3) {
        this.f252963i = i3;
    }

    @Override // android.view.View
    public void setSelected(boolean z16) {
        super.setSelected(z16);
        e();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        boolean z16;
        super.setVisibility(i3);
        Drawable drawable = this.F;
        if (drawable != null) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            drawable.setVisible(z16, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (this.F != drawable && !super.verifyDrawable(drawable)) {
            return false;
        }
        return true;
    }

    public FitXImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.Q = context;
        d();
        c(context, attributeSet);
    }

    public FitXImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f252960e = 0;
        this.f252961f = false;
        this.f252962h = false;
        this.f252963i = Integer.MAX_VALUE;
        this.f252964m = Integer.MAX_VALUE;
        this.C = 255;
        this.D = 256;
        this.E = false;
        this.F = null;
        this.G = null;
        this.H = false;
        this.I = 0;
        this.L = null;
        this.M = new RectF();
        this.N = new RectF();
        this.S = false;
        this.Q = context;
        d();
        c(context, attributeSet);
    }
}
