package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.mobileqq.guild.discover.widget.GuildRoundBoardImageView;
import com.tencent.mobileqq.guild.widget.RadiusConstraintLayout;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildNewRecommendBannerItemBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public ImageView f387364a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f387365b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387366c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f387367d;

    /* renamed from: e, reason: collision with root package name */
    public GuildRoundBoardImageView f387368e;

    /* renamed from: f, reason: collision with root package name */
    public View f387369f;

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
        RadiusConstraintLayout radiusConstraintLayout = new RadiusConstraintLayout(context, null);
        this.f387369f = radiusConstraintLayout;
        radiusConstraintLayout.setImportantForAccessibility(2);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
        layoutParams.validate();
        ImageView imageView = new ImageView(context, null);
        this.f387364a = imageView;
        imageView.setId(R.id.t66);
        this.f387364a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        radiusConstraintLayout.addView(this.f387364a, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams2.startToStart = 0;
        layoutParams2.topToTop = 0;
        layoutParams2.validate();
        TextView textView = new TextView(context, null);
        this.f387365b = textView;
        textView.setTextSize(0, (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f));
        this.f387365b.setTextColor(Color.parseColor("#FFFFFF"));
        this.f387365b.setId(R.id.yc9);
        this.f387365b.setEllipsize(TextUtils.TruncateAt.END);
        this.f387365b.setMaxLines(1);
        this.f387365b.setGravity(16);
        this.f387365b.setIncludeFontPadding(false);
        d.e(this.f387365b);
        this.f387365b.setBackground(context.getResources().getDrawable(R.drawable.guild_recommend_label_bg));
        this.f387365b.setPadding((int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 8.33f, displayMetrics) + 0.5f), 0);
        d.h(this.f387365b, 0, null, null, 1, -1);
        radiusConstraintLayout.addView(this.f387365b, layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.bottomToTop = R.id.j5r;
        layoutParams3.startToStart = 0;
        layoutParams3.horizontalBias = 0.0f;
        layoutParams3.endToStart = R.id.f165417vw2;
        ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f);
        layoutParams3.setMarginStart((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        layoutParams3.validate();
        TextView textView2 = new TextView(context, null);
        this.f387366c = textView2;
        textView2.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        this.f387366c.setTextColor(Color.parseColor("#FFFFFF"));
        this.f387366c.setId(R.id.yw6);
        this.f387366c.setEllipsize(TextUtils.TruncateAt.END);
        this.f387366c.setMaxLines(1);
        this.f387366c.setShadowLayer(3.0f, 0.0f, 0.0f, Color.parseColor("#40000000"));
        radiusConstraintLayout.addView(this.f387366c, layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams4.startToStart = 0;
        layoutParams4.bottomToBottom = 0;
        layoutParams4.horizontalBias = 0.0f;
        layoutParams4.endToStart = R.id.f165417vw2;
        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = (int) (TypedValue.applyDimension(1, 13.0f, displayMetrics) + 0.5f);
        layoutParams4.setMarginStart((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        layoutParams4.validate();
        TextView textView3 = new TextView(context, null);
        this.f387367d = textView3;
        textView3.setTextSize(0, (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        this.f387367d.setTextColor(Color.parseColor("#D9FFFFFF"));
        this.f387367d.setId(R.id.j5r);
        this.f387367d.setEllipsize(TextUtils.TruncateAt.END);
        this.f387367d.setMaxLines(1);
        this.f387367d.setShadowLayer(3.0f, 0.0f, 0.0f, Color.parseColor("#40000000"));
        radiusConstraintLayout.addView(this.f387367d, layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = (int) (TypedValue.applyDimension(1, 38.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = (int) (TypedValue.applyDimension(1, 38.0f, displayMetrics) + 0.5f);
        layoutParams5.bottomToBottom = 0;
        layoutParams5.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        layoutParams5.setMarginEnd((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        layoutParams5.validate();
        GuildRoundBoardImageView guildRoundBoardImageView = new GuildRoundBoardImageView(context, null);
        this.f387368e = guildRoundBoardImageView;
        guildRoundBoardImageView.setId(R.id.f165417vw2);
        this.f387368e.setGuildBoardWidth((int) (TypedValue.applyDimension(1, 1.0f, displayMetrics) + 0.5f));
        this.f387368e.setGuildBoardColor(Color.parseColor("#4DFFFFFF"));
        radiusConstraintLayout.addView(this.f387368e, layoutParams5);
        return radiusConstraintLayout;
    }
}
