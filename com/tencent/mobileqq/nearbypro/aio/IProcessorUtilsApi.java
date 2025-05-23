package com.tencent.mobileqq.nearbypro.aio;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/IProcessorUtilsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAppRuntime", "Lmqq/app/AppRuntime;", "getFriendName", "", "uin", "getTempName", "isReceiveFriendNotify", "", "qq_nearby_pro_df_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IProcessorUtilsApi extends QRouteApi {
    @NotNull
    AppRuntime getAppRuntime();

    @NotNull
    String getFriendName(@NotNull String uin);

    @NotNull
    String getTempName(@NotNull String uin);

    boolean isReceiveFriendNotify(@NotNull String uin);
}
