package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
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
import com.tencent.mobileqq.aio.widget.CommonTextView;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NotifyServiceTitleLeftInfoBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public RoundRectImageView f387444a;

    /* renamed from: b, reason: collision with root package name */
    public CommonTextView f387445b;

    /* renamed from: c, reason: collision with root package name */
    public CommonTextView f387446c;

    /* renamed from: d, reason: collision with root package name */
    public View f387447d;

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
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387447d = relativeLayout;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) (TypedValue.applyDimension(1, 32.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 32.0f, displayMetrics) + 0.5f);
        RoundRectImageView roundRectImageView = new RoundRectImageView(context, null);
        this.f387444a = roundRectImageView;
        roundRectImageView.setId(R.id.f166439zv2);
        this.f387444a.setImageDrawable(context.getResources().getDrawable(R.drawable.f160830com));
        relativeLayout.addView(this.f387444a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(6, R.id.f166439zv2);
        layoutParams2.addRule(1, R.id.f166439zv2);
        layoutParams2.leftMargin = (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f);
        CommonTextView commonTextView = new CommonTextView(context, null);
        this.f387445b = commonTextView;
        commonTextView.setId(R.id.f166440zv3);
        this.f387445b.setTextSize(0, (int) (TypedValue.applyDimension(2, 16.0f, displayMetrics) + 0.5f));
        this.f387445b.setEllipsize(TextUtils.TruncateAt.END);
        this.f387445b.setSingleLine(true);
        this.f387445b.setTextColor(resources.getColor(R.color.qui_common_text_nav_secondary_selector));
        relativeLayout.addView(this.f387445b, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(1, R.id.f166439zv2);
        layoutParams3.addRule(8, R.id.f166439zv2);
        layoutParams3.leftMargin = (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f);
        CommonTextView commonTextView2 = new CommonTextView(context, null);
        this.f387446c = commonTextView2;
        commonTextView2.setId(R.id.f166438zv1);
        this.f387446c.setTextSize(0, (int) (TypedValue.applyDimension(2, 10.0f, displayMetrics) + 0.5f));
        this.f387446c.setEllipsize(TextUtils.TruncateAt.END);
        this.f387446c.setSingleLine(true);
        this.f387446c.setTextColor(resources.getColor(R.color.qui_common_text_nav_secondary_selector));
        relativeLayout.addView(this.f387446c, layoutParams3);
        return relativeLayout;
    }
}
