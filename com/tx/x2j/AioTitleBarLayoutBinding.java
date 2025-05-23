package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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
import com.tencent.mobileqq.aio.widget.AIOTitleRelativeLayout;
import com.tencent.mobileqq.aio.widget.CommonTextView;
import com.tencent.mobileqq.aio.widget.QUIBadgeMosaic;
import com.tencent.mobileqq.aio.widget.RedDotImageView;
import ty4.a;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioTitleBarLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f387167a;

    /* renamed from: b, reason: collision with root package name */
    public AIOTitleRelativeLayout f387168b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387169c;

    /* renamed from: d, reason: collision with root package name */
    public QUIBadgeMosaic f387170d;

    /* renamed from: e, reason: collision with root package name */
    public CommonTextView f387171e;

    /* renamed from: f, reason: collision with root package name */
    public CommonTextView f387172f;

    /* renamed from: g, reason: collision with root package name */
    public ViewStub f387173g;

    /* renamed from: h, reason: collision with root package name */
    public View f387174h;

    /* renamed from: i, reason: collision with root package name */
    public ViewStub f387175i;

    /* renamed from: j, reason: collision with root package name */
    public ViewStub f387176j;

    /* renamed from: k, reason: collision with root package name */
    public ViewStub f387177k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f387178l;

    /* renamed from: m, reason: collision with root package name */
    public RedDotImageView f387179m;

    /* renamed from: n, reason: collision with root package name */
    public ViewStub f387180n;

    /* renamed from: o, reason: collision with root package name */
    public ViewStub f387181o;

    /* renamed from: p, reason: collision with root package name */
    public ViewStub f387182p;

    /* renamed from: q, reason: collision with root package name */
    public RedDotImageView f387183q;

    /* renamed from: r, reason: collision with root package name */
    public ImageView f387184r;

    /* renamed from: s, reason: collision with root package name */
    public View f387185s;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=ViewGroup.LayoutParams, key=android:layout_alignParentTop, value=true}");
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=AbsListView.LayoutParams, key=android:layout_alignParentTop, value=true}");
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=FrameLayout.LayoutParams, key=android:layout_alignParentTop, value=true}");
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=LinearLayout.LayoutParams, key=android:layout_alignParentTop, value=true}");
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=RadioGroup.LayoutParams, key=android:layout_alignParentTop, value=true}");
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.addRule(10, -1);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=ConstraintLayout.LayoutParams, key=android:layout_alignParentTop, value=true}");
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=RecyclerView.LayoutParams, key=android:layout_alignParentTop, value=true}");
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387167a = relativeLayout;
        this.f387185s = relativeLayout;
        relativeLayout.setId(R.id.jo9);
        this.f387167a.setImportantForAccessibility(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158287c11);
        AIOTitleRelativeLayout aIOTitleRelativeLayout = new AIOTitleRelativeLayout(context, null);
        this.f387168b = aIOTitleRelativeLayout;
        aIOTitleRelativeLayout.setId(R.id.f98705nt);
        this.f387167a.addView(this.f387168b, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(20, -1);
        layoutParams2.addRule(15, -1);
        layoutParams2.setMarginStart((int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f));
        TextView textView = new TextView(context, null);
        this.f387169c = textView;
        textView.setTextSize(0, (int) (TypedValue.applyDimension(2, 17.0f, displayMetrics) + 0.5f));
        this.f387169c.setFocusable(true);
        this.f387169c.setSingleLine(true);
        this.f387169c.setTextColor(resources.getColor(R.color.skin_bar_btn));
        this.f387169c.setId(R.id.ivTitleBtnLeft);
        this.f387169c.setClickable(true);
        this.f387169c.setGravity(19);
        this.f387169c.setIncludeFontPadding(false);
        d.e(this.f387169c);
        this.f387169c.setBackground(context.getResources().getDrawable(R.drawable.qui_chevron_left));
        this.f387168b.addView(this.f387169c, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(17, R.id.ivTitleBtnLeft);
        layoutParams3.addRule(15, -1);
        layoutParams3.setMarginStart((int) (TypedValue.applyDimension(1, -2.0f, displayMetrics) + 0.5f));
        QUIBadgeMosaic qUIBadgeMosaic = new QUIBadgeMosaic(context, null);
        this.f387170d = qUIBadgeMosaic;
        qUIBadgeMosaic.setId(R.id.f114256su);
        this.f387170d.setImportantForAccessibility(1);
        this.f387168b.addView(this.f387170d, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(17, R.id.f114256su);
        layoutParams4.addRule(15, -1);
        CommonTextView commonTextView = new CommonTextView(context, null);
        this.f387171e = commonTextView;
        commonTextView.setId(R.id.f98175md);
        this.f387171e.setTextSize(0, (int) (TypedValue.applyDimension(2, 16.0f, displayMetrics) + 0.5f));
        this.f387171e.setEllipsize(TextUtils.TruncateAt.END);
        this.f387171e.setSingleLine(true);
        this.f387171e.setTextColor(resources.getColor(R.color.qui_common_text_nav_secondary));
        this.f387168b.addView(this.f387171e, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(8, R.id.f98175md);
        layoutParams5.addRule(6, R.id.f98175md);
        layoutParams5.addRule(1, R.id.f98175md);
        layoutParams5.addRule(17, R.id.f98175md);
        CommonTextView commonTextView2 = new CommonTextView(context, null);
        this.f387172f = commonTextView2;
        commonTextView2.setTextSize(0, (int) (TypedValue.applyDimension(2, 16.0f, displayMetrics) + 0.5f));
        this.f387172f.setSingleLine(true);
        this.f387172f.setTextColor(Color.parseColor("#03081A"));
        this.f387172f.setId(R.id.f98155mb);
        this.f387172f.setEllipsize(TextUtils.TruncateAt.END);
        this.f387172f.setVisibility(8);
        this.f387168b.addView(this.f387172f, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.width = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
        layoutParams6.height = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        layoutParams6.addRule(8, R.id.f98175md);
        layoutParams6.addRule(17, R.id.f98155mb);
        layoutParams6.addRule(15, -1);
        layoutParams6.topMargin = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams6.bottomMargin = (int) (TypedValue.applyDimension(1, 1.5f, displayMetrics) + 0.5f);
        layoutParams6.setMarginStart((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        ViewStub viewStub = new ViewStub(context, (AttributeSet) null);
        this.f387173g = viewStub;
        viewStub.setLayoutResource(R.layout.dwm);
        this.f387173g.setLayoutInflater(new a(this.f387173g.getContext(), new AioTitleBarCommonIvBinding()));
        this.f387173g.setId(R.id.f1198377x);
        this.f387173g.setInflatedId(R.id.f1198377x);
        this.f387168b.addView(this.f387173g, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) (TypedValue.applyDimension(1, 1.0f, displayMetrics) + 0.5f);
        layoutParams7.height = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        layoutParams7.addRule(17, R.id.f1198377x);
        layoutParams7.setMarginStart((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        View view = new View(context, null);
        this.f387174h = view;
        view.setId(R.id.f1198177v);
        this.f387174h.setImportantForAccessibility(2);
        this.f387174h.setVisibility(8);
        d.e(this.f387174h);
        this.f387174h.setBackground(context.getResources().getDrawable(R.drawable.qui_common_icon_tertiary_bg));
        this.f387168b.addView(this.f387174h, layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.height = (int) (TypedValue.applyDimension(1, 21.0f, displayMetrics) + 0.5f);
        layoutParams8.addRule(8, R.id.f98175md);
        layoutParams8.width = (int) (TypedValue.applyDimension(1, 21.0f, displayMetrics) + 0.5f);
        layoutParams8.addRule(6, R.id.f98175md);
        layoutParams8.addRule(17, R.id.f98345mu);
        layoutParams8.addRule(15, -1);
        layoutParams8.topMargin = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams8.bottomMargin = (int) (TypedValue.applyDimension(1, 1.5f, displayMetrics) + 0.5f);
        layoutParams8.setMarginStart((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        ViewStub viewStub2 = new ViewStub(context, (AttributeSet) null);
        this.f387175i = viewStub2;
        viewStub2.setLayoutResource(R.layout.dwm);
        this.f387175i.setLayoutInflater(new a(this.f387175i.getContext(), new AioTitleBarCommonIvBinding()));
        this.f387175i.setInflatedId(R.id.tqe);
        this.f387175i.setId(R.id.tqe);
        this.f387168b.addView(this.f387175i, layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.height = (int) (TypedValue.applyDimension(1, 21.0f, displayMetrics) + 0.5f);
        layoutParams9.addRule(8, R.id.f98175md);
        layoutParams9.width = (int) (TypedValue.applyDimension(1, 21.0f, displayMetrics) + 0.5f);
        layoutParams9.addRule(6, R.id.f98175md);
        layoutParams9.addRule(17, R.id.tqe);
        layoutParams9.addRule(15, -1);
        layoutParams9.topMargin = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams9.bottomMargin = (int) (TypedValue.applyDimension(1, 1.5f, displayMetrics) + 0.5f);
        layoutParams9.setMarginStart((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        ViewStub viewStub3 = new ViewStub(context, (AttributeSet) null);
        this.f387176j = viewStub3;
        viewStub3.setLayoutResource(R.layout.dwm);
        this.f387176j.setLayoutInflater(new a(this.f387176j.getContext(), new AioTitleBarCommonIvBinding()));
        this.f387176j.setInflatedId(R.id.tqf);
        this.f387176j.setId(R.id.tqf);
        this.f387168b.addView(this.f387176j, layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.height = (int) (TypedValue.applyDimension(1, 21.0f, displayMetrics) + 0.5f);
        layoutParams10.addRule(13, -1);
        layoutParams10.addRule(8, R.id.f98175md);
        layoutParams10.width = (int) (TypedValue.applyDimension(1, 21.0f, displayMetrics) + 0.5f);
        layoutParams10.addRule(6, R.id.f98175md);
        layoutParams10.addRule(17, R.id.tqf);
        layoutParams10.addRule(15, -1);
        layoutParams10.topMargin = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams10.bottomMargin = (int) (TypedValue.applyDimension(1, 1.5f, displayMetrics) + 0.5f);
        layoutParams10.setMarginStart((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        ViewStub viewStub4 = new ViewStub(context, (AttributeSet) null);
        this.f387177k = viewStub4;
        viewStub4.setLayoutResource(R.layout.dwm);
        this.f387177k.setLayoutInflater(new a(this.f387177k.getContext(), new AioTitleBarCommonIvBinding()));
        this.f387177k.setImportantForAccessibility(1);
        this.f387177k.setInflatedId(R.id.up5);
        this.f387177k.setId(R.id.up5);
        this.f387168b.addView(this.f387177k, layoutParams10);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(3, R.id.f98175md);
        layoutParams11.addRule(6, R.id.mam);
        layoutParams11.addRule(8, R.id.mam);
        layoutParams11.addRule(5, R.id.f98175md);
        layoutParams11.rightMargin = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387178l = imageView;
        imageView.setId(R.id.f9032526);
        this.f387178l.setImportantForAccessibility(2);
        this.f387178l.setVisibility(8);
        this.f387168b.addView(this.f387178l, layoutParams11);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams12.addRule(16, R.id.f74333vz);
        layoutParams12.addRule(15, -1);
        layoutParams12.addRule(0, R.id.f74333vz);
        layoutParams12.setMarginEnd((int) resources.getDimension(R.dimen.f158703ms));
        RedDotImageView redDotImageView = new RedDotImageView(context, null);
        this.f387179m = redDotImageView;
        redDotImageView.setId(R.id.f74343w0);
        this.f387179m.setScaleType(ImageView.ScaleType.CENTER);
        this.f387179m.setVisibility(8);
        this.f387168b.addView(this.f387179m, layoutParams12);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.addRule(16, R.id.f74333vz);
        layoutParams13.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        layoutParams13.addRule(15, -1);
        ViewStub viewStub5 = new ViewStub(context, (AttributeSet) null);
        this.f387180n = viewStub5;
        viewStub5.setLayoutResource(R.layout.f169160i13);
        this.f387180n.setLayoutInflater(new a(this.f387180n.getContext(), new TroopSquareAioTitleLayoutBinding()));
        this.f387180n.setId(R.id.f10366618);
        this.f387180n.setInflatedId(R.id.f10366618);
        this.f387168b.addView(this.f387180n, layoutParams13);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams14.addRule(16, R.id.f74333vz);
        layoutParams14.height = -1;
        layoutParams14.addRule(0, R.id.f74333vz);
        ViewStub viewStub6 = new ViewStub(context, (AttributeSet) null);
        this.f387181o = viewStub6;
        viewStub6.setLayoutResource(R.layout.fqa);
        this.f387181o.setLayoutInflater(new a(this.f387181o.getContext(), new NtDfTroopGuildTitleTabLayoutBinding()));
        this.f387181o.setId(R.id.f98855o8);
        this.f387181o.setInflatedId(R.id.f98855o8);
        this.f387168b.addView(this.f387181o, layoutParams14);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.width = -1;
        layoutParams15.addRule(1, R.id.ivTitleBtnLeft);
        layoutParams15.addRule(17, R.id.ivTitleBtnLeft);
        layoutParams15.addRule(0, R.id.f74333vz);
        layoutParams15.addRule(15, -1);
        ViewStub viewStub7 = new ViewStub(context, (AttributeSet) null);
        this.f387182p = viewStub7;
        viewStub7.setLayoutResource(R.layout.fpf);
        this.f387182p.setLayoutInflater(new a(this.f387182p.getContext(), new NotifyServiceTitleLeftInfoBinding()));
        this.f387182p.setId(R.id.yhl);
        this.f387182p.setInflatedId(R.id.yhl);
        this.f387168b.addView(this.f387182p, layoutParams15);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams16.addRule(21, -1);
        layoutParams16.addRule(15, -1);
        layoutParams16.setMarginEnd((int) resources.getDimension(R.dimen.c9y));
        RedDotImageView redDotImageView2 = new RedDotImageView(context, null);
        this.f387183q = redDotImageView2;
        redDotImageView2.setId(R.id.f74333vz);
        this.f387183q.setScaleType(ImageView.ScaleType.CENTER);
        this.f387183q.setImageDrawable(context.getResources().getDrawable(R.drawable.j9f));
        this.f387168b.addView(this.f387183q, layoutParams16);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams17.width = -1;
        layoutParams17.height = (int) (TypedValue.applyDimension(0, 1.0f, displayMetrics) + 0.5f);
        layoutParams17.addRule(3, R.id.f98705nt);
        ImageView imageView2 = new ImageView(context, null);
        this.f387184r = imageView2;
        imageView2.setId(R.id.uj_);
        this.f387184r.setVisibility(8);
        d.e(this.f387184r);
        this.f387184r.setBackground(context.getResources().getDrawable(R.drawable.qui_common_border_light_bg));
        this.f387167a.addView(this.f387184r, layoutParams17);
        return this.f387167a;
    }

    public View u() {
        return this.f387185s;
    }
}
