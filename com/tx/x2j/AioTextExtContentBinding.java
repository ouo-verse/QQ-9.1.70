package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.widget.CommonImageView;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioTextExtContentBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f387155a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f387156b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f387157c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f387158d;

    /* renamed from: e, reason: collision with root package name */
    public RelativeLayout f387159e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f387160f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f387161g;

    /* renamed from: h, reason: collision with root package name */
    public CommonImageView f387162h;

    /* renamed from: i, reason: collision with root package name */
    public View f387163i;

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        layoutParams.validate();
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387155a = relativeLayout;
        this.f387163i = relativeLayout;
        relativeLayout.setId(R.id.root);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) resources.getDimension(R.dimen.f158711n0);
        RelativeLayout relativeLayout2 = new RelativeLayout(context, null);
        this.f387156b = relativeLayout2;
        relativeLayout2.setId(R.id.f74263vs);
        this.f387156b.setVisibility(8);
        this.f387155a.addView(this.f387156b, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams2.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams2.addRule(15, -1);
        ImageView imageView = new ImageView(context, null);
        this.f387157c = imageView;
        imageView.setId(R.id.f74243vq);
        this.f387157c.setImportantForAccessibility(2);
        this.f387157c.setImageDrawable(context.getResources().getDrawable(R.drawable.f160250mn0));
        this.f387156b.addView(this.f387157c, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(17, R.id.f74243vq);
        layoutParams3.addRule(15, -1);
        layoutParams3.setMarginStart((int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f));
        TextView textView = new TextView(context, null);
        this.f387158d = textView;
        textView.setId(R.id.f74253vr);
        this.f387158d.setText(resources.getString(R.string.yt_));
        this.f387158d.setTextSize(0, (int) resources.getDimension(R.dimen.aym));
        this.f387158d.setTextColor(resources.getColor(R.color.qui_common_text_allwhite_primary));
        this.f387156b.addView(this.f387158d, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.width = -1;
        RelativeLayout relativeLayout3 = new RelativeLayout(context, null);
        this.f387159e = relativeLayout3;
        relativeLayout3.setId(R.id.f74203vm);
        this.f387159e.setVisibility(0);
        d.e(this.f387159e);
        this.f387159e.setBackground(context.getResources().getDrawable(R.drawable.j97));
        this.f387155a.addView(this.f387159e, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f);
        layoutParams5.setMarginStart((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        layoutParams5.setMarginEnd((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        TextView textView2 = new TextView(context, null);
        this.f387160f = textView2;
        textView2.setId(R.id.f74233vp);
        this.f387160f.setTextSize(0, (int) resources.getDimension(R.dimen.ayp));
        this.f387160f.setEllipsize(TextUtils.TruncateAt.END);
        this.f387160f.setMaxLines(2);
        this.f387160f.setTextColor(resources.getColor(R.color.qui_common_bubble_host_text_primary));
        this.f387159e.addView(this.f387160f, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.width = -1;
        layoutParams6.addRule(3, R.id.f74233vp);
        layoutParams6.topMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        layoutParams6.bottomMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        layoutParams6.setMarginStart((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        layoutParams6.setMarginEnd((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        LinearLayout linearLayout = new LinearLayout(context, null);
        linearLayout.setOrientation(0);
        this.f387159e.addView(linearLayout, layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams7.weight = 1.0f;
        TextView textView3 = new TextView(context, null);
        this.f387161g = textView3;
        textView3.setId(R.id.f74213vn);
        this.f387161g.setTextSize(0, (int) resources.getDimension(R.dimen.ayk));
        if (Build.VERSION.SDK_INT >= 28) {
            this.f387161g.setLineHeight((int) resources.getDimension(R.dimen.f158711n0));
        }
        this.f387161g.setEllipsize(TextUtils.TruncateAt.END);
        this.f387161g.setMaxLines(3);
        this.f387161g.setTextColor(resources.getColor(R.color.qui_common_bubble_host_text_secondary));
        linearLayout.addView(this.f387161g, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.width = (int) (TypedValue.applyDimension(1, 52.0f, displayMetrics) + 0.5f);
        layoutParams8.height = (int) (TypedValue.applyDimension(1, 52.0f, displayMetrics) + 0.5f);
        layoutParams8.gravity = 16;
        layoutParams8.setMarginStart((int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f));
        CommonImageView commonImageView = new CommonImageView(context, null);
        this.f387162h = commonImageView;
        commonImageView.setId(R.id.f74223vo);
        this.f387162h.setImportantForAccessibility(2);
        this.f387162h.setImageDrawable(context.getResources().getDrawable(R.drawable.mmy));
        linearLayout.addView(this.f387162h, layoutParams8);
        return this.f387155a;
    }

    public View u() {
        return this.f387163i;
    }
}
