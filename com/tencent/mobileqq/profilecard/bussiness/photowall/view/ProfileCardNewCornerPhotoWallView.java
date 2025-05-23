package com.tencent.mobileqq.profilecard.bussiness.photowall.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileCardNewCornerPhotoWallView extends ProfileCardNewPhotoWallView {
    static IPatchRedirector $redirector_;
    private int lowerLeft;
    private int lowerRight;
    private int mColor;
    private Paint mPaint;
    private Path mPath;
    private float[] radius;
    private RectF rectF;
    private int upperLeft;
    private int upperRight;

    public ProfileCardNewCornerPhotoWallView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mPath = new Path();
        this.mPaint = new Paint();
        this.mColor = Color.parseColor("#FFD5D5D5");
        this.upperLeft = 0;
        this.upperRight = 0;
        this.lowerLeft = 0;
        this.lowerRight = 0;
        this.rectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
        int i3 = this.upperLeft;
        int i16 = this.upperRight;
        int i17 = this.lowerRight;
        int i18 = this.lowerLeft;
        this.radius = new float[]{i3, i3, i16, i16, i17, i17, i18, i18};
    }

    private void initCorner(Context context, AttributeSet attributeSet) {
        this.mPaint.setColor(this.mColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setFilterBitmap(true);
        super.setLayerType(2, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (this.mPath == null) {
            this.mPath = new Path();
        }
        this.mPath.reset();
        this.rectF.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + ((getWidth() - getPaddingLeft()) - getPaddingRight()), getPaddingTop() + ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        this.mPath.addRoundRect(this.rectF, this.radius, Path.Direction.CW);
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    public void setCorner(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (i3 >= 0 && i16 >= 0 && i17 >= 0 && i18 >= 0) {
            this.upperLeft = i3;
            this.upperRight = i16;
            this.lowerLeft = i17;
            this.lowerRight = i18;
            float[] fArr = this.radius;
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

    public void setCornerRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            setCorner(i3, i3, i3, i3);
        }
    }

    public ProfileCardNewCornerPhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mPath = new Path();
        this.mPaint = new Paint();
        this.mColor = Color.parseColor("#FFD5D5D5");
        this.upperLeft = 0;
        this.upperRight = 0;
        this.lowerLeft = 0;
        this.lowerRight = 0;
        this.rectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
        int i3 = this.upperLeft;
        int i16 = this.upperRight;
        int i17 = this.lowerRight;
        int i18 = this.lowerLeft;
        this.radius = new float[]{i3, i3, i16, i16, i17, i17, i18, i18};
        initCorner(context, attributeSet);
    }
}
