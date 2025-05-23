package com.tencent.mobileqq.activity.contacts.alphabet;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QUITokenResUtil;

/* compiled from: P */
/* loaded from: classes10.dex */
public class IndexBarTipView extends View {
    static IPatchRedirector $redirector_;
    private static String J;
    private int C;
    private int D;
    private int E;
    private Drawable F;
    private Matrix G;
    private Paint H;
    private BitmapShader I;

    /* renamed from: d, reason: collision with root package name */
    private RectF f181441d;

    /* renamed from: e, reason: collision with root package name */
    private String f181442e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f181443f;

    /* renamed from: h, reason: collision with root package name */
    private int f181444h;

    /* renamed from: i, reason: collision with root package name */
    private int f181445i;

    /* renamed from: m, reason: collision with root package name */
    private float f181446m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67995);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            J = "IndexBarTipView";
        }
    }

    public IndexBarTipView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private Bitmap b(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap a16 = a(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888, 1);
        Canvas canvas = new Canvas(a16);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return a16;
    }

    private void c(Context context, AttributeSet attributeSet) {
        this.C = context.getResources().getColor(R.color.black);
        this.f181446m = context.getResources().getDimension(com.tencent.mobileqq.R.dimen.f159012tv);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.tencent.mobileqq.R.styleable.IndexBar);
            this.C = obtainStyledAttributes.getColor(com.tencent.mobileqq.R.styleable.IndexBar_sidebarTextColor, this.C);
            this.f181446m = obtainStyledAttributes.getDimension(com.tencent.mobileqq.R.styleable.IndexBar_sidebarTextSize, this.f181446m);
            this.F = obtainStyledAttributes.getDrawable(com.tencent.mobileqq.R.styleable.IndexBar_sidebarTipsDrawable);
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint(1);
        this.f181443f = paint;
        paint.setColor(this.C);
        this.f181443f.setTypeface(Typeface.DEFAULT);
        this.f181443f.setTextAlign(Paint.Align.CENTER);
        this.f181443f.setTextSize(this.f181446m);
        this.G = new Matrix();
        Paint paint2 = new Paint();
        this.H = paint2;
        paint2.setAntiAlias(true);
        d();
    }

    private void d() {
        Drawable drawable = this.F;
        if (drawable == null) {
            return;
        }
        Bitmap b16 = b(drawable);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.I = new BitmapShader(b16, tileMode, tileMode);
    }

    private void f() {
        float f16;
        if (this.F == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "updateImagePaint mWidth =  " + this.f181444h + ", getWidth = " + getWidth());
        }
        float intrinsicWidth = this.F.getIntrinsicWidth();
        float intrinsicHeight = this.F.getIntrinsicHeight();
        if ((intrinsicWidth * 1.0f) / intrinsicHeight > 1.0f) {
            f16 = (this.f181444h * 1.0f) / intrinsicWidth;
        } else {
            f16 = (this.f181444h * 1.0f) / intrinsicHeight;
        }
        Matrix matrix = this.G;
        if (matrix != null && this.I != null && this.H != null) {
            matrix.setScale(f16, f16);
            this.I.setLocalMatrix(this.G);
            this.H.setShader(this.I);
        }
        int i3 = (int) (f16 * intrinsicHeight);
        this.f181445i = i3;
        this.f181441d.set(0.0f, 0.0f, this.f181444h, i3);
    }

    public Bitmap a(int i3, int i16, Bitmap.Config config, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), config, Integer.valueOf(i17));
        }
        try {
            return Bitmap.createBitmap(i3, i16, config);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            if (i17 > 0) {
                System.gc();
                return a(i3, i16, config, i17 - 1);
            }
            return null;
        }
    }

    public void e() {
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (!QUITokenResUtil.useQUIToken() || (resources = getResources()) == null) {
            return;
        }
        Paint paint = this.f181443f;
        if (paint != null) {
            paint.setColor(resources.getColor(com.tencent.mobileqq.R.color.qui_common_on_brand_primary, null));
        }
        Drawable drawable = resources.getDrawable(com.tencent.mobileqq.R.drawable.ndl);
        this.F = drawable;
        if (drawable == null) {
            return;
        }
        d();
        f();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (TextUtils.isEmpty(this.f181442e)) {
            return;
        }
        if (this.F != null) {
            canvas.drawRect(this.f181441d, this.H);
        }
        canvas.drawText(this.f181442e, this.D, this.E, this.f181443f);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f181444h != getWidth()) {
            this.f181444h = getWidth();
            f();
        }
        if (!TextUtils.isEmpty(this.f181442e)) {
            Rect rect = new Rect();
            Paint paint = this.f181443f;
            String str = this.f181442e;
            paint.getTextBounds(str, 0, str.length(), rect);
            this.D = (int) ((this.f181444h * 0.5d) - (rect.width() / 2.0d));
            this.E = (int) ((this.f181445i * 0.5d) + (rect.height() / 2.0d));
        }
    }

    public void setText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        this.f181442e = str;
        Rect rect = new Rect();
        Paint paint = this.f181443f;
        String str2 = this.f181442e;
        paint.getTextBounds(str2, 0, str2.length(), rect);
        this.D = (int) ((this.f181444h * 0.5d) - (rect.width() / 2.0d));
        this.E = (int) ((this.f181445i * 0.5d) + (rect.height() / 2.0d));
        invalidate();
    }

    public IndexBarTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public IndexBarTipView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f181441d = new RectF();
        this.f181442e = "";
        c(context, attributeSet);
    }
}
