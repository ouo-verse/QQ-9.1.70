package com.tencent.qqnt.aio.at.widget;

import android.R;
import android.content.Context;
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
import qv3.a;

/* compiled from: P */
/* loaded from: classes23.dex */
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
    private RectF f349492d;

    /* renamed from: e, reason: collision with root package name */
    private String f349493e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f349494f;

    /* renamed from: h, reason: collision with root package name */
    private int f349495h;

    /* renamed from: i, reason: collision with root package name */
    private int f349496i;

    /* renamed from: m, reason: collision with root package name */
    private float f349497m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48143);
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

    private void d(Context context, AttributeSet attributeSet) {
        this.C = context.getResources().getColor(R.color.black);
        this.f349497m = context.getResources().getDimension(com.tencent.mobileqq.R.dimen.f159012tv);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.A1);
            this.C = obtainStyledAttributes.getColor(a.D1, this.C);
            this.f349497m = obtainStyledAttributes.getDimension(a.G1, this.f349497m);
            this.F = obtainStyledAttributes.getDrawable(a.I1);
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint(1);
        this.f349494f = paint;
        paint.setColor(this.C);
        this.f349494f.setTypeface(Typeface.DEFAULT);
        this.f349494f.setTextAlign(Paint.Align.CENTER);
        this.f349494f.setTextSize(this.f349497m);
        this.G = new Matrix();
        Paint paint2 = new Paint();
        this.H = paint2;
        paint2.setAntiAlias(true);
        e();
    }

    private void e() {
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
            QLog.d(J, 2, "updateImagePaint mWidth =  " + this.f349495h + ", getWidth = " + getWidth());
        }
        float intrinsicWidth = this.F.getIntrinsicWidth();
        float intrinsicHeight = this.F.getIntrinsicHeight();
        if ((intrinsicWidth * 1.0f) / intrinsicHeight > 1.0f) {
            f16 = (this.f349495h * 1.0f) / intrinsicWidth;
        } else {
            f16 = (this.f349495h * 1.0f) / intrinsicHeight;
        }
        this.G.setScale(f16, f16);
        this.I.setLocalMatrix(this.G);
        this.H.setShader(this.I);
        int i3 = (int) (f16 * intrinsicHeight);
        this.f349496i = i3;
        this.f349492d.set(0.0f, 0.0f, this.f349495h, i3);
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

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f349493e;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (TextUtils.isEmpty(this.f349493e)) {
            return;
        }
        if (this.F != null) {
            canvas.drawRect(this.f349492d, this.H);
        }
        canvas.drawText(this.f349493e, this.D, this.E, this.f349494f);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f349495h != getWidth()) {
            this.f349495h = getWidth();
            f();
        }
        if (!TextUtils.isEmpty(this.f349493e)) {
            Rect rect = new Rect();
            Paint paint = this.f349494f;
            String str = this.f349493e;
            paint.getTextBounds(str, 0, str.length(), rect);
            this.D = (int) ((this.f349495h * 0.5d) - (rect.width() / 2.0d));
            this.E = (int) ((this.f349496i * 0.5d) + (rect.height() / 2.0d));
        }
    }

    public void setText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        this.f349493e = str;
        Rect rect = new Rect();
        Paint paint = this.f349494f;
        String str2 = this.f349493e;
        paint.getTextBounds(str2, 0, str2.length(), rect);
        this.D = (int) ((this.f349495h * 0.5d) - (rect.width() / 2.0d));
        this.E = (int) ((this.f349496i * 0.5d) + (rect.height() / 2.0d));
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
        this.f349492d = new RectF();
        this.f349493e = "";
        d(context, attributeSet);
    }
}
