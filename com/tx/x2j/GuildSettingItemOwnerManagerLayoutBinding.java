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
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildSettingItemOwnerManagerLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public ConstraintLayout f387419a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f387420b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387421c;

    /* renamed from: d, reason: collision with root package name */
    public LottieAnimationView f387422d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f387423e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f387424f;

    /* renamed from: g, reason: collision with root package name */
    public RelativeLayout f387425g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f387426h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f387427i;

    /* renamed from: j, reason: collision with root package name */
    public RoundImageView f387428j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f387429k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f387430l;

    /* renamed from: m, reason: collision with root package name */
    public View f387431m;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=ViewGroup.LayoutParams, key=android:layout_marginHorizontal, value=16dp}");
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=AbsListView.LayoutParams, key=android:layout_marginHorizontal, value=16dp}");
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.leftMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams.rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.leftMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams.rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.leftMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams.rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.leftMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams.rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f387419a = constraintLayout;
        this.f387431m = constraintLayout;
        constraintLayout.setId(R.id.wtg);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 56.0f, displayMetrics) + 0.5f);
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.validate();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387420b = relativeLayout;
        relativeLayout.setId(R.id.wpc);
        this.f387420b.setClickable(true);
        d.e(this.f387420b);
        this.f387420b.setBackground(context.getResources().getDrawable(R.drawable.guild_qui_common_fill_light_secondary_bg_top_round_8_selector));
        this.f387419a.addView(this.f387420b, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15, -1);
        layoutParams2.setMarginStart((int) resources.getDimension(R.dimen.c9y));
        TextView textView = new TextView(context, null);
        this.f387421c = textView;
        textView.setId(R.id.y5k);
        this.f387421c.setMinimumWidth((int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f));
        this.f387421c.setText(resources.getString(R.string.f156151jf));
        this.f387421c.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        this.f387421c.setSingleLine(true);
        this.f387421c.setDuplicateParentStateEnabled(true);
        this.f387421c.setIncludeFontPadding(false);
        this.f387421c.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        this.f387420b.addView(this.f387421c, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) resources.getDimension(R.dimen.f158700mp);
        layoutParams3.height = (int) resources.getDimension(R.dimen.f158700mp);
        layoutParams3.addRule(1, R.id.y5k);
        layoutParams3.topMargin = (int) (TypedValue.applyDimension(1, 7.0f, displayMetrics) + 0.5f);
        layoutParams3.setMarginEnd((int) (TypedValue.applyDimension(1, 7.0f, displayMetrics) + 0.5f));
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context, null);
        this.f387422d = lottieAnimationView;
        lottieAnimationView.setId(R.id.xnh);
        this.f387422d.setVisibility(8);
        this.f387420b.addView(this.f387422d, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams4.addRule(21, -1);
        layoutParams4.addRule(15, -1);
        layoutParams4.setMarginEnd((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        ImageView imageView = new ImageView(context, null);
        this.f387423e = imageView;
        imageView.setId(R.id.wpi);
        this.f387423e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        d.e(this.f387423e);
        this.f387423e.setBackground(context.getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_01));
        int applyDimension = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        this.f387423e.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        this.f387420b.addView(this.f387423e, layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = (int) (TypedValue.applyDimension(1, 0.5f, displayMetrics) + 0.5f);
        layoutParams5.topToBottom = R.id.wpc;
        layoutParams5.startToStart = 0;
        layoutParams5.validate();
        ImageView imageView2 = new ImageView(context, null);
        this.f387424f = imageView2;
        imageView2.setId(R.id.e_3);
        this.f387424f.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_common_border_standard_bg));
        d.e(this.f387424f);
        this.f387424f.setBackground(context.getResources().getDrawable(R.drawable.qui_common_fill_light_secondary_bg_selector));
        this.f387424f.setPadding((int) resources.getDimension(R.dimen.c9y), 0, (int) resources.getDimension(R.dimen.c9y), 0);
        this.f387419a.addView(this.f387424f, layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = (int) (TypedValue.applyDimension(1, 56.0f, displayMetrics) + 0.5f);
        layoutParams6.topToBottom = R.id.e_3;
        layoutParams6.startToStart = 0;
        layoutParams6.validate();
        RelativeLayout relativeLayout2 = new RelativeLayout(context, null);
        this.f387425g = relativeLayout2;
        relativeLayout2.setId(R.id.wtd);
        this.f387425g.setFocusable(true);
        this.f387425g.setClickable(true);
        this.f387425g.setVisibility(8);
        d.e(this.f387425g);
        this.f387425g.setBackground(context.getResources().getDrawable(R.drawable.guild_qui_common_fill_light_secondary_bg_bottom_round_8_selector));
        this.f387419a.addView(this.f387425g, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(15, -1);
        layoutParams7.setMarginStart((int) resources.getDimension(R.dimen.c9y));
        TextView textView2 = new TextView(context, null);
        this.f387426h = textView2;
        textView2.setId(R.id.f109796gs);
        this.f387426h.setMinimumWidth((int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f));
        this.f387426h.setText(resources.getString(R.string.f156321jw));
        this.f387426h.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        this.f387426h.setSingleLine(true);
        this.f387426h.setDuplicateParentStateEnabled(true);
        this.f387426h.setIncludeFontPadding(false);
        this.f387426h.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        this.f387425g.addView(this.f387426h, layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(16, R.id.wta);
        layoutParams8.alignWithParent = true;
        layoutParams8.addRule(17, R.id.f109796gs);
        layoutParams8.addRule(15, -1);
        layoutParams8.setMarginStart((int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f));
        layoutParams8.setMarginEnd((int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f));
        TextView textView3 = new TextView(context, null);
        this.f387427i = textView3;
        textView3.setLines(1);
        this.f387427i.setTextSize(0, (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f));
        this.f387427i.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387427i.setId(R.id.wtb);
        this.f387427i.setEllipsize(TextUtils.TruncateAt.END);
        this.f387427i.setGravity(8388613);
        this.f387427i.setDuplicateParentStateEnabled(true);
        this.f387427i.setIncludeFontPadding(false);
        this.f387425g.addView(this.f387427i, layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.width = (int) (TypedValue.applyDimension(1, 32.0f, displayMetrics) + 0.5f);
        layoutParams9.addRule(16, R.id.wtc);
        layoutParams9.height = (int) (TypedValue.applyDimension(1, 32.0f, displayMetrics) + 0.5f);
        layoutParams9.addRule(15, -1);
        layoutParams9.setMarginEnd((int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f));
        RoundImageView roundImageView = new RoundImageView(context, null);
        this.f387428j = roundImageView;
        roundImageView.setId(R.id.wta);
        this.f387428j.setVisibility(8);
        this.f387428j.setQwRadius((int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f));
        this.f387425g.addView(this.f387428j, layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.width = (int) resources.getDimension(R.dimen.f158729nj);
        layoutParams10.height = (int) resources.getDimension(R.dimen.f158729nj);
        layoutParams10.addRule(6, R.id.wta);
        layoutParams10.addRule(19, R.id.wta);
        layoutParams10.topMargin = (int) (TypedValue.applyDimension(1, -4.0f, displayMetrics) + 0.5f);
        layoutParams10.setMarginEnd((int) (TypedValue.applyDimension(1, -5.0f, displayMetrics) + 0.5f));
        ImageView imageView3 = new ImageView(context, null);
        this.f387429k = imageView3;
        imageView3.setId(R.id.wte);
        this.f387429k.setImageDrawable(context.getResources().getDrawable(R.drawable.skin_tips_newmessage));
        this.f387425g.addView(this.f387429k, layoutParams10);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams11.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams11.addRule(21, -1);
        layoutParams11.addRule(15, -1);
        layoutParams11.setMarginEnd((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        ImageView imageView4 = new ImageView(context, null);
        this.f387430l = imageView4;
        imageView4.setId(R.id.wtc);
        d.e(this.f387430l);
        this.f387430l.setBackground(context.getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_01));
        int applyDimension2 = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        this.f387430l.setPadding(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
        this.f387425g.addView(this.f387430l, layoutParams11);
        return this.f387419a;
    }

    public View u() {
        return this.f387431m;
    }
}
