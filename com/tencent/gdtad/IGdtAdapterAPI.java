package com.tencent.gdtad;

import com.tencent.ad.tangram.config.AdConfigManager;
import com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2;
import com.tencent.ad.tangram.interpage.AdInterPageAdapter;
import com.tencent.ad.tangram.statistics.AdReporterForOuterJumpAdapter;
import com.tencent.ad.tangram.statistics.metric.IAdMetricServiceAdapter;
import com.tencent.ad.tangram.util.AdAppReceiverWrapper;
import com.tencent.ad.tangram.views.floatwindow.AdFloatWindowAdapter;
import com.tencent.ad.tangram.wechat.AdWXCustomerServiceAdapter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtAdapterAPI extends QRouteApi {
    AdInterPageAdapter createAdInterPageAdapter();

    AdAppReceiverWrapper.Adapter createAppReceiverWrapperAdapter();

    AdConfigManager.Adapter createConfigManagerAdapter();

    AdFloatWindowAdapter createFloatWindowAdapter();

    IAdMetricServiceAdapter createMetricServiceAdapter();

    AdReporterForOuterJumpAdapter createReporterForOuterJumpAdapter();

    AdWXCustomerServiceAdapter createWXCustomerServiceScreenAdapter();

    AdDownloaderAdapterV2 getDownloadAdapter();
}
