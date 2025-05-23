package com.tencent.mobileqq.profilecard.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/profilecard/api/IZanRankingApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getZanRankingServerInstance", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getZanRankingServerName", "", "profilecard_feature_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IZanRankingApi extends QRouteApi {
    @NotNull
    QIPCModule getZanRankingServerInstance();

    @NotNull
    String getZanRankingServerName();
}
