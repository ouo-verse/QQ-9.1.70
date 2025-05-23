package com.qzone.component.banner;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.qzone.common.activities.base.BaseActivity;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.util.QZLog;
import yo.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MedalBanner extends BasePushBanner {
    private String G;
    private String H;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MedalBanner.this.g();
            MedalBanner.this.A();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MedalBanner.this.g();
            com.qzone.component.banner.util.a.a(215);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public MedalBanner(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        g gVar = new g(this.H);
        gVar.f450709b = this.G;
        gVar.f450712e = yo.b.f450701c;
        Activity topActivity = BaseActivity.getTopActivity();
        if (topActivity != null) {
            int b16 = yo.d.b(topActivity, gVar);
            if (b16 == 1) {
                com.qzone.component.banner.util.a.a(213);
                return;
            } else {
                if (b16 == 2) {
                    com.qzone.component.banner.util.a.a(214);
                    return;
                }
                return;
            }
        }
        QZLog.e(QZLog.TO_DEVICE_TAG, "open duli qzone fail");
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 200;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 12;
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.g98);
        this.f46313h.addView(imageView);
        setOnClickListener(new a());
        this.f46315m.setSingleLine(false);
        this.f46315m.setTextSize(0, getResources().getDimension(R.dimen.ap_));
        this.C.setVisibility(0);
        this.C.setImageResource(R.drawable.g19);
        this.C.setOnClickListener(new b());
        w(QZoneConfigHelper.S());
        setVisibility(8);
        this.f46297e = true;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        if (this.f46297e) {
            setVisibility(z16 ? 0 : 8);
            if (z16) {
                com.qzone.component.banner.util.a.a(212);
                u();
                this.f46298f = false;
            }
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46297e && getVisibility() == 0;
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        if (!this.f46297e || aVar == null || TextUtils.isEmpty(aVar.f47119c)) {
            return;
        }
        this.f46315m.setText(aVar.f47119c);
        this.H = aVar.f47128l;
        this.G = aVar.f47129m;
        this.f46298f = true;
        c();
    }

    @Override // com.qzone.component.banner.BasePushBanner
    protected void x() {
        g();
    }

    public MedalBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
