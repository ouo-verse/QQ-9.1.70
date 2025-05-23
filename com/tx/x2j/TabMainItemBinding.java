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
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TabMainItemBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public View f387527a;

    /* renamed from: b, reason: collision with root package name */
    public TabDragAnimationView f387528b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387529c;

    /* renamed from: d, reason: collision with root package name */
    public QUIBadge f387530d;

    /* renamed from: e, reason: collision with root package name */
    public View f387531e;

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
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387531e = relativeLayout;
        relativeLayout.setClipChildren(false);
        relativeLayout.setClipToPadding(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) (TypedValue.applyDimension(1, 1.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 54.0f, displayMetrics) + 0.5f);
        layoutParams.addRule(6, R.id.j_k);
        layoutParams.addRule(14, -1);
        View view = new View(context, null);
        this.f387527a = view;
        view.setId(R.id.kmv);
        this.f387527a.setVisibility(4);
        relativeLayout.addView(this.f387527a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.addRule(12, -1);
        TabDragAnimationView tabDragAnimationView = new TabDragAnimationView(context, null);
        this.f387528b = tabDragAnimationView;
        tabDragAnimationView.setId(R.id.j_k);
        this.f387528b.setPadding(0, (int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f), 0, 0);
        this.f387528b.setLogoGravity(1);
        this.f387528b.setLogoHeight((int) (TypedValue.applyDimension(1, 29.0f, displayMetrics) + 0.5f));
        this.f387528b.setLogoWidth((int) (TypedValue.applyDimension(1, 29.0f, displayMetrics) + 0.5f));
        relativeLayout.addView(this.f387528b, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(12, -1);
        layoutParams3.addRule(14, -1);
        layoutParams3.bottomMargin = (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f);
        TextView textView = new TextView(context, null);
        this.f387529c = textView;
        textView.setId(R.id.kbi);
        this.f387529c.setTextSize(0, (int) resources.getDimension(R.dimen.de7));
        this.f387529c.setTextColor(resources.getColor(R.color.f157982ai1));
        relativeLayout.addView(this.f387529c, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(6, R.id.j_k);
        layoutParams4.addRule(1, R.id.kmv);
        layoutParams4.leftMargin = (int) (TypedValue.applyDimension(0, 5.0f, displayMetrics) + 0.5f);
        layoutParams4.topMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        QUIBadge qUIBadge = new QUIBadge(context, null);
        this.f387530d = qUIBadge;
        qUIBadge.setId(R.id.khc);
        this.f387530d.setVisibility(8);
        relativeLayout.addView(this.f387530d, layoutParams4);
        return relativeLayout;
    }
}
