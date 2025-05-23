package com.tencent.icgame.common.widget;

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
/* loaded from: classes7.dex */
public class RCFrameLayout extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f114871i = {"OPPO", "MEIZU"};

    /* renamed from: d, reason: collision with root package name */
    private int f114872d;

    /* renamed from: e, reason: collision with root package name */
    private final Path f114873e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f114874f;

    /* renamed from: h, reason: collision with root package name */
    private float[] f114875h;

    public RCFrameLayout(@NonNull Context context) {
        super(context);
        this.f114872d = 4;
        this.f114873e = new Path();
        this.f114874f = new RectF();
        b();
    }

    private void a() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            float f16 = (int) (this.f114872d * displayMetrics.scaledDensity);
            this.f114875h = new float[]{f16, f16, f16, f16, 0.0f, 0.0f, 0.0f, 0.0f};
        }
    }

    private void b() {
        a();
    }

    private boolean c() {
        String str = Build.MANUFACTURER;
        int i3 = 0;
        while (true) {
            String[] strArr = f114871i;
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
        this.f114874f.right = getMeasuredWidth();
        this.f114874f.bottom = getMeasuredHeight();
        this.f114873e.addRoundRect(this.f114874f, this.f114875h, Path.Direction.CCW);
        canvas.clipPath(this.f114873e, Region.Op.INTERSECT);
        super.dispatchDraw(canvas);
    }

    public void setConnerSize(int i3) {
        this.f114872d = i3;
        a();
    }

    public RCFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f114872d = 4;
        this.f114873e = new Path();
        this.f114874f = new RectF();
        b();
    }

    public RCFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
        this.f114872d = 4;
        this.f114873e = new Path();
        this.f114874f = new RectF();
        b();
    }
}
