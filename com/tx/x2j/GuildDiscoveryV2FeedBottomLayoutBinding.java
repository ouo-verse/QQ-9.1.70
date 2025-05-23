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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildDiscoveryV2FeedBottomLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public RoundImageView f387265a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f387266b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387267c;

    /* renamed from: d, reason: collision with root package name */
    public View f387268d;

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
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f387268d = constraintLayout;
        constraintLayout.setClipToPadding(false);
        int dimension = (int) resources.getDimension(R.dimen.f158700mp);
        constraintLayout.setPadding(dimension, dimension, dimension, dimension);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) resources.getDimension(R.dimen.c9y);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) resources.getDimension(R.dimen.c9y);
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.validate();
        RoundImageView roundImageView = new RoundImageView(context, null);
        this.f387265a = roundImageView;
        roundImageView.setId(R.id.f165469w54);
        this.f387265a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f387265a.setRadius((int) resources.getDimension(R.dimen.f158716n6));
        constraintLayout.addView(this.f387265a, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.matchConstraintDefaultWidth = 1;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams2.bottomToBottom = R.id.f165469w54;
        layoutParams2.topToTop = R.id.f165469w54;
        layoutParams2.horizontalBias = 0.0f;
        layoutParams2.endToEnd = 0;
        layoutParams2.startToEnd = R.id.f165469w54;
        layoutParams2.setMarginStart((int) resources.getDimension(R.dimen.f158720na));
        layoutParams2.setMarginEnd((int) resources.getDimension(R.dimen.f158720na));
        layoutParams2.validate();
        TextView textView = new TextView(context, null);
        this.f387266b = textView;
        textView.setTextSize(0, (int) resources.getDimension(R.dimen.f159562aw3));
        this.f387266b.setSingleLine(true);
        this.f387266b.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387266b.setId(R.id.w56);
        this.f387266b.setEllipsize(TextUtils.TruncateAt.END);
        this.f387266b.setGravity(16);
        this.f387266b.setIncludeFontPadding(false);
        constraintLayout.addView(this.f387266b, layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams3.bottomToBottom = R.id.f165469w54;
        layoutParams3.topToTop = R.id.f165469w54;
        layoutParams3.endToEnd = 0;
        layoutParams3.startToEnd = R.id.w56;
        layoutParams3.validate();
        TextView textView2 = new TextView(context, null);
        this.f387267c = textView2;
        textView2.setTextSize(0, (int) resources.getDimension(R.dimen.f159562aw3));
        this.f387267c.setSingleLine(true);
        this.f387267c.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387267c.setId(R.id.w55);
        this.f387267c.setEllipsize(TextUtils.TruncateAt.END);
        this.f387267c.setIncludeFontPadding(false);
        constraintLayout.addView(this.f387267c, layoutParams3);
        return constraintLayout;
    }
}
