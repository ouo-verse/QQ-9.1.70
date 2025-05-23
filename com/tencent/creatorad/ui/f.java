package com.tencent.creatorad.ui;

import com.tencent.creatorad.pb.CreatorReader$ShareAD;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static void a(CreatorReader$ShareAD creatorReader$ShareAD, int i3) {
        if (!com.tencent.creatorad.utils.c.f(creatorReader$ShareAD, i3)) {
            return;
        }
        new GdtThirdProcessorProxy().c2sReportAsync(1, 0, creatorReader$ShareAD.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(i3));
        if (creatorReader$ShareAD.action_report_infos.size() > i3) {
            com.tencent.creatorad.utils.b.c(creatorReader$ShareAD.action_report_infos.get(i3).click_url.get());
        }
    }

    public static void b(CreatorReader$ShareAD creatorReader$ShareAD, int i3) {
        if (!com.tencent.creatorad.utils.c.f(creatorReader$ShareAD, i3)) {
            return;
        }
        new GdtThirdProcessorProxy().c2sReportAsync(0, 0, creatorReader$ShareAD.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(i3));
        if (creatorReader$ShareAD.action_report_infos.size() > i3) {
            com.tencent.creatorad.utils.b.c(creatorReader$ShareAD.action_report_infos.get(i3).exposure_url.get());
        }
    }
}
