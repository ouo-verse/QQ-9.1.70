package com.tx.x2j;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.util.Xml2LayoutKt;
import ty4.c;
import ty4.d;

/* loaded from: classes38.dex */
public class QqProfilecardTitleLayoutImplBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public View f387509a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f387510b;

    /* renamed from: c, reason: collision with root package name */
    public RelativeLayout f387511c;

    /* renamed from: d, reason: collision with root package name */
    public RelativeLayout f387512d;

    /* renamed from: e, reason: collision with root package name */
    public RelativeLayout f387513e;

    /* renamed from: f, reason: collision with root package name */
    public RelativeLayout f387514f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f387515g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f387516h;

    /* renamed from: i, reason: collision with root package name */
    public RelativeLayout f387517i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f387518j;

    /* renamed from: k, reason: collision with root package name */
    public RelativeLayout f387519k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f387520l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f387521m;

    /* renamed from: n, reason: collision with root package name */
    public RelativeLayout f387522n;

    /* renamed from: o, reason: collision with root package name */
    public ImageView f387523o;

    /* renamed from: p, reason: collision with root package name */
    public View f387524p;

    @Override // ty4.c
    public View m(Context context, LinearLayout linearLayout) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.f387524p = linearLayout;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        FrameLayout frameLayout = new FrameLayout(context, null);
        linearLayout.addView(frameLayout, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.height = (int) (TypedValue.applyDimension(1, 90.0f, displayMetrics) + 0.5f);
        View view = new View(context, null);
        this.f387509a = view;
        view.setId(R.id.oxi);
        d.e(this.f387509a);
        this.f387509a.setBackground(context.getResources().getDrawable(R.drawable.f161204k74));
        frameLayout.addView(this.f387509a, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.width = -1;
        layoutParams3.height = (int) resources.getDimension(R.dimen.title_bar_height);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387510b = linearLayout2;
        linearLayout2.setId(R.id.ow5);
        this.f387510b.setOrientation(1);
        frameLayout.addView(this.f387510b, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.width = -1;
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387511c = relativeLayout;
        relativeLayout.setId(R.id.oxm);
        this.f387511c.setGravity(16);
        int applyDimension = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        this.f387511c.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        this.f387510b.addView(this.f387511c, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.width = -1;
        layoutParams5.height = -1;
        RelativeLayout relativeLayout2 = new RelativeLayout(context, null);
        this.f387512d = relativeLayout2;
        relativeLayout2.setId(R.id.oxf);
        this.f387512d.setFocusable(false);
        this.f387512d.setGravity(16);
        d.e(this.f387512d);
        this.f387512d.setBackground(context.getResources().getDrawable(R.drawable.qui_bg_nav_secondary));
        int applyDimension2 = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        this.f387512d.setPadding(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
        this.f387511c.addView(this.f387512d, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.width = -1;
        layoutParams6.height = (int) resources.getDimension(R.dimen.title_bar_height);
        RelativeLayout relativeLayout3 = new RelativeLayout(context, null);
        this.f387513e = relativeLayout3;
        relativeLayout3.setId(R.id.oxh);
        this.f387513e.setFocusable(false);
        this.f387513e.setGravity(48);
        int applyDimension3 = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        this.f387513e.setPadding(applyDimension3, applyDimension3, applyDimension3, applyDimension3);
        this.f387511c.addView(this.f387513e, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        layoutParams7.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        layoutParams7.addRule(9, -1);
        layoutParams7.addRule(15, -1);
        layoutParams7.leftMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        RelativeLayout relativeLayout4 = new RelativeLayout(context, null);
        this.f387514f = relativeLayout4;
        relativeLayout4.setId(R.id.ovc);
        d.e(this.f387514f);
        this.f387514f.setBackground(context.getResources().getDrawable(R.drawable.f161203k73));
        this.f387513e.addView(this.f387514f, layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.width = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams8.height = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams8.addRule(13, -1);
        ImageView imageView = new ImageView(context, null);
        this.f387515g = imageView;
        imageView.setId(R.id.ovb);
        this.f387515g.setScaleType(ImageView.ScaleType.CENTER);
        this.f387515g.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_chevron_left_icon_navigation_02_selector));
        this.f387514f.addView(this.f387515g, layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.addRule(13, -1);
        TextView textView = new TextView(context, null);
        this.f387516h = textView;
        textView.setId(R.id.ovk);
        this.f387516h.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        this.f387516h.setText(Xml2LayoutKt.NULL_VALUE);
        this.f387516h.setEllipsize(TextUtils.TruncateAt.END);
        this.f387516h.setSingleLine(true);
        this.f387516h.setGravity(17);
        this.f387516h.setTextColor(resources.getColor(R.color.qui_common_text_nav_primary));
        this.f387513e.addView(this.f387516h, layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.height = -1;
        layoutParams10.addRule(11, -1);
        layoutParams10.rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout3 = new LinearLayout(context, null);
        linearLayout3.setGravity(17);
        linearLayout3.setOrientation(0);
        this.f387513e.addView(linearLayout3, layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.width = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        layoutParams11.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        layoutParams11.rightMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        RelativeLayout relativeLayout5 = new RelativeLayout(context, null);
        this.f387517i = relativeLayout5;
        relativeLayout5.setId(R.id.ove);
        this.f387517i.setVisibility(8);
        d.e(this.f387517i);
        this.f387517i.setBackground(context.getResources().getDrawable(R.drawable.f161203k73));
        linearLayout3.addView(this.f387517i, layoutParams11);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams12.width = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams12.height = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams12.addRule(13, -1);
        ImageView imageView2 = new ImageView(context, null);
        this.f387518j = imageView2;
        imageView2.setId(R.id.ovd);
        this.f387518j.setScaleType(ImageView.ScaleType.CENTER);
        this.f387517i.addView(this.f387518j, layoutParams12);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.width = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        layoutParams13.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        layoutParams13.rightMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        RelativeLayout relativeLayout6 = new RelativeLayout(context, null);
        this.f387519k = relativeLayout6;
        relativeLayout6.setId(R.id.ovg);
        this.f387519k.setVisibility(8);
        d.e(this.f387519k);
        this.f387519k.setBackground(context.getResources().getDrawable(R.drawable.f161203k73));
        linearLayout3.addView(this.f387519k, layoutParams13);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams14.width = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams14.height = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams14.addRule(13, -1);
        ImageView imageView3 = new ImageView(context, null);
        this.f387520l = imageView3;
        imageView3.setId(R.id.ovf);
        this.f387520l.setScaleType(ImageView.ScaleType.CENTER);
        this.f387519k.addView(this.f387520l, layoutParams14);
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams15.height = (int) resources.getDimension(R.dimen.title_bar_height);
        TextView textView2 = new TextView(context, null);
        this.f387521m = textView2;
        textView2.setId(R.id.ovj);
        this.f387521m.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        this.f387521m.setEllipsize(TextUtils.TruncateAt.END);
        this.f387521m.setSingleLine(true);
        this.f387521m.setMaxWidth((int) (TypedValue.applyDimension(1, 100.0f, displayMetrics) + 0.5f));
        this.f387521m.setGravity(17);
        this.f387521m.setIncludeFontPadding(false);
        this.f387521m.setTextColor(resources.getColor(R.color.qui_common_icon_nav_secondary));
        linearLayout3.addView(this.f387521m, layoutParams15);
        LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams16.width = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        layoutParams16.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        RelativeLayout relativeLayout7 = new RelativeLayout(context, null);
        this.f387522n = relativeLayout7;
        relativeLayout7.setId(R.id.ovi);
        this.f387522n.setVisibility(8);
        d.e(this.f387522n);
        this.f387522n.setBackground(context.getResources().getDrawable(R.drawable.f161203k73));
        linearLayout3.addView(this.f387522n, layoutParams16);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams17.width = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams17.height = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams17.addRule(13, -1);
        ImageView imageView4 = new ImageView(context, null);
        this.f387523o = imageView4;
        imageView4.setId(R.id.ovh);
        this.f387523o.setScaleType(ImageView.ScaleType.CENTER);
        this.f387522n.addView(this.f387523o, layoutParams17);
        return linearLayout;
    }
}
