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
import com.tencent.mobileqq.guild.component.RoundImageView;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildDiscoveryV2RecommendThirdVideoLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public FrameLayout f387286a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f387287b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f387288c;

    /* renamed from: d, reason: collision with root package name */
    public RoundImageView f387289d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f387290e;

    /* renamed from: f, reason: collision with root package name */
    public View f387291f;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387286a = frameLayout;
        this.f387291f = frameLayout;
        frameLayout.setId(R.id.w57);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -1;
        ImageView imageView = new ImageView(context, null);
        this.f387287b = imageView;
        imageView.setId(R.id.w58);
        this.f387287b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f387286a.addView(this.f387287b, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 8388661;
        int dimension = (int) resources.getDimension(R.dimen.f158729nj);
        layoutParams2.setMargins(dimension, dimension, dimension, dimension);
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387288c = linearLayout;
        linearLayout.setId(R.id.w5_);
        this.f387288c.setGravity(16);
        d.e(this.f387288c);
        this.f387288c.setBackground(context.getResources().getDrawable(R.drawable.guild_feed_third_video_label_mask));
        int dimension2 = (int) resources.getDimension(R.dimen.f158716n6);
        this.f387288c.setPadding(dimension2, dimension2, dimension2, dimension2);
        this.f387286a.addView(this.f387288c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) resources.getDimension(R.dimen.f158703ms);
        layoutParams3.height = (int) resources.getDimension(R.dimen.f158703ms);
        RoundImageView roundImageView = new RoundImageView(context, null);
        this.f387289d = roundImageView;
        roundImageView.setId(R.id.w59);
        this.f387289d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f387289d.setRadius((int) resources.getDimension(R.dimen.f158716n6));
        this.f387288c.addView(this.f387289d, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f);
        TextView textView = new TextView(context, null);
        this.f387290e = textView;
        textView.setId(R.id.w5a);
        this.f387290e.setTextSize(0, (int) resources.getDimension(R.dimen.f158700mp));
        this.f387290e.setTextColor(resources.getColor(R.color.qui_button_text_primary_default));
        this.f387288c.addView(this.f387290e, layoutParams4);
        return this.f387286a;
    }
}
