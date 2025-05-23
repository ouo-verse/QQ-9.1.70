package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
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
public class AioMsgCenterNoAvatarTemplateBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public TemplateLayout f387046a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f387047b;

    /* renamed from: c, reason: collision with root package name */
    public ViewStub f387048c;

    /* renamed from: d, reason: collision with root package name */
    public BubbleLayoutCompatPress f387049d;

    /* renamed from: e, reason: collision with root package name */
    public View f387050e;

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
        context.getResources().getDisplayMetrics();
        TemplateLayout templateLayout = new TemplateLayout(context, null);
        this.f387046a = templateLayout;
        this.f387050e = templateLayout;
        templateLayout.setId(R.id.root);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.validate();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387047b = frameLayout;
        frameLayout.setId(R.id.f166336f24);
        this.f387046a.addView(this.f387047b, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.topToBottom = R.id.f166336f24;
        layoutParams2.startToStart = 0;
        layoutParams2.horizontalChainStyle = 2;
        layoutParams2.validate();
        ViewStub viewStub = new ViewStub(context, (AttributeSet) null);
        this.f387048c = viewStub;
        viewStub.setLayoutResource(R.layout.dvo);
        this.f387048c.setLayoutInflater(new a(this.f387048c.getContext(), new AioMsgComponentContainerLayout2Binding()));
        this.f387048c.setId(R.id.zg7);
        this.f387048c.setInflatedId(R.id.zg7);
        this.f387046a.addView(this.f387048c, layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.topToBottom = R.id.f166336f24;
        layoutParams3.endToEnd = 0;
        layoutParams3.startToEnd = R.id.zg7;
        layoutParams3.validate();
        BubbleLayoutCompatPress bubbleLayoutCompatPress = new BubbleLayoutCompatPress(context, null);
        this.f387049d = bubbleLayoutCompatPress;
        bubbleLayoutCompatPress.setId(R.id.zfv);
        this.f387049d.setFocusable(true);
        this.f387049d.setClickable(true);
        this.f387049d.setGravity(17);
        this.f387049d.setOrientation(1);
        this.f387046a.addView(this.f387049d, layoutParams3);
        return this.f387046a;
    }

    public View u() {
        return this.f387050e;
    }
}
