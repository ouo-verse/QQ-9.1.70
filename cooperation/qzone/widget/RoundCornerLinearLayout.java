package cooperation.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes28.dex */
public class RoundCornerLinearLayout extends LinearLayout {
    private Path mPath;
    private float mRadius;
    private RectF mRectF;

    public RoundCornerLinearLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.mPath.reset();
        this.mRectF.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.mPath;
        RectF rectF = this.mRectF;
        float f16 = this.mRadius;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        super.dispatchDraw(canvas);
    }

    public void setRadius(float f16) {
        this.mRadius = f16;
    }

    public RoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }
}
