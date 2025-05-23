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
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.view.DiscoveryV2RootView;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import ty4.a;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildDiscoveryV2RecommendFeedItemLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public DiscoveryV2RootView f387272a;

    /* renamed from: b, reason: collision with root package name */
    public RadiusFrameLayout f387273b;

    /* renamed from: c, reason: collision with root package name */
    public ViewStub f387274c;

    /* renamed from: d, reason: collision with root package name */
    public ViewStub f387275d;

    /* renamed from: e, reason: collision with root package name */
    public ViewStub f387276e;

    /* renamed from: f, reason: collision with root package name */
    public ViewStub f387277f;

    /* renamed from: g, reason: collision with root package name */
    public GuildDiscoveryV2RecommendFeedItemTextLayoutIncludeBinding f387278g;

    /* renamed from: h, reason: collision with root package name */
    public ViewStub f387279h;

    /* renamed from: i, reason: collision with root package name */
    public ViewStub f387280i;

    /* renamed from: j, reason: collision with root package name */
    public View f387281j;

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        layoutParams.validate();
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        DiscoveryV2RootView discoveryV2RootView = new DiscoveryV2RootView(context, null);
        this.f387272a = discoveryV2RootView;
        this.f387281j = discoveryV2RootView;
        discoveryV2RootView.setId(R.id.w5r);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f387272a.addView(constraintLayout, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
        layoutParams2.topToTop = 0;
        layoutParams2.validate();
        RadiusFrameLayout radiusFrameLayout = new RadiusFrameLayout(context, null);
        this.f387273b = radiusFrameLayout;
        radiusFrameLayout.setId(R.id.w5o);
        constraintLayout.addView(this.f387273b, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.width = -1;
        layoutParams3.height = -1;
        ViewStub viewStub = new ViewStub(context, (AttributeSet) null);
        this.f387274c = viewStub;
        viewStub.setLayoutResource(R.layout.elu);
        this.f387274c.setLayoutInflater(new a(this.f387274c.getContext(), new GuildDiscoveryV2RecommendPicLayoutBinding()));
        this.f387274c.setId(R.id.w5x);
        this.f387273b.addView(this.f387274c, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.width = -1;
        layoutParams4.height = -1;
        ViewStub viewStub2 = new ViewStub(context, (AttributeSet) null);
        this.f387275d = viewStub2;
        viewStub2.setLayoutResource(R.layout.f168063em0);
        this.f387275d.setLayoutInflater(new a(this.f387275d.getContext(), new GuildDiscoveryV2RecommendVideoLayoutBinding()));
        this.f387275d.setId(R.id.w5w);
        this.f387273b.addView(this.f387275d, layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.width = -1;
        layoutParams5.height = -1;
        ViewStub viewStub3 = new ViewStub(context, (AttributeSet) null);
        this.f387276e = viewStub3;
        viewStub3.setLayoutResource(R.layout.elx);
        this.f387276e.setLayoutInflater(new a(this.f387276e.getContext(), new GuildDiscoveryV2RecommendThirdVideoLayoutBinding()));
        this.f387276e.setId(R.id.w5u);
        this.f387273b.addView(this.f387276e, layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = -1;
        layoutParams6.topToTop = 0;
        layoutParams6.leftToLeft = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin = (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        layoutParams6.validate();
        ViewStub viewStub4 = new ViewStub(context, (AttributeSet) null);
        this.f387277f = viewStub4;
        viewStub4.setLayoutResource(R.layout.elg);
        this.f387277f.setLayoutInflater(new a(this.f387277f.getContext(), new GuildDiscoveryV2FeedApprovalStatusLayoutBinding()));
        this.f387277f.setId(R.id.w5g);
        this.f387277f.setInflatedId(R.id.w5f);
        constraintLayout.addView(this.f387277f, layoutParams6);
        ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams7).width = -1;
        layoutParams7.topToBottom = R.id.w5o;
        layoutParams7.validate();
        GuildDiscoveryV2RecommendFeedItemTextLayoutIncludeBinding guildDiscoveryV2RecommendFeedItemTextLayoutIncludeBinding = new GuildDiscoveryV2RecommendFeedItemTextLayoutIncludeBinding();
        this.f387278g = guildDiscoveryV2RecommendFeedItemTextLayoutIncludeBinding;
        View s16 = guildDiscoveryV2RecommendFeedItemTextLayoutIncludeBinding.s(context, constraintLayout, false);
        s16.setId(R.id.w5s);
        constraintLayout.addView(s16, layoutParams7);
        ConstraintLayout.LayoutParams layoutParams8 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams8).width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams8.topToBottom = R.id.w5s;
        layoutParams8.leftToLeft = 0;
        layoutParams8.rightToRight = 0;
        layoutParams8.validate();
        ViewStub viewStub5 = new ViewStub(context, (AttributeSet) null);
        this.f387279h = viewStub5;
        viewStub5.setLayoutResource(R.layout.elh);
        this.f387279h.setLayoutInflater(new a(this.f387279h.getContext(), new GuildDiscoveryV2FeedBottomLayoutBinding()));
        this.f387279h.setId(R.id.w5k);
        this.f387279h.setInflatedId(R.id.w5j);
        constraintLayout.addView(this.f387279h, layoutParams8);
        ConstraintLayout.LayoutParams layoutParams9 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams9).height = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams9.bottomToBottom = R.id.w5o;
        layoutParams9.leftToLeft = 0;
        int applyDimension = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        layoutParams9.setMargins(applyDimension, applyDimension, applyDimension, applyDimension);
        layoutParams9.validate();
        ViewStub viewStub6 = new ViewStub(context, (AttributeSet) null);
        this.f387280i = viewStub6;
        viewStub6.setLayoutResource(R.layout.eli);
        this.f387280i.setLayoutInflater(new a(this.f387280i.getContext(), new GuildDiscoveryV2FeedLikeLayoutBinding()));
        this.f387280i.setId(R.id.w5n);
        this.f387280i.setInflatedId(R.id.w5m);
        constraintLayout.addView(this.f387280i, layoutParams9);
        return this.f387272a;
    }
}
