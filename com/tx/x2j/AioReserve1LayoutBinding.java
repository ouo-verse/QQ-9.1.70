package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import ty4.a;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioReserve1LayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public ConstraintLayout f387116a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f387117b;

    /* renamed from: c, reason: collision with root package name */
    public ViewStub f387118c;

    /* renamed from: d, reason: collision with root package name */
    public View f387119d;

    /* renamed from: e, reason: collision with root package name */
    public View f387120e;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f387116a = constraintLayout;
        this.f387120e = constraintLayout;
        constraintLayout.setId(R.id.sjn);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.validate();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387117b = frameLayout;
        frameLayout.setId(R.id.f100035re);
        this.f387116a.addView(this.f387117b, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
        layoutParams2.bottomToBottom = R.id.slg;
        layoutParams2.startToStart = 0;
        layoutParams2.endToEnd = 0;
        layoutParams2.validate();
        ViewStub viewStub = new ViewStub(context, (AttributeSet) null);
        this.f387118c = viewStub;
        viewStub.setLayoutResource(R.layout.f169178i42);
        this.f387118c.setLayoutInflater(new a(this.f387118c.getContext(), new ViewstubFramelayoutBinding()));
        this.f387118c.setId(R.id.tid);
        this.f387118c.setInflatedId(R.id.tid);
        this.f387116a.addView(this.f387118c, layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) (TypedValue.applyDimension(1, 1.0f, displayMetrics) + 0.5f);
        layoutParams3.verticalBias = 1.0f;
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) (TypedValue.applyDimension(1, 1.0f, displayMetrics) + 0.5f);
        layoutParams3.bottomToBottom = 0;
        layoutParams3.topToTop = 0;
        layoutParams3.startToStart = 0;
        layoutParams3.endToEnd = 0;
        layoutParams3.validate();
        View view = new View(context, null);
        this.f387119d = view;
        view.setId(R.id.slg);
        this.f387116a.addView(this.f387119d, layoutParams3);
        return this.f387116a;
    }

    public View u() {
        return this.f387120e;
    }
}
