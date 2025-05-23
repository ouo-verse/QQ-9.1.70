package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.R;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class UnderlineTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private Rect f316497d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f316498e;

    /* renamed from: f, reason: collision with root package name */
    private float f316499f;

    public UnderlineTextView(Context context) {
        this(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i3) {
        float f16 = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UnderlineTextView, i3, 0);
        int color = obtainStyledAttributes.getColor(R.styleable.UnderlineTextView_underedlineColor, SupportMenu.CATEGORY_MASK);
        this.f316499f = obtainStyledAttributes.getDimension(R.styleable.UnderlineTextView_underedlineWidth, f16 * 2.0f);
        obtainStyledAttributes.recycle();
        this.f316497d = new Rect();
        Paint paint = new Paint();
        this.f316498e = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f316498e.setColor(color);
        this.f316498e.setStrokeWidth(this.f316499f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int lineCount = getLineCount();
        Layout layout = getLayout();
        for (int i3 = 0; i3 < lineCount; i3++) {
            try {
                int lineBounds = getLineBounds(i3, this.f316497d);
                int lineStart = layout.getLineStart(i3);
                int lineEnd = layout.getLineEnd(i3);
                float primaryHorizontal = layout.getPrimaryHorizontal(lineStart);
                float f16 = lineBounds;
                canvas.drawLine(primaryHorizontal + getPaddingLeft(), this.f316499f + f16 + 15.0f, layout.getPrimaryHorizontal(lineEnd - 1) + (layout.getPrimaryHorizontal(lineStart + 1) - primaryHorizontal) + getPaddingLeft(), f16 + this.f316499f + 15.0f, this.f316498e);
            } catch (Exception e16) {
                QZLog.e("UnderlineTextView", "" + e16);
                return;
            }
        }
    }

    public void setUnderLineColor(int i3) {
        this.f316498e.setColor(i3);
        invalidate();
    }

    public void setUnderlineWidth(float f16) {
        this.f316499f = f16;
        invalidate();
    }

    public UnderlineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnderlineTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context, attributeSet, i3);
    }
}
