package com.tencent.guild.aio.msglist.graytips.special.revoke;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f111449a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f111450b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f111451c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f111452d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f111453e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f111454f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f111455g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f111456h;

    @SuppressLint({"NewApi"})
    public View a(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f111450b = linearLayout;
        this.f111449a = linearLayout;
        linearLayout.setId(R.id.vsi);
        this.f111450b.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) TypedValue.applyDimension(1, 18.0f, displayMetrics);
        layoutParams.height = (int) TypedValue.applyDimension(1, 18.0f, displayMetrics);
        layoutParams.gravity = 16;
        layoutParams.leftMargin = (int) TypedValue.applyDimension(1, 14.0f, displayMetrics);
        layoutParams.rightMargin = (int) TypedValue.applyDimension(1, 17.0f, displayMetrics);
        ImageView imageView = new ImageView(context, null);
        this.f111451c = imageView;
        imageView.setId(R.id.vs9);
        this.f111450b.addView(this.f111451c, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.height = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
        TextView textView = new TextView(context, null);
        this.f111452d = textView;
        textView.setId(R.id.vsa);
        this.f111452d.setTextSize(0, (int) TypedValue.applyDimension(2, 13.0f, displayMetrics));
        this.f111452d.setEllipsize(TextUtils.TruncateAt.END);
        this.f111452d.setMaxWidth((int) TypedValue.applyDimension(1, 200.0f, displayMetrics));
        this.f111452d.setMaxLines(1);
        this.f111452d.setVisibility(8);
        this.f111452d.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f111450b.addView(this.f111452d, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.height = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
        TextView textView2 = new TextView(context, null);
        this.f111453e = textView2;
        textView2.setId(R.id.vsf);
        this.f111453e.setTextSize(0, (int) TypedValue.applyDimension(2, 13.0f, displayMetrics));
        this.f111453e.setText("\u64a4\u56de\u4e86");
        this.f111453e.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f111450b.addView(this.f111453e, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.height = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
        layoutParams4.weight = 1.0f;
        TextView textView3 = new TextView(context, null);
        this.f111454f = textView3;
        textView3.setId(R.id.vsb);
        this.f111454f.setTextSize(0, (int) TypedValue.applyDimension(2, 13.0f, displayMetrics));
        this.f111454f.setEllipsize(TextUtils.TruncateAt.END);
        this.f111454f.setMaxWidth((int) TypedValue.applyDimension(1, 180.0f, displayMetrics));
        this.f111454f.setMaxLines(1);
        this.f111454f.setVisibility(8);
        this.f111454f.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f111450b.addView(this.f111454f, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.height = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
        TextView textView4 = new TextView(context, null);
        this.f111455g = textView4;
        textView4.setId(R.id.vsh);
        this.f111455g.setTextSize(0, (int) TypedValue.applyDimension(2, 13.0f, displayMetrics));
        this.f111455g.setText(R.string.f1502514h);
        this.f111455g.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f111450b.addView(this.f111455g, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.width = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
        layoutParams6.height = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
        layoutParams6.gravity = 16;
        ImageView imageView2 = new ImageView(context, null);
        this.f111456h = imageView2;
        imageView2.setBackgroundResource(R.drawable.qui_close_filled_icon_secondary_01_selector);
        this.f111456h.setId(R.id.vs8);
        this.f111456h.setVisibility(8);
        this.f111450b.addView(this.f111456h, layoutParams6);
        return this.f111450b;
    }

    public ViewGroup b() {
        return this.f111449a;
    }
}
