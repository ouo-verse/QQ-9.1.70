package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
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
import com.tencent.mobileqq.aio.widget.RedDotImageView;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioTitleBarRight3IvBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public RedDotImageView f387186a;

    /* renamed from: b, reason: collision with root package name */
    public View f387187b;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=ViewGroup.LayoutParams, key=android:layout_toStartOf, value=@+id/right2_iv}");
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=ViewGroup.LayoutParams, key=android:layout_marginEnd, value=@dimen/dp12}");
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=ViewGroup.LayoutParams, key=android:layout_centerVertical, value=true}");
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=AbsListView.LayoutParams, key=android:layout_toStartOf, value=@+id/right2_iv}");
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=AbsListView.LayoutParams, key=android:layout_marginEnd, value=@dimen/dp12}");
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=AbsListView.LayoutParams, key=android:layout_centerVertical, value=true}");
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=FrameLayout.LayoutParams, key=android:layout_toStartOf, value=@+id/right2_iv}");
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=FrameLayout.LayoutParams, key=android:layout_centerVertical, value=true}");
        layoutParams.setMarginEnd((int) resources.getDimension(R.dimen.f158703ms));
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=LinearLayout.LayoutParams, key=android:layout_toStartOf, value=@+id/right2_iv}");
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=LinearLayout.LayoutParams, key=android:layout_centerVertical, value=true}");
        layoutParams.setMarginEnd((int) resources.getDimension(R.dimen.f158703ms));
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=RadioGroup.LayoutParams, key=android:layout_toStartOf, value=@+id/right2_iv}");
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=RadioGroup.LayoutParams, key=android:layout_centerVertical, value=true}");
        layoutParams.setMarginEnd((int) resources.getDimension(R.dimen.f158703ms));
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.addRule(16, R.id.f74343w0);
        layoutParams.addRule(15, -1);
        layoutParams.setMarginEnd((int) resources.getDimension(R.dimen.f158703ms));
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=ConstraintLayout.LayoutParams, key=android:layout_toStartOf, value=@+id/right2_iv}");
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=ConstraintLayout.LayoutParams, key=android:layout_centerVertical, value=true}");
        layoutParams.setMarginEnd((int) resources.getDimension(R.dimen.f158703ms));
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=RecyclerView.LayoutParams, key=android:layout_toStartOf, value=@+id/right2_iv}");
        Log.e("X2J", "invalid root attr \uff1aRedDotImageView {parent=RecyclerView.LayoutParams, key=android:layout_centerVertical, value=true}");
        layoutParams.setMarginEnd((int) resources.getDimension(R.dimen.f158703ms));
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        context.getResources().getDisplayMetrics();
        RedDotImageView redDotImageView = new RedDotImageView(context, null);
        this.f387186a = redDotImageView;
        this.f387187b = redDotImageView;
        redDotImageView.setId(R.id.f74353w1);
        this.f387186a.setScaleType(ImageView.ScaleType.CENTER);
        this.f387186a.setVisibility(8);
        this.f387186a.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_fun_neighbors));
        return this.f387186a;
    }

    public View u() {
        return this.f387187b;
    }
}
