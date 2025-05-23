package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qzonehub.api.panorama.IPanoramaBallView;

/* loaded from: classes38.dex */
public class PanoramaBallView extends View {
    private static final int SWEEP_ANGLE_MAX = 120;
    private static final int SWEEP_ANGLE_MIN = 45;
    private int colorBackground;
    private int innerCircleRadius;
    private Paint mPaint;
    private int mViewHeight;
    private int mViewWidth;
    private int modeType;
    private int moveDegreeX;
    private int moveDegreeY;
    private int outCircleRadius;
    private int sectorDegree;
    private float sweepAngle;
    public static final int WIDTH = IPanoramaBallView.WIDTH;
    public static final int HEIGHT = IPanoramaBallView.HEIGHT;

    public PanoramaBallView(Context context) {
        super(context);
        this.mViewWidth = WIDTH;
        this.mViewHeight = HEIGHT;
        this.moveDegreeX = 0;
        this.moveDegreeY = 0;
        this.sectorDegree = 360;
        init(context);
    }

    private void drawBackground(Canvas canvas) {
        this.mPaint.setColor(this.colorBackground);
        this.mPaint.setStyle(Paint.Style.FILL);
        int i3 = this.mViewWidth;
        canvas.drawCircle(i3 / 2, i3 / 2, i3 / 2, this.mPaint);
    }

    private void drawContent(Canvas canvas) {
        float f16;
        int i3 = (this.outCircleRadius - this.innerCircleRadius) / 2;
        int i16 = this.outCircleRadius;
        int i17 = this.innerCircleRadius;
        RectF rectF = new RectF((i16 - i17) + i3, (i16 - i17) + i3, (i16 + i17) - i3, (i16 + i17) - i3);
        this.mPaint.setColor(-1);
        float f17 = this.sweepAngle;
        float f18 = ((-90.0f) - (f17 / 2.0f)) + this.moveDegreeX;
        int i18 = this.sectorDegree;
        if (i18 != 360) {
            if (f18 < (-90) - (i18 / 2)) {
                f18 = (-90) - (i18 / 2);
            }
            if (f18 + f17 > (i18 / 2) - 90) {
                f16 = ((i18 / 2) - 90) - f17;
                canvas.drawArc(rectF, f16, f17, true, this.mPaint);
            }
        }
        f16 = f18;
        canvas.drawArc(rectF, f16, f17, true, this.mPaint);
    }

    private void drawContentDeco(Canvas canvas) {
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        int i3 = this.outCircleRadius;
        int i16 = this.innerCircleRadius;
        canvas.drawArc(new RectF(i3 - i16, i3 - i16, i3 + i16, i3 + i16), (-90) - (r0 / 2), this.sectorDegree, false, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        int i17 = this.outCircleRadius;
        int i18 = ((i17 - this.innerCircleRadius) / 2) / 2;
        path.moveTo(i17, (i17 - r2) - r3);
        int i19 = this.outCircleRadius;
        path.lineTo(i19 - i18, i19 - this.innerCircleRadius);
        int i26 = this.outCircleRadius;
        path.lineTo(i18 + i26, i26 - this.innerCircleRadius);
        path.close();
        canvas.drawPath(path, this.mPaint);
    }

    private void init(Context context) {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.colorBackground = context.getResources().getColor(R.color.by);
    }

    private int measureHeight(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(size, this.mViewHeight);
            } else {
                size = this.mViewHeight;
            }
        }
        this.mViewHeight = size;
        return size;
    }

    private int measureWidth(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(size, this.mViewWidth);
            } else {
                size = this.mViewWidth;
            }
        }
        this.mViewWidth = size;
        return size;
    }

    public int getMoveDegreeX() {
        return this.moveDegreeX;
    }

    public int getMoveDegreeY() {
        return this.moveDegreeY;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = this.mViewWidth;
        int i16 = i3 / 2;
        this.outCircleRadius = i16;
        this.innerCircleRadius = i16 - (i3 / 6);
        drawBackground(canvas);
        drawContentDeco(canvas);
        drawContent(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(measureWidth(i3), measureHeight(i16));
    }

    public void setDegreeChange(int i3, int i16, int i17, float f16) {
        float f17;
        float f18;
        this.sectorDegree = i3;
        this.moveDegreeX = i16;
        this.moveDegreeY = i17;
        if (this.modeType == 2) {
            f17 = f16 - 0.122f;
            f18 = 0.878f;
        } else {
            f17 = f16 - 0.35f;
            f18 = 1.15f;
        }
        this.sweepAngle = ((f17 / f18) * 75.0f) + 45.0f;
        postInvalidate();
    }

    public void setModeType(int i3) {
        this.modeType = i3;
    }

    public PanoramaBallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewWidth = WIDTH;
        this.mViewHeight = HEIGHT;
        this.moveDegreeX = 0;
        this.moveDegreeY = 0;
        this.sectorDegree = 360;
        init(context);
    }
}
