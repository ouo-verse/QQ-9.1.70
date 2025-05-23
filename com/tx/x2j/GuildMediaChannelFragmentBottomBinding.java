package com.tx.x2j;

import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView;
import com.tencent.mobileqq.guild.widget.ScanningView;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildMediaChannelFragmentBottomBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f387336a;

    /* renamed from: b, reason: collision with root package name */
    public GuildAIOInputEditText f387337b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387338c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f387339d;

    /* renamed from: e, reason: collision with root package name */
    public LinearLayout f387340e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f387341f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f387342g;

    /* renamed from: h, reason: collision with root package name */
    public LinearLayout f387343h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f387344i;

    /* renamed from: j, reason: collision with root package name */
    public LottieAnimationView f387345j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f387346k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f387347l;

    /* renamed from: m, reason: collision with root package name */
    public FrameLayout f387348m;

    /* renamed from: n, reason: collision with root package name */
    public ImageView f387349n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f387350o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f387351p;

    /* renamed from: q, reason: collision with root package name */
    public GuildFreeGiftView f387352q;

    /* renamed from: r, reason: collision with root package name */
    public ImageView f387353r;

    /* renamed from: s, reason: collision with root package name */
    public ScanningView f387354s;

    /* renamed from: t, reason: collision with root package name */
    public ImageView f387355t;

    /* renamed from: u, reason: collision with root package name */
    public View f387356u;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158982ch2);
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158982ch2);
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158982ch2);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158982ch2);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158982ch2);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158982ch2);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) resources.getDimension(R.dimen.f158982ch2);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) resources.getDimension(R.dimen.f158982ch2);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387356u = linearLayout;
        linearLayout.setGravity(80);
        linearLayout.setOrientation(0);
        linearLayout.setBaselineAligned(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) resources.getDimension(R.dimen.cdb);
        layoutParams.weight = 1.0f;
        layoutParams.leftMargin = (int) resources.getDimension(R.dimen.f158703ms);
        layoutParams.rightMargin = (int) resources.getDimension(R.dimen.f158723nd);
        layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.f158983ch3);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387336a = linearLayout2;
        linearLayout2.setId(R.id.wq7);
        this.f387336a.setGravity(17);
        this.f387336a.setOrientation(0);
        d.e(this.f387336a);
        this.f387336a.setBackground(context.getResources().getDrawable(R.drawable.guild_media_input_bar_no_content_bg));
        linearLayout.addView(this.f387336a, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.height = -1;
        layoutParams2.weight = 1.0f;
        layoutParams2.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams2.setMarginStart((int) resources.getDimension(R.dimen.f158700mp));
        GuildAIOInputEditText guildAIOInputEditText = new GuildAIOInputEditText(context, null);
        this.f387337b = guildAIOInputEditText;
        guildAIOInputEditText.setTextSize(0, (int) resources.getDimension(R.dimen.f158706mv));
        this.f387337b.setSingleLine(true);
        this.f387337b.setHint(resources.getString(R.string.f1494612c));
        this.f387337b.setTextColor(resources.getColor(R.color.f158017al3));
        this.f387337b.setId(R.id.wqa);
        this.f387337b.setHintTextColor(resources.getColor(R.color.bpo));
        this.f387337b.setGravity(16);
        this.f387337b.setVisibility(8);
        this.f387337b.setIncludeFontPadding(false);
        this.f387336a.addView(this.f387337b, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(context, null);
        this.f387338c = textView;
        textView.setTextSize(0, (int) resources.getDimension(R.dimen.f158706mv));
        this.f387338c.setSingleLine(true);
        this.f387338c.setCompoundDrawablePadding((int) resources.getDimension(R.dimen.f158716n6));
        this.f387338c.setTextColor(resources.getColor(R.color.bs9));
        this.f387338c.setId(R.id.wqc);
        this.f387338c.setEllipsize(TextUtils.TruncateAt.END);
        this.f387338c.setGravity(17);
        this.f387338c.setVisibility(8);
        this.f387338c.setIncludeFontPadding(false);
        this.f387338c.setPadding((int) resources.getDimension(R.dimen.f158706mv), 0, (int) resources.getDimension(R.dimen.f158706mv), 0);
        this.f387336a.addView(this.f387338c, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) (TypedValue.applyDimension(1, 38.0f, displayMetrics) + 0.5f);
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 38.0f, displayMetrics) + 0.5f);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        layoutParams4.rightMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387339d = imageView;
        imageView.setId(R.id.wqb);
        this.f387339d.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_media_input_emoji));
        this.f387336a.addView(this.f387339d, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams5.height = (int) resources.getDimension(R.dimen.cdb);
        layoutParams5.weight = 1.0f;
        layoutParams5.leftMargin = (int) resources.getDimension(R.dimen.f158703ms);
        layoutParams5.rightMargin = (int) resources.getDimension(R.dimen.f158723nd);
        layoutParams5.bottomMargin = (int) resources.getDimension(R.dimen.f158983ch3);
        LinearLayout linearLayout3 = new LinearLayout(context, null);
        this.f387340e = linearLayout3;
        linearLayout3.setId(R.id.wq9);
        this.f387340e.setGravity(17);
        this.f387340e.setVisibility(8);
        this.f387340e.setOrientation(0);
        d.e(this.f387340e);
        this.f387340e.setBackground(context.getResources().getDrawable(R.drawable.guild_media_input_bar_no_content_bg));
        linearLayout.addView(this.f387340e, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams6.height = -1;
        layoutParams6.weight = 1.0f;
        ImageView imageView2 = new ImageView(context, null);
        this.f387341f = imageView2;
        imageView2.setId(R.id.wq_);
        this.f387341f.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_media_aio_hint_icon));
        this.f387340e.addView(this.f387341f, layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) (TypedValue.applyDimension(1, 0.4f, displayMetrics) + 0.5f);
        layoutParams7.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams7.gravity = 16;
        View view = new View(context, null);
        d.e(view);
        view.setBackground(new ColorDrawable(Color.parseColor("#838387")));
        this.f387340e.addView(view, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams8.height = -1;
        layoutParams8.weight = 1.0f;
        ImageView imageView3 = new ImageView(context, null);
        this.f387342g = imageView3;
        imageView3.setId(R.id.wq8);
        this.f387342g.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_media_input_emoji));
        this.f387340e.addView(this.f387342g, layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.height = (int) resources.getDimension(R.dimen.cdb);
        layoutParams9.leftMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams9.rightMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams9.bottomMargin = (int) resources.getDimension(R.dimen.f158983ch3);
        LinearLayout linearLayout4 = new LinearLayout(context, null);
        this.f387343h = linearLayout4;
        linearLayout4.setClipChildren(false);
        this.f387343h.setId(R.id.sx6);
        this.f387343h.setGravity(16);
        this.f387343h.setVisibility(8);
        d.e(this.f387343h);
        this.f387343h.setBackground(context.getResources().getDrawable(R.drawable.guild_media_raise_hand_bg));
        this.f387343h.setPadding((int) resources.getDimension(R.dimen.f158703ms), 0, (int) resources.getDimension(R.dimen.f158703ms), 0);
        linearLayout.addView(this.f387343h, layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.width = (int) resources.getDimension(R.dimen.cdc);
        layoutParams10.height = (int) resources.getDimension(R.dimen.cdc);
        ImageView imageView4 = new ImageView(context, null);
        this.f387344i = imageView4;
        imageView4.setId(R.id.sx7);
        this.f387343h.addView(this.f387344i, layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.width = (int) resources.getDimension(R.dimen.cdc);
        layoutParams11.height = (int) resources.getDimension(R.dimen.cdc);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context, null);
        this.f387345j = lottieAnimationView;
        lottieAnimationView.setId(R.id.f164511sx4);
        this.f387345j.setVisibility(8);
        this.f387343h.addView(this.f387345j, layoutParams11);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.leftMargin = (int) resources.getDimension(R.dimen.f158699mo);
        TextView textView2 = new TextView(context, null);
        textView2.setText(resources.getString(R.string.f14977137));
        textView2.setTextSize(0, (int) resources.getDimension(R.dimen.f158706mv));
        textView2.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        textView2.setIncludeFontPadding(false);
        textView2.setTextColor(resources.getColor(R.color.f158017al3));
        this.f387343h.addView(textView2, layoutParams12);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.height = (int) resources.getDimension(R.dimen.cdb);
        layoutParams13.leftMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams13.rightMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams13.bottomMargin = (int) resources.getDimension(R.dimen.f158983ch3);
        TextView textView3 = new TextView(context, null);
        this.f387346k = textView3;
        textView3.setText(resources.getString(R.string.f140250dg));
        this.f387346k.setTextSize(0, (int) resources.getDimension(R.dimen.aw5));
        this.f387346k.setTextColor(resources.getColor(R.color.f158017al3));
        this.f387346k.setId(R.id.vzm);
        this.f387346k.setMaxLines(1);
        this.f387346k.setGravity(17);
        this.f387346k.setVisibility(8);
        d.e(this.f387346k);
        this.f387346k.setBackground(context.getResources().getDrawable(R.drawable.guild_audio_queue_btn_active_bg));
        this.f387346k.setPadding((int) resources.getDimension(R.dimen.c9y), 0, (int) resources.getDimension(R.dimen.c9y), 0);
        linearLayout.addView(this.f387346k, layoutParams13);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams14.width = (int) resources.getDimension(R.dimen.cdb);
        layoutParams14.height = (int) resources.getDimension(R.dimen.cdb);
        layoutParams14.leftMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams14.rightMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams14.bottomMargin = (int) resources.getDimension(R.dimen.f158983ch3);
        ImageView imageView5 = new ImageView(context, null);
        this.f387347l = imageView5;
        imageView5.setId(R.id.sx9);
        d.e(this.f387347l);
        this.f387347l.setBackground(context.getResources().getDrawable(R.drawable.guild_media_input_bar_no_content_bg));
        linearLayout.addView(this.f387347l, layoutParams14);
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams15.bottomMargin = (int) resources.getDimension(R.dimen.f158983ch3);
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387348m = frameLayout;
        frameLayout.setId(R.id.f164510sx3);
        this.f387348m.setClipChildren(false);
        this.f387348m.setVisibility(8);
        linearLayout.addView(this.f387348m, layoutParams15);
        FrameLayout.LayoutParams layoutParams16 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams16.width = (int) resources.getDimension(R.dimen.cdb);
        layoutParams16.height = (int) resources.getDimension(R.dimen.cdb);
        layoutParams16.leftMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams16.topMargin = (int) resources.getDimension(R.dimen.f158720na);
        layoutParams16.rightMargin = (int) resources.getDimension(R.dimen.f158726ng);
        ImageView imageView6 = new ImageView(context, null);
        this.f387349n = imageView6;
        imageView6.setId(R.id.f164509sx2);
        d.e(this.f387349n);
        this.f387349n.setBackground(context.getResources().getDrawable(R.drawable.guild_media_input_bar_no_content_bg));
        this.f387348m.addView(this.f387349n, layoutParams16);
        FrameLayout.LayoutParams layoutParams17 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams17.height = (int) resources.getDimension(R.dimen.c9y);
        layoutParams17.leftMargin = (int) resources.getDimension(R.dimen.f158717n7);
        TextView textView4 = new TextView(context, null);
        this.f387350o = textView4;
        textView4.setText("12");
        this.f387350o.setTextSize(0, (int) resources.getDimension(R.dimen.f158729nj));
        this.f387350o.setTextColor(resources.getColor(R.color.f158017al3));
        this.f387350o.setId(R.id.sx5);
        this.f387350o.setMinimumWidth((int) resources.getDimension(R.dimen.c9y));
        this.f387350o.setGravity(17);
        this.f387350o.setVisibility(8);
        d.e(this.f387350o);
        this.f387350o.setBackground(context.getResources().getDrawable(R.drawable.ji_));
        this.f387350o.setPadding((int) resources.getDimension(R.dimen.f158726ng), 0, (int) resources.getDimension(R.dimen.f158726ng), 0);
        this.f387348m.addView(this.f387350o, layoutParams17);
        LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams18.width = (int) resources.getDimension(R.dimen.cdb);
        layoutParams18.height = (int) resources.getDimension(R.dimen.cdb);
        layoutParams18.leftMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams18.rightMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams18.bottomMargin = (int) resources.getDimension(R.dimen.f158983ch3);
        ImageView imageView7 = new ImageView(context, null);
        this.f387351p = imageView7;
        imageView7.setId(R.id.f164508sx1);
        this.f387351p.setVisibility(8);
        d.e(this.f387351p);
        this.f387351p.setBackground(context.getResources().getDrawable(R.drawable.guild_audio_bottom_bar_icon_bg));
        linearLayout.addView(this.f387351p, layoutParams18);
        LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams19.bottomMargin = (int) resources.getDimension(R.dimen.f158983ch3);
        layoutParams19.setMarginStart((int) resources.getDimension(R.dimen.f158726ng));
        layoutParams19.setMarginEnd((int) resources.getDimension(R.dimen.f158726ng));
        GuildFreeGiftView guildFreeGiftView = new GuildFreeGiftView(context, null);
        this.f387352q = guildFreeGiftView;
        guildFreeGiftView.setId(R.id.swx);
        linearLayout.addView(this.f387352q, layoutParams19);
        LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams20.width = (int) resources.getDimension(R.dimen.cdb);
        layoutParams20.height = (int) resources.getDimension(R.dimen.cdb);
        layoutParams20.bottomMargin = (int) resources.getDimension(R.dimen.f158983ch3);
        layoutParams20.setMarginStart((int) resources.getDimension(R.dimen.f158726ng));
        layoutParams20.setMarginEnd((int) resources.getDimension(R.dimen.f158726ng));
        FrameLayout frameLayout2 = new FrameLayout(context, null);
        linearLayout.addView(frameLayout2, layoutParams20);
        FrameLayout.LayoutParams layoutParams21 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams21.width = (int) resources.getDimension(R.dimen.cdb);
        layoutParams21.height = (int) resources.getDimension(R.dimen.cdb);
        ImageView imageView8 = new ImageView(context, null);
        this.f387353r = imageView8;
        imageView8.setId(R.id.f164504sx0);
        this.f387353r.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        this.f387353r.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_media_bottom_sale_gift_press));
        d.e(this.f387353r);
        this.f387353r.setBackground(context.getResources().getDrawable(R.drawable.guild_media_input_bar_no_content_bg));
        frameLayout2.addView(this.f387353r, layoutParams21);
        FrameLayout.LayoutParams layoutParams22 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams22.width = -1;
        layoutParams22.height = -1;
        ScanningView scanningView = new ScanningView(context, null);
        this.f387354s = scanningView;
        scanningView.setId(R.id.f79734_k);
        this.f387354s.setGuildScanViewRoundRadius((int) (TypedValue.applyDimension(1, 19.0f, displayMetrics) + 0.5f));
        frameLayout2.addView(this.f387354s, layoutParams22);
        LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams23.width = (int) resources.getDimension(R.dimen.cdb);
        layoutParams23.height = (int) resources.getDimension(R.dimen.cdb);
        layoutParams23.leftMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams23.rightMargin = (int) resources.getDimension(R.dimen.c9y);
        layoutParams23.bottomMargin = (int) resources.getDimension(R.dimen.f158983ch3);
        ImageView imageView9 = new ImageView(context, null);
        this.f387355t = imageView9;
        imageView9.setId(R.id.swz);
        this.f387355t.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        this.f387355t.setVisibility(8);
        d.e(this.f387355t);
        this.f387355t.setBackground(context.getResources().getDrawable(R.drawable.guild_media_input_bar_no_content_bg));
        linearLayout.addView(this.f387355t, layoutParams23);
        return linearLayout;
    }

    public View u() {
        return this.f387356u;
    }
}
