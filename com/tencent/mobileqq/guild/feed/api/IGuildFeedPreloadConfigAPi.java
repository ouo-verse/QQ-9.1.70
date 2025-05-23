package com.tencent.mobileqq.guild.feed.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0003H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedPreloadConfigAPi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "enableFeedDetailPreload", "", "enableWebBundlePreload", "getFeedDetailBatchPreloadUrl", "", "getFeedDetailSinglePreloadUrl", "getFeedPublishMaxLimit", "", "getWebBundlePreloadUrl", "parseConfig", "", "jsonObj", "Lorg/json/JSONObject;", "setWebBundlePreloadEnable", "enable", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IGuildFeedPreloadConfigAPi extends QRouteApi {
    boolean enableFeedDetailPreload();

    boolean enableWebBundlePreload();

    @NotNull
    String getFeedDetailBatchPreloadUrl();

    @NotNull
    String getFeedDetailSinglePreloadUrl();

    int getFeedPublishMaxLimit();

    @NotNull
    String getWebBundlePreloadUrl();

    void parseConfig(@NotNull JSONObject jsonObj);

    void setWebBundlePreloadEnable(boolean enable);
}
