package com.qzone.homepage.diy;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import jj2.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ShadowViewGroup extends FrameLayout {
    private float C;
    private float D;
    private float E;
    private Rect F;
    private ShapeDrawable G;

    /* renamed from: d, reason: collision with root package name */
    private float f47521d;

    /* renamed from: e, reason: collision with root package name */
    private float f47522e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f47523f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f47524h;

    /* renamed from: i, reason: collision with root package name */
    private Context f47525i;

    /* renamed from: m, reason: collision with root package name */
    private int f47526m;

    public ShadowViewGroup(Context context) {
        this(context, null);
    }

    private void a() {
        this.G = new ShapeDrawable(new OvalShape());
        this.f47523f = new Paint();
        this.G.getPaint().setStyle(Paint.Style.FILL);
        this.G.getPaint().setAntiAlias(true);
        this.G.getPaint().setColor(this.f47526m);
        this.G.getPaint().setShadowLayer(this.C, this.D, this.E, this.f47526m);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f47525i.obtainStyledAttributes(attributeSet, b.f410200s7);
        this.f47526m = obtainStyledAttributes.getColor(2, -16777216);
        this.C = obtainStyledAttributes.getDimension(3, 0.0f);
        this.D = obtainStyledAttributes.getDimension(4, 0.0f);
        this.E = obtainStyledAttributes.getDimension(5, 0.0f);
        this.f47521d = obtainStyledAttributes.getDimension(1, 0.0f);
        this.f47522e = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f47524h = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.recycle();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f47524h) {
            if (getLayerType() != 1) {
                setLayerType(1, null);
            }
            View childAt = getChildAt(0);
            this.F.left = childAt.getLeft();
            this.F.top = childAt.getTop();
            this.F.right = childAt.getRight();
            this.F.bottom = childAt.getBottom();
            this.G.setBounds(this.F);
            this.G.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public ShadowViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowViewGroup(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.F = new Rect();
        this.f47525i = context;
        b(attributeSet);
    }
}
