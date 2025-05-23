package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AERoundCornerImageView extends KandianUrlImageView {
    public static final int ALL = 0;
    public static final int TOP = 1;
    private int corner;
    private int mMode;
    private Path mPath;
    private RectF mRectF;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    @interface CornerMode {
    }

    public AERoundCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.corner = 0;
        this.mPath = new Path();
        this.mRectF = new RectF();
        this.mMode = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.corner > 0) {
            this.mPath.reset();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            this.mRectF.left = getPaddingLeft();
            this.mRectF.top = getPaddingTop();
            this.mRectF.right = getPaddingLeft() + width;
            this.mRectF.bottom = getPaddingTop() + height;
            int i3 = this.corner;
            if (i3 <= 0) {
                i3 = width / 30;
            }
            int i16 = this.mMode;
            if (i16 == 0) {
                float f16 = i3;
                this.mPath.addRoundRect(this.mRectF, f16, f16, Path.Direction.CCW);
            } else if (i16 == 1) {
                float f17 = i3;
                this.mPath.addRoundRect(this.mRectF, new float[]{f17, f17, f17, f17, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CCW);
            }
            this.mPath.setFillType(Path.FillType.EVEN_ODD);
            canvas.clipPath(this.mPath);
        }
        try {
            super.onDraw(canvas);
        } catch (Exception e16) {
            QLog.e("RoundCornerImageView", 2, "e:" + e16.getMessage());
        }
    }

    public void setCorner(int i3) {
        setCorner(i3, 0);
    }

    public void setCorner(int i3, int i16) {
        if (i3 < 0) {
            return;
        }
        this.mMode = i16;
        this.corner = i3;
    }

    public AERoundCornerImageView(Context context) {
        super(context);
        this.corner = 0;
        this.mPath = new Path();
        this.mRectF = new RectF();
        this.mMode = 0;
    }

    public AERoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.corner = 0;
        this.mPath = new Path();
        this.mRectF = new RectF();
        this.mMode = 0;
    }
}
