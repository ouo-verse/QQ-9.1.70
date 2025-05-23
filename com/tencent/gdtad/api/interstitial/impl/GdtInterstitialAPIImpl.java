package com.tencent.gdtad.api.interstitial.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.gdtad.api.interstitial.GdtInterstitialAd;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAd;
import com.tencent.gdtad.api.interstitial.c;
import com.tencent.gdtad.api.interstitial.e;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get;
import wm0.a;

/* loaded from: classes6.dex */
public final class GdtInterstitialAPIImpl implements IGdtInterstitialAPI {
    private static final String TAG = "GdtInterstitialAPIImpl";

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI
    @NonNull
    public IGdtInterstitialAd build(Context context, GdtInterstitialParams gdtInterstitialParams) {
        if (a.f445800a.b(gdtInterstitialParams.isRenderTypeKuikly)) {
            QLog.d(TAG, 1, "render type kuikly");
            return new c(gdtInterstitialParams);
        }
        QLog.d(TAG, 1, "render type native");
        return new GdtInterstitialAd(context, gdtInterstitialParams);
    }

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI
    public void closeAd(final qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        if (adInfo == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.impl.GdtInterstitialAPIImpl.1
            @Override // java.lang.Runnable
            public void run() {
                GdtInterstitialFragment c16 = e.d().c(adInfo.report_info.trace_info.traceid.get());
                if (c16 == null) {
                    return;
                }
                c16.sh(4, 13, Integer.MIN_VALUE, Integer.MIN_VALUE);
            }
        });
    }

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI
    public void init(Context context) {
        e.d().e();
    }
}
