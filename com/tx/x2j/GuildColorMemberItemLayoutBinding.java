package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.client.widget.GuildClientIdentityView;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildColorMemberItemLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public ConstraintLayout f387236a;

    /* renamed from: b, reason: collision with root package name */
    public QUICheckBox f387237b;

    /* renamed from: c, reason: collision with root package name */
    public FrameLayout f387238c;

    /* renamed from: d, reason: collision with root package name */
    public GuildUserAvatarView f387239d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f387240e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f387241f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f387242g;

    /* renamed from: h, reason: collision with root package name */
    public LinearLayout f387243h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f387244i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f387245j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f387246k;

    /* renamed from: l, reason: collision with root package name */
    public GuildLevelRoleView f387247l;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f387248m;

    /* renamed from: n, reason: collision with root package name */
    public GuildClientIdentityView f387249n;

    /* renamed from: o, reason: collision with root package name */
    public LinearLayout f387250o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f387251p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f387252q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f387253r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f387254s;

    /* renamed from: t, reason: collision with root package name */
    public View f387255t;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 56.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 56.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 56.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 56.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 56.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 56.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 56.0f, displayMetrics) + 0.5f);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 56.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f387236a = constraintLayout;
        this.f387255t = constraintLayout;
        constraintLayout.setId(R.id.dq8);
        d.e(this.f387236a);
        this.f387236a.setBackground(context.getResources().getDrawable(R.drawable.guild_token_setting_common_bg_selector_bottom_light_bg));
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams.horizontalChainStyle = 2;
        layoutParams.rightToLeft = R.id.f164548a32;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams.bottomToBottom = 0;
        layoutParams.topToTop = 0;
        layoutParams.leftToLeft = 0;
        layoutParams.horizontalBias = 0.0f;
        layoutParams.setMarginStart((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f));
        layoutParams.validate();
        QUICheckBox qUICheckBox = new QUICheckBox(context, null);
        this.f387237b = qUICheckBox;
        qUICheckBox.setButtonDrawable((Drawable) null);
        this.f387237b.setTextSize(0, (int) resources.getDimension(R.dimen.d_v));
        this.f387237b.setTextColor(resources.getColor(R.color.qui_button_text_primary_default));
        this.f387237b.setId(R.id.f82074fw);
        this.f387237b.setGravity(17);
        this.f387237b.setVisibility(8);
        d.e(this.f387237b);
        this.f387237b.setBackground(context.getResources().getDrawable(R.drawable.qui_common_check_box));
        this.f387237b.setType(0);
        this.f387237b.setSizeType(1);
        this.f387236a.addView(this.f387237b, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.bottomToBottom = 0;
        layoutParams2.topToTop = 0;
        layoutParams2.leftToRight = R.id.f82074fw;
        layoutParams2.rightToLeft = R.id.xw7;
        layoutParams2.setMarginStart((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f));
        layoutParams2.validate();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387238c = frameLayout;
        frameLayout.setId(R.id.f164548a32);
        this.f387236a.addView(this.f387238c, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) (TypedValue.applyDimension(1, 40.0f, displayMetrics) + 0.5f);
        layoutParams3.height = (int) (TypedValue.applyDimension(1, 40.0f, displayMetrics) + 0.5f);
        GuildUserAvatarView guildUserAvatarView = new GuildUserAvatarView(context, null);
        this.f387239d = guildUserAvatarView;
        guildUserAvatarView.setId(R.id.xsl);
        this.f387239d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f387238c.addView(this.f387239d, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) (TypedValue.applyDimension(1, 40.0f, displayMetrics) + 0.5f);
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 40.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387240e = imageView;
        imageView.setId(R.id.t1e);
        this.f387238c.addView(this.f387240e, layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        layoutParams5.height = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        layoutParams5.gravity = 8388693;
        ImageView imageView2 = new ImageView(context, null);
        this.f387241f = imageView2;
        imageView2.setId(R.id.xwf);
        this.f387241f.setVisibility(8);
        this.f387241f.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_green_dot_with_ring));
        this.f387238c.addView(this.f387241f, layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams6.leftToRight = R.id.f164548a32;
        layoutParams6.bottomToTop = R.id.xsz;
        layoutParams6.rightToLeft = R.id.jbb;
        layoutParams6.constrainedWidth = true;
        layoutParams6.topToTop = 0;
        layoutParams6.setMarginStart((int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f));
        layoutParams6.validate();
        TextView textView = new TextView(context, null);
        this.f387242g = textView;
        textView.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        this.f387242g.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        this.f387242g.setId(R.id.xw7);
        this.f387242g.setMinimumWidth((int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f));
        this.f387242g.setEllipsize(TextUtils.TruncateAt.END);
        this.f387242g.setMaxLines(1);
        this.f387242g.setGravity(16);
        this.f387242g.setIncludeFontPadding(false);
        this.f387236a.addView(this.f387242g, layoutParams6);
        ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams7.bottomToBottom = R.id.xw7;
        layoutParams7.topToTop = R.id.xw7;
        layoutParams7.leftToRight = R.id.xw7;
        layoutParams7.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams7.validate();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387243h = linearLayout;
        linearLayout.setId(R.id.jbb);
        this.f387243h.setGravity(16);
        this.f387243h.setOrientation(0);
        this.f387236a.addView(this.f387243h, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.width = (int) (TypedValue.applyDimension(1, 61.3f, displayMetrics) + 0.5f);
        layoutParams8.height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams8.setMarginStart((int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f));
        ImageView imageView3 = new ImageView(context, null);
        this.f387244i = imageView3;
        imageView3.setId(R.id.xw9);
        this.f387244i.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f387244i.setVisibility(8);
        int applyDimension = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
        this.f387244i.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        this.f387243h.addView(this.f387244i, layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.width = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams9.height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams9.gravity = 16;
        layoutParams9.setMarginStart((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        ImageView imageView4 = new ImageView(context, null);
        this.f387245j = imageView4;
        imageView4.setId(R.id.xw8);
        this.f387245j.setVisibility(8);
        this.f387243h.addView(this.f387245j, layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.setMarginStart((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        TextView textView2 = new TextView(context, null);
        this.f387246k = textView2;
        textView2.setTextSize(0, (int) (TypedValue.applyDimension(2, 9.0f, displayMetrics) + 0.5f));
        this.f387246k.setTextColor(resources.getColor(R.color.qui_common_text_allwhite_primary));
        this.f387246k.setId(R.id.xvf);
        this.f387246k.setGravity(17);
        this.f387246k.setVisibility(8);
        this.f387246k.setIncludeFontPadding(false);
        d.e(this.f387246k);
        this.f387246k.setBackground(context.getResources().getDrawable(R.drawable.guild_aio_role_icon_identity_bg));
        this.f387246k.setPadding((int) resources.getDimension(R.dimen.f158720na), (int) resources.getDimension(R.dimen.f158712n1), (int) resources.getDimension(R.dimen.f158720na), (int) resources.getDimension(R.dimen.f158712n1));
        this.f387243h.addView(this.f387246k, layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.setMarginStart((int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f));
        GuildLevelRoleView guildLevelRoleView = new GuildLevelRoleView(context, null);
        this.f387247l = guildLevelRoleView;
        guildLevelRoleView.setId(R.id.xvh);
        this.f387247l.setVisibility(8);
        this.f387243h.addView(this.f387247l, layoutParams11);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.width = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        layoutParams12.height = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        layoutParams12.setMarginStart((int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f));
        ImageView imageView5 = new ImageView(context, null);
        this.f387248m = imageView5;
        imageView5.setId(R.id.f767642j);
        this.f387248m.setVisibility(8);
        this.f387248m.setImageDrawable(context.getResources().getDrawable(R.drawable.qq_troop_bot_icon));
        this.f387243h.addView(this.f387248m, layoutParams12);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.height = (int) (TypedValue.applyDimension(1, 19.0f, displayMetrics) + 0.5f);
        layoutParams13.setMarginStart((int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f));
        GuildClientIdentityView guildClientIdentityView = new GuildClientIdentityView(context, null);
        this.f387249n = guildClientIdentityView;
        guildClientIdentityView.setId(R.id.xw5);
        int applyDimension2 = (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f);
        this.f387249n.setPadding(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
        this.f387243h.addView(this.f387249n, layoutParams13);
        ConstraintLayout.LayoutParams layoutParams14 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams14.bottomToBottom = 0;
        layoutParams14.topToBottom = R.id.xw7;
        layoutParams14.leftToLeft = R.id.xw7;
        layoutParams14.horizontalBias = 0.0f;
        layoutParams14.constrainedWidth = true;
        layoutParams14.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams14).rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams14.validate();
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387250o = linearLayout2;
        linearLayout2.setId(R.id.xsz);
        this.f387250o.setVisibility(8);
        this.f387236a.addView(this.f387250o, layoutParams14);
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams15.width = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        layoutParams15.height = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        layoutParams15.gravity = 17;
        layoutParams15.setMarginEnd((int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f));
        ImageView imageView6 = new ImageView(context, null);
        this.f387251p = imageView6;
        imageView6.setId(R.id.xsx);
        this.f387250o.addView(this.f387251p, layoutParams15);
        LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams16.rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        TextView textView3 = new TextView(context, null);
        this.f387252q = textView3;
        textView3.setId(R.id.xsy);
        this.f387252q.setTextSize(0, (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        this.f387252q.setEllipsize(TextUtils.TruncateAt.END);
        this.f387252q.setMaxLines(1);
        this.f387252q.setIncludeFontPadding(false);
        this.f387252q.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387250o.addView(this.f387252q, layoutParams16);
        ConstraintLayout.LayoutParams layoutParams17 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams17).height = (int) (TypedValue.applyDimension(1, 51.0f, displayMetrics) + 0.5f);
        layoutParams17.leftToRight = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams17).width = (int) (TypedValue.applyDimension(1, 115.0f, displayMetrics) + 0.5f);
        layoutParams17.bottomToBottom = 0;
        layoutParams17.topToTop = 0;
        layoutParams17.validate();
        TextView textView4 = new TextView(context, null);
        this.f387253r = textView4;
        textView4.setText("\u8bbe\u7f6e\u7ba1\u7406\u5458");
        this.f387253r.setTextSize(0, (int) (TypedValue.applyDimension(2, 17.0f, displayMetrics) + 0.5f));
        this.f387253r.setFocusable(false);
        this.f387253r.setSingleLine(true);
        this.f387253r.setTextColor(resources.getColor(R.color.f158017al3));
        this.f387253r.setId(R.id.xw_);
        this.f387253r.setClickable(true);
        this.f387253r.setGravity(17);
        d.e(this.f387253r);
        this.f387253r.setBackground(new ColorDrawable(resources.getColor(R.color.f157116k8)));
        this.f387236a.addView(this.f387253r, layoutParams17);
        ConstraintLayout.LayoutParams layoutParams18 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams18).height = (int) (TypedValue.applyDimension(1, 51.0f, displayMetrics) + 0.5f);
        layoutParams18.leftToRight = R.id.xw_;
        ((ViewGroup.MarginLayoutParams) layoutParams18).width = (int) (TypedValue.applyDimension(1, 64.0f, displayMetrics) + 0.5f);
        layoutParams18.bottomToBottom = 0;
        layoutParams18.topToTop = 0;
        layoutParams18.validate();
        TextView textView5 = new TextView(context, null);
        this.f387254s = textView5;
        textView5.setText("\u79fb\u9664");
        this.f387254s.setTextSize(0, (int) (TypedValue.applyDimension(2, 17.0f, displayMetrics) + 0.5f));
        this.f387254s.setFocusable(false);
        this.f387254s.setSingleLine(true);
        this.f387254s.setTextColor(resources.getColor(R.color.f158017al3));
        this.f387254s.setId(R.id.xw6);
        this.f387254s.setClickable(true);
        this.f387254s.setGravity(17);
        d.e(this.f387254s);
        this.f387254s.setBackground(new ColorDrawable(Color.parseColor("#ffff3A30")));
        this.f387236a.addView(this.f387254s, layoutParams18);
        return this.f387236a;
    }

    public View u() {
        return this.f387255t;
    }
}
