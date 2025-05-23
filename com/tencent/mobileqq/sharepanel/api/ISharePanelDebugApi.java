package com.tencent.mobileqq.sharepanel.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/api/ISharePanelDebugApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAllSceneIds", "", "", "", "isMainSwitchOn", "", "isSceneSwitchOn", WadlProxyConsts.SCENE_ID, "resetDebugSwitch", "", "setDebugMainSwitch", "switchOn", "setDebugSceneSwitch", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISharePanelDebugApi extends QRouteApi {
    @NotNull
    Map<String, List<String>> getAllSceneIds();

    boolean isMainSwitchOn();

    boolean isSceneSwitchOn(@NotNull String sceneId);

    void resetDebugSwitch();

    void setDebugMainSwitch(boolean switchOn);

    void setDebugSceneSwitch(@NotNull String sceneId, boolean switchOn);
}
