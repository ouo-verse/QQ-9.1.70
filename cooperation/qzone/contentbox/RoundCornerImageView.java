package cooperation.qzone.contentbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class RoundCornerImageView extends URLImageView {
    private int lowerLeft;
    private int lowerRight;
    private int mColor;
    private Paint mPaint;
    private Path mPath;
    private float[] radius;
    private RectF rectF;
    private int upperLeft;
    private int upperRight;

    public RoundCornerImageView(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
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

    public void setColor(int i3) {
        this.mColor = i3;
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mPath = new Path();
        this.mPaint = new Paint();
        this.mColor = Color.parseColor("#FFD5D5D5");
        this.upperLeft = 0;
        this.upperRight = 0;
        this.lowerLeft = 0;
        this.lowerRight = 0;
        this.rectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
        int i16 = this.upperLeft;
        int i17 = this.upperRight;
        int i18 = this.lowerRight;
        int i19 = this.lowerLeft;
        this.radius = new float[]{i16, i16, i17, i17, i18, i18, i19, i19};
        this.mPaint.setColor(this.mColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setFilterBitmap(true);
        super.setLayerType(2, null);
    }

    public void setCorner(int i3, int i16, int i17, int i18) {
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
}
