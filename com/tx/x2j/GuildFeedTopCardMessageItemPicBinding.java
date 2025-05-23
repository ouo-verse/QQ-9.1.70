package com.tx.x2j;

import android.animation.AnimatorInflater;
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
import com.tencent.mobileqq.guild.main.topchannel.widget.FeedTopCardThumbView;
import ty4.c;

/* loaded from: classes27.dex */
public class GuildFeedTopCardMessageItemPicBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public FeedTopCardThumbView f387302a;

    /* renamed from: b, reason: collision with root package name */
    public View f387303b;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=ViewGroup.LayoutParams, key=android:layout_alignParentRight, value=true}");
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=ViewGroup.LayoutParams, key=android:layout_marginRight, value=3dp}");
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=ViewGroup.LayoutParams, key=android:layout_centerVertical, value=true}");
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=AbsListView.LayoutParams, key=android:layout_alignParentRight, value=true}");
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=AbsListView.LayoutParams, key=android:layout_marginRight, value=3dp}");
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=AbsListView.LayoutParams, key=android:layout_centerVertical, value=true}");
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=FrameLayout.LayoutParams, key=android:layout_alignParentRight, value=true}");
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=FrameLayout.LayoutParams, key=android:layout_centerVertical, value=true}");
        layoutParams.rightMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=LinearLayout.LayoutParams, key=android:layout_alignParentRight, value=true}");
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=LinearLayout.LayoutParams, key=android:layout_centerVertical, value=true}");
        layoutParams.rightMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=RadioGroup.LayoutParams, key=android:layout_alignParentRight, value=true}");
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=RadioGroup.LayoutParams, key=android:layout_centerVertical, value=true}");
        layoutParams.rightMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        layoutParams.rightMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=ConstraintLayout.LayoutParams, key=android:layout_alignParentRight, value=true}");
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=ConstraintLayout.LayoutParams, key=android:layout_centerVertical, value=true}");
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=RecyclerView.LayoutParams, key=android:layout_alignParentRight, value=true}");
        Log.e("X2J", "invalid root attr \uff1aFeedTopCardThumbView {parent=RecyclerView.LayoutParams, key=android:layout_centerVertical, value=true}");
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        context.getResources().getDisplayMetrics();
        FeedTopCardThumbView feedTopCardThumbView = new FeedTopCardThumbView(context, null);
        this.f387302a = feedTopCardThumbView;
        this.f387303b = feedTopCardThumbView;
        feedTopCardThumbView.setId(R.id.v3p);
        this.f387302a.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        this.f387302a.setVisibility(8);
        this.f387302a.setDuplicateParentStateEnabled(true);
        return this.f387302a;
    }
}
