package com.qzone.common.activities.titlebuilder;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.ExtendButton;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends QzoneBaseTitle implements View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    protected ExtendButton f45566a0;

    /* renamed from: b0, reason: collision with root package name */
    protected ExtendButton f45567b0;

    /* renamed from: c0, reason: collision with root package name */
    protected View f45568c0;

    /* renamed from: d0, reason: collision with root package name */
    protected View f45569d0;

    /* renamed from: e0, reason: collision with root package name */
    protected View f45570e0;

    /* renamed from: f0, reason: collision with root package name */
    protected String f45571f0;

    /* renamed from: g0, reason: collision with root package name */
    protected String f45572g0;

    /* renamed from: h0, reason: collision with root package name */
    protected LinearLayout f45573h0;

    /* renamed from: i0, reason: collision with root package name */
    protected View f45574i0;

    /* renamed from: j0, reason: collision with root package name */
    TabHost.OnTabChangeListener f45575j0;

    /* renamed from: k0, reason: collision with root package name */
    View f45576k0;

    public b(f fVar) {
        super(fVar);
        this.f45573h0 = null;
        this.f45576k0 = null;
    }

    public void E(String str) {
        this.f45571f0 = str;
        this.f45566a0.setText(str);
        this.f45566a0.setOnClickListener(this);
        this.f45566a0.setTextSize(1, 17.0f);
    }

    public void F(String str) {
        this.f45572g0 = str;
        this.f45567b0.setText(str);
        this.f45567b0.setOnClickListener(this);
        this.f45567b0.setTextSize(1, 17.0f);
    }

    protected View G() {
        ExtendButton extendButton = (ExtendButton) this.f45558h.findViewById(R.id.afu);
        this.f45566a0 = extendButton;
        return extendButton;
    }

    protected View H() {
        ExtendButton extendButton = (ExtendButton) this.f45558h.findViewById(R.id.afv);
        this.f45567b0 = extendButton;
        return extendButton;
    }

    public void J(boolean z16) {
        ExtendButton extendButton = this.f45566a0;
        if (extendButton != null) {
            extendButton.setChecked(z16);
        }
    }

    public void K(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f45575j0 = onTabChangeListener;
    }

    @Override // com.qzone.common.activities.titlebuilder.QzoneBaseTitle, com.qzone.common.activities.titlebuilder.a
    public void K3(Intent intent) {
        super.K3(intent);
        G();
        H();
        this.f45569d0 = this.f45558h.findViewById(R.id.kmo);
        this.f45570e0 = this.f45558h.findViewById(R.id.kmx);
        if (com.tencent.mobileqq.simpleui.b.c() && SimpleUIUtil.getSimpleUiBgColor() != -1) {
            this.f45569d0.setBackgroundColor(Color.parseColor("#80FFFFFF"));
            this.f45570e0.setBackgroundColor(Color.parseColor("#80FFFFFF"));
        }
        View findViewById = this.f45558h.findViewById(R.id.jp9);
        this.f45574i0 = findViewById;
        findViewById.setBackgroundColor(getResources().getColor(R.color.qzone_skin_divider_line_top));
        this.f45568c0 = this.f45558h.findViewById(R.id.iam);
        this.f45573h0 = (LinearLayout) d(R.id.asq);
    }

    public void L(boolean z16) {
        ExtendButton extendButton = this.f45567b0;
        if (extendButton != null) {
            extendButton.setChecked(z16);
        }
    }

    @Override // com.qzone.common.activities.titlebuilder.QzoneBaseTitle
    protected int h() {
        return R.layout.bjq;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f45566a0) {
            if (view != this.f45576k0) {
                TabHost.OnTabChangeListener onTabChangeListener = this.f45575j0;
                if (onTabChangeListener != null) {
                    onTabChangeListener.onTabChanged(this.f45571f0);
                }
                this.f45576k0 = view;
            }
        } else if (view == this.f45567b0 && view != this.f45576k0) {
            TabHost.OnTabChangeListener onTabChangeListener2 = this.f45575j0;
            if (onTabChangeListener2 != null) {
                onTabChangeListener2.onTabChanged(this.f45572g0);
            }
            this.f45576k0 = view;
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
