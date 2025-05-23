package com.tencent.hippykotlin.demo.pages.foundation.density;

import com.tencent.kuikly.core.pager.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQHostCustomDensity {
    public Float hostDensity;
    public Boolean useHostDisplayMetrics;

    public final void init(g gVar) {
        this.useHostDisplayMetrics = Boolean.valueOf(gVar.n().a(KuiklyLaunchParams.PARAM_USE_HOST_DISPLAY_METRICS));
        double i3 = gVar.n().i("qqScaleDensity", 0.0d);
        if (i3 == 0.0d) {
            return;
        }
        this.hostDensity = Float.valueOf((float) i3);
    }
}
