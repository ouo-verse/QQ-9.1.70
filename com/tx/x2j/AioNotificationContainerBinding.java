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
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.notification.background.AIONotificationBlurView;
import com.tencent.mobileqq.aio.notification.list.AIONotificationScrollLayout;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioNotificationContainerBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public View f387054a;

    /* renamed from: b, reason: collision with root package name */
    public AIONotificationScrollLayout f387055b;

    /* renamed from: c, reason: collision with root package name */
    public AIONotificationBlurView f387056c;

    /* renamed from: d, reason: collision with root package name */
    public RelativeLayout f387057d;

    /* renamed from: e, reason: collision with root package name */
    public RecyclerView f387058e;

    /* renamed from: f, reason: collision with root package name */
    public NestedScrollView f387059f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f387060g;

    /* renamed from: h, reason: collision with root package name */
    public View f387061h;

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
        this.f387061h = frameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -1;
        View view = new View(context, null);
        this.f387054a = view;
        view.setId(R.id.gm7);
        this.f387054a.setVisibility(8);
        d.e(this.f387054a);
        this.f387054a.setBackground(context.getResources().getDrawable(R.drawable.mlz));
        frameLayout.addView(this.f387054a, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        AIONotificationScrollLayout aIONotificationScrollLayout = new AIONotificationScrollLayout(context, null);
        this.f387055b = aIONotificationScrollLayout;
        aIONotificationScrollLayout.setId(R.id.sj_);
        frameLayout.addView(this.f387055b, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.width = -1;
        layoutParams3.height = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        AIONotificationBlurView aIONotificationBlurView = new AIONotificationBlurView(context, null);
        this.f387056c = aIONotificationBlurView;
        aIONotificationBlurView.setId(R.id.t97);
        this.f387056c.setVisibility(8);
        this.f387055b.addView(this.f387056c, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.width = -1;
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387057d = relativeLayout;
        relativeLayout.setId(R.id.sj5);
        this.f387057d.setVisibility(0);
        this.f387055b.addView(this.f387057d, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.width = -1;
        layoutParams5.height = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        RecyclerView recyclerView = new RecyclerView(context, null);
        this.f387058e = recyclerView;
        recyclerView.setId(R.id.sj9);
        this.f387058e.setClipChildren(false);
        this.f387058e.setClipToPadding(false);
        this.f387057d.addView(this.f387058e, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.width = -1;
        layoutParams6.addRule(12, -1);
        NestedScrollView nestedScrollView = new NestedScrollView(context, null);
        this.f387059f = nestedScrollView;
        nestedScrollView.setId(R.id.sj8);
        this.f387059f.setVisibility(8);
        this.f387057d.addView(this.f387059f, layoutParams6);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams7.width = -1;
        layoutParams7.height = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387060g = imageView;
        imageView.setId(R.id.sj7);
        this.f387060g.setScaleType(ImageView.ScaleType.CENTER);
        this.f387060g.setImageDrawable(context.getResources().getDrawable(R.drawable.f160153mm4));
        this.f387060g.setPadding(0, (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        this.f387059f.addView(this.f387060g, layoutParams7);
        return frameLayout;
    }

    public View u() {
        return this.f387061h;
    }
}
