package com.tencent.gdtad.adapter;

import android.app.Activity;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.wechat.AdWXCustomerService;
import com.tencent.ad.tangram.wechat.AdWXCustomerServiceAdapter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class w implements AdWXCustomerServiceAdapter {
    private void a(AdWXCustomerService.Params params) {
        Activity activity;
        Ad ad5;
        WeakReference<Activity> weakReference;
        AdReporterForLinkEvent adReporterForLinkEvent = AdReporterForLinkEvent.getInstance();
        if (params != null && (weakReference = params.waekActivity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (params != null) {
            ad5 = params.f61350ad;
        } else {
            ad5 = null;
        }
        adReporterForLinkEvent.reportAsync(activity, 4001065, ad5, null, null);
    }

    @Override // com.tencent.ad.tangram.wechat.AdWXCustomerServiceAdapter
    public AdError show(AdWXCustomerService.Params params) {
        QLog.i("GdtWXCustomerServiceAdapter", 1, "[show] start");
        a(params);
        an0.b bVar = new an0.b(params);
        bVar.l(System.currentTimeMillis());
        int j3 = an0.a.n().j(bVar);
        QLog.i("GdtWXCustomerServiceAdapter", 1, "[show] end");
        return new AdError(j3);
    }
}
