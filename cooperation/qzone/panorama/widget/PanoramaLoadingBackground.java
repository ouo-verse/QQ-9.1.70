package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;

/* loaded from: classes38.dex */
public class PanoramaLoadingBackground extends View {
    public static int MIN_ALPHA = 180;
    private int colorBackground;
    private int contentAlpha;
    private int inCircleRadius;
    private Paint mPaint;
    private int mViewHeight;
    private int mViewWidth;
    private int midCircleRadius;
    private int outCircleRadius;

    public PanoramaLoadingBackground(Context context) {
        super(context);
        this.mViewWidth = PanoramaLoadingLayout.WIDTH;
        this.mViewHeight = PanoramaLoadingLayout.HEIGHT;
        this.contentAlpha = 255;
        init(context);
    }

    private void drawContentText(Canvas canvas) {
        this.mPaint.setColor(-16777216);
        this.mPaint.setAlpha(this.contentAlpha);
        this.mPaint.setTextSize(this.mViewWidth / 5);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setStrokeWidth(0.0f);
        Paint.FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
        int i3 = this.mViewHeight / 2;
        int i16 = fontMetricsInt.descent;
        canvas.drawText("360", getWidth() / 2, (i3 - i16) + ((i16 - fontMetricsInt.ascent) / 2), this.mPaint);
    }

    private void drawInCircle(Canvas canvas) {
        this.mPaint.setColor(-1);
        this.mPaint.setAlpha(this.contentAlpha);
        this.mPaint.setStyle(Paint.Style.FILL);
        int i3 = this.mViewWidth;
        canvas.drawCircle(i3 / 2, i3 / 2, this.inCircleRadius, this.mPaint);
    }

    private void drawOutCircle(Canvas canvas) {
        this.mPaint.setAlpha(255);
        this.mPaint.setColor(this.colorBackground);
        this.mPaint.setStyle(Paint.Style.FILL);
        int i3 = this.mViewWidth;
        canvas.drawCircle(i3 / 2, i3 / 2, this.outCircleRadius, this.mPaint);
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

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = this.mViewWidth / 2;
        this.outCircleRadius = i3;
        this.midCircleRadius = i3 - (i3 / 5);
        this.inCircleRadius = i3 - ((i3 * 2) / 5);
        drawOutCircle(canvas);
        drawInCircle(canvas);
        drawContentText(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(measureWidth(i3), measureHeight(i16));
    }

    public void setContentAlpha(int i3) {
        this.contentAlpha = i3;
        postInvalidate();
    }

    public PanoramaLoadingBackground(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewWidth = PanoramaLoadingLayout.WIDTH;
        this.mViewHeight = PanoramaLoadingLayout.HEIGHT;
        this.contentAlpha = 255;
        init(context);
    }
}
