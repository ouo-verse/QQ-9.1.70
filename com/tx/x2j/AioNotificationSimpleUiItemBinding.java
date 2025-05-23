package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
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
public class AioNotificationSimpleUiItemBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public FrameLayout f387065a;

    /* renamed from: b, reason: collision with root package name */
    public View f387066b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f387067c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f387068d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f387069e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f387070f;

    /* renamed from: g, reason: collision with root package name */
    public View f387071g;

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
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387071g = frameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158724ne);
        FrameLayout frameLayout2 = new FrameLayout(context, null);
        this.f387065a = frameLayout2;
        frameLayout2.setId(R.id.f164190sj3);
        frameLayout.addView(this.f387065a, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.height = (int) resources.getDimension(R.dimen.f158721nb);
        FrameLayout frameLayout3 = new FrameLayout(context, null);
        d.e(frameLayout3);
        frameLayout3.setBackground(context.getResources().getDrawable(R.drawable.mmf));
        frameLayout.addView(frameLayout3, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.width = -1;
        layoutParams3.height = -1;
        View view = new View(context, null);
        this.f387066b = view;
        view.setId(R.id.sja);
        this.f387066b.setVisibility(8);
        d.e(this.f387066b);
        this.f387066b.setBackground(context.getResources().getDrawable(R.drawable.mmc));
        frameLayout3.addView(this.f387066b, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.width = -1;
        layoutParams4.height = -1;
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        relativeLayout.setPadding((int) resources.getDimension(R.dimen.f158703ms), (int) resources.getDimension(R.dimen.f158700mp), (int) resources.getDimension(R.dimen.f158703ms), (int) resources.getDimension(R.dimen.f158700mp));
        frameLayout3.addView(relativeLayout, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams5.height = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams5.addRule(9, -1);
        layoutParams5.addRule(15, -1);
        ImageView imageView = new ImageView(context, null);
        this.f387067c = imageView;
        imageView.setId(R.id.sj6);
        this.f387067c.setImportantForAccessibility(2);
        relativeLayout.addView(this.f387067c, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.width = -1;
        layoutParams6.addRule(1, R.id.sj6);
        layoutParams6.addRule(15, -1);
        layoutParams6.addRule(0, R.id.f164189sj2);
        layoutParams6.leftMargin = (int) resources.getDimension(R.dimen.f158728ni);
        TextView textView = new TextView(context, null);
        this.f387068d = textView;
        textView.setTextSize(0, (int) resources.getDimension(R.dimen.aw5));
        this.f387068d.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        this.f387068d.setId(R.id.f164191sj4);
        this.f387068d.setEllipsize(TextUtils.TruncateAt.END);
        this.f387068d.setMaxLines(1);
        relativeLayout.addView(this.f387068d, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.height = -1;
        layoutParams7.addRule(0, R.id.f164187sj0);
        layoutParams7.addRule(15, -1);
        TextView textView2 = new TextView(context, null);
        this.f387069e = textView2;
        textView2.setId(R.id.f164189sj2);
        this.f387069e.setTextSize(0, (int) resources.getDimension(R.dimen.aw5));
        this.f387069e.setGravity(17);
        relativeLayout.addView(this.f387069e, layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.width = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams8.height = -1;
        layoutParams8.addRule(11, -1);
        layoutParams8.addRule(15, -1);
        layoutParams8.leftMargin = (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f);
        ImageView imageView2 = new ImageView(context, null);
        this.f387070f = imageView2;
        imageView2.setId(R.id.f164187sj0);
        this.f387070f.setPadding((int) resources.getDimension(R.dimen.f158712n1), 0, (int) resources.getDimension(R.dimen.f158712n1), 0);
        relativeLayout.addView(this.f387070f, layoutParams8);
        return frameLayout;
    }

    public View u() {
        return this.f387071g;
    }
}
