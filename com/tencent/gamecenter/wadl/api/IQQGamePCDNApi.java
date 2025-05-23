package com.tencent.gamecenter.wadl.api;

import com.tencent.gamecenter.wadl.sdk.downloader.pcdn.PCDNInitParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0005H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/gamecenter/wadl/api/IQQGamePCDNApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkAndLoadSoAsync", "", "checkAndLoadSoSync", "", "getPCDNConfig", "Lorg/json/JSONObject;", "getPCDNInitParams", "Lcom/tencent/gamecenter/wadl/sdk/downloader/pcdn/PCDNInitParam;", "getPCDNThreadConfig", "appId", "", "getPcdnBufferDirPath", "getPcdnLogPath", "isPCDNSOReady", "isPCDNSwitchOpen", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGamePCDNApi extends QRouteApi {
    void checkAndLoadSoAsync();

    boolean checkAndLoadSoSync();

    @Nullable
    JSONObject getPCDNConfig();

    @NotNull
    PCDNInitParam getPCDNInitParams();

    @Nullable
    JSONObject getPCDNThreadConfig(@Nullable String appId);

    @NotNull
    String getPcdnBufferDirPath();

    @NotNull
    String getPcdnLogPath();

    boolean isPCDNSOReady();

    boolean isPCDNSwitchOpen();
}
