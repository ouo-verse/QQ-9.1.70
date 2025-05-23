package com.tencent.ams.mosaic.jsengine.component.button;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.internal.view.SupportMenu;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes3.dex */
public class ProgressButton extends FrameLayout {
    static IPatchRedirector $redirector_;
    private static final float P;
    private static final float Q;
    private Paint C;
    private float D;
    private Bitmap E;
    private int F;
    private float G;
    private int H;
    private String I;
    private int J;
    private ProgressBar K;
    private final GradientDrawable L;
    private final GradientDrawable M;
    private Path N;

    /* renamed from: d, reason: collision with root package name */
    private float f70966d;

    /* renamed from: e, reason: collision with root package name */
    private float f70967e;

    /* renamed from: f, reason: collision with root package name */
    private float f70968f;

    /* renamed from: h, reason: collision with root package name */
    private String f70969h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f70970i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f70971m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46673);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            P = Utils.dp2px(16.0f);
            Q = Utils.dp2px(8.0f);
        }
    }

    public ProgressButton(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f70966d = Q;
        this.f70967e = P;
        this.f70968f = 100.0f;
        this.L = new GradientDrawable();
        this.M = new GradientDrawable();
        m(context);
    }

    private void a(int i3, int i16) {
        ProgressBar progressBar = this.K;
        if (progressBar != null) {
            MosaicUtils.Q(progressBar);
        } else {
            this.K = new ProgressBar(getContext());
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i16);
        layoutParams.leftMargin = (int) f();
        layoutParams.topMargin = (int) g();
        addView(this.K, layoutParams);
    }

    private Path b(RectF rectF) {
        Path path = this.N;
        if (path == null) {
            this.N = new Path();
        } else {
            path.rewind();
        }
        this.N.addRect(rectF, Path.Direction.CW);
        this.N.close();
        return this.N;
    }

    private Paint c() {
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f70967e);
        paint.setColor(-1);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setFakeBoldText(true);
        return paint;
    }

    private float d() {
        if (l()) {
            return (getMeasuredWidth() / 2.0f) - (((this.F + k()) + this.G) / 2.0f);
        }
        return (getMeasuredWidth() - k()) / 2.0f;
    }

    private Paint e() {
        if (this.C == null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            this.C = paint;
        }
        return this.C;
    }

    private float f() {
        if (l()) {
            if (n()) {
                return d() + k() + this.G;
            }
            return (getMeasuredWidth() / 2.0f) - (((this.F + k()) + this.G) / 2.0f);
        }
        return 0.0f;
    }

    private float g() {
        if (l()) {
            return (getMeasuredHeight() - this.H) / 2.0f;
        }
        return 0.0f;
    }

    private float h() {
        if (this.D == 0.0f) {
            Paint.FontMetrics fontMetrics = this.f70970i.getFontMetrics();
            this.D = (int) (((getMeasuredHeight() / 2) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f));
        }
        return this.D;
    }

    private Rect i(float f16, String str) {
        Rect rect = new Rect();
        if (TextUtils.isEmpty(str)) {
            return rect;
        }
        Paint paint = new Paint();
        paint.setTextSize(f16);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

    private float j() {
        if (l()) {
            if (n()) {
                return (getMeasuredWidth() / 2.0f) - (((this.F + k()) + this.G) / 2.0f);
            }
            return d() + this.F + this.G;
        }
        return d();
    }

    private float k() {
        return i(this.f70967e, this.f70969h).width();
    }

    private boolean l() {
        if (this.E != null || this.J == 1) {
            return true;
        }
        return false;
    }

    private void m(Context context) {
        this.f70970i = c();
        this.f70971m = c();
        this.L.setColor(DownloadCardView.COLOR_APP_NAME_DARK);
        setBackgroundDrawable(this.L);
        this.M.setColor(SupportMenu.CATEGORY_MASK);
        setClickable(true);
    }

    private boolean n() {
        return "right".equals(this.I);
    }

    @Override // android.view.View
    public void invalidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.L.setCornerRadius(this.f70966d);
        this.M.setCornerRadius(this.f70966d);
        super.invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
            return;
        }
        float j3 = j();
        if (!TextUtils.isEmpty(this.f70969h)) {
            canvas.drawText(this.f70969h, j3, h(), this.f70970i);
        }
        float f16 = this.f70968f;
        if (f16 >= 0.0f && f16 <= 100.0f) {
            RectF rectF = new RectF(0.0f, 0.0f, getMeasuredWidth() * (this.f70968f / 100.0f), getMeasuredHeight());
            canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            canvas.clipPath(b(rectF), Region.Op.INTERSECT);
            this.M.setBounds(new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight()));
            this.M.draw(canvas);
            Bitmap bitmap = this.E;
            if (bitmap != null && this.J == 0) {
                canvas.drawBitmap(bitmap, f(), g(), e());
            }
            if (!TextUtils.isEmpty(this.f70969h)) {
                canvas.drawText(this.f70969h, j3, h(), this.f70971m);
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        ProgressBar progressBar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.J == 1 && (progressBar = this.K) != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) progressBar.getLayoutParams();
            if (layoutParams == null) {
                int i19 = this.F;
                layoutParams = new FrameLayout.LayoutParams(i19, i19);
            }
            layoutParams.leftMargin = (int) f();
            layoutParams.topMargin = (int) g();
            this.K.setLayoutParams(layoutParams);
        }
    }

    public void setCornerRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.f70966d = f16;
            invalidate();
        }
    }

    public void setIcon(Bitmap bitmap, int i3, int i16, String str, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.E = bitmap;
        this.F = i3;
        this.H = i16;
        this.I = str;
        this.G = i18;
        this.J = i17;
        if (i17 == 1) {
            a(i3, i16);
        }
        invalidate();
    }

    public void setProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        } else {
            this.f70968f = Math.max(Math.min(f16, 100.0f), 0.0f);
            invalidate();
        }
    }

    public void setProgressBackgroundColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.L.setColor(i3);
            invalidate();
        }
    }

    public void setProgressColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        this.M.setColor(i3);
        this.f70970i.setColor(i3);
        invalidate();
    }

    public void setText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f70969h = str;
            invalidate();
        }
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f70970i.setColor(i3);
            invalidate();
        }
    }

    public void setTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
            return;
        }
        this.f70967e = f16;
        this.f70970i.setTextSize(f16);
        this.f70971m.setTextSize(f16);
        invalidate();
    }

    public void setTextTypeface(String str, String str2) {
        Typeface create;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
            return;
        }
        boolean equals = "bold".equals(str2);
        if (TextUtils.isEmpty(str)) {
            create = Typeface.defaultFromStyle(equals ? 1 : 0);
        } else {
            create = Typeface.create(str, equals ? 1 : 0);
        }
        this.f70970i.setTypeface(create);
    }
}
