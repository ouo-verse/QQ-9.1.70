package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioTopMaskBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public View f387192a;

    /* renamed from: b, reason: collision with root package name */
    public View f387193b;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 89.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 89.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 89.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 89.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 89.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 89.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 89.0f, displayMetrics) + 0.5f);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 89.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        context.getResources().getDisplayMetrics();
        View view = new View(context, null);
        this.f387192a = view;
        this.f387193b = view;
        view.setId(R.id.f166190yy0);
        d.e(this.f387192a);
        this.f387192a.setBackground(context.getResources().getDrawable(R.drawable.mna));
        return this.f387192a;
    }

    public View u() {
        return this.f387193b;
    }
}
