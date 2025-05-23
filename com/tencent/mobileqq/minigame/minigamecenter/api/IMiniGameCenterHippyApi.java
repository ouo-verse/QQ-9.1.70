package com.tencent.mobileqq.minigame.minigamecenter.api;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameCenterHippyApi extends QRouteApi {
    boolean canPreloadHippy();

    HippyAPIProvider createHippyProvider();

    Class<? extends QPublicBaseFragment> getMiniGameCenterHippyClass();

    boolean hasNewMessage();

    boolean isMiniGameCenterModule(String str);

    boolean isUseHippy();

    void reportMiniAppOpen(String str, MiniAppCmdInterface miniAppCmdInterface);

    void setAppInfoBuffer(String str);

    void setAppInfoTraceInfo(String str);
}
