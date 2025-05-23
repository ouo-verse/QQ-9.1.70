package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
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
import com.tencent.qqnt.aio.holder.template.TemplateLayout;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioTofuTemplateLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public TemplateLayout f387188a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f387189b;

    /* renamed from: c, reason: collision with root package name */
    public FrameLayout f387190c;

    /* renamed from: d, reason: collision with root package name */
    public View f387191d;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        resources.getDisplayMetrics();
        TemplateLayout templateLayout = new TemplateLayout(context, null);
        this.f387188a = templateLayout;
        this.f387191d = templateLayout;
        templateLayout.setId(R.id.root);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.validate();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387189b = frameLayout;
        frameLayout.setId(R.id.f99275pc);
        this.f387188a.addView(this.f387189b, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
        layoutParams2.topToBottom = R.id.f99275pc;
        layoutParams2.startToStart = 0;
        layoutParams2.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) resources.getDimension(R.dimen.bzt);
        layoutParams2.validate();
        FrameLayout frameLayout2 = new FrameLayout(context, null);
        this.f387190c = frameLayout2;
        frameLayout2.setId(R.id.f99265pb);
        this.f387188a.addView(this.f387190c, layoutParams2);
        return this.f387188a;
    }

    public View u() {
        return this.f387191d;
    }
}
