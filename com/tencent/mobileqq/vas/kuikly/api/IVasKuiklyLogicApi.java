package com.tencent.mobileqq.vas.kuikly.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import s13.KuikLyConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/api/IVasKuiklyLogicApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ls13/a;", DownloadInfo.spKey_Config, "", "openLucky", "destroy", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasKuiklyLogicApi extends QRouteApi {
    void destroy();

    void openLucky(@NotNull KuikLyConfig config);
}
