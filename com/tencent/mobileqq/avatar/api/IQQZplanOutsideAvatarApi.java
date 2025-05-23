package com.tencent.mobileqq.avatar.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/IQQZplanOutsideAvatarApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkOutboundHeadSceneEnable", "", WadlProxyConsts.SCENE_ID, "", "enableSetBgDrawableDimens", "isManualCancelDecodeRequest", "isOutboundHeadFeatureOn", "isToggleBugfix106568443Enable", "updateOutboundHeadFeatureOn", "", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IQQZplanOutsideAvatarApi extends QRouteApi {
    boolean checkOutboundHeadSceneEnable(int sceneId);

    boolean enableSetBgDrawableDimens();

    boolean isManualCancelDecodeRequest();

    boolean isOutboundHeadFeatureOn();

    boolean isToggleBugfix106568443Enable();

    void updateOutboundHeadFeatureOn();
}
