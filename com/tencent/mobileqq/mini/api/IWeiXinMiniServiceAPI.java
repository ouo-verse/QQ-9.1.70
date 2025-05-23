package com.tencent.mobileqq.mini.api;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000bH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/mini/api/IWeiXinMiniServiceAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkSession", "", "appId", "", "callback", "Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;", "getAuthCode", "getUserInfo", "hasGrantPermission", "", "lang", "openConnectAuthorize", "data", "Lorg/json/JSONObject;", "triggerPullDownAnim", FileReaderHelper.OPEN_FILE_FROM_FORCE, "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IWeiXinMiniServiceAPI extends QRouteApi {
    void checkSession(@NotNull String appId, @NotNull MiniAppCmdInterface callback);

    void getAuthCode(@NotNull String appId, @NotNull MiniAppCmdInterface callback);

    void getUserInfo(@NotNull String appId, boolean hasGrantPermission, @NotNull String lang, @NotNull MiniAppCmdInterface callback);

    void openConnectAuthorize(@NotNull String appId, @NotNull JSONObject data, @NotNull MiniAppCmdInterface callback);

    void triggerPullDownAnim(@NotNull String appId, boolean force);
}
