package com.tencent.mobileqq.zplan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0002H&J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanAIOWhiteListApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "requestAIOWhiteList", "", "hasAvatarFeature", "setAvatarFeature", "", "friendUin", "currentUserNeedShowDialog", "reportExposure", "Lcom/tencent/mobileqq/zplan/api/b;", "listener", "registerAIOWhiteListListener", "unRegisterAIOWhiteListListener", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanAIOWhiteListApi extends QRouteApi {
    boolean currentUserNeedShowDialog(long friendUin);

    boolean hasAvatarFeature();

    void registerAIOWhiteListListener(@NotNull b listener);

    void reportExposure();

    void requestAIOWhiteList();

    void setAvatarFeature();

    void unRegisterAIOWhiteListListener(@NotNull b listener);
}
