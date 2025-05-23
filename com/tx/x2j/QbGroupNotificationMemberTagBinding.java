package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
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
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QbGroupNotificationMemberTagBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f387501a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f387502b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387503c;

    /* renamed from: d, reason: collision with root package name */
    public LinearLayout f387504d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f387505e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f387506f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f387507g;

    /* renamed from: h, reason: collision with root package name */
    public View f387508h;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aLinearLayout {parent=ViewGroup.LayoutParams, key=android:layout_marginTop, value=4dp}");
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aLinearLayout {parent=AbsListView.LayoutParams, key=android:layout_marginTop, value=4dp}");
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams.topMargin = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams.topMargin = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams.topMargin = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams.topMargin = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387501a = linearLayout;
        this.f387508h = linearLayout;
        linearLayout.setId(R.id.f103035zi);
        this.f387501a.setVisibility(8);
        this.f387501a.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.height = -1;
        layoutParams.setMarginEnd((int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f));
        TextView textView = new TextView(context, null);
        this.f387502b = textView;
        textView.setTextSize(0, (int) resources.getDimension(R.dimen.ayi));
        this.f387502b.setText("\u4f01\u4e1a\u7528\u6237");
        this.f387502b.setTextColor(resources.getColor(R.color.f158017al3));
        this.f387502b.setId(R.id.f10330609);
        this.f387502b.setMaxLines(1);
        this.f387502b.setGravity(17);
        this.f387502b.setVisibility(8);
        this.f387502b.setIncludeFontPadding(false);
        d.e(this.f387502b);
        this.f387502b.setBackground(context.getResources().getDrawable(R.drawable.k_l));
        this.f387502b.setPadding((int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f), 0);
        this.f387501a.addView(this.f387502b, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.height = -1;
        TextView textView2 = new TextView(context, null);
        this.f387503c = textView2;
        textView2.setId(R.id.f10322601);
        this.f387503c.setTextSize(0, (int) resources.getDimension(R.dimen.ayi));
        this.f387503c.setMaxLines(1);
        this.f387503c.setGravity(17);
        this.f387503c.setVisibility(8);
        this.f387503c.setTextColor(Color.parseColor("#FFB300"));
        d.e(this.f387503c);
        this.f387503c.setBackground(context.getResources().getDrawable(R.drawable.k_j));
        this.f387503c.setPadding((int) resources.getDimension(R.dimen.f158726ng), 0, (int) resources.getDimension(R.dimen.f158726ng), 0);
        this.f387501a.addView(this.f387503c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.height = -1;
        layoutParams3.setMarginStart((int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f));
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387504d = linearLayout2;
        linearLayout2.setId(R.id.f103185zx);
        this.f387504d.setGravity(16);
        this.f387504d.setVisibility(8);
        this.f387504d.setOrientation(0);
        d.e(this.f387504d);
        this.f387504d.setBackground(context.getResources().getDrawable(R.drawable.k_i));
        this.f387504d.setPadding((int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f), 0);
        this.f387501a.addView(this.f387504d, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f);
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387505e = imageView;
        imageView.setId(R.id.f103175zw);
        this.f387504d.addView(this.f387505e, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.setMarginStart((int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f));
        TextView textView3 = new TextView(context, null);
        this.f387506f = textView3;
        textView3.setId(R.id.f103165zv);
        this.f387506f.setTextSize(0, (int) resources.getDimension(R.dimen.ayi));
        this.f387506f.setMaxLines(1);
        this.f387506f.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387504d.addView(this.f387506f, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.height = -1;
        layoutParams6.setMarginStart((int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f));
        TextView textView4 = new TextView(context, null);
        this.f387507g = textView4;
        textView4.setTextSize(0, (int) resources.getDimension(R.dimen.ayi));
        this.f387507g.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387507g.setId(R.id.f10323602);
        this.f387507g.setEllipsize(TextUtils.TruncateAt.END);
        this.f387507g.setMaxLines(1);
        this.f387507g.setGravity(17);
        this.f387507g.setVisibility(8);
        this.f387507g.setMaxEms(5);
        d.e(this.f387507g);
        this.f387507g.setBackground(context.getResources().getDrawable(R.drawable.k_k));
        this.f387507g.setPadding((int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f), 0);
        this.f387501a.addView(this.f387507g, layoutParams6);
        return this.f387501a;
    }
}
