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
import com.tencent.qqnt.widget.SwipeMenuLayout;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildMyGuildListItemBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f387357a;

    /* renamed from: b, reason: collision with root package name */
    public RoundImageView f387358b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387359c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f387360d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f387361e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f387362f;

    /* renamed from: g, reason: collision with root package name */
    public View f387363g;

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
        SwipeMenuLayout swipeMenuLayout = new SwipeMenuLayout(context, null);
        this.f387363g = swipeMenuLayout;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.width = -1;
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387357a = linearLayout;
        linearLayout.setId(R.id.yji);
        this.f387357a.setGravity(8388611);
        this.f387357a.setOrientation(0);
        int applyDimension = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        this.f387357a.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        swipeMenuLayout.addView(this.f387357a, marginLayoutParams);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) (TypedValue.applyDimension(1, 48.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 48.0f, displayMetrics) + 0.5f);
        RoundImageView roundImageView = new RoundImageView(context, null);
        this.f387358b = roundImageView;
        roundImageView.setId(R.id.vzu);
        this.f387358b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f387358b.setRadius((int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f));
        this.f387357a.addView(this.f387358b, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams2.gravity = 16;
        layoutParams2.weight = 1.0f;
        layoutParams2.leftMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        linearLayout2.setOrientation(1);
        this.f387357a.addView(linearLayout2, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.weight = 1.0f;
        TextView textView = new TextView(context, null);
        this.f387359c = textView;
        textView.setId(R.id.x2e);
        this.f387359c.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        this.f387359c.setEllipsize(TextUtils.TruncateAt.END);
        this.f387359c.setMaxLines(2);
        this.f387359c.setGravity(19);
        this.f387359c.setIncludeFontPadding(false);
        this.f387359c.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        linearLayout2.addView(this.f387359c, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams4.width = -1;
        layoutParams4.topMargin = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
        layoutParams4.rightMargin = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        TextView textView2 = new TextView(context, null);
        this.f387360d = textView2;
        textView2.setTextSize(0, (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f));
        this.f387360d.setSingleLine(true);
        this.f387360d.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387360d.setId(R.id.w3j);
        this.f387360d.setEllipsize(TextUtils.TruncateAt.END);
        this.f387360d.setMaxLines(1);
        this.f387360d.setGravity(19);
        this.f387360d.setIncludeFontPadding(false);
        linearLayout2.addView(this.f387360d, layoutParams4);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams2.width = (int) (TypedValue.applyDimension(1, 80.0f, displayMetrics) + 0.5f);
        marginLayoutParams2.height = (int) resources.getDimension(R.dimen.chm);
        TextView textView3 = new TextView(context, null);
        this.f387361e = textView3;
        textView3.setId(R.id.f74753x4);
        this.f387361e.setText(resources.getString(R.string.f155871io));
        this.f387361e.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        this.f387361e.setSingleLine(true);
        this.f387361e.setMaxLines(1);
        this.f387361e.setGravity(17);
        this.f387361e.setIncludeFontPadding(false);
        this.f387361e.setTextColor(resources.getColor(R.color.qui_common_text_allwhite_primary));
        d.e(this.f387361e);
        this.f387361e.setBackground(context.getResources().getDrawable(R.drawable.guild_right_set_top_menu_bg));
        swipeMenuLayout.addView(this.f387361e, marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams3.width = (int) (TypedValue.applyDimension(1, 114.0f, displayMetrics) + 0.5f);
        marginLayoutParams3.height = (int) resources.getDimension(R.dimen.chm);
        TextView textView4 = new TextView(context, null);
        this.f387362f = textView4;
        textView4.setId(R.id.f74743x3);
        this.f387362f.setText(resources.getString(R.string.f140880f6));
        this.f387362f.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        this.f387362f.setSingleLine(true);
        this.f387362f.setMaxLines(1);
        this.f387362f.setGravity(17);
        this.f387362f.setIncludeFontPadding(false);
        this.f387362f.setTextColor(resources.getColor(R.color.qui_common_text_allwhite_primary));
        d.e(this.f387362f);
        this.f387362f.setBackground(context.getResources().getDrawable(R.drawable.guild_right_cancel_top_menu_bg));
        swipeMenuLayout.addView(this.f387362f, marginLayoutParams3);
        return swipeMenuLayout;
    }

    public View u() {
        return this.f387363g;
    }
}
