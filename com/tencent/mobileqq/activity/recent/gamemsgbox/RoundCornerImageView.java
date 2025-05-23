package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RoundCornerImageView extends URLImageView {
    static IPatchRedirector $redirector_;
    private int C;
    private RectF D;
    private float[] E;

    /* renamed from: d, reason: collision with root package name */
    private Path f185448d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f185449e;

    /* renamed from: f, reason: collision with root package name */
    private int f185450f;

    /* renamed from: h, reason: collision with root package name */
    private int f185451h;

    /* renamed from: i, reason: collision with root package name */
    private int f185452i;

    /* renamed from: m, reason: collision with root package name */
    private int f185453m;

    public RoundCornerImageView(Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        if (this.f185448d == null) {
            this.f185448d = new Path();
        }
        this.f185448d.reset();
        this.D.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + ((getWidth() - getPaddingLeft()) - getPaddingRight()), getPaddingTop() + ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        this.f185448d.addRoundRect(this.D, this.E, Path.Direction.CW);
        this.f185448d.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.f185448d);
        super.draw(canvas);
    }

    public void setColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f185450f = i3;
        }
    }

    public void setCorner(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (i3 >= 0 && i16 >= 0 && i17 >= 0 && i18 >= 0) {
            this.f185451h = i3;
            this.f185452i = i16;
            this.f185453m = i17;
            this.C = i18;
            float[] fArr = this.E;
            float f16 = i3;
            fArr[0] = f16;
            fArr[1] = f16;
            float f17 = i16;
            fArr[2] = f17;
            fArr[3] = f17;
            float f18 = i18;
            fArr[4] = f18;
            fArr[5] = f18;
            float f19 = i17;
            fArr[6] = f19;
            fArr[7] = f19;
            return;
        }
        throw new IllegalArgumentException("should not be less than 0");
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f185448d = new Path();
        this.f185449e = new Paint();
        this.f185450f = Color.parseColor("#FFD5D5D5");
        this.f185451h = 0;
        this.f185452i = 0;
        this.f185453m = 0;
        this.C = 0;
        this.D = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
        int i16 = this.f185451h;
        int i17 = this.f185452i;
        int i18 = this.C;
        int i19 = this.f185453m;
        this.E = new float[]{i16, i16, i17, i17, i18, i18, i19, i19};
        this.f185449e.setColor(this.f185450f);
        this.f185449e.setStyle(Paint.Style.STROKE);
        this.f185449e.setAntiAlias(true);
        this.f185449e.setFilterBitmap(true);
        super.setLayerType(2, null);
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.roundCornerImageView);
            this.f185451h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.roundCornerImageView_upperLeft, 0);
            this.f185452i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.roundCornerImageView_upperRight, 0);
            this.f185453m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.roundCornerImageView_lowerLeft, 0);
            this.C = obtainStyledAttributes.getDimensionPixelSize(R.styleable.roundCornerImageView_lowerRight, 0);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.roundCornerImageView_imageRadius, 0);
            if (this.f185451h == 0) {
                this.f185451h = dimensionPixelSize;
            }
            if (this.f185452i == 0) {
                this.f185452i = dimensionPixelSize;
            }
            if (this.f185453m == 0) {
                this.f185453m = dimensionPixelSize;
            }
            if (this.C == 0) {
                this.C = dimensionPixelSize;
            }
            obtainStyledAttributes.recycle();
            float[] fArr = this.E;
            int i26 = this.f185451h;
            fArr[0] = i26;
            fArr[1] = i26;
            int i27 = this.f185452i;
            fArr[2] = i27;
            fArr[3] = i27;
            int i28 = this.C;
            fArr[4] = i28;
            fArr[5] = i28;
            int i29 = this.f185453m;
            fArr[6] = i29;
            fArr[7] = i29;
        } catch (Exception unused) {
            QLog.e("RoundCornerImageView", 1, "init RoundCornerImageView catch exception");
        }
    }
}
