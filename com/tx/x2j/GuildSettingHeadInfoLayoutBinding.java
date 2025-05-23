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
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildSettingHeadInfoLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public ConstraintLayout f387411a;

    /* renamed from: b, reason: collision with root package name */
    public RadiusFrameLayout f387412b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f387413c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f387414d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f387415e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f387416f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f387417g;

    /* renamed from: h, reason: collision with root package name */
    public View f387418h;

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
        this.f387411a = constraintLayout;
        this.f387418h = constraintLayout;
        constraintLayout.setId(R.id.wji);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (TypedValue.applyDimension(1, 68.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 68.0f, displayMetrics) + 0.5f);
        layoutParams.bottomToBottom = 0;
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.validate();
        RadiusFrameLayout radiusFrameLayout = new RadiusFrameLayout(context, null);
        this.f387412b = radiusFrameLayout;
        radiusFrameLayout.setId(R.id.wik);
        this.f387412b.d((int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f));
        this.f387411a.addView(this.f387412b, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.gravity = 17;
        ImageView imageView = new ImageView(context, null);
        this.f387413c = imageView;
        imageView.setId(R.id.wij);
        this.f387413c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f387412b.addView(this.f387413c, layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.bottomToTop = R.id.x1h;
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams3.topToTop = 0;
        layoutParams3.verticalChainStyle = 2;
        layoutParams3.startToEnd = R.id.wik;
        layoutParams3.endToStart = R.id.wut;
        layoutParams3.setMarginStart((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        layoutParams3.validate();
        TextView textView = new TextView(context, null);
        this.f387414d = textView;
        textView.setTextSize(0, (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f));
        this.f387414d.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        this.f387414d.setId(R.id.wrw);
        this.f387414d.setEllipsize(TextUtils.TruncateAt.END);
        this.f387414d.setMaxLines(2);
        this.f387414d.setIncludeFontPadding(false);
        this.f387411a.addView(this.f387414d, layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams4.topToBottom = R.id.wrw;
        layoutParams4.startToStart = R.id.wrw;
        layoutParams4.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f);
        layoutParams4.setMarginEnd((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        layoutParams4.validate();
        TextView textView2 = new TextView(context, null);
        this.f387415e = textView2;
        textView2.setTextSize(0, (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f));
        this.f387415e.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387415e.setId(R.id.x1h);
        this.f387411a.addView(this.f387415e, layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams5.topToTop = R.id.wrw;
        layoutParams5.endToEnd = 0;
        layoutParams5.setMarginStart((int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f));
        layoutParams5.validate();
        ImageView imageView2 = new ImageView(context, null);
        this.f387416f = imageView2;
        imageView2.setId(R.id.wut);
        this.f387416f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f387416f.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_token_qrcode_icon));
        this.f387411a.addView(this.f387416f, layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams6.bottomToBottom = R.id.x1h;
        layoutParams6.topToTop = R.id.x1h;
        layoutParams6.endToEnd = 0;
        layoutParams6.validate();
        ImageView imageView3 = new ImageView(context, null);
        this.f387417g = imageView3;
        imageView3.setId(R.id.wjh);
        d.e(this.f387417g);
        this.f387417g.setBackground(context.getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_01));
        this.f387411a.addView(this.f387417g, layoutParams6);
        return this.f387411a;
    }

    public View u() {
        return this.f387418h;
    }
}
