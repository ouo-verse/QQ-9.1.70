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
public class AioMsgBubbleTemplateLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public TemplateLayout f387029a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f387030b;

    /* renamed from: c, reason: collision with root package name */
    public FrameLayout f387031c;

    /* renamed from: d, reason: collision with root package name */
    public ViewStub f387032d;

    /* renamed from: e, reason: collision with root package name */
    public FrameLayout f387033e;

    /* renamed from: f, reason: collision with root package name */
    public FrameLayout f387034f;

    /* renamed from: g, reason: collision with root package name */
    public BubbleLayoutCompatPress f387035g;

    /* renamed from: h, reason: collision with root package name */
    public ViewStub f387036h;

    /* renamed from: i, reason: collision with root package name */
    public FrameLayout f387037i;

    /* renamed from: j, reason: collision with root package name */
    public FrameLayout f387038j;

    /* renamed from: k, reason: collision with root package name */
    public ViewStub f387039k;

    /* renamed from: l, reason: collision with root package name */
    public ViewStub f387040l;

    /* renamed from: m, reason: collision with root package name */
    public ViewStub f387041m;

    /* renamed from: n, reason: collision with root package name */
    public ViewStub f387042n;

    /* renamed from: o, reason: collision with root package name */
    public ViewStub f387043o;

    /* renamed from: p, reason: collision with root package name */
    public FrameLayout f387044p;

    /* renamed from: q, reason: collision with root package name */
    public View f387045q;

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
        this.f387029a = templateLayout;
        this.f387045q = templateLayout;
        templateLayout.setId(R.id.root);
        this.f387029a.setClipChildren(false);
        this.f387029a.setClipToPadding(false);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.validate();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387030b = frameLayout;
        frameLayout.setId(R.id.zgu);
        this.f387030b.setVisibility(8);
        this.f387029a.addView(this.f387030b, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.topToBottom = R.id.zgu;
        layoutParams2.startToStart = 0;
        layoutParams2.endToEnd = 0;
        layoutParams2.validate();
        FrameLayout frameLayout2 = new FrameLayout(context, null);
        this.f387031c = frameLayout2;
        frameLayout2.setId(R.id.f166336f24);
        this.f387029a.addView(this.f387031c, layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.topToBottom = R.id.f166336f24;
        layoutParams3.startToStart = 0;
        layoutParams3.validate();
        ViewStub viewStub = new ViewStub(context, (AttributeSet) null);
        this.f387032d = viewStub;
        viewStub.setLayoutResource(R.layout.dvn);
        this.f387032d.setLayoutInflater(new a(this.f387032d.getContext(), new AioMsgComponentContainerLayoutBinding()));
        this.f387032d.setId(R.id.zg7);
        this.f387032d.setInflatedId(R.id.zg7);
        this.f387029a.addView(this.f387032d, layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams4.topToBottom = R.id.f166336f24;
        layoutParams4.startToEnd = R.id.zg7;
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = (int) resources.getDimension(R.dimen.bzr);
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = (int) resources.getDimension(R.dimen.bzt);
        layoutParams4.validate();
        FrameLayout frameLayout3 = new FrameLayout(context, null);
        this.f387033e = frameLayout3;
        frameLayout3.setId(R.id.zfr);
        this.f387033e.setClipChildren(false);
        this.f387033e.setClipToPadding(false);
        this.f387029a.addView(this.f387033e, layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams5.topToBottom = R.id.f166336f24;
        layoutParams5.horizontalBias = 0.0f;
        layoutParams5.constrainedWidth = true;
        layoutParams5.endToEnd = 0;
        layoutParams5.startToEnd = R.id.zfr;
        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = (int) resources.getDimension(R.dimen.bzt);
        layoutParams5.setMarginStart((int) resources.getDimension(R.dimen.bzy));
        layoutParams5.setMarginEnd((int) resources.getDimension(R.dimen.f158234c00));
        layoutParams5.validate();
        FrameLayout frameLayout4 = new FrameLayout(context, null);
        this.f387034f = frameLayout4;
        frameLayout4.setId(R.id.zqy);
        this.f387034f.setVisibility(8);
        this.f387029a.addView(this.f387034f, layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams6.topToBottom = R.id.zqy;
        layoutParams6.horizontalBias = 0.0f;
        layoutParams6.constrainedWidth = true;
        layoutParams6.endToEnd = 0;
        layoutParams6.startToEnd = R.id.zfr;
        layoutParams6.validate();
        BubbleLayoutCompatPress bubbleLayoutCompatPress = new BubbleLayoutCompatPress(context, null);
        this.f387035g = bubbleLayoutCompatPress;
        bubbleLayoutCompatPress.setId(R.id.f164907u83);
        this.f387035g.setOrientation(1);
        this.f387029a.addView(this.f387035g, layoutParams6);
        ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams7).width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams7.bottomToBottom = R.id.f164907u83;
        ((ViewGroup.MarginLayoutParams) layoutParams7).height = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams7.topToTop = R.id.f164907u83;
        layoutParams7.startToStart = R.id.f164907u83;
        layoutParams7.endToEnd = R.id.f164907u83;
        layoutParams7.validate();
        ViewStub viewStub2 = new ViewStub(context, (AttributeSet) null);
        this.f387036h = viewStub2;
        viewStub2.setLayoutResource(R.layout.dvp);
        this.f387036h.setLayoutInflater(new a(this.f387036h.getContext(), new AioMsgContentMaskLayoutBinding()));
        this.f387036h.setId(R.id.f164908u84);
        this.f387029a.addView(this.f387036h, layoutParams7);
        ConstraintLayout.LayoutParams layoutParams8 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams8.bottomToBottom = R.id.f164907u83;
        layoutParams8.startToEnd = R.id.f164907u83;
        ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = (int) resources.getDimension(R.dimen.bzx);
        layoutParams8.setMarginStart((int) resources.getDimension(R.dimen.bzw));
        layoutParams8.validate();
        FrameLayout frameLayout5 = new FrameLayout(context, null);
        this.f387037i = frameLayout5;
        frameLayout5.setId(R.id.f166334f21);
        this.f387029a.addView(this.f387037i, layoutParams8);
        ConstraintLayout.LayoutParams layoutParams9 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams9.bottomToBottom = R.id.f164907u83;
        layoutParams9.startToEnd = R.id.f164907u83;
        ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin = (int) resources.getDimension(R.dimen.bzq);
        layoutParams9.setMarginEnd((int) resources.getDimension(R.dimen.bzp));
        layoutParams9.validate();
        FrameLayout frameLayout6 = new FrameLayout(context, null);
        this.f387038j = frameLayout6;
        frameLayout6.setId(R.id.zfz);
        this.f387029a.addView(this.f387038j, layoutParams9);
        ConstraintLayout.LayoutParams layoutParams10 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams10.bottomToBottom = R.id.f164907u83;
        layoutParams10.startToEnd = R.id.f164907u83;
        ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin = (int) resources.getDimension(R.dimen.bzq);
        layoutParams10.setMarginEnd((int) resources.getDimension(R.dimen.bzp));
        layoutParams10.validate();
        ViewStub viewStub3 = new ViewStub(context, (AttributeSet) null);
        this.f387039k = viewStub3;
        viewStub3.setLayoutResource(R.layout.dvn);
        this.f387039k.setLayoutInflater(new a(this.f387039k.getContext(), new AioMsgComponentContainerLayoutBinding()));
        this.f387039k.setId(R.id.zgk);
        this.f387029a.addView(this.f387039k, layoutParams10);
        ConstraintLayout.LayoutParams layoutParams11 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams11.topToBottom = R.id.f164907u83;
        layoutParams11.horizontalBias = 0.0f;
        layoutParams11.startToStart = R.id.f164907u83;
        layoutParams11.constrainedWidth = true;
        layoutParams11.endToEnd = 0;
        layoutParams11.validate();
        ViewStub viewStub4 = new ViewStub(context, (AttributeSet) null);
        this.f387040l = viewStub4;
        viewStub4.setLayoutResource(R.layout.dvn);
        this.f387040l.setLayoutInflater(new a(this.f387040l.getContext(), new AioMsgComponentContainerLayoutBinding()));
        this.f387040l.setId(R.id.zgh);
        this.f387040l.setInflatedId(R.id.zgh);
        this.f387029a.addView(this.f387040l, layoutParams11);
        ConstraintLayout.LayoutParams layoutParams12 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams12).height = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams12.bottomToBottom = R.id.f164907u83;
        layoutParams12.topToTop = R.id.zfr;
        layoutParams12.startToEnd = 0;
        layoutParams12.validate();
        ViewStub viewStub5 = new ViewStub(context, (AttributeSet) null);
        this.f387041m = viewStub5;
        viewStub5.setLayoutResource(R.layout.dvn);
        this.f387041m.setLayoutInflater(new a(this.f387041m.getContext(), new AioMsgComponentContainerLayoutBinding()));
        this.f387041m.setId(R.id.yhi);
        this.f387041m.setInflatedId(R.id.yhi);
        this.f387029a.addView(this.f387041m, layoutParams12);
        ConstraintLayout.LayoutParams layoutParams13 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams13).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams13).height = -1;
        layoutParams13.topToTop = 0;
        layoutParams13.validate();
        ViewStub viewStub6 = new ViewStub(context, (AttributeSet) null);
        this.f387042n = viewStub6;
        viewStub6.setLayoutResource(R.layout.dvn);
        this.f387042n.setLayoutInflater(new a(this.f387042n.getContext(), new AioMsgComponentContainerLayoutBinding()));
        this.f387042n.setId(R.id.zfq);
        this.f387042n.setInflatedId(R.id.zfq);
        this.f387029a.addView(this.f387042n, layoutParams13);
        ConstraintLayout.LayoutParams layoutParams14 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams14).height = -1;
        layoutParams14.topToBottom = R.id.f166336f24;
        layoutParams14.startToStart = 0;
        layoutParams14.validate();
        ViewStub viewStub7 = new ViewStub(context, (AttributeSet) null);
        this.f387043o = viewStub7;
        viewStub7.setLayoutResource(R.layout.dvn);
        this.f387043o.setLayoutInflater(new a(this.f387043o.getContext(), new AioMsgComponentContainerLayoutBinding()));
        this.f387043o.setId(R.id.t1c);
        this.f387043o.setInflatedId(R.id.t1c);
        this.f387029a.addView(this.f387043o, layoutParams14);
        ConstraintLayout.LayoutParams layoutParams15 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams15.topToBottom = R.id.f164907u83;
        layoutParams15.startToStart = R.id.f164907u83;
        layoutParams15.validate();
        FrameLayout frameLayout7 = new FrameLayout(context, null);
        this.f387044p = frameLayout7;
        frameLayout7.setId(R.id.zgt);
        this.f387029a.addView(this.f387044p, layoutParams15);
        return this.f387029a;
    }

    public View u() {
        return this.f387045q;
    }
}
