package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.holder.template.BubbleLayoutCompatPress;
import com.tencent.qqnt.aio.holder.template.TemplateLayout;
import ty4.a;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioSenderBubbleTemplateBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public TemplateLayout f387140a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f387141b;

    /* renamed from: c, reason: collision with root package name */
    public FrameLayout f387142c;

    /* renamed from: d, reason: collision with root package name */
    public ViewStub f387143d;

    /* renamed from: e, reason: collision with root package name */
    public FrameLayout f387144e;

    /* renamed from: f, reason: collision with root package name */
    public FrameLayout f387145f;

    /* renamed from: g, reason: collision with root package name */
    public BubbleLayoutCompatPress f387146g;

    /* renamed from: h, reason: collision with root package name */
    public ViewStub f387147h;

    /* renamed from: i, reason: collision with root package name */
    public FrameLayout f387148i;

    /* renamed from: j, reason: collision with root package name */
    public FrameLayout f387149j;

    /* renamed from: k, reason: collision with root package name */
    public ViewStub f387150k;

    /* renamed from: l, reason: collision with root package name */
    public ViewStub f387151l;

    /* renamed from: m, reason: collision with root package name */
    public ViewStub f387152m;

    /* renamed from: n, reason: collision with root package name */
    public FrameLayout f387153n;

    /* renamed from: o, reason: collision with root package name */
    public View f387154o;

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
        TemplateLayout templateLayout = new TemplateLayout(context, null);
        this.f387140a = templateLayout;
        this.f387154o = templateLayout;
        templateLayout.setId(R.id.root);
        this.f387140a.setClipChildren(false);
        this.f387140a.setClipToPadding(false);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.validate();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387141b = frameLayout;
        frameLayout.setId(R.id.zgu);
        this.f387141b.setVisibility(8);
        this.f387140a.addView(this.f387141b, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.topToBottom = R.id.zgu;
        layoutParams2.startToStart = 0;
        layoutParams2.endToEnd = 0;
        layoutParams2.validate();
        FrameLayout frameLayout2 = new FrameLayout(context, null);
        this.f387142c = frameLayout2;
        frameLayout2.setId(R.id.f166336f24);
        this.f387140a.addView(this.f387142c, layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.topToBottom = R.id.f166336f24;
        layoutParams3.startToStart = 0;
        layoutParams3.validate();
        ViewStub viewStub = new ViewStub(context, (AttributeSet) null);
        this.f387143d = viewStub;
        viewStub.setLayoutResource(R.layout.dvn);
        this.f387143d.setLayoutInflater(new a(this.f387143d.getContext(), new AioMsgComponentContainerLayoutBinding()));
        this.f387143d.setId(R.id.zg7);
        this.f387143d.setInflatedId(R.id.zg7);
        this.f387140a.addView(this.f387143d, layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams4.topToBottom = R.id.f166336f24;
        layoutParams4.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = (int) resources.getDimension(R.dimen.bzt);
        ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = (int) resources.getDimension(R.dimen.bzr);
        layoutParams4.validate();
        FrameLayout frameLayout3 = new FrameLayout(context, null);
        this.f387144e = frameLayout3;
        frameLayout3.setId(R.id.zfr);
        this.f387140a.addView(this.f387144e, layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams5.topToBottom = R.id.f166336f24;
        layoutParams5.horizontalBias = 1.0f;
        layoutParams5.constrainedWidth = true;
        layoutParams5.endToStart = R.id.zfr;
        layoutParams5.startToEnd = R.id.zg7;
        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = (int) resources.getDimension(R.dimen.bzt);
        layoutParams5.setMarginStart((int) resources.getDimension(R.dimen.f158234c00));
        layoutParams5.setMarginEnd((int) resources.getDimension(R.dimen.bzy));
        layoutParams5.validate();
        FrameLayout frameLayout4 = new FrameLayout(context, null);
        this.f387145f = frameLayout4;
        frameLayout4.setId(R.id.zqy);
        this.f387145f.setVisibility(8);
        this.f387140a.addView(this.f387145f, layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams6.topToBottom = R.id.zqy;
        layoutParams6.horizontalBias = 1.0f;
        layoutParams6.constrainedWidth = true;
        layoutParams6.startToEnd = R.id.zg7;
        layoutParams6.endToStart = R.id.zfr;
        layoutParams6.validate();
        BubbleLayoutCompatPress bubbleLayoutCompatPress = new BubbleLayoutCompatPress(context, null);
        this.f387146g = bubbleLayoutCompatPress;
        bubbleLayoutCompatPress.setId(R.id.f164907u83);
        this.f387146g.setOrientation(1);
        this.f387140a.addView(this.f387146g, layoutParams6);
        ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams7).width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams7.bottomToBottom = R.id.f164907u83;
        ((ViewGroup.MarginLayoutParams) layoutParams7).height = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams7.topToTop = R.id.f164907u83;
        layoutParams7.startToStart = R.id.f164907u83;
        layoutParams7.endToEnd = R.id.f164907u83;
        layoutParams7.validate();
        ViewStub viewStub2 = new ViewStub(context, (AttributeSet) null);
        this.f387147h = viewStub2;
        viewStub2.setLayoutResource(R.layout.dvp);
        this.f387147h.setLayoutInflater(new a(this.f387147h.getContext(), new AioMsgContentMaskLayoutBinding()));
        this.f387147h.setId(R.id.f164908u84);
        this.f387140a.addView(this.f387147h, layoutParams7);
        ConstraintLayout.LayoutParams layoutParams8 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams8.bottomToBottom = R.id.f164907u83;
        layoutParams8.endToStart = R.id.f164907u83;
        ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = (int) resources.getDimension(R.dimen.bzx);
        layoutParams8.setMarginEnd((int) resources.getDimension(R.dimen.bzw));
        layoutParams8.validate();
        FrameLayout frameLayout5 = new FrameLayout(context, null);
        this.f387148i = frameLayout5;
        frameLayout5.setId(R.id.f166334f21);
        this.f387140a.addView(this.f387148i, layoutParams8);
        ConstraintLayout.LayoutParams layoutParams9 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams9.bottomToBottom = R.id.f164907u83;
        layoutParams9.endToStart = R.id.f164907u83;
        ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin = (int) resources.getDimension(R.dimen.bzq);
        layoutParams9.setMarginEnd((int) resources.getDimension(R.dimen.bzp));
        layoutParams9.validate();
        FrameLayout frameLayout6 = new FrameLayout(context, null);
        this.f387149j = frameLayout6;
        frameLayout6.setId(R.id.zfz);
        this.f387140a.addView(this.f387149j, layoutParams9);
        ConstraintLayout.LayoutParams layoutParams10 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams10).height = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams10.bottomToBottom = R.id.f164907u83;
        layoutParams10.topToTop = R.id.zfr;
        layoutParams10.startToEnd = 0;
        layoutParams10.validate();
        ViewStub viewStub3 = new ViewStub(context, (AttributeSet) null);
        this.f387150k = viewStub3;
        viewStub3.setLayoutResource(R.layout.dvn);
        this.f387150k.setLayoutInflater(new a(this.f387150k.getContext(), new AioMsgComponentContainerLayoutBinding()));
        this.f387150k.setId(R.id.yhi);
        this.f387150k.setInflatedId(R.id.yhi);
        this.f387140a.addView(this.f387150k, layoutParams10);
        ConstraintLayout.LayoutParams layoutParams11 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams11).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams11).height = -1;
        layoutParams11.topToTop = 0;
        layoutParams11.validate();
        ViewStub viewStub4 = new ViewStub(context, (AttributeSet) null);
        this.f387151l = viewStub4;
        viewStub4.setLayoutResource(R.layout.dvn);
        this.f387151l.setLayoutInflater(new a(this.f387151l.getContext(), new AioMsgComponentContainerLayoutBinding()));
        this.f387151l.setId(R.id.zfq);
        this.f387151l.setInflatedId(R.id.zfq);
        this.f387140a.addView(this.f387151l, layoutParams11);
        ConstraintLayout.LayoutParams layoutParams12 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams12).height = -1;
        layoutParams12.topToBottom = R.id.f166336f24;
        layoutParams12.endToEnd = 0;
        layoutParams12.validate();
        ViewStub viewStub5 = new ViewStub(context, (AttributeSet) null);
        this.f387152m = viewStub5;
        viewStub5.setLayoutResource(R.layout.dvn);
        this.f387152m.setLayoutInflater(new a(this.f387152m.getContext(), new AioMsgComponentContainerLayoutBinding()));
        this.f387152m.setId(R.id.t1c);
        this.f387152m.setInflatedId(R.id.t1c);
        this.f387140a.addView(this.f387152m, layoutParams12);
        ConstraintLayout.LayoutParams layoutParams13 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams13).width = -1;
        layoutParams13.topToBottom = R.id.f164907u83;
        layoutParams13.validate();
        FrameLayout frameLayout7 = new FrameLayout(context, null);
        this.f387153n = frameLayout7;
        frameLayout7.setId(R.id.zgt);
        this.f387140a.addView(this.f387153n, layoutParams13);
        return this.f387140a;
    }

    public View u() {
        return this.f387154o;
    }
}
