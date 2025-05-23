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
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.TroopNotificationTabBar;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QbGroupHistoryNotificationLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f387453a;

    /* renamed from: b, reason: collision with root package name */
    public QUISecNavBar f387454b;

    /* renamed from: c, reason: collision with root package name */
    public TroopNotificationTabBar f387455c;

    /* renamed from: d, reason: collision with root package name */
    public FrameLayout f387456d;

    /* renamed from: e, reason: collision with root package name */
    public ViewPager2 f387457e;

    /* renamed from: f, reason: collision with root package name */
    public View f387458f;

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
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387453a = linearLayout;
        this.f387458f = linearLayout;
        linearLayout.setId(R.id.root);
        this.f387453a.setOrientation(1);
        d.e(this.f387453a);
        this.f387453a.setBackground(context.getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard_bg));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        QUISecNavBar qUISecNavBar = new QUISecNavBar(context, null);
        this.f387454b = qUISecNavBar;
        qUISecNavBar.setId(R.id.idz);
        d.e(this.f387454b);
        this.f387454b.setBackground(context.getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg));
        this.f387453a.addView(this.f387454b, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.height = (int) (TypedValue.applyDimension(1, 56.0f, displayMetrics) + 0.5f);
        TroopNotificationTabBar troopNotificationTabBar = new TroopNotificationTabBar(context, null);
        this.f387455c = troopNotificationTabBar;
        troopNotificationTabBar.setId(R.id.f10329608);
        d.e(this.f387455c);
        this.f387455c.setBackground(context.getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg));
        this.f387453a.addView(this.f387455c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = -1;
        layoutParams3.height = -1;
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387456d = frameLayout;
        frameLayout.setId(R.id.f103115zq);
        d.e(this.f387456d);
        this.f387456d.setBackground(context.getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg));
        this.f387453a.addView(this.f387456d, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.width = -1;
        layoutParams4.height = -1;
        ViewPager2 viewPager2 = new ViewPager2(context, null);
        this.f387457e = viewPager2;
        viewPager2.setId(R.id.f1034260k);
        this.f387456d.addView(this.f387457e, layoutParams4);
        return this.f387453a;
    }

    public View u() {
        return this.f387458f;
    }
}
