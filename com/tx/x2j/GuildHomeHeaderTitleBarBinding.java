package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
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
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.view.GuildChannelNameTextView;
import com.tencent.mobileqq.guild.widget.GuildBannerTitleLayout;
import com.tencent.mobileqq.widget.RoundImageView;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildHomeHeaderTitleBarBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public ConstraintLayout f387328a;

    /* renamed from: b, reason: collision with root package name */
    public View f387329b;

    /* renamed from: c, reason: collision with root package name */
    public RoundImageView f387330c;

    /* renamed from: d, reason: collision with root package name */
    public GuildBannerTitleLayout f387331d;

    /* renamed from: e, reason: collision with root package name */
    public GuildChannelNameTextView f387332e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f387333f;

    /* renamed from: g, reason: collision with root package name */
    public View f387334g;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        Log.e("X2J", "invalid root attr \uff1aFrameLayout {parent=ViewGroup.LayoutParams, key=android:layout_gravity, value=bottom}");
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        Log.e("X2J", "invalid root attr \uff1aFrameLayout {parent=AbsListView.LayoutParams, key=android:layout_gravity, value=bottom}");
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.gravity = 80;
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.gravity = 80;
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.gravity = 80;
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        Log.e("X2J", "invalid root attr \uff1aFrameLayout {parent=RelativeLayout.LayoutParams, key=android:layout_gravity, value=bottom}");
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        Log.e("X2J", "invalid root attr \uff1aFrameLayout {parent=ConstraintLayout.LayoutParams, key=android:layout_gravity, value=bottom}");
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        Log.e("X2J", "invalid root attr \uff1aFrameLayout {parent=RecyclerView.LayoutParams, key=android:layout_gravity, value=bottom}");
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387334g = frameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.gravity = 80;
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f387328a = constraintLayout;
        constraintLayout.setId(R.id.b8q);
        this.f387328a.setClipToPadding(false);
        frameLayout.addView(this.f387328a, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (TypedValue.applyDimension(1, 60.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (TypedValue.applyDimension(1, 60.0f, displayMetrics) + 0.5f);
        layoutParams2.bottomToBottom = 0;
        layoutParams2.topToTop = 0;
        layoutParams2.startToStart = 0;
        layoutParams2.setMarginStart((int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        layoutParams2.validate();
        View view = new View(context, null);
        this.f387329b = view;
        view.setId(R.id.f165418vw3);
        d.e(this.f387329b);
        this.f387329b.setBackground(context.getResources().getDrawable(R.drawable.guild_shape_round_stroke_white_8dp_radius));
        this.f387328a.addView(this.f387329b, layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) (TypedValue.applyDimension(1, 58.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) (TypedValue.applyDimension(1, 58.0f, displayMetrics) + 0.5f);
        layoutParams3.bottomToBottom = 0;
        layoutParams3.topToTop = 0;
        layoutParams3.startToStart = 0;
        layoutParams3.setMarginStart((int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f));
        layoutParams3.validate();
        RoundImageView roundImageView = new RoundImageView(context, null);
        this.f387330c = roundImageView;
        roundImageView.setId(R.id.f165417vw2);
        this.f387330c.setQwRadius((int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f));
        this.f387328a.addView(this.f387330c, layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = -1;
        layoutParams4.topToTop = R.id.f165417vw2;
        layoutParams4.bottomToTop = R.id.f166221z24;
        layoutParams4.startToStart = 0;
        layoutParams4.verticalChainStyle = 2;
        layoutParams4.setMarginStart((int) (TypedValue.applyDimension(1, 88.0f, displayMetrics) + 0.5f));
        layoutParams4.setMarginEnd((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f));
        layoutParams4.validate();
        GuildBannerTitleLayout guildBannerTitleLayout = new GuildBannerTitleLayout(context, null);
        this.f387331d = guildBannerTitleLayout;
        guildBannerTitleLayout.setId(R.id.t4b);
        this.f387331d.setClipChildren(false);
        this.f387331d.setClipToPadding(false);
        this.f387328a.addView(this.f387331d, layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        GuildChannelNameTextView guildChannelNameTextView = new GuildChannelNameTextView(context, null);
        this.f387332e = guildChannelNameTextView;
        guildChannelNameTextView.setTextSize(0, (int) (TypedValue.applyDimension(1, 22.0f, displayMetrics) + 0.5f));
        this.f387332e.setSingleLine(true);
        this.f387332e.setTextColor(resources.getColor(R.color.guild_skin_content_text));
        this.f387332e.setTypeface(Typeface.create("PingFangHK-Medium", 0));
        this.f387332e.setId(R.id.f166992jq2);
        this.f387332e.setEllipsize(TextUtils.TruncateAt.END);
        this.f387332e.setVisibility(0);
        this.f387332e.setIncludeFontPadding(false);
        d.h(this.f387332e, 0, "PingFangHK-Medium", null, 1, -1);
        this.f387331d.addView(this.f387332e, layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams6.bottomToBottom = R.id.f165417vw2;
        layoutParams6.topToBottom = R.id.t4b;
        layoutParams6.startToStart = R.id.t4b;
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        layoutParams6.validate();
        TextView textView = new TextView(context, null);
        this.f387333f = textView;
        textView.setId(R.id.f166221z24);
        this.f387333f.setTextSize(0, (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        this.f387333f.setGravity(16);
        this.f387333f.setTextColor(resources.getColor(R.color.guild_skin_color_a7acb6));
        this.f387328a.addView(this.f387333f, layoutParams6);
        return frameLayout;
    }

    public View u() {
        return this.f387334g;
    }
}
