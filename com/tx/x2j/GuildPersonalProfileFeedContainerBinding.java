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
public class GuildPersonalProfileFeedContainerBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public ImageView f387370a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f387371b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387372c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f387373d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f387374e;

    /* renamed from: f, reason: collision with root package name */
    public RecyclerView f387375f;

    /* renamed from: g, reason: collision with root package name */
    public View f387376g;

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
        this.f387376g = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 0.5f, displayMetrics) + 0.5f);
        layoutParams.leftMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams.rightMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams.bottomMargin = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387370a = imageView;
        imageView.setId(R.id.f164999bn3);
        this.f387370a.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_common_border_standard_bg));
        linearLayout.addView(this.f387370a, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.leftMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams2.rightMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams2.bottomMargin = (int) resources.getDimension(R.dimen.f158707mw);
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387371b = relativeLayout;
        relativeLayout.setId(R.id.wug);
        linearLayout.addView(this.f387371b, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(9, -1);
        TextView textView = new TextView(context, null);
        this.f387372c = textView;
        textView.setId(R.id.f165641x33);
        this.f387372c.setText(resources.getString(R.string.f1520819f));
        this.f387372c.setTextSize(0, (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f));
        this.f387372c.setIncludeFontPadding(false);
        this.f387372c.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387371b.addView(this.f387372c, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(21, -1);
        layoutParams4.setMarginEnd((int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f));
        TextView textView2 = new TextView(context, null);
        this.f387373d = textView2;
        textView2.setId(R.id.f165588wt3);
        this.f387373d.setTextSize(0, (int) resources.getDimension(R.dimen.f158706mv));
        this.f387373d.setVisibility(8);
        this.f387373d.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387371b.addView(this.f387373d, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams5.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams5.addRule(21, -1);
        layoutParams5.addRule(15, -1);
        layoutParams5.setMarginStart((int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f));
        ImageView imageView2 = new ImageView(context, null);
        this.f387374e = imageView2;
        imageView2.setId(R.id.ezw);
        this.f387374e.setVisibility(8);
        this.f387374e.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_01));
        this.f387371b.addView(this.f387374e, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams6.rightMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        RecyclerView recyclerView = new RecyclerView(context, null);
        this.f387375f = recyclerView;
        recyclerView.setId(R.id.wxi);
        linearLayout.addView(this.f387375f, layoutParams6);
        return linearLayout;
    }

    public View u() {
        return this.f387376g;
    }
}
