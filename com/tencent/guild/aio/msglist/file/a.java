package com.tencent.guild.aio.msglist.file;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f111271a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f111272b;

    /* renamed from: c, reason: collision with root package name */
    public RelativeLayout f111273c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f111274d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f111275e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f111276f;

    /* renamed from: g, reason: collision with root package name */
    public ProgressBar f111277g;

    /* renamed from: h, reason: collision with root package name */
    public RelativeLayout f111278h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        a(context);
    }

    public View a(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f111272b = relativeLayout;
        this.f111271a = relativeLayout;
        relativeLayout.setId(R.id.zfv);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -2;
        RelativeLayout relativeLayout2 = new RelativeLayout(context, null);
        this.f111273c = relativeLayout2;
        relativeLayout2.setBackgroundResource(R.drawable.guild_aio_friend_bubble_bg);
        this.f111273c.setId(R.id.zfy);
        this.f111273c.setLayoutParams(layoutParams);
        this.f111272b.addView(this.f111273c);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.height = -2;
        layoutParams2.leftMargin = (int) resources.getDimension(R.dimen.f158706mv);
        layoutParams2.width = -1;
        layoutParams2.topMargin = (int) resources.getDimension(R.dimen.f158703ms);
        layoutParams2.addRule(0, R.id.y36);
        TextView textView = new TextView(context, null);
        this.f111274d = textView;
        textView.setTextSize(1, 17.0f);
        this.f111274d.setTextColor(resources.getColor(R.color.qui_common_bubble_guest_text_primary));
        this.f111274d.setId(R.id.kbs);
        this.f111274d.setEllipsize(TextUtils.TruncateAt.END);
        this.f111274d.setMaxLines(2);
        TextView textView2 = this.f111274d;
        textView2.setLineSpacing(textView2.getLineSpacingExtra(), 1.0f);
        this.f111274d.setIncludeFontPadding(true);
        this.f111274d.setLineSpacing((int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics()), this.f111274d.getLineSpacingMultiplier());
        this.f111274d.setLayoutParams(layoutParams2);
        this.f111273c.addView(this.f111274d);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics());
        layoutParams3.height = (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics());
        layoutParams3.addRule(11, -1);
        layoutParams3.topMargin = (int) resources.getDimension(R.dimen.f158706mv);
        layoutParams3.bottomMargin = (int) resources.getDimension(R.dimen.c_a);
        layoutParams3.rightMargin = (int) resources.getDimension(R.dimen.f158706mv);
        ImageView imageView = new ImageView(context, null);
        this.f111275e = imageView;
        imageView.setId(R.id.y36);
        this.f111275e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f111275e.setLayoutParams(layoutParams3);
        this.f111273c.addView(this.f111275e);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.width = -1;
        layoutParams4.height = -2;
        layoutParams4.leftMargin = (int) resources.getDimension(R.dimen.f158706mv);
        layoutParams4.addRule(12, -1);
        layoutParams4.rightMargin = (int) resources.getDimension(R.dimen.f158706mv);
        LinearLayout linearLayout = new LinearLayout(context, null);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, 0, 0, (int) resources.getDimension(R.dimen.f158705mu));
        linearLayout.setLayoutParams(layoutParams4);
        this.f111273c.addView(linearLayout);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.width = -2;
        layoutParams5.height = (int) resources.getDimension(R.dimen.f158711n0);
        TextView textView3 = new TextView(context, null);
        this.f111276f = textView3;
        textView3.setId(R.id.f167042k73);
        this.f111276f.setTextSize(1, 14.0f);
        this.f111276f.setSingleLine(true);
        this.f111276f.setTextColor(resources.getColor(R.color.qui_common_bubble_guest_text_secondary));
        this.f111276f.setLayoutParams(layoutParams5);
        linearLayout.addView(this.f111276f);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.width = -1;
        layoutParams6.height = (int) TypedValue.applyDimension(1, 2.0f, resources.getDisplayMetrics());
        layoutParams6.topMargin = (int) resources.getDimension(R.dimen.f158728ni);
        ProgressBar progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        this.f111277g = progressBar;
        progressBar.setIndeterminateDrawable(context.getResources().getDrawable(R.drawable.guild_file_progress_layerlist));
        this.f111277g.setId(R.id.lz7);
        this.f111277g.setVisibility(8);
        this.f111277g.setMax(100);
        this.f111277g.setLayoutParams(layoutParams6);
        linearLayout.addView(this.f111277g);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.width = -2;
        layoutParams7.height = -2;
        RelativeLayout relativeLayout3 = new RelativeLayout(context, null);
        this.f111278h = relativeLayout3;
        relativeLayout3.setId(R.id.zgw);
        this.f111278h.setLayoutParams(layoutParams7);
        this.f111272b.addView(this.f111278h);
        return this.f111272b;
    }

    public ViewGroup b() {
        return this.f111271a;
    }
}
