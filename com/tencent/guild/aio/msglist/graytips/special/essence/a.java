package com.tencent.guild.aio.msglist.graytips.special.essence;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f111410a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f111411b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f111412c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f111413d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f111414e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f111415f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        a(context);
    }

    public View a(Context context) {
        Resources resources = context.getResources();
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f111410a = constraintLayout;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) TypedValue.applyDimension(1, 18.0f, resources.getDisplayMetrics());
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) TypedValue.applyDimension(1, 18.0f, resources.getDisplayMetrics());
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = (int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.validate();
        ImageView imageView = new ImageView(context, null);
        this.f111411b = imageView;
        imageView.setId(R.id.vs9);
        this.f111411b.setLayoutParams(layoutParams);
        constraintLayout.addView(this.f111411b);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics());
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = (int) TypedValue.applyDimension(1, 17.0f, resources.getDisplayMetrics());
        layoutParams2.topToTop = 0;
        layoutParams2.startToEnd = R.id.vs9;
        layoutParams2.validate();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f111412c = linearLayout;
        linearLayout.setId(R.id.vsi);
        this.f111412c.setOrientation(0);
        this.f111412c.setLayoutParams(layoutParams2);
        constraintLayout.addView(this.f111412c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics());
        TextView textView = new TextView(context, null);
        this.f111413d = textView;
        textView.setId(R.id.vs_);
        this.f111413d.setTextSize(2, 13.0f);
        this.f111413d.setEllipsize(TextUtils.TruncateAt.END);
        this.f111413d.setMaxWidth((int) TypedValue.applyDimension(1, 140.0f, resources.getDisplayMetrics()));
        this.f111413d.setMaxLines(1);
        this.f111413d.setTextColor(ResourcesCompat.getColorStateList(resources, R.color.qui_common_text_link, null));
        this.f111413d.setLayoutParams(layoutParams3);
        this.f111412c.addView(this.f111413d);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.width = -2;
        layoutParams4.height = (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics());
        TextView textView2 = new TextView(context, null);
        this.f111414e = textView2;
        textView2.setId(R.id.vsg);
        this.f111414e.setTextSize(2, 13.0f);
        this.f111414e.setText(" \u7684\u6d88\u606f ");
        this.f111414e.setTextColor(ResourcesCompat.getColorStateList(resources, R.color.qui_common_text_link, null));
        this.f111414e.setLayoutParams(layoutParams4);
        this.f111412c.addView(this.f111414e);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics());
        layoutParams5.topToTop = 0;
        layoutParams5.startToEnd = R.id.vsi;
        layoutParams5.validate();
        TextView textView3 = new TextView(context, null);
        this.f111415f = textView3;
        textView3.setId(R.id.vsh);
        this.f111415f.setTextSize(2, 13.0f);
        this.f111415f.setText(R.string.f143570mf);
        this.f111415f.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f111415f.setLayoutParams(layoutParams5);
        constraintLayout.addView(this.f111415f);
        return constraintLayout;
    }

    public ViewGroup b() {
        return this.f111410a;
    }
}
