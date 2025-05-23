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
public class AioNotificationHeaderItemBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public TextView f387062a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f387063b;

    /* renamed from: c, reason: collision with root package name */
    public View f387064c;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158715n5);
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158715n5);
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158715n5);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158715n5);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158715n5);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) resources.getDimension(R.dimen.f158715n5);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) resources.getDimension(R.dimen.f158715n5);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) resources.getDimension(R.dimen.f158715n5);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387064c = relativeLayout;
        relativeLayout.setPadding((int) resources.getDimension(R.dimen.f158700mp), 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.height = -1;
        TextView textView = new TextView(context, null);
        this.f387062a = textView;
        textView.setId(R.id.sjd);
        this.f387062a.setTextSize(0, (int) resources.getDimension(R.dimen.f159562aw3));
        this.f387062a.setGravity(16);
        this.f387062a.setTextColor(resources.getColor(R.color.f157116k8));
        relativeLayout.addView(this.f387062a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) (TypedValue.applyDimension(1, 40.0f, displayMetrics) + 0.5f);
        layoutParams2.height = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(15, -1);
        TextView textView2 = new TextView(context, null);
        this.f387063b = textView2;
        textView2.setId(R.id.sjc);
        this.f387063b.setText("\u6e05\u9664");
        this.f387063b.setTextSize(0, (int) resources.getDimension(R.dimen.f159562aw3));
        this.f387063b.setGravity(17);
        this.f387063b.setTextColor(resources.getColor(R.color.f158017al3));
        d.e(this.f387063b);
        this.f387063b.setBackground(context.getResources().getDrawable(R.drawable.mly));
        relativeLayout.addView(this.f387063b, layoutParams2);
        return relativeLayout;
    }

    public View u() {
        return this.f387064c;
    }
}
