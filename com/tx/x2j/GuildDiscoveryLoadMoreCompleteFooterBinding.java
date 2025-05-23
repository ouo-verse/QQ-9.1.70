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
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildDiscoveryLoadMoreCompleteFooterBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public TextView f387256a;

    /* renamed from: b, reason: collision with root package name */
    public View f387257b;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 75.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 75.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 75.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 75.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 75.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 75.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 75.0f, displayMetrics) + 0.5f);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 75.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387257b = frameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 75.0f, displayMetrics) + 0.5f);
        TextView textView = new TextView(context, null);
        this.f387256a = textView;
        textView.setId(R.id.kbr);
        this.f387256a.setTextSize(0, (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f));
        this.f387256a.setText(resources.getString(R.string.f1502814k));
        this.f387256a.setGravity(17);
        this.f387256a.setTextColor(resources.getColor(R.color.guild_api_color_999999_5d6064));
        frameLayout.addView(this.f387256a, layoutParams);
        return frameLayout;
    }
}
