package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
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
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.avgame.gamelobby.view.OverlappingImgLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelRootLayout;
import com.tencent.mobileqq.profile.view.ReboundHorizontalScrollView;
import ty4.c;
import ty4.d;

/* loaded from: classes27.dex */
public class AccountPanelImmersiveBinding extends c {
    public ImageView A;
    public View B;
    public ScrollView C;
    public LinearLayout D;
    public FrameLayout E;
    public LinearLayout F;
    public TextView G;
    public ImageView H;
    public ImageView I;
    public ReboundHorizontalScrollView J;
    public LinearLayout K;
    public View L;
    public View M;

    /* renamed from: a, reason: collision with root package name */
    public AccountPanelRootLayout f386996a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f386997b;

    /* renamed from: c, reason: collision with root package name */
    public AutoResizeAsyncImageView f386998c;

    /* renamed from: d, reason: collision with root package name */
    public OnlineStatusLyricView f386999d;

    /* renamed from: e, reason: collision with root package name */
    public View f387000e;

    /* renamed from: f, reason: collision with root package name */
    public ConstraintLayout f387001f;

    /* renamed from: g, reason: collision with root package name */
    public FrameLayout f387002g;

    /* renamed from: h, reason: collision with root package name */
    public LinearLayout f387003h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f387004i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f387005j;

    /* renamed from: k, reason: collision with root package name */
    public FrameLayout f387006k;

    /* renamed from: l, reason: collision with root package name */
    public LinearLayout f387007l;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f387008m;

    /* renamed from: n, reason: collision with root package name */
    public LinearLayout f387009n;

    /* renamed from: o, reason: collision with root package name */
    public FrameLayout f387010o;

    /* renamed from: p, reason: collision with root package name */
    public LinearLayout f387011p;

    /* renamed from: q, reason: collision with root package name */
    public OverlappingImgLayout f387012q;

    /* renamed from: r, reason: collision with root package name */
    public ImageView f387013r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f387014s;

    /* renamed from: t, reason: collision with root package name */
    public ImageView f387015t;

    /* renamed from: u, reason: collision with root package name */
    public FrameLayout f387016u;

    /* renamed from: v, reason: collision with root package name */
    public LinearLayout f387017v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f387018w;

    /* renamed from: x, reason: collision with root package name */
    public FrameLayout f387019x;

    /* renamed from: y, reason: collision with root package name */
    public RelativeLayout f387020y;

