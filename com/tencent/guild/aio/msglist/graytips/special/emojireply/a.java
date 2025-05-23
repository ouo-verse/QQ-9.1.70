package com.tencent.guild.aio.msglist.graytips.special.emojireply;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f111389a;

    /* renamed from: b, reason: collision with root package name */
    public ConstraintLayout f111390b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f111391c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f111392d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f111393e;

    public a(Context context) {
        a(context);
    }

    public View a(Context context) {
        Resources resources = context.getResources();
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f111390b = constraintLayout;
        this.f111389a = constraintLayout;
        constraintLayout.setId(R.id.vse);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) TypedValue.applyDimension(1, 18.0f, resources.getDisplayMetrics());
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) TypedValue.applyDimension(1, 18.0f, resources.getDisplayMetrics());
        layoutParams.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = (int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.validate();
        ImageView imageView = new ImageView(context, null);
        this.f111391c = imageView;
        imageView.setId(R.id.vs9);
        this.f111391c.setLayoutParams(layoutParams);
        this.f111390b.addView(this.f111391c);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = (int) TypedValue.applyDimension(1, 17.0f, resources.getDisplayMetrics());
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.topToTop = 0;
        layoutParams2.startToEnd = R.id.vs9;
        layoutParams2.validate();
        TextView textView = new TextView(context, null);
        this.f111392d = textView;
        textView.setTextSize(2, 13.0f);
        this.f111392d.setMaxWidth((int) TypedValue.applyDimension(1, 195.0f, resources.getDisplayMetrics()));
        this.f111392d.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f111392d.setId(R.id.vs_);
        this.f111392d.setEllipsize(TextUtils.TruncateAt.END);
        this.f111392d.setMaxLines(1);
        this.f111392d.setLayoutParams(layoutParams2);
        this.f111390b.addView(this.f111392d);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = -2;
        layoutParams3.baselineToBaseline = R.id.vs_;
        layoutParams3.startToEnd = R.id.vs_;
        layoutParams3.validate();
        TextView textView2 = new TextView(context, null);
        this.f111393e = textView2;
        textView2.setId(R.id.vsh);
        this.f111393e.setTextSize(2, 13.0f);
        this.f111393e.setText("\u56de\u5e94\u4e86\u4f60\u7684\u6d88\u606f");
        this.f111393e.setMaxLines(1);
        this.f111393e.setSingleLine();
        this.f111393e.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f111393e.setLayoutParams(layoutParams3);
        this.f111390b.addView(this.f111393e);
        return this.f111390b;
    }

    public ViewGroup b() {
        return this.f111389a;
    }
}
