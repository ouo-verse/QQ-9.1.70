package cooperation.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
@Deprecated
/* loaded from: classes28.dex */
public class TriangleView extends View {
    private int direction;
    private int drawColor;

    public TriangleView(Context context, int i3, int i16) {
        super(context);
        getResources().getColor(R.color.g_);
        this.direction = i3;
        this.drawColor = i16;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.drawColor);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.direction == 1) {
            path.moveTo(measuredWidth / 2, 0.0f);
            float f16 = measuredWidth;
            float f17 = measuredHeight;
            path.lineTo(f16, f17);
            path.lineTo(0.0f, f17);
        } else {
            path.moveTo(measuredWidth / 2, measuredHeight);
            path.lineTo(measuredWidth, 0.0f);
            path.lineTo(0.0f, 0.0f);
        }
        path.close();
        canvas.drawPath(path, paint);
    }
}