    /* renamed from: z, reason: collision with root package name */
    public ImageView f387021z;

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
        AccountPanelRootLayout accountPanelRootLayout = new AccountPanelRootLayout(context, null);
        this.f386996a = accountPanelRootLayout;
        this.M = accountPanelRootLayout;
        accountPanelRootLayout.setId(R.id.if5);
        d.e(this.f386996a);
        this.f386996a.setBackground(new ColorDrawable(resources.getColor(R.color.ajr)));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.addRule(10, -1);
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f386997b = relativeLayout;
        relativeLayout.setId(R.id.zlr);
        this.f386996a.addView(this.f386997b, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        AutoResizeAsyncImageView autoResizeAsyncImageView = new AutoResizeAsyncImageView(context, null);
        this.f386998c = autoResizeAsyncImageView;
        autoResizeAsyncImageView.setId(R.id.zx8);
        this.f386998c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f386998c.setMaxHeight((int) (TypedValue.applyDimension(1, 339.0f, displayMetrics) + 0.5f));
        this.f386998c.setImageDrawable(context.getResources().getDrawable(R.drawable.n4z));
        this.f386998c.setFixedRatio(true);
        this.f386998c.setFixedRatioWidth(75.0f);
        this.f386998c.setFixedRatioHeight(58.0f);
        this.f386997b.addView(this.f386998c, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(2, R.id.zlq);
        layoutParams3.addRule(14, -1);
        OnlineStatusLyricView onlineStatusLyricView = new OnlineStatusLyricView(context, null);
        this.f386999d = onlineStatusLyricView;
        onlineStatusLyricView.setTextSize(0, (int) (TypedValue.applyDimension(2, 17.0f, displayMetrics) + 0.5f));
        this.f386999d.setTextColor(resources.getColor(R.color.cee));
        this.f386999d.setId(R.id.zls);
        this.f386999d.setEllipsize(TextUtils.TruncateAt.END);
        this.f386999d.setMaxLines(1);
        this.f386999d.setVisibility(0);
        d.h(this.f386999d, 0, null, null, 1, -1);
        this.f386999d.setShadowLayer(10.0f, 0.0f, 0.0f, Color.parseColor("#40000000"));
        this.f386997b.addView(this.f386999d, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.width = -1;
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 101.0f, displayMetrics) + 0.5f);
        layoutParams4.addRule(8, R.id.zx8);
        View view = new View(context, null);
        this.f387000e = view;
        view.setId(R.id.zlq);
        this.f386997b.addView(this.f387000e, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) (TypedValue.applyDimension(1, 300.0f, displayMetrics) + 0.5f);
        layoutParams5.height = (int) (TypedValue.applyDimension(1, 300.0f, displayMetrics) + 0.5f);
        layoutParams5.addRule(8, R.id.zx8);
        layoutParams5.addRule(14, -1);
        layoutParams5.topMargin = (int) (TypedValue.applyDimension(1, 39.0f, displayMetrics) + 0.5f);
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f387001f = constraintLayout;
        constraintLayout.setId(R.id.f908153h);
        this.f387001f.setVisibility(8);
        this.f386997b.addView(this.f387001f, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(11, -1);
        layoutParams6.addRule(8, R.id.zx8);
        layoutParams6.rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams6.bottomMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387002g = frameLayout;
        frameLayout.setId(R.id.f908453k);
        this.f387002g.setVisibility(8);
        this.f386997b.addView(this.f387002g, layoutParams6);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        layoutParams7.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387003h = linearLayout;
        linearLayout.setId(R.id.f908353j);
        this.f387003h.setContentDescription("\u7f16\u8f91");
        this.f387003h.setGravity(17);
        this.f387003h.setVisibility(8);
        this.f387003h.setOrientation(0);
        d.e(this.f387003h);
        this.f387003h.setBackground(context.getResources().getDrawable(R.drawable.qui_online_status_avatar_setting_circle_shadow));
        this.f387002g.addView(this.f387003h, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.width = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams8.height = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387004i = imageView;
        imageView.setId(R.id.f908253i);
        this.f387004i.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_edit_icon_white));
        this.f387003h.addView(this.f387004i, layoutParams8);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(context, null);
        this.f387005j = textView;
        textView.setId(R.id.f908553l);
        this.f387005j.setLines(1);
        this.f387005j.setText("\u53bb\u5143\u68a6\u4e4b\u5fc3");
        this.f387005j.setTextSize(0, (int) (TypedValue.applyDimension(2, 14.0f, displayMetrics) + 0.5f));
        this.f387005j.setCompoundDrawableTintList(ColorStateList.valueOf(resources.getColor(R.color.qui_common_text_secondary)));
        this.f387005j.setMaxLines(1);
        this.f387005j.setVisibility(8);
        this.f387005j.setCompoundDrawablePadding((int) resources.getDimension(R.dimen.f158712n1));
        this.f387005j.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387002g.addView(this.f387005j, layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(10, -1);
        layoutParams10.topMargin = (int) (TypedValue.applyDimension(1, 40.0f, displayMetrics) + 0.5f);
        layoutParams10.setMarginStart((int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f));
        FrameLayout frameLayout2 = new FrameLayout(context, null);
        this.f387006k = frameLayout2;
        frameLayout2.setId(R.id.zx5);
        this.f387006k.setVisibility(0);
        int applyDimension = (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f);
        this.f387006k.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        this.f386997b.addView(this.f387006k, layoutParams10);
        FrameLayout.LayoutParams layoutParams11 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams11.width = (int) (TypedValue.applyDimension(1, 36.0f, displayMetrics) + 0.5f);
        layoutParams11.height = (int) (TypedValue.applyDimension(1, 36.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387007l = linearLayout2;
        linearLayout2.setId(R.id.f166459zx4);
        this.f387007l.setGravity(17);
        this.f387007l.setOrientation(0);
        d.e(this.f387007l);
        this.f387007l.setBackground(context.getResources().getDrawable(R.drawable.f160031j23));
        this.f387006k.addView(this.f387007l, layoutParams11);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.width = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams12.height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        ImageView imageView2 = new ImageView(context, null);
        this.f387008m = imageView2;
        imageView2.setId(R.id.zx6);
        this.f387008m.setImageDrawable(context.getResources().getDrawable(R.drawable.j1r));
        this.f387007l.addView(this.f387008m, layoutParams12);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.addRule(10, -1);
        layoutParams13.addRule(21, -1);
        layoutParams13.topMargin = (int) (TypedValue.applyDimension(1, 40.0f, displayMetrics) + 0.5f);
        layoutParams13.setMarginEnd((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f));
        LinearLayout linearLayout3 = new LinearLayout(context, null);
        this.f387009n = linearLayout3;
        linearLayout3.setId(R.id.zy7);
        this.f387009n.setOrientation(0);
        this.f386997b.addView(this.f387009n, layoutParams13);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, -2);
        FrameLayout frameLayout3 = new FrameLayout(context, null);
        this.f387010o = frameLayout3;
        frameLayout3.setId(R.id.zxj);
        this.f387010o.setPadding(0, (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f));
        this.f387009n.addView(this.f387010o, layoutParams14);
        FrameLayout.LayoutParams layoutParams15 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams15.height = (int) (TypedValue.applyDimension(1, 36.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout4 = new LinearLayout(context, null);
        this.f387011p = linearLayout4;
        linearLayout4.setId(R.id.zxh);
        this.f387011p.setGravity(16);
        this.f387011p.setOrientation(0);
        d.e(this.f387011p);
        this.f387011p.setBackground(context.getResources().getDrawable(R.drawable.f160031j23));
        this.f387010o.addView(this.f387011p, layoutParams15);
        LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams16.height = -1;
        layoutParams16.setMarginEnd((int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f));
        OverlappingImgLayout overlappingImgLayout = new OverlappingImgLayout(context, null);
        this.f387012q = overlappingImgLayout;
        overlappingImgLayout.setId(R.id.zy9);
        this.f387012q.setGravity(16);
        this.f387011p.addView(this.f387012q, layoutParams16);
        LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams17.width = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams17.height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        ImageView imageView3 = new ImageView(context, null);
        this.f387013r = imageView3;
        imageView3.setId(R.id.zxg);
        this.f387013r.setContentDescription(resources.getString(R.string.f172342q7));
        this.f387013r.setVisibility(8);
        this.f387011p.addView(this.f387013r, layoutParams17);
        LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams18.height = -1;
        TextView textView2 = new TextView(context, null);
        this.f387014s = textView2;
        textView2.setId(R.id.zxk);
        this.f387014s.setText(resources.getString(R.string.f172342q7));
        this.f387014s.setLines(1);
        this.f387014s.setTextSize(0, (int) (TypedValue.applyDimension(2, 14.0f, displayMetrics) + 0.5f));
        this.f387014s.setEllipsize(TextUtils.TruncateAt.END);
        this.f387014s.setMaxWidth((int) (TypedValue.applyDimension(1, 150.0f, displayMetrics) + 0.5f));
        this.f387014s.setMaxLines(1);
        this.f387014s.setGravity(16);
        this.f387014s.setTextColor(resources.getColor(R.color.ces));
        this.f387011p.addView(this.f387014s, layoutParams18);
        FrameLayout.LayoutParams layoutParams19 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams19.gravity = 8388613;
        layoutParams19.setMarginEnd((int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f));
        ImageView imageView4 = new ImageView(context, null);
        this.f387015t = imageView4;
        imageView4.setId(R.id.zxi);
        this.f387015t.setVisibility(8);
        d.e(this.f387015t);
        this.f387015t.setBackground(context.getResources().getDrawable(R.drawable.k5f));
        this.f387010o.addView(this.f387015t, layoutParams19);
        LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(-2, -2);
        FrameLayout frameLayout4 = new FrameLayout(context, null);
        this.f387016u = frameLayout4;
        frameLayout4.setId(R.id.zwy);
        this.f387016u.setVisibility(8);
        this.f387016u.setPadding((int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f));
        this.f387009n.addView(this.f387016u, layoutParams20);
        FrameLayout.LayoutParams layoutParams21 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams21.height = (int) (TypedValue.applyDimension(1, 36.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout5 = new LinearLayout(context, null);
        this.f387017v = linearLayout5;
        linearLayout5.setId(R.id.zwz);
        this.f387017v.setGravity(17);
        this.f387017v.setOrientation(0);
        d.e(this.f387017v);
        this.f387017v.setBackground(context.getResources().getDrawable(R.drawable.f160031j23));
        this.f387016u.addView(this.f387017v, layoutParams21);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams22.width = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams22.height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        ImageView imageView5 = new ImageView(context, null);
        imageView5.setContentDescription("\u72b6\u6001\u70b9\u8d5e");
        d.e(imageView5);
        imageView5.setBackground(context.getResources().getDrawable(R.drawable.n59));
        this.f387017v.addView(imageView5, layoutParams22);
        LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams23.setMarginStart((int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f));
        TextView textView3 = new TextView(context, null);
        this.f387018w = textView3;
        textView3.setId(R.id.zxl);
        this.f387018w.setTextSize(0, (int) (TypedValue.applyDimension(2, 14.0f, displayMetrics) + 0.5f));
        this.f387018w.setTextColor(resources.getColor(R.color.ces));
        this.f387017v.addView(this.f387018w, layoutParams23);
        LinearLayout.LayoutParams layoutParams24 = new LinearLayout.LayoutParams(-2, -2);
        FrameLayout frameLayout5 = new FrameLayout(context, null);
        this.f387019x = frameLayout5;
        frameLayout5.setId(R.id.f166455zx0);
        this.f387019x.setVisibility(8);
        this.f387019x.setPadding((int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f));
        this.f387009n.addView(this.f387019x, layoutParams24);
        FrameLayout.LayoutParams layoutParams25 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams25.width = (int) (TypedValue.applyDimension(1, 36.0f, displayMetrics) + 0.5f);
        layoutParams25.height = (int) (TypedValue.applyDimension(1, 36.0f, displayMetrics) + 0.5f);
        RelativeLayout relativeLayout2 = new RelativeLayout(context, null);
        this.f387020y = relativeLayout2;
        relativeLayout2.setId(R.id.zyd);
        this.f387020y.setGravity(17);
        d.e(this.f387020y);
        this.f387020y.setBackground(context.getResources().getDrawable(R.drawable.f160031j23));
        this.f387019x.addView(this.f387020y, layoutParams25);
        RelativeLayout.LayoutParams layoutParams26 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams26.width = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams26.height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        ImageView imageView6 = new ImageView(context, null);
        this.f387021z = imageView6;
        imageView6.setId(R.id.f166456zx1);
        this.f387021z.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f387021z.setContentDescription(resources.getString(R.string.f172382qa));
        this.f387021z.setImageDrawable(context.getResources().getDrawable(R.drawable.j1z));
        this.f387020y.addView(this.f387021z, layoutParams26);
        RelativeLayout.LayoutParams layoutParams27 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams27.width = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams27.height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        ImageView imageView7 = new ImageView(context, null);
        this.A = imageView7;
        imageView7.setId(R.id.f166457zx2);
        this.A.setScaleType(ImageView.ScaleType.FIT_XY);
        this.A.setContentDescription(resources.getString(R.string.f172362q9));
        this.A.setVisibility(8);
        this.A.setImageDrawable(context.getResources().getDrawable(R.drawable.j26));
        this.f387020y.addView(this.A, layoutParams27);
        RelativeLayout.LayoutParams layoutParams28 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams28.width = -1;
        layoutParams28.height = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams28.addRule(3, R.id.zlr);
        layoutParams28.addRule(12, -1);
        View view2 = new View(context, null);
        this.B = view2;
        view2.setId(R.id.zxo);
        d.e(this.B);
        this.B.setBackground(new ColorDrawable(Color.parseColor("#DAEAFA")));
        this.f386996a.addView(this.B, layoutParams28);
        RelativeLayout.LayoutParams layoutParams29 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams29.width = -1;
        layoutParams29.addRule(3, R.id.zlr);
        ScrollView scrollView = new ScrollView(context, null);
        this.C = scrollView;
        scrollView.setId(R.id.b9j);
        this.C.setPadding(0, 0, 0, (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f));
        this.f386996a.addView(this.C, layoutParams29);
        FrameLayout.LayoutParams layoutParams30 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams30.width = -1;
        LinearLayout linearLayout6 = new LinearLayout(context, null);
        this.D = linearLayout6;
        linearLayout6.setId(R.id.b_7);
        this.D.setOrientation(1);
        this.C.addView(this.D, layoutParams30);
        LinearLayout.LayoutParams layoutParams31 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams31.width = -1;
        FrameLayout frameLayout6 = new FrameLayout(context, null);
        this.E = frameLayout6;
        frameLayout6.setId(R.id.fda);
        this.D.addView(this.E, layoutParams31);
        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams32.width = -1;
        layoutParams32.gravity = 1;
        layoutParams32.leftMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        layoutParams32.topMargin = (int) (TypedValue.applyDimension(1, 31.0f, displayMetrics) + 0.5f);
        layoutParams32.rightMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout7 = new LinearLayout(context, null);
        this.F = linearLayout7;
        linearLayout7.setId(R.id.f163903bt);
        this.F.setOrientation(1);
        d.e(this.F);
        this.F.setBackground(context.getResources().getDrawable(R.drawable.jj6));
        this.D.addView(this.F, layoutParams32);
        LinearLayout.LayoutParams layoutParams33 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams33.gravity = 1;
        layoutParams33.topMargin = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams33.bottomMargin = (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f);
        TextView textView4 = new TextView(context, null);
        this.G = textView4;
        textView4.setId(R.id.f163900bq);
        this.G.setText(resources.getString(R.string.f170711zm));
        this.G.setTextSize(0, (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        this.G.setTextColor(resources.getColor(R.color.cee));
        this.F.addView(this.G, layoutParams33);
        LinearLayout.LayoutParams layoutParams34 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams34.width = -1;
        layoutParams34.bottomMargin = (int) (TypedValue.applyDimension(1, 9.0f, displayMetrics) + 0.5f);
        RelativeLayout relativeLayout3 = new RelativeLayout(context, null);
        relativeLayout3.setGravity(1);
        relativeLayout3.setPadding((int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f), 0);
        this.F.addView(relativeLayout3, layoutParams34);
        RelativeLayout.LayoutParams layoutParams35 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams35.width = (int) (TypedValue.applyDimension(1, 48.0f, displayMetrics) + 0.5f);
        layoutParams35.height = (int) (TypedValue.applyDimension(1, 48.0f, displayMetrics) + 0.5f);
        layoutParams35.addRule(11, -1);
        layoutParams35.addRule(15, -1);
        layoutParams35.leftMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        layoutParams35.rightMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        ImageView imageView8 = new ImageView(context, null);
        this.H = imageView8;
        imageView8.setId(R.id.dv8);
        this.H.setContentDescription(resources.getString(R.string.aa7));
        this.H.setImageDrawable(context.getResources().getDrawable(R.drawable.j1v));
        relativeLayout3.addView(this.H, layoutParams35);
        RelativeLayout.LayoutParams layoutParams36 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams36.width = (int) (TypedValue.applyDimension(1, 48.0f, displayMetrics) + 0.5f);
        layoutParams36.height = (int) (TypedValue.applyDimension(1, 48.0f, displayMetrics) + 0.5f);
        layoutParams36.addRule(15, -1);
        layoutParams36.addRule(0, R.id.dv8);
        layoutParams36.leftMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        layoutParams36.rightMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        ImageView imageView9 = new ImageView(context, null);
        this.I = imageView9;
        imageView9.setId(R.id.xzo);
        this.I.setContentDescription(resources.getString(R.string.f5u));
        this.I.setImageDrawable(context.getResources().getDrawable(R.drawable.j1p));
        relativeLayout3.addView(this.I, layoutParams36);
        RelativeLayout.LayoutParams layoutParams37 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams37.addRule(0, R.id.xzo);
        layoutParams37.addRule(15, -1);
        ReboundHorizontalScrollView reboundHorizontalScrollView = new ReboundHorizontalScrollView(context, null);
        this.J = reboundHorizontalScrollView;
        reboundHorizontalScrollView.setId(R.id.s87);
        relativeLayout3.addView(this.J, layoutParams37);
        FrameLayout.LayoutParams layoutParams38 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams38.width = -1;
        LinearLayout linearLayout8 = new LinearLayout(context, null);
        this.K = linearLayout8;
        linearLayout8.setId(R.id.f163886b8);
        this.K.setOrientation(0);
        this.J.addView(this.K, layoutParams38);
        RelativeLayout.LayoutParams layoutParams39 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams39.width = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        layoutParams39.height = (int) (TypedValue.applyDimension(1, 62.0f, displayMetrics) + 0.5f);
        layoutParams39.addRule(7, R.id.s87);
        View view3 = new View(context, null);
        this.L = view3;
        view3.setId(R.id.f84074l_);
        this.L.setClickable(false);
        d.e(this.L);
        this.L.setBackground(context.getResources().getDrawable(R.drawable.n4t));
        relativeLayout3.addView(this.L, layoutParams39);
        return this.f386996a;
    }
}
