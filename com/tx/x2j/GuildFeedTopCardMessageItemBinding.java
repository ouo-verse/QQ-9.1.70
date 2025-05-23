package com.tx.x2j;

import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import ty4.a;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildFeedTopCardMessageItemBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f387296a;

    /* renamed from: b, reason: collision with root package name */
    public ViewStub f387297b;

    /* renamed from: c, reason: collision with root package name */
    public ViewStub f387298c;

    /* renamed from: d, reason: collision with root package name */
    public ViewStub f387299d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f387300e;

    /* renamed from: f, reason: collision with root package name */
    public View f387301f;

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
        this.f387301f = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387296a = linearLayout2;
        linearLayout2.setId(R.id.v3n);
        this.f387296a.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        this.f387296a.setGravity(16);
        this.f387296a.setOrientation(0);
        d.e(this.f387296a);
        this.f387296a.setBackground(context.getResources().getDrawable(R.drawable.guild_top_card_feed_item_bg));
        this.f387296a.setPadding((int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f), 0);
        linearLayout.addView(this.f387296a, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams2.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams2.setMarginEnd((int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f));
        ViewStub viewStub = new ViewStub(context, (AttributeSet) null);
        this.f387297b = viewStub;
        viewStub.setLayoutResource(R.layout.erk);
        this.f387297b.setLayoutInflater(new a(this.f387297b.getContext(), new GuildFeedTopCardMessageItemPicBinding()));
        this.f387297b.setId(R.id.v3q);
        this.f387297b.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        this.f387297b.setVisibility(8);
        this.f387297b.setDuplicateParentStateEnabled(true);
        this.f387296a.addView(this.f387297b, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams3.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams3.setMarginEnd((int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f));
        ViewStub viewStub2 = new ViewStub(context, (AttributeSet) null);
        this.f387298c = viewStub2;
        viewStub2.setLayoutResource(R.layout.erk);
        this.f387298c.setLayoutInflater(new a(this.f387298c.getContext(), new GuildFeedTopCardMessageItemPicBinding()));
        this.f387298c.setId(R.id.v3r);
        this.f387298c.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        this.f387298c.setVisibility(8);
        this.f387298c.setDuplicateParentStateEnabled(true);
        this.f387296a.addView(this.f387298c, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams4.setMarginEnd((int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f));
        ViewStub viewStub3 = new ViewStub(context, (AttributeSet) null);
        this.f387299d = viewStub3;
        viewStub3.setLayoutResource(R.layout.erk);
        this.f387299d.setLayoutInflater(new a(this.f387299d.getContext(), new GuildFeedTopCardMessageItemPicBinding()));
        this.f387299d.setId(R.id.v3s);
        this.f387299d.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        this.f387299d.setVisibility(8);
        this.f387299d.setDuplicateParentStateEnabled(true);
        this.f387296a.addView(this.f387299d, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(context, null);
        this.f387300e = textView;
        textView.setId(R.id.v3o);
        this.f387300e.setTextSize(0, (int) (TypedValue.applyDimension(2, 11.0f, displayMetrics) + 0.5f));
        this.f387300e.setEllipsize(TextUtils.TruncateAt.END);
        this.f387300e.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        this.f387300e.setMaxLines(1);
        this.f387300e.setDuplicateParentStateEnabled(true);
        this.f387300e.setTextColor(resources.getColor(R.color.bts));
        this.f387296a.addView(this.f387300e, layoutParams5);
        return linearLayout;
    }

    public View u() {
        return this.f387301f;
    }
}
