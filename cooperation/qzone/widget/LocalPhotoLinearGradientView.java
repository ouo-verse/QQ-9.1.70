package cooperation.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes28.dex */
public class LocalPhotoLinearGradientView extends View {
    private Paint mPaint;
    private float mRadius;
    private RectF mRect;
    private Shader mShader;

    public LocalPhotoLinearGradientView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mShader = new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, 0, 0, Shader.TileMode.CLAMP);
        this.mRect = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setShader(this.mShader);
        RectF rectF = this.mRect;
        float f16 = this.mRadius;
        canvas.drawRoundRect(rectF, f16, f16, this.mPaint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.mRect = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    public void setRadius(float f16) {
        this.mRadius = f16;
        requestLayout();
    }

    public void setShader(@NonNull Shader shader) {
        this.mShader = shader;
        requestLayout();
    }

    public LocalPhotoLinearGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.mShader = new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, 0, 0, Shader.TileMode.CLAMP);
        this.mRect = new RectF();
    }
}
