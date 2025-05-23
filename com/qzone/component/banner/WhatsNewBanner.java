package com.qzone.component.banner;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import com.qzone.common.activities.base.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QZoneConfigHelper;
import yo.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WhatsNewBanner extends BasePushBanner {
    private String G;
    private String H;
    private BusinessADBannerData I;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (WhatsNewBanner.this.I != null) {
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(WhatsNewBanner.this.I.strTraceInfo, "");
            }
            Activity topActivity = BaseActivity.getTopActivity();
            if (topActivity != null) {
                g gVar = new g(WhatsNewBanner.this.H);
                gVar.f450709b = WhatsNewBanner.this.G;
                yo.d.b(topActivity, gVar);
            }
            WhatsNewBanner.this.g();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public WhatsNewBanner(Context context) {
        super(context);
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 1;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 11;
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        setOnClickListener(new a());
        w(QZoneConfigHelper.S());
        setVisibility(8);
        this.f46297e = true;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        if (this.f46297e) {
            setVisibility(z16 ? 0 : 8);
            if (z16) {
                u();
                this.f46298f = false;
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.I.strTraceInfo, "");
            }
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46297e && getVisibility() == 0;
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        BusinessADBannerData businessADBannerData;
        if (!this.f46297e || aVar == null || (businessADBannerData = aVar.f47123g) == null) {
            return;
        }
        this.G = businessADBannerData.strJmpUrl;
        this.H = businessADBannerData.schemeUrl;
        this.I = businessADBannerData;
        if (TextUtils.isEmpty(businessADBannerData.description)) {
            return;
        }
        this.f46315m.setText(aVar.f47123g.description);
        this.f46298f = true;
        c();
    }

    @Override // com.qzone.component.banner.BasePushBanner
    protected void x() {
        g();
    }

    public WhatsNewBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
