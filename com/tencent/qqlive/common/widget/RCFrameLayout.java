package com.tencent.qqlive.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RCFrameLayout extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f345217i = {"OPPO", "MEIZU"};

    /* renamed from: d, reason: collision with root package name */
    private int f345218d;

    /* renamed from: e, reason: collision with root package name */
    private final Path f345219e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f345220f;

    /* renamed from: h, reason: collision with root package name */
    private float[] f345221h;

    public RCFrameLayout(@NonNull Context context) {
        super(context);
        this.f345218d = 4;
        this.f345219e = new Path();
        this.f345220f = new RectF();
        b();
    }

    private void a() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            float f16 = (int) (this.f345218d * displayMetrics.scaledDensity);
            this.f345221h = new float[]{f16, f16, f16, f16, 0.0f, 0.0f, 0.0f, 0.0f};
        }
    }

    private void b() {
        a();
    }

    private boolean c() {
        String str = Build.MANUFACTURER;
        int i3 = 0;
        while (true) {
            String[] strArr = f345217i;
            if (i3 >= strArr.length) {
                return false;
            }
            if (strArr[i3].contains(str.toUpperCase())) {
                return true;
            }
            i3++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (c()) {
            super.dispatchDraw(canvas);
            return;
        }
        this.f345220f.right = getMeasuredWidth();
        this.f345220f.bottom = getMeasuredHeight();
        this.f345219e.addRoundRect(this.f345220f, this.f345221h, Path.Direction.CCW);
        canvas.clipPath(this.f345219e, Region.Op.INTERSECT);
        super.dispatchDraw(canvas);
    }

    public void setConnerSize(int i3) {
        this.f345218d = i3;
        a();
    }

    public RCFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f345218d = 4;
        this.f345219e = new Path();
        this.f345220f = new RectF();
        b();
    }

    public RCFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
        this.f345218d = 4;
        this.f345219e = new Path();
        this.f345220f = new RectF();
        b();
    }
}
