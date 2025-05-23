package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
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
import com.tencent.mobileqq.guild.media.widget.GuildMediaNetStatusView;
import com.tencent.mobileqq.guild.media.widget.GuildMediaVoiceMicView;
import com.tencent.mobileqq.guild.media.widget.GuildWavAvatarImageView;
import com.tencent.mobileqq.mini.entry.util.Xml2LayoutKt;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildAudioMediaItemViewBinding extends c {
    public TextView A;
    public ImageView B;
    public View C;

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f387210a;

    /* renamed from: b, reason: collision with root package name */
    public View f387211b;

    /* renamed from: c, reason: collision with root package name */
    public View f387212c;

    /* renamed from: d, reason: collision with root package name */
    public LinearLayout f387213d;

    /* renamed from: e, reason: collision with root package name */
    public GuildMediaNetStatusView f387214e;

    /* renamed from: f, reason: collision with root package name */
    public GuildMediaNetStatusView f387215f;

    /* renamed from: g, reason: collision with root package name */
    public LinearLayout f387216g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f387217h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f387218i;

    /* renamed from: j, reason: collision with root package name */
    public FrameLayout f387219j;

    /* renamed from: k, reason: collision with root package name */
    public GuildWavAvatarImageView f387220k;

    /* renamed from: l, reason: collision with root package name */
    public FrameLayout f387221l;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f387222m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f387223n;

    /* renamed from: o, reason: collision with root package name */
    public FrameLayout f387224o;

    /* renamed from: p, reason: collision with root package name */
    public LinearLayout f387225p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f387226q;

    /* renamed from: r, reason: collision with root package name */
    public ImageView f387227r;

    /* renamed from: s, reason: collision with root package name */
    public GuildMediaVoiceMicView f387228s;

    /* renamed from: t, reason: collision with root package name */
    public ImageView f387229t;

    /* renamed from: u, reason: collision with root package name */
    public ImageView f387230u;

    /* renamed from: v, reason: collision with root package name */
    public LottieAnimationView f387231v;

    /* renamed from: w, reason: collision with root package name */
    public LinearLayout f387232w;

    /* renamed from: x, reason: collision with root package name */
    public ImageView f387233x;

    /* renamed from: y, reason: collision with root package name */
    public TextView f387234y;

    /* renamed from: z, reason: collision with root package name */
    public LinearLayout f387235z;

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
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387210a = relativeLayout;
        this.C = relativeLayout;
        relativeLayout.setId(R.id.vzb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -1;
        View view = new View(context, null);
        this.f387211b = view;
        view.setId(R.id.f96545hz);
        this.f387211b.setVisibility(8);
        d.e(this.f387211b);
        this.f387211b.setBackground(context.getResources().getDrawable(R.drawable.guild_audio_media_item_third_app_user_bg));
        this.f387210a.addView(this.f387211b, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        View view2 = new View(context, null);
        this.f387212c = view2;
        view2.setId(R.id.f165364vp0);
        this.f387212c.setVisibility(4);
        d.e(this.f387212c);
        this.f387212c.setBackground(new ColorDrawable(Color.parseColor("#E640404C")));
        this.f387210a.addView(this.f387212c, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(10, -1);
        layoutParams3.topMargin = (int) resources.getDimension(R.dimen.f158703ms);
        layoutParams3.rightMargin = (int) resources.getDimension(R.dimen.f158703ms);
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387213d = linearLayout;
        linearLayout.setId(R.id.xxp);
        this.f387213d.setOrientation(0);
        this.f387210a.addView(this.f387213d, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) resources.getDimension(R.dimen.c9y);
        layoutParams4.height = (int) resources.getDimension(R.dimen.c9y);
        GuildMediaNetStatusView guildMediaNetStatusView = new GuildMediaNetStatusView(context, null);
        this.f387214e = guildMediaNetStatusView;
        guildMediaNetStatusView.setId(R.id.zph);
        this.f387214e.setVisibility(8);
        this.f387213d.addView(this.f387214e, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) resources.getDimension(R.dimen.c9y);
        layoutParams5.height = (int) resources.getDimension(R.dimen.c9y);
        layoutParams5.leftMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        GuildMediaNetStatusView guildMediaNetStatusView2 = new GuildMediaNetStatusView(context, null);
        this.f387215f = guildMediaNetStatusView2;
        guildMediaNetStatusView2.setId(R.id.vjz);
        this.f387215f.setVisibility(8);
        this.f387215f.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_audio_media_item_game_status));
        this.f387213d.addView(this.f387215f, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.height = (int) resources.getDimension(R.dimen.c9y);
        layoutParams6.addRule(10, -1);
        layoutParams6.addRule(9, -1);
        layoutParams6.leftMargin = (int) resources.getDimension(R.dimen.f158728ni);
        layoutParams6.topMargin = (int) resources.getDimension(R.dimen.f158728ni);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387216g = linearLayout2;
        linearLayout2.setId(R.id.f165430vz0);
        this.f387216g.setVisibility(8);
        this.f387216g.setOrientation(0);
        this.f387210a.addView(this.f387216g, layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) resources.getDimension(R.dimen.f158705mu);
        layoutParams7.height = (int) resources.getDimension(R.dimen.f158705mu);
        layoutParams7.gravity = 16;
        ImageView imageView = new ImageView(context, null);
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_audio_timer));
        this.f387216g.addView(imageView, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.leftMargin = (int) resources.getDimension(R.dimen.f158712n1);
        TextView textView = new TextView(context, null);
        this.f387217h = textView;
        textView.setId(R.id.f165431vz1);
        this.f387217h.setText("05:00");
        this.f387217h.setTextSize(0, (int) resources.getDimension(R.dimen.f159562aw3));
        if (Build.VERSION.SDK_INT >= 28) {
            this.f387217h.setLineHeight((int) resources.getDimension(R.dimen.c9y));
        }
        this.f387217h.setMaxLines(1);
        this.f387217h.setTextColor(resources.getColor(R.color.f158017al3));
        this.f387216g.addView(this.f387217h, layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.width = -1;
        layoutParams9.height = (int) (TypedValue.applyDimension(1, 180.0f, displayMetrics) + 0.5f);
        layoutParams9.addRule(15, -1);
        LinearLayout linearLayout3 = new LinearLayout(context, null);
        this.f387218i = linearLayout3;
        linearLayout3.setId(R.id.tq8);
        this.f387218i.setContentDescription(Xml2LayoutKt.NULL_VALUE);
        this.f387218i.setClipChildren(false);
        this.f387218i.setGravity(17);
        this.f387218i.setClipToPadding(false);
        this.f387218i.setOrientation(1);
        this.f387210a.addView(this.f387218i, layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.width = (int) (TypedValue.applyDimension(1, 65.0f, displayMetrics) + 0.5f);
        layoutParams10.height = (int) (TypedValue.applyDimension(1, 65.0f, displayMetrics) + 0.5f);
        layoutParams10.gravity = 1;
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387219j = frameLayout;
        frameLayout.setId(R.id.l_j);
        this.f387219j.setClipChildren(false);
        this.f387219j.setClipToPadding(false);
        this.f387218i.addView(this.f387219j, layoutParams10);
        FrameLayout.LayoutParams layoutParams11 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams11.width = -1;
        layoutParams11.height = -1;
        GuildWavAvatarImageView guildWavAvatarImageView = new GuildWavAvatarImageView(context, null);
        this.f387220k = guildWavAvatarImageView;
        guildWavAvatarImageView.setId(R.id.f165434vz4);
        this.f387220k.setAvatarWidth((int) (TypedValue.applyDimension(1, 65.0f, displayMetrics) + 0.5f));
        this.f387220k.setAvatarHeight((int) (TypedValue.applyDimension(1, 65.0f, displayMetrics) + 0.5f));
        this.f387219j.addView(this.f387220k, layoutParams11);
        FrameLayout.LayoutParams layoutParams12 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams12.width = -1;
        layoutParams12.height = -1;
        FrameLayout frameLayout2 = new FrameLayout(context, null);
        this.f387221l = frameLayout2;
        frameLayout2.setId(R.id.vz_);
        this.f387221l.setVisibility(8);
        d.e(this.f387221l);
        this.f387221l.setBackground(context.getResources().getDrawable(R.drawable.guild_audio_phone_busy_bg));
        this.f387219j.addView(this.f387221l, layoutParams12);
        FrameLayout.LayoutParams layoutParams13 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams13.width = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams13.height = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams13.gravity = 17;
        ImageView imageView2 = new ImageView(context, null);
        imageView2.setContentDescription(resources.getString(R.string.f140190da));
        imageView2.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_audio_phone_call));
        this.f387221l.addView(imageView2, layoutParams13);
        FrameLayout.LayoutParams layoutParams14 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams14.width = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams14.height = (int) resources.getDimension(R.dimen.f158713n2);
        LinearLayout linearLayout4 = new LinearLayout(context, null);
        this.f387222m = linearLayout4;
        linearLayout4.setId(R.id.vzg);
        this.f387222m.setVisibility(8);
        d.e(this.f387222m);
        this.f387222m.setBackground(context.getResources().getDrawable(R.drawable.guild_audio_queue_number_bg));
        this.f387219j.addView(this.f387222m, layoutParams14);
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams15.width = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams15.height = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams15.gravity = 17;
        TextView textView2 = new TextView(context, null);
        this.f387223n = textView2;
        textView2.setId(R.id.vzf);
        this.f387223n.setText("1");
        this.f387223n.setTextSize(0, (int) resources.getDimension(R.dimen.f159562aw3));
        this.f387223n.setMaxLines(1);
        this.f387223n.setGravity(17);
        this.f387223n.setTextColor(resources.getColor(R.color.f158017al3));
        this.f387223n.setTypeface(Typeface.create("DIN-NextLT-Pro-QQ", 0));
        d.h(this.f387223n, 0, "DIN-NextLT-Pro-QQ", null, -1, -1);
        this.f387222m.addView(this.f387223n, layoutParams15);
        FrameLayout.LayoutParams layoutParams16 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams16.width = -1;
        layoutParams16.height = -1;
        layoutParams16.gravity = 17;
        FrameLayout frameLayout3 = new FrameLayout(context, null);
        this.f387224o = frameLayout3;
        frameLayout3.setId(R.id.wqn);
        this.f387224o.setClipChildren(false);
        this.f387219j.addView(this.f387224o, layoutParams16);
        LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams17.width = -1;
        layoutParams17.gravity = 16;
        layoutParams17.topMargin = (int) resources.getDimension(R.dimen.c9y);
        LinearLayout linearLayout5 = new LinearLayout(context, null);
        this.f387225p = linearLayout5;
        linearLayout5.setId(R.id.d_8);
        this.f387225p.setOrientation(1);
        this.f387218i.addView(this.f387225p, layoutParams17);
        LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams18.gravity = 17;
        LinearLayout linearLayout6 = new LinearLayout(context, null);
        linearLayout6.setOrientation(0);
        linearLayout6.setBaselineAligned(true);
        this.f387225p.addView(linearLayout6, layoutParams18);
        LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams19.gravity = 16;
        TextView textView3 = new TextView(context, null);
        this.f387226q = textView3;
        textView3.setId(R.id.vz7);
        this.f387226q.setTextSize(0, (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f));
        this.f387226q.setEllipsize(TextUtils.TruncateAt.END);
        this.f387226q.setMaxLines(1);
        this.f387226q.setIncludeFontPadding(false);
        this.f387226q.setMaxEms(7);
        this.f387226q.setTextColor(Color.parseColor("#E8E9EA"));
        linearLayout6.addView(this.f387226q, layoutParams19);
        LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams20.gravity = 17;
        layoutParams20.setMarginStart((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        ImageView imageView3 = new ImageView(context, null);
        this.f387227r = imageView3;
        imageView3.setAdjustViewBounds(true);
        this.f387227r.setId(R.id.vzd);
        this.f387227r.setContentDescription(Xml2LayoutKt.NULL_VALUE);
        this.f387227r.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f387227r.setMaxHeight((int) (TypedValue.applyDimension(1, 22.0f, displayMetrics) + 0.5f));
        this.f387227r.setVisibility(8);
        linearLayout6.addView(this.f387227r, layoutParams20);
        LinearLayout.LayoutParams layoutParams21 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams21.width = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams21.height = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams21.gravity = 16;
        layoutParams21.setMarginStart((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        GuildMediaVoiceMicView guildMediaVoiceMicView = new GuildMediaVoiceMicView(context, null);
        this.f387228s = guildMediaVoiceMicView;
        guildMediaVoiceMicView.setId(R.id.vz5);
        this.f387228s.setVisibility(0);
        this.f387228s.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_item_icon_mic_off_dark));
        linearLayout6.addView(this.f387228s, layoutParams21);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams22.width = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams22.height = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams22.gravity = 16;
        layoutParams22.setMarginStart((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        ImageView imageView4 = new ImageView(context, null);
        this.f387229t = imageView4;
        imageView4.setId(R.id.vz6);
        this.f387229t.setContentDescription(Xml2LayoutKt.NULL_VALUE);
        this.f387229t.setVisibility(8);
        this.f387229t.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_item_icon_mute_new_dark));
        linearLayout6.addView(this.f387229t, layoutParams22);
        LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams23.width = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams23.height = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams23.gravity = 16;
        layoutParams23.setMarginStart((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        ImageView imageView5 = new ImageView(context, null);
        this.f387230u = imageView5;
        imageView5.setId(R.id.vz8);
        this.f387230u.setContentDescription(Xml2LayoutKt.NULL_VALUE);
        this.f387230u.setVisibility(8);
        this.f387230u.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_raisehand_big));
        linearLayout6.addView(this.f387230u, layoutParams23);
        LinearLayout.LayoutParams layoutParams24 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams24.width = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams24.height = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams24.gravity = 16;
        layoutParams24.setMarginStart((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context, null);
        this.f387231v = lottieAnimationView;
        lottieAnimationView.setId(R.id.f164511sx4);
        this.f387231v.setVisibility(8);
        linearLayout6.addView(this.f387231v, layoutParams24);
        LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams25.gravity = 17;
        layoutParams25.topMargin = (int) (TypedValue.applyDimension(1, 7.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout7 = new LinearLayout(context, null);
        this.f387232w = linearLayout7;
        linearLayout7.setId(R.id.xe6);
        this.f387232w.setGravity(17);
        this.f387232w.setOrientation(0);
        this.f387225p.addView(this.f387232w, layoutParams25);
        LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams26.width = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams26.height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams26.rightMargin = (int) (TypedValue.applyDimension(1, 7.0f, displayMetrics) + 0.5f);
        ImageView imageView6 = new ImageView(context, null);
        this.f387233x = imageView6;
        imageView6.setId(R.id.x4f);
        this.f387233x.setVisibility(8);
        this.f387232w.addView(this.f387233x, layoutParams26);
        LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams27.gravity = 17;
        TextView textView4 = new TextView(context, null);
        this.f387234y = textView4;
        textView4.setText(resources.getString(R.string.f154371em));
        this.f387234y.setTextSize(0, (int) resources.getDimension(R.dimen.f158729nj));
        this.f387234y.setTextColor(resources.getColor(R.color.f158017al3));
        this.f387234y.setId(R.id.vwy);
        this.f387234y.setEllipsize(TextUtils.TruncateAt.END);
        this.f387234y.setMaxLines(1);
        this.f387234y.setGravity(17);
        this.f387234y.setVisibility(8);
        this.f387234y.setIncludeFontPadding(false);
        d.e(this.f387234y);
        this.f387234y.setBackground(context.getResources().getDrawable(R.drawable.guild_admin_role_icon_bg));
        this.f387234y.setPadding((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f));
        this.f387232w.addView(this.f387234y, layoutParams27);
        LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams28.gravity = 17;
        layoutParams28.topMargin = (int) resources.getDimension(R.dimen.f158726ng);
        LinearLayout linearLayout8 = new LinearLayout(context, null);
        this.f387235z = linearLayout8;
        linearLayout8.setId(R.id.f88224wh);
        this.f387218i.addView(this.f387235z, layoutParams28);
        LinearLayout.LayoutParams layoutParams29 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams29.gravity = 16;
        TextView textView5 = new TextView(context, null);
        this.A = textView5;
        textView5.setId(R.id.vze);
        this.A.setText(resources.getString(R.string.f140190da));
        this.A.setTextSize(0, (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f));
        this.A.setVisibility(8);
        this.A.setTextColor(Color.parseColor("#5d6064"));
        this.f387235z.addView(this.A, layoutParams29);
        RelativeLayout.LayoutParams layoutParams30 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams30.width = (int) resources.getDimension(R.dimen.c_k);
        layoutParams30.height = (int) resources.getDimension(R.dimen.c_k);
        layoutParams30.addRule(13, -1);
        layoutParams30.addRule(12, -1);
        ImageView imageView7 = new ImageView(context, null);
        this.B = imageView7;
        imageView7.setId(R.id.wqm);
        this.f387210a.addView(this.B, layoutParams30);
        return this.f387210a;
    }

    public View u() {
        return this.C;
    }
}
