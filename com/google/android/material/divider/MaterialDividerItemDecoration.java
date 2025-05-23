package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.internal.o;
import com.tencent.mobileqq.R;
import g1.c;
import w0.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MaterialDividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int E = 2131953465;
    private boolean C;
    private final Rect D;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private Drawable f33622d;

    /* renamed from: e, reason: collision with root package name */
    private int f33623e;

    /* renamed from: f, reason: collision with root package name */
    @ColorInt
    private int f33624f;

    /* renamed from: h, reason: collision with root package name */
    private int f33625h;

    /* renamed from: i, reason: collision with root package name */
    private int f33626i;

    /* renamed from: m, reason: collision with root package name */
    private int f33627m;

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, R.attr.av8, i3);
    }

    private void a(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        int height;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i3, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            i3 = 0;
        }
        int i16 = i3 + this.f33626i;
        int i17 = height - this.f33627m;
        int childCount = recyclerView.getChildCount();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = recyclerView.getChildAt(i18);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.D);
            int round = this.D.right + Math.round(childAt.getTranslationX());
            this.f33622d.setBounds((round - this.f33622d.getIntrinsicWidth()) - this.f33623e, i16, round, i17);
            this.f33622d.draw(canvas);
        }
        canvas.restore();
    }

    private void b(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        int width;
        int i3;
        int i16;
        int i17;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i3, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            i3 = 0;
        }
        boolean z16 = true;
        if (ViewCompat.getLayoutDirection(recyclerView) != 1) {
            z16 = false;
        }
        if (z16) {
            i16 = this.f33627m;
        } else {
            i16 = this.f33626i;
        }
        int i18 = i3 + i16;
        if (z16) {
            i17 = this.f33626i;
        } else {
            i17 = this.f33627m;
        }
        int i19 = width - i17;
        int childCount = recyclerView.getChildCount();
        if (!this.C) {
            childCount--;
        }
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt = recyclerView.getChildAt(i26);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.D);
            int round = this.D.bottom + Math.round(childAt.getTranslationY());
            this.f33622d.setBounds(i18, (round - this.f33622d.getIntrinsicHeight()) - this.f33623e, i19, round);
            this.f33622d.draw(canvas);
        }
        canvas.restore();
    }

    public void c(@ColorInt int i3) {
        this.f33624f = i3;
        Drawable wrap = DrawableCompat.wrap(this.f33622d);
        this.f33622d = wrap;
        DrawableCompat.setTint(wrap, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        rect.set(0, 0, 0, 0);
        if (this.f33625h == 1) {
            rect.bottom = this.f33622d.getIntrinsicHeight() + this.f33623e;
        } else {
            rect.right = this.f33622d.getIntrinsicWidth() + this.f33623e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (recyclerView.getLayoutManager() == null) {
            return;
        }
        if (this.f33625h == 1) {
            b(canvas, recyclerView);
        } else {
            a(canvas, recyclerView);
        }
    }

    public void setOrientation(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("Invalid orientation: " + i3 + ". It should be either HORIZONTAL or VERTICAL");
        }
        this.f33625h = i3;
    }

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        this.D = new Rect();
        TypedArray h16 = o.h(context, attributeSet, a.f443814a5, i3, E, new int[0]);
        this.f33624f = c.a(context, h16, a.f443826b5).getDefaultColor();
        this.f33623e = h16.getDimensionPixelSize(a.f443862e5, context.getResources().getDimensionPixelSize(R.dimen.f159135cp4));
        this.f33626i = h16.getDimensionPixelOffset(a.f443850d5, 0);
        this.f33627m = h16.getDimensionPixelOffset(a.f443838c5, 0);
        this.C = h16.getBoolean(a.f443874f5, true);
        h16.recycle();
        this.f33622d = new ShapeDrawable();
        c(this.f33624f);
        setOrientation(i16);
    }
}
