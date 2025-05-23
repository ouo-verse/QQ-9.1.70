package com.qzone.reborn.feedx.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g extends RecyclerView.ItemDecoration {
    protected static final int[] E = {R.attr.listDivider};
    protected boolean C;
    protected boolean D;

    /* renamed from: d, reason: collision with root package name */
    protected Paint f56107d;

    /* renamed from: e, reason: collision with root package name */
    protected Drawable f56108e;

    /* renamed from: f, reason: collision with root package name */
    protected int f56109f;

    /* renamed from: h, reason: collision with root package name */
    protected int f56110h;

    /* renamed from: i, reason: collision with root package name */
    protected int f56111i;

    /* renamed from: m, reason: collision with root package name */
    protected int f56112m;

    public g(Context context, int i3) {
        this.f56109f = 2;
        this.C = true;
        this.D = false;
        if (i3 != 1 && i3 != 0) {
            RFWLog.fatal("QZoneRecycleViewDivider", 1, new IllegalArgumentException("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u53c2\u6570\uff01"));
        }
        this.f56110h = i3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(E);
        this.f56108e = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int a16 = a(recyclerView);
        for (int i3 = 0; i3 < a16; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            if (c(childAt)) {
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).rightMargin;
                int i16 = this.f56109f + right;
                Drawable drawable = this.f56108e;
                if (drawable != null) {
                    drawable.setBounds(right, paddingTop, i16, measuredHeight);
                    this.f56108e.draw(canvas);
                }
                Paint paint = this.f56107d;
                if (paint != null) {
                    canvas.drawRect(right, paddingTop, i16, measuredHeight, paint);
                }
            }
        }
    }

    protected int a(RecyclerView recyclerView) {
        if (!this.C && !this.D) {
            return recyclerView.getChildCount() - 1;
        }
        return recyclerView.getChildCount();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean b(View view) {
        return (view instanceof de.c) && ((de.c) view).j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean c(View view) {
        return (view instanceof de.c) && ((de.c) view).Q();
    }

    public void d(int i3, int i16) {
        this.f56111i = i3;
        this.f56112m = i16;
    }

    public void e(boolean z16) {
        this.D = z16;
    }

    public void f(boolean z16) {
        this.C = z16;
    }

    public void g(int i3) {
        this.f56107d.setColor(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (c(view)) {
            if (this.D) {
                rect.set(0, this.f56109f, 0, 0);
                return;
            } else {
                rect.set(0, 0, 0, this.f56109f);
                return;
            }
        }
        rect.set(0, 0, 0, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.f56110h == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int i3;
        int paddingLeft = recyclerView.getPaddingLeft() + this.f56111i;
        int measuredWidth = (recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight()) - this.f56112m;
        int a16 = a(recyclerView);
        for (int i16 = 0; i16 < a16; i16++) {
            View childAt = recyclerView.getChildAt(i16);
            if (c(childAt) && ((i3 = i16 + 1) >= recyclerView.getChildCount() || !b(recyclerView.getChildAt(i3)))) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int i17 = this.f56109f + bottom;
                if (this.D) {
                    int top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    int i18 = this.f56109f;
                    bottom = top - i18;
                    i17 = bottom + i18;
                }
                Drawable drawable = this.f56108e;
                if (drawable != null) {
                    drawable.setBounds(paddingLeft, bottom, measuredWidth, i17);
                    this.f56108e.draw(canvas);
                }
                Paint paint = this.f56107d;
                if (paint != null) {
                    canvas.drawRect(paddingLeft, bottom, measuredWidth, i17, paint);
                }
            }
        }
    }

    public g(Context context, int i3, int i16, int i17) {
        this(context, i3);
        this.f56109f = i16;
        Paint paint = new Paint(1);
        this.f56107d = paint;
        paint.setColor(i17);
        this.f56107d.setStyle(Paint.Style.FILL);
    }
}
