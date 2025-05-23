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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.discovery.widget.GDiscoveryLoadingView;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildDiscoveryMineLoadingAndExceptionViewBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public FrameLayout f387258a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f387259b;

    /* renamed from: c, reason: collision with root package name */
    public GDiscoveryLoadingView f387260c;

    /* renamed from: d, reason: collision with root package name */
    public ScanningLightView f387261d;

    /* renamed from: e, reason: collision with root package name */
    public View f387262e;

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
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387258a = frameLayout;
        this.f387262e = frameLayout;
        frameLayout.setId(R.id.if5);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = (int) (TypedValue.applyDimension(1, 36.0f, displayMetrics) + 0.5f);
        FrameLayout frameLayout2 = new FrameLayout(context, null);
        this.f387259b = frameLayout2;
        frameLayout2.setId(R.id.w5e);
        this.f387258a.addView(this.f387259b, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.gravity = 17;
        GDiscoveryLoadingView gDiscoveryLoadingView = new GDiscoveryLoadingView(context, null);
        this.f387260c = gDiscoveryLoadingView;
        gDiscoveryLoadingView.setId(R.id.w4z);
        this.f387260c.setVisibility(8);
        this.f387258a.addView(this.f387260c, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.width = -1;
        layoutParams3.height = -1;
        ScanningLightView scanningLightView = new ScanningLightView(context, null);
        this.f387261d = scanningLightView;
        scanningLightView.setId(R.id.wxn);
        this.f387261d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f387261d.setVisibility(8);
        this.f387258a.addView(this.f387261d, layoutParams3);
        return this.f387258a;
    }

    public View u() {
        return this.f387262e;
    }
}
