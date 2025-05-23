package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.util.VersionUtils;

/* loaded from: classes20.dex */
public class PAImageView extends AnyScaleTypeImageView {
    private int E;
    private int F;
    private int G;
    private Bitmap H;
    private Canvas I;
    private BitmapShader J;
    private Paint K;
    float L;
    Paint M;
    float[] N;
    Path P;
    RectF Q;
    private boolean R;

    public PAImageView(Context context) {
        this(context, null, 0);
    }

    public void c(float f16, float f17) {
        this.Q.set(0.0f, 0.0f, f16, f17);
        this.P.addRoundRect(this.Q, this.N, Path.Direction.CW);
    }

    @Override // com.tencent.mobileqq.widget.URLTextImageView, android.view.View
    public void draw(Canvas canvas) {
        if (!this.R) {
            super.draw(canvas);
            return;
        }
        this.E = getWidth();
        int height = getHeight();
        this.F = height;
        if (this.E > 0 && height > 0) {
            int i3 = this.G;
            if (i3 == 1) {
                int saveCount = canvas.getSaveCount();
                canvas.save();
                super.draw(canvas);
                canvas.drawPath(this.P, this.M);
                canvas.restoreToCount(saveCount);
                return;
            }
            if (i3 == 2) {
                Bitmap bitmap = this.H;
                if (bitmap != null && (bitmap.getWidth() != this.E || this.H.getHeight() != this.F)) {
                    this.H = null;
                    this.J = null;
                }
                if (this.H == null) {
                    try {
                        try {
                            this.H = Bitmap.createBitmap(this.E, this.F, Bitmap.Config.RGB_565);
                        } catch (OutOfMemoryError unused) {
                            URLDrawable.clearMemoryCache();
                            try {
                                this.H = Bitmap.createBitmap(this.E, this.F, Bitmap.Config.RGB_565);
                            } catch (OutOfMemoryError unused2) {
                            }
                        }
                    } catch (OutOfMemoryError unused3) {
                        this.H = Bitmap.createBitmap(this.E, this.F, Bitmap.Config.RGB_565);
                    }
                    Canvas canvas2 = this.I;
                    if (canvas2 != null) {
                        canvas2.setBitmap(this.H);
                    }
                }
                if (this.H == null) {
                    super.draw(canvas);
                    return;
                }
                if (this.I == null) {
                    Canvas canvas3 = new Canvas(this.H);
                    this.I = canvas3;
                    canvas3.setBitmap(this.H);
                }
                if (this.J == null) {
                    Bitmap bitmap2 = this.H;
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
                    this.J = bitmapShader;
                    this.K.setShader(bitmapShader);
                }
                super.draw(this.I);
                RectF rectF = new RectF(0.0f, 0.0f, this.E, this.F + (this.L * 2.0f));
                int save = canvas.save();
                float f16 = this.L;
                canvas.drawRoundRect(rectF, f16, f16, this.K);
                canvas.restoreToCount(save);
                return;
            }
            return;
        }
        super.draw(canvas);
    }

    @TargetApi(11)
    public void init() {
        if (VersionUtils.isHoneycomb()) {
            this.G = 2;
        } else {
            this.G = 2;
        }
        int i3 = this.G;
        if (i3 == 1) {
            setLayerType(2, null);
            Paint paint = new Paint();
            this.M = paint;
            paint.setStyle(Paint.Style.FILL);
            this.M.setAntiAlias(true);
            this.M.setFilterBitmap(true);
            this.M.setColor(-16777216);
            this.M.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.P = new Path();
            this.Q = new RectF();
            this.N = new float[8];
            return;
        }
        if (i3 == 2) {
            Paint paint2 = new Paint();
            this.K = paint2;
            paint2.setAntiAlias(true);
            this.K.setFilterBitmap(true);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16 && this.G == 1) {
            c(getWidth(), getHeight());
        }
    }

    public void setUseRadiusRound(boolean z16, float f16) {
        this.R = z16;
        this.L = f16;
        float[] fArr = this.N;
        if (fArr != null) {
            fArr[3] = f16;
            fArr[2] = f16;
            fArr[1] = f16;
            fArr[0] = f16;
            fArr[7] = 0.0f;
            fArr[6] = 0.0f;
            fArr[5] = 0.0f;
            fArr[4] = 0.0f;
        }
    }

    public PAImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PAImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.L = 10.0f;
        this.R = false;
        init();
    }
}
