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

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildDiscoveryV2FeedLikeLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public ImageView f387269a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f387270b;

    /* renamed from: c, reason: collision with root package name */
    public View f387271c;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.height = (int) resources.getDimension(R.dimen.f158713n2);
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.height = (int) resources.getDimension(R.dimen.f158713n2);
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.height = (int) resources.getDimension(R.dimen.f158713n2);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.height = (int) resources.getDimension(R.dimen.f158713n2);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.height = (int) resources.getDimension(R.dimen.f158713n2);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.height = (int) resources.getDimension(R.dimen.f158713n2);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) resources.getDimension(R.dimen.f158713n2);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387271c = frameLayout;
        frameLayout.setClipToPadding(false);
        frameLayout.setPadding((int) resources.getDimension(R.dimen.f158726ng), (int) resources.getDimension(R.dimen.f158716n6), (int) resources.getDimension(R.dimen.f158726ng), (int) resources.getDimension(R.dimen.f158716n6));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) resources.getDimension(R.dimen.f158706mv);
        layoutParams.height = (int) resources.getDimension(R.dimen.f158706mv);
        layoutParams.gravity = 8388627;
        ImageView imageView = new ImageView(context, null);
        this.f387269a = imageView;
        imageView.setId(R.id.w5c);
        frameLayout.addView(this.f387269a, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.height = -1;
        layoutParams2.gravity = 8388627;
        layoutParams2.setMarginStart((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f));
        TextView textView = new TextView(context, null);
        this.f387270b = textView;
        textView.setTextSize(0, (int) (TypedValue.applyDimension(2, 13.0f, displayMetrics) + 0.5f));
        this.f387270b.setSingleLine(true);
        this.f387270b.setId(R.id.w5d);
        this.f387270b.setMaxLines(1);
        this.f387270b.setGravity(17);
        this.f387270b.setVisibility(8);
        this.f387270b.setIncludeFontPadding(false);
        frameLayout.addView(this.f387270b, layoutParams2);
        return frameLayout;
    }
}
