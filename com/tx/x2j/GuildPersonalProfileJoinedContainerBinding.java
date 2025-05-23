package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mobileqq.R;
import ty4.c;

/* loaded from: classes27.dex */
public class GuildPersonalProfileJoinedContainerBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public ImageView f387391a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f387392b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387393c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f387394d;

    /* renamed from: e, reason: collision with root package name */
    public LinearLayout f387395e;

    /* renamed from: f, reason: collision with root package name */
    public View f387396f;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387396f = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 0.5f, displayMetrics) + 0.5f);
        layoutParams.leftMargin = (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f);
        layoutParams.rightMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.f158714n4);
        ImageView imageView = new ImageView(context, null);
        this.f387391a = imageView;
        imageView.setId(R.id.f164999bn3);
        this.f387391a.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_common_border_standard_bg));
        linearLayout.addView(this.f387391a, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.leftMargin = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams2.rightMargin = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams2.bottomMargin = (int) resources.getDimension(R.dimen.f158707mw);
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387392b = relativeLayout;
        relativeLayout.setId(R.id.f165589wt4);
        linearLayout.addView(this.f387392b, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(context, null);
        textView.setText(resources.getString(R.string.f1521019h));
        textView.setTextSize(0, (int) resources.getDimension(R.dimen.f158706mv));
        textView.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387392b.addView(textView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(21, -1);
        layoutParams4.setMarginEnd((int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f));
        TextView textView2 = new TextView(context, null);
        this.f387393c = textView2;
        textView2.setId(R.id.f165588wt3);
        this.f387393c.setTextSize(0, (int) resources.getDimension(R.dimen.f158706mv));
        this.f387393c.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387392b.addView(this.f387393c, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams5.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams5.addRule(21, -1);
        layoutParams5.addRule(15, -1);
        layoutParams5.setMarginStart((int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f));
        ImageView imageView2 = new ImageView(context, null);
        this.f387394d = imageView2;
        imageView2.setId(R.id.ezw);
        this.f387394d.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_01));
        this.f387392b.addView(this.f387394d, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.width = -1;
        layoutParams6.leftMargin = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams6.rightMargin = (int) resources.getDimension(R.dimen.f158713n2);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387395e = linearLayout2;
        linearLayout2.setId(R.id.b8q);
        this.f387395e.setOrientation(0);
        linearLayout.addView(this.f387395e, layoutParams6);
        return linearLayout;
    }

    public View u() {
        return this.f387396f;
    }
}
