package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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
import com.tencent.mobileqq.aio.reserve1.navigation.view.AioNavAnimView;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import ty4.a;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioReserve1LayoutBpBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public ConstraintLayout f387121a;

    /* renamed from: b, reason: collision with root package name */
    public QQBlurViewWrapper f387122b;

    /* renamed from: c, reason: collision with root package name */
    public FrameLayout f387123c;

    /* renamed from: d, reason: collision with root package name */
    public AioNavAnimView f387124d;

    /* renamed from: e, reason: collision with root package name */
    public LinearLayout f387125e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f387126f;

    /* renamed from: g, reason: collision with root package name */
    public LinearLayout f387127g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f387128h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f387129i;

    /* renamed from: j, reason: collision with root package name */
    public LinearLayout f387130j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f387131k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f387132l;

    /* renamed from: m, reason: collision with root package name */
    public ViewStub f387133m;

    /* renamed from: n, reason: collision with root package name */
    public View f387134n;

    /* renamed from: o, reason: collision with root package name */
    public ConstraintLayout f387135o;

    /* renamed from: p, reason: collision with root package name */
    public View f387136p;

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
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f387121a = constraintLayout;
        this.f387136p = constraintLayout;
        constraintLayout.setId(R.id.sjo);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 88.0f, displayMetrics) + 0.5f);
        layoutParams.bottomToBottom = 0;
        layoutParams.validate();
        QQBlurViewWrapper qQBlurViewWrapper = new QQBlurViewWrapper(context, null);
        this.f387122b = qQBlurViewWrapper;
        qQBlurViewWrapper.setId(R.id.f164620t93);
        this.f387122b.setVisibility(8);
        this.f387121a.addView(this.f387122b, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
        layoutParams2.topToTop = 0;
        layoutParams2.startToStart = 0;
        layoutParams2.endToEnd = 0;
        layoutParams2.validate();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387123c = frameLayout;
        frameLayout.setId(R.id.f100035re);
        this.f387121a.addView(this.f387123c, layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.topToBottom = R.id.f100035re;
        layoutParams3.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = (int) resources.getDimension(R.dimen.f158238c02);
        layoutParams3.validate();
        AioNavAnimView aioNavAnimView = new AioNavAnimView(context, null);
        this.f387124d = aioNavAnimView;
        aioNavAnimView.setId(R.id.siz);
        this.f387124d.setVisibility(8);
        this.f387121a.addView(this.f387124d, layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams4.verticalBias = 0.17f;
        layoutParams4.bottomToBottom = 0;
        layoutParams4.topToTop = 0;
        layoutParams4.endToEnd = 0;
        layoutParams4.validate();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387125e = linearLayout;
        linearLayout.setId(R.id.sh9);
        this.f387125e.setOrientation(1);
        this.f387121a.addView(this.f387125e, layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams5.bottomToBottom = R.id.slg;
        layoutParams5.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f);
        layoutParams5.setMarginEnd((int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f));
        layoutParams5.validate();
        TextView textView = new TextView(context, null);
        this.f387126f = textView;
        textView.setTextSize(0, (int) (TypedValue.applyDimension(2, 16.0f, displayMetrics) + 0.5f));
        this.f387126f.setSingleLine(true);
        this.f387126f.setTextColor(resources.getColor(R.color.f158017al3));
        this.f387126f.setId(R.id.f114346t3);
        this.f387126f.setGravity(1);
        this.f387126f.setVisibility(8);
        this.f387126f.setPadding(0, (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f), 0, 0);
        this.f387121a.addView(this.f387126f, layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = (int) (TypedValue.applyDimension(1, 45.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = (int) (TypedValue.applyDimension(1, 45.0f, displayMetrics) + 0.5f);
        layoutParams6.bottomToBottom = R.id.slg;
        layoutParams6.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        layoutParams6.validate();
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387127g = linearLayout2;
        linearLayout2.setId(R.id.f164199mz);
        this.f387127g.setVisibility(8);
        this.f387127g.setOrientation(1);
        d.e(this.f387127g);
        this.f387127g.setBackground(context.getResources().getDrawable(R.drawable.skin_aio_speaker_phone_layout_bg));
        this.f387121a.addView(this.f387127g, layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) (TypedValue.applyDimension(1, 21.0f, displayMetrics) + 0.5f);
        layoutParams7.height = (int) (TypedValue.applyDimension(1, 21.0f, displayMetrics) + 0.5f);
        layoutParams7.gravity = 1;
        layoutParams7.topMargin = (int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387128h = imageView;
        imageView.setId(R.id.f164198my);
        this.f387127g.addView(this.f387128h, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.gravity = 1;
        layoutParams8.topMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        TextView textView2 = new TextView(context, null);
        this.f387129i = textView2;
        textView2.setId(R.id.f164200n0);
        this.f387129i.setTextSize(0, (int) (TypedValue.applyDimension(2, 8.0f, displayMetrics) + 0.5f));
        this.f387129i.setIncludeFontPadding(false);
        this.f387129i.setTextColor(Color.parseColor("#03081a"));
        this.f387127g.addView(this.f387129i, layoutParams8);
        ConstraintLayout.LayoutParams layoutParams9 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams9.bottomToBottom = R.id.slg;
        layoutParams9.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams9).rightMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        layoutParams9.validate();
        LinearLayout linearLayout3 = new LinearLayout(context, null);
        this.f387130j = linearLayout3;
        linearLayout3.setId(R.id.shj);
        this.f387130j.setVisibility(8);
        this.f387130j.setOrientation(1);
        d.e(this.f387130j);
        this.f387130j.setBackground(context.getResources().getDrawable(R.drawable.j6s));
        this.f387121a.addView(this.f387130j, layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.width = (int) resources.getDimension(R.dimen.bzg);
        layoutParams10.gravity = 1;
        TextView textView3 = new TextView(context, null);
        this.f387131k = textView3;
        textView3.setId(R.id.v0r);
        this.f387131k.setText(resources.getString(R.string.yql));
        this.f387131k.setTextSize(0, (int) resources.getDimension(R.dimen.bzf));
        this.f387131k.setSingleLine(false);
        this.f387131k.setTextColor(resources.getColor(R.color.b4s));
        this.f387130j.addView(this.f387131k, layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.width = (int) resources.getDimension(R.dimen.bzg);
        layoutParams11.height = (int) resources.getDimension(R.dimen.bzd);
        layoutParams11.topMargin = (int) resources.getDimension(R.dimen.bze);
        ImageView imageView2 = new ImageView(context, null);
        this.f387132l = imageView2;
        imageView2.setId(R.id.v0q);
        this.f387132l.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f387130j.addView(this.f387132l, layoutParams11);
        ConstraintLayout.LayoutParams layoutParams12 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams12).width = -1;
        layoutParams12.bottomToBottom = R.id.slg;
        layoutParams12.startToStart = 0;
        layoutParams12.endToEnd = 0;
        layoutParams12.validate();
        ViewStub viewStub = new ViewStub(context, (AttributeSet) null);
        this.f387133m = viewStub;
        viewStub.setLayoutResource(R.layout.f169178i42);
        this.f387133m.setLayoutInflater(new a(this.f387133m.getContext(), new ViewstubFramelayoutBinding()));
        this.f387133m.setId(R.id.tid);
        this.f387133m.setInflatedId(R.id.tid);
        this.f387121a.addView(this.f387133m, layoutParams12);
        ConstraintLayout.LayoutParams layoutParams13 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams13).width = (int) (TypedValue.applyDimension(1, 1.0f, displayMetrics) + 0.5f);
        layoutParams13.verticalBias = 1.0f;
        ((ViewGroup.MarginLayoutParams) layoutParams13).height = (int) (TypedValue.applyDimension(1, 1.0f, displayMetrics) + 0.5f);
        layoutParams13.bottomToBottom = 0;
        layoutParams13.topToTop = 0;
        layoutParams13.startToStart = 0;
        layoutParams13.endToEnd = 0;
        layoutParams13.validate();
        View view = new View(context, null);
        this.f387134n = view;
        view.setId(R.id.slg);
        this.f387121a.addView(this.f387134n, layoutParams13);
        ConstraintLayout.LayoutParams layoutParams14 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams14).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams14).height = -1;
        layoutParams14.validate();
        ConstraintLayout constraintLayout2 = new ConstraintLayout(context, null);
        this.f387135o = constraintLayout2;
        constraintLayout2.setId(R.id.shh);
        this.f387135o.setVisibility(8);
        this.f387121a.addView(this.f387135o, layoutParams14);
        return this.f387121a;
    }
}
