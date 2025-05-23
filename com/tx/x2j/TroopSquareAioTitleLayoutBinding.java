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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.widget.SingleLineTextView;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TroopSquareAioTitleLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f387532a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f387533b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f387534c;

    /* renamed from: d, reason: collision with root package name */
    public SingleLineTextView f387535d;

    /* renamed from: e, reason: collision with root package name */
    public QUIBadge f387536e;

    /* renamed from: f, reason: collision with root package name */
    public View f387537f;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 28.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387532a = relativeLayout;
        this.f387537f = relativeLayout;
        relativeLayout.setId(R.id.f10367619);
        this.f387532a.setPadding((int) resources.getDimension(R.dimen.f158703ms), 0, (int) resources.getDimension(R.dimen.f158703ms), 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 26.0f, displayMetrics) + 0.5f);
        layoutParams.addRule(15, -1);
        RelativeLayout relativeLayout2 = new RelativeLayout(context, null);
        this.f387533b = relativeLayout2;
        relativeLayout2.setId(R.id.f10366618);
        d.e(this.f387533b);
        this.f387533b.setBackground(context.getResources().getDrawable(R.drawable.j9m));
        this.f387533b.setPadding((int) (TypedValue.applyDimension(1, 4.5f, displayMetrics) + 0.5f), 0, 0, 0);
        this.f387532a.addView(this.f387533b, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams2.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams2.addRule(15, -1);
        ImageView imageView = new ImageView(context, null);
        this.f387534c = imageView;
        imageView.setId(R.id.f1036861_);
        this.f387534c.setVisibility(0);
        this.f387534c.setImageDrawable(context.getResources().getDrawable(R.drawable.j9n));
        this.f387533b.addView(this.f387534c, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(1, R.id.f1036861_);
        layoutParams3.addRule(15, -1);
        layoutParams3.leftMargin = (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f);
        layoutParams3.rightMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        SingleLineTextView singleLineTextView = new SingleLineTextView(context, null);
        this.f387535d = singleLineTextView;
        this.f387533b.addView(singleLineTextView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) (TypedValue.applyDimension(1, 9.0f, displayMetrics) + 0.5f);
        layoutParams4.addRule(2, R.id.f10366618);
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 9.0f, displayMetrics) + 0.5f);
        layoutParams4.addRule(1, R.id.f10366618);
        layoutParams4.leftMargin = (int) (TypedValue.applyDimension(1, -6.5f, displayMetrics) + 0.5f);
        layoutParams4.bottomMargin = (int) (TypedValue.applyDimension(1, -8.0f, displayMetrics) + 0.5f);
        QUIBadge qUIBadge = new QUIBadge(context, null);
        this.f387536e = qUIBadge;
        qUIBadge.setId(R.id.f1036961a);
        this.f387536e.setVisibility(8);
        this.f387532a.addView(this.f387536e, layoutParams4);
        return this.f387532a;
    }
}
