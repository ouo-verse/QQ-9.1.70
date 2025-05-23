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
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QbGroupNotificationDetailContainerLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f387459a;

    /* renamed from: b, reason: collision with root package name */
    public QUISecNavBar f387460b;

    /* renamed from: c, reason: collision with root package name */
    public View f387461c;

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
        context.getResources().getDisplayMetrics();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387459a = linearLayout;
        this.f387461c = linearLayout;
        linearLayout.setId(R.id.root);
        this.f387459a.setOrientation(1);
        d.e(this.f387459a);
        this.f387459a.setBackground(context.getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard_bg));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        QUISecNavBar qUISecNavBar = new QUISecNavBar(context, null);
        this.f387460b = qUISecNavBar;
        qUISecNavBar.setId(R.id.idz);
        this.f387459a.addView(this.f387460b, layoutParams);
        return this.f387459a;
    }

    public View u() {
        return this.f387461c;
    }
}
