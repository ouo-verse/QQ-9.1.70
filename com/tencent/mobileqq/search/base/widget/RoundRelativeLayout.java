package com.tencent.mobileqq.search.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.av.utils.api.IUIToolsTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import jj2.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RoundRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f282816d;

    /* renamed from: e, reason: collision with root package name */
    private Path f282817e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f282818f;

    public RoundRelativeLayout(Context context) {
        super(context);
        this.f282816d = 16.0f;
        a(context, null);
    }

    private void b() {
        Path path = this.f282817e;
        RectF rectF = this.f282818f;
        float f16 = this.f282816d;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        QLog.i(com.tencent.state.view.RoundRelativeLayout.TAG, 2, "roundLayoutRadius " + this.f282816d);
    }

    public void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        this.f282816d = ((IUIToolsTempApi) QRoute.api(IUIToolsTempApi.class)).dp2px(getContext(), 16.0f);
        setWillNotDraw(false);
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.Z9)) != null) {
            this.f282816d = obtainStyledAttributes.getDimensionPixelSize(b.f409993aa, 0);
            obtainStyledAttributes.recycle();
        }
        this.f282817e = new Path();
        this.f282818f = new RectF();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f282816d > 0.0f && this.f282817e != null) {
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f282817e);
        }
        super.draw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        RectF rectF = this.f282818f;
        if (rectF == null) {
            return;
        }
        rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        b();
    }

    public void setRoundLayoutRadius(float f16) {
        this.f282816d = f16;
        b();
        postInvalidate();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f282816d = 16.0f;
        a(context, attributeSet);
    }
}
