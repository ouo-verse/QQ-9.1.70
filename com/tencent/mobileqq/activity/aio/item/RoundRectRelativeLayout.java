package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RoundRectRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f179426d;

    /* renamed from: e, reason: collision with root package name */
    private int f179427e;

    /* renamed from: f, reason: collision with root package name */
    private int f179428f;

    /* renamed from: h, reason: collision with root package name */
    private int f179429h;

    /* renamed from: i, reason: collision with root package name */
    private Path f179430i;

    public RoundRectRelativeLayout(Context context) {
        super(context);
        this.f179429h = 0;
    }

    private void a() {
        Path path = new Path();
        this.f179430i = path;
        int i3 = this.f179426d;
        if (i3 == 0) {
            path.addRect(0.0f, 0.0f, this.f179427e, this.f179428f, Path.Direction.CCW);
            return;
        }
        float min = Math.min(i3 * 2, Math.min(this.f179427e, this.f179428f)) / 2;
        this.f179430i.addRoundRect(new RectF(0.0f, 0.0f, this.f179427e, this.f179428f), min, min, Path.Direction.CCW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Integer num;
        if (this.f179430i != null) {
            num = Integer.valueOf(canvas.save());
            canvas.clipPath(this.f179430i);
        } else {
            num = null;
        }
        canvas.drawColor(this.f179429h);
        super.dispatchDraw(canvas);
        if (num != null) {
            canvas.restoreToCount(num.intValue());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int width = getWidth();
        int height = getHeight();
        if (width == this.f179427e && height == this.f179428f) {
            return;
        }
        this.f179427e = width;
        this.f179428f = height;
        a();
    }

    public void setBgColor(int i3) {
        if (this.f179429h == i3) {
            return;
        }
        this.f179429h = i3;
        invalidate();
    }

    public void setAllRadius(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        if (this.f179426d == i3) {
            return;
        }
        this.f179426d = i3;
        a();
        invalidate();
    }
}
