package com.tencent.mobileqq.guild.channel.manage;

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

/* compiled from: P */
/* loaded from: classes12.dex */
public class m extends RecyclerView.ItemDecoration {
    protected static final int[] F = {R.attr.listDivider};
    protected boolean C;
    protected boolean D;
    protected View E;

    /* renamed from: d, reason: collision with root package name */
    protected Paint f215116d;

    /* renamed from: e, reason: collision with root package name */
    protected Drawable f215117e;

    /* renamed from: f, reason: collision with root package name */
    protected int f215118f;

    /* renamed from: h, reason: collision with root package name */
    protected int f215119h;

    /* renamed from: i, reason: collision with root package name */
    protected int f215120i;

    /* renamed from: m, reason: collision with root package name */
    protected int f215121m;

    public m(Context context, int i3) {
        this.f215118f = 2;
        this.C = true;
        this.D = true;
        if (i3 != 1 && i3 != 0) {
            throw new IllegalArgumentException("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u53c2\u6570\uff01");
        }
        this.f215119h = i3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(F);
        this.f215117e = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    private int a(RecyclerView recyclerView) {
        if (!this.C) {
            return recyclerView.getChildCount() - 1;
        }
        return recyclerView.getChildCount();
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft() + this.f215120i;
        int measuredWidth = (recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight()) - this.f215121m;
        int a16 = a(recyclerView);
        int i3 = 0;
        if (!this.D && recyclerView.getChildAt(0) == this.E) {
            i3 = 1;
        }
        while (i3 < a16) {
            View childAt = recyclerView.getChildAt(i3);
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            int i16 = this.f215118f + bottom;
            Drawable drawable = this.f215117e;
            if (drawable != null) {
                drawable.setBounds(paddingLeft, bottom, measuredWidth, i16);
                this.f215117e.draw(canvas);
            }
            Paint paint = this.f215116d;
            if (paint != null) {
                canvas.drawRect(paddingLeft, bottom, measuredWidth, i16, paint);
            }
            i3++;
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int a16 = a(recyclerView);
        for (int i3 = 0; i3 < a16; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).rightMargin;
            int i16 = this.f215118f + right;
            Drawable drawable = this.f215117e;
            if (drawable != null) {
                drawable.setBounds(right, paddingTop, i16, measuredHeight);
                this.f215117e.draw(canvas);
            }
            Paint paint = this.f215116d;
            if (paint != null) {
                canvas.drawRect(right, paddingTop, i16, measuredHeight, paint);
            }
        }
    }

    public void b(int i3, int i16) {
        this.f215120i = i3;
        this.f215121m = i16;
    }

    public void c(boolean z16) {
        this.C = z16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, 0, 0, this.f215118f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.f215119h == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public m(Context context, int i3, int i16, int i17) {
        this(context, i3);
        this.f215118f = i16;
        Paint paint = new Paint(1);
        this.f215116d = paint;
        paint.setColor(i17);
        this.f215116d.setStyle(Paint.Style.FILL);
    }
}
