package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class PerfRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.fpsreport.a f315957d;

    public PerfRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        com.tencent.mobileqq.fpsreport.a aVar = this.f315957d;
        if (aVar != null) {
            aVar.onDrawComplete();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("PerfRelativeLayout", 4, "dispatchDraw, " + this.f315957d);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        com.tencent.mobileqq.fpsreport.a aVar = this.f315957d;
        if (aVar != null) {
            aVar.onDrawComplete();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("PerfRelativeLayout", 4, "draw, " + this.f315957d);
        }
    }

    public void setOnDrawCompleteListener(com.tencent.mobileqq.fpsreport.a aVar) {
        this.f315957d = aVar;
    }

    public PerfRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PerfRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
