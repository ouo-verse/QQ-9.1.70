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
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.R;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildRecommendThemeCollectionItemBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public TextView f387404a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f387405b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387406c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f387407d;

    /* renamed from: e, reason: collision with root package name */
    public ViewPager2 f387408e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f387409f;

    /* renamed from: g, reason: collision with root package name */
    public View f387410g;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=ViewGroup.LayoutParams, key=android:layout_marginTop, value=14dp}");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=ViewGroup.LayoutParams, key=android:layout_marginBottom, value=14dp}");
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=AbsListView.LayoutParams, key=android:layout_marginTop, value=14dp}");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=AbsListView.LayoutParams, key=android:layout_marginBottom, value=14dp}");
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.topMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        layoutParams.bottomMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.topMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        layoutParams.bottomMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.topMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        layoutParams.bottomMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.topMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        layoutParams.bottomMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f387410g = constraintLayout;
        constraintLayout.setClipChildren(false);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.setMarginStart((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        layoutParams.validate();
        TextView textView = new TextView(context, null);
        this.f387404a = textView;
        textView.setId(R.id.dqd);
        this.f387404a.setTextSize(0, (int) (TypedValue.applyDimension(2, 18.0f, displayMetrics) + 0.5f));
        this.f387404a.setTextColor(resources.getColor(R.color.guild_skin_color_222222_e8e9ea));
        constraintLayout.addView(this.f387404a, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams2.bottomToBottom = R.id.dqd;
        layoutParams2.topToTop = R.id.dqd;
        layoutParams2.endToEnd = 0;
        layoutParams2.setMarginEnd((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        layoutParams2.validate();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387405b = linearLayout;
        linearLayout.setId(R.id.it6);
        this.f387405b.setGravity(16);
        this.f387405b.setOrientation(0);
        constraintLayout.addView(this.f387405b, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMarginEnd((int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f));
        TextView textView2 = new TextView(context, null);
        this.f387406c = textView2;
        textView2.setId(R.id.f0q);
        this.f387406c.setText(resources.getString(R.string.f1502914l));
        this.f387406c.setTextSize(0, (int) (TypedValue.applyDimension(2, 12.0f, displayMetrics) + 0.5f));
        this.f387406c.setIncludeFontPadding(false);
        this.f387406c.setTextColor(resources.getColor(R.color.guild_skin_999999_5d6064));
        this.f387405b.addView(this.f387406c, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) (TypedValue.applyDimension(1, 7.0f, displayMetrics) + 0.5f);
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 11.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387407d = imageView;
        imageView.setId(R.id.f06);
        this.f387407d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f387407d.setImageDrawable(context.getResources().getDrawable(R.drawable.skin_more_arrow));
        this.f387405b.addView(this.f387407d, layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = (int) (TypedValue.applyDimension(1, 270.0f, displayMetrics) + 0.5f);
        layoutParams5.topToBottom = R.id.dqd;
        layoutParams5.horizontalBias = 0.0f;
        layoutParams5.startToStart = 0;
        layoutParams5.matchConstraintPercentWidth = 0.93f;
        layoutParams5.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = (int) (TypedValue.applyDimension(1, 7.0f, displayMetrics) + 0.5f);
        layoutParams5.validate();
        ViewPager2 viewPager2 = new ViewPager2(context, null);
        this.f387408e = viewPager2;
        viewPager2.setId(R.id.f96375hi);
        this.f387408e.setClipChildren(false);
        constraintLayout.addView(this.f387408e, layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams6.bottomToBottom = R.id.f96375hi;
        layoutParams6.topToTop = R.id.f96375hi;
        layoutParams6.startToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin = (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f);
        layoutParams6.validate();
        ImageView imageView2 = new ImageView(context, null);
        this.f387409f = imageView2;
        imageView2.setId(R.id.f80464bj);
        this.f387409f.setImageDrawable(context.getResources().getDrawable(R.drawable.guild_scroll_arrow));
        constraintLayout.addView(this.f387409f, layoutParams6);
        return constraintLayout;
    }
}
