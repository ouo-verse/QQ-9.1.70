package com.tencent.state.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.state.square.SquareBaseKt;

/* compiled from: P */
/* loaded from: classes38.dex */
public class RoundRelativeLayout extends RelativeLayout {
    public static final int CORNER_ALL = 15;
    public static final int CORNER_EMPTY = 0;
    public static final int CORNER_LEFT_BOTTOM = 8;
    public static final int CORNER_LEFT_TOP = 1;
    public static final int CORNER_RIGHT_TOP = 2;
    public static final int CORNER_RITH_BOTTOM = 4;
    public static final int[] CORNORS = {1, 2, 4, 8};
    public static final String TAG = "RoundRelativeLayout";
    public int mCorners;
    public int mRadius;
    public Path mRoundPath;
    private Paint paint;
    private float[] radiusValue;

    public RoundRelativeLayout(Context context) {
        super(context);
        this.mCorners = 15;
        this.radiusValue = new float[8];
        initRoundPath();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mRadius != 0 && this.mCorners != 0) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
            super.dispatchDraw(canvas);
            try {
                try {
                    checkPathChanged(canvas);
                } catch (Exception e16) {
                    SquareBaseKt.getSquareLog().e(TAG, "checkPathChanged", e16);
                }
                return;
            } finally {
                canvas.restoreToCount(saveLayer);
            }
        }
        super.dispatchDraw(canvas);
    }

    public void initRoundPath() {
        Path path = new Path();
        this.mRoundPath = path;
        path.setFillType(Path.FillType.INVERSE_WINDING);
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paint.setColor(0);
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    private void checkPathChanged(Canvas canvas) {
        int i3 = 0;
        while (true) {
            float[] fArr = this.radiusValue;
            if (i3 < fArr.length) {
                if ((CORNORS[i3 / 2] & this.mCorners) != 0) {
                    fArr[i3] = this.mRadius;
                } else {
                    fArr[i3] = 0.0f;
                }
                i3++;
            } else {
                this.mRoundPath.reset();
                this.mRoundPath.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.radiusValue, Path.Direction.CW);
                canvas.drawPath(this.mRoundPath, this.paint);
                return;
            }
        }
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCorners = 15;
        this.radiusValue = new float[8];
        initRoundPath();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mCorners = 15;
        this.radiusValue = new float[8];
        initRoundPath();
    }
}
