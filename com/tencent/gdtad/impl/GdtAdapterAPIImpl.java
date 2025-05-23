package com.tencent.gdtad.impl;

import com.tencent.ad.tangram.config.AdConfigManager;
import com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2;
import com.tencent.ad.tangram.interpage.AdInterPageAdapter;
import com.tencent.ad.tangram.statistics.AdReporterForOuterJumpAdapter;
import com.tencent.ad.tangram.statistics.metric.IAdMetricServiceAdapter;
import com.tencent.ad.tangram.util.AdAppReceiverWrapper;
import com.tencent.ad.tangram.views.floatwindow.AdFloatWindowAdapter;
import com.tencent.ad.tangram.wechat.AdWXCustomerServiceAdapter;
import com.tencent.gdtad.IGdtAdapterAPI;
import com.tencent.gdtad.adapter.GdtDownloaderAdapterV2;
import com.tencent.gdtad.adapter.GdtFloatWindowAdapter;
import com.tencent.gdtad.adapter.h;
import com.tencent.gdtad.adapter.k;
import com.tencent.gdtad.adapter.q;
import com.tencent.gdtad.adapter.w;

/* loaded from: classes6.dex */
public final class GdtAdapterAPIImpl implements IGdtAdapterAPI {
    @Override // com.tencent.gdtad.IGdtAdapterAPI
    public AdInterPageAdapter createAdInterPageAdapter() {
        return new h();
    }

    @Override // com.tencent.gdtad.IGdtAdapterAPI
    public AdAppReceiverWrapper.Adapter createAppReceiverWrapperAdapter() {
        return new com.tencent.gdtad.adapter.a();
    }

    @Override // com.tencent.gdtad.IGdtAdapterAPI
    public AdConfigManager.Adapter createConfigManagerAdapter() {
        return new wm0.c();
    }

    @Override // com.tencent.gdtad.IGdtAdapterAPI
    public AdFloatWindowAdapter createFloatWindowAdapter() {
        return new GdtFloatWindowAdapter();
    }

    @Override // com.tencent.gdtad.IGdtAdapterAPI
    public IAdMetricServiceAdapter createMetricServiceAdapter() {
        return new k();
    }

    @Override // com.tencent.gdtad.IGdtAdapterAPI
    public AdReporterForOuterJumpAdapter createReporterForOuterJumpAdapter() {
        return new q();
    }

    @Override // com.tencent.gdtad.IGdtAdapterAPI
    public AdWXCustomerServiceAdapter createWXCustomerServiceScreenAdapter() {
        return new w();
    }

    @Override // com.tencent.gdtad.IGdtAdapterAPI
    public AdDownloaderAdapterV2 getDownloadAdapter() {
        return GdtDownloaderAdapterV2.f();
    }
}
