package com.qzone.component.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.qzone.util.ar;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BannerAutoVideoViewWrapper extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private Path f46300d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f46301e;

    /* renamed from: f, reason: collision with root package name */
    private int f46302f;

    /* renamed from: h, reason: collision with root package name */
    private int f46303h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f46304i;

    public BannerAutoVideoViewWrapper(Context context) {
        super(context);
    }

    private boolean a() {
        return true;
    }

    private void b(Canvas canvas) {
        this.f46303h = canvas.save();
        canvas.clipPath(this.f46300d, Region.Op.INTERSECT);
    }

    private void c(Canvas canvas) {
        canvas.restoreToCount(this.f46303h);
    }

    private void d() {
        this.f46300d = new Path();
        this.f46301e = new RectF();
        e(ar.e(4.0f));
    }

    private void e(int i3) {
        this.f46302f = i3;
        f();
    }

    private void f() {
        this.f46300d.reset();
        float[] fArr = this.f46304i;
        if (fArr != null && fArr.length == 8) {
            if (fArr.length == 8) {
                this.f46300d.addRoundRect(this.f46301e, fArr, Path.Direction.CCW);
            }
        } else {
            Path path = this.f46300d;
            RectF rectF = this.f46301e;
            int i3 = this.f46302f;
            path.addRoundRect(rectF, i3, i3, Path.Direction.CCW);
        }
    }

    private void g(int i3, int i16) {
        RectF rectF = this.f46301e;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = i3;
        rectF.bottom = i16;
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (a()) {
            b(canvas);
            super.dispatchDraw(canvas);
            c(canvas);
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        g(i3, i16);
        super.onSizeChanged(i3, i16, i17, i18);
    }

    public void setCorners(float[] fArr) {
        this.f46304i = fArr;
    }

    public BannerAutoVideoViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }
}
