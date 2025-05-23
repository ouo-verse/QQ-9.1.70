package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.PttAudioWaveView;
import ty4.a;
import ty4.c;

/* loaded from: classes27.dex */
public class AioPttContentBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f387081a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f387082b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f387083c;

    /* renamed from: d, reason: collision with root package name */
    public RelativeLayout f387084d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f387085e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f387086f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f387087g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f387088h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f387089i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f387090j;

    /* renamed from: k, reason: collision with root package name */
    public PttAudioWaveView f387091k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f387092l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f387093m;

    /* renamed from: n, reason: collision with root package name */
    public ImageView f387094n;

    /* renamed from: o, reason: collision with root package name */
    public ImageView f387095o;

    /* renamed from: p, reason: collision with root package name */
    public ViewStub f387096p;

    /* renamed from: q, reason: collision with root package name */
    public View f387097q;

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
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f387097q = constraintLayout;
        constraintLayout.setFocusable(true);
        constraintLayout.setClickable(true);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = (int) resources.getDimension(R.dimen.bz8);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) resources.getDimension(R.dimen.bzb);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) resources.getDimension(R.dimen.bz5);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) resources.getDimension(R.dimen.bz_);
        layoutParams.validate();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387081a = relativeLayout;
        relativeLayout.setId(R.id.f28770ju);
        this.f387081a.setFocusable(true);
        this.f387081a.setClickable(true);
        constraintLayout.addView(this.f387081a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        layoutParams2.height = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        layoutParams2.addRule(15, -1);
        layoutParams2.leftMargin = (int) (TypedValue.applyDimension(1, 19.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387082b = imageView;
        imageView.setId(R.id.uzh);
        this.f387082b.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f387082b.setVisibility(8);
        this.f387082b.setImageDrawable(context.getResources().getDrawable(R.drawable.c2s));
        this.f387081a.addView(this.f387082b, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(1, R.id.uzh);
        layoutParams3.addRule(15, -1);
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387083c = linearLayout;
        linearLayout.setId(R.id.f28910k8);
        this.f387083c.setGravity(16);
        this.f387083c.setOrientation(0);
        this.f387083c.setPadding((int) resources.getDimension(R.dimen.c07), 0, (int) resources.getDimension(R.dimen.c08), 0);
        this.f387081a.addView(this.f387083c, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.rightMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        RelativeLayout relativeLayout2 = new RelativeLayout(context, null);
        this.f387084d = relativeLayout2;
        relativeLayout2.setId(R.id.f28830k0);
        int applyDimension = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        this.f387084d.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        this.f387083c.addView(this.f387084d, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) resources.getDimension(R.dimen.c0a);
        layoutParams5.height = (int) resources.getDimension(R.dimen.c0a);
        ImageView imageView2 = new ImageView(context, null);
        this.f387085e = imageView2;
        imageView2.setId(R.id.f28820jz);
        this.f387085e.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f387085e.setImageDrawable(context.getResources().getDrawable(R.drawable.j8i));
        this.f387084d.addView(this.f387085e, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.width = (int) resources.getDimension(R.dimen.c09);
        layoutParams6.height = (int) resources.getDimension(R.dimen.c09);
        layoutParams6.addRule(13, -1);
        ImageView imageView3 = new ImageView(context, null);
        this.f387086f = imageView3;
        imageView3.setId(R.id.f28800jx);
        this.f387086f.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f387086f.setImageDrawable(context.getResources().getDrawable(R.drawable.j8l));
        this.f387084d.addView(this.f387086f, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) resources.getDimension(R.dimen.c09);
        layoutParams7.height = (int) resources.getDimension(R.dimen.c09);
        layoutParams7.addRule(13, -1);
        ImageView imageView4 = new ImageView(context, null);
        this.f387087g = imageView4;
        imageView4.setId(R.id.f28810jy);
        this.f387087g.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f387087g.setVisibility(8);
        this.f387087g.setImageDrawable(context.getResources().getDrawable(R.drawable.j8l));
        this.f387084d.addView(this.f387087g, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.width = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        layoutParams8.height = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        ImageView imageView5 = new ImageView(context, null);
        this.f387088h = imageView5;
        imageView5.setId(R.id.f28900k7);
        this.f387088h.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f387088h.setVisibility(8);
        this.f387088h.setImageDrawable(context.getResources().getDrawable(R.drawable.c2s));
        this.f387083c.addView(this.f387088h, layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.height = (int) (TypedValue.applyDimension(1, 42.0f, displayMetrics) + 0.5f);
        TextView textView = new TextView(context, null);
        this.f387089i = textView;
        textView.setId(R.id.f28920k9);
        this.f387089i.setTextSize(0, (int) resources.getDimension(R.dimen.ayk));
        this.f387089i.setGravity(16);
        this.f387089i.setVisibility(8);
        this.f387089i.setPadding(0, 0, (int) resources.getDimension(R.dimen.f158703ms), 0);
        this.f387083c.addView(this.f387089i, layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.width = (int) (TypedValue.applyDimension(1, 58.0f, displayMetrics) + 0.5f);
        layoutParams10.height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        ImageView imageView6 = new ImageView(context, null);
        this.f387090j = imageView6;
        imageView6.setId(R.id.f28930k_);
        this.f387090j.setVisibility(8);
        this.f387083c.addView(this.f387090j, layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.width = (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f);
        layoutParams11.height = (int) (TypedValue.applyDimension(1, 42.0f, displayMetrics) + 0.5f);
        PttAudioWaveView pttAudioWaveView = new PttAudioWaveView(context, null);
        this.f387091k = pttAudioWaveView;
        pttAudioWaveView.setId(R.id.f28750js);
        this.f387083c.addView(this.f387091k, layoutParams11);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams12.height = (int) (TypedValue.applyDimension(1, 42.0f, displayMetrics) + 0.5f);
        ImageView imageView7 = new ImageView(context, null);
        this.f387092l = imageView7;
        imageView7.setId(R.id.f28940ka);
        this.f387092l.setVisibility(8);
        this.f387083c.addView(this.f387092l, layoutParams12);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.leftMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        layoutParams13.rightMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        TextView textView2 = new TextView(context, null);
        this.f387093m = textView2;
        textView2.setId(R.id.f28780jv);
        this.f387093m.setTextSize(0, (int) (TypedValue.applyDimension(2, 14.0f, displayMetrics) + 0.5f));
        this.f387093m.setMaxLines(1);
        this.f387083c.addView(this.f387093m, layoutParams13);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams14.width = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        layoutParams14.height = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        ImageView imageView8 = new ImageView(context, null);
        this.f387094n = imageView8;
        imageView8.setId(R.id.f28790jw);
        this.f387094n.setVisibility(8);
        this.f387081a.addView(this.f387094n, layoutParams14);
        ConstraintLayout.LayoutParams layoutParams15 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams15).width = (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams15).height = (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f);
        layoutParams15.topToTop = R.id.f28770ju;
        layoutParams15.startToEnd = R.id.f28770ju;
        ((ViewGroup.MarginLayoutParams) layoutParams15).leftMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams15).topMargin = (int) (TypedValue.applyDimension(1, -2.0f, displayMetrics) + 0.5f);
        layoutParams15.validate();
        ImageView imageView9 = new ImageView(context, null);
        this.f387095o = imageView9;
        imageView9.setId(R.id.f28870k4);
        this.f387095o.setVisibility(8);
        this.f387095o.setImageDrawable(context.getResources().getDrawable(R.drawable.skin_tips_dot_small));
        constraintLayout.addView(this.f387095o, layoutParams15);
        ConstraintLayout.LayoutParams layoutParams16 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams16.topToBottom = R.id.f28770ju;
        layoutParams16.startToStart = R.id.f28770ju;
        layoutParams16.validate();
        ViewStub viewStub = new ViewStub(context, (AttributeSet) null);
        this.f387096p = viewStub;
        viewStub.setLayoutResource(R.layout.dw5);
        this.f387096p.setLayoutInflater(new a(this.f387096p.getContext(), new AioPttSpeechToTextBinding()));
        this.f387096p.setId(R.id.f28890k6);
        this.f387096p.setInflatedId(R.id.f28880k5);
        constraintLayout.addView(this.f387096p, layoutParams16);
        return constraintLayout;
    }

    public View u() {
        return this.f387097q;
    }
}
