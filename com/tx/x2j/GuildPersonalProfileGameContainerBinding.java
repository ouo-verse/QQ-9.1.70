package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import ty4.c;
import ty4.d;

/* loaded from: classes27.dex */
public class GuildPersonalProfileGameContainerBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f387377a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f387378b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387379c;

    /* renamed from: d, reason: collision with root package name */
    public RelativeLayout f387380d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f387381e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f387382f;

    /* renamed from: g, reason: collision with root package name */
    public RadiusFrameLayout f387383g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f387384h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f387385i;

    /* renamed from: j, reason: collision with root package name */
    public LinearLayout f387386j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f387387k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f387388l;

    /* renamed from: m, reason: collision with root package name */
    public RadiusFrameLayout f387389m;

    /* renamed from: n, reason: collision with root package name */
    public View f387390n;

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
        this.f387377a = linearLayout;
        this.f387390n = linearLayout;
        linearLayout.setId(R.id.won);
        this.f387377a.setVisibility(8);
        this.f387377a.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = (int) (TypedValue.applyDimension(1, 0.5f, displayMetrics) + 0.5f);
        layoutParams.leftMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams.rightMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams.bottomMargin = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387378b = imageView;
        imageView.setId(R.id.f165000bn4);
        this.f387378b.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_common_border_standard_bg));
        this.f387377a.addView(this.f387378b, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        TextView textView = new TextView(context, null);
        this.f387379c = textView;
        textView.setId(R.id.x39);
        this.f387379c.setText(resources.getString(R.string.f1520919g));
        this.f387379c.setTextSize(0, (int) resources.getDimension(R.dimen.aw5));
        this.f387379c.setVisibility(8);
        this.f387379c.setIncludeFontPadding(false);
        this.f387379c.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387377a.addView(this.f387379c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = -1;
        layoutParams3.height = (int) (TypedValue.applyDimension(1, 74.0f, displayMetrics) + 0.5f);
        layoutParams3.leftMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams3.topMargin = (int) resources.getDimension(R.dimen.f158729nj);
        layoutParams3.rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387380d = relativeLayout;
        relativeLayout.setId(R.id.f165602ww2);
        this.f387380d.setVisibility(8);
        this.f387377a.addView(this.f387380d, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(1, R.id.wfy);
        layoutParams4.addRule(15, -1);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        linearLayout2.setOrientation(1);
        this.f387380d.addView(linearLayout2, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = (int) resources.getDimension(R.dimen.f158703ms);
        layoutParams5.rightMargin = (int) resources.getDimension(R.dimen.f158703ms);
        TextView textView2 = new TextView(context, null);
        this.f387381e = textView2;
        textView2.setId(R.id.x3_);
        this.f387381e.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        this.f387381e.setVisibility(8);
        this.f387381e.setIncludeFontPadding(false);
        this.f387381e.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        this.f387381e.setTypeface(Typeface.create(PTSNodeTextBase.FONT_FAMILY_PING_FANG_SC_MEDIUM, 0));
        d.h(this.f387381e, 0, PTSNodeTextBase.FONT_FAMILY_PING_FANG_SC_MEDIUM, null, -1, -1);
        linearLayout2.addView(this.f387381e, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = (int) resources.getDimension(R.dimen.f158703ms);
        layoutParams6.topMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams6.rightMargin = (int) resources.getDimension(R.dimen.f158703ms);
        TextView textView3 = new TextView(context, null);
        this.f387382f = textView3;
        textView3.setTextSize(0, (int) resources.getDimension(R.dimen.f158703ms));
        this.f387382f.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387382f.setId(R.id.x38);
        this.f387382f.setVisibility(8);
        this.f387382f.setIncludeFontPadding(false);
        linearLayout2.addView(this.f387382f, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) resources.getDimension(R.dimen.f158724ne);
        layoutParams7.height = (int) resources.getDimension(R.dimen.f158724ne);
        layoutParams7.addRule(15, -1);
        layoutParams7.leftMargin = (int) resources.getDimension(R.dimen.f158703ms);
        RadiusFrameLayout radiusFrameLayout = new RadiusFrameLayout(context, null);
        this.f387383g = radiusFrameLayout;
        radiusFrameLayout.setId(R.id.wfy);
        this.f387383g.d((int) resources.getDimension(R.dimen.f158703ms));
        this.f387380d.addView(this.f387383g, layoutParams7);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams8.width = (int) resources.getDimension(R.dimen.f158724ne);
        layoutParams8.height = (int) resources.getDimension(R.dimen.f158724ne);
        ImageView imageView2 = new ImageView(context, null);
        this.f387384h = imageView2;
        imageView2.setId(R.id.wkc);
        this.f387384h.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f387384h.setVisibility(8);
        this.f387383g.addView(this.f387384h, layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.width = -1;
        layoutParams9.height = (int) (TypedValue.applyDimension(1, 0.5f, displayMetrics) + 0.5f);
        layoutParams9.leftMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams9.rightMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams9.bottomMargin = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        ImageView imageView3 = new ImageView(context, null);
        this.f387385i = imageView3;
        imageView3.setId(R.id.bn5);
        this.f387385i.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_common_border_standard_bg));
        this.f387377a.addView(this.f387385i, layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.width = -1;
        layoutParams10.bottomMargin = (int) resources.getDimension(R.dimen.f158703ms);
        LinearLayout linearLayout3 = new LinearLayout(context, null);
        this.f387386j = linearLayout3;
        linearLayout3.setId(R.id.wom);
        this.f387386j.setOrientation(0);
        this.f387377a.addView(this.f387386j, layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.leftMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        TextView textView4 = new TextView(context, null);
        this.f387387k = textView4;
        textView4.setId(R.id.f165643x35);
        this.f387387k.setText(resources.getString(R.string.f1517918n));
        this.f387387k.setTextSize(0, (int) resources.getDimension(R.dimen.f158706mv));
        this.f387387k.setVisibility(8);
        this.f387387k.setIncludeFontPadding(false);
        this.f387387k.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387386j.addView(this.f387387k, layoutParams11);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams12.weight = 1.0f;
        this.f387386j.addView(new View(context, null), layoutParams12);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        TextView textView5 = new TextView(context, null);
        this.f387388l = textView5;
        textView5.setId(R.id.x36);
        this.f387388l.setTextSize(0, (int) resources.getDimension(R.dimen.f158706mv));
        this.f387388l.setText(resources.getString(R.string.f142370j7));
        this.f387388l.setGravity(17);
        this.f387388l.setVisibility(8);
        this.f387388l.setIncludeFontPadding(false);
        this.f387388l.setCompoundDrawablePadding((int) resources.getDimension(R.dimen.f158728ni));
        this.f387388l.setTextColor(resources.getColor(R.color.qui_common_text_secondary_selector));
        this.f387388l.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, context.getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_01), (Drawable) null);
        this.f387386j.addView(this.f387388l, layoutParams13);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams14.width = -1;
        layoutParams14.leftMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams14.rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        RadiusFrameLayout radiusFrameLayout2 = new RadiusFrameLayout(context, null);
        this.f387389m = radiusFrameLayout2;
        radiusFrameLayout2.setId(R.id.wfv);
        this.f387389m.setMinimumHeight((int) (TypedValue.applyDimension(1, 168.0f, displayMetrics) + 0.5f));
        this.f387389m.d((int) resources.getDimension(R.dimen.f158728ni));
        this.f387377a.addView(this.f387389m, layoutParams14);
        return this.f387377a;
    }

    public View u() {
        return this.f387390n;
    }
}
