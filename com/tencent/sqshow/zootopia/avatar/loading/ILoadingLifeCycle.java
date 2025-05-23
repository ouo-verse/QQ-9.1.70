package com.tencent.sqshow.zootopia.avatar.loading;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.zplan.world.model.FirstFrameResult;
import kotlin.Metadata;
import yh3.ZPlanHotPatchVersionInfo;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0013\u001a\u00020\u0007H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/ILoadingLifeCycle;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "scene", "pageId", "rootSourceId", "sceneHash", "", "onLoadingStart", "", "sceneChange", "onRealEnterAvatar", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "Lyh3/e;", "versionInfo", "receiveHotPatchInfo", "clearLoadingStartInfo", "markFilamentHotStart", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes34.dex */
public interface ILoadingLifeCycle extends QRouteApi {
    void clearLoadingStartInfo(String sceneHash);

    void markFilamentHotStart();

    void onFirstFrame(FirstFrameResult result);

    void onLoadingStart(String scene, String pageId, String rootSourceId, String sceneHash);

    void onRealEnterAvatar(boolean sceneChange);

    void receiveHotPatchInfo(ZPlanHotPatchVersionInfo versionInfo);
}
