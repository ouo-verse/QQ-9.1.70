package com.tx.x2j;

import android.animation.AnimatorInflater;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.view.GuildChannelNameTextView;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.widget.GuildBannerTitleLayout;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.widget.RoundImageView;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildHomeHeaderChannelTitleLayoutInStandaloneBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public FrameLayout f387304a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f387305b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f387306c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f387307d;

    /* renamed from: e, reason: collision with root package name */
    public FrameLayout f387308e;

    /* renamed from: f, reason: collision with root package name */
    public View f387309f;

    /* renamed from: g, reason: collision with root package name */
    public RoundImageView f387310g;

    /* renamed from: h, reason: collision with root package name */
    public LinearLayout f387311h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f387312i;

    /* renamed from: j, reason: collision with root package name */
    public GuildBannerTitleLayout f387313j;

    /* renamed from: k, reason: collision with root package name */
    public GuildChannelNameTextView f387314k;

    /* renamed from: l, reason: collision with root package name */
    public LinearLayout f387315l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f387316m;

    /* renamed from: n, reason: collision with root package name */
    public ShadowFrameLayout f387317n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f387318o;

    /* renamed from: p, reason: collision with root package name */
    public FrameLayout f387319p;

    /* renamed from: q, reason: collision with root package name */
    public ImageView f387320q;

    /* renamed from: r, reason: collision with root package name */
    public GuildDragTextView f387321r;

    /* renamed from: s, reason: collision with root package name */
    public ImageView f387322s;

    /* renamed from: t, reason: collision with root package name */
    public FrameLayout f387323t;

    /* renamed from: u, reason: collision with root package name */
    public ImageView f387324u;

    /* renamed from: v, reason: collision with root package name */
    public ImageView f387325v;

    /* renamed from: w, reason: collision with root package name */
    public ImageView f387326w;

    /* renamed from: x, reason: collision with root package name */
    public View f387327x;

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
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387304a = frameLayout;
        this.f387327x = frameLayout;
        frameLayout.setId(R.id.root);
        this.f387304a.setClipChildren(false);
        this.f387304a.setClipToPadding(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -1;
        ImageView imageView = new ImageView(context, null);
        this.f387305b = imageView;
        imageView.setId(R.id.f164897b91);
        this.f387305b.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f387304a.addView(this.f387305b, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.height = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
        layoutParams2.setMarginEnd((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387306c = linearLayout;
        linearLayout.setId(R.id.title_container);
        this.f387306c.setClipChildren(false);
        this.f387306c.setClipToPadding(false);
        this.f387304a.addView(this.f387306c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) (TypedValue.applyDimension(1, 34.0f, displayMetrics) + 0.5f);
        layoutParams3.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        layoutParams3.gravity = 16;
        ImageView imageView2 = new ImageView(context, null);
        this.f387307d = imageView2;
        imageView2.setId(R.id.jo8);
        this.f387307d.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        this.f387307d.setPadding((int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        this.f387306c.addView(this.f387307d, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.setMarginStart((int) (TypedValue.applyDimension(1, 8.66f, displayMetrics) + 0.5f));
        FrameLayout frameLayout2 = new FrameLayout(context, null);
        this.f387308e = frameLayout2;
        frameLayout2.setId(R.id.vzz);
        this.f387308e.setVisibility(8);
        this.f387306c.addView(this.f387308e, layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) (TypedValue.applyDimension(1, 30.0f, displayMetrics) + 0.5f);
        layoutParams5.height = (int) (TypedValue.applyDimension(1, 30.0f, displayMetrics) + 0.5f);
        View view = new View(context, null);
        this.f387309f = view;
        view.setId(R.id.wih);
        this.f387309f.setVisibility(8);
        d.e(this.f387309f);
        this.f387309f.setBackground(context.getResources().getDrawable(R.drawable.guild_background_radius_4dp_white));
        this.f387308e.addView(this.f387309f, layoutParams5);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams6.width = (int) (TypedValue.applyDimension(1, 29.0f, displayMetrics) + 0.5f);
        layoutParams6.height = (int) (TypedValue.applyDimension(1, 29.0f, displayMetrics) + 0.5f);
        layoutParams6.topMargin = (int) (TypedValue.applyDimension(1, 0.5f, displayMetrics) + 0.5f);
        layoutParams6.setMarginStart((int) (TypedValue.applyDimension(1, 0.5f, displayMetrics) + 0.5f));
        RoundImageView roundImageView = new RoundImageView(context, null);
        this.f387310g = roundImageView;
        roundImageView.setId(R.id.f98495n9);
        this.f387310g.setQwRadius((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        this.f387308e.addView(this.f387310g, layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams7.gravity = 16;
        layoutParams7.weight = 1.0f;
        layoutParams7.setMarginStart((int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f));
        layoutParams7.setMarginEnd((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387311h = linearLayout2;
        linearLayout2.setId(R.id.wrx);
        this.f387311h.setVisibility(8);
        this.f387311h.setOrientation(1);
        this.f387311h.setPadding(0, (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f), 0, 0);
        this.f387306c.addView(this.f387311h, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.gravity = 16;
        LinearLayout linearLayout3 = new LinearLayout(context, null);
        this.f387312i = linearLayout3;
        linearLayout3.setId(R.id.jnz);
        this.f387312i.setGravity(16);
        this.f387312i.setOrientation(0);
        this.f387311h.addView(this.f387312i, layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams9.weight = 1.0f;
        GuildBannerTitleLayout guildBannerTitleLayout = new GuildBannerTitleLayout(context, null);
        this.f387313j = guildBannerTitleLayout;
        guildBannerTitleLayout.setId(R.id.w0k);
        this.f387313j.setClipChildren(false);
        this.f387313j.setClipToPadding(false);
        this.f387312i.addView(this.f387313j, layoutParams9);
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-2, -2);
        GuildChannelNameTextView guildChannelNameTextView = new GuildChannelNameTextView(context, null);
        this.f387314k = guildChannelNameTextView;
        guildChannelNameTextView.setTextSize(0, (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f));
        this.f387314k.setSingleLine(true);
        this.f387314k.setTypeface(Typeface.create("PingFangHK-Medium", 0));
        this.f387314k.setId(R.id.f98175md);
        this.f387314k.setEllipsize(TextUtils.TruncateAt.END);
        this.f387314k.setMaxLines(1);
        this.f387314k.setVisibility(0);
        this.f387314k.setIncludeFontPadding(false);
        d.h(this.f387314k, 0, "PingFangHK-Medium", null, -1, -1);
        this.f387313j.addView(this.f387314k, layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.gravity = 16;
        LinearLayout linearLayout4 = new LinearLayout(context, null);
        this.f387315l = linearLayout4;
        linearLayout4.setId(R.id.wqt);
        this.f387315l.setGravity(16);
        this.f387315l.setOrientation(0);
        this.f387311h.addView(this.f387315l, layoutParams11);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.setMarginStart((int) resources.getDimension(R.dimen.f158712n1));
        TextView textView = new TextView(context, null);
        this.f387316m = textView;
        textView.setId(R.id.wqv);
        this.f387316m.setTextSize(0, (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f));
        this.f387315l.addView(this.f387316m, layoutParams12);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.gravity = 16;
        layoutParams13.setMarginEnd((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f));
        ShadowFrameLayout shadowFrameLayout = new ShadowFrameLayout(context, null);
        this.f387317n = shadowFrameLayout;
        shadowFrameLayout.setId(R.id.f1067369i);
        this.f387317n.setShadowRadius((int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f));
        this.f387317n.setCornerRadius((int) (TypedValue.applyDimension(1, 100.0f, displayMetrics) + 0.5f));
        this.f387317n.setShadowColor(resources.getColor(R.color.boy));
        this.f387306c.addView(this.f387317n, layoutParams13);
        FrameLayout.LayoutParams layoutParams14 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams14.gravity = 17;
        TextView textView2 = new TextView(context, null);
        this.f387318o = textView2;
        textView2.setId(R.id.f1067269h);
        this.f387318o.setTextSize(0, (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f));
        this.f387318o.setText("\u7b7e\u5230");
        this.f387318o.setPadding((int) (TypedValue.applyDimension(1, 13.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 13.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f));
        this.f387317n.addView(this.f387318o, layoutParams14);
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams15.width = (int) (TypedValue.applyDimension(1, 34.0f, displayMetrics) + 0.5f);
        layoutParams15.height = (int) (TypedValue.applyDimension(1, 34.0f, displayMetrics) + 0.5f);
        layoutParams15.gravity = 16;
        layoutParams15.setMarginEnd((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        FrameLayout frameLayout3 = new FrameLayout(context, null);
        this.f387319p = frameLayout3;
        frameLayout3.setId(R.id.f98095m6);
        this.f387306c.addView(this.f387319p, layoutParams15);
        FrameLayout.LayoutParams layoutParams16 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams16.width = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        layoutParams16.height = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        layoutParams16.gravity = 16;
        ImageView imageView3 = new ImageView(context, null);
        this.f387320q = imageView3;
        imageView3.setId(R.id.f98725nv);
        this.f387320q.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f387320q.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        int applyDimension = (int) (TypedValue.applyDimension(1, 3.5f, displayMetrics) + 0.5f);
        this.f387320q.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        this.f387319p.addView(this.f387320q, layoutParams16);
        FrameLayout.LayoutParams layoutParams17 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams17.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams17.gravity = 5;
        GuildDragTextView guildDragTextView = new GuildDragTextView(context, null);
        this.f387321r = guildDragTextView;
        guildDragTextView.setTextSize(0, (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f));
        this.f387321r.setSingleLine(true);
        this.f387321r.setTextColor(resources.getColor(R.color.skin_notification));
        this.f387321r.setId(R.id.f98105m7);
        this.f387321r.setGravity(17);
        this.f387321r.setVisibility(8);
        this.f387321r.setIncludeFontPadding(false);
        this.f387319p.addView(this.f387321r, layoutParams17);
        LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams18.width = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        layoutParams18.height = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        layoutParams18.gravity = 16;
        layoutParams18.setMarginEnd((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        ImageView imageView4 = new ImageView(context, null);
        this.f387322s = imageView4;
        imageView4.setId(R.id.f98835o6);
        this.f387322s.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f387322s.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        int applyDimension2 = (int) (TypedValue.applyDimension(1, 3.5f, displayMetrics) + 0.5f);
        this.f387322s.setPadding(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
        this.f387306c.addView(this.f387322s, layoutParams18);
        LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams19.width = (int) (TypedValue.applyDimension(1, 30.5f, displayMetrics) + 0.5f);
        layoutParams19.height = (int) (TypedValue.applyDimension(1, 30.5f, displayMetrics) + 0.5f);
        layoutParams19.gravity = 16;
        layoutParams19.setMarginEnd((int) (TypedValue.applyDimension(1, 7.5f, displayMetrics) + 0.5f));
        FrameLayout frameLayout4 = new FrameLayout(context, null);
        this.f387323t = frameLayout4;
        frameLayout4.setId(R.id.f98825o5);
        this.f387306c.addView(this.f387323t, layoutParams19);
        FrameLayout.LayoutParams layoutParams20 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams20.width = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        layoutParams20.height = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        layoutParams20.gravity = 16;
        ImageView imageView5 = new ImageView(context, null);
        this.f387324u = imageView5;
        imageView5.setId(R.id.jpu);
        this.f387324u.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f387324u.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        int applyDimension3 = (int) (TypedValue.applyDimension(1, 3.5f, displayMetrics) + 0.5f);
        this.f387324u.setPadding(applyDimension3, applyDimension3, applyDimension3, applyDimension3);
        this.f387323t.addView(this.f387324u, layoutParams20);
        FrameLayout.LayoutParams layoutParams21 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams21.width = (int) resources.getDimension(R.dimen.f158729nj);
        layoutParams21.height = (int) resources.getDimension(R.dimen.f158729nj);
        layoutParams21.gravity = 5;
        ImageView imageView6 = new ImageView(context, null);
        this.f387325v = imageView6;
        imageView6.setId(R.id.i4v);
        this.f387325v.setVisibility(8);
        this.f387323t.addView(this.f387325v, layoutParams21);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams22.gravity = 16;
        layoutParams22.setMarginEnd((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f));
        ImageView imageView7 = new ImageView(context, null);
        this.f387326w = imageView7;
        imageView7.setId(R.id.f98915od);
        this.f387326w.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f387326w.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        this.f387306c.addView(this.f387326w, layoutParams22);
        return this.f387304a;
    }

    public View u() {
        return this.f387327x;
    }
}
