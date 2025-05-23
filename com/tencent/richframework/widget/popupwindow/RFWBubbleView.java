package com.tencent.richframework.widget.popupwindow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWBubbleView extends FrameLayout {
    private int mArrowOffsetX;
    private int mArrowOffsetY;
    private int mArrowPosition;
    private int mArrowSize;
    private final Paint mBoundPaint;
    private int mBubbleColor;
    private int[] mBubbleGradientColor;
    private Path mBubblePath;
    private float mCornerRadius;
    private boolean mEnableBound;
    private final Paint mPaint;

    public RFWBubbleView(@NonNull Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mBoundPaint = new Paint();
        setWillNotDraw(false);
        configDefault();
    }

    private void appendArrowPath() {
        int i3 = this.mArrowPosition;
        if (i3 != 1 && i3 != 0) {
            if (i3 == 3 || i3 == 2) {
                appendVerticalArrowPath();
                return;
            }
            return;
        }
        appendHorizontalArrowPath();
    }

    private void appendCornerPath() {
        if (this.mBubblePath == null) {
            this.mBubblePath = new Path();
        }
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        Path path = new Path();
        float f16 = this.mCornerRadius;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        this.mBubblePath.op(path, Path.Op.UNION);
    }

    private void appendHorizontalArrowPath() {
        int paddingTop;
        int i3;
        if (this.mBubblePath == null) {
            this.mBubblePath = new Path();
        }
        int paddingLeft = getPaddingLeft() + this.mArrowSize + this.mArrowOffsetX;
        double sqrt = Math.sqrt(2.0d);
        float f16 = (float) ((r3 / 3.0f) / sqrt);
        float f17 = this.mArrowSize - f16;
        if (this.mArrowPosition == 0) {
            paddingTop = getHeight() - getPaddingBottom();
        } else {
            paddingTop = getPaddingTop();
        }
        int i16 = this.mArrowPosition;
        if (i16 != 0) {
            f17 = -f17;
        }
        if (i16 == 0) {
            i3 = this.mArrowSize;
        } else {
            i3 = -this.mArrowSize;
        }
        float f18 = paddingTop;
        this.mBubblePath.moveTo(paddingLeft - this.mArrowSize, f18);
        float f19 = paddingLeft;
        float f26 = f17 + f18;
        this.mBubblePath.lineTo(f19 - f16, f26);
        this.mBubblePath.quadTo(f19, i3 + f18, f16 + f19, f26);
        this.mBubblePath.lineTo(paddingLeft + this.mArrowSize, f18);
    }

    private void appendVerticalArrowPath() {
        int paddingLeft;
        int i3;
        if (this.mBubblePath == null) {
            this.mBubblePath = new Path();
        }
        int paddingTop = getPaddingTop() + this.mArrowSize + this.mArrowOffsetY;
        double sqrt = Math.sqrt(2.0d);
        float f16 = (float) ((r3 / 3.0f) / sqrt);
        float f17 = this.mArrowSize - f16;
        if (this.mArrowPosition == 2) {
            paddingLeft = getWidth() - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int i16 = this.mArrowPosition;
        if (i16 != 2) {
            f17 = -f17;
        }
        if (i16 == 2) {
            i3 = this.mArrowSize;
        } else {
            i3 = -this.mArrowSize;
        }
        float f18 = paddingLeft;
        this.mBubblePath.moveTo(f18, this.mArrowSize + paddingTop);
        float f19 = f17 + f18;
        float f26 = paddingTop;
        this.mBubblePath.lineTo(f19, f26 + f16);
        this.mBubblePath.quadTo(i3 + f18, f26, f19, f26 - f16);
        this.mBubblePath.lineTo(f18, paddingTop - this.mArrowSize);
    }

    private void configDefault() {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(0);
        this.mCornerRadius = DisplayUtil.dip2px(getContext(), 4.0f);
        this.mArrowSize = DisplayUtil.dip2px(getContext(), 6.0f);
    }

    private Path createBubblePath() {
        Path path = this.mBubblePath;
        if (path != null) {
            return path;
        }
        this.mBubblePath = new Path();
        appendArrowPath();
        appendCornerPath();
        this.mBubblePath.close();
        return this.mBubblePath;
    }

    private void initGradientShader(int i3, int i16) {
        if (this.mBubbleGradientColor == null) {
            return;
        }
        this.mPaint.setColor(-1);
        this.mPaint.setShader(new LinearGradient(0.0f, 0.0f, i3, i16, this.mBubbleGradientColor, (float[]) null, Shader.TileMode.CLAMP));
    }

    public int getArrowWidth() {
        return this.mArrowSize * 2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(createBubblePath(), this.mPaint);
        if (this.mEnableBound) {
            canvas.drawPath(createBubblePath(), this.mBoundPaint);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        initGradientShader(i3, i16);
    }

    public void setArrowOffsetX(int i3) {
        if (this.mArrowOffsetX == i3) {
            return;
        }
        float measuredWidth = ((getMeasuredWidth() - getPaddingEnd()) - getArrowWidth()) - getPaddingStart();
        float f16 = this.mCornerRadius;
        float f17 = measuredWidth - f16;
        float f18 = i3;
        if (f18 < f16) {
            this.mArrowOffsetX = (int) f16;
        } else if (f18 > f17) {
            this.mArrowOffsetX = (int) f17;
        } else {
            this.mArrowOffsetX = i3;
        }
        this.mBubblePath = null;
        invalidate();
    }

    public void setArrowOffsetY(int i3) {
        if (this.mArrowOffsetY == i3) {
            return;
        }
        float measuredHeight = ((getMeasuredHeight() - getPaddingTop()) - getArrowWidth()) - getPaddingBottom();
        float f16 = this.mCornerRadius;
        float f17 = measuredHeight - f16;
        float f18 = i3;
        if (f18 < f16) {
            this.mArrowOffsetY = (int) f16;
        } else if (f18 > f17) {
            this.mArrowOffsetY = (int) f17;
        } else {
            this.mArrowOffsetY = i3;
        }
        this.mBubblePath = null;
        invalidate();
    }

    public void setArrowPosition(int i3) {
        this.mArrowPosition = i3;
    }

    public void setBubbleColor(int i3) {
        if (i3 == this.mBubbleColor) {
            return;
        }
        this.mBubbleColor = i3;
        this.mPaint.setColor(i3);
        invalidate();
    }

    public void setBubbleColors(int[] iArr) {
        this.mBubbleGradientColor = iArr;
    }

    public void setEnableBound(boolean z16) {
        this.mEnableBound = z16;
        if (z16) {
            this.mBoundPaint.setStyle(Paint.Style.STROKE);
            this.mBoundPaint.setStrokeWidth(2.0f);
            this.mBoundPaint.setColor(getResources().getColor(R.color.cow));
        }
    }

    public void setEnableShadow(boolean z16) {
        if (z16) {
            this.mPaint.setShadowLayer(12.0f, 0.0f, 4.0f, getResources().getColor(R.color.cox));
        } else {
            this.mPaint.clearShadowLayer();
        }
    }

    public RFWBubbleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.mBoundPaint = new Paint();
        setWillNotDraw(false);
        configDefault();
    }
}
