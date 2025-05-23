package com.tencent.gdtad.adapter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.mini.AdQQMINIProgram;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes6.dex */
public class p implements AdQQMINIProgramAdapter {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AdQQMINIProgram.Params params, GdtAd gdtAd, boolean z16, Bundle bundle) {
        GdtLog.i("GdtQQMINIProgramAdapter", String.format("onLaunchResult %b", Boolean.valueOf(z16)));
        AdAnalysisHelperForUtil.reportForLaunchQQMINIProgramEND(params.context.get(), gdtAd, z16);
    }

    @Override // com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter
    @NonNull
    public AdError show(@Nullable final AdQQMINIProgram.Params params) {
        if (params != null && params.isValid()) {
            Ad ad5 = params.f61321ad;
            if (ad5 instanceof GdtAd) {
                final GdtAd gdtAd = (GdtAd) GdtAd.class.cast(ad5);
                GdtLog.i("GdtQQMINIProgramAdapter", String.format("show %s", gdtAd.getUrlForLandingPage()));
                AdAnalysisHelperForUtil.reportForLaunchQQMINIProgramStart(params.context.get(), gdtAd);
                EntryModel entryModel = new EntryModel(-1, 0L, "", false);
                entryModel.mArguments = params.extrasForIntent;
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(params.context.get(), gdtAd.getUrlForLandingPage(), 2054, entryModel, new MiniAppLaunchListener() { // from class: com.tencent.gdtad.adapter.o
                    @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
                    public final void onLaunchResult(boolean z16, Bundle bundle) {
                        p.b(AdQQMINIProgram.Params.this, gdtAd, z16, bundle);
                    }
                });
                return new AdError(0);
            }
        }
        GdtLog.e("GdtQQMINIProgramAdapter", "show error");
        return new AdError(4);
    }
}
