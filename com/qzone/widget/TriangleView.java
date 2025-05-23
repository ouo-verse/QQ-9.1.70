package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
@Deprecated
/* loaded from: classes37.dex */
public class TriangleView extends View {

    /* renamed from: d, reason: collision with root package name */
    private int f60687d;

    /* renamed from: e, reason: collision with root package name */
    private int f60688e;

    public TriangleView(Context context) {
        super(context);
        this.f60687d = 1;
        BaseApplicationImpl.getApplication();
        this.f60688e = BaseApplication.getContext().getResources().getColor(R.color.g_);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.f60688e);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.f60687d == 1) {
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

    public void setDrawColor(int i3) {
        this.f60688e = i3;
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60687d = 1;
        BaseApplicationImpl.getApplication();
        this.f60688e = BaseApplication.getContext().getResources().getColor(R.color.g_);
    }

    public TriangleView(Context context, int i3, int i16) {
        super(context);
        this.f60687d = 1;
        BaseApplicationImpl.getApplication();
        BaseApplication.getContext().getResources().getColor(R.color.g_);
        this.f60687d = i3;
        this.f60688e = i16;
    }
}
