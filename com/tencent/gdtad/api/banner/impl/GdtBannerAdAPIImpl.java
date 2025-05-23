package com.tencent.gdtad.api.banner.impl;

import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.gdtad.api.banner.GdtBannerAdKuikly;
import com.tencent.gdtad.api.banner.GdtBannerParams;
import com.tencent.gdtad.api.banner.IGdtBannerAd;
import com.tencent.gdtad.api.banner.IGdtBannerAdAPI;
import com.tencent.qphone.base.util.QLog;
import wm0.a;

/* loaded from: classes6.dex */
public class GdtBannerAdAPIImpl implements IGdtBannerAdAPI {
    private static final String TAG = "GdtBannerAdAPIImpl";

    @Override // com.tencent.gdtad.api.banner.IGdtBannerAdAPI
    public IGdtBannerAd buildBannerAd(GdtBannerParams gdtBannerParams) {
        if (a.f445800a.a(gdtBannerParams.isRenderTypeKuikly)) {
            QLog.d(TAG, 1, "render type kuikly");
            return new GdtBannerAdKuikly(gdtBannerParams);
        }
        QLog.d(TAG, 1, "render type native");
        return new GdtBannerAd(gdtBannerParams);
    }
}
