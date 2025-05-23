package com.qzone.widget.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ColorfulCardView extends CardView {
    private final String[][] F;
    private int G;
    private int H;
    private Paint I;
    private boolean J;

    public ColorfulCardView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.G == -1 || this.H == -1) {
            return;
        }
        QLog.d("ColorfulCardView", 2, "mColorStart : " + this.G + "mColorEnd:" + this.H);
        float f16 = (float) width;
        float f17 = (float) height;
        this.I.setShader(new LinearGradient(0.0f, 0.0f, f16, f17, new int[]{this.G, this.H}, (float[]) null, Shader.TileMode.CLAMP));
        canvas.drawRect(0.0f, 0.0f, f16, f17, this.I);
        if (this.J) {
            canvas.save();
            canvas.drawColor(getContext().getResources().getColor(R.color.f156806bu));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.J = true;
            invalidate();
        } else if (action == 1 || action == 3) {
            this.J = false;
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setColor(int i3, int i16) {
        this.G = e(i3);
        this.H = e(i16);
        postInvalidate();
    }

    public void setColorRadom() {
        int nextInt = new Random().nextInt(this.F.length);
        this.G = Color.parseColor(this.F[nextInt][0]);
        this.H = Color.parseColor(this.F[nextInt][1]);
        postInvalidate();
    }

    public ColorfulCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorfulCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.F = new String[][]{new String[]{"#26E7FC", "#05C9FA"}, new String[]{"#17E6D4", "#00CCBB"}, new String[]{"#FFB973", "#FF8F40"}, new String[]{"#26E7FC", "#05C9FA"}, new String[]{"#9F8CFF", "#7064F9"}};
        this.G = -1;
        this.H = -1;
        this.I = new Paint();
        this.J = false;
    }

    public void setColor(String str) {
        this.G = Color.parseColor(str);
        this.H = Color.parseColor(str);
        postInvalidate();
    }

    public int e(int i3) {
        return Color.rgb((16711680 & i3) >> 16, (65280 & i3) >> 8, i3 & 255);
    }
}
