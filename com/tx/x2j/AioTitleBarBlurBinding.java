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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioTitleBarBlurBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public QQBlurViewWrapper f387164a;

    /* renamed from: b, reason: collision with root package name */
    public View f387165b;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        context.getResources().getDisplayMetrics();
        QQBlurViewWrapper qQBlurViewWrapper = new QQBlurViewWrapper(context, null);
        this.f387164a = qQBlurViewWrapper;
        this.f387165b = qQBlurViewWrapper;
        qQBlurViewWrapper.setId(R.id.t96);
        this.f387164a.setVisibility(8);
        return this.f387164a;
    }

    public View u() {
        return this.f387165b;
    }
}
